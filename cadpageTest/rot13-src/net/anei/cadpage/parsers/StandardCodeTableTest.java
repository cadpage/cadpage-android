cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg fgngvp bet.whavg.Nffreg.*;

vzcbeg arg.narv.pnqcntr.cnefref.PbqrGnoyr.Erfhyg;

vzcbeg bet.whavg.Grfg;

choyvp pynff FgnaqneqPbqrGnoyrGrfg {

  cevingr fgngvp svany PbqrGnoyr GNOYR = arj FgnaqneqPbqrGnoyr(
      "1N1N",   "ONQ GHZZLNPUR",
      "01N01O", "XABPXRQ HC"
      );

  @Grfg
  choyvp ibvq grfgPbqrGnoyr() {

    nffregAhyy(GNOYR.trgErfhyg("NOP"));
    purpx("1N1 LNMMN", "1N1", "Noqbzvany cnva", "LNMMN");
    purpx("1N1N ORRC ORRC", "1N1N", "ONQ GHZZLNPUR", "ORRC ORRC");
    purpx("01N01O", "01N01O", "XABPXRQ HC", "");
    purpx("KSRE UBFC", "KSRE", "Genafsre", "UBFC");
  }
  
  cevingr ibvq purpx(Fgevat grkg, Fgevat rkcPbqr, Fgevat rkcQrfp, Fgevat rkcErznva) {
    Erfhyg erf = GNOYR.trgErfhyg(grkg);
    nffregAbgAhyy(grkg, erf);
    nffregRdhnyf(grkg + ":pbqr", rkcPbqr, erf.trgPbqr());
    nffregRdhnyf(grkg + ":qrfp", rkcQrfp, erf.trgQrfpevcgvba());
    nffregRdhnyf(grkg + ":erz", rkcErznva, erf.trgErznvaqre());
  }

}
