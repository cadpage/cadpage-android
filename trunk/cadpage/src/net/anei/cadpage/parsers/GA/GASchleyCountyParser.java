package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Schley county, GA

Central dispatch for Dooly, Schley, Sumter, Macon, Marion, Webster, Taylor, Talbot counties

Vienna FD, Dooley County
Contact: John Sherrer <jwsherrer@gmail.com>
Sender: mfrdispatch@glen-usa.org

VFD Type:WEATHER SUBTYPE:? LOC:TORNADO WATCH UNTIL 2 AM C:11/22/2011 18:25:41 VFDE1 : DSPTCH & primary unit.
VFD Type:50I SUBTYPE:? LOC:HWY 41 & MT PLEASANT CHURCH RD C:11/23/2011 13:01:24 18 WHEELER VS ANOTHER VEH 11/23/2011 13:01:26 DCEM1 : DSPTCH & primary uni
VFD Type:SMOKE SUBTYPE:? LOC:513 CLOVER ST C:11/24/2011 03:31:23 513 CLOVER ST: cross streets: W WOODWARD ST & PECAN ST 11/24/2011 03:32:59 10-85 CALLED T
VFD Type:70 SUBTYPE:? LOC:N 5TH ST & E PINE ST C:11/25/2011 05:09:23 10-85 CALLED T REPORT A HOUSE ON FIRE ON N 5TH ST NEAR PINE ST
VFD Type:MEETING SUBTYPE:? LOC:DRILL TONIGHT @1900 HRS AT THE STATION. ALL MEMBERS ARE ASKED TO ATTEND C:
VFD Type:90F SUBTYPE:? LOC:208 CHURCH ST C:12/6/2011 10:58:06 208 CHURCH ST: cross streets:       N 5TH ST & N 4TH ST 12/6/2011 10:59:18 VFDE2 : DSPTCH & primar
VFD Type:CANCELCALL SUBTYPE:? LOC:208 CHURCH ST C:12/6/2011 10:58:06 208 CHURCH ST: cross streets: N 5TH ST & N 4TH ST 12/6/2011 10:59:18 VFDE2 : DSPTCH &
VFD Type:90F SUBTYPE:? LOC:3113 HWY 90 C:12/6/2011 19:07:08 OPT 29 JOHNSON ELEC 12/6/2011 19:07:11 3113 HWY 90: cross streets: SLOSHEYE TRAIL RD 12/6/2011
VFD Type:CANCELCALL SUBTYPE:? LOC:3113 HWY 90 C:12/6/2011 19:07:08 OPT 29 JOHNSON ELEC 12/6/2011 19:07:11 3113 HWY 90: cross streets: SLOSHEYE TRAIL RD 12/
VFD Type:70 SUBTYPE:? LOC:514 FOUNDRY ST C:12/7/2011 19:27:29 514 FOUNDRY ST: cross streets: W WOODWARD ST & PECAN ST 12/7/2011 19:27:50 ADV SMOKE IS COMI
VFD Type:90M SUBTYPE:? LOC:21490 HWY 27 C:12/13/2011 20:59:47 21490 HWY 27: cross streets: RIVER RD & OTTO RD 12/13/2011 21:01:13 56 YOA FEMALE HAS PRESSE
VFD Type:70 LRG VEHICLE SUBTYPE:? LOC:TIPPETTVILLE RD & COPPEDGE RD C:12/14/2011 13:24:04 ADV THAT ONE OF THE TRACTORS ARE ON FIRE 12/14/2011 13:24:23 ADV
VFD Type:70 DUMPSTER SUBTYPE:? LOC:PECAN ST & CLOVER ST C:12/15/2011 18:14:10 FIRE IN TRASH CAN BY A HOUSE ON PECAN JUST OFF OF CLOVER ST 12/15/2011 18:14:
VFD Type:CANCELCALL SUBTYPE:? LOC:PECAN ST & CLOVER ST C:12/15/2011 18:14:10 FIRE IN TRASH CAN BY A HOUSE ON PECAN JUST OFF OF CLOVER ST 12/15/2011 18:14:4
VFD Type:WIRES SUBTYPE:? LOC:S 5TH ST & E UNION ST C:12/16/2011 07:46:24 ADV THE POWER LINES ARE SPARKING FIRE AT THIS LOCATION 12/16/2011 07:46:51 VFDE2
VFD Type:50I SUBTYPE:? LOC:109 I 75 N [@I75N EXIT 109[ : C:12/17/2011 19:48:39 VPD6 : Field Incident 12/17/2011 19:48:39 VPD6 : DSPTCH & primary unit. 12/1
VFD Type:70W SUBTYPE:? LOC:107 I 75 N [@I75N MM 107 C:12/18/2011 12:53:33 VFDE2 : DSPTCH & primary unit.
VFD Type:CANCELCALL SUBTYPE:? LOC:107 I 75 N [@I75N MM 107 C:12/18/2011 12:53:33 VFDE2 : DSPTCH & primary unit. 12/18/2011 12:53:53 ADV FIELD ON FIRE AT TH

[Times - VFD]  VFD LOC:21490 HWY 27 Phone:229-268-8082 Type:CANCELCALL SUBTYPE:? CREATED:21:4:22 C:12/13/2011 20:59:47 21490 HWY 27: cross streets: RIVER R
[Times - VFD]  VFD LOC:PECAN ST & CLOVER ST Phone:(478) 867-3805 Type:CANCELCALL SUBTYPE:? CREATED:18:24:44 C:12/15/2011 18:14:10 FIRE IN TRASH CAN BY A HOU
[Times - VFD]  VFD LOC:107 I 75 N [@I75N MM 107 Phone: Type:CANCELCALL SUBTYPE:? CREATED:13:2:14 C:12/18/2011 12:53:33 VFDE2 : DSPTCH & primary unit. 12/18/

*/
public class GASchleyCountyParser extends FieldProgramParser {
  
  public GASchleyCountyParser() {
    this("SCHLEY COUNTY");
  }
  
  public GASchleyCountyParser(String defCounty) {
    super(defCounty, "GA",
           "Type:CALL! SUBTYPE:CALL2! LOC:ADDR! C:EXTRA!");
  }
  
  @Override
  public String getFilter() {
    return "mfrdispatch@glen-usa.org";
  }
  
  @Override
  public String getAliasCode() {
    return "GASchleyCounty";
  }
  
  // Subtype field is appended to call description, unless it is a ?
  private class MyCall2Field extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("?")) return;
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  // Address field may have appended place name
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get("[@"), data);
      data.strPlace = p.get('[');
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  // The C: field is a conglomeration of all kinds of things
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d{1,2}/\\d{1,2}/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d)");
  private static final Pattern DATE_TIME_TRAIL = Pattern.compile("\\b\\d{1,2}/[0-9/]+(?: +[0-9:]+)?$");
  private static final Pattern UNIT_PTN = Pattern.compile("\\b([A-Z][A-Z0-9]+) : ");
  private static final String CROSS_STREET_KEY = "cross streets:";
  private class MyExtraField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      
      // Break the field down by date/time separators, the first of which
      // be stored as the dispatch date/time
      Matcher match = DATE_TIME_PTN.matcher(field);
      int pt = 0;
      while (match.find()) {
        if (data.strDate.length() == 0) {
          data.strDate = match.group(1);
          data.strTime = match.group(2);
        }
        parseBlock(field.substring(pt, match.start()), data);
        pt = match.end();
      }
      
      // Strip out remains a partial date/time before processing what is left
      String left = field.substring(pt);
      match = DATE_TIME_TRAIL.matcher(left);
      if (match.find()) left = left.substring(0,match.start()).trim();
      parseBlock(left, data);
    }
    
    private void parseBlock(String block, Data data) {
      
      // If nothing here, skip it
      block = block.trim();
      if (block.length() == 0) return;
      
      // Look for a Unit
      Matcher match = UNIT_PTN.matcher(block);
      if (match.find()) {
        String left = block.substring(match.end());
        if (left.startsWith("DSPTCH") || "DSPTCH".startsWith(left)) {
          data.strUnit = append(data.strUnit, ",", match.group(1));
          block = block.substring(0,match.start()).trim();
        }
      }
      
      // Look for a cross street designator
      int pt = block.indexOf(CROSS_STREET_KEY);
      if (pt >= 0) {
        String sCross = block.substring(pt+CROSS_STREET_KEY.length()).trim();
        if (sCross.endsWith("/")) sCross = sCross.substring(0,sCross.length()-1).trim();
        data.strCross = append(data.strCross, " & ", sCross);
        block = block.substring(0,pt).trim();
      }
      
      // If we didn't find one, look for a partial cross street designator
      else {
        pt = block.lastIndexOf(' ');
        if (pt >= 0) {
          String left = block.substring(pt+1);
          if (CROSS_STREET_KEY.startsWith(left)) {
            block = block.substring(0,pt).trim();
          }
          else if (pt >= 6) {
            pt -= 6;
            left = block.substring(pt);
            if (CROSS_STREET_KEY.startsWith(left)) {
              block = block.substring(0,pt).trim();
            }
          }
        }
      }
      
      // If copy of address, skip it
      if (data.strAddress.startsWith(block)) return;
      if (block.startsWith(data.strAddress)) block = block.substring(data.strAddress.length()).trim();
      
      // Strip off leading colon
      if (block.startsWith(":")) block = block.substring(1).trim();
      
      // append whatever is left to the info
      data.strSupp = append(data.strSupp, " / ", block);
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME X UNIT INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL2")) return new MyCall2Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }
}
