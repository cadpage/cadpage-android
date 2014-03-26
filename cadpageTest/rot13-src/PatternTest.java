

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("^VAPVQ?RAG PNYY(?: -?([N-M]+)[,;]?)? ");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg(" VAPVQRAG PNYY -JVAZNYRR ERFCBAQ GB GERR QBJA JVAZNYRR YBBX BHG UNJXRFOHEL EBNQ JVAZNYRR 445 NFFVFGVAT SVERPBZZ 16-Sro-2014 14:37:28");
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
