package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;

/*
Muscalane County, IA
Contact: KEVIN FLYNN <kwf9111@gmail.com>
System: Iamresponding
Sender: 7771

.... (NFD) 12-001870 MEDICAL \n1089 180TH ST \nATWOOD AVE / BANCROF/T AVE \nNICHOLS \nNFR WLAB
.... (NFD) 11-052885 ACCIDENT-PI\nIJEM AVE/ MAIN ST\nNICHOLS\nNFD NFR
.... (NFD) 11-052886 FIRE-STRUCTURE\n410 RAILROAD ST\nIJEM AVE / WASHINGTO/N AVE\nNICHOLS\nNFD
.... (NFD) 12-001933 MEDICAL\n1649 HOLLY AVE\n160TH ST / 170TH ST/\nWEST LIBERTY\nNFR WLAB
.... (NFD) 12-000312 FIRE-STRUCTURE\n1530 ATWOOD AVE\n560TH ST SE / 160TH/ST\nWEST LIBERTY\nNFD WLFD

 */


public class IAMuscatineCountyParser extends DispatchShieldwareParser {
  
  public IAMuscatineCountyParser() {
    super("MUSCATINE COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "777";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    data.strSource = subject;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
