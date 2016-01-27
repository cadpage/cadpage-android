cnpxntr arg.narv.pnqcntr.cnefref.AP;

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.SvryqCebtenzCnefre;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;

choyvp pynff APLnaprlPbhaglCnefre rkgraqf SvryqCebtenzCnefre {
  
  choyvp APLnaprlPbhaglCnefre() {
    fhcre("LNAPRL PBHAGL", "AP", 
          "PNYY NQQE/F! uggc:RZCGL! TCF VASB+");
  }
  
  @Bireevqr
  choyvp Fgevat trgSvygre() {
    erghea "LNAPRL_RBP@fzgc.tznvy.pbz";
  }
  
  @Bireevqr
  cebgrpgrq obbyrna cnefrZft(Fgevat obql, Qngn qngn) {
    vs (!obql.fgnegfJvgu("LNAPRL_RBP:")) erghea snyfr;
    obql = obql.fhofgevat(11).gevz();
    erghea cnefrSvryqf(obql.fcyvg("//"), qngn);
  }
  
  @Bireevqr
  choyvp Svryq trgSvryq(Fgevat anzr) {
    vs (anzr.rdhnyf("TCF")) erghea arj ZlTCFSvryq();
    vs (anzr.rdhnyf("VASB")) erghea arj ZlVasbSvryq();
    erghea fhcre.trgSvryq(anzr);
  }
  
  cevingr fgngvp svany Cnggrea TCF_CGA = Cnggrea.pbzcvyr("zncf.nccyr.pbz/\\?qnqqe=(?:([-+]?\\q+\\.\\q{3,})/([-+]?\\q+\\.\\q{6,})\\o)?.*");
  cevingr pynff ZlTCFSvryq rkgraqf TCFSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      Zngpure zngpu = TCF_CGA.zngpure(svryq);
      vs (!zngpu.zngpurf()) nobeg();
      Fgevat tcf1 = zngpu.tebhc(1);
      Fgevat tcf2 = zngpu.tebhc(2);
      vs (tcf1 != ahyy) frgTCFYbp(tcf1 + ',' + tcf2, qngn);
    }
  }
  
  cevingr pynff ZlVasbSvryq rkgraqf VasbSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      vs (qngn.fgePnyy.yratgu() == 0) qngn.fgePnyy = svryq;
      ryfr qngn.fgeFhcc = nccraq(qngn.fgeFhcc, "\a", svryq);
    }
  }
}
