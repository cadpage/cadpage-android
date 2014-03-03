cnpxntr arg.narv.pnqcntr.cnefref.BU;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Havba Pbhagl, BU
Pbagnpg: "Qnavry Obbar Fe." <qnavry.obbarfe@tznvy.pbz>
Fraqre: vqargjbexf@pb.havba.bu.hf

SVER, 121 R OYNTEBIR FG 1/2 EVPUJBBQ, ORNGGL NIR,EVPUJBBQ//A PYVAGBA FG,EVPUJBBQ,\a
URNEG CEBOYRZF, 10535 ZNCYR QRYY EQ ZNELFIVYYR, FGNGR EBHGR 37,ZNELFIVYYR//, 53 LBS CBFF URNEG\a
SNYY/ONPX VAWHEL, 85 EBFR FG ZNTARGVP FCEVATF, J PNGUREVAR FG,ZNTARGVP FCEVATF//J ZNTARGVP FG,ZNTARGVP FCEVATF, QNYR SNTT SRYY NAQ UV
QVSSVPHYGL OERNGUVAT, 14936 ZVYYRE EQ EVPUJBBQ, ZPZVYYRA EQ,EVPUJBBQ//FANER EQ,EVPUJBBQ, 74 LB QO\a

 */

choyvp pynff BUHavbaPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BUHavbaPbhaglCnefreGrfg() {
    frgCnefre(arj BUHavbaPbhaglCnefre(), "HAVBA PBHAGL", "BU");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "SVER, 121 R OYNTEBIR FG 1/2 EVPUJBBQ, ORNGGL NIR,EVPUJBBQ//A PYVAGBA FG,EVPUJBBQ,\a",
        "PNYY:SVER",
        "NQQE:121 R OYNTEBIR FG 1/2",
        "PVGL:EVPUJBBQ",
        "K:ORNGGL NIR & A PYVAGBA FG");

    qbGrfg("G2",
        "URNEG CEBOYRZF, 10535 ZNCYR QRYY EQ ZNELFIVYYR, FGNGR EBHGR 37,ZNELFIVYYR//, 53 LBS CBFF URNEG\a",
        "PNYY:URNEG CEBOYRZF",
        "NQQE:10535 ZNCYR QRYY EQ",
        "PVGL:ZNELFIVYYR",
        "K:FGNGR EBHGR 37",
        "VASB:53 LBS CBFF URNEG");

    qbGrfg("G3",
        "SNYY/ONPX VAWHEL, 85 EBFR FG ZNTARGVP FCEVATF, J PNGUREVAR FG,ZNTARGVP FCEVATF//J ZNTARGVP FG,ZNTARGVP FCEVATF, QNYR SNTT SRYY NAQ UV",
        "PNYY:SNYY/ONPX VAWHEL",
        "NQQE:85 EBFR FG",
        "PVGL:ZNTARGVP FCEVATF",
        "K:J PNGUREVAR FG & J ZNTARGVP FG",
        "VASB:QNYR SNTT SRYY NAQ UV");

    qbGrfg("G4",
        "QVSSVPHYGL OERNGUVAT, 14936 ZVYYRE EQ EVPUJBBQ, ZPZVYYRA EQ,EVPUJBBQ//FANER EQ,EVPUJBBQ, 74 LB QO\a",
        "PNYY:QVSSVPHYGL OERNGUVAT",
        "NQQE:14936 ZVYYRE EQ",
        "PVGL:EVPUJBBQ",
        "K:ZPZVYYRA EQ & FANER EQ",
        "VASB:74 LB QO");
      
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj BUHavbaPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}