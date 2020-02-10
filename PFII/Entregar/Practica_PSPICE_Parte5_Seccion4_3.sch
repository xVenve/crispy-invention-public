*version 9.1 1000093605
u 75
V? 2
C? 2
R? 2
@libraries
@analysis
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
pageloc 1 0 2431 
@status
n 0 119:03:26:16:46:47;1556290007 e 
s 0 119:03:29:17:19:20;1556551160 e 
*page 1 0 970 720 iA
@ports
port 71 GND_EARTH 120 240 h
@parts
part 41 r 130 70 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=30k
part 45 r 230 150 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R3
a 0 xp 9 0 5 0 hln 100 REFDES=R3
a 0 u 13 0 5 40 hln 100 VALUE=100Meg
part 42 VDC 120 130 h
a 0 sp 0 0 22 37 hln 100 PART=VDC
a 1 u 13 0 -11 18 hcn 100 DC=48V
a 0 x 0:13 0 0 0 hln 100 PKGREF=V4
a 1 xp 9 0 24 7 hcn 100 REFDES=V4
part 44 r 180 170 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 u 13 0 15 35 hln 100 VALUE=10k
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
part 68 r 280 180 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R4
a 0 xp 9 0 15 0 hln 100 REFDES=R4
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
@conn
w 73
a 0 up 0:33 0 0 0 hln 100 V=
s 180 240 230 240 13
s 230 150 230 240 15
a 0 up 33 0 232 195 hlt 100 V=
s 180 240 180 170 50
s 120 240 180 240 8
s 120 240 120 170 61
s 230 240 280 240 17
s 280 180 280 240 4
a 0 up 0:33 0 282 210 hlt 100 V=
w 35
a 0 up 0:33 0 0 0 hln 100 V=
s 120 70 130 70 36
a 0 up 33 0 87 60 hlt 100 V=
s 120 70 120 130 53
a 0 up 33 0 122 100 hlt 100 V=
w 72
a 0 up 0:33 0 0 0 hln 100 V=
s 180 70 230 70 29
s 230 110 230 70 31
s 170 70 180 70 22
a 0 up 33 0 260 54 hct 100 V=
s 180 130 180 70 26
a 0 up 33 0 182 100 hlt 100 V=
s 230 70 280 70 74
s 280 140 280 70 20
a 0 up 33 0 287 105 hlt 100 V=
@junction
j 180 70
+ w 72
+ w 72
j 170 70
+ p 41 2
+ w 72
j 130 70
+ p 41 1
+ w 35
j 180 130
+ p 44 2
+ w 72
j 230 150
+ p 45 1
+ w 73
j 230 110
+ p 45 2
+ w 72
j 180 170
+ p 44 1
+ w 73
j 120 130
+ p 42 +
+ w 35
j 120 170
+ p 42 -
+ w 73
j 180 240
+ w 73
+ w 73
j 120 240
+ s 71
+ w 73
j 230 70
+ w 72
+ w 72
j 280 140
+ p 68 2
+ w 72
j 230 240
+ w 73
+ w 73
j 280 180
+ p 68 1
+ w 73
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
