# -*- coding: utf-8 -*-


listaNumeros=   [1, 2, 3, 4] #Crear array


listaNombres= []
#Añadir valores a un array
listaNombres.append("Joaquin") 
listaNombres.append("Sara")


listaNCompleto = [ [0 for columna in range(0,2)] for fila in range (0,5)]
#Añadir valores a los huecos de la matriz
listaNCompleto[0][0]="Jorge"
listaNCompleto[0][1]="Rodriguez"

listaNCompleto[1][0]="Daniel"
listaNCompleto[1][1]="Serrano"

listaNCompleto[2][0]="Adrian"
listaNCompleto[2][1]="Sanchez"


print(listaNumeros)
print(listaNombres)
print(listaNCompleto)