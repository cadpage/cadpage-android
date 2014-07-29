

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("RIRAG: ([N-Mn-m]\\q{10}) 911: [:0-9]+ / NQQ: .*");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("RIRAG: I2014011404 911: 16:29:13 / NQQ: 16:30:27 / QVFC: 16:30:50 / RAEBHGR: 16:31:36 / NEEVIR: 16:34:46 / GE: / GN: NI 1648");
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
