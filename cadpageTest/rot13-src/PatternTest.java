

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("InaprPbhagl911:(?:YvarPbhag=\\q+ +)?(?:(\\q{4}-\\q{6}) +)?(.*?)(?: +Yvar\\q+=)*$");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("InaprPbhagl911:YvarPbhag=18 400 EVPR EQ URAQREFBA FGEHPGHER SVER OP-1,RATA2,UISQ,Z1,GISQ,IPEF Yvar16= Yvar17= Yvar18=");
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
