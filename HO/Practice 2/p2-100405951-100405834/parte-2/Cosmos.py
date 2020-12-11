import sys


class Nodo():

    def __init__(self, parent=None, bateria1=None, sat1franjas=None, observaciones1=None, pos=None,
                 bateria2=None, sat2franjas=None, observaciones2=None, g=None, h=None, f=None):
        self.parent = parent

        self.pos = pos

        self.bateria1 = bateria1
        self.sat1franjas = sat1franjas
        self.observaciones1 = observaciones1

        self.bateria2 = bateria2
        self.sat2franjas = sat2franjas
        self.observaciones2 = observaciones2

        self.g = g
        self.h = h
        self.f = f

    def __eq__(self, other):
        return (self.bateria1 == other.bateria1) and (self.pos1 == other.pos1) and (self.sat1franjas == other.sat1franjas) and (self.sat1franjas == other.sat1franjas) and (self.observaciones1 == other.observaciones1) and (self.bateria2 == other.bateria2) and (self.pos2 == other.pos2) and (self.sat2franjas == other.sat2franjas) and (self.observaciones2 == other.observaciones2)


def astar(problema, heuristica):

    # Leer el problema y extraer los datos
    f = open(problema, "r")
    lineas = f.read().splitlines()
    OBS = lineas[0][5:].split(';')
    SAT1 = lineas[1][6:].split(';')
    SAT2 = lineas[2][6:].split(';')
    f.close

    numOBSrestantes = len(OBS)

    SAT1costeOBS = SAT1[0]
    SAT1costeTRANS = SAT1[1]
    SAT1costeGIR = SAT1[2]
    SAT1costeCAR = SAT1[3]

    SAT2costeOBS = SAT2[0]
    SAT2costeTRANS = SAT2[1]
    SAT2costeGIR = SAT2[2]
    SAT2costeCAR = SAT1[3]

    # Creacion de estado inicial PONER QUE h Y f SEAN DE LA HEURISTICA
    start = Nodo(None, SAT1[4], '(0,1)', 0, 0, SAT2[4], '(2,3)', 0, 0, 5, 5)

    # Creacion de la lista abierta y la lista cerrada
    open_list = []
    closedlist = set()

    start2 = Nodo(None, 1, '(0,1)', 0, 0, 1, '(2,3)', 0, 0, 5, 7)
    start3 = Nodo(None, 1, '(0,1)', 0, 0, 1, '(2,3)', 0, 0, 3, 1)
    start4 = Nodo(None, 1, '(0,1)', 0, 0, 1, '(2,3)', 0, 0, 5, 23)

    open_list.append(start)
    open_list.append(start2)
    open_list.append(start3)
    open_list.append(start4)

    open_list = sorted(open_list, key=lambda nodo: nodo.f)

    for val in open_list:
        print(val.f)


if __name__ == "__main__":

    # Comprobacion del numero de parametros
    if len(sys.argv) < 3:
        print("Formato invalido. \n Cosmos.sh <problema.prob> <heuristica>")
        sys.exit(-1)

    # Llamada a A* dado un problema y heuristica
    astar(sys.argv[1], sys.argv[2])
