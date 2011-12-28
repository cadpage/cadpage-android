package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Nassau County, NY (version D)
Contact: Besnik Gjonlekaj <tigerfdny@gmail.com>
System: Fire Rescue Systems (old version)
Sender: paging@bethpagefd.xohost.com

*** 30) RESCUE-SIGNAL 9 *** 21 BELMONT AVE CS: DAVID CT TOA: 18:39 03-29-11
*** 45) BRUSH *** 1 MILLER RD CS: HEMPSTEAD TPKE TOA: 14:48 03-29-11
*** 11) AFA -HOUSE *** 21 CLARK ST CS: EILEEN AVE TOA: 08:09 03-29-11
*** 75) CARBON MONOXIDE ALARM *** 91 SUNBEAM AVE CS: SUNNY LN TOA: 04:08 03-26-11
*** 13) SMOKE INVESTIGATION *** 56 APOLLO CIR CS: HICKEY BLVD TOA: 22:16 03-26-11
*** 82) MUTUAL AID *** 930 HICKSVILLE FD TO STANDBY CS: CAROLINE ST TOA: 10:10 03-26-11
*** 20) BUILDING FIRE *** 4105 HEMPSTEAD TPKE CS: HICKSVILLE RD TOA: 20:48 03-21-11
*** 61) TRUCK FIRE *** HICKSVILLE RD CS: MARTIN RD N TOA: 19:35 03-21-11
*** 10) HOUSE FIRE *** 22 CRESTLINE AVE CS: HILLTOP AVE TOA: 15:41 03-21-11
*** 10) HOUSE FIRE *** 212 GILLING RD CS: WHELAN PL TOA: 14:33 03-20-11

Contact: jim baudille jr <ncdisp33@gmail.com>
FRM:paging@bethpagefd.xohost.com\nMSG:\n2011-000418 *** 21)  AFA BUILDING *** BETHPAGE HIGH SCHOOL 800 STEWART AVE CS: SYCAMORE AVE TOA: 12:03 04-02-11 STATION 4
1 of 2\nFRM:paging@bethpagefd.xohost.com\nMSG:\n2011-000530 *** 30) RESCUE-SIGNAL 9 *** MR ANTHONY MORACE 141 HERMANN AVE N CS: SOPHIA ST TOA:\n(Con't) 2 of 2\n09:52 04-22-11 HEADQUARTERS(End)

Contact:"sal234@nmfd-660.com" <sal234@nmfd-660.com>
Sender: nmfd660@verizon.net
*** 30 - RESCUE *** CIARDI 41 AMHERST DR CS: N WISCONSIN AVE  / HARRIET PL C-6 TOA: 18:23 05/12/11 2011-000368 3/18/30/38/52 Amherst Drive

Contact: jmreeves@gmail.com
*** 330 RESCUE - STROKE *** XYZ RESIDENCE 460 PIPING ROCK RD CS: RUSSET RD  - WELLWOOD RD N-4 TOA: 09:28 05-23-11 STATION 2 STATION 4 STATION 3 2011-000877
*** 400 AUTO ACCIDENT *** WATCHTOWER LN & N JERUSALEM RD  WATCHTOWER LN CS: N JERUSALEM RD F-7 TOA: 08:53 05-23-11 STATION 2 STATION 4 STATION 1 2011-000876
*** 630 INVESTIGATION-SMOKE EXT *** XYZ RESIDENCE 39 EDEN LN CS: ELM DR W  - ELM DR E K-3 TOA: 17:11 05-22-11 STATION 2 STATION 4 2011-000873
*** 210 MAJOR-BLDG FIRE AUTO ALM *** UMBERTO'S PIZZA 1180 WANTAGH AVE CS: DUCKPOND DR  - JERUSALEM AVE H-11 TOA: 06:34 05-22-11 STATION 2 STATION 4 2011-000868

Contact: Jared Reeves <jreeves@liag.net>
Sender: paging@wantaghfd.xohost.com
*** 640 INVESTIGATION-WIRES-LIPA *** LEVITTOWN SCHOOL MAINT. BLDG 850 SEAMANS NECK RD CS: HUNT RD  - DUNHILL RD M-6 TOA: 07:41 08-15-11 STATION 2 STATIO

*/

public class NYNassauCountyDParser extends FieldProgramParser {
  
  private static final Pattern ID_PTN = Pattern.compile("^(\\d{4}-\\d{6}) ");
  private static final Pattern ID_PTN2 = Pattern.compile("\\b(\\d{4}-\\d{6})\\b");
  
  public NYNassauCountyDParser() {
    super("NASSAU COUNTY", "NY",
           "ADDR/SP! CS:X! TOA:SPEC");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(match.end()).trim();
    }
    
    // Call description is in front of text bracketed by three asterisks
    if (!body.startsWith("***")) return false;
    int pt1 = 3;
    int pt2 = body.indexOf("*** ", pt1);
    if (pt2 < 0) return false;
    data.strCall = body.substring(pt1, pt2).trim();
    
    body = body.substring(pt2+4).trim();
    return super.parseMsg(body, data);
  }
  
  private class SpecField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.length() < 14) return;
      field = field.substring(14).trim();
      
      Matcher match = ID_PTN2.matcher(field);
      if (match.find()) {
        data.strCallId = match.group(1);
        field = field.substring(0,match.start()) + field.substring(match.end());
        field = field.trim().replaceAll("  +", " ");
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SPEC")) return new SpecField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID CALL " + super.getProgram();
  }
}


