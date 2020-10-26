/* modelo */

set TIPO;
set AVION;

/* parametros */

param equipaje{t in TIPO};
param precio{t in TIPO};
param min_billetes{t in TIPO};
param propcion_min{t in TIPO};

param asientos{a in AVION};
param capacidad{a in AVION};

/* variables */

var billetes_avion_tipo{a in AVION, t in TIPO} integer;

/* funcion objetivo */

maximize beneficio : sum{a in AVION, t in TIPO} precio[t]*billetes_avion_tipo[a,t];

/* restricciones */

s.t. limiteAsientos{a in AVION} : sum{t in TIPO} billetes_avion_tipo[a,t] <= asientos[a];
s.t. limiteEquipaje{a in AVION} : sum{t in TIPO} billetes_avion_tipo[a,t]*equipaje[t] <= capacidad[a];
s.t. limiteTipo{a in AVION, t in TIPO} : billetes_avion_tipo[a,t] >= min_billetes[t];
s.t. limiteProporcion{t in TIPO} : (sum{a in AVION} billetes_avion_tipo[a,t])/(sum{a in AVION} asientos[a]) >=
propcion_min[t];

end;
