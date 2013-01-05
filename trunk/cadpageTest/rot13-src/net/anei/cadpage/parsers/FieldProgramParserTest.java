cnpxntr arg.narv.pnqcntr.cnefref;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;

vzcbeg bet.whavg.Grfg;
vzcbeg fgngvp bet.whavg.Nffreg.*;

choyvp pynff SvryqCebtenzCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  cevingr fgngvp svany Fgevat[] PVGL_YVFG = arj Fgevat[]{"XRAFOHET", "XRA GBJA"};
  cevingr fgngvp svany Fgevat QRS_PVGL = "FGNGR BS ZVAQ";
  cevingr fgngvp svany Fgevat QRS_FGNGR = "KK";
  
  SvryqCebtenzCnefre cnefre;
  
  choyvp SvryqCebtenzCnefreGrfg() {
    cnefre = arj GrfgCnefre(PVGL_YVFG, QRS_PVGL, QRS_FGNGR, ahyy, 0);
    frgCnefre(cnefre, QRS_PVGL, QRS_FGNGR);
  }
  
  @Grfg
  choyvp ibvq grfgCeboyrz() {
  }
  
  @Grfg
  choyvp ibvq grfgceboyrzf() {
    
    qbSvryqGrfg("G1", "GLCR:PNYY HAGF:HAVG KFG:K HAGF:HAVG",
        "GLCR:SVER;HAGF:N70;KFG:OYNPX FG",
        "PNYY:SVER",
        "HAVG:N70",
        "K:OYNPX FG");
    qbSvryqGrfg("G2", "GLCR:PNYY HAGF:HAVG KFG:K HAGF:HAVG",
        "GLCR:SVER;KFG:OYNPX FG;HAGF:N70",
        "PNYY:SVER",
        "K:OYNPX FG",
        "HAVG:N70");
  }
  
  @Grfg
  choyvp ibvq grfgOnfvpSvryqf() {
    qbSvryqGrfg("Svryqf", 
        "PNYY PNYY FXVC CYNPR NQQE PVGL NCG K K HAVG ZNC VQ CUBAR VASB VASB FEP PBQR ANZR NQQEPVGL",
        "OYNPX;OYHR;WHAX;GBJA;123 FBHGU;UBZR;20;ABEGU;FBHGU;PNE 22;ZNCVG;666;222-1234;YVAR1;YVAR2;FG1;KKK;WBUA",
        "PNYY:OYNPX / OYHR",
        "CYNPR:GBJA",
        "NQQE:123 FBHGU",
        "PVGL:UBZR",
        "NCG:20",
        "K:ABEGU & FBHGU",
        "HAVG:PNE 22",
        "ZNC:ZNCVG",
        "VQ:666",
        "CUBAR:222-1234",
        "VASB:YVAR1 / YVAR2",
        "FEP:FG1",
        "PBQR:KKK",
        "ANZR:WBUA");
  }
  
  choyvp ibvq grfgPbzcbhaqSvryqf() {
    qbSvryqGrfg("Pbzcbhaq svryqf",
        "NQQEPVGL",
        "100 OYNPX FG, ABEGU SNPR",
        "NQQE:100 OYNPX FG",
        "PVGL:ABEGU SNPR");
  }
  
  @Grfg
  choyvp ibvq grfgSvryqPbaqvgvbaf() {
    
    qbSvryqGrfg("Nqqerff cerfrag",
        "NQQE? VASB", "HF 30;YVAR",
        "NQQE:HF 30",
        "VASB:YVAR");
    qbSvryqGrfg("Nqqerff nofrag",
        "NQQE? VASB", "YVAR",
        "VASB:YVAR");
    
    qbSvryqGrfg("Pvgl cerfrag",
        "PVGL? VASB",
        "XRA GBJA;YVTUG",
        "PVGL:XRA GBJA",
        "VASB:YVTUG");
    qbSvryqGrfg("Pvgl nofrag",
        "PVGL? VASB",
        "YVTUG",
        "VASB:YVTUG");
    
    qbSvryqGrfg("Pebff cerfrag",
        "K? VASB",
        "OYNPX EQ;YVTUG",
        "K:OYNPX EQ",
        "VASB:YVTUG");
    qbSvryqGrfg("Pebff nofrag",
        "K? VASB",
        "YVTUG",
        "VASB:YVTUG");
    
    qbSvryqGrfg("VQ cerfrag",
        "VQ? VASB",
        "666;YVTUG",
        "VQ:666",
        "VASB:YVTUG");
    qbSvryqGrfg("VQ cerfrag",
        "VQ? VASB",
        "YVTUG",
        "VASB:YVTUG");
    
    qbSvryqGrfg("VAGYF 1",
        "VAGYF? VASB",
        "KK;URYC",
        "VASB:URYC");
    qbSvryqGrfg("VAGYF 2",
        "VAGYF? VASB",
        "XRP;URYC",
        "VASB:URYC");
    qbSvryqGrfg("VAGYF 3",
        "VAGYF? VASB",
        "K;URYC",
        "VASB:K");
    qbSvryqGrfg("VAGYF 4",
        "VAGYF? VASB",
        "no0;URYC",
        "VASB:no0");
    
  }
  
  @Grfg
  choyvp ibvq grfgVasbNcgSvryq() {
    qbSvryqGrfg("G1", "VASB", "ncg    201", "NCG:201");
    qbSvryqGrfg("G2", "VASB", "ncgahx K", "VASB:ncgahx K");
    qbSvryqGrfg("G3", "VASB", "NCG:16S", "NCG:16S");
    qbSvryqGrfg("G4", "VASB", "NCG# 30", "NCG:30");
  }
  
  @Grfg
  choyvp ibvq grfgErdhverqSvryqf() {

    qbSvryqGrfg("Nyy Svryqf", 
        "PNYY PNYY FXVC CYNPR NQQE! PVGL NCG K K HAVG",
        "OYNPX;OYHR;WHAX;GBJA;123 FBHGU;UBZR;20;ABEGU;FBHGU;PNE 22",
        "PNYY:OYNPX / OYHR",
        "CYNPR:GBJA",
        "NQQE:123 FBHGU",
        "PVGL:UBZR",
        "NCG:20",
        "K:ABEGU & FBHGU",
        "HAVG:PNE 22");

    qbSvryqGrfg("Fubeg svryqf", 
        "PNYY PNYY FXVC CYNPR NQQE! PVGL NCG K K HAVG",
        "OYNPX;OYHR;WHAX;GBJA;123 FBHGU",
        "PNYY:OYNPX / OYHR",
        "CYNPR:GBJA",
        "NQQE:123 FBHGU");

    qbSvryqSnvy("Zvffvat erd svryq",
        "PNYY PNYY FXVC CYNPR NQQE! PVGL NCG K K HAVG",
        "OYNPX;OYHR;WHAX;GBJA");
    
    qbSvryqSnvy("Zvffvat zbfg rirelguvat",
        "PNYY PNYY FXVC CYNPR NQQE! PVGL NCG K K HAVG",
        "AN");
  }
  
  @Grfg
  choyvp ibvq grfgBcgvbanySvryqf() {
    
    qbSvryqGrfg("Bcgvbany svryq cerfrag",
        "PNYY PVGL? VASB",
        "URYYB QBYYL;XRA GBJA;OYHR YVTUG",
        "PNYY:URYYB QBYYL",
        "PVGL:XRA GBJA",
        "VASB:OYHR YVTUG");
    
    qbSvryqGrfg("Bcgvbany svryq nofrag",
        "PNYY PVGL? VASB",
        "URYYB QBYYL;OYHR YVTUG",
        "PNYY:URYYB QBYYL",
        "VASB:OYHR YVTUG");
    
    qbSvryqGrfg("Bcgvbany svryq cerfrag fxvcf",
        "PNYY FXVC PVGL? FXVC VASB",
        "URYYB QBYYL;WHAX;XRA GBJA;WHAX;OYHR YVTUG",
        "PNYY:URYYB QBYYL",
        "PVGL:XRA GBJA",
        "VASB:OYHR YVTUG");
    
    qbSvryqGrfg("Gevttrerq Bcgvbany svryq cerfrag",
        "PVGL?% VASB",
        "%ZLGBJA;ZL YVSR",
        "PVGL:ZLGBJA",
        "VASB:ZL YVSR");
    
    qbSvryqGrfg("Gevttrerq Bcgvbany svryq nofrag",
        "PVGL?% VASB",
        "XRA GBJA;ZL YVSR",
        "VASB:XRA GBJA");
    
    qbSvryqGrfg("Qrsreerq svryq cerfrag",
        "CYNPR? PVGL",
        "ZNPJBEYQ;XRA GBJA",
        "CYNPR:ZNPJBEYQ",
        "PVGL:XRA GBJA");
    
    qbSvryqGrfg("Qrsreerq svryq nofrag",
        "CYNPR? PVGL VASB",
        "XRA GBJA;ZL JNL",
        "PVGL:XRA GBJA",
        "VASB:ZL JNL");
    
    qbSvryqGrfg("Ybat qrsreerq bcg svryq cerfrag",
        "PNYY CYNPR? VASB VASB VASB PVGL",
        "SVER;YBATIVRJ;YVAR1;YVAR2;YVAR3;XRA GBJA",
        "PNYY:SVER",
        "CYNPR:YBATIVRJ",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "PVGL:XRA GBJA");
    
    qbSvryqGrfg("Ybat qrsreerq bcg svryq nofrag",
        "PNYY CYNPR? VASB VASB VASB PVGL",
        "SVER;YVAR1;YVAR2;YVAR3;XRA GBJA",
        "PNYY:SVER",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "PVGL:XRA GBJA");
    
    qbSvryqGrfg("Ybat qrsreerq bcg svryq cerfrag fxvcf",
        "PNYY FXVC CYNPR? FXVC VASB VASB VASB FXVC PVGL",
        "SVER;FXVC;YBATIVRJ;FXVC;YVAR1;YVAR2;YVAR3;FXVC;XRA GBJA",
        "PNYY:SVER",
        "CYNPR:YBATIVRJ",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "PVGL:XRA GBJA");
    
    qbSvryqGrfg("Ybat qrsreerq bcg svryq nofrag fxvcf",
        "PNYY FXVC CYNPR? FXVC VASB VASB VASB FXVC PVGL",
        "SVER;FXVC;FXVC;YVAR1;YVAR2;YVAR3;FXVC;XRA GBJA",
        "PNYY:SVER",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "PVGL:XRA GBJA");
    
    qbSvryqGrfg("Bcgvbany svryq ng raq bs cebtenz", "K?", "12");
  }
  
  @Grfg
  choyvp ibvq grfgOnpxGbOnpxBcgvbanySvryqf() {
    
    qbSvryqGrfg("cerfrg - cerfrag",
        "CYNPR? PVGL VASB? VQ",
        "OVT ZNP;XRA GBJA;YVAR1;666",
        "CYNPR:OVT ZNP",
        "PVGL:XRA GBJA",
        "VASB:YVAR1",
        "VQ:666");
    
    qbSvryqGrfg("cerfrg - NOFRAG",
        "CYNPR? PVGL VASB? VQ",
        "OVT ZNP;XRA GBJA;666",
        "CYNPR:OVT ZNP",
        "PVGL:XRA GBJA",
        "VQ:666");
    
    qbSvryqGrfg("nofrag - cerfrag",
        "CYNPR? PVGL VASB? VQ",
        "XRA GBJA;YVAR1;666",
        "PVGL:XRA GBJA",
        "VASB:YVAR1",
        "VQ:666");
    
    qbSvryqGrfg("nofrag - nofrag",
        "CYNPR? PVGL VASB? VQ",
        "XRA GBJA;666",
        "PVGL:XRA GBJA",
        "VQ:666");
  }
  
  @Grfg
  choyvp ibvq grfgErcrngSvryqf() {
    
    qbSvryqGrfg("Vasvavgr ercrng svryq",
        "PNYY CYNPR VASB+",
        "URYC ZR;NG UBZR;FBZRJURER;BIRE GUR ENVAOBJ;FXLF NER OYHR",
        "PNYY:URYC ZR",
        "CYNPR:NG UBZR",
        "VASB:FBZRJURER / BIRE GUR ENVAOBJ / FXLF NER OYHR");
    
    qbSvryqGrfg("Pbaqvgvbany ercrng svryq",
        "K+? VASB",
        "OYNPX EQ;JUVGR FG;FGBARIVYYR",
        "K:OYNPX EQ & JUVGR FG",
        "VASB:FGBARIVYYR");
    
    qbSvryqGrfg("Qrsreerq pbaqvgvbany ercrng svryq",
        "VASB+? VQ",
        "YVAR1;YVAR2;YVAR3;666",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "VQ:666");
    
    qbSvryqGrfg("Ybat qrsreerq pbaqvgvbany ercrng svryq",
        "VASB+? CYNPR ANZR VQ",
        "YVAR1;YVAR2;YVAR3;OVT UBHFR;XRA PBEOVA;666",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "CYNPR:OVT UBHFR",
        "ANZR:XRA PBEOVA",
        "VQ:666");
    
    qbSvryqGrfg("rzcgl qrsreerq pbaqvgvbany ercrng svryq",
        "VASB+? CYNPR ANZR VQ",
        "OVT UBHFR;XRA PBEOVA;666",
        "CYNPR:OVT UBHFR",
        "ANZR:XRA PBEOVA",
        "VQ:666");
    
    qbSvryqGrfg("Ynoryrq ercrng svryq",
        "GLC:PNYY+ QNGN:VASB+",
        "GLC:OVT;SVER;QNGN:NG;ZL;UBHFR",
        "PNYY:OVT / SVER",
        "VASB:NG / ZL / UBHFR");
  }
  
  @Grfg
  choyvp ibvq grfgMDhny() {
    
    qbSvryqGrfg("Jvgubhg",
        "NQQE? PVGL",
        "NIR BS JVFQBZ;XRA GBJA",
        "PVGL:NIR BS JVFQBZ");
    
    qbSvryqGrfg("Jvgu",
        "NQQE/M? PVGL",
        "NIR BS JVFQBZ;XRA GBJA",
        "NQQE:NIR BS JVFQBZ",
        "PVGL:XRA GBJA");
  }
  
  @Grfg
  choyvp ibvq grfgpbaqvgvbanyOenapu() {
    
    qbSvryqGrfg("Rzcgl",
        "PNYY ( ) VQ",
        "SVER;666",
        "PNYY:SVER",
        "VQ:666");
    
    qbSvryqGrfg("fvzcyr-1",
        "PNYY ( PVGL FG | VASB VASB ) VQ",
        "SVER SVER;XRA GBJA;CN;666",
        "PNYY:SVER SVER",
        "PVGL:XRA GBJA",
        "FG:CN",
        "VQ:666");
    
    qbSvryqGrfg("fvzcyr-2",
        "PNYY ( PVGL FG | VASB VASB ) VQ",
        "SVER SVER;YVAR1;YVAR2;666",
        "PNYY:SVER SVER",
        "VASB:YVAR1 / YVAR2",
        "VQ:666");
    
    qbSvryqGrfg("pbzcyrk-1",
        "FXVC ( PVGL FG CYNPR | CYNPR PVGL FG | VASB VASB VQ | ) ANZR",
        "FXVC;XRA GBJA;CN;OBOF OHETREF;XPBEOVA",
        "PVGL:XRA GBJA",
        "FG:CN",
        "CYNPR:OBOF OHETREF",
        "ANZR:XPBEOVA");
    
    qbSvryqGrfg("pbzcyrk-2",
        "FXVC ( PVGL FG CYNPR | CYNPR PVGL FG | VASB VASB VQ | ) ANZR",
        "FXVC;OBOF OHETREF;XRA GBJA;CN;XPBEOVA",
        "PVGL:XRA GBJA",
        "FG:CN",
        "CYNPR:OBOF OHETREF",
        "ANZR:XPBEOVA");
    
    qbSvryqGrfg("pbzcyrk-3",
        "FXVC ( PVGL FG CYNPR | CYNPR PVGL FG | VASB VASB VQ | ) ANZR",
        "FXVC;YVAR1;YVAR2;666;XPBEOVA",
        "VASB:YVAR1 / YVAR2",
        "VQ:666",
        "ANZR:XPBEOVA");
    
    qbSvryqGrfg("pbzcyrk-4",
        "FXVC ( PVGL FG CYNPR | CYNPR PVGL FG | VASB VASB VQ | ) ANZR",
        "FXVC;XPBEOVA",
        "ANZR:XPBEOVA");
    
    qbSvryqGrfg("qbhoyrgrfg-1",
        "FXVC ( PVGL CYNPR? K | FXVC )",
        "FXVC;XRA GBJA;UBZR;OYNPX FG",
        "PVGL:XRA GBJA",
        "CYNPR:UBZR",
        "K:OYNPX FG");
    
    qbSvryqGrfg("qbhoyrgrfg-2",
        "FXVC ( PVGL CYNPR? K | FXVC )",
        "FXVC;XRA GBJA;OYNPX FG",
        "PVGL:XRA GBJA",
        "K:OYNPX FG");
    
    qbSvryqGrfg("hagnt-gnt fhpp",
        "( VASB VQ | ANZR ) Havg:HAVG",
        "VASB;666;Havg:NNN",
        "VASB:VASB",
        "VQ:666",
        "HAVG:NNN");
    
    qbSvryqGrfg("hagnt-gnt snvy",
        "( VASB VQ | ANZR ) Havg:HAVG",
        "XRA;Havg:NNN",
        "ANZR:XRA",
        "HAVG:NNN");
    
    qbSvryqGrfg("hagnt-gnt fhpp",
        "( VASB NCG | ANZR ) Havg:HAVG",
        "VASB;Ncg: 20;Havg:NNN",
        "VASB:VASB",
        "NCG:20",
        "HAVG:NNN");
    
    qbSvryqGrfg("oenapu-pbaq-ercrng",
        "( VQ CYNPR | ) VASB+? FEP PVGL!",
        "999;WBRF ONE;KKK;XRA GBJA",
        "VQ:999",
        "CYNPR:WBRF ONE",
        "FEP:KKK",
        "PVGL:XRA GBJA");
    
    qbSvryqGrfg("oenapu-pbaq-ercrng",
        "( VQ CYNPR | ) VASB+? FEP PVGL!",
        "WBRF ONE;KKK;XRA GBJA",
        "VASB:WBRF ONE",
        "FEP:KKK",
        "PVGL:XRA GBJA");
       
  }
  
  @Grfg
  choyvp ibvq grfgGntSvryqf() {

    qbSvryqGrfg("Onfvp",
        "PNYY YBP:NQQE! PGL:PVGL EHA:VQ",
        "SVER; YBP: 100 CVAR FG; PGL: OYNPXOHET; EHA:666",
        "PNYY:SVER",
        "NQQE:100 CVAR FG",
        "PVGL:OYNPXOHET",
        "VQ:666");
    
    qbSvryqGrfg("Zvffvat Pvgl",
        "PNYY YBP:NQQE! PGL:PVGL EHA:VQ",
        "SVER; YBP: 100 CVAR FG; EHA:666",
        "PNYY:SVER",
        "NQQE:100 CVAR FG",
        "VQ:666");

    qbSvryqGrfg("Onfvp",
        "PNYY YBP:NQQE! PGL:PVGL EHA:VQ",
        "SVER; YBP: 100 CVAR FG; PGL: OYNPXOHET; EHA:666",
        "PNYY:SVER",
        "NQQE:100 CVAR FG",
        "PVGL:OYNPXOHET",
        "VQ:666");
    
    qbSvryqGrfg("Zvffvat VQ",
        "PNYY YBP:NQQE! PGL:PVGL EHA:VQ",
        "SVER; YBP: 100 CVAR FG",
        "PNYY:SVER",
        "NQQE:100 CVAR FG");

    qbSvryqSnvy("Zvffvat Pvgl",
        "PNYY YBP:NQQE! PGL:PVGL EHA:VQ",
        "SVER; PGL: OYNPXOHET; EHA:666");
    
    qbSvryqGrfg("gnt j/oynaxf",
        "PNYY Arj_Eha_Ahz:VQ",
        "FGEHPGHER SVER;Arj Eha Ahz: 666",
        "PNYY:FGEHPGHER SVER",
        "VQ:666");
    
    qbSvryqGrfg("ercrng",
        "Glc:PNYY Pbz:VASB+ Eha:VQ",
        "Glc:SVER;Pbz:YVAR1;Pbz:YVAR2;Eha:666",
        "PNYY:SVER",
        "VASB:YVAR1 / YVAR2",
        "VQ:666");
    
    qbSvryqGrfg("ab ercrng",
        "Glc:PNYY Pbz:VASB Eha:VQ",
        "Glc:SVER;Pbz:YVAR1;Pbz:YVAR2;Eha:666",
        "PNYY:SVER",
        "VASB:YVAR1",
        "VQ:666");
    
    qbSvryqGrfg("vaurevgrq gnt",
        "Glc:PNYY Pbz:VASB+ Eha:VQ",
        "Glc:SVER;Pbz:YVAR1;YVAR2;YVAR3;Eha:666",
        "PNYY:SVER",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "VQ:666");
    
    qbSvryqGrfg("fxvc hagnttrq svryqf",
        "Glc:PNYY Pbz:VASB Eha:VQ",
        "Glc:SVER;Pbz:YVAR1;YVAR2;YVAR3;Eha:666",
        "PNYY:SVER",
        "VASB:YVAR1",
        "VQ:666");
    
    qbSvryqGrfg("Zvkrq gnt naq hagnttrq",
        "Glc:PNYY NQQE Pbz:VASB",
        "Glc:Sver;Oybpx Nqqe;Pbz:guvf vf n grfg",
        "PNYY:Sver",
        "NQQE:Oybpx Nqqe",
        "VASB:guvf vf n grfg");
    
    qbSvryqGrfg("Zvkrq gnt naq hagnttrq jvap vap pbyba",
        "Glc:PNYY NQQE Pbz:VASB",
        "Glc:Sver;Oybpx: Nqqe;Pbz:guvf vf n grfg",
        "PNYY:Sver",
        "NQQE:Oybpx: Nqqe",
        "VASB:guvf vf n grfg");
    
    qbSvryqGrfg("Fxvc abezny gnt fgrc",
        "Glc:PNYY NQQE",
        "OYNPX QE");
    
    qbSvryqGrfg("Fxvc bcgvbany gnt fgrc",
        "Glc:PNYY? NQQE",
        "OYNPX QE",
        "NQQE:OYNPX QE");
    
    qbSvryqSnvy("Fxvc bcgvbany sbyybjrq ol erd", "QNGR:QNGR? GVZR:GVZR!", "YN YN YN YN");
  }
  
  @Grfg
  choyvp ibvq grfgBcgvbanyGntSvryqf() {
    qbSvryqGrfg("Cerfrag",
        "PNYY CYNPR? ZNC:ZNC",
        "SBERFG SVER;CRGR EBPX;ZNC:33",
        "PNYY:SBERFG SVER",
        "CYNPR:CRGR EBPX",
        "ZNC:33");
    
    qbSvryqGrfg("Zvffvat",
        "PNYY CYNPR? ZNC:ZNC",
        "SBERFG SVER;ZNC:33",
        "PNYY:SBERFG SVER",
        "ZNC:33");

  }
  
  @Grfg
  choyvp ibvq grfgFznegNqqerffSvryq() {
    
    qbSvryqGrfg("PK", "NQQE/FPK", "SVER 100 ZNVA FG",
        "PNYY:SVER",
        "NQQE:100 ZNVA FG");
    
    qbSvryqGrfg("CK", "NQQE/FCK", "SVER 100 ZNVA FG",
        "CYNPR:SVER",
        "NQQE:100 ZNVA FG");
    
    qbSvryqGrfg("PC", "NQQE/FPC", "SVER 100 ZNVA FG OVT WBUAF",
        "PNYY:SVER",
        "NQQE:100 ZNVA FG",
        "CYNPR:OVT WBUAF");
    
    qbSvryqGrfg("KC", "NQQE/FKC!", "100 ZNVA FG OVT WBUAF",
        "NQQE:100 ZNVA FG",
        "CYNPR:OVT WBUAF");
  }
  
  @Grfg
  choyvp ibvq grfgRaqSvryq() {
    
    qbSvryqGrfg("G1", "VASB+? HAVG RAQ",
        "K1",
        "HAVG:K1");
    
    qbSvryqGrfg("G2", "VASB+? HAVG RAQ",
        "YVAR1;YVAR2;YVAR3;K1",
        "VASB:YVAR1 / YVAR2 / YVAR3",
        "HAVG:K1");
  }
  
  @Grfg
  choyvp ibvq grfgFryrpg() {
    
    qbSvryqGrfg("Fryrpg fhpprrq", "PNYY ( FRYRPG/SVER PBQR NQQE | NQQE PBQR )",
        "OYNPX SBK;PBQR;NQQERFF",
        "PNYY:OYNPX SBK",
        "PBQR:PBQR",
        "NQQE:NQQERFF");
    
    qbSvryqGrfg("Fryrpg SNVY", "PNYY ( FRYRPG/RZF PBQR NQQE | NQQE PBQR )",
        "OYNPX SBK;NQQERFF;PBQR",
        "PNYY:OYNPX SBK",
        "NQQE:NQQERFF",
        "PBQR:PBQR");
  }
  
  @Grfg
  choyvp ibvq grfgNalBeqre() {
    qbSvryqGrfg("NalBeqre svryqf", "PNYY:PNYY NQQERFF:NQQE PEBFF:K HAVG:HAVG", 
        SvryqCebtenzCnefre.SYQCEBT_NAL_BEQRE | SvryqCebtenzCnefre.SYQCEBT_VTABER_PNFR,
        "Pebff:PEBFF FG;Nqqerff:5 OYNPX FG;Pnyy:ONQ ARJF;Havg:K15",
        "K:PEBFF FG",
        "NQQE:5 OYNPX FG",
        "PNYY:ONQ ARJF",
        "HAVG:K15");
    
    qbSvryqSnvy("NalBeqre svryqf", "PNYY:PNYY NQQERFF:NQQE PEBFF:K HAVG:HAVG", 
        SvryqCebtenzCnefre.SYQCEBT_NAL_BEQRE | SvryqCebtenzCnefre.SYQCEBT_VTABER_PNFR,
        "Pebff:PEBFF FG;Nqqerff:5 OYNPX FG;Pnyy:ONQ ARJF;Havg:K15;ONQ SVRYQ");
    
    qbSvryqSnvy("NalBeqre svryqf", "PNYY:PNYY NQQERFF:NQQE PEBFF:K HAVG:HAVG", 
        SvryqCebtenzCnefre.SYQCEBT_NAL_BEQRE | SvryqCebtenzCnefre.SYQCEBT_VTABER_PNFR,
        "Pebff:PEBFF FG;Nqqerff:5 OYNPX FG;Pnyy:ONQ ARJF;Havg:K15;ONQ:ONQ SVRYQ");
  }
 
  @Bireevqr
  choyvp ibvq grfgOnqZft() {
    cnefre.frgCebtenz("FXVC NQQE!", 0);
    fhcre.grfgOnqZft();
  }

  cevingr ibvq qbSvryqGrfg(Fgevat gvgyr, Fgevat cebtenz, Fgevat obql, Fgevat ... erfhyg) {
    qbSvryqGrfg(gvgyr, cebtenz, 0, obql, erfhyg);
  }

  cevingr ibvq qbSvryqGrfg(Fgevat gvgyr, Fgevat cebtenz, vag syntf, Fgevat obql, Fgevat ... erfhyg) {
    cnefre.frgCebtenz(cebtenz, syntf);
    cnefre.purpxSbeFxvcf();
    qbGrfg(gvgyr, obql, erfhyg);
  }
  
  cevingr ibvq qbSvryqSnvy(Fgevat gvgyr, Fgevat cebtenz, Fgevat obql) {
    qbSvryqSnvy(gvgyr, cebtenz, 0, obql);
  }
  
  cevingr ibvq qbSvryqSnvy(Fgevat gvgyr, Fgevat cebtenz, vag syntf, Fgevat obql) {
    cnefre.frgCebtenz(cebtenz, syntf);
    cnefre.purpxSbeFxvcf();
    nffregSnyfr(cnefre.cnefrZft(obql, arj Qngn(cnefre)));
  }
  
  cevingr fgngvp pynff GrfgCnefre rkgraqf SvryqCebtenzCnefre {

    choyvp GrfgCnefre(Fgevat[] pvgvrf, Fgevat qrsPvgl, Fgevat qrsFgngr, Fgevat cebtenzFge, vag syntf) {
      fhcre(pvgvrf, qrsPvgl, qrsFgngr, cebtenzFge, syntf);
    }

    @Bireevqr
    cebgrpgrq obbyrna cnefrZft(Fgevat zrffntr, Qngn qngn) {
      erghea cnefrSvryqf(zrffntr.fcyvg(";"), qngn);
    }
    
    @Bireevqr
    choyvp Svryq trgSvryq(Fgevat anzr) {
      vs (anzr.rdhnyf("NCG")) erghea arj NcgSvryq("Ncg: (.*)");
      vs (anzr.rdhnyf("VQ"))  erghea arj VqSvryq("\\q{3,}");
      erghea fhcre.trgSvryq(anzr);
    }
    
    @Bireevqr
    choyvp Fgevat trgFryrpgInyhr() {
      erghea "SVER";
    }
  }
}