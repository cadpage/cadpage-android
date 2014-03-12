package net.anei.cadpage.parsers.IN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INElkhartCountyParser extends FieldProgramParser {

  public INElkhartCountyParser() {
    super("ELKHART COUNTY", "IN", "CALL:CALL! ADDR:ADDR! UNIT:UNIT! CITY:CITY! ST:ST! INFO:INFO!");
  }

  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("UNIT")) return new UnitField("(.*?),?"); // remove trailing commas
    if (name.equals("ST")) return new StateField("(?:IN)?(.*)"); // exclude value of "IN"
    return super.getField(name);
  }

  private static Pattern CROSS_INFO = Pattern.compile("(.*?)Cross streets: (.*?)");
  private static Pattern INFO_DATE_TIME = Pattern.compile("(.*?) (\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{1,2}:\\d{2}:\\d{2} [AP]M)");
  private static SimpleDateFormat MilitaryFormat = new SimpleDateFormat("HH:mm:ss");
  private static SimpleDateFormat PageFormat = new SimpleDateFormat("hh:mm:ss a");

  private class MyInfoField extends Field {

    @Override
    public void parse(String field, Data data) {
      // parse cross streets from info
      Matcher mat = CROSS_INFO.matcher(field);
      if (mat.matches()) {
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, mat.group(2).replace("//", "/"), data);
        field = append(mat.group(1), " ", getLeft());
      }

      // parse date and time from info
      mat = INFO_DATE_TIME.matcher(field);
      if (!mat.matches()) abort();
      data.strSupp = mat.group(1); // INFO
      data.strDate = mat.group(2); // DATE
      // parse TIME to 24h format real quick
      Date time = null;
      try {
        time = PageFormat.parse(mat.group(3));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      if (time == null) abort();
      data.strTime = MilitaryFormat.format(time);
    }

    @Override
    public String getFieldNames() {
      return "X INFO DATE TIME";
    }

  }

}
