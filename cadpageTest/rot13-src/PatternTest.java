

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("R911 PYNFF: *[N-M]{1,4}\\q*(?: *YBP: .*?YNG: ([-+]?\\q+\\.\\q{6})0? *YBA: ([-+]?\\q+\\.\\q{6})(?: *Yrp:[n-m]{4})?)?");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("R911 PYNFF: IBVCYBP: 122 Ebfr YaYNG: +37.676797YBA: -084.255888Yrp:gjpoGENVYRE BA SVER PNHTUG N TNF GNAX BA SVER");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.svaq()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
