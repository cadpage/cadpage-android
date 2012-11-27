package net.anei.cadpage.parsers.CO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class COLarimerCountyParser extends FieldProgramParser {
  
  private static final Pattern SEPARATOR = Pattern.compile(" *// *");

  public COLarimerCountyParser() {
    super("LARIMER COUNTY", "CO",
           "CALL ADDR APT! Radio:CH! PLACE MAP UNIT");
  }
  
  public String getFilter() {
    return "@notifyall.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Parser p = new Parser(subject);
    data.strSource = p.getOptional('|');
    if (!p.get().equals("CFS")) return false;
    if (data.strSource.toLowerCase().startsWith("notifyall")) data.strSource = "";

    String[] flds = SEPARATOR.split(body);
    if (!parseFields(flds, data)) return false;
    if (data.strMap.equals("NOT FOUND")) data.strMap = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new AptField("Apt/Lot\\b *(.*)", true);
    return super.getField(name);
  }
}
