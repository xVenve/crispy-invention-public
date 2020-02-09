.data
	p: .asciiz  "Par"
    i: .asciiz  "Impar"
.text
main:
	li $t1, 2
	li $v0, 5
    syscall #leer el numero
    move $t0, $v0 
    rem $t2, $t0, $t1
    beqz $t2 par #Si modulo 0, vamos a par, es par
    	 li $v0, 4 #Imprimir Impar
         la $a0, i
  		 syscall
         b fin #Salir
par:li $v0, 4	#Imprimir Par
    la $a0, p
	syscall
fin: 
    
    
    
    
