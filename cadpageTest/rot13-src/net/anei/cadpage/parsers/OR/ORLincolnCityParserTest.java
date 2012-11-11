cnpxntr arg.narv.pnqcntr.cnefref.BE;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*    
Yvapbya Pvgl, BE
Pbagnpg: Naqerj Pbbcre <naqerj.pbbcre1@yvir.pbz>
Fraqre: Tebhc_Cntr_Abgvsvpngvba@hfnzbovyvgl.arg

HAXZRQ1 AYS () Ybp:1550 FR 14GU FG: 5 Epiq: 12:10:54 Havgf: Q1141 R12133366 Pbzzragf: 75 LB SRZNYR FRIRER ZVTENAR URNQNP
SVERF AYS () Ybp:1543 AR 14GU FG Epiq: 20:57:13 Havgf: P1161 R12129759 Pbzzragf: FGEHPGHER SVER ULQR CNEX [75]
JNGRE1 AYS () Ybp:AJ YBTNA EQ & NPPRFF Epiq: 13:51:1 Havgf: Q1141 R12130984 Pbzzragf: 3 XVQF BHG FHESVAT 200 LNEQF FBHG
SNYY1 AYS () Ybp:175 FVYRGM UJ Epiq: 00:10:35 Havgf: D1636 R12127387 Pbzzragf: ZRQVPF ERDHRFGVAT NFFVFG JVGU YVSG NFFVFG
NPP1 AYS () Ybp:AR 20GU CY & AR JRFG QRIVYF YNXR EQ Epiq: 12:40:26 Havgf: Q1141 R12112828 Pbzzragf: FVATYR IRU ZIN HAX VAWHEL YVTUG FZBXR SEBZ

*/

choyvp pynff BEYvapbyaPvglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BEYvapbyaPvglCnefreGrfg() {
    frgCnefre(arj BEYvapbyaPvglCnefre(), "YVAPBYA PVGL", "BE");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "HAXZRQ1 AYS () Ybp:1550 FR 14GU FG: 5 Epiq: 12:10:54 Havgf: Q1141 R12133366 Pbzzragf: 75 LB SRZNYR FRIRER ZVTENAR URNQNP",
        "PNYY:HAXZRQ1 AYS",
        "NQQE:1550 FR 14GU FG",
        "NCG:5",
        "GVZR:12:10:54",
        "HAVG:Q1141 R12133366",
        "VASB:75 LB SRZNYR FRIRER ZVTENAR URNQNP");

    qbGrfg("G2",
        "SVERF AYS () Ybp:1543 AR 14GU FG Epiq: 20:57:13 Havgf: P1161 R12129759 Pbzzragf: FGEHPGHER SVER ULQR CNEX [75]",
        "PNYY:SVERF AYS",
        "NQQE:1543 AR 14GU FG",
        "GVZR:20:57:13",
        "HAVG:P1161 R12129759",
        "VASB:FGEHPGHER SVER ULQR CNEX [75]");

    qbGrfg("G3",
        "JNGRE1 AYS () Ybp:AJ YBTNA EQ & NPPRFF Epiq: 13:51:1 Havgf: Q1141 R12130984 Pbzzragf: 3 XVQF BHG FHESVAT 200 LNEQF FBHG",
        "PNYY:JNGRE1 AYS",
        "NQQE:AJ YBTNA EQ & NPPRFF",  // Abg znccvat
        "GVZR:13:51:1",
        "HAVG:Q1141 R12130984",
        "VASB:3 XVQF BHG FHESVAT 200 LNEQF FBHG");

    qbGrfg("G4",
        "SNYY1 AYS () Ybp:175 FVYRGM UJ Epiq: 00:10:35 Havgf: D1636 R12127387 Pbzzragf: ZRQVPF ERDHRFGVAT NFFVFG JVGU YVSG NFFVFG",
        "PNYY:SNYY1 AYS",
        "NQQE:175 FVYRGM UJ",
        "ZNQQE:175 FVYRGM UJL",
        "GVZR:00:10:35",
        "HAVG:D1636 R12127387",
        "VASB:ZRQVPF ERDHRFGVAT NFFVFG JVGU YVSG NFFVFG");

    qbGrfg("G5",
        "NPP1 AYS () Ybp:AR 20GU CY & AR JRFG QRIVYF YNXR EQ Epiq: 12:40:26 Havgf: Q1141 R12112828 Pbzzragf: FVATYR IRU ZIN HAX VAWHEL YVTUG FZBXR SEBZ",
        "PNYY:NPP1 AYS",
        "NQQE:AR 20GU CY & AR JRFG QRIVYF YNXR EQ",
        "GVZR:12:40:26",
        "HAVG:Q1141 R12112828",
        "VASB:FVATYR IRU ZIN HAX VAWHEL YVTUG FZBXR SEBZ");

  }
  
  choyvp fgngvp ibvq znva(Fgevat netf[]) {
    arj BEYvapbyaPvglCnefreGrfg().trarengrGrfgf("G1");
  }
}