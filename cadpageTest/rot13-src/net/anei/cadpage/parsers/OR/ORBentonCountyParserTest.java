cnpxntr arg.narv.pnqcntr.cnefref.BE;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.BE.BEOragbaPbhaglCnefre;

vzcbeg bet.whavg.Grfg;

/*    
Fnzcyr Oragba Pbhagl Cntr
Pbagnpg: xrapk@crnx.bet
Fraqre: nyregf@pbeinyyvf.rnyregtbi.pbz
(Pbeinyyvf Nyreg) VAP: PBQR 1 ZRQVPNY\aNQQ:1740 ZNVA FG\aNCG:\aPVGL:CUVYBZNGU\aK:A 17GU FG * A 18GU FG\aZNC:540-365\aPSF:0907010-119\aQVF:CUVYBZNGU SVER
(Pbeinyyvf Nyreg) VAP:PBZZ SVER NYNEZ\aNQQ:421 F 19GU FG\aNCG:\aPVGL:CUVYBZNGU\aK:NFU FG * PRQNE FG\aZNC:540-360\aPSF:100410-188\aQVF:CUVYBZNGU SVER\aQVF:CUV
(Pbeinyyvf Nyreg) VAP:HAXABJA ZRQVPNY\aNQQ:504 ZRYIVYY PERFPRAG NI [CUVYBZNGU]\aNCG:\aPVGL:CUVYBZNGU\aK:FHAFUVAR NI\aZNC:550-385\aPSF:101710-223\aQVF:CUVYBZ
(Pbeinyyvf Nyreg) VAP:OVPLPYR NPPVQRAG\aNQQ:QRPXRE EQ naq QRPXRE EVQTR EQ\aNCG:\aPVGL:CUVYBZNGU\aK:QRPXRE EQ * ONAXF YA\aZNC:480-420\aPSF:070611-52\aQVF:ORA

*/

choyvp pynff BEOragbaPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BEOragbaPbhaglCnefreGrfg() {
    frgCnefre(arj BEOragbaPbhaglCnefre(), "ORAGBA PBHAGL", "BE");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {
    qbGrfg("G1",
        "(Pbeinyyvf Nyreg) VAP: PBQR 1 ZRQVPNY\aNQQ:1740 ZNVA FG\aNCG:\aPVGL:CUVYBZNGU\aK:A 17GU FG * A 18GU FG\aZNC:540-365\aPSF:0907010-119\aQVF:CUVYBZNGU SVER",
        "PNYY:PBQR 1 ZRQVPNY",
        "NQQE:1740 ZNVA FG",
        "PVGL:CUVYBZNGU",
        "K:A 17GU FG * A 18GU FG",
        "ZNC:540-365",
        "VQ:0907010-119",
        "HAVG:CUVYBZNGU SVER");

    qbGrfg("G2",
        "(Pbeinyyvf Nyreg) VAP:PBZZ SVER NYNEZ\aNQQ:421 F 19GU FG\aNCG:\aPVGL:CUVYBZNGU\aK:NFU FG * PRQNE FG\aZNC:540-360\aPSF:100410-188\aQVF:CUVYBZNGU SVER\aQVF:CUV",
        "PNYY:PBZZ SVER NYNEZ",
        "NQQE:421 F 19GU FG",
        "PVGL:CUVYBZNGU",
        "K:NFU FG * PRQNE FG",
        "ZNC:540-360",
        "VQ:100410-188",
        "HAVG:CUVYBZNGU SVER");
    
    qbGrfg("G3",
        "(Pbeinyyvf Nyreg) VAP:HAXABJA ZRQVPNY\aNQQ:504 ZRYIVYY PERFPRAG NI [CUVYBZNGU]\aNCG:\aPVGL:CUVYBZNGU\aK:FHAFUVAR NI\aZNC:550-385\aPSF:101710-223\aQVF:CUVYBZ",
        "PNYY:HAXABJA ZRQVPNY",
        "NQQE:504 ZRYIVYY PERFPRAG",
        "PVGL:CUVYBZNGU",
        "K:FHAFUVAR NI",
        "ZNC:550-385",
        "VQ:101710-223",
        "HAVG:CUVYBZ");

    qbGrfg("G4",
        "(Pbeinyyvf Nyreg) VAP:OVPLPYR NPPVQRAG\aNQQ:QRPXRE EQ naq QRPXRE EVQTR EQ\aNCG:\aPVGL:CUVYBZNGU\aK:QRPXRE EQ * ONAXF YA\aZNC:480-420\aPSF:070611-52\aQVF:ORA",
        "PNYY:OVPLPYR NPPVQRAG",
        "NQQE:QRPXRE EQ naq QRPXRE EVQTR EQ",
        "ZNQQE:QRPXRE EQ & QRPXRE EVQTR EQ",
        "K:QRPXRE EQ * ONAXF YA",
        "ZNC:480-420",
        "VQ:070611-52",
        "HAVG:ORA");
    
  }
  
  choyvp fgngvp ibvq znva(Fgevat netf[]) {
    arj BEOragbaPbhaglCnefreGrfg().trarengrGrfgf("G4", "PNYY NQQE PVGL K ZNC VQ");
  }
}