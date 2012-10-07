package net.anei.cadpage.parsers.ID;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class IDGoodingCountyParser extends FieldProgramParser {
  
  public IDGoodingCountyParser() {
    super(CITY_CODES, "GOODING COUNTY", "ID",
          "TIME SRC SKIP CALL ADDR! CITY");
  }
  
  @Override
  public String getFilter() {
    return "PagingService@sircomm.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals("SIRCOMM")) break;

      if (body.startsWith("SIRCOMM / ")) {
        body = body.substring(10).trim();
        break;
      }
      return false;
    } while (false);
    
    return parseFields(body.split("\n"), 5, data);
  }

  private class MySourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("NEW EVENT ")) abort();
      super.parse(field.substring(10).trim(), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField(TIME_FMT);
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("mm:ss aa");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "WND AREA", "WENDELL"
  });
}
