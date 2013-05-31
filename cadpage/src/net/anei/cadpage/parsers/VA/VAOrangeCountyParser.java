package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class VAOrangeCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d\\d:\\d\\d)");
  private static final Pattern DELIM = Pattern.compile(" {2,}");
    
  
  public VAOrangeCountyParser() {
    super(CITY_LIST, "ORANGE COUNTY", "VA",
           "ADDR! CALL! [INCIDENT#]:ID! BOX:BOX Map:MAP");
  }
  
  @Override
  public String getFilter() {
    return "orange911@oorange.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() == 0) return false;
    if (!body.contains("[INCIDENT#]:")) {
      int pt = body.indexOf("[Orange911]  ");
      if (pt >= 0) return data.parseGeneralAlert(this, body.substring(pt+13).trim());
      return false;
    }

    do {
      Matcher match = SUBJECT_PTN.matcher(subject);
      if (match.matches()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
        break;
      }
    
      else if (!subject.contains(" ")) {
        data.strSource = subject;
        break;
      }
      
      return false;
    } while (false);
      
    int pt = body.indexOf("[LOCATION]:");
    if (pt > 0) body = body.substring(pt);
    body = body.replace("[NATURE]:", "").replace("[LOCATION]:", "");
    body = body.replace(" BOX ", "  BOX: ").replace(" Map ", "  Map: ");
    body =body.trim();
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "DATE TIME SRC " + super.getProgram() + " PLACE";
  }
  
  private class MyIdField extends IdField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCallId = p.get(' ');
      
      // The time field here appears to be an est incident time.  Which we
      // will use if we didn't get a dispatch time from the subject
      String sTime = p.get(' ');
      if (data.strTime.length() == 0) data.strTime = sTime;
      
      field = p.get();
      parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY, field, data);
      data.strCross = data.strPlace.replace("/", " / ");
      data.strPlace = "";
      data.strSupp = getLeft();
    }
    
    @Override
    public String getFieldNames() {
      return "ID X CITY INFO";
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Page ")) {
        field = field.substring(5).trim();
      } else {
        if ("Page ".startsWith(field)) return;
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("BOX")) return new MyBoxField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "GORDONSVILLE",
    "ORANGE",
    "BARBOURSVILLE",
    "LOCUST GROVE",
    
    "MADISON COUNTY",
    "CULPEPER COUNTY",
    "SPOTSYLVANIA COUNTY",
    "LOUISA COUNTY",
    "ALBEMARLE COUNTY",
    "GREENE COUNTY"
  };
}
