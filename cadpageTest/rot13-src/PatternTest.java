

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("Sebz - ?([N-M0-9]+) - ?\\q ?Nynez / ?(.*?) (?:Cev (\\q+) +)?(?:Obk|OBK|\\| ENC) - ?([-N-M0-9]*) ?@ ?(.*?) (?:\\| )?KFgerrgf: *(.*?)[ \\|]+?Ba - ?([ N-M0-9]*)\\|? Gvzr:[ \\|]*(?:(\\q\\q:\\q\\q:\\q\\q)|(\\q\\q:\\q\\q [NC]Z))[ \\|]+Vap# ?(\\q+)(?: Pnfr Ahz:([-N-M0-9]*))?[ \\|]+Sbe - ?([N-M0-9,]+)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Sebz -RFQ02 -1Nynez /Snyy Cev 4 | ENC -02-0134 @3300 Xvyyvatfjbegu Ya | KFgerrgf:R JRYYF OENAPU CXJL/OBHYQRE EVQTR | Ba -NG SPBZ R| Gvzr:19:21:59| Vap#15102036 | Sbe -DAG211");
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
