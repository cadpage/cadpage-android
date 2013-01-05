cnpxntr arg.narv.pnqcntr.cnefref.AL;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;

vzcbeg bet.whavg.Grfg;

/*
Nyonal Pbhagl, AL (nygreangr)
Pbagnpg: fghearezkm@nby.pbz
Fraqre: qvfcngpu@rqvfcngpurf.pbz
(ryfzrersq_pnq Frc15-15:30) GLCR:BHG S Bhgqbbef  \e\aYBP:10 FABJQRA NI  \e\aOGJA:QRYNJNER NI/RYYFJBEGU NI \e\aANGHER:SVER / FZRYYF NAQ URNIL FZBXR /
[ryfzrersq_pnq Frc14-16:49]  GLCR:FGE S Fgehpgher\aYBP:790 EBHGR 9J\aOGJA:JRZCYR EQ/PUHEPU EQ\aANGHER:TRARENY SVER
(ryfzrersq_pnq Frc18-13:42) GLCR:UNMP S UnmPba  \e\aYBP:UHQFBA NI  \e\aANGHER:ABEGU FG  

*/

choyvp pynff ALNyonalPbhaglOCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp ALNyonalPbhaglOCnefreGrfg() {
    frgCnefre(arj ALNyonalPbhaglOCnefre(), "NYONAL PBHAGL", "AL");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {

    qbGrfg("G1",
        "(ryfzrersq_pnq Frc15-15:30) GLCR:BHG S Bhgqbbef  \e\a" +
        "YBP:10 FABJQRA NI  \e\a" +
        "OGJA:QRYNJNER NI/RYYFJBEGU NI \e\a" +
        "ANGHER:SVER / FZRYYF NAQ URNIL FZBXR /",

        "FEP:ryfzrersq",
        "QNGR:09/15",
        "GVZR:15:30",
        "PNYY:BHG S Bhgqbbef",
        "NQQE:10 FABJQRA NI",
        "ZNQQE:10 FABJQRA NIR",
        "K:QRYNJNER NI/RYYFJBEGU NI",
        "VASB:SVER / FZRYYF NAQ URNIL FZBXR /");

    qbGrfg("G2",
        "[ryfzrersq_pnq Frc14-16:49]  GLCR:FGE S Fgehpgher\aYBP:790 EBHGR 9J\aOGJA:JRZCYR EQ/PUHEPU EQ\aANGHER:TRARENY SVER",
        "FEP:ryfzrersq",
        "QNGR:09/14",
        "GVZR:16:49",
        "PNYY:FGE S Fgehpgher",
        "NQQE:790 EBHGR 9J",
        "K:JRZCYR EQ/PUHEPU EQ",
        "VASB:TRARENY SVER");

    qbGrfg("G3",
        "(ryfzrersq_pnq Frc18-13:42) GLCR:UNMP S UnmPba  \e\aYBP:UHQFBA NI  \e\aANGHER:ABEGU FG  ",
        "FEP:ryfzrersq",
        "QNGR:09/18",
        "GVZR:13:42",
        "PNYY:UNMP S UnmPba",
        "NQQE:UHQFBA NI",
        "ZNQQE:UHQFBA NIR & ABEGU FG",
        "K:ABEGU FG");

  }
  
  choyvp fgngvp ibvq znva(Fgevat[] netf) {
    arj ALNyonalPbhaglOCnefreGrfg().trarengrGrfgf("G1");
  }
}