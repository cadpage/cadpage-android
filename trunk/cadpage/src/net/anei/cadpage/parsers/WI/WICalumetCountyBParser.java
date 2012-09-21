package net.anei.cadpage.parsers.WI;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Calumet County, WI
Contact: Tom Macco <tmacco1@gmail.com>
Sender: zoll@goldcross.org
(Gold Cross Alert - part 1 of 1) RC:W824 RUSCH RD//BRILLION/Non Emergency/Hemorhage / Laceration//<None>/Run# 9652/18:21/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:723 S MAIN ST//BRILLION/Emergency/Heart Problems//<None>/Run# 9888/06:05/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:W2377 USHY 10//BRILLION/Non Emergency/Sick Person//<None>/Run# 10629/20:58/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:220 ACHIEVEMENT DR//BRILLION/Non Emergency/Fall Victim//<None>/Run# 10637/04:21/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:130 CALUMET ST//BRILLION/Non Emergency/Allergies/walk in w/ bee sting/ does not want to be transported by ambulance/<None>/Ru
(Gold Cross Alert - part 1 of 1) RC:306 N MAIN ST//BRILLION/Non Emergency/Sick Person//<None>/Run# 11405/02:22/911 Call (County)//

** Not Parsing **
(Gold Cross Alert - part 1 of 1) RC:Job# 0028-A (Run# 12637) Alert: Special Instructions: DOES NOT GEOCODE - RESPONSE ZONE IS 34-CITY OF

*/


public class WICalumetCountyBParser extends FieldProgramParser {
  
  public WICalumetCountyBParser() {
    super("CALUMET COUNTY", "WI",
          "ADDR APT CITY CALL CALL+? NONE! ID TIME ");
  }
  
  @Override
  public String getFilter() {
    return "zoll@goldcross.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Gold Cross Alert - ")) return false;
    if (!body.startsWith("RC:")) return false;
    body = body.substring(3).trim();
    return parseFields(body.split("/"), 5, data);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    if (W_DIGIT_PTN.matcher(sAddress).find()) sAddress = sAddress.substring(1);
    return sAddress;
  }
  private static final Pattern W_DIGIT_PTN = Pattern.compile("^W\\d+ ");
  
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Run# ")) {
        super.parse(field.substring(5).trim(), data);
      } else {
        if (!"Run# ".startsWith(field)) abort();
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NONE")) return new SkipField("<None>", true);
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
}
