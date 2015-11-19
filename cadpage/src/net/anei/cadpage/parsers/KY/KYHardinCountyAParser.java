package net.anei.cadpage.parsers.KY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class KYHardinCountyAParser extends HtmlProgramParser {
  
  public KYHardinCountyAParser() {
    super("HARDIN COUNTY", "KY",
           "( COMMUNICATIONS DISPATCH ID1 DATETIME1 | ) " +
          "Nature:CALL! ( Business:PLACE! Address:ADDR! Addt_Address:SKIP! Cross:X!+ Subdivision:SKIP Neighborhood:SKIP Notes:INFO/N+ Hot_Spot:SKIP Premise:SKIP Units:UNIT STREET_NOTES INFO/N+ " +
                       "| Address:ADDR! Cross:X!+ Timeout:DATETIME2! Info:INFO+ )");
  }
  
  @Override
  public String getFilter() {
    return "noreply@hckysar.appspotmail.com,NO-REPLY@HCKY.ORG";
  }
  
  private static final Pattern SUBJECT_PTN1 = Pattern.compile("(Dispatch|Clear) Report Incident #(\\d{4})(\\d{6})");
  private static final Pattern SUBJECT_PTN2 = Pattern.compile("Incident: *(\\d{4})(\\d{6})");
  
  private boolean infoActive;
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    // We handle two variants of the same base format.  One if full fledged HTML,
    // the other has been stripped of  most html sequences and relies on 
    // newline field terminators
    infoActive = true;
    Matcher match = SUBJECT_PTN1.matcher(subject);
    if (match.matches()) {
      data.strCallId = match.group(2) + '-' + match.group(3);
      if (match.group(1).equals("Clear")) {
        setFieldList("ID");
        data.msgType = MsgType.RUN_REPORT;
        return true;
      } else {
        return super.parseHtmlMsg(subject, body, data);
      }
    } 
    
    // process the non-html version
    else {
      match = SUBJECT_PTN2.matcher(subject);
      if (!match.matches()) return false;
      data.strCallId = match.group(1) + '-' + match.group(2);
      body = decodeHtmlSequence(body).trim(); 
      body = body.replace('\t', ' ');
      return parseFields(body.split("\n"), data);
    }
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("COMMUNICATIONS")) return new SkipField("Communications");
    if (name.equals("DISPATCH")) return new SkipField("Dispatch");
    if (name.equals("ID1")) return new MyId1Field();
    if (name.equals("DATETIME1")) return new MyDateTime1Field();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME2")) return new MyDateTime2Field();
    if (name.equals("STREET_NOTES")) return new SkipField("Street Notes");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyId1Field extends IdField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" Report#:");
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }

  private static final Pattern DATE_TIME_PTN1 = Pattern.compile("Date: *(\\d\\d?/\\d\\d?/\\d\\d) +Time Out: *(\\d\\d?:\\d\\d)");
  private class MyDateTime1Field extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN1.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" MP:");
      if (pt >= 0) field = field.substring(0,pt).trim();
      field = stripFieldStart(field, "*");
      field = stripFieldEnd(field, "*");
      super.parse(field,  data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.indexOf(" City:");
      if (pt >= 0) {
        data.strCity = convertCodes(field.substring(pt+6).trim(), CITY_CODES);
        field = field.substring(0,pt).trim();
      }
      field = stripFieldStart(field, "*");
      field = stripFieldEnd(field, "*");
      super.parse(field, data);
      
      // See if they added a  "1" house number to what should be an intersection
      if (data.strAddress.startsWith("1 ") && data.strAddress.contains("&")) {
        data.strAddress = data.strAddress.substring(2).trim();
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private static final Pattern DATE_TIME_PTN2 = Pattern.compile("[A-Z][a-z]{2} ([A-Z][a-z]{2} \\d\\d \\d\\d:\\d\\d:\\d\\d) UTC (\\d{4})");
  private static final DateFormat DATE_TIME_FMT2 = new SimpleDateFormat("MMM dd HH:mm:ss yyyy");
  private class MyDateTime2Field extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      
      // The field contains a UTC time zone indicator, but it lies
      // Time is really relative to local time zone
      Matcher match = DATE_TIME_PTN2.matcher(field);
      if (!match.matches()) abort();
      setDateTime(DATE_TIME_FMT2, match.group(1) + ' ' + match.group(2), data);
    }
  }
  
  private static final Pattern INFO_SKIP_PTN = Pattern.compile(" *\\[\\d\\d[\\d[A-Z]/: ]*\\]?$|^(?:\\d\\d:\\d\\d:\\d\\d )?[A-Z]*\\] *|^\\d\\d:\\d\\d:\\d\\d *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("[*Begin PowerPhone") || field.startsWith("[Begin PowerPhone")) {
        infoActive = false;
        return;
      }
      if (field.startsWith("[*End PowerPhone") || field.startsWith("[End PowerPhone")) {
        infoActive = true;
        return;
      }
      if (!infoActive) return;
      
      field = INFO_SKIP_PTN.matcher(field).replaceAll(" ").trim();
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BIG",  "BIG CLIFTY",
      "CECI", "CECILIA",
      "EAST", "EASTVIEW",
      "ELIZ", "ELIZABETHTOWN",
      "FORT", "FORT KNOX",
      "GARF", "GARFIELD",
      "GLEN", "GLENDALE",
      "HODG", "HODGENVILLE",
      "LEBA", "LEBANON JUNCTION",
      "LRCO", "LARUE CO",
      "MULD", "MULDRAUGH",
      "NEWH", "NEW HAVEN",
      "RADC", "RADCLIFF",
      "RINE", "RINEYVILLE",
      "SONO", "SONORA",
      "UPTO", "UPTON",
      "VINE", "VINE GROVE",
      "WEST", "WEST POINT",
      "WHIT", "WHITE MILLS"

  });
}
