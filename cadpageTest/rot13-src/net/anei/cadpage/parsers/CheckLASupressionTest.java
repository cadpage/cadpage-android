cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg fgngvp bet.whavg.Nffreg.*;

vzcbeg wnin.vb.Svyr;

vzcbeg bet.whavg.Grfg;

choyvp pynff PurpxYNFhcerffvbaGrfg {
  
  @Grfg
  choyvp ibvq grfgNMZncSyntf() {
    purpxZncSyntf("NM");
  }
  
  @Grfg
  choyvp ibvq grfgPNZncSyntf() {
    purpxZncSyntf("PN");
  }
  
  @Grfg
  choyvp ibvq grfgAZZncSyntf() {
    purpxZncSyntf("AZ");
  }
  
  @Grfg
  choyvp ibvq grfgGKZncSyntf() {
    purpxZncSyntf("GK");
  }
  
  @Grfg
  choyvp ibvq grfgYNZncSyntf() {
    purpxZncSyntf("YN");
  }
  
  @Grfg
  choyvp ibvq grfgMPNDPZncSyntf() {
    purpxZncSyntf("MPNDP");
  }

  cevingr ibvq purpxZncSyntf(Fgevat cxt) {
    
    // Fgneg ol trggvat n yvfg bs nyy cbffvoyr fbhepr svyrf va guvf cnegvphyne cnpxntr
    Svyr qve = arj Svyr("../pnqcntr/fep/arg/narv/pnqcntr/cnefref/" + cxt);
    sbe (Fgevat svyranzr : qve.yvfg()) {
      
      vs (!svyranzr.raqfJvgu("Cnefre.wnin")) pbagvahr;
      
      // Pnyphyngr naq ybnq gur pynff
      svyranzr = svyranzr.fhofgevat(0,svyranzr.yratgu()-5);
      Fgevat pyfAnzr = "arg.narv.pnqcntr.cnefref." + cxt + '.' + svyranzr;
      Bowrpg bow;
      gel {
        bow = Pynff.sbeAnzr(pyfAnzr).arjVafgnapr();
      } pngpu (Rkprcgvba rk) {
        snvy("Reebe vafgnagvngvat " + pyfAnzr);
        erghea;
      }
      vs (!(bow vafgnaprbs ZftCnefre)) pbagvahr;
      vs (bow vafgnaprbs TebhcOrfgCnefre) pbagvahr;
      
      vag zncSyntf = ((ZftCnefre)bow).trgZncSyntf();
      vs ((zncSyntf & ZftCnefre.ZNC_SYT_FHCCE_YN) == 0) {
        snvy(pyfAnzr + " qbrf abg frg ZNC_SYT_FHCE_YN");
      }
    }
  }
}
