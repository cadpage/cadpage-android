cnpxntr arg.narv.pnqcntr.cnefref.VN;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Zhfpnynar Pbhagl, VN
Pbagnpg: XRIVA SYLAA <xjs9111@tznvy.pbz>
Flfgrz: Vnzerfcbaqvat
Fraqre: 7771

.... (ASQ) 12-001870 ZRQVPNY \a1089 180GU FG \aNGJBBQ NIR / ONAPEBS/G NIR \aAVPUBYF \aASE JYNO
.... (ASQ) 11-052885 NPPVQRAG-CV\aVWRZ NIR/ ZNVA FG\aAVPUBYF\aASQ ASE
.... (ASQ) 11-052886 SVER-FGEHPGHER\a410 ENVYEBNQ FG\aVWRZ NIR / JNFUVATGB/A NIR\aAVPUBYF\aASQ
.... (ASQ) 12-001933 ZRQVPNY\a1649 UBYYL NIR\a160GU FG / 170GU FG/\aJRFG YVOREGL\aASE JYNO
.... (ASQ) 12-000312 SVER-FGEHPGHER\a1530 NGJBBQ NIR\a560GU FG FR / 160GU/FG\aJRFG YVOREGL\aASQ JYSQ

Pbagnpg: Oergg Orpxre <penfu.orpxre@tznvy.pbz>
Fraqre: 777
.... (JYSQ, JYNZO) Ercbegrq: 10/02/2013 19:59:41\a13-040989 ZRQVPNY \aYbp: 332 ZNVA FG AVPUBYF,  \aAVPUBYF NIR /  VWRZ NIR \aAVPUBYF SVER QRCNEGZRAG \aASE JYNO

 */

choyvp pynff VNZhfpngvarPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VNZhfpngvarPbhaglCnefreGrfg() {
    frgCnefre(arj VNZhfpngvarPbhaglCnefre(), "ZHFPNGVAR PBHAGL", "VN");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        ".... (ASQ) 12-001870 ZRQVPNY \a1089 180GU FG \aNGJBBQ NIR / ONAPEBS/G NIR \aAVPUBYF \aASE JYNO",
        "FEP:ASQ",
        "VQ:12-001870",
        "PNYY:ZRQVPNY",
        "NQQE:1089 180GU FG",
        "K:NGJBBQ NIR / ONAPEBS/G NIR",
        "PVGL:AVPUBYF",
        "HAVG:ASE JYNO");

    qbGrfg("G2",
        ".... (ASQ) 11-052885 NPPVQRAG-CV\aVWRZ NIR/ ZNVA FG\aAVPUBYF\aASQ ASE",
        "FEP:ASQ",
        "VQ:11-052885",
        "PNYY:NPPVQRAG-CV",
        "NQQE:VWRZ NIR & ZNVA FG",
        "PVGL:AVPUBYF",
        "HAVG:ASQ ASE");

    qbGrfg("G3",
        ".... (ASQ) 11-052886 SVER-FGEHPGHER\a410 ENVYEBNQ FG\aVWRZ NIR / JNFUVATGB/A NIR\aAVPUBYF\aASQ",
        "FEP:ASQ",
        "VQ:11-052886",
        "PNYY:SVER-FGEHPGHER",
        "NQQE:410 ENVYEBNQ FG",
        "K:VWRZ NIR / JNFUVATGB/A NIR",
        "PVGL:AVPUBYF",
        "HAVG:ASQ");

    qbGrfg("G4",
        ".... (ASQ) 12-001933 ZRQVPNY\a1649 UBYYL NIR\a160GU FG / 170GU FG/\aJRFG YVOREGL\aASE JYNO",
        "FEP:ASQ",
        "VQ:12-001933",
        "PNYY:ZRQVPNY",
        "NQQE:1649 UBYYL NIR",
        "K:160GU FG / 170GU FG/",
        "PVGL:JRFG YVOREGL",
        "HAVG:ASE JYNO");

    qbGrfg("G5",
        ".... (ASQ) 12-000312 SVER-FGEHPGHER\a1530 NGJBBQ NIR\a560GU FG FR / 160GU/FG\aJRFG YVOREGL\aASQ JYSQ",
        "FEP:ASQ",
        "VQ:12-000312",
        "PNYY:SVER-FGEHPGHER",
        "NQQE:1530 NGJBBQ NIR",
        "K:560GU FG FR / 160GU/FG",
        "PVGL:JRFG YVOREGL",
        "HAVG:ASQ JYSQ");
  
  }
  
  @Grfg
  choyvp ibvq grfgOergOrpxrare() {

    qbGrfg("G1",
        ".... (JYSQ, JYNZO) Ercbegrq: 10/02/2013 19:59:41\a" +
        "13-040989 ZRQVPNY \a" +
        "Ybp: 332 ZNVA FG AVPUBYF,  \a" +
        "AVPUBYF NIR /  VWRZ NIR \a" +
        "AVPUBYF SVER QRCNEGZRAG \a" +
        "ASE JYNO",

        "FEP:JYSQ, JYNZO",
        "QNGR:10/02/2013",
        "GVZR:19:59:41",
        "VQ:13-040989",
        "PNYY:ZRQVPNY",
        "NQQE:332 ZNVA FG",
        "PVGL:AVPUBYF",
        "K:AVPUBYF NIR /  VWRZ NIR",
        "FEP:AVPUBYF SVER QRCNEGZRAG",
        "HAVG:ASE JYNO");
   
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VNZhfpngvarPbhaglCnefreGrfg().trarengrGrfgf("G1");
  }
}