import sys
import time


class Nodo():
    def __init__(self, parent=None, bateria1=None, sat1franjas=None, observaciones1=None, operacion1=None, pos=None,
                 bateria2=None, sat2franjas=None, observaciones2=None, numOBSrestantes=None, operacion2=None,
                 g=None, h=None, f=None, OBS=[]):
        self.parent = parent

        self.pos = pos

        self.bateria1 = bateria1
        self.sat1franjas = sat1franjas
        self.observaciones1 = observaciones1
        self.operacion1 = operacion1

        self.bateria2 = bateria2
        self.sat2franjas = sat2franjas
        self.observaciones2 = observaciones2
        self.operacion2 = operacion2

        self.numOBSrestantes = numOBSrestantes
        self.g = g
        self.h = h
        self.f = f
        self.OBS = OBS

    def __eq__(self, other):

        return (self.bateria1 == other.bateria1) and (self.pos == other.pos) and (self.sat1franjas == other.sat1franjas) and (self.observaciones1 == other.observaciones1) and (self.operacion1 == other.operacion1) and (self.bateria2 == other.bateria2) and (self.sat2franjas == other.sat2franjas) and (self.observaciones2 == other.observaciones2) and (self.numOBSrestantes == other.numOBSrestantes) and (self.operacion2 == other.operacion2)


def heuristica(nodo, nombre):
    if nombre.strip() == "lessOBS":
        return nodo.numOBSrestantes
    elif nombre.strip() == "distanciaUbeda":
        h = 0
        for observacion in nodo.OBS:
            h += abs(nodo.pos - int(observacion[1]))
        return h
    elif nombre.strip() == "bruta":
        return 0
    else:
        print("Error: El nombre de la heuristica debe ser lessOBS, distanciaUbeda o bruta.")
        sys.exit(-1)


def astar(problema, heuris):

    # Leer el problema y extraer los datosS
    f = open(problema, "r")
    lineas = f.read().splitlines()
    OBSsrc = lineas[0][5:].split(';')
    OBS = []
    for c in OBSsrc:
        OBS.append(c[1:len(c)-1].split(','))
    for d in OBS:
        if int(d[0])>11 or int(d[1])>11:
            print("Error: Observaciones fuera de la franja visible.")
            sys.exit(-1)
    SAT1 = lineas[1][6:].split(';')
    SAT2 = lineas[2][6:].split(';')
    f.close

    SAT1costeOBS = int(SAT1[0])
    SAT1costeTRANS = int(SAT1[1])
    SAT1costeGIR = int(SAT1[2])
    SAT1costeCAR = int(SAT1[3])

    SAT2costeOBS = int(SAT2[0])
    SAT2costeTRANS = int(SAT2[1])
    SAT2costeGIR = int(SAT2[2])
    SAT2costeCAR = int(SAT2[3])

    contador_nodo = 0

    # Creacion de estado inicial PONER QUE h Y f SEAN DE LA HEURISTICA
    start = Nodo(None, int(SAT1[4]), '(0,1)', 0, 'IDLE', 0, int(
        SAT2[4]), '(2,3)', 0, len(OBS), 'IDLE', 0, 0, 0, OBS[:])

    start.h = heuristica(start, heuris)
    start.f = start.h + start.g
    # Creacion de la lista abierta y la lista cerrada
    open_list = []
    closed_list = []

    open_list.append(start)
    contador_nodo += 1

    nodo_prev = None
    starttime = time.process_time()
    # Crear el loop para el algoritmo
    while len(open_list) > 0:
        nodo_actual = None
        encontrado = True
        while encontrado == True:
            encontrado = False
            if len(open_list) > 0:
                nodo_actual = open_list.pop(0)
                for nodo in closed_list:
                    if nodo_actual == nodo:
                        encontrado = True
                        break
                if encontrado == False:
                    closed_list.append(nodo_actual)
            else:
                print('No se ha encontrado solución')
                sys.exit(0)

        contador_nodo += 1

        # Comprobacion de si es el nodo final
        if nodo_actual.numOBSrestantes == 0:
            camino = []
            current = nodo_actual
            num = 0
            while current is not start:
                camino.append(current)
                current = current.parent
            caminor = camino[::-1]

            foutput = open(sys.argv[1]+".output", "w")
            foutputstat = open(sys.argv[1]+".statistics", "w")
            statmsg = "Tiempo Total: " + str("{:.1f}".format(time.process_time() - starttime)) + "\nCoste Total: " + str(
                nodo_actual.f) + "\nLongitud del plan: " + str(nodo_actual.g) + "\n" + "Nodos expandidos: " + str(contador_nodo)
            foutputstat.write(statmsg)
            foutputstat.close()

            for i in caminor:
                num += 1
                msg = str(num) + ". SAT1: " + i.operacion1 + \
                    " SAT2: " + i.operacion2 + "\n"
                foutput.write(msg)

            foutput.close()
            break

        # Generación de hijos
        nodohijo1 = None
        boolhijo1 = False
        nodohijo2 = None
        boolhijo2 = False
        nodohijo3 = None
        boolhijo3 = False
        nodohijo4 = None
        boolhijo4 = False
        nodohijo5 = None
        boolhijo5 = False

        nodohijo1OBS = nodo_actual.OBS[:]

        # Operación de Observación1
        if nodo_actual.bateria1 >= SAT1costeOBS and nodo_actual.pos < 12 and nodo_actual.OBS != None:
            for elem in nodo_actual.OBS:
                if (int(elem[0]) == int(nodo_actual.sat1franjas[1]) or int(elem[0]) == int(nodo_actual.sat1franjas[1])) and int(elem[1]) == nodo_actual.pos:
                    nodohijo1bateria1 = nodo_actual.bateria1-SAT1costeOBS
                    nodohijo1observaciones = nodo_actual.observaciones1+1
                    nodohijo1OBS.remove(elem)
                    boolhijo1 = True
                    break

        # Operación de Giro1
        if nodo_actual.bateria1 >= SAT1costeGIR and nodo_actual.pos < 12:
            if nodo_actual.sat1franjas == '(0,1)':
                nodohijo2bateria1 = nodo_actual.bateria1-SAT1costeGIR
                nodohijo2sat1franjas = '(1,2)'
                nodohijo2observaciones1 = nodo_actual.observaciones1
                boolhijo2 = True
            elif nodo_actual.sat1franjas == '(1,2)':
                nodohijo2bateria1 = nodo_actual.bateria1-SAT1costeGIR
                nodohijo2sat1franjas = '(0,1)'
                boolhijo2 = True

        # Operación de IDLE1
        if nodo_actual.pos < 12:
            boolhijo3 = True

        # Operación de Carga1
        if nodo_actual.pos < 12 and (nodo_actual.bateria1 <= start.bateria1 - SAT1costeCAR):
            nodohijo4bateria1 = nodo_actual.bateria1+SAT1costeCAR
            boolhijo4 = True

        # Operación de Transmisión1
        if nodo_actual.observaciones1 > 0 and nodo_actual.pos < 12 and nodo_actual.bateria1 >= SAT1costeTRANS:
            nodohijo5bateria1 = nodo_actual.bateria1-SAT1costeTRANS
            nodohijo5observaciones1 = nodo_actual.observaciones1-1
            boolhijo5 = True

        # Operación de Observación2
        if nodo_actual.bateria2 >= SAT2costeOBS and nodo_actual.pos < 12 and len(nodo_actual.OBS) > 0:
            if boolhijo1 == True and len(nodohijo1OBS) > 0:
                for elem in nodohijo1OBS:
                    if (int(elem[0]) == int(nodo_actual.sat2franjas[1]) or int(elem[0]) == int(nodo_actual.sat2franjas[3])) and int(elem[1]) == nodo_actual.pos:

                        nodohijo1OBS.remove(elem)
                        nodohijo1 = Nodo(nodo_actual, nodohijo1bateria1, nodo_actual.sat1franjas, nodohijo1observaciones, 'Observa', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeOBS,
                                         nodo_actual.sat2franjas, nodo_actual.observaciones2+1, nodo_actual.numOBSrestantes, 'Observa', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodohijo1OBS[:])
                        nodohijo1.h = heuristica(nodohijo1, heuris)
                        nodohijo1.f = nodohijo1.h + nodohijo1.g

                        open_list.append(nodohijo1)
                        break
            if boolhijo2 == True and len(nodohijo1OBS) > 0:
                for elem in nodohijo1OBS:
                    if (int(elem[0]) == int(nodo_actual.sat2franjas[1]) or int(elem[0]) == int(nodo_actual.sat2franjas[3])) and int(elem[1]) == nodo_actual.pos:

                        nodohijo2 = Nodo(nodo_actual, nodohijo2bateria1, nodohijo2sat1franjas, nodo_actual.observaciones1, 'Gira', nodo_actual.pos + 1, nodo_actual.bateria2 - SAT2costeOBS,
                                         nodo_actual.sat2franjas, nodo_actual.observaciones2 + 1, nodo_actual.numOBSrestantes, 'Observa', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodohijo1OBS[:])
                        nodohijo2.OBS.remove(elem)
                        nodohijo2.h = heuristica(nodohijo2, heuris)
                        nodohijo2.f = nodohijo2.h + nodohijo2.g
                        open_list.append(nodohijo2)
                        break
            if boolhijo3 == True and len(nodohijo1OBS) > 0:
                for elem in nodohijo1OBS:
                    if (int(elem[0]) == int(nodo_actual.sat2franjas[1]) or int(elem[0]) == int(nodo_actual.sat2franjas[3])) and int(elem[1]) == nodo_actual.pos:

                        nodohijo3 = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'IDLE', nodo_actual.pos + 1, nodo_actual.bateria2 - SAT2costeOBS,
                                         nodo_actual.sat2franjas, nodo_actual.observaciones2 + 1, nodo_actual.numOBSrestantes, 'Observa', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodohijo1OBS[:])
                        nodohijo3.OBS.remove(elem)
                        nodohijo3.h = heuristica(nodohijo3, heuris)
                        nodohijo3.f = nodohijo3.h + nodohijo3.g
                        open_list.append(nodohijo3)
                        break
            if boolhijo4 == True and len(nodohijo1OBS) > 0:
                for elem in nodohijo1OBS:
                    if (int(elem[0]) == int(nodo_actual.sat2franjas[1]) or int(elem[0]) == int(nodo_actual.sat2franjas[3])) and int(elem[1]) == nodo_actual.pos:

                        nodohijo4 = Nodo(nodo_actual, nodohijo4bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Carga', nodo_actual.pos + 1, nodo_actual.bateria2-SAT2costeOBS, nodo_actual.sat2franjas, nodo_actual.observaciones2 + 1,
                                         nodo_actual.numOBSrestantes, 'Observa', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodohijo1OBS[:])
                        nodohijo4.h = heuristica(nodohijo4, heuris)
                        nodohijo4.f = nodohijo4.h + nodohijo4.g

                        nodohijo4.OBS.remove(elem)
                        open_list.append(nodohijo4)
                        break
            if boolhijo5 == True and len(nodohijo1OBS) > 0:
                for elem in nodohijo1OBS:
                    if (int(elem[0]) == int(nodo_actual.sat2franjas[1]) or int(elem[0]) == int(nodo_actual.sat2franjas[3])) and int(elem[1]) == nodo_actual.pos:

                        nodohijo5 = Nodo(nodo_actual, nodohijo5bateria1, nodo_actual.sat1franjas, nodohijo5observaciones1, 'Transmite', nodo_actual.pos + 1, nodo_actual.bateria2 - SAT2costeOBS,
                                         nodo_actual.sat2franjas, nodo_actual.observaciones2 + 1, nodo_actual.numOBSrestantes-1, 'Observa', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodohijo1OBS[:])
                        nodohijo5.h = heuristica(nodohijo5, heuris)
                        nodohijo5.f = nodohijo5.h + nodohijo5.g

                        nodohijo5.OBS.remove(elem)
                        open_list.append(nodohijo5)
                        break

        # Operación de Giro2
        if nodo_actual.bateria2 >= SAT1costeGIR and nodo_actual.pos < 12:
            if boolhijo1 == True and len(nodohijo1OBS) > 0:
                if nodo_actual.sat2franjas == '(2,3)':

                    nodohijo1 = Nodo(nodo_actual, nodohijo1bateria1, nodo_actual.sat1franjas, nodohijo1observaciones, 'Observa', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(1,2)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodohijo1OBS[:])
                    nodohijo1.h = heuristica(nodohijo1, heuris)

                    open_list.append(nodohijo1)

                elif nodo_actual.sat2franjas == '(1,2)' and len(nodohijo1OBS) > 0:

                    nodohijo1 = Nodo(nodo_actual, nodohijo1bateria1, nodo_actual.sat1franjas, nodohijo1observaciones, 'Observa', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(2,3)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo1.h = heuristica(nodohijo1, heuris)
                    nodohijo1.f = nodohijo1.h + nodohijo1.g
                    open_list.append(nodohijo1)

            if boolhijo2 == True:
                if nodo_actual.sat2franjas == '(2,3)':

                    nodohijo2 = Nodo(nodo_actual, nodohijo2bateria1, nodohijo2sat1franjas, nodohijo2observaciones1, 'Gira', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(1,2)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo2.h = heuristica(nodohijo2, heuris)
                    nodohijo2.f = nodohijo2.h + nodohijo2.g
                    open_list.append(nodohijo2)

                else:
                    nodohijo2 = Nodo(nodo_actual, nodohijo2bateria1, nodohijo2sat1franjas, nodohijo2observaciones1, 'Gira', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(2,3)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo2.h = heuristica(nodohijo2, heuris)
                    nodohijo2.f = nodohijo2.h + nodohijo2.g
                    open_list.append(nodohijo2)

            if boolhijo3 == True:
                if nodo_actual.sat2franjas == '(2,3)':

                    nodohijo3 = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'IDLE', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(1,2)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo3.h = heuristica(nodohijo3, heuris)
                    nodohijo3.f = nodohijo3.h + nodohijo3.g
                    open_list.append(nodohijo3)

                else:
                    nodohijo3 = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'IDLE', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(2,3)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo3.h = heuristica(nodohijo3, heuris)
                    nodohijo3.f = nodohijo3.h + nodohijo3.g
                    open_list.append(nodohijo3)

            if boolhijo4 == True:
                if nodo_actual.sat2franjas == '(2,3)':

                    nodohijo4 = Nodo(nodo_actual, nodohijo4bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Carga', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(1,2)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo4.h = heuristica(nodohijo4, heuris)
                    nodohijo4.f = nodohijo4.h + nodohijo4.g

                    open_list.append(nodohijo4)

                else:
                    nodohijo4 = Nodo(nodo_actual, nodohijo4bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Carga', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(2,3)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo4.h = heuristica(nodohijo4, heuris)
                    nodohijo4.f = nodohijo4.h + nodohijo4.g

                    open_list.append(nodohijo4)

            if boolhijo5 == True:
                if nodo_actual.sat2franjas == '(2,3)':

                    nodohijo5 = Nodo(nodo_actual, nodohijo5bateria1, nodo_actual.sat1franjas, nodohijo5observaciones1, 'Transmite', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(1,2)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes-1, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo5.h = heuristica(nodohijo5, heuris)
                    nodohijo5.f = nodohijo5.h + nodohijo5.g
                    open_list.append(nodohijo5)

                else:
                    nodohijo5 = Nodo(nodo_actual, nodohijo5bateria1, nodo_actual.sat1franjas, nodohijo5observaciones1, 'Transmite', nodo_actual.pos+1, nodo_actual.bateria2 - SAT2costeGIR,
                                     '(2,3)', nodo_actual.observaciones2, nodo_actual.numOBSrestantes-1, 'Gira', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h, nodo_actual.OBS[:])
                    nodohijo5.h = heuristica(nodohijo5, heuris)
                    nodohijo5.f = nodohijo5.h + nodohijo5.g
                    open_list.append(nodohijo5)

        # Operación de IDLE2
        if int(nodo_actual.pos) < 12:
            if boolhijo1 == True and len(nodohijo1OBS) > 0:

                nodohijo1 = Nodo(nodo_actual, nodohijo1bateria1, nodo_actual.sat1franjas, nodohijo1observaciones, 'Observa', nodo_actual.pos+1, nodo_actual.bateria2, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'IDLE', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodohijo1OBS[:])
                nodohijo1.h = heuristica(nodohijo1, heuris)
                nodohijo1.f = nodohijo1.h + nodohijo1.g

                open_list.append(nodohijo1)

            if boolhijo2 == True:

                nodohijo2 = Nodo(nodo_actual, nodohijo2bateria1, nodohijo2sat1franjas, nodohijo2observaciones1, 'Gira', nodo_actual.pos+1, nodo_actual.bateria2, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'IDLE', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodo_actual.OBS[:])
                nodohijo2.h = heuristica(nodohijo2, heuris)
                nodohijo2.f = nodohijo2.h + nodohijo2.g
                open_list.append(nodohijo2)

            if boolhijo3 == True:

                nodohijo3 = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'IDLE', nodo_actual.pos+1, nodo_actual.bateria2, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'IDLE', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodo_actual.OBS[:])
                nodohijo3.h = heuristica(nodohijo3, heuris)
                nodohijo3.f = nodohijo3.h + nodohijo3.g

                open_list.append(nodohijo3)

            if boolhijo4 == True:

                nodohijo4 = Nodo(nodo_actual, nodohijo4bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Carga', nodo_actual.pos+1, nodo_actual.bateria2, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'IDLE', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodo_actual.OBS[:])
                nodohijo4.h = heuristica(nodohijo4, heuris)
                nodohijo4.f = nodohijo4.h + nodohijo4.g

                open_list.append(nodohijo4)

            if boolhijo5 == True:

                nodohijo5 = Nodo(nodo_actual, nodohijo5bateria1, nodo_actual.sat1franjas, nodohijo5observaciones1, 'Transmite', nodo_actual.pos+1, nodo_actual.bateria2, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2, nodo_actual.numOBSrestantes-1, 'IDLE', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g + 1 + nodo_actual.h,  nodo_actual.OBS[:])
                nodohijo5.h = heuristica(nodohijo5, heuris)
                nodohijo5.f = nodohijo5.h + nodohijo5.g

                open_list.append(nodohijo5)

        # Operación de Carga2
        if (nodo_actual.pos < 12) and (nodo_actual.bateria2 <= int(SAT2[4]) - SAT2costeCAR):
            if boolhijo1 == True and len(nodohijo1OBS) > 0:

                nodohijo1 = Nodo(nodo_actual, nodohijo1bateria1, nodo_actual.sat1franjas, nodohijo1observaciones, 'Observa', nodo_actual.pos+1, nodo_actual.bateria2 + SAT2costeCAR,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Carga', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodohijo1OBS[:])
                nodohijo1.h = heuristica(nodohijo1, heuris)
                nodohijo1.f = nodohijo1.h + nodohijo1.g

                open_list.append(nodohijo1)

            if boolhijo2 == True:

                nodohijo2 = Nodo(nodo_actual, nodohijo2bateria1, nodohijo2sat1franjas, nodohijo2observaciones1, 'Gira', nodo_actual.pos+1, nodo_actual.bateria2 + SAT2costeCAR,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Carga', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo2.h = heuristica(nodohijo2, heuris)
                nodohijo2.f = nodohijo2.h + nodohijo2.g

                open_list.append(nodohijo2)

            if boolhijo3 == True:

                nodohijo3 = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'IDLE', nodo_actual.pos+1, nodo_actual.bateria2 + SAT2costeCAR,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Carga', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo3.h = heuristica(nodohijo3, heuris)
                nodohijo3.f = nodohijo3.h + nodohijo3.g

                open_list.append(nodohijo3)

            if boolhijo4 == True:

                nodohijo4 = Nodo(nodo_actual, nodohijo4bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Carga', nodo_actual.pos+1, nodo_actual.bateria2 + SAT2costeCAR,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Carga', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo4.h = heuristica(nodohijo4, heuris)
                nodohijo4.f = nodohijo4.h + nodohijo4.g

                open_list.append(nodohijo4)

            if boolhijo5 == True:

                nodohijo5 = Nodo(nodo_actual, nodohijo5bateria1, nodo_actual.sat1franjas, nodohijo5observaciones1, 'Transmite', nodo_actual.pos+1, nodo_actual.bateria2 + SAT2costeCAR,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2, nodo_actual.numOBSrestantes-1, 'Carga', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo5.h = heuristica(nodohijo5, heuris)
                nodohijo5.f = nodohijo5.h + nodohijo5.g

                open_list.append(nodohijo5)

        # Operación de Transmisión
        if nodo_actual.observaciones2 > 0 and nodo_actual.pos < 12 and nodo_actual.bateria2 >= SAT2costeTRANS:
            if boolhijo1 == True and len(nodohijo1OBS) > 0:

                nodohijo1 = Nodo(nodo_actual, nodohijo1bateria1, nodo_actual.sat1franjas, nodohijo1observaciones, 'Observa', nodo_actual.pos+1, nodo_actual.bateria2-SAT2costeTRANS,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2-1, nodo_actual.numOBSrestantes-1, 'Transmite', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodohijo1OBS[:])
                nodohijo1.h = heuristica(nodohijo1, heuris)
                nodohijo1.f = nodohijo1.h + nodohijo1.g

                open_list.append(nodohijo1)

            if boolhijo2 == True:

                nodohijo2 = Nodo(nodo_actual, nodohijo2bateria1, nodohijo2sat1franjas, nodohijo2observaciones1, 'Gira', nodo_actual.pos+1, nodo_actual.bateria2-SAT2costeTRANS, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2-1, nodo_actual.numOBSrestantes-1, 'Transmite', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo2.h = heuristica(nodohijo2, heuris)
                nodohijo2.f = nodohijo2.h + nodohijo2.g
                open_list.append(nodohijo2)

            if boolhijo3 == True:

                nodohijo3 = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'IDLE', nodo_actual.pos + 1, nodo_actual.bateria2 - SAT2costeTRANS,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2-1, nodo_actual.numOBSrestantes-1, 'Transmite', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo3.h = heuristica(nodohijo3, heuris)
                nodohijo3.f = nodohijo3.h + nodohijo3.g

                open_list.append(nodohijo3)

            if boolhijo4 == True:

                nodohijo4 = Nodo(nodo_actual, nodohijo4bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Carga', nodo_actual.pos+1, nodo_actual.bateria2-SAT2costeTRANS, nodo_actual.sat2franjas, nodo_actual.observaciones2-1,
                                 nodo_actual.numOBSrestantes-1, 'Transmite', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo4.h = heuristica(nodohijo4, heuris)
                nodohijo4.f = nodohijo4.h + nodohijo4.g

                open_list.append(nodohijo4)

            if boolhijo5 == True:

                nodohijo5 = Nodo(nodo_actual, nodohijo5bateria1, nodo_actual.sat1franjas, nodohijo5observaciones1, 'Transmite', nodo_actual.pos + 1, nodo_actual.bateria2 - SAT2costeTRANS,
                                 nodo_actual.sat2franjas, nodo_actual.observaciones2-1, nodo_actual.numOBSrestantes-2, 'Transmite', nodo_actual.g + 1, nodo_actual.h, nodo_actual.g+1 + nodo_actual.h, nodo_actual.OBS[:])
                nodohijo5.h = heuristica(nodohijo5, heuris)
                nodohijo5.f = nodohijo5.h + nodohijo5.g

                open_list.append(nodohijo5)

        # Operación de Noche
        if nodo_actual.pos == 12:
            nodohijoNoche = Nodo(nodo_actual, nodo_actual.bateria1, nodo_actual.sat1franjas, nodo_actual.observaciones1, 'Noche', 0, nodo_actual.bateria2, nodo_actual.sat2franjas,
                                 nodo_actual.observaciones2, nodo_actual.numOBSrestantes, 'Noche', nodo_actual.g+12, nodo_actual.h, nodo_actual.g+12 + nodo_actual.h, nodo_actual.OBS[:])
            open_list.append(nodohijoNoche)

        open_list = sorted(open_list, key=lambda nodo: nodo.f)
        nodo_prev = nodo_actual


if __name__ == "__main__":

    # Comprobacion del numero de parametros
    if len(sys.argv) < 3:
        print('Formato invalido. \n Cosmos.sh <problema.prob> <heuristica>')
        sys.exit(-1)

    # Llamada a A* dado un problema y heuristica
    astar(sys.argv[1], sys.argv[2])
