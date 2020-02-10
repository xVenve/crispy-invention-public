*version 9.1 629698408
u 117
R? 4
V? 4
? 5
@libraries
@analysis
.DC 0 0 0 0 1 1
+ 0 0 R1
+ 0 4 100M
+ 0 5 100k
+ 0 6 5M
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
pageloc 1 0 1943 
@status
n 0 119:03:08:17:55:24;1554738924 e 
s 0 119:03:29:17:41:30;1556552490 e 
c 119:03:08:17:55:22;1554738922
*page 1 0 970 720 iA
@ports
port 6 GND_EARTH 150 100 h
@parts
part 81 VDC 90 50 h
a 0 sp 0 0 22 37 hln 100 PART=VDC
a 0 a 0:13 0 0 0 hln 100 PKGREF=V2
a 1 ap 9 0 24 7 hcn 100 REFDES=V2
a 1 u 13 0 -11 18 hcn 100 DC=20
part 2 r 100 40 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=R1
a 0 ap 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=3k
part 3 r 150 90 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=R2
a 0 ap 9 0 15 0 hln 100 REFDES=R2
a 0 u 13 0 15 35 hln 100 VALUE=1k
part 102 r 200 90 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=R3
a 0 ap 9 0 5 0 hln 100 REFDES=R3
a 0 u 13 0 5 45 hln 100 VALUE=100Meg
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
@conn
w 75
a 0 up 0:33 0 0 0 hln 100 V=
s 90 40 100 40 69
s 90 50 90 40 82
a 0 up 33 0 57 30 hlt 100 V=
w 44
s 90 100 150 100 45
s 150 100 150 90 14
s 150 100 200 100 38
s 90 90 90 100 84
s 200 90 200 100 107
s 200 100 210 100 113
w 13
a 0 up 0:33 0 0 0 hln 100 V=
s 140 40 150 40 33
a 0 up 33 0 170 24 hct 100 V=
s 150 40 200 40 80
s 150 50 150 40 47
s 200 50 200 40 103
s 200 40 210 40 105
a 0 up 33 0 220 24 hct 100 V=
@junction
j 90 50
+ p 81 +
+ w 75
j 150 40
+ w 13
+ w 13
j 200 50
+ p 102 2
+ w 13
j 150 100
+ s 6
+ w 44
j 90 90
+ p 81 -
+ w 44
j 200 90
+ p 102 1
+ w 44
j 200 100
+ w 44
+ w 44
j 200 40
+ w 13
+ w 13
j 150 50
+ p 3 2
+ w 13
j 150 90
+ p 3 1
+ w 44
j 140 40
+ p 2 2
+ w 13
j 100 40
+ p 2 1
+ w 75
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
