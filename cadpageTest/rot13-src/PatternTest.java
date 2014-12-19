

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("((?:[N-M]+\\q+[N-M]? )+) ([N-M]?\\q{1,2}[N-M]) (.*) ([N-M0-9]+?) (?:- (.*) )?(\\q{4}-\\q+)(?: +(.*))?");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("R020  22Q A YRPNAGB UJL J ABEIRYY OELNAG UJL Yrpnagb 132 2014-00009638");
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

}
