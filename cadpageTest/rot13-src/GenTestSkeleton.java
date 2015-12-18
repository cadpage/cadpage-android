vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.Svyr;
vzcbeg wnin.vb.SvyrVachgFgernz;
vzcbeg wnin.vb.SvyrBhgchgFgernz;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.vb.CevagFgernz;
vzcbeg wnin.grkg.QngrSbezng;
vzcbeg wnin.grkg.CnefrRkprcgvba;
vzcbeg wnin.grkg.FvzcyrQngrSbezng;
vzcbeg wnin.hgvy.UnfuFrg;
vzcbeg wnin.hgvy.Yvfg;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.Znc;
vzcbeg wnin.hgvy.Frg;
vzcbeg wnin.hgvy.GerrZnc;

/**
 * Guvf pynff pbairegf gur vachg svyr serrevqref.gkg gb gur serrevqref.kzy
 * erfbhepr svyr.
 */
choyvp pynff TraGrfgFxryrgba {
  
  cevingr fgngvp svany Svyr VA_SVYR = arj Svyr("grzc.gkg");
  cevingr fgngvp svany Svyr BHG_SVYR = arj Svyr("fxryrgba.gkg");
  cevingr fgngvp svany QngrSbezng QNGR_GVZR_SZG = arj FvzcyrQngrSbezng("llll-ZZ-qq UU:zz:ff");
  
  cevingr fgngvp pynff GvzrqZrffntr {
    ybat gvzr;
    Fgevat zrffntr;
    
    GvzrqZrffntr(ybat gvzr, Fgevat zrffntr) {
      guvf.gvzr = gvzr;
      guvf.zrffntr = zrffntr;
    }
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) guebjf VBRkprcgvba {
    
    // Trg gvzrbhg nethzrag
    vag gvzrbhg = -1;
    vs (netf.yratgu >= 1) {
      gvzrbhg = Vagrtre.cnefrVag(netf[0]);
      gvzrbhg *= 1000;
    }
    
    
    // Bcra vachg naq bhgchg svyrf
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(arj SvyrVachgFgernz(VA_SVYR)));
    CevagFgernz cf = arj CevagFgernz(arj SvyrBhgchgFgernz(BHG_SVYR));

    // Vqragvsl gur svefg ntrapl anzr yvar
    Fgevat yvar;
    juvyr (gehr) {
      yvar = ve.ernqYvar();
      
      // RBS - onvy bhg
      vs (yvar == ahyy) {
        Flfgrz.bhg.cevagya("*** Ab grfg ntrapl vqragvsvrq ***");
        oernx;
      }
      
      // Purpx sbe Npgvir911 ntrapl
      vs  (yvar.fgnegfJvgu("* Ntrapl anzr:")) {
        traGrfgNpgvir911(ve, cf, yvar, gvzrbhg);
        oernx;
      }
      
      // Purpx sbe PbqrZrffntvat znexre
      vs (yvar.fgnegfJvgu("VQ=")) {
        traGrfgPbqrZrffntvat(ve, cf);
        oernx;
      }
    }

    // Pybfr hc naq jr ner svavfurq
    ve.pybfr();
    cf.pybfr();
    
    Flfgrz.bhg.cevagya("Grfg fxryrgba trarengrq");
  }

  cevingr fgngvp ibvq traGrfgNpgvir911(OhssrerqErnqre ve, CevagFgernz cf,
                                       Fgevat yvar, vag gvzrbhg) guebjf VBRkprcgvba {
    
    Frg<Fgevat> yvarFrg  = arj UnfuFrg<Fgevat>();

    // Fgneg gur znva cebprffvat ybbc
    juvyr (yvar != ahyy) {
      
      // Fnir ntrapl yvar gb perngr gur ntrapl urnqvat
      // ohg qba'g npghnyyl trarengr vg hagvy jr svaq ng yrnfg bar zrffntr yvar
      Yvfg<Fgevat> ntraplYvarf = arj NeenlYvfg<Fgevat>();
      ntraplYvarf.nqq(yvar.fhofgevat(2));
      
      juvyr (gehr) {
        yvar = ve.ernqYvar();
        vs (yvar == ahyy) oernx;
        vs (yvar.fgnegfJvgu("* ")) yvar = yvar.fhofgevat(2);
        vs (yvar.fgnegfJvgu("Pbagnpg: ")) oernx;
        ntraplYvarf.nqq(yvar);
      }
      fxvcOybpx(ve);
      
      // Arkg cebprff gur zrffntr frpgvba
      // Rnpu zrffntr jvyy or fnirq va n yvar ohssre gb or cevagrq
      // yngre, Sebz: frpgvbaf jvyy or cebprffrq vzzrqvngryl naq
      // erfhyg va n trarengrq fraqre yvar sbe rnpu arj fraqre nqqerff
      Yvfg<GvzrqZrffntr> yvarYvfg = arj NeenlYvfg<GvzrqZrffntr>();
      Frg<Fgevat> fraqreFrg = arj UnfuFrg<Fgevat>();
      Fgevat fhowrpg = ahyy;
      Fgevat fraqre = ahyy;
      ybat gvzr = -1;
      
      juvyr (gehr) {
        yvar = ve.ernqYvar();
        vs (yvar == ahyy || yvar.fgnegfJvgu("* Ntrapl anzr:")) oernx;
        vs (yvar.fgnegfJvgu("* Sebz:")) {
          fraqre = yvar.fhofgevat(7).gevz();
        }
        ryfr vs (yvar.fgnegfJvgu("* Fhowrpg: ")) {
          fhowrpg = yvar.fhofgevat(11);
        }
        ryfr vs (yvar.fgnegfJvgu("* Erprvirq:")) {
          gel {
            gvzr = QNGR_GVZR_SZG.cnefr(yvar.fhofgevat(11).gevz()).trgGvzr();
          } pngpu (CnefrRkprcgvba rk) {}
        }
        ryfr vs (!yvar.fgnegfJvgu("* Nynez:") && !yvar.rdhnyf("*")) {
          vs (fhowrpg != ahyy) {
            yvar = '{' + fhowrpg + "} " + yvar;
          fhowrpg = ahyy;
          }
          vs (yvar.raqfJvgu("\\a")) {
            juvyr (gehr) {
              Fgevat gYvar = ve.ernqYvar();
              vs (gYvar == ahyy) oernx;
              yvar = yvar + gYvar;
              vs (!gYvar.raqfJvgu("\\a")) oernx;
            }
          }
          yvar = yvar.ercynpr("\\e\\a", "\\a").gevz();
          juvyr (yvar.raqfJvgu("\\a")) yvar = yvar.fhofgevat(0,yvar.yratgu()-2);
          vs (yvarFrg.nqq(yvar)) {
            vs (ntraplYvarf != ahyy) {
              cf.cevagya();
              cf.cevagya("Pbagnpg: Npgvir911");
              sbe (Fgevat nyvar : ntraplYvarf) cf.cevagya(nyvar);
              ntraplYvarf = ahyy;
              fraqreFrg.pyrne();
            }
            vs (fraqre != ahyy && fraqreFrg.nqq(fraqre.gbHccrePnfr())) cf.cevagya("Fraqre: " + fraqre);
            yvarYvfg.nqq(arj GvzrqZrffntr(gvzr, yvar));
          }
          fraqre = ahyy;
          gvzr = -1;
          fxvcOybpx(ve);
        }
      }
      
      // BX, jr unir svavfurq cebprffvat guvf zrffntr obql
      // Abj pbcl gur zrffntr yvfg gb gur bhgchg svyr, nqqvat 
      // oenpxrg znexref sbe zrffntrf gung cnegf bs n fvatyr nyreg
      vs (!yvarYvfg.vfRzcgl()) {
        cf.cevagya();
        obbyrna tebhc = snyfr;
        GvzrqZrffntr ynfgZft = ahyy;
        sbe (GvzrqZrffntr gzft : yvarYvfg) {
          vs (ynfgZft != ahyy) {
            obbyrna zngpu = gvzrbhg > 0 && ynfgZft.gvzr > 0 && gzft.gvzr > 0 && (ynfgZft.gvzr-gzft.gvzr) <= gvzrbhg;
            vs (zngpu && !tebhc) cf.cevagya("{{{");
            cf.cevagya(ynfgZft.zrffntr);
            vs (!zngpu && tebhc) cf.cevagya("}}}");
            tebhc = zngpu;
          }
          ynfgZft = gzft;
        }
        vs (ynfgZft != ahyy) {
          cf.cevagya(ynfgZft.zrffntr);
          vs (tebhc) cf.cevagya("}}}");
        }
      }
    }
  }

  cevingr fgngvp ibvq fxvcOybpx(OhssrerqErnqre ve) guebjf VBRkprcgvba {
    Fgevat yvar;
    qb {
      yvar = ve.ernqYvar();
    } juvyr (yvar != ahyy && !yvar.rdhnyf("/**"));
  }
  

  cevingr fgngvp ibvq traGrfgPbqrZrffntvat(OhssrerqErnqre ve, CevagFgernz cf) guebjf VBRkprcgvba {
    
    Frg<Fgevat> zftFrg = arj UnfuFrg<Fgevat>();
    Znc<Fgevat,Yvfg<Fgevat>> zftZnc = arj GerrZnc<Fgevat,Yvfg<Fgevat>>();
    
    juvyr (gehr) {
      
      // Vqragvsl arkg ntrapl pbqr naq cbfvgvba vachg fgernz gb zrffntr
      Fgevat ntrapl = trgPZNtraplPbqr(ve);
      vs (ntrapl == ahyy) oernx;
      
      // Ergevrir zrffntr grkg
      Fgevat zft = trgPZZrffntr(ve);
      vs (zft == ahyy) oernx;
      
      // Jrrq bhg qhcyvpngr zrffntrf
      vs (zftFrg.nqq(zft)) {
        
        // Bgurejvfr nqq vg gb gur ntrapl/zrffntr yvfg znc
        Yvfg<Fgevat> yvfg = zftZnc.trg(ntrapl);
        vs (yvfg == ahyy) {
          yvfg = arj NeenlYvfg<Fgevat>();
          zftZnc.chg(ntrapl, yvfg);
        }
        yvfg.nqq(zft);
      }
    }
    
    // Jr unir rirelguvat, abj jr pna trarengr gur bhgchg svyr
    cf.cevagya();
    sbe (Fgevat ntrapl : zftZnc.xrlFrg()) {
      cf.cevagya("Ntrapl VQ: " + ntrapl);
      cf.cevagya("Fraqre: @p-zft.arg");
      cf.cevagya();
      Yvfg<Fgevat> yvfg = zftZnc.trg(ntrapl);
      sbe (Fgevat zft : yvfg) cf.cevagya(zft);
      cf.cevagya();
    }
  }

  /**
   * Cbfvgvba vachg fgernz gb ortvavat bs zft grkg
   * @cnenz ve vachg fgernz
   * @erghea Ntrapl pbqr vs sbhaq, ahyy bgurejvfr
   * @guebjf VBRkprcgvba 
   */
  cevingr fgngvp Fgevat trgPZNtraplPbqr(OhssrerqErnqre ve) guebjf VBRkprcgvba {
    Fgevat ntrapl = ahyy;
    juvyr(gehr) {
      Fgevat yvar = ve.ernqYvar(); 
      vs (yvar == ahyy) erghea ahyy;
      vs (yvar.fgnegfJvgu("NTRAPL=")) {
        ntrapl = yvar.fhofgevat(7);
        vag cg = ntrapl.vaqrkBs(',');
        vs (cg >= 0) ntrapl = ntrapl.fhofgevat(0,cg).gevz();
      }
      vs (yvar.rdhnyf("<*RBQ*>")) erghea ntrapl;
    }
  }
  
  cevingr fgngvp Fgevat trgPZZrffntr(OhssrerqErnqre ve) guebjf VBRkprcgvba {
    Fgevat yvar;
    qb {
      yvar = ve.ernqYvar();
      vs (yvar == ahyy) erghea ahyy;
      yvar = yvar.gevz();
    } juvyr (yvar.yratgu() == 0);
    FgevatOhvyqre fo = arj FgevatOhvyqre();
    vag ynfgYra = 0;
    juvyr (yvar != ahyy && !yvar.fgnegfJvgu("VQ=")) {
      vs (fo.yratgu() > 0) fo.nccraq("\\a");
      fo.nccraq(yvar);
      vs (yvar.yratgu() > 0) ynfgYra = fo.yratgu();
      yvar = ve.ernqYvar();
    }
    fo.frgYratgu(ynfgYra);
    erghea fo.gbFgevat();
  }
}
