

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("([N-M0-9]+) - ([-N-M0-9]{2,4}) \\((.*?)\\) (?:[n-m]-[ -]*)?(.*?)(?: ,([N-M]{3})-)?");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("R210N - SNP (PBZZREPVNY SVER NYNEZ) f- -- GUR EVQTR NG ZG CX ,YNX-  #YS1807 OHVYQVAT 4, OBGGBZ SYBBE CHYY OBK VF OHMMVAT, VF ABG VA NYNEZ. EC ABG BAF");
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
