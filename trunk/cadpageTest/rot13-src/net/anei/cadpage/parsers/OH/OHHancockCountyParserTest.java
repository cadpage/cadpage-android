cnpxntr arg.narv.pnqcntr.cnefref.BU;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Unapbpx Pbhagl, BU

Pbagnpg: Puevfgbcure Rnfg <rnfg911@nby.pbz>
Fraqre: qbabgercyl@pb.Unapbpx.bu.hf

,Zrqvpny/RZF, 8601 GE 128, SVAQYNL, BU  45840, PE 86//GE 89, 85 LE BYQ ZNYR SRYY VA ONEA, ERFCBAFVIR
,Zrqvpny/RZF, 7906 HF 224, SVAQYNL, BU  45840, JRFGYNAQ QE//GE 136, HAERFCBAFV
,SVER, 7746 PE 140, SVAQYNL, BU  45840, //, FBHGU FVQR BS GUR OHVYQVAT, CBJRE YVARF QBJA, NEPVAT
PENFU - VAWHEL, PE 139/GE 89, YVOREGL GJC 
,SVER, 601 RQVGU NIR, SVAQYNL, BU  45840, PBGGBAJBBQ FG//OBYGBA FG,
[29] ,Zrqvpny/RZF, 8517 GE 89, SVAQYNL, BU  45840, GE 130//PE 139, CBFF QRPRNFRQ
[4] ,PENFU - VAWHEL, GE 67/PE 313, YVOREGL GJC, //, FVATYR IRUVPYR VAWHEL NPPVQRAG, HAERFCBAFVIR QEVIRE

 */

choyvp pynff BUUnapbpxPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BUUnapbpxPbhaglCnefreGrfg() {
    frgCnefre(arj BUUnapbpxPbhaglCnefre(), "UNAPBPX PBHAGL", "BU");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        ",Zrqvpny/RZF, 8601 GE 128, SVAQYNL, BU  45840, PE 86//GE 89, 85 LE BYQ ZNYR SRYY VA ONEA, ERFCBAFVIR",
        "PNYY:Zrqvpny/RZF",
        "NQQE:8601 GE 128",
        "PVGL:SVAQYNL",
        "FG:BU",
        "K:PE 86/GE 89",
        "VASB:85 LE BYQ ZNYR SRYY VA ONEA, ERFCBAFVIR");

    qbGrfg("G2",
        ",Zrqvpny/RZF, 7906 HF 224, SVAQYNL, BU  45840, JRFGYNAQ QE//GE 136, HAERFCBAFV",
        "PNYY:Zrqvpny/RZF",
        "NQQE:7906 HF 224",
        "PVGL:SVAQYNL",
        "FG:BU",
        "K:JRFGYNAQ QE/GE 136",
        "VASB:HAERFCBAFV");

    qbGrfg("G3",
        ",SVER, 7746 PE 140, SVAQYNL, BU  45840, //, FBHGU FVQR BS GUR OHVYQVAT, CBJRE YVARF QBJA, NEPVAT",
        "PNYY:SVER",
        "NQQE:7746 PE 140",
        "ZNQQE:7746 PBHAGL EBNQ 140",
        "PVGL:SVAQYNL",
        "FG:BU",
        "VASB:FBHGU FVQR BS GUR OHVYQVAT, CBJRE YVARF QBJA, NEPVAT");

    qbGrfg("G4",
        "PENFU - VAWHEL, PE 139/GE 89, YVOREGL GJC ",
        "PNYY:PENFU - VAWHEL",
        "NQQE:PE 139 & GE 89",  
        "ZNQQE:PBHAGL EBNQ 139 & GE 89",  // Abg znccvat
        "PVGL:YVOREGL GJC");

    qbGrfg("G5",
        ",SVER, 601 RQVGU NIR, SVAQYNL, BU  45840, PBGGBAJBBQ FG//OBYGBA FG,",
        "PNYY:SVER",
        "NQQE:601 RQVGU NIR",
        "PVGL:SVAQYNL",
        "FG:BU",
        "K:PBGGBAJBBQ FG/OBYGBA FG");

    qbGrfg("G6",
        "[29] ,Zrqvpny/RZF, 8517 GE 89, SVAQYNL, BU  45840, GE 130//PE 139, CBFF QRPRNFRQ",
        "PNYY:Zrqvpny/RZF",
        "NQQE:8517 GE 89",
        "PVGL:SVAQYNL",
        "FG:BU",
        "K:GE 130/PE 139",
        "VASB:CBFF QRPRNFRQ");

    qbGrfg("G7",
        "[4] ,PENFU - VAWHEL, GE 67/PE 313, YVOREGL GJC, //, FVATYR IRUVPYR VAWHEL NPPVQRAG, HAERFCBAFVIR QEVIRE",
        "PNYY:PENFU - VAWHEL",
        "NQQE:GE 67 & PE 313",
        "ZNQQE:GE 67 & PBHAGL EBNQ 313", // Abg znccvat
        "PVGL:YVOREGL GJC",
        "VASB:FVATYR IRUVPYR VAWHEL NPPVQRAG, HAERFCBAFVIR QEVIRE");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj BUUnapbpxPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}