#include <stdio.h>		/* Header file for printf */
#include <sys/types.h>		/* Header file for system call  open */
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>		/* Header file for system calls read, write y close */

#define BUFFER_SIZE 1024

int main(int argc, char *argv[])
{

	/*If the number of arguments is less than two (argv[0] -> program, argv[|] -> file to be shown) we print the error and return -1*/
	if(argc < 2)
	{
		printf("Not enough arguments\n");
		return -1;
	}

	int descriptor;	//Descriptor del fichero
	char buf[BUFFER_SIZE];	//Declaramos el buffer con el tamaño indicado
	//open  con flag O_RDWR para Read/Write

	return 0;
}

