package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Delaware County, PA (Variant C)
Contact: Mike Bierman <mtb2580@yahoo.com>
Sender: norwoodfireco@rcn.com

1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:[Update]\nF11032765\n06/09/2011\n04:13\nASSIST\nFD TO ASSIST EMS\n17 ELMWOOD AV\nS\n(Con't) 2 of 2\nELMWOOD AV\nMCKINLEY AV\n021/M100D/M100/027B\n~80YOM,Set Station Alarm activ\nFD\nFIRE\nANI/(End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031554 \n06/03/2011 \n08:56 \nSTREET \nSTREET CLOSED \nW ASHLAND AV & N MACDADE BLVD \nW\n(Con't) 2 of 2\nASHLAND AV \nN MACDADE BLVD \nM100D/STA02/STA05/STA09/STA01 \nBETWEEN N WELLS AND MACDADE ON(End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031406 \n06/02/2011 \n14:44 \nACC \nWITH INJURY REPORTED \n8TH AV & LINCOLN AV \n8TH\n(Con't) 2 of 2\nAV \nLINCOLN AV \n487/ENG08/027/M102A/RE08/071 \n610-461-1539,SEE THE MAN,STRIK \nFD \nFIRE \nCELL (End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031265 \n06/01/2011 \n20:40 \nFIRE-BLD \nBUILDING FIRE, COMMERCIAL BLDG \n734 CHESTER\n(Con't) 2 of 2\nPKE \nPENNSYLVANIA AV \nNASSAU BLVD \nENG08/021/027/SN08/RE08/076/07 \n-075.305228 +039.883204 (End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031005 \n05/31/2011 \n18:14 \nFIRE-OTH \nFD INVESTIGATION \n241 W WINONA AV \nSYLVAN\n(Con't) 2 of 2\nAV \nTRITES AV \n021 \n-075.303855 +039.894780,~ GRIL \nFD \nFIRE \nANI/ALI \nRACHEL - SAME \nFIRE-OT(End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11029356 \n05/24/2011 \n00:41 \nALARM \nCARBON MONOXIDE ALARM \n711 SOUTH AV \nUNNAMED\n(Con't) 2 of 2\nSTREET \nQUAINT ST \nARID7/027/RID7B/677C/MRID7/LA4 \nò~3¿ \nFD \nFIRE \nANI/ALI \nWARD MARGARET - (End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11027808 \n05/16/2011 \n10:54 \nFIRE-BLD \nBUILDING FIRE, COMMERCIAL BLDG \n701 ASHLAND AV\n(Con't) 2 of 2\n22 \nDELMAR DR \nCARPENTERS CROSSING \nM06/012/017/027A/091/ENG05/TW0 \nMULTIPLE BUSINESSES (End)

Contact: support@active911.com
Sender: dispatch@smtp-auth.no-ip.com
F12029686\n05/27/2012\n18:54\nALARM\nWATERFLOW ALARM\n1800 MILL RD\nBETHEL RD\nCENTRAL AV\nCalltaker - Verify the building (Main, North, or West) where assistance is,requested.,ESZ 405,~MAIN \nPHONE\nTRI M #28\nALARM -\n800-877-3624
F12029450\n05/26/2012\n13:09\nACC\nWITH INJURY/FIRE\nCONCHESTER HWY \nCONCHESTER HWY\nFLORA LN\n~ 1 VEH POSS ENGINE COMPARTMENT ON FIRE,~ INJURIES UNK,ù:ªU9(íU\nANI/ALI\nBULEY,CHERYL - 901 FLORA LN\nACC - ACCIDENT\n610-494-4356
F12029166\n05/25/2012\n01:22\nFIRE-BLD\nBUILDING FIRE, RES/DWELLING\n925 CHESTNUT ST\nW 9TH ST\nW 10TH ST\n~LOUD BANG FROM THE BASEMENT / FILLING WITH SMOKE,Ô>UU«¿\nCELL PHO\nHEWES, SHELBY - SAME\nFIRE-BLD - BUILDING RESPONSE\n610-800-4894
F12029319\n05/25/2012\n18:28\nFIRE-OTH\nFD INVESTIGATION\n4TH AV & OKIOLA\n4TH AV\nOKIOLA AV\n~SMOKE ODOR IN THE AREA,”]\nCELL PHO\nANNA JONES\nFIRE-OTH - OTHER RESPONSE\n610-494-6028
F12029110\n05/24/2012\n18:44\nFIRE-NON\nVEHICLE FIRE\nCONCHESTER HWY \nCONCHESTER HWY\nMARKET ST\n~ON 322 JUST BEFORE 452,UNK WHAT KIND OF VEHICLE,\nCELL PHO\nLOFTIS,ERICA\nFIRE-NON - NON BLDG RESPONSE\n610-812-1574
F12029697\n05/27/2012\n19:32\nFIRE-OTH\nCOVER ASSIGNMENT\n1500 W 3RD ST\nTILGHMAN ST\nLOCKSLEY ST\n610-447-7765,~FIRE CHANNEL 8,Location: 1500 W 3RD ST,2nd 68LA (If fire is in east end) RE39 SQ61,3rd\nPHONE\nFIRE-OTH - OTHER RESPONSE
F12029084\n05/24/2012\n17:10\nALARM\nAUTOMATIC FIRE ALARM\n2403 6TH AV\nOKIOLA AV\nMEETINGHOUSE RD\n~GENERAL,ZERBE RESIDENCE 610-494-5403,KBN,ÁõÏ•+š‚Wÿ\nPHONE\nPROTECT AMERICA OPER 091\nALARM -\n800-443-8865

*/

public class PADelawareCountyCParser extends FieldProgramParser {
  
  public PADelawareCountyCParser() {
    super("DELAWARE COUNTY", "PA",
           "SKIP? ID DATE TIME CALL CALL ADDR! X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "norwoodfireco@rcn.com,dispatch@smtp-auth.no-ip.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!parseFields(body.split("\n"), 6, data)) return false;
    
    // It is not uncommon to report the same info in address and cross street fields :(
    if (data.strCross.equals(data.strAddress)) data.strCross = "";
    
    // Less common, but more annoying, address contains a street name, and cross street
    // contains the intersection with the first street name matching the address.  In which 
    // case the cross street should be used as the address
    if (data.strCross.startsWith(data.strAddress)) {
      data.strAddress = data.strCross;
      data.strCross = "";
    }
    return true;
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private static final Pattern TRASH_PTN = Pattern.compile(",[^\\p{Print}].*$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = TRASH_PTN.matcher(field).replaceAll("");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("F\\d{8}", true);
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d\\d\\d\\d", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
