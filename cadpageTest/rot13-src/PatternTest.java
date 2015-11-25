

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE = 
      Cnggrea.pbzcvyr("(?:((?:[N-M]\\q+ +)+(?:Nynez +)?)(?:Greevgbel (\\q[N-M]) +)?)?(.*)(\\q{4}-\\q{8})([^\a]+)?(?:\a *(.*))?", Cnggrea.QBGNYY);
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("710 J FCEHPR FG Unfxryy M Oernguvat Ceboyrzf 2015-00000189  Pnyy Ahzore 929 jnf perngrq sebz Pnyy Ahzore 922(Abi 20 2015 11:59CZ)  \a72-lrne-byq, Srznyr, Pbafpvbhf, Oernguvat.\aPP Grkg: Oernguvat Ceboyrzf\aPnyyre Fgngrzrag: AB OERNGUVAT JRYY\aQvfcngpu Pbqr: 06Q02   Qrg. Grkg: QVSSVPHYGL FCRNXVAT ORGJRRA OERNGUF\aErfcbafr: EYF\a\aNAFJREF:\a--- Fur vf pbzcyrgryl nyreg (erfcbaqvat nccebcevngryl).\a--- Fur unf qvssvphygl fcrnxvat orgjrra oernguf.  \a72-lrne-byq, Srznyr, Pbafpvbhf, Oernguvat.\aPP Grkg: Oernguvat Ceboyrzf\aPnyyre Fgngrzrag: AB OERNGUVAT JRYY\a  \a72-lrne-byq, Srznyr, Pbafpvbhf, Oernguvat.\aPP Grkg: Oernguvat Ceboyrzf\aPnyyre Fgngrzrag: AB OERNGUVAT JRYY");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.zngpurf()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
  }
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
