package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Montgomery County, MD
 */
public class MDMontgomeryCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("\\* (D|\\d[a-z]{2}) \\*");
  private static final Pattern STATION_PTN = Pattern.compile("^Sent by Montgomery CAD to.*(FS\\d+),.* Montgomery CAD");
  
  public MDMontgomeryCountyParser() {
    super(CITY_CODES, "MONTGOMERY COUNTY", "MD",
          "BOX CALL ADDR UNIT!");
  }
  
	public String getFilter() {
		return "rc.355@c-msg.net,MC Emergency Network,@mcen.montgomerycountymd.gov,411911,MCEN";
	}
	
	@Override
	protected boolean parseMsg(String body, Data data) {
  
	  Matcher match = MARKER.matcher(body);
	  if (!match.find()) return false;
	  body = body.substring(match.end()).trim();
	  int pt = body.indexOf('\n');
	  if (pt >= 0) {
	    String extra = body.substring(pt+1).trim();
	    match = STATION_PTN.matcher(extra);
	    if (match.find()) data.strSource = match.group(1);
	    body = body.substring(0,pt).trim();
	  }
	  return parseFields(body.split("\\*"), 4, data);
	}
	
	@Override
	public String getProgram() {
	  return super.getProgram() + " SRC";
	}
	
	private final Field CITY_FIELD = new CityField();
	private class MyAddressField extends AddressField {
	  @Override
	  public void parse(String field, Data data) {
	    Parser p = new Parser(field);
	    field = p.get('(');
	    data.strPlace = p.get(')');
	    p = new Parser(field);
	    data.strPlace = append(p.getOptional('@'), " - ", data.strPlace);
	    super.parse(p.get(','), data);
      CITY_FIELD.parse(p.get(), data);
      if (data.strCity.equals("DC")) {
        data.strCity = "WASHINGTON";
        data.strState = "DC";
      }
    }
	  
	  @Override
	  public String getFieldNames() {
	    return super.getFieldNames() + " CITY ST PLACE";
	  }
	}
	
	@Override
	public Field getField(String name) {
	  if (name.equals("ADDR")) return new MyAddressField();
	  return super.getField(name);
	}
	
	@Override
	public String adjustMapAddress(String address) {
	  return address.replace("BIT AND SPUR", "BIT_AND_SPUR");
	}
	
	@Override
	public String postAdjustMapAddress(String address) {
    return address.replace("BIT_AND_SPUR", "BIT AND SPUR");
	}
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "C4",  "CHEVY CHASE",
      "CV",  "CHEVY CHASE",
      "DC",  "DC",
      "FH",  "FRIENDSHIP HEIGHTS",
      "GA",  "GAITHERSBURG",
      "MCG", "",
      "NC",  "NORTH CHEVY CHASE",
      "PG",  "PRINCE GEORGES COUNTY",
      "PO",  "POOLESVILLE",
      "RO",  "ROCKVILLE",
      "SS",  "SILVER SPRING",
      "TP",  "TACOMA PARK"
  });
}
/***
valid units consist of specific prefix followed by 3 digits.

A – Ambulance (BLS EMS Transport Unit)
AB – Air Boat
ALS – ALS Chase Car
AR – Air Unit
AT – Tower (Aerial Tower)
BC – Battalion Chief
DC – Duty Chief
E – Engine
ECC CAD – Emergency Communication Center CAD dispatch console
EMS – EMS Supervisor
EW – Engine Tanker
HM – Haz Mat
HSU – Haz Mat Support Unit
M – Medic (ALS EMS Transport Unit)
MAB – Medical Ambulance Bus (20 patient EMS transport unit)
MSU – Medical Support Unit (Mass casualty EMS supplies)
NCR – National Capital Region Communications Unit
RAT – Reserve Aerial Tower
RE – Reserve Engine
RECON – Urban Search & Rescue Recon Unit
RS – Rescue Squad (Heavy Rescue)
SOP – Special Operations Chief
T – Truck
U – Unit
W – Tanker (Water Tender)
XTP – Urban Search & Rescue Roll-off Transport Unit
***/  
