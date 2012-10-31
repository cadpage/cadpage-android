package net.anei.cadpage.parsers.NY;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYSuffolkCountyDParser extends FieldProgramParser {
  
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}-[A-Z]-\\d{1,2}[A-Z]?) ");
  
  public NYSuffolkCountyDParser() {
    super("SUFFOLK COUNTY","NY",
    "CALL! code:CODE? at:ADDRCITY! c/s:X! d/t:DATETIME");
  }

  @Override
  public String getFilter() {
    return "paging@pjvac.org,";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCode.length() == 0) {
      Matcher match = CODE_PTN.matcher(data.strCall);
      if (match.find()) {
        data.strCode = match.group(1);
        data.strCall = data.strCall.substring(match.end()).trim();
      }
    }
    
    if (data.strAddress.length() == 0) {
      String sAddr = data.strCross;
      data.strCross = "";
      parseAddress(sAddr, data);
    }
    return true;
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("&")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
      
  }
}
