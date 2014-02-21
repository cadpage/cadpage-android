package net.anei.cadpage.parsers.WV;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Berkeley County, WV
 */
public class WVFayetteCountyParser extends FieldProgramParser {

  public WVFayetteCountyParser() {
    super(CITY_CODES, "FAYETTE COUNTY", "WV", "SRC ( STA UNIT PLACE+ | CALL ADDRCITY UNIT STA! INFO+ )");
  }

  private static Pattern DELIM = Pattern.compile(" *\n *");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Message from HipLink")) return false;
    return parseFields(DELIM.split(body), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField("[^ ]*");
    if (name.equals("STA")) return new MySourceField("STA[^ ]+");
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }

  private class MySourceField extends SourceField {

    public MySourceField(String pattern) {
      super(pattern, true);
    }

    @Override
    public void parse(String field, Data data) {
      data.strSource = append(data.strSource, " ", field);
    }
  }

  private static Pattern ADDR_SEMICOLON_PLACE = Pattern.compile("(.*?); *(.*?)(,.*)?");
  private static Pattern IDD_MILE_MARKER = Pattern.compile("(?:I[ -]?)?(\\d+)[/ ]+(NORTH|SOUTH|N|S)B?[/ ]+(?:MM[/ ]*)?(\\d+)(?:[/ ]*MM)?([,;].*)?", Pattern.CASE_INSENSITIVE);

  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher mat = IDD_MILE_MARKER.matcher(field);
      if (mat.matches()) {
        field = "I " + mat.group(1) + " " + mat.group(2) + " " + mat.group(3) + " MM" + getOptGroup(mat.group(4));
      }
      
      mat = ADDR_SEMICOLON_PLACE.matcher(field);
      if (mat.matches()) {
        data.strPlace = mat.group(2);
        field = mat.group(1) + getOptGroup(mat.group(3));
      }

      super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "ADDR PLACE CITY";
    }
  }

  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      //if this field is being used, then call has been identified as a run report
      data.strCall = "RUN REPORT";
      data.strPlace = append(data.strPlace, "\n", field);
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GAL", "GAULEY BRIDGE",
      "MTH", "MT HOPE",
      "OAK", "OAK HILL",
      "PAX", "PAX",
      "SCA", "SCARBRO"
  });
}
