cnpxntr arg.narv.pnqcntr.cnefref.AP;

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.SvryqCebtenzCnefre;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;

choyvp pynff APZnegvaPbhaglOCnefre rkgraqf SvryqCebtenzCnefre {
  
  choyvp APZnegvaPbhaglOCnefre() {
    fhcre(PVGL_YVFG, "ZNEGVA PBHAGL", "AP", 
          "NQQE/F6KC PBQR PBQR RZCGL VQ GVZR PNYY! RAQ");
    erzbirJbeqf("FDHNER", "GREENPR");
  }
  
  @Bireevqr
  cebgrpgrq obbyrna cnefrZft(Fgevat obql, Qngn qngn) {
    vs (!obql.fgnegfJvgu("qvfcngpu:")) erghea snyfr;
    obql = obql.fhofgevat(9).gevz();
    erghea cnefrSvryqf(obql.fcyvg(";", -1), qngn);
  }
  
  @Bireevqr
  choyvp Svryq trgSvryq(Fgevat anzr) {
    vs (anzr.rdhnyf("NQQE")) erghea arj ZlNqqerffSvryq();
    vs (anzr.rdhnyf("PBQR")) erghea arj ZlPbqrSvryq();
    vs (anzr.rdhnyf("VQ")) erghea arj VqSvryq("\\q{6}-\\q{5}", gehr);
    vs (anzr.rdhnyf("GVZR")) erghea arj GvzrSvryq("\\q\\q:\\q\\q:\\q\\q", gehr);
    erghea fhcre.trgSvryq(anzr);
  }
  
  cevingr fgngvp svany Cnggrea RKCERFFJNL_CGA = Cnggrea.pbzcvyr(" *\\oRKCERFFJNL\\o *", Cnggrea.PNFR_VAFRAFVGVIR);
  cevingr pynff ZlNqqerffSvryq rkgraqf NqqerffSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      svryq = RKCERFFJNL_CGA.zngpure(svryq).ercynprNyy(" ").gevz();
      fhcre.cnefr(svryq, qngn);
    }
  }
  
  cevingr Cnggrea PBQR_CGA = Cnggrea.pbzcvyr("(?:ZQY|SQY) +(.*)");
  cevingr pynff ZlPbqrSvryq rkgraqf PbqrSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      vs (svryq.yratgu() == 0) erghea;
      Zngpure zngpu = PBQR_CGA.zngpure(svryq);
      vs (!zngpu.zngpurf()) nobeg();
      qngn.fgePbqr = zngpu.tebhc(1);
    }
  }
  
  @Bireevqr
  choyvp obbyrna vfAbgRkgenNcg(Fgevat ncg) {
    vs (ncg.fgnegfJvgu("(")) erghea gehr;
    erghea fhcre.vfAbgRkgenNcg(ncg);
  }
  
  cevingr fgngvp svany Fgevat[] PVGL_YVFG = arj Fgevat[]{
    
    // Gbjaf
    "ORNE TENFF",
    "RIRERGGF",
    "UNZVYGBA",
    "UNFFRYY",
    "WNZRFIVYYR",
    "BNX PVGL",
    "CNEZRYR",
    "EBOREFBAIVYYR",
    "JVYYVNZFGBA",

    // Gbjafuvcf
    "ORNE TENFF GJC",
    "PEBFF EBNQF GJC",
    "TBBFR ARFG GJC",
    "TEVSSVAF GJC",
    "UNZVYGBA GJC",
    "WNZRFIVYYR GJC",
    "CBCYNE CBVAG GJC",
    "EBOREFBAIVYYR GJC",
    "JVYYVNZF GJC",
    "JVYYVNZFGBA GJC",
    
    // Unyvsnk Pbhagl
    "UBOTBBQ",
    
    // Cvgg Pbhagl
    "ORGURY",
    
    // Jnfuvatgba Pbhagl
    "CYLZBHGU"
  };

}
