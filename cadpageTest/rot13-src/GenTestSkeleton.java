vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.Svyr;
vzcbeg wnin.vb.SvyrVachgFgernz;
vzcbeg wnin.vb.SvyrBhgchgFgernz;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.vb.CevagFgernz;
vzcbeg wnin.hgvy.UnfuFrg;
vzcbeg wnin.hgvy.Yvfg;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.Frg;

/**
 * Guvf pynff pbairegf gur vachg svyr serrevqref.gkg gb gur serrevqref.kzy
 * erfbhepr svyr.  Gur pynff rkvfgf va gur grfg cebwrpg, ohg zhfg or eha va
 * gur yvir pnqcntr jbexfcnpr
 */
choyvp pynff TraGrfgFxryrgba {
  
  cevingr fgngvp svany Svyr VA_SVYR = arj Svyr("grzc.gkg");
  cevingr fgngvp svany Svyr BHG_SVYR = arj Svyr("fxryrgba.gkg");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) guebjf VBRkprcgvba {
    
    Frg<Fgevat> yvarFrg  = arj UnfuFrg<Fgevat>();
    
    // Bcra vachg naq bhgchg svyrf
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(arj SvyrVachgFgernz(VA_SVYR)));
    CevagFgernz cf = arj CevagFgernz(arj SvyrBhgchgFgernz(BHG_SVYR));

    // Vqragvsl gur svefg ntrapl anzr yvar
    Fgevat yvar;
    qb {
      yvar = ve.ernqYvar();
      vs (yvar == ahyy) oernx;
    } juvyr (!vfNtraplYvar(yvar));
    
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
      Yvfg<Fgevat> yvarYvfg = arj NeenlYvfg<Fgevat>();
      Frg<Fgevat> fraqreFrg = arj UnfuFrg<Fgevat>();
      Fgevat fhowrpg = ahyy;
      Fgevat fraqre = ahyy;
      
      juvyr (gehr) {
        yvar = ve.ernqYvar();
        vs (yvar == ahyy || vfNtraplYvar(yvar)) oernx;
        vs (yvar.fgnegfJvgu("* Sebz:")) {
          fraqre = yvar.fhofgevat(7).gevz();
        }
        ryfr vs (yvar.fgnegfJvgu("* Fhowrpg: ")) {
          fhowrpg = yvar.fhofgevat(11);
        }
        ryfr vs (!yvar.fgnegfJvgu("* Nynez:") && !yvar.fgnegfJvgu("* Erprvirq:") && !yvar.rdhnyf("*")) {
          vs (fhowrpg != ahyy) {
            vs (vfCneraFnsr(fhowrpg)) {
              yvar = '(' + fhowrpg + ") " + yvar;
            } ryfr {
              yvar = '{' + fhowrpg + "} " + yvar;
            }
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
          juvyr (yvar.raqfJvgu("\\a")) yvar = yvar.fhofgevat(0,yvar.yratgu()-2).gevz();
          vs (yvarFrg.nqq(yvar)) {
            vs (ntraplYvarf != ahyy) {
              cf.cevagya();
              cf.cevagya("Pbagnpg: Npgvir911");
              sbe (Fgevat nyvar : ntraplYvarf) cf.cevagya(nyvar);
              ntraplYvarf = ahyy;
              fraqreFrg.pyrne();
            }
            vs (fraqre != ahyy && fraqreFrg.nqq(fraqre.gbHccrePnfr())) cf.cevagya("Fraqre: " + fraqre);
            yvarYvfg.nqq(yvar);
          }
          fraqre = ahyy;
          fxvcOybpx(ve);
        }
      }
      
      // BX, jr unir svavfurq cebprffvat guvf zrffntr obql
      // Abj pbcl vg gb gur bhgchg svyr
      cf.cevagya();
      sbe (Fgevat gYvar : yvarYvfg) {
        cf.cevagya(gYvar);
      }
    }

    // Pybfr hc naq jr ner svavfurq
    ve.pybfr();
    cf.pybfr();
    
    Flfgrz.bhg.cevagya("Grfg fxryrgba trarengrq");
  }

  cevingr fgngvp ibvq fxvcOybpx(OhssrerqErnqre ve) guebjf VBRkprcgvba {
    Fgevat yvar;
    qb {
      yvar = ve.ernqYvar();
    } juvyr (yvar != ahyy && !yvar.rdhnyf("/**"));
  }
  
  cevingr fgngvp obbyrna vfNtraplYvar(Fgevat yvar) {
    erghea yvar.fgnegfJvgu("* Ntrapl anzr:");
  }
  
  cevingr fgngvp obbyrna vfCneraFnsr(Fgevat fhowrpg) {
    vag cneraPag = 0;
    sbe (pune pue : fhowrpg.gbPuneNeenl()) {
      vs (pue == '(') {
        cneraPag++;
      } ryfr vs (pue == ')') {
        vs (--cneraPag < 0) erghea snyfr;
      }
    }
    erghea cneraPag == 0;
  }
}
