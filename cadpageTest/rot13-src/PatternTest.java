

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("([N-M0-9]+):\\[[N-M0-9]+\\]");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("P039:[P039]-- 3 FGERRGF BA GUR UVYY ORUVAQ GUR SVER UBHFR VA QHEOVA WHQL PNYYRQ NAQ FNVQ UR UHFONAQ UNQ ERPGNY OYRRQVAT RNEYLRE GBQNL NAQ ABJ VF OYRRQVAT SEBZ GUNG NERN");
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
