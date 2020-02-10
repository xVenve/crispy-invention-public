*version 9.1 3779152385
u 119
C? 2
V? 7
? 4
@libraries
@analysis
.TRAN 1 0 1 0
+0 0ms
+1 2.27ms
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
pageloc 1 0 2037 
@status
n 0 119:03:11:19:18:41;1555003121 e 
s 0 119:03:11:19:18:41;1555003121 e 
c 119:03:11:19:18:54;1555003134
*page 1 0 970 720 iA
@ports
port 35 GND_EARTH 150 170 h
@parts
part 34 r 100 70 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=1k
part 92 VDC 90 200 h
a 0 sp 0 0 22 37 hln 100 PART=VDC
a 1 u 13 0 -11 18 hcn 100 DC=48V
a 0 x 0:13 0 0 0 hln 100 PKGREF=V4
a 1 xp 9 0 24 7 hcn 100 REFDES=V4
part 68 VSIN 90 120 h
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 0 x 0:13 0 0 0 hln 100 PKGREF=V2
a 1 xp 9 0 20 10 hcn 100 REFDES=V2
a 1 u 0 0 0 0 hcn 100 VAMPL=10V
a 1 u 0 0 0 0 hcn 100 FREQ=4400Hz
part 62 VSIN 90 80 h
a 0 a 0:13 0 0 0 hln 100 PKGREF=V1
a 1 ap 9 0 20 10 hcn 100 REFDES=V1
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 1 u 0 0 0 0 hcn 100 FREQ=440Hz
a 1 u 0 0 0 0 hcn 100 VAMPL=20V
part 69 VSIN 90 160 h
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 0 x 0:13 0 0 0 hln 100 PKGREF=V3
a 1 xp 9 0 20 10 hcn 100 REFDES=V3
a 1 u 0 0 0 0 hcn 100 FREQ=8800Hz
a 1 u 0 0 0 0 hcn 100 VAMPL=4V
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
part 89 nodeMarker 90 70 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=R1:1
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=1
@conn
w 80
a 0 up 0:33 0 0 0 hln 100 V=
s 90 70 90 80 79
s 90 70 100 70 15
a 0 up 33 0 57 60 hlt 100 V=
w 65
a 0 up 0:33 0 0 0 hln 100 V=
s 140 70 150 70 21
a 0 up 33 0 170 54 hct 100 V=
s 150 170 150 70 66
a 0 up 33 0 152 120 hlt 100 V=
s 140 170 150 170 85
s 140 240 140 170 70
s 90 240 140 240 2
a 0 up 0:33 0 115 244 hct 100 V=
@junction
j 140 70
+ p 34 2
+ w 65
j 150 170
+ s 35
+ w 65
j 90 240
+ p 92 -
+ w 65
j 90 200
+ p 92 +
+ p 69 -
j 90 120
+ p 68 +
+ p 62 -
j 90 160
+ p 69 +
+ p 68 -
j 90 80
+ p 62 +
+ w 80
j 100 70
+ p 34 1
+ w 80
j 90 70
+ p 89 pin1
+ w 80
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
