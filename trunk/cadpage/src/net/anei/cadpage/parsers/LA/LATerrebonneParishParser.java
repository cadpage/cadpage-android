package net.anei.cadpage.parsers.LA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class LATerrebonneParishParser extends FieldProgramParser {

  public LATerrebonneParishParser() {
    super("TERREBONNE PARISH", "LA", "ID MARK CALL ADDR");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split("\n"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("MARK")) return new SkipField("Req_Dispatch", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  private static Pattern PLACE_ADDR = Pattern.compile("(?:@(.*?) *)?\\((.*?)\\)");// |
  private static Pattern ADDR_CITY_X_PLACE = Pattern.compile("([^,]*?) *, *([A-Za-z ]+?) *(?:\\(/?(.+?)/?(?:; *Near:(.*?))?\\))?");
  private static Pattern INTERSECTION = Pattern.compile("(.*?) *(?:\\((.*?)\\))? *(?:, (.*))? *& *(.*?) *(?:\\((.*?)\\))? *(?:, (.*))?");

  private class MyAddressField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher mat = PLACE_ADDR.matcher(field);
      if (mat.matches()) {
        data.strPlace = getOptGroup(mat.group(1));
        parseAddress(mat.group(2), data);
        return;
      }

      mat = ADDR_CITY_X_PLACE.matcher(field);
      if (mat.matches()) {
        parseAddress(mat.group(1), data);
        data.strCity = mat.group(2);
        data.strPlace = getOptGroup(mat.group(4));
        data.strCross = getOptGroup(mat.group(3));
        return;
      }

      mat = INTERSECTION.matcher(field);
      if (mat.matches()) {
        parseAddress(mat.group(1) + " & " + mat.group(4), data);
        data.strCity = getOptGroup(mat.group(3));
        if (data.strCity.length() == 0) data.strCity = getOptGroup(mat.group(4));
        data.strCross = append(getOptGroup(mat.group(2)), " / ", getOptGroup(mat.group(5)));
        return;
      }

      parseAddress(field, data);
    }

    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY X";
    }

  }

}
