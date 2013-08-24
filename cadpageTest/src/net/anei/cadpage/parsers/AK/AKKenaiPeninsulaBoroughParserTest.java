package net.anei.cadpage.parsers.AK;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kenai Peninsula Borough, AK

Agency name: Nikiski Fire Department
Location: Nikiski, AK, United States
Contact: Active911
Sender: Disp-CES@borough.kenai.ak.us

(911 Rip And Run Service) Location: \r\nBEHIND THE POOR HOUSE \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n69-STRUCTURE FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n69-D-05\r\r\n
(911 Rip And Run Service) Location: \r\n264 UPPER ROSIAN DR \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nW LONDON ROSE CIR / DEAD END\r\n\r\n\r\nCall Type: \r\n17-FALLS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n17-D-03\r\r\n
(911 Rip And Run Service) Location: \r\nMAP SHOP \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n24032 WEBB RAMSELL RD \r\n  KASILOF\r\n, AK\r\n\r\nCross Streets: \r\n\r\nFOX DR / SHIAK ST\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n60.5330705955000000 -150.4798026600000000 \r\n, AK\r\n\r\nCross Streets: \r\n\r\nSTERLING HWY\r\nSKILAK LAKE RD / SKILAK LAKE RD\r\nSTERLING HWY\r\n\r\n\r\nCall Type: \r\nVID\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n38350 HOMEWOOD AVE 2627175\r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nROBINSON LOOP RD / BIRKENWEG ST\r\n\r\n\r\nCall Type: \r\n10-CHEST PAIN\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n10-C-01\r\r\n
(911 Rip And Run Service) Location: \r\n48075 ARCHIE DR \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nEVEN LN / DEAD END\r\n\r\n\r\nCall Type: \r\n11-CHOKING\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n11-D-01\r\r\n
(911 Rip And Run Service) Location: \r\nKENAI KEYS RD \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n3-ANIMAL BITES/ATTACKS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n03-B-02\r\r\n
(911 Rip And Run Service) Location: \r\n51035 DOROTHY AVE \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n55-ELECTRICAL HAZARD\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n55-B-02\r\r\n
(911 Rip And Run Service) Location: \r\nCES STATION STERLING \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n10-CHEST PAIN\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n19-C-03\r\r\n
(911 Rip And Run Service) Location: \r\n34525 COMMERCE ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nVIRGO CT / MERRYWOOD AVE\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nSUNRISE ASSISTED LIVING \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n31-UNCONSCIOUS/FAINTING(NEAR)\r\n\r\n\r\nConscious: \r\nNO;\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n31-D-01\r\r\n
(911 Rip And Run Service) Location: \r\n308 W LONDON ROSE CIR \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-D-02\r\r\n
(911 Rip And Run Service) Location: \r\nRABBIT RUN RD \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n--\r\n11/1\r\n
(911 Rip And Run Service) Location: \r\n298 REDWOOD CT \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n12-CONVULSIONS/SEIZURES\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n12-A-01E\r\n
(911 Rip And Run Service) Location: \r\nSALS KLONDIKE DINER \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n32-UNKNOWN PROBLEM (MAN DOWN)\r\n\r\n\r\nConscious: \r\nUNK\r\n\r\nBreathing:\r\nUNC\r\n\r\nDispatch Code:\r\n32-D-01\r\n
(911 Rip And Run Service) Location: \r\n39180 FARVIEW ST \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / MISTY MORNING AVE\r\n\r\n\r\nCall Type: \r\n21-HEMORRHAGE/LACERATIONS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n21-B-04\r\r\n
(911 Rip And Run Service) Location: \r\n60.5240007668000000 -150.8767482150000000 \r\n, AK\r\n\r\nCross Streets: \r\n\r\nCRANE SONG ST\r\nSTERLING HWY / EVERGREEN DR\r\nSTERLING HWY\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n33090 GAS WELL RD \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nRUSTIC AVE / HENRY AVE\r\n\r\n\r\nCall Type: \r\n23-OVERDOSE/POISONING\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n23-C-07V\r\n
(911 Rip And Run Service) Location: \r\n247 N FIREWEED ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nW KATMAI AVE / W ROCKWELL AVE\r\n\r\n\r\nCall Type: \r\n32-UNKNOWN PROBLEM (MAN DOWN)\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n32-B-03\r\r\n
(911 Rip And Run Service) Location: \r\n36370 BORE TIDE CT \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / KALGIN DR\r\nBORE TIDE DR\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n26-A-07\r\r\n
(911 Rip And Run Service) Location: \r\n40396 ILIAMNA LOOP \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nFRONTAGE RD / FRONTAGE RD\r\n\r\n\r\nCall Type: \r\n69-STRUCTURE FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n69-D-06\r\r\n
(911 Rip And Run Service) Location: \r\nREDOUBT EL \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n26-SICK PERSON\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n26-D-01\r\r\n
(911 Rip And Run Service) Location: \r\n34555 JABILA DR \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / YESVA LN\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n198 W RIVERVIEW AVE \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nS FIREWEED ST / HILLCREST AVE\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n47109 TOBACCO LN \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nSWAMP ST / MISSING LINK RD\r\n\r\n\r\nCall Type: \r\n31-UNCONSCIOUS/FAINTING(NEAR)\r\n\r\n\r\nConscious: \r\nNO;\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n31-C-02\r\r\n
(911 Rip And Run Service) Location: \r\n35825 ELLIE CIRCLE \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n27-STAB/GUNSHOT\r\n\r\n\r\nConscious: \r\nNO;\r\n\r\nBreathing:\r\nUNC\r\n\r\nDispatch Code:\r\n27-D-01G\r\n
(911 Rip And Run Service) Location: \r\n156 COLLEGE RD \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nALARM- FIRE/BURG\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n38600 HOMEWOOD AVE \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nBIRKENWEG ST / NORDLICHT ST\r\n\r\n\r\nCall Type: \r\n<NEW CALL>\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nNORTH OF BIG JOHNS \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nMVC-I\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n60.4847820000000000 -151.0688960000000000 \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nUNKNOWN / LITTLE AVE\r\nROBIN PL\r\n\r\n\r\nCall Type: \r\n52-ALARMS\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n52-C-03G\r\n
(911 Rip And Run Service) Location: \r\n50290 STERLING HWY \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nCHARLAND DR / GOLDDUST DR\r\n\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-D-03\r\r\n
(911 Rip And Run Service) Location: \r\nCITY HALL \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-D-01\r\r\n
(911 Rip And Run Service) Location: \r\n<UNKNOWN> \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nMI 123.7 STERLING \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-D-02\r\r\n
(911 Rip And Run Service) Location: \r\n46775 PINTAIL AVE \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nWREN DR / PELICAN RD\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n425 W MARYDALE AVE \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nRIDGEWOOD DR / SOHI LN\r\n\r\n\r\nCall Type: \r\nMVC-D\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n46645 ROOSEVELT AVE \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nPHYLLIS CIR / CONSTITUTION ST\r\n\r\n\r\nCall Type: \r\n17-FALLS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n17-B-01G\r\n
(911 Rip And Run Service) Location: \r\nCPH ER 4\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n<NEW CALL>\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nGROVE AVE \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nDISTURBANCE OTHER\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n36601 NAVIGATOR ST \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n38359 MARILEE ST B1\r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nJIM AVE / STERLING HWY\r\n\r\n\r\nCall Type: \r\nWELFARE CHECK\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n36601 NAVIGATOR ST \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nHELMSMAN AVE / OCEAN ENTRANCE DR\r\n\r\n\r\nCall Type: \r\n26-SICK PERSON\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n26-A-01\r\n
(911 Rip And Run Service) Location: \r\nCPH TO SOLE AIRPORT \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nBEHIND BUCKETS \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n168 W PARK AVE 5\r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nN FIREWEED ST / N BINKLEY ST\r\nE PARK AVE\r\n\r\n\r\nCall Type: \r\nALARM- FIRE/BURG\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n330 COLUMBINE ST B12\r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nW MARYDALE AVE / LUPINE ST\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n38359 MARILEE ST B1\r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nJIM AVE / STERLING HWY\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n264 UPPER ROSIAN DR \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nW LONDON ROSE CIR / DEAD END\r\n\r\n\r\nCall Type: \r\n26-SICK PERSON\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n26-C-02\r\r\n
(911 Rip And Run Service) Location: \r\n<UNKNOWN> \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL ASSIST\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nROOM 9 ER TO SOLDOTNA AIRPORT \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n46476 CIECHANSKI RD \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nPERFECT ENDING ST / STANFORD ST\r\n\r\n\r\nCall Type: \r\n17-FALLS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n17-A-03G\r\n
(911 Rip And Run Service) Location: \r\n60808 STERLING HWY \r\n  COHOE\r\n, AK\r\n\r\nCross Streets: \r\n\r\nBLUE RIBBON AVE / COHOE LOOP RD\r\n\r\n\r\nCall Type: \r\n17-FALLS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n17-A-01G\r\n
(911 Rip And Run Service) Location: \r\n289 N FIREWEED ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nW MARYDALE AVE / W ROCKWELL AVE\r\n\r\n\r\nCall Type: \r\n19-HEART PROBLEMS/A.I.C.D\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n19-D-01\r\r\n
(911 Rip And Run Service) Location: \r\n36430 PUFFIN ST \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nGADWALL AVE / MERGANSER AVE\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n GAS WELL/ KBEACH\r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n5-BACK PAIN\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n05-C-03\r\r\n
(911 Rip And Run Service) Location: \r\n53321 STOL RO \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-D-04\r\r\n
(911 Rip And Run Service) Location: \r\n36195 IRONS DR \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n28-C-11F\r\n
(911 Rip And Run Service) Location: \r\n33095 JOEY CT \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n69-STRUCTURE FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n69-D-06\r\r\n
(911 Rip And Run Service) Location: \r\n48339 DJS DR \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / STERLING HWY\r\n\r\n\r\nCall Type: \r\n<NEW CALL>\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n60.5243097676000000 -149.6543220880000000 \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n60.4733600000000000 -151.1533140000000000 \r\nADDITIONAL LOCATION INFORMATION:W SECTOR\r\n, AK\r\n\r\nCross Streets: \r\n\r\nGAS WELL RD\r\nECHO LAKE RD / GAS WELL RD\r\nKALIFORNSKY BEACH RD\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nWILSON IN FRONT OF FOSTERS \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n12-CONVULSIONS/SEIZURES\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n12-D-04E\r\n
(911 Rip And Run Service) Location: \r\n33130 BAYLOR ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nRENSSELAER LN / JEFFERSON AVE\r\n\r\n\r\nCall Type: \r\n31-UNCONSCIOUS/FAINTING(NEAR)\r\n\r\n\r\nConscious: \r\nNO;\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n31-D-01\r\r\n
(911 Rip And Run Service) Location: \r\n60.5316555084000000 -150.4212824840000000 \r\n  SALAMATOF\r\n, AK\r\n\r\nCross Streets: \r\n\r\nSTERLING HWY\r\nSKILAK LAKE RD / SKILAK LAKE RD\r\nSTERLING HWY\r\n\r\n\r\nCall Type: \r\n<NEW CALL>\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nVAUGNS MINI MART \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n25-PSYCHIATRIC/SUICIDE ATTEMPT\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n34133 MATANUSKA ST \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n52-ALARMS\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n52-B-01C\r\n
(911 Rip And Run Service) Location: \r\n35879 TERESA WAY \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n10-CHEST PAIN\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n10-C-02\r\r\n
(911 Rip And Run Service) Location: \r\n34146 KHAMSIN ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nFOEHN CT / SIROCCO DR\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n156 COLLEGE RD \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nPOPPY RIDGE RD\r\nE POPPY LN / CHUGACH DR\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nCARDWELL RD \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\n12-CONVULSIONS/SEIZURES\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n12-A-02\r\n
(911 Rip And Run Service) Location: \r\n23160 LOWELL LOOP \r\n  KASILOF\r\n, AK\r\n\r\nCross Streets: \r\n\r\nRILINDA RD / RILINDA RD\r\n\r\n\r\nCall Type: \r\n31-UNCONSCIOUS/FAINTING(NEAR)\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n31-C-02\r\r\n
(911 Rip And Run Service) Location: \r\n230 E MARYDALE AVE \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n17-FALLS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n17-A-01G\r\n
(911 Rip And Run Service) Location: \r\n247 N FIREWEED ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nW KATMAI AVE / W ROCKWELL AVE\r\n\r\n\r\nCall Type: \r\n33-TRANSFER/INTERFACILITY\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n33-C-02T\r\n
(911 Rip And Run Service) Location: \r\n48480 DAISY AVE \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n31-UNCONSCIOUS/FAINTING(NEAR)\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n31-C-01\r\n
(911 Rip And Run Service) Location: \r\n425 W MARYDALE AVE \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nALARM- FIRE/BURG\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n38809 MCDOWELL RD \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nSTASSI LN / FALLHAVEN LN\r\n\r\n\r\nCall Type: \r\nCOMFORT ONE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n34965 YALE ST 1\r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nRAVENWOOD ST\r\nE POPPY LN / PRINCETON AVE\r\n\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-C-01\r\r\n
(911 Rip And Run Service) Location: \r\n30793 ECHO LAKE RD \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n38809 MCDOWELL RD \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nSTASSI LN / FALLHAVEN LN\r\n\r\n\r\nCall Type: \r\n6-BREATHING PROBLEMS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n06-D-01\r\r\n
(911 Rip And Run Service) Location: \r\n35482 KENAI SPUR HWY \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n35135 WATER FRONT WAY \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nWHARF AVE / RIVER DR\r\n\r\n\r\nCall Type: \r\n26-SICK PERSON\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n26-C-02\r\r\n
(911 Rip And Run Service) Location: \r\n250 HOSPITAL PL 1\r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n109 N BIRCH ST B\r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nE REDOUBT AVE\r\nS BIRCH ST / SHADY LN\r\n\r\n\r\nCall Type: \r\n17-FALLS\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n17-B-01G\r\n
(911 Rip And Run Service) Location: \r\n250 HOSPITAL PL \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / W MARYDALE AVE\r\n\r\n\r\nCall Type: \r\n18-HEADACHE\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n18-C-04\r\r\n
(911 Rip And Run Service) Location: \r\n39180 FARVIEW ST \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / MISTY MORNING AVE\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n12-C-04\r\n
(911 Rip And Run Service) Location: \r\n34610 SILVER WEED ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / WHISPER WAY\r\n\r\n\r\nCall Type: \r\nALARM- FIRE/BURG\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nCPH ER ROOM 6 TO STERLING \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nCPH ER 17\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nJOHNS ROAD \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n67-OUTSIDE FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n67-B-03U\r\n
(911 Rip And Run Service) Location: \r\n286 SUNRISE CT \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n60-GAS LEAK/GAS ODOR\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\n60-B-02O\r\n
(911 Rip And Run Service) Location: \r\n39180 FARVIEW ST \r\n  STERLING\r\n, AK\r\n\r\nCross Streets: \r\n\r\nDEAD END / MISTY MORNING AVE\r\n\r\n\r\nCall Type: \r\n12-CONVULSIONS/SEIZURES\r\n\r\n\r\nConscious: \r\nYES\r\n\r\nBreathing:\r\nYES\r\n\r\nDispatch Code:\r\n12-D-03\r\r\n
(911 Rip And Run Service) Location: \r\n34901 DANA BAYES ST \r\n  SOLDOTNA\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\n<NEW CALL>\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n73 STERLING HWY \r\n  HOMER\r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMVC-I\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n14 KBEACH \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nAPPROX 14 K-BEACH RD \r\n, AK\r\n\r\nCross Streets: \r\nUnknown\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n50235 ONSLOW AVE \r\n  KENAI\r\n, AK\r\n\r\nCross Streets: \r\n\r\nBJERKE ST / EASTWAY RD\r\n\r\n\r\nCall Type: \r\nMEDICAL ASSIST\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n48494 SANDHILL CRANE LOOP \r\n  KASILOF\r\n, AK\r\n\r\nCross Streets: \r\n\r\nKALEA AVE / KOSHNEY LN\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\n354 TYEE LN C\r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nSUICIDE ATTEMPT\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n
(911 Rip And Run Service) Location: \r\nSANDHILL CRANE LOOP \r\n, AK\r\n\r\nCross Streets: \r\n\r\n\r\n\r\nCall Type: \r\nMEDICAL/FIRE\r\n\r\n\r\nConscious: \r\nUnknown\r\n\r\nBreathing:\r\nUnknown\r\n\r\nDispatch Code:\r\nUnknown\r\n

*/

public class AKKenaiPeninsulaBoroughParserTest extends BaseParserTest {
  
  public AKKenaiPeninsulaBoroughParserTest() {
    setParser(new AKKenaiPeninsulaBoroughParser(), "KENAI PENINSULA BOROUGH", "AK");
  }
  
  @Test
  public void testNikiskiFire() {

    doTest("T1",
        "(911 Rip And Run Service) Location: \r\n" +
        "BEHIND THE POOR HOUSE \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "69-STRUCTURE FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "69-D-05\r\r\n",

        "ADDR:BEHIND THE POOR HOUSE",
        "CODE:69-D-05",
        "CALL:STRUCTURE FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T2",
        "(911 Rip And Run Service) Location: \r\n" +
        "264 UPPER ROSIAN DR \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "W LONDON ROSE CIR / DEAD END\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "17-FALLS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "17-D-03\r\r\n",

        "ADDR:264 UPPER ROSIAN DR",
        "CITY:SOLDOTNA",
        "X:W LONDON ROSE CIR / DEAD END",
        "CODE:17-D-03",
        "CALL:FALLS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T3",
        "(911 Rip And Run Service) Location: \r\n" +
        "MAP SHOP \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:MAP SHOP",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T4",
        "(911 Rip And Run Service) Location: \r\n" +
        "24032 WEBB RAMSELL RD \r\n" +
        "  KASILOF\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "FOX DR / SHIAK ST\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:24032 WEBB RAMSELL RD",
        "CITY:KASILOF",
        "X:FOX DR / SHIAK ST",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T5",
        "(911 Rip And Run Service) Location: \r\n" +
        "60.5330705955000000 -150.4798026600000000 \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "STERLING HWY\r\n" +
        "SKILAK LAKE RD / SKILAK LAKE RD\r\n" +
        "STERLING HWY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "VID\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:60.5330705955000000 -150.4798026600000000",
        "MADDR:+60.533071,-150.479803",
        "X:STERLING HWY / SKILAK LAKE RD",
        "CALL:VID",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T6",
        "(911 Rip And Run Service) Location: \r\n" +
        "38350 HOMEWOOD AVE 2627175\r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "ROBINSON LOOP RD / BIRKENWEG ST\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "10-CHEST PAIN\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "10-C-01\r\r\n",

        "ADDR:38350 HOMEWOOD AVE",
        "PHONE:2627175",
        "CITY:STERLING",
        "X:ROBINSON LOOP RD / BIRKENWEG ST",
        "CODE:10-C-01",
        "CALL:CHEST PAIN",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T7",
        "(911 Rip And Run Service) Location: \r\n" +
        "48075 ARCHIE DR \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "EVEN LN / DEAD END\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "11-CHOKING\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "11-D-01\r\r\n",

        "ADDR:48075 ARCHIE DR",
        "CITY:KENAI",
        "X:EVEN LN / DEAD END",
        "CODE:11-D-01",
        "CALL:CHOKING",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T8",
        "(911 Rip And Run Service) Location: \r\n" +
        "KENAI KEYS RD \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "3-ANIMAL BITES/ATTACKS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "03-B-02\r\r\n",

        "ADDR:KENAI KEYS RD",
        "CODE:03-B-02",
        "CALL:ANIMAL BITES/ATTACKS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T9",
        "(911 Rip And Run Service) Location: \r\n" +
        "51035 DOROTHY AVE \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "55-ELECTRICAL HAZARD\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "55-B-02\r\r\n",

        "ADDR:51035 DOROTHY AVE",
        "CODE:55-B-02",
        "CALL:ELECTRICAL HAZARD",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T10",
        "(911 Rip And Run Service) Location: \r\n" +
        "CES STATION STERLING \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "10-CHEST PAIN\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "19-C-03\r\r\n",

        "ADDR:CES STATION STERLING",
        "CODE:19-C-03",
        "CALL:CHEST PAIN",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T11",
        "(911 Rip And Run Service) Location: \r\n" +
        "34525 COMMERCE ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "VIRGO CT / MERRYWOOD AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:34525 COMMERCE ST",
        "CITY:SOLDOTNA",
        "X:VIRGO CT / MERRYWOOD AVE",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T12",
        "(911 Rip And Run Service) Location: \r\n" +
        "SUNRISE ASSISTED LIVING \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "31-UNCONSCIOUS/FAINTING(NEAR)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "NO;\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "31-D-01\r\r\n",

        "ADDR:SUNRISE ASSISTED LIVING",
        "CODE:31-D-01",
        "CALL:UNCONSCIOUS/FAINTING(NEAR)",
        "INFO:Conscious: NO;\nBreathing: YES");

    doTest("T13",
        "(911 Rip And Run Service) Location: \r\n" +
        "308 W LONDON ROSE CIR \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-D-02\r\r\n",

        "ADDR:308 W LONDON ROSE CIR",
        "CITY:SOLDOTNA",
        "CODE:06-D-02",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T14",
        "(911 Rip And Run Service) Location: \r\n" +
        "RABBIT RUN RD \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "--\r\n" +
        "11/1\r\n",

        "ADDR:RABBIT RUN RD",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T15",
        "(911 Rip And Run Service) Location: \r\n" +
        "298 REDWOOD CT \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "12-CONVULSIONS/SEIZURES\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "12-A-01E\r\n",

        "ADDR:298 REDWOOD CT",
        "CITY:SOLDOTNA",
        "CODE:12-A-01E",
        "CALL:CONVULSIONS/SEIZURES",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T16",
        "(911 Rip And Run Service) Location: \r\n" +
        "SALS KLONDIKE DINER \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "32-UNKNOWN PROBLEM (MAN DOWN)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "UNK\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "UNC\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "32-D-01\r\n",

        "ADDR:SALS KLONDIKE DINER",
        "CODE:32-D-01",
        "CALL:UNKNOWN PROBLEM (MAN DOWN)",
        "INFO:Conscious: UNK\nBreathing: UNC");

    doTest("T17",
        "(911 Rip And Run Service) Location: \r\n" +
        "39180 FARVIEW ST \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / MISTY MORNING AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "21-HEMORRHAGE/LACERATIONS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "21-B-04\r\r\n",

        "ADDR:39180 FARVIEW ST",  // Map failure
        "CITY:STERLING",
        "X:DEAD END / MISTY MORNING AVE",
        "CODE:21-B-04",
        "CALL:HEMORRHAGE/LACERATIONS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T18",
        "(911 Rip And Run Service) Location: \r\n" +
        "60.5240007668000000 -150.8767482150000000 \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "CRANE SONG ST\r\n" +
        "STERLING HWY / EVERGREEN DR\r\n" +
        "STERLING HWY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:60.5240007668000000 -150.8767482150000000",
        "MADDR:+60.524001,-150.876748",
        "X:CRANE SONG ST / STERLING HWY / EVERGREEN DR",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T19",
        "(911 Rip And Run Service) Location: \r\n" +
        "33090 GAS WELL RD \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "RUSTIC AVE / HENRY AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "23-OVERDOSE/POISONING\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "23-C-07V\r\n",

        "ADDR:33090 GAS WELL RD",
        "CITY:SOLDOTNA",
        "X:RUSTIC AVE / HENRY AVE",
        "CODE:23-C-07V",
        "CALL:OVERDOSE/POISONING",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T20",
        "(911 Rip And Run Service) Location: \r\n" +
        "247 N FIREWEED ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "W KATMAI AVE / W ROCKWELL AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "32-UNKNOWN PROBLEM (MAN DOWN)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "32-B-03\r\r\n",

        "ADDR:247 N FIREWEED ST",
        "CITY:SOLDOTNA",
        "X:W KATMAI AVE / W ROCKWELL AVE",
        "CODE:32-B-03",
        "CALL:UNKNOWN PROBLEM (MAN DOWN)",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T21",
        "(911 Rip And Run Service) Location: \r\n" +
        "36370 BORE TIDE CT \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / KALGIN DR\r\n" +
        "BORE TIDE DR\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "26-A-07\r\r\n",

        "ADDR:36370 BORE TIDE CT",
        "CITY:KENAI",
        "X:DEAD END / KALGIN DR / BORE TIDE DR",
        "CODE:26-A-07",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T22",
        "(911 Rip And Run Service) Location: \r\n" +
        "40396 ILIAMNA LOOP \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "FRONTAGE RD / FRONTAGE RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "69-STRUCTURE FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "69-D-06\r\r\n",

        "ADDR:40396 ILIAMNA LOOP",
        "CITY:SOLDOTNA",
        "X:FRONTAGE RD",
        "CODE:69-D-06",
        "CALL:STRUCTURE FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T23",
        "(911 Rip And Run Service) Location: \r\n" +
        "REDOUBT EL \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "26-SICK PERSON\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "26-D-01\r\r\n",

        "ADDR:REDOUBT EL",
        "CODE:26-D-01",
        "CALL:SICK PERSON",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T24",
        "(911 Rip And Run Service) Location: \r\n" +
        "34555 JABILA DR \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / YESVA LN\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:34555 JABILA DR",  // Not mapping
        "CITY:SOLDOTNA",
        "X:DEAD END / YESVA LN",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T25",
        "(911 Rip And Run Service) Location: \r\n" +
        "198 W RIVERVIEW AVE \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "S FIREWEED ST / HILLCREST AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:198 W RIVERVIEW AVE",
        "CITY:SOLDOTNA",
        "X:S FIREWEED ST / HILLCREST AVE",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T26",
        "(911 Rip And Run Service) Location: \r\n" +
        "47109 TOBACCO LN \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "SWAMP ST / MISSING LINK RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "31-UNCONSCIOUS/FAINTING(NEAR)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "NO;\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "31-C-02\r\r\n",

        "ADDR:47109 TOBACCO LN",
        "CITY:SOLDOTNA",
        "X:SWAMP ST / MISSING LINK RD",
        "CODE:31-C-02",
        "CALL:UNCONSCIOUS/FAINTING(NEAR)",
        "INFO:Conscious: NO;\nBreathing: YES");

    doTest("T27",
        "(911 Rip And Run Service) Location: \r\n" +
        "35825 ELLIE CIRCLE \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "27-STAB/GUNSHOT\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "NO;\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "UNC\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "27-D-01G\r\n",

        "ADDR:35825 ELLIE CIRCLE",  // Not mapping
        "CODE:27-D-01G",
        "CALL:STAB/GUNSHOT",
        "INFO:Conscious: NO;\nBreathing: UNC");

    doTest("T28",
        "(911 Rip And Run Service) Location: \r\n" +
        "156 COLLEGE RD \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "ALARM- FIRE/BURG\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:156 COLLEGE RD",
        "CITY:SOLDOTNA",
        "CALL:ALARM- FIRE/BURG",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T29",
        "(911 Rip And Run Service) Location: \r\n" +
        "38600 HOMEWOOD AVE \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "BIRKENWEG ST / NORDLICHT ST\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "<NEW CALL>\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:38600 HOMEWOOD AVE",
        "CITY:STERLING",
        "X:BIRKENWEG ST / NORDLICHT ST",
        "CALL:<NEW CALL>",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T30",
        "(911 Rip And Run Service) Location: \r\n" +
        "NORTH OF BIG JOHNS \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MVC-I\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:NORTH OF BIG JOHNS",
        "CALL:MVC-I",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T31",
        "(911 Rip And Run Service) Location: \r\n" +
        "60.4847820000000000 -151.0688960000000000 \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "UNKNOWN / LITTLE AVE\r\n" +
        "ROBIN PL\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "52-ALARMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "52-C-03G\r\n",

        "ADDR:60.4847820000000000 -151.0688960000000000",
        "MADDR:+60.484782,-151.068896",
        "CITY:SOLDOTNA",
        "X:UNKNOWN / LITTLE AVE / ROBIN PL",
        "CODE:52-C-03G",
        "CALL:ALARMS",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T32",
        "(911 Rip And Run Service) Location: \r\n" +
        "50290 STERLING HWY \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "CHARLAND DR / GOLDDUST DR\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-D-03\r\r\n",

        "ADDR:50290 STERLING HWY",
        "CITY:SOLDOTNA",
        "X:CHARLAND DR / GOLDDUST DR",
        "CODE:06-D-03",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T33",
        "(911 Rip And Run Service) Location: \r\n" +
        "CITY HALL \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-D-01\r\r\n",

        "ADDR:CITY HALL",
        "CODE:06-D-01",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T34",
        "(911 Rip And Run Service) Location: \r\n" +
        "<UNKNOWN> \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:<UNKNOWN>",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T35",
        "(911 Rip And Run Service) Location: \r\n" +
        "MI 123.7 STERLING \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-D-02\r\r\n",

        "ADDR:MI 123.7 STERLING",
        "CODE:06-D-02",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T36",
        "(911 Rip And Run Service) Location: \r\n" +
        "46775 PINTAIL AVE \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "WREN DR / PELICAN RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:46775 PINTAIL AVE",
        "CITY:KENAI",
        "X:WREN DR / PELICAN RD",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T37",
        "(911 Rip And Run Service) Location: \r\n" +
        "425 W MARYDALE AVE \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "RIDGEWOOD DR / SOHI LN\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MVC-D\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:425 W MARYDALE AVE",
        "CITY:SOLDOTNA",
        "X:RIDGEWOOD DR / SOHI LN",
        "CALL:MVC-D",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T38",
        "(911 Rip And Run Service) Location: \r\n" +
        "46645 ROOSEVELT AVE \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "PHYLLIS CIR / CONSTITUTION ST\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "17-FALLS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "17-B-01G\r\n",

        "ADDR:46645 ROOSEVELT AVE",
        "CITY:SOLDOTNA",
        "X:PHYLLIS CIR / CONSTITUTION ST",
        "CODE:17-B-01G",
        "CALL:FALLS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T39",
        "(911 Rip And Run Service) Location: \r\n" +
        "CPH ER 4\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "<NEW CALL>\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:CPH ER 4",
        "CALL:<NEW CALL>",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T40",
        "(911 Rip And Run Service) Location: \r\n" +
        "GROVE AVE \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "DISTURBANCE OTHER\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:GROVE AVE",
        "CALL:DISTURBANCE OTHER",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T41",
        "(911 Rip And Run Service) Location: \r\n" +
        "36601 NAVIGATOR ST \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:36601 NAVIGATOR ST",
        "CITY:KENAI",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T42",
        "(911 Rip And Run Service) Location: \r\n" +
        "38359 MARILEE ST B1\r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "JIM AVE / STERLING HWY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "WELFARE CHECK\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:38359 MARILEE ST B1",
        "CITY:STERLING",
        "X:JIM AVE / STERLING HWY",
        "CALL:WELFARE CHECK",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T43",
        "(911 Rip And Run Service) Location: \r\n" +
        "36601 NAVIGATOR ST \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "HELMSMAN AVE / OCEAN ENTRANCE DR\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "26-SICK PERSON\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "26-A-01\r\n",

        "ADDR:36601 NAVIGATOR ST",
        "CITY:KENAI",
        "X:HELMSMAN AVE / OCEAN ENTRANCE DR",
        "CODE:26-A-01",
        "CALL:SICK PERSON",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T44",
        "(911 Rip And Run Service) Location: \r\n" +
        "CPH TO SOLE AIRPORT \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:CPH TO SOLE AIRPORT",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T45",
        "(911 Rip And Run Service) Location: \r\n" +
        "BEHIND BUCKETS \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:BEHIND BUCKETS",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T46",
        "(911 Rip And Run Service) Location: \r\n" +
        "168 W PARK AVE 5\r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "N FIREWEED ST / N BINKLEY ST\r\n" +
        "E PARK AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "ALARM- FIRE/BURG\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:168 W PARK AVE 5",
        "CITY:SOLDOTNA",
        "X:N FIREWEED ST / N BINKLEY ST / E PARK AVE",
        "CALL:ALARM- FIRE/BURG",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T47",
        "(911 Rip And Run Service) Location: \r\n" +
        "330 COLUMBINE ST B12\r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "W MARYDALE AVE / LUPINE ST\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:330 COLUMBINE ST B12",
        "CITY:SOLDOTNA",
        "X:W MARYDALE AVE / LUPINE ST",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T48",
        "(911 Rip And Run Service) Location: \r\n" +
        "38359 MARILEE ST B1\r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "JIM AVE / STERLING HWY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:38359 MARILEE ST B1",
        "CITY:STERLING",
        "X:JIM AVE / STERLING HWY",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T49",
        "(911 Rip And Run Service) Location: \r\n" +
        "264 UPPER ROSIAN DR \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "W LONDON ROSE CIR / DEAD END\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "26-SICK PERSON\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "26-C-02\r\r\n",

        "ADDR:264 UPPER ROSIAN DR",
        "CITY:SOLDOTNA",
        "X:W LONDON ROSE CIR / DEAD END",
        "CODE:26-C-02",
        "CALL:SICK PERSON",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T50",
        "(911 Rip And Run Service) Location: \r\n" +
        "<UNKNOWN> \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL ASSIST\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:<UNKNOWN>",
        "CALL:MEDICAL ASSIST",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T51",
        "(911 Rip And Run Service) Location: \r\n" +
        "ROOM 9 ER TO SOLDOTNA AIRPORT \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "APT:9 ER TO SOLDOTNA AIRPORT",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T52",
        "(911 Rip And Run Service) Location: \r\n" +
        "46476 CIECHANSKI RD \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "PERFECT ENDING ST / STANFORD ST\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "17-FALLS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "17-A-03G\r\n",

        "ADDR:46476 CIECHANSKI RD",
        "CITY:KENAI",
        "X:PERFECT ENDING ST / STANFORD ST",
        "CODE:17-A-03G",
        "CALL:FALLS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T53",
        "(911 Rip And Run Service) Location: \r\n" +
        "60808 STERLING HWY \r\n" +
        "  COHOE\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "BLUE RIBBON AVE / COHOE LOOP RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "17-FALLS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "17-A-01G\r\n",

        "ADDR:60808 STERLING HWY",
        "CITY:COHOE",
        "X:BLUE RIBBON AVE / COHOE LOOP RD",
        "CODE:17-A-01G",
        "CALL:FALLS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T54",
        "(911 Rip And Run Service) Location: \r\n" +
        "289 N FIREWEED ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "W MARYDALE AVE / W ROCKWELL AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "19-HEART PROBLEMS/A.I.C.D\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "19-D-01\r\r\n",

        "ADDR:289 N FIREWEED ST",
        "CITY:SOLDOTNA",
        "X:W MARYDALE AVE / W ROCKWELL AVE",
        "CODE:19-D-01",
        "CALL:HEART PROBLEMS/A.I.C.D",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T55",
        "(911 Rip And Run Service) Location: \r\n" +
        "36430 PUFFIN ST \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "GADWALL AVE / MERGANSER AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:36430 PUFFIN ST",
        "CITY:KENAI",
        "X:GADWALL AVE / MERGANSER AVE",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T56",
        "(911 Rip And Run Service) Location: \r\n" +
        " GAS WELL/ KBEACH\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "5-BACK PAIN\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "05-C-03\r\r\n",

        "ADDR:GAS WELL & KBEACH",
        "CODE:05-C-03",
        "CALL:BACK PAIN",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T57",
        "(911 Rip And Run Service) Location: \r\n" +
        "53321 STOL RO \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-D-04\r\r\n",

        "ADDR:53321 STOL RO",
        "CODE:06-D-04",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T58",
        "(911 Rip And Run Service) Location: \r\n" +
        "36195 IRONS DR \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "28-C-11F\r\n",

        "ADDR:36195 IRONS DR",
        "CODE:28-C-11F",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T59",
        "(911 Rip And Run Service) Location: \r\n" +
        "33095 JOEY CT \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "69-STRUCTURE FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "69-D-06\r\r\n",

        "ADDR:33095 JOEY CT",
        "CITY:STERLING",
        "CODE:69-D-06",
        "CALL:STRUCTURE FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T60",
        "(911 Rip And Run Service) Location: \r\n" +
        "48339 DJS DR \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / STERLING HWY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "<NEW CALL>\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:48339 DJS DR",
        "CITY:SOLDOTNA",
        "X:DEAD END / STERLING HWY",
        "CALL:<NEW CALL>",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T61",
        "(911 Rip And Run Service) Location: \r\n" +
        "60.5243097676000000 -149.6543220880000000 \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:60.5243097676000000 -149.6543220880000000",
        "MADDR:+60.524310,-149.654322",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T62",
        "(911 Rip And Run Service) Location: \r\n" +
        "60.4733600000000000 -151.1533140000000000 \r\n" +
        "ADDITIONAL LOCATION INFORMATION:W SECTOR\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "GAS WELL RD\r\n" +
        "ECHO LAKE RD / GAS WELL RD\r\n" +
        "KALIFORNSKY BEACH RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:60.4733600000000000 -151.1533140000000000",
        "MADDR:+60.473360,-151.153314",
        "CITY:ADDITIONAL LOCATION INFORMATION:W SECTOR",
        "X:GAS WELL RD / ECHO LAKE RD / KALIFORNSKY BEACH RD",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T63",
        "(911 Rip And Run Service) Location: \r\n" +
        "WILSON IN FRONT OF FOSTERS \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "12-CONVULSIONS/SEIZURES\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "12-D-04E\r\n",

        "ADDR:WILSON IN FRONT OF FOSTERS",
        "CODE:12-D-04E",
        "CALL:CONVULSIONS/SEIZURES",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T64",
        "(911 Rip And Run Service) Location: \r\n" +
        "33130 BAYLOR ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "RENSSELAER LN / JEFFERSON AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "31-UNCONSCIOUS/FAINTING(NEAR)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "NO;\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "31-D-01\r\r\n",

        "ADDR:33130 BAYLOR ST",
        "CITY:SOLDOTNA",
        "X:RENSSELAER LN / JEFFERSON AVE",
        "CODE:31-D-01",
        "CALL:UNCONSCIOUS/FAINTING(NEAR)",
        "INFO:Conscious: NO;\nBreathing: YES");

    doTest("T65",
        "(911 Rip And Run Service) Location: \r\n" +
        "60.5316555084000000 -150.4212824840000000 \r\n" +
        "  SALAMATOF\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "STERLING HWY\r\n" +
        "SKILAK LAKE RD / SKILAK LAKE RD\r\n" +
        "STERLING HWY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "<NEW CALL>\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:60.5316555084000000 -150.4212824840000000",
        "MADDR:+60.531656,-150.421282",
        "CITY:SALAMATOF",
        "X:STERLING HWY / SKILAK LAKE RD",
        "CALL:<NEW CALL>",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T66",
        "(911 Rip And Run Service) Location: \r\n" +
        "VAUGNS MINI MART \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "25-PSYCHIATRIC/SUICIDE ATTEMPT\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:VAUGNS MINI MART",
        "CODE:25",
        "CALL:PSYCHIATRIC/SUICIDE ATTEMPT",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T67",
        "(911 Rip And Run Service) Location: \r\n" +
        "34133 MATANUSKA ST \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "52-ALARMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "52-B-01C\r\n",

        "ADDR:34133 MATANUSKA ST",
        "CODE:52-B-01C",
        "CALL:ALARMS",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T68",
        "(911 Rip And Run Service) Location: \r\n" +
        "35879 TERESA WAY \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "10-CHEST PAIN\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "10-C-02\r\r\n",

        "ADDR:35879 TERESA WAY",
        "CITY:SOLDOTNA",
        "CODE:10-C-02",
        "CALL:CHEST PAIN",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T69",
        "(911 Rip And Run Service) Location: \r\n" +
        "34146 KHAMSIN ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "FOEHN CT / SIROCCO DR\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:34146 KHAMSIN ST",
        "CITY:SOLDOTNA",
        "X:FOEHN CT / SIROCCO DR",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T70",
        "(911 Rip And Run Service) Location: \r\n" +
        "156 COLLEGE RD \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "POPPY RIDGE RD\r\n" +
        "E POPPY LN / CHUGACH DR\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:156 COLLEGE RD",
        "CITY:SOLDOTNA",
        "X:POPPY RIDGE RD / E POPPY LN / CHUGACH DR",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T71",
        "(911 Rip And Run Service) Location: \r\n" +
        "CARDWELL RD \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "12-CONVULSIONS/SEIZURES\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "12-A-02\r\n",

        "ADDR:CARDWELL RD",
        "CODE:12-A-02",
        "CALL:CONVULSIONS/SEIZURES",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T72",
        "(911 Rip And Run Service) Location: \r\n" +
        "23160 LOWELL LOOP \r\n" +
        "  KASILOF\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "RILINDA RD / RILINDA RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "31-UNCONSCIOUS/FAINTING(NEAR)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "31-C-02\r\r\n",

        "ADDR:23160 LOWELL LOOP",
        "CITY:KASILOF",
        "X:RILINDA RD",
        "CODE:31-C-02",
        "CALL:UNCONSCIOUS/FAINTING(NEAR)",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T73",
        "(911 Rip And Run Service) Location: \r\n" +
        "230 E MARYDALE AVE \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "17-FALLS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "17-A-01G\r\n",

        "ADDR:230 E MARYDALE AVE",
        "CITY:SOLDOTNA",
        "CODE:17-A-01G",
        "CALL:FALLS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T74",
        "(911 Rip And Run Service) Location: \r\n" +
        "247 N FIREWEED ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "W KATMAI AVE / W ROCKWELL AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "33-TRANSFER/INTERFACILITY\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "33-C-02T\r\n",

        "ADDR:247 N FIREWEED ST",
        "CITY:SOLDOTNA",
        "X:W KATMAI AVE / W ROCKWELL AVE",
        "CODE:33-C-02T",
        "CALL:TRANSFER/INTERFACILITY",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T75",
        "(911 Rip And Run Service) Location: \r\n" +
        "48480 DAISY AVE \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "31-UNCONSCIOUS/FAINTING(NEAR)\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "31-C-01\r\n",

        "ADDR:48480 DAISY AVE",
        "CITY:SOLDOTNA",
        "CODE:31-C-01",
        "CALL:UNCONSCIOUS/FAINTING(NEAR)",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T76",
        "(911 Rip And Run Service) Location: \r\n" +
        "425 W MARYDALE AVE \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "ALARM- FIRE/BURG\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:425 W MARYDALE AVE",
        "CITY:SOLDOTNA",
        "CALL:ALARM- FIRE/BURG",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T77",
        "(911 Rip And Run Service) Location: \r\n" +
        "38809 MCDOWELL RD \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "STASSI LN / FALLHAVEN LN\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "COMFORT ONE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:38809 MCDOWELL RD",
        "CITY:STERLING",
        "X:STASSI LN / FALLHAVEN LN",
        "CALL:COMFORT ONE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T78",
        "(911 Rip And Run Service) Location: \r\n" +
        "34965 YALE ST 1\r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "RAVENWOOD ST\r\n" +
        "E POPPY LN / PRINCETON AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-C-01\r\r\n",

        "ADDR:34965 YALE ST 1",
        "CITY:SOLDOTNA",
        "X:RAVENWOOD ST / E POPPY LN / PRINCETON AVE",
        "CODE:06-C-01",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T79",
        "(911 Rip And Run Service) Location: \r\n" +
        "30793 ECHO LAKE RD \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:30793 ECHO LAKE RD",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T80",
        "(911 Rip And Run Service) Location: \r\n" +
        "38809 MCDOWELL RD \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "STASSI LN / FALLHAVEN LN\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "6-BREATHING PROBLEMS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "06-D-01\r\r\n",

        "ADDR:38809 MCDOWELL RD",
        "CITY:STERLING",
        "X:STASSI LN / FALLHAVEN LN",
        "CODE:06-D-01",
        "CALL:BREATHING PROBLEMS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T81",
        "(911 Rip And Run Service) Location: \r\n" +
        "35482 KENAI SPUR HWY \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:35482 KENAI SPUR HWY",
        "CITY:SOLDOTNA",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T82",
        "(911 Rip And Run Service) Location: \r\n" +
        "35135 WATER FRONT WAY \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "WHARF AVE / RIVER DR\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "26-SICK PERSON\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "26-C-02\r\r\n",

        "ADDR:35135 WATER FRONT WAY",
        "CITY:SOLDOTNA",
        "X:WHARF AVE / RIVER DR",
        "CODE:26-C-02",
        "CALL:SICK PERSON",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T83",
        "(911 Rip And Run Service) Location: \r\n" +
        "250 HOSPITAL PL 1\r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:250 HOSPITAL PL 1",
        "CITY:SOLDOTNA",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T84",
        "(911 Rip And Run Service) Location: \r\n" +
        "109 N BIRCH ST B\r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "E REDOUBT AVE\r\n" +
        "S BIRCH ST / SHADY LN\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "17-FALLS\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "17-B-01G\r\n",

        "ADDR:109 N BIRCH ST B",
        "CITY:SOLDOTNA",
        "X:E REDOUBT AVE / S BIRCH ST / SHADY LN",
        "CODE:17-B-01G",
        "CALL:FALLS",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T85",
        "(911 Rip And Run Service) Location: \r\n" +
        "250 HOSPITAL PL \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / W MARYDALE AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "18-HEADACHE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "18-C-04\r\r\n",

        "ADDR:250 HOSPITAL PL",
        "CITY:SOLDOTNA",
        "X:DEAD END / W MARYDALE AVE",
        "CODE:18-C-04",
        "CALL:HEADACHE",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T86",
        "(911 Rip And Run Service) Location: \r\n" +
        "39180 FARVIEW ST \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / MISTY MORNING AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "12-C-04\r\n",

        "ADDR:39180 FARVIEW ST",
        "CITY:STERLING",
        "X:DEAD END / MISTY MORNING AVE",
        "CODE:12-C-04",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T87",
        "(911 Rip And Run Service) Location: \r\n" +
        "34610 SILVER WEED ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / WHISPER WAY\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "ALARM- FIRE/BURG\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:34610 SILVER WEED ST",
        "CITY:SOLDOTNA",
        "X:DEAD END / WHISPER WAY",
        "CALL:ALARM- FIRE/BURG",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T88",
        "(911 Rip And Run Service) Location: \r\n" +
        "CPH ER ROOM 6 TO STERLING \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:CPH ER",
        "APT:6 TO STERLING",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T89",
        "(911 Rip And Run Service) Location: \r\n" +
        "CPH ER 17\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:CPH ER 17",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T90",
        "(911 Rip And Run Service) Location: \r\n" +
        "JOHNS ROAD \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "67-OUTSIDE FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "67-B-03U\r\n",

        "ADDR:JOHNS ROAD",
        "CODE:67-B-03U",
        "CALL:OUTSIDE FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T91",
        "(911 Rip And Run Service) Location: \r\n" +
        "286 SUNRISE CT \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "60-GAS LEAK/GAS ODOR\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "60-B-02O\r\n",

        "ADDR:286 SUNRISE CT",
        "CITY:SOLDOTNA",
        "CODE:60-B-02O",
        "CALL:GAS LEAK/GAS ODOR",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T92",
        "(911 Rip And Run Service) Location: \r\n" +
        "39180 FARVIEW ST \r\n" +
        "  STERLING\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "DEAD END / MISTY MORNING AVE\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "12-CONVULSIONS/SEIZURES\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "YES\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "YES\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "12-D-03\r\r\n",

        "ADDR:39180 FARVIEW ST",
        "CITY:STERLING",
        "X:DEAD END / MISTY MORNING AVE",
        "CODE:12-D-03",
        "CALL:CONVULSIONS/SEIZURES",
        "INFO:Conscious: YES\nBreathing: YES");

    doTest("T93",
        "(911 Rip And Run Service) Location: \r\n" +
        "34901 DANA BAYES ST \r\n" +
        "  SOLDOTNA\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "<NEW CALL>\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:34901 DANA BAYES ST",
        "CITY:SOLDOTNA",
        "CALL:<NEW CALL>",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T94",
        "(911 Rip And Run Service) Location: \r\n" +
        "73 STERLING HWY \r\n" +
        "  HOMER\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MVC-I\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:73 STERLING HWY",
        "CITY:HOMER",
        "CALL:MVC-I",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T95",
        "(911 Rip And Run Service) Location: \r\n" +
        "14 KBEACH \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:14 KBEACH",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T96",
        "(911 Rip And Run Service) Location: \r\n" +
        "APPROX 14 K-BEACH RD \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:APPROX 14 K-BEACH RD",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T97",
        "(911 Rip And Run Service) Location: \r\n" +
        "50235 ONSLOW AVE \r\n" +
        "  KENAI\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "BJERKE ST / EASTWAY RD\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL ASSIST\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:50235 ONSLOW AVE",
        "CITY:KENAI",
        "X:BJERKE ST / EASTWAY RD",
        "CALL:MEDICAL ASSIST",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T98",
        "(911 Rip And Run Service) Location: \r\n" +
        "48494 SANDHILL CRANE LOOP \r\n" +
        "  KASILOF\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "KALEA AVE / KOSHNEY LN\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:48494 SANDHILL CRANE LOOP",
        "CITY:KASILOF",
        "X:KALEA AVE / KOSHNEY LN",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T99",
        "(911 Rip And Run Service) Location: \r\n" +
        "354 TYEE LN C\r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "SUICIDE ATTEMPT\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:354 TYEE LN C",
        "CALL:SUICIDE ATTEMPT",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

    doTest("T100",
        "(911 Rip And Run Service) Location: \r\n" +
        "SANDHILL CRANE LOOP \r\n" +
        ", AK\r\n" +
        "\r\n" +
        "Cross Streets: \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Call Type: \r\n" +
        "MEDICAL/FIRE\r\n" +
        "\r\n" +
        "\r\n" +
        "Conscious: \r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Breathing:\r\n" +
        "Unknown\r\n" +
        "\r\n" +
        "Dispatch Code:\r\n" +
        "Unknown\r\n",

        "ADDR:SANDHILL CRANE LOOP",
        "CALL:MEDICAL/FIRE",
        "INFO:Conscious: Unknown\nBreathing: Unknown");

  }
  
  public static void main(String[] args) {
    new AKKenaiPeninsulaBoroughParserTest().generateTests("T1");
  }
}