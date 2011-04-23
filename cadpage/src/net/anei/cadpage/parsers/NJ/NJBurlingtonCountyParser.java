package net.anei.cadpage.parsers.NJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/*
Burlington County, NJ
Contact: Jerseyfirefighter@gmail.com
Contact: Darren Randall <darren.randall@vincentfire.org>
Sender: 7770*

.... (Station 171) : 129F E Mva/Fire             Priority: 1  : RT206                                              Venue: Southamptn    Cross Street . : CARRANZA RD Call Time- 16:56:48                                : 1721 : (609) 668-8686                Caller : CHARITA.THOMAS Nature of Call : MVA UNK INJS/FIRE IN VEH Additional Info    WPH1:  RADIUS 02 MILES Additional Inc#s
.... (Station 171) :   11 F StrctrFire           Priority: 1  : 4209 RT563                                 Venue: Woodland  Located Between  : RT532/S OOY PLACE RD Call Time- 19:30:14                                : 2911 : (609) 848-4053                Caller : RODNEY CONCILMAN  Complaintant: 4211 RT563 Nature of Call : FLAMES COMING OUT OF THE CHIMNEY// Additional Inc#s
.... (Station 171) :  EMS E EMS Call             Priority: 1  : 1883 RT38                                          Venue: Southamptn  Located Between  : SMITHVILLE RD/RT206   : DIAMOND M LUMBER Call Time- 09:35:44                      : 1711: (609) 261-2701                Caller : NJSP Nature of Call : MVA / RQST EMS
.... (Station 171) : FIRE F Fire Call            Priority: 1  : 26 NEW RD                                            Venue: Tabernacle  Located Between  : SOUTHAMPTON TWP LINE/WALTHAM DR Call Time- 19:50:50                                : 4312 : (609) 268-8218                Caller : JOHN JR MEALE Nature of Call : POSS CHIMNEY FIRE Additional Info    RESD:    MEMBER OF STATION 439 ON LOCATION (REEPORTING BY PHONE)      19:55:26   REPORTING A WORKING CHIMNEY FIRE //     
.... (Station 171) :  EMS E EMS Call             Priority: 1  : 2400 RT70                                            Venue: Southamptn  Located Between  : BURRS MILL RD/MILE RD Call Time- 15:16:39                                : 1723 : (732) 581-5640                Caller : JOEL MADDEN Nature of Call : VEH INTO TREE Additional Info    WPH2:  RADIUS 04 MILES Additional Inc#s
.... (Station 171) : 129F E Mva/Fire             Priority: 1  : 2400 RT70                                          Venue: Southamptn  Located Between  : BURRS MILL RD/MILE RD Call Time- 15:16:39                       : 1723 : (732) 581-5640                Caller : JOEL MADDEN Nature of Call : VEH INTO TREE Additional Info    WPH2:  MM24 Additional Inc#s
.... (Station 171) : FIRE F Fire Call            Priority: 1  : 412 PRICKETTS MILL RD                                Venue: Tabernacle  Located Between  : MEDFORD LAKES RD/OAKSHADE RD Call Time- 16:20:29                                : 4310 : (609) 268-1974                Caller : JUDY GERBER Nature of Call : CHIMNEY FIRE // Additional Info    RESD: Additional Inc#s

23  \n   Caller Address  . . : WIRELESS CALLER                      15:55:23  \n   Caller Phone   : (609)668-5448                        15:55:23  \nAdditionalE911 Caller: SPRINT NEXTEL,,,                     15:56:50  \n   Caller Address  . . : WIRELESS CALLER                      15:56:50  \n   Caller Phone   : (609)379-0656                        15:56:50 \n\nAdditional Inc#s


.... (Station 171) : 1  \n: 10 WINDING WY                                        Venue: Southamptn  \nLocated Between  : PHEASANT CL/DEAD END \n\nCall Time- 19:13:51\                                : 1711 \n\n: (856) 287-8607                Caller : VERIZON WIRELESS \n\nNature of Call : MALE UNCONSCIOUS POSS OVERDOSE \n\nAdditional Info  \n\2sWPH2:  RADIUS 02 MILES
.... (Station 171) : 1  \n: STOCKTONS BRIDGE RD                                  Venue: Pembtn Twp  \n  Cross Street . : SIMONTOWN RD \n\nCall Time- 19:47:43                                : 1822 \n\n: (000) 000-0000                Caller : KGB CARRIER \n\nNature of Call : TRAILER FIRE \n\n  \nF1911 RSPNDING/COLUMN IN SIGHT                               19:50:52 \n\nAdditional Inc#s


*/

public class NJBurlingtonCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "Southamptn", "Southampton",
      "Woodland",   "Woodland",
      "Pembtn Twp", "Pemberton Twp",
      "Pembtn Bor", "Pemberton",
      "Eastampton", "Eastampton",
      "Tabernacle", "Tabernacle",
      "MedfordTwp", "Medford Twp",
      "MedfordLks", "Medford Lakes",
      "Lumberton",  "Lumberton",
      "Shamong",    "Shamong"
  });
  
  private static final Pattern MARKER = Pattern.compile("^\\.\\.\\.\\. \\(([\\w ]+)\\) : ");
  
  public NJBurlingtonCountyParser() {
    super(CITY_CODES, "BURLINGTON COUNTY", "NJ",
           "CALL Priority:SKIP ADDR! Venue:CITY! CrossStreet:ADDR2 LocatedBetween:X PLACE CallTime:SKIP ID PHONE Caller:NAME Compaintant:SKIP NatureOfCall:INFO AdditionalInfo:INFO");
  }
  
  @Override
  public String getFilter() {
    return "7770";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    body = body.substring(match.end()).trim();
    
    // See if we have all of it
    int pt = body.indexOf("Additional Inc#s");
    if (pt >= 0) {
      body = body.substring(0,pt);
    } else {
      data.expectMore = true;
    }
    
    body = body.replace("Cross Street . :", "CrossStreet:");
    body = body.replace("Located Between  :", "LocatedBetween:");
    body = body.replace("Call Time-", "CallTime:");
    body = body.replace("Caller :", "Caller:");
    body = body.replace("Nature of Call :", "NatureOfCall:");
    body = body.replace("Additional Info", "AdditionalInfo:");
    return parseFields(splitMsg(body), data);
  }
  
  private static final Pattern DELIM = Pattern.compile("[^ ]*: ");
  private String[] splitMsg(String body) {
    List<String> list = new ArrayList<String>();
    Matcher match = DELIM.matcher(body);
    int pt = 0;
    String key = "";
    while (match.find()) {
      list.add((key + body.substring(pt,match.start())).trim());
      pt = match.end();
      key = match.group();
      if (key.length() == 2) key = "";
      if (key.equals("AdditionalInfo: ")) break;
    }
    String tail = key + body.substring(pt);
    if (tail.length() > 0) list.add(tail);
    return list.toArray(new String[list.size()]);
  }
  
  private class Address2Field extends Field {
    @Override
    public void parse(String field, Data data) {
      data.strAddress = append(data.strAddress, " & ", field);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR2")) return new Address2Field();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
