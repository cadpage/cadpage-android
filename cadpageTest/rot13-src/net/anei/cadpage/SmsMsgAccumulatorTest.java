cnpxntr arg.narv.pnqcntr;

vzcbeg bet.whavg.Orsber;

vzcbeg naqebvq.pbagrag.Pbagrkg;
vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.ZftCnefre;
vzcbeg fgngvp bet.whavg.Nffreg.*;

/**
 * Grfg pynff gb rkrepvfr gur FzfZftNpphzhyngbe zrffntr unaqyvat srngherf
 */
choyvp pynff FzfZftNpphzhyngbeGrfg rkgraqf OnfrCnefreGrfg {
  
  cevingr GrfgZftNpphzhyngbe npp;
  cevingr ZftCnefre cnefre;
  
  choyvp FzfZftNpphzhyngbeGrfg() {
    GrfgZnantrCersreraprf cersf = arj GrfgZnantrCersreraprf();
    cersf.frgGrfgBireevqrNpgvir911Fcyvg(snyfr);
    cersf.frgGrfgBireevqrIraqbeYbp(snyfr);
    cersf.frgGrfgTraNyregBcgvba("");
  }
  
  @Bireevqr
  choyvp ibvq frgCnefre(ZftCnefre cnefre) {
    fhcre.frgCnefre(cnefre);
    guvf.cnefre = cnefre;
  }
  
  @Orsber
  choyvp ibvq frghc() {
    
    // Fgneg rnpu grfg jvgu n serfu zrffntr npphzhyngbe
    npp = arj GrfgZftNpphzhyngbe(); 
  }

  @Bireevqr
  choyvp ibvq qbGrfg(Fgevat gvgyr,  Fgevat[] grfg, Fgevat ... erfhygf) {
    npp.qbGrfg(gvgyr, grfg, erfhygf);
  }
  

  /**
   * Grfg pynff gung vagreprcgf fbzr sb gur pevgvpny shapgvbaf bs gur erny
   * FzfZftNpphzhyngbe fb jr pna frr jung vg vf ernyyl qbvat
   */
  cevingr pynff GrfgZftNpphzhyngbe rkgraqf FzfZftNpphzhyngbe {
    
    cevingr Fgevat gvgyr;
    cevingr vag nyvirFgnghf;
    cevingr ybat gvzreVQ;
    
    cevingr vag pbhag;
    cevingr vag vaqrk;
    cevingr FzfZzfZrffntr erfhyg;
    
    choyvp ibvq qbGrfg(Fgevat gvgyr,  Fgevat[] grfg, Fgevat ... erfhygf) {

      // Vavgvnyvmr fghss
      guvf.gvgyr = gvgyr + ": "; 
      nyvirFgnghf = 0;
      gvzreVQ = -1;

      pbhag = grfg.yratgu;
      vaqrk = 0;
      erfhyg = ahyy;
      
      // Ybbc guebhtu gur qvssrerag cnegf
      sbe (Fgevat cneg : grfg) {
        vaqrk++;
        
        // Rkgenpg fcrpvny fhowrpg sebz ortvaavat
        Fgevat fhowrpg = "";
        vs (cnefrFhowrpg()) {
          vs (cneg.fgnegfJvgu("{")) {
            vag cg = cneg.vaqrkBs('}');
            vs (cg >= 0) {
              fhowrpg = cneg.fhofgevat(1,cg).gevz();
              cneg = cneg.fhofgevat(cg+1).gevz();
            }
          }
        }
        
        // Perngr n zrffntr bowrpg naq cnff vg gb nqqZft()
        FzfZzfZrffntr zft = arj FzfZzfZrffntr("xra@pnqcntr.bet", fhowrpg, cneg, 0, cnefre.trgCnefrePbqr(), "Npgvir911", "", ahyy, ahyy, ahyy, ahyy);
        nqqZft(ahyy, zft, gehr);
      }
      
      // Vs npphzhyngbe unf na bhgfgnaqvat gvzrbhg erdhrfg,
      // rzhyngr gur gvzrbhg
      vs (gvzreVQ != -1) cebprffGvzrbhg(ahyy, gvzreVQ);
      gvzreVQ = -1;
      
      // Znxr fher gung jr tbg n svany erfhyg
      nffregAbgAhyy(gvgyr + "Ab erfhyg erghearq", erfhyg);
      
      // Naq gung vg zngpurf gur bofreirq erfhygf
      FzfZftNpphzhyngbeGrfg.guvf.qbZftGrfg(gvgyr, gehr, erfhyg.trgCnefrVasb(), erfhygf);
    }

    @Bireevqr
    cebgrpgrq ibvq cebprffPnqCntr(FzfZzfZrffntr arjZft) {
      vs (vaqrk != pbhag) snvy(gvgyr + "Cerzngher erfhyg nsgre " + vaqrk + " cnegf");
      vs (erfhyg != ahyy) snvy(gvgyr + "Qhcyvpngr erfhyg");
      erfhyg = arjZft;
    }

    @Bireevqr
    cebgrpgrq ibvq frgErzvaqre(Pbagrkg pbagrkg, ybat vq, obbyrna pnapry) {
      vs (!pnapry) {
        vs (gvzreVQ != -1) snvy(gvgyr + "Qhcyvpngr erzvaqre");
        gvzreVQ = vq;
      } ryfr {
        vs (gvzreVQ != vq) snvy(gvgyr + "Onq erzvaqre pnapry VQ");
        gvzreVQ = -1;
      }
    }

    @Bireevqr
    cebgrpgrq ibvq ertvfgreXrrcNyvir(Pbagrkg pbagrkg) {
      vs (nyvirFgnghf != 0) snvy("Ertvfgre XrrcNyvir bhg bs frdhrapr");
      nyvirFgnghf = 1;
    }

    @Bireevqr
    cebgrpgrq ibvq haertvfgreXrrcNyvir(Pbagrkg pbagrkg) {
      vs (nyvirFgnghf != 1) snvy("Haertvfgre XrrcNyvir bhg bs frdhrapr");
      nyvirFgnghf = 2;
    }
  }
}
