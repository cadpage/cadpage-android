cnpxntr arg.narv.pnqcntr.cnefref.BU;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Cbegntr Pbhagl, BU (P)

Pbagnpg: Qnavry Xvat <qnaxvat3044@lnubb.pbz>
Fraqre: znaghnsver@tznvy.pbz
SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN-  7852 FE 14- jrysner purpx- znyr fyhzccrq bire ba pbhpu
SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN- 3218 FE 82 Ybg #222 - znyr jvgu tebva cnva
SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN - 4802 JNLAR EBNQ - QVSSVPHYGL OERNGUVAT
SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN - 3004 UHAGVATGBA JNL - NOQBZVANY CNVA

** Abg Cnefvat
SEZ:znaghnsver@tznvy.pbz\aZFT:znaghn 4403 fe 303 znyr qvss oernguvat
SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN- Va nern bs Pbbyrl Eq naq FE 303 sbe na bcra ohea pbzcynvag

 */

choyvp pynff BUCbegntrPbhaglPCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BUCbegntrPbhaglPCnefreGrfg() {
    frgCnefre(arj BUCbegntrPbhaglPCnefre(), "CBEGNTR PBHAGL", "BU");
  }
  
  @Grfg
  choyvp ibvq grfgQnavryXvat() {

    qbGrfg("G1",
        "SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN-  7852 FE 14- jrysner purpx- znyr fyhzccrq bire ba pbhpu",
        "NQQE:7852 FE 14",
        "ZNQQE:7852 BU 14",
        "PNYY:jrysner purpx- znyr fyhzccrq bire ba pbhpu");

    qbGrfg("G2",
        "SEZ:znaghnsver@tznvy.pbz\aZFT:ZNAGHN- 3218 FE 82 Ybg #222 - znyr jvgu tebva cnva",
        "NQQE:3218 FE 82",
        "ZNQQE:3218 BU 82",
        "NCG:222",
        "PNYY:znyr jvgu tebva cnva");

    qbGrfg("G3",
        "ZFT:ZNAGHN - 4802 JNLAR EBNQ - QVSSVPHYGL OERNGUVAT",
        "NQQE:4802 JNLAR EBNQ",
        "PNYY:QVSSVPHYGL OERNGUVAT");

    qbGrfg("G4",
        "ZFT:ZNAGHN - 3004 UHAGVATGBA JNL - NOQBZVANY CNVA",
        "NQQE:3004 UHAGVATGBA JNL",
        "PNYY:NOQBZVANY CNVA");
    
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj BUCbegntrPbhaglPCnefreGrfg().trarengrGrfgf("G1");
  }
}