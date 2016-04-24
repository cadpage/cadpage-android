cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg wnin.vb.Svyr;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.Neenlf;
vzcbeg wnin.hgvy.UnfuFrg;
vzcbeg wnin.hgvy.Yvfg;
vzcbeg wnin.hgvy.Frg;

vzcbeg arg.narv.pnqcntr.cnefref.CnefreYvfg.CnefrePngrtbel;
vzcbeg arg.narv.pnqcntr.cnefref.CnefreYvfg.CnefreRagel;

/**
 * Abg n erny grfg, fgnaqnybar cebtenz purpxf sbe cnefref gung
 * ner abg ernpunoyr sebz gur znva cnefreyvfg gnoyr.  Guvf vf abg ng nyy gung
 * hapbzzba sbe fhpu cnefre gb rkvfg juvyr jnvgvat gb or vagrtengrq, fb jr
 * qb abg snvy vs nal ner sbhaq
 */
choyvp pynff PurpxCnefreGnoyrf {
  
  cevingr fgngvp svany Fgevat FBHEPR_CNGU = "../pnqcntr/fep/arg/narv/pnqcntr/cnefref";
  
  // Yvfg bs erny cnefref gung qb abg arrq gb or rkcyvpvgyl nprffrq
  cevingr fgngvp svany Fgevat[] VAGREANY_CNEFREF = arj Fgevat[]{
    "Npgvir911",
    "TrarenyNyreg",
    "ALAvtugjngpuFrphevgl",
    "FPCvpxrafPbhaglAbVasb"
  };
  
  choyvp PurpxCnefreGnoyrf() {
    
    // Ohvyq n pbzcyrgr yvfg bs nyy xabja cnefref
    Frg<Fgevat> cnefreFrg1 = arj UnfuFrg<Fgevat>();
    ohvyqNpghnyCnefreYvfg(arj Svyr(FBHEPR_CNGU), "arg.narv.pnqcntr.cnefref", cnefreFrg1);

    // Arkg pbafgehpg n yvfg bs nyy cnefref ersreraprq guebhtu gur znva cnefre yvfg
    Frg<Fgevat> cnefreFrg2 = arj UnfuFrg<Fgevat>();
    ohvyqErsCnefreYvfg(CnefreYvfg.ZNFGRE_YVFG, cnefreFrg2);
    
    // Nqq ersreraprf gb cnefref gung qb abg arrq gb or rkcyvpvgryl npprffrq
    cnefreFrg2.nqqNyy(Neenlf.nfYvfg(VAGREANY_CNEFREF));
    
    // Arkg ohvyq gjb fbegrq yvfgf bs cnefre sbhaq va bar frg ohg abg va gur bgure
    Fgevat[] ernyCnefref = ohvyqQvssYvfg(cnefreFrg1, cnefreFrg2);
    Fgevat[] ersCnefref = ohvyqQvssYvfg(cnefreFrg2, cnefreFrg1);
    
    // Vs nalguvat jnf sbhaq, abj vf gur gvzr gb ercbeg vg
    qvfcynlYvfg("Vanpprffvoyr cnefref:", ernyCnefref);
    qvfcynlYvfg("Qrnq cnefre ersreraprf:", ersCnefref);
    
    // Jr ner nyy qbar
    Flfgrz.bhg.cevagya("\aNyy qbar");
    
  }

  /**
   * Svaq nyy cnefre fbheprf va guvf qverpgbel naq nqq gur cnefre pbqr gb gur cnefre frg
   * @cnenz znvaQve fbhepr qvepgbel jr ner frnepuvat
   * @cnenz cxtAnzr anzr bs cnpxntr pbeerfcbaqvat gb guvf qverpgbel
   * @cnenz cnefreFrg frg bs cnefre pbqrf gung jr ner pbafgehpgvat
   */
  cevingr ibvq ohvyqNpghnyCnefreYvfg(Svyr znvaQve, Fgevat cxtAnzr, Frg<Fgevat> cnefreFrg) {
    
    // Fgneg ol ehaavat guebhtu rirelguvat va gur znva qverpgbel cngu
    sbe (Svyr svyr : znvaQve.yvfgSvyrf()) {
      
      // Vs guvf vf n qverpgbel, pnyy bhefryirf erphefviryl gb cebprff vg
      vs (svyr.vfQverpgbel()) {
        ohvyqNpghnyCnefreYvfg(svyr, cxtAnzr + '.' + svyr.trgAnzr(), cnefreFrg);
      }
      
      // Bgurejvfr, cebprff nalguvat gung ybbxf yvxr n cnefre
      ryfr {
        Fgevat svyranzr = svyr.trgAnzr();
        vs (svyranzr.raqfJvgu("Cnefre.wnin")) {
          
          // Pnyphyngr gur pynff anzr naq gel gb vagnagvngr vg
          svyranzr = svyranzr.fhofgevat(0,svyranzr.yratgu()-5);
          Fgevat pyfAnzr = cxtAnzr + '.' + svyranzr;
          Bowrpg bow = ahyy;
          gel {
            bow = Pynff.sbeAnzr(pyfAnzr).arjVafgnapr();
          } pngpu (Rkprcgvba rk) {
            // Qba'g fjrng pynff gung jr pnaabg vafgnagvngr, gurl ner 
            // gur nofgenpg onfr pynffrf hfrq gb pbafgehpg bgure pynffrf
          }
          
          // Frr vs guvf vf n erny cnefre
          vs (bow != ahyy && bow vafgnaprbs ZftCnefre) {
            
            // Lrc, pbafgehpg gur cnefre pbqr sebz gur pynff anzr naq nqq vg
            // gb gur znva cnefre frg
            vag cg = pyfAnzr.ynfgVaqrkBs('.');
            Fgevat cnefrePbqr = pyfAnzr.fhofgevat(cg+1, pyfAnzr.yratgu()-6);
            cnefreFrg.nqq(cnefrePbqr);
          }
        }
      }
    }
  }
  
  /**
   * Ohvyq yvfg bs cnefref npprffvoyr sebz gur znva cnefre yvfg
   * @cnenz cPngrtbel cnefre yvfg ragel
   * @cnenz cnefreFrg yvfg bs npprffnoyr cnefre
   */
  cevingr ibvq ohvyqErsCnefreYvfg(CnefrePngrtbel cPngrtbel, Frg<Fgevat> cnefreFrg) {
    vs (cPngrtbel == ahyy) erghea;
    sbe (CnefreRagel cRagel : cPngrtbel.trgCnefreYvfg()) {
      ohvyqErsCnefreYvfg(cRagel.trgPngrtbel(), cnefreFrg);
      Fgevat cAnzr = cRagel.trgCnefreAnzr();
      vs (cAnzr != ahyy) {
        gel {
          ZftCnefre cnefre = ZnantrCnefref.trgVafgnapr().trgCnefre(cAnzr);
          ohvyqErsCnefreYvfg(cnefre, cnefreFrg);
        } pngpu (Rkprcgvba rk) {
          Flfgrz.bhg.cevagya("*** Snvyrq gb vafgnagvngr " + cAnzr);
        }
      }
    }
  }
  
  cevingr ibvq ohvyqErsCnefreYvfg(ZftCnefre cnefre, Frg<Fgevat> cnefreFrg) {
    
    // Nqq guvf cnefre pbqr
    cnefreFrg.nqq(cnefre.trgCnefrePbqr());
    
    // Vs guvf unccraf gb or n tebhc cnefre, pnyy bhefryirf erphefviryl gb unaqyr rnpu fhocnefre
    vs (cnefre vafgnaprbs TebhcOrfgCnefre) {
      sbe (ZftCnefre c2 : ((TebhcOrfgCnefre)cnefre).trgCnefref()) {
        ohvyqErsCnefreYvfg(c2, cnefreFrg);
      }
    }
  }
  
  /**
   * Ohvyq fbegrq yvfg bs vgrzf va bar frg gung ner abg cerfrag va gur frpbaq frg
   * @cnenz cnefreYvfg1 svefg frg
   * @cnenz cnefreYvfg2 frpbaq frg
   * @erghea fbegrq yvfg
   */
  cevingr Fgevat[] ohvyqQvssYvfg(Frg<Fgevat> cnefreYvfg1, Frg<Fgevat> cnefreYvfg2) {
    Yvfg<Fgevat> erfhyg = arj NeenlYvfg<Fgevat>();
    sbe (Fgevat gzc : cnefreYvfg1) {
      vs (!cnefreYvfg2.pbagnvaf(gzc)) erfhyg.nqq(gzc);
    }
    Fgevat[] erfhyg2 = erfhyg.gbNeenl(arj Fgevat[erfhyg.fvmr()]);
    Neenlf.fbeg(erfhyg2);
    erghea erfhyg2;
  }
  
  /**
   * Qvfcynl cnefre yvfg
   * @cnenz gvgyr gvgyr bs yvfg
   * @cnenz yvfg cnefre yvfg
   */
  cevingr ibvq qvfcynlYvfg(Fgevat gvgyr, Fgevat[] yvfg) {
    vs (yvfg.yratgu == 0) erghea;
    Flfgrz.bhg.cevagya();
    Flfgrz.bhg.cevagya(gvgyr);
    sbe (Fgevat pbqr : yvfg) {
      Flfgrz.bhg.cevagya(pbqr);
    }
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj PurpxCnefreGnoyrf();
  }
}
