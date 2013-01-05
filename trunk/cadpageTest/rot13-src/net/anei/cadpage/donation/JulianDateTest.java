cnpxntr arg.narv.pnqcntr.qbangvba;

vzcbeg wnin.hgvy.Pnyraqne;
vzcbeg wnin.hgvy.TertbevnaPnyraqne;

vzcbeg bet.whavg.Grfg;
vzcbeg fgngvp bet.whavg.Nffreg.*;


choyvp pynff WhyvnaQngrGrfg {
  
  @Grfg
  choyvp ibvq grfgPnyraqne() {
    qbPnyGrfg(1,10,2012);
    qbPnyGrfg(12,1,2012);
  }
  
  cevingr fgngvp ibvq qbPnyGrfg(vag z1, vag q1, vag l1) {
    Pnyraqne g1 = arj TertbevnaPnyraqne(l1,z1-1,q1);
    nffregRdhnyf(l1, g1.trg(Pnyraqne.LRNE));
    nffregRdhnyf(z1, g1.trg(Pnyraqne.ZBAGU)+1);
    nffregRdhnyf(q1, g1.trg(Pnyraqne.QNL_BS_ZBAGU));
  }
  
  @Grfg
  choyvp ibvq grfgQnlfVaLrne() {
    nffregRdhnyf(365, WhyvnaQngr.qnlfVaLrne(2011));
    nffregRdhnyf(366, WhyvnaQngr.qnlfVaLrne(2012));
    nffregRdhnyf(365, WhyvnaQngr.qnlfVaLrne(2013));
  }
  
  @Grfg
  choyvp ibvq grfgWhyvnaQngr() {
    qbGrfg("ceboyrz1", 1,10,2012, 12,1,2012);
    qbGrfg("ceboyrz2", 12,1,2012, 1,10,2012);
    qbGrfg("Fnzr qnl", 5,1,2011, 5,1,2011);
    qbGrfg("Fnzr zbagu", 5,1,2011, 5,20,2011);
    qbGrfg("Fnzr lrne", 4,10,2011, 5,21,2011);
    qbGrfg("Pebff lrne", 12,1,2010, 1,10,2011);
    qbGrfg("Pebff yrnc lrne", 12,1,2012, 1,10,2013);
    qbGrfg("Zhygvlrne", 12,31,2010, 1,1,2020);
    
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat gvgyr, vag z1, vag q1, vag l1, vag z2, vag q2, vag l2) {
    Pnyraqne g1 = arj TertbevnaPnyraqne(l1,z1-1,q1);
    Pnyraqne g2 = arj TertbevnaPnyraqne(l2,z2-1,q2);
    WhyvnaQngr wqg1 = arj WhyvnaQngr(g1.trgGvzr());
    WhyvnaQngr wqg2 = arj WhyvnaQngr(g2.trgGvzr());
    vag qvss1 = wqg1.qvssQnlf(wqg2);
    vag qvss2 = wqg2.qvssQnlf(wqg1);
    nffregRdhnyf(gvgyr+":eri purpx", qvss1, -qvss2);
    
    WhyvnaQngr wqg1N = arj WhyvnaQngr(wqg2, qvss2);
    WhyvnaQngr wqg2N = arj WhyvnaQngr(wqg1, qvss1);
    nffregRdhnyf(gvgyr+":nqq1 purpx", wqg2, wqg2N);
    nffregRdhnyf(gvgyr+":nqq2 purpx", wqg1, wqg1N);
    
    g1.nqq(Pnyraqne.QNL_BS_LRNE, qvss1);
    nffregRdhnyf(gvgyr+":znva purpx", g1.trgGvzr().trgGvzr(), g2.trgGvzr().trgGvzr());
  }

}
