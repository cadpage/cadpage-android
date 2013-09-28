

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =  
      Cnggrea.pbzcvyr("([N-M0-9]{1,5}) *(?:\\q{3})? Hgy# (\\q{3}(?: ?[N-M]\\q?)?(?: +\\q{3}[- ]?[N-M]\\q?)?) +(\\q\\q/\\q\\q/\\q\\q) +([-, N-M0-9]+?)(?: *#([-,N-M0-9]+))? / (.*?)[ /]+([N-M]+\\q+(?: ?, ?[N-M]+\\q+)*)");


  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("FANXR053 Hgy# 362 P 09/26/13 3152 A XVATF UVTUJNL JRFG AG PL / A XVATF UVTUJNL ABEGU AG WO-EC UNF N ENGGYR FANXR PBAGNVARQ GB N TNEONTR PNA R53 <- Sver Havg rKgenpgrq sebz Vapvqrag. 1638 QC004 R59 ,302SQ");
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
