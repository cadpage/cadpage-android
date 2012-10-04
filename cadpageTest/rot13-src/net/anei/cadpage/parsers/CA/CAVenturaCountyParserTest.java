cnpxntr arg.narv.pnqcntr.cnefref.PN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Iraghen Pbhagl, PN
Pbagnpg: Punfr Zbetna <punfrzbetna43@tznvy.pbz>
Pbagnpg: "punfrzbetna@lznvy.pbz" <punfrzbetna@lznvy.pbz>
Fraqre: SPP-QB-ABG-ERCYL@iraghen.bet
Flfgrz: VasbEnq

(SPP Cntr) Vapvqrag Qvfcngpu:G30   FGEHPGHER 905 Snyzbhgu Fg               526-W7 38/3912-0058915
(SPP Cntr) Vapvqrag Qvfcngpu:G30   GP        796 Cnfrb Qr Yrba             555-R3 38/3912-0058883
(SPP Cntr) Vapvqrag Qvfcngpu:G30   FVPX CREFB12 Pbarwb Oyiq                556-S1 38/3912-0058846

 */

choyvp pynff PNIraghenPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp PNIraghenPbhaglCnefreGrfg() {
    frgCnefre(arj PNIraghenPbhaglCnefre(), "IRAGHEN PBHAGL", "PN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(SPP Cntr) Vapvqrag Qvfcngpu:G30   FGEHPGHER 905 Snyzbhgu Fg               526-W7 38/3912-0058915",
        "HAVG:G30",
        "PNYY:FGEHPGHER",
        "NQQE:905 Snyzbhgu Fg",
        "ZNC:526-W7",
        "PU:38/39",
        "VQ:12-0058915");

    qbGrfg("G2",
        "(SPP Cntr) Vapvqrag Qvfcngpu:G30   GP        796 Cnfrb Qr Yrba             555-R3 38/3912-0058883",
        "HAVG:G30",
        "PNYY:GP",
        "NQQE:796 Cnfrb Qr Yrba",
        "ZNC:555-R3",
        "PU:38/39",
        "VQ:12-0058883");

    qbGrfg("G3",
        "(SPP Cntr) Vapvqrag Qvfcngpu:G30   FVPX CREFB12 Pbarwb Oyiq                556-S1 38/3912-0058846",
        "HAVG:G30",
        "PNYY:FVPX CREFB",
        "NQQE:12 Pbarwb Oyiq",
        "ZNC:556-S1",
        "PU:38/39",
        "VQ:12-0058846");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj PNIraghenPbhaglCnefreGrfg().trarengrGrfgf("G1", "HAVG PNYY NQQE ZNC PU VQ");
  }
}