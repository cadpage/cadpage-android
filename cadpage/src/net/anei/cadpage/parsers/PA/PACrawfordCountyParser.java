package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Crawford County, PA
Contact: Patriot Jon <patriot.jon21@gmail.com>
Sender: OESCAD@WINDSTREAM.NET
DispatchBParser base after combining subject and text

FRM:\nSUBJ:TWDU >TREES/WIRES DOWN URGENT\nMSG:OESCAD:STATE HWY 18 SPRING TWP THARP, DENNIS Cad: 2012-0000000067
FRM:OESCAD@WINDSTREAM.NET\nSUBJ:TWDU  >TREES/WIRES DOWN URGENT\nMSG:OESCAD:STATE HWY 18 SPRING TWP THARP, DENNIS Cad: 2012-0000000067
FRM:OESCAD@WINDSTREAM.NET\nSUBJ:SFR   >STRUCTURE FIRE\nMSG:OESCAD:150 S MAIN ST XS: SPRING ST SPRINGBORO BORO PIERI, PIERINO Map:E-3\n(Con't) 2 of 2\nGrids:0,0 Cad: 2012-0000000547(End)
1 of 2\nFRM:OESCAD@WINDSTREAM.NET\nSUBJ:CS    >CARDIAC SYMPTOMS\nMSG:OESCAD:135 MEAD AVE XS: BEAVER ST SPRINGBORO BORO NAAS, DAVID C Map:E-3\n(Con't) 2 of 2\nGrids:0,0 Cad: 2012-0000001348(End)
1 of 2\nFRM:OESCAD@WINDSTREAM.NET\nSUBJ:UNC   >UNCONSCIOUS SUBJECT\nMSG:OESCAD:104 CUSSEWAGO ST Apt: A Bldg XS: SPRINGBORO RD SPRINGBORO BORO\n(Con't) 2 of 2\nHOOVER,KYLE Map:E-3 Grids:0,0 Cad: 2012-0000001631(End)

*/

public class PACrawfordCountyParser extends DispatchBParser {

  public PACrawfordCountyParser() {
    super(CITY_LIST, "CRAWFORD COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "OESCAD@WINDSTREAM.NET";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.contains(">")) return false;
    body = subject + " " + body;
    return super.parseMsg(body, data);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "MEADVILLE",
    "TITUSVILLE",
    
    // Boroughs
    "BLOOMING VALLEY",
    "CAMBRIDGE SPRINGS",
    "CENTERVILLE",
    "CONNEAUT LAKE",
    "CONNEAUTVILLE",
    "COCHRANTON",
    "HYDETOWN",
    "LINESVILLE",
    "SAEGERTOWN",
    "SPARTANSBURG",
    "SPRINGBORO",
    "TOWNVILLE",
    "VENANGO",
    "WOODCOCK",
    
    // Townships
    "ATHENS TWP",
    "BEAVER TWP",
    "BLOOMFIELD TWP",
    "CAMBRIDGE TWP",
    "CONNEAUT TWP",
    "CUSSEWAGO TWP",
    "EAST FAIRFIELD TWP",
    "EAST FALLOWFIELD TWP",
    "EAST MEAD TWP",
    "FAIRFIELD TWP",
    "GREENWOOD TWP",
    "HAYFIELD TWP",
    "NORTH SHENANGO TWP",
    "OIL CREEK TWP",
    "PINE TWP",
    "RANDOLPH TWP",
    "RICHMOND TWP",
    "ROCKDALE TWP",
    "ROME TWP",
    "SADSBURY TWP",
    "SOUTH SHENANGO TWP",
    "SPARTA TWP",
    "SPRING TWP",
    "STEUBEN TWP",
    "SUMMERHILL TWP",
    "SUMMIT TWP",
    "TROY TWP",
    "UNION TWP",
    "VENANGO TWP",
    "VERNON TWP",
    "WAYNE TWP",
    "WEST FALLOWFIELD TWP",
    "WEST MEAD TWP",
    "WEST SHENANGO TWP",
    "WOODCOCK TWP"
  };
}
