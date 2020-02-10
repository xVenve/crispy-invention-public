*version 9.1 3058309147
u 70
C? 2
V? 3
? 8
@libraries
@analysis
.AC 1 3 0
+0 101
+1 10
+2 200K
.TRAN 0 0 0 0
+0 0
+1 10ms
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
pageloc 1 0 2680 
@status
n 0 119:03:12:19:01:04;1555088464 e 
s 2832 119:03:12:19:08:51;1555088931 e 
c 119:03:12:19:00:57;1555088457
*page 1 0 970 720 iA
@ports
port 42 GND_ANALOG 280 160 h
@parts
part 40 r 330 150 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R3
a 0 xp 9 0 5 0 hln 100 REFDES=R3
a 0 u 13 0 5 40 hln 100 VALUE=100Meg
part 41 r 230 100 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=30k
part 43 VAC 220 110 h
a 0 u 13 0 -9 23 hcn 100 ACMAG=10V
a 0 sp 0 0 0 50 hln 100 PART=VAC
a 0 a 0:13 0 0 0 hln 100 PKGREF=V2
a 1 ap 9 0 20 10 hcn 100 REFDES=V2
part 37 c 360 140 v
a 0 u 13 0 15 35 hln 100 VALUE=10n
a 0 sp 0 0 0 10 hlb 100 PART=c
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=CK05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 ap 9 0 15 0 hln 100 REFDES=C1
a 0 a 0:13 0 0 0 hln 100 PKGREF=C1
part 39 r 280 150 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 u 13 0 15 35 hln 100 VALUE=10k
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
part 65 nodeMarker 360 110 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=3
@conn
w 3
a 0 up 0:33 0 0 0 hln 100 V=
s 220 100 230 100 2
s 220 110 220 100 4
a 0 up 33 0 187 90 hlt 100 V=
w 7
a 0 up 0:33 0 0 0 hln 100 V=
s 220 160 280 160 6
a 0 up 0:33 0 300 84 hct 100 V=
s 280 160 280 150 8
s 280 160 330 160 10
s 220 150 220 160 12
s 330 150 330 160 14
s 360 140 360 160 16
s 330 160 360 160 18
s 360 160 370 160 20
w 23
a 0 up 0:33 0 0 0 hln 100 V=
s 270 100 280 100 24
a 0 up 33 0 280 79 hct 100 V=
s 280 100 330 100 28
a 0 up 33 0 305 104 hct 100 V=
s 280 110 280 100 26
s 330 110 330 100 29
s 360 110 360 100 31
s 330 100 360 100 33
a 0 up 33 0 360 84 hct 100 V=
s 360 100 370 100 35
@junction
j 280 150
+ p 39 1
+ w 7
j 280 160
+ w 7
+ w 7
j 330 160
+ w 7
+ w 7
j 360 160
+ w 7
+ w 7
j 360 140
+ p 37 1
+ w 7
j 330 150
+ p 40 1
+ w 7
j 280 160
+ s 42
+ w 7
j 230 100
+ p 41 1
+ w 3
j 270 100
+ p 41 2
+ w 23
j 280 100
+ w 23
+ w 23
j 330 100
+ w 23
+ w 23
j 360 100
+ w 23
+ w 23
j 360 110
+ p 37 2
+ w 23
j 280 110
+ p 39 2
+ w 23
j 330 110
+ p 40 2
+ w 23
j 220 150
+ p 43 -
+ w 7
j 220 110
+ p 43 +
+ w 3
j 360 110
+ p 65 pin1
+ p 37 2
j 360 110
+ p 65 pin1
+ w 23
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
