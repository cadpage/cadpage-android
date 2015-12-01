

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("(.*) - Sebz [N-M0-9]+ (\\q\\q?/\\q\\q?/\\q{4}) (\\q\\q:\\q\\q:\\q\\q)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("3422 YHQTNGR EQ, ONY, 45-70, QJRYYVAT SVER, OBK, R45, R29, FD40, R52, R44, G12, G25, Z17, OP5, OP3 (ogja UVTUTNGR QE naq PYBIRE EQ), OS150161374 - Sebz NQ01 11/29/2015 21:31:21");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.zngpurf()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
