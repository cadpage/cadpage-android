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

Ebpx Vfynaq Pbhagl, VY
Pbagnpg: Qneva Xrvgu <qneva.xrvgu@ubgznvy.pbz>
Fraqre: PNQ@evpbrgfo.bet

F: Z:91:SLV: ;3130 9GU FG;FGEHPGHER SVER/TRARENY;EV 
F: Z:90:Hcqngr: ;2626 EBQZNA NI;FGEHPGHER SVER/TRARENY;EVN 
F: Z:93:SLV: ;2932 EBQZNA NI;FGEHPGHER SVER/TRARENY;EVN 

Pbagnpg: Wvz Barl <wvzbarl95@lnubb.pbz>
Fraqre: PNQ@evpbrgfo.bet
417:SLV: ;28424 38GU NI A;PBHAGL RZF BAYL;UVY
416:SLV: ;27521 94GU NI A;PBHAGL RZF BAYL;UVY
F: Z:417:SLV: ;28424 38GU NI A;PBHAGL RZF BAYL;UVY 

*/

choyvp pynff VYEbpxVfynaqPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VYEbpxVfynaqPbhaglCnefreGrfg() {
    frgCnefre(arj VYEbpxVfynaqPbhaglCnefre(), "EBPX VFYNAQ PBHAGL", "VY");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "F: Z:91:SLV: ;3130 9GU FG;FGEHPGHER SVER/TRARENY;EV ",
        "VQ:91",
        "NQQE:3130 9GU FG",
        "PNYY:FGEHPGHER SVER/TRARENY",
        "PVGL:EBPX VFYNAQ");

    qbGrfg("G2",
        "F: Z:90:Hcqngr: ;2626 EBQZNA NI;FGEHPGHER SVER/TRARENY;EVN ",
        "VQ:90",
        "NQQE:2626 EBQZNA NI",
        "ZNQQE:2626 EBQZNA NIR",
        "PNYY:FGEHPGHER SVER/TRARENY",
        "PVGL:EBPX VFYNAQ NEFRANY");

    qbGrfg("G3",
        "F: Z:93:SLV: ;2932 EBQZNA NI;FGEHPGHER SVER/TRARENY;EVN ",
        "VQ:93",
        "NQQE:2932 EBQZNA NI",
        "ZNQQE:2932 EBQZNA NIR",
        "PNYY:FGEHPGHER SVER/TRARENY",
        "PVGL:EBPX VFYNAQ NEFRANY");
  
  }
  
  @Grfg
  choyvp ibvq WvzBarl() {

    qbGrfg("G1",
        "417:SLV: ;28424 38GU NI A;PBHAGL RZF BAYL;UVY",
        "VQ:417",
        "NQQE:28424 38GU NI A",
        "ZNQQE:28424 38GU NIR A",
        "PNYY:PBHAGL RZF BAYL",
        "PVGL:UVYYFQNYR");

    qbGrfg("G2",
        "416:SLV: ;27521 94GU NI A;PBHAGL RZF BAYL;UVY",
        "VQ:416",
        "NQQE:27521 94GU NI A",
        "ZNQQE:27521 94GU NIR A",
        "PNYY:PBHAGL RZF BAYL",
        "PVGL:UVYYFQNYR");
  
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VYEbpxVfynaqPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}