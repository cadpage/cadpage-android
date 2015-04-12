package net.anei.cadpage.parsers.MS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MSLauderdaleCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("\\((\\d+)\\) *([A-Z]+)");

  public MSLauderdaleCountyParser() {
    super("LAUDERDALE COUNTY", "MS",
          "CALL ADDR CITY INFO SRC UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "E911@meridianms.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    
    return parseFields(body.split("-"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{3}", true);
    return super.getField(name);
  }
}
