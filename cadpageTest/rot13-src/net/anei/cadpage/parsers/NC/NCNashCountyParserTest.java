cnpxntr arg.narv.pnqcntr.cnefref.AP;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/* 
Anfu Pbhagl, AP
Pbagnpg: ohpx.c <ohpx.c@fhqqrayvax.arg>
Fraqre: ANFU911@ANFUPBHAGLAP.TBI
F: Z:ANFU911:4956 QBEBGUL YA EBPXL ZBHAG PURFG-U ORNZNA, EBOREG 4SE1 

Pbagnpg: Eboreg Nzrefba <ernzrefba614@tznvy.pbz>
Fraqre: ANFU911@anfupbhaglap.tbi
ANFU911:704 F ONFF QE ANFUIVYYR FGEHPGHER HF PRYYHYNE 14SQ1

Pbagnpg: Npgvir911
Ntrapl anzr: Jrfg Zbhag ISQ
Ybpngvba: Ebpxl Zbhag, AP, Havgrq Fgngrf
Fraqre: 2529044041@imjcvk.pbz

ANFU911:4956 QBEBGUL YA EBPXL ZBHAG PURFG-U ORNZNA, EBOREG 4SE1
ANFU911:4479 YNATJBBQ JNL EBPXL ZBHAG CFLP/FHV-U XNEYL-OBVFR JVYYVF 4SE1

*/

choyvp pynff APAnfuPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp APAnfuPbhaglCnefreGrfg() {
    frgCnefre(arj APAnfuPbhaglCnefre(), "ANFU PBHAGL", "AP");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "F: Z:ANFU911:4956 QBEBGUL YA EBPXL ZBHAG PURFG-U ORNZNA, EBOREG 4SE1 ",
        "NQQE:4956 QBEBGUL YA",
        "PVGL:EBPXL ZBHAG",
        "PNYY:PURFG-U",
        "ANZR:ORNZNA, EBOREG",
        "HAVG:4SE1");

  }
  
  @Grfg
  choyvp ibvq grfgEboregNzrefba() {

    qbGrfg("G1",
        "ANFU911:704 F ONFF QE ANFUIVYYR FGEHPGHER HF PRYYHYNE 14SQ1",
        "NQQE:704 F ONFF QE",
        "PVGL:ANFUIVYYR",
        "PNYY:FGEHPGHER",
        "HAVG:14SQ1");
   
  }
  
  @Grfg
  choyvp ibvq grfgEbpxZbhag() {

    qbGrfg("G1",
        "ANFU911:4956 QBEBGUL YA EBPXL ZBHAG PURFG-U ORNZNA, EBOREG 4SE1",
        "NQQE:4956 QBEBGUL YA",
        "PVGL:EBPXL ZBHAG",
        "PNYY:PURFG-U",
        "ANZR:ORNZNA, EBOREG",
        "HAVG:4SE1");

    qbGrfg("G2",
        "ANFU911:4479 YNATJBBQ JNL EBPXL ZBHAG CFLP/FHV-U XNEYL-OBVFR JVYYVF 4SE1",
        "NQQE:4479 YNATJBBQ JNL",
        "PVGL:EBPXL ZBHAG",
        "PNYY:CFLP/FHV-U",
        "ANZR:XNEYL-OBVFR JVYYVF",
        "HAVG:4SE1");

  }
  

  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj APAnfuPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}
