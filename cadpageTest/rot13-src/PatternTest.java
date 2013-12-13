

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("\\oCebDN (?:Zrqvpny|Sver) (?:Dhrfgvbaanver Pbzcyrgrq;|Xrl Dhrfgvbaf unir orra pbzcyrgrq;|Qvfcngpu Zrffntr Frag;)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("CebDN Zrqvpny Xrl Dhrfgvbaf unir orra pbzcyrgrq; Qvfc Qvfcngpu Pbqr:");
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
