package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Nassau County, NY (Firetracker)
Contact: peter Griebel <griebz217@yahoo.com>
Sender: dispatch@firetracker.net

(FirePage) ** FFD FIRE CALL ** GENERAL PROB WITH GAS STOVE-POSS LEAK 170 JAY ST\nC/S: DEAN (E) ST / MILTON (E) ST TOA: 17:02 [FireTracker]
(FirePage) ** FFD FIRE CALL ** DISTRIC DIST CALL FOR SMOKE IN THE AREA CHURCH ST\nC/S: ARCHER ST TOA: 19:12 [FireTracker]
(FirePage) ** FFD FIRE CALL ** GENERAL APT 72 / 3RD FLOOR / SMOKE 100 N MAIN ST\nC/S: RANDALL AVE / GRAND AVE TOA: 18:50 [FireTracker]
(FirePage) ** FFD FIRE CALL ** STILL WILLOWBROOK LA C/S: BROOKSIDE (N) AVE TOA:\n09:16 [FireTracker]
(FirePage) ** FFD FIRE CALL ** GENERAL ELEC PROBLEM/APT 415 45 WALLACE ST C/S:\nBROOKLYN AVE / RANDALL AVE TOA: 18:26 [FireTracker]
(FirePage) ** FFD FIRE CALL ** CARBON APT 33 116 WEST END AVE C/S: RAY ST / ELINOR\nPL TOA: 11:23 [FireTracker]
(FirePage) ** FFD FIRE CALL ** GENERAL 22 PEARSALL AVE C/S: LONG BEACH (N) AVE /\nPENNSYLVANIA AVE TOA: 15:56 [FireTracker]

Contact: Nick Stein <snickphotos@gmail.com>
Sender: +15163018638
FirePage / ** FFD SIGNAL 9 ** SIG 9 MALE VOMITTING 21 NORTON ST C/S: GUY LOMBARDO\nAVE / HUDSON AVE TOA: 18:42 [FireTracker]\n
** FFD FIRE CALL ** CARBON AUTOMATIC/NO PERMIT 109 MARYLAND AVE C/S: SEAMAN (W) AVE / CALIFORNIA AVE TOA: 20:55 [FireTracker]

Contact: Louis Sabatino <lousab1@optonline.net>
Contact: Mike Torregrossa <torr393@gmail.com>
Sender: dispatch@firetracker.net
(FirePage) *FSMFD* 4/22/2011 TOA:20:47 AMBU [AMBU] 178 RINTIN ST BENRIS AVE ARM\nINJURY [FireTracker]
(FirePage) *FSMFD* 4/27/2011 TOA:21:12 AMBU [AMBU] 820 FRANKLIN PL GARDEN CITY ROAD\nDIZZY FEMALE VOMITING [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:14:59 AMBU [AMBU] 1150 HEMPSTEAD TPK RENKEN BLVD\nIN THE SICK BAY SICK FEMALE [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:19:45 AMBU [AMBU] 947 MAPLE DR COURT HOUSE ROAD\nMALE,SHORT OF BREATH [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE\nFEMALE FELL,WRIST INJURY [FireTracker]
[FirePage]  *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE FEMALE FELL,WRIST INJURY [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:23:14 CARB 1 [CARB] 551 CHESMAN ST NASSAU BLVD NO\nAIDED [FireTracker]
(FirePage) *FSMFD* 4/29/2011 TOA:19:21 AMBU [AMBU] 775 CORNELL ROAD ETON ROAD MALE\nFELL-HIP INJURY [FireTracker]
(FirePage) *FSMFD* 4/29/2011 TOA:21:59 MUTUAID [MAF] 125 MEACHAM AVE POST AVE\n[FireTracker]
(FirePage) FSMFD 5/2/2011 TOA:17:36 AMBU [AMBU] 766 WILLOW ROAD BIRCH ST BROKEN\nHIP [FireTracker]

Contact: J N <shadymailman@gmail.com>,Jason Ng <jasonkwng@gmail.com>
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [HOUSE] 7 ARMS AVE C/S: CAMP AVE / GARFIELD (E) ST -\nM/A 64 UPSTAIRS\n(Con' 2 of 2\nTOA:01:57 6/20/2011 Town Of: MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 119 RHODE AVE C/S: HENRY ROAD / WILLIAM ST - M/A\n65 PAIN IN LEFT\n(Con' 2 of 2\nSIDE TOA:09:46 6/21/2011 Town Of: NO MERRICK\n[FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 4 WILLIAM ST C/S: BRIARCLIFF DR / RICHARD AVE -\nM/A 65 93F\n(Con't) 2 of 2\nCARDIAC/CARDIAC HISTORY TOA:14:02 6/21/2011 Town Of: NO\nMERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [CARB] 185 E LOINES AV C/S: GRACE AVE / -DEAD END--\nM/A 64 TOA:12:20\n(Con 2 of 2\n6/22/2011 Town Of: MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 28 SURREY DR C/S: BAKER AVE / CROYDON DR - M/A 65\nFM FAINTING\n(Con't) 2 of 2\nTOA:16:41 6/23/2011 Town Of: NO MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] MERRICK AVE C/S: JERUSALEM AVE - M/A 65 FEMALE\nLYING IN ROADWAY\n(Con't 2 of 2\nTOA:16:52 6/23/2011 Town Of: NO MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [MVA] [MVA] PARK AVE C/S: CAMERON AVE - M/A 65 AIDED WITH CHEST\nPAINS TOA:23:00\n(Con 2 of 2\n6/23/2011 Town Of: NO MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 1817 WILLIS AVE [ALARM PENDING] C/S: STATE ST /\nSCHERMERHORN ST -\n(C 2 of 2\nM/A 64 PERSON CHOKING TOA:12:22 6/25/2011 Town Of:\nMERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 1766 MERRICK AVE [DUNKIN DONUTS] C/S: WEBSTER ST\n/ GARFIELD ST -\n(Co 2 of 2\nM/A 64 ASSAULT VICTIM / R/O TOA:15:51 6/25/2011 Town Of:\nNO MERRICK [FireTracker](End)
FRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [MVA] [MVA] WEBSTER ST C/S: MERRICK AVE - M/A 64 TOA:11:56\n6/28/2011 Town Of: MERRICK [FireTracker

Contact: FRED DAVIS <fred.davis337@gmail.com>, "derf337@aol.com" <derf337@aol.com>
Sender: dispatch@firetracker.net
(FirePage) **WPFD** [CARBON] (CARB) [UPSTAIRS BEDROOM-NO AIDED] 141 COLLINS AVE\nWILLISTON PARK C/S:LAFAYETTE ST / CENTER ST TOA:18:12 4/4/2012\n[

Contact: Tracy Bowdwin <bowdwin32@gmail.com>
Sender: dispatch@firetracker.net
(FirePage) **RFD** CHIEF 2 [INVE] ALARM SOUNDING 68 DEBEVOISE AVE C/S:GILBERT PL /\r\nCHARLES ST TOA:02:26 [FireTracker]
(FirePage) **RFD** AUTOACC [MVA] E/B E/O 21 SOUTHERN STATE PKWY E/B C/S:NASSAU ROAD\r\n/ EXIT 21 TOA:10:37 [FireTracker]

*/
public class NYNassauCountyFiretrackerParser extends FieldProgramParser {
  
  private static final Pattern FFD_MARKER = Pattern.compile("^\\*\\* FFD [^\\*]+ \\*\\* ");
  private static final Pattern FD_MARKER = Pattern.compile("^\\*{0,2}([A-Z]{1,3}FD)\\*{0,2} +");
  
  public NYNassauCountyFiretrackerParser() {
    super("NASSAU COUNTY", "NY", 
           "ADDR/SCP! C/S:X TOA:TIME Town_Of:CITY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@firetracker.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (body.startsWith("FirePage / ")) body = body.substring(11).trim();
    
    int pt = body.lastIndexOf('[');
    if (pt < 0) return false;
    if (! "[FireTracker]".startsWith(body.substring(pt))) return false;
    body = body.substring(0,pt).trim();
    
    if (body.startsWith("*FSMFD* ") || body.startsWith("FSMFD")) {
      data.strSource = "FSMFD";
      Parser p = new Parser(body);
      p.get(' ');
      data.strDate = p.get("TOA:");
      data.strTime = p.get(" ");
      data.strCall = p.get('[');
      p.get(']');
      body = p.get();
      if (body.length() == 0) return false;
      body = body.replace('\n', ' ');
      parseAddress(StartType.START_ADDR, body, data);
      body = getLeft();
      Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
      if (res.getStatus() > 0) {
        res.getData(data);
        body = res.getLeft();
      }
      data.strSupp = body;
      return true;
      
    }

    do {
      Matcher match;
      if ((match = FFD_MARKER.matcher(body)).find()) {
        data.strSource = "FFD";
        body = body.substring(match.end()).trim();
        break;
      }
      if ((match = FD_MARKER.matcher(body)).find()) {
        data.strSource = match.group(1);
        body = body.substring(match.end()).trim();
        break;
      }
      return false;
    } while (false);
    
    body = body.replace('\n', ' ');

    return super.parseMsg(body, data);
  }
  
  private static final Pattern APT_PTN = Pattern.compile("\\bAPT ([^ ]+)\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (match.find()) {
        data.strApt = match.group(1);
        field = field.substring(0,match.start()) + field.substring(match.end());
      }
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strSupp = p.getLastOptional(" - ");
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "X INFO";
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strTime = p.get(' ');
      data.strDate = p.get();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
