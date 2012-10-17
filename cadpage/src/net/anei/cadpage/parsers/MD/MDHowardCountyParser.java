package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDHowardCountyParser extends FieldProgramParser {
  
  public MDHowardCountyParser() {
    super(CITY_CODES, "HOWARD COUNTY", "MD",
           "ADDR/S! TYPE:CALL! BEAT/BOX:BOX");
  }
  
  @Override
  public String getFilter() {
    return "Rc.261@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.startsWith("CAD") || subject.startsWith("hCAD")) break;
      
      if (subject.startsWith("Station ")) {
        data.strSource = subject;
        break;
      }
      if (body.startsWith("EVENT: ")) break;
      return false;
    } while (false);
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC ID " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      boolean id = field.startsWith("EVENT: ");
      if (id) field = field.substring(7).trim();
      Parser p = new Parser(field);
      if (id) data.strCallId = p.get(' ');
      String sAddr = p.get(": @");
      data.strPlace = p.get().replace(": @", " - ");
      p = new Parser(sAddr);
      p.getLastOptional(':');
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ID " + super.getFieldNames() + " APT PLACE";
    }
  }
  
  private static final Pattern TRAIL_JUNK_PTN = Pattern.compile("-\\**$");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String call = p.get('@');
      Matcher match = TRAIL_JUNK_PTN.matcher(call);
      if (match.find()) call = call.substring(0,match.start()).trim();
      data.strCall =  call;

      data.strTime = p.get(' ');
      
      String extra = p.get();
      if (data.strAddress.length() == 0) {
        Result res = parseAddress(StartType.START_ADDR, extra);
        if (res.getStatus() > 0) {
          res.getData(data);
          extra = getLeft();
          if (extra.startsWith("-"))  extra = extra.substring(1).trim();
        }
        data.strSupp = extra;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL TIME";
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) {
        data.strSupp = append(data.strSupp, " / ", field.substring(pt+1).trim());
        field = field.substring(0,pt);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "BOX INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("BOX")) return new  MyBoxField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return NS_PTN.matcher(sAddress).replaceAll("");
  }
  private static Pattern NS_PTN = Pattern.compile("\\bNS\\b", Pattern.CASE_INSENSITIVE);

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ANNJ", "ANNAPOLIS JUNCTION",
      "BWI",  "BWI AIRPORT",
      "CLK",  "CLARKSVILLE",
      "COOK", "COOKSVILLE",
      "DYTN", "DAYTON",
      "EC",   "ELLICOTT CITY",
      "ECOL", "COLUMBIA",
      "ECW",  "ELLICOTT CITY",
      "ELK",  "ELKRIDGE",
      "FULT", "FULTON",
      "GLNG", "GLENELG",
      "GLWD", "GLENWOOD",
      "HANR", "HANOVER",
      "HIGH", "HIGHLAND",
      "JSSP", "JESSUP",
      "LAUR", "LAUREL",
      "MARR", "MARRIOTTSVILLE",
      "MTAR", "MOUNT AIRY",
      "SAVG", "SAVAGE",
      "SCOL", "COLUMBIA",
      "SYKE", "SYKESVILLE",
      "WCOL", "COLUMBIA",
      "WDBN", "WOODBINE",
      "WDSK", "WOODSTOCK",
      "WF",   "WEST FRIENDSHIP",
     
  });
}
