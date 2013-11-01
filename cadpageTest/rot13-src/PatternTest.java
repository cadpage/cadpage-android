

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("^(?:([- N-M0-9]+) )?(?:Vp# +(.*?) +Qf# ([^ ]*?) (?:Ny# ([^ ]*?))? Hgy# (?:([^ ]*?) +)?)?");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Vp# 3 PENFU021 Qf# 125004 Ny# 1 Hgy# 72 -94 10/21/13-11351 RQVFBA EQ CR :(54600) OVEPU EQ ORGJRRA OVEPU NAQ ORRPU - HAXABJA VAWHEL NPPVQRAG 0725,014CZR13,Q13");
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
