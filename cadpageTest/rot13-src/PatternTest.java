

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("^(?:Pnyy\\f*#\\f*((?:[N-M]?\\q{2}-|[N-M]{2})?\\q+?)?)?\\f*(?:\\-\\f*(.+?)\\-\\f+)?\\f*(\\q\\q?/\\q\\q?/\\q{4})\\f+(\\q{2}:\\q{2}:\\q{2})\\f*(?:(Ybpngvba|Zrffntr):\\f*(.*?))?$");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Pnyy#  -ZRQVPNY- 4/10/2015 10:14:23       Ybpngvba: \\Y 1905 QBIR PEBFFVAT");
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
