

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr(" *\\oR911 Vasb - Pynff bs Freivpr: [N-M]+ Fcrpvny Erfcbafr Vasb: HAP= .* Hapregnvagl: +Pbasvqrapr: *");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("R911 Vasb - Pynff bs Freivpr: ERFQ Fcrpvny Erfcbafr Vasb: HAP=         FBHGU UHGPUVAFBA PVGL YVZVGF Hapregnvagl:  Pbasvqrapr:");
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
