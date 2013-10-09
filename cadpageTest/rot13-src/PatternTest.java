

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("\\f*(?:R911 Vasb .*)?(?:(3[45]\\.\\q{4,} +-7[67]\\.\\q{4,})|-361 +-361)$");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("ers #  o3702705 bcre 417  pnyyrq va ol nynez pbzc sver nynez pbzvat sebz gur ragel jnl k4  erf bs zvxr fznfny  34.9730731060001 -76.967750343");
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
