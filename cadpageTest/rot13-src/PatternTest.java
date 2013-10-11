

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("(?:([N-M0-9_ ]+?) +)?(Nvecbeg|XSQ|Perfgba SQ|Rireterra SQ|Byarl SQ|Fbhgu Xnyvfcryy? +SQ|Fzvgu Inyyrl SQ|Fbzref SQ|Juvgrsvfu ?SQ|P\\.SNYYF ?SQ)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("621 FXSQ  Fbhgu Xnyvfcry SQ (Abegu) 1717 F JBBQYNAQ QE 2 Xnyvfcryy S PB Rkcbfher / Tnf Bqbe 2013-00002308");
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
