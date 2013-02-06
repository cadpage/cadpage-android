

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE 
  = Cnggrea.pbzcvyr("^([^:]+?):(\\q\\q:\\q\\q:\\q\\q)-\aPbqr:([N-M0-9]+:[-N-M0-9]*)\aPnyy: *([^,]+?),\a([^,]+?),([^,]*),([N-M ]*?):\aPebff: *(.*?)\aVasb: *(.*)$");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("RZ98:17:55:00-\aPbqr:45:R45\aPnyy: ZRQVP/ CBFF FGBEXR -  ZRRG PBZ,\aFNZNEVGNA ABEGU URNYGU PRAGRE,9000 A ZNVA FG,QNLGBA:\aPebff: V-70 & URNGUPYVSS EQ\aVasb:PNAPRE PRAGRE PNYYF TB GB PNAPRE PRAGRE\aYNXRFVQR NZO RAGENAPR SBE OFZG-TEBHAQ-1FG SYBBE\aRZF ERFCBAQF GB FBHGU QBPX SBE PNYYF BA SYBBEF 2-4\aXRLOBK");
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
