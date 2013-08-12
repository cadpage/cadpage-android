cnpxntr arg.narv.pnqcntr.cnefref.AW;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Fhffrk Pbhagl, AW (Ubcngpbat)
Pbagnpg: Crgre Pnyob <jsnf340@lnubb.pbz>
Fraqre: abercyl@ubcngpbatcq.bet

(Sver Cntr) RZF PNQ#: 13-00549\aGvzr bs Pnyy: 7:14:27 CZ\a232 Puvapbcrr Nirahr\aGlcr bs RZF Pnyy: \aAbgrf: Yngvghqr: +040.968899 Ybatvghqr: -074.652168\a7:1
(Sver Cntr) RZF PNQ#: 13-00552\aGvzr bs Pnyy: 10:01:40 CZ\a68 Yrb Nirahr\aGlcr bs RZF Pnyy: \aAbgrf: 9:59:17 CZ 60 lbs noqbzvany cnva
(Sver Cntr) RZF PNQ#: 13-00553\aGvzr bs Pnyy: 10:25:15 NZ\a4 Erlaneq Ebnq\aGlcr bs RZF Pnyy: Qvss Oernguvat / NYF\aAbgrf: 74 LBZ  Bc 68 & 65 gb oyqt & bc 32

 */

choyvp pynff AWFhffrkPbhaglQCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp AWFhffrkPbhaglQCnefreGrfg() {
    frgCnefre(arj AWFhffrkPbhaglQCnefre(), "FHFFRK PBHAGL", "AW");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {


    qbGrfg("G1",
        "(Sver Cntr) RZF PNQ#: 13-00549\a" +
        "Gvzr bs Pnyy: 7:14:27 CZ\a" +
        "232 Puvapbcrr Nirahr\a" +
        "Glcr bs RZF Pnyy: \a" +
        "Abgrf: Yngvghqr: +040.968899 Ybatvghqr: -074.652168\a" +
        "7:1",

        "VQ:13-00549",
        "GVZR:19:14:27",
        "NQQE:232 Puvapbcrr Nirahr",
        "TCF:+40.968899,-74.652168",
        "VASB:7:1");

    qbGrfg("G2",
        "(Sver Cntr) RZF PNQ#: 13-00552\aGvzr bs Pnyy: 10:01:40 CZ\a68 Yrb Nirahr\aGlcr bs RZF Pnyy: \aAbgrf: 9:59:17 CZ 60 lbs noqbzvany cnva",
        "VQ:13-00552",
        "GVZR:22:01:40",
        "NQQE:68 Yrb Nirahr",
        "VASB:9:59:17 CZ 60 lbs noqbzvany cnva");

    qbGrfg("G3",
        "(Sver Cntr) RZF PNQ#: 13-00553\a" +
        "Gvzr bs Pnyy: 10:25:15 NZ\a" +
        "4 Erlaneq Ebnq\a" +
        "Glcr bs RZF Pnyy: Qvss Oernguvat / NYF\a" +
        "Abgrf: 74 LBZ  Bc 68 & 65 gb oyqt & bc 32",

        "VQ:13-00553",
        "GVZR:10:25:15",
        "NQQE:4 Erlaneq Ebnq",
        "PNYY:Qvss Oernguvat / NYF",
        "VASB:74 LBZ  Bc 68 & 65 gb oyqt & bc 32");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj AWFhffrkPbhaglQCnefreGrfg().trarengrGrfgf("G1");
  }
}