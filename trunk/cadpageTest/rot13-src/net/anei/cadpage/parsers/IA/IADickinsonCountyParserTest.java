cnpxntr arg.narv.pnqcntr.cnefref.VN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Qvpxvafba Pbhagl, VN
Pbagnpg: Wrffr Jrypu <wtenaqvfba2004@tznvy.pbz>
Fraqre: QP911@frpherfreire.arg

QP911:ANGHER: 10-52 /YBPNGVBA: 1310 9GU FG /PBZZRAGF: 90LB ZNYR QVNORGVP VYY NAQ QVSSVPHYGL J/ VAWRPGVBAF.
QP911:ANGHER: 10-52 /YBPNGVBA: 14020 240GU NIR /PBZZRAGF: PNE IF UBHFR 1 ZNYR VAWHERQ TNF YVAR UVG.
QP911:ANGHER: 10-52 /YBPNGVBA: UJL 86/UJL 71 /PBZZRAGF: 10-50 CV 
QP911:[02-NI]- ANGHER: 52 YBPNGVBA: 107 A 3EQ FG GREEVY PBZZ RAGF: 62 LB SRZNYR NAQ URE UVC VF BHG NTNVA. GUVEQ GVZR VGF UNCCRARQ
QP911:[02-NI]- ANGHER: 52 YBPNGVBA: 2505 YVAPBYA NIR FCVEVG YNXR ORGJRRA 23EQ FG / 28GU FG PBZZRAGF: 62 LB QVNORGVP CEB OYRZ PBAPVBHF NAQ OERNGUVAT FUNXVAT O

*/

choyvp pynff VNQvpxvafbaPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VNQvpxvafbaPbhaglCnefreGrfg() {
    frgCnefre(arj VNQvpxvafbaPbhaglCnefre(), "QVPXVAFBA PBHAGL", "VN");
  }
  
  @Grfg
  choyvp ibvq grfgwrffrJrypu() {

    qbGrfg("G1",
        "QP911:ANGHER: 10-52 /YBPNGVBA: 1310 9GU FG /PBZZRAGF: 90LB ZNYR QVNORGVP VYY NAQ QVSSVPHYGL J/ VAWRPGVBAF.",
        "PNYY:10-52",
        "NQQE:1310 9GU FG",
        "VASB:90LB ZNYR QVNORGVP VYY NAQ QVSSVPHYGL J/ VAWRPGVBAF.");

    qbGrfg("G2",
        "QP911:ANGHER: 10-52 /YBPNGVBA: 14020 240GU NIR /PBZZRAGF: PNE IF UBHFR 1 ZNYR VAWHERQ TNF YVAR UVG.",
        "PNYY:10-52",
        "NQQE:14020 240GU NIR",
        "VASB:PNE IF UBHFR 1 ZNYR VAWHERQ TNF YVAR UVG.");

    qbGrfg("G3",
        "QP911:ANGHER: 10-52 /YBPNGVBA: UJL 86/UJL 71 /PBZZRAGF: 10-50 CV ",
        "PNYY:10-52",
        "NQQE:UJL 86 & UJL 71",
        "VASB:10-50 CV");

    qbGrfg("G4",
        "QP911:[02-NI]- ANGHER: 52 YBPNGVBA: 107 A 3EQ FG GREEVY PBZZ RAGF: 62 LB SRZNYR NAQ URE UVC VF BHG NTNVA. GUVEQ GVZR VGF UNCCRARQ",
        "HAVG:02-NI",
        "PNYY:52",
        "NQQE:107 A 3EQ FG",
        "PVGL:GREEVY",
        "VASB:62 LB SRZNYR NAQ URE UVC VF BHG NTNVA. GUVEQ GVZR VGF UNCCRARQ");

    qbGrfg("G5",
        "QP911:[02-NI]- ANGHER: 52 YBPNGVBA: 2505 YVAPBYA NIR FCVEVG YNXR ORGJRRA 23EQ FG / 28GU FG PBZZRAGF: 62 LB QVNORGVP CEB OYRZ PBAPVBHF NAQ OERNGUVAT FUNXVAT O",
        "HAVG:02-NI",
        "PNYY:52",
        "NQQE:2505 YVAPBYA NIR",
        "PVGL:FCVEVG YNXR",
        "K:23EQ FG / 28GU FG",
        "VASB:62 LB QVNORGVP CEB OYRZ PBAPVBHF NAQ OERNGUVAT FUNXVAT O");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VNQvpxvafbaPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}