package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Burlington County, NJ 
Contact: Robert Allen <rallen7779@gmail.com>
Sender: chief1300@comcast.net

Messenger 911 / [Update]\n18:43:42\n133 E TrfcEntp\n5010\nSOUTH AV\nPINE ST\nPINE ST\n
Messenger 911 / 18:43:42\n129 E AccInjry\n5010\nSOUTH AV\nPINE ST\nPINE ST\n
Messenger 911 / [Update]\n22:39:55\n16 F Alarms\n1321\n691 EAYRESTOWN RD\nMUNICIPAL DR/RT38\n609.267.1224/GENERAL ALARM
Messenger 911 / 14:29:55\n132 E UnkMedEmrg\n1310\n4 HEMSING DR\nMAIN ST/ESTATE RD\nMALE WITH FOOT INJURY\nWPH2:
Messenger 911 / [Update]\n14:57:17\n129F E Mva/Fire\n1311\n1740 E RT38\nEAYRESTOWN RD/SMITHVILLE RD\n1 VEH OVERTURNED//OCCUPANTS ST\nIFO\n
Messenger 911 / [Update]\n10:34:13\n129F E Mva/Fire\n1340\nE RT38\nMT HOLLY BP\nWHI PICKUP TRUCK FLIPPED OVER \nWRLS:  PCS/WIRELESS DEFAULT\n

*/

public class NJBurlingtonCountyBParser extends FieldProgramParser {
  
  public NJBurlingtonCountyBParser() {
    super("BURLINGTON COUNTY", "NJ",
          "UPDT? TIME CALL UNIT ADDR! X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "chief1300@comcast.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.startsWith("Messenger 911")) break;
      if (body.startsWith("Messenger 911 / ")) {
        body = body.substring(16).trim();
        break;
      }
      return false;
    } while (false);
    String[] flds = body.split("\n");
    if (flds.length < 4) return false;
    return parseFields(flds, data);
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\d{3}[-\\.]?\\d{3}[-\\.]?\\d{4}");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (PHONE_PTN.matcher(field).matches()) {
        data.strPhone = field;
      } else {
        data.strSupp = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PHONE INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UPDT")) return new SkipField("\\[Update\\]", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
