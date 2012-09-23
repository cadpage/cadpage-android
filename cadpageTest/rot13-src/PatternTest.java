

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("Vap# (\\q+):(?:([^@]+)@)?(.+?), *([N-M_]+) *:Znc  ([^:]*): YNG/YBAT K: ([-+ \\.\\q]+) +L: ([-+ \\.\\q]+)");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("(PNQ Cntr) Vap# 007104: ANGHENY OEVQTRF @ =Y(38.051636,-120.470996) ,PNYNIRENF_PBHAGL :Znc  509/37O_005: YNG/YBAT K: -120 28.2597  L: 38 3.09816: ZRQ, GENSSVP PBYYVFVBA: ZIN: 24 22 R4452");
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
