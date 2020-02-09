.data
	msg: .asciiz "Mi primer programa"
.text
.globl main
main:	
	li $v0, 4
    la $a0, msg
    syscall
    