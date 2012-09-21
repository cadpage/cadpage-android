package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Oakland County, MI
Contact: Active911
Agency name: South Lyon Fire Department Location: South Lyon, MI 
Sender: @response.troymi.gov

(South Lyon Medical) Respond to a medical at 106 s lafayette - seizure
(South Lyon Medical) Respond to a medical at south lyon gardens  low heart rate 
(South Lyon Fire Run) Respond to a fire alarm at 23000 valerie for gen fire alarm 
(South Lyon Medical) Respond to a medical at 25376 potomac elderly male fell hit head is conscious 
(South Lyon Medical) Respond to a medical at 501 wellington 5 mth old having seizure 
(South Lyon Medical) Respond to a medical at 25328 franklin terrace
(South Lyon Medical) Respond to a medical at 514 lanier chest pains
(South Lyon Medical) Respond to a medical at 380 Lennox St
(South Lyon Medical) Respond to a medical at 22195 quail run #16 apt 3
(South Lyon Fire Run) Respond to a brush fire at Equestrian/Colt
(South Lyon Medical) Respond to a medical at St Joes Church 830 S Lafayette  for 82 yo fem in/out of conciousness
(South Lyon Fire Run) Respond to a medical at 836 Downy Nest
(South Lyon Medical) Respond to a medical at 22195 quail run apt 3 drk red blood in cath bag patient on cumadin and diabetic
(South Lyon Medical) Respond to a medical at lake st and mill injury accident
(South Lyon Medical) Respond to a medical at witches hat 350 dorothy for poss heart attack
(South Lyon Medical) Respond to a medical at 134 w liberty diabetic high blood sugar vomiting 
(South Lyon Medical) Respond to a medical at 503 stryker male poss suicide by gun shot in chest 
(South Lyon Medical) Respond to a medical at 522 n reese set diff breathing
(South Lyon Medical) Respond to a medical at 535 w lake
(South Lyon Medical) Respond to a medical at 510 lanier  high blood sugar
(South Lyon Medical) Respond to a medical at 559 Old Pond St
(South Lyon Medical) Respond to a medical at 1035 Arabian Ct
(South Lyon Fire Run) Respond to a wires - behind 101 n lafayette SL Herald
(South Lyon Medical) Respond to a medical at 61746 valley forge - diff breathing
(South Lyon Medical) Respond to a medical at 62067 ticonderoga dr apt 5
(South Lyon Medical) Respond to a medical at 414 Ada
(South Lyon Medical) Respond to a medical at 408 washington chest pains diff breathing 
(South Lyon Medical) Respond to a medical at 61702 williamsburg #2
(South Lyon Medical) Respond to a medical at 682 forest
(South Lyon Medical) Respond to a medical at 22185 quail run cir #1
(South Lyon Medical) Respond to a medical at 559 old pond st
(South Lyon Mutual Aid) Respond to a mutal aid request for Green Oak FD for station coverage at Station 83.
(South Lyon Mutual Aid) Respond to a mutal aid request for station coverage at sta 81 and 83 
(South Lyon Medical) Respond to a medical at 62292 yorktown unit 6 medical alarm head pain 
(South Lyon Fire Run) Respond to a alarm at 1047 colt
(South Lyon Mutual Aid) Respond to a mutal aid request for livingston co at station 81
(South Lyon Medical) Respond to a medical at 25110 hamilton ct 78  pain abd
(South Lyon Fire Run) Respond to a grass fire at base of eletrical pole next to 356 cambridge

(South Lyon Fire Run) Respond to a 23000 valerie gen fire alarm zone 1
(South Lyon Fire Run) Respond to a 1131 polo house struck by lightening

(medical) 686 lakewood unk odor inv and rp is feeling ill
(grass fire) 356 cambridge   grass fire
(brush fire) 22350 brookfield  grass fire
(washdown) w lake and n hagadorn   washdown   at scene of pda
(medical) 295 eagle way - choking on vomit

*/

public class MIOaklandCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("Respond to a (.*?) (?:at|-) (.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern END_MARKER = Pattern.compile(" +- +| +for +|  +", Pattern.CASE_INSENSITIVE);
  
  public MIOaklandCountyParser() {
    super("OAKLAND COUNTY", "MI");
    setupMultiWordStreets("DOWNY NEST");
  }
  
  @Override
  public String getFilter() {
    return "@response.troymi.gov";
  }
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() == 0) return false;
    
    Matcher match = MASTER.matcher(body);
    if (match.matches()) {
      data.strCall = match.group(1).trim();
      String sAddr = match.group(2).trim();
      int flags = FLAG_NO_IMPLIED_APT | FLAG_OPT_STREET_SFX;
      match = END_MARKER.matcher(sAddr);
      if (match.find()) {
        data.strSupp = sAddr.substring(match.end()).trim();
        sAddr = sAddr.substring(0,match.start()).trim();
        flags |= FLAG_ANCHOR_END;
      }
      parseAddress(StartType.START_PLACE, flags, sAddr, data);
      if (data.strSupp.length() == 0) data.strSupp = getLeft();
      if (data.strAddress.length() == 0) {
        data.strAddress = data.strPlace;
        data.strPlace = "";
      }
      else if (data.strPlace.equalsIgnoreCase("STA")) {
        data.strAddress = append (data.strPlace + " " + data.strAddress, " ", data.strSupp);
        data.strPlace = "";
        data.strSupp = "";
      }
      return true;
    }
    
    // That was our best shot.  But there are calls that fit different patterns
    if (body.startsWith("Respond to a ")) {
      body = body.substring(13).trim();
      parseAddress(StartType.START_CALL, FLAG_NO_IMPLIED_APT | FLAG_OPT_STREET_SFX, body, data);
      if (data.strCall.length() == 0) data.strCall = getLeft();
      else data.strSupp = getLeft();
      return data.strAddress.length() > 0;
    }
    
    // One last chance, but only if call has been postively IDed as a page
    if (isPositiveId()) {
      parseAddress(StartType.START_ADDR, FLAG_NO_IMPLIED_APT | FLAG_OPT_STREET_SFX, body, data);
      data.strCall = getLeft();
      return data.strCall.length() > 0;
    }
    
    return false;
  }
}
