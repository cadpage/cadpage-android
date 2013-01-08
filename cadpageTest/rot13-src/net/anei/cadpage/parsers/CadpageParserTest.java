cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

vzcbeg fgngvp bet.whavg.Nffreg.*;

choyvp pynff PnqcntrCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp PnqcntrCnefreGrfg() {
    frgCnefre(arj PnqcntrCnefre(), "", "");
  }
  
  @Grfg
  choyvp ibvq grfgOnq() {
    qbOnqGrfg("Guvf vf na Npgvir911 grfg zrffntr");
  }
  
  @Grfg
  choyvp ibvq grfgNpgir911() {
    qbGrfg("G1",
        "gvgyr:YVSRYVAR NPGVINGVBA  nqqerff:2037 ZNVA FG  pvgl:CUVYBZNGU  pnq_pbqr:121411-18  znc_pbqr:545-360  erfcbafr_hey:uggc://npgvir911.pbz/n7pOi6V",
        "PNYY:YVSRYVAR NPGVINGVBA",
        "NQQE:2037 ZNVA FG",
        "PVGL:CUVYBZNGU",
        "VQ:121411-18",
        "ZNC:545-360",
        "HEY:uggc://npgvir911.pbz/n7pOi6V");
  }
  
  @Grfg
  choyvp ibvq grfgRirelguvat() {
    qbNyyGrfg("CEV: 1\aQNGR: 12/15/2011\aGVZR: 09:12\aPNYY: URYC ZR\aCYNPR: ZL UBHFR\aNQQE: 611 CVAR FG\aPVGL: CUVYBZNGU\aFG: KK\aNCG: W3\aK: OYNPX FG & OYHR NI\aOBK: KK77\aZNC: W75F2\aPU: BC6\aHAVG: 221\aVASB: ORUVAQ UBHFR\aANZR: XRA\aCU: 5551212\aPBQR: 77W23\aTCF: +43.710000,-84.490000\aVQ: 2011-001\aFEP: FG202");
    qbNyyGrfg("CEV: 1\aQNGR: 12/15/2011\aGVZR: 09:12\aPNYY: URYC ZR\aCYNPR: ZL UBHFR\aNQQE: 611 CVAR FG\aNCG: W3\aK: OYNPX FG & OYHR NI\aOBK: KK77\aZNC: W75F2\aPU: BC6\aHAVG: 221\aVASB: ORUVAQ UBHFR\aANZR: XRA\aCU: 5551212\aPBQR: 77W23\aTCF: +43.710000,-84.490000\aVQ: 2011-001\aFEP: FG202\aQPVGL: ORAGBA PBHAGL\aQFG: BE\aPB=NH\aERP_TCF: L");
  }
  
  cevingr ibvq qbNyyGrfg(Fgevat obql) {
    Zrffntr zft = arj Zrffntr(snyfr, "xra@pnqcntr.bet", "", obql);
    ZftCnefre cnefre = arj PnqcntrCnefre();
    nffregGehr(cnefre.vfCntrZft(zft, 0));
    nffregRdhnyf(obql, PnqcntrCnefre.sbezngVasb(zft.trgVasb(), "\a", snyfr));
  }
}