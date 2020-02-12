#include <stdio.h>		/* Header file for system call printf */
#include <unistd.h>		/* Header file for system call gtcwd */
#include <sys/types.h>		/* Header file for system calls opendir, readdir y closedir */
#include <dirent.h>
#include <string.h>


int main(int argc, char *argv[])
{

	DIR *descriptor;
	//No hemos recibido argumentos, por lo que usamos el directorio actual
	if(argc <2){
		char buffer[PATH_MAX];
		getcwd(buffer, PATH_MAX); //directorio actual guardado en buffer
		descriptor = opendir (buffer);
	}else if (argc == 2){
	//Usamos el argumento como directorio a leer
		descriptor = opendir(argv[1]);

	}else{
		printf("Exceso de argumentos\n");
		return -1;
	}


	if (descriptor == NULL){
		printf ("Error al abrir directorio \n");
		return -1;
	}

	//Leemos cada uno de los ficheros del directorio al que apunta descriptor e imprimimos por pantalla el nombre
	struct dirent *fichero_act;
	while ( (fichero_act = readdir(descriptor) ) != NULL){
		printf("%s\n",fichero_act->d_name);
	}
	//Hemos terminado de leer, cerramos el directorio
	if (closedir(descriptor) == -1){
		printf("Error al cerrar directorio\n");
		return -1;
	}
	return 0;
}
