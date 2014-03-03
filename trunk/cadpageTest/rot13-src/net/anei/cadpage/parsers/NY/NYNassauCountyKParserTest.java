cnpxntr arg.narv.pnqcntr.cnefref.AL;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Anffnh Pbhagl, AL (X)

PBagnpg: Cuvy A. <cavpbyn@angpn.arg>
Fraqre: cntvat1@svererfphrflfgrzf.kbubfg.pbz

300 ERFPHR \a3862 CNEX NIR\a** PF: SHYGBA NIR / WNPXFBA NIR \a\aGBN: 10:05 01-30-14 \a2014-000051
320 ERFPHR - QVSS. OERNGUVAT \a2529 NQNZF PG\a** PF: OELNAG QE / QRNQ RAQ \a\aGBN: 21:59 01-29-14 \a2014-000050
300 ERFPHR \a3864 ZREEVPX EQ\a** PF: F FRNZNAF ARPX EQ / CRANGVDHVG NIR \a\aGBN: 13:34 01-29-14 \a2014-000049 \a** ZNMR-YVXR PBAQVGVBAF VA O
350 ERFPHR - SNYY \a3754 PUNEYRF PG\a** PF: FRNZNAF ARPX EQ / QRNQ RAQ \a\aGBN: 07:24 01-29-14 \a2014-000048

 */

choyvp pynff ALAnffnhPbhaglXCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp ALAnffnhPbhaglXCnefreGrfg() {
    frgCnefre(arj ALAnffnhPbhaglXCnefre(), "ANFFNH PBHAGL", "AL");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre1() {

    qbGrfg("G1",
        "300 ERFPHR \a3862 CNEX NIR\a** PF: SHYGBA NIR / WNPXFBA NIR \a\aGBN: 10:05 01-30-14 \a2014-000051",
        "PNYY:300 ERFPHR",
        "NQQE:3862 CNEX NIR",
        "K:SHYGBA NIR / WNPXFBA NIR",
        "GVZR:10:05",
        "QNGR:01-30-14",
        "VQ:2014-000051");

    qbGrfg("G2",
        "320 ERFPHR - QVSS. OERNGUVAT \a2529 NQNZF PG\a** PF: OELNAG QE / QRNQ RAQ \a\aGBN: 21:59 01-29-14 \a2014-000050",
        "PNYY:320 ERFPHR - QVSS. OERNGUVAT",
        "NQQE:2529 NQNZF PG",
        "K:OELNAG QE / QRNQ RAQ",
        "GVZR:21:59",
        "QNGR:01-29-14",
        "VQ:2014-000050");

    qbGrfg("G3",
        "300 ERFPHR \a" +
        "3864 ZREEVPX EQ\a" +
        "** PF: F FRNZNAF ARPX EQ / CRANGVDHVG NIR \a\a" +
        "GBN: 13:34 01-29-14 \a" +
        "2014-000049 \a" +
        "** ZNMR-YVXR PBAQVGVBAF VA O",

        "PNYY:300 ERFPHR",
        "NQQE:3864 ZREEVPX EQ",
        "K:F FRNZNAF ARPX EQ / CRANGVDHVG NIR",
        "GVZR:13:34",
        "QNGR:01-29-14",
        "VQ:2014-000049",
        "VASB:ZNMR-YVXR PBAQVGVBAF VA O");

    qbGrfg("G4",
        "350 ERFPHR - SNYY \a3754 PUNEYRF PG\a** PF: FRNZNAF ARPX EQ / QRNQ RAQ \a\aGBN: 07:24 01-29-14 \a2014-000048",
        "PNYY:350 ERFPHR - SNYY",
        "NQQE:3754 PUNEYRF PG",
        "K:FRNZNAF ARPX EQ / QRNQ RAQ",
        "GVZR:07:24",
        "QNGR:01-29-14",
        "VQ:2014-000048");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj ALAnffnhPbhaglXCnefreGrfg().trarengrGrfgf("G1");
  }

}