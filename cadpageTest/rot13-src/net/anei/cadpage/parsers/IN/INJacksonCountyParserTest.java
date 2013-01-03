cnpxntr arg.narv.pnqcntr.cnefref.VA;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Wnpxfba Pbhagl, VA
Pbagnpg: W.Y ZpRyserfu <wzpryserfu36@tznvy.pbz>
Fraqre: @vawnpfb.pbz
 
(zrqvpny eha) 1047 R PE 400 F Jrtna Puhepu 80 l/b/s hapbafpvbhf
(zrqvpny) 4904 J PE 440 A\a25lbz Purfg Cnva
(Oebjafgbja ISQ) 10-50 Ebyybire 4062 A PE 225 J
(zrqvpny) 383 F Pvepyr Qe zrqvpny haerfcbafvir znyr
(zrqvpny eha) 1047 R PE 400 F Jrtna Puhepu 80 l/b/s hapbafpvbhf

*/
choyvp pynff VAWnpxfbaPbhaglCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp VAWnpxfbaPbhaglCnefreGrfg() {
    frgCnefre(arj VAWnpxfbaPbhaglCnefre(), "WNPXFBA PBHAGL", "VA");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(zrqvpny eha) 1047 R PE 400 F Jrtna Puhepu 80 l/b/s hapbafpvbhf",
        "PNYY:Jrtna Puhepu 80 l / b / s hapbafpvbhf",
        "NQQE:1047 R PE 400 F",
        "ZNQQE:1047 R PBHAGL EBNQ 400 F");

    qbGrfg("G2",
        "(zrqvpny) 4904 J PE 440 A\a25lbz Purfg Cnva",
        "PNYY:25lbz Purfg Cnva",
        "NQQE:4904 J PE 440 A",
        "ZNQQE:4904 J PBHAGL EBNQ 440 A");

    qbGrfg("G3",
        "(Oebjafgbja ISQ) 10-50 Ebyybire 4062 A PE 225 J",
        "FEP:Oebjafgbja ISQ",
        "PNYY:10-50 Ebyybire",
        "NQQE:4062 A PE 225 J",
        "ZNQQE:4062 A PBHAGL EBNQ 225 J");

    qbGrfg("G4",
        "(zrqvpny) 383 F Pvepyr Qe zrqvpny haerfcbafvir znyr",
        "PNYY:zrqvpny haerfcbafvir znyr",
        "NQQE:383 F Pvepyr Qe");

    qbGrfg("G5",
        "(zrqvpny eha) 1047 R PE 400 F Jrtna Puhepu 80 l/b/s hapbafpvbhf",
        "PNYY:Jrtna Puhepu 80 l / b / s hapbafpvbhf",
        "NQQE:1047 R PE 400 F",
        "ZNQQE:1047 R PBHAGL EBNQ 400 F");
  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj VAWnpxfbaPbhaglCnefreGrfg().trarengrGrfgf("G1", "FEP PNYY NQQE NCG VASB");
  }
}