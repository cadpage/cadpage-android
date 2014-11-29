cnpxntr arg.narv.pnqcntr.cnefref.BU;

vzcbeg arg.narv.pnqcntr.cnefref.OnfrCnefreGrfg;
vzcbeg arg.narv.pnqcntr.cnefref.BU.BUFhtnePerrxCnefre;

vzcbeg bet.whavg.Grfg;

/*
FhtnePerrx, BU
pbagnpg: Wba Svfure <fgsq26@pyrnejver.arg>
fraqre: PNQ@fhtneperrxgbjafuvc.pbz <Sebz%3NPNQ@fhtneperrxgbjafuvc.pbz>

"Pg:RZF ZVABE       Ybp:4336 FGNGR EG 725            Ncg:      KFg:ONLOREEL PBIR Q YNXRZNA QE      Tevq:003S Havgf:72                                        Ezx:"
"Pg:SVER NYNEZ - ER Ybp:4334 XVYYVNA PG              Ncg:      KFg:ORYSNFG QE                      Tevq:0001 Havgf:Z71   O70   C219                          Ezx:"
"Pg:RZF ZVABE       Ybp:V 675 A/8ZZ                  Ncg:      KFg:JVYZVATGBA CVXR SRRQJVER EQ     Tevq:0045 Havgf:72                                        Ezx:"
"Pg:GENSSVP NPPVQRA Ybp:SRRQJVER EQ/JVAFUVER GRE     Ncg:      KFg:YVGGYR FHTNEPER YRQTRFGBAR OYIQ Tevq:0002 Havgf:P70   O70   R71   Z72   C228              Ezx:"
"Pg:BGURE SVER      Ybp:5980 JVYZVATGBA CVXR         Ncg:      KFg:PYLB EQ         JVYZVATGBA CVXR Tevq:003N Havgf:72                                        Ezx:"
Pg:RZF ZVABE       Ybp:6244 JVYZVATGBA CVXR         Ncg:      KFg:PYLB EQ         PRAGRE CBVAG QE Tevq:003O Havgf:R74   Z72   E70   C241 
***/

choyvp pynff BUFhtnePerrxCnefreGrfg rkgraqf OnfrCnefreGrfg {
  
  choyvp BUFhtnePerrxCnefreGrfg() {
    frgCnefre(arj BUFhtnePerrxCnefre(), "FhtnePerrx", "BU");
  }
  
  @Grfg
  choyvp ibvq grfgCnefre() {
    
    qbGrfg("G1",
        "Pg:RZF ZVABE       Ybp:4336 FGNGR EG 725            Ncg:      KFg:ONLOREEL PBIR Q YNXRZNA QE      Tevq:003S Havgf:72                                        Ezx:",
        "PNYY:RZF ZVABE",
        "K:ONLOREEL PBIR QE / YNXRZNA QE",
        "ZNC:003S",
        "NQQE:4336 FGNGR EG 725",
        "ZNQQE:4336 FGNGR 725",
        "HAVG:72"
        );

    qbGrfg("G2",
        "Pg:SVER NYNEZ - ER Ybp:4334 XVYYVNA PG              Ncg:      KFg:ORYSNFG QE                      Tevq:0001 Havgf:Z71   O70   C219                          Ezx:",
        "PNYY:SVER NYNEZ - ER",
        "ZNC:0001",
        "K:ORYSNFG QE",
        "HAVG:Z71 O70 C219",
        "NQQE:4334 XVYYVNA PG"
        );
    
    qbGrfg("G3",
        "Pg:RZF ZVABE       Ybp:V 675 A/8ZZ                  Ncg:      KFg:JVYZVATGBA CVXR SRRQJVER EQ     Tevq:0045 Havgf:72                                        Ezx:",
        "PNYY:RZF ZVABE",
        "NQQE:V 675 A & 8ZZ",
        "K:JVYZVATGBA CVXR / SRRQJVER EQ",
        "ZNC:0045",
        "HAVG:72"
        );
    
    qbGrfg("G4",
        "Pg:GENSSVP NPPVQRA Ybp:SRRQJVER EQ/JVAFUVER GRE     Ncg:      KFg:YVGGYR FHTNEPER YRQTRFGBAR OYIQ Tevq:0002 Havgf:P70   O70   R71   Z72   C228              Ezx:",
        "PNYY:GENSSVP NPPVQRA",
        "NQQE:SRRQJVER EQ & JVAFUVER GRE",
        "K:YVGGYR FHTNEPER / YRQTRFGBAR OYIQ",
        "ZNC:0002",
        "HAVG:P70 O70 R71 Z72 C228"
        );
    
    qbGrfg("G5",
        "Pg:BGURE SVER      Ybp:5980 JVYZVATGBA CVXR         Ncg:      KFg:PYLB EQ         JVYZVATGBA CVXR Tevq:003N Havgf:72                                        Ezx:",
        "PNYY:BGURE SVER",
        "K:PYLB EQ / JVYZVATGBA CVXR",
        "ZNC:003N",
        "NQQE:5980 JVYZVATGBA CVXR",
        "HAVG:72"
        );
    
    qbGrfg("G6",
        "Pg:RZF ZVABE       Ybp:6244 JVYZVATGBA CVXR         Ncg:      KFg:PYLB EQ         PRAGRE CBVAG QE Tevq:003O Havgf:R74   Z72   E70   C241",
        "PNYY:RZF ZVABE",
        "K:PYLB EQ / PRAGRE CBVAG QE",
        "ZNC:003O",
        "NQQE:6244 JVYZVATGBA CVXR",
        "HAVG:R74 Z72 E70 C241");
        
    
  }
}
