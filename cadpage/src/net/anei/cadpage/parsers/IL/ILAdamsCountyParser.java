package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ILAdamsCountyParser extends FieldProgramParser {
  
  private static final Pattern MISSING_BRK_PTN = Pattern.compile("(\nUnits:.*?)  +(\\S.*)");
  private static final Pattern MISSING_BRK2_PTN = Pattern.compile("(?<!\n)(?=Cross Streets ?:)");

  public ILAdamsCountyParser() {
    super("ADAMS COUNTY", "IL",
          "CALL! Units:UNIT! ADDR/S6! APT City:CITY? Cross_Streets:X X INFO+");
  } 
  
  @Override
  public String getFilter() {
    return "911@co.adams.il.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    // check subject and parse SRC
    if (!subject.startsWith("CAD Page for CFS ")) return false;
    data.strCallId = subject.substring(17).trim();
    
    // Check for non-existent call field
    if (body.startsWith("Units:")) body = '\n' + body;
    
    // Fix missing line break between Units and address :(
    Matcher match = MISSING_BRK_PTN.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.start()) + match.group(1) + '\n' + match.group(2) + body.substring(match.end());
    }
    
    // And between city and cross streets
    body = MISSING_BRK2_PTN.matcher(body).replaceFirst("\n");
    return parseFields(body.split("\n"), 3, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('*', '/');
      super.parse(field, data);
    }
  }
}
