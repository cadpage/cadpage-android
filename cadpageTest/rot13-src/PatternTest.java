

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("(PU *\\q+) ([N-M]+) (?:NFFVTA:|NFFVTA SBE ) *(?:([N-M0-9,. ]+?)(?: NERN BS | - ))(.*?) (?v)(?:[-/]|SBE N |SBE (?:ERCBEG BS )?)(.*)", Cnggrea.PNFR_VAFRAFVGVIR);
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("PU1 ERF NFFVTA: R10, R2, R9, R5, N9, O7 - 12183 F ZNTTVR YA, YNF ONENAPNF NERN SBE ERCBEG BS CBFF PNEOBA ZBABKVQR, BPPHCNAGF RINPHNGRQ");
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
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
