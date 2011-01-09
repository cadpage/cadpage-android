package net.anei.cadpage.parsers;

import org.junit.Test;


public class IAWoodburyCountyParserTest extends BaseParserTest {
  
  public IAWoodburyCountyParserTest() {
    setParser(new IAWoodburyCountyParser(), "WOODBURY COUNTY", "IA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "J:FIRE ALARM/813 N DERBY LN NORTH SIOUX PORTIONABLES/ FREEDOM DR & DEVILSFOOD DR/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/ PORTIONABLES.... WATER FLOW ALARM",
        "CALL:FIRE ALARM",
        "ADDR:813 N DERBY LN",
        "CITY:NORTH SIOUX",
        "X:FREEDOM DR & DEVILSFOOD DR",
        "UNIT:72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8",
        "INFO:PORTIONABLES.... WATER FLOW ALARM");
    
    doTest("T2",
        "J:FIRE SM VEHICLE/110 SODRAC DR NORTH SIOUX RED CARPET INN/ RIVER DR &/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/ TRUCK SMOKING LOOKS ON FIRE- NOBODY AROUND -IN FRONT OF INN",
        "CALL:FIRE SM VEHICLE",
        "ADDR:110 SODRAC DR",
        "X:RIVER DR",
        "CITY:NORTH SIOUX",
        "UNIT:72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8",
        "INFO:TRUCK SMOKING LOOKS ON FIRE- NOBODY AROUND -IN FRONT OF INN");
   
  }
}