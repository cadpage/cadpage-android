package net.anei.cadpage.parsers.OK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.general.GeneralParser;

/*
Tulusa, OK
Contact: Greg Rockin M Ranch <catoosafd23@yahoo.com>
Sender: pagealert@cityoftulsa.org

PAGE-OUT / 09:11PM Tue 05/10/2011 2200 N HWY167NB EXPY; UNK WHAT IS ON FIRE CS7 ENR PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 10:40PM Tue 05/10/2011 ***MED EMERG / FALL*** 314 N CHEROKEE ST /// PAFFORD ENRT PUBLIC SAFETY COMMUNICATIONS
02:42AM Wed 05/11/2011 back pain....303 n joanna st, mp 1771....42 yof post back surgery....pafford enr from catoosa..eot PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 08:15PM Wed 05/11/2011 MEDICAL / 17835 E Pine St, Lot 6 / not alert PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 06:13PM Wed 05/11/2011 MVA AT 17700 E I44WB EXP; OHP/PAFFORD ENR PUBLIC SAFETY COMMUNICATIONS
03:50PM Wed 05/11/2011 ***MED EMERG / CP (POST DOM)*** CHEROKEE CASINO LOT D //// PAFFORD ENRT... CASINO WILL HAVE WAIVER AT LIGHT PUBLIC SAFETY COMMUNICATIONS
03:24PM Mon 05/16/2011 Please Call Ramella Hitchcock at 918 261 3786. ref: burning trash at 203 Riter Rd PUBLIC SAFETY COMMUNICATIONS
12:25PM Tue 05/17/2011 MEDICAL EMERGENCY.. SYNCOPAL.. WELLS MIDDLE SCHOOL 2000 S CHEROKEE ST... 14 YR OLD MALE.. PAFFORD ENRT.. EOT PUBLIC SAFETY COMMUNICATIONS
12:40PM Tue 05/17/2011 catoosa chief call dispatch re:citizen burn permit...918 596 9977, thank you..eot PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 01:24PM Tue 05/17/2011 catoosa chief please call dispatch 596 9977, re burn ban...eot PUBLIC SAFETY COMMUNICATIONS
03:18PM Tue 05/17/2011 MEDICAL EMER 20132 E 4 ST  67YOF SEVERE PAIN AND LAC TO LEG THAT IS INFECTED PAFFORD ENRT PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 11:26PM Tue 05/17/2011 TFD WAVED OFF BY PAFFORD, SAYS CATOOSA CAN CANCEL AS WELL. PUBLIC SAFETY COMMUNICATIONS
11:29PM Tue 05/17/2011 MEDICAL 777 W CHEROKEE ST. REC 2316 HRS, DISP 2316, CR ENR 2323, CANCELED BY PAFFORD AT 2326  PUBLIC SAFETY COMMUNICATIONS
12:48PM Thu 05/19/2011 me / od 2000 s cherokee st, 13 yom down between bldgs/ pafford enrt eot PUBLIC SAFETY COMMUNICATIONS
04:07PM Thu 05/19/2011 MED EMERG FEMALE W/ CP. 19300 E PINE ST SONIC RESTAURANT. PAFFORD ENRT. EOT  PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 04:44PM Fri 05/20/2011 777 W CHEROKEE;MCDONALDS;37 YOF INSIDE HAVING CHEST PAINS PUBLIC SAFETY COMMUNICATIONS
PAGE-OUT / 05:32PM Fri 05/20/2011 MEDICAL 19525 E 2 ST S;13 YOM ASLTED; CAT PD ON SCENE PUBLIC SAFETY COMMUNICATIONS
07:40PM Fri 05/20/2011 MED EMERG, CASINO, 50 YOF FELL, HEAD INJURY, TFD E30 ENRT, PAFFORD ENRT  PUBLIC SAFETY COMMUNICATIONS
11:46AM Sat 05/21/2011 SOMEONE FROM CATOOSA FD PLEASE CALL ALARM OFFICE FOR BURN PERMIT 178 SPUNKYCREEK DR PUBLIC SAFETY COMMUNICATIONS

 */
public class OKTulsaParser extends GeneralParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:PAGE-OUT / )?\\d\\d:\\d\\d[AP]M [A-Z][A-Za-z]{2} ");
  private static final Pattern DATE_PTN = Pattern.compile("^\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)? ");
  private static final Pattern DELIM_PTN = Pattern.compile("\\.\\.+|//+");
  
  public OKTulsaParser() {
    super("TULSA", "OK");
  }
  
  @Override
  public String getFilter() {
    return "pagealert@cityoftulsa.org";
  }

  @Override
  protected boolean isPageMsg(String subject, String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // See if message has the right start signature
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    
    // if what is left starts with a date, strip that off
    match = DATE_PTN.matcher(body);
    if (match.find()) body = body.substring(match.end()).trim();
    
    // There are some constructs we know are delimiters that the general parser doesn't
    body = DELIM_PTN.matcher(body).replaceAll(";");
    
    // That's all we can do, time for the general parser to do what it can
    if (super.parseMsg(subject, body, data)) return true;
    
    // If it fails, it can only be because it couldn't find an address
    // We know this is a CAD page so we don't want to fail, so we'll just
    // do our own general alert
    return data.parseGeneralAlert(body);
  }

}
