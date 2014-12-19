

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("((?:PNAPRY|PKY)(?: NAL)?(?: SHEGURE ERF?CBAFR| ERFCBAFR| PNYY(?: PKY)?)?)[-:/ ]*");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("PKY SHEGURE ERCBAFR - ERFBEG NG TBIREABEF PEBFFVAT 225 PBYYVRE QE FRIVREIVYYR; UHEYRL QE K ENVAOBJ EQ; 2014-0048487; PBZZREPVNY SVER NYNEZ NPGVINGVBA");
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

}
