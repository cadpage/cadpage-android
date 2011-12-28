package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Delaware County, PA (variant D, possibly superseded by variant E
Contact: chris smith <csmith045@verizon.net>
Sender: oakmont1@comcast.net

09:06\nE BENEDICT AV & W DARBY RD\nSTREET CLOSED\nE BENEDICT AV\nW DARBY RD\n08/16/2011\nSTREET\nSTA38\nF11046756\nE BENEDICT BETWEEN DARB
11:42\n616 VALLEY VIEW RD\nAUTOMATIC FIRE ALARM\nHAVERFORD RD\nWESTFIELD RD\n10/17/2011\nALARM\nSTA38\nF11060706\n~GENERAL,~SEVERAL SIGNAL
09:29\n5030 BRITTANY LN\nACCIDENTAL TRIP OF FIRE ALARM\nBRENNAN DR\nSPROUL RD\n10/17/2011\nALARM\nENG38\nF11060680\n~TRIPPED /BY STEAM,610
18:25\n300 E EAGLE RD\nAUTOMATIC FIRE ALARM\nSAINT DENIS LN\nSAINT DENIS LN\n10/13/2011\nALARM\nENG38\nF11059917\n610-446-4608,ESZ 3815,~G
17:54\n601 OVERHILL RD\nAUTOMATIC FIRE ALARM\nHAVERFORD RD\nWESTFIELD RD\n10/12/2011\nALARM\nENG38\nF11059705\n~ZONE 014,RES SEIMEN,610-65
12:57\n421 BROOKLINE BLVD\nAUTOMATIC FIRE ALARM\nWEXFORD RD\nEARLINGTON RD\n10/12/2011\nALARM\nLA38/ENG56/RE56/FO35\nF11059648\n610-446-84
09:29\n5030 BRITTANY LN\nACCIDENTAL TRIP OF FIRE ALARM\nBRENNAN DR\nSPROUL RD\n10/17/2011\nALARM\nENG38\nF11060680\n~TRIPPED /BY STEAM,610
13:36\n838 AUBREY AV\nAUTOMATIC FIRE ALARM\nSAINT MARYS RD\nCOUNTY LINE RD\n10/14/2011\nALARM\nENG38\nF11060114\n~ HALLWAY SMOKE DET,1068 

Contact: George Millison <george.millison@colonialelectric.com>
18:03\nHAVERFORD RD & WOODCREST AV\nFD INVESTIGATION\nHAVERFORD RD\nWOODCREST AV

*/

public class PADelawareCountyDParser extends FieldProgramParser {
  
  public PADelawareCountyDParser() {
    super("DELAWARE COUNTY", "PA",
           "TIME! ADDR X/Z!+? DATE! CALL! UNIT! ID! INFO");
  }
  
  @Override
  public String getFilter() {
    return "oakmont1@comcast.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  private class MyTimeField extends TimeField {
    public MyTimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  private class MyDateField extends DateField {
    public MyDateField() {
      setPattern(Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d"), true);
    }
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("F\\d{8}"), true);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('~', ' ').trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
