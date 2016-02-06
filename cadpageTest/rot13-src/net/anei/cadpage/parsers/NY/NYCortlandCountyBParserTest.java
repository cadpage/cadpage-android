cnpxntr arg.narv.pnqcntr.cnefref.AL;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Pbegynaq Pbhagl, AL

Pbagnpg: qnyynf ohgyre <qnyynfohgyre56@tznvy.pbz>
Fraqre: pbegynaqsq@erqazkpnq.pbz

RZF BAYL: 34 SRZNYR- SRYY- NAXYR VAWHEL- NYFB PBZCYNVAVAT BS ONPX CNVA\a22:07:44 02/05/2016 - X FZVGUREF\aSRYY BA GUR FGNVEF ng 14 FBHGU
RZF BAYL: 76S PURFG CNVA, CNVA SEBZ OYBBQ PYBGF, QVSS OERNGUVAT ng 15 RYZ FG; P PBEGYNAQ , 5, PBEGYNAQ . . 21:22:59
CREF VAW ZIN: 3 PNE ZIN, WRRC PNZR SYLVAT NEBHAQ \a19:04:03 02/05/2016 - X FZVGUREF\aNABGURE PNYYRE ERCBEGVAT VAPVQRAG- PNYYRE NZNAQN ZR
NHGB NYNEZ: OBK NYNEZ ng 134 UBZRE NIR; PEZP; 3354 PEZP; P PBEGYNAQ, PBEGYNAQ . . 16:22:02

*/

choyvp pynff ALPbegynaqPbhaglOCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp ALPbegynaqPbhaglOCnefreGrfg() {
    frgCnefre(arj ALPbegynaqPbhaglOCnefre(), "PBEGYNAQ PBHAGL", "AL");
  }
  
  @Grfg
  choyvp ibvq grfgQnyynfOhgyre() {

    qbGrfg("G1",
        "RZF BAYL: 34 SRZNYR- SRYY- NAXYR VAWHEL- NYFB PBZCYNVAVAT BS ONPX CNVA\a" +
        "22:07:44 02/05/2016 - X FZVGUREF\a" +
        "SRYY BA GUR FGNVEF ng 14 FBHGU",

        "PNYY:RZF BAYL",
        "VASB:34 SRZNYR- SRYY- NAXYR VAWHEL- NYFB PBZCYNVAVAT BS ONPX CNVA\aSRYY BA GUR FGNVEF",
        "GVZR:22:07:44",
        "QNGR:02/05/2016",
        "NQQE:14 FBHGU");

     qbGrfg("G2",
         "RZF BAYL: 76S PURFG CNVA, CNVA SEBZ OYBBQ PYBGF, QVSS OERNGUVAT ng 15 RYZ FG; P PBEGYNAQ , 5, PBEGYNAQ . . 21:22:59",
         "PNYY:RZF BAYL",
         "VASB:76S PURFG CNVA, CNVA SEBZ OYBBQ PYBGF, QVSS OERNGUVAT",
         "NQQE:15 RYZ FG",
         "CYNPR:P PBEGYNAQ 5",
         "PVGL:PBEGYNAQ",
         "GVZR:21:22:59");

     qbGrfg("G3",
         "CREF VAW ZIN: 3 PNE ZIN, WRRC PNZR SYLVAT NEBHAQ \a" +
         "19:04:03 02/05/2016 - X FZVGUREF\a" +
         "NABGURE PNYYRE ERCBEGVAT VAPVQRAG- PNYYRE NZNAQN ZR",

         "PNYY:CREF VAW ZIN",
         "VASB:3 PNE ZIN, WRRC PNZR SYLVAT NEBHAQ\aNABGURE PNYYRE ERCBEGVAT VAPVQRAG- PNYYRE NZNAQN ZR",
         "GVZR:19:04:03",
         "QNGR:02/05/2016");

     qbGrfg("G4",
         "NHGB NYNEZ: OBK NYNEZ ng 134 UBZRE NIR; PEZP; 3354 PEZP; P PBEGYNAQ, PBEGYNAQ . . 16:22:02",
         "PNYY:NHGB NYNEZ",
         "VASB:OBK NYNEZ",
         "NQQE:134 UBZRE NIR",
         "CYNPR:PEZP; 3354 PEZP; P PBEGYNAQ",
         "PVGL:PBEGYNAQ",
         "GVZR:16:22:02");
    
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj ALPbegynaqPbhaglOCnefreGrfg().trarengrGrfgf("G1");
  }
}