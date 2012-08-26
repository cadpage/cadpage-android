package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Camden County, NJ
Contact: "N.dalonzo" <nfdfire45@comcast.net>
Sender: cccademail@camdencounty.com 

(Dispatch SD45) DWELLING\n312 9TH ST ,14\n#:\nX:CENTER/CHERRY\nZN:14A\nCP:  2011-03-31 10:44:12\nMI#:110073123\nRES#:SD45
(Dispatch SD45) M.V.A\nROUTE 295 SB RAMP TO 76 SB ALJO CUR ,04\n#:\nX:/\nZN:04Q\nCP:ROUTE 295 SB RAMP T  2011-03-31 09:06:36\nMI#:110073062 
(Dispatch SD45) DIABETIC\n217 BLACK HORSE PK N ,25\n#:4\nX:CARLISLE/LAKEVIEW\nZN:25B\nCP:MAX GROUP PHILLY CO  2011-03-30 13:23:26\nMI#:11007
(Dispatch SD45) DWELLING\nBURLINGTON ST S/MONMOUTH ST ,14\n#:\nX:/\nZN:14A\nCP:  2011-03-30 10:33:28\nMI#:110072287\nRES#:SD45

Contact: Steve Kane <captsteevo@gmail.com>
(Dispatch QT60) APARTMENT  \n1800 LAUREL RD ,22   \n#:114  \nX:BLACKWOOD CLEMENTON/  \nZN:22B  \nCP:STONINGTON COURT AP  2012-03-09 07:24:49  \nMI#:

Contact: "Guy Dietrich Jr." <dvipergtsrgt@gmail.com>
Subject:Dispatch SD11\nINCIDENTAL  \r\n260 AUDUBON AV ,01   \r\n#:  \r\nX:BELOIT/WYOMING  \r\nZN:01A  \r\nCP:  2012-03-25 07:29:59  \r\nMI#:1200\r

Contact: support@active911.com
Subject: Dispatch E331\nBRUSH  \n501 BENIGNO BD ,04   \n#:  \nX:HAIG/LEAF  \nZN:04B  \nCP:POST OFFICE ADMIN B  2012-05-19 18:32:49  \nMI#:120118554  \nRES#:E331
Subject: Dispatch SD379\nINCIDENTAL  \n217 RUSSELL AV ,03 03;HOUSE NEXT DO  \n#:  \nX:MOORE/RICHARDS  \nZN:03D  \nCP:  2012-05-18 23:01:45  \nMI#:120117862  \nRES#:SD379
Subject: Dispatch SD379\nM.V.A  \nROUTE 295 EXIT 28 ,18   \n#:  \nX:/  \nZN:03W  \nCP:ROUTE 295 EXIT 28  2012-05-19 02:38:47  \nMI#:120118005  \nRES#:SD379
Subject: Dispatch R32\nAPARTMENT  \n1306 HANCOCK DR ,03   \n#:5  \nX:CLEMENTS BRIDGE RD/  \nZN:03D  \nCP:WILLOWS APTS  2012-05-20 07:08:50  \nMI#:120118985  \nRES#:R32
Subject: Dispatch R32\nRESCUE  \nROUTE 42 EXIT 14 ,04   \n#:  \nX:/  \nZN:BMA  \nCP:ROUTE 42 EXIT 14  2012-05-19 16:47:48  \nMI#:120118461  \nRES#:R32

[Free SD379] ROUTE 295 EXIT 28 ,18 18  \nMI#:120118005  \nDisp:02:38:48  \nEnr:  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:02:39:15  \nRES#:SD379  \n
[Free SD32] 294 ROUTE 295 ,04 04  \nMI#:120118005  \nDisp:02:39:15  \nEnr:02:41:47  \nArr:02:47:43  \nEnr Hosp:  \nArr Hosp:  \nClr:02:59:23  \nRES#:SD32  \n
[Free R32] ROUTE 295 EXIT 26 ,04 04  \nMI#:120140280  \nDisp:18:32:56  \nEnr:18:33:27  \nArr:18:35:41  \nEnr Hosp:  \nArr Hosp:  \nClr:18:51:43  \nRES#:R32  \n

Contact: Active911
[Free SD63] MAPLE AV E/WALNUT AV ,22 22  \r\nMI#:120188119  \r\nDisp:18:55:46  \r\nEnr:18:58:16  \r\nArr:18:59:24  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:19:08:14  \r\nRES#:SD63  \r\n\n
[Dispatch SD63] WIRES/BURNING  \r\nLOWELL AV S/CHESTNUT AV ,22   \r\n#:  \r\nX:/  \r\nZN:22A  \r\nCP:  2012-08-05 21:25:36  \r\nMI#:120188244  \r\nRES#:SD63\r\n\n
[Dispatch F6302] WIRES  \r\nLOWELL AV S/CHESTNUT AV ,22   \r\n#:  \r\nX:/  \r\nZN:22A  \r\nCP:  2012-08-05 21:25:36  \r\nMI#:120188244  \r\nRES#:F6302\r\n\n
[Free SD63] LOWELL AV S/CHESTNUT AV ,22 22  \r\nMI#:120188244  \r\nDisp:21:25:36  \r\nEnr:21:33:08  \r\nArr:21:34:52  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:22:12:54  \r\nRES#:SD63  \r\n\n
[Free F6302] LOWELL AV S/CHESTNUT AV ,22 22  \r\nMI#:120188244  \r\nDisp:21:28:53  \r\nEnr:21:28:54  \r\nArr:21:33:33  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:22:12:55  \r\nRES#:F6302  \r\n\n
[Dispatch TF632] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:TF632\r\n\n
[Dispatch S632] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:S632\r\n\n
[Dispatch L63] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:L63\r\n\n
[Dispatch SD63] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:SD63\r\n\n
[Dispatch SQ63] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:SQ63\r\n\n
[Dispatch E63] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:E63\r\n\n
[Free SQ63] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:17:38  \r\nEnr:04:17:40  \r\nArr:  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:04:19:52  \r\nRES#:SQ63  \r\n\n
[Free E63] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:18:09  \r\nEnr:04:18:10  \r\nArr:  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:04:19:52  \r\nRES#:E63  \r\n\n
[Free SD63] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:15:28  \r\nEnr:04:15:29  \r\nArr:  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:04:19:52  \r\nRES#:SD63  \r\n\n
[Free L63] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:13:02  \r\nEnr:04:13:03  \r\nArr:  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:04:19:52  \r\nRES#:L63  \r\n\n
[Free S632] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:06:53  \r\nEnr:  \r\nArr:  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:  \r\nRES#:S632  \r\n\n
[Dispatch L63] APARTMENT  \r\n800 CHEWS LANDING RD ,22   \r\n#:2E  \r\nX:LAUREL/BORO LINE  \r\nZN:22B  \r\nCP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\nMI#:120189349  \r\nRES#:L63\r\n\n
[Free TF632] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:06:53  \r\nEnr:  \r\nArr:04:17:52  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:05:06:23  \r\nRES#:TF632  \r\n\n
[Free L63] 800 CHEWS LANDING RD ,22 22  \r\nMI#:120189349  \r\nDisp:04:13:02  \r\nEnr:04:13:03  \r\nArr:04:45:24  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:05:06:25  \r\nRES#:L63  \r\n\n
[Dispatch SQ63] ALARM SYSTEM  \r\n900 GIBBSBORO RD ,22   \r\n#:  \r\nX:WILSON/HILLIARDS  \r\nZN:22A  \r\nCP:LINDENWOLD SCHOOL 4  2012-08-08 07:37:16  \r\nMI#:120190307  \r\nRES#:SQ63\r\n\n
[Dispatch L63] ALARM SYSTEM  \r\n900 GIBBSBORO RD ,22   \r\n#:  \r\nX:WILSON/HILLIARDS  \r\nZN:22A  \r\nCP:LINDENWOLD SCHOOL 4  2012-08-08 07:37:16  \r\nMI#:120190307  \r\nRES#:L63\r\n\n
[Dispatch F6301] ALARM SYSTEM  \r\n900 GIBBSBORO RD ,22   \r\n#:  \r\nX:WILSON/HILLIARDS  \r\nZN:22A  \r\nCP:LINDENWOLD SCHOOL 4  2012-08-08 07:37:16  \r\nMI#:120190307  \r\nRES#:F6301\r\n\n
[Free SQ63] 900 GIBBSBORO RD ,22 22  \r\nMI#:120190307  \r\nDisp:07:37:16  \r\nEnr:  \r\nArr:  \r\nEnr Hosp:  \r\nArr Hosp:  \r\nClr:07:51:45  \r\nRES#:SQ63  \r\n\n

Contact: Active911
Agency name: Glendora Fire Company Location: Glandora, NJ
Sender:  messaging@iamresponding.com
(Sta 81) DWELLING  \n\n202 OTTERBRANCH AV ,23   \n\n#:  \n\nX:JACKSON/LINCOLN  \n\n :23A  \n\nCP:  2012-08-21 21:13:26  \n\n U81
(Sta 81) DWELLING  \n\n1205 ABERDEEN LN ,15   \n\n#:  \n\nX:WIMBELTON/  \n\n :15F  \n\nCP:  2012-08-22 00:15:27  \n\n SQ81
(Sta 81) INCIDENTAL  \n\n7 MUIRFIELD CT ,15   \n\n#:  \n\nX:DORAL DR/  \n\n :15F  \n\nCP:  2012-08-24 09:43:36  \n\n SD81
(Sta 81) DWELLING  \n\n1305 ST MARK DR ,15   \n\n#:  \n\nX:SAN JOSE/EVESHAM  \n\n   \n\nCP:  2012-08-25 20:24:48  \n\n TF81

*/

public class NJCamdenCountyAParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Dispatch (.*)"); 
  private static final Pattern SUBJECT2_PTN = Pattern.compile("Free (.*)");
  private static final Pattern SUBJECT3_PTN = Pattern.compile("Sta +(.+)");
  private static final Pattern REPORT_ID_PTN = Pattern.compile("\nMI#:(\\d+) *\n");
  private static final Pattern SINGLE_LINE_BRK = Pattern.compile("(?<!\n)\n(?!\n)");
  
  public NJCamdenCountyAParser() {
    super("CAMDEN COUNTY", "NJ",
           "CALL ADDR/SXP! #:APT X:X! ZN:MAP? CP:PLACE UNIT MI:ID RES:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "cccademail@camdencounty.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) {
      data.strUnit = match.group(1).trim();
    } else {
      match = SUBJECT3_PTN.matcher(subject);
      if (match.matches()) {
        data.strSource = subject.trim();
      } else {
        match = SUBJECT2_PTN.matcher(subject);
        if (!match.matches()) return false;
        data.strCall = "RUN REPORT";
        data.strPlace = body;
        data.strUnit = match.group(1);
        match = REPORT_ID_PTN.matcher(body);
        if (match.find()) data.strCallId = match.group(1);
        return true;
      }
    }
    
    // Search and destroy code messaging double line breaks
    match = SINGLE_LINE_BRK.matcher(body);
    if (!match.find()) body = body.replace("\n\n", "\n");
    
    body = body.replace("MI#:", "MI:").replace("RES#:", "RES:");
    return parseFields(body.split("\n"), data) && data.strAddress.length() > 0;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final Pattern CITY_PTN = Pattern.compile(",(\\d\\d)(?: \\d\\d)?$");
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(';');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      Matcher match = CITY_PTN.matcher(field);
      if (match.find()) {
        Integer ndx = Integer.parseInt(match.group(1));
        if (ndx > 0 && ndx <= CITY_LIST.length) {
          data.strCity = CITY_LIST[ndx-1]; 
        }
        field = field.substring(0,match.start()).trim();
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY"; 
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d{4})-(\\d\\d)-(\\d\\d) (\\d\\d:\\d\\d:\\d\\d)$");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        data.strDate = match.group(2) + "/" + match.group(3) + "/" + match.group(1);
        data.strTime = match.group(4);
        field = field.substring(0,match.start()).trim(); 
      }
      data.strPlace = append(data.strPlace, " ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE DATE TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  // X - remove empty /
  // Place strip off date/time

  private static final String[] CITY_LIST = new String[]{
    /* 01 */ "Audubon",
    /* 02 */ "Audubon Park",
    /* 03 */ "Barrington",
    /* 04 */ "Bellmawr",
    /* 05 */ "Berlin",
    /* 06 */ "Berlin Twp",
    /* 07 */ "Brooklawn",
    /* 08 */ "Camden City",
    /* 09 */ "Chesilhurst",
    /* 10 */ "Clementon",
    /* 11 */ "Collingswood",
    /* 12 */ "Cherry Hill",
    /* 13 */ "Gibbsboro",
    /* 14 */ "Gloucester City",
    /* 15 */ "Gloucester Twp",
    /* 16 */ "Haddon Twp",
    /* 17 */ "Haddonfield",
    /* 18 */ "Haddon Heights",
    /* 19 */ "Hi-Nella",
    /* 20 */ "Laurel Springs",
    /* 21 */ "Lawnside",
    /* 22 */ "Lindenwold",
    /* 23 */ "Magnolia",
    /* 24 */ "Merchantville",
    /* 25 */ "Mount Ephraim",
    /* 26 */ "Oaklyn",
    /* 27 */ "Pennsauken Twp",
    /* 28 */ "Pine Hill",
    /* 29 */ "Pine Valley",
    /* 30 */ "Runnemede",
    /* 31 */ "Somerdale",
    /* 32 */ "Stratford",
    /* 33 */ "Tavistock",
    /* 34 */ "Voorhees Twp",
    /* 35 */ "Waterford Twp",
    /* 36 */ "Winslow Twp",
    /* 37 */ "Woodlyne"
  };

}
