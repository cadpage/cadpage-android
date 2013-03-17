cnpxntr arg.narv.pnqcntr.cnefref.IN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Senaxyva Pbhagl, IN
Pbagnpg: Evpxl Tevmmneq <evpxltevmmneq@tznvy.pbz>
Fraqre: 777

PVGL BS SENAXYVA qyrqorggre:32417 EVIREQNYR QE SENAXYVA 00:09:03 ERFPHR RZF- NC RYQREYL SRZNYR PURFG CNVAF,ABG ERFCBAQVAT,AHEFR BA QHGL NG ERFVQRAPR
PVGL BS SENAXYVA zugheare:16 PERFPRAG QE SENAXYVA A UVTU FG K ZPPHGPURBA FG 14:40:37 ERFPHR RZF- NC ZRQVPNY NYNEZ
PVGL BS SENAXYVA nwhfghf:1401 A UVTU FG Ez 1007 SENAXYVA BNXJBBQ QE K PVGL YVZVGF 05:40:29 ERFPHR RZF- NC ryqreyl srznyr frirer abfr oyrrq
PVGL BS SENAXYVA zugheare:117 ORRPUJBBQ QE SENAXYVA BNXJBBQ QE K A UVTU FG 18:02:51 ERFPHR RZF- NC 74 LB SRZNYR - CBFFVOYR FGEBXR

*/

choyvp pynff INSenaxyvaCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp INSenaxyvaCnefreGrfg() {
    frgCnefre(arj INSenaxyvaCnefre(), "SENAXYVA", "IN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "PVGL BS SENAXYVA qyrqorggre:32417 EVIREQNYR QE SENAXYVA 00:09:03 ERFPHR RZF- NC RYQREYL SRZNYR PURFG CNVAF,ABG ERFCBAQVAT,AHEFR BA QHGL NG ERFVQRAPR",
        "NQQE:32417 EVIREQNYR QE",
        "PVGL:SENAXYVA",
        "GVZR:00:09:03",
        "PNYY:ERFPHR RZF- NC",
        "VASB:RYQREYL SRZNYR PURFG CNVAF,ABG ERFCBAQVAT,AHEFR BA QHGL NG ERFVQRAPR");

    qbGrfg("G2",
        "PVGL BS SENAXYVA zugheare:16 PERFPRAG QE SENAXYVA A UVTU FG K ZPPHGPURBA FG 14:40:37 ERFPHR RZF- NC ZRQVPNY NYNEZ",
        "NQQE:16 PERFPRAG QE",
        "PVGL:SENAXYVA",
        "K:A UVTU FG / ZPPHGPURBA FG",
        "GVZR:14:40:37",
        "PNYY:ERFPHR RZF- NC ZRQVPNY NYNEZ");

    qbGrfg("G3",
        "PVGL BS SENAXYVA nwhfghf:1401 A UVTU FG Ez 1007 SENAXYVA BNXJBBQ QE K PVGL YVZVGF 05:40:29 ERFPHR RZF- NC ryqreyl srznyr frirer abfr oyrrq",
        "NQQE:1401 A UVTU FG",
        "NCG:1007",
        "PVGL:SENAXYVA",
        "K:BNXJBBQ QE / PVGL YVZVGF",
        "GVZR:05:40:29",
        "PNYY:ERFPHR RZF- NC",
        "VASB:ryqreyl srznyr frirer abfr oyrrq");

    qbGrfg("G4",
        "PVGL BS SENAXYVA zugheare:117 ORRPUJBBQ QE SENAXYVA BNXJBBQ QE K A UVTU FG 18:02:51 ERFPHR RZF- NC 74 LB SRZNYR - CBFFVOYR FGEBXR",
        "NQQE:117 ORRPUJBBQ QE",
        "PVGL:SENAXYVA",
        "K:BNXJBBQ QE / A UVTU FG",
        "GVZR:18:02:51",
        "PNYY:ERFPHR RZF- NC",
        "VASB:74 LB SRZNYR - CBFFVOYR FGEBXR");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj INSenaxyvaCnefreGrfg().trarengrGrfgf("G1");
  }
}
