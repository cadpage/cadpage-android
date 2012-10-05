package net.anei.cadpage.parsers.CO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class COLarimerCountyParser extends FieldProgramParser {
  
  private static final Pattern SEPARATOR = Pattern.compile(" *// *");

  public COLarimerCountyParser() {
    super("LARIMER COUNTY", "CO",
           "CALL ADDR SKIP Radio:SKIP! INFO");
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
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
