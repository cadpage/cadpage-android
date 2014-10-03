package net.anei.cadpage.parsers.LA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lafayette Parish, LA
*/

public class LALafayetteParishParser extends FieldProgramParser {

  public LALafayetteParishParser() {
    super("LAFAYETTE PARISH","LA", 
        "DATE_TIME_SRC! Addr:ADDR! Cross:X! Inc_Type:CODE! REMARKS! EXTRA+");
  }
  
  @Override
  public String getFilter() {
    return "cadalert@lafayettela.gov,alerts@carencrofd.org";
  }
  
  @Override
  protected boolean parseMsg(String field, Data data) {
    return parseFields(field.split("\n+"), 5, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE_TIME_SRC")) return new MyDateTimeSourceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("REMARKS")) return new IdField("Remarks >RPT#< (\\d\\d-\\d{8})", true);
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }

  private static final Pattern DATE_TIME_SRC_PTN = Pattern.compile("Date:(\\d\\d/\\d\\d/\\d{4}) Time:(\\d\\d:\\d\\d)EQPT:(\\d+)");
  private class MyDateTimeSourceField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_SRC_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strSource = match.group(3);
    }

    @Override
    public String getFieldNames() {
      return "DATE TIME SRC";
    }
  }
  
  private static final Pattern ADDR_CITY_PTN = Pattern.compile("(.*)\\.([A-Z])");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_CITY_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strCity = convertCodes(match.group(2), CITY_CODES);
      }
      super.parse(field, data);
    }
    
    @Override
    public String  getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }

  private static final Pattern EXTRA_TIME_OP_PTN = Pattern.compile("(.*) \\d{4},\\d{3}");
  private static final Pattern EXTRA_CALL_PTN = Pattern.compile("F>>IC< *(.*?)(?: \\d{6})?");
  private static final Pattern EXTRA_PHONE_PTN = Pattern.compile("(?:\\d{3})?\\d{7}");
  private static final Pattern EXTRA_GPS_PTN = Pattern.compile("\\bLat=([-+]\\d+\\.\\d{4,}) Long=([-+]\\d+\\.\\d{4,})\\b");
  private class MyExtraField extends Field {
    @Override
    public void parse(String field, Data data) {
      
      Matcher match = EXTRA_CALL_PTN.matcher(field);
      if (match.matches()) {
        data.strCall = append(data.strCall, " / ", match.group(1));
        return;
      }
      
      match = EXTRA_TIME_OP_PTN.matcher(field);
      if (match.matches()) field = match.group(1).trim();
      field = stripFieldStart(field, "F>");
      
      if (EXTRA_PHONE_PTN.matcher(field).matches()) {
        data.strPhone = field;
        return;
      }
      
      match = EXTRA_GPS_PTN.matcher(field);
      if (match.find()) {
        setGPSLoc(match.group(1) + ',' + match.group(2), data);
      }
      
      data.strSupp = append(data.strSupp, "\n", field);
    }

    @Override
    public String getFieldNames() {
      return "CALL PHONE INFO GPS";
    }
    
  }
  
  @Override
  public String adjustMapAddress(String sAddress, boolean cross) {
    sAddress = TW_PTN.matcher(sAddress).replaceAll("THRUWAY");
    if (cross) {
      Matcher match = CROSS_HOUSE_PTN.matcher(sAddress);
      if (match.matches()) sAddress = match.group(1);
    }
    return super.adjustMapAddress(sAddress, cross);
  }
  private static final Pattern TW_PTN = Pattern.compile("\\bTW\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern CROSS_HOUSE_PTN = Pattern.compile("\\d+ +(.*)");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "B", "BROUSSARD",
      "C", "CARENCRO",
      "D", "DUSON",
      "L", "LAFAYETTE",
      "P", "LAFAYETTE PARISH",
      "S", "SCOTT",
      "Y", "YOUNGSVILLE"

  });
}
