package net.anei.cadpage.parsers.AR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ARBentonCountyBParser extends FieldProgramParser {

  public ARBentonCountyBParser() {
    super(CITY_LIST, "BENTON COUNTY", "AR", "Location:ADDR/Sx Map:MAP Cross_Streets:X Call_Type:CALL Narrative:INFO+ Call_Time:DATETIME Incident_Number:ID Units:UNIT");
  }
  
  @Override
  public int getMapFlags() {
    return MsgInfo.MAP_FLG_SUPPR_AND_ADJ;
  }

  private static Pattern UNDERSCORES = Pattern.compile(" +_* *");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    // replace " +_* *" patterns with single space
    Matcher uMat = UNDERSCORES.matcher(body);
    body = uMat.replaceAll(" ");

    return super.parseMsg(body, data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("MAP")) return new MapField("Map *(.*?)");
    return super.getField(name);
  }

  private static Pattern TRIMMED_COMMA = Pattern.compile(" *, *");

  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      //Split state, and save if it isn't AR
      String[] fields = TRIMMED_COMMA.split(field);
      if (!fields[1].equals("AR")) data.strState = fields[1];
      parseAddress(StartType.START_ADDR, fields[0], data);
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY ST";
    }
  }
  
  private static Pattern CALL_PRI = Pattern.compile("(.*?) *(?:Pri *(.*))?");
  
  private class MyCallField extends Field {

    @Override
    public void parse(String field, Data data) {
      //Grab and save Call and Pri from field
      Matcher cpMat = CALL_PRI.matcher(field);
      if (!cpMat.matches()) abort();
      data.strCall = cpMat.group(1);
      data.strPriority = getOptGroup(cpMat.group(2));
    }

    @Override
    public String getFieldNames() {
      return "CALL PRI";
    }
    
  }

  private static String[] CITY_LIST = new String[] {
  "AVOCA",
  "BELLA VISTA",
  "BENTON COUNTY",
  "BENTONVILLE",
  "BETHEL HEIGHTS",
  "CAVE SPRINGS",
  "CENTERTON",
  "DECATUR",
  "ELM SPRINGS",
  "GARFIELD",
  "GATEWAY",
  "GENTRY",
  "GRAVETTE",
  "HIGHFILL",
  "LITTLE FLOCK",
  "LOWELL",
  "PEA RIDGE",
  "ROGERS",
  "SILOAM SPRINGS",
  "SPRINGDALE",
  "SPRINGTOWN",
  "SULPHUR SPRINGS",
  "WAR EAGLE"};
  
}
