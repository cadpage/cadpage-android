cnpxntr arg.narv.pnqcntr.cnefref.JI;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Znfba Pbhagl, JI

Pbagnpg: Mnpu Nqxvaf <mnbarfvkgrra@tznvy.pbz>
Fraqre: znfbapnq@znfbapbhaglbrf.pbz
 
ZNFBAPNQ:SVEFGA>FGNAQ OL SBE SVER PBIRENTR PNORYY PBHAGL FG600 PNORYY PBHAGL Pnq: 2013-0000104009
ZNFBAPNQ:NGIZIP>NGI PENFU EBOREG YA KF: RINAF EQ RINAF OHGPU OYNPX Znc: Tevqf:, Pnq: 2013-0000104016
ZNFBAPNQ:ZIPHAX>ZIP HAXABJA VAWHEVRF 40000 UHAGVATGBA EQ KF: UNAANA GENPR EQ TYRAJBBQ WRAAN 3045932951 Znc: Tevqf:, Pnq: 2013-0000103864
ZNFBAPNQ:ZRQHAX>ZRQVPNY PNYY - HAXABJA 4851 JUVGGRA EVQTR EQ KF: GVZOREJBBQ YA ZVYGBA FUREEV GUBZCFBA 3046689405 Znc: Tevqf:, Pnq: 2013-0000103720

*/

choyvp pynff JIZnfbaPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp JIZnfbaPbhaglCnefreGrfg() {
    frgCnefre(arj JIZnfbaPbhaglCnefre(), "ZNFBA PBHAGL", "JI", gehr);
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "ZNFBAPNQ:SVEFGA>FGNAQ OL SBE SVER PBIRENTR PNORYY PBHAGL FG600 PNORYY PBHAGL Pnq: 2013-0000104009",
        "PBQR:SVEFGA",
        "PNYY:FGNAQ OL SBE SVER PBIRENTR",
        "NQQE:PNORYY PBHAGL FG600",
        "ZNQQE:PNORYY PBHAGL JI 600",
        "PVGL:PNORYY PBHAGL",
        "VQ:2013-0000104009");

    qbGrfg("G2",
        "ZNFBAPNQ:NGIZIP>NGI PENFU EBOREG YA KF: RINAF EQ RINAF OHGPU OYNPX Znc: Tevqf:, Pnq: 2013-0000104016",
        "PBQR:NGIZIP",
        "PNYY:NGI PENFU",
        "NQQE:EBOREG YA",
        "ZNQQE:EBOREG YA & RINAF EQ", // abg znccvat
        "K:RINAF EQ",
        "PVGL:RINAF",
        "ANZR:OHGPU OYNPX",
        "VQ:2013-0000104016");

    qbGrfg("G3",
        "ZNFBAPNQ:ZIPHAX>ZIP HAXABJA VAWHEVRF 40000 UHAGVATGBA EQ KF: UNAANA GENPR EQ TYRAJBBQ WRAAN 3045932951 Znc: Tevqf:, Pnq: 2013-0000103864",
        "PBQR:ZIPHAX",
        "PNYY:ZIP HAXABJA VAWHEVRF",
        "NQQE:40000 UHAGVATGBA EQ",
        "K:UNAANA GENPR EQ",
        "PVGL:TYRAJBBQ",
        "ANZR:WRAAN",
        "CUBAR:3045932951",
        "VQ:2013-0000103864");

    qbGrfg("G4",
        "ZNFBAPNQ:ZRQHAX>ZRQVPNY PNYY - HAXABJA 4851 JUVGGRA EVQTR EQ KF: GVZOREJBBQ YA ZVYGBA FUREEV GUBZCFBA 3046689405 Znc: Tevqf:, Pnq: 2013-0000103720",
        "PBQR:ZRQHAX",
        "PNYY:ZRQVPNY PNYY - HAXABJA",
        "NQQE:4851 JUVGGRA EVQTR EQ",
        "K:GVZOREJBBQ YA",
        "PVGL:ZVYGBA",
        "ANZR:FUREEV GUBZCFBA",
        "CUBAR:3046689405",
        "VQ:2013-0000103720");
   
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj JIZnfbaPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}