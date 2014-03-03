cnpxntr arg.narv.pnqcntr.cnefref.AP;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/* 
Qhcyva Pbhagl, AP
Pbagnpg: Wrsserl Nyyra <wrsserl.nyyra84@tznvy.pbz>
Fraqre: Q.PUNZOREF@qhcyvapbhaglap.pbz

Q.PUNZOREF:113 TRBETR EQ SNVFBA JNEERA EQ - FE 1301 K QRNQ RAQ 15:50:43 VYYARFF PNYYRE NQI FUR VF NG N ARVTUOBEF UBHFR, ORYVRIRF UR VF VAFVQR NAQ CBFF FVPX NQI UR UNF ORRA FVPX ER @ 1322 JNEERA EQ FE 1301 GB QRNQ RAQ
G.XRAARQL:353 R V 40 ZZ PNYYRJE QHCYVA 12:34:02
G.XRAARQL:110 R ZNVA FG RKG SNVFBA 16:15:11
G.XRAARQL:1 16:37:58 BHG BS FREIVPR SBE NAL ERNFBA SNVFBA ERFPHR 5 10-17 OEHFU JVYY ERFCBAFR VA GURER CYNPR BPN: 2012001083
G.XRAARQL:364 V 40 ZZ QHCYVA 15:50:25 NPPVQRAG-CEBCREGL QNZNTR BAYL NAQ SNVFBA RKVG AB BAR VF UHEG TERL UBAQN NAQ N FVYRIE GNHEHF IRUVPYRF VA EQ QHCYVA V 40

Pbagnpg: Oenaqba Gheare <ogheare605@rzonedznvy.pbz>
Fraqre: Q.PUNZOREF@qhcyvapbhaglap.pbz 
F: Z:Q.PUNZOREF:ERZVAQRE BS YVIR OHEA ZBAQNL AVTUG, ABIRZORE 26. ARRQ GB OR NG GUR FGNGVBA OL 630CZ 
F:puvrsf zrrgvat Z:12/12/2012 12:09:19 CZ RFG - erzvaqre sver puvrsf zrrgvat gbavtug ng 07:30 ng Xranafivyyr SQ\a
( 2 bs  2)  JNF VA NYBG BS CNVA, 

*/

choyvp pynff APQhcyvaPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp APQhcyvaPbhaglCnefreGrfg() {
    frgCnefre(arj APQhcyvaPbhaglCnefre(), "QHCYVA PBHAGL", "AP");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "Q.PUNZOREF:113 TRBETR EQ SNVFBA JNEERA EQ - FE 1301 K QRNQ RAQ 15:50:43 VYYARFF PNYYRE NQI FUR VF NG N ARVTUOBEF UBHFR, ORYVRIRF UR VF VAFVQR NAQ CBFF FVPX NQI UR UNF ORRA FVPX ER @ 1322 JNEERA EQ FE 1301 GB QRNQ RAQ",
        "NQQE:113 TRBETR EQ",  // Tbbtyr pnyyf guvf TRBETRF EQ
        "PVGL:SNVFBA",
        "K:JNEERA EQ - FE 1301 / QRNQ RAQ",
        "GVZR:15:50:43",
        "VASB:VYYARFF PNYYRE NQI FUR VF NG N ARVTUOBEF UBHFR, ORYVRIRF UR VF VAFVQR NAQ CBFF FVPX NQI UR UNF ORRA FVPX ER @ 1322 JNEERA EQ FE 1301 GB QRNQ RAQ");

    qbGrfg("G2",
        "G.XRAARQL:353 R V 40 ZZ PNYYRJE QHCYVA 12:34:02",
        "NQQE:353 R V 40 ZZ PNYYRJE",
        "GVZR:12:34:02",
        "PNYY:NYREG");

    qbGrfg("G3",
        "G.XRAARQL:110 R ZNVA FG RKG SNVFBA 16:15:11",
        "NQQE:110 R ZNVA FG RKG",
        "ZNQQE:110 R ZNVA FG",
        "PVGL:SNVFBA",
        "GVZR:16:15:11",
        "PNYY:NYREG");

    qbGrfg("G4",
        "G.XRAARQL:1 16:37:58 BHG BS FREIVPR SBE NAL ERNFBA SNVFBA ERFPHR 5 10-17 OEHFU JVYY ERFCBAFR VA GURER CYNPR BPN: 2012001083",
        "NQQE:1",
        "GVZR:16:37:58",
        "VASB:BHG BS FREIVPR SBE NAL ERNFBA SNVFBA ERFPHR 5 10-17 OEHFU JVYY ERFCBAFR VA GURER CYNPR",
        "VQ:2012001083");

    qbGrfg("G5",
        "G.XRAARQL:364 V 40 ZZ QHCYVA 15:50:25 NPPVQRAG-CEBCREGL QNZNTR BAYL NAQ SNVFBA RKVG AB BAR VF UHEG TERL UBAQN NAQ N FVYRIE GNHEHF IRUVPYRF VA EQ QHCYVA V 40",
        "NQQE:364 V 40 ZZ",
        "GVZR:15:50:25",
        "VASB:NPPVQRAG-CEBCREGL QNZNTR BAYL NAQ SNVFBA RKVG AB BAR VF UHEG TERL UBAQN NAQ N FVYRIE GNHEHF IRUVPYRF VA EQ QHCYVA V 40");
  }

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj APQhcyvaPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}
