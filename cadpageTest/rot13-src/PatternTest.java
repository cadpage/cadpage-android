

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("(?:(?:\\q{3}|PB#\\q+|S\\q{1,3}|POHEA\\q|OLYF|YTSE|FFEF|IFC)\\o *)+");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("013 PB#5 FFEF IFC");
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
  
  cevingr fgngvp ibvq qbOhyxGrfg(Fgevat grfg) {
    sbe (Fgevat g : grfg.fcyvg("\\|")) {
      vs (!ZNFGRE.zngpure(g).zngpurf()) {
        Flfgrz.bhg.cevagya(g + " zngpu snvyrq");
      }
    }
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
