package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHAuglaizeCountyParser extends FieldProgramParser {

  public OHAuglaizeCountyParser() {
    super("AUGLAIZE COUNTY", "OH", "SIG:CODE! NAME:NAME! LOC:ADDR! CROSS:X! DESC:INFO! CFS:ID! DATE:DATE! TIME:TIME! CITY:CITY! SECTOR:MAP! DISTRICT:MAP! SIG_DESC:CALL!");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseMsg(body, data);
  }

  private static Pattern REDUNDANT_X = Pattern.compile("(.*?) *& *(\\1)");

  @Override
  public String adjustMapAddress(String sAddress, boolean cross) {
    if (cross) {
      Matcher mat = REDUNDANT_X.matcher(sAddress);
      if (mat.matches()) sAddress = mat.group(1);
    }
    return sAddress;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ID")) return new IdField("\\d{2}-\\d{6}", true);
    if (name.equals("DATE")) return new DateField("\\d{1,2}/\\d{1,2}/\\d{4}", true);
    if (name.equals("TIME")) return new TimeField("\\d{2}:\\d{2}:\\d{2}", true);
    if (name.equals("MAP")) return new MapField("\\d+[A-Z]+");
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }

  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      // road@road to road & road
      parseAddress(field.replace("@", " & "), data);
    }
  }

  private class MyCrossField extends CrossField {
    public MyCrossField() {
      super("&? *(.*?) *&?", true);
    }

    @Override
    public void parse(String field, Data data) {
      // consolidate entries like "US 33 & US 33"
      Matcher mat = REDUNDANT_X.matcher(field);
      if (mat.matches()) field = mat.group(1);
      super.parse(field, data);
    }
  }

  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      // if info starts with call, remove it
      if (data.strSupp.startsWith(data.strCall)) {
        data.strSupp = data.strSupp.substring(data.strCall.length()).trim();
      }
    }
  }
}
