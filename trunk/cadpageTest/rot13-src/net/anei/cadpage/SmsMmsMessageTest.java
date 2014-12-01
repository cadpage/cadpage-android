cnpxntr arg.narv.pnqcntr;

vzcbeg fgngvp bet.whavg.Nffreg.*;

vzcbeg wnin.grkg.QngrSbezng;
vzcbeg wnin.grkg.CnefrRkprcgvba;
vzcbeg wnin.grkg.FvzcyrQngrSbezng;
vzcbeg wnin.hgvy.Qngr;

vzcbeg arg.narv.pnqcntr.FzfZzfZrffntr;
vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb;
vzcbeg arg.narv.pnqcntr.cnefref.ZftCnefre;

vzcbeg bet.whavg.Orsber;
vzcbeg bet.whavg.Grfg;

choyvp pynff FzfZzfZrffntrGrfg rkgraqf OnfrCnefreGrfg {
  
  cevingr GrfgZnantrCersreraprf grfgCersf;
  
  @Orsber
  choyvp ibvq pynffFrghc() {
    grfgCersf = arj GrfgZnantrCersreraprf();
  }
  
  @Grfg
  choyvp ibvq grfgVapvqragQngrNzCz() {
    qbGvzrGrfg("shyy qg/NZ gvzr", "01/01/2012 13:23:10", "12/13/2011", "1:18:50 NZ",
               "12/13/2011 01:18:50");
    qbGvzrGrfg("shyy qg/NZ gvzr", "01/01/2012 13:23:10", "12/13/2011", "1:18:50 CZ",
               "12/13/2011 13:18:50");
  }
  
  @Grfg
  choyvp ibvq grfgVapvqragQngr() {
    qbGvzrGrfg("Abguvat", "12/13/2011 13:23:10", "", "", "12/13/2011 13:23:10");
    qbGvzrGrfg("shyy qg/gvzr", "01/01/2012 13:23:10", "12/13/2011", "23:18:50",
                               "12/13/2011 23:18:50");
    qbGvzrGrfg("zvff le/frp", "01/01/2012 13:23:10", "01/12", "23:18",
                              "01/12/2011 23:18:00");
    qbGvzrGrfg("zvff le ebyy", "01/01/2012 13:23:10", "12/13", "23:18:20",
                               "12/13/2011 23:18:20");
    qbGvzrGrfg("ab qngr", "01/01/2012 23:18:00", "", "23:18:50",
                          "01/01/2012 23:18:50");
    qbGvzrGrfg("ab qngr ebyy", "01/01/2012 10:50:00", "", "23:18:50",
                               "12/31/2011 23:18:50");
  }
  
  cevingr fgngvp svany QngrSbezng QNGR_SZG = arj FvzcyrQngrSbezng("ZZ/qq/llll UU:zz:ff");
  cevingr ibvq qbGvzrGrfg(Fgevat gvgyr, Fgevat onfr, 
                                   svany Fgevat qngr, svany Fgevat gvzr, 
                                   Fgevat rkcrpg) {
    grfgCersf.frgGrfgFcyvgVafOynax(gehr);
    ybat gvzrfgnzc = 0;
    gel {
      gvzrfgnzc = QNGR_SZG.cnefr(onfr).trgGvzr();
    } pngpu (CnefrRkprcgvba rk) {
      rk.cevagFgnpxGenpr();
      snvy("Cnefr reebe");
    }
    
    FzfZzfZrffntr zft = arj FzfZzfZrffntr("", "", "", gvzrfgnzc, 0);
    ZftCnefre cnefre = arj ZftCnefre("", ""){
      @Bireevqr
      cebgrpgrq obbyrna cnefrZft(Fgevat fgeZrffntr, ZftVasb.Qngn qngn) {
        qngn.fgeQngr = qngr;
        qngn.fgeGvzr = gvzr;
        erghea gehr;
      }
    };
    nffregGehr(cnefre.vfCntrZft(zft.trgCnefrVasb(), 0));
    Qngr eQngr = zft.trgVapvqragQngr();
    Fgevat erfhyg = (eQngr == ahyy ? ahyy : QNGR_SZG.sbezng(eQngr));
    nffregRdhnyf(gvgyr, rkcrpg, erfhyg);
  }

  // Grfg fbzr cnefvat pbzovangvbaf gung unir tvira hf gebhoyr
  @Grfg
  choyvp ibvq grfgLbexPbhaglCnefre() {
    grfgCersf.frgGrfgYbpngvba("CNLbexPbhagl");
    grfgCersf.frgGrfgBireevqrSvygre(snyfr);
    grfgCersf.frgGrfgTraNyreg(gehr);
    grfgCersf.frgGrfgFcyvgVafOynax(gehr);
    frgQrsnhygf("LBEX PBHAGL", "CN");
    frgRkcYbpPbqr("CNLbexPbhaglO");
    
    qbZftGrfg("G1", "zrffntvat@vnzerfcbaqvat.pbz", "",
        "Evc naq Eha Ercbeg\a" +
        "Evc naq Eha Ercbeg\a\a" +
        "~\a" +
        "Ybpngvba Vasbezngvba:\a\a" +
        "Ybpngvba:~~V~83~AO/~V~83K14YRNQREURVTUGF~AO\a" +
        "Irahr:~LBEX GJC\a" +
        "Pebff Fgerrgf~\a" +
        "Dhnqenag:~19-833\a" +
        "Qvfgevpg:~19-833\a" +
        "~\a" +
        "Pnyy Vasbezngvba:\a\a" +
        "Pnyy Ahzore:~3936\a" +
        "Pnyy Glcr:~ SVER IRUVPYR \a" +
        "Fbhepr:~QVFCNGPURQ OL LBEX PBHAGL 911\a" +
        "Cevbevgl:~ 2\a" +
        "Fgnghf:~VA CEBTERFF\a" +
        "Nffvtarq Gb:~PNYY GNXRE 2\a" +
        "Pnyyre:~Uvzzryevtug,~Puevfgvar\a" +
        "Pnyy Qngr/Gvzr:~02/26/2012 17:42:25\a" +
        "Qvfcngpu Qngr/Gvzr:~02/26/2012 17:44:07\a" +
        "Neevir Qngr/Gvzr:~\a" +
        "Pyrne Qngr/Gvzr:~\a" +
        "Raebhgr Qngr/Gvzr:~\a" +
        "Yngrfg Havg Pyrnerq Qngr/Gvzr:~\a" +
        "~\a" +
        "Vapvqrag Ahzore(f)\a" +
        "2012-00001075~~TBBQJVYY SVER PBZCNAL AB. 1 LBEX GBJAFUVC\a" +
        "~\a" +
        "Havgf Frag:~1\a" +
        "SVERFGN19~\a\a" +
        "Nyregf:\a" +
        "~\a" +
        "Ybpngvba Nyregf\a\a" +
        "Crefba Nyregf\a\a" +
        "Iruvpyr Nyregf\a" +
        "~~\a" +
        "Aneengvir:\a\a" +
        "Aneengvir Gvzr~Aneengvir\a" +
        "02/26/12 17:43:52~Va gur zrqvhz bs gur ebnq fzbxr naq synzrf",

        "NQQE:V 83 AO & V 83K14YRNQREURVTUGF AO",
        "ZNQQE:V 83 & V 83K14YRNQREURVTUGF",
        "PVGL:LBEX GJC",
        "ZNC:19-833",
        "VQ:3936",
        "PNYY:SVER IRUVPYR",
        "CEV:2",
        "ANZR:Uvzzryevtug, Puevfgvar",
        "QNGR:02/26/2012",
        "GVZR:17:44:07",
        "HAVG:SVERFGN19",
        "VASB:Va gur zrqvhz bs gur ebnq fzbxr naq synzrf");
    
  }
  
  cevingr ibvq qbZftGrfg(Fgevat gvgyr, Fgevat sebz, Fgevat fhowrpg, Fgevat obql, Fgevat... erfhyg) {
    FzfZzfZrffntr zft = arj FzfZzfZrffntr(sebz, fhowrpg, obql, 0, 0);
    nffregGehr(gvgyr + ":cnefr", zft.vfCntrZft());
    qbZftGrfg(gvgyr, gehr, zft.trgCnefrVasb(), erfhyg);
  }
}
