package net.anei.cadpage.parsers.AZ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class AZYavapaiCountyCParser extends FieldProgramParser {

	public AZYavapaiCountyCParser() {
		super(CITY_CODES, "YAVAPAI COUNTY", "AZ", "SRC ( BOX | SRC? ) CALL ADDR UNIT/S! INFO/N+? A8 EMPTY+? X? DATETIME?");
	}
	
	@Override
	public boolean parseMsg(String subject, String body, Data data) {
	  //check subject
	  if (!subject.equals("Message from HipLink")) return false;
	  
	  return parseFields(body.split("\n"), data);
	}
	
	@Override
  public Field getField(String name) {
	  if (name.equals("SRC")) return new MySourceField();
	  if (name.equals("BOX")) return new BoxField("\\d+", true);
	  if (name.equals("ADDR")) return new MyAddressField();
	  if (name.equals("INFO")) return new MyInfoField();
	  if (name.equals("A8")) return new InfoField("(?:[A-Z]\\d{8})?"); //i have no idea what this field is
	  if (name.equals("X")) return new MyCrossField();
	  if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
	
	//make SRC append with " " and give vali pattern
	private class MySourceField extends SourceField {
	  public MySourceField() {
	    super("[A-Z]+", true);
	  }

	  @Override
	  public void parse(String field, Data data) {
	    data.strSource = append(data.strSource, " ", field);
	  }
	}
	
	
	private static Pattern ADDR_CITY = Pattern.compile("(.*?),([A-Z]+)?");
	private static Pattern SORTER = Pattern.compile("(?:AREA (.*)|((?:APT|RM|ROOM|UNIT) .*)|#?(\\d+[A-Z]?)|(ST[AN] [^ ]+)|(?:NORTH|SOUTH|EAST|WEST)BOUND)", Pattern.CASE_INSENSITIVE);
  //field is ADDR(;(MAP|APT|UNIT|[NSEW]BOUND|PLACE))+,CITY
	private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      //remove leading empty fields ( 2 occurrences in pages )
      while (field.startsWith(";")) field = field.substring(1).trim();
      //parse ADDR and CITY
      Matcher mat = ADDR_CITY.matcher(field);
      if (!mat.matches()) abort();
      String[] fields = mat.group(1).split(" *; *");
      //ADDR
      super.parse(fields[0], data);
      //CITY
      String g2 = mat.group(2);
      if (g2 != null) parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, g2, data);
      
      //parse intermediate fields
      for (int i = 1; i < fields.length; i++) {
        Matcher imat = SORTER.matcher(fields[i]);
        //if no match, append to PLACE
        if (!imat.matches()) { data.strPlace = append(data.strPlace, ", ", fields[i]); continue; }
        //MAP
        String group = imat.group(1);
        if (group != null) { data.strMap = append(data.strMap, ", ", group); continue; }
        //APT
        group = imat.group(2);
        if (group == null) group = imat.group(3);
        if (group != null) { data.strApt = append(data.strApt, ", ", group); continue; }
        if (data.strApt.startsWith("APT ")) data.strApt = data.strApt.substring(4);
        //UNIT
        group = imat.group(4);
        if (group != null) { data.strUnit = append(data.strUnit, " ", group.replace(" ", "")); continue; }
        //if mat matched, but no groups are captured, whole field is a direction (like SOUTHBOUND). append to ADDR
        data.strAddress = append(data.strAddress, " ", fields[i]);
      } //format strApt so we don't ever get "APT:APT 3" on values from only 1 field
      if (!data.strApt.contains(",") && data.strApt.startsWith("APT ")) data.strApt = data.strApt.substring(4);
      
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " MAP PLACE CITY";
    }
  }
  
  private static Pattern DT_OPERATOR = Pattern.compile("(\\d{2} \\d{2} \\d{2}) (\\d{2}/\\d{2}/\\d{4}) - .*?, .* \\(.*\\)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      //if DT hasen't been parsed yet, check if this field is one + parse it
      if (data.strDate.length() != 0) {
        Matcher mat = DT_OPERATOR.matcher(field);
        if (mat.matches()) {
          data.strTime = mat.group(1).replace(" ", ":");
          data.strDate = mat.group(2);
        }
      } //now parse normally as INFO
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME "+super.getFieldNames();
    }
  }
  
  private static Pattern REMOVE_NOTFOUND = Pattern.compile("Between: *(?:<not found> & )?(.*?)(?: & <not found>)?");
  private class MyCrossField extends CrossField {
    public MyCrossField() {
      super("(?:Between|Intersection of):.*", true);
    }

    @Override
    public void parse(String field, Data data) {
      //if field.startswith "Intersection of:" make sure it isn't identical to the address (or a truncation), remove the tag in either case
      if (field.startsWith("I")) {
        //Intersection of: (.*)
        field = field.substring(field.indexOf(":")+1).trim();
        //make sure field isn't redundant
        if (data.strAddress.startsWith(field)) return; //don't parse, this field is redundant
      } else {
        //Between: (.*) - remove <not found>'s before parsing
        Matcher mat = REMOVE_NOTFOUND.matcher(field);
        if (!mat.matches()) abort();
        field = mat.group(1);
      }
        
      //assign to strCross
      super.parse(field, data);
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    public MyDateTimeField() {
      super("\\d{2}/\\d{2}/\\d{4}(?: \\d{2}(?::\\d{2}){0,2})?", true);
    }

    @Override
    public void parse(String field, Data data) {
      // skip parse() if DATETIME has been parsed from INFO
      if (data.strDate.length() == 0) super.parse(field, data);
    }
  }
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "CLA", "CLARKDALE",
      "COR", "CORNVILLE",
      "CW", "COTTONWOOD",
      "JER", "JEROME",
  });
  
}
