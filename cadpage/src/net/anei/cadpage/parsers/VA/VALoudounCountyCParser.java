package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class VALoudounCountyCParser extends FieldProgramParser {
  
  public VALoudounCountyCParser() {
    super("LOUDOUN COUNTY", "VA", 
          "( SELECT/1 CALL:CALL! PLACE:PLACE! ADDR:ADDR! CITY:CITY! ID:ID! PRI:PRI! DATE:DATE! TIME:TIME! MAP:MAP! UNIT:UNIT! INFO:INFO! INFO/N+ B:BOX! LOW_CROSS_STREET:X! HIGH_CROSS_STREET:X! RADIO_CHANNELS:CH! FDIDs:SKIP! LATITUDE:GPS1 LONGITUDE:GPS2 " +
          "| CALL ADDR ( X2! | APT X2! | APT PLACE X2! ) BOX! Units:UNIT! )");
  }
  
  @Override
  public String getFilter() {
    return "LCe911@loudoun.gov,@everbridge.net";
  }
  
  private static final Pattern MARKER2 = Pattern.compile("([A-Z]{4}-\\d{4}-\\d{8}):");
  private static final Pattern INFO_BRK_PTN = Pattern.compile("(?: +|(?<! ))(?=TEXT:|PROBLEM:|CAD RESPONSE:|DISPATCH LEVEL:)|(?<=[\\.\\)])(?=\\d{1,2}\\.)");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER2.matcher(body);
    if (match.lookingAt()) {
      setSelectValue("2");
      data.strCallId = match.group(1);
      body = body.substring(match.end()).trim();
      int pt = body.indexOf(". Remarks:");
      if (pt < 0) return false;
      String info = body.substring(pt+10).trim();
      body = body.substring(0,pt).trim();
      if (!parseFields(body.split(","), data)) return false;
      info = INFO_BRK_PTN.matcher(info).replaceAll("\n");
      data.strSupp = append(data.strSupp, "\n", info);
      return true;
    } else {
      setSelectValue("1");
      return parseFields(body.split("\n"), data);
    }
  }
  
  @Override
  public String getProgram() {
    return "ID? " + super.getProgram() + " INFO";
  }

  @Override
  public Field getField(String name) {
    if (name.equals("X2")) return new CrossField("btwn\\b[ /]*(.*)", true); 
    return super.getField(name);
  }
}
