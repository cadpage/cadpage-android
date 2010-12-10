package net.anei.cadpage.parsers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/* This is the Parser for OSSI Pages. http://www.sungardps.com/products/ossipublicsafetysolution.aspx/
Currently Haywood, NC and Worcester,MD use this parser

Haywood County, NC (Caruso Fire & Rescue)
CAD:1010170008;ROUTINE SICK PERSON;33 GRACE DR;CRUSO RD;JOHNS CREEK RD;12;10/17/2010 10:15:00
CAD:1011010007;ROUTINE SICK PERSON;59 YAH WAY;MUNDY FIELD RD;12;11/01/2010 12:29:40
CAD:1010300004;EMERGENCY TRAFFIC ACCIDENT;9600 CRUSO RD/BURNETTE COVE RD;12;10/30/2010 10:07:00
CAD:11538 CRUSO RD;12;ROUTINE FALL
CAD:1010310024;EMERGENCY HEMORRHAGE LACERATIO;8573 CRUSO RD;SAWMILL ACRES LN;HARLEY DAVIDSON DR;12;10/31/2010 21:54:21
CAD:1011050024;EMERGENCY UNCONSCIOUS FAINTING;50 MUSTANG ALLEY DR;CRUSO RD;HAPPY WAY;12;11/05/2010 20:19:31
CAD:1011050011;EMERGENCY BREATHING PROBLEMS;12695 CRUSO RD;EVERIDGE DR;COLD CREEK RD;12;11/05/2010 12:02:51
CAD:1011070002;69D7 CHIMNEY FIRE;296 MATTHEW LN;SHADY BROOK RD;MOUNTAIN VISTA RD;19;11/07/2010 01:02:10
CAD:ROUTINE TRANSPORT;12695 CRUSO RD;CA;RM-525 TO HOME;MED6 CALL AND REQ ST12, FR12 RESPOND TO THE RESIDENCE TO HELP THEM GET PT BACK INTO HOUSE [11/11/10 :1of2
CAD:1011110016;ROUTINE CONVULSIONS SEIZURES;12588 CRUSO RD;EVERIDGE DR;COLD CREEK RD;12;11/11/2010 19:24:02
CAD:1011110019;ROUTINE SICK PERSON;311 PISGAH CREEK RD;EDGEWATER LN;PISGAH MOUNTAIN RD;12;11/11/2010 20:58:54

Worcester County, MD
Contact:james johnson <jjohnson1179@gmail.com>
Contact: BIGJOHNSON1179@vtext.com
ANother one with challenging inconsistent field placement :(
Looks same as Hayword County, NC  (Close, but appears to add a town)
CAD:300;FALLS;5914 BOX IRON RD;GIRDLETREE;PINE ST;TAYLOR LANDING RD;11/23/2010 08:31:38
CAD:300;SICK PERSON;5822 DUKES RD;GIRDLETREE;RAILROAD AVE;SNOW HILL RD;11/16/2010 09:21:04
CAD:300;FALLS;5914 BOX IRON RD;GIRDLETREE;PINE ST;TAYLOR LANDING RD;11/23/2010 08:31:38
CAD:100;TRAFFIC TRANSPORTATION ACC;3543 AYDELOTTE RD;DIST: 7.94 FT;POCOMOKE;BRANTLEY RD;SHEEPHOUSE RD;11/16/2010 00:31:42
CAD:100;PROPANE OR NATURAL GAS LEAK;1010 CLARKE AVE;POCOMOKE;ANN ST;MCMICHAEL AVE;11/12/2010 10:31:09
CAD:100;FIRE ALARM;125 NEWTOWNE BLVD;HOLIDAY INN EXPRESS;POCOMOKE;OLD SNOW HILL RD;11/12/2010 08:15:38
CAD:100;TRAFFIC TRANSPORTATION ACC;DIVIDING CREEK RD/WORTH RD;DIST: 25.70 FT;POCOMOKE;11/10/2010 15:20:42
CAD:MUTUAL AID ASSIST OUTSIDE AGY;4264 FIREHOUSE ST;NEWCHURCH STATION 1;NEW CHURCH;DEPOT ST;LANKFORD LN;11/08/2010 20:34:48
CAD:100;TRAFFIC TRANSPORTATION ACC;OCEAN HWY/WORCESTER HWY;PRIOR TO 113;POCOMOKE;11/08/2010 01:15:41
CAD:100;UNCONSCIOUS FAINTING;275 NEWTOWNE BLVD;BLDG LOWES;LOWES OF POCOMOKE;POCOMOKE;OLD SNOW HILL RD;11/07/2010 11:25:06
CAD:100;BREATHING PROBLEMS;906-16 LYNNHAVEN DR;POCOMOKE;8TH ST;HALEYS WAY;10/24/2010 06:58:01
CAD:S5;MUTUAL AID ASSIST OUTSIDE AGY;8987 COURTHOUSE HILL RD;POCOMOKE;DIVIDING CREEK RD;WALLACE TAYLOR RD;10/22/2010 22:01:04
CAD:100;UNCONSCIOUS FAINTING;1130 OLD VIRGINIA RD;POCOMOKE NAZARENE CHURCH;POCOMOKE;OCEAN HWY;SOUTHERN FIELDS DR;10/17/2010 11:32:35
CAD:100;CARDIAC OR RESPIRATORY ARREST;2330 WORCESTER HWY;GRND FLR;POCOMOKE;OLD SNOW HILL RD;LAMBERTSON RD;10/18/2010 19:23:41
CAD:100;RESIDENTIAL STRUCTURE FIRE;208 14TH ST;POCOMOKE;MARKET ST;CEDAR RUN;10/23/2010 07:12:12
CAD:100;BREATHING PROBLEMS;906-16 LYNNHAVEN DR;POCOMOKE;8TH ST;HALEYS WAY;10/24/2010 06:58:01  

Case ID
Nature
Street Address
Business (If applicable)
Crossroad 1
Crossroad2
District
Call time
Street not

*/

public class DispatchOSSIParser extends SmsMsgParser {

	  private String defCity;
	  private String defState;
	  private int cadVersion;
	  
	  private static final Pattern TIME_DATE = Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d \\d\\d:\\d\\d:\\d\\d");
	  
  public void setDefaults(String defCity, String defState) {
	    this.defCity = defCity;
	    this.defState = defState;
	  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! body.startsWith("CAD:")) return false;
    
    data.defState=defState;
    data.defCity = defCity;
    if (defCity== "WORCESTER COUNTY") {cadVersion=1;}
    if (defCity== "HAYWOOD COUNTY") {cadVersion=2;}

    if (body.length() < 4) return false;
    String[] lines = body.substring(4).split(";");
    int ndx = 0;
    int iCityMoved = 0;
    for (String line : lines) {
      line = line.trim();
      switch (ndx++) {
      
      // Call ID, not always present, >9 numeric digits/
      // if not present fall through
      case 0:
        if(line.length() == 3 && NUMERIC.matcher(line).matches()) {
          data.strUnit = line;
          break;
        }
        ndx++;
      
      // Call description, also not always present but harder to identify
      // Must start with 'ROUTINE', 'EMERGANCY' or 4 character code starting
      // with a digit and containing at least one non-digit
      case 1:
          data.strCall = line;
          break;
        //ndx++;

      // The next thing has to be an address
      case 2:
        data.strAddress = line.replaceAll("/", "&");
        break;

      //CAD1 or CAD2: Should Be City. 
      //CAD1:  If it has DIST: or PROP in it then the next field is City and this is supplemental 
      case 3:
    	if (cadVersion ==1) {
    		if (line.contains("DIST:") || line.contains("PRIOR TO")){
    			data.strSupp = line.trim();
    			iCityMoved = 1;
    			break;
    		} else if(line.contains(" ")) {
    			data.strSupp = line.trim();
    			iCityMoved = 1;
    			break;
    		}else {
    			data.strCity = line.trim();
    			break;
    		}
    	} 
    	if (cadVersion ==2) {
        if (data.strCross.length() > 0) data.strCross += " & ";
        data.strCross += line;
        ndx--;
        break;
    	}
      
      // If we skipped the call description, the field following the
      // terminator might be the call description, or it might be a date
      case 4:
    	if (iCityMoved == 1 && cadVersion == 1) {
    		// This is really the city field.
    		data.strCity = line.trim();
    		break;
    	} 
    	
    	if (iCityMoved == 0 && cadVersion ==1) {
    		// This is the First Cross Street.
    		if (data.strCross.length() > 0) data.strCross += " & ";
    	       data.strCross += line;
    	    break;
    	}
    	
        if (data.strCall.length() == 0 && line.length() > 0 && 
            ! Character.isDigit(line.charAt(0))) {
          data.strCall = line;
          break;
        }
        
     
      // For CAD1: this is the second cross street.
      case 5:
      	if (cadVersion == 1 && !isDateTime(line)) {
    		// This is the first Cross Street.
      		if (data.strCross.length() > 0) data.strCross += " & ";
 	       data.strCross += line;
 	       break;
    	} 
    	  
      case 6:
    	  if (iCityMoved == 1 && cadVersion == 1 && !isDateTime(line)) {
      		// This is the second Cross Street.
        		if (data.strCross.length() > 0) data.strCross += " & ";
   	       data.strCross += line;
   	       break;
      	} 
    	  
    	  
      }   
      if (ndx > 6) break;
    }
    
    return true;
  }


  private boolean isCallId(String line) {
    int pt = line.indexOf(' ');
    if (pt >= 0) line = line.substring(0,pt);
    return line.length() == 3 && Character.isDigit(line.charAt(0)) &&
      ! NUMERIC.matcher(line).matches();
  }
  private boolean isDateTime(String line) {
	  Matcher match = TIME_DATE.matcher(line);
	  return match.matches();
	  }
}