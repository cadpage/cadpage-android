

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("\\[([N-M0-9]+): *([^\\]]+?)\\] ([^~]+?)~([^~]+?)~([^#\\.]+?)\\.?#([^~]*?)~([^~]*?)~([N-M0-9]+)");
      
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("[PNF: 250-2] PNF,NZE1,PFC1,FNET,PFH~GENSS NPP HAX VAWHEVRF~8180 J 24 UJL.#~ABEGU CBYR FNAGNF JBEXFUBC~PNF217800");
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
