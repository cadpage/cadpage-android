

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE
    = Cnggrea.pbzcvyr("^(\\q\\q/\\q\\q(?:/\\q{4})?) (\\q\\q:\\q\\q)(?: ([^:]+): (.*)|: (.*) ng (.*?)(?:(?<!/)/(.*))?)$");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("03/27/2013 20:38: Iruvpyr penfu jvgu n qrre ng A  OEVPX PUHEPU EQ // YBFG ZVYR EQ/UNTREFGBJA");
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
