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
      "FRED", "FREDERICK COUNTY",
      "GA",  "GAITHERSBURG",
      "HC",  "HOWARD COUNTY",
      "KE",  "KENSINGTON",
      "LA",  "LAYTONSVILLE",
      "MCG", "",
      "NC",  "NORTH CHEVY CHASE",
      "PG",  "PRINCE GEORGES COUNTY",
      "PO",  "POOLESVILLE",
      "RO",  "ROCKVILLE",
      "SS",  "SILVER SPRING",
      "SO",  "SOMERSET",
      "TP",  "TACOMA PARK"
      
  });
}
