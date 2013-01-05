cnpxntr arg.narv.pnqcntr.cnefref.TN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.TN.TNBpbarrPbhaglCnefre;

vzcbeg bet.whavg.Grfg;

/* Fnzcyr Bpbarr Cntr
 * 
 * BPFB R911:Erghea Cubar: 7060000000 F28 FVPX CREFBA 4047 PBYUNZ SREEL EQ 8583046 
 * BPFB R911:Erghea Cubar: 7060000000 F28 FVPX CREFBA 385 WRSSREFBA NIR 2029728 
 * BPFB R911:1090S SVER NYNEZ 1021 JBBQ UBYYBJ YA 5482767 PELFGNY UVYYF QE
 * BPFB R911:1073 FZBXR 1421 ORIREYL QE 5495253 ABAN QEVIR
 * BPFB R911:1070 SVER 1280 NFUYNAQ QE 7250300 UJL 53
 
 */

choyvp pynff TNBpbarrPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp TNBpbarrPbhaglCnefreGrfg() {
    frgCnefre(arj TNBpbarrPbhaglCnefre(), "BPBARR PBHAGL", "TN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {
    qbGrfg("G1",
        "BPFB R911:Erghea Cubar: 7060000000 F28 FVPX CREFBA 4047 PBYUNZ SREEL EQ 8583046",
        "CUBAR:7060000000",
        "PNYY:F28 FVPX CREFBA",
        "NQQE:4047 PBYUNZ SREEL EQ");

    qbGrfg("G2",
        "BPFB R911:Erghea Cubar: 7060000000 F28 FVPX CREFBA 385 WRSSREFBA NIR 2029728",
        "CUBAR:7060000000",
        "PNYY:F28 FVPX CREFBA",
        "NQQE:385 WRSSREFBA NIR");
    
    qbGrfg("G3",
        "BPFB R911:1090S SVER NYNEZ 1021 JBBQ UBYYBJ YA 5482767 PELFGNY UVYYF QE",
        "PNYY:1090S SVER NYNEZ",
        "NQQE:1021 JBBQ UBYYBJ YA",
        "K:PELFGNY UVYYF QE");
    
    qbGrfg("G4",
        "BPFB R911:1073 FZBXR 1421 ORIREYL QE 5495253 ABAN QEVIR",
        "PNYY:1073 FZBXR",
        "NQQE:1421 ORIREYL QE",
        "K:ABAN QEVIR");

    qbGrfg("G5",
        "BPFB R911:1070 SVER 1280 NFUYNAQ QE 7250300 UJL 53",
        "PNYY:1070 SVER",
        "NQQE:1280 NFUYNAQ QE",
        "K:UJL 53");
  }
}
