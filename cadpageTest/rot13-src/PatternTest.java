

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = Cnggrea.pbzcvyr("\\f*\\o(?:R911 Vasb .*)(?:(35\\.\\q{4,} +-77\\.\\q{4,})|-361 +-361)$");

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("");
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
