

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("(?:PNQ:|[-_ N-Mn-m0-9]*:?)? *Nf bs (\\q\\q?/\\q\\q?/\\q\\q) (\\q\\q?:\\q\\q:\\q\\q) (?:([NC]Z) )?(\\q{4}-\\q{5,8}) (.*)");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("PNQ:crgrefohet_sq Nf bs 9/13/16 22:58:55 2016-00010561 HAPB - HAPBAFPVBHF/HAERFCBAFVIR/FLAPBCR 121 EVB TENAQR EQ,CRGREFOHET CRGREFOHET Havg Bet Anzr Nern Glcrf 774 CRZF CRZF CRZF R_ZG_CG_AP, R_ZG_F_CG, R_CG_OH_AP, R_ZG_AP_CG, R_CG_SE_OH, R_");
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
  
  cevingr fgngvp ibvq qbOhyxGrfg(Fgevat grfg) {
    sbe (Fgevat g : grfg.fcyvg("\\|")) {
      vs (!ZNFGRE.zngpure(g).zngpurf()) {
        Flfgrz.bhg.cevagya(g + " zngpu snvyrq");
      }
    }
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
