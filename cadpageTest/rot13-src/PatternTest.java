

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("((?:ZRQVP )?[N-M0-9]+) +((?:CYRNFR|VAFREIVPR) CBFG|(?:RKPRCGVBA |SEBZ [N-M0-9]+ )?GB) +(.*)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("ZRQVP 723 CYRNFR CBFG  OYNPXFGBPX NIR/URVAF FG");
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
