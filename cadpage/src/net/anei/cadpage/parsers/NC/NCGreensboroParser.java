package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
GreensBoro, NC
Contact: Jeff Boyers <jtboyers@gmail.com>
Sender: 93001050 (increments)

388:CAD@greensboro-nc.gov:CAD:FYI: ;1137919;CARDIAC / RESPIRATORY ARREST;1202 BILBRO ST;W WHITTINGTON ST;IRELAND ST;09E01
397:CAD@greensboro-nc.gov:CAD:1138157;STAB / GUNSHOT WOUND;707 W FLORIDA ST;DIST: 25.68 FT;HUDGINS DR;HUDGINS DR;27D01G;SMITH HOMES
392:CAD@greensboro-nc.gov:CAD:FYI: ;1138044;CARDIAC / RESPIRATORY ARREST;827 GARDENGATE RD;WOODEDGE DR;09E02
400:CAD@greensboro-nc.gov:CAD:1138253;BREATHING PROBLEMS;1515 WOODMERE DR;APT L;TEXTILE DR;PHILLIPS AV;06D02
393:CAD@greensboro-nc.gov:CAD:1138092;ACCIDENT WITH PERSONAL INJURY;E CONE BLVD/CHESHIRE WAY;DIST: 32.08 FT;29D02p
395:CAD@greensboro-nc.gov:CAD:1138115;ACCIDENT WITH PERSONAL INJURY;2615 HIGH POINT RD;MAYWOOD ST;W FLORIDA ST;SUNSET CLEANERS

*/

public class NCGreensboroParser extends DispatchOSSIParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d{1,4}:CAD@greensboro-nc.gov:");
  
  public NCGreensboroParser() {
    super("GREENSBORO", "NC",
           "FYI? ID CALL ADDR EXTRA? X+? CODE? PLACE");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    return super.parseMsg(body, data);
  }
  
  // FYI field should be skipped if present
  private class FYIField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      return field.equals("FYI:");
    }
  }
  
  // Extra information field
  private class ExtraField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("DIST:")) {
        data.strSupp = field;
        return true;
      }
      if (field.startsWith("APT ")) {
        data.strApt = field.substring(4).trim();
        return true;
      }
      return false;
    }
    
    @Override
    public String getFieldNames() {
      return "INFO APT";
    }
  }
  
  // Code field must  match specified pattern
  private class MyCodeField extends CodeField {
    MyCodeField() {
      setPattern(Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Za-z]?"));
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("FYI")) return new FYIField();
    if (name.equals("EXTRA")) return new ExtraField();
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
}
