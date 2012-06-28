package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Nightwatch Security, NY
Contact: Active911
Agency name: Nightwatch Location: Staten Island, NY
Sender: Scheduler <scheduler@specialtyansweringservice.net>

Note! This parser is *NOT* available in the Cadpage app. It is intended only to be used with the standalone Cadpage Parser

(TEST) ********** Nightwatch Security - Account 3694 ********** \n\n                  =========================== \n\n  Reason for Call: 04-SERVICE & BILLING CALL                 Date:\n12/30/2010\n  Order Number: 2400000946                                   Time: 13:46:11\n  Operator: AMM\n  Name: Jackie Johnston\n  Callback Number: (347)265-6123\n  Call For: \n  Patched: YES\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: AUTOZONE #4713 (STATEN ISLAND)\n  Dispatch Notes: \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 3472656123\n  Message: \n   \n\n   \n\n                                   Message # 1\n\n\n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 06-MONITORING CENTER                      Date:\n12/09/2010\n  Order Number: 2400000925                                   Time: 23:54:31\n  Operator: AJH\n  Name: Lb03\n  Callback Number: (800)434-4000\n  Call For: \n  Patched: \n  Police Needed: YES\n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: 3340 STREET ROAD\n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 7183326100\n  Message: \n   \n   \n   \n                                   Message # 1\n\n ===================================\n End of Report Statement       : 12/10/2010 00:04:39\n \n Total Number of Orders Records:          1
(new messages for 3694) \n      ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date:\n05/22/2012\n  Order Number: 2400002076                                   Time: 09:15:26\n  Operator: MBC\n  Name: Steve Galindo W/ L1 Idenity Solutios\n  Callback Number: (615)342-9256\n  Call For: John Burbridge\n  Patched: NO\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 6153429256\n  Message: PLEASE CALL\n   \n   \n   \n                                   Message # 1\n\n ===================================
(new messages for 3694) \n      ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date:\n05/22/2012\n  Order Number: 2400002076                                   Time: 09:15:26\n  Operator: MBC\n  Name: Steve Galindo W/ L1 Idenity Solutios\n  Callback Number: (615)342-9256\n  Call For: John\n  Patched: NO\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 6153429256\n  Message: PLEASE CALL\n   \n   \n   \n                                   Message # 1\n\n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 11-EMPLOYMENT                             Date: 05/30/2012\n  Order Number: 2400002093                                   Time: 13:15:15\n  Operator: SMC\n  Name: Lynette Rodriguez\n  Callback Number: (347)756-8975\n  Call For: \n  Patched: \n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 3478568975\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 06-MONITORING CENTER                      Date: 06/03/2012\n  Order Number: 2400002096                                   Time: 08:42:30\n  Operator: MBC\n  Name: Jasmine 433\n  Callback Number: (718)494-6414\n  Call For: \n  Patched: \n  Police Needed: NO\n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 7186973200\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/07/2012\n  Order Number: 2400002104                                   Time: 12:23:33\n  Operator: MRH\n  Name: Mike Antoik\n  Callback Number: (212)801-1067\n  Call For: \n  Patched: NO\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 2128011067\n  Message: PLEASE CALL\n   \n   \n   \n                                   Message # 1                                   \n ===================================\n 
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/08/2012\n  Order Number: 2400002109                                   Time: 14:27:18\n  Operator: JDB\n  Name: Jesse Rivest\n  Callback Number: (860)471-0136\n  Call For: \n  Patched: YES\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 8604710136\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 11-EMPLOYMENT                             Date: 06/10/2012\n  Order Number: 2400002113                                   Time: 09:06:09\n  Operator: SMC\n  Name: Richard Pacilli\n  Callback Number: (347)924-3197\n  Call For: \n  Patched: \n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 3479243197\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(General Alert) 1911 Richmond Avenue
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 11-EMPLOYMENT                             Date: 06/11/2012\n  Order Number: 2400002114                                   Time: 08:54:05\n  Operator: MRH\n  Name: Ayomide Awopetu\n  Callback Number: (347)500-9095\n  Call For: \n  Patched: \n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 3475009095\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/15/2012\n  Order Number: 2400002116                                   Time: 10:36:45\n  Operator: LMH\n  Name: Anthony Missud\n  Callback Number: (718)370-2171 1 41\n  Call For: Mr. Burbridge\n  Patched: NO\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 7183702171\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 11-EMPLOYMENT                             Date: 06/16/2012\n  Order Number: 2400002118                                   Time: 09:10:15\n  Operator: JLX\n  Name: Andre Ortiz\n  Callback Number: (347)499-6792\n  Call For: \n  Patched: \n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 3474996792\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 10-PUT ALARM IN TEST                      Date: 06/18/2012\n  Order Number: 2400002119                                   Time: 08:24:22\n  Operator: 9JC\n  Name: Nancy Mctaggart\n  Callback Number: (215)638-2283\n  Call For: \n  Patched: YES\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 2156382283\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/19/2012\n  Order Number: 2400002122                                   Time: 12:41:36\n  Operator: 9GP\n  Name: Jennifer Coss\n  Callback Number: (866)421-2374\n  Call For: John\n  Patched: NO\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 8433795113\n  Message: \n   WANTS TO KNOW IF A CREDIT CARD PAYMENT WENT THROUGH.\n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/21/2012\n  Order Number: 2400002127                                   Time: 05:30:35\n  Operator: PJG\n  Name: Jasmine Carter\n  Callback Number: (317)601-5373\n  Call For: John\n  Patched: \n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 3176015376\n  Message: PLEASE CALL. WANTS PRICING TO HAVE SYSTEM INSTALLED. SHE WAS ROBBED\n   RECENTLY AT GUNPOINT. STOLE HER CAR & HAS HER GPS. SHE IS SCARED THEY\n   WILL GET HER ADDRESS & HER PARENTS ADDRESS.\n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/26/2012\n  Order Number: 2400002129                                   Time: 15:06:55\n  Operator: JDB\n  Name: Nicki\n  Callback Number: (631)782-1700\n  Call For: John Burbridge\n  Patched: YES\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 6317821700\n  Message: \n   \n   \n   \n                                   Message # 1                                   \n ===================================
(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n                  =========================== \n  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/27/2012\n  Order Number: 2400002132                                   Time: 10:16:11\n  Operator: LMH\n  Name: Jennifer\n  Callback Number: (866)421-2374 X 211\n  Call For: John Burbiege\n  Patched: NO\n  Police Needed: \n  Police Called: \n  Description Of Incident: \n  Description Of Incident: \n  Location: \n  Dispatch Notes: \n   \n  Attendance: \n  When Arriving: \n  Time Assigned: \n  Caller ID: 2627218855\n  Message: PER JOHN WILL CALL HER BACK AT 2PM\n   \n   \n   \n                                   Message # 1                                   \n ===================================

*/


public class NYNightwatchSecurityParser extends FieldProgramParser {
  
  private static final Pattern WRAP_PTN = Pattern.compile("\n(?![ \n])"); 
  private static final Pattern BLANK_KEYWORD = Pattern.compile(" +(?=Date:|Time:)");

  public NYNightwatchSecurityParser() {
    super("STATEN ISLAND", "NY",
           "Reason_for_Call:CALL! Date:DATE! Order_Number:ID! Time:TIME! Operator:SKIP Name:NAME! Callback_Number:PHONE! Description_Of_Incident:INFO Description_Of_Incident:INFO Location:ADDR! Dispatch_Notes:INFO Message:INFO INFO+? EMPTY"); 
 }
  
  @Override
  public String getFilter() {
    return "scheduler@specialtyansweringservice.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // General alert (there's not ours) is a special case
    if (subject.equals("General Alert")) {
      data.strCall = "** General Alert **";
      parseAddress(body, data);
      return true;
    }
    
    // Next we need to correct for some internal wraparround
    body = WRAP_PTN.matcher(body).replaceAll(" ");
    
    // And add line breaks in front of the Date: and Time: fields
    body = BLANK_KEYWORD.matcher(body).replaceAll("\n");
    
    // From here, everything is pretty basic
    return parseFields(body.split("\n"), data);
  }
  
  // Address field isn't usually a real address, and it occasionally
  // contains # that should not be interpreted as appartment numbers
  // So we need to protect them
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("#", "%%%");
      super.parse(field, data);
      data.strAddress = data.strAddress.replace("%%%", "#");
    }
  }
  
  // Empty field marks ends of Message: information
  private class EmptyField extends SkipField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return (field.length() == 0);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("EMPTY")) return new EmptyField();
    return super.getField(name);
  }
}
	