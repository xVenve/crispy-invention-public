.text
main:
	li $t0, 6 #a=6
    li $t1, 7 #b=7
    li $t2, 3 #c=3
    add $t3, $t0, $t1 #a+b
    mul $t5, $t3, $t3 #(a+b)*(a+b)
    
    li $v0, 1
    move $a0, $t5
    syscall