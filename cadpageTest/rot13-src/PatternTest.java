

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("(?:(Fgngvba [^/:]+) / )?([N-M]+\\f+(?:Nqe:|nqe:|Obk:).*)", Cnggrea.QBGNYY);
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("Fgngvba 45 & 55 / SVAI   Obk:45015 nqe: YBJRE QBYVATGBA EQ/LBEXFUVER QE ,52 12/06/12  19:01:49 SQ1219254   Eha: E45");
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
