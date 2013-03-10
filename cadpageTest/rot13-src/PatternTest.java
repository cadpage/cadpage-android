

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE 
  = Cnggrea.pbzcvyr("(?:IREVMBA(?: JVERYRFF)?|NGG? ?& ?G(?: ZBOVYVGL)?|NGGZB|G-ZBOVYR|FCEVAG(?:CPF)?|HF PRYYHYNE|ZRGEB ?CPF)\\o.*", Cnggrea.PNFR_VAFRAFVGVIR);  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("NGG&G");
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
