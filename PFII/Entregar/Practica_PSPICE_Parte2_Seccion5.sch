*version 9.1 1257822882
u 155
V? 3
R? 3
C? 5
? 3
@libraries
@analysis
.TRAN 1 0 1 0
+0 0ms
+1 1ms
@targets
@attributes
@translators
a 0 u 13 0 0 0 hln 100 PCBOARDS=PCB
a 0 u 13 0 0 0 hln 100 PSPICE=PSPICE
a 0 u 13 0 0 0 hln 100 XILINX=XILINX
@setup
unconnectedPins 0
connectViaLabel 0
connectViaLocalLabels 0
NoStim4ExtIFPortsWarnings 1
AutoGenStim4ExtIFPorts 1
@index
pageloc 1 0 3126 
@status
n 0 119:03:06:22:22:49;1554582169 e 
s 0 119:03:08:18:01:18;1554739278 e 
c 119:03:08:18:08:23;1554739703
*page 1 0 970 720 iA
@ports
port 24 GND_EARTH 180 130 h
@parts
part 22 r 180 120 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 u 13 0 15 40 hln 100 VALUE=10k
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
part 32 VPULSE 120 80 h
a 1 u 0 0 0 0 hcn 100 V1=0
a 1 u 0 0 0 0 hcn 100 TD=0
a 1 u 0 0 0 0 hcn 100 TR=1ns
a 1 u 0 0 0 0 hcn 100 TF=1ns
a 1 u 0 0 0 0 hcn 100 PER=1ms
a 0 x 0:13 0 0 0 hln 100 PKGREF=V1
a 1 xp 9 0 20 10 hcn 100 REFDES=V1
a 1 u 0 0 0 0 hcn 100 PW=0.5ms
a 1 u 0 0 0 0 hcn 100 V2=20
part 129 c 250 110 v
a 0 u 13 0 15 35 hln 100 VALUE=10n
a 0 sp 0 0 0 10 hlb 100 PART=c
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=CK05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=C4
a 0 ap 9 0 15 0 hln 100 REFDES=C4
part 23 r 130 70 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=30k
part 130 r 220 120 v
a 0 x 0:13 0 0 0 hln 100 PKGREF=R3
a 0 xp 9 0 5 0 hln 100 REFDES=R3
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 u 13 0 5 40 hln 100 VALUE=100Meg
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
part 33 nodeMarker 120 70 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=1
part 34 nodeMarker 180 70 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=R2:2
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=2
@conn
w 3
a 0 up 0:33 0 0 0 hln 100 V=
s 120 70 130 70 2
s 120 80 120 70 4
a 0 up 0:33 0 87 60 hlt 100 V=
w 106
a 0 up 0:33 0 0 0 hln 100 V=
s 170 70 180 70 16
a 0 up 0:33 0 200 59 hct 100 V=
s 180 80 180 70 18
s 180 70 220 70 111
a 0 up 0:33 0 200 54 hct 100 V=
s 220 80 220 70 112
s 250 80 250 70 114
s 220 70 250 70 116
a 0 up 0:33 0 260 54 hct 100 V=
s 250 70 260 70 151
w 119
a 0 up 0:33 0 0 0 hln 100 V=
s 120 130 180 130 6
a 0 up 0:33 0 150 134 hct 100 V=
s 180 130 180 120 8
s 120 120 120 130 12
s 180 130 220 130 120
s 220 120 220 130 122
s 250 110 250 130 124
s 220 130 250 130 126
s 250 130 260 130 153
@junction
j 120 70
+ p 33 pin1
+ w 3
j 130 70
+ p 23 1
+ w 3
j 180 130
+ w 119
+ w 119
j 180 70
+ w 106
+ w 106
j 180 120
+ p 22 1
+ w 119
j 180 130
+ s 24
+ w 119
j 180 80
+ p 22 2
+ w 106
j 170 70
+ p 23 2
+ w 106
j 180 70
+ p 34 pin1
+ w 106
j 220 80
+ p 130 2
+ w 106
j 220 70
+ w 106
+ w 106
j 250 80
+ p 129 2
+ w 106
j 220 120
+ p 130 1
+ w 119
j 220 130
+ w 119
+ w 119
j 250 110
+ p 129 1
+ w 119
j 120 120
+ p 32 -
+ w 119
j 120 80
+ p 32 +
+ w 3
j 250 70
+ w 106
+ w 106
j 250 130
+ w 119
+ w 119
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
