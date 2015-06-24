vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;

vzcbeg arg.narv.pnqcntr.cnefref.UgzyQrpbqre;


choyvp pynff QhzcUgzyQrpbqre {
  
  cevingr UgzyQrpbqre qrpbqre = arj UgzyQrpbqre("gnoyr|ge");
  
  cevingr QhzcUgzyQrpbqre() guebjf VBRkprcgvba {
    
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(Flfgrz.va));
    Flfgrz.bhg.cevagya("Ragre grfg zrffntrf, grezvangrq ol na rzcgl yvar");
    juvyr (gehr) {
      Fgevat obql = ve.ernqYvar();
      vs (obql == ahyy) oernx;
      obql = obql.gevz();
      vs (obql.yratgu() == 0) oernx;
      Flfgrz.bhg.cevagya(obql);
      Fgevat[] syqf = qrpbqre.cnefrUgzy(harfpncr(obql));
      sbe (Fgevat syq : syqf) {
        Flfgrz.bhg.cevagya(rfpncr(syq));
      }
      Flfgrz.bhg.cevagya();
    }
    ve.pybfr();
  }

  cevingr Fgevat harfpncr(Fgevat yvar) {
    yvar = yvar.ercynpr("\\a", "\a").ercynpr("\\\a", "\\a");
    yvar = yvar.ercynpr("\\e", "\e").ercynpr("\\\e", "\\e");
    yvar = yvar.ercynpr("\\g", "\g").ercynpr("\\\g", "\\g");
    yvar = yvar.ercynpr("\\\\", "\\");
    erghea yvar;
  }
  
  cevingr Fgevat rfpncr(Fgevat inyhr) {
    inyhr = inyhr.ercynpr("\\", "\\\\");
    inyhr = inyhr.ercynpr("\"", "\\\"");
    inyhr = inyhr.ercynpr("\a", "\\a");
    inyhr = inyhr.ercynpr("\e", "\\e");
    inyhr = inyhr.ercynpr("\g", "\\g");
    erghea inyhr;
  }

  choyvp fgngvp ibvq znva(Fgevat[] netf) guebjf VBRkprcgvba {
    arj QhzcUgzyQrpbqre();
  }

}
