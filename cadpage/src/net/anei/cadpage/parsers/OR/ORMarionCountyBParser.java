package net.anei.cadpage.parsers.OR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ORMarionCountyBParser extends FieldProgramParser {

  public ORMarionCountyBParser() {
    super("MARION COUNTY", "OR", "CALL SRC DATETIME ADDR/iS UNIT ID!");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    return parseFields(body.split("\n"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d{2}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ID")) return new IdField("[A-Z]{3,4}\\d{12}", true);
    return super.getField(name);
  }

  public static Pattern FIELD_CLEANUP_PATTERN = Pattern.compile(".*?\\(([^/]*,[^/]*)\\)");
  public static Pattern REMOVE_MAPBOOK_PATTERN = Pattern.compile("(.*?)(?:\\(MapBook:(\\d{4})\\))(.*?)");
  public static Pattern REMOVE_ZIP_PATTERN = Pattern.compile("(.+?)(?:[, ]+\\d{5}|,? 0)$");
  public static Pattern INTERSECTION_CLEANUP_PATTERN = Pattern.compile("(.*),.*(&.*)");

  public class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {

      // remove mapbook and store its #
      Matcher mapbookMat = REMOVE_MAPBOOK_PATTERN.matcher(field);
      if (mapbookMat.matches()) {
        field = mapbookMat.group(1) + mapbookMat.group(3);
        data.strMap = mapbookMat.group(2);
      }

      // check and act if this string is in the format "blah(partweactuallywant)" and act on it
      Matcher fieldMat = FIELD_CLEANUP_PATTERN.matcher(field);
      if (fieldMat.matches()) {
        field = fieldMat.group(1);
      }
      
      // parse remaining string
      Parser p = new Parser(field);
      if (field.endsWith(")")) {
        p.getLast(")");
        field = p.getOptional("(");
        data.strCross = p.get();
        //remove preceding and trailing slashes
        int si = data.strCross.indexOf("/");
        if (si == 0) data.strCross = data.strCross.substring(1);
        else if (si == data.strCross.length() - 1) data.strCross = data.strCross.substring(0, data.strCross.length() - 1);
        p = new Parser(field);
      }

      data.strCity = p.getLastOptional(",");
      if (NUMERIC.matcher(data.strCity).matches()) data.strCity = p.getLastOptional(","); 
      data.strPlace = p.getLastOptional(", @");
      super.parse(p.get(), data);
      if (data.strAddress.length() == 0) abort();
      
      // remove zipcode from city
      Matcher zipMat = REMOVE_ZIP_PATTERN.matcher(data.strCity);
      if (zipMat.matches()) data.strCity = zipMat.group(1);

      // remove extra city from intersection address
      Matcher intMat = INTERSECTION_CLEANUP_PATTERN.matcher(data.strAddress);
      if (intMat.matches()) {
        data.strAddress = intMat.group(1).trim() + " " + intMat.group(2);
      }
      
      //  Remove anything following a comma that is left in the address
      int pt = data.strAddress.indexOf(',');
      if (pt >= 0) data.strAddress = data.strAddress.substring(0,pt).trim();
    }

    @Override
    public String getFieldNames() {
      return ("ADDR APT MAP PLACE CITY X");
    }
  }

}
