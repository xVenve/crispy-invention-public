*version 9.1 2685869655
u 66
V? 3
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
pageloc 1 0 1592 
@status
n 0 119:03:29:17:18:54;1556551134 e 
s 0 119:03:29:17:18:54;1556551134 e 
c 119:03:29:17:18:52;1556551132
*page 1 0 970 720 iA
@ports
port 42 GND_ANALOG 270 210 h
@parts
part 44 vdc 270 160 h
a 1 u 13 0 -11 18 hcn 100 DC=12V
a 0 sp 0 0 22 37 hln 100 PART=vdc
a 0 a 0:13 0 0 0 hln 100 PKGREF=V2
a 1 ap 9 0 24 7 hcn 100 REFDES=V2
part 54 r 330 200 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
part 38 r 280 150 h
a 0 u 13 0 15 25 hln 100 VALUE=7.5k
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
@conn
w 3
a 0 up 0:33 0 0 0 hln 100 V=
s 270 150 280 150 2
s 270 160 270 150 4
a 0 up 33 0 232 150 hlt 100 V=
w 7
a 0 up 0:33 0 0 0 hln 100 V=
s 270 200 270 210 12
s 270 210 330 210 6
a 0 up 0:33 0 305 134 hct 100 V=
s 330 210 330 200 62
s 330 210 350 210 64
w 52
a 0 up 0:33 0 0 0 hln 100 V=
s 320 150 330 150 55
a 0 up 33 0 355 149 hct 100 V=
s 330 150 350 150 61
s 330 150 330 160 59
@junction
j 270 200
+ p 44 -
+ w 7
j 270 210
+ s 42
+ w 7
j 280 150
+ p 38 1
+ w 3
j 270 160
+ p 44 +
+ w 3
j 320 150
+ p 38 2
+ w 52
j 330 160
+ p 54 2
+ w 52
j 330 150
+ w 52
+ w 52
j 330 200
+ p 54 1
+ w 7
j 330 210
+ w 7
+ w 7
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
