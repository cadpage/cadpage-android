package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;


/*
Wayne County, NJ
Contact: support@active911
Sender: cad@waynetownship.com

2012000006 {01/03/2012 10:58:16}\nAFCI     - Fire alarm - commercial/industrial{3}\n3 Willowbrook Mall;PD\nUnits:\n\nComments:\n  Station Dispatched : {C1 } Station Dispatched : {C2 } Units Recommended: ,;\nDispatched: {C2 }, {C1 } ZONE 3 FIRE ALARM/IDHIT/8772387739/ACWN/ADT
2012000019 {01/04/2012 11:47:19}\nFCI      - Fire - commercial/industrial{1}\n1520 Rt23;PD\nUnits:\n\nComments:\n  Station Dispatched : {C3 } Station Dispatched : {C1 } Loc changed  \nfrom {1530 Rt23;PD} to {1520 Rt23;PD}\n\nPri from -> 5 to 1\n  Station Dispatched : {C2 } Station Dispatched : {C5 } Units Recommended: (Not able to recommend);\nDispatched: {C5 }, {C2 } Elco admin services\nRough,Jim  862 226 9566\nCaller stated her heard a popping sound inside the building and they nsmell smoke\nAddress in 1538 rt23  behing wayne Hardware Update reviewed by dispatcher- Peterson, Tracy L-716
2012000017 {01/04/2012 10:49:09}\nAFCI     - Fire alarm - commercial/industrial{3}\n520 Rt46;PD.\n  Units:\n\nComments:\n  Station Dispatched : {C1 } Station Dispatched : {C2 } Units Recommended: ,;\nDispatched: {C2 }, {C1 } Adt/877 2387739/id iub/acwn\nRed Lobster\nzone 18 ANSUL
2012000022 {01/04/2012 20:21:09}\nMVAE     - MVA - extrication{1}\nValley Rd/French Hill Rd;PD\nUnits:\n\nComments:\n  Station Dispatched : {R5 } Station Dispatched : {C1 } Units Recommended: ,;\nDispatched: {C1 }, {R5 } Caller states the white suv flipped over  -  \nmight be trapped inside - caller not involed - Caller states white suv  \nposs trapped States 4 veh involved - caller not involed -
2012000023 {01/05/2012 00:07:46}\nAFCI     - Fire alarm - commercial/industrial{2}\n1 Willowbrook Mall;PD \nUnits:\n\nComments:\n   Station Dispatched : {C1 } Station Dispatched : {C2 } Units Recommended: ,;\nDispatched: {C2 }, {C1 } PreEmpt - 03N\nCode 4 MaCYS COMM CENTER/8662297579/opred/acwn glass beak perimeter

*/

public class NJWayneCountyParser extends DispatchProphoenixParser {
  
  public NJWayneCountyParser() {
    super("WAYNE COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "cad@waynetownship.com,5417047704";
  }
}
