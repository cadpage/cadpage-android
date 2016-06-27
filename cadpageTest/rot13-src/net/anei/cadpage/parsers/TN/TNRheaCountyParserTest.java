cnpxntr arg.narv.pnqcntr.cnefref.GA;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/* 
Eurn Pbhagl, GA

Pbagnpg: Puneyrf Xvaarl <nefbapbc1@tznvy.pbz>
Fraqre: eurnpbga@911rznvy.arg
(R911) SVER NYNEZ\a500 JNYAHG TEBIR EQ, QNLGBA\aCYNAG 19
(R911) SVER - ERFVQRAGVNY\a2250 BYQ TENLFIVYYR EQ, QNLGBA\aCBJRE VF BHG - FNJ FCNEXF PBZVAT SEBZ GUR FVQR BS GUR UBHFR NG GUR ZRGRE
(R911) TNF YRNX\a1015 GVTHRF PERRX EQ, QNLGBA
(R911) QRNQ BA NEEVINY\a166 PUREEL UVYY QE, QNLGBA
(R911) SVER - ERFVQRAGVNY\a498 UVTUYNAQ QE, QNLGBA
(R911) SVER CBFFVOYR FZBXR VA GUR NERN\a145 EBFR FG, QNLGBA\aFZBXR VAIRFGVTNGVBA/ PNYY PNZR GUEBHTU GUR QSQ/ HAVGF BAFPA

 */

choyvp pynff GAEurnPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp GAEurnPbhaglCnefreGrfg() {
    frgCnefre(arj GAEurnPbhaglCnefre(), "EURN PBHAGL", "GA");
  }
  
  @Grfg
  choyvp ibvq grfgPuneyrfXvaarl() {

    qbGrfg("G1",
        "(R911) SVER NYNEZ\a500 JNYAHG TEBIR EQ, QNLGBA\aCYNAG 19",
        "PNYY:SVER NYNEZ",
        "NQQE:500 JNYAHG TEBIR EQ",
        "PVGL:QNLGBA",
        "VASB:CYNAG 19");

    qbGrfg("G2",
        "(R911) SVER - ERFVQRAGVNY\a2250 BYQ TENLFIVYYR EQ, QNLGBA\aCBJRE VF BHG - FNJ FCNEXF PBZVAT SEBZ GUR FVQR BS GUR UBHFR NG GUR ZRGRE",
        "PNYY:SVER - ERFVQRAGVNY",
        "NQQE:2250 BYQ TENLFIVYYR EQ",
        "PVGL:QNLGBA",
        "VASB:CBJRE VF BHG - FNJ FCNEXF PBZVAT SEBZ GUR FVQR BS GUR UBHFR NG GUR ZRGRE");

    qbGrfg("G3",
        "(R911) TNF YRNX\a1015 GVTHRF PERRX EQ, QNLGBA",
        "PNYY:TNF YRNX",
        "NQQE:1015 GVTHRF PERRX EQ",
        "PVGL:QNLGBA");

    qbGrfg("G4",
        "(R911) QRNQ BA NEEVINY\a166 PUREEL UVYY QE, QNLGBA",
        "PNYY:QRNQ BA NEEVINY",
        "NQQE:166 PUREEL UVYY QE",
        "PVGL:QNLGBA");

    qbGrfg("G5",
        "(R911) SVER - ERFVQRAGVNY\a498 UVTUYNAQ QE, QNLGBA",
        "PNYY:SVER - ERFVQRAGVNY",
        "NQQE:498 UVTUYNAQ QE",
        "PVGL:QNLGBA");

    qbGrfg("G6",
        "(R911) SVER CBFFVOYR FZBXR VA GUR NERN\a145 EBFR FG, QNLGBA\aFZBXR VAIRFGVTNGVBA/ PNYY PNZR GUEBHTU GUR QSQ/ HAVGF BAFPA",
        "PNYY:SVER CBFFVOYR FZBXR VA GUR NERN",
        "NQQE:145 EBFR FG",
        "PVGL:QNLGBA",
        "VASB:FZBXR VAIRFGVTNGVBA/ PNYY PNZR GUEBHTU GUR QSQ/ HAVGF BAFPA");
   
  }

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj GAEurnPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}
