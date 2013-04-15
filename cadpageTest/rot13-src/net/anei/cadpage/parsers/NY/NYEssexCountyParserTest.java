cnpxntr arg.narv.pnqcntr.cnefref.AL;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;


/*
Rffrk Pbhagl, AL
Pbagnpg: Xreba Puneyrf <xreba.puneyrf001@tznvy.pbz>

(Wnl) WISQ:2013:12\aQVFCNGPURQ\aRZF\a1, zvyr FJ vag. bs NhFnoyr Qe. & FE 86 - AJ ;Wnl A
[Wnl]  WISQ:2013:10\aQVFCNGPURQ\aNynez-Sver
[Wnl]  WISQ:2013:9\aQVFCNGPURQ\aSver-Sver
(Wnl) WISQ:2013:13\aQVFCNGPURQ\aSver\aNHFNOYR
(Wnl) WISQ:2013:15\aQVFCNGPURQ\aSver\a70 ORRPU FG

*/

choyvp pynff ALRffrkPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp ALRffrkPbhaglCnefreGrfg() {
    frgCnefre(arj ALRffrkPbhaglCnefre(), "RFFRK PBHAGL", "AL");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(Wnl) WISQ:2013:12\aQVFCNGPURQ\aRZF\a1, zvyr FJ vag. bs NhFnoyr Qe. & FE 86 - AJ ;Wnl A",
        "FEP:WISQ",
        "VQ:2013:12",
        "PNYY:RZF",
        "NQQE:1",
        "PVGL:zvyr FJ vag. bs NhFnoyr Qe. & FE 86 - AJ ;Wnl A");

    qbGrfg("G2",
        "[Wnl]  WISQ:2013:10\aQVFCNGPURQ\aNynez-Sver",
        "FEP:WISQ",
        "VQ:2013:10",
        "PNYY:Nynez-Sver");

    qbGrfg("G3",
        "[Wnl]  WISQ:2013:9\aQVFCNGPURQ\aSver-Sver",
        "FEP:WISQ",
        "VQ:2013:9",
        "PNYY:Sver-Sver");

    qbGrfg("G4",
        "(Wnl) WISQ:2013:13\aQVFCNGPURQ\aSver\aNHFNOYR",
        "FEP:WISQ",
        "VQ:2013:13",
        "PNYY:Sver",
        "NQQE:NHFNOYR");

    qbGrfg("G5",
        "(Wnl) WISQ:2013:15\aQVFCNGPURQ\aSver\a70 ORRPU FG",
        "FEP:WISQ",
        "VQ:2013:15",
        "PNYY:Sver",
        "NQQE:70 ORRPU FG");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj ALRffrkPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}