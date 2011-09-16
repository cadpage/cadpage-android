package net.anei.cadpage.parsers.DE;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Wilmington (brandywine), DE
Contact: "cmwetherby@aol.com" <cmwetherby@aol.com>
Contact: Michael DiMauro <mdimaurojr@gmail.com>
Contact: "backusgj@hotmail.com" <backusgj@hotmail.com>
Sender: brandywinefireco@comcast.net

06/06/2011*21:22*L1*SMOKE INVESTIGATION*8 E LEA BL btwn N MARKET ST & *PENNROSE
06/21/2011*06:01*ASSAULT - UNKNOWN*1202 FAIRVIEW AV btwn MAPLE AV*HOLLY OAK TERRACE*MALE SUBJECT MACED //NCCPD ENR
08/14/2011*08:19*CVA - NOT ALERT*207 ROWLAND PARK BL btwn HILLS*CARRCROFT
08/14/2011*16:00*L2*ELECTRICAL ODOR INSIDE*1304 HILLSIDE AV btwn W CLEARV*HOLLY OAK TERRACE
[Update]*08/10/2011*14:27*SYNCOPE - DIFF BREATHING*9 NEWARK UNION PUBLI RD btwn B*NORMANDY MANOR

 */


public class DEWilmingtonParser extends FieldProgramParser {
  
  public DEWilmingtonParser() {
    super("WILMINGTON", "DE",
           "DATE TIME PRI? CALL ADDR! PLACE INFO");
  }
  
  @Override
  public String getFilter() {
    return "brandywinefireco@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("*")) body = body.substring(1);
    return parseFields(body.split("\\*"), data);
  }
  
  private class DateField extends SkipField {
    public DateField() {
      setPattern(Pattern.compile("\\d\\d/\\d\\d/\\d{4}"), true);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  private class MyPriorityField extends PriorityField {
    public MyPriorityField() {
      setPattern(Pattern.compile("L\\d"));
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get(" btwn "), data);
      data.strCross = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new DateField();
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}


