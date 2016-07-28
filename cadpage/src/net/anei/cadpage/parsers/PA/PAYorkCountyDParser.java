package net.anei.cadpage.parsers.PA;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class PAYorkCountyDParser extends FieldProgramParser {
  
  public PAYorkCountyDParser() {
    super("YORK COUNTY", "PA",
          "DATE_TIME BOX:BOX_CALL! ADDR! CITY! APT_PLACE CROSS_STREETS:X_INFO! UNITS:UNIT! UNIT+", FLDPROG_IGNORE_CASE);
    setupProtectedNames("FISH AND GAME");
  }
  
  @Override
  public String getFilter() {
    return "york911alert@comcast.net,paging@ycdes.org,paging@zoominternet.net,messaging@iamresponding.com,j.bankert712@gmail.com,dtfdfilter@yahoo.com,pager@fairviewems.org";
  }
  
  private static final Pattern SUBJECT_SRC_PTN = Pattern.compile("Station \\d+");
  private static final Pattern TRAIL_JUNK_PTN = Pattern.compile("[ \n]\\[\\d{4}\\](?:$| *[-\n]| {3})");
  private static final Pattern IAR_PTN1 = Pattern.compile("(?!:BOX:|box:).*\n.*\n.*");
  private static final Pattern IAR_PTN2 = Pattern.compile("(?!BOX:|box:)(.*), ([^,]*) :(?: |$)(.*)");
  private static final Pattern BOX_PTN = Pattern.compile("BOX:", Pattern.CASE_INSENSITIVE);
  private static final Pattern DELIM = Pattern.compile(", |(?<!,) +(?=(?:box|cross streets|units):)", Pattern.CASE_INSENSITIVE);

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (SUBJECT_SRC_PTN.matcher(subject).matches()) data.strSource = subject;
    
    // Trim trailing garbage
    int pt = body.indexOf('\04');
    if (pt >= 0) body = body.substring(0,pt).trim();
    Matcher match = TRAIL_JUNK_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    
    // Undo IAR edits :(
    if (IAR_PTN1.matcher(body).lookingAt()) {
      body = "box: " + body.replace('\n', ',');
    } else {
      body = body.replace('\n', ' ');
    }
    
    if (subject.equals("WMTFD")) {
      if (!BOX_PTN.matcher(body).lookingAt()) body = "box: " + body;
    }
    else if (subject.equals("Station 68")) {
      match = IAR_PTN2.matcher(body);
      if (match.matches()) {
        body = "box: " + match.group(1) + ", cross streets:" + match.group(2) + " units:" + match.group(3);
      }
    }
    
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("DATE_TIME")) return new MyDateTimeField();
    if (name.equals("BOX_CALL")) return new MyBoxCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("APT_PLACE")) return new MyAptPlaceField();
    if (name.equals("X_INFO")) return new MyCrossInfoField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d{6})?\\b ?\\b(\\d\\d:\\d\\d:\\d\\d)?(?: (\\d\\d-\\d\\d-\\d\\d))?");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.matches()) {
        data.strTime = getOptGroup(match.group(2));
        data.strDate = getOptGroup(match.group(3)).replace('-', '/');
      }
    }
  }
  
  private static final Pattern BOX_CALL_PTN = Pattern.compile("(\\d+-\\d+) +(.*)");
  private static final Pattern CL_PTN = Pattern.compile("(CL \\d)\\b *(.*)");
  private class MyBoxCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = BOX_CALL_PTN.matcher(field);
      if (match.matches()) {
        data.strBox = match.group(1);
        field = match.group(2);
      }
      int pt = field.indexOf("  ");
      if (pt >= 0) {
        String place = field.substring(pt+2).trim();
        field = field.substring(0,pt);
        match = CL_PTN.matcher(place);
        if (match.matches()) {
          field = field + " " + match.group(1);
          place = match.group(2);
        }
        data.strPlace = place;
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "BOX CALL PLACE";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strPlace.equals(field)) data.strPlace = "";
      field = field.replace('@', '&');
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" BORO")) field = field.substring(0,field.length()-5).trim();
      super.parse(field, data);
      if (data.strCity.equalsIgnoreCase("BALTIMORE COUNTY")) data.strState = "MD";
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|ROOM|RM) *(.*)|(.*\\d.*)", Pattern.CASE_INSENSITIVE);
  private class MyAptPlaceField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        String apt = match.group(1);
        if (apt == null) apt = match.group(2);
        data.strApt = append(data.strApt, "-", apt);
      } else {
        data.strPlace = append(data.strPlace, " - ", field);
      }
    }

    @Override
    public String getFieldNames() {
      return "APT PLACE";
    }
  }
  
  private static final Pattern FL_CROSS_PTN = Pattern.compile("(\\d+[A-Za-z]* +FL)\\b *(.*)");
  
  private class MyCrossInfoField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = FL_CROSS_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = match.group(1);
        field = match.group(2);
      }
      if (field.toUpperCase().startsWith("NO CROSS STREETS FOUND")) {
        data.strSupp = field.substring(22).trim();
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_NO_IMPLIED_APT, field, data);
        data.strSupp = getLeft();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "APT X INFO";
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
}
