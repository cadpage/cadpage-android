package net.anei.cadpage.parsers.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class XXAcadianAmbulanceParser extends FieldProgramParser {
  
  public XXAcadianAmbulanceParser(String defState) {
    super("", defState,
           "CALL! Loc:PLACE! Add:ADDR! APT:APT? Cross_St:X! City:CITY! Cnty:CITY! Map_Pg:MAP Dest:INFO Pt's_Name:NAME");
  }
  
  @Override
  public String getFilter() {
    return "commcenter@acadian.com";
  }
  
  private static final Pattern MARKER = Pattern.compile("^Resp(?:onse)?#:?(\\d+(?:-\\d{4})?) +");
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    body = body.replace("Add:", " Add:").replace("APT:", " APT:").replace("City:", " City:").replace("Cnty:", " Cnty:");
    if (!super.parseMsg(body, data)) return false;
    
    // There is one particular long, oft abbreviated road in Harris County, TX 
    // that always causes trouble
    if (data.defState.equals("TX") &&
        data.strCity.toUpperCase().startsWith("HARRIS")) {
      int pt = data.strAddress.lastIndexOf(' ');
      if (pt >= 0) {
        pt = data.strAddress.lastIndexOf(' ', pt-1);
        if (pt >= 0) {
          String tag = data.strAddress.substring(pt+1).toUpperCase();
          if ("HUFFMAN CLEVELAND RD".startsWith(tag)) {
            data.strAddress = data.strAddress.substring(0,pt+1) + "Huffman-Cleveland Rd";
          }
        }
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("  +", " ");
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.endsWith(" County") && data.strCity.startsWith(field)) return;
      data.strCity = append(data.strCity, ", ", field);
    }
  }
}
