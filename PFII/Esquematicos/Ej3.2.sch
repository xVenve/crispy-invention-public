*version 9.1 3495726739
u 141
V? 4
R? 5
C? 2
? 2
@libraries
@analysis
.DC 1 0 0 0 1 1
+ 0 0 V3
+ 0 4 0
+ 0 5 400
+ 0 6 1
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
pageloc 1 0 2549 
@status
c 119:03:12:18:44:18;1555087458
n 0 119:03:12:18:44:21;1555087461 e 
s 2832 119:03:12:18:44:22;1555087462 e 
*page 1 0 970 720 iA
@ports
port 128 GND_ANALOG 180 160 h
@parts
part 34 c 260 140 v
a 0 u 13 0 15 35 hln 100 VALUE=10n
a 0 sp 0 0 0 10 hlb 100 PART=c
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=CK05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 ap 9 0 15 0 hln 100 REFDES=C1
a 0 a 0:13 0 0 0 hln 100 PKGREF=C1
part 124 VDC 120 110 h
a 0 sp 0 0 22 37 hln 100 PART=VDC
a 1 u 13 0 -11 18 hcn 100 DC=20
a 0 a 0:13 0 0 0 hln 100 PKGREF=V3
a 1 ap 9 0 24 7 hcn 100 REFDES=V3
part 125 r 230 150 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R3
a 0 xp 9 0 5 0 hln 100 REFDES=R3
a 0 u 13 0 5 40 hln 100 VALUE=100Meg
part 127 r 130 100 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=60k
part 126 r 180 150 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
a 0 u 13 0 15 35 hln 100 VALUE=20k
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
@conn
w 95
a 0 up 0:33 0 0 0 hln 100 V=
s 120 100 130 100 94
s 120 110 120 100 96
a 0 up 33 0 87 90 hlt 100 V=
w 99
a 0 up 0:33 0 0 0 hln 100 V=
s 120 160 180 160 98
a 0 up 0:33 0 200 84 hct 100 V=
s 180 160 180 150 100
s 180 160 230 160 102
s 120 150 120 160 105
s 230 150 230 160 107
s 260 140 260 160 28
s 230 160 260 160 109
s 260 160 270 160 137
w 113
a 0 up 0:33 0 0 0 hln 100 V=
s 170 100 180 100 114
a 0 up 0:33 0 205 84 hct 100 V=
s 180 100 230 100 118
a 0 up 33 0 205 89 hct 100 V=
s 180 110 180 100 116
s 230 110 230 100 119
s 260 110 260 100 15
s 230 100 260 100 121
a 0 up 33 0 260 84 hct 100 V=
s 260 100 270 100 135
@junction
j 180 160
+ w 99
+ w 99
j 120 110
+ p 124 +
+ w 95
j 120 150
+ p 124 -
+ w 99
j 130 100
+ p 127 1
+ w 95
j 180 160
+ s 128
+ w 99
j 260 140
+ p 34 1
+ w 99
j 230 160
+ w 99
+ w 99
j 180 150
+ p 126 1
+ w 99
j 230 150
+ p 125 1
+ w 99
j 260 160
+ w 99
+ w 99
j 180 100
+ w 113
+ w 113
j 170 100
+ p 127 2
+ w 113
j 260 110
+ p 34 2
+ w 113
j 230 100
+ w 113
+ w 113
j 180 110
+ p 126 2
+ w 113
j 230 110
+ p 125 2
+ w 113
j 260 100
+ w 113
+ w 113
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
