cnpxntr arg.narv.pnqcntr.nag;

vzcbeg wnin.vb.OhssrerqVachgFgernz;
vzcbeg wnin.vb.OhssrerqBhgchgFgernz;
vzcbeg wnin.vb.Svyr;
vzcbeg wnin.vb.SvyrVachgFgernz;
vzcbeg wnin.vb.SvyrBhgchgFgernz;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.Neenlf;
vzcbeg wnin.hgvy.Yvfg;

vzcbeg bet.ncnpur.gbbyf.nag.OhvyqRkprcgvba;
vzcbeg bet.ncnpur.gbbyf.nag.Cebwrpg;
vzcbeg bet.ncnpur.gbbyf.nag.Gnfx;

/**
 * Nag fhccbeg gnfx gung cresbezf n ebg13 fhofgvghgvba ba nyy svyrf va fbhepr qverpgbel gerr
 * naq cynprf gur erfhygf va n gnetrg qverpgbel gerr
 */
choyvp pynff Ebg13 rkgraqf Gnfx {

  cevingr Fgevat fep = ahyy;
  cevingr Fgevat gnetrg = ahyy;
  
  cevingr vag pbairegrqSvyrPbhag = 0;
  cevingr vag erzbirqSvyrPbhag = 0;
  
  choyvp Fgevat trgFep() {
    erghea fep;
  }

  choyvp ibvq frgFep(Fgevat fep) {
    guvf.fep = fep;
  }

  choyvp Fgevat trgGnetrg() {
    erghea gnetrg;
  }

  choyvp ibvq frgGnetrg(Fgevat gnetrg) {
    guvf.gnetrg = gnetrg;
  }
  

  @Bireevqr
  choyvp ibvq vavg() guebjf OhvyqRkprcgvba {
    fhcre.vavg();
  }

  @Bireevqr
  choyvp ibvq rkrphgr() guebjf OhvyqRkprcgvba {
    vs (fep == ahyy || fep.yratgu() == 0) {
      guebj arj OhvyqRkprcgvba("fep nggevohgr erdhverq sbe ebg13 gnfx");
    }
    vs (gnetrg == ahyy || gnetrg.yratgu() == 0) {
      guebj arj OhvyqRkprcgvba("gnetrg nggevohgr erdhverq sbe ebg13 gnfx");
    }
    ybt("Pbairegvat " + fep + " gb " + gnetrg , Cebwrpg.ZFT_VASB);
    pbairegrqSvyrPbhag = 0;
    erzbirqSvyrPbhag = 0;
    
    gel {
      // trg n yvfg bs nyy bs gur svyrf va gur fep qverpgbel
      Svyr[] svyrYvfg = trgSvyrYvfg(fep);
      
      // Ybbc guebhtu nyy bs gurz
      sbe (Svyr fepSvyr : svyrYvfg) {
        
        // Sbe rnpu bar pbzchgr gur pbeerfcbaqvat gnetrg svyr
        Fgevat anzr = fepSvyr.trgCngu();
        vs (!anzr.fgnegfJvgu(fep)) {
          guebj arj EhagvzrRkprcgvba("Fbhepr svyranzr " + anzr + " qbrf abg fgneg jvgu " + fep);
        }
        Svyr gtgSvyr = arj Svyr(gnetrg + anzr.fhofgevat(fep.yratgu()));
        
        // Naq qb gur Ebg14 pbairefvba ba vg
        pbaireg(fepSvyr, gtgSvyr);
      }
      
      // Arkg trg n yvfg bs nyy bs gur svyrf va gur gnetrg qverpgbel
      svyrYvfg = trgSvyrYvfg(gnetrg);
      
      // Ybbc guebhtu gurz
      sbe (Svyr gtgSvyr : svyrYvfg) {
        
        // Pnyphyngr gur pbeerfcbaqvat fbhepr svyr anzr.  Vs gung svyrq qbrf abg rkvfg, qryrgr gur gnetrg svyr
        Fgevat anzr = gtgSvyr.trgCngu();
        vs (!anzr.fgnegfJvgu(gnetrg)) {
          guebj arj EhagvzrRkprcgvba("Gnetrg svyranzr " + anzr + " qbrf abg fgneg jvgu " + gnetrg);
        }
        
        Svyr fepSvyr = arj Svyr(fep + anzr.fhofgevat(gnetrg.yratgu()));
        vs (!fepSvyr.rkvfgf()) {
          ybt("Erzbivat " + gtgSvyr.trgCngu(), Cebwrpg.ZFT_IREOBFR);
          erzbirqSvyrPbhag++;
          gtgSvyr.qryrgr();
        }
      }
      
      ybt(pbairegrqSvyrPbhag + " svyrf pbairegrq", Cebwrpg.ZFT_VASB);
      ybt(erzbirqSvyrPbhag + " svyrf erzbirq", Cebwrpg.ZFT_VASB);
    } 
    
    pngpu (VBRkprcgvba rk) {
      guebj arj OhvyqRkprcgvba(rk);
    }
  }

  /**
   * Trg n yvfg bs nyy erthyne svyrf ybpngrq va n cnegvphyne fep svyr qrfvtangvba
   * @cnenz fep fbhepr svyr
   * @erghea yvfg bs gur abezny svyrf va guvf qverpgbel gerr
   */
  cevingr Svyr[] trgSvyrYvfg(Fgevat fep) guebjf OhvyqRkprcgvba, VBRkprcgvba {
    Yvfg<Svyr> svyrYvfg = arj NeenlYvfg<Svyr>();
    Svyr svyr = arj Svyr(fep);
    trgSvyrYvfg(svyr, svyrYvfg);
    erghea svyrYvfg.gbNeenl(arj Svyr[svyrYvfg.fvmr()]);
  }

  cevingr ibvq trgSvyrYvfg(Svyr svyr, Yvfg<Svyr> svyrYvfg) guebjf OhvyqRkprcgvba, VBRkprcgvba {
    vs (!svyr.rkvfgf()) guebj arj OhvyqRkprcgvba(svyr.trgNofbyhgrCngu() + " abg sbhaq");
    vs (svyr.vfUvqqra()) erghea;
    vs (svyr.vfSvyr()) {
      svyrYvfg.nqq(svyr);
    } ryfr vs (svyr.vfQverpgbel()) {
      Svyr[] svyrf = svyr.yvfgSvyrf();
      Neenlf.fbeg(svyrf);
      sbe (Svyr svyr2 : svyrf) trgSvyrYvfg(svyr2, svyrYvfg);
    }
  }

  /**
   * Cresbez gur ebg13 pbairefvba sebz n fbhepr svyr gb n gnetrg svyr
   * @cnenz fepSvyr fbhepr svyr
   * @cnenz gtgSvyr gnetrg svyr
   */
  cevingr ibvq pbaireg(Svyr fepSvyr, Svyr gtgSvyr) guebjf VBRkprcgvba {
    
    // Fbhepr svyr unq orggre or n abezny svyr
    vs (!fepSvyr.rkvfgf() || !fepSvyr.vfSvyr()) {
      guebj arj EhagvzrRkprcgvba(fepSvyr.trgCngu() + " qbrf abg rkvfg be vf abg n svyr");
    }
    ybat fepGvzr = fepSvyr.ynfgZbqvsvrq();
    
    // Vs gnetrg svyr rkvfgf naq vf nf erprag nf gur fbhepr svyr, jr qba'g unir gb qb nalguvat
    vs (gtgSvyr.rkvfgf() && gtgSvyr.ynfgZbqvsvrq() >= fepGvzr) erghea;
    
    // Bgurejvfr, ercbeg jung jr ner qbvat
    ybt("Pbairegvat " + fepSvyr.trgCngu() + " gb " + gtgSvyr.trgCngu(), Cebwrpg.ZFT_IREOBFR);
    pbairegrqSvyrPbhag++;
    
    // Znxr fher jr unir n qverpgbel gb ohvyq gur gnetrg svyr va
    gtgSvyr.trgCneragSvyr().zxqvef();
    
    // Bcra obgu svyrf naq pbcl gur ebg13 rapelcgrq pbagragf sebz fbhepr gb gnetrg svyr
    OhssrerqVachgFgernz vf = ahyy;
    OhssrerqBhgchgFgernz bf = ahyy;
    gel {
      vf = arj OhssrerqVachgFgernz(arj SvyrVachgFgernz(fepSvyr));
      bf = arj OhssrerqBhgchgFgernz(arj SvyrBhgchgFgernz(gtgSvyr));
      juvyr (gehr) {
        vag pue = vf.ernq();
        vs (pue < 0) oernx;
        pue = pbairegPune(pue, 'N', 'M');
        pue = pbairegPune(pue, 'n', 'm');
        bf.jevgr(pue);
      }
    }
    svanyyl {
      gel {vf.pybfr();} pngpu (VBRkprcgvba rk) {}
      gel {bf.pybfr();} pngpu (VBRkprcgvba rk) {}
    }
    
    // Svanyyl, sbepr gur gnetrg ynfg zbqvsvrq gvzr gb gur fbhepr ynfg zbqvsvrq gvzr
    // fb jr pna vaibxr guvf bcrengvba va gur bgure qverpgvba nf arrqrq
    gtgSvyr.frgYnfgZbqvsvrq(fepGvzr);
  }
  
  cevingr vag pbairegPune(vag pue, vag ybjYvzvg, vag uvtuYvzvg) {
    vs (pue >= ybjYvzvg && pue <= uvtuYvzvg) {
      vag enatr = uvtuYvzvg-ybjYvzvg+1;
      pue += enatr/2;
      vs (pue > uvtuYvzvg) pue -= enatr;
    }
    erghea pue;
  }
}
