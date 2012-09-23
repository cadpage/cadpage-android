package net.anei.cadpage.parsers.NY;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class NYNassauCountyGParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("\\** *(.*?) *\\**");

  public NYNassauCountyGParser() {
    super("NASSAU COUNTY", "NY",
           "ADDR! C/S:X! ADTNL:INFO? HYDRNTS:INFO? TOA:TIMEDATE!");
  }
  
  @Override
  public String getFilter() {
    return "alertpaging@pwfd.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("** ALARM: ")) return false;
    subject = subject.substring(10).trim();
    if (subject.equals("UNKNOWN CALL TYPE")) {
      data.strCall = subject;
      subject = "*UNKNWN CALL TYPE*";
    } else {
      Matcher match = SUBJECT_PTN.matcher(subject);
      if (!match.matches()) return false;
      data.strCall = match.group(1);
    }
    if (!body.startsWith(subject)) return false;
    body = body.substring(subject.length()).trim();
    body = body.replace("HYDRNTS @", " HYDRNTS:HYDRNTS @");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String call = p.getOptional("  ");
      String place = p.getOptional("  ");
      super.parse(p.get(), data);
      if (call.length() >= 0 && place.length() == 0 && !CALL_SET.contains(call)) {
        place = call;
        call = "";
      }
      data.strCall = append(data.strCall, " - ", call);
      data.strPlace = place;
    }
    
    @Override
    public String getFieldNames() {
      return "CALL PLACE " + super.getFieldNames();
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int st = 0;
      if (field.startsWith("[")) st++;
      int end = field.length();
      if (field.endsWith("]")) end--;
      field = field.substring(st, end).trim();
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TIMEDATE")) return new TimeDateField("\\d\\d:\\d\\d \\d\\d?/\\d\\d?/\\d{4}", true);
    return super.getField(name);
  }
  
  private static final Set<String> CALL_SET = new HashSet<String>(Arrays.asList(new String[]{
      "AMBULANCE",
      "AUTOMATIC ALARM",
      "BUILD",
      "BUILDING",
      "CAR FIRE",
      "CARBON MONOXIDE",
      "CHIEF",
      "CHIEF CALL",
      "HAZMAT",
      "HOUSE",
      "INVES",
      "INVESTIGATION",
      "MUTUAL AID FIRE",
      "NATURAL GAS",
      "MVA",
      "PROPANE",
      "RES",
      "RESCUE/HEAVY RESCUE",
      "RUBBISH",
      "SCHOO",
      "SMOKE",
      "SMOKE IN AREA",
      "SPILL",
      "TRANSFORMER",
      "UNKNOWN",
      "WATER",
      "WIRE",
      "WIRES"
  }));
}
