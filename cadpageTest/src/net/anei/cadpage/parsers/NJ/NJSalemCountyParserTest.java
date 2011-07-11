package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSalemCountyParserTest extends BaseParserTest {
  
  public NJSalemCountyParserTest() {
    setParser(new NJSalemCountyParser(), "SALEM COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "911-CENTER:06N >ALARM SYSTEM-NIGHT 40 EATON RD XS: LINCOLN DR AND S WASHINGTON DR PENNSVILLE TWP TC02 // MONITORING CENT",
        "CALL:ALARM SYSTEM-NIGHT",
        "ADDR:40 EATON RD",
        "X:LINCOLN DR AND S WASHINGTON DR",
        "CITY:PENNSVILLE TWP",
        "NAME:TC02 / / MONITORING CENT");

    doTest("T2",
        "911-CENTER:02 >STRUCTURE FIRE-MEDIUM HAZARD 429 N BROADWAY WAY XS: ROUTE 130 OVERPASS PENNSVILLE TWP KIM MILLER 3511754",
        "CALL:STRUCTURE FIRE-MEDIUM HAZARD",
        "ADDR:429 N BROADWAY WAY",
        "X:ROUTE 130 OVERPASS",
        "CITY:PENNSVILLE TWP",
        "NAME:KIM MILLER",
        "PHONE:3511754");

    doTest("T3",
        "911-CENTER:41 >ALS 25 W PITTSFIELD ST XS: N BROADWAY PENNSVILLE TWP AMERICAN LEGION BROWN MOORE PO 6789801 Map: Grids:00",
        "CALL:ALS",
        "ADDR:25 W PITTSFIELD ST",
        "X:N BROADWAY",
        "CITY:PENNSVILLE TWP",
        "NAME:AMERICAN LEGION BROWN MOORE PO",
        "PHONE:6789801");

    doTest("T4",
        "911-CENTER:40 >BLS 9 HARVARD RD XS: FORT MOTT ROAD PENNSVILLE TWP JIM MCCLAGHLIN 3142134 Map: Grids: 00000 ,000",
        "CALL:BLS",
        "ADDR:9 HARVARD RD",
        "X:FORT MOTT ROAD",
        "CITY:PENNSVILLE TWP",
        "NAME:JIM MCCLAGHLIN",
        "PHONE:3142134");

    doTest("T5",
        "911-CENTER:40 >BLS 108 MADISON ST XS: GARFIELD ST PENNSVILLE TWP MC GRAW ROBIN 2996816 Map: Grids: 00000 ,000",
        "CALL:BLS",
        "ADDR:108 MADISON ST",
        "X:GARFIELD ST",
        "CITY:PENNSVILLE TWP",
        "NAME:MC GRAW ROBIN",
        "PHONE:2996816");

    doTest("T6",
        "911-CENTER:40 >BLS 556 N BROADWAY PENNSVILLE SARA MORIARTY 4078169",
        "CALL:BLS",
        "ADDR:556 N BROADWAY",
        "CITY:PENNSVILLE",
        "NAME:SARA MORIARTY",
        "PHONE:4078169");

    doTest("T7",
        "911-CENTER:01 >STRUCTURE FIRE - LOW HAZARD 21 VAN BUREN ST XS: CANAL ROAD PENNSVILLE TWP JENNIFER PORADOSKY 0383396 Map:",
        "CALL:STRUCTURE FIRE - LOW HAZARD",
        "ADDR:21 VAN BUREN ST",
        "X:CANAL ROAD",
        "CITY:PENNSVILLE TWP",
        "NAME:JENNIFER PORADOSKY",
        "PHONE:0383396");

    doTest("T8",
        "911-CENTER:40 >BLS 90 N BROADWAY WAY XS: CLIFTON PLACE PENNSVILLE TWP 504 6783089 Map: Grids: 00000 ,000",
        "CALL:BLS",
        "ADDR:90 N BROADWAY WAY",
        "X:CLIFTON PLACE",
        "CITY:PENNSVILLE TWP",
        "PHONE:504 6783089");

    doTest("T9",
        "911-CENTER:41 >ALS 29 MARKET ST XS: HOWELL ST SALEM CITY BARBARA CRISPIN 2028606 Map: Grids: 00000 ,000",
        "CALL:ALS",
        "ADDR:29 MARKET ST",
        "X:HOWELL ST",
        "CITY:SALEM CITY",
        "NAME:BARBARA CRISPIN",
        "PHONE:2028606");

    doTest("T10",
        "911-CENTER:40 >BLS 255 N RIVER DR XS: MEADOW ROAD PENNSVILLE TWP CONEY, KENNETH R 6785492 Map: Grids: 00000 ,000",
        "CALL:BLS",
        "ADDR:255 N RIVER DR",
        "X:MEADOW ROAD",
        "CITY:PENNSVILLE TWP",
        "NAME:CONEY, KENNETH R",
        "PHONE:6785492");

    doTest("T11",
        "911-CENTER:40 >BLS 11 KENT AVE Apt: 412 Bldg XS: NORTH BROADWAY PENNSVILLE TWP FRANKLIN ALARM CO OPER 2769 6782600 Map:",
        "CALL:BLS",
        "ADDR:11 KENT AVE",
        "APT:412 Bldg",
        "X:NORTH BROADWAY",
        "CITY:PENNSVILLE TWP",
        "NAME:FRANKLIN ALARM CO OPER 2769",
        "PHONE:6782600");
  }
  
  public static void main(String[] args) {
    new NJSalemCountyParserTest().generateTests("T1", "CALL ADDR APT X CITY NAME PHONE");
  }
}