.data
	v: .space 400
	w: .space 400
  
.text
	addi R1, R0, 400
	addi R2, R1, -8
	addi R3, R0, 0
	addi R5, R0, -1
	
	loop:
	sw R3, v(R3)
	addi R4, R3, 1
	add R4, R4, R5
	sw R4, w(R2)
	addi R3, R3, 8
	addi R2, R2, -8
	bne R3, R1, loop
	syscall 0
