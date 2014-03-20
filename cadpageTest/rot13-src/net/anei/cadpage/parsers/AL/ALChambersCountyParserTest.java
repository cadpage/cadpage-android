cnpxntr arg.narv.pnqcntr.cnefref.NY;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.NY.NYPunzorefPbhaglCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Punzoref Pbhagl, NY

Pbagnpg: Npgvir911
Ntrapl anzr: Rnfg Nynonzn Sver Qvfgevpg
Ybpngvba: Inyyrl, NY, Havgrq Fgngrf
Fraqre: qvfcngpu@911rznvy.bet

(R911) GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.\aPP 911 PRAGRE
(R911 Qbphzrag: 91031683729) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a91031683729\a\aCyrnfr frr nggnpurq qbphzrag.
(R911) 10-70 SVER NYNEZ\a5702 19GU NI
(R911) 10-70 SVER PBAGEBY OHEA, CREZVG
(R911) SVER\a6308 26GU NI, INYYRL\aFZBXR QRGRPGBE
(R911) SVER\a866 EVIRE EQ, INYYRL\aABEZNA CNFPUNY OHFVARFF
(R911) I GENSSVP NPPVQRAG
(R911) SVER
(R911) GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.
(R911 Qbphzrag: 91031683086) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a91031683086\a\aCyrnfr frr nggnpurq qbphzrag.
(R911) I GENSSVP NPPVQRAG\a20GU NIR @ ZPQBANYQF, INYYRL\a4 IRU
(R911) I GENSSVP NPPVQRAG\a1801 F 1FG NIR - FRP FR, YNARGG\a4 IRU
(R911 Qbphzrag: 91031683051) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a91031683051\a\aCyrnfr frr nggnpurq qbphzrag.
(R911) 10-70 SVER FGEHPGHER\aERFREIBVE FG @ FPUBBY FG
(R911 Qbphzrag: 91031682869) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a91031682869\a\aCyrnfr frr nggnpurq qbphzrag.
(R911) 10-70 SVER FGEHPGHER\a2100 PBYHZOHF EQ, INYYRL\aFURQ
(R911) 10-70 SVER JVYQYNAQF\a3378 PBHAGL EQ 388, INYYRL
(R911) GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.
(R911) 10-52 ZRQVPNY RZRETRAPL\a106 PBZOF FG, INYYRL
(R911) I GENSSVP NPPVQRAG\aUJL 29 FO ORSBER GEVNATYR
(R911 Qbphzrag: 91031682261) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a91031682261\a\aCyrnfr frr nggnpurq qbphzrag.
(R911) 10-70 SVER JVYQYNAQF\aJNGRESBEQ FHOQVIVFVBA, INYYRL
(R911) 10-70 SVER IRUVPYR\a1500 EVIRE EQ, INYYRL
(R911) 10-70 SVER JVYQYNAQF
(R911) I GENSSVP NPPVQRAG\a\aAB VAWHEVRF
(R911) JRYSNER PURPX\a3507 IRGRENAF ZRZBEVNY CXJL, YNARGG\aGRFGVAT FZF GKG ZFT NAQ NPGVIR 911 RZNVY

*/

choyvp pynff NYPunzorefPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp NYPunzorefPbhaglCnefreGrfg() {
    frgCnefre(arj NYPunzorefPbhaglCnefre(), "PUNZOREF PBHAGL", "NY");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {
    qbGrfg("G1",
        "(R911) GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.\aPP 911 PRAGRE",
        "PNYY:GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.",
        "ANZR:PP",
        "NQQE:911 PRAGRE");

    qbGrfg("G2",
        "(R911 Qbphzrag: 91031683729) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a" +
        "91031683729\a\a" +
        "Cyrnfr frr nggnpurq qbphzrag.",

        "PNYY:Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf:",
        "NQQE:91031683729", //vgf qbvat gur orfg vg pna
        "VASB:Cyrnfr frr nggnpurq qbphzrag.");

    qbGrfg("G3",
        "(R911) 10-70 SVER NYNEZ\a5702 19GU NI",
        "PNYY:10-70 SVER NYNEZ",
        "NQQE:5702 19GU NI",
        "ZNQQE:5702 19GU NIR");

    qbGrfg("G4",
        "(R911) 10-70 SVER PBAGEBY OHEA, CREZVG",
        "PNYY:10-70 SVER PBAGEBY OHEA, CREZVG");

    qbGrfg("G5",
        "(R911) SVER\a6308 26GU NI, INYYRL\aFZBXR QRGRPGBE",
        "PNYY:SVER",
        "NQQE:6308 26GU NI",
        "ZNQQE:6308 26GU NIR",
        "PVGL:INYYRL",
        "VASB:FZBXR QRGRPGBE");

    qbGrfg("G6",
        "(R911) SVER\a866 EVIRE EQ, INYYRL\aABEZNA CNFPUNY OHFVARFF",
        "PNYY:SVER",
        "NQQE:866 EVIRE EQ",
        "PVGL:INYYRL",
        "VASB:ABEZNA CNFPUNY OHFVARFF");

    qbGrfg("G7",
        "(R911) I GENSSVP NPPVQRAG",
        "PNYY:I GENSSVP NPPVQRAG");

    qbGrfg("G8",
        "(R911) SVER",
        "PNYY:SVER");

    qbGrfg("G9",
        "(R911) GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.",
        "PNYY:GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.");

    qbGrfg("G10",
        "(R911 Qbphzrag: 91031683086) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a" +
        "91031683086\a\a" +
        "Cyrnfr frr nggnpurq qbphzrag.",

        "PNYY:Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf:",
        "NQQE:91031683086",
        "VASB:Cyrnfr frr nggnpurq qbphzrag.");

    qbGrfg("G11",
        "(R911) I GENSSVP NPPVQRAG\a20GU NIR @ ZPQBANYQF, INYYRL\a4 IRU",
        "PNYY:I GENSSVP NPPVQRAG",
        "ANZR:20GU NIR @ ZPQBANYQF, INYYRL",
        "NQQE:4 IRU"); //abcr

    qbGrfg("G12",
        "(R911) I GENSSVP NPPVQRAG\a1801 F 1FG NIR - FRP FR, YNARGG\a4 IRU",
        "PNYY:I GENSSVP NPPVQRAG",
        "ANZR:1801 F 1FG NIR - FRP FR, YNARGG", //guvf jvyy npghnyyl znc, ohg vg vf va gur jebat svryq.
        "NQQE:4 IRU"); //abcr

    qbGrfg("G13",
        "(R911 Qbphzrag: 91031683051) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a" +
        "91031683051\a\a" +
        "Cyrnfr frr nggnpurq qbphzrag.",

        "PNYY:Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf:",
        "NQQE:91031683051",
        "VASB:Cyrnfr frr nggnpurq qbphzrag.");

    qbGrfg("G14",
        "(R911) 10-70 SVER FGEHPGHER\aERFREIBVE FG @ FPUBBY FG",
        "PNYY:10-70 SVER FGEHPGHER",
        "NQQE:ERFREIBVE FG & FPUBBY FG");

    qbGrfg("G15",
        "(R911 Qbphzrag: 91031682869) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a" +
        "91031682869\a\a" +
        "Cyrnfr frr nggnpurq qbphzrag.",

        "PNYY:Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf:",
        "NQQE:91031682869",
        "VASB:Cyrnfr frr nggnpurq qbphzrag.");

    qbGrfg("G16",
        "(R911) 10-70 SVER FGEHPGHER\a2100 PBYHZOHF EQ, INYYRL\aFURQ",
        "PNYY:10-70 SVER FGEHPGHER",
        "NQQE:2100 PBYHZOHF EQ",
        "PVGL:INYYRL",
        "VASB:FURQ");

    qbGrfg("G17",
        "(R911) 10-70 SVER JVYQYNAQF\a3378 PBHAGL EQ 388, INYYRL",
        "PNYY:10-70 SVER JVYQYNAQF",
        "NQQE:3378 PBHAGL EQ 388",
        "ZNQQE:3378 PBHAGL EBNQ 388",
        "PVGL:INYYRL");

    qbGrfg("G18",
        "(R911) GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.",
        "PNYY:GRFG CNTR - RIREL ZBEAVAT @ 8:00 N.Z.");

    qbGrfg("G19",
        "(R911) 10-52 ZRQVPNY RZRETRAPL\a106 PBZOF FG, INYYRL",
        "PNYY:10-52 ZRQVPNY RZRETRAPL",
        "NQQE:106 PBZOF FG",
        "PVGL:INYYRL");

    qbGrfg("G20",
        "(R911) I GENSSVP NPPVQRAG\aUJL 29 FO ORSBER GEVNATYR",
        "PNYY:I GENSSVP NPPVQRAG",
        "NQQE:UJL 29 FO ORSBER GEVNATYR",
        "ZNQQE:UJL 29 ORSBER GEVNATYR"); //abcr

    qbGrfg("G21",
        "(R911 Qbphzrag: 91031682261) Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf: \a\a" +
        "91031682261\a\a" +
        "Cyrnfr frr nggnpurq qbphzrag.",

        "PNYY:Gur nggnpurq qbphzrag pbagnvaf vasbezngvba sbe gur sbyybjvat vapvqragf:",
        "NQQE:91031682261",
        "VASB:Cyrnfr frr nggnpurq qbphzrag.");

    qbGrfg("G22",
        "(R911) 10-70 SVER JVYQYNAQF\aJNGRESBEQ FHOQVIVFVBA, INYYRL",
        "PNYY:10-70 SVER JVYQYNAQF",
        "NQQE:JNGRESBEQ FHOQVIVFVBA", //abcr
        "PVGL:INYYRL");

    qbGrfg("G23",
        "(R911) 10-70 SVER IRUVPYR\a1500 EVIRE EQ, INYYRL",
        "PNYY:10-70 SVER IRUVPYR",
        "NQQE:1500 EVIRE EQ",
        "PVGL:INYYRL");

    qbGrfg("G24",
        "(R911) 10-70 SVER JVYQYNAQF",
        "PNYY:10-70 SVER JVYQYNAQF");

    qbGrfg("G25",
        "(R911) I GENSSVP NPPVQRAG\a\aAB VAWHEVRF",
        "PNYY:I GENSSVP NPPVQRAG",
        "NQQE:AB VAWHEVRF");

    qbGrfg("G26",
        "(R911) JRYSNER PURPX\a3507 IRGRENAF ZRZBEVNY CXJL, YNARGG\aGRFGVAT FZF GKG ZFT NAQ NPGVIR 911 RZNVY",
        "PNYY:JRYSNER PURPX",
        "NQQE:3507 IRGRENAF ZRZBEVNY CXJL",
        "PVGL:YNARGG",
        "VASB:GRFGVAT FZF GKG ZFT NAQ NPGVIR 911 RZNVY");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj NYPunzorefPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}