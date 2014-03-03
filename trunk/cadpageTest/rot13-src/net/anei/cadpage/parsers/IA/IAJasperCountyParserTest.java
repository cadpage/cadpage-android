cnpxntr arg.narv.pnqcntr.cnefref.VN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Wnfcre Pbhagl, VN

Pbagnpg: Npgvir911
Ntrapl anzr: Ernfabe Sver Qrcnegzrag
Ybpngvba: Ernfabe, VN, Havgrq Fgngrf
Fraqre: <wnfcre911@vbjngryrpbz.arg>

(Qvfcngpu Vasb) Ercbegrq: 10/25/2013 19:26:34\a 13-028048 Z/I NPPVQRAG CREFBANY VAWHEL \a Ybp: R RQTR BS ERNFABE ,  \a 31 NYF1 ESQ
(Qvfcngpu Vasb) Ercbegrq: 10/19/2013 20:16:43\a 13-027551 SVER-ZVFP SVER PNYYF \a Ybp: 1093 F 72AQ NIR R ARJGBA,VN 50208 \a UJL F 74 F / QRNQRAQ \a E1093 F 72 NIR R \a ESQ
(Qvfcngpu Vasb) Ercbegrq: 10/19/2013 19:47:48\a 13-027547 SVER-ZVFP SVER PNYYF \a Ybp: 8914 J 24GU FG F ZBAEBR,VN 50170 \a F 80 NIR J / UJL S 62 J J \a E8914 J 24 FG F \a 31 ZBSQ CPSQ ESQ

 */

choyvp pynff VNWnfcrePbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VNWnfcrePbhaglCnefreGrfg() {
    frgCnefre(arj VNWnfcrePbhaglCnefre(), "WNFCRE PBHAGL", "VN");
  }

  @Grfg
  choyvp ibvq grfgErnfabeSverQrcnegzrag() {

    qbGrfg("G1",
        "(Qvfcngpu Vasb) Ercbegrq: 10/25/2013 19:26:34\a 13-028048 Z/I NPPVQRAG CREFBANY VAWHEL \a Ybp: R RQTR BS ERNFABE ,  \a 31 NYF1 ESQ",
        "QNGR:10/25/2013",
        "GVZR:19:26:34",
        "VQ:13-028048",
        "PNYY:Z/I NPPVQRAG CREFBANY VAWHEL",
        "NQQE:R RQTR BS",
        "PVGL:ERNFABE",
        "HAVG:31 NYF1 ESQ");

    qbGrfg("G2",
        "(Qvfcngpu Vasb) Ercbegrq: 10/19/2013 20:16:43\a" +
        " 13-027551 SVER-ZVFP SVER PNYYF \a" +
        " Ybp: 1093 F 72AQ NIR R ARJGBA,VN 50208 \a" +
        " UJL F 74 F / QRNQRAQ \a" +
        " E1093 F 72 NIR R \a" +
        " ESQ",

        "QNGR:10/19/2013",
        "GVZR:20:16:43",
        "VQ:13-027551",
        "PNYY:SVER-ZVFP SVER PNYYF",
        "NQQE:1093 F 72AQ NIR R",
        "PVGL:ARJGBA",
        "K:UJL F 74 F / QRNQRAQ",
        "HAVG:E1093 F 72 NIR R");

    qbGrfg("G3",
        "(Qvfcngpu Vasb) Ercbegrq: 10/19/2013 19:47:48\a" +
        " 13-027547 SVER-ZVFP SVER PNYYF \a" +
        " Ybp: 8914 J 24GU FG F ZBAEBR,VN 50170 \a" +
        " F 80 NIR J / UJL S 62 J J \a" +
        " E8914 J 24 FG F \a" +
        " 31 ZBSQ CPSQ ESQ",

        "QNGR:10/19/2013",
        "GVZR:19:47:48",
        "VQ:13-027547",
        "PNYY:SVER-ZVFP SVER PNYYF",
        "NQQE:8914 J 24GU FG F",
        "PVGL:ZBAEBR",
        "K:F 80 NIR J / UJL S 62 J J",
        "HAVG:E8914 J 24 FG F");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VNWnfcrePbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}