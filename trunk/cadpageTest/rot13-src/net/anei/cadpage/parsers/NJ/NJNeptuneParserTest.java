cnpxntr arg.narv.pnqcntr.cnefref.AW;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Arcghar, AW
Pbagnpg: Ebff Yrvobjvgm <ebffy32100@tznvy.pbz>
Fraqre: vne@arcghargbjafuvc.bet

Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aunzvygba sver/fe sver naq unzvygba svefg nvq 716 furyy cynpr pneoba zbabkvqr nynez
Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aunzvygba svefg nvq 716 furyy cy pneoba zbabkvqr nynez jvgu flzcgbzf﻿
Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aUSN-PNAPRY PNYY 716 FURYY CY ERSHFNY NF CRE CNGEBY﻿
Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\anyy arcghar rzf nyy pnyy bprna tebir 98.5 ynjerapr nir srznyr srryvat jrnx naq qvmml
Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aRZF NYY PNYY 98.5 YNJERAPR NI SBE NYREGREQ ZRAGNY FGNGHF

 */

choyvp pynff AWArcgharCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp AWArcgharCnefreGrfg() {
    frgCnefre(arj AWArcgharCnefre(), "ARCGHAR", "AW");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aunzvygba sver/fe sver naq unzvygba svefg nvq 716 furyy cynpr pneoba zbabkvqr nynez",
        "PNYY:unzvygba sver/fe sver naq unzvygba svefg nvq",
        "NQQE:716 furyy cynpr",
        "VASB:pneoba zbabkvqr nynez");

    qbGrfg("G2",
        "Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aunzvygba svefg nvq 716 furyy cy pneoba zbabkvqr nynez jvgu flzcgbzf﻿",
        "PNYY:unzvygba svefg nvq",
        "NQQE:716 furyy cy",
        "VASB:pneoba zbabkvqr nynez jvgu flzcgbzf﻿");

    qbGrfg("G3",
        "Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aUSN-PNAPRY PNYY 716 FURYY CY ERSHFNY NF CRE CNGEBY﻿",
        "PNYY:USN-PNAPRY PNYY",
        "NQQE:716 FURYY CY",
        "VASB:ERSHFNY NF CRE CNGEBY﻿");

    qbGrfg("G4",
        "Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\anyy arcghar rzf nyy pnyy bprna tebir 98.5 ynjerapr nir srznyr srryvat jrnx naq qvmml",
        "PNYY:nyy arcghar rzf nyy pnyy bprna tebir",
        "NQQE:98.5 ynjerapr nir",
        "VASB:srznyr srryvat jrnx naq qvmml");

    qbGrfg("G5",
        "Fhowrpg:ARCGHAR CQ PBZZF PRAGRE\aRZF NYY PNYY 98.5 YNJERAPR NI SBE NYREGREQ ZRAGNY FGNGHF",
        "PNYY:RZF NYY PNYY",
        "NQQE:98.5 YNJERAPR NI",
        "ZNQQE:98.5 YNJERAPR NIR",
        "VASB:SBE NYREGREQ ZRAGNY FGNGHF");
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj AWArcgharCnefreGrfg().trarengrGrfgf("G1");
  }
}