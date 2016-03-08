cnpxntr arg.narv.pnqcntr.cnefref.PN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Fna Qvrtb Pbhagl, PN (Q)
 
Pbagnpg: ebokpneevr@nby.pbz <ebokpneevr@nby.pbz>
Fraqre: zihpnq@sver.pn.tbi

Fhowrpg:PNQ Cntr\aVap# 004944: 405 YN PERFGN URVTUGF EQ ,PERFG ; Pzq: 10O; Gnp: 10R: E/N N1U: :Znc  1252_U_2/2639N: ZRQVPNY: PC: R7218 Z7296
Fhowrpg:PNQ Cntr\aVap# 004423: 160 GNFUN IVRJ JL ,PERFG ; Pzq: 10O; Gnp: 10R: E/N N1U: :Znc  1252_W_1/2739P: ZRQVPNY: SNYY: R7218 Z7296 NVE G
Fhowrpg:PNQ Cntr\aVap# 004231: V 8 UJL R / 1190 GNIREA EQ ,NYCVAR ; Pzq: KFQ PZQ 1; Gnp: PQS GNP 5: E/N Z6: :Znc  1233_W_5/2843P: SVER, JVYQY
Fhowrpg:PNQ Cntr\aVap# 006280: 8365 CNENQVFR INYYRL EQ ,FNA_ZVTHRY ; Pzq: 10O; Gnp: 10R: E/N FZT16: :Znc  1290_W_5/1531N: ZRQVPNY: NG XSP/ OE

 */

choyvp pynff PNFnaQvrtbPbhaglQCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp PNFnaQvrtbPbhaglQCnefreGrfg() {
    frgCnefre(arj PNFnaQvrtbPbhaglQCnefre(), "FNA QVRTB PBHAGL", "PN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "Fhowrpg:PNQ Cntr\a" +
        "Vap# 004944: 405 YN PERFGN URVTUGF EQ ,PERFG ; Pzq: 10O; Gnp: 10R: E/N N1U: :Znc  1252_U_2/2639N: ZRQVPNY: PC: R7218 Z7296",

        "VQ:004944",
        "NQQE:405 YN PERFGN URVTUGF EQ",
        "ZNQQE:405 YA PERFGN URVTUGF EQ",
        "PVGL:PERFG",
        "PU:Pzq: 10O; Gnp: 10R: E/N N1U",
        "ZNC:1252_U_2/2639N",
        "PNYY:ZRQVPNY - PC",
        "HAVG:R7218 Z7296");

    qbGrfg("G2",
        "Fhowrpg:PNQ Cntr\a" +
        "Vap# 004423: 160 GNFUN IVRJ JL ,PERFG ; Pzq: 10O; Gnp: 10R: E/N N1U: :Znc  1252_W_1/2739P: ZRQVPNY: SNYY: R7218 Z7296 NVE G",

        "VQ:004423",
        "NQQE:160 GNFUN IVRJ JL",
        "PVGL:PERFG",
        "PU:Pzq: 10O; Gnp: 10R: E/N N1U",
        "ZNC:1252_W_1/2739P",
        "PNYY:ZRQVPNY - SNYY",
        "HAVG:R7218 Z7296 NVE G");

    qbGrfg("G3",
        "Fhowrpg:PNQ Cntr\a" +
        "Vap# 004231: V 8 UJL R / 1190 GNIREA EQ ,NYCVAR ; Pzq: KFQ PZQ 1; Gnp: PQS GNP 5: E/N Z6: :Znc  1233_W_5/2843P: SVER, JVYQY",

        "VQ:004231",
        "NQQE:V 8 UJL R & 1190 GNIREA EQ",
        "ZNQQE:V 8 R & 1190 GNIREA EQ",
        "PVGL:NYCVAR",
        "PU:Pzq: KFQ PZQ 1; Gnp: PQS GNP 5: E/N Z6",
        "ZNC:1233_W_5/2843P",
        "PNYY:SVER, JVYQY");

    qbGrfg("G4",
        "Fhowrpg:PNQ Cntr\a" +
        "Vap# 006280: 8365 CNENQVFR INYYRL EQ ,FNA_ZVTHRY ; Pzq: 10O; Gnp: 10R: E/N FZT16: :Znc  1290_W_5/1531N: ZRQVPNY: NG XSP/ OE",

        "VQ:006280",
        "NQQE:8365 CNENQVFR INYYRL EQ",
        "PVGL:FNA ZVTHRY",
        "PU:Pzq: 10O; Gnp: 10R: E/N FZT16",
        "ZNC:1290_W_5/1531N",
        "PNYY:ZRQVPNY - NG XSP/ OE");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj PNFnaQvrtbPbhaglQCnefreGrfg().trarengrGrfgf("G1");
  }
}