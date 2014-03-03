package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class MDWorcesterCountyAParser extends DispatchOSSIParser {
 
  public MDWorcesterCountyAParser() {
    super(MDWorcesterCountyParser.CITY_LIST, "WORCESTER COUNTY", "MD",
    		   "SRC? CALL ( CITY ADDR DIR? APT? | ADDR DIR? APT? PLACE+? CITY/Y! ) ( DATETIME | X+? INFO+? DATETIME )");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    if (!super.parseMsg(body, data)) return false;
    if (MDWorcesterCountyParser.VA_CITY_SET.contains(data.strCity.toUpperCase())) {
      data.strState = "VA";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }
  
  private class MyDirField extends Field {
    public MyDirField() {
      setPattern("[NSEW](?:/?B)?", true);
    }

    @Override
    public void parse(String field, Data data) {
      field = field.replace("/", "");
      data.strAddress = append(data.strAddress, " ", field);
    }

    @Override
    public String getFieldNames() {
      // TODO Auto-generated method stub
      return null;
    }
    
  }

  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM) *(.*)|(BLDG *.*)", Pattern.CASE_INSENSITIVE);
  private class MyAptField extends AptField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (!match.matches()) return false;
      String apt = match.group(1);
      if (apt == null) apt = match.group(2);
      data.strApt = apt;
      return true;
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      
      // Occasionally they have an apt field that does not look like
      // an apt field and was mistaken for a place field.  When the
      // real place field comes along, move the old place value to
      // the apt field.
      if (data.strPlace.length() > 0) {
        if (data.strApt.length() > 0) abort();
        data.strApt = data.strPlace;
        data.strPlace = "";
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "APT PLACE";
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[0-9]{1,2}00[A-Z]?|S[0-9]", true);
    if (name.equals("DIR")) return new MyDirField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("PLACE")) return new  MyPlaceField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} +\\d\\d:\\d\\d:\\d\\d");
    return super.getField(name);
  }
}
