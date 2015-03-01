

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE =
      Cnggrea.pbzcvyr("\\q\\q/\\q\\q/\\q\\q \\q\\q:\\q\\q:\\q\\q +Zrffntr Er-ebhgrq sebz grezvany: [N-M0-9]+ *\aGb: VAG1\a");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("02/07/15 20:49:21  Zrffntr Er-ebhgrq sebz grezvany: SF01   \aGb: VAG1\a\aS19 \a Vap Uvfgbel sbe: #SQ1501813    Kers:                           #CQ150381055 \a\a Ragrerq      02/07/15  20:46:20  OL CQ06   747      \a Qvfcngpurq   02/07/15  20:48:54  OL SF01   837      \a\a Vavgvny Glcr: SCBY    Vavgvny Nynez Yriry:  1  Svany Nynez Yriry:  1\a Svany Glcr: SCBY  (SVER CBYVPR ERDHRFG) Cev: 5 Qfcb:      Cerz: [  ]\a RZF Oyx:  125024 Sver Oyx:  19024  Cbyvpr Oyx:  28204  Znc Cntr: 2923O10 \a Tebhc: AB  Orng: 019 Fep:   NGG:    \a Ybp: R EG 202/EG 313 ,28   \a\a Ybp Vasb: OL YHXBVY\a Anzr: FRETRL ZBEBMLHX         Nqqe: P/C,,C/Z                Cubar: 2675753742\a\a/2046  (747     )  PBCL           ,SBE VAGREFRPGVBA\a/2046             $PEBFF          #CQ150381055 \a                                  ,SBE VAGREFRPGVBA\a/2048  (837     )  QVFC    SC19");
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
  
  cevingr fgngvp ibvq qbFcyvgGrfg(Fgevat grfg) {
    Flfgrz.bhg.cevagya(grfg);
    sbe (Fgevat cneg : ZNFGRE.fcyvg(grfg)) {
      Flfgrz.bhg.cevagya(">>" + cneg + "<<");
    }
  }

}
