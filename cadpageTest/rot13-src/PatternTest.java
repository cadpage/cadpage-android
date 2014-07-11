

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("((?:N|SN|SQ|SZ|SE)\\q+?(?=[\\.| N-M]|10-)|ZSQ|ZEF|VPEF|FSQ|AVEF)[\\. ]*+([^,]+?), *([^,]*)(?:, *(\\q{2}-\\q{5,6}))?");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("SQ11 .P-5 SVER NYNEZ, 210 PNCR PBQ JNL");
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
