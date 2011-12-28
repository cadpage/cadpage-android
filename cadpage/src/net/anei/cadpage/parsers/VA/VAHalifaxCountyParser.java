package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Halifax County, VA
Contact: "devinsnead@hotmail.com" <devinsnead@hotmail.com>
Contact: Dennis Blanks <dblanks09@gmail.com>
Contact: George Hodges <grh850@embarqmail.com>
Sender: halifaxeoc@co.halifax.va.us

[from Central]  11-023176 FALLEN PATIENT\n2210 N TERRYS BRIDGE RD\nJAMES D HAGOOD HWY //SUNSET LN\nHALIFAX
[from Central]  11-023175 FALLEN PATIENT\n1167 LEWIS FERRELL RD\nOAK LEVEL RD / LITTL/E CIR\nSOUTH BOSTON
[from Central]  11-023166 EMERGENCY MEDICAL SERVICE\n111-22 ROSEHILL DR\nPOWELL RD / DEAD END/EN\nROSE HILL APARTMENTS  SOUTH BOSTON
[from Central]  11-023086 UNRESPONSIVE PATIENT\n1110 ASBURY CHURCH RD\nCHATHAM RD / PAUL PR/Y TRL\nYOUNGERS HOME FOR ADULTS  HALIFAX
[from Central]  11-023050 FALLEN PATIENT\n3471 OLD HALIFAX RD\nHIGH SCHOOL CIR /  C/ENTERVILLE PARK RD\nWAL-MART  SOUTH BOSTON
[from Central]  11-023040 EMERGENCY MEDICAL SERVICE\n2082 BURTON RD\nWAGSTAFF LN / CLAYS/MILL RD\nSCOTTSBURG
[from Central]  11-023038 FALLEN PATIENT\n103 WHITE OAK DR\nSYCAMORE RD / SYCAMO/RE RD\nSOUTH BOSTON
[from Central]  11-017088 SHORTNESS OF BREATH, ETC.\n1110 HENRYS TRL\nAMBERSTONE DR / DEAD/END\nNATHALIE
(from Central) 11-022783 ACCIDENT INVOLVING PEDESTRIAN\n104-20 LOVE SHOP PARK RD\nOLD HALIFAX RD / DEA/D END\nLOVE SHOP TRAILER PARK  SOUTH BOSTON

 */
public class VAHalifaxCountyParser extends FieldProgramParser {
  
  private static final Pattern ID_PTN = Pattern.compile("^(\\d\\d-\\d{6}) +");
  
  public VAHalifaxCountyParser() {
    super("HALIFAX COUNTY", "VA",
           "CALL ADDR X CITY");
  }
  
  @Override
  public String getFilter() {
    return "halifaxeoc@co.halifax.va.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("from Central")) return false;
    Matcher match = ID_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end()).trim();
    
    return parseFields(body.split("\n"), data);
  }
  
  private class MyCityField extends CityField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getOptional("  ");
      super.parse(p.get(), data);
    }
    
    @Override 
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}