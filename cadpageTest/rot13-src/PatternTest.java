

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("\a+Gb hafhofpevor .*$", Cnggrea.PNFR_VAFRAFVGVIR);


  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("GRFG NYREG\a\a\a\a\a\a\aGb hafhofpevor sebz guvf tebhc naq fgbc erprvivat rznvyf sebz vg, fraq na rznvy gb grfgcntr+hafhofpevor@punysbagrzf.bet.\a\a\a\a--\a\a\a\a\a\a");
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
