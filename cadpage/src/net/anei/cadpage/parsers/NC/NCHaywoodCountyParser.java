package net.anei.cadpage.parsers.NC;


import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

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

public class NCHaywoodCountyParser extends DispatchOSSIParser {
  
  public NCHaywoodCountyParser() {
    super("HAYWOOD COUNTY", "NC",
           "ID? CALL? ADDR! X? X?");
  }

  @Override
  public String getFilter() {
    return "CAD@haywoodnc.net";
  }
  
  // We need a call class that can verify its existence
  // To be valid must start with 'ROUTINE', 'EMERGENCY' or 4 character code 
  // starting with a digit and containing at least one non-digit
  private class MyCallField extends CallField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (!isValid(field)) return false;
      parse(field, data);
      return true;
    }

    private boolean isValid(String field) {
      if (field.startsWith("ROUTINE")) return true;
      if (field.startsWith("EMERGENCY")) return true;

      int pt = field.indexOf(' ');
      if (pt >= 0) field = field.substring(0,pt);
      return field.length() == 4 && Character.isDigit(field.charAt(0)) &&
              ! NUMERIC.matcher(field).matches();
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
}