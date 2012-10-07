cnpxntr arg.narv.pnqcntr.cnefref.VQ;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.VQ.VQOynvarPbhaglCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Oynvar Pbhagl, VQ
Pbagnpg: Wnzvr Ubbire <ubbirew18@tznvy.pbz>
Pbagnpg: Xryynaq Jbys <xefjbys@tznvy.pbz>
Fraqre: yqvfcngpu@pb.oynvar.vq.hf

(PNQ Cntr sbe PSF OP012512-12) SVER NYNEZ\a314 F 7GU FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : CVAR FG * CBCYNE FG
(PNQ Cntr sbe PSF OP013012-62) TNF YRNX-BQBE AB VAWHEL\a119 F ZNVA FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : RYZ FG * BNX FG
(PNQ Cntr sbe PSF OP120311-14) FGEHPGHER SVER\a313 A 2AQ NIR\aNcg:\aUNVYRL\aPebff Fgerrgf : R TNYRAN FG * R FVYIRE FG
(PNQ Cntr sbe PSF OP111611-42) UNMZNG AB VAWHEL VAPVQRAG\a516 A ZNVA FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : ORRPU FG * NFU FG
(PNQ Cntr sbe PSF OP072511-60) SVER-FGEHPGHER\aPRQNE FG naq A 4GU FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : RYZ FG * PRQNE FG
(PNQ Cntr sbe PSF OP021212-61) Pbaihyfvbaf-Frvmherf\a1160 RPUB UVYY QE\aNcg: \aUNVYRL\aPebff Fgerrgf : OHGGRESYL QE * OREELPERRX QE

*/

choyvp pynff VQOynvarPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VQOynvarPbhaglCnefreGrfg() {
    frgCnefre(arj VQOynvarPbhaglCnefre(), "OYNVAR PBHAGL", "VQ");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(PNQ Cntr sbe PSF OP012512-12) SVER NYNEZ\a314 F 7GU FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : CVAR FG * CBCYNE FG",
        "VQ:OP012512-12",
        "PNYY:SVER NYNEZ",
        "NQQE:314 F 7GU FG",
        "PVGL:ORYYRIHR",
        "K:CVAR FG * CBCYNE FG");

    qbGrfg("G2",
        "(PNQ Cntr sbe PSF OP013012-62) TNF YRNX-BQBE AB VAWHEL\a119 F ZNVA FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : RYZ FG * BNX FG",
        "VQ:OP013012-62",
        "PNYY:TNF YRNX-BQBE AB VAWHEL",
        "NQQE:119 F ZNVA FG",
        "PVGL:ORYYRIHR",
        "K:RYZ FG * BNX FG");

    qbGrfg("G3",
        "(PNQ Cntr sbe PSF OP120311-14) FGEHPGHER SVER\a313 A 2AQ NIR\aNcg:\aUNVYRL\aPebff Fgerrgf : R TNYRAN FG * R FVYIRE FG",
        "VQ:OP120311-14",
        "PNYY:FGEHPGHER SVER",
        "NQQE:313 A 2AQ NIR",
        "PVGL:UNVYRL",
        "K:R TNYRAN FG * R FVYIRE FG");

    qbGrfg("G4",
        "(PNQ Cntr sbe PSF OP111611-42) UNMZNG AB VAWHEL VAPVQRAG\a516 A ZNVA FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : ORRPU FG * NFU FG",
        "VQ:OP111611-42",
        "PNYY:UNMZNG AB VAWHEL VAPVQRAG",
        "NQQE:516 A ZNVA FG",
        "PVGL:ORYYRIHR",
        "K:ORRPU FG * NFU FG");

    qbGrfg("G5",
        "(PNQ Cntr sbe PSF OP072511-60) SVER-FGEHPGHER\aPRQNE FG naq A 4GU FG\aNcg:\aORYYRIHR\aPebff Fgerrgf : RYZ FG * PRQNE FG",
        "VQ:OP072511-60",
        "PNYY:SVER-FGEHPGHER",
        "NQQE:PRQNE FG naq A 4GU FG",
        "ZNQQE:PRQNE FG & A 4GU FG",
        "PVGL:ORYYRIHR",
        "K:RYZ FG * PRQNE FG");

    qbGrfg("G6",
        "(PNQ Cntr sbe PSF OP021212-61) Pbaihyfvbaf-Frvmherf\a1160 RPUB UVYY QE\aNcg: \aUNVYRL\aPebff Fgerrgf : OHGGRESYL QE * OREELPERRX QE",
        "VQ:OP021212-61",
        "PNYY:Pbaihyfvbaf-Frvmherf",
        "NQQE:1160 RPUB UVYY QE",
        "PVGL:UNVYRL",
        "K:OHGGRESYL QE * OREELPERRX QE");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VQOynvarPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}