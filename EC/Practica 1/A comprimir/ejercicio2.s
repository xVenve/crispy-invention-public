.text
extraerValores: #A-> $a0, M-> $a1, N -> $a2, V -> $a3
    blez $a1, error_extraer 	#Problemas de M o N
    blez $a2, error_extraer
    mul $t7, $a1,$a2 			#Casillas a recorrer
    #Guardar direcciones y pila
    addu $sp, $sp, -12
    sw $s0, ($sp) #Uso para reconocer NaN
    sw $s1, 4($sp) #Iterador de direcciones de memoria en A
    sw $s2, 8($sp) #Valor que compararemos
    move $s1, $a0 #Copiamos la dirección inicial de A en nuestro iterador
	li $t0,0 #Iterador loop
	li $t1,0 #Contador ceros
	li $t2,0 #Contador infinito -
	li $t3,0 #Contador infinito +
	li $t4,0 #Contador NaN
	li $t5,0 #Contador no normalizado
	li $t6,0 #Contador normalizados
loop_extraer: bge $t0, $t7,fin_extraer
	#Carga de valor
	lw $s2,($s1) 
	#Comparacion con 0´s
	cond_ceros: bne $s2,0x00000000,cond_infinito1
		addi $t1,$t1,1
		b final_comp
	#Comparación infinito negativo
	cond_infinito1: bne $s2,0xFF800000, cond_infinito2
		addi $t2,$t2,1
		b final_comp
	#Comparación infinito positivo
	cond_infinito2: bne $s2, 0x7F800000,cond_NaN
		addi $t3,$t3,1
		b final_comp
	#Comparación NaN
	cond_NaN: move $s0, $s2
		sll $s0, $s0 , 1
		srl $s0, $s0 , 24    
	  	bne $s0,0xFF, cond_noNorm
			addi $t4,$t4,1
       		b final_comp
	#Comparación no normalizado
	cond_noNorm: bne $s0, 0x00, norm
	addi $t5,$t5,1
	b final_comp
	#Comparación normalizado
	norm: addi $t6,$t6,1
	#Incrementación de iteradores 
	final_comp: addi $s1, $s1, 4
	addi $t0,$t0, 1
	b loop_extraer


error_extraer: li $v0, -1
	jr $ra
fin_extraer: 
    #Restauración de espacio en pila
    lw $s0, ($sp)
    lw $s1, 4($sp)
    lw $s2, 8($sp)
    addu $sp, $sp, 12
	#Introducción de los contadores en el vector resultado
	sw $t1, ($a3)
	sw $t2, 4($a3)
	sw $t3, 8($a3)
	sw $t4, 12($a3)
	sw $t5, 16($a3)
	sw $t6, 20($a3)
	jr $ra





sumar: #$a0->A, $a1->B, $a2->C, $a3->int M, $sp->int N
	#Copia de N (ubicada en pila) en un registro
	lw $t0, ($sp)
	#Control de error
	blez $a3, error_suma
	blez $t0, error_suma
	li $v0, 0
	mul $t1, $a3, $t0 #Numero de elementos totales
	li $t2, 0 #Indice
	#Copia parametros
	move $t3,$a0
	move $t4,$a1
	move $t5,$a2
	loop_suma: bge $t2,$t1, fin_suma
		l.s $f4, ($t3) #Carga de valor de A
		l.s $f5, ($t4) #Carga de valor de B
		add.s $f6,$f4,$f5 #Suma
		s.s $f6,($t5) #Resultado copiado en C
		#Incremento de iteradores
		addi $t2,$t2,1
		addi $t3,$t3,4
		addi $t4,$t4,4
		addi $t5,$t5,4
 	b loop_suma


error_suma: li $v0, -1
	jr $ra
fin_suma: jr $ra