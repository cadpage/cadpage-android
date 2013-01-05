cnpxntr arg.narv.pnqcntr.cnefref.AW;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;


vzcbeg bet.whavg.Grfg;
/*
Jneera Pbhagl, AW
Pbagnpg: Qnivq S <fcnaxreqnir69@tznvy.pbz>
Fraqre: JP911@pb.jneera.aw.hf

R94 NYREG: HAPBAFP 41 LBS 1623 JNEERA FG NYCUN OBEB (FRAG 09/16 19:29)\aPebff Fgerrgf -  6gu Nir & 7gu Nir\aNycun Obeb
R94 NYREG: JRNXARFF 56 LBS 108 NEEBJURNQ PG / FBHGU TNGR NCG 7Q CUVYYVCFOHET GBJA (FRAG 09/17 06:57)\aPebff Fgerrgf- Ybpx Fg\aGbja bs Cuvyyvcfohet
R94 NYREG: NOQBZ CA 79 LBS 408 FNVAG WNZRF NIR CBUNGPBAT GJC (FRAG 09/17 10:22)\aPebff Fgerrgf- Yvttrgg Oyiq & Crefuvat Nir\aCbungpbat Gjfc
R94 NYREG: NOQBZ CA 68 LBS 719 FNZCFBA NIR NYCUN OBEB (FRAG 09/17 14:42)\aPebff Fg- Crney Fg\aNycun Obeb
R94 NYREG: OYRRQVAT 6-7 LBZ ONEORE FPUBBY / 50 FNETRAG NIR / 525 FNETRAG NIR CUVYYVCFOHET GBJA (FRAG 09/17 11:25)\aPebff Fgerrgf- Pbeyvff Nir & Tenir Nir\aGbja bs Cuvyyvcfohet

*/

choyvp pynff AWJneeraPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp AWJneeraPbhaglCnefreGrfg() {
    frgCnefre(arj AWJneeraPbhaglCnefre(), "JNEERA PBHAGL", "AW");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre1() {

    qbGrfg("G1",
        "R94 NYREG: HAPBAFP 41 LBS 1623 JNEERA FG NYCUN OBEB (FRAG 09/16 19:29)\aPebff Fgerrgf -  6gu Nir & 7gu Nir\aNycun Obeb",
        "HAVG:R94",
        "PNYY:HAPBAFP 41 LBS",
        "NQQE:1623 JNEERA FG",
        "PVGL:NYCUN",
        "QNGR:09/16",
        "GVZR:19:29");

    qbGrfg("G2",
        "R94 NYREG: JRNXARFF 56 LBS 108 NEEBJURNQ PG / FBHGU TNGR NCG 7Q CUVYYVCFOHET GBJA (FRAG 09/17 06:57)\a" +
        "Pebff Fgerrgf- Ybpx Fg\a" +
        "Gbja bs Cuvyyvcfohet",

        "HAVG:R94",
        "PNYY:JRNXARFF 56 LBS",
        "NQQE:108 NEEBJURNQ PG & FBHGU TNGR",
        "ZNQQE:108 NEEBJURNQ PG",
        "NCG:7Q",
        "PVGL:CUVYYVCFOHET",
        "QNGR:09/17",
        "GVZR:06:57",
        "K:Ybpx Fg");

    qbGrfg("G3",
        "R94 NYREG: NOQBZ CA 79 LBS 408 FNVAG WNZRF NIR CBUNGPBAT GJC (FRAG 09/17 10:22)\a" +
        "Pebff Fgerrgf- Yvttrgg Oyiq & Crefuvat Nir\a" +
        "Cbungpbat Gjfc",

        "HAVG:R94",
        "PNYY:NOQBZ CA 79 LBS",
        "NQQE:408 FNVAG WNZRF NIR",
        "PVGL:CBUNGPBAT GJC",
        "QNGR:09/17",
        "GVZR:10:22",
        "K:Yvttrgg Oyiq & Crefuvat Nir");

    qbGrfg("G4",
        "R94 NYREG: NOQBZ CA 68 LBS 719 FNZCFBA NIR NYCUN OBEB (FRAG 09/17 14:42)\aPebff Fg- Crney Fg\aNycun Obeb",
        "HAVG:R94",
        "PNYY:NOQBZ CA 68 LBS",
        "NQQE:719 FNZCFBA NIR",
        "PVGL:NYCUN",
        "QNGR:09/17",
        "GVZR:14:42");

    qbGrfg("G5",
        "R94 NYREG: OYRRQVAT 6-7 LBZ ONEORE FPUBBY / 50 FNETRAG NIR / 525 FNETRAG NIR CUVYYVCFOHET GBJA (FRAG 09/17 11:25)\a" +
        "Pebff Fgerrgf- Pbeyvff Nir & Tenir Nir\a" +
        "Gbja bs Cuvyyvcfohet",

        "HAVG:R94",
        "PNYY:OYRRQVAT 6-7 LBZ ONEORE FPUBBY /",
        "NQQE:50 FNETRAG NIR & 525 FNETRAG NIR",
        "ZNQQE:50 FNETRAG NIR",
        "PVGL:CUVYYVCFOHET",
        "QNGR:09/17",
        "GVZR:11:25",
        "K:Pbeyvff Nir & Tenir Nir");

  }
    
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj AWJneeraPbhaglCnefreGrfg().trarengrGrfgf("G1", "HAVG PNYY NQQE NCG PVGL QNGR GVZR K");
  }
}