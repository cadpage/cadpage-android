package net.anei.cadpage.parsers.TX;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/* 
Montgomery County, TX
Contact: Brian Mulligan <fireguyl19@gmail.com>, Brian Mulligan <bmulligan@avfd.com>
Sender: firecad@thewoodlandstownship-tx.gov
System: Firecom

[Fire CAD Message]  New Fire Run: 2010-63654,Nature: 12D02E-SEIZURE - Continuous or Multiple seizures,MR54,Location: 12246 TRAIL HOLLOW DR,Buildi
[Fire CAD Message]  New Fire Run: 2010-63564,Nature: 19D04-HEART PROBLEMS - Clammy,MR51,Location: HIGHWAY 105 W & S FM 1486,Building: ,Cross: ,,G
[Fire CAD Message]  New Fire Run: 2010-63733,Nature: F15-ILLEGAL BURN,E55;,Location: 14321 FOREST CIR E-MO,Building: ,Cross: 14658 FOREST CIR-MO,
[Fire CAD Message]  New Fire Run: 2010-63709,Nature: F25-RESIDENTIAL FIRE,E51;,Location: 159 S PINE DR-MO,Building: ,Cross: 132 N PINE DR-MO,132
[Fire CAD Message]  New Fire Run: 2010-63739,Nature: F15-ILLEGAL BURN,E51;,Location: PINE LN-MO/HICKORY DR-MO,Building: ,Cross: 19902 PINE LN-MO,
[Fire CAD Message]  New Fire Run: 2010-63762,Nature: 10C04-CHEST PAIN - Breathing Normally => 35,MR51,Location: 24495 REED RD,Building: ,Cross: ,
[Fire CAD Message]  New Fire Run: 2010-63789,Nature: 17D03-FALL - Not alert,MR51,Location: 1953 DR MARTIN LUTHER KING JR DR,Building: ,Cross: ,,G
[Fire CAD Message]  New Fire Run: 2010-63800,Nature: 28C01G-STROKE/CVA - Not alert - Greater than one hour onset,MR55,Location: 1 FAIRFIELD DR,Bu
[Fire CAD Message]  2011-64534,CLOSED CALL: DISP 18:06:34,AVL 18:24:17,.
[Fire CAD Message]  Run# 2010-63824 Trk E51,E54,E55,E31,T51,T31,TN51,FM1,BAT5,TN31 TAC NORTH (01900149-940),. 

 */

public class TXMontgomeryCountyParser extends FieldProgramParser {
  
  private static final String DEF_STATE = "TX";
  private static final String DEF_CITY = "MONTGOMERY COUNTY";
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MO",   "MONTGOMERY"
  });
  
  public TXMontgomeryCountyParser() {
    super(CITY_CODES, DEF_CITY, DEF_STATE,
           "New_Fire_Run:ID Nature:CALL Location:ADDR/c! UNIT Building:APT Cross:X/c");
  }
  
  @Override
  public String getFilter() {
    return "firecad@thewoodlandstownship-tx.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Fire CAD Message")) return false;
    return parseFields(body.split(","), data);
  }
}
