package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/*
Otsego County, NY
Contact: Jeremy Preston <jeremypreston911@gmail.com>
Sender: CAD@otsegocounty.com

1 of 10\nFRM:CAD@otsegocounty.com\nSUBJ:911 EVENT\nMSG:HAZARD ALL|WILBER NATIONAL BANK - COOPERS|5378 ST HWY 28   STA COOP3 XS CO HWY 26\n(Con't) 2 of 10\n/WALNUT|09:04|NARR SOUTH OF BANK MVA PDAA NEED FIR POLICE  PERSON: (COMPLAINANT) (FMLS) TIM  DONLAN\nDisclaimer:\n\nThis communication,\n(Con't 3 of 10\nincluding any attachments, may contain confidential information and is intended only for \nthe individual or entity to whom it is\n(Con't) 4 of 10\naddressed. Any review, dissemination, or copying of this communication \nby anyone other than the intended recipient is strictly\n(Con't) 5 of 10\nprohibited. If you are not the intended recipient, please \ncontact the sender by reply e-mail, delete and destroy all copies of the origi\nMore?
1 of 10\nFRM:CAD@otsegocounty.com\nSUBJ:911 EVENT\nMSG:MVA PD|GRASSLANDS|ST HWY 28   STA COUNTY XS  |09:00|NARR 1 CAR PDMVA PERSON: (COMPLAINANT)\n(Con' 2 of 10\n(FMLS) SUE  JENNINGS\nDisclaimer:\nThis communication, including any attachments, may contain confidential information and is intended\n(Con't) 3 of 10\nonly for the individual or entity to whom it is addressed. Any review, dissemination, or copying of this communication by anyone\n(Con't) 4 of 10\nother than the intended recipient is strictly prohibited. If you are not the intended recipient, please contact the sender by reply\n(Con't) 5 of 10\ne-mail, delete and destroy all copies of the original message. No responsibility is accepted by Otsego County Government for any loss or\nMore?
1 of 10\nFRM:CAD@otsegocounty.com\nSUBJ:911 EVENT\nMSG:TRAFFIC ACCIDENTS|| STA MIDD1 XS ST HWY 166 /CO HWY 52|08:22|NARR CAR OVER THE BANK -\n(Con't) 2 of 10\nROLLOVER PERSON: (COMPLAINANT)\nDisclaimer:\nThis communication, including any attachments, may contain confidential information and\n(Con't) 3 of 10\nis intended only for the individual or entity to whom it is addressed. Any review, dissemination, or copying of this communication\n(Con't) 4 of 10\nby anyone other than the intended recipient is strictly prohibited. If you are not the intended recipient, please contact the sender\n(Con't) 5 of 10\nby reply e-mail, delete and destroy all copies of the original message. No responsibility is accepted by Otsego County Government for an\nMore?
1 of 10\nFRM:CAD@otsegocounty.com\nSUBJ:911 EVENT\nMSG:HAZARD ALL|| STA COOP4 XS CO HWY 52 /GATEWAY LN|08:14|NARR 2 CAR MVA NO\n(Con't) 2 of 10\nINJ\nDisclaimer:\nThis communication, including any attachments, may contain confidential information and is intended only for the\n(Con't) 3 of 10\nindividual or entity to whom it is addressed. Any review, dissemination, or copying of this communication by anyone other than the\n(Con't) 4 of 10\nintended recipient is strictly prohibited. If you are not the intended recipient, please contact the sender by reply e-mail, delete\n(Con't) 5 of 10\nand destroy all copies of the original message. No responsibility is accepted by Otsego County Government for any loss or damage arising\nMore?
1 of 10\nFRM:CAD@otsegocounty.com\nSUBJ:911 EVENT\nMSG:TRAFFIC ACCIDENTS||4 GLEN AV  STA COOP1 XS CHESTNUT /BRUNLAR CT|13:06|NARR WPH2-S\n(Con't) 2 of 10\nVEH/BICYCLE -  PERSON: (COMPLAINANT) (FMLS) ZACK  MAHLUM\nDisclaimer:\nThis communication, including any attachments, may contain\n(Con't) 3 of 10\nconfidential information and is intended only for the individual or entity to whom it is addressed. Any review, dissemination, or\n(Con't) 4 of 10\ncopying of this communication by anyone other than the intended recipient is strictly prohibited. If you are not the intended\n(Con't) 5 of 10\nrecipient, please contact the sender by reply e-mail, delete and destroy all copies of the original message. No responsibility is acce\nMore?

*/


public class NYOtsegoCountyParser extends FieldProgramParser {
    
    public NYOtsegoCountyParser() {
      super("OTSEGO COUNTY", "NY",
             "CALL PLACE ADDR SKIP INFO");
    }
    
    @Override
    public String getFilter() {
      return "CAD@otsegocounty.com";
    }
    
    

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    
	    if (!subject.equals("911 EVENT")) return false;
	    
	    int ipt = body.indexOf("\nDisclaimer:");
	    if (ipt >= 0) body = body.substring(0,ipt).trim();
	    
	    return parseFields(body.split("\\|"), data);
	  }

	  // Address field contains Address, Map code, and cross steet info
	  private class MyAddressField extends AddressField {

      @Override
      public void parse(String field, Data data) {
        Parser p = new Parser(" " + field + " ");
        parseAddress(p.get(" STA "), data);
        data.strSource = p.get(" XS ");
        String strCross = p.get();
        if (data.strAddress.length() == 0) {
          parseAddress(strCross, data);
        } else {
          data.strCross = strCross;
        }
      }

      @Override
      public String getFieldNames() {
        return "SRC MAP X";
      }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("ADDR")) return new MyAddressField();
      return super.getField(name);
    }
	  
	}
	