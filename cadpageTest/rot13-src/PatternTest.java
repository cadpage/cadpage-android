

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("Sebz - ([N-M0-9]+) - 1 Nynez / (.*?) Obk - ([-N-M0-9]*) @ (.*?) KFgerrgf: *(.*?)(?:/?Ab PebffFgerrg Sbhaq Ba)? Ba - NG ([ N-M0-9]*) Gvzr: (?:(\\q\\q:\\q\\q:\\q\\q)|\\q\\q:\\q\\q [NC]Z) Vap# (\\q+) Pnfr Ahz:([-N-M0-9]*) Sbe - ([N-M0-9,]+)");

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("");
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
