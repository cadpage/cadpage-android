package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Montgomery county, Pa (West Norriton)
Contact: Roy@fd34.com, 2152648884@messaging.sprintpcs.com
Sender: alert46@Verizon.net 

Subject:Dispatch\n09:39 * RESCUE - WATER * 316 RIVER RD * - *
Subject:Dispatch\n11:12 * PUMP DETAIL * 114 KOEGEL LN * - * 
Subject:Dispatch\n13:32 * GAS-ODOR/LEAK OUTSIDE * 2409 DAIRY LN * - * 
Subject:Dispatch\n18:06 * VEHICLE FIRE * N TROOPER RD AND W MAIN ST * - * 
Subject:Dispatch\n01:49 * BUILDING FIRE COMMERCIAL * 2030 MAIN ST W * DOMINOS PIZZA- * 
Subject:Dispatch\n03:20 * RESCUE - WATER * 6025 VALLEY GREEN RD W * PHILADELPHIA CRICKET CLUB- * 
Subject:Dispatch\n18:10 * S/B AT HELICOPTER LANDING * 51 UPPER FARM RD  Apt# C2 * BUILDING 051 NORRISTOWN STATE HOSPITAL- * 

 */


public class PAMontgomeryCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" *\\* *");
  
  public PAMontgomeryCountyParser() {
    super("MONTGOMERY COUNTY", "PA",
           "TIME CALL ADDR PLACE");
  }
  
  @Override
  public String getFilter() {
    return "alert46@Verizon.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch")) return false;
    String[] flds = DELIM.split(body);
    if (flds.length < 4) return false;
    return parseFields(flds, data);
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
}
