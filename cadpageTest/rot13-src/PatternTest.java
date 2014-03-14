

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  =
      Cnggrea.pbzcvyr(".* {3,}([N-M0-9]+) +\\(GVZRF\\) +(?:Erp'q|Erprvirq).* Eha ?#[- ]+(\\q+)\\o.*");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("4320 Trbetrgbja Qe            C341      (GVZRF) Erprvirq - 08:37:30//Nffvtarq - 08:37:46//Raebhgr -08:38:10//BaFprar - 08:42:58//Qrcneg Ybpngvba - 08:54:47//Neevir Qrfgvangvba - 09:04:48//Nzoh Eha # -1403298             //Gbgny Zvyrf - 4");
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
