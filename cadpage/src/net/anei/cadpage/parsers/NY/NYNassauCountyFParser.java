package net.anei.cadpage.parsers.NY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNassauCountyFParser extends FieldProgramParser {
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm aa");

  public NYNassauCountyFParser() {
    super("NASSAU COUNTY", "NY",
           "CALL TIME ADDR CITY X X INFO PHONE!");
  }
  
  @Override
  public String getFilter() {
    return "2ndSignal@2sig.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.trim().equals("*")) return false;
    if (body.endsWith(" support@2sig.com")) {
      body = body.substring(0,body.length()-17).trim();
    }
    return parseFields(body.split("\n"), 6, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField(TIME_FMT);
    return super.getField(name);
  }
}


