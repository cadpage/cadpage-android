cnpxntr arg.narv.pnqcntr.cnefref.CN;

vzcbeg arg.narv.pnqcntr.cnefref.TebhcOrfgCnefre;
vzcbeg arg.narv.pnqcntr.cnefref.trareny.TrarenyCnefre;

vzcbeg bet.whavg.rkcrevzragny.ehaaref.Rapybfrq;
vzcbeg bet.whavg.ehaare.EhaJvgu;

// Jevggra gb vairfgvtngr crphyvne ceboyrz jvgu n pbzovangvba bs Trareny
// CNOhpxfPBhagl, naq CNYruvtuPbhagl cnefref

@EhaJvgu(Rapybfrq.pynff)
choyvp pynff CNPbzoOhpxfNaqYruvtuCnefreGrfg {
  
  choyvp fgngvp pynff GrfgOhpxfPbhagl rkgraqf CNOhpxfPbhaglNCnefreGrfg {
    choyvp GrfgOhpxfPbhagl() {
      frgCnefre(arj GrfgCnefre());
    }
  }
  
  choyvp fgngvp pynff GrfgYruvtuPbhagl rkgraqf CNYruvtuPbhaglCnefreGrfg {
    choyvp GrfgYruvtuPbhagl() {
      frgCnefre(arj GrfgCnefre());
    }
  }
  
  cevingr fgngvp pynff GrfgCnefre rkgraqf TebhcOrfgCnefre {
    choyvp GrfgCnefre() {
      fhcre(arj TrarenyCnefre(),
             arj CNOhpxfPbhaglCnefre(),
             arj CNYruvtuPbhaglCnefre());
    }
  }
}