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
                    execvp(argv_execvp[0], argv_execvp);
                  } else {
                    if (!in_background) {
                      while (wait(&stat) > 0);
                      if (stat < 0) {
                        printf("Error ejecucion hijo\n"); // Cambiar todos los errores por perror
                      }
                    }
                  }

                } else { //CONTROLAR ERRORES
                  int n = command_counter;
                  int fd[2];
                  int pid, status2;

                  int in = dup(0);

                  for (int i = 0; i < n; i++) {
                    /* se crea el siguiente pipe */
                    if (i != n - 1) { // el último no se crea
                      if (pipe(fd) < 0) {
                        perror("Error en pipe\n");
                        exit(0);
                      }
                    }

                    /* se crea el proceso siguiente en la cadena */
                    switch (pid = fork()) {

                    case -1:
                      perror("Error en fork\n");
                      close(fd[0]);
                      close(fd[1]);
                      exit(0);

                    case 0: /* proceso hijo */
                      /* redirige la entrada estándar al pipe anterior*/
                      /* al anterior in */
                      close(0);
                      dup(in);
                      close(in);

                      if (i != n - 1) { // no es último proeso
                        close(1);
                        dup(fd[1]);
                        close(fd[0]);
                        close(fd[1]);
                      }

                      getCompleteCommand(argvv, i);
                      execvp(argv_execvp[0], argv_execvp);
                      break;

                    default: /* proceso padre */

                      close(in); // cierra el anterior
                      if (i != n - 1) {
                        in = dup(fd[0]); // para el siguiente
                        close(fd[0]);
                        close(fd[1]);
                      }
                    }
                  }
									if (!in_background) {
										while (wait(&status2) > 0);
										if (stat < 0) {
											printf("Error ejecucion hijo\n"); // Cambiar todos los errores por perror
										}
									}
                }
        }
        return 0;
}
