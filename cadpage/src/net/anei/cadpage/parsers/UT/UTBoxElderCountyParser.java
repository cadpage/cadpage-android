package net.anei.cadpage.parsers.UT;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class UTBoxElderCountyParser extends FieldProgramParser {

  public UTBoxElderCountyParser() {
    super(CITY_CODES, "BOX ELDER COUNTY", "UT", "DATETIME! CALL! ADDR CITY INFO+");
  }

  private static Pattern ID_GRABBER = Pattern.compile("(.*?)\\[(\\d+)\\]", Pattern.DOTALL);

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    int pi = subject.indexOf("test");
    if (pi < 0) data.strUnit = subject;

    Matcher idMat = ID_GRABBER.matcher(body);
    if (idMat.matches()) {
      body = idMat.group(1);
      data.strCallId = idMat.group(2);
    }

    return parseFields(body.split("\n"), data);
  }

  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram() + " ID";
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static final Pattern ADDR_MP_PTN = Pattern.compile("\\bMP[ 0-9]");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String[] fields = field.split(";");
      if (fields.length > 1) {
        super.parse(fields[0].trim(), data);
        for (int i = 1; i < fields.length; i++) {
          String part = fields[i].trim();
          if (part.startsWith("#")) data.strApt = append(data.strApt, " - ", part.substring(1).trim());
          else if (NUMERIC.matcher(part).matches()) data.strApt = append(data.strApt, " - ", part);
          else if (ADDR_MP_PTN.matcher(part).find() || checkAddress(part) > 0) data.strCross = append(data.strCross, " & ", part);
          else data.strPlace = append(data.strPlace, "; ", part);
        }
      } else super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE X";
    }
  }

  
  Pattern DATE_TIME_OPERATOR = Pattern.compile("\\d{2}:\\d{2}:\\d{2} \\d{2}/\\d{2}/\\d{4} - .*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (!DATE_TIME_OPERATOR.matcher(field).matches()) data.strSupp = append(data.strSupp, "\n", field);
    }

  }

  private static final Properties CITY_CODES = buildCodeTable(new String[] {
      "LYN",     "Lynn",
      "YOS",     "Yost",
      "CLC",     "Clear Creek",
      "BEA",     "Bear River City",
      "BRI",     "Brigham City",
      "HAR",     "Harper Ward",
      "PER",     "Perry",
      "BED",     "Beaver Dam",
      "COL",     "Collinston",
      "COR",     "Corinne",
      "PRO",     "Promontory",
      "DEW",     "Deweyville",
      "FIE",     "Fielding",
      "GAR",     "Garland",
      "ETN",     "Etna",
      "GRO",     "Grouse Creek",
      "LUC",     "Lucin",
      "HON",     "Honeyville",
      "HOW",     "Howell",
      "MAN",     "Mantua",
      "KEL",     "Kelton",
      "PAR",     "Park Valley",
      "ROS",     "Rosette",
      "BEL",     "Belmont Springs",
      "PLY",     "Plymouth",
      "POR",     "Portage",
      "WAS",     "Washakie",
      "RIV",     "Riverside",
      "BNS",     "Benson",
      "SNO",     "Snowville",
      "BLU",     "Blue Creek",
      "BOT",     "Bothwell",
      "ELW",     "Elwood",
      "PEN",     "Penrose",
      "THA",     "Thatcher",
      "TRE",     "Tremonton",
      "HOT",     "Hot Spr Trailer",
      "SOW",     "S Willard",
      "WIL",     "Willard",
      "GUN",     "Gunnison",
      "THI",     "Thiokol Plnt 78",
      "RSB",     "Rosebud",
      "CUR",     "Curlew Junction",
      "BEC",     ""
  });

}
