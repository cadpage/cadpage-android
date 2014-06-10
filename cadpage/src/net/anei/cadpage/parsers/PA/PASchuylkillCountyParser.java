package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Adams County, PA
 */
public class PASchuylkillCountyParser extends FieldProgramParser {
  
  public PASchuylkillCountyParser() {
    super(CITY_LIST, "SCHUYLKILL COUNTY", "PA",
          "RESPOND_TO:ADDRCITY! FOR_A:CODE_CALL! TRUCKS:UNIT! CN:PLACE INFO+");
  }

  @Override
  public String getFilter() {
    return "llewellynscanner@hotmail.com,ldaubert@hotmail.com,ldaubert@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldStart(body, "REPAGE ");
    body = body.replace(" FOR A:", "\nFOR A:");
    body = body.replace(" TRUCKS:", "\nTRUCKS:");
    return super.parseFields(body.split("\n"), 3, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("CODE_CALL")) return new MyCodeCallField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_INTERSECT_PTN = Pattern.compile("(.*?)-(\\d\\d)/(.*)");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_INTERSECT_PTN.matcher(field); 
      if (match.matches()) {
        parseAddress(match.group(1).trim() + " & " + match.group(3).trim(), data);
        data.strCity = convertCodes(match.group(2), CITY_CODES);
      }
      
      else {
        int pt = field.lastIndexOf('-');
        if (pt < 0) abort();
        parseAddress(field.substring(0,pt).trim(), data);
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, field.substring(pt+1).trim(), data);
        if (data.strCity.length() == 0) abort();
        data.strApt = getLeft();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY APT";
    }
  }
  
  private class MyCodeCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf('-');
      if (pt < 0) abort();
      data.strCode = field.substring(0,pt).trim();
      data.strCall = field.substring(pt+1).trim();
    }

    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static final String[] CITY_LIST = new String[] {

    // Cities
    "POTTSVILLE",

    // Boroughs
    "ASHLAND",
    "AUBURN",
    "COALDALE",
    "CRESSONA",
    "DEER LAKE",
    "FRACKVILLE",
    "GILBERTON",
    "GIRARDVILLE",
    "GORDON",
    "LANDINGVILLE",
    "MAHANOY CITY",
    "MCADOO",
    "MECHANICSVILLE",
    "MIDDLEPORT",
    "MINERSVILLE",
    "MOUNT CARBON",
    "NEW PHILADELPHIA",
    "NEW RINGGOLD",
    "ORWIGSBURG",
    "PALO ALTO",
    "PINE GROVE",
    "PORT CARBON",
    "PORT CLINTON",
    "RINGTOWN",
    "SCHUYLKILL HAVEN",
    "SHENANDOAH",
    "ST CLAIR",
    "TAMAQUA",
    "TOWER CITY",
    "TREMONT",

    //Townships
    "BARRY TWP",
    "BLYTHE TWP",
    "BRANCH TWP",
    "BUTLER TWP",
    "CASS TWP",
    "DELANO TWP",
    "EAST BRUNSWICK TWP",
    "EAST NORWEGIAN TWP",
    "EAST UNION TWP",
    "ELDRED TWP",
    "FOSTER TWP",
    "FRAILEY TWP",
    "HEGINS TWP",
    "HUBLEY TWP",
    "KLINE TWP",
    "MAHANOY TWP",
    "NEW CASTLE TWP",
    "NORTH MANHEIM TWP",
    "NORTH UNION TWP",
    "NORWEGIAN TWP",
    "PINE GROVE TWP",
    "PORTER TWP",
    "REILLY TWP",
    "RUSH TWP",
    "RYAN TWP",
    "SCHUYLKILL TWP",
    "SOUTH MANHEIM TWP",
    "TREMONT TWP",
    "UNION TWP",
    "UPPER MAHANTONGO TWP",
    "WALKER TWP",
    "WASHINGTON TWP",
    "WAYNE TWP",
    "WEST BRUNSWICK TWP",
    "WEST MAHANOY TWP",
    "WEST PENN TWP",

    // Census-designated places
    "ALTAMONT",
    "BEURYS LAKE",
    "BRANCHDALE",
    "BRANDONVILLE",
    "BUCK RUN",
    "CUMBOLA",
    "DELANO",
    "DONALDSON",
    "ENGLEWOOD",
    "FORRESTVILLE",
    "FOUNTAIN SPRINGS",
    "FRIEDENSBURG",
    "GRIER CITY",
    "HECKSCHERVILLE",
    "HEGINS",
    "HOMETOWN",
    "KELAYRES",
    "KLINGERSTOWN",
    "LAKE WYNONAH",
    "LAVELLE",
    "LOCUSTDALE",
    "MARLIN",
    "MCKEANSBURG",
    "MUIR",
    "NEWTOWN",
    "NUREMBERG",
    "ONEIDA",
    "ORWIN",
    "PARK CREST",
    "RAVINE",
    "REINERTON",
    "RENNINGERS",
    "SELTZER",
    "SHENANDOAH HEIGHTS",
    "SHEPPTON",
    "SUMMIT STATION",
    "TUSCARORA",
    "VALLEY VIEW",

    // Unincorporated communities
    "ANDREAS",
    "BROCKTON",
    "CONNERTON",
    "GINTHERS",
    "GOODSPRING",
    "HADDOCK",
    "HAUTO",
    "MANTZVILLE",
    "MAHONING VALLEY",
    "MARY D",
    "MOLINO",
    "ORWIN",
    "OWL CREEK",
    "SEEK",
    "SOUTH TAMAQUA",
    "STILL CREEK",
    "WEISHAMPLE"
  };
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "03", "BRANCH TWP",
      "11", "FOSTER TWP",
      "20", "MINERSVILLE",
      "22", "PORTER TWP",
      "33", "WASHINGTON TWP"
  });
}
