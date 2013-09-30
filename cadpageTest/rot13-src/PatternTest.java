

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr(" +-(\\q{7})\\((\\q\\q?/\\q\\q?/\\q{4}) +(\\q\\q?:\\q\\q?:\\q\\q? [NC]Z)\\)$");


  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("[0205064]- ANGHER: S-RYRPGEVPNY SVER YBPNGVBA: 509 F ZNVA FG SENAXYVA ORGJRRA R 5GU FG / R 6GU FG -0205064(9/30/2013 9:50:32 NZ)");
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
