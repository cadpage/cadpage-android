package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Burlington County, Willingboro, NJ 
Contact: CodeMessaging.net
Contact: John Hamilton <skinink66@gmail.com>
[MLCAD] EMS E EMS Call Loc: 5142 CHURCH RD Ven: Mt Laurel XS: PREAKNESS DR/SHARP RD Nature: SON IS CHOKING // 15:44:31 02/14/2012
EMS E EMS Call Loc: 20 WOODHAVEN LA Ven: Willingbor XS: WINDOVER LA/WELDON LA Nature: CHANGE IN MENTAL STATUS 07:03:09 06/27/2012
EMS E EMS Call Loc: 4 THORNHILL LA Ven: Willingbor XS: TYLER DR/TREBING LA Nature: FM/DECEASED 08:29:39 06/27/2012
EMS E EMS Call Loc: 15 BLUEBERRY LA Ven: Willingbor XS: BABBITT LA/BRADFORD LA Nature: 7MT PREGNANT /FALL VICTIM/SPOTTING 08:42:37 06/27/2012
EMS E EMS Call Loc: 32 TWISTING LA Ven: Willingbor XS: TOWER LA/TOBIN CT Nature: ILL 09:12:53 06/27/2012
EMS E EMS Call Loc: 1103 MILLENNIUM WY Ven: Willingbor XS: VANSCIVER PY/LEVITT PY Nature: SICK / NEEDS TO GO TO HOSPITAL // 09:43:41 06/27/2012
12 F StrNonFire Loc: 73 BROOKLAWN DR Ven: Willingbor XS: BUCKNELL LA/BABBITT LA Nature: OVEN FIRE 18:17:21 06/26/2012
FIRE F Fire Call Loc: 45 HOPEWELL LA Ven: Willingbor XS: HANCOCK LA/HARGROVE LA Nature: GARAGE ON FIRE 17:42:38 06/26/2012
EMS E EMS Call Loc: 37 HUMMINGBIRD LA Ven: Willingbor XS: HUNTINGTON LA/HAMPSHIRE LA Nature: STOMACH AND BACK AND LEG PAIN 16:07:00 06/26/2012
EMS E EMS Call Loc: 20 BUTTERCUP LA Ven: Willingbor XS: BRADFORD LA/BROOKLAWN DR Nature: FEM BROKEN ANKLE//IS DIABETIC 15:42:24 06/26/2012
EMS E EMS Call Loc: 55 SUNSET RD Ven: Willingbor XS: STRETTON CL/SIDNEY LA Nature: TENANT HAVING STOMACH PAIN // 11:08:43 06/27/2012

*/

public class NJBurlingtonCountyFParser extends FieldProgramParser {


  public NJBurlingtonCountyFParser() {
    super(CITY_CODES, "BURLINGTON COUNTY", "NJ",
        "CALL! Loc:ADDR! Ven:CITY! XS:X! Nature:INFO!");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  private static final Pattern INFO_PTN = 
      Pattern.compile("[ /]* (\\d\\d:\\d\\d:\\d\\d) +(\\d\\d/\\d\\d/\\d{4})$");

  private class MyInfoField extends InfoField {

    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_PTN.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
        data.strDate = match.group(2);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "INFO TIME DATE";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "Willingbor", "Willingboro"
  });
}

	    
	
	    
	    




	 
