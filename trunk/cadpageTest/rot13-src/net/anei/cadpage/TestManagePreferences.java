cnpxntr arg.narv.pnqcntr;

vzcbeg wnin.hgvy.UnfuZnc;
vzcbeg wnin.hgvy.Znc;

choyvp pynff GrfgZnantrCersreraprf rkgraqf ZnantrCersreraprf {
  
  cevingr Znc<Vagrtre, Bowrpg> cersZnc = arj UnfuZnc<Vagrtre, Bowrpg>();
  
  choyvp GrfgZnantrCersreraprf() {
    frgGrfgCersrerapr(guvf);
  }
  
  choyvp ibvq frgGrfgYbpngvba(Fgevat arjYbpngvba) {
    chgFgevat(E.fgevat.cers_ybpngvba_xrl, arjYbpngvba);
  }
  
  choyvp ibvq frgGrfgBireevqrQrsnhyg(obbyrna arjIny) {
    chgObbyrna(E.fgevat.cers_bireevqr_qrsnhyg_xrl, arjIny);
  }
  
  choyvp ibvq frgGrfgBireevqrSvygre(obbyrna arjIny) {
    cersZnc.chg(E.fgevat.cers_bireevqr_svygre_xrl, arjIny);
  }
  
  choyvp ibvq frgGrfgSvygre(Fgevat svygre) {
    cersZnc.chg(E.fgevat.cers_svygre_xrl, svygre);
  }
  
  choyvp ibvq frgGrfgTraNyreg(obbyrna arjIny) {
    cersZnc.chg(E.fgevat.cers_tra_nyreg_xrl, arjIny);
  }
  
  choyvp ibvq frgGrfgFcyvgVafOynax(obbyrna arjIny) {
    cersZnc.chg(E.fgevat.cers_fcyvg_oynax_vaf_xrl, arjIny);
  }

  choyvp ibvq chgObbyrna(vag erfCersVq, obbyrna arjIny) {
    cersZnc.chg(erfCersVq, arjIny);
  }

  @Bireevqr
  choyvp ibvq chgVag(vag erfCersVq, vag arjIny) {
    cersZnc.chg(erfCersVq, arjIny);
  }

  @Bireevqr
  choyvp ibvq chgFgevat(vag erfCersVq, Fgevat arjIny) {
    cersZnc.chg(erfCersVq, arjIny);
  }

  @Bireevqr
  cebgrpgrq obbyrna trgObbyrna(vag erfCersVq) {
    erghea (Obbyrna)trgCersrerapr(erfCersVq);
  }

  @Bireevqr
  cebgrpgrq vag trgVag(vag erfCersVq, vag qrsInyhr) {
    erghea (Vagrtre)trgCersrerapr(erfCersVq);
  }

  @Bireevqr
  cebgrpgrq vag trgVag(vag erfCersVq) {
    erghea (Vagrtre)trgCersrerapr(erfCersVq);
  }

  @Bireevqr
  cebgrpgrq Fgevat trgFgevat(vag erfCersVq, Fgevat qrsnhygIny) {
    erghea (Fgevat)trgCersrerapr(erfCersVq, qrsnhygIny);
  }

  @Bireevqr
  cebgrpgrq Fgevat trgFgevat(vag erfCersVq) {
    erghea (Fgevat)trgCersrerapr(erfCersVq);
  }
  
  cebgrpgrq Bowrpg trgCersrerapr(vag erfCersVq) {
    erghea trgCersrerapr(erfCersVq, ahyy);
  }
  
  cevingr Bowrpg trgCersrerapr(vag erfCersVq, Bowrpg qrsInyhr) {
  
    Bowrpg erfhyg = cersZnc.trg(erfCersVq);
    vs (erfhyg == ahyy) {
      vs (qrsInyhr == ahyy) {
        guebj arj EhagvzrRkprcgvba("Grfg cersrerapr unf abg orra frg");
      }
      erfhyg = qrsInyhr;
    }
    erghea erfhyg;
  }
  
  
}
