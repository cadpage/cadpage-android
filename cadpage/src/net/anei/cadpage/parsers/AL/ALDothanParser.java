package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Dothan AL
15:49:38/SC-Service Call Non-Emergency/801 E LAFAYETTE ST/DOTHAN/14523968/ref lines fell at front door, see c404/
16:31:23/SC-Service Call Non-Emergency/401 W INEZ RD/DOTHAN/TANGLEWOOD APARTMENTS/24135869/POWER LINES DOWN AT ENTRANCE, POSS SPARKING, RELAYED BY/
18:35:57/MAID-Mutual Aid Request/5499 MONTGOMERY HWY INTERSECTN/DOTHAN/JOHN D ODOM RD/63981245/ECHO RESCUE --/
18:43:58/S38B-Medical Call-Code III-Emergy/107 RIDGE RD/DOTHAN/95163482/63 YOM HEAD INJURY, S24/
19:03:20/S22CF-Assault-Code II/1486 KINSEY RD/DOTHAN/51943628/ARM HURT, WAS PUSHED/
19:08:26/S38B-Medical Call-Code III-Emergy/1303 SUMMIT ST/DOTHAN/14529368/WEAKNESS, PAIN/
19:17:49/OF-Outdoor Fire-Level 1/1241 KINSEY RD APT186/DOTHAN/JOHNSON 186/51943628/SPARKS SHOOTING FROM POLE/
19:58:39/SC-Service Call Non-Emergency/175 BUFORD LN/DOTHAN/LAKEWOOD FIRE STATION/24318569/A/O -- DO NOT RESPOND/
20:11:48/S8BF-MVC-Code III/2299 JOHN D ODOM RD INTERSECTN/DOTHAN/MURPHY MILL RD/63891245/unk further~~ pr disconnected/
20:15:39/S38B-Medical Call-Code III-Emergy/403 S APPLETREE ST APTJ31/DOTHAN/MARVIN LEWIS J31/14523968/pt low sugar/

*/
public class ALDothanParser extends FieldProgramParser {
  
  
  public ALDothanParser() {
    super("DOTHAN", "AL",
           "SKIP CALL ADDR CITY! ID? UNIT INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    return parseFields(body.split("/"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
