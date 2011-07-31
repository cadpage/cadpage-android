package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Harris County ESD #1, TX
Contact: Nathan Mathews <nbmathews807@gmail.com>
Sender: cadnoreply@proxy.hcec.com
ID#:11-06-20685 - - TRASH FIRE - 111 Bayou Dr - Apt:C - Bldg: - Key Map: 498D - Cross Streets:EAST FWY/MARKET - Box #:2002
ID#:11-06-20710 - - FIRE - PreAlert - 16217 Ridlon - Apt: - Bldg: intra SERVICES - Key Map: 498C - Cross Streets:SHEILA LN/WOODLAND D
ID#:11-06-20658 - - 29A1 MOTOR VEHICLE A - East Fwy / Delldale - Apt: - Bldg: - Key Map: 498E - Cross Streets: - Box #:2004
ID#:11-06-20627 - - 29A1 MOTOR VEHICLE A - 16410 Ave D - Apt:1 - Bldg: AVE D APTS - Key Map: 498D - Cross Streets:WOODLAND DR/CEDAR L

*** NOT IMPLEMENTED YET ***
ID#:11-07-25331 - - ALARMS - 1518 Great Dover Cir - Apt: - Bldg: - Key Map: 458W
ID#:11-07-25331 - UNIT:L32 - DISP: 10:27:45 - ER: 10:27:49 - OUT: 10:41:48 - TO:
ID#:11-07-25341 - 06D02 - 6D1 RESPIRATORY - 11870 Greenloch Ln - Apt: - Bldg: - Key Map: 416K - Cross Streets:GREENCANYON DR/GREENROC 
ID#:11-07-25342 - 25A01 - PSYCHIATRIC - 15215 S Brentwood Dr - Apt: - Bldg: - Ke
ID#:11-07-25342 - 25A01 - PSYCHIATRIC - 15215 S Brentwood Dr - Apt: - Bldg: - Ke
y Map: 498E - Cross Streets:Dead End/DELLDALE - Box #:2004

*/


public class TXHarrisCountyESD1BParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" *(?: -)+ *| *(?:- )+ *");

  public TXHarrisCountyESD1BParser() {
    super("HARRIS COUNTY", "TX",
           "ID:ID! CODE? CALL! PREALERT? ADDR! Apt:APT! Bldg:APT! Key_Map:MAP% Cross_Streets:X Box:BOX");
  }
  
  @Override
  public String getFilter() {
    return "cadnoreply@proxy.hcec.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace("ID#:","ID:").replace("Box #:", "Box:");
    return parseFields(DELIM.split(body), data);
  }
  
  // Code field has to fit specific pattern
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Za-z]?"));
    }
  }
  
  // PreAlert is a special call extender field
  private class PreAlertField extends CallField {
    
    public PreAlertField() {
      setPattern(Pattern.compile("PreAlert"));
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  // There are two fields, APT and BLD mapped to the apartment field.  But they
  // occur in reverse order, if both are specified, we want to to put bldg first.
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      data.strApt = append(field, "-", data.strApt);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("PREALERT")) return new PreAlertField();
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
}
