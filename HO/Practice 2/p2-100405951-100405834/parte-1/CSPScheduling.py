from constraint import *

problem = Problem()

# VARIABLES Y DOMINIOS
problem.addVariable("SAT1", [1, 2, 3, 4])
problem.addVariable("SAT2", [1, 2, 3])
problem.addVariable("SAT31", [4, 6])
problem.addVariable("SAT32", [7, 9, 10])
problem.addVariable("SAT4", [8, 11, 12])
problem.addVariable("SAT5", [1, 7, 12])
problem.addVariable("SAT61", [7, 9])
problem.addVariable("SAT62", [3, 4, 5])

# RESTRICCIONES

# Puesto que los satelites SAT1 y SAT2 comparten trayectorias similares, se requiere que a ambos se les asigne la misma
# antena de transmision

problem.addConstraint(AllEqualConstraint(), ["SAT1", "SAT2"])

# Los satelites SAT2, SAT4 y SAT5 deben tener asignados antenas de transmision diferentes.

problem.addConstraint(AllDifferentConstraint(), ["SAT2", "SAT4", "SAT5"])

# Si SAT5 se comunica con ANT12, SAT4 no se puede comunicar con ANT11


def constraint_SAT5_SAT4(a, b):
    if a == 12 and b == 11:
        return False
    return True


problem.addConstraint(constraint_SAT5_SAT4, ("SAT5", "SAT4"))

# Si en una solucion se asignan las antenas ANT7 y ANT12, se deben asignar ambas a franjas horarias que comiencen antes
# de las 12:00 o a franjas horarias que comiencen despues de las 12:00. No podrıa ocurrir, por ejemplo, que ANT7
# estuviera asignada a la franja 06:00-12:00 de SAT3, y ANT12 a la franja 16:00-00:00 de SAT4.


def constraint_hours(a, b, c, d):
    if a == 7 and c == 12:
        return False
    if c == 7 and b == 12:
        return False
    if d == 7 and b == 12:
        return False
    return True


problem.addConstraint(constraint_hours, ("SAT32", "SAT4", "SAT5", "SAT61"))

# SOLUCIONES

solutions = problem.getSolutions()

print(" #{0} solutions have been found: ".format(len(solutions)))
for isolution in solutions:
    #print("SAT1: {0}\t SAT2: {1}\t SAT3: {2}\t {3}\t SAT4: {4}\t SAT5: {5}\t SAT6: {6}\t {7}".format(isolution["SAT1"],isolution["SAT2"],isolution["SAT31"],isolution["SAT32"],isolution["SAT4"],isolution["SAT5"],isolution["SAT61"],isolution["SAT62"]))
    print(
        """
        SAT1 00:00 - 12:00 ANT{0}
        SAT2 00:00 - 12:00 ANT{1}
        SAT3 06:00 - 12:00 ANT{2}
        SAT3 13:00 - 16:00 ANT{3}
        SAT4 16:00 - 00:00 ANT{4}
        SAT5 13:00 - 06:00 ANT{5}
        SAT6 09-00 - 13:00 ANT{6}
        SAT6 13-00 - 19:00 ANT{7}""".format(isolution["SAT1"], isolution["SAT2"], isolution["SAT31"], isolution["SAT32"], isolution["SAT4"], isolution["SAT5"], isolution["SAT61"], isolution["SAT62"]))
