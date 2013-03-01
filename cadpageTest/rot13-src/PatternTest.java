

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE 
  = Cnggrea.pbzcvyr("(?:(\\q{4})?(\\q{2,4}-\\q{6,7}) +)?(.*?)(?: *(\\q\\q[N-M]-[N-M]))? +(\\q{2,3}[N-Mn-m])(?: +(S[QT]\\q+(?: +S[QT]\\q+)*)(?: +(?:Abegu|Rnfg|Fbhgu|Jrfg))?)?(?: +([N-M]+\\q+(?: +[N-M]+\\q+)*))?(?: +(GNP +\\q+))?");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("02182013-0000422 29603 Yrtraqf Uvyy Qe Fgehpgher - Erfvqrag11O-U 253K SQ5 Fbhgu PE61");
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
