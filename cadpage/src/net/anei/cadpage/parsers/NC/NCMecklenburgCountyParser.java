package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Mecklenburg County, NC
Contact: Rick <very.orange@gmail.com>
Sender: paging@rcscom.com
System: TriTech VisiCAD

Subject:Text Page\n18758 Silver Quay Dr                                                  Charlie                       17- Falls/Back injur
Subject:Text Page\n03172011-073     Received:  08:42    Assigned:  08:43    Enroute:   08:45    Arrived:   08:48    Pt Contact:         Can
Subject:Text Page\n19485 Old Jetton Rd           ste 100   Lakeside Familty Physicians anDelta                         31- Unconsciousness/
Subject:Text Page\n03172011-239     Received:  16:59    Assigned:  16:59    Enroute:   17:01    Arrived:   17:02    Pt Contact:         Can

Contact: Tucker Sizemore <tsizemore@gmail.com>
Sender: @huntersvillefd.com
(Text Page) 04022011-202     Received:  15:29    Assigned:  15:29    Enroute:            Arrived:            Pt Contact:
(Text Page) 16710 Northcross Dr                                                   Fire -  Emergency             59-Fuel Spi
(Text Page) 04022011-238     Received:  16:50    Assigned:  16:50    Enroute:   16:51    Arrived:   16:59    Pt Contact:
(Text Page) 19180-19209 Coachmans Trace             GLENRIDGE                     Fire -  Emergency             69-Structure Fire             Meadow Crossing L

Contact: John Stroup <jbstroup3@gmail.com>
Subject:Incoming Message\n16738 Amberside Rd East                 Alexander Chase Condos        Fire -  Emergency             52F-Alarm-FIRE

Contact: David Fuller <firefighter19163@netscape.com>
Subject:Incoming Message\n9150 Lawyers Rd                         McDonalds - Mint Hill         Charlie                       06- Breathing Pr
Subject:Incoming Message\n10043 Idlewild Rd             126       Willow Grove Retirement       Charlie                       06- Breathing Pr

Contact: David Boyd <rookiefire14@gmail.com>
(Incoming Message) 19432 Fridley Ln                        medical alarm .. no pt info ..Charlie                       32- Unknown problem (man down)Denae Lynn

Contact: Michael Filliben <mfillibene16@gmail.com>
Sender: Group_Page_Notification@archwireless.net
9120 Willow Ridge Rd          307A      Regency Retirement            Charlie                       26- Sick person               Goodsell
12463 Stratfield Place Cr               CAROLINA CROSSING SUBD        Delta                         31- Unconsciousness/Fainting  Stineway Ct/Sam Meeks Rd                                    PINR3     Map - 405405/J9 07302011-086
1010 Lakeview Dr              30-B      Pvl Rehab & Living Ctr  *SNF* Charlie                       06- Breathing Problems        Eden Cr/B

** NOT IMPLEMENTED **
Contact: John Stroup <j.stroup@northmeckrescue.org>
Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr1 Map - 266266/
Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr2 Map - 266266/

Contact: Ben Reagan <breagan@eastlincolnfd.org>
(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F
(Incoming Message) 13000-blk Hidcote Ct                    BURNING BRUSH                 Fire -  Emergency             67-
(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F
(Incoming Message) 14341 Salem Ridge Rd                    residential fire alarm        Fire -  Emergency             52F

*/

public class NCMecklenburgCountyParser extends SmsMsgParser {
  
  private static final String[] PRI_VALUES = new String[]{"Charlie", "Delta", "Fire - Emergency"};
  
  public NCMecklenburgCountyParser() {
    super("MECKLENBURG COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "paging@rcscom.com,@huntersvillefd.com,Group_Page_Notification@archwireless.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(body.length() < 110) return false;
    if (body.contains("Received:")) return false;
    
    boolean good = subject.equals("Text Page") || subject.equals("Incoming Message");
    
    parseAddress(substring(body,0,30), data);
    data.strApt = substring(body,30,40);
    data.strPlace = substring(body,40,70);
    data.strSupp = substring(body,70,100);
    data.strCall = substring(body,100,130);
    data.strCross = substring(body,130,190);
    data.strChannel = substring(body,190,200);
    data.strMap = substring(body,206,216);
    data.strCallId = substring(body,216);

    if (!good) {
      for (String priVal : PRI_VALUES) {
        if (data.strSupp.equals(priVal)) {
          good = true;
          break;
        }
      }
    }
    return good;
  }
  
  private String substring(String body, int st) {
    return substring(body, st, Integer.MAX_VALUE);
  }
  
  private String substring(String body, int st, int end) {
    int len = body.length();
    if (st >= len) return "";
    if (end > len) end = len;
    return body.substring(st, end).trim();
  }

}
