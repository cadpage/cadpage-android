package net.anei.cadpage.parsers.KS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class KSBartonCountyParser extends FieldProgramParser {


  public KSBartonCountyParser() {
    super("BARTON COUNTY", "KS",
          "Call_Number:ID! Call_Received_Time:DATETIME_CALL_ADDR/SL! Description:INFO!");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("911 NOTIFY")) return false;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getFilter() {
    return "bcso@ruraltel.net";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d+");
    if (name.equals("DATETIME_CALL_ADDR")) return new MyDateTimeCallAddressField();
    return super.getField(name);
  }
  
  private static final Pattern DATETIME_CALL_ADDR_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d?:\\d\\d) (.*)");
  private static final Pattern MBLANK_PTN = Pattern.compile(" {2,}");
  private class MyDateTimeCallAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATETIME_CALL_ADDR_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      field = match.group(3).trim();
      field = MBLANK_PTN.matcher(field).replaceAll(" ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME CALL ADDR APT";
    }
  }
  
  private static CodeSet CALL_LIST = new CodeSet(
      "9-1-1 HANGUP/OPEN LINE",
      "ALARM",
      "ANIMAL COMPLAINT",
      "BREATHING PROBLEMS",
      "CHECK SUBJECT",
      "CHECK WELFARE",
      "CHILD IN NEED OF CARE",
      "DISTURBANCE",
      "DOMESTIC - 10-97",
      "DRIVING/DRIVER COMPLAINT",
      "FIRE (GRASS,TRASH,VEHICLE,UTILITY)",
      "GAS LEAK/SPILL",
      "INJURY ACCIDENT - 10-48",
      "MEDICAL ALARM",
      "NARCOTICS VI0LATION",
      "NON INJURY ACCIDENT - 10-47",
      "PM ANIMAL COMPLAINT",
      "PM BREATHING PROBLEMS",
      "PM SEX OFFENSE",
      "PM STRUCTURE FIRE",
      "STRUCTURE FIRE",
      "TRANSFER",
      "TRESPASSING/CRIM TRESPASSING",
      "WEATHER"
  );
}
