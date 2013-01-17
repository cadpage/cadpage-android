

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("(.*) ERFCBAQ GB (.*?)(,|,? +(\\q{1,2}-[N-M]-\\q{1,2}|UBG|NYCUN)) *(:|--)(\\q\\q:\\q\\q)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("ZRQVP 4 ERFCBAQ GB 30 CNEX YNAR RNFG   ARJ ZVYSBEQ, ,   HAPBAFPVBHF, 31-Q-3 :09:22");
    qbGrfg("ARJ UNEGSBEQ NZO ERFCBAQ GB 13 JNYYRAF FGERRG   JVAPURFGRE, , 46 Z OERNGUVAT CEBOYRZ, UBG :19:41");
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
