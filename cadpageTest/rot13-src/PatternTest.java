

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("([N-M0-9]{1,5}) *(\\q{3}) Hgy# (\\q{3} [N-M]) ([- N-M0-9]+) / (.*?)[ /]+([N-M]+\\q+(?: ?, ?[N-M]+\\q+)*)");



  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("ZRQ3 005 Hgy# 338 Q 08/27/13 7940 R YBBF QE CI / A GBAGB JL LF//70S TYS QRPERNFRQ YBP//UK OBAR PNAPRE// R53 ,YY1");
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
