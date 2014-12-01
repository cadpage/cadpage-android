cnpxntr arg.narv.pnqcntr.cnefref.BU;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Ybenva Pbhagl, BU
Pbagnpg: Jnlar Ynpxb <jynpxb@ebffvapvarengvba.pbz>
Fraqre: pnq@ybenvapb911.pbz

PNQ:SLV: ;RZF SVEFG ERFCBAQREF;11401 ZNEGUN QE;PNE
PNQ:SLV: ;RZF SVEFG ERFCBAQREF;11406 VAQVNA UBYYBJ EQ;PNE
PNQ:SLV: ;RZF NZOHYNAPR;1935 TENSGBA EQ;PNE
PNQ:Hcqngr: ;PNE SVER;HF EG 20;ZZ 11
PNQ:PNAPRY;11401 ZNEGUN QE; PNE
PNQ:SLV: ;RZF SVEFG ERFCBAQREF;11401 ZNEGUN QE;PNE

Pbagnpg: wbua lbfg <wbualbfg228@tznvy.pbz>
Fraqre: PNQ@jvaqfgernz.arg
(SLV) PNQ:;ZIN EBYYBIRE;EG 10 R/O OL BFC;QVFG: 153.07 sg
(Hcqngr) PNQ:;FZBXR VA GUR NERN;35440 R EBLNYGBA EQ;QVFG: QVFG: 16.61 sg;RNG
(SLV) PNQ:;FZBXR VA GUR NERN;12435 NINYBA QE;QVFG: QVFG: 16.61 sg;RNG

 */
choyvp pynff BUYbenvaPbhaglNCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BUYbenvaPbhaglNCnefreGrfg() {
    frgCnefre(arj BUYbenvaPbhaglNCnefre(), "YBENVA PBHAGL", "BU");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "PNQ:SLV: ;RZF SVEFG ERFCBAQREF;11401 ZNEGUN QE;PNE",
        "PNYY:RZF SVEFG ERFCBAQREF",
        "NQQE:11401 ZNEGUN QE",
        "PVGL:PNEYVFYR GJC");

    qbGrfg("G2",
        "PNQ:SLV: ;RZF SVEFG ERFCBAQREF;11406 VAQVNA UBYYBJ EQ;PNE",
        "PNYY:RZF SVEFG ERFCBAQREF",
        "NQQE:11406 VAQVNA UBYYBJ EQ",
        "PVGL:PNEYVFYR GJC");

    qbGrfg("G3",
        "PNQ:SLV: ;RZF NZOHYNAPR;1935 TENSGBA EQ;PNE",
        "PNYY:RZF NZOHYNAPR",
        "NQQE:1935 TENSGBA EQ",
        "PVGL:PNEYVFYR GJC");

    qbGrfg("G4",
        "PNQ:Hcqngr: ;PNE SVER;HF EG 20;ZZ 11",
        "PNYY:PNE SVER",
        "NQQE:HF EG 20",
        "ZNQQE:HF 20",
        "CYNPR:ZZ 11");

    qbGrfg("G5",
        "PNQ:PNAPRY;11401 ZNEGUN QE; PNE",
        "PNYY:PNAPRY",
        "NQQE:11401 ZNEGUN QE",
        "PVGL:PNEYVFYR GJC");

    qbGrfg("G6",
        "PNQ:SLV: ;RZF SVEFG ERFCBAQREF;11401 ZNEGUN QE;PNE",
        "PNYY:RZF SVEFG ERFCBAQREF",
        "NQQE:11401 ZNEGUN QE",
        "PVGL:PNEYVFYR GJC");
 
  }
  
  @Grfg
  choyvp ibvq grfgWbuaLbfg() {

    qbGrfg("G1",
        "(SLV) PNQ:;ZIN EBYYBIRE;EG 10 R/O OL BFC;QVFG: 153.07 sg",
        "PNYY:ZIN EBYYBIRE",
        "NQQE:EG 10 R & O OL BFC",
        "CYNPR:QVFG: 153.07 sg");

    qbGrfg("G2",
        "(Hcqngr) PNQ:;FZBXR VA GUR NERN;35440 R EBLNYGBA EQ;QVFG: QVFG: 16.61 sg;RNG",
        "PNYY:FZBXR VA GUR NERN",
        "NQQE:35440 R EBLNYGBA EQ",
        "CYNPR:QVFG: QVFG: 16.61 sg",
        "PVGL:RNGBA");

    qbGrfg("G3",
        "(SLV) PNQ:;FZBXR VA GUR NERN;12435 NINYBA QE;QVFG: QVFG: 16.61 sg;RNG",
        "PNYY:FZBXR VA GUR NERN",
        "NQQE:12435 NINYBA QE",
        "CYNPR:QVFG: QVFG: 16.61 sg",
        "PVGL:RNGBA");
    
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj BUYbenvaPbhaglNCnefreGrfg().trarengrGrfgf("G1");
  }
}