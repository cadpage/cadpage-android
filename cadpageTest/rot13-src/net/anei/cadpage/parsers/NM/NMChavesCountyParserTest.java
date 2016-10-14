cnpxntr arg.narv.pnqcntr.cnefref.AZ;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Punirf Pbhagl, AZ

Pbagnpg: ghpxre.gbqq <ghpxre.gbqq@yvir.pbz>
Fraqre: PNQ@ebfjryycbyvpr.pbz

SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;5103 F ZNVA FG;R PUNEYRFGBA EQ;F EBFJRYY ERYVRS EG;ZRQVPY
SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;110 ZNEX EQ;J PBYYRTR OYIQ;OEVTUG FXL EQ;TESVER
SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;ELNA FG/YRJVF NIR;FGSVER
SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;BYQ QRKGRE UJL/R PEBFFEBNQF FG;TESVER

Pbagnpg: Oevna <Oevna@qnfuyrl.arg>
Fraqre: Pnq@ebfjryy-az.tbi
Pnq@ebfjryy-az.tbi:SLV: ;302 F YVAPBYA NIR;F BYQ QRKGRE UJL;R 4GU FG;INYZRQ

*/

choyvp pynff AZPunirfPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp AZPunirfPbhaglCnefreGrfg() {
    frgCnefre(arj AZPunirfPbhaglCnefre(), "PUNIRF PBHAGL", "AZ");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;5103 F ZNVA FG;R PUNEYRFGBA EQ;F EBFJRYY ERYVRS EG;ZRQVPY",
        "NQQE:5103 F ZNVA FG",
        "K:R PUNEYRFGBA EQ & F EBFJRYY ERYVRS EG",
        "PNYY:ZRQVPY");

    qbGrfg("G2",
        "SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;110 ZNEX EQ;J PBYYRTR OYIQ;OEVTUG FXL EQ;TESVER",
        "NQQE:110 ZNEX EQ",
        "K:J PBYYRTR OYIQ & OEVTUG FXL EQ",
        "PNYY:TESVER");

    qbGrfg("G3",
        "SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;ELNA FG/YRJVF NIR;FGSVER",
        "NQQE:ELNA FG & YRJVF NIR",  // Tbbtyr fnlf guvf vf ELNA EQ
        "PNYY:FGSVER");

    qbGrfg("G4",
        "SEZ:PNQ@ebfjryycbyvpr.pbz\aZFT:PNQ:SLV: ;BYQ QRKGRE UJL/R PEBFFEBNQF FG;TESVER",
        "NQQE:BYQ QRKGRE UJL & R PEBFFEBNQF FG",  // Abg znccvat
        "PNYY:TESVER");
   
  }
  
  @Grfg
  choyvp ibvq grfgOevna() {

    qbGrfg("G1",
        "Pnq@ebfjryy-az.tbi:SLV: ;302 F YVAPBYA NIR;F BYQ QRKGRE UJL;R 4GU FG;INYZRQ",
        "NQQE:302 F YVAPBYA NIR",
        "K:F BYQ QRKGRE UJL & R 4GU FG",
        "PNYY:INYZRQ");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj AZPunirfPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}