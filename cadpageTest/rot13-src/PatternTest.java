

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE  = 
      Cnggrea.pbzcvyr("\\oCeboyrz: (.*?)\\.  Cngvrag Vasb:|\\oPnyyre Fgngrzrag: (.*?)\\.|\\oQvfcngpu (?:Pbqr|Yriry): +(\\q[^ ;]+);?|\\oCebDN (?:(?:Zrqvpny|Sver|Cbyvpr) )?(?:Qvfcngpu Zrffntr Frag|Xrl Dhrfgvbaf unir orra pbzcyrgrq|Dhrfgvbaanver Pbzcyrgrq);| Arj CebDN (?:Zrqvpny|Sver|Cbyvpr) Pnfr Ahzore unf orra nffvtarq;|Qvfcngpu (?:Pbqr|Yriry): --: -\\q+|\\oR911 Vasb -.*|Puvrs Pbzcynvag Ahzore: \\q+;| \\*\\* Pnfr ahzore \\q+ unf orra nffvtarq sbe \\q+:PAGL \\*\\* >+|>+ ol: [ N-M]+ ba grezvany: [^ ]+");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg(" >>>> ol: QRNAAN FRNOBYG ba grezvany: 911zf21");
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
