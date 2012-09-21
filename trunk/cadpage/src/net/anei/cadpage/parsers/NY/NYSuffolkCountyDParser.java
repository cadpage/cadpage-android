package net.anei.cadpage.parsers.NY;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Suffolk County NY (Port Jefferson Volunteer Ambulance)
Contact: Jason Lazerus <jlazerus@pjvac.org>
Sender: paging@pjvac.org

UNKNOWN PROBLEM - STANDING, SITTING UP, MOVING OR TALKING code: 32-B-1 at: 3 STANDISH DR c/s: CHIPPENDALE DR d/t: 06/30 00:01:30
PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE - NON SUICIDAL AND ALERT code: 25-A-1 at: 60 N COUNTRY RD c/s: PINE HILL RD d/t: 06/30 19:53:51
SICK - NO PRIORITY SYMPTOMS (COMPLAINT CONDITIONS 2-11 NOT IDENTIFIED) code: 26-A-1 at: 11 BURNETT CT c/s: LOUDEN LP d/t: 06/30 11:27:10
BURNS (SCALDS) / EXPLOSION - FIRE ALARM (UNKNOWN SITUATION) code: 7-A-2 at: 11 BRADDOCK CT c/s: STRATHMORE CT d/t: 06/28 19:37:00
PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE - UNKNOWN STATUS / OTHER CODES NOT APPLICABLE code: 25-B-6V at: 99 CLIFF RD c/s: CROOKED OAK RD d/t: 06/26 07:27:08
RESPIRATORY - DIFFICULTY SPEAKING BETWEEN BREATHS code: 6-D-2 at: 640 BELLE TERRE RD c/s: PRINCESS TREE CT d/t: 06/27 15:57:11
BLEEDING / LACERATIONS - NOT ALERT code: 21-D-2 at: 70 N COUNTRY RD c/s: PINE HILL RD d/t: 06/24 15:58:51
MOTOR VEHICLE ACCIDENT - NOT ALERT code: 29-D-5 at: CANAL RD c/s: OSBORNE AV d/t: 06/25 13:15:03

Contact: Kevin Leedham <kl53rfd@gmail.com>
Sender: ridge@rednmxcad.com
30-D-2 TRAUMATIC INJURY (SPECIFIC)-NOT ALERT at: 6 REDBROOK LN c/s: RANDALL RD & FARMHOUSE LN d/t: 10/09 18:41
29-B-1 MOTOR VEHICLE ACCIDENT-INJURIES at:  c/s: MEDFORD RD & MIDDLE COUNTRY RD d/t: 10/09 09:31
1-C-5 ABDOMINAL PAINS-MALES WITH PAIN ABOVE NAVEL >=35 at: 44 RIDGE RD c/s: MIDDLE COUNTRY RD & SHARON CT d/t: 10/08 14:21
17-A-1G FALLS-NOT DANGEROUS BODY AREA at: 15D GUILFORD CT c/s:  & BRIDGEWATER DR d/t: 10/10 09:53
25-B-6 PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICI-UNKNOWN STATUS / OTHER CODES NOT APPLICA at: 262 EDINBURGH DR c/s: BROWNFIELD DR & KINGSTON 
29-B-1 MOTOR VEHICLE ACCIDENT-INJURIES at:  c/s: SB WILLIAM FLOYD PKWY & MORICHES MIDDLE ISLAND RD d/t: 10/27 09:13

Contact: support@action911.com
[] CHEST PAIN - NORMAL BREATHING (AGE >=35) code: 10-C-4 at: 43 WHITE BIRCH CIR c/s: CENTRAL BLVD d/t: 02/07 23:25:51\n
[] UNCONSCIOUS / FAINTING (NEAR) - FAINTING EPISODE(S) AND ALERT >=35 (WITH CARDIAC HISTORY) code: 31-C-2 at: ROUTE 25A c/s:  d/t: 02/08 19:17:00\n
[] DIABETIC - UNCONSCIOUS code: 13-D-1 at: 7 BRADDOCK CT c/s: STRATHMORE CT d/t: 02/08 21:30:30\n
[] BURNS (SCALDS) / EXPLOSION - FIRE ALARM (UNKNOWN SITUATION) code: 7-A-2 at: 3 PURITAN PATH, PORT JEFFERSON c/s: PILGRIM DR d/t: 02/09 10:08:19\n
[] UNKNOWN PROBLEM - MEDICAL ALERT NOTIFICATION code: 32-B-2 at: 22 LANDING LN, PORT JEFFERSON c/s: OLD HOMESTEAD RD d/t: 02/09 11:11:32\n
[] BLEEDING / LACERATIONS - SERIOUS HEMORRHAGE code: 21-B-2 at: 12 HEARTHSIDE DR, MOUNT SINAI c/s: COBBLESTONE WAY d/t: 02/09 15:50:23\n

 */

public class NYSuffolkCountyDParser extends FieldProgramParser {
  
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}-[A-Z]-\\d{1,2}[A-Z]?) ");
  
  public NYSuffolkCountyDParser() {
    super("SUFFOLK COUNTY","NY",
    "CALL! code:CODE? at:ADDRCITY! c/s:X! d/t:DATETIME");
  }

  @Override
  public String getFilter() {
    return "paging@pjvac.org,";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCode.length() == 0) {
      Matcher match = CODE_PTN.matcher(data.strCall);
      if (match.find()) {
        data.strCode = match.group(1);
        data.strCall = data.strCall.substring(match.end()).trim();
      }
    }
    
    if (data.strAddress.length() == 0) {
      String sAddr = data.strCross;
      data.strCross = "";
      parseAddress(sAddr, data);
    }
    return true;
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("&")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
      
  }
}
