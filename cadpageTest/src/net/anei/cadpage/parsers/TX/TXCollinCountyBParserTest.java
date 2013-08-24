package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Collin County, TX
Contact: Active911
Agency name: Lucas Fire Dept
Location: Lucas, TX, United States
Sender: PSCx7900@plano.gov 

(VisiCAD SMTP Paging) Comment: Disregard FD Call for 2755 Aztec Trl -- Disregard per Wylie FD already on scene.,  Medical Call-Level 1-F /Comment: UNATTENDED DEATH /ADDR: 2755 Aztec Trl ,  , TX /XST: PARKER RD/Dead End /Map Page: 2436A
(VisiCAD SMTP Paging) Comment: PER COLLIN CO SO NO INJURIES AT 415 W LUCAS RD TRAFFIC ACCIDENT ALL LUCAS UNITS RESPONDING CAN DISREGARD,  Traffic Accident-F /Comment: unk inj - 2 veh /ADDR: 415 W Lucas Rd , Lucas , TX /XST: EDGEFIELD LN/HOLLY LN /Map Page: 2734D
(VisiCAD SMTP Paging) Comment: Disregard call of mutual aid in Branch,  Traffic Accident-F /Comment: mutual aid in Branch / 5877 FM 546 /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/ESTATES RD /Map Page: 2733D

(VisiCAD SMTP Paging) Traffic Accident-F /Comment: cc has officer on scene needs fd to respond /ADDR: Lynn Ln / Estates Pkwy , Lucas , TX /XST:  /Map Page: 2733B
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 3455 AZTEK TRL /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Public Service-F /Comment: 3455 Aztek trl /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Grass Fire-F /Comment: was burning in yard.....fire not going out /ADDR: 1600 W Forest Grove Rd , Lucas , TX /XST: TIMBER TRL/WOLF CREEK DR /Map Page: 2933D
(VisiCAD SMTP Paging) Structure Fire-F /Comment:  /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Smoke Investigation OUTSIDE-F /Comment: blk smoke near Wolf Creek edition /ADDR: 2721 Katety Mae Ct , Lucas , TX /XST: Dead End/WOLF CREEK DR /Map Page: 2933C
(VisiCAD SMTP Paging) Chest Pain-Level 1-F /Comment: chest pains /ADDR: 13 Graham Ln , Lucas , TX /XST: UNKNOWN/Dead End /Map Page: 2833A
(VisiCAD SMTP Paging) Alarm Investigation-F /Comment: GENERAL SMOKE ALRM GOING OFF /ADDR: 651 Stinson Rd , Lucas , TX /XST: W LUCAS RD/HICKORY HILL ST /Map Page: 2634B
(VisiCAD SMTP Paging) Medical Call-Level 2-F /Comment: unknown medical emergency /ADDR: 2741 Wolf Creek Dr , Lucas , TX /XST: ELIZABETH ST/W FOREST GROVE RD /Map Page: 2933C
(VisiCAD SMTP Paging) Structure Fire-F /Comment:  /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/ESTATES RD /Map Page: 2733D
(VisiCAD SMTP Paging) Traffic Accident-F /Comment: subj hit by veh /ADDR: 2662 W Lucas Rd , Lucas , TX /XST: ALLISON LN/FM 2551 HWY /Map Page: 2732D
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: HUSB UNRESPONSIVE /ADDR: 7 Park Ln , Lucas , TX /XST: ESTATES PKWY/Dead End /Map Page: 2833D
(VisiCAD SMTP Paging) Alarm Investigation-F /Comment: smoke detector fire alarm /ADDR: 131 Estelle Ln , Lucas , TX /XST: FORESTVIEW DR/GOLD DUST TRL /Map Page: 2735A
(VisiCAD SMTP Paging) Traffic Accident-F /Comment: 1 VEH, MOTORCYCLE /ADDR: 750 W Lucas Rd , Lucas , TX /XST: HOLLY LN/STINSON RD /Map Page: 2734D
(VisiCAD SMTP Paging) Trash Fire-F /Comment: bonfire at loc /ADDR: 16 Carey Ln , Lucas , TX /XST: SOUTHVIEW DR/Dead End /Map Page: 2635A
(VisiCAD SMTP Paging) Breathing Problems-Level 1-F /Comment: 79 y/o m breathing trouble /ADDR: 3455 Aztec Trl , Lucas , TX /XST: PARKER RD/SOUTHVIEW DR /Map Page: 2536C
(VisiCAD SMTP Paging) Alarm Investigation-F /Comment: HALLWAY SMOKE /ADDR: 105 Lost Valley Dr , Lucas , TX /XST: E LUCAS RD/Dead End /Map Page: 2735C
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: allergic reaction /ADDR: 1535 Snider Ln , Lucas , TX /XST: Dead End/STERLING BROWN LN /Map Page: 2836D
(VisiCAD SMTP Paging) Public Service-F /Comment: 200 STANFORD /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Structure Fire-F /Comment: 200 STANFORD  FIRE ON BACK PORCH /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 75yom con breath /ADDR: 201 Riva Rdg , CollinC , TX /XST: SANTA ANITA CR/SANTA MARIA CR /Map Page: 2535A
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 8180 CR 887 TRINITY PARK /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Traffic Accident-F /Comment: stinson road & west lucas road /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Medical Call-Level 2-F /Comment: 680 winning coff rd /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D
(VisiCAD SMTP Paging) Electrical Short-F /Comment:  /ADDR: 800 Country Club Rd , Lucas , TX /XST: ESTELLE LN/CREEK VIEW /Map Page: 2733B
(VisiCAD SMTP Paging) Medical Call-Level 2-F /Comment:  /ADDR: 404 Carriage Trl , Lucas , TX /XST: CHULA VISTA CR/RIVA RDG /Map Page: 2635C
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: UNATTENDED DEATH /ADDR: 2755 Aztec Trl ,  , TX /XST: PARKER RD/Dead End /Map Page: 2436A
(VisiCAD SMTP Paging) Suicide Attempt-F /Comment:  /ADDR: 4 Brookhaven Dr , Lucas , TX /XST: SOUTHVIEW DR/Dead End /Map Page: 2634D
(VisiCAD SMTP Paging) Unconscious/Altered LOC-L 1-F /Comment: F FAINTED /ADDR: 440 Southview Dr , Lucas , TX /XST: ALEXANDER CT/JORDAN CT /Map Page: 2635A
(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 1520 SNIDER LN /ADDR: 1520 Snider Ln , Lucas , TX /XST: Dead End/STERLING BROWN LN /Map Page: 2836D

*/

public class TXCollinCountyBParserTest extends BaseParserTest {
  
  public TXCollinCountyBParserTest() {
    setParser(new TXCollinCountyBParser(), "COLLIN COUNTY", "TX");
  }
  
  @Test
  public void testSpecialComment() {

    doTest("T1",
        "(VisiCAD SMTP Paging) Comment: Disregard FD Call for 2755 Aztec Trl -- Disregard per Wylie FD already on scene.,  Medical Call-Level 1-F /Comment: UNATTENDED DEATH /ADDR: 2755 Aztec Trl ,  , TX /XST: PARKER RD/Dead End /Map Page: 2436A",
        "PLACE:Disregard FD Call for 2755 Aztec Trl -- Disregard per Wylie FD already on scene.",
        "CALL:Medical Call-Level 1-F",
        "INFO:UNATTENDED DEATH",
        "ADDR:2755 Aztec Trl",
        "X:PARKER RD/Dead End",
        "MAP:2436A");

    doTest("T2",
        "(VisiCAD SMTP Paging) Comment: PER COLLIN CO SO NO INJURIES AT 415 W LUCAS RD TRAFFIC ACCIDENT ALL LUCAS UNITS RESPONDING CAN DISREGARD,  Traffic Accident-F /Comment: unk inj - 2 veh /ADDR: 415 W Lucas Rd , Lucas , TX /XST: EDGEFIELD LN/HOLLY LN /Map Page: 2734D",
        "PLACE:PER COLLIN CO SO NO INJURIES AT 415 W LUCAS RD TRAFFIC ACCIDENT ALL LUCAS UNITS RESPONDING CAN DISREGARD",
        "CALL:Traffic Accident-F",
        "INFO:unk inj - 2 veh",
        "ADDR:415 W Lucas Rd",
        "CITY:Lucas",
        "X:EDGEFIELD LN/HOLLY LN",
        "MAP:2734D");

    doTest("T3",
        "(VisiCAD SMTP Paging) Comment: Disregard call of mutual aid in Branch,  Traffic Accident-F /Comment: mutual aid in Branch / 5877 FM 546 /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/ESTATES RD /Map Page: 2733D",
        "PLACE:Disregard call of mutual aid in Branch",
        "CALL:Traffic Accident-F",
        "INFO:mutual aid in Branch / 5877 FM 546",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/ESTATES RD",
        "MAP:2733D");
  
  }
  
  @Test
  public void testLucasFireDept() {

    doTest("T1",
        "(VisiCAD SMTP Paging) Traffic Accident-F /Comment: cc has officer on scene needs fd to respond /ADDR: Lynn Ln / Estates Pkwy , Lucas , TX /XST:  /Map Page: 2733B",
        "CALL:Traffic Accident-F",
        "INFO:cc has officer on scene needs fd to respond",
        "ADDR:Lynn Ln & Estates Pkwy",
        "CITY:Lucas",
        "MAP:2733B");

    doTest("T2",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 3455 AZTEK TRL /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Medical Call-Level 1-F",
        "INFO:3455 AZTEK TRL",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T3",
        "(VisiCAD SMTP Paging) Public Service-F /Comment: 3455 Aztek trl /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Public Service-F",
        "INFO:3455 Aztek trl",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T4",
        "(VisiCAD SMTP Paging) Grass Fire-F /Comment: was burning in yard.....fire not going out /ADDR: 1600 W Forest Grove Rd , Lucas , TX /XST: TIMBER TRL/WOLF CREEK DR /Map Page: 2933D",
        "CALL:Grass Fire-F",
        "INFO:was burning in yard.....fire not going out",
        "ADDR:1600 W Forest Grove Rd",
        "CITY:Lucas",
        "X:TIMBER TRL/WOLF CREEK DR",
        "MAP:2933D");

    doTest("T5",
        "(VisiCAD SMTP Paging) Structure Fire-F /Comment:  /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Structure Fire-F",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T6",
        "(VisiCAD SMTP Paging) Smoke Investigation OUTSIDE-F /Comment: blk smoke near Wolf Creek edition /ADDR: 2721 Katety Mae Ct , Lucas , TX /XST: Dead End/WOLF CREEK DR /Map Page: 2933C",
        "CALL:Smoke Investigation OUTSIDE-F",
        "INFO:blk smoke near Wolf Creek edition",
        "ADDR:2721 Katety Mae Ct",
        "CITY:Lucas",
        "X:Dead End/WOLF CREEK DR",
        "MAP:2933C");

    doTest("T7",
        "(VisiCAD SMTP Paging) Chest Pain-Level 1-F /Comment: chest pains /ADDR: 13 Graham Ln , Lucas , TX /XST: UNKNOWN/Dead End /Map Page: 2833A",
        "CALL:Chest Pain-Level 1-F",
        "INFO:chest pains",
        "ADDR:13 Graham Ln",
        "CITY:Lucas",
        "X:UNKNOWN/Dead End",
        "MAP:2833A");

    doTest("T8",
        "(VisiCAD SMTP Paging) Alarm Investigation-F /Comment: GENERAL SMOKE ALRM GOING OFF /ADDR: 651 Stinson Rd , Lucas , TX /XST: W LUCAS RD/HICKORY HILL ST /Map Page: 2634B",
        "CALL:Alarm Investigation-F",
        "INFO:GENERAL SMOKE ALRM GOING OFF",
        "ADDR:651 Stinson Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/HICKORY HILL ST",
        "MAP:2634B");

    doTest("T9",
        "(VisiCAD SMTP Paging) Medical Call-Level 2-F /Comment: unknown medical emergency /ADDR: 2741 Wolf Creek Dr , Lucas , TX /XST: ELIZABETH ST/W FOREST GROVE RD /Map Page: 2933C",
        "CALL:Medical Call-Level 2-F",
        "INFO:unknown medical emergency",
        "ADDR:2741 Wolf Creek Dr",
        "CITY:Lucas",
        "X:ELIZABETH ST/W FOREST GROVE RD",
        "MAP:2933C");

    doTest("T10",
        "(VisiCAD SMTP Paging) Structure Fire-F /Comment:  /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/ESTATES RD /Map Page: 2733D",
        "CALL:Structure Fire-F",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/ESTATES RD",
        "MAP:2733D");

    doTest("T11",
        "(VisiCAD SMTP Paging) Traffic Accident-F /Comment: subj hit by veh /ADDR: 2662 W Lucas Rd , Lucas , TX /XST: ALLISON LN/FM 2551 HWY /Map Page: 2732D",
        "CALL:Traffic Accident-F",
        "INFO:subj hit by veh",
        "ADDR:2662 W Lucas Rd",
        "CITY:Lucas",
        "X:ALLISON LN/FM 2551 HWY",
        "MAP:2732D");

    doTest("T12",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: HUSB UNRESPONSIVE /ADDR: 7 Park Ln , Lucas , TX /XST: ESTATES PKWY/Dead End /Map Page: 2833D",
        "CALL:Medical Call-Level 1-F",
        "INFO:HUSB UNRESPONSIVE",
        "ADDR:7 Park Ln",
        "CITY:Lucas",
        "X:ESTATES PKWY/Dead End",
        "MAP:2833D");

    doTest("T13",
        "(VisiCAD SMTP Paging) Alarm Investigation-F /Comment: smoke detector fire alarm /ADDR: 131 Estelle Ln , Lucas , TX /XST: FORESTVIEW DR/GOLD DUST TRL /Map Page: 2735A",
        "CALL:Alarm Investigation-F",
        "INFO:smoke detector fire alarm",
        "ADDR:131 Estelle Ln",
        "CITY:Lucas",
        "X:FORESTVIEW DR/GOLD DUST TRL",
        "MAP:2735A");

    doTest("T14",
        "(VisiCAD SMTP Paging) Traffic Accident-F /Comment: 1 VEH, MOTORCYCLE /ADDR: 750 W Lucas Rd , Lucas , TX /XST: HOLLY LN/STINSON RD /Map Page: 2734D",
        "CALL:Traffic Accident-F",
        "INFO:1 VEH, MOTORCYCLE",
        "ADDR:750 W Lucas Rd",
        "CITY:Lucas",
        "X:HOLLY LN/STINSON RD",
        "MAP:2734D");

    doTest("T15",
        "(VisiCAD SMTP Paging) Trash Fire-F /Comment: bonfire at loc /ADDR: 16 Carey Ln , Lucas , TX /XST: SOUTHVIEW DR/Dead End /Map Page: 2635A",
        "CALL:Trash Fire-F",
        "INFO:bonfire at loc",
        "ADDR:16 Carey Ln",
        "CITY:Lucas",
        "X:SOUTHVIEW DR/Dead End",
        "MAP:2635A");

    doTest("T16",
        "(VisiCAD SMTP Paging) Breathing Problems-Level 1-F /Comment: 79 y/o m breathing trouble /ADDR: 3455 Aztec Trl , Lucas , TX /XST: PARKER RD/SOUTHVIEW DR /Map Page: 2536C",
        "CALL:Breathing Problems-Level 1-F",
        "INFO:79 y/o m breathing trouble",
        "ADDR:3455 Aztec Trl",
        "CITY:Lucas",
        "X:PARKER RD/SOUTHVIEW DR",
        "MAP:2536C");

    doTest("T17",
        "(VisiCAD SMTP Paging) Alarm Investigation-F /Comment: HALLWAY SMOKE /ADDR: 105 Lost Valley Dr , Lucas , TX /XST: E LUCAS RD/Dead End /Map Page: 2735C",
        "CALL:Alarm Investigation-F",
        "INFO:HALLWAY SMOKE",
        "ADDR:105 Lost Valley Dr",
        "CITY:Lucas",
        "X:E LUCAS RD/Dead End",
        "MAP:2735C");

    doTest("T18",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: allergic reaction /ADDR: 1535 Snider Ln , Lucas , TX /XST: Dead End/STERLING BROWN LN /Map Page: 2836D",
        "CALL:Medical Call-Level 1-F",
        "INFO:allergic reaction",
        "ADDR:1535 Snider Ln",
        "CITY:Lucas",
        "X:Dead End/STERLING BROWN LN",
        "MAP:2836D");

    doTest("T19",
        "(VisiCAD SMTP Paging) Public Service-F /Comment: 200 STANFORD /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Public Service-F",
        "INFO:200 STANFORD",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T20",
        "(VisiCAD SMTP Paging) Structure Fire-F /Comment: 200 STANFORD  FIRE ON BACK PORCH /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Structure Fire-F",
        "INFO:200 STANFORD  FIRE ON BACK PORCH",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T21",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 75yom con breath /ADDR: 201 Riva Rdg , CollinC , TX /XST: SANTA ANITA CR/SANTA MARIA CR /Map Page: 2535A",
        "CALL:Medical Call-Level 1-F",
        "INFO:75yom con breath",
        "ADDR:201 Riva Rdg",
        "CITY:CollinC",
        "X:SANTA ANITA CR/SANTA MARIA CR",
        "MAP:2535A");

    doTest("T22",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 8180 CR 887 TRINITY PARK /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Medical Call-Level 1-F",
        "INFO:8180 CR 887 TRINITY PARK",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T23",
        "(VisiCAD SMTP Paging) Traffic Accident-F /Comment: stinson road & west lucas road /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Traffic Accident-F",
        "INFO:stinson road & west lucas road",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T24",
        "(VisiCAD SMTP Paging) Medical Call-Level 2-F /Comment: 680 winning coff rd /ADDR: 165 Country Club Rd , Lucas , TX /XST: W LUCAS RD/LUCAS /Map Page: 2733D",
        "CALL:Medical Call-Level 2-F",
        "INFO:680 winning coff rd",
        "ADDR:165 Country Club Rd",
        "CITY:Lucas",
        "X:W LUCAS RD/LUCAS",
        "MAP:2733D");

    doTest("T25",
        "(VisiCAD SMTP Paging) Electrical Short-F /Comment:  /ADDR: 800 Country Club Rd , Lucas , TX /XST: ESTELLE LN/CREEK VIEW /Map Page: 2733B",
        "CALL:Electrical Short-F",
        "ADDR:800 Country Club Rd",
        "CITY:Lucas",
        "X:ESTELLE LN/CREEK VIEW",
        "MAP:2733B");

    doTest("T26",
        "(VisiCAD SMTP Paging) Medical Call-Level 2-F /Comment:  /ADDR: 404 Carriage Trl , Lucas , TX /XST: CHULA VISTA CR/RIVA RDG /Map Page: 2635C",
        "CALL:Medical Call-Level 2-F",
        "ADDR:404 Carriage Trl",
        "CITY:Lucas",
        "X:CHULA VISTA CR/RIVA RDG",
        "MAP:2635C");

    doTest("T27",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: UNATTENDED DEATH /ADDR: 2755 Aztec Trl ,  , TX /XST: PARKER RD/Dead End /Map Page: 2436A",
        "CALL:Medical Call-Level 1-F",
        "INFO:UNATTENDED DEATH",
        "ADDR:2755 Aztec Trl",
        "X:PARKER RD/Dead End",
        "MAP:2436A");

    doTest("T28",
        "(VisiCAD SMTP Paging) Suicide Attempt-F /Comment:  /ADDR: 4 Brookhaven Dr , Lucas , TX /XST: SOUTHVIEW DR/Dead End /Map Page: 2634D",
        "CALL:Suicide Attempt-F",
        "ADDR:4 Brookhaven Dr",
        "CITY:Lucas",
        "X:SOUTHVIEW DR/Dead End",
        "MAP:2634D");

    doTest("T29",
        "(VisiCAD SMTP Paging) Unconscious/Altered LOC-L 1-F /Comment: F FAINTED /ADDR: 440 Southview Dr , Lucas , TX /XST: ALEXANDER CT/JORDAN CT /Map Page: 2635A",
        "CALL:Unconscious/Altered LOC-L 1-F",
        "INFO:F FAINTED",
        "ADDR:440 Southview Dr",
        "CITY:Lucas",
        "X:ALEXANDER CT/JORDAN CT",
        "MAP:2635A");

    doTest("T30",
        "(VisiCAD SMTP Paging) Medical Call-Level 1-F /Comment: 1520 SNIDER LN /ADDR: 1520 Snider Ln , Lucas , TX /XST: Dead End/STERLING BROWN LN /Map Page: 2836D",
        "CALL:Medical Call-Level 1-F",
        "INFO:1520 SNIDER LN",
        "ADDR:1520 Snider Ln",
        "CITY:Lucas",
        "X:Dead End/STERLING BROWN LN",
        "MAP:2836D");

  }
  
  public static void main(String[] args) {
    new TXCollinCountyBParserTest().generateTests("T1");
  }
}
