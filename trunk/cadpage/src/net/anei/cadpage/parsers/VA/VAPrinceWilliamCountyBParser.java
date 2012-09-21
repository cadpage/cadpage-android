package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Prince William County
Agency name: Nokesville Vol. Fire Rescue Location: Bristow, VA 
Sender: @rsan.pwcgov.org>

(Flyout) (Trauma) Flyout  \nInc. Address: 18903 Miata Ln  \nBox Number: 0329  \nRadio Channel: 5C  \nCommand: N/A  \nLanding Zone: 3615 Lions Field Rd. Triangle ES  \nComments: Injuries to a pediatric from a fall. Life Evac 2 with E503B on 5C for ground contact.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout) (Trauma) Flyout  \nInc. Address: I-95 North 156 MM  \nBox Number: 2382  \nRadio Channel: 5D  \nCommand: N/A  \nLanding Zone: I-95 North 156 MM  \nComments: ALS injuries for adult male. E520 is ground contact for Med Star 2 on 5D.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout) (Trauma) Flyout  \nInc. Address: 9427 Taney Rd  \nBox Number: 8126   \nRadio Channel: 5C  \nCommand: N/A  \nLanding Zone: 9005 Tudor Rd - Osborn HS  \nComments: Adult with injuries from an assault. E501B is ground contact for Air Care 1 on 5C.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - I-66) (Trauma) Flyout  \nInc. Address: I-66 W 43.9 MM  \nBox Number: 1187  \nRadio Channel: 5C   \nCommand: BC501 I-66 CMD  \nLanding Zone: I-66 W   \nComments: Medivac for injuries from an MVA. E524 is ground contact for Air Care 2 on 5C.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - Dale Blvd) (Trauma) Flyout  \nInc. Address: 4719 Kellog Dr.   \nBox Number: 1311  \nRadio Channel: 5D  \nCommand: N/A  \nLanding Zone: 4901 Dale Blvd - Beville MS  \nComments: Medivac for adult from injuries from a fall. E518 is ground contact for Air Care 2 on 5D\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - McGrath Rd) (Trauma) Flyout  \nInc. Address: 8498 McGrath Rd  \nBox Number: 0701  \nRadio Channel: 5C  \nCommand: N/A  \nLanding Zone: 10628 Dumfries Rd - National Guard Armory  \nComments: Medivac for adult trauma pt. E507 is ground contact for Life Evac 2 on 5C.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 0243) Trauma Flyout  \nInc. Address: 12836 Tumbling Brook Lane  \nBox Number: 0243  \nRadio Channel: 5C  \nCommand: E514  \nLanding Zone: Woodbridge HS  \nComments: Units on scene of patient who fell down some steps and struck head on concrete.  Requested helicopter.  HMS-2 enroute to LZ.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 1492) (Trauma) Flyout  \nInc. Address: 3001 Old Bridge Road  \nBox Number: 1492  \nRadio Channel: 5C  \nCommand: E514  \nLanding Zone: Woodbridge High School 3001 Old Bridge Road  \nComments: Infant fell and is in/out of cons. E514 ground contact. Medstar 2 responding with a 8 minute ETA\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 1122) (Trauma) Flyout  \nInc. Address: 8005 Sudley Road  \nBox Number: 1122  \nRadio Channel: 5C  \nCommand: AC511  \nLanding Zone: Sinclair Elem. 7801 Garner Dr  \nComments: Injuries from an auto accident (Vehicle into a building)Aircare 1 responding with a 13 minute ETA\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 0707) Trauma Flyout  \nInc. Address: Prince William Parkway / Brentsville Rd.  \nBox Number: 0707  \nRadio Channel: 5C  \nCommand: BC504Z (Jordan)  \nLanding Zone: Bennett Elememtary 8800 Old Dominion Dr.  \nComments: Units on scene of ACCX requesting helicopter.  HAC-1 on scene.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - Box 0707) (Medical/Trauma) Flyout  \nInc. Address: Prince Wm Pkway/Brentsville Rd  \nBox Number: 0707  \nRadio Channel: 5C  \nCommand: BC504Z (Jordan)  \nLanding Zone: Bennett ES @8800 Old Dominion Dr  \nComments: 1 Pt CPR in progress, 1 being extr. Total 3 pts.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org

(Working Incident) Event Type: Structure Fire Townhouse  \nInc. Address: 14357 Newbern Lp.   \nBox Number: 0402  \nRadio Channel: 5C  \nCommand: BC501 Newbern CMD  \nComments: Units arrived nothing showing mid unit townhouse. T5504  reports fire in the basement.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident) Event Type: HOUSE  \nInc. Address: 14440 COLONY CREEK CT  \nBox Number: 1749  \nRadio Channel: 5C  \nCommand: BC502 (BC LITTLE)  \nComments: E517 ON SCENE WITH SMOKE SHOWING FROM SIDE A,C,D AND FROM THE ROOF//ALL OCCUPANTS ARE OUT OF THE BUILDING//STRETCHING A LINE TO SIDE B TO ACCESS THE BASEMENT\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident (Update)) Event Type: HOUSE  \nInc. Address: 14440 COLONY CREEK CT  \nBox Number: 1749  \nRadio Channel: 5C//5D  \nCommand: BC502 (BC LITTLE)  \nComments: FIRE IS KNOCKED DOWN//CHECKING FOR EXTENSION//AND MOPPING UP\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident) Event Type: HOUSE  \nInc. Address: STEPPING STONE DR  \nBox Number: 2427  \nRadio Channel: 5C  \nCommand: CAPT SMITH (E524)  \nComments: UNITS ON SCENE WITH A STRUCTURE FULLY INVOLVED\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident (Update)) Event Type: HOUSE  \nInc. Address: 6100 JAMES MADISON (CORRECTED ADDRESS)  \nBox Number: 2427  \nRadio Channel: 5C  \nCommand:  \nComments: FIRE IS KNOCKED DOWN//FM523 IS ENROUTE//E524,E515,E504,T504 REMAINING ON SCENE FOR OVERHAUL FOR APPROX 1 HOUR  \n  \nE505 FILLING FS524\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident Box 2437) Event Type: House Fire  \nInc. Address: 7315 James Madison Highway  \nBox Number: 2437  \nRadio Channel: 5C  \nCommand: E524  \nComments: E524 on the scene with smoke showing from the roof of a single family house.  \nUFRO Klimtzak\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident Box 8170) Event Type: House Fire  \nInc. Address: 9318 Main Street  \nBox Number: 8170  \nRadio Channel: 5C  \nCommand:   \nComments: Units on the scene with with smoke showing from a single fmaily house\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident - MVA Extrication) Event Type: Auto Acc with extrication  \n Inc. Address: I-95 South 156.2 MM   \n Box Number: 2087  \n Radio Channel: 5C   \n Command: E512   \n Comments: Auto accident involving several vehicles and a Tanker Placard 1993, no active leaks. One pt. needing extrication.\n \n Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
(Working Incident) Event Type: ACCX  \n Inc. Address: I95 SB 152MM  \n Box Number: 1087  \n Radio Channel: 5C  \n Command: 5D//BC507 (BAUM)  \n Comments: UNITS ON SCENE REPORTING 1 DOA//5 ALS//1 BLS//2 PT REFUSALS\n \n Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org

*/


public class VAPrinceWilliamCountyBParser extends VAPrinceWilliamCountyBaseParser {
  
  public VAPrinceWilliamCountyBParser() {
    super("Event_Type:CALL! Inc._Address:ADDR! Box_Number:BOX! Radio_Channel:CH! Command:CMD! Landing_Zone:LZ? Comments:INFO");
  }

  @Override
  public String getFilter() {
    return "@rsan.pwcgov.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    int pt = body.indexOf("Sent by PW Alert to ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (!body.startsWith("Event Type:")) body = "Event Type: " + body;
    return parseFields(body.split("\n"), 5, data);
  }
  
  private static final Pattern PAREN_PTN = Pattern.compile("\\(.*\\)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(PAREN_PTN.matcher(field).replaceAll("").trim(), data);
    }
  }
  
  private class MyCommandField extends MyInfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("N/A")) return;
      super.parse("Cmd: " + field, data);
    }
  }
  
  
  private class MyLZField extends MyInfoField {
    @Override
    public void parse(String field, Data data) {
      super.parse("LZ: " + field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CMD")) return new MyCommandField();
    if (name.equals("LZ")) return new MyLZField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}