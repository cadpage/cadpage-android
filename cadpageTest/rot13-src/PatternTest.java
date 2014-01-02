

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("Sebz - ([N-M0-9]+) - 1 Nynez / (.*?) (?:Obk|OBK|\\| ENC) - ([-N-M0-9]*) @ (.*?) (?:\\| )?KFgerrgf: *(.*?)(?:/?Ab PebffFgerrg Sbhaq)? (?:\\| )?Ba - ([ N-M0-9]*)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Sebz - RFQ02 - 1 Nynez / OBK -Fgehpgher Sver Obk - 02-0214O @ 821 Bngzrny Qe KFgerrgf: ANEHAN JNL/SNVEYNAQ QE Ba - SGNP 201 Gvzr: 06:21:03 Vap# 13122652 Pnfr Ahz: Sbe - DAG40,RAT28,RAT221,ONG201");
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
