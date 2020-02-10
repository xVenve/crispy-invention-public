*version 9.1 1043301294
u 103
V? 2
C? 3
? 3
@libraries
@analysis
.TRAN 1 0 1 0
+0 0
+1 8ms
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
pageloc 1 0 3345 
@status
n 0 119:03:11:19:11:02;1555002662 e 
s 0 119:03:26:08:25:55;1556259955 e 
*page 1 0 970 720 iA
@ports
port 41 GND_ANALOG 240 250 h
@parts
part 7 VSIN 180 130 h
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 0 x 0:13 0 0 0 hln 100 PKGREF=V2
a 1 xp 9 0 20 10 hcn 100 REFDES=V2
a 1 u 0 0 0 0 hcn 100 VAMPL=10V
a 1 u 0 0 0 0 hcn 100 FREQ=4400Hz
part 8 VSIN 180 90 h
a 1 ap 9 0 20 10 hcn 100 REFDES=V1
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 1 u 0 0 0 0 hcn 100 FREQ=440Hz
a 1 u 0 0 0 0 hcn 100 VAMPL=20V
a 0 a 0:13 0 0 0 hln 100 PKGREF=V1
part 9 VSIN 180 170 h
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 0 x 0:13 0 0 0 hln 100 PKGREF=V3
a 1 xp 9 0 20 10 hcn 100 REFDES=V3
a 1 u 0 0 0 0 hcn 100 FREQ=8800Hz
a 1 u 0 0 0 0 hcn 100 VAMPL=4V
part 40 r 190 80 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=30k
part 6 VDC 180 210 h
a 0 sp 0 0 22 37 hln 100 PART=VDC
a 1 u 13 0 -11 18 hcn 100 DC=48V
a 0 x 0:13 0 0 0 hln 100 PKGREF=V4
a 1 xp 9 0 24 7 hcn 100 REFDES=V4
part 37 c 320 120 v
a 0 u 13 0 15 35 hln 100 VALUE=10n
a 0 sp 0 0 0 10 hlb 100 PART=c
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=CK05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 ap 9 0 15 0 hln 100 REFDES=C1
a 0 a 0:13 0 0 0 hln 100 PKGREF=C1
part 38 r 240 180 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 u 13 0 15 35 hln 100 VALUE=10k
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
part 39 r 290 160 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R3
a 0 xp 9 0 5 0 hln 100 REFDES=R3
a 0 u 13 0 5 40 hln 100 VALUE=100Meg
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
part 101 nodeMarker 330 80 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=1
part 102 nodeMarker 180 80 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=2
@conn
w 11
a 0 up 0:33 0 0 0 hln 100 V=
s 240 250 180 250 74
s 320 120 320 250 16
a 0 up 33 0 322 185 hlt 100 V=
s 320 250 330 250 20
s 240 250 290 250 18
s 240 250 240 180 81
s 290 250 320 250 100
s 290 160 290 250 14
w 23
a 0 up 0:33 0 0 0 hln 100 V=
s 230 80 240 80 24
a 0 up 33 0 265 69 hct 100 V=
s 320 90 320 80 31
s 240 80 290 80 33
a 0 up 33 0 320 64 hct 100 V=
s 320 80 330 80 35
s 240 140 240 80 26
a 0 up 33 0 242 110 hlt 100 V=
s 290 80 320 80 98
s 290 120 290 80 29
w 3
a 0 up 0:33 0 0 0 hln 100 V=
s 180 80 180 90 2
s 180 80 190 80 4
a 0 up 33 0 147 70 hlt 100 V=
@junction
j 180 130
+ p 8 -
+ p 7 +
j 180 90
+ p 8 +
+ w 3
j 180 170
+ p 9 +
+ p 7 -
j 320 80
+ w 23
+ w 23
j 190 80
+ p 40 1
+ w 3
j 230 80
+ p 40 2
+ w 23
j 180 250
+ p 6 -
+ w 11
j 320 120
+ p 37 1
+ w 11
j 320 250
+ w 11
+ w 11
j 180 210
+ p 9 -
+ p 6 +
j 320 90
+ p 37 2
+ w 23
j 240 250
+ s 41
+ w 11
j 240 140
+ p 38 2
+ w 23
j 240 80
+ w 23
+ w 23
j 240 180
+ p 38 1
+ w 11
j 290 120
+ p 39 2
+ w 23
j 290 80
+ w 23
+ w 23
j 290 160
+ p 39 1
+ w 11
j 290 250
+ w 11
+ w 11
j 330 80
+ p 101 pin1
+ w 23
j 180 80
+ p 102 pin1
+ w 3
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
