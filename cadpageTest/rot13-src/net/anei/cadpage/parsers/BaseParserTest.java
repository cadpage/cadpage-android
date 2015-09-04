cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.Neenlf;
vzcbeg wnin.hgvy.Pbyyrpgvbaf;
vzcbeg wnin.hgvy.UnfuFrg;
vzcbeg wnin.hgvy.Yvfg;
vzcbeg wnin.hgvy.Frg;
vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.ZftGlcr;
vzcbeg arg.narv.pnqcntr.cnefref.ZftCnefre.PbhagelPbqr;

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
  
  /**
   * Zrgubq qrgrezvarf vs yrnqvat pheyl oenpr grezf fubhyq or cnefrq nf gur zrffntr fhowrpg
   * Qrsnhygf gb gehr, pna or bireevqqra ol grfg pynffrf gung jnag guvf ghearq bss.
   */
  cebgrpgrq obbyrna cnefrFhowrpg() {
    erghea gehr;
  }
  
  cevingr fgngvp svany Fgevat SEBZ_NQQERFF = "1112223333";
  cevingr fgngvp svany vag CNEFR_SYNTF = ZftCnefre.CNEFR_SYT_GRFG_ZBQR | 
                                         ZftCnefre.CNEFR_SYT_CBFVGVIR_VQ | 
                                         ZftCnefre.CNEFR_SYT_FXVC_SVYGRE;
  
  cevingr fgngvp svany Fgevat[] EHA_ERCBEG_GREZF = "GLCR PBQR PNYY FEP VQ HAVG CYNPR QNGR GVZR VASB".fcyvg(" ");

  cevingr ZftCnefre cnefre = ahyy;
  cevingr FcyvgZftBcgvbaf bcgvbaf = ahyy;
  cevingr Fgevat qrsPvgl = ahyy;
  cevingr Fgevat qrsFgngr = ahyy;
  cevingr Fgevat ceriQrsPvgl = ahyy;
  cevingr Fgevat ceriQrsFgngr = ahyy;
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
    // zvtug or cnffrq ol nabgure cnefre va gur tebhc.
    vs (guvf.cnefre != ahyy) fxvcOnqGrfg = gehr;
    guvf.cnefre = cnefre;
    
    // Nyfb vs jr ner pnyyrq zhygvcyr gvzrf, jr jnag gur cnefr ybpngvba pbqr gb zngpu 
    // gur pbqr ercbegrq ol gur svefg cnefre
    vs (cnefreYbpPbqr == ahyy) cnefreYbpPbqr = cnefreZncPbqr = cnefre.trgCnefrePbqr();
    
    // Fcyvg zretr bcgvbaf ner nabgure ceboyrzngvp vffhr, cvpx gur svefg bar gung
    // unf nal bcgvbaf qrsvarq
    FcyvgZftBcgvbaf bcg = cnefre.trgNpgvir911FcyvgZftBcgvbaf();
    vs (bcgvbaf == ahyy && bcg != ahyy) bcgvbaf = bcg;
    
    // Frg cnefre grfg zbqr
    cnefre.frgGrfgZbqr(gehr);
  }
  
  cevingr FcyvgZftBcgvbaf trgFcyvgZftBcgvbaf() {
    vs (bcgvbaf == ahyy) bcgvbaf = arj FcyvgZftBcgvbafPhfgbz(){
      @Bireevqr choyvp obbyrna fcyvgOynaxVaf() { erghea vfFcyvgVafOynax(); }
    };
    erghea bcgvbaf;
  }
  
  choyvp ibvq frgRkcYbpPbqr(Fgevat cnefreYbpPbqr) {
    guvf.cnefreYbpPbqr = cnefreYbpPbqr;
    guvf.cnefreZncPbqr = cnefreYbpPbqr;
  }
  
  choyvp ibvq frgRkcZncPbqr(Fgevat cnefreZncPbqr) {
    guvf.cnefreZncPbqr = cnefreZncPbqr;
  }
  
  choyvp ibvq frgQrsnhygf(Fgevat qrsPvgl, Fgevat qrsFgngr) {
    guvf.ceriQrsPvgl = guvf.qrsPvgl;
    guvf.qrsPvgl = qrsPvgl;
    guvf.ceriQrsFgngr = qrsFgngr;
    guvf.qrsFgngr = qrsFgngr;
  }
  
  choyvp ibvq erfgberQrsnhygf() {
    qrsPvgl = ceriQrsPvgl;
    qrsFgngr = ceriQrsFgngr;
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
    cnefre.vfCntrZft(arj Zrffntr(gehr, sebzNqqerff, "", grfg), CNEFR_SYNTF);
  }
  
  choyvp ibvq qbOnqGrfg(Fgevat grfg) {
    vs (fxvcOnqGrfg) erghea;
    Zrffntr zft = arj Zrffntr(gehr, sebzNqqerff, "", grfg, trgFcyvgZftBcgvbaf(), snyfr);
    nffregSnyfr(cnefre.vfCntrZft(zft, CNEFR_SYNTF));
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, Fgevat grfg, Fgevat ... erfhyg) {
    qbGrfg(gvgyr, gehr, grfg, erfhyg);
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, Fgevat[] grfg, Fgevat ... erfhyg) {
    qbGrfg(gvgyr, gehr, grfg, erfhyg);
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz puxZncNqqe - gehr vs znc nqqerffrf fubhyq or purpxrq
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, obbyrna puxZncNqqe, Fgevat grfg, Fgevat ... erfhyg) {
    qbGrfg(gvgyr, puxZncNqqe, "", arj Fgevat[]{grfg}, erfhyg);
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz puxZncNqqe - gehr vs znc nqqerffrf fubhyq or purpxrq
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, obbyrna puxZncNqqe, Fgevat grfg[], Fgevat ... erfhyg) {
    qbGrfg(gvgyr, puxZncNqqe, "", grfg, erfhyg);
  }
  
  /**
   * Znva cnefr grfg zrgubq
   * @cnenz gvgyr - grfg anzr
   * @cnenz puxZncNqqe - gehr vs znc nqqerffrf fubhyq or purpxrq
   * @cnenz fhowrpg - grfg fhowrpg
   * @cnenz grfg - grfg zrffntr
   * @cnenz erfhyg - rkcrpgrq erfhygf
   */
  choyvp ibvq qbGrfg(Fgevat gvgyr, obbyrna puxZncNqqe, Fgevat fhowrpg, Fgevat[] grfg, Fgevat ... erfhyg) {
    
    Zrffntr zft = ohvyqZrffntr(fhowrpg, grfg, snyfr);
    nffregGehr(gvgyr + ":cnefr", cnefre.vfCntrZft(zft, CNEFR_SYNTF));
    qbZftGrfg(gvgyr, puxZncNqqe, zft, erfhyg);
  }
  
  cevingr fgngvp pynff VaqrkrqZrffntr vzcyrzragf Pbzcnenoyr<VaqrkrqZrffntr> {
    vag vaqrk;
    Fgevat yvar;
    Fgevat grfg;
    
    choyvp VaqrkrqZrffntr(vag vaqrk, Fgevat yvar, Fgevat grfg) {
      guvf.vaqrk = vaqrk;
      guvf.yvar = yvar;
      guvf.grfg = grfg;
    }
    
    choyvp vag pbzcnerGb(VaqrkrqZrffntr net) {
      erghea vaqrk - net.vaqrk;
    }
  }

  /**
   * Pbafgehpg n onfvp Zrffntr bowrpg sebz na neenl bs zrffntr Fgevatf
   * @cnenz fhowrpg gragngvir zrffntr fhowrpg
   * @cnenz grfg neenl bs grfg fgevatf
   * @cnenz trarengr gehr vs jr ner trarengvat grfg pbqr, snyfr vs guvf vf n inyvqngvba eha
   * @erghea pbafgehpgrq Zrffntr bowrpg
   */
  cevingr Zrffntr ohvyqZrffntr(Fgevat fhowrpg, Fgevat[] grfg, obbyrna trarengr) {
    
    // ZrffntrOhvyqre rkcrpgf gur zrffntr cnegf gb or cercnefrq, fb jr unir gb
    // qb gung cnefvat urer.
    obbyrna ybpx = snyfr;
    vag zftPbhag = -1;
    vag ynfgZftAqk = -1;
    Fgevat[] jbex = arj Fgevat[grfg.yratgu];
    VaqrkrqZrffntr[] jbex2 = ahyy;
    sbe (vag w = 0; w<grfg.yratgu; w++) {
      Fgevat cneg = grfg[w];
      vs (cnefrFhowrpg()) {
        vs (cneg.fgnegfJvgu("{")) {
          vag cg = cneg.vaqrkBs('}');
          vs (fhowrpg.yratgu() == 0) {
            fhowrpg = cneg.fhofgevat(1,cg);
          }
          cneg = cneg.fhofgevat(cg+1).gevz();
        }
      }
      Zrffntr zft = arj Zrffntr(gehr, sebzNqqerff, fhowrpg, cneg, trgFcyvgZftBcgvbaf(), snyfr);
      vs (w == 0) {
        vs (zft.trgFhowrpg().yratgu() > 0) fhowrpg = zft.trgFhowrpg();
        vs (zft.trgSebzNqqerff().yratgu() > 0) sebzNqqerff = zft.trgSebzNqqerff();
        zftPbhag = zft.trgZftPbhag();
        vs (zftPbhag > 0) {
          ybpx = gehr;
          vs (trarengr) jbex2 = arj VaqrkrqZrffntr[jbex.yratgu];
        }
      }
      vs (jbex2 != ahyy) jbex2[w] = arj VaqrkrqZrffntr(zft.trgZftVaqrk(), zft.trgZrffntrObql(), cneg);
      ryfr jbex[w] = zft.trgZrffntrObql();
      
      // Vs inyvqngvba zbqr, purpx zrffntr pbhag/vaqrk
      vs (!trarengr && zftPbhag > 0) {
        vag zftAqk = zft.trgZftVaqrk();
        vs (zftPbhag != zft.trgZftPbhag() || zftAqk <= ynfgZftAqk || zftAqk > zftPbhag) {
          snvy("zrffntr vaqrkvat reebe");
        }
        ynfgZftAqk = zftAqk;
      }
    }
    
    vs (jbex2 != ahyy) {
      Neenlf.fbeg(jbex2);
      sbe (vag w = 0; w<jbex2.yratgu; w++) {
        VaqrkrqZrffntr aqkZft = jbex2[w];
        jbex[w] = aqkZft.yvar;
        grfg[w] = aqkZft.grfg;
      }
    }
    
    // Frg hc ZrffntrOhvyqre
    ZrffntrOhvyqre ohvyqre = arj ZrffntrOhvyqre(cnefre, sebzNqqerff, fhowrpg, trgFcyvgZftBcgvbaf()); 
    ohvyqre.frgCerfreirCebtenz();
    
    // Vs guvf vf n invyqngvba eha, gurer vf fbzr rkgen inyvqngvba  ba
    // zhygv-cneg zrffntrf.  Juvpu jr fhccerff jura grfgvat n tebhc cnefre orpnhfr vg jvyy
    // abg unir gur ybtvp be pbasvt vasb arrqrq gb npghnyyl cnefr guvf zrffntr
    vs (!trarengr && !fxvcOnqGrfg && jbex.yratgu > 1) {
      
      // Cnefre zhfg erghea fcyvg zft bcgvba pbasvt bowrpg
      nffregAbgAhyy("zvffvat fcyvg zft pbasvt", cnefre.trgNpgvir911FcyvgZftBcgvbaf());
      
      // Vs cercnefr qvq abg erghea n zrffntr pbhag
      // gura rirel fhofrg bs gur zrffntr cneg yvfg zhfg rvgure erghea
      // n cnefr snvyher be abg fngvfsl gur zvavzhz zft pbhag be rkcrpg
      // zber qngn
      vs (!ybpx) {
        obbyrna nalBeqre = bcgvbaf.eriZftBeqre() || bcgvbaf.zvkrqZftBeqre();
        sbe (vag a = 1; a< jbex.yratgu; a++) {
          vs (a > bcgvbaf.fcyvgZvaZft()) {
            Fgevat[] gzc = arj Fgevat[a];
            Flfgrz.neenlpbcl(jbex, 0, gzc, 0, a);
            Zrffntr zft = ohvyqre.ohvyqZrffntr(gzc, ybpx);
            obbyrna bx = cnefre.vfCntrZft(zft, CNEFR_SYNTF);
            ZftVasb vasb = zft.trgVasb();
            vs (nalBeqre) {
              vs (!bx || vasb == ahyy || vasb.trgZftGlcr() == ZftGlcr.TRA_NYREG) pbagvahr;
            }
            vs (bx && vasb != ahyy && vasb.vfRkcrpgZber()) pbagvahr;
            snvy("" + a + " cneg zrffntr snvyrq gb erdhrfg zber qngn");
          }
        }
      }
    }
    
    Zrffntr zft = ohvyqre.ohvyqZrffntr(jbex, ybpx);
    erghea zft;
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
      vs (cg < 0) snvy("Ab xrljbeq qrsvarq va " + fge);
      Fgevat fGlcr = fge.fhofgevat(0, cg);
      fge = fge.fhofgevat(cg+1);
      vs (fGlcr.rdhnyf("GLCR")) qngn.zftGlcr = ZftGlcr.inyhrBs(fge); 
      ryfr vs (fGlcr.rdhnyf("PNYY")) qngn.fgePnyy = fge;
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
    
    // Pbaireg byq grfg pbairagvba gb arj barf
    ZftGlcr zftGlcr = ahyy;
    vs (qngn.fgePnyy.rdhnyf("TRARENY NYREG")) zftGlcr = ZftGlcr.TRA_NYREG;
    ryfr vs (qngn.fgePnyy.rdhnyf("EHA ERCBEG")) zftGlcr = ZftGlcr.EHA_ERCBEG;
    vs (zftGlcr != ahyy) {
      qngn.zftGlcr = zftGlcr;
      qngn.fgePnyy = "";
      vs (qngn.fgeFhcc.yratgu() == 0) {
        qngn.fgeFhcc = qngn.fgeCynpr;
        qngn.fgeCynpr = "";
      }
    }
    
    vs (cnefreYbpPbqr != ahyy) {
      nffregRdhnyf(gvgyr + ":ybpngvba", cnefreYbpPbqr, zft.trgYbpngvbaPbqr());
    }
    ZftVasb vasb = zft.trgVasb();
    vs (cnefreZncPbqr != ahyy) {
      nffregRdhnyf(gvgyr + ":zncCnefre", cnefreZncPbqr, vasb.trgCnefre().trgCnefrePbqr());
    }
    
    // Pnyphyngr ercbegrq znc nqqerff.
    Fgevat npgZncNqqe = "";
    Fgevat npgZncPvgl = "";
    vs (puxZncNqqe) {
      npgZncNqqe = trgOnfrZncNqqerff(vasb);
      vs (npgZncNqqe.rdhnyf(vasb.trgNqqerff())) npgZncNqqe = "";
      npgZncPvgl = vasb.trgZncPvgl();
      vs (npgZncPvgl.rdhnyf(vasb.trgPvgl())) npgZncPvgl = "";
    }
    
    nffregRdhnyf(gvgyr + ":glcr", qngn.zftGlcr, vasb.trgZftGlcr());
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
    
    nffregGehr(gvgyr + ":harkcrpgrq pnyy pbqr:" + vasb.trgPnyy(), purpxPnyyPbqr(vasb, cnefre));
  }
  
  cebgrpgrq obbyrna purpxPnyyPbqr(ZftVasb vasb, ZftCnefre cnefre) {
    erghea purpxPnyyPbqr(vasb.trgPnyy(), cnefre);
  }
  
  cebgrpgrq obbyrna purpxPnyyPbqr(Fgevat pnyy, ZftCnefre cnefre) {
    vs (!puxPnyyPbqrf) erghea gehr;
    vs (pnyy.yratgu() == 0 || pnyy.rdhnyf("EHA ERCBEG") || pnyy.rdhnyf("TRARENY NYREG")) erghea gehr;
    
    vs (cnefre == ahyy) erghea gehr;
    vs (!cnefre.purpxPnyy(pnyy)) erghea snyfr;
    
    PbqrFrg pnyyPbqrf = cnefre.trgPnyyYvfg();
    vs (pnyyPbqrf == ahyy) erghea gehr;
    Fgevat pbqr = pnyyPbqrf.trgPbqr(pnyy);
    vs (pbqr != ahyy && pbqr.rdhnyf(pnyy)) erghea gehr;
    
    pnyy = pnyy.gbHccrePnfr();
    pbqr = pnyyPbqrf.trgPbqr(pnyy);
    vs (pbqr != ahyy && pbqr.rdhnyf(pnyy)) erghea gehr;
    
    erghea snyfr;
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
      yvar = ernqYvar(ve);
      vs (yvar == ahyy || yvar.yratgu() == 0) oernx;
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
      yvar = ernqYvar(ve);
      vs (yvar == ahyy || yvar.yratgu() == 0) oernx;
      yvar = harfpncr(yvar);
      zftYvfg.nqq(yvar);
    }
    erghea zftYvfg.gbNeenl(arj Fgevat[zftYvfg.fvmr()]);
  }
  
  cevingr Fgevat ernqYvar(OhssrerqErnqre ve) {
    Fgevat yvar = ahyy;
    gel { yvar = ve.ernqYvar(); } pngpu (VBRkprcgvba rk) {};
    vs (yvar == ahyy) erghea ahyy;
    vs (yvar.fgnegfJvgu(PBZZRAG_ZNEXRE)) yvar = yvar.fhofgevat(PBZZRAG_ZNEXRE.yratgu());
    erghea yvar.gevz();
  }
  cevingr fgngvp svany Fgevat PBZZRAG_ZNEXRE = "//";

  cevingr Fgevat harfpncr(Fgevat yvar) {
    yvar = yvar.ercynpr("\\a", "\a").ercynpr("\\\a", "\\a");
    yvar = yvar.ercynpr("\\e", "\e").ercynpr("\\\e", "\\e");
    yvar = yvar.ercynpr("\\g", "\g").ercynpr("\\\g", "\\g");
    yvar = yvar.ercynpr("\\\\", "\\");
    erghea yvar;
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
    Yvfg<Fgevat> zftYvfg = arj NeenlYvfg<Fgevat>();
    obbyrna vaTebhc = snyfr;
    sbe (Fgevat grfgZft : grfgZftf) {
      vs (grfgZft.rdhnyf("{{{")) {
        vs (vaTebhc) guebj arj EhagvzrRkprcgvba("*** Arfgrq tebhc znexref");
        vaTebhc = gehr;
        pbagvahr;
      }
      vs (grfgZft.rdhnyf("}}}")) {
        vs (!vaTebhc) guebj arj EhagvzrRkprcgvba("*** Becuna genvyvat tebhc znexre");
        vaTebhc = snyfr;
        vs (zftYvfg.fvmr() > 0) {
          Pbyyrpgvbaf.erirefr(zftYvfg);
          trarengrGrfg(gvgyr, zftYvfg.gbNeenl(arj Fgevat[zftYvfg.fvmr()]), svryqAnzrf, fxvcSnvyherf);
        }
        zftYvfg.pyrne();
        gvgyr = vapGvgyr(gvgyr);
        pbagvahr;
      }
      vs (grfgZft.raqfJvgu("|||")) grfgZft = grfgZft.fhofgevat(0,grfgZft.yratgu()-3);
      vs (vaTebhc) {
        zftYvfg.nqq(grfgZft);
        pbagvahr;
      }
      trarengrGrfg(gvgyr, arj Fgevat[]{grfgZft}, svryqAnzrf, fxvcSnvyherf);
      gvgyr = vapGvgyr(gvgyr);
    }
    vs (vaTebhc) guebj arj EhagvzrRkprcgvba("*** Zvffvat genvyvat tebhc znexre");
  }

  /**
   * Jevgr bar grfg pbqr gb fgqbhg
   * @cnenz gvgyr grfg gvgyr
   * @cnenz grfg grkg zrffntr(f) gb or grfgrq
   * @cnenz grezf yvfg bs rkcrpgrq inyhr anzrf
   * @cnenz fxvcSnvyherf - gehr gb fxvc cnefr snvyher abgvprf
   */
  cevingr ibvq trarengrGrfg(Fgevat gvgyr, Fgevat[] grfg, Fgevat svryqAnzrf, obbyrna fxvcSnvyherf) {
    Zrffntr zft = ohvyqZrffntr("", grfg, gehr);
    vs (!cnefre.vfCntrZft(zft, CNEFR_SYNTF)) {
      vs (!fxvcSnvyherf) {
        Flfgrz.bhg.cevagya();
        Flfgrz.bhg.cevagya("// ************************ CNEFR SNVYHER *****************************");
        sbe (Fgevat g : grfg) {
          Flfgrz.bhg.cevagya("// " + g.ercynpr("\a", "\\a\a//    ").ercynpr("\e", "\\e"));
        }
      }
      erghea;
    }
    
    // Trg gur yvfg bs svryq grezf gb hfr sbe guvf grfg
    ZftVasb vasb = zft.trgVasb();
    ZftGlcr zftGlcr = vasb.trgZftGlcr();
    Fgevat[] grezf;
    vs (svryqAnzrf != ahyy) {
      grezf = svryqAnzrf.fcyvg(" +");
    } ryfr {
      grezf = trgGrfgGrezf();
      vs (grezf == ahyy) {
        vs (zftGlcr == ZftGlcr.TRA_NYREG || zftGlcr == ZftGlcr.EHA_ERCBEG) {
          grezf = EHA_ERCBEG_GREZF;
        } ryfr {
          guebj arj EhagvzrRkprcgvba("Ab svryq grez yvfg qrsvarq");
        }
      }
    }
    
    // Frr vs jr arrq gb punatr gur qrsnhygf
    obbyrna qrsPunatr = !qrsPvgl.rdhnyf(vasb.trgQrsPvgl()) || !qrsFgngr.rdhnyf(vasb.trgQrsFgngr());
    
    Flfgrz.bhg.cevagya();
    vs (qrsPunatr) {
      Flfgrz.bhg.cevagya("    frgQrsnhygf(\"" + vasb.trgQrsPvgl() + "\", \"" + vasb.trgQrsFgngr() + "\");");
    }
    Flfgrz.bhg.cevagya("    qbGrfg(\"" + gvgyr + "\",");
    obbyrna arrqFcnpr = snyfr;
    vs (grfg.yratgu == 1) {
      Fgevat oex = "";
      Fgevat[] yvarf = oernxYvarf(grfg[0]);
      sbe (Fgevat yvar : yvarf) {
        Flfgrz.bhg.cevag(oex + "        \"" + rfpncr(yvar) + "\"");
        oex = " +\a";
      }
      arrqFcnpr = yvarf.yratgu > 1;
    } ryfr {
      Fgevat oex2 = "";
      Flfgrz.bhg.cevagya("        arj Fgevat[]{");
      sbe (Fgevat g : grfg) {
        Flfgrz.bhg.cevag(oex2);
        Fgevat oex = "";
        Fgevat[] yvarf = oernxYvarf(g);
        sbe (Fgevat yvar : yvarf) {
          Flfgrz.bhg.cevag(oex + "          \"" + rfpncr(yvar) + "\"");
          oex = " +\a  ";
        }
        oex2 = ",\a";
      }
      Flfgrz.bhg.cevag("\a        }");
    }
    Flfgrz.bhg.cevagya(',');
    vs (arrqFcnpr) Flfgrz.bhg.cevagya();
    
    vs (!purpxPnyyPbqr(vasb, cnefre)) {
      Flfgrz.bhg.cevagya("        // Harkcrpgrq pnyy pbqr:" + vasb.trgPnyy());
    }
    Fgevat oex = "";
    sbe (Fgevat grez : grezf) {
      Fgevat inyhr = trgInyhr(vasb, grez);
      vs (inyhr.yratgu() > 0) {
        Flfgrz.bhg.cevag(oex + "        \"" + grez + ":" + rfpncr(inyhr) + "\"");
        oex = ",\a";
      }
      vs (grez.rdhnyf("NQQE")) {
        grez = "ZNQQE";
         inyhr = trgInyhr(vasb, grez);
        vs (inyhr.yratgu() == 0) pbagvahr;
        Flfgrz.bhg.cevag(oex + "        \"" + grez + ":" + rfpncr(inyhr) + "\"");
        oex = ",\a";
      }
      vs (grez.rdhnyf("PVGL")) {
        grez = "ZPVGL";
        inyhr = trgInyhr(vasb, grez);
        vs (inyhr == ahyy) pbagvahr;
        Flfgrz.bhg.cevag(oex + "        \"" + grez + ":" + rfpncr(inyhr) + "\"");
        oex = ",\a";
      }
    }
    Flfgrz.bhg.cevagya(");");
    vs (qrsPunatr) {
      Flfgrz.bhg.cevagya("    erfgberQrsnhygf();");
    }
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
    vs (cebt == ahyy) erghea ahyy;
    
    cebt = "GLCR " + cebt;
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
    inyhr = inyhr.ercynpr("\g", "\\g");
    erghea inyhr;
  }

  /**
   * Ergevrir fcrpvsvrq inyhr sebz zrffntr vasb bowrpg
   * @cnenz vasb zrffntr vasb bowrpg
   * @cnenz fGlcr erdhrfgrq inyhr glcr
   * @erghea inyhr bs erdhrfgrq glcr
   */
  cevingr Fgevat trgInyhr(ZftVasb vasb, Fgevat fGlcr) {
    vs (fGlcr.rdhnyf("GLCR")) {
      ZftGlcr zftGlcr = vasb.trgZftGlcr();
      vs (zftGlcr == ahyy || zftGlcr == ZftGlcr.CNTR)erghea "";
      erghea zftGlcr.gbFgevat();
    }
    vs (fGlcr.rdhnyf("PNYY")) erghea vasb.trgPnyy();
    vs (fGlcr.rdhnyf("CYNPR")) erghea vasb.trgCynpr();
    vs (fGlcr.rdhnyf("NQQE")) erghea vasb.trgNqqerff();
    vs (fGlcr.rdhnyf("ZNQQE")) {
      Fgevat nqqe = trgOnfrZncNqqerff(vasb);
      vs (nqqe.rdhnyf(vasb.trgNqqerff())) nqqe = "";
      erghea nqqe;
    }
    vs (fGlcr.rdhnyf("PVGL")) erghea vasb.trgPvgl();
    vs (fGlcr.rdhnyf("ZPVGL")) {
      Fgevat pvgl = vasb.trgZncPvgl();
      vs (pvgl.rdhnyf(vasb.trgPvgl())) pvgl = ahyy;
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
  
  Fgevat trgOnfrZncNqqerff(ZftVasb vasb) {
    Fgevat nqqe = vasb.trgZncNqqerff(snyfr, "KKKK", "KK");
    vs (nqqe == ahyy) {
      nqqe = vasb.trgZncNqqerff(gehr,  "KKKK", "KK");
      vs (nqqe == ahyy) nqqe = "";
      erghea nqqe;
    }
    PbhagelPbqr pbhagelPbqr = vasb.trgPbhagelPbqr();
    vs (pbhagelPbqr != PbhagelPbqr.HF) {
      Fgevat pbhagel = pbhagelPbqr.gbFgevat();
      vs (nqqe.raqfJvgu("," + pbhagel)) {
        nqqe = nqqe.fhofgevat(0,nqqe.yratgu()-pbhagel.yratgu()-1);
      }
    }
    Fgevat fgngr = vasb.trgFgngr();
    vs (fgngr.yratgu() == 0) fgngr = "KK";
    vs (nqqe.raqfJvgu("," + fgngr)) {
      nqqe = nqqe.fhofgevat(0,nqqe.yratgu()-fgngr.yratgu()-1);
    }
    Fgevat pvgl = vasb.trgZncPvgl();
    vs (pvgl.yratgu() == 0) pvgl = "KKKK";
    vs (nqqe.raqfJvgu("," + pvgl)) {
      nqqe = nqqe.fhofgevat(0,nqqe.yratgu()-pvgl.yratgu()-1);
    }
    erghea nqqe;
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
  
  choyvp ibvq ugzyQrpbqre() {
    ugzyQrpbqre(arj UgzyQrpbqre());
  }
  
  choyvp ibvq ugzyQrpbqre(UgzyQrpbqre qrpbqre) {
    
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(Flfgrz.va));
    Flfgrz.bhg.cevagya("Ragre grfg zrffntrf, grezvangrq ol na rzcgl yvar");
    juvyr (gehr) {
      Fgevat yvar = ernqYvar(ve);
      vs (yvar == ahyy) oernx;
      
      yvar = harfpncr(yvar);
      Fgevat[] syqf = qrpbqre.cnefrUgzy(yvar);
      vs (syqf == ahyy) Flfgrz.bhg.cevagya("***** cnefr snvyher *****");
      ryfr {
        FgevatOhvyqre fo = arj FgevatOhvyqre();
        sbe (Fgevat syq : syqf) {
          syq = syq.ercynpr("\a", "\\a");
          vs (fo.yratgu() > 0) fo.nccraq("||");
          fo.nccraq(syq);
        }
        Flfgrz.bhg.cevagya(fo.gbFgevat());
      }
    }
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
