cnpxntr arg.narv.pnqcntr.cnefref.VN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Fpbggl Pbhagl, VN
Pbagnpg: Qnivq Yvfxr <qnivq.yvfxrhfzp@tznvy.pbz>
Fraqre: frpp@fpbgg.vn.hf
(Vapvqrag) ZPSQ  106 A FNYVAN FG ZpPnhfynaq RZF be ZIP-Fbyb  Pnyy fhpprffshyyl genafsreerq gb crre Ntrapl. [ZrqvpRZF]  Crre PSF Ahzore = 0045-N_2012-12-01 [ZrqvpRZ
(Vapvqrag) ZPSQ  21822 274GU FG Fpbgg Pbhagl RZF be ZIP-Fbyb  TENAQNHTUGRE  FRVMHER  R911 Vasb - Pynff bs Freivpr: ERFQ Fcrpvny Erfcbafr Vasb: CFNC=FRPP FPBGG FQ  
(Vapvqrag) ZPSQ  401 F FNYVAN FG ZpPnhfynaq RZF be ZIP-Fbyb  QNHTUGRE VYY.  IBZVGVAT.  R911 Vasb - Pynff bs Freivpr: ERFQ Fcrpvny Erfcbafr Vasb: CFNC=FRPP ZPPNHFYN
(Vapvqrag) ZPSQ  210GU NIR 300GU FG Fpbgg Pbhagl RZF be ZIP-Fbyb  Pnyy Ahzore 5550 jnf perngrq sebz Pnyy Ahzore 5548(Qrp 21 2012  4:51NZ)  PNYYRE JNF ABG FHER VS N
(Vapvqrag) ZPSQ  210GU NIR 300GU FG Fpbgg Pbhagl <ARJ PNYY>  R911 Vasb - Pynff bs Freivpr: JCU2 Fcrpvny Erfcbafr Vasb: CFNC=        Irevsl CQ  Irevsl SQ  Irevsl RZ

 */

choyvp pynff VNFpbggPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VNFpbggPbhaglCnefreGrfg() {
    frgCnefre(arj VNFpbggPbhaglCnefre(), "FPBGG PBHAGL", "VN");
  }
  
  @Grfg
  choyvp ibvq grfgQnivqYvfxr() {

    qbGrfg("G1",
        "(Vapvqrag) ZPSQ  106 A FNYVAN FG ZpPnhfynaq RZF be ZIP-Fbyb  Pnyy fhpprffshyyl genafsreerq gb crre Ntrapl. [ZrqvpRZF]  Crre PSF Ahzore = 0045-N_2012-12-01 [ZrqvpRZ",
        "FEP:ZPSQ",
        "NQQE:106 A FNYVAN FG",
        "PVGL:ZpPnhfynaq",
        "PNYY:RZF be ZIP-Fbyb",
        "VASB:Pnyy fhpprffshyyl genafsreerq gb crre Ntrapl.");

    qbGrfg("G2",
        "(Vapvqrag) ZPSQ  21822 274GU FG Fpbgg Pbhagl RZF be ZIP-Fbyb  TENAQNHTUGRE  FRVMHER  R911 Vasb - Pynff bs Freivpr: ERFQ Fcrpvny Erfcbafr Vasb: CFNC=FRPP FPBGG FQ  ",
        "FEP:ZPSQ",
        "NQQE:21822 274GU FG",
        "PNYY:RZF be ZIP-Fbyb",
        "VASB:TENAQNHTUGRE  FRVMHER");

    qbGrfg("G3",
        "(Vapvqrag) ZPSQ  401 F FNYVAN FG ZpPnhfynaq RZF be ZIP-Fbyb  QNHTUGRE VYY.  IBZVGVAT.  R911 Vasb - Pynff bs Freivpr: ERFQ Fcrpvny Erfcbafr Vasb: CFNC=FRPP ZPPNHFYN",
        "FEP:ZPSQ",
        "NQQE:401 F FNYVAN FG",
        "PVGL:ZpPnhfynaq",
        "PNYY:RZF be ZIP-Fbyb",
        "VASB:QNHTUGRE VYY.  IBZVGVAT.");

    qbGrfg("G4",
        "(Vapvqrag) ZPSQ  210GU NIR 300GU FG Fpbgg Pbhagl RZF be ZIP-Fbyb  Pnyy Ahzore 5550 jnf perngrq sebz Pnyy Ahzore 5548(Qrp 21 2012  4:51NZ)  PNYYRE JNF ABG FHER VS N",
        "FEP:ZPSQ",
        "NQQE:210GU NIR & 300GU FG",
        "PNYY:RZF be ZIP-Fbyb",
        "VASB:Pnyy Ahzore 5550 jnf perngrq sebz Pnyy Ahzore 5548(Qrp 21 2012  4:51NZ)  PNYYRE JNF ABG FHER VS N");

    qbGrfg("G5",
        "(Vapvqrag) ZPSQ  210GU NIR 300GU FG Fpbgg Pbhagl <ARJ PNYY>  R911 Vasb - Pynff bs Freivpr: JCU2 Fcrpvny Erfcbafr Vasb: CFNC=        Irevsl CQ  Irevsl SQ  Irevsl RZ",
        "FEP:ZPSQ",
        "NQQE:210GU NIR & 300GU FG",
        "PNYY:<ARJ PNYY>");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VNFpbggPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}