package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Ocean City County, NJ
 */
public class NJOceanCountyParser extends DispatchA9Parser {
  
  public NJOceanCountyParser() {
    super(null, "OCEAN COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "Fire_Records";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Correct double spacing by iamresponding
    if (body.startsWith("Rip and Run Report\n\n\n\n~")) body = body.replace("\n\n", "\n"); 
    
    if (!super.parseMsg(body, data)) return false;
    
    // Dispatch seems to be storing the station code in the map fields
    data.strSource = data.strMap;
    data.strMap = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
