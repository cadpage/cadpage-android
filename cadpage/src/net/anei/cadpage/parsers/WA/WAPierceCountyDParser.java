package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Pierce County, WA
 */
public class WAPierceCountyDParser extends FieldProgramParser {
  
  private static Pattern MASTER_PTN = Pattern.compile("DISPATCH: *(.*?) +- From [A-Z0-9]+ (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)");
  
  public WAPierceCountyDParser() {
    super( "PIERCE COUNTY", "WA", 
           "CODE CALL ( NAME SRC/Z AT | ADDR ) SRC APT? X ( PLACE APT SRC2 | PLACE? SRC2 ) BOX MAP INFO+? ID! Units:UNIT! UNIT+");
  }
  
  @Override
  public String getFilter() {
    return "2082524514";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    body = match.group(1);
    data.strDate = match.group(2);
    data.strTime = match.group(3);

    body = body.replace(" Unit:", " Units:");
    return parseFields(body.split(", "), data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " DATE TIME";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("\\d\\d", true);
    if (name.equals("AT")) return new AddressField("at +(.*)", true);
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("SRC2")) return new SkipField("F\\d\\d", true);
    if (name.equals("BOX")) return new BoxField("\\d\\d-\\d{3,4}", true);
    if (name.equals("MAP")) return new MapField("\\d+", true);
    if (name.equals("ID")) return new IdField("\\d{10}", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("<") && field.endsWith(">")) {
        super.parse(field, data);
        return true;
      }
      
      if (field.startsWith("btwn ")) {
        field = field.substring(5).replace(" and ", " / ").trim();
        super.parse(field, data);
        return true;
      }
      
      return false;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, ", ", field);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ", ", field);
    }
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return WAPierceCountyParser.adjustMapAddressCommon(sAddress);
  }
}
