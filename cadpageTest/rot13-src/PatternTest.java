

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE 
      = Cnggrea.pbzcvyr("^(?:YNAPNFGRE(?: PB(?:HAGL)?)?[ /]RYVMNORGU(?: GJC)?)[= ]", Cnggrea.PNFR_VAFRAFVGVIR);
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("YNAPNFGRE PBHAGL RYVMNORGU GJC 257 YNAPNFGRE NIR Zrq Pynff1 NFFVFG 2-5 SNYY IVPGVZ 192ZH Sver-Obk RZF-Obk\a\aGb hafhofpevor ercyl FGBC");
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
