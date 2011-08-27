package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;


/* 
Chester County, PA (Variant F)
Contact: "A. Testa" <tac239@msn.com>
Sender: cad@oxfordfire.com

(Dispatch) ACCIDENT - PEDESTRIAN STRUCK * ** WB LANCASTER PK EO BETHEL RD ,56   (V) ** LWROXF **  **  ** - ** VEH VS MALE\nDETAILS TO FOLLOW\n
(Dispatch) CARDIAC/RESP ARREST - ALS * ** 167 MOUNT PLEASANT RD ,69 ** ENOTT **  ** GRANT ST & COOPER LA ** - ** 48/F--LIPS BLUE\nDETAILS TO FOLLOW\n**
(Dispatch) ALARM - FIRE * ** 117 HYACINTH DR ,71 ** NEWLON ** THUNDER HILL ** RIDGE DR & MCBERTY CT ** - ** SMOKE ALARM GOING OFF - NO VIS SMOKE - 2ND FLO\nOR **
(Dispatch) BUILDING FIRE * ** 110 E MAIN ST, 87   (NV) **   **  **  ** APT A- ** ENG21 AND LAD21\n**
(Dispatch) ELECTRICAL FIRE INSIDE * ** 325 S BROOKSIDE DR ,06 ** OXFORD ** BROOKSIDE ESTATES ** MCLEOD DR & SEBASTIAN DR ** - ** ELECTIRCAL SPARKED - SMOKED COMI
(Dispatch) FIRE POLICE REQUEST * ** EB UNION SCHOOL RD EO CREAM RD ,56   (V) ** LWROXF **  **  ** - ** ASSIST PSP WITH A TRAFFIC CONTROL\n**
(Dispatch) ACCIDENT - UNKNOWN INJURIES * ** OLD BALTIMORE PK/VILLAGE RD ,57    (V) **  **  **  ** - ** 2 VEH/BLKG ROADWAY/\n**

 */


public class PAChesterCountyFParser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile("(\\* )?\\*\\*");
  
  public PAChesterCountyFParser() {
    super("CALL ADDRCITY CITY PLACE X APT INFO");
  }
  
  @Override
  public String getFilter() {
    return "cad@oxfordfire.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch")) return false;

    // Split and parse by asterisk delimiters
    body = body.replace('\n', ' ');
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
} 
