*version 9.1 953022155
u 416
V? 5
C? 8
? 4
R? 3
HB? 2
I? 2
@libraries
@analysis
.AC 0 3 0
+0 101
+1 10
+2 200k
.TRAN 1 0 1 0
+0 0ns
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
pageloc 1 0 1773 
@status
n 0 119:03:29:17:31:20;1556551880 e 
s 0 119:03:29:17:31:20;1556551880 e 
c 119:03:29:17:31:13;1556551873
*page 1 0 970 720 iA
@ports
port 415 GND_ANALOG 60 260 h
@parts
part 412 idc 60 250 u
a 1 ap 9 0 20 10 hcn 100 REFDES=I1
a 1 u 13 0 -9 11 hcn 100 DC=1.66mA
a 0 a 0:13 0 0 0 hln 100 PKGREF=I1
part 414 r 110 250 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R1
a 0 xp 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 35 hln 100 VALUE=7.5k
part 413 r 150 250 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 x 0:13 0 0 0 hln 100 PKGREF=R2
a 0 xp 9 0 25 0 hln 100 REFDES=R2
a 0 u 13 0 25 35 hln 100 VALUE=1k
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
@conn
w 387
a 0 up 0:33 0 0 0 hln 100 V=
s 60 250 60 260 386
s 150 260 150 250 388
s 160 260 150 260 392
s 60 260 110 260 394
a 0 up 0:33 0 110 184 hct 100 V=
s 110 260 150 260 398
s 110 250 110 260 396
w 400
a 0 up 0:33 0 0 0 hln 100 V=
s 60 210 60 200 399
a 0 up 33 0 27 190 hlt 100 V=
s 150 200 150 210 401
s 160 200 150 200 403
a 0 up 33 0 135 184 hct 100 V=
s 150 200 110 200 407
a 0 up 33 0 175 229 hct 100 V=
s 110 200 60 200 411
a 0 up 33 0 85 199 hct 100 V=
s 110 210 110 200 409
@junction
j 150 260
+ w 387
+ w 387
j 110 260
+ w 387
+ w 387
j 150 200
+ w 400
+ w 400
j 110 200
+ w 400
+ w 400
j 60 250
+ p 412 +
+ w 387
j 60 210
+ p 412 -
+ w 400
j 150 250
+ p 413 1
+ w 387
j 150 210
+ p 413 2
+ w 400
j 110 250
+ p 414 1
+ w 387
j 110 210
+ p 414 2
+ w 400
j 60 260
+ s 415
+ w 387
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics
