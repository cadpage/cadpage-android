package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Davie County, NC
Contact: Michael Wilson <fireman1700@gmail.com>

911:Call #110619-2932* Address:866 ANGELL RD* * * City:MOCKSVILLE* * Type:HC* HAZARDOUS CONDITION* HILL JOEL* PH#:336-940-2303* Units:17* IRA:* Medical: No* Haza.
911:Call #110622-3347* Address:2388 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:19D4* HEART PROBLEMS* HALL GENE* PH#:336-492-5114* Units:17,34,ST4,YC24* IRA:*
911:Call #110622-3355* Address:389 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* CULLER C O* PH#:336-492-7249* Units:17* IRA:* Medical: No* H
911:Call #110623-3420* Address:261 COOPER CREEK DR* * * City:MOCKSVILLE* Geo Comment: BUSINESSES IN CITY LIMITS NBH: OFF 1734 US HWY 601 N Landmark Comment: KNOX
911:Call #110624-3510* Address:3868 US HWY 601 N* * * City:MOCKSVILLE* * Type:YEL* CARDIAC PROBLEM* HOHFF, EARL V* PH#:336-492-3017* Units:17* IRA:* Medical: No*

 */


public class NCDavieCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*(?: \\*)*"); 
  
  public NCDavieCountyParser() {
    super("DAVIE COUNTY", "NC",
           "ID Address:ADDR! City:CITY! Type:CALL CALL NAME PH:PHONE Units:UNIT IRA:SKIP INFO+ Geo_Comment:INFO2");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("911:Call #")) return false;
    body = body.substring(10).trim();
    body = body.replace("PH#:", "PH:");
    return parseFields(DELIM.split(body), data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private class MyInfo2Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = "Geo Comment: " + field;
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO2")) return new MyInfo2Field();
    return super.getField(name);
  }
}
