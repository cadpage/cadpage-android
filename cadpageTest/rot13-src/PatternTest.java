

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("PCS:NGGZB([-+]?\\q{1,3}\\.\\q{5,6})([-+]?\\q{1,3}\\.\\q{5,6})PBS:\\q+PBC:\\q+(?:PNYYOX=(\\(740\\)\\q{3}-\\q{4}))?");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("PCS:NGGZB+039.45268-082.24182PBS:0PBC:0PNYYOX=(740)677-3183FRPGVBABSJNYAHGHCBAUVTUFG.ORUVAQGURUBHFR,OHVYQVATHFRQGBORN");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.ybbxvatNg()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }
  
  cevingr fgngvp ibvq purpxZngpu(Fgevat grfg) {
    vs (!ZNFGRE.zngpure(grfg).zngpurf()) {
      Flfgrz.bhg.cevagya(grfg + " Qbrf abg zngpu");
    }
  }
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
