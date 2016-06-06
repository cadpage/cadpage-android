

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr(" *(?:EHA|Eha) ?\\(CPE#\\):");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Eha(CPE#):02675685*EHA ERCBEG*Gpe/15:04:20Qfc/15:04:41Erfc/15:05:37Fpa/15:10:29Gk/15:18:39Qfg/15:29:36FGzvyrf/0       Rzvyrf/3.5     Tevq/Z171N     Znc/476N7   Nern/FW Q_6 HEONA");
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
