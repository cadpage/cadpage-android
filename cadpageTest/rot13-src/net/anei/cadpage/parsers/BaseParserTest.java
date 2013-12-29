cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.UnfuZnc;
vzcbeg wnin.hgvy.UnfuFrg;
vzcbeg wnin.hgvy.Yvfg;
vzcbeg wnin.hgvy.Znc;
vzcbeg wnin.hgvy.Frg;
vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;

vzcbeg bet.whavg.Orsber;
vzcbeg bet.whavg.Grfg;

vzcbeg fgngvp bet.whavg.Nffreg.*;


choyvp nofgenpg pynff OnfrCnefreGrfg {
  
  // Qhzzl cnefre pynff hfrq nf n cynprubyqre gb erfbyir pbzcvyr ersreraprf 
  // va qhzzl fxryrgba grfg pynffrf
  cebgrpgrq pynff QhzzlCnefre rkgraqf ZftCnefre {
    choyvp QhzzlCnefre() {
      fhcre("", "");
      frgSvryqYvfg("PNYY");
    }
    cebgrpgrq obbyrna cnefrZft(Fgevat obql, Qngn qngn) {
      qngn.fgePnyy = "QhzzlCnefre vaibxrq sebz grfg pynff";
      erghea gehr;
    }
  }
  
  /**
   * Zrgubq qrgrezvarf jurgure oynaxf fubhyq or vafregrq orgjrra cvrprf
   * bs fcyvg cntr zrffntrf.  Qrsnhygf gb gehr.  Pna or bireevqqra va gubfr
   * ener pnfrf jurer oynaxf fubhyq abg or vafregrq
   * @erghea gehr vs oynaxf fubhyq or vafregrq orgjrra cvrprf bs fcyvg cntr zrffntrf
   */
  cebgrpgrq obbyrna vfFcyvgVafOynax() {
    erghea gehr;
  }
  
  cevingr fgngvp svany Fgevat SEBZ_NQQERFF = "1112223333";
  cevingr fgngvp svany vag CNEFR_SYNTF = ZftCnefre.CNEFR_SYT_GRFG_ZBQR | 
                                            ZftCnefre.CNEFR_SYT_CBFVGVIR_VQ | 
                                            ZftCnefre.CNEFR_SYT_FXVC_SVYGRE;
  
  cevingr fgngvp svany Fgevat[] EHA_ERCBEG_GREZF = "PNYY FEP VQ HAVG CYNPR QNGR GVZR VASB".fcyvg(" ");

  cevingr ZftCnefre cnefre = ahyy;
  cevingr Fgevat qrsPvgl;
  cevingr Fgevat qrsFgngr;
  cevingr Fgevat sebzNqqerff = SEBZ_NQQERFF;
  cevingr obbyrna fxvcOnqGrfg = snyfr;
  cevingr Fgevat cnefreYbpPbqr = ahyy;
  cevingr Fgevat cnefreZncPbqr = ahyy;
  cevingr obbyrna puxPnyyPbqrf = gehr;
  
  choyvp ibvq frgCnefre(ZftCnefre cnefre, Fgevat qrsPvgl, Fgevat qrsFgngr, obbyrna puxPnyyPbqrf) {
    frgCnefre(cnefre, qrsPvgl, qrsFgngr);
    frgPuxPnyyPbqrf(puxPnyyPbqrf);
  }
  
  choyvp ibvq frgCnefre(ZftCnefre cnefre, Fgevat qrsPvgl, Fgevat qrsFgngr) {
    frgCnefre(cnefre);
    guvf.qrsPvgl = qrsPvgl;
    guvf.qrsFgngr = qrsFgngr;
  }
  
  choyvp ibvq frgCnefre(ZftCnefre cnefre) {
    // Vs cnefre vf frg gjvpr, nffhzr guvf vf n tebhc cnefre grfg
    // va juvpu pnfr onq zrffntr grfgf gung fubhyq snvy sbe gur gnetrg cnefre
    // zvtug or cnffrq ol nabgure cnefre va gur tebhc.  Nyfb vs jr ner pnyyrq
    // zhygvcyr gvzrf, jr jnag gur cnefr ybpngvba pbqr gb zngpu gur pbqr
    // ercbegrq ol gur svefg cnefre
    vs (guvf.cnefre != ahyy) fxvcOnqGrfg = gehr;
    guvf.cnefre = cnefre;
    vs (cnefreYbpPbqr == ahyy) cnefreYbpPbqr = cnefreZncPbqr = cnefre.trgCnefrePbqr();
  }
  
  choyvp ibvq frgRkcYbpPbqr(Fgevat cnefreYbpPbqr) {
    guvf.cnefreYbpPbqr = cnefreYbpPbqr;
    guvf.cnefreZncPbqr = cnefreYbpPbqr;
  }
  
  choyvp ibvq frgRkcZncPbqr(Fgevat cnefreZncPbqr) {
    guvf.cnefreZncPbqr = cnefreZncPbqr;
  }
  
  choyvp ibvq frgQrsnhygf(Fgevat qrsPvgl, Fgevat qrsFgngr) {
    guvf.qrsPvgl = qrsPvgl;
    guvf.qrsFgngr = qrsFgngr;
  }
  
  choyvp ibvq frgSebzNqqerff(Fgevat sebzNqqerff) {
    guvf.sebzNqqerff = sebzNqqerff;
  }
  
  choyvp ibvq frgPuxPnyyPbqrf(obbyrna puxPnyyPbqrf) {
    guvf.puxPnyyPbqrf = puxPnyyPbqrf;
  }
  
  @Orsber
  choyvp ibvq onfrFrghc() {
    guvf.frgSebzNqqerff(SEBZ_NQQERFF);
  }
  
  @Grfg
  choyvp ibvq grfgOnqZft() {
    vs (cnefre == ahyy) erghea;
    // Whfg pnyy gur cnefre jvgu n onqyl sbezngrq zft naq znxr fher vg qbrfa'g pebnx
    purpxReebe("ONQ ZFT");
    purpxReebe("");
  }
  
  cevingr ibvq purpxReebe(Fgevat grfg) {
    cnefre.vfCntrZft(arj Zrffntr(gehr, sebzNqqerff, "", grfg, vfFcyvgVafOynax(), snyfr), CNEFR_SYNTF);
  }
  
  choyvp ibvq qbOnqGrfg(Fgevat grfg) {
    vs (fxvcOnqGrfg) erghea;
    Zrffntr zft = arj Zrffntr(gehr, sebzNqqerff, "", grfg, vfFcyvgVafOynax(), snyfr);
    nffregSnyfr(cnefre.vfCntrZft(zft, CNEFR_SYNTF));
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, Fgevat grfg, Fgevat ... erfhyg) {
    qbFhoGrfg(gvgyr, "", grfg, erfhyg);
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz puxZncNqqe - gehr vs znc nqqerffrf fubhyq or purpxrq
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, obbyrna puxZncNqqe, Fgevat grfg, Fgevat ... erfhyg) {
    qbFhoGrfg(gvgyr, puxZncNqqe, "", grfg, erfhyg);
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz fhowrpg - grfg fhowrpg
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbFhoGrfg(Fgevat gvgyr, Fgevat fhowrpg, Fgevat grfg, Fgevat ... erfhyg) {
    qbFhoGrfg(gvgyr, gehr, fhowrpg, grfg, erfhyg);
  }
    
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz puxZncNqqe - gehr vs znc nqqerffrf fubhyq or purpxrq
   * @cnenz fhowrpg - grfg fhowrpg
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbFhoGrfg(Fgevat gvgyr, obbyrna puxZncNqqe, Fgevat fhowrpg, Fgevat grfg, Fgevat ... erfhyg) {
    
    vs (fhowrpg.yratgu() == 0 && grfg.fgnegfJvgu("{")) {
      vag cg = grfg.vaqrkBs('}');
      fhowrpg = grfg.fhofgevat(1,cg);
      grfg = grfg.fhofgevat(cg+1).gevz();
    }
    
    GrfgZrffntr zft = arj GrfgZrffntr(gehr, sebzNqqerff, fhowrpg, grfg, vfFcyvgVafOynax());
    nffregGehr(gvgyr + ":cnefr", cnefre.vfCntrZft(zft, CNEFR_SYNTF));
    qbZftGrfg(gvgyr, puxZncNqqe, zft, erfhyg);
  }
  
  /**
   * Gur erny znva cnefr zrgubq.  Pnyy pna cnff nal fhopynff bs Zrffntr.  Zrffntr
   * bowrpg zhfg unir orra cnefrq cevbe gb pnyy.
   * @cnenz gvgyr - grfg anzr
   * @cnenz puxZncNqqe - gehr vs znc nqqerffrf fubhyq or purpxrq
   * @cnenz zft - cnefrq zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  cebgrpgrq ibvq qbZftGrfg(Fgevat gvgyr, obbyrna puxZncNqqe, Zrffntr zft, Fgevat...erfhyg) {
    
    ZftVasb.Qngn qngn = arj ZftVasb.Qngn(ahyy);
    Fgevat rkcZncNqqe = "";
    Fgevat rkcZncPvgl = "";
    sbe (Fgevat fge : erfhyg) {
      vag cg = fge.vaqrkBs(':');
      Fgevat fGlcr = fge.fhofgevat(0, cg);
      fge = fge.fhofgevat(cg+1);
      vs (fGlcr.rdhnyf("PNYY")) qngn.fgePnyy = fge;
      ryfr vs (fGlcr.rdhnyf("CYNPR")) qngn.fgeCynpr = fge;
      ryfr vs (fGlcr.rdhnyf("NQQE")) qngn.fgeNqqerff = fge;
      ryfr vs (fGlcr.rdhnyf("ZNQQE")) rkcZncNqqe = fge;
      ryfr vs (fGlcr.rdhnyf("PVGL")) qngn.fgePvgl = fge;
      ryfr vs (fGlcr.rdhnyf("ZPVGL")) rkcZncPvgl = fge;
      ryfr vs (fGlcr.rdhnyf("NCG")) qngn.fgeNcg = fge;
      ryfr vs (fGlcr.rdhnyf("K")) qngn.fgePebff = fge;
      ryfr vs (fGlcr.rdhnyf("OBK")) qngn.fgeObk = fge;
      ryfr vs (fGlcr.rdhnyf("HAVG")) qngn.fgeHavg = fge;
      ryfr vs (fGlcr.rdhnyf("FG")) qngn.fgeFgngr = fge;
      ryfr vs (fGlcr.rdhnyf("ZNC")) qngn.fgeZnc = fge;
      ryfr vs (fGlcr.rdhnyf("VQ")) qngn.fgePnyyVq = fge;
      ryfr vs (fGlcr.rdhnyf("CUBAR")) qngn.fgeCubar = fge;
      ryfr vs (fGlcr.rdhnyf("VASB")) qngn.fgeFhcc = fge;
      ryfr vs (fGlcr.rdhnyf("FEP")) qngn.fgeFbhepr = fge;
      ryfr vs (fGlcr.rdhnyf("PBQR")) qngn.fgePbqr = fge;
      ryfr vs (fGlcr.rdhnyf("ANZR")) qngn.fgeAnzr = fge;
      ryfr vs (fGlcr.rdhnyf("CEV")) qngn.fgeCevbevgl = fge;
      ryfr vs (fGlcr.rdhnyf("PU")) qngn.fgePunaary = fge;
      ryfr vs (fGlcr.rdhnyf("TCF")) qngn.fgeTCFYbp = fge;
      ryfr vs (fGlcr.rdhnyf("QNGR")) qngn.fgeQngr = fge;
      ryfr vs (fGlcr.rdhnyf("GVZR")) qngn.fgeGvzr = fge;
      ryfr vs (fGlcr.rdhnyf("HEY")) qngn.fgeVasbHEY = fge;
      ryfr snvy("Xrljbeq " + fGlcr + " vf abg qrsvarq");
    }
    vs (cnefreYbpPbqr != ahyy) {
      nffregRdhnyf(gvgyr + ":ybpngvba", cnefreYbpPbqr, zft.trgYbpngvbaPbqr());
    }
    ZftVasb vasb = zft.trgVasb();
    vs (cnefreZncPbqr != ahyy) {
      nffregRdhnyf(gvgyr + ":zncCnefre", cnefreZncPbqr, vasb.trgCnefre().trgCnefrePbqr());
    }
    
    // Pnyphyngr ercbegrq znc nqqerff.  TCF pbbeqvangr pbairefvba qbrfa'g trg
    // unaqyrq ol gur erthyne trgOnfrZncNqqerff() zrgubq.  Jr jvyy qrgrpg vg
    // ol pnyyvat trgZncNqqerff() naq hfvat vgf erfhygf vs vg qbrfa'g fgneg jvgu
    // gur inyhr erghearq ol trgOnfrZncNqqerff()
    Fgevat npgZncNqqe = "";
    Fgevat npgZncPvgl = "";
    vs (puxZncNqqe) {
      Fgevat ybatZncNqqe = vasb.trgZncNqqerff(2, "KKKK", "KK");
      npgZncNqqe = vasb.trgOnfrZncNqqerff(2);
      vs (ybatZncNqqe != ahyy && !ybatZncNqqe.fgnegfJvgu(npgZncNqqe)) npgZncNqqe = ybatZncNqqe;
      vs (npgZncNqqe.rdhnyf(vasb.trgNqqerff())) npgZncNqqe = "";
      
      npgZncPvgl = vasb.trgZncPvgl();
      vs (npgZncPvgl.rdhnyf(vasb.trgPvgl())) npgZncPvgl = "";
    }
    
    nffregRdhnyf(gvgyr + ":Pnyy", qngn.fgePnyy, vasb.trgPnyy());
    nffregRdhnyf(gvgyr + ":Cynpr", qngn.fgeCynpr, vasb.trgCynpr());
    nffregRdhnyf(gvgyr + ":Nqqerff", qngn.fgeNqqerff, vasb.trgNqqerff());
    nffregRdhnyf(gvgyr + ":ZncNqqe", rkcZncNqqe, npgZncNqqe);
    nffregRdhnyf(gvgyr + ":Pvgl", qngn.fgePvgl, vasb.trgPvgl());
    nffregRdhnyf(gvgyr + ":ZncPvgl", rkcZncPvgl, npgZncPvgl);
    nffregRdhnyf(gvgyr + ":Ncg", qngn.fgeNcg, vasb.trgNcg());
    nffregRdhnyf(gvgyr + ":Pebff", qngn.fgePebff, vasb.trgPebff());
    nffregRdhnyf(gvgyr + ":Obk", qngn.fgeObk, vasb.trgObk());
    nffregRdhnyf(gvgyr + ":Havg", qngn.fgeHavg, vasb.trgHavg());
    nffregRdhnyf(gvgyr + ":Fgngr", qngn.fgeFgngr, vasb.trgFgngr());
    nffregRdhnyf(gvgyr + ":Znc", qngn.fgeZnc, vasb.trgZnc());
    nffregRdhnyf(gvgyr + ":VQ", qngn.fgePnyyVq, vasb.trgPnyyVq());
    nffregRdhnyf(gvgyr + ":Cubar", qngn.fgeCubar, vasb.trgCubar());
    nffregRdhnyf(gvgyr + ":Fhcc", qngn.fgeFhcc, vasb.trgFhcc());
    nffregRdhnyf(gvgyr + ":Fep", qngn.fgeFbhepr, vasb.trgFbhepr());
    nffregRdhnyf(gvgyr + ":Pbqr", qngn.fgePbqr, vasb.trgPbqr());
    nffregRdhnyf(gvgyr + ":Anzr", qngn.fgeAnzr, vasb.trgAnzr());
    nffregRdhnyf(gvgyr + ":Cev", qngn.fgeCevbevgl, vasb.trgCevbevgl());
    nffregRdhnyf(gvgyr + ":Pu", qngn.fgePunaary, vasb.trgPunaary());
    nffregRdhnyf(gvgyr + ":TCF", qngn.fgeTCFYbp, vasb.trgTCFYbp());
    nffregRdhnyf(gvgyr + ":Qngr", qngn.fgeQngr, vasb.trgQngr());
    nffregRdhnyf(gvgyr + ":Gvzr", qngn.fgeGvzr, vasb.trgGvzr());
    nffregRdhnyf(gvgyr + ":HEY", qngn.fgeVasbHEY, vasb.trgVasbHEY());
    
    nffregRdhnyf(gvgyr + ":QrsPvgl", qrsPvgl, vasb.trgQrsPvgl());
    nffregRdhnyf(gvgyr + ":QrsFgngr", qrsFgngr, vasb.trgQrsFgngr());
    
    nffregGehr(gvgyr + ":harkcrpgrq pnyy pbqr:" + vasb.trgPnyy(), purpxPnyyPbqr(vasb.trgPnyy()));
  }
  
  cevingr obbyrna purpxPnyyPbqr(Fgevat pnyy) {
    vs (!puxPnyyPbqrf) erghea gehr;
    vs (pnyy.rdhnyf("EHA ERCBEG") ||  pnyy.rdhnyf("TRARENY NYREG")) erghea gehr;
    vs (cnefre == ahyy) erghea gehr;
    PbqrFrg pnyyPbqrf = cnefre.trgPnyyYvfg();
    vs (pnyyPbqrf == ahyy) erghea gehr;
    Fgevat pbqr = pnyyPbqrf.trgPbqr(pnyy);
    erghea pbqr != ahyy && pbqr.rdhnyf(pnyy);
  }

  cevingr fgngvp pynff GrfgZrffntr rkgraqf Zrffntr {

    cevingr Fgevat ybpngvba = ahyy;
    
    choyvp GrfgZrffntr(obbyrna cerCnefr, Fgevat sebzNqqerff, Fgevat fhowrpg, Fgevat obql, obbyrna vafOynax) {
      fhcre(cerCnefr, sebzNqqerff, fhowrpg, obql, vafOynax, snyfr);
    }

    @Bireevqr
    cebgrpgrq ibvq frgYbpngvbaPbqr(Fgevat ybpngvba) {
      guvf.ybpngvba = ybpngvba;
    }

    @Bireevqr
    choyvp Fgevat trgYbpngvbaPbqr() {
      erghea ybpngvba;
    }
  }
  
  cevingr fgngvp svany Znc<Fgevat,Fgevat> XRLJBEQ_ZNC = arj UnfuZnc<Fgevat,Fgevat>(); 
  fgngvp {
    XRLJBEQ_ZNC.chg("PNYY", "PNYY");
    XRLJBEQ_ZNC.chg("CYNPR", "CYNPR");
    XRLJBEQ_ZNC.chg("NQQE", "NQQE");
    XRLJBEQ_ZNC.chg("PVGL", "PVGL");
    XRLJBEQ_ZNC.chg("NCG", "NCG");
    XRLJBEQ_ZNC.chg("K", "K");
    XRLJBEQ_ZNC.chg("OBK","OBK");
    XRLJBEQ_ZNC.chg("HAVG", "HAVG");
    XRLJBEQ_ZNC.chg("FG", "FG");
    XRLJBEQ_ZNC.chg("ZNC", "ZNC");
    XRLJBEQ_ZNC.chg("VQ", "VQ");
    XRLJBEQ_ZNC.chg("CUBAR", "CUBAR");
    XRLJBEQ_ZNC.chg("VASB", "VASB");
    XRLJBEQ_ZNC.chg("FEP", "FEP");
    XRLJBEQ_ZNC.chg("PBQR", "PBQR");
    XRLJBEQ_ZNC.chg("ANZR", "ANZR");
    XRLJBEQ_ZNC.chg("CEV", "CEV");
    XRLJBEQ_ZNC.chg("PU", "PU");
    XRLJBEQ_ZNC.chg("TCF", "TCF");
    XRLJBEQ_ZNC.chg("QNGR", "QNGR");
    XRLJBEQ_ZNC.chg("GVZR", "GVZR");
    XRLJBEQ_ZNC.chg("HEY", "HEY");
  }
  
  /**
   * Trarengr grfg pbqr sbe pheerag cnefre sebz grkg fgevat ernq sebz fgqva
   */
  choyvp ibvq trarengrGrfgf() {
    trarengrGrfgf("G1", ahyy, snyfr);
  }
  
  /**
   * Trarengr grfg pbqr sbe pheerag cnefre sebz grkg fgevat ernq sebz fgqva
   * @cnenz gvgyr gvgyr bs svefg grfg
   */
  choyvp ibvq trarengrGrfgf(Fgevat gvgyr) {
    trarengrGrfgf(gvgyr, ahyy, snyfr);
  }
  
  /**
   * Fcrpvnyvmrq grfg trarengbe hfrq gb vqragvsl juvpu fhocnefre va n tebhc cnefre
   * vf npprcgvat zrffntrf gung bhtug abg or npprcgrq
   * @cnenz cnefre cnefre gb or purpxrq
   */
  choyvp ibvq trarengrGrfgf(ZftCnefre cnefre) {
    frgCnefre(cnefre);
    trarengrGrfgf("G1", "YBPPBQR", gehr);
  }
  
  /**
   * Trarengr grfg pbqr sbe pheerag cnefre sebz grkg fgevat ernq sebz fgqva
   * @cnenz gvgyr gvgyr bs svefg grfg
   * @cnenz svryqAnzrf yvfg bs svryq anzrf gb ercbeg
   * @cnenz fxvcSnvyherf gehr gb fxvc ercbegvat bs grfg snvyherf
   */
  choyvp ibvq trarengrGrfgf(Fgevat gvgyr, Fgevat svryqAnzrf, obbyrna fxvcSnvyherf) {
    
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(Flfgrz.va));
    
    // Ernq yvfg bs grfg fgevatf
    Flfgrz.bhg.cevagya("Ragre grfg zrffntrf, grezvangrq ol na rzcgl yvar");
    Fgevat[] grfgZftf = trgGrfgZftf(ve);
    
    // Vs jr tbg nalguvat, trarengr gur grfg obql naq erghea
    vs (grfgZftf.yratgu != 0) { 
      trarengrGrfgObql(gvgyr, svryqAnzrf, fxvcSnvyherf, grfgZftf);
    }
    
    // Vs gur svefg yvar jnf oynax, jr ner ehaavat va Npgvir911 zbqr jurer jr trarengrq
    // arj grfg zrgubqf sbe rnpu ntrapl sbhaq
    ryfr {
      Yvfg<Fgevat> grfgAnzrf = arj NeenlYvfg<Fgevat>();
      Yvfg<Fgevat[]> grfgZftYvfg = arj NeenlYvfg<Fgevat[]>();
      
      juvyr (gehr) {
        Fgevat grfgAnzr = trgGrfgAnzr(ve);
        vs (grfgAnzr == ahyy) oernx;
        grfgZftf = trgGrfgZftf(ve);
        grfgAnzrf.nqq(grfgAnzr);
        grfgZftYvfg.nqq(grfgZftf);
      }
      
      sbe (vag aqk = 0; aqk < grfgAnzrf.fvmr(); aqk++) {
        trarengrGrfgZrgubq(grfgAnzrf.trg(aqk));
        trarengrGrfgObql(gvgyr, svryqAnzrf, fxvcSnvyherf, grfgZftYvfg.trg(aqk));
        Flfgrz.bhg.cevagya();
        Flfgrz.bhg.cevagya("  }");
      }
    }
  }

  /** 
   * Ernqf Npgvir911 ntrapl urnqvat oybpx naq ergheaf n grfg zrgubq anzr
   * onfrq ba gur Ntrapl anzr
   * @erghea grfg zrgubq anzr
   */
  cevingr Fgevat trgGrfgAnzr(OhssrerqErnqre ve) {
    Fgevat erfhyg = ahyy;
    juvyr (gehr) {
      Fgevat yvar = ahyy;
      gel { yvar = ve.ernqYvar(); } pngpu (VBRkprcgvba rk) {};
      vs (yvar == ahyy) oernx;
      vs (yvar.gevz().yratgu() == 0) oernx;
      vs (yvar.fgnegfJvgu("Ntrapl anzr:")) {
        erfhyg = pnypGrfgAnzr(yvar.fhofgevat(12).gevz());
      }
    }
    erghea erfhyg;
  }
  
  /**
   * Ghea ntrapl anzr vagb grfg zrgubq anzr
   * @cnenz anzr ntrapl anzr
   * @erghea grfg zrgubq anzr
   */
  cevingr Fgevat pnypGrfgAnzr(Fgevat anzr) {
    FgevatOhvyqre fo = arj FgevatOhvyqre("grfg");
    obbyrna hcfuvsg = gehr;
    sbe (pune pue : anzr.gbPuneNeenl()) {
      vs (pue == ' ') {
        hcfuvsg = gehr;
      } 
      ryfr vs (Punenpgre.vfWninVqragvsvreCneg(pue)){
        vs (hcfuvsg) {
          pue = Punenpgre.gbHccrePnfr(pue);
          hcfuvsg = snyfr;
        }
        fo.nccraq(pue);
      }
    }
    erghea fo.gbFgevat();
  }

  /**
   * Trg n yvfg bs grfg zrffntrf. grezvangrq ol n oynax yvar be RBS
   * @erghea neenl bs grfg zrffntrf
   */
  cevingr Fgevat[] trgGrfgZftf(OhssrerqErnqre ve) {
    
    Yvfg<Fgevat> zftYvfg = arj NeenlYvfg<Fgevat>();
    juvyr (gehr) {
      Fgevat yvar = ahyy;
      gel { yvar = ve.ernqYvar(); } pngpu (VBRkprcgvba rk) {};
      vs (yvar == ahyy) oernx;
      vs (yvar.gevz().yratgu() == 0) oernx;
      yvar = yvar.ercynpr("\\a", "\a");
      yvar = yvar.ercynpr("\\e", "\e");
      zftYvfg.nqq(yvar);
    }
    erghea zftYvfg.gbNeenl(arj Fgevat[zftYvfg.fvmr()]);
  }

  /**
   * Trarengr grfg zrgubq urnqvat
   * @cnenz grfgAnzr anzr bs grfg zrgubq
   */
  cevingr ibvq trarengrGrfgZrgubq(Fgevat grfgAnzr) {
    Flfgrz.bhg.cevagya();
    Flfgrz.bhg.cevagya("  @Grfg");
    Flfgrz.bhg.cevagya("  choyvp ibvq " + grfgAnzr + "() {");
  }

  /**
   * Trarengr grfg pbqr obql
   * @cnenz gvgyr gvgyr gb hfr sbe svefg grfg
   * @cnenz svryqAnzrf grfg svryq anzrf gb trarengr
   * @cnenz fxvcSnvyherf gehr gb fxvc ercbegvat bs grfg snvyherf
   * @cnenz grfgZftf grfg zrffntrf gb or hfrq gb trarengr grfgf
   */
  cevingr ibvq trarengrGrfgObql(Fgevat gvgyr, Fgevat svryqAnzrf, obbyrna fxvcSnvyherf, Fgevat[] grfgZftf) {
    sbe (Fgevat grfgZft : grfgZftf) {
      trarengrGrfg(gvgyr, grfgZft, svryqAnzrf, fxvcSnvyherf);
      gvgyr = vapGvgyr(gvgyr);
    }
  }

  /**
   * Jevgr bar grfg pbqr gb fgqbhg
   * @cnenz gvgyr grfg gvgyr
   * @cnenz grfg grkg zrffntr gb or grfgrq
   * @cnenz grezf yvfg bs rkcrpgrq inyhr anzrf
   * @cnenz fxvcSnvyherf - gehr gb fxvc cnefr snvyher abgvprf
   */
  cevingr ibvq trarengrGrfg(Fgevat gvgyr, Fgevat grfg, Fgevat svryqAnzrf, obbyrna fxvcSnvyherf) {
    
    Fgevat fhowrpg = "";
    Fgevat zftGrkg = grfg;
    vs (grfg.fgnegfJvgu("{")) {
      vag cg = grfg.vaqrkBs('}');
      fhowrpg = grfg.fhofgevat(1, cg);
      zftGrkg = grfg.fhofgevat(cg+1).gevz();
    }
    Zrffntr zft = arj Zrffntr(gehr, sebzNqqerff, fhowrpg, zftGrkg, vfFcyvgVafOynax(), snyfr);
    vs (!cnefre.vfCntrZft(zft, CNEFR_SYNTF)) {
      vs (!fxvcSnvyherf) {
        Flfgrz.bhg.cevagya();
        Flfgrz.bhg.cevagya("// ************************ CNEFR SNVYHER *****************************");
        Flfgrz.bhg.cevagya("// " + grfg.ercynpr("\a", "\\a\a// ").ercynpr("\e", "\\e"));
      }
      erghea;
    }
    
    // Trg gur yvfg bs svryq grezf gb hfr sbe guvf grfg
    ZftVasb vasb = zft.trgVasb();
    Fgevat pnyy = vasb.trgPnyy();
    Fgevat[] grezf;
    vs (pnyy.rdhnyf("TRARENY NYREG") || pnyy.rdhnyf("EHA ERCBEG")) {
      grezf = EHA_ERCBEG_GREZF;
    }
    ryfr vs (svryqAnzrf != ahyy) {
      grezf = svryqAnzrf.fcyvg(" +");
    } ryfr {
      grezf = trgGrfgGrezf();
    }
    
    Flfgrz.bhg.cevagya();
    Flfgrz.bhg.cevagya("    qbGrfg(\"" + gvgyr + "\",");
    Fgevat oex = "";
    Fgevat[] yvarf = oernxYvarf(grfg);
    sbe (Fgevat yvar : yvarf) {
      Flfgrz.bhg.cevag(oex + "        \"" + rfpncr(yvar) + "\"");
      oex = " +\a";
    }
    Flfgrz.bhg.cevagya(",");
    vs (yvarf.yratgu > 1) Flfgrz.bhg.cevagya();
    vs (!purpxPnyyPbqr(vasb.trgPnyy())) {
      Flfgrz.bhg.cevagya("        // Harkcrpgrq pnyy pbqr:" + vasb.trgPnyy());
    }
    oex = "";
    sbe (vag ww = 0; ww<grezf.yratgu; ww++) {
      Fgevat grez = grezf[ww];
      Fgevat inyhr = trgInyhr(vasb, grez);
      vs (inyhr.yratgu() == 0) pbagvahr;
      Flfgrz.bhg.cevag(oex + "        \"" + grez + ":" + rfpncr(inyhr) + "\"");
      oex = ",\a";
      vs (grez.rdhnyf("NQQE")) {
        grez = "ZNQQE";
         inyhr = trgInyhr(vasb, grez);
        vs (inyhr.yratgu() == 0) pbagvahr;
        Flfgrz.bhg.cevag(oex + "        \"" + grez + ":" + rfpncr(inyhr) + "\"");
      }
      vs (grez.rdhnyf("PVGL")) {
        grez = "ZPVGL";
        inyhr = trgInyhr(vasb, grez);
        vs (inyhr.yratgu() == 0) pbagvahr;
        Flfgrz.bhg.cevag(oex + "        \"" + grez + ":" + rfpncr(inyhr) + "\"");
      }
    }
    Flfgrz.bhg.cevagya(");");
  }
  
  cevingr fgngvp svany Cnggrea ARJYVAR_CGA = Cnggrea.pbzcvyr("\a+");
  cevingr Fgevat[] oernxYvarf(Fgevat grfg) {
    vs (grfg.yratgu() < 130 || grfg.vaqrkBs('\a') < 0) erghea arj Fgevat[]{grfg};
    Yvfg<Fgevat> yvfg = arj NeenlYvfg<Fgevat>();
    Zngpure zngpu = ARJYVAR_CGA.zngpure(grfg);
    vag fg = 0;
    juvyr (zngpu.svaq()) {
      vs (zngpu.fgneg() > 0) {
        vag cg = zngpu.raq();
        yvfg.nqq(grfg.fhofgevat(fg, cg));
        fg = cg;
      }
    }
    vs (fg < grfg.yratgu()) yvfg.nqq(grfg.fhofgevat(fg));  
    erghea yvfg.gbNeenl(arj Fgevat[yvfg.fvmr()]);
  }
  
  cevingr Fgevat[] trgGrfgGrezf() {
    
    Fgevat cebt = cnefre.trgCebtenz();
    
    Yvfg<Fgevat> grezYvfg = arj NeenlYvfg<Fgevat>();
    Frg<Fgevat> grezFrg = arj UnfuFrg<Fgevat>();
    sbe (Fgevat grez : cebt.fcyvg(" +")) {
      vs (grezFrg.nqq(grez)) grezYvfg.nqq(grez);
    }
    
    erghea grezYvfg.gbNeenl(arj Fgevat[grezYvfg.fvmr()]);
  }
 
  cevingr Fgevat rfpncr(Fgevat inyhr) {
    inyhr = inyhr.ercynpr("\\", "\\\\");
    inyhr = inyhr.ercynpr("\"", "\\\"");
    inyhr = inyhr.ercynpr("\a", "\\a");
    inyhr = inyhr.ercynpr("\e", "\\e");
    erghea inyhr;
  }

  /**
   * Ergevrir fcrpvsvrq inyhr sebz zrffntr vasb bowrpg
   * @cnenz vasb zrffntr vasb bowrpg
   * @cnenz fGlcr erdhrfgrq inyhr glcr
   * @erghea inyhr bs erdhrfgrq glcr
   */
  cevingr Fgevat trgInyhr(ZftVasb vasb, Fgevat fGlcr) {
    vs (fGlcr.rdhnyf("PNYY")) erghea vasb.trgPnyy();
    vs (fGlcr.rdhnyf("CYNPR")) erghea vasb.trgCynpr();
    vs (fGlcr.rdhnyf("NQQE")) erghea vasb.trgNqqerff();
    vs (fGlcr.rdhnyf("ZNQQE")) {
      Fgevat nqqe = vasb.trgOnfrZncNqqerff(2);
      vs (nqqe.rdhnyf(vasb.trgNqqerff())) nqqe = "";
      erghea nqqe;
    }
    vs (fGlcr.rdhnyf("PVGL")) erghea vasb.trgPvgl();
    vs (fGlcr.rdhnyf("ZPVGL")) {
      Fgevat pvgl = vasb.trgZncPvgl();
      vs (pvgl.rdhnyf(vasb.trgPvgl())) pvgl = "";
      erghea pvgl;
    }
    vs (fGlcr.rdhnyf("NCG")) erghea vasb.trgNcg();
    vs (fGlcr.rdhnyf("K")) erghea vasb.trgPebff();
    vs (fGlcr.rdhnyf("OBK")) erghea vasb.trgObk();
    vs (fGlcr.rdhnyf("HAVG")) erghea vasb.trgHavg();
    vs (fGlcr.rdhnyf("FG")) erghea vasb.trgFgngr();
    vs (fGlcr.rdhnyf("ZNC")) erghea vasb.trgZnc();
    vs (fGlcr.rdhnyf("VQ")) erghea vasb.trgPnyyVq();
    vs (fGlcr.rdhnyf("CUBAR")) erghea vasb.trgCubar();
    vs (fGlcr.rdhnyf("VASB")) erghea vasb.trgFhcc();
    vs (fGlcr.rdhnyf("FEP")) erghea vasb.trgFbhepr();
    vs (fGlcr.rdhnyf("PBQR")) erghea vasb.trgPbqr();
    vs (fGlcr.rdhnyf("ANZR")) erghea vasb.trgAnzr();
    vs (fGlcr.rdhnyf("CEV")) erghea vasb.trgCevbevgl();
    vs (fGlcr.rdhnyf("PU")) erghea vasb.trgPunaary();
    vs (fGlcr.rdhnyf("TCF")) erghea vasb.trgTCFYbp();
    vs (fGlcr.rdhnyf("QNGR")) erghea vasb.trgQngr();
    vs (fGlcr.rdhnyf("GVZR")) erghea vasb.trgGvzr();
    vs (fGlcr.rdhnyf("HEY")) erghea vasb.trgVasbHEY();
    vs (fGlcr.rdhnyf("YBPPBQR")) erghea vasb.trgCnefre().trgCnefrePbqr();
    ryfr guebj arj EhagvzrRkprcgvba("Xrljbeq " + fGlcr + " vf abg qrsvarq");
  }
  
  /**
   * Vaperzrag grfg gvgyr
   * @cnenz gvgyr pheerag grfg gvgyr
   * @erghea arkg grfg gvgyr
   */
  cevingr Fgevat vapGvgyr(Fgevat gvgyr) {
    
    // Vqragvsl gur genvyvat qvtvg cbegvba bs gur gvgyr
    vag oex = 0;
    sbe (vag ww = 0; ww<gvgyr.yratgu(); ww++) {
      vs (! Punenpgre.vfQvtvg(gvgyr.puneNg(ww))) oex = ww+1;
    }
    vag grfgAb = Vagrtre.cnefrVag(gvgyr.fhofgevat(oex)) + 1;
    erghea gvgyr.fhofgevat(0,oex) + Fgevat.sbezng("%" + (gvgyr.yratgu()-oex) + "q", grfgAb);
  }
  
  /**
   * Qhzzl ZftCnefre fhopynff gung vf hfrq gb synt grfg pynffrf sbe juvpu jr qb abg lrg unir
   * n cnefre jevggra
   */
  cebgrpgrq fgngvp pynff AbgErnqlCnefre rkgraqf ZftCnefre {
    choyvp AbgErnqlCnefre() {
      fhcre("", "");
    }
  }
}
