cnpxntr arg.narv.pnqcntr.cnefref.ZB;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Wnfcre Pbhagl, ZB
Pbagnpg: "P. Ivetva S. S. 452" <pwscq452@lnubb.pbz>
Fraqre: @wnfpb.bet
Flfgrz: Vagrtencu (punatvat gb DFFV va Nhthfg)

F: Z:YBAR RYZ/RFGNGR YA- EBYYBIRE\a
F: Z:1725O Erqohq qe- 87 lbz snyy - onpx cnva\a
F: Z:IRUVPYR SVER SVE NAQ OYNPX PNG\a
F: Z:6653 CNEX PVE NCGQ - 87 LBZ SRYY\a
F: Z:3169 A ZVFFBHEV 20 QNL BYQ QVSS OERNGVAT QRYGN ZOC 51P\a\a\a\a\a\a
F: Z:302 XRRARL QE - PW WHAVBE UVTU - CBFFVOYR FRVMHER\a
F: Z:25589 GNOBE ZNVA - QVSS OERNGUVAT\a

*/

choyvp pynff ZBWnfcrePbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp ZBWnfcrePbhaglCnefreGrfg() {
    frgCnefre(arj ZBWnfcrePbhaglCnefre(), "WNFCRE PBHAGL", "ZB");
  }

 
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "F: Z:YBAR RYZ/RFGNGR YA- EBYYBIRE\a",
        "NQQE:YBAR RYZ & RFGNGR YA",
        "PNYY:EBYYBIRE");

    qbGrfg("G2",
        "F: Z:1725O Erqohq qe- 87 lbz snyy - onpx cnva\a",
        "NQQE:1725O Erqohq qe",
        "PNYY:87 lbz snyy - onpx cnva");

    qbGrfg("G3",
        "F: Z:IRUVPYR SVER SVE NAQ OYNPX PNG\a",
        "PNYY:IRUVPYR SVER SVE NAQ OYNPX PNG");

    qbGrfg("G4",
        "F: Z:6653 CNEX PVE NCGQ - 87 LBZ SRYY\a",
        "NQQE:6653 CNEX PVE",
        "NCG:Q",
        "PNYY:87 LBZ SRYY");

    qbGrfg("G5",
        "F: Z:3169 A ZVFFBHEV 20 QNL BYQ QVSS OERNGVAT QRYGN ZOC 51P\a\a\a\a\a\a",
        "NQQE:3169 A ZVFFBHEV 20 QNL BYQ QVSS OERNGVAT QRYGN ZOC 51P");

    qbGrfg("G6",
        "F: Z:302 XRRARL QE - PW WHAVBE UVTU - CBFFVOYR FRVMHER\a",
        "NQQE:302 XRRARL QE",
        "PNYY:PW WHAVBE UVTU - CBFFVOYR FRVMHER");

    qbGrfg("G7",
        "F: Z:25589 GNOBE ZNVA - QVSS OERNGUVAT\a",
        "NQQE:25589 GNOBE ZNVA",
        "PNYY:QVSS OERNGUVAT");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj ZBWnfcrePbhaglCnefreGrfg().trarengrGrfgf("G1", "NQQE NCG PNYY VASB");
  }
}