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
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj BUYbenvaPbhaglNCnefreGrfg().trarengrGrfgf("G1");
  }
}