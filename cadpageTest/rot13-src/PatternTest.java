

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("(?:Ybpngvba Fnirq ol YbpngrPnyy - YY\\([-+\\q:\\.,]+?\\))(?: RFG \\q+)?(?: JCU\\q)?");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Ybpngvba Fnirq ol YbpngrPnyy - YY(31:12:23.8320,-97:17:40.5601): RFG 596 YNXR FG GEBL JVYY OR ABEGU BS GEBL ORGJRRA OVT RYZF NAQ GEBL BA GUR AO FVQR AB FGEHPGHERF ARNEOL NCCEBK 15 SRRG SYNZRF NAQ FZBXR");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.svaq()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }

}
