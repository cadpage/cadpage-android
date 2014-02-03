cnpxntr arg.narv.pnqcntr.cnefref.IN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Fheel Pbhagl, IN

Pbagnpg: Zryvffn Oebpx <rzfopu@tznvy.pbz>
Fraqre: 7576189349

(PISQ 09) ZNVYOBK:32 HAPBAFPVBHF/HAERFCBAFVIR 000783 FHEEL YNAQVAT QE PSF# 2014-000376
(PISQ 02) ZNVYOBK:27 ZIN- ZBGBE IRUVPYR NPPVQRAG PSF# 2014-000350
(PISQ 17) ZNVYOBK:58 FGEHPGHER SVER PSF# 2014-000323
(PISQ 19) ZNVYOBK:58 BQBE BS FZBXR VA FGEHPGHER 000896 ENVYEBNQ NIR QRA PSF# 2014-000249
(PISQ 16) ZNVYOBK:55 BGURE/HAXABJA CEBOYRZ 000127 ORGUNAL NIR PSF# 2014-000177

 */
choyvp pynff INFheelPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp INFheelPbhaglCnefreGrfg() {
    frgCnefre(arj INFheelPbhaglCnefre(), "FHEEL PBHAGL", "IN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(PISQ 09) ZNVYOBK:32 HAPBAFPVBHF/HAERFCBAFVIR 000783 FHEEL YNAQVAT QE PSF# 2014-000376",
        "FEP:PISQ",
        "HAVG:09",
        "OBK:32",
        "PNYY:HAPBAFPVBHF/HAERFCBAFVIR",
        "NQQE:783 FHEEL YNAQVAT QE",
        "VQ:2014-000376");

    qbGrfg("G2",
        "(PISQ 02) ZNVYOBK:27 ZIN- ZBGBE IRUVPYR NPPVQRAG PSF# 2014-000350",
        "FEP:PISQ",
        "HAVG:02",
        "OBK:27",
        "PNYY:ZIN- ZBGBE IRUVPYR NPPVQRAG",
        "VQ:2014-000350");

    qbGrfg("G3",
        "(PISQ 17) ZNVYOBK:58 FGEHPGHER SVER PSF# 2014-000323",
        "FEP:PISQ",
        "HAVG:17",
        "OBK:58",
        "PNYY:FGEHPGHER SVER",
        "VQ:2014-000323");

    qbGrfg("G4",
        "(PISQ 19) ZNVYOBK:58 BQBE BS FZBXR VA FGEHPGHER 000896 ENVYEBNQ NIR QRA PSF# 2014-000249",
        "FEP:PISQ",
        "HAVG:19",
        "OBK:58",
        "PNYY:BQBE BS FZBXR VA FGEHPGHER",
        "NQQE:896 ENVYEBNQ NIR",
        "PVGL:QRAQEBA",
        "VQ:2014-000249");

    qbGrfg("G5",
        "(PISQ 16) ZNVYOBK:55 BGURE/HAXABJA CEBOYRZ 000127 ORGUNAL NIR PSF# 2014-000177",
        "FEP:PISQ",
        "HAVG:16",
        "OBK:55",
        "PNYY:BGURE/HAXABJA CEBOYRZ",
        "NQQE:127 ORGUNAL NIR",
        "VQ:2014-000177");

  }
  
  choyvp fgngvp ibvq znva(Fgevat netf[]) {
    arj INFheelPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}
  