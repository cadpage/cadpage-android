package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Flathead County, MT
Contact: Tristan Peterson <twpetetson72@gmail.com>
Sender: dispatch@communicationcenter.com

1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: 417 1ST AVE N Martin City Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 06:29 Info:  ton of cars in front drive, thengo to back yard  had chest pains prior to this  CO UNITS ADV \n(Con't) 3 of 3\ncpr in progress  50 ACK  55 ACK  turning blue  unk what happened, goingto him now  \n(End)
1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Hungry Horse Reservoir Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 21:13 Info:  RUN CARD SHOWED NO FIRE UNITS TODISPATCH, DISPATCHED HHFD AND MCFD FROM MEMORY  1602 AND 1501\n(Con't) 3 of 3\nACK  RP CALLED BACK....FATHER IS FEELING WEAK AND SLEEPY  ADV TO CALL BACKWHEN GETS\n(End)
1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: HIGHWAY 2 E Hungry Horse Call\n(Con't) 2 of 3\nType: F Smoke Investigation - Outside Call Time: 20:00 Info:  RP LIVES AT844 WOODLAND AVE  CAN SEE WHAT APPEARS TO BE A SMOKE CLOUD\n(Con't) 3 of 3\nCOMING FORM THE AREA OF HUNGRY HORSE. \n(End)
1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Call Type: MVA Injury Call Time:\n(Con't) 2 of 3\n17:03 Info:  RP STATED THEY DID NOT NEED ALERT  KIDC SAYS TREMS CAN MAKEIT UP THERE...LOWER LEFT LEG PAIN, NO LOC & SOME HEAD ABRASIONS \n(Con't) 3 of 3\n4 MILES UP RD #497//TOWARD DESERT MTN RD  LEG AND BACK\n(End)

*/
public class MTFlatheadCountyParser extends FieldProgramParser {

  public MTFlatheadCountyParser() {
    super(CITY_LIST, "FLATHEAD COUNTY", "MT",
           "Unit:UNIT! Status:SKIP! Location:ADDR/S! Call_Type:CALL! Call_Time:SKIP! Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@communicationcenter.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Information")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("MAP ")) field = field.substring(4).trim();
      data.strMap = append(data.strMap, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "COLUMBIA FALLS",
    "KALISPELL",
    "WHITEFISH",
    
    "BIGFORK",
    "CORAM",
    "EVERGREEN",
    "HUNGRY HORSE",
    "LAKESIDE",
    "MARTIN CITY",
    "NIARADA",
    "SOMERS",
    
    "POLEBRIDGE",
    "WEST GLACIER",
  };
  
}
