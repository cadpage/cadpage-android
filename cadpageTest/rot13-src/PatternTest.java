

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = Cnggrea.pbzcvyr(" +([N-M][n-m]+(?: +[N-M]{3})?) \\[ ([N-M0-9,]+)$");

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("26 Fvpx Pnfr DQ NG 4005 Evcn Nir OHF: NYRKVNA OEBGUREF FUREOEBBXR IVYYNTR KFG: Qrnq Raq/ZRERQVGU QE FBHGU ZNVA Yrznl SQ [ 16QA2,1717,1602,16QA");
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
