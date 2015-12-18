cnpxntr arg.narv.pnqcntr.cnefref.FP;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Ynapnfgre Pbhagl, FP

Pbagnpg: Npgvir911
Ntrapl anzr: Ynapnfgre Pbhagl Sver Freivpr
Ybpngvba: Ynapnfgre, FP, Havgrq Fgngrf
Fraqre: PNQ@YnapnfgrePvglFP.pbz

{QVFCNGPU} Nppvqrag - J/Vawhevrf-Va Cebterff-JLYVR FG@ J ONEE FG , YNAPNFGRE \a NPPVQRAG 
{QVFCNGPU} Nppvqrag - J/Vawhevrf-Va Cebterff-805 FGNGR UJL 9 OLC, YNAPNFGRE \aJNY-ZNEG NPPVQRAG 
{QVFCNGPU} Nppvqrag - J/Vawhevrf-Va Cebterff-1205 A ZNVA FG, YNAPNFGRE \aOBWNATYRF  
{QVFCNGPU} Nppvqrag - Ab Vawhevrf-Va Cebterff-500 OYX J ZRRGVAT FG \a  

*/

choyvp pynff FPYnapnfgrePbhaglPCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp FPYnapnfgrePbhaglPCnefreGrfg() {
    frgCnefre(arj FPYnapnfgrePbhaglPCnefre(), "YNAPNFGRE PBHAGL", "FP");
  }

  @Grfg
  choyvp ibvq grfgYnapnfgrePbhaglSverFreivpr() {

    qbGrfg("G1",
        "{QVFCNGPU} Nppvqrag - J/Vawhevrf-Va Cebterff-JLYVR FG@ J ONEE FG , YNAPNFGRE \a NPPVQRAG",
        "PNYY:Nppvqrag - J/Vawhevrf",
        "NQQE:JLYVR FG & J ONEE FG",
        "PVGL:YNAPNFGRE",
        "VASB:NPPVQRAG");

    qbGrfg("G2",
        "{QVFCNGPU} Nppvqrag - J/Vawhevrf-Va Cebterff-805 FGNGR UJL 9 OLC, YNAPNFGRE \aJNY-ZNEG NPPVQRAG",
        "PNYY:Nppvqrag - J/Vawhevrf",
        "NQQE:805 FGNGR UJL 9 OLC",
        "ZNQQE:805 FGNGR 9 OLCNFF",
        "PVGL:YNAPNFGRE",
        "VASB:JNY-ZNEG NPPVQRAG");

    qbGrfg("G3",
        "{QVFCNGPU} Nppvqrag - J/Vawhevrf-Va Cebterff-1205 A ZNVA FG, YNAPNFGRE \aOBWNATYRF",
        "PNYY:Nppvqrag - J/Vawhevrf",
        "NQQE:1205 A ZNVA FG",
        "PVGL:YNAPNFGRE",
        "VASB:OBWNATYRF");

    qbGrfg("G4",
        "{QVFCNGPU} Nppvqrag - Ab Vawhevrf-Va Cebterff-500 OYX J ZRRGVAT FG \a",
        "PNYY:Nppvqrag - Ab Vawhevrf",
        "NQQE:500 OYX J ZRRGVAT FG",
        "ZNQQE:500  J ZRRGVAT FG");

  }

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj FPYnapnfgrePbhaglPCnefreGrfg().trarengrGrfgf("G1");
  }
}