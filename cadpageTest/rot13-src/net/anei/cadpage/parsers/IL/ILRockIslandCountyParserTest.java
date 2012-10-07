cnpxntr arg.narv.pnqcntr.cnefref.VY;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Ebpx Vfynaq Pbhagl, VY
Pbagnpg: Qneva Xrvgu <qneva.xrvgu@ubgznvy.pbz>
Fraqre: 40404,PNQ@evpbrgfo.bet
Flfgrz: Fhathneq BFFV

@EVSQ: 15221:;PENFU CREFBANY VAWHEVRF;24GU FG/18GU NI
@EVSQ: 15226:;SVER BGURE;1323 14GU FG
@EVSQ: 15227:;SVER NYNEZ;3605 11GU NI
@EVSQ: 16193:;ZRQVPNY PNYY;2300-46 79GU NI J
F: Z:67:SLV: ;FGEHPGHER SVER/TRARENY;2932 EBQZNA NI\a
F: Z:68:PNAPRY;2932 EBQZNA NI; EVN\a
F: Z:69:Hcqngr: ;SVER ZHGHNY NVQ;2932 EBQZNA NI\a
@EVSQ: 17437:;ZRQVPNY PNYY;767 30GU FG;EV

*/

choyvp pynff VYEbpxVfynaqPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VYEbpxVfynaqPbhaglCnefreGrfg() {
    frgCnefre(arj VYEbpxVfynaqPbhaglCnefre(), "EBPX VFYNAQ PBHAGL", "VY");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "@EVSQ: 15221:;PENFU CREFBANY VAWHEVRF;24GU FG/18GU NI",
        "FEP:EVSQ",
        "VQ:15221",
        "PNYY:PENFU CREFBANY VAWHEVRF",
        "NQQE:24GU FG & 18GU NI",
        "ZNQQE:24GU FG & 18GU NIR");

    qbGrfg("G2",
        "@EVSQ: 15226:;SVER BGURE;1323 14GU FG",
        "FEP:EVSQ",
        "VQ:15226",
        "PNYY:SVER BGURE",
        "NQQE:1323 14GU FG");

    qbGrfg("G3",
        "@EVSQ: 15227:;SVER NYNEZ;3605 11GU NI",
        "FEP:EVSQ",
        "VQ:15227",
        "PNYY:SVER NYNEZ",
        "NQQE:3605 11GU NI",
        "ZNQQE:3605 11GU NIR");

    qbGrfg("G4",
        "@EVSQ: 16193:;ZRQVPNY PNYY;2300-46 79GU NI J",
        "FEP:EVSQ",
        "VQ:16193",
        "PNYY:ZRQVPNY PNYY",
        "NQQE:2300-46 79GU NI J",
        "ZNQQE:2300 79GU NIR J");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre2() {

    qbGrfg("G1",
        "F: Z:67:SLV: ;FGEHPGHER SVER/TRARENY;2932 EBQZNA NI\a",
        "VQ:67",
        "PNYY:FGEHPGHER SVER/TRARENY",
        "NQQE:2932 EBQZNA NI",
        "ZNQQE:2932 EBQZNA NIR");

    qbGrfg("G2",
        "F: Z:68:PNAPRY;2932 EBQZNA NI; EVN\a",
        "VQ:68",
        "PNYY:PNAPRY - EVN",
        "NQQE:2932 EBQZNA NI",
        "ZNQQE:2932 EBQZNA NIR");

    qbGrfg("G3",
        "F: Z:69:Hcqngr: ;SVER ZHGHNY NVQ;2932 EBQZNA NI\a",
        "VQ:69",
        "PNYY:SVER ZHGHNY NVQ",
        "NQQE:2932 EBQZNA NI",
        "ZNQQE:2932 EBQZNA NIR");

    qbGrfg("G4",
        "@EVSQ: 17437:;ZRQVPNY PNYY;767 30GU FG;EV",
        "FEP:EVSQ",
        "VQ:17437",
        "PNYY:ZRQVPNY PNYY",
        "NQQE:767 30GU FG",
        "PVGL:EBPX VFYNAQ");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VYEbpxVfynaqPbhaglCnefreGrfg().trarengrGrfgf("G1", "FEP VQ PNYY NQQE PVGL");
  }
}