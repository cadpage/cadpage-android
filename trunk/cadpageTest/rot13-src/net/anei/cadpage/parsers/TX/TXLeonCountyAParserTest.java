cnpxntr arg.narv.pnqcntr.cnefref.GK;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;


/* 
Yrba Pbhagl, GK
Pbagnpg: Npgvir911
Ntrapl anzr: Ohssnyb ISQ
Ybpngvba: Ohssnyb, GK, Havgrq Fgngrf
Fraqre: pnqnyregf@rsbeprfbsgjner.pbz 

(Qvfcngpu Nyreg) TENFF SVER\a\aZZ 177 FO\aNcg \aOHSSNYB\aAbgr: FO FVQR TENFF SVER
(Qvfcngpu Nyreg) TENFF SVER\a\aZZ AO 177 178\aNcg \aOHSSNYB
(Qvfcngpu Nyreg) SVER\a\a430 TBYQRA NPERF \aNcg \aOHSSNYB\aAbgr: fzryyf fbzrguvat oheavat sebz ure n.p.
(Qvfcngpu Nyreg) ZRQVPNY RZRETRAPL\a\a440 F YBIR \aNcg \aBNXJBBQ\aAbgr: NYIVA ENL OEBJA HAERFCBAFVIR   PNYYRQ VA OL ARVTUOBE
(Qvfcngpu Nyreg) SVER\a\a540 R PBZZREPR\aNcg \aOHSSNYB\aAbgr: ubhfr shyyl rathysrq
(Qvfcngpu Nyreg) SVER\a\a540 R PBZZREPR\aNcg \aOHSSNYB
(Qvfcngpu Nyreg) SVER\a\a123 RNFL FG\aNcg \aPRAGREIVYYR

 */


choyvp pynff GKYrbaPbhaglNCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp GKYrbaPbhaglNCnefreGrfg() {
    frgCnefre(arj GKYrbaPbhaglNCnefre(), "YRBA PBHAGL", "GK");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(Qvfcngpu Nyreg) TENFF SVER\a\aZZ 177 FO\aNcg \aOHSSNYB\aAbgr: FO FVQR TENFF SVER",
        "PNYY:TENFF SVER",
        "NQQE:ZZ 177 FO",
        "ZNQQE:ZZ 177",    //tbbtyr zncf tvirf 3 hayvxryl ybpngvbaf va Ohssnyb. Abg fher vs guvf vf npghnyyl na nqqerff.
        "PVGL:OHSSNYB",
        "VASB:FO FVQR TENFF SVER");

    qbGrfg("G2",
        "(Qvfcngpu Nyreg) TENFF SVER\a\aZZ AO 177 178\aNcg \aOHSSNYB",
        "PNYY:TENFF SVER",
        "NQQE:ZZ AO 177 178",
        "ZNQQE:ZZ 177 178",    //tbbtyr zncf pna'g svaq ng nyy
        "PVGL:OHSSNYB");

    qbGrfg("G3",
        "(Qvfcngpu Nyreg) SVER\a\a430 TBYQRA NPERF \aNcg \aOHSSNYB\aAbgr: fzryyf fbzrguvat oheavat sebz ure n.p.",
        "PNYY:SVER",
        "NQQE:430 TBYQRA NPERF",
        "PVGL:OHSSNYB",
        "VASB:fzryyf fbzrguvat oheavat sebz ure n.p.");

    qbGrfg("G4",
        "(Qvfcngpu Nyreg) ZRQVPNY RZRETRAPL\a\a440 F YBIR \aNcg \aBNXJBBQ\aAbgr: NYIVA ENL OEBJA HAERFCBAFVIR   PNYYRQ VA OL ARVTUOBE",
        "PNYY:ZRQVPNY RZRETRAPL",
        "NQQE:440 F YBIR",
        "PVGL:BNXJBBQ",
        "VASB:NYIVA ENL OEBJA HAERFCBAFVIR   PNYYRQ VA OL ARVTUOBE");

    qbGrfg("G5",
        "(Qvfcngpu Nyreg) SVER\a\a540 R PBZZREPR\aNcg \aOHSSNYB\aAbgr: ubhfr shyyl rathysrq",
        "PNYY:SVER",
        "NQQE:540 R PBZZREPR",
        "PVGL:OHSSNYB",
        "VASB:ubhfr shyyl rathysrq");

    qbGrfg("G6",
        "(Qvfcngpu Nyreg) SVER\a\a540 R PBZZREPR\aNcg \aOHSSNYB",
        "PNYY:SVER",
        "NQQE:540 R PBZZREPR",
        "PVGL:OHSSNYB");

    qbGrfg("G7",
        "(Qvfcngpu Nyreg) SVER\a\a123 RNFL FG\aNcg \aPRAGREIVYYR",
        "PNYY:SVER",
        "NQQE:123 RNFL FG",    //svaqf 123 Nzrevpna Onax Fg, Uhagfivyyr, GK 
        "PVGL:PRAGREIVYYR");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj GKYrbaPbhaglNCnefreGrfg().trarengrGrfgf("G1");
  }
}
