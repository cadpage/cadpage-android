

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("(.*?)((?: [N-M]?\\q+)+)  (.*?) Dhnqenag: (.*?) (\\q\\q/\\q\\q/\\q\\q) (\\q\\q:\\q\\q) Aneengvir:(.*?)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("(WPSQ5) OYF N51  267 BEPNF QE 14 Dhnqenag: Qvfpb Prageny 502 10/16/13 07:38 Aneengvir:  HANOYR GB HEVANGR  50 LBS  R911 Vasb - Pynff bs Freivpr: OHFA Fcrpvny Erfcbafr Vasb: CFNC=WRSSJN--QVFPBIREL ONL WPFB  QVFPB 51  QVFPB RZF 51");
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
