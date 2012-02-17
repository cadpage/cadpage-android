package net.anei.cadpage.parsers.NV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Las Vegas, NV
Contact: Trevor Nelson <robs_trevor@yahoo.com>
Sender: sms@pageway.net
SMS / 725 12011164 Pri:4 Prob:Sch Grid:2625-1/11 3186 S MARYLAND PKWY Bld:ER Apt:25 Zip:89169
SMS / 725 12011200 Pri:4 Prob:Imm Grid:2429-1/11 61 N NELLIS BLVD Bld: Apt: Zip:89110
SMS / 725 12011221 Pri:5 Prob:Imm Grid:2826-1/11 2170 E HARMON AV Bld: Apt:324A Zip:89119
SMS / 725 12011269 Pri:5 Prob:Imm Grid:1823-1/11 2202 W CRAIG RD Bld: Apt: Zip:89032

*** Should not parse ***
SMS / 725 12011269 Disp:16:59:20 Enroute:16:59:27 On Scene:17:26:43 To Hosp:17:40:01 At Hosp:17:58:28

*/

public class NVLasVegasParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^SMS / 725 (\\d{8}) ");
  
  public NVLasVegasParser() {
    super("LAS VEGAS", "NV",
           "Pri:PRI! Prob:CALL! Grid:ADDR! Bld:APT! Apt:APT! Zip:CITY!");
  }
  
  @Override
  public String getFilter() {
    return "sms@pageway.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end()).trim();
    if (body.startsWith("Disp:"))  return false;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern ADDRESS_PTN = Pattern.compile("(\\d{4}-\\d/\\d{2}) +(.*)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDRESS_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strMap = match.group(1);
      super.parse(match.group(2), data);
    }
    
    @Override
    public String getFieldNames() {
      return "MAP " + super.getFieldNames();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
