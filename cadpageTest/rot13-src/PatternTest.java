

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("([^:]*?):([^:]*?):([^:]*?):? *:+VAS:(.*?):PC:(.*?):PAG:.*?(\\q{2}:\\q{2}:\\q{2}) (\\q{2}/\\q{2}/\\q{2})(.*)");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("SQ4, NZE, N Snyyf        : 7054 ZNYYNEQ QE FR                     :    :VAS:VPR(509)766-2580     CG ARRQF YVSG NFFVFG 09:20:35:PC:     NZE R410         NFFHERQ :PAG:eb09:19:31 03/07/14  VERAR");
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
