

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("(\\q\\q\\.\\q\\q\\.\\q\\q) (\\q\\q/\\q\\q/\\q\\q) (.*?) ([N-M]{2}SQ|NZE|NYF)((?: +[N-M]+\\q+[N-M]?)+)( +.*)?");



  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("14.40.11 09/18/13 RZE ERQ 611 F 44GU NIR; RVFRAUBJRE UVTU FPUBBY NYF  LX93N NYF3 BCRA YVAR. ABGUVAT FNVQ/URNEQ AB UVFG ZNYR FNLF UR UNF SNYYRA NAQ PNAABG TRG HC EC NQI UR VF BA 40GU ARNE SBBGONYY SVRYQ ZNYR FNLVAT UR VF XEVCCYRQ");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevag(grfg);
    vs (! zngpu.svaq()) {
      Flfgrz.bhg.cevag(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevag(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }

}
