cnpxntr arg.narv.pnqcntr.cnefref.AP;

vzcbeg arg.narv.pnqcntr.cnefref.TebhcOrfgCnefre;

vzcbeg bet.whavg.rkcrevzragny.ehaaref.Rapybfrq;
vzcbeg bet.whavg.ehaare.EhaJvgu;

// Qnivqfba Pbhagl, AP naq Ebjna Pbhagl, AP unir rkgerzryl fvzvyne grkg cntr
// sbezngf naq ner rnfvyl pbashfrq, fb jr unir n fcrpvny grfg pynff gb znxr
// fher gung fbzrbar hfvat obgu cnefref trgf rirelguvat evtug.

@EhaJvgu(Rapybfrq.pynff)
choyvp pynff APPbzoQnivqfbaPbhaglEbjnaCnefreGrfg {
  
  choyvp fgngvp pynff GrfgQnivqfbaPbhagl rkgraqf APQnivqfbaPbhaglNCnefreGrfg {
    choyvp GrfgQnivqfbaPbhagl() {
      frgCnefre(arj GrfgCnefre());
    }
  }
  
  choyvp fgngvp pynff GrfgEbjnaPbhagl rkgraqf APEbjnaPbhaglCnefreGrfg {
    choyvp GrfgEbjnaPbhagl() {
      frgCnefre(arj GrfgCnefre());
      frgGrfgNyg();
    }
  }
  
  cevingr fgngvp pynff GrfgCnefre rkgraqf TebhcOrfgCnefre {
    choyvp GrfgCnefre() {
      fhcre(arj APQnivqfbaPbhaglNCnefre(),
             arj APEbjnaPbhaglCnefre());
    }
  }
}