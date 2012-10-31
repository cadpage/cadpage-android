package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYNassauCountyFiretrackerParser extends FieldProgramParser {
  
  private static final Pattern FFD_MARKER = Pattern.compile("^\\*\\* FFD [^\\*]+ \\*\\* ");
  private static final Pattern FD_MARKER = Pattern.compile("^\\*{0,2}([A-Z]{1,3}FD)\\*{0,2} +");
  
  public NYNassauCountyFiretrackerParser() {
    super("NASSAU COUNTY", "NY", 
           "ADDR/SCP! C/S:X TOA:TIME Town_Of:CITY");
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
    
    if (body.startsWith("*FSMFD* ") || body.startsWith("FSMFD")) {
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
        body = body.substring(match.end()).trim();
        break;
      }
      return false;
    } while (false);
    
    body = body.replace('\n', ' ');

    return super.parseMsg(body, data);
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
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strSupp = p.getLastOptional(" - ");
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "X INFO";
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strTime = p.get(' ');
      data.strDate = p.get();
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
