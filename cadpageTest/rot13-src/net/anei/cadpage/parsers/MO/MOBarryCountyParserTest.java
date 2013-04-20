cnpxntr arg.narv.pnqcntr.cnefref.ZB;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;


/*
Oneel Pbhagl, ZB
Pbagnpg: Elna Wbl <penmlebpxw@tznvy.pbz>

OP911:NYZ >NYNEZF 23544 SNEZ EBNQ 2040 ONEEL PBHAGL WHYVR XRRARE 8775350563 Znc: Tevqf:0,0 Pnq: 2011-0000015066
OP911:ZINHAX>ZBGBE IRU NPP HAXABJA VAW FGNGR UVTUJNL 39 WRAXVAF IREVMBA JVERYRFF Pnq: 2011-0000009418
OP911:SVERF >FGEHPGHER SVER 23270 FGNGR UVTUJNL GG ONEEL PBHAGL PNUQ ERNIVF 3350036 Znc: Tevqf:0,0 Pnq: 2011-0000015655

*/

choyvp pynff ZBOneelPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp ZBOneelPbhaglCnefreGrfg() {
    frgCnefre(arj ZBOneelPbhaglCnefre(), "ONEEL PBHAGL", "ZB");
  }

 
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "OP911:NYZ >NYNEZF 23544 SNEZ EBNQ 2040 ONEEL PBHAGL WHYVR XRRARE 8775350563 Znc: Tevqf:0,0 Pnq: 2011-0000015066",
        "PNYY:NYNEZF",
        "NQQE:23544 SNEZ EBNQ 2040",
        "ANZR:WHYVR XRRARE",
        "CUBAR:8775350563",
        "VQ:2011-0000015066");

    qbGrfg("G2",
        "OP911:ZINHAX>ZBGBE IRU NPP HAXABJA VAW FGNGR UVTUJNL 39 WRAXVAF IREVMBA JVERYRFF Pnq: 2011-0000009418",
        "PNYY:ZBGBE IRU NPP HAXABJA VAW",
        "NQQE:FGNGR UVTUJNL 39",
        "ZNQQE:FGNGR 39",
        "PVGL:WRAXVAF",
        "VQ:2011-0000009418");

    qbGrfg("G3",
        "OP911:SVERF >FGEHPGHER SVER 23270 FGNGR UVTUJNL GG ONEEL PBHAGL PNUQ ERNIVF 3350036 Znc: Tevqf:0,0 Pnq: 2011-0000015655",
        "PNYY:FGEHPGHER SVER",
        "NQQE:23270 FGNGR UVTUJNL GG",
        "ZNQQE:23270 FGNGR GG",
        "ANZR:PNUQ ERNIVF",
        "CUBAR:3350036",
        "VQ:2011-0000015655");
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj ZBOneelPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}