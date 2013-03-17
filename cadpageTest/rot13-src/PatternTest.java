

vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

choyvp pynff CnggreaGrfg {

  cevingr fgngvp svany Cnggrea ZNFGRE
      = Cnggrea.pbzcvyr("EN: +([N-M0-9]+); +([^;]+); +([^,]+?) +,([^ ]*?) +K: +(-?[ \\q\\.]+?) +L: +(-?[ \\q\\.]+?) +Vap# +(\\q+); +([^;]+?) *; *(?:Qrfpe: *)?(.*)");
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    qbGrfg("EN: EVBYEN; ZRQVPNY; 270 BTYR NIR ,EVB_QRYY  K: -124 7.31976  L: 40 30.3687 Vap# 001122; EVB SEN2; Qrfpe: cnva va fgbznpu  Cng Pag: 1  Ntr: 28  Lrnef  Frk: Znyr  Pba: Lrf  Oerngu: Lrf  Erfc Fpevcg: Lbh ner erfcbaqvat gb n cngvrag jvgu noqbzvany cnva.  Gur cngvrag vf n  28-lrne-byq znyr, jub vf pbafpvbhf naq oernguvat. Abg nyreg.  Pnyyre Fgngrzrag: cnva va fgbznpu.  1.Ur vf abg pbzcyrgryl nyreg (abg erfcbaqvat nccebcevngryl).   <n uers=\"uggc://zncf.tbbtyr.pbz/?d=40.506146,-124.121996\">Znc</n>");
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
