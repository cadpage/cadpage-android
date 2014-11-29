package net.anei.cadpage.parsers.SD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Pennington County, SD
 */
public class SDPenningtonCountyParser extends FieldProgramParser {
  
  public SDPenningtonCountyParser() {
    super(CITY_LIST, "PENNINGTON COUNTY", "SD",
          "SRC UNIT CALL ADDR! X? INFO+? DATETIME END");
    setupCallList(CALL_LIST);
  }

  @Override
  public String getFilter() {
    return "dispatch@co.pennington.sd.us,dispatch@pennco.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals(".")) return parseFields(body.split("\\|"), 4, data);
    if (subject.equalsIgnoreCase("Dispatch")) return parseFireCall(body, data);
    if (subject.equalsIgnoreCase("MEDICAL")) return parseMedicalCall(body, data);
    return false;
  }

  // *************************************************************************
  // Parse new pipe delimited format
  // *************************************************************************
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new CrossField("Nearest Inter - *(.*)", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("; ", " ");
      super.parse(field, data);
    }
  }
  
  private static final Pattern ADDR_CITY_PTN = Pattern.compile("(.*?) *, *([A-Z ]+?) *, SD(?: +\\d{5})?");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_CITY_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1);
        data.strCity = match.group(2);
        fixCity(data);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private static final Pattern INFO_DATE_TIME_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d - *(.*)");
  private static final String TRUNC_DATE_TIME_MARK = "NN/NN/NN NN:NN:NN -";
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      for (String part : field.split(";")) {
        part = part.trim();
        if (part.length() == 0) continue;
        if (part.equalsIgnoreCase("None")) continue;
        Matcher match = INFO_DATE_TIME_PTN.matcher(part);
        if (match.matches()) {
          data.strSupp = append(data.strSupp, "\n", match.group(1));
        }
        else if (TRUNC_DATE_TIME_MARK.startsWith(part.replaceAll("\\d", "N"))) continue;
        else data.strSupp = append(data.strSupp, "; ", part);
      }
    }
  }

  // *************************************************************************
  // Parse old fire format
  // *************************************************************************
  private static final Pattern UNIT_PTN = Pattern.compile("^([A-Z0-9]+)(?: +\\(Primary\\))?; *");
  private static final Pattern UNIT_PTN2 = Pattern.compile("^([A-Z0-9]+) +(?:\\(Primary\\) +)?");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("[- ]*\\b(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d(?::\\d\\d)?)\\b[- ]*");
  private static final Pattern CITY_PTN = Pattern.compile("(.*?) *, *([A-Z ]+?) *, SD +\\d{5} *(.*?)");
  private static final Pattern CODE_PTN1 = Pattern.compile(" *\\bCode: *([-A-Z0-9]+): *");
  private static final Pattern CODE_PTN2 = Pattern.compile("^Code: *([-A-Z0-9]+): *");
  
  private boolean parseFireCall(String body, Data data) {
    setFieldList("UNIT CALL ADDR APT CITY CODE INFO DATE TIME");
    
    // Parser unit information
    while (true) {
      Matcher match = UNIT_PTN.matcher(body);
      if (!match.lookingAt()) break;
      data.strUnit = append(data.strUnit, " ", match.group(1));
      body = body.substring(match.end());
    }
    Matcher match = UNIT_PTN2.matcher(body);
    if (!match.lookingAt()) return false;
    data.strUnit = append(data.strUnit, " ", match.group(1));
    body = body.substring(match.end());
    
    // Process Date/time splits 
    match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      String save = body.substring(0,match.start());
      int last = match.end();
      String info = "";
      while (match.find()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
        info = append(info, "\n", body.substring(last,match.start()));
        last = match.end();
      }
      data.strSupp = append(info, "\n", body.substring(last));
      body = save;
    }
    
    String callAddr = null;
    match = CITY_PTN.matcher(body);
    if (match.matches()) {
      callAddr = match.group(1);
      data.strCity = match.group(2);
      body = match.group(3);
    } else {
      int pt = body.indexOf(',');
      if (pt >= 0) {
        String extra = body.substring(pt+1).trim();
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, extra, data);
        if (data.strCity.length() > 0) {
          callAddr =  body.substring(0,pt).trim();
          body = getLeft();
        }
      }
    }
    if (callAddr != null) {
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_IGNORE_AT | FLAG_NO_CITY | FLAG_ANCHOR_END, callAddr, data);
      if (data.strCode.length() == 0) {
        match = CODE_PTN2.matcher(body);
        if (match.find()) {
          data.strCode = match.group(1);
          body = body.substring(match.end());
        }
      }
      data.strSupp = append(data.strSupp, "\n", body);
    } else {
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_IGNORE_AT, body, data);
      if (data.strAddress.length() == 0) return false;
      String info = getLeft();
      match = CODE_PTN1.matcher(info);
      if (match.find()) {
        data.strCode = match.group(1);
        info = append(info.substring(0,match.start()), " / ", info.substring(match.end()));
      }
      data.strSupp = append(data.strSupp, "\n", info);
    }
    fixCity(data);
        
    return true;
  }

  private void fixCity(Data data) {
    if (data.strCity.equals("PENNCO")) data.strCity = "";
    else if (data.strCity.equals("JACKCO")) data.strCity = "JACKSON COUNTY";
    else if (data.strCity.equals("MEADCO")) data.strCity = "MEADE COUNTY";
  }
  

  // *************************************************************************
  // Parse old medical format
  // *************************************************************************
  private static final Pattern MED_SPLIT_PTN = Pattern.compile("(.*?)(?: +FOR +|  +)(.*)");
  private boolean parseMedicalCall(String body, Data data) {
    setFieldList("ADDR APT CITY CALL");
    body = stripFieldEnd(body, "[Attachment(s) removed]");
    Matcher match = MED_SPLIT_PTN.matcher(body);
    if (match.matches()) {
      parseAddress(StartType.START_ADDR, match.group(1), data);
      data.strCall = match.group(2);
      return true;
    }
    else {
      parseAddress(StartType.START_ADDR, body, data);
      data.strCall = getLeft();
      return data.strCall.length() > 0;
    }
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "AB",
      "AB-C",
      "ACC",
      "ACCI",
      "ALLERGY-C",
      "BACK",
      "BLEED-B",
      "BREATH",
      "BREATH-D1",
      "CARDIAC-E",
      "CHEST",
      "CHEST-D",
      "EMS",
      "FALARM DELTA",
      "FALARM",
      "FALL",
      "FALL-B",
      "FIRE",
      "GRASSF",
      "HEAD",
      "SICK",
      "SICK-C",
      "SMFIRE",
      "SICK PERSON DELTA LEVEL",
      "AB-C",
      "STBY",
      "STRUCF",
      "TRANSFER",
      "TRAUMA",
      "TRAUMA-B",
      "TRAUMA-D",
      "UNCON",
      "UNCON CHILD",
      "UNK",
      "VEHF",
      "VEHF-B1"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "PENNCO",
    
    "ASHLAND HEIGHTS",
    "COLONIAL PINE HILLS",
    "CREIGHTON",
    "GREEN VALLEY",
    "HILL CITY",
    "KEYSTONE",
    "NEW UNDERWOOD",
    "OWANKA",
    "QUINN",
    "RAPID CITY",
    "RAPID VALLEY",
    "WALL",
    "WASTA",
    "WICKSVILLE",
    "PENNCO",
    
    "ELK VALE",
    "ELLSWORTH AFB",
    "MUD BUTTE",
    "PIEDMONT",
    "TILFORD",
    "WHITE OWL",
    "BOX ELDER",
    "STURGIS",
    "BLACKHAWK",
    "SUMMERSET",
    "FAITH",
    "MEADCO"
  };
}
