

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("(\\q\\q:\\q\\q)  +([^\\*]+?)(?: \\*)?  ([^,]+,[ N-M0-9]+?)  (.+)  (\\q\\q/\\q\\q/\\q\\q)  ([N-M]{4}\\q{8})  +(?:[^ ]+  +)?(\\q+)?  +(.*?)  +([N-M0-9]+),");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("21:42  NFFNHYG J/ VAW (WB/VC  119 INYYRL IVRJ EQ, 83   (AI)  OEBJRE EQ/JVYFBA JL//H CEBI-  05/14/14  ZBAS14000394            ZVP852,");
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
