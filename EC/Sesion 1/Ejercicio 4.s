.data
	m: .asciiz  "Multiplo"
    n: .asciiz  "No multiplo"
.text
main:
	li $v0, 5
    syscall #leer A
    move $t0, $v0 
    
    li $v0, 5
    syscall	#leer B
    move $t1, $v0
    
    bgt $t0, $t1 ma #Si el A > B vamos a ma
    	rem $t2, $t1, $t0 # A<B B%A
        b c0
ma:	rem $t2, $t0, $t1   # A>B A%B
    
c0: beqz $t2 c #Si modulo 0, vamos a c
    	 li $v0, 4 #Imprimir No Multiplo
         la $a0, n	
  		 syscall
         b fin #Salir
c:	li $v0, 4	#Imprimir Multiplo
    la $a0, m
	syscall
fin: 
    
    
    
    
