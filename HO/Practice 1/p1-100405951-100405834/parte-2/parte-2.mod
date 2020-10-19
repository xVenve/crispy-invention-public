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

var avion_franja_pista{a in AVION, f in FRANJA, p in PISTA} binary;

/* funcion objetivo */

minimize gastos_extras: sum{a in AVION, f in FRANJA, p in PISTA} coste[a]*(hora_programada[a]-inicio[f])*avion_franja_pista[a,f,p];

/* restricciones */

s.t. avionEnSlotLibre{a in AVION, f in FRANJA, p in PISTA} : avion_franja_pista[a,f,p]+ocupado[p,f] <= 1;

s.t. avionesNoCoincida {f in FRANJA, p in PISTA} : sum {a in AVION} avion_franja_pista[a,f,p] <= 1;

s.t. asignacionUnicaAvion{a in AVION}: sum{f in FRANJA, p in PISTA} avion_franja_pista[a,f,p] = 1;

/*
  s.t. noAntesDeInicio{a in AVION,f in FRANJA, p in PISTA}: inicio[f]*avion_franja_pista[a,f,p] >= hora_programada[a];
  s.t. AntesDeHoraLimite{a in AVION,f in FRANJA, p in PISTA}: hora_limite[a]*avion_franja_pista[a,f,p] >= inicio[f];

  s.t. noConsecutivos{a in AVION, b in AVION, f in FRANJA, g in FRANJA, p in PISTA}: avion_franja_pista[a,f,p]+avion_franja_pista[b,g,p] <= 1;
*/



end;
