package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PABeaverCountyParser extends FieldProgramParser {
  
  public PABeaverCountyParser() {
    super(CITY_CODES, "BEAVER COUNTY", "PA",
           "EVENT_#:ID! LOC:ADDR/S! EST:SKIP? PLACE:PLACE? TYPE:CALL! TIME:TIME! COMMENTS:INFO");
  }
  
  @Override
  public String getFilter() {
    return "bc911cad@beavercountypa.gov,Beaver County 911";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("DISPATCH ALERT, ")) body = body.substring(16).trim();
    body = body.replace(": @", " PLACE:").replace(" Type:", " TYPE:");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALIQ", "ALIQUIPPA",
      "AMBR", "AMBRIDGE",
      "BADE", "BADEN",
      "BEAV", "BEAVER",
      "BEAF", "BEAVER FALLS",
      "BELA", "BELL ACRES",
      "BIGB", "BIG BEAVER",
      "BRID", "BRIDGEWATER",
      "BRIG", "BRIGHTON TWP",
      "CENT", "CENTER TWP",
      "CHIP", "CHIPPEWA TWP",
      "CONW", "CONWAY",
      "DARB", "DARLINGTON BORO",
      "DARL", "DARLINGTON TWP",
      "DAUG", "DAUGHERTY TWP",
      "EROC", "EAST ROCHESTER",
      "EVAL", "EASTVALE",
      "ECON", "ECONOMY",
      "FALS", "FALLSTON",
      "FRDM", "FREEDOM",
      "FRFK", "FRANKFORT SPRINGS",
      "FRAN", "FRANKLIN ",
      "GEOR", "GEORGETOWN",
      "GLAS", "GLASGOW",
      "GREN", "GREENE TWP",
      "HANO", "HANOVER TWP",
      "HARM", "HARMONY TWP",
      "HMWD", "HOMEWOOD",
      "HKTW", "HOOKSTOWN",
      "HPWL", "HOPEWELL TWP",
      "INDE", "INDEPENDENCE TWP",
      "INDU", "INDUSTRY",
      "KOPP", "KOPPEL",
      "LETP", "LEET TWP",
      "MARI", "MARION TWP",
      "MIDL", "MIDLAND",
      "MONA", "MONACA",
      "NEWB", "NEW BRIGHTON",
      "NEWG", "NEW GALILEE",
      "NWSE", "NEW SEWICKLEY TWP",
      "NOSE", "NORTH SEWICKLEY TWP",
      "OHVL", "OHIOVILLE",
      "PRHT", "PATTERSON HEIGHTS",
      "PATT", "PATTERSON TWP",
      "POTT", "POTTER TWP",
      "PULA", "PULASKI TWP",
      "RACC", "RACCOON TWP",
      "ROCH", "ROCHESTER BORO",
      "ROCT", "ROCHESTER TWP",
      "SPPT", "SHIPPINGPORT",
      "SOBE", "SOUTH BEAVER TWP",
      "SOHT", "SOUTH HEIGHTS",
      "VANP", "VANPORT TWP",
      "WMYF", "WEST MAYFIELD",
      "WHIT", "WHITE"
  });
}
