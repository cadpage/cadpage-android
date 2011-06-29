package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Camden County, GA
Contact: "croney kingslandgeorgia.com" <croney@kingslandgeorgia.com>
Sender: astudstill@co.camden.ga.us
astudstill@co.camden.ga.us:2011-101695* HIGHWAY 17 STEFFANS* * * KINGSLAND* * Traffic Stop* TRAFFIC STOP* * * 1128,1140,1150,1152,509,514,523,532,LS3,R3* * Med
astudstill@co.camden.ga.us:2011-104696* 4059 MARTIN LUTHER KING BLVD* N4* * 514,541,546,ENG4,LS4,MED4 KINGSLAND* * INJURY* INJURY* 509,ENG5,LS3* * Medical: No
astudstill@co.camden.ga.us:2011-101995* 405 & HIGHWAY 40 OLD WAFFLE HOUSE* * * KINGSLAND* * ACCIDENT* ACCIDENT* ELAINE* 386-208-4465* 514,541,546,ENG4,LS4,MED4
astudstill@co.camden.ga.us:2011-104843* 429 EAGLE BLVD* * * KINGSLAND* * PERSON SICK* PERSON SICK* * 540,ENG4,LS4* * Medical: No* Haz

*/
public class GACamdenCountyParser extends FieldProgramParser {
  
  private static final String[] MARKER_LIST = new String[]{
    "astudstill@co.camden.ga.us:"
  };
  private static final Pattern DELIM = Pattern.compile("\\*(?: \\*)*");
  
  public GACamdenCountyParser() {
    super("CAMDEN COUNTY", "GA",
           "ID ADDR/SXP APT? CITY CALL SKIP ( NAME PHONE | ) UNIT INFO+");
  }
  
  @Override
  public String getFilter() {
    return "astudstill@co.camden.ga.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    boolean found = false;
    for (String mark : MARKER_LIST) {
      if (body.startsWith(mark)) {
        found = true;
        body = body.substring(mark.length()).trim();
      }
    }
    if (!found) return false;
    
    return parseFields(DELIM.split(body), data);
  }
  
  private class MyAptField extends AptField {
    public MyAptField() {
      setPattern(Pattern.compile("[-A-Z0-9]{1,3}"));
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("^[^ ]*,[^ ]* ");
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end()).trim();
      super.parse(field, data);
    }
  }
  
  private class MyNameField extends NameField {
    public MyNameField() {
      setPattern(Pattern.compile("[^,]{4,}"));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }
}
