

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("RIRAG: ([N-Mn-m]\\q{10}) 911: [:0-9]+ / NQQ: .*");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("(YPQ Zrffntr) JVAFGRQ NZO ERFCBAQ GB 6 CEBPX UVYY EQ PNZC WRJRYY, VSB ZNVA YBQTR  PBYROEBBX, , 7L Z PURFG CNVA, 10-N-1 :09:51**,42.018370879814, -73.1147161591798");
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
