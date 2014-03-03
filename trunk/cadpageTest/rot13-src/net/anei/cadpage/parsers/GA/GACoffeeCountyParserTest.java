cnpxntr arg.narv.pnqcntr.cnefref.TN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Pbssrr Pbhagl, TN
Pbagnpg: Qnyr Zreevgg <qzreevggwe309@tznvy.pbz>
Fraqre: 911-PRAGRE@pbssrrpbhagltbi.pbz

911-PRAGRE:1070F > SVER FGEHPGHER 402 A ZPQBANYQ NIR 3310694 R JNEQ FG
911-PRAGRE:1050V > NPPVQRAG JVGU VAWHEVRF PUREEL/ CRGREFBA 3839024
911-PRAGRE:1050V > NPPVQRAG JVGU VAWHEVRF 706 J ONXRE UJL F CRGREFBA NIR
911-PRAGRE:1050V > NPPVQRAG JVGU VAWHEVRF OBJRAF ZVYY EQ / BYQ ORYY YX 4329619
911-PRAGRE:1070F > SVER FGEHPGHER 809 Z Y X QE 3092493 R PBYYRTR CNEX QE

*/

choyvp pynff TNPbssrrPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp TNPbssrrPbhaglCnefreGrfg() {
    frgCnefre(arj TNPbssrrPbhaglCnefre(), "PBSSRR PBHAGL", "TN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "911-PRAGRE:1070F > SVER FGEHPGHER 402 A ZPQBANYQ NIR 3310694 R JNEQ FG",
        "PBQR:1070F",
        "PNYY:SVER FGEHPGHER",
        "NQQE:402 A ZPQBANYQ NIR",
        "K:R JNEQ FG",
        "CUBAR:3310694");

    qbGrfg("G2",
        "911-PRAGRE:1050V > NPPVQRAG JVGU VAWHEVRF PUREEL/ CRGREFBA 3839024",
        "PBQR:1050V",
        "PNYY:NPPVQRAG JVGU VAWHEVRF",
        "NQQE:PUREEL & CRGREFBA",
        "CUBAR:3839024");

    qbGrfg("G3",
        "911-PRAGRE:1050V > NPPVQRAG JVGU VAWHEVRF 706 J ONXRE UJL F CRGREFBA NIR",
        "PBQR:1050V",
        "PNYY:NPPVQRAG JVGU VAWHEVRF",
        "NQQE:706 J ONXRE UJL",
        "K:F CRGREFBA NIR");

    qbGrfg("G4",
        "911-PRAGRE:1050V > NPPVQRAG JVGU VAWHEVRF OBJRAF ZVYY EQ / BYQ ORYY YX 4329619",
        "PBQR:1050V",
        "PNYY:NPPVQRAG JVGU VAWHEVRF",
        "NQQE:OBJRAF ZVYY EQ & BYQ ORYY YNXR EQ",
        "CUBAR:4329619");

    qbGrfg("G5",
        "911-PRAGRE:1070F > SVER FGEHPGHER 809 Z Y X QE 3092493 R PBYYRTR CNEX QE",
        "PBQR:1070F",
        "PNYY:SVER FGEHPGHER",
        "NQQE:809 Z Y X QE",
        "ZNQQE:809 ZNEGVA YHGURE XVAT QE",
        "K:R PBYYRTR CNEX QE",
        "CUBAR:3092493");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj TNPbssrrPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}
