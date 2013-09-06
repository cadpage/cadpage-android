

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =       
      Cnggrea.pbzcvyr("^(\\q{7}) +(\\q\\q:\\q\\q:\\q\\q) +(\\q\\q-\\q\\q-\\q\\q) +[-N-M0-9]+ +NYCUN +\\q+ +");


  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("0001002 07:25:36 28-08-13 CBPFNT-1  NYCUN  1200 Abegu Naaivyyr Gbjafuvc 241 PYRNE FCEVAT EQ ZI - Nppvqrag j/Vawhevrf Iruvpyr if Gryrcubar Cbyr St-3 Ercynprzrag R7 R1-1  Sver-Obk 6-02 RZF-Obk 190-15 -");
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
