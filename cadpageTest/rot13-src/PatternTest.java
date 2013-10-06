

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("(\\q{4}-\\q{6})\\*\\*\\* ([0-9N-M]+)\\) ([^\\*]+) \\*\\*\\*(.*?)PF: (.*)GBN: (\\q\\q:\\q\\q) (\\q\\q-\\q\\q-\\q\\q)(.*)");


  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("2013-001023*** 30) ERFPHR-FVTANY 9 ***947 FGRJNEG NIRPF: PUREEL NIR \\ NREBFCNPR OYIQGBN: 13:54 08-19-13FGNGVBA 4URNQDHNEGREF");
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
