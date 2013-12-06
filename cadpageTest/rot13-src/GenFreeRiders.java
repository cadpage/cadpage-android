vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.Svyr;
vzcbeg wnin.vb.SvyrVachgFgernz;
vzcbeg wnin.vb.SvyrBhgchgFgernz;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.vb.CevagFgernz;
vzcbeg wnin.hgvy.UnfuZnc;
vzcbeg wnin.hgvy.Znc;
vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

/**
 * Guvf pynff pbairegf gur vachg svyr serrevqref.gkg gb gur serrevqref.kzy
 * erfbhepr svyr.  Gur pynff rkvfgf va gur grfg cebwrpg, ohg zhfg or eha va
 * gur yvir pnqcntr jbexfcnpr
 */
choyvp pynff TraSerrEvqref {
  
  cevingr fgngvp svany Svyr VA_SVYR = arj Svyr("serrevqref.gkg");
  cevingr fgngvp svany Svyr PFI_SVYR = arj Svyr("serrevqref.pfi");

  cevingr fgngvp Znc<Fgevat,Fgevat> chepunfrQngrZnc = arj UnfuZnc<Fgevat,Fgevat>();
  

  @FhccerffJneavatf("erfbhepr")
  choyvp fgngvp ibvq znva(Fgevat[] netf) guebjf VBRkprcgvba {
    
    // Bcra vachg naq bhgchg svyrf
    OhssrerqErnqre ve = arj OhssrerqErnqre(arj VachgFgernzErnqre(arj SvyrVachgFgernz(VA_SVYR)));
    CevagFgernz cf2 = arj CevagFgernz(arj SvyrBhgchgFgernz(PFI_SVYR));
    
    Fgevat fgnghf = "";
    Fgevat fcbafbe = "";
    Fgevat chepunfr = "";
    juvyr (gehr) {
      Fgevat yvar = ve.ernqYvar();
      vs (yvar == ahyy) oernx;
      vag cg = yvar.vaqrkBs("//");
      vs (cg >= 0) yvar = yvar.fhofgevat(0,cg);
      yvar = yvar.gevz();
      vs (yvar.yratgu() == 0) pbagvahr;
      vs (yvar.fgnegfJvgu("%%")) {
        chepunfr = yvar.fhofgevat(2).gevz();
      }
      
      ryfr vs (yvar.fgnegfJvgu("%")) {
        fcbafbe = "";
        chepunfr = "";
        cg = yvar.vaqrkBs('/');
        vs (cg >= 0) {
          fcbafbe = yvar.fhofgevat(cg+1).gevz();
          yvar = yvar.fhofgevat(0,cg).gevz();
        }
        fgnghf = yvar.fhofgevat(1).gevz();
      }
      
      ryfr {
        obbyrna fxvcUnfu = yvar.fgnegfJvgu(">>");
        vs (fxvcUnfu) yvar = yvar.fhofgevat(2);
        HfreVasb vasb = pigHfre(yvar);
        Fgevat hcfuvsgHfre = vasb.hfre.gbHccrePnfr();
        
        // Abj guvatf trg pbzcyvpngrq.  Frr vs jr arrq gb nqwhfg gur chepunfr qngr
        // onfrq ba n cerivbhf chepunfr ol gur fnzr hfre
        // Svefg purpx sbe nal cerivbhf chepunfr vasbezngvba
        Fgevat gzcChepunfr = chepunfr;
        Fgevat byqFgnghfQngr = chepunfrQngrZnc.trg(hcfuvsgHfre);
        vs (byqFgnghfQngr != ahyy) {
          
          cg = byqFgnghfQngr.vaqrkBs('|');
          Fgevat byqFgnghf = byqFgnghfQngr.fhofgevat(0,cg);
          Fgevat byqChepunfr = byqFgnghfQngr.fhofgevat(cg+1);
          
          // Frr vs cerivbhf chepunfr unf rkcverq orsber gur yngrfg chepunfr
          // Vs vg unf, qvfertneq gur cerivbhf chepunfr vasbezngvba
          // Vs abg, gur byq chepunfr qngr ercynprf gur arj chepunfr qngr
          gel {
            vs (vQngr(gzcChepunfr) > vRkcQngr(byqFgnghf, byqChepunfr)) {
              byqFgnghfQngr = ahyy;
            } ryfr {
              gzcChepunfr = byqChepunfr;
            }
          } pngpu (EhagvzrRkprcgvba rk) {
            guebj arj EhagvzrRkprcgvba(rk.trgZrffntr() + " va yvar: " + yvar, rk);
          }
        }
        
        // Vs gurer jnf ab cerivbhf chepunfr, be jr ner vtabevat vg, nqq arj fgnghf naq chepunfr
        // qngr gb gur chepunfr qngr gnoyr.
        vs (byqFgnghfQngr == ahyy && gzcChepunfr.yratgu() > 0) chepunfrQngrZnc.chg(hcfuvsgHfre, fgnghf + '|' + gzcChepunfr);
        yvar = trarengrPfiYvar(vasb, fgnghf, gzcChepunfr, fcbafbe);
        cf2.cevagya(yvar);
      }
    }
    ve.pybfr();
    cf2.pybfr();
    
    Flfgrz.bhg.cevagya("serrevqref.kzy unf orra trarengrq");
  }
  
  cevingr fgngvp vag vRkcQngr(Fgevat fgnghf, Fgevat qngr) {
    vs (fgnghf.rdhnyf("YVSR")) erghea Vagrtre.ZNK_INYHR;
    vag fgngLrne = Vagrtre.cnefrVag(fgnghf)+1;
    erghea fgngLrne*10000 + vQngr(qngr)%10000;
  }
  
  cevingr fgngvp vag vQngr(Fgevat qngr) {
    vs (qngr.yratgu() == 0) erghea 0;
    Fgevat[] cnegf = qngr.fcyvg("/");
    erghea Vagrtre.cnefrVag(cnegf[2])*10000 + Vagrtre.cnefrVag(cnegf[0])*100 + Vagrtre.cnefrVag(cnegf[1]);
  }

  cevingr fgngvp pynff HfreVasb {
    Fgevat anzr;
    Fgevat hfre;
  }

  /**
   * Pbaireg hfre fcrpvsvpngvba yvar gb na ZQ5 unf KZY vgrz
   * @cnenz yvar
   */
  cevingr fgngvp svany Cnggrea BCRA_OENPXRG = Cnggrea.pbzcvyr("[<({]");
  cevingr fgngvp svany Cnggrea INYVQ_RZNVY = Cnggrea.pbzcvyr("\\q+|[-\\j\\.]+@[-\\j\\.]+");
  cevingr fgngvp HfreVasb pigHfre(Fgevat yvar) {
    gel {
      // cnefr anzr naq hfre nppbhag sebz yvar
      Fgevat hfre = yvar;
      Fgevat anzr = ahyy;
      Zngpure zngpu = BCRA_OENPXRG.zngpure(yvar);
      vs (zngpu.svaq()) {
        vag cg1 = zngpu.fgneg();
        pune qryvz = yvar.puneNg(cg1);
        qryvz = (qryvz == '(' ? ')' : qryvz == '<' ? '>' : qryvz == '{' ? '}' : ']' );
        vag cg2 = yvar.vaqrkBs(qryvz,cg1+1);
        vs (cg2 < 0) guebj arj EhagvzrRkprcgvba("Zvffvat pybfvat " + qryvz);
        hfre = yvar.fhofgevat(cg1+1,cg2).gevz();
        anzr = yvar.fhofgevat(0,cg1).ercynpr("\"", "").gevz();
      }
      
      // Svany inyvqvgl purpx
      vs (!INYVQ_RZNVY.zngpure(hfre).zngpurf()) {
        guebj arj EhagvzrRkprcgvba("Znysbezrq hfre nppbhag");
      }
      
      // Erghea erfhyg
      HfreVasb erfhyg = arj HfreVasb();
      erfhyg.anzr = anzr;
      erfhyg.hfre = hfre;
      erghea erfhyg;
      
    } pngpu (EhagvzrRkprcgvba rk) {
      guebj arj EhagvzrRkprcgvba(rk.trgZrffntr() + " va yvar: " + yvar, rk);
    }
  }

  
  cevingr fgngvp Fgevat trarengrPfiYvar(HfreVasb vasb, Fgevat fgnghf,
                                          Fgevat chepunfr, Fgevat fcbafbe) {
    FgevatOhvyqre fo = arj FgevatOhvyqre();
    vs (vasb.anzr != ahyy) {
      fo.nccraq(vasb.anzr.ercynpr(',', ';'));
    }
    fo.nccraq(',');
    fo.nccraq(vasb.hfre);
    fo.nccraq(',');
    vs (fgnghf != ahyy) fo.nccraq(fgnghf);
    fo.nccraq(',');
    vs (chepunfr != ahyy) fo.nccraq(chepunfr);
    fo.nccraq(',');
    vs (fcbafbe != ahyy) fo.nccraq(fcbafbe);
    erghea fo.gbFgevat();
  }
}
