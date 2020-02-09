.data
	space: .byte '\n'    
    e: .byte ' '
.text
main:
	li $v0, 5
    syscall #leer N
    move $t0, $v0
    li $t1, 0 #Contador linea
    li $t2, 0 #Contador cadena
bl1:bge $t1, $t0 sal #Lineas
    	addi $t1, $t1, 1
        li $t2, 0
bl2:    bge $t2, $t1 lin #Cadenas
        	addi $t2, $t2, 1
            li $v0, 1
    		move $a0, $t2
			syscall #Imprimir numero
            li $v0, 4
    		la $a0, e
			syscall #Espacio entre numeros
            b bl2
	lin: li $v0, 4
    	 la $a0, space
         syscall   #Salto de linea
         b bl1
sal:    