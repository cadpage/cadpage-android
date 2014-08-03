

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr("([N-M]{1,3}\\q{12,14}) +(.*)");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("S4P140801000065 IRUVPYR PENFU JVGU V Nqq: V71 AO RKVG&JVYZVATGBA EQ Synt: ..A/N.. Pbzc: IREVMBA Ck: 5137608315 Znc: Y17 Orng: 4PJG  Pzg: Vapvqrag Vavgvngrq Ol: RF/SNEYNVAB, NAQERJ ZBGBEPLYIR BSS GUR EBNQ BA GUR FUBHYQRE. 1 ZNYR, JNF JRNEVAT URYZRG Cevznel Rirag: ZNVA Bcrarq: 14/08/01 19:17 Gvzr: 19:16 (JNFUVATGBA GJC) C2_NAL_Ntrapl_Tebhc");
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
