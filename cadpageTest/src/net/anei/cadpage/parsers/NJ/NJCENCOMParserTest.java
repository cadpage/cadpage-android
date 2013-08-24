package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
CENCOM, NJ
Contact: David Suriano <dasuriano1@gmail.com>
Sender: cencom@ahsys.org
System: Visinet

Unit M404-1 # 2012-049211 Recv'd 15:09 Disp 15:10 Enroute Arrival Avail 15:13

Unit:M404-1 #2012-049202 Breathing Problems ALS Dingman Twp 114 High Meadow Dr Room Pickup Location: Pt Name:
Unit:M404-1 #2012-049211 Sick Person BLS Westfall Twp 0-0 Rte6 (264 Route 6 & 2 RoomRM 211 Pickup Location: Pt Name:
Unit:M404-2 #2012-048860 Chest Pain ALS Westfall Twp 1023 Pensylvania Ave Room Pickup Location: Pt Name:
Unit:M404-2 #2012-046172 Seizures/Convulsions ALS Milford Boro (Pike) 107 W Ann St Room Pickup Location: Pt Name:
Unit:M404-1 #2012-045571 Sick Person BLS Milford Boro (Pike) 404 Rte6 Room318 Pickup Location: Pt Name:
Unit:M404-2 #2012-044825 Chest Pain ALS Westfall Twp Rte6 & Rte209 Room Pickup Location: Pt Name:
Unit:M404-1 #2012-044543 Altered Mental Status ALS Matamoras Boro 91 10th St Room Pickup Location: Pt Name:
Unit:M404-2 #2012-042444 Cardiac Arrest ALS Dingman Twp 107 Brooke Park Ct Room Pickup Location: Pt Name:
Unit:EMS4 #2012-035472 Sick Person BLS Frankford Twp 129 Morris Tpke Apt308 Cross St:Rte519/Unnamed Street
Unit:EMS4 #2012-035438 Altered Mental Status ALS Andover Twp 99 Mulford Rd AptN111B Cross St:Unnamed Street/Unnamed Street
Unit:EMS4 #2012-032512 Chest Pain ALS Newton Town 99 High St Apt Cross St:Academy St/Liberty St
Unit:EMS4 #2012-032518 Psych/Behavior Problem BLS Frelinghuysen Twp 145 State Park Rd Apt115-D Cross St:Shiloh Rd/Unnamed Street
Unit:EMS4 #2012-031691 Breathing Problems BLS Newton Town 249 High St Apt12-W Cross St:Summit Ave/Shady Ln
Unit:EMS4 #2012-031058 Standby BLS Newton Town 85 Mill St Apt Cross St:Clinton St/Newton Swartswood Rd
 
 */
public class NJCENCOMParserTest extends BaseParserTest {
  
  public NJCENCOMParserTest() {
    setParser(new NJCENCOMParser(), "", "NJ");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "Unit M404-1 # 2012-049211 Recv'd 15:09 Disp 15:10 Enroute Arrival Avail 15:13",
        "UNIT:M404-1",
        "ID:2012-049211",
        "CALL:RUN REPORT",
        "PLACE:Recv'd 15:09 Disp 15:10 Enroute Arrival Avail 15:13");

  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Unit:M404-1 #2012-049202 Breathing Problems ALS Dingman Twp 114 High Meadow Dr Room Pickup Location: Pt Name:",
        "UNIT:M404-1",
        "ID:2012-049202",
        "CALL:Breathing Problems ALS",
        "CITY:Dingman Twp",
        "ST:PA",
        "ADDR:114 High Meadow Dr");

    doTest("T2",
        "Unit:M404-1 #2012-049211 Sick Person BLS Westfall Twp 0-0 Rte6 (264 Route 6 & 2 RoomRM 211 Pickup Location: Pt Name:",
        "UNIT:M404-1",
        "ID:2012-049211",
        "CALL:Sick Person BLS",
        "CITY:Westfall Twp",
        "ST:PA",
        "ADDR:264 Route 6 & 2",
        "MADDR:264 Route 6",
        "APT:RM 211");

    doTest("T3",
        "Unit:M404-2 #2012-048860 Chest Pain ALS Westfall Twp 1023 Pensylvania Ave Room Pickup Location: Pt Name:",
        "UNIT:M404-2",
        "ID:2012-048860",
        "CALL:Chest Pain ALS",
        "CITY:Westfall Twp",
        "ST:PA",
        "ADDR:1023 Pensylvania Ave");

    doTest("T4",
        "Unit:M404-2 #2012-046172 Seizures/Convulsions ALS Milford Boro (Pike) 107 W Ann St Room Pickup Location: Pt Name:",
        "UNIT:M404-2",
        "ID:2012-046172",
        "CALL:Seizures/Convulsions ALS",
        "CITY:Milford",
        "ST:PA",
        "ADDR:107 W Ann St");

    doTest("T5",
        "Unit:M404-1 #2012-045571 Sick Person BLS Milford Boro (Pike) 404 Rte6 Room318 Pickup Location: Pt Name:",
        "UNIT:M404-1",
        "ID:2012-045571",
        "CALL:Sick Person BLS",
        "CITY:Milford",
        "ST:PA",
        "ADDR:404 Rte6",
        "MADDR:404 Rte 6",
        "APT:318");

    doTest("T6",
        "Unit:M404-2 #2012-044825 Chest Pain ALS Westfall Twp Rte6 & Rte209 Room Pickup Location: Pt Name:",
        "UNIT:M404-2",
        "ID:2012-044825",
        "CALL:Chest Pain ALS",
        "CITY:Westfall Twp",
        "ST:PA",
        "ADDR:Rte6 & Rte209",
        "MADDR:Rte 6 & Rte 209");

    doTest("T7",
        "Unit:M404-1 #2012-044543 Altered Mental Status ALS Matamoras Boro 91 10th St Room Pickup Location: Pt Name:",
        "UNIT:M404-1",
        "ID:2012-044543",
        "CALL:Altered Mental Status ALS",
        "CITY:Matamoras",
        "ST:PA",
        "ADDR:91 10th St");

    doTest("T8",
        "Unit:M404-2 #2012-042444 Cardiac Arrest ALS Dingman Twp 107 Brooke Park Ct Room Pickup Location: Pt Name:",
        "UNIT:M404-2",
        "ID:2012-042444",
        "CALL:Cardiac Arrest ALS",
        "CITY:Dingman Twp",
        "ST:PA",
        "ADDR:107 Brooke Park Ct");

    doTest("T9",
        "Unit:EMS4 #2012-035472 Sick Person BLS Frankford Twp 129 Morris Tpke Apt308 Cross St:Rte519/Unnamed Street",
        "UNIT:EMS4",
        "ID:2012-035472",
        "CALL:Sick Person BLS",
        "CITY:Frankford Twp",
        "ADDR:129 Morris Tpke",
        "APT:308",
        "X:Rte519/Unnamed Street");

    doTest("T10",
        "Unit:EMS4 #2012-035438 Altered Mental Status ALS Andover Twp 99 Mulford Rd AptN111B Cross St:Unnamed Street/Unnamed Street",
        "UNIT:EMS4",
        "ID:2012-035438",
        "CALL:Altered Mental Status ALS",
        "CITY:Andover Twp",
        "ADDR:99 Mulford Rd",
        "APT:N111B",
        "X:Unnamed Street/Unnamed Street");

    doTest("T11",
        "Unit:EMS4 #2012-032512 Chest Pain ALS Newton Town 99 High St Apt Cross St:Academy St/Liberty St",
        "UNIT:EMS4",
        "ID:2012-032512",
        "CALL:Chest Pain ALS",
        "CITY:Newton Town",
        "ADDR:99 High St",
        "X:Academy St/Liberty St");

    doTest("T12",
        "Unit:EMS4 #2012-032518 Psych/Behavior Problem BLS Frelinghuysen Twp 145 State Park Rd Apt115-D Cross St:Shiloh Rd/Unnamed Street",
        "UNIT:EMS4",
        "ID:2012-032518",
        "CALL:Psych/Behavior Problem BLS",
        "CITY:Frelinghuysen Twp",
        "ADDR:145 State Park Rd",
        "APT:115-D",
        "X:Shiloh Rd/Unnamed Street");

    doTest("T13",
        "Unit:EMS4 #2012-031691 Breathing Problems BLS Newton Town 249 High St Apt12-W Cross St:Summit Ave/Shady Ln",
        "UNIT:EMS4",
        "ID:2012-031691",
        "CALL:Breathing Problems BLS",
        "CITY:Newton Town",
        "ADDR:249 High St",
        "APT:12-W",
        "X:Summit Ave/Shady Ln");

    doTest("T14",
        "Unit:EMS4 #2012-031058 Standby BLS Newton Town 85 Mill St Apt Cross St:Clinton St/Newton Swartswood Rd",
        "UNIT:EMS4",
        "ID:2012-031058",
        "CALL:Standby BLS",
        "CITY:Newton Town",
        "ADDR:85 Mill St",
        "X:Clinton St/Newton Swartswood Rd");

  }
  
  public static void main(String[] args) {
    new NJCENCOMParserTest().generateTests("T1");
  }
}