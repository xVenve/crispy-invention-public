set FRANJA;
set PISTA;
set AVION;

/* parametros */

param ocupado{p in PISTA, f in FRANJA};

param hora_programada{a in AVION};
param hora_limite{a in AVION};
param coste{a in AVION};

param inicio{f in FRANJA};
param fin{f in FRANJA};

/* variables */

var binary avion-slot (a in AVION, s in SLOT)

/* funcion objetivo */

minimize gastos_extras: sum{a in AVION, f in FRANJA} coste[a]*(hora_limite[a]-inicio[f])

s.d. cadaAvionTieneUnSlot {a in AVION} := sum (avion-slot[a]) >= 1

end;






/*ideas*/

var tabla_slot{p in PISTA, f in FRANJA} binary >= 0;

minimize gastos_extras: sum{a in AVION, f in FRANJA} coste[a]*(hora_limite[a]-inicio[f])

s.d. llega {a in AVION}:= asigL[a,f]*inicio[f] >= hora_llegada[a]
s.d. llega {a in AVION}:= asigS[a,f]*fin[f] <= hora_limite[a]
[a,f]
s.d. aviontengaslot {}:=



s.d. cadaAvionTieneUnSlot
s.d. llega {a in AVION}:= asigL[a,f]*inicio[f] >= hora_llegada[a]
s.d. llegaYlibre {a in AVION}:= matriz[i,j]*asigL[a,f] <= 0 --> todas las libres y que ademas son factibles para el vuelo

1--> ocupado
0--> libre


0 0 0 0 1 1
0 0 1 1 0 0
1 1 1 0 0 1
1 0 0 0 1 1

a in avion      ij=

s.d. slottenga1avion {

{
0 0 0 0 1 1
0 0 1 1 0 0
1 1 1 0 0 1
1 0 0 0 1 1



s.d. asignar {a in AVION} := sum{f in FRANJA} asig[a,f] <= 1

asigL
    0 1 0 0 0 0
asigS
    1 0 1 1 1 1

    1*570 >= 550 --> SI
    0*585 <= 615 --> SI



    1*555<=615
