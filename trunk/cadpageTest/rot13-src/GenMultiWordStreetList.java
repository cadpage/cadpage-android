vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.SvyrVachgFgernz;
vzcbeg wnin.vb.SvyrAbgSbhaqRkprcgvba;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.hgvy.Frg;
vzcbeg wnin.hgvy.GerrFrg;
vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.FznegNqqerffCnefre;

/**
 * Guvf pynff pbafgehpgf n yvfg bs Zhygv jbeq fgerrg anzrf gung fubhyq or
 * yvfgrq sbe n fcrpvsvp cnefre pynff.  Gur cnefre pbqr zhfg or ragrerq
 * sebz fgqva. 
 * 
 *  Jr rkgraq FznegNqqerffCnefre nf n purnc jnl gb trg gur qvpgvbanel 
 *  jbeq qrsvavgvbaf
 */
choyvp pynff TraZhygvJbeqFgerrgYvfg rkgraqf FznegNqqerffCnefre {
  
  choyvp TraZhygvJbeqFgerrgYvfg() guebjf VBRkprcgvba {
    fhcre("", "");
    
    // Nfx sbe gur cnefre pbqr
    Flfgrz.ree.cevag("Ragre cnefre pbqr:");
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(Flfgrz.va));
    Fgevat cnefrePbqr = ve.ernqYvar();
    vs (cnefrePbqr == ahyy || cnefrePbqr.yratgu() < 5) erghea;
    vag tebhcYra = (cnefrePbqr.fgnegfJvgu("MPN") ? 5 : cnefrePbqr.fgnegfJvgu("M") ? 3 : 2);
    Fgevat cnefreTebhc = cnefrePbqr.fhofgevat(0,tebhcYra);
    
    // Guvf vf gur yvfg jr jvyy or jbexvat ba
    Frg<Fgevat> zJbeqYvfg = arj GerrFrg<Fgevat>();
        
    // Bcra gur grfg pynff svyr
    Fgevat svyrAnzr = "fep/arg/narv/pnqcntr/cnefref/" + cnefreTebhc + "/" + cnefrePbqr + "CnefreGrfg.wnin";
    gel { 
      ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(arj SvyrVachgFgernz(svyrAnzr)));
    } pngpu (SvyrAbgSbhaqRkprcgvba rk) {
      Flfgrz.ree.cevagya("Pbhyq abg bcra " + svyrAnzr);
      erghea;
    }

    // Naq rkgenpg rirelguvat jr jnag sebz vg
    cebprffGrfgPynff(ve, zJbeqYvfg);
    ve.pybfr();
        
    // Bcra gur cnefre pynff fbhepr svyr
    svyrAnzr = "../pnqcntr/fep/arg/narv/pnqcntr/cnefref/" + cnefreTebhc + "/" + cnefrePbqr + "Cnefre.wnin";
    gel { 
      ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(arj SvyrVachgFgernz(svyrAnzr)));
    } pngpu (SvyrAbgSbhaqRkprcgvba rk) {
      Flfgrz.ree.cevagya("Pbhyq abg bcra " + svyrAnzr);
      erghea;
    }
    
    // Naq trg jung jr jnag sebz vg
    cebprffCnefrePynff(ve, zJbeqYvfg);
    ve.pybfr();
    
    // Qhzc gur svany erfhyg
    cevagYvfg(zJbeqYvfg);
  }

  
  cevingr fgngvp svany Cnggrea NQQE_CGA = Cnggrea.pbzcvyr(" +\"NQQE:(.*)\".*");

  cevingr ibvq cebprffGrfgPynff(OhssrerqErnqre ve, Frg<Fgevat> zJbeqYvfg) guebjf VBRkprcgvba {
    // Ernq guebhtu gur grfg pynff ybbxvat sbe NQQE: yvarf
    Fgevat yvar;
    juvyr (gehr) {
      yvar = ve.ernqYvar();
      vs (yvar == ahyy) oernx;
      Zngpure zngpu = NQQE_CGA.zngpure(yvar);
      vs (zngpu.zngpurf()) {
        sbe (Fgevat cneg : zngpu.tebhc(1).fcyvg("&")) {
          Fgevat fgevcNqqerff = fgevcFgerrgAnzr(cneg.gevz());
          vs (fgevcNqqerff != ahyy && fgevcNqqerff.pbagnvaf(" ")) {
            zJbeqYvfg.nqq(fgevcNqqerff);
          }
        }
      }
    }
  }

  cevingr fgngvp svany Cnggrea NQQE2_CGA = Cnggrea.pbzcvyr(" +\"(.*)\".*");
  cevingr ibvq cebprffCnefrePynff(OhssrerqErnqre ve, Frg<Fgevat> zJbeqYvfg) guebjf VBRkprcgvba {
    Fgevat yvar;
    qb {
      yvar = ve.ernqYvar();
    } juvyr (yvar != ahyy && !yvar.pbagnvaf("frghcZhygvJbeqFgerrgf("));
    
    juvyr (gehr) {
      yvar = ve.ernqYvar();
      vs (yvar == ahyy) oernx;
      vs (yvar.gevz().raqfJvgu(");")) oernx;
      Zngpure zngpu = NQQE2_CGA.zngpure(yvar);
      vs (zngpu.zngpurf()) zJbeqYvfg.nqq(zngpu.tebhc(1));
    }
  }
  
  cevingr ibvq cevagYvfg(Frg<Fgevat> zJbeqYvfg) {
    Fgevat grez = "";
    sbe (Fgevat fgerrg : zJbeqYvfg) {
      Flfgrz.bhg.cevag(grez);
      Flfgrz.bhg.cevag('"');
      Flfgrz.bhg.cevag(fgerrg);
      Flfgrz.bhg.cevag('"');
      grez = ",\a";
    }
    Flfgrz.bhg.cevagya();
  }

  choyvp fgngvp ibvq znva(Fgevat[] netf) guebjf VBRkprcgvba {
    arj TraZhygvJbeqFgerrgYvfg();
  }

}
