package net.anei.cadpage.parsers.NY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNassauCountyFParser extends FieldProgramParser {
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm aa");

  public NYNassauCountyFParser() {
    super("NASSAU COUNTY", "NY",
           "CALL CALL CALL CALL ADDR CITY PHONE!");
  }
  
  @Override
  public String getFilter() {
    return "2ndSignal@2sig.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (body.endsWith(" support@2sig.com")) {
      body = body.substring(0,body.length()-17).trim();
    }
    return parseFields(body.split("\n"), 6, data);
  }
  
  private class MyCallField extends CallField {
    @Override 
    public void parse(String field, Data data) {
      // Odd duplicated call fields
      int len = field.length();
      if ((len % 2) == 0) {
        len /= 2;
        String tmp = field.substring(0,len);
        if (tmp.equals(field.substring(len))) field = tmp;
      }
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("TIME")) return new TimeField(TIME_FMT);
    return super.getField(name);
  }
}


