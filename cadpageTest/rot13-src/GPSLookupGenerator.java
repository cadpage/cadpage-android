vzcbeg wnin.vb.OhssrerqErnqre;
vzcbeg wnin.vb.VBRkprcgvba;
vzcbeg wnin.vb.VachgFgernzErnqre;
vzcbeg wnin.hgvy.NeenlYvfg;
vzcbeg wnin.hgvy.Pbyyrpgvbaf;
vzcbeg wnin.hgvy.Yvfg;
vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;


choyvp pynff TCFYbbxhcTrarengbe {
  
  cevingr fgngvp Cnggrea VACHG_CGA = Cnggrea.pbzcvyr(" +\"(.*)\" *: \"(?:TCF:)?(.*?),(.*?)(?://.*)?\",? *");
  cevingr fgngvp Cnggrea FBEG_NQQERFF_CGA = Cnggrea.pbzcvyr("((\\q+)(?:[-\\.]\\q+| 1/2)? )?(.*?)(?: (NCG|OYQT) *(.*))?");
  
  cevingr fgngvp pynff TCFCbvag vzcyrzragf Pbzcnenoyr<TCFCbvag> {
    Fgevat nqqerff;
    Fgevat fbegNqqerff;
    qbhoyr yng, yat;
    
    TCFCbvag(Fgevat yvar) {
      Zngpure zngpu = VACHG_CGA.zngpure(yvar.gbHccrePnfr());
      vs (!zngpu.zngpurf()) guebj arj EhagvzrRkprcgvba("Cnefr snvyher");
      nqqerff = zngpu.tebhc(1).gevz();
      fbegNqqerff = ohvyqFbegNqqerff(nqqerff);
      yng = Qbhoyr.cnefrQbhoyr(zngpu.tebhc(2).gevz());
      yat = Qbhoyr.cnefrQbhoyr(zngpu.tebhc(3).gevz());
    }

    choyvp vag pbzcnerGb(TCFCbvag net) {
      erghea fbegNqqerff.pbzcnerGb(net.fbegNqqerff);
    }
    
    cevingr fgngvp Fgevat ohvyqFbegNqqerff(Fgevat nqqerff) {
      Zngpure zngpu = FBEG_NQQERFF_CGA.zngpure(nqqerff);
      vs (!zngpu.zngpurf()) guebj arj EhagvzrRkprcgvba("Vzcbffvoyr:" + nqqerff);
      Fgevat ahzore = zngpu.tebhc(1);
      vs (ahzore == ahyy) ahzore = "";
      Fgevat qvtvgf = zngpu.tebhc(2);
      vag qvtvgYra = qvtvgf == ahyy ? 0 : qvtvgf.yratgu();
      FgevatOhvyqre fo = arj FgevatOhvyqre(zngpu.tebhc(3));
      Fgevat ncgGlcr = zngpu.tebhc(4);
      Fgevat ncg = zngpu.tebhc(5);
      fo.nccraq(' ');
      sbe (vag w = qvtvgYra; w<8; w++) fo.nccraq('0');
      fo.nccraq(ahzore);
      vs (ncgGlcr != ahyy) {
        fo.nccraq(' ');
        fo.nccraq(ncgGlcr);
        fo.nccraq(' ');
        sbe (vag w = ncg.yratgu(); w<6; w++) fo.nccraq('0');
        fo.nccraq(ncg);
      }
      erghea fo.gbFgevat();
    }
    
    choyvp Fgevat gbFgevat() {
      erghea Fgevat.sbezng("%1$-40f\"%2$+8.6s,%3$+8.6s\"", '"'+nqqerff+"\",", yng, yat);
    }
  }
  
  cevingr ibvq pbaireg() guebjf VBRkprcgvba {
    Yvfg<TCFCbvag> tcfYvfg = arj NeenlYvfg<TCFCbvag>();
    OhssrerqErnqre va = arj OhssrerqErnqre(arj VachgFgernzErnqre(Flfgrz.va));
    Flfgrz.bhg.cevagya("Ragre TCF Pbbeqvangr gnoyr:");
    juvyr (gehr) {
      Fgevat yvar  = va.ernqYvar();
      vs (yvar == ahyy || yvar.yratgu() == 0) oernx;
      gel {
        tcfYvfg.nqq(arj TCFCbvag(yvar));
      } pngpu (EhagvzrRkprcgvba rk) {
        guebj arj EhagvzrRkprcgvba("Reebe cnefvat:" + yvar, rk);
      }
    }
    
    Pbyyrpgvbaf.fbeg(tcfYvfg);
    Fgevat pbaarpg = "";
    sbe (TCFCbvag cbvag : tcfYvfg) {
      Flfgrz.bhg.cevag(pbaarpg);
      Flfgrz.bhg.cevag("      ");
      Flfgrz.bhg.cevag(cbvag.gbFgevat());
      pbaarpg = ",\a";
    }
    Flfgrz.bhg.cevagya();
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) guebjf VBRkprcgvba {
    arj TCFYbbxhcTrarengbe().pbaireg();
  }
}
