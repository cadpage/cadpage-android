

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE 
  = Cnggrea.pbzcvyr("\\*\\* RZQ (?:Pnfr Ragel Svavfurq|Pnfr Pbzcyrgr|Erpbzzraqrq Qvfcngpu) \\*\\*|\\oErfcbafr Grkg:|\\oXrl Dhrfgvbaf:|\\oTrb Pbzzrag:|\\oYnaqznex Pbzzrag:|Aneengvir ?:|\\o(?=Pebff Fgerrgf:|Ynaqznex:|AOU:)|Cynpr Pbzzrag:|  +|\a", Cnggrea.PNFR_VAFRAFVGVIR);
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("** RZQ Pnfr Ragel Svavfurq ** Puvrs Pb");
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
