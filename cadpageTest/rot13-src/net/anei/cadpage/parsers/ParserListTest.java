cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg fgngvp bet.whavg.Nffreg.*;

vzcbeg arg.narv.pnqcntr.cnefref.ZnantrCnefref;
vzcbeg arg.narv.pnqcntr.cnefref.CnefreYvfg.CnefrePngrtbel;
vzcbeg arg.narv.pnqcntr.cnefref.CnefreYvfg.CnefreRagel;

vzcbeg bet.whavg.Grfg;

choyvp pynff CnefreYvfgGrfg {

  @Grfg
  choyvp ibvq grfg() {
    
    // Znxr fher nyy bs gur cnefre pynffrf qrsvarq va gur cnefre yvfg gnoyr pna or vafgnagvngrq
    purpxCnefref(CnefreYvfg.ZNFGRE_YVFG);
  }

  cevingr ibvq purpxCnefref(CnefrePngrtbel cPngrtbel) {
    vs (cPngrtbel == ahyy) erghea;
    sbe (CnefreRagel cRagel : cPngrtbel.trgCnefreYvfg()) {
      purpxCnefref(cRagel.trgPngrtbel());
      Fgevat cAnzr = cRagel.trgCnefreAnzr();
      vs (cAnzr != ahyy) {
        gel {
          ZnantrCnefref.trgVafgnapr().trgCnefre(cAnzr);
        } pngpu (Rkprcgvba rk) {
          snvy("Pnaabg vafgnagvngr " + cAnzr);
        }
      }
    }
  }
}
