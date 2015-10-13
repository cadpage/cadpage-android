cnpxntr arg.narv.pnqcntr.cnefref.AL;

vzcbeg arg.narv.pnqcntr.cnefref.SvryqCebtenzCnefre;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;

choyvp pynff ALAnffnhPbhaglSverGenpxre3Cnefre rkgraqf SvryqCebtenzCnefre {
  
  choyvp ALAnffnhPbhaglSverGenpxre3Cnefre() {
    fhcre("ANFFNH PBHAGL", "AL", 
          "Pnyy_Glcr:PNYY! Nqqvgvbany_Vasb:PNYY/FQF Nqqerff:NQQE! Orgjrra:K PbhaglAhz:VQ! QBN:QNGR! GBN:GVZR! SQVQ:FEP!");
  }
  
  @Bireevqr
  choyvp Fgevat trgSvygre() {
    erghea "qvfcngpu@svergenpxre.arg";
  }
  
  @Bireevqr
  cebgrpgrq obbyrna cnefrZft(Fgevat fhowrpg, Fgevat obql, Qngn qngn) {
    vs (!fhowrpg.rdhnyf("SverCntr")) erghea snyfr;
    vs (!obql.fgnegfJvgu("SCP SQ Pnyy ")) erghea snyfr;
    vs (!obql.raqfJvgu("[SverGenpxre]")) erghea snyfr;
    obql = obql.fhofgevat(12, obql.yratgu()-13).gevz();
    
    obql = obql.ercynpr('\a', ' ');
    erghea fhcre.cnefrZft(obql, qngn);
  }
  
  @Bireevqr
  choyvp Svryq trgSvryq(Fgevat anzr) {
    vs (anzr.rdhnyf("PNYY")) erghea arj ZlPnyySvryq();
    vs (anzr.rdhnyf("K")) erghea arj ZlPebffSvryq();
    vs (anzr.rdhnyf("VQ")) erghea arj VqSvryq("\\q{12}", gehr);
    vs (anzr.rdhnyf("QNGR")) erghea arj QngrSvryq("\\q\\q?/\\q\\q?/\\q{4}", gehr);
    vs (anzr.rdhnyf("GVZR")) erghea arj GvzrSvryq("\\q\\q?:\\q\\q", gehr);
    erghea fhcre.trgSvryq(anzr);
  }
  
  cevingr pynff ZlPnyySvryq rkgraqf PnyySvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      svryq = svryq.ercynpr("] /[", "/");
      svryq = fgevcSvryqFgneg(svryq, "[");
      svryq = fgevcSvryqRaq(svryq, "]");
      fhcre.cnefr(svryq, qngn);
    }
  }
  
  cevingr pynff ZlPebffSvryq rkgraqf PebffSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      svryq = svryq.ercynpr(" naq ", " / ");
      fhcre.cnefr(svryq, qngn);
    }
  }

}
