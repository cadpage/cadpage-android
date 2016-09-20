cnpxntr arg.narv.pnqcntr.cnefref.IN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Xvat Trbetr Pbhagl, IN (O)

Pbagnpg: Npgvir911
Ntrapl anzr: Xvat Trbetr Sver naq Erfphr
Ybpngvba: Xvat Trbetr, IN, Havgrq Fgngrf
Fraqre: <PNQ@pb.xvattrbetr.fgngr.in.hf>

{VYYARFF} VYY, 10404 RVFRAUBJRE QE, XVAT TRBETR, IN  22485, K=UNEEVFBA QE/YVAPBYA QE, 6 ZBA LB SRZNYR VYYARFF, HAFHER JUNG VF TBVAT BA
{SVER NYNEZ PBZZREPVNY} PSNYNEZ, 8079 XVATF UJL, XVAT TRBETR, IN  22485, K=/, SVER NYNEZ MBAR 1  XTCE NYNEZ ZBAVGBE 8007763624
{GRFG PNYY} GRFG, 8494 TENL SBK YA, XVAT TRBETR, IN  22485, K=GEHZCRG PG/QRNQ RAQ, GRFG PNYY - AB ARRQ GB ERFCBAQ

*/

choyvp pynff INXvatTrbetrPbhaglOCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp INXvatTrbetrPbhaglOCnefreGrfg() {
    frgCnefre(arj INXvatTrbetrPbhaglOCnefre(), "XVAT TRBETR PBHAGL", "IN");
  }

  @Grfg
  choyvp ibvq grfgXvatTrbetrSverNaqErfphr() {

    qbGrfg("G1",
        "{VYYARFF} VYY, 10404 RVFRAUBJRE QE, XVAT TRBETR, IN  22485, K=UNEEVFBA QE/YVAPBYA QE, 6 ZBA LB SRZNYR VYYARFF, HAFHER JUNG VF TBVAT BA",
        "PNYY:VYYARFF",
        "PBQR:VYY",
        "NQQE:10404 RVFRAUBJRE QE",
        "PVGL:XVAT TRBETR",
        "FG:IN",
        "K:UNEEVFBA QE/YVAPBYA QE",
        "VASB:6 ZBA LB SRZNYR VYYARFF, HAFHER JUNG VF TBVAT BA");

    qbGrfg("G2",
        "{SVER NYNEZ PBZZREPVNY} PSNYNEZ, 8079 XVATF UJL, XVAT TRBETR, IN  22485, K=/, SVER NYNEZ MBAR 1  XTCE NYNEZ ZBAVGBE 8007763624",
        "PNYY:SVER NYNEZ PBZZREPVNY",
        "PBQR:PSNYNEZ",
        "NQQE:8079 XVATF UJL",
        "PVGL:XVAT TRBETR",
        "FG:IN",
        "VASB:SVER NYNEZ MBAR 1  XTCE NYNEZ ZBAVGBE 8007763624");

    qbGrfg("G3",
        "{GRFG PNYY} GRFG, 8494 TENL SBK YA, XVAT TRBETR, IN  22485, K=GEHZCRG PG/QRNQ RAQ, GRFG PNYY - AB ARRQ GB ERFCBAQ",
        "PNYY:GRFG PNYY",
        "PBQR:GRFG",
        "NQQE:8494 TENL SBK YA",
        "PVGL:XVAT TRBETR",
        "FG:IN",
        "K:GEHZCRG PG/QRNQ RAQ",
        "VASB:GRFG PNYY - AB ARRQ GB ERFCBAQ");

  }

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj INXvatTrbetrPbhaglOCnefreGrfg().trarengrGrfgf("G1");
  }
}
  