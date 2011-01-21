package net.anei.cadpage.parsers;


import net.anei.cadpage.SmsMsgInfo.Data;

/*

Haywood County, NC (Caruso Fire & Rescue)
Contact: bradford1967@hotmail.com" <bradford1967@hotmail.com>
Contact: Kevin Wheeler <moo2175@gmail.com>
Sender: CAD@haywoodnc.net

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

public class NCHaywoodCountyParser extends SmsMsgParser {
  
  public NCHaywoodCountyParser() {
    super("HAYWOOD COUNTY", "NC");
  }

  @Override
  public String getFilter() {
    return "CAD@haywoodnc.net";
  }


  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! body.startsWith("CAD:")) return false;

    if (body.length() < 4) return false;
    String[] lines = body.substring(4).split(";");
    int ndx = 0;
    for (String line : lines) {
      line = line.trim();
      switch (ndx++) {
      
      // Call ID, not always present, >9 numeric digits/
      // if not present fall through
      case 0:
        if(line.length() >= 10 && NUMERIC.matcher(line).matches()) {
          data.strCallId = line;
          break;
        }
        ndx++;
      
      // Call description, also not always present but harder to identify
      // Must start with 'ROUTINE', 'EMERGANCY' or 4 character code starting
      // with a digit and containing at least one non-digit
      case 1:
        if (line.startsWith("ROUTINE") || line.startsWith("EMERGENCY") ||
            isCallId(line)) {
          data.strCall = line;
          break;
        }
        ndx++;

      // The next thing has to be an address
      case 2:
        data.strAddress = line.replaceAll("/", "&");
        break;

      // followed by any number of cross streets
      // terminated by a 2 digit code (or 'CA')
      case 3:
        if (line.equals("CA") ||
            line.length() == 2 && NUMERIC.matcher(line).matches()) break;
        
        if (data.strCross.length() > 0) data.strCross += " & ";
        data.strCross += line;
        ndx--;
        break;
      
      // If we skipped the call description, the field following the
      // terminator might be the call description, or it might be a date
      case 4:
        if (data.strCall.length() == 0 && line.length() > 0 && 
            ! Character.isDigit(line.charAt(0))) {
          data.strCall = line;
        }
        break;
      }
        
      if (ndx > 4) break;
    }
    
    return true;
  }


  private boolean isCallId(String line) {
    int pt = line.indexOf(' ');
    if (pt >= 0) line = line.substring(0,pt);
    return line.length() == 4 && Character.isDigit(line.charAt(0)) &&
      ! NUMERIC.matcher(line).matches();
  }
}