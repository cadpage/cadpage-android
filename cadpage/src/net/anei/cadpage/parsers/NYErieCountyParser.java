package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Erie County, NY
Contact: "Buttino, John" <John.Buttino@erie.gov>   (network administrator)
AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN
AMH 52 ENDICOTT DR EMS 82 YO M
AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING
AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING
AMH 35 ELM RD EMS 69M CHEST/ARM PAIN

Possible call code values

AMA             MUTUAL AID-Automatic Mutual Aid                   
AP              AIRPORT ALERT                                    
AST             MISCELLANEOUS-Assist                             
BA              ALARMS-Box Alarm                                 
DUP             Duplicate Call                                    
E911            Emergency Call                                    
EMA             ALARMS-EMS Alarm                                 
EMS             EMS-Emergency Medical Service                    
EMSC            EMS-Emergency Medical Service Cold               
F               Structure                                        
FAL             ALARMS-Fire Alarm Activation                     
HM              HAZMAT-Leak, Spill                               
MAA             MUTUAL AID-Ambulance                             
MAF             MUTUAL AID-Fire                                  
MAR             MUTUAL AID-Rescue                                
MAS             MUTUAL AID-Standby                               
MF              Miscellaneous                                    
MVA             EMS-Motor Vehicle Accident                       
MVF             Motor Vehicle                                    
NOT             Notification                                     
POL             Police Emergency                                 
R               EMS-Rescue                                       
SA              Silent Alarm                                     
TR              EMS-Transportation                               
TRC             EMS-Transportation Cold                          
TRH             EMS-Transportation Hot  
*/


public class NYErieCountyParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "NY";
  private static final String DEF_CITY = "ERIE COUNTY";
  
  public NYErieCountyParser() {
    super(DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! body.startsWith("AMH ")) return false;

    data.defState= DEF_STATE;
    data.defCity = DEF_CITY;
    
    parseAddress(StartType.START_ADDR, body.substring(4), data);
    data.strCall = getLeft();
    
    return true;
  }
}
