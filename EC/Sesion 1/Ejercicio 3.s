.text
main:
	li $t0, 1 #El 1
    li $t1, 0 #Veces
    li $t2, 0 #Suma
    li $t4, 99 #TotalVeces
bcl:bgt $t1, $t4, fin #Veces>TotalVeces
    	add $t1, $t1, $t0 #Veces+1
        add $t2, $t2, $t1 #Total+Veces
        b bcl #Vuelta al bucle
fin: move $v0, $t2 
