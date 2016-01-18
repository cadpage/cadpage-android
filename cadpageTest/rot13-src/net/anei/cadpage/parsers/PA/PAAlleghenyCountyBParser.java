cnpxntr arg.narv.pnqcntr.cnefref.CN;

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.SvryqCebtenzCnefre;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;

choyvp pynff CNNyyrturalPbhaglOCnefre rkgraqf SvryqCebtenzCnefre {
  
  choyvp CNNyyrturalPbhaglOCnefre() {
    fhcre("NYYRTURAL PBHAGL", "CN", 
          "Nqqerff:NQQE! kFgf:K! Pbqr:PBQR! Pbqr_Qrgnvy:PNYY! Sver_Mbar:ZNC! Qrfpevcgvba:VASB! GBP:QNGRGVZR! Vap_Ahz:VQ! Erfcbaqvat:FXVC! Havgf:HAVG! Qvfc_Tec:PU! Pnyy_Gnxre:FXVC");
  }
  
  @Bireevqr
  choyvp Fgevat trgSvygre() {
    erghea "nyreg@rpz2.hf";
  }
  
  
  cevingr fgngvp svany Cnggrea HCQNGR_CGA = Cnggrea.pbzcvyr("Hcqngr gb Vap# (S\\q{9}): *");

  @Bireevqr
  cebgrpgrq obbyrna cnefrZft(Fgevat fhowrpg, Fgevat obql, Qngn qngn) {
    vs (!fhowrpg.raqfJvgu(" - 911 Pnyy")) erghea snyfr;
    
    Zngpure zngpu = HCQNGR_CGA.zngpure(obql);
    vs (zngpu.ybbxvatNg()) {
      qngn.fgePnyyVq = zngpu.tebhc(1);
      obql = obql.fhofgevat(zngpu.raq());
    }
    
    obql = obql.ercynpr(" Havg:", "Havgf:");
    erghea cnefrZft(obql, qngn);
  }
  
  @Bireevqr
  choyvp Svryq trgSvryq(Fgevat anzr) {
    vs (anzr.rdhnyf("NQQE")) erghea arj ZlNqqerffSvryq();
    vs (anzr.rdhnyf("ZNC")) erghea arj ZncSvryq("\\q{6}", gehr);
    vs (anzr.rdhnyf("VASB")) erghea arj ZlVasbSvryq();
    vs (anzr.rdhnyf("QNGRGVZR")) erghea arj QngrGvzrSvryq("\\q\\q/\\q\\q/\\q{4} \\q\\q:\\q\\q:\\q\\q", gehr);
    erghea fhcre.trgSvryq(anzr);
  }
  
  cevingr pynff ZlNqqerffSvryq rkgraqf NqqerffSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      Cnefre c = arj Cnefre(svryq);
      Fgevat pvgl = c.trgYnfgBcgvbany(',');
      vs (pvgl.rdhnyf("CN")) {
        qngn.fgeFgngr = pvgl;
        pvgl = c.trgYnfgBcgvbany(',');
      }
      qngn.fgePvgl = pvgl;
      fhcre.cnefr(c.trg(), qngn);
    }
    
    @Bireevqr
    choyvp Fgevat trgSvryqAnzrf() {
      erghea "NQQE NCG PVGL FG";
    }
  }

  cevingr fgngvp svany Cnggrea VASB_VQ_CGA = Cnggrea.pbzcvyr("\\o[N-M]{4}\\q{9}\\o");
  cevingr fgngvp svany Cnggrea VASB_CUBAR_CGA = Cnggrea.pbzcvyr(" */+ *|(?=\\q)");
  cevingr pynff ZlVasbSvryq rkgraqf VasbSvryq {
    @Bireevqr
    choyvp ibvq cnefr(Fgevat svryq, Qngn qngn) {
      
      Zngpure zngpu = VASB_VQ_CGA.zngpure(svryq);
      vs (!zngpu.svaq()) {
        fhcre.cnefr(svryq, qngn);
        erghea;
      }
      fhcre.cnefr(svryq.fhofgevat(zngpu.raq()).gevz(), qngn);
      
      svryq = svryq.fhofgevat(0, zngpu.fgneg()).gevz();
      vs (svryq.yratgu() > 0) {
        svryq = fgevcSvryqFgneg(svryq, "Cubar:");
        zngpu = VASB_CUBAR_CGA.zngpure(svryq);
        vs (zngpu.svaq()) {
          qngn.fgeAnzr = svryq.fhofgevat(0,zngpu.fgneg()).gevz();
          qngn.fgeCubar = svryq.fhofgevat(zngpu.raq()).gevz();
        } ryfr {
          qngn.fgeAnzr = svryq;
        }
      }
    }
    
    @Bireevqr
    choyvp Fgevat trgSvryqAnzrf() {
      erghea "ANZR CUBAR VASB";
    }
  }
}
