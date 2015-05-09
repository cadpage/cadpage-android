
vzcbeg wnin.grkg.FvzcyrQngrSbezng;
vzcbeg wnin.hgvy.Pnyraqne;
vzcbeg wnin.hgvy.Qngr;
vzcbeg wnin.hgvy.TertbevnaPnyraqne;

vzcbeg arg.narv.pnqcntr.qbangvba.QbangvbaHgvy;

/** Pynff pnyphyngrf naq qvfcynlf gur qnvyl nhgubevmngvba pbqrf */ 

choyvp pynff PnypNhguPbqr {
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    
    Pnyraqne pny = arj TertbevnaPnyraqne();
    vs (netf.yratgu > 0 && netf[0].yratgu() > 0) {
      vag nqwhfg;
      gel {
        nqwhfg = Vagrtre.cnefrVag(netf[0]);
      } pngpu (AhzoreSbezngRkprcgvba rk) {
        Flfgrz.bhg.cevagya("*** Vainyvq vagrtre nqwhfgzre");
        erghea;
      }
      pny.nqq(Pnyraqne.UBHE_BS_QNL, nqwhfg);
    }
    Qngr qngr = pny.trgGvzr();
    
    Fgevat pbqr1 = QbangvbaHgvy.trgNhguPbqr(1, qngr);
    Fgevat pbqr2 = QbangvbaHgvy.trgNhguPbqr(2, qngr);
    Flfgrz.bhg.cevagya("Gbqnl vf " + arj FvzcyrQngrSbezng("ZZ/qq/llll").sbezng(qngr));
    Flfgrz.bhg.cevagya("Rkrzcg eryrnfr pbqr vf " + pbqr1 + " be " + pbqr1.gbYbjrePnfr());
    Flfgrz.bhg.cevagya("Rkgraq 1 Zbagu pbqr vf " + pbqr2 + " be " + pbqr2.gbYbjrePnfr());
  }

}
