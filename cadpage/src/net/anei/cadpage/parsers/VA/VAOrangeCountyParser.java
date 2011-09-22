package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Orange county, VA
Contact: Mike Cianci <ciancims@gmail.com>
Sender: orange911@oorange.org

[7/13/2011 08:26] orange911@oorange.org: [Orange911]  [LOCATION]: GERMANNA HWY  [NATURE]: AA- Auto Accident  [INCIDENT#]: 2011-00003013 00:41 Locust Grove BOX 2901 Map Page 20
[7/18/2011 08:42] orange911@oorange.org: [Orange911]  [LOCATION]: 11111 PLANK RD  [NATURE]: AA- Auto Accident  [INCIDENT#]: 2011-00003105 08:39
[7/20/2011 15:46] orange911@oorange.org: [Orange911]  [LOCATION]: 35059 GERMANNA HEIGHTS DR  [NATURE]: Medical Alarm  [INCIDENT#]: 2011-00003133 15:44 A AND K BLVD / GERMANNA HWY Locust Grove BOX 2901
[7/21/2011 22:40] orange911@oorange.org: [Orange911]  [LOCATION]: 602 YORKTOWN BLVD  [NATURE]: Unconscious  [INCIDENT#]: 2011-00003155 22:36 CONSTITUTION BLVD / HOLLYFIELD PARK RD Locust Grove BOX 290
[7/22/2011 04:30] orange911@oorange.org: [Orange911]  [LOCATION]: 504 CORNWALLIS AVE  [NATURE]: Fire Alarm RES  [INCIDENT#]: 2011-00003158 04:27 WOODLAWN TRL / WASHINGTON ST Locust Grove BOX 2900 Map
[7/22/2011 05:14] orange911@oorange.org: [Orange911]  [LOCATION]: 116 REPUBLIC AVE  [NATURE]: Unconscious  [INCIDENT#]: 2011-00003159 05:11 PARLIAMENT ST / FREEDOM RD Locust Grove BOX 2900 Map Page 30
[7/22/2011 13:35] orange911@oorange.org: [Orange911]  [LOCATION]: 415 HARRISON CIR  [NATURE]: Public Service   [INCIDENT#]: 2011-00003167 13:33 MANASSAS PT / RAMSAY RD Locust Grove BOX 2900 Map Page 3
[7/22/2011 18:17] orange911@oorange.org: [Orange911]  [LOCATION]: SCFR 7  [NATURE]: Station Fill  [INCIDENT#]: 2011-00003170 18:15 Spotsylvania County
[7/22/2011 18:26] orange911@oorange.org: [Orange911]  [LOCATION]: 25505 ELYS FORD ROAD  [NATURE]: Smell of Smoke RES  [INCIDENT#]: 2011-00003171 18:24 Spotsylvania County
[7/22/2011 22:51] orange911@oorange.org: [Orange911]  [LOCATION]: 144 MADISON CIR  [NATURE]: Public Service   [INCIDENT#]: 2011-00003178 22:48 SUSSEX RD / LAKEVIEW PKWY Locust Grove BOX 2900 Map Page
[7/23/2011 08:53] orange911@oorange.org: [Orange911]  [LOCATION]: CHESTERFIELD RD  [NATURE]: Unconscious  [INCIDENT#]: 2011-00003183 08:49 Locust Grove BOX 2901 Map Page 5
[7/23/2011 20:36] orange911@oorange.org: [Orange911]  [LOCATION]: 33011 INDIANTOWN RD  [NATURE]: AA- W/ ENT  [INCIDENT#]: 2011-00003197 20:14 UNKNOWN / LILLY PAD LN Locust Grove BOX 2907 Map Page 4
[7/23/2011 20:37] orange911@oorange.org: [Orange911]  [LOCATION]: 33011 INDIANTOWN RD  [NATURE]: AA- W/ ENT  [INCIDENT#]: 2011-00003197 20:14 UNKNOWN / LILLY PAD LN Locust Grove BOX 2907 Map Page 4
[7/24/2011 09:39] orange911@oorange.org: [Orange911]  [LOCATION]: 112 JEFFERSON AVE  [NATURE]: Fire Alarm RES  [INCIDENT#]: 2011-00003204 09:36 MONTICELLO CIR / MONTICELLO CIR Locust Grove BOX 2900 Ma
[7/24/2011 13:34] orange911@oorange.org: [Orange911]  [LOCATION]: 838 EASTOVER PKWY  [NATURE]: Illness  [INCIDENT#]: 2011-00003208 13:14 LARKSPUR LN / WILDERNESS LN Locust Grove BOX 2900 Map Page 316
[7/25/2011 16:55] orange911@oorange.org: [Orange911]  [LOCATION]: 208 PINE VALLEY RD  [NATURE]: Structure Fire RES  [INCIDENT#]: 2011-00003226 16:52 DEAD END / APPLEVIEW CT Locust Grove BOX 2900 Map P
[7/29/2011 14:17] orange911@oorange.org: [Orange911]  [LOCATION]: 2130 GERMANNA HWY  [NATURE]: Fire Alarm NHSA  [INCIDENT#]: 2011-00003273 14:15 SPOTSWOOD DR / HAMPTON LN Locust Grove BOX 2903 Map Pag
[7/29/2011 14:29] orange911@oorange.org: [Orange911]  [LOCATION]: 2130 GERMANNA HWY  [NATURE]: Fire Alarm NHSA  [INCIDENT#]: 2011-00003274 14:27 SPOTSWOOD DR / HAMPTON LN Locust Grove BOX 2903 Map Pag
[7/23/2011 15:36] orange911@oorange.org: [Orange911]  Orange County is under severe thunderstorm warning until 1545.  Storm is capable of producing damaging winds in excess of 60 mph.

 */


public class VAOrangeCountyParser extends FieldProgramParser {
    
  
  public VAOrangeCountyParser() {
    super(CITY_LIST, "ORANGE COUNTY", "VA",
           "[LOCATION]:ADDR! [NATURE]:CALL! [INCIDENT#]:ID! BOX:BOX Map:MAP");
  }
  
  @Override
  public String getFilter() {
    return "orange911@oorange.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("[LOCATION]:");
    if (pt > 0) {
      body = body.substring(pt).replace(" BOX ", " BOX: ").replace(" Map ", " Map: ");
      return super.parseMsg(body, data);
    } else if ((pt = body.indexOf("[Orange911]  ")) > 0) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body.substring(pt+13).trim();
      return true;
    }
    return false;
  }
  
  private class MyIdField extends IdField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCallId = p.get(' ');
      p.get(' ');
      field = p.get();
      parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY | FLAG_ANCHOR_END, field, data);
      data.strCross = data.strPlace.replace("/", " / ");
      data.strPlace = "";
    }
    
    @Override
    public String getFieldNames() {
      return "ID X CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "GORDONSVILLE",
    "ORANGE",
    "BARBOURSVILLE",
    "LOCUST GROVE",
    
    "MADISON COUNTY",
    "CULPEPER COUNTY",
    "SPOTSYLVANIA COUNTY",
    "LOUISA COUNTY",
    "ALBEMARLE COUNTY",
    "GREENE COUNTY"
  };
}
