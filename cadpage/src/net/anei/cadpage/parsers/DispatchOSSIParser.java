package net.anei.cadpage.parsers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/* This is the Parser for OSSI Pages. http://www.sungardps.com/products/ossipublicsafetysolution.aspx/
Currently Haywood, NC and Worcester,MD use this parser
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