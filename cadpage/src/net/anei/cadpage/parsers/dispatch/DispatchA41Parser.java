package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA41Parser extends FieldProgramParser {
  
  public static final int A41_FLG_NO_CALL = 1;
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(.*) +- From +(?:[A-Z][A-Z0-9]+ +)?(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d)");
  
  private Pattern sourcePattern;
  
  public DispatchA41Parser(Properties cityCodes, String defCity, String defState, String sourcePattern) {
    this(cityCodes, defCity, defState, sourcePattern, 0);
  }
  
  public DispatchA41Parser(Properties cityCodes, String defCity, String defState, String sourcePattern, int flags) {
    super(cityCodes, defCity, defState, calcProgram(flags));
    this.sourcePattern = Pattern.compile(sourcePattern);
  }
  
  private static String calcProgram(int flags) {
    StringBuilder sb = new StringBuilder();
    sb.append("DISPATCH:CODE! ");
    if ((flags & A41_FLG_NO_CALL) == 0) sb.append("CALL ");
    sb.append("( PLACE CITY/Z AT | ADDRCITY/Z ) CITY? ( SRC/Z MAPPAGE! | EMPTY? ( PLACE APT X1 | PLACE APT INT | PLACE X1 | PLACE INT | X1 | INT | ) EMPTY? ( PLACE APT SRC | PLACE SRC | SRC ) ( MAP MAPPAGE | MAPPAGE | MAP MAP2? ) ) INFO/CS+? ID1 GPS1 GPS2 ID2? Unit:UNIT UNIT+");
    return sb.toString();
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (match.matches()) {
      body = match.group(1);
      data.strDate = match.group(2);
      data.strTime = match.group(3);
    } else {
      int pt = body.lastIndexOf(" - From");
      if (pt >= 0) body = body.substring(0,pt).trim();
    }
    body = body.replace(" Units:", " Unit:");
    if (body.endsWith(",")) body = body + ' ';
    return parseFields(body.split(",+ "), data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " DATE TIME"; 
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new BaseAddressCityField();
    if (name.equals("CITY")) return new BaseCityField();
    if (name.equals("AT")) return new AddressField("at +(.*)", true);
    if (name.equals("X1")) return new CrossField("btwn *(.*)", true);
    if (name.equals("INT")) return new SkipField("<.*>", true);
    if (name.equals("PLACE")) return new BasePlaceField();
    if (name.equals("APT")) return new BaseAptField();
    if (name.equals("SRC")) return new BaseSourceField();
    if (name.equals("MAPPAGE")) return new SkipField("mappage,XXXX", true);
    if (name.equals("MAP2")) return new BaseMap2Field();
    if (name.equals("INFO")) return new BaseInfoField();
    if (name.equals("ID1")) return new IdField("\\d{10}", true);
    if (name.equals("ID2")) return new BaseId2Field();
    if (name.equals("UNIT")) return new BaseUnitField();
    if (name.equals("TIMESTAMP")) return new SkipField("\\d{4}-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private class BaseAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(")")) {
        int pt = field.indexOf('(');
        if (pt >= 0) field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  private class BaseCityField extends CityField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt < 0) pt = field.indexOf('<');
      if (pt >= 0) field = field.substring(0,pt).trim();
      return super.checkParse(field, data);
    }
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt < 0) pt = field.indexOf('<');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private class BasePlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(",")) return;
      super.parse(field, data);
    }
  }
  
  private class BaseAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      if (data.strApt.length() > 0) return;
      field = stripFieldStart(field, "#");
      data.strApt = field;
    }
  }
  
  private class BaseSourceField extends SourceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!sourcePattern.matcher(field).matches()) return false;
      super.parse(field, data);
      return true;
    }
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class BaseMap2Field extends MapField {
    public BaseMap2Field() {
      super("\\d{1,4}[A-Z]?", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(field, "/", data.strMap);
    }
  }
  
  private static final String PROQA_DISPATCH = "Medical ProQA recommends dispatch at this time";
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(PROQA_DISPATCH)) field = field.substring(PROQA_DISPATCH.length()).trim();
      else if (PROQA_DISPATCH.startsWith(field)) return;
      super.parse(field, data);
    }
  }
  
  private class BaseId2Field extends IdField {
    public BaseId2Field() {
      super("[A-Z]{2}\\d{9,10}", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCallId = append(field, "/", data.strCallId);
    }
  }
  
  private class BaseUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
}
