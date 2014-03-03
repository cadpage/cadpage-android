cnpxntr arg.narv.pnqcntr.cnefref.PB;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.PB.PBChroybPbhaglCnefre;

vzcbeg bet.whavg.Grfg;

/*
Chroyb ESQ, PB
Pbagnpg: Fgrira Cnffvt <tvm5312@tznvy.pbz>
Fraqre: fhercntr@jqfy.hf
Flfgrz: Fcvyyzna zbovyr
(Cntr ) 12:43CZ 11/28 EHENY SVER va gur nern bs 1543 Pbbcre Cy ercbeg bs urnil fzbxr ab synzrf fubjvat...xe
(Cntr ) 04:26CZ 12/13 eheny sver:  ujl 50 & 27gu ya; abegu fvqr, 10 sg sver...gqo
(Cntr ) 04:52CZ 11/27 NGGA EHENY SVER: 28141 fbhgu eq....znyr cbff bireqbfr...wnn
(Cntr ) 09:18NZ 12/11 eheny sver  33550 ujl 96 R Ybg 379 35 lbs pbaihyfvbaf
(Cntr ) 11:45CZ 11/15 NGGA EHENY SVER: 1917 a fnagn sr nir...ng gur pne jnfu....39lbs...frvmher...wnn


Pbagnpg: Tvm <cnffvt5312@ubgznvy.pbz>
(Cntr ) eheny sver...23090 tnyr eq srznyr jvgu purfg cnva
(Cntr ) 328 nibaqnyr oyiq; 16 lbz cnffrq bhg rneyvre gbqnl, pnag gnyx abj... tb va fvqr qbbe...fzo
(Cntr ) Ngga Eheny Sver...27767 Ujl 50 R.... 89 lbs cnffrq bhg...enpu
(Cntr ) EHENY  75 lbs oernguvat qvss  1130 JNTB QE
(Cntr ) ngga chroyb eheny sver 27025 gbhepurl jnl srznyr qvmml naq abg srryvat tbbq
(Cntr ) 31918 ujl 96 r; ybns & wht; srz qvmml; nyzbfg snvagrq...gqo

Pbagnpg: Jvyyvr Znegva <jvyyvfzneg84@tznvy.pbz>
Fraqre: fhercntr@jqfy.hf
(Cntr ) 2027 mvaab oyiq; zrqvpny nynez ba 71 lbs p/b qvss oernguvat. srz unf pbcq naq ba bkltra. xpd

*/

choyvp pynff PBChroybPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp PBChroybPbhaglCnefreGrfg() {
    frgCnefre(arj PBChroybPbhaglCnefre(), "CHROYB PBHAGL", "PB");
  }
  
  @Grfg
  choyvp ibvq grfg1Cnefre() {
    
    qbGrfg("G1",
        "(Cntr ) 12:43CZ 11/28 EHENY SVER va gur nern bs 1543 Pbbcre Cy ercbeg bs urnil fzbxr ab synzrf fubjvat...xe",
        "NQQE:1543 Pbbcre Cy",
        "PNYY:EHENY SVER va gur nern bs",
        "VASB:ercbeg bs urnil fzbxr ab synzrf fubjvat");
    
    qbGrfg("G2",
        "(Cntr ) 04:26CZ 12/13 eheny sver:  ujl 50 & 27gu ya; abegu fvqr, 10 sg sver...gqo",
        "NQQE:ujl 50 & 27gu ya",
        "PNYY:eheny sver:",
        "VASB:abegu fvqr, 10 sg sver");
    
    qbGrfg("G3", 
        "(Cntr ) 04:52CZ 11/27 NGGA EHENY SVER: 28141 fbhgu eq....znyr cbff bireqbfr...wnn",
        "NQQE:28141 fbhgu eq",
        "PNYY:NGGA EHENY SVER:",
        "VASB:znyr cbff bireqbfr");
    
    qbGrfg("G4",
        "(Cntr ) 09:18NZ 12/11 eheny sver  33550 ujl 96 R Ybg 379 35 lbs pbaihyfvbaf",
        "NQQE:33550 ujl 96 R",
        "PNYY:eheny sver",
        "NCG:379",
        "VASB:35 lbs pbaihyfvbaf");
    
    qbGrfg("G5",
        "(Cntr ) 11:45CZ 11/15 NGGA EHENY SVER: 1917 a fnagn sr nir...ng gur pne jnfu....39lbs...frvmher...wnn",
        "NQQE:1917 a fnagn sr nir",
        "PNYY:NGGA EHENY SVER:",
        "VASB:ng gur pne jnfu / 39lbs / frvmher");
  }
  
  @Grfg
  choyvp ibvq grfg2Cnefre() {

    qbGrfg("G1",
        "(Cntr ) eheny sver...23090 tnyr eq srznyr jvgu purfg cnva",
        "PNYY:eheny sver",
        "NQQE:23090 tnyr eq",
        "VASB:srznyr jvgu purfg cnva");

    qbGrfg("G2",
        "(Cntr ) 328 nibaqnyr oyiq; 16 lbz cnffrq bhg rneyvre gbqnl, pnag gnyx abj... tb va fvqr qbbe...fzo",
        "NQQE:328 nibaqnyr oyiq",
        "VASB:16 lbz cnffrq bhg rneyvre gbqnl, pnag gnyx abj / tb va fvqr qbbe");

    qbGrfg("G3",
        "(Cntr ) Ngga Eheny Sver...27767 Ujl 50 R.... 89 lbs cnffrq bhg...enpu",
        "PNYY:Ngga Eheny Sver",
        "NQQE:27767 Ujl 50 R",
        "VASB:89 lbs cnffrq bhg");

    qbGrfg("G4",
        "(Cntr ) EHENY  75 lbs oernguvat qvss  1130 JNTB QE",
        "NQQE:1130 JNTB QE",
        "PNYY:EHENY  75 lbs oernguvat qvss");

    qbGrfg("G5",
        "(Cntr ) ngga chroyb eheny sver 27025 gbhepurl jnl srznyr qvmml naq abg srryvat tbbq",
        "PNYY:ngga chroyb eheny sver",
        "NQQE:27025 gbhepurl jnl",
        "VASB:srznyr qvmml naq abg srryvat tbbq");

    qbGrfg("G6",
        "(Cntr ) 31918 ujl 96 r; ybns & wht; srz qvmml; nyzbfg snvagrq...gqo",
        "NQQE:31918 ujl 96 r",
        "VASB:ybns & wht / srz qvmml / nyzbfg snvagrq");

    qbGrfg("G7",
        "(Cntr ) 2027 mvaab oyiq; zrqvpny nynez ba 71 lbs p/b qvss oernguvat. srz unf pbcq naq ba bkltra. xpd",
        "NQQE:2027 mvaab oyiq",
        "VASB:zrqvpny nynez ba 71 lbs p/b qvss oernguvat. srz unf pbcq naq ba bkltra. xpd");
   
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj PBChroybPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}   