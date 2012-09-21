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

Mount laurel Township
[DISPATCH]EMS E EMS Call LOC: 907 PLEASANT VALLEY AV VEN: Mt Laurel XS: EASTGATE DR/S CHURCH ST NATURE: FEM DIZZY & LIGHT HEADED 13:48:34 07/10/2012
[DISPATCH]EMS E EMS Call LOC: 110 LAUREL LA VEN: Mt Laurel XS: LAUREL LA/HOLLY LA NATURE: FALL VIC,, LACERATION TO HEAD 18:16:26 07/05/2012
[DISPATCH]132 E UnkMedEmrg LOC: 159 BIRCHFIELD CT A VEN: Mt Laurel XS: BIRCHFIELD DR/DEAD END NATURE: 71 YEAR OLD FEM/ACTIVATED ALERT/RUSKIN, 18:51:28 07/05/2012
[DISPATCH]EMS E EMS Call LOC: 13 GOLDENROD DR VEN: Mt Laurel XS: MORNING GLORY DR/ NATURE: F/FEELING WEAK 16:06:14 07/13/2012
[DISPATCH]EMS E EMS Call LOC: 3740 RT295 SB VEN: Mt Laurel XS: RT73 EXITS/RT38 EXITS NATURE: M/V ACCIDENT SHOULDER INJURY BLS ONLY 15:44:57 07/14/2012
[DISPATCH]EMS E EMS Call LOC: 250 CENTURY PY VEN: Mt Laurel XS: FELLOWSHIP RD/FELLOWSHIP RD NATURE: EMPLOYEE W/HEADACHE / VOMITING // 12:48:33 07/18/2012
[DISPATCH]EMS E EMS Call LOC: 101 DIEMER DR VEN: Mt Laurel XS: CRAWFORD PL/PACILLI PL NATURE: CLLR COMING DOWN FROM ALCOHOL WITHDRAWAL 18:24:46 07/18/2012
[DISPATCH]EMS E EMS Call LOC: 121 WAVERLY AV VEN: Mt Laurel XS: FEDERAL ST/CHURCH RD NATURE: MVA OCCURED IN D10,,,ONE SUBJ W/FACIAL 13:40:27 06/25/2012
[DISPATCH]EMS E EMS Call LOC: 5711 ADELAIDE DR VEN: Mt Laurel XS: LINDALE DR/LINDALE DR NATURE: FEM POSS STROKE 08:17:02 06/25/2012


*/

public class NJBurlingtonCountyFParser extends FieldProgramParser {


  public NJBurlingtonCountyFParser() {
    super(CITY_CODES, "BURLINGTON COUNTY", "NJ",
        "CALL! Loc:ADDR LOC:ADDR Ven:CITY VEN:CITY XS:X! Nature:INFO NATURE:INFO");
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
      "Willingbor", "Willingboro",
      "Mt Laurel", "Mount Laurel"
  });
}

	    
	
	    
	    




	 
