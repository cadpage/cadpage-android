package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Hanover County, VA
 */
public class VAHanoverCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[\\[\\(]?(\\d{4,})[\\)\\] a]*");
  private static final Pattern START_TRASH_PTN = Pattern.compile("^a +[\\)\n]");
    
  
  public VAHanoverCountyParser() {
    super("HANOVER COUNTY", "VA",
           "Unit:UNIT! UnitSts:SKIP! Inc:CALL? Inc#:ID! Inc:CALL? Loc:ADDR! MapRef:MAP");
  }
  
  @Override
  public String getFilter() {
    return "e911@ps400.hanoverva.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    
    match = START_TRASH_PTN.matcher(body);
    if (match.find()) body = body.substring(match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("^[A-Z] Map \\d{2,4}(?:-\\d)?\\b");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_PTN.matcher(field);
      if (!match.find()) abort();
      data.strMap = match.group();
      field = field.substring(match.end()).trim();
      field = field.replace("Addtl:", "-");
      if (field.startsWith("-")) field = field.substring(1).trim();
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      data.strSupp = field;
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }

  @Override
  public String adjustMapAddress(String sAddress) {
    return PK_PTN.matcher(sAddress).replaceAll("PKWY");
  }
  private static final Pattern PK_PTN = Pattern.compile("\\bPK\\b", Pattern.CASE_INSENSITIVE);
}
