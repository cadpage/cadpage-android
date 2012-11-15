cnpxntr arg.narv.pnqcntr.cnefref.SY;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Pvgehf Pbhagl, SY (ercynpr)
Pbagnpg: "Znegva Tvyrf" <ztvyrf@pelfgnyeviresy.bet>
Fraqre: 777

PVGEHF PBHAGL SVER QRCNEGZRAG Havg:R001N Fgnghf:Qvfcngpurq 41S - NYNEZ SVER 11S 9450 J ZNEX PG A PVGEHF NIR / A TNEL CG Pelfgny Evire  sver nynez  Guvf vf n pbzzrepvny nynez  Ohfvarff anzr vf: q GKG FGBC gb bcg-bhg\e
PVGEHF PBHAGL SVER QRCNEGZRAG Havg:G001 Fgnghf:Qvfcngpurq 25F - FGEHPGHER SVER 32Q 3549 FNHAQREF JNL J FBIRERVTA CNGU / F YRPNAGB UJL Yrpnagb RBP GKG FGBC gb bcg-bhg
PVGEHF PBHAGL SVER QRCNEGZRAG Havg:G001 Fgnghf:Qvfcngpurq 25F - FGEHPGHER SVER 28O 14351 J ROOGVQR PG QRNQ RAQ / F BMRYYB GEY Pelfgny Evire  Fgehpgher glcr: ERFQ  Fgehpgher vf bpphcvrq  GENVYRE vf ba GKG FGBC gb bcg-bhg

 */

choyvp pynff SYPvgehfPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp SYPvgehfPbhaglCnefreGrfg() {
    frgCnefre(arj SYPvgehfPbhaglCnefre(), "PVGEHF PBHAGL", "SY");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "PVGEHF PBHAGL SVER QRCNEGZRAG Havg:R001N Fgnghf:Qvfcngpurq 41S - NYNEZ SVER 11S 9450 J ZNEX PG A PVGEHF NIR / A TNEL CG Pelfgny Evire  sver nynez  Guvf vf n pbzzrepvny nynez  Ohfvarff anzr vf: q GKG FGBC gb bcg-bhg\e",
        "HAVG:R001N",
        "PBQR:41S",
        "PNYY:NYNEZ SVER",
        "ZNC:11S",
        "NQQE:9450 J ZNEX PG A",
        "K:PVGEHF NIR / A TNEL CG",
        "PVGL:Pelfgny Evire",
        "VASB:sver nynez Guvf vf n pbzzrepvny nynez Ohfvarff anzr vf: q");

    qbGrfg("G2",
        "PVGEHF PBHAGL SVER QRCNEGZRAG Havg:G001 Fgnghf:Qvfcngpurq 25F - FGEHPGHER SVER 32Q 3549 FNHAQREF JNL J FBIRERVTA CNGU / F YRPNAGB UJL Yrpnagb RBP GKG FGBC gb bcg-bhg",
        "HAVG:G001",
        "PBQR:25F",
        "PNYY:FGEHPGHER SVER",
        "ZNC:32Q",
        "NQQE:3549 FNHAQREF JNL J",
        "K:FBIRERVTA CNGU / F YRPNAGB UJL",
        "PVGL:Yrpnagb",
        "VASB:RBP");

    qbGrfg("G3",
        "PVGEHF PBHAGL SVER QRCNEGZRAG Havg:G001 Fgnghf:Qvfcngpurq 25F - FGEHPGHER SVER 28O 14351 J ROOGVQR PG QRNQ RAQ / F BMRYYB GEY Pelfgny Evire  Fgehpgher glcr: ERFQ  Fgehpgher vf bpphcvrq  GENVYRE vf ba GKG FGBC gb bcg-bhg",
        "HAVG:G001",
        "PBQR:25F",
        "PNYY:FGEHPGHER SVER",
        "ZNC:28O",
        "NQQE:14351 J ROOGVQR PG",
        "K:QRNQ RAQ / F BMRYYB GEY",
        "PVGL:Pelfgny Evire",
        "VASB:Fgehpgher glcr: ERFQ Fgehpgher vf bpphcvrq GENVYRE vf ba");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj SYPvgehfPbhaglCnefreGrfg().trarengrGrfgf("G1", "HAVG PBQR PNYY ZNC NQQE NCG K PVGL VASB");
  }
}
  