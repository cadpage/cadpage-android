

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("^(?:(\\q{2,4}-\\q{6,7}) +)?(?:(\\q{8} \\q{8}|0 0) +)?(.*?)(?: *(\\q\\q[N-M]-?[N-M]))? *(?:ABG SBH|((?:JBBQYN|01&03-)?\\q{2,4}[N-Mn-m])(?: +(S[QT] ?\\q+(?: +S[QT] ?\\q+)*))?)$");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("15-041482 30389428 95593646 11047 Svefg Yvtug Jngre Erfphr 05QU 125G");
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
