cnpxntr arg.narv.pnqcntr.cnefref.XL;

vzcbeg wnin.hgvy.Cebcregvrf;
vzcbeg wnin.hgvy.ertrk.Zngpure;
vzcbeg wnin.hgvy.ertrk.Cnggrea;

vzcbeg arg.narv.pnqcntr.cnefref.ZftVasb.Qngn;
vzcbeg arg.narv.pnqcntr.cnefref.FznegNqqerffCnefre;

choyvp pynff XLJbbqsbeqPbhaglCnefre rkgraqf FznegNqqerffCnefre {

  choyvp XLJbbqsbeqPbhaglCnefre() {
    fhcre(PVGL_YVFG, "JBBQSBEQ PBHAGL", "XL");
    frgSvryqYvfg("PBQR PNYY NQQE NCG PVGL QNGR GVZR TCF VASB VQ");
  }
  
  @Bireevqr
  choyvp Fgevat trgSvygre() {
    erghea "PNQ@icq.irefnvyyrfxl.pbz";
  }
  
  cevingr fgngvp svany Cnggrea ZNFGRE = Cnggrea.pbzcvyr("PNQ:([N-M0-9]+) +(.*?) +(\\q\\q/\\q\\q/\\q{4}) (\\q\\q:\\q\\q:\\q\\q) (?:(.*) )?(\\q{12})");
  cevingr fgngvp svany Cnggrea VASB_TCF_CGA = Cnggrea.pbzcvyr("R911 PYNFF: [N-M0-9]+ .*? YNG: ([-+]\\q{2,3}\\.\\q{6}) YBA: ([-+]\\q{2,3}\\.\\q{6})\\o *(.*)");
  
  @Bireevqr
  cebgrpgrq obbyrna cnefrZft(Fgevat fhowrpg, Fgevat obql, Qngn qngn) {
    
    vs (!fhowrpg.rdhnyf("JPN")) erghea snyfr;
    
    Zngpure zngpu = ZNFGRE.zngpure(obql);
    vs (!zngpu.zngpurf()) erghea snyfr;
    
    qngn.fgePbqr = zngpu.tebhc(1);
    qngn.fgePnyy = pbairegPbqrf(qngn.fgePbqr, PNYY_PBQRF);
    cnefrNqqerff(FgnegGlcr.FGNEG_NQQE, SYNT_NAPUBE_RAQ, zngpu.tebhc(2), qngn);
    qngn.fgeQngr = zngpu.tebhc(3);
    qngn.fgeGvzr = zngpu.tebhc(4);
    Fgevat vasb = trgBcgTebhc(zngpu.tebhc(5));
    qngn.fgePnyyVq = zngpu.tebhc(6);
    
    zngpu = VASB_TCF_CGA.zngpure(vasb);
    vs (zngpu.zngpurf()) {
      frgTCFYbp(zngpu.tebhc(1)+','+zngpu.tebhc(2), qngn);
      vasb = zngpu.tebhc(3);
    }
    qngn.fgeFhcc = vasb;
    erghea gehr;
  }
  
  cevingr fgngvp svany Cebcregvrf PNYY_PBQRF = ohvyqPbqrGnoyr(arj Fgevat[]{
      "R01",    "Noqbzvany Cnva",
      "R02",    "Nyyrevrf/Uvirf/Fgvat",
      "R03",    "Navzny Ovgrf",
      "R04",    "Nffnhyg/Encr",
      "R05",    "Onpx Cnva",
      "R06",    "Oernguvat Ceboyrzf",
      "R07",    "Oheaf",
      "R08",    "Pneoba Zbabkvqr Cbvfba",
      "R09",    "Pneqvnp/Erfcve Neerfg",
      "R10",    "Purfg Cnva",
      "R1046",  "Nzohynapr gb Nppvqrag",
      "R11",    "Pubxvat",
      "R12",    "Pbaihyfvbaf/Frvmherf",
      "R13",    "Qvnorgvp Ceboyrzf",
      "R14",    "Qebjavat/Qvivat Nppvqrag",
      "R15",    "Ryrpgebpgvba",
      "R16",    "Rlr Ceboyrzf",
      "R17",    "Snyyf",
      "R18",    "Urnqnpurf",
      "R19",    "Urneg Ceboyrzf",
      "R20",    "Urzbeeuntr",
      "R21",    "Vaqhfg/Znpuvarel Nppvqrag",
      "R22",    "Zhygvcyr Pbzcynvagf",
      "R23",    "Bireqbfr/Cbvfbavat",
      "R24",    "Certanapl/Puvyqovegu",
      "R25",    "Culpuvngevp/Oruni Ceboyrz",
      "R26",    "Fcrp Qvnt-Fvpx Crefba",
      "R27",    "Fgno/TFJ",
      "R28",    "Fgebxr/PIN",
      "R30",    "Genhzngvp Vaw-Fcrpvsvp",
      "R31",    "Hapbafpvbhf/Snvagvat",
      "R32",    "Haxabja Cebo-Zna Qbja",
      "R33",    "Oebxra/Senpgherq Yvzof",
      "RNYZ",   "RZF Sver Nynez Eha",
      "RNFFG",  "RZF Nffvgnapr",
      "RSVER",  "Sver Qrcg. Eha",
      "RCNTR",  "3eq Pnyy",
      "RGEA",   "RZF-Genvavat",
      "RGFC",   "RZF-Genafcbeg"
  });
  
  cevingr fgngvp svany Fgevat[] PVGL_YVFG = arj Fgevat[]{
    
    // Pvgvrf
    "ZVQJNL",
    "IREFNVYYRF",

    // Havapbecbengrq pbzzhavgvrf
    "ZVYYIVYYR",
    "ABARFHPU",
    "ZBEGBAFIVYYR",
    "ZVYARE",
    "GEBL"
  };
}
