

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("\\(([N-M0-9, ]+)\\) *([N-M0-9]+-[N-M]+) (?:\\((Nynez Glcr [-N-M0-9 ]+)\\) *)?(?:\\(Obk ([-N-M0-9]+)\\) *)?([-N-M0-9 ]+?) *\\. *(?:(ARNE [- N-M0-9]+)\\. *)?(?:\\(KFge +([-N-M0-9/ ]*)\\) *)?(?:\\.([-N-M0-9 /\\.]+)\\. *)?#(S\\q+)");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("(JNVG671, JNVG672, GRNG664) CSN-FCEAXYE (Nynez Glcr GUREZNY/FZ) (Obk -P67-4) JRFGOEVQTR ERFVQRAGVNY FPUBBY 488R QBA OHPX EQ ZNFFRL. ARNE ORNHPUNZC EQ. (KFge ORNHPUNZC QE/EHFU PERRX QE) #S1268862");
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
