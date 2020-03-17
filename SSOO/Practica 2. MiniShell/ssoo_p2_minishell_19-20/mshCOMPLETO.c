//  MSH main file
// Write your msh source code here

//#include "parser.h"
#include <stddef.h>			/* NULL */
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>

#define MAX_COMMANDS 8


// ficheros por si hay redirección
char filev[3][64];

//to store the execvp second parameter
char *argv_execvp[8];

void siginthandler(int param)
{
	printf("****  Saliendo del MSH **** \n");
	//signal(SIGINT, siginthandler);
        exit(0);
}

/**
 * Get the command with its parameters for execvp
 * Execute this instruction before run an execvp to obtain the complete command
 * @param argvv
 * @param num_command
 * @return
 */
void getCompleteCommand(char*** argvv, int num_command) {
    //reset first
    for(int j = 0; j < 8; j++)
        argv_execvp[j] = NULL;

    int i = 0;
    for ( i = 0; argvv[num_command][i] != NULL; i++)
        argv_execvp[i] = argvv[num_command][i];
}


/**
 * Main sheell  Loop
 */
int main(int argc, char* argv[])
{
    /**** Do not delete this code.****/
    int end = 0;
    int executed_cmd_lines = -1;
    char *cmd_line = NULL;
    char *cmd_lines[10];

    if (!isatty(STDIN_FILENO)) {
        cmd_line = (char*)malloc(100);
        while (scanf(" %[^\n]", cmd_line) != EOF){
            if(strlen(cmd_line) <= 0) return 0;
            cmd_lines[end] = (char*)malloc(strlen(cmd_line)+1);
            strcpy(cmd_lines[end], cmd_line);
            end++;
            fflush (stdin);
            fflush(stdout);
        }
    }

    /*********************************/

    char ***argvv = NULL;
    int num_commands;


	while (1)
	{
		int status = 0;
	        int command_counter = 0;
		int in_background = 0;
		signal(SIGINT, siginthandler);

		// Prompt
		write(STDERR_FILENO, "MSH>>", strlen("MSH>>"));

		// Get command
                //********** DO NOT MODIFY THIS PART. IT DISTINGUISH BETWEEN NORMAL/CORRECTION MODE***************
                executed_cmd_lines++;
                if( end != 0 && executed_cmd_lines < end) {
                    command_counter = read_command_correction(&argvv, filev, &in_background, cmd_lines[executed_cmd_lines]);
                }else if( end != 0 && executed_cmd_lines == end)
                    return 0;
                else
                    command_counter = read_command(&argvv, filev, &in_background); //NORMAL MODE
                //************************************************************************************************


              /************************ STUDENTS CODE ********************************/

                if (command_counter > 0) {
                  if (command_counter > MAX_COMMANDS)
                    printf("Error: Numero máximo de comandos es %d \n", MAX_COMMANDS);
                  else {
                    // Print command
                    print_command(argvv, filev, in_background);
                  }
                }

                for (int i = 0; i < command_counter; i++) {
                  getCompleteCommand(argvv, i);
                  printf("%s\n", argv_execvp[0]);
                }

                // ESCRIBIR AQUI
                // PARTE 1 Y 2: INICIO
                if (command_counter == 1) {
                  int pid = fork();
                  if (pid == -1) {
                    perror("Error en fork: Reescribir");
                    return (-1);
                  }
                  int stat;
                  if (pid == 0) {
										getCompleteCommand(argv_execvp,0);
                    execvp(argv_execvp[0], argv_execvp);
                  } else {

                    if (!in_background) {
                      printf("ESPERO\n");
                      while (wait(&stat)>0);
                      if (stat < 0) {
                        printf("Error ejecucion hijo\n"); // Cambiar todos los errores por perror
                      }
                    }else{
											printf("no espero\n");
										}
                  }

                } else if (command_counter == 2) {
                  int tub[2];
                  int stat2;
                  int pid = 0;
                  pipe(tub);
                  for (int i = 0; i < 2; i++) {
                    pid = fork();
                    if (pid == 0) { // hijo
                      if (i == 0) { // hijo 1
                        printf("0.1-he entrado a este hijo 0\n");
                        close(1);
                        dup(tub[1]);
                        close(tub[1]);
                        close(tub[0]);
												printf("0.2-He creado su conexion a la pipe para entrar datos\n");

                        getCompleteCommand(argvv, i);
												printf("0.3-Ejecutando: %s\n", argv_execvp[0]);
                        execvp(argv_execvp[0], argv_execvp);
												printf("Ha fallado el hijo 0\n");
                      } else if (i == 1) { // hijo 2
                        printf("1.1-he entrado a este hijo 1\n");
                        close(0);
                        dup(tub[0]);
                        close(tub[0]);
                        close(tub[1]);

                        printf("1.2-He creado su conexion a la pipe para que salgan datos\n");

                        getCompleteCommand(argvv, i);
 												printf("1.3-Ejecutando: %s\n", argv_execvp[0]);
                        execvp(argv_execvp[0], argv_execvp);
												printf("Ha fallado el hijo 1\n");
                      }

                    } else { // padre
                      printf("%d.4-Voy a esperar a mi hijo %d\n", i, i);
                      while (pid != wait(&stat2))
                        ;
                      printf("%d.5-He esperado a mi hijo %d\n", i, i);
                    }
                  }
									close(tub[0]);
									close(tub[1]);
                } else if (command_counter == 3) {
                  int tub1[2];
                  int tub2[2];
                  int pid = 0;
                  int stat3 = 0;
                  pid = fork();
                  pipe(tub1);
                  getCompleteCommand(argvv, 0);
                  if (pid == 0) {

                    close(1);
                    dup(tub1[1]);
                    close(tub1[1]);
                    close(tub1[0]);

                    printf("Hijo izq\n");
                    execvp(argv_execvp[0], argv_execvp);
                  } else {
                    printf("Voy a esperar a mi hijo izq\n");
                    while (pid != wait(&stat3))
                      ;
                    printf("He esperado a mi hijo izq\n");
                  }
                  pipe(tub2);
                  getCompleteCommand(argvv, 1);
                  pid = fork();
                  if (pid == 0) {

                    close(0);
                    dup(tub1[0]);
                    close(tub1[0]);
                    close(tub1[1]);

                    printf("Hijo medio\n");
                    execvp(argv_execvp[0], argv_execvp);
                  } else {
                    printf("Voy a esperar a mi hijo medio\n");
                    while (pid != wait(&stat3))
                      ;
                    printf("He esperado a mi hijo medio\n");
                  }
                  getCompleteCommand(argvv, 2);
                  pid = fork();
                  if (pid == 0) {

                    execvp(argv_execvp[0], argv_execvp);
                  } else {
                    printf("Voy a esperar a mi hijo dch\n");
                    while (pid != wait(&stat3))
                      ;
                    printf("He esperado a mi hijo dch\n");
                  }
                }
        }
        return 0;
}
