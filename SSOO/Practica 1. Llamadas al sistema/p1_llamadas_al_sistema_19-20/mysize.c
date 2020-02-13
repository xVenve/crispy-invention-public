#include <stdio.h>	/*Header file for system call printf*/
#include <sys/types.h>	/*Header file for system call fstat*/
#include <sys/stat.h>
#include <fcntl.h>	/*Header file for system call fcntl*/
#include <dirent.h> 	/*Header file for system call opendir, closedir,readdir...*/
#include <unistd.h>


int main(int argc, char *argv[])
{

	DIR *descriptor;
	//Usamos el directorio actual
	char buffer[PATH_MAX];
	getcwd(buffer, PATH_MAX); //directorio guardado en buffer
	descriptor = opendir (buffer);

	if (descriptor == NULL){
		printf ("Error al abrir directorio \n");
		return -1;
	}
	//Leemos cada uno de los ficheros a del directorio al que apunta descriptor
	struct dirent *fichero_act;
	while ( (fichero_act = readdir(descriptor) ) != NULL){
		//Usamos la función lseek
		if (fichero_act->d_type == DT_REG){
			int tamano_fichero = lseek(fichero_act,0,SEEK_END);
			if (tamano_fichero == -1){
				printf("Error al leer un fichero\n");
				return -1;
			}
			printf("%s	%d\n",fichero_act->d_name,tamano_fichero);
		}

	}
	//Hemos terminado de leer, cerramos el directorio
	if (closedir(descriptor) == -1){
		printf("Error al cerrar directorio\n");
		return -1;
	}
	return 0;
}
