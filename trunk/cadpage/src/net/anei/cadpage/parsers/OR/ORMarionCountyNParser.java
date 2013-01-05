package net.anei.cadpage.parsers.OR;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Marion County (North), OR
 */
public class ORMarionCountyNParser extends FieldProgramParser {
  
  private static final Pattern TIME_PTN = Pattern.compile("\\b(\\d{1,2}):(\\d{1,2}):(\\d{1,2})\\b");
  private static final Pattern GPS_PTN = Pattern.compile("\\bLAT: *([+-]?[\\d.]+), *LON: *([+-]?[\\d.]+)\\b");
  
  public ORMarionCountyNParser() {
    super("MARION COUNTY", "OR",
           "( ADDR/SXCZ END | CALL ADDRCITY ( PLACE UNK APT UNIT! EMPTY INFO DATETIME | UNIT! INFO UNK UNK UNK PLACE ) )");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@ci.woodburn.or.us";
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.equals("Incident")) break;
      
      if (body.startsWith("Incident / ")) {
        body = body.substring(11).trim();
        break;
      }
      
      return false;
    } while (false);
    
    // Time field has to be protected from being broken up by colon field separators
    body = TIME_PTN.matcher(body).replaceAll("$1-$2-$3");
    
    // As does a GPS address field
    body = GPS_PTN.matcher(body).replaceAll("$1,$2");
    
    return parseFields(body.split(":", -1), data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace('@', '&');
      super.parse(field, data);
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+[0-9]+(?:-[A-Z]+)?(?:,.*)?");
  private static final Pattern STATION_PTN = Pattern.compile("\\bSTA\\d+$");
  private class MyUnitField extends UnitField {
    public MyUnitField() {
      setPattern(UNIT_PTN);
    }
    
    @Override
    public void parse(String fld, Data data) {
      if (fld.endsWith(",")) fld = fld.substring(0,fld.length()-1);
      Matcher match = STATION_PTN.matcher(fld);
      if (match.find()) {
        data.strSource = match.group();
        fld = fld.substring(0,match.start()).trim();
        if (fld.endsWith(",")) fld = fld.substring(0,fld.length()-1);
      }
      super.parse(fld, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT SRC";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override 
    public void parse(String field, Data data) {
      if (field.equals(data.strAddress)) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("DATETIME")) return new DateTimeField(DATE_TIME_FMT);
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh-mm-ss aa"); 
}
