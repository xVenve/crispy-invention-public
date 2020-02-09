.data
	a: .word 5 
	b: .word 10
.text
main:
	li $t0 1
    lw $t1, a
    lw $t2, b
label1:bgt $t0, $t1, label2
		addi $t2, $t2, 2 
		addi $t0, $t0, 1
		b label1
label2:	sw $t0, a 
    	sw $t2, b


    
    
    
