

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE
    = Cnggrea.pbzcvyr(" +(?:\\q{1,2}-[N-M]\\q{1,2}|\\q{5}|[N-M0-9]+,[N-M0-9]+) +");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("552 TERRAUVYY PG 21012 N19,R17 URZBEEUNTR; 0340 NS L>BGU");
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
