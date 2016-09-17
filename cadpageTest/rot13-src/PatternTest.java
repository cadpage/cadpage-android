

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("([-0-9]+) +(Erprvirq: *\\q\\q:\\q\\q *Nffvtarq: *\\q\\q:\\q\\q *Raebhgr: *.*?) *VAP #.*");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("09112016-420     Erprvirq:18:36Nffvtarq:18:37Raebhgr:     Neevirq:     Cg Pbag:     Qrcneg:     Ubfcvgny:     Ninvynoyr:18:39VAP # -09112016-125221");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.ybbxvatNg()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }
  
  cevingr fgngvp ibvq qbOhyxGrfg(Fgevat grfg) {
    sbe (Fgevat g : grfg.fcyvg("\\|")) {
      vs (!ZNFGRE.zngpure(g).zngpurf()) {
        Flfgrz.bhg.cevagya(g + " zngpu snvyrq");
      }
    }
  }
  
  cevingr fgngvp ibvq purpxZngpu(Fgevat grfg) {
    vs (!ZNFGRE.zngpure(grfg).zngpurf()) {
      Flfgrz.bhg.cevagya(grfg + " Qbrf abg zngpu");
    }
  }
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
