package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
San Joaquin County, CA

BS18-1    Dispatched: 00:45:33 Enroute: 00:48:05 On Scene: 01:00:47 AOR: 01:20:35
BS18-1    Dispatched: 02:01:53 Enroute: 02:04:23 On Scene: 02:05:26 AOR: 02:26:24
T26-1     12018446    Dispatched:18:49:50Enroute:18:51:55On Scene:18:53:54AOR:19:15:58
T26-1     12018446    Dispatched:18:49:50Enroute:        On Scene:        AOR:18:51:14
E26-1     12018782    Dispatched:00:37:41Enroute:00:40:05On Scene:        AOR:00:42:38
T26-1     12018873    Dispatched:05:47:04Enroute:05:49:25On Scene:05:55:03AOR:06:01:39

BS18-1    ZUM-110502      Medical Aid                     3232 E Munford Ave     Dead End/S STATE ROUBldg:            Apt: 3
BS18-1    ZUM-110503      Medical Aid                     1840 S B St     E FOURTH ST/E FIFTH Bldg:            Apt:
T26-1     FRC-120542      Structure Fire                  10331 S Priest Rd                                 E GALIN RD/E KRELL LBldg:            Apt:

E18-1 11020566     Fire Alarm - Co  5045 S State Route 99 E F E ARCH RD/E SUNNY RD 830A
      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386                Assigned Units: E9-3,E9-2,E26-2,BC9-0
BC9-0 12018079     Traffic Collisi W Eleventh St / S Bird Rd                           T327A               Assigned Units: E9-2,T26-2,E9-6,T9-1,BC9-0
T26-1 12018446     Structure Fire   16658 S Ore Claim Trl     W CLAIM STAKE AVE/W  L142A                                Assigned Units:T26-1,E11-1,T26-1,E3-4,E3-1,LM
E26-1 12018116     Vegetation Fire I 5 NB / S KASSON RD                                H5C3                Assigned Units: E9-3,E26-1
      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386                Assigned Units: E9-3,E9-2,E26-2,BC9-0
T26-2 12018956     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B               Assigned Units: T26-2
T9-1  12018957     Traffic Collisi I 580 Eb / S Corral Hollow Rd                       H580C1              Assigned Units: E9-4,E9-8,T9-1,BC9-0,E26-1
      12019053     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B               Assigned Units: T26-2


Contact: John <john499@live.com>
Sender: LifecomCellPaging@amr.net

1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:BS18-1    ZUM-110502      Medical Aid                     3232 E Munford Ave\n(Con't) 2 of 2\n     Dead End/S STATE ROUBldg:            Apt: 3\n(End)
FRM:LifecomCellPaging@amr.net\nMSG:BS18-1    Dispatched: 00:45:33 Enroute: 00:48:05 On Scene: 01:00:47 AOR: 01:20:35
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:BS18-1    ZUM-110503      Medical Aid                     1840 S B St\n(Con't) 2 of 2\n     E FOURTH ST/E FIFTH Bldg:            Apt:\n(End)
FRM:LifecomCellPaging@amr.net\nMSG:BS18-1    Dispatched: 02:01:53 Enroute: 02:04:23 On Scene: 02:05:26 AOR: 02:26:24
FRM:LifecomCellPaging@amr.net\nMSG:E18-1 11020566     Fire Alarm - Co  5045 S State Route 99 E F E ARCH RD/E SUNNY RD 830A

Contact: David Reinhard <r26loki@hotmail.com>
1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386            \n(Con't) 2 of 2\n    Assigned Units: E9-3,E9-2,E26-2,BC9-0\r\n(End)
1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:BC9-0 12018079     Traffic Collisi W Eleventh St / S Bird Rd                           T327A           \n(Con't) 2 of 2\n    Assigned Units: E9-2,T26-2,E9-6,T9-1,BC9-0\r\n(End)
FRM:LifecomCellPaging@amr.net\nMSG:T26-1     12018446    Dispatched:18:49:50Enroute:        On Scene:        AOR:18:51:14
FRM:LifecomCellPaging@amr.net\nMSG:T26-1     12018446    Dispatched:18:49:50Enroute:18:51:55On Scene:18:53:54AOR:19:15:58
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:T26-1 12018446     Structure Fire   16658 S Ore Claim Trl     W CLAIM STAKE AVE/W  L142A               \n(Con't) 2 of 2\n                 Assigned Units:T26-1,E11-1,T26-1,E3-4,E3-1,LM\n(End)
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:T26-1     FRC-120542      Structure Fire                  10331 S Priest Rd                            \n(Con't) 2 of 2\n     E GALIN RD/E KRELL LBldg:            Apt:\n(End)
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:E26-1 12018116     Vegetation Fire I 5 NB / S KASSON RD                                H5C3            \n(Con't) 2 of 2\n    Assigned Units: E9-3,E26-1\n(End)
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386            \n(Con't) 2 of 2\n    Assigned Units: E9-3,E9-2,E26-2,BC9-0\n(End)
FRM:LifecomCellPaging@amr.net\nMSG:E26-1     12018782    Dispatched:00:37:41Enroute:00:40:05On Scene:        AOR:00:42:38\r\n
FRM:LifecomCellPaging@amr.net\nMSG:T26-1     12018873    Dispatched:05:47:04Enroute:05:49:25On Scene:05:55:03AOR:06:01:39\r\n
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:T26-2 12018956     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B           \n(Con't) 2 of 2\n    Assigned Units: T26-2\r\n(End)
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:T9-1  12018957     Traffic Collisi I 580 Eb / S Corral Hollow Rd                       H580C1          \n(Con't) 2 of 2\n    Assigned Units: E9-4,E9-8,T9-1,BC9-0,E26-1\r\n(End)
 1 of 2\nFRM:LifecomCellPaging@amr.net\nMSG:      12019053     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B           \n(Con't) 2 of 2\n    Assigned Units: T26-2\r\n(End)

 */


public class CASanJoaquinCountyParser extends SmartAddressParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile(".*? Dispatched:.*?Enroute:.*?On Scene:.*?AOR:.*");
  private static final Pattern MASTER1 = Pattern.compile("(?:([-A-Z0-9]+) +)?([A-Z]{3}-\\d{6})  +(.*?)  +(.*?)(?:  +(.*?))? *Bldg: *(.*?) *Apt: *(.*)");
  private static final Pattern MASTER2 = Pattern.compile("(?:([-A-Z0-9]+) +)?(\\d{8}) {5}([^ ].*)");
  
  public CASanJoaquinCountyParser() {
    super("SAN JOAQUIN COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "LifecomCellPaging@amr.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // First see if this looks like a run report
    if (RUN_REPORT_PTN.matcher(body).matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    // There are two types of CAD page, check for the first one
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      data.strUnit = getOptGroup(match.group(1));
      data.strCallId = match.group(2);
      data.strCall = match.group(3).trim();
      parseAddress(match.group(4).trim(), data);
      data.strCross = getOptGroup(match.group(5));
      data.strPlace = match.group(6).trim();
      data.strApt = match.group(7).trim();
      return true;
    }
    
    //  See if this matches the second pattern
    match = MASTER2.matcher(body);
    if (match.matches()) {
      data.strUnit = getOptGroup(match.group(1));
      data.strCallId = match.group(2);
      String sAddr = match.group(3).trim();
      if (sAddr.length() <= 20) return false;
      data.strCall = sAddr.substring(0,16).trim();
      Parser p = new Parser(sAddr.substring(16).trim());
      String sUnit = p.getLastOptional("Assigned Units:");
      if (sUnit.length() > 0) data.strUnit = sUnit;
      data.strMap = p.getLast(' ');
      data.strCross = p.getLastOptional("  ");
      sAddr = p.get();
      if (data.strCross.length() > 0) {
        parseAddress(sAddr, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, sAddr, data);
        data.strCross = getLeft();
      }
      return true;
    }
    
    return false;
  }
}
