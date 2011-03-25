package net.anei.cadpage.parsers.UT;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Davis County, UT
Contact: Justin Arbogast <arby115@gmail.com>
Sender: paging@co.davis.ut.us
System: Spillman

paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Fire Alarm Comm\n2645 N MAIN ST; 12D ACTION ZONE GYMNASTI\nKEY PAD / RP PENDING
Child Birth\n2539 N 475 W; #B\n17:02:14 11/29/2010 - dmaples\nProQA Medical Recommended Dispatch Level = 24D5\n28 year old, Female, Conscious, B
Pregnancy Prob\n2248 N 75 W\n22:20:36 11/28/2010 - carchbol\nProQA Medical Recommended Dispatch Level = 24D4\n19 year old, Female, Conscious, Br
Fainting\n177 W 1850 N\n20:55:02 11/26/2010 - vjones\nProQA Medical Recommended Dispatch Level = 31D2\n75 year old, Male, Unconscious, Breathing
Fainting\n1086 N 450 W\n20:23:18 11/26/2010 - ebutcher\nProQA Medical Recommended Dispatch Level = 31D4\n52 year old, Female, Conscious, Breathi
paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Acc PI Alpha\n2300 N MAIN ST\nNEG INJURIES, DODGE DURANGO, 2006 TOYT,\n16:14:58 11/24/2010 - D Bird\nIN THE TURNING LANE
paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Domestic\n31 W 1600 N; 8\nman & woman it has been physical, no weapons, alcohol involved, they are\nboth\noutside
paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Medical Standby\n78 W 800 N\n.SUICIDAL TRYING TO GET A KNIFE
*/


public class UTDavisCountyParser extends SmsMsgParser {
  
  private static final Pattern TIME_PAT = Pattern.compile("^\\d\\d:\\d\\d:\\d\\d .*");
  
  public UTDavisCountyParser() {
    super("DAVIS COUNTY", "UT");
  }
  
  @Override
  public String getFilter() {
    return "paging@co.davis.ut.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    int ndx = 1;
    boolean good = false;
    for (String line : body.split("\n")) {
      line = line.trim();

      switch (ndx) {
      
      case 1:
        if (line.startsWith("paging@co.davis.ut.us")) break;
        data.strCall = line;
        ndx++;
        break;
        
      case 2:
        Parser p = new Parser(line);
        parseAddress(p.get(';'), data);
        String extra = p.get();
        if (extra.length() > 0) {
          char first = extra.charAt(0);
          if (! extra.contains(" ") &&
              (first == '#' || Character.isDigit(first))) {
            data.strApt = extra;
          } else {
            data.strPlace = extra;
          }
        }
        good = true;
        ndx++;
        break;
        
      case 3:
        if (line.startsWith("ProQA Medical Recommended Dispatch Level")) break;
        if (TIME_PAT.matcher(line).matches()) break;
        if (data.strSupp.length() > 0) data.strSupp += ' ';
        data.strSupp += line;
        break;
      }
    }
    
    return good;
  }
}
