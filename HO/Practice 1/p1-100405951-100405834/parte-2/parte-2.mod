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
var avion_franja_pista_i{a in AVION, f in FRANJA, p in PISTA} binary;

/* funcion objetivo */

minimize gastos_extras: sum{a in AVION, f in FRANJA, p in PISTA} avion_franja_pista[a,f,p]*coste[a]*(inicio[f]-
hora_programada[a]);

/* restricciones */

  /*El slot que se asigna a un avion debe ser un slot libre (en verde en la Figura 1).*/
s.t. avionEnSlotLibre{a in AVION, f in FRANJA, p in PISTA} : avion_franja_pista[a,f,p]+ocupado[p,f] <= 1;
  /*Un slot de tiempo puede estar asignado como maximo a un avion. ´*/
s.t. avionesNoCoincidan{f in FRANJA, p in PISTA} : sum {a in AVION} avion_franja_pista[a,f,p] <= 1;
  /*Todos los aviones tienen que tener asignado un slot de tiempo para efectuar el aterrizaje.*/
s.t. asignacionUnicaAvion{a in AVION} : sum{f in FRANJA, p in PISTA} avion_franja_pista[a,f,p] = 1;
  /*El inicio del slot de aterrizaje debe ser igual o posterior a la hora de llegada del avion.*/
s.t. noAntesDeInicio{a in AVION, f in FRANJA, p in PISTA} :
(1440*avion_franja_pista_i[a,f,p])+inicio[f]*avion_franja_pista[a,f,p] >= hora_programada[a];
  /*El inicio del slot de aterrizaje debe ser igual o anterior a la hora l´ımite de aterrizaje del avion.*/
s.t. AntesDeHoraLimite{a in AVION,f in FRANJA, p in PISTA}:
(1440*avion_franja_pista_i[a,f,p])+hora_limite[a]*avion_franja_pista[a,f,p] >= inicio[f];
  /*Por cuestiones de seguridad, no se pueden asignar dos slots consecutivos en la misma pista.*/
s.t. noConsecutivos{a in AVION, b in AVION, f in FRANJA, g in FRANJA, p in PISTA : a<>b and inicio[f]>inicio[g]} :
(1455*avion_franja_pista_i[a,f,p])+inicio[f]*avion_franja_pista[a,f,p]-inicio[g]*avion_franja_pista[b,g,p] >= 16;
  /*Inversa de avion_franja_pista*/
s.t. invesaAvionFranjaPista{a in AVION,f in FRANJA, p in PISTA} :
avion_franja_pista[a,f,p]+avion_franja_pista_i[a,f,p]=1;

end;
