package net.anei.cadpage.parsers.IA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Pottawattamie county, IA
Contact: Adam Gillaspie <adam.gillaspie@gmail.com>
Sender: messaging@iamresponding.com

[1700]  17-11-339 11/23 08:32\n20595 MCPHERSON AV, POTT COUNTY\nFIRE - WEED GRASS FIRE\nXST: STATE ORCHARD RD//SUNNYDALE RD 
[1700]  17-11-338 11/21 17:33\n3000 RISEN SON BV, POTT COUNTY\nEMS/FIRE - UNCONCIOUS/FAINTING\nXST: VIRGINIA HILLS RD//
[1700]  17-11-337 11/20 16:02\n18088 BENT TREE RIDGE, POTT COUNTY\nFIRE - AUTOMATIC FIRE DETECTION SIGNAL\nXST: THREE BRIDGE RD//DEAD END
[1700]  17-11-336 11/20 15:26\n19897 BEVERLY MANOR, POTT COUNTY\nSICK PERSON - GENERIC\nXST: LONGVIEW LP//DEAD END
[1700]  17-11-334 11/20 15:19\n19900 VIRGINIA HILLS RD, POTT COUNTY\nFALLS - GENERIC\nXST: CONCORD LP//
[1700]  17-11-333 11/19 22:07\n1102 LONGVIEW LP, POTT COUNTY\nEMS/FIRE - BREATHING PROBLEMS\nXST: VALLEY VIEW DR//GREENVIEW RD
[1700]  17-11-332 11/19 14:21\n14186 230 ST, POTT COUNTY\nPOLE - GENERIC\nXST: CHESTNUT RD//
[1700]  17-11-331 11/19 11:10\n21940 VINEYARD HILLS RD, POTT COUNTY\nSICK PERSON - GENERIC\nXST: EDGEWOOD RD// \n

 */


public class IAPottawattamieCountyParser extends FieldProgramParser {
  
  private static final Pattern SOURCE_PTN = Pattern.compile("\\d{4}"); 
  
  public IAPottawattamieCountyParser() {
    super("POTTAWATTAMIE COUNTY", "IA",
           "IDDATETIME ADDRCITY CALL! XST:X");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!SOURCE_PTN.matcher(subject).matches()) return false;
    data.strSource = subject;
    if (!parseFields(body.split("\n"), data)) return false;
    if (data.strCity.equals("POTT COUNTY")) data.strCity = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final Pattern ID_DATE_TIME_PTN = Pattern.compile("(\\d\\d-\\d\\d-\\d{3}) (\\d\\d/\\d\\d) (\\d\\d:\\d\\d)");
  private class MyIdDateTimeField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strDate = match.group(2);
      data.strTime = match.group(3);
    }
    
    @Override
    public String getFieldNames() {
      return "ID DATE TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("IDDATETIME")) return new MyIdDateTimeField();
    return super.getField(name);
  }
}
