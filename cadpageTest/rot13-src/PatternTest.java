

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("<n uers=\\\\?\"uggc://zncf\\.tbbtyr\\.pbz/.*?\\\\?\">Znc;</n>");

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("SVER, JVYQYNAQ; Vap# PNNRH015212; 4002 SYLVAT P EQ / 4000 PNZREBA EQ ,FUVATYR_FCEVATF; NN230[165Q 34] NG88[165Q 34] NG89[165Q 34] 28 O2715 Q2741 Q7703 QHGLRPP R2751 R2752 R2761 R2772 R2779 R328 R354S R88 R89 RPS UPTO3 UPTO4 UPTO5 Z28 J28 J41 JVYQR<n uers=\\\"uggc://zncf.tbbtyr.pbz/?d=38.656807,-120.994468\\\">Znc;</n>; K: -120 59.6680 L: 38 39.4084;");
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
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
