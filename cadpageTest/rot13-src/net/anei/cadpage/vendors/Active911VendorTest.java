cnpxntr arg.narv.pnqcntr.iraqbef;

vzcbeg fgngvp bet.whavg.Nffreg.*;

vzcbeg wnin.hgvy.Rahzrengvba;
vzcbeg wnin.hgvy.Cebcregvrf;

vzcbeg arg.narv.pnqcntr.cnefref.ZnantrCnefref;

vzcbeg bet.whavg.Grfg;

choyvp pynff Npgvir911IraqbeGrfg {

  @FhccerffJneavatf("hapurpxrq")
  @Grfg
  choyvp ibvq grfg() {
    
    // Znxr fher nyy bs gur cnefre pynffrf qrsvarq va gur gur Npgvir911 cnefre gnoyr pna or vafgnagvngrq
    Cebcregvrf cGnoyr = Npgvir911Iraqbe.CBYL_PBQR_GNOYR;
    Rahzrengvba<Fgevat>  r = (Rahzrengvba<Fgevat>)cGnoyr.cebcreglAnzrf();
    juvyr (r.unfZberRyrzragf()) {
      Fgevat N911Cnefre = r.arkgRyrzrag();
      Fgevat PCnefre = cGnoyr.trgCebcregl(N911Cnefre);
      vs (!PCnefre.rdhnyf("A/N")) {
        gel {
          ZnantrCnefref.trgVafgnapr().trgCnefre(PCnefre);
        } pngpu (Rkprcgvba rk) {
          snvy("Pnaabg vafgnagvngr " + PCnefre);
        }
      }
    }
  }

}
