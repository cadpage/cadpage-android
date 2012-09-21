package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;


/* 
Chester County, PA (Variant F)
Contact: "A. Testa" <tac239@msn.com>
Contact: Matthew Woolston <matthew.woolston@gmail.com>
Sender: cad@oxfordfire.com

(Dispatch) ACCIDENT - PEDESTRIAN STRUCK * ** WB LANCASTER PK EO BETHEL RD ,56   (V) ** LWROXF **  **  ** - ** VEH VS MALE\nDETAILS TO FOLLOW\n
(Dispatch) CARDIAC/RESP ARREST - ALS * ** 167 MOUNT PLEASANT RD ,69 ** ENOTT **  ** GRANT ST & COOPER LA ** - ** 48/F--LIPS BLUE\nDETAILS TO FOLLOW\n**
(Dispatch) ALARM - FIRE * ** 117 HYACINTH DR ,71 ** NEWLON ** THUNDER HILL ** RIDGE DR & MCBERTY CT ** - ** SMOKE ALARM GOING OFF - NO VIS SMOKE - 2ND FLO\nOR **
(Dispatch) BUILDING FIRE * ** 110 E MAIN ST, 87   (NV) **   **  **  ** APT A- ** ENG21 AND LAD21\n**
(Dispatch) ELECTRICAL FIRE INSIDE * ** 325 S BROOKSIDE DR ,06 ** OXFORD ** BROOKSIDE ESTATES ** MCLEOD DR & SEBASTIAN DR ** - ** ELECTIRCAL SPARKED - SMOKED COMI
(Dispatch) FIRE POLICE REQUEST * ** EB UNION SCHOOL RD EO CREAM RD ,56   (V) ** LWROXF **  **  ** - ** ASSIST PSP WITH A TRAFFIC CONTROL\n**
(Dispatch) ACCIDENT - UNKNOWN INJURIES * ** OLD BALTIMORE PK/VILLAGE RD ,57    (V) **  **  **  ** - ** 2 VEH/BLKG ROADWAY/\n**
(Dispatch) CHIMNEY FIRE * ** 3064 LIMESTONE RD ,44 ** WFALLO **  ** HOSTETTER RD & HIGHVIEW D ** - ** CHIMNEY\nDETAILS TO FOLLOW\n**

Contact: Glenn Heininger <glenn.heininger@gmail.com>
Contact:Marc Ferry <marcrferry@gmail.com> 
Sender: paging@minquas.org
System: PRC CAD

CHIMNEY FIRE * ** 451 DONOFRIO DR ,11 ** - ** SPARKS FROM CHIMNEY\nDETAILS TO FOLLOW\n ** DNGTWN ** JOHNSONTOWN **
EMOTIONAL DISORDER - BLS * ** 282 W CHURCH ST ,11 ** - ** PER PD O/S --\nSCENE IS SECURE\n ** DNGTWN **
OVERDOSE - BLS * ** 10 W LANCASTER AV ,11 ** -11PD ** ALCOHOL OD ** DNGTWN **  ** E LANCASTER AV & MANOR AV *
1 of 2\n FRM:paging@minquas.org\n SUBJ:21 WILLIAMS WY ,39\n MSG:EMOTIONAL DISORDER - BLS * ** 21 WILLIAMS WY ,39 ** - **  ** CALN ** HUMPTON FARMS **\n(Con't) 2 of 2\nLYNN BL & HUMPTON RD ** (End)
1 of 2\nFRM:paging@minquas.org\nSUBJ:21 WILLIAMS WY ,39\nMSG:EMOTIONAL DISORDER - BLS * ** 21 WILLIAMS WY ,39 ** - **  ** CALN ** HUMPTON FARMS **\n(Con't) 2 of 2\nLYNN BL & HUMPTON RD ** (End)
Fwd:  1 of 2\nFRM:paging@minquas.org\nSUBJ:517 WASHINGTON AV ,11\nMSG:HEMORRHAGING - ALS * ** 517 WASHINGTON AV ,11 ** - ** 73/M - BLEEDINGFROM\n(Con't) 2 of 2\nRECTUM\r\nDETAILS TO FOLLOW\r\n** DNGTWN **  ** WHITELAND AV & WAGNER AV ** (End)
 1 of 2\nFRM:paging@minquas.org\nSUBJ:150 E PENNSYLVANIA AV ,1\nMSG:ABDOMINAL PAIN - ALS * ** 150 E PENNSYLVANIA AV ,11 ** DOCTORS EXPRESS-- ROOM\n(Con't) 2 of 2\n1-BRAN ** 60'S/M\r\nDETAILS TO FOLLOW\r\n** DNGTWN **  ** WALLACE AV & GREEN ST ** (End)

 */


public class PAChesterCountyFParser extends PAChesterCountyBaseParser {

  private static final Pattern DETAILS_TO_FOLLOW = Pattern.compile("\\r?\\nDETAILS TO FOLLOW\\b\\r?\\n?");
  private static final Pattern DELIM = Pattern.compile("(\\* )?\\*\\*");
  
  public PAChesterCountyFParser() {
    super("CALL ADDRCITY ( CITY PLACE X APT INFO | APT INFO CITY PLACE )");
  }
  
  @Override
  public String getFilter() {
    return "cad@oxfordfire.com,paging@minquas.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains(" * ** ")) return false;

    body = DETAILS_TO_FOLLOW.matcher(body).replaceAll("");
    body = body.replace('\n', ' ');

    // Split and parse by asterisk delimiters
    return parseFields(DELIM.split(body), data);
  }
  
  private static final Pattern TRAILER = Pattern.compile(" *\\(N?V\\)$");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = TRAILER.matcher(field);
      if (match.find()) {
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return true;
      return super.checkParse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
} 
