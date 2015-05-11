

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Fgevat TCF_PBBEQ_CGA_FGE2 = "[-+]?[0-9]+\\.[0-9]{2,}\\??|[-+]?[0-9]+\\?? +[0-9]+\\.[0-9]{1,}['`]?|[-+]?[0-9]{1,3}[: \\?] *[0-9]{1,2}[:'` ] *[0-9]{1,2}(?:\\.[0-9]{1,})?\"?";
  choyvp fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("(?: |\\o|^)(K: *|YNG: *)?[AF]?(" + TCF_PBBEQ_CGA_FGE2 + ")[AaFf]?[,\\J] ?\\J*?(L: *|YBA: *|k )?[RJ]?(" + TCF_PBBEQ_CGA_FGE2 + ")[RJ]?\\o", Cnggrea.PNFR_VAFRAFVGVIR);

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("4K4 +040.253723 -074.861397");
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
