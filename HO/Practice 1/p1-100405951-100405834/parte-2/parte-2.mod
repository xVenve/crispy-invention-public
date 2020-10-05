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

var avion_franja{a in AVION, f in FRANJA} binary;
var horario{p in PISTA, f in FRANJA} binary;


/* funcion objetivo */

minimize gastos_extras: sum{a in AVION, f in FRANJA} coste[a]*(hora_limite[a]-inicio[f]*avion_franja[a,f]);

/* restricciones */

s.t. cadaAvionTieneUnSlot{a in AVION} : sum{f in FRANJA} avion_franja[a,f] = 1;

s.t. obligarNoDisponibles{p in PISTA, f in FRANJA} : horario[p,f] >= ocupado[p,f];
s.t. noMasDe1PorSlot{p in PISTA, f in FRANJA} : horario[p,f] <= 1;


end;

/*ideas 2*/

s.t. asignarfranja{a in AVION, f in FRANJA} : sum{p in PISTA} horario[p,f] = avion_franja[a,f];
s.t. noDeLosPosiblesPorFranja{f in FRANJA} : 4 - sum{p in PISTA} horario[p,f] <= sum{a in AVION} avion_franja[a,f];




/*ideas*/

var tabla_slot{p in PISTA, f in FRANJA} binary >= 0;

minimize gastos_extras: sum{a in AVION, f in FRANJA} coste[a]*(hora_limite[a]-inicio[f])

s.t. llega {a in AVION}:= asigL[a,f]*inicio[f] >= hora_llegada[a]
s.t. llega {a in AVION}:= asigS[a,f]*fin[f] <= hora_limite[a]
[a,f]
s.t. aviontengaslot {}:=



s.t. cadaAvionTieneUnSlot
s.t. llega {a in AVION}:= asigL[a,f]*inicio[f] >= hora_llegada[a]
s.t. llegaYlibre {a in AVION}:= matriz[i,j]*asigL[a,f] <= 0 --> todas las libres y que ademas son factibles para el vuelo

1--> ocupado
0--> libre


0 0 0 0 1 1
0 0 1 1 0 0
1 1 1 0 0 1
1 0 0 0 1 1

a in avion      ij=

s.t. slottenga1avion {

{
0 0 0 0 1 1
0 0 1 1 0 0
1 1 1 0 0 1
1 0 0 0 1 1



s.t. asignar {a in AVION} := sum{f in FRANJA} asig[a,f] <= 1

asigL
    0 1 0 0 0 0
asigS
    1 0 1 1 1 1

    1*570 >= 550 --> SI
    0*585 <= 615 --> SI



    1*555<=615
