*version 9.1 343146533
u 58
V? 3
R? 6
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
pageloc 1 0 2081 
@status
n 0 119:03:06:22:16:29;1554581789 e 
s 2832 119:03:06:22:16:29;1554581789 e 
c 119:03:06:22:16:06;1554581766
*page 1 0 970 720 iA
@ports
port 57 GND_ANALOG 170 130 h
@parts
part 53 VDC 110 80 h
a 0 sp 0 0 22 37 hln 100 PART=VDC
a 1 ap 9 0 24 7 hcn 100 REFDES=V2
a 1 u 13 0 -11 18 hcn 100 DC=20
a 0 a 0:13 0 0 0 hln 100 PKGREF=V2
part 54 r 220 120 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 ap 9 0 5 0 hln 100 REFDES=R3
a 0 a 0:13 0 0 0 hln 100 PKGREF=R3
a 0 u 13 0 5 45 hln 100 VALUE=100Meg
part 56 r 170 120 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 15 0 hln 100 REFDES=R2
a 0 u 13 0 15 35 hln 100 VALUE=10k
part 55 r 120 70 h
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 25 hln 100 VALUE=30k
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
@conn
w 27
a 0 up 0:33 0 0 0 hln 100 V=
s 110 70 120 70 26
s 110 80 110 70 28
a 0 up 33 0 77 60 hlt 100 V=
w 31
a 0 up 0:33 0 0 0 hln 100 V=
s 110 130 170 130 30
a 0 up 0:33 0 190 54 hct 100 V=
s 170 130 170 120 32
s 170 130 220 130 34
s 110 120 110 130 36
s 220 120 220 130 38
s 220 130 230 130 40
w 43
a 0 up 0:33 0 0 0 hln 100 V=
s 160 70 170 70 44
a 0 up 33 0 190 54 hct 100 V=
s 170 70 220 70 48
a 0 up 0:33 0 195 54 hct 100 V=
s 170 80 170 70 46
s 220 80 220 70 49
s 220 70 230 70 51
a 0 up 33 0 240 54 hct 100 V=
@junction
j 170 130
+ w 31
+ w 31
j 220 130
+ w 31
+ w 31
j 170 70
+ w 43
+ w 43
j 220 70
+ w 43
+ w 43
j 220 120
+ p 54 1
+ w 31
j 220 80
+ p 54 2
+ w 43
j 120 70
+ p 55 1
+ w 27
j 160 70
+ p 55 2
+ w 43
j 170 120
+ p 56 1
+ w 31
j 170 80
+ p 56 2
+ w 43
j 170 130
+ s 57
+ w 31
j 110 80
+ p 53 +
+ w 27
j 110 120
+ p 53 -
+ w 31
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
