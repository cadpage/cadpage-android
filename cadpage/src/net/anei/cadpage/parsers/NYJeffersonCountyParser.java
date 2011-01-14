package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Jefferson County, NY

Contact: "jayscad@yahoo.com" <jayscad@yahoo.com>,jay greening <jagx91@gmail.com>
Sender: tirescue@googlegroups.com
BREATHING PROBL|18077 REED POINT RD:ORLEANS(T)|77 YO MALE DIFF BREATHING
ABDOMINAL PAIN|18081 REED POINT RD:ORLEANS(T)|79F  :ProQA Medical Case Entry Finished You are responding to a patient with abdominal pain.  The patient is a  79-year-old female, who is conscious and breathing.  Abdominal Pain / Problems.  Caller Statement: ABDOMINAL PAIN.
ASSIST-EMS|I 81 MM 176 N:ALEXANDRIA(T)|1 mile south of 50 in the north bound lane   vehicle appears to be stuck in mediun    unkn9ow if occupied  :3D63 REQUESTING EMS RESPOND.  ONE FEMALE OCCUPANT COMPLAINING OF WRIST PAIN.
CHEST PAIN|622 JOHN ST:CLAYTON(V)|59 FEMALE/CARDIAC ISSUES
MVA-PI|SHIMEL RD & STATE ROUTE 411:ORLEANS(T)|1 VEH OFF ROAD - MINOR INJURY
FIRE ALARM|37382 ORLEANS CEMETERY RD:ORLEANS(T)|CAPUTO RESIDENCE GENERAL SMOKE ALARM
(DISPATCH:4392) MVA-PI|I 81 MM 176 N:ALEXANDRIA(T)|SPUN OUT IN THE MIDDLE OF DRIVING LANE YELLOW SEDAN NORTHBOUND LANE. CALL Eff Body:(DISPATCH:4392) MVA-PI|I 81 MM 176 N:ALEXANDRIA(T)|SPUN OUT IN THE MIDDLE OF DRIVING LANE YELLOW SEDAN NORTHBOUND LANE. CALL

Sender: lvfd27@googlegroups.com
FALL|34226 CARTER STREET RD:ORLEANS(T)|  CALLBACK=(315)489-3188 LAT=  LON=  
UNC=    06315-489-3188 12/05 17:38:29  071                                 
Verizon Wireless            WPH1                 Honey Flats Road - SW  
Sector                   LaFargeville                  NY                     
                                LAT:+044.158612  LON:-075.905035ELV:+00000  
COF:1709      COP:100MTN:315-511-4647       CPF:VZW  -911ai.com-             
ESN:01315

 */


public class NYJeffersonCountyParser extends SmsMsgParser {
  
  public NYJeffersonCountyParser() {
    super("JEFFERSON COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String[] flds = body.split("\\|");
    if (flds.length != 3) return false;
    
    data.strCall = flds[0].trim();
    
    Parser p = new Parser(flds[1].trim());
    parseAddress(p.get(':'), data);
    data.strCity = p.get('(');
    
    data.strSupp = flds[2];
    
    return true;
  }
}
