

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  choyvp fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("([N-M ]+) [-+]\\q{3}\\.\\q{6} [-+]\\q{3}\\.\\q{6}");
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("FBHGU UHAGVATQBA -079.688001 +040.18421 Ceboyrz: QVNORGVP TRARENY JRNXARFF Cngvrag Ahzore: 1 Puvrs Pbzcynvag: Fvpx Crefba (Fcrpvsvp Qvntabfvf) 72-lrne-byq, Srznyr, Pbafpvbhf, Oernguvat. Qvfcngpu PNQ Pbqr: 26N05 Erfcbafr Grkg: Nycun XD: Fur unf bgure cnva: YRT CNVA XD: Ure cevznel ceboyrz vf trareny jrnxarff. XD: Fur vf pbzcyrgryl nyreg (erfcbaqvat nccebcevngryl). XD: Vg'f abg xabja vs fur vf oernguvat abeznyyl. XD: Fur vf abg oyrrqvat (be ibzvgvat oybbq). PNYYRE VF GUR QNHTUGRE.. FUR VF ABG BA FPRAR. JNF HAFHER BS NQQERFF.. FNVQ VG JNF GUR 3EQ BA YRSG PBZVAT VA BSS UHAGVATQBA EQ.. TERRA UBHFR & GURER VF N GENVYRE NPEBFF FG CG VF N QVNORGVP & SRYY FRIRENY QNLF NTB.. UNFA'G ORRA BHG BS ORQ FVAPR GURA");
  }
  
  cevingr fgngvp ibvq qbGrfg(Fgevat grfg) {
    Zngpure zngpu = ZNFGRE.zngpure(grfg);
    Flfgrz.bhg.cevagya(grfg);
    vs (! zngpu.svaq()) {
      Flfgrz.bhg.cevagya(" ab zngpu");
    } ryfr {
      sbe (vag t = 0; t<=zngpu.tebhcPbhag(); t++) {
        Flfgrz.bhg.cevagya(" T" + t + ":" + zngpu.tebhc(t));
      }
    }
    Flfgrz.bhg.cevagya();
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
