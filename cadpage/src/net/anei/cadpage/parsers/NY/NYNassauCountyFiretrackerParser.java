package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYNassauCountyFiretrackerParser extends FieldProgramParser {
  
  private static final Pattern FFD_MARKER = Pattern.compile("^\\*\\* FFD [^\\*]+ \\*\\* ");
  private static final Pattern FD_MARKER = Pattern.compile("^\\*\\* *([A-Z]{3,4})(?: ([ A-Z0-9]+?))? *\\*\\* +");
  
  public NYNassauCountyFiretrackerParser() {
    super("NASSAU COUNTY", "NY", 
           "ADDR/SCP! C/S:X DATE:DATE TOA:TIME Town_Of:CITY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@firetracker.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (body.startsWith("FirePage / ")) body = body.substring(11).trim();
    
    int pt = body.lastIndexOf('[');
    if (pt < 0) return false;
    if (! "[FireTracker]".startsWith(body.substring(pt))) return false;
    body = body.substring(0,pt).trim();
    
    if (body.startsWith("*FSMFD* ") || body.startsWith("FSMFD ")) {
      data.strSource = "FSMFD";
      Parser p = new Parser(body);
      p.get(' ');
      data.strDate = p.get("TOA:");
      data.strTime = p.get(" ");
      data.strCall = p.get('[');
      p.get(']');
      body = p.get();
      if (body.length() == 0) return false;
      body = body.replace('\n', ' ');
      parseAddress(StartType.START_ADDR, body, data);
      body = getLeft();
      Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
      if (res.getStatus() > 0) {
        res.getData(data);
        body = res.getLeft();
      }
      data.strSupp = body;
      return true;
      
    }

    do {
      Matcher match;
      if ((match = FFD_MARKER.matcher(body)).find()) {
        data.strSource = "FFD";
        body = body.substring(match.end()).trim();
        break;
      }
      if ((match = FD_MARKER.matcher(body)).find()) {
        data.strSource = match.group(1);
        data.strCall = getOptGroup(match.group(2));
        body = body.substring(match.end()).trim();
        break;
      }
      return false;
    } while (false);
    
    body = body.replace('\n', ' ');

    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) {
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    return true;
  }
  
  private static final Pattern APT_PTN = Pattern.compile("\\bAPT ([^ ]+)\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (match.find()) {
        data.strApt = match.group(1);
        field = field.substring(0,match.start()) + field.substring(match.end());
      }
      
      StartType st = StartType.START_CALL;
      int flags = FLAG_START_FLD_REQ;
      String connect = " - ";
      while (field.length() > 0) {
        int stchr = field.charAt(0);
        if (stchr != '[' && stchr != '(') break;
        int pt = field.indexOf(stchr == '[' ? ']' : ')', 1);
        if (pt < 0) break;
        String call = stchr == '[' ? field.substring(1,pt).trim() : field.substring(0,pt+1);
        if (!data.strCall.equals(call)) {
          data.strCall = append(data.strCall, connect, call);
        }
        field = field.substring(pt+1).trim();
        st = StartType.START_PLACE;
        flags = 0;
        connect = " ";
      }
      parseAddress(st, flags, field, data);
      data.strPlace = append(data.strPlace, " - ", getLeft());
    }
  }
  
  private  static final Pattern CROSS_MAP_PTN = Pattern.compile("^[A-Z]-\\d\\b");
  private class MyCrossField extends CrossField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("-DEAD END-", " DEAD END ").replaceAll("  +", " ");
      Parser p = new Parser(field);
      super.parse(p.get(" - "), data);
      String extra = p.get();
      Matcher match = CROSS_MAP_PTN.matcher(extra);
      if (match.find()) {
        data.strMap = match.group();
        extra = extra.substring(match.end()).trim();
      }
      data.strCall = append(data.strCall, " - ", extra);
    }
    
    @Override
    public String getFieldNames() {
      return "X MAP CALL";
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strTime = p.get(' ');
      if (data.strDate.length() == 0) data.strDate = p.get();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
