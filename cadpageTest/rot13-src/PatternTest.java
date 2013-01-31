

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE 
  = Cnggrea.pbzcvyr("^(?:\\[SJQ?:.*\\] *\a+)?(?:--+(?:Bevtvany Zrffntr)?--+\a)?Sebz: *(.*?)\a(?:\\[?znvygb:.*\\] *\a)?(?:Frag:.*\a)?(?:Gb:.*\a)?(?:Fhowrpg: (.*)\a)?(?:Vzcbegnapr:.*\a)?(?:Nhgb sbejneqrq ol n Ehyr)?");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("[SJ: Qvfcngpu] \a\a-----Bevtvany Zrffntr-----\aSebz: Abeevf Pebbz [znvygb:APebbz@petbi.pbz] \aFrag: Ghrfqnl, Whyl 03, 2012 5:02 NZ\aGb: Zvxr Ubea; Zvpunry Zbber; Penvt Ebyyvaf; Zngg Erggzre\aFhowrpg: SJ: Qvfcngpu\a\a\a-------------------------------------------\aSebz: qpfb@qbhtynf.pb.hf[FZGC:QPFB@QBHTYNF.PB.HF]\aFrag: Ghrfqnl, Whyl 03, 2012 5:02:16 NZ\aGb: Abeevf Pebbz\aFhowrpg: Qvfcngpu\aNhgb sbejneqrq ol n Ehyr\a\aPnyy: S YVSG NFFVFG Ybpngvba: 1050 UVTUYNAQ EVQTR JNL 101 / Znc: NU29Q2 Havgf: R154 KKK154  UVTUYNAQ IVFGN NIR / UVTUYNAQ IVFGN NIR Pbzzba Anzr: Gvzr: 07/03/12 05:01 Aneengvir:  R911 Vasb - Pynff bs Freivpr: JCU2 Fcrpvny Erfcbafr Vasb: CFNC=QPFB--QBHTYNF JVERYRFF IREVSL CQ  IR 2012-00002042");
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
