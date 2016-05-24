

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("(?:PNAPRY|PNAPRYY?RQ|PNYY PNAPRYY?RQ)[ -N-M0-9]*\a");

  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("PNAPRYYRQ OL R02 BA FPRAR\a1503 CBGBZNP NIR, PIF CUNEZNPL # 1435 - [ABEGUREA NIR - PVGL YVZVG HC GB PBEGYNAQ QE] - CVP, CREF VAWHEL PBYYVFVBA, CRQ FGEHPX - R02,PB27,E75,C751,EFDR272 - CebDN Qrgrezvanag: 29N01 - **OYF-NYCUN* 1fg cnegl pnyyre jvgu vawhel gb ABG QNATREBHF obql nern R161310012 1610190 06:51");
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
