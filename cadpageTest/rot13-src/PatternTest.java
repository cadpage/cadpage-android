

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("(.*?) ([N-M]{4,5}\\q{10}) (?:(\\q{1,2}[N-M]\\q{1,2}[N-M]?) \\q+ )?(.*?) ([N-M]+\\q+) (\\q\\q/\\q\\q/\\q{4}) (\\q\\q:\\q\\q:\\q\\q)(\\q\\q/\\q\\q/\\q{4} \\q\\q:\\q\\q:\\q\\q)*");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("A Fu 6 & J Yvggyr Lbex Eq PSIA Fu 6 & J Yvggyr Lbex Eq PSISQ2016017860 29O05 77084 ZIN Haxabja Fvghngvba PS17Q 09/10/2016 12:38:0209/10/2016 12:38:0209/10/2016 12:39:06SQ2016017860 29O05 77084 ZIN Haxabja Fvghngvba PS17Q 09/10/2016 12:38:0209/10/2016 12:38:0209/10/2016 12:39:06");
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
