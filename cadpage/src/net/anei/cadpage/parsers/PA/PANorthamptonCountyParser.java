package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Northampton County, PA
Contact: Matt Winter <mattgwinter@gmail.com>
Sender: @notifync.orgaddress
DispatchBParser subclass

[e49]ALS >ADVANCED LIFE SUPPORT CALL 602 E 21ST ST Apt: 119 Bldg NORTHAMPTON DIANE ECK Map: Grids:0,0 Cad: 2011-0000086714
[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE Apt: REAR Bldg NORTHAMPTON TONY FERRERA Map: Grids:0,0 Cad: 2011-00000
[e49]MVAI >MVA WITH INJURIES 248 AT PENNSVILLE LIGHT LEHIGH TWP NATALIE BRODIANO Cad: 2011-0000086361
[e49]ALS >ADVANCED LIFE SUPPORT CALL 612 E 10TH ST NORTHAMPTON ROBERTS PAMELA Map: Grids:0,0 Cad: 2011-0000086262
[e49]BLS >BASIC LIFE SUPPORT CALL 1001 WASHINGTON AVE Apt: 105 Bldg NORTHAMPTON MEGAN MOREY Map: Grids:0,0 Cad: 2011-000008
[e49]ALS >ADVANCED LIFE SUPPORT CALL 5962 KEYSTONE DR EAST ALLEN CHRISTINA WIGMER Map: Grids:0,0 Cad: 2011-0000086103
[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE NORTHAMPTON TONY CABRERA Map: Grids:0,0 Cad: 2011-0000086010

Contact: "richierrs@aol.com" <richierrs@aol.com>
Sender: alert@notifync.org
Subject:#6550\n[f14]MVAU >MVA WITH UNKNOW INJUIRIES WILLOW PARK RD BETHLEHEM TWP P1736 Map: Grids:0,0 Cad: 2011-0000131105

Contact: Edmund Lamontagne <edmundl79@gmail.com>
*3750: *alert_6JP4@notifync.org /  / [f25]ODOR >ODOR / OTHER THAN SMOKE ARNDT RD FORKS Map: Grids:0,0 Cad: 2011-0000171220 <20110000171220>

Contact: soupport@active911.com
[#8ICT  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 6303 HANOVERVILLE RD EAST ALLEN SARA HILBERT Map: Grids:0,0 Cad: 2012-0000098761\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397037&c=f5d0d for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IJN  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5516 LOIS LN EAST ALLEN HOSER, CHRISTINE Map: Grids:0,0 Cad: 2012-0000099349\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397283&c=8e4b8 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IKZ  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 251 S GREENBRIAR DR EAST ALLEN HORTON, ROBERT Map: Grids:0,0 Cad: 2012-0000099450\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397331&c=4e113 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IMN  Northampton County PA CAD] [e46]MVA >MVA NONE INJURY AIRPORT RD EAST ALLEN 4676 Map: Grids:0,0 Cad: 2012-0000099584\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397391&c=b9536 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IXF  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 478 BLUE MOUNTAIN DR LEHIGH KARMONICK, TERRY Map: Grids:0,0 Cad: 2012-0000100411\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397779&c=77340 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8J0R  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5701 COLONY DR EAST ALLEN MARY JOE DEEGAN Map: Grids:0,0 Cad: 2012-0000100593\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397899&c=90443 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8J2X  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 5745 COLONY DR EAST ALLEN WENGRYN HELEN Map: Grids:0,0 Cad: 2012-0000100697\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397977&c=2f09b for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8J6H  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5897 LEHIGH LN EAST ALLEN WALTON, CECELIA Map: Grids:0,0 Cad: 2012-0000100946\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=398105&c=61154 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n

*/

public class PANorthamptonCountyParser extends DispatchBParser {
  
  private static final Pattern MARKER = Pattern.compile(">.* Cad: ");
  
  @Override
  public String getFilter() {
    return "@notifync.org";
  }
 
  @Override
  protected boolean isPageMsg(String body) {
    return MARKER.matcher(body).find();
  }

  public PANorthamptonCountyParser() {
    super(CITY_LIST, "NORTHAMPTON COUNTY", "PA");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    data.strUnit = new Parser(subject).getLast('|');
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    body = body.replace(" CALL ", " AT ");
    if (!super.parseMsg(body, data)) return false;
    return true;
  }

  @Override
  protected boolean parseAddrField(String field, Data data) {
    // TODO Auto-generated method stub
    return super.parseAddrField(field, data);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BETHLEHEM",
    "EASTON",

    "BANGOR",
    "BATH",
    "CHAPMAN",
    "EAST ALLEN",
    "EAST BANGOR",
    "FREEMANSBURG",
    "GLENDON",
    "HELLERTOWN",
    "NAZARETH",
    "NORTH CATASAUQUA",
    "NORTHAMPTON",
    "PEN ARGYL",
    "PORTLAND",
    "ROSETO",
    "STOCKERTOWN",
    "TATAMY",
    "WALNUTPORT",
    "WEST EASTON",
    "WILSON",
    "WIND GAP",

    "ALLEN TWP",
    "BETHLEHEM TWP",
    "BUSHKILL TWP",
    "EAST ALLEN TWP",
    "FORKS TWP",
    "HANOVER TWP",
    "LEHIGH TWP",
    "LOWER MOUNT BETHEL TWP",
    "LOWER NAZARETH TWP",
    "LOWER SAUCON TWP",
    "MOORE TWP",
    "PALMER TWP",
    "PLAINFIELD TWP",
    "UPPER MOUNT BETHEL TWP",
    "UPPER NAZARETH TWP",
    "WASHINGTON TWP",
    "WILLIAMS TWP"
  };
}
