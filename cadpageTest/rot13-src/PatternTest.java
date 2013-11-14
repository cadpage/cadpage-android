

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("Vap(?:vqrag) Uvfgbel");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("<FLFGRZ TRARENGRQ> GB VAG1 SEBZ SF01  : 134/R60\a                                                    \a \a \a Vap Uvfgbel sbe: #RQ1213417    Kers:                           #CQ121040864\a\a \a Ragrerq      04/13/12  15:57:01  OL CQ10   753      \a Qvfcngpurq   04/13/12  15:57:23  OL SF01   619      \a \a Vavgvny Glcr: NQVNO   Vavgvny Nynez Yriry:  1  Svany Nynez Yriry:  1\a Svany Glcr: NQVNO (QVNORGVP RZRETRAPL) Cev: 3 Qfcb:      Cerz: [  ]\a RZF Oyx:  134620 Sver Oyx:  60063  Cbyvpr Oyx:  36106  Znc Cntr: 3032T4 \a Tebhc: RA  Orng: 134 Fep:  A NGG:  ZGP - Zrrg gur Pbzcynvanag  \a Ybp: EG 309 BSSVPR SHEA ,36 ng 1711 ORGUYRURZ CX ,36 ogja FJNEGYRL EQ & ZVYY EQ\a \a Ybp Vasb: \a Anzr: QNA ZPGNTHR             Nqqe:                         Cubar: 2676406378\a \a/1557  (753     )  RAGEL:         63LBZ,,NJNXR OHG VAPBURERAG,,ERSHFVAT GUR FHTN\a                                  EF\a/1557  (619     )  QVFC    N134    #125093   CNAXBR,ELNA \a/1557              NQQ     DHG60");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevag(grfg);
    vs (! zngpu.svaq()) {
      Flfgrz.bhg.cevag(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevag(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }

}
