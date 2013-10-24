package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PAMontgomeryCountyGParser extends FieldProgramParser {
  
  public PAMontgomeryCountyGParser() {
    super(PAMontgomeryCountyParser.CITY_CODES, "MONTGOMERY COUNTY", "PA",
           "INC#:ID_CALL! Addr:ADDR Box:BOX! ADC:MAP! MUN:CITY! Units:UNIT!");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.startsWith("Dispatch-")) return false;
    data.strSource = subject.substring(9).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID_CALL")) return new MyIdCallField();
    return super.getField(name);
  }
  
  private static final Pattern ID_CALL_PTN = Pattern.compile("([EF]\\d+)  +(.*)");
  private class MyIdCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strCall = match.group(2);
    }

    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
}
