.text
main:
	li $v0, 5
    syscall #leer A
    move $t0, $v0 
    
    li $v0, 5
    syscall	#leer B
    move $t1, $v0
    
    bgt $t0, $t1 ma #Si el A > B vamos a ma
		li $v0, 1 #Mayor el B
		move $a0, $t1
		syscall
        b fin
ma:	li $v0, 1	#Mayor el A
    move $a0, $t0
	syscall
fin:    
 
    
    
    
    
