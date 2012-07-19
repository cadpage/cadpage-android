package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCGastonCountyBParserTest extends BaseParserTest {
  
  public NCGastonCountyBParserTest() {
    setParser(new NCGastonCountyBParser(), "GASTON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(FW: Rip and Run Report) ---------- Forwarded message ----------\n" +
        "From: NWSAdmin <NWSAdmin@cityofgastonia.com>\n" +
        "Date: Mon, Jun 4, 2012 at 4:41 PM\n" +
        "Subject: FW: Rip and Run Report\n" +
        "To: \"AG Center (agcenter61@gmail.com)\" <agcenter61@gmail.com>\n\n\n\n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Monday, June 04, 2012 4:41:06 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~M L KISER~RD/~PUETTS CHAPEL~RD\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Phone:~(704) 842-4272\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61E\n" +
        "District:~3CM2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~4284\n" +
        "Call Type:~ Fire-Vehicle\n" +
        "Source:~911 Call\n" +
        "Priority:~ 2\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 12 Police Back Up\n" +
        "Caller:~stephanie\n" +
        "Call Date/Time:~06/04/2012 16:40:08\n" +
        "Dispatch Date/Time:~06/04/2012 16:41:02\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000194~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/04/12 16:40:46~hay bale on trailer is on fire",

        "ADDR:M L KISER RD & PUETTS CHAPEL RD",  // Not mapping
        "PHONE:(704) 842-4272",
        "MAP:61E-3CM2",
        "ID:4284",
        "CALL:Fire-Vehicle",
        "PRI:2",
        "NAME:stephanie",
        "DATE:06/04/2012",
        "TIME:16:41:02",
        "UNIT:EN611",
        "INFO:hay bale on trailer is on fire");

    doTest("T2",
        "(Fwd: FW: Rip and Run Report) ---------- Forwarded message ----------\n" +
        "From: \"NWSAdmin\" <NWSAdmin@cityofgastonia.com>\n" +
        "Date: Jun 3, 2012 2:31 PM\n" +
        "Subject: FW: Rip and Run Report\n" +
        "To: \"AG Center (agcenter61@gmail.com)\" <agcenter61@gmail.com>\n\n\n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Sunday, June 03, 2012 2:31:14 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~320~N ~MYRTLE SCHOOL~RD~\n" +
        "Venue:~GASTONIA\n" +
        "Cross Streets~\n" +
        "WHITENER ST / TWIN AVE\n" +
        "Station:~Station 1\n" +
        "Quadrant:~GF1A\n" +
        "District:~1GR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~3041\n" +
        "Call Type:~ Fire-House\n" +
        "Source:~Phone\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~allen,~ann\n" +
        "Call Date/Time:~06/03/2012 14:29:44\n" +
        "Dispatch Date/Time:~06/03/2012 14:31:03\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/03/2012 14:31:05\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000192~~AG Center Fire Dept.\n" +
        "2012-00011140~~Gaston Emergency Medical Services\n" +
        "2012-00003728~~Gastonia Fire Dept.\n" +
        "~\n" +
        "Units Sent:~6\n" +
        "RS1, LD61, EN8, EN5, LD1, E24P~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/03/12 14:30:08~propane gas tank caught on fire\n" +
        "06/03/12 14:30:29~this is in her carport attached to the house",

        "ADDR:320 N  MYRTLE SCHOOL RD",
        "CITY:GASTONIA",
        "X:WHITENER ST / TWIN AVE",
        "MAP:GF1A-1GR1",
        "ID:3041",
        "CALL:Fire-House",
        "PRI:1",
        "NAME:allen, ann",
        "DATE:06/03/2012",
        "TIME:14:31:03",
        "UNIT:RS1, LD61, EN8, EN5, LD1, E24P",
        "INFO:propane gas tank caught on fire / this is in her carport attached to the house");

    doTest("T3",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Monday, June 04, 2012 10:59:40 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~2912~CLONINGER~RD~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "NIXON SMITH RD / COLT THORNBURG RD\n" +
        "Phone:~(980) 329-2486\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61C\n" +
        "District:~1DR2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~4631\n" +
        "Call Type:~ Veh Acc-PI\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~Just Occurred\n" +
        "Assigned To:~Position 15 Call Taking\n" +
        "Caller:~HUGGINS,~JAY\n" +
        "Call Date/Time:~06/04/2012 22:58:17\n" +
        "Dispatch Date/Time:~06/04/2012 22:59:36\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000196~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/04/12 22:58:43~New ProQA Case Number has been assigned: 4988669\n" +
        "06/04/12 22:59:04~CAR HIT A TREE AND THEY ARE PINNED IN",

        "ADDR:2912 CLONINGER RD",
        "X:NIXON SMITH RD / COLT THORNBURG RD",
        "PHONE:(980) 329-2486",
        "MAP:61C-1DR2",
        "ID:4631",
        "CALL:Veh Acc-PI",
        "PRI:1",
        "NAME:HUGGINS, JAY",
        "DATE:06/04/2012",
        "TIME:22:59:36",
        "UNIT:EN611",
        "INFO:New ProQA Case Number has been assigned: 4988669 / CAR HIT A TREE AND THEY ARE PINNED IN");

    doTest("T4",
        "(Fwd: FW: Rip and Run Report) ---------- Forwarded message ----------\n" +
        "From: \"NWSAdmin\" <NWSAdmin@cityofgastonia.com>\n" +
        "Date: Jun 4, 2012 11:25 AM\n" +
        "Subject: FW: Rip and Run Report\n" +
        "To: \"AG Center (agcenter61@gmail.com)\" <agcenter61@gmail.com>\n\n\n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Monday, June 04, 2012 11:25:44 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~602~BREVARD~ST~\n" +
        "Common Name:~COUNTRY TIME\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "LUNSFORD DR / WHITNEY COURTNEY LN\n" +
        "Phone:~(800) 318-9486\n" +
        "Station:~Station 55\n" +
        "Quadrant:~55B\n" +
        "District:~11CM1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~3798\n" +
        "Call Type:~ Alarm-Fire (High Risk)\n" +
        "Source:~Phone\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/04/2012 09:35:40\n" +
        "Dispatch Date/Time:~06/04/2012 09:37:12\n" +
        "Arrive Date/Time:~06/04/2012 09:45:08\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/04/2012 09:37:56\n" +
        "Latest Unit Cleared Date/Time:~06/04/2012 11:25:36\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000193~~AG Center Fire Dept.\n" +
        "2012-00000488~~Crowders Mt. Fire Dept.\n" +
        "2012-00011201~~Gaston Emergency Medical Services\n" +
        "2012-00003759~~Gastonia Fire Dept.\n" +
        "2012-00014898~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~11\n" +
        "CAR55, LD61, EN8, LD1, D182, EN552, EN554, SQ55, EN553, E93Q, EN55~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/04/12 09:36:08~GENERAL FIRE ALARM\n" +
        "06/04/12 09:37:43~toned out d182\n" +
        "06/04/12 09:46:09~ops 2\n" +
        "06/04/12 09:49:01~ALARM MALFUNCTION IN ROOM 109\n" +
        "06/04/12 09:49:10~TRYING TO RESET",

        "ADDR:602 BREVARD ST",
        "PLACE:COUNTRY TIME",
        "X:LUNSFORD DR / WHITNEY COURTNEY LN",
        "PHONE:(800) 318-9486",
        "MAP:55B-11CM1",
        "ID:3798",
        "CALL:Alarm-Fire (High Risk)",
        "PRI:1",
        "DATE:06/04/2012",
        "TIME:09:37:12",
        "UNIT:CAR55, LD61, EN8, LD1, D182, EN552, EN554, SQ55, EN553, E93Q, EN55",
        "INFO:GENERAL FIRE ALARM / toned out d182 / ops 2 / ALARM MALFUNCTION IN ROOM 109 / TRYING TO RESET");

    doTest("T5",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Wednesday, June 06, 2012 7:46:27 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~500~PARK~RD~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "WILLIS RD / QUEENS DR\n" +
        "Phone:~(704) 530-7258\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61C\n" +
        "District:~1DR2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~6107\n" +
        "Call Type:~ Veh Acc-PI\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~Just Occurred\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~AT&amp;T MOBILITY\n" +
        "Call Date/Time:~06/06/2012 07:44:40\n" +
        "Dispatch Date/Time:~06/06/2012 07:46:23\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000197~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "RS619, EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/06/12 07:44:58~New ProQA Case Number has been assigned: 4990145\n" +
        "06/06/12 07:45:21~veh accident one veh-- ford tarus silver in color\n" +
        "06/06/12 07:46:04~hit a tree and hit a ditch.. several people out walking around",

        "ADDR:500 PARK RD",
        "X:WILLIS RD / QUEENS DR",
        "PHONE:(704) 530-7258",
        "MAP:61C-1DR2",
        "ID:6107",
        "CALL:Veh Acc-PI",
        "PRI:1",
        "NAME:AT&T MOBILITY",
        "DATE:06/06/2012",
        "TIME:07:46:23",
        "UNIT:RS619, EN611",
        "INFO:New ProQA Case Number has been assigned: 4990145 / veh accident one veh-- ford tarus silver in color / hit a tree and hit a ditch.. several people out walking around");

    doTest("T6",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Wednesday, June 06, 2012 5:21:00 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~CLONINGER~RD/~S ~USHY~321\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61F\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~6711\n" +
        "Call Type:~ 29B3M\n" +
        "Source:~911 Call\n" +
        "Priority:~ 3\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 6 Fire/EMS Backup\n" +
        "Caller:~CONNELL,~LESLIE\n" +
        "Call Date/Time:~06/06/2012 17:16:41\n" +
        "Dispatch Date/Time:~06/06/2012 17:19:44\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/06/2012 17:20:09\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000198~~AG Center Fire Dept.\n" +
        "2012-00011360~~Gaston Emergency Medical Services\n" +
        "2012-00015122~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~4\n" +
        "EN611, D185, E23P, E10S~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/06/12 17:17:58~WHT MINI VAN  WAS FORCED INTO THE BRIDGE   A BLACK INTREPID   DOT BACK TWRDS NORTH GASTON\n" +
        "06/06/12 17:18:10~New ProQA Case Number has been assigned: 4990749\n" +
        "06/06/12 17:19:24~Problem: TRAFFIC ACCIDENT.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/06/12 17:19:24~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B03; Dispatch Level Suffix: M; Response Text: Bravo\n" +
        "06/06/12 17:19:24~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  Other hazards  (Multiple patients).  Caller Statement: TRAFFIC ACCIDENT.  1.The incident involves multiple vehicles.  2.A multiple-unit response is not required.  3.Other hazards specified in comments are present: VEH HAS HIT THE BRIDGE  4.There is no one pinned.  5.No one was thrown from the vehicle.  6.Everyone appears to be completely awake (alert).  7.Their injuries are described as other than to a NOT DANGEROUS area.  8.There is no bleeding now.  -Comments: VEH HAS HIT THE BRIDGE-",

        "ADDR:CLONINGER RD & S  USHY 321",
        "MADDR:CLONINGER RD & S  US 321",
        "X:Station: Station 61",
        "MAP:61F-1DR3",
        "ID:6711",
        "CALL:29B3M",
        "PRI:3",
        "NAME:CONNELL, LESLIE",
        "DATE:06/06/2012",
        "TIME:17:19:44",
        "UNIT:EN611, D185, E23P, E10S",
        "INFO:WHT MINI VAN  WAS FORCED INTO THE BRIDGE   A BLACK INTREPID   DOT BACK TWRDS NORTH GASTON / New ProQA Case Number has been assigned: 4990749 / Problem: TRAFFIC ACCIDENT.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B03; Dispatch Level Suffix: M; Response Text: Bravo / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  Other hazards  (Multiple patients).  Caller Statement: TRAFFIC ACCIDENT.  1.The incident involves multiple vehicles.  2.A multiple-unit response is not required.  3.Other hazards specified in comments are present: VEH HAS HIT THE BRIDGE  4.There is no one pinned.  5.No one was thrown from the vehicle.  6.Everyone appears to be completely awake (alert).  7.Their injuries are described as other than to a NOT DANGEROUS area.  8.There is no bleeding now.  -Comments: VEH HAS HIT THE BRIDGE-");

    doTest("T7",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Friday, June 08, 2012 11:53:17 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~502~IKE LYNCH~RD~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "MILES RD / ACE AVE\n" +
        "Phone:~(980) 429-1939\n" +
        "Station:~Station 21\n" +
        "Quadrant:~21B\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~8578\n" +
        "Call Type:~ Veh Acc-PI\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~Just Occurred\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~Sprint Nextel - iDEN\n" +
        "Call Date/Time:~06/08/2012 11:51:46\n" +
        "Dispatch Date/Time:~06/08/2012 11:53:11\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000199~~AG Center Fire Dept.\n" +
        "2012-00000107~~High Shoals Fire Dept.\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "CAR21, RS619, EN212~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/08/12 11:52:25~wreck\n" +
        "06/08/12 11:52:27~ped struck\n" +
        "06/08/12 11:52:32~New ProQA Case Number has been assigned: 4992614",

        "ADDR:502 IKE LYNCH RD",
        "X:MILES RD / ACE AVE",
        "PHONE:(980) 429-1939",
        "MAP:21B-1DR3",
        "ID:8578",
        "CALL:Veh Acc-PI",
        "PRI:1",
        "NAME:Sprint Nextel - iDEN",
        "DATE:06/08/2012",
        "TIME:11:53:11",
        "UNIT:CAR21, RS619, EN212",
        "INFO:wreck / ped struck / New ProQA Case Number has been assigned: 4992614");

    doTest("T8",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 09, 2012 7:48:47 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~1133~RATCHFORD~DR~\n" +
        "Common Name:~NORTH GASTON HIGH\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "CLONINGER RD / WILSON DR\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61C\n" +
        "District:~1DR2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~9605\n" +
        "Call Type:~ Event-Standby Fire\n" +
        "Source:~Field Initiated\n" +
        "Priority:~ 9\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/09/2012 07:48:43\n" +
        "Dispatch Date/Time:~06/09/2012 07:48:43\n" +
        "Arrive Date/Time:~06/09/2012 07:48:43\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000200~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "LD61~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/09/12 07:48:43~STANDBY FOR GRADUATION",

        "ADDR:1133 RATCHFORD DR",
        "PLACE:NORTH GASTON HIGH",
        "X:CLONINGER RD / WILSON DR",
        "MAP:61C-1DR2",
        "ID:9605",
        "CALL:Event-Standby Fire",
        "PRI:9",
        "DATE:06/09/2012",
        "TIME:07:48:43",
        "UNIT:LD61",
        "INFO:STANDBY FOR GRADUATION");

    doTest("T9",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 09, 2012 10:33:52 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~3255~DALLAS CHERRYVILLE~HWY~\n" +
        "Common Name:~WALNUT GROVE BAPTIST\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "CARPENTER SPRINGS DR\n" +
        " BUSINESS PARK DR / HELEN DR\n" +
        "Phone:~(800) 230-6975\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61A\n" +
        "District:~1DR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~9705\n" +
        "Call Type:~ Alarm-Fire\n" +
        "Source:~Phone\n" +
        "Priority:~ 2\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 10 Call Taking\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/09/2012 10:33:18\n" +
        "Dispatch Date/Time:~06/09/2012 10:33:48\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000201~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "RS619, EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/09/12 10:33:37~walnut grove baptist church/ smoke detector on 11/ atl kh",

        "ADDR:3255 DALLAS CHERRYVILLE HWY",
        "PLACE:WALNUT GROVE BAPTIST",
        "X:CARPENTER SPRINGS DR",
        "PHONE:(800) 230-6975",
        "MAP:61A-1DR1",
        "ID:9705",
        "CALL:Alarm-Fire",
        "PRI:2",
        "DATE:06/09/2012",
        "TIME:10:33:48",
        "UNIT:RS619, EN611",
        "INFO:walnut grove baptist church/ smoke detector on 11/ atl kh");

    doTest("T10",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 09, 2012 1:58:54 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~5711~DALLAS CHERRYVILLE~HWY~\n" +
        "Common Name:~METCALFS STORE\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "TRYON SCHOOL RD / BILL FRALEY DR\n" +
        "Station:~Station 70 North\n" +
        "Quadrant:~70A\n" +
        "District:~6CR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~9869\n" +
        "Call Type:~ 29D2P\n" +
        "Source:~Phone\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/09/2012 13:53:59\n" +
        "Dispatch Date/Time:~06/09/2012 13:55:47\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000202~~AG Center Fire Dept.\n" +
        "2012-00000115~~Tryon Fire Dept.\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "RS619, EN701, SQ709~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/09/12 13:54:20~New ProQA Case Number has been assigned: 4993905\n" +
        "06/09/12 13:55:03~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:55:03~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.\n" +
        "06/09/12 13:55:03~Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:55:09~over turned\n" +
        "06/09/12 13:55:15~off the road.. its on the roof\n" +
        "06/09/12 13:55:24~people are still inside\n" +
        "06/09/12 13:55:30~dark green expedition\n" +
        "06/09/12 13:55:41~people are conscious\n" +
        "06/09/12 13:55:54~lodged between 2 trees\n" +
        "06/09/12 13:56:11~male subj just climbed out\n" +
        "06/09/12 13:56:46~the males mother is still inside the vehicle\n" +
        "06/09/12 13:58:34~ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:58:34~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/09/12 13:58:34~Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:58:38~Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:58:38~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/09/12 13:58:38~ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta",

        "ADDR:5711 DALLAS CHERRYVILLE HWY",
        "PLACE:METCALFS STORE",
        "X:TRYON SCHOOL RD / BILL FRALEY DR",
        "MAP:70A-6CR1",
        "ID:9869",
        "CALL:29D2P",
        "PRI:1",
        "DATE:06/09/2012",
        "TIME:13:55:47",
        "UNIT:RS619, EN701, SQ709",
        "INFO:New ProQA Case Number has been assigned: 4993905 / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover. / Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / over turned / off the road.. its on the roof / people are still inside / dark green expedition / people are conscious / lodged between 2 trees / male subj just climbed out / the males mother is still inside the vehicle / ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding. / Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding. / ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta");

    doTest("T11",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 09, 2012 2:22:36 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~5711~DALLAS CHERRYVILLE~HWY~\n" +
        "Common Name:~METCALFS STORE\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "TRYON SCHOOL RD / BILL FRALEY DR\n" +
        "Station:~Station 70 North\n" +
        "Quadrant:~70A\n" +
        "District:~6CR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~9868\n" +
        "Call Type:~ 29D2P\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~AT&amp;T MOBILITY\n" +
        "Call Date/Time:~06/09/2012 13:53:38\n" +
        "Dispatch Date/Time:~06/09/2012 13:54:33\n" +
        "Arrive Date/Time:~06/09/2012 13:56:32\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/09/2012 13:55:08\n" +
        "Latest Unit Cleared Date/Time:~06/09/2012 14:22:28\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000202~~AG Center Fire Dept.\n" +
        "2012-00001363~~Gaston Co. 9-1-1\n" +
        "2012-00034362~~Gaston Co. Police Dept.\n" +
        "2012-00011557~~Gaston Emergency Medical Services\n" +
        "2012-00015400~~Rescue Squads Gaston Co\n" +
        "2012-00000115~~Tryon Fire Dept.\n" +
        "2012-00000116~~Tryon Fire Dept.\n" +
        "~\n" +
        "Units Sent:~15\n" +
        "E91Q, E81P, NCSHP, RS619, EN701, EN700, CAR61, D186, D182, D180, E30S, 4A3, 1C3, 1B3, SQ709~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/09/12 13:54:17~CAR FLIPPED OVER\n" +
        "06/09/12 13:54:21~New ProQA Case Number has been assigned: 4993904\n" +
        "06/09/12 13:54:54~NEAR METCALF'S STORE\n" +
        "06/09/12 13:55:20~Problem: VEH ACC.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:55:20~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACC.  1.The incident involves a rollover.\n" +
        "06/09/12 13:55:20~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:55:47~ONE PERSON IS OUT, THE OTHER POSSIBLY PINNED IN PER MY RP\n" +
        "06/09/12 13:56:04~ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:56:04~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACC.  1.The incident involves a rollover.  2.It's not suspected that chemicals or other hazards are involved.  3.There is someone pinned.  4.No one was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.Their injuries are described as other than to a NOT DANGEROUS area.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/09/12 13:56:04~Problem: VEH ACC.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:56:35~ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:56:35~Problem: VEH ACC.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:56:35~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACC.  1.The incident involves a rollover.  2.It's not suspected that chemicals or other hazards are involved.  3.There is someone pinned.  4.No one was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.Their injuries are described as other than to a NOT DANGEROUS area.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/09/12 13:57:09~1b3 confirmed roll over...1 female trapped\n" +
        "06/09/12 13:58:09~female is able to get out of the vehicle but is loosing cons...veh on side\n" +
        "06/09/12 13:59:35~37 yof regained cons\n" +
        "06/09/12 13:54:20~Call #: 9869 - New ProQA Case Number has been assigned: 4993905\n" +
        "06/09/12 13:55:03~Call #: 9869 - ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:55:03~Call #: 9869 - Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.\n" +
        "06/09/12 13:55:03~Call #: 9869 - Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:55:09~Call #: 9869 - over turned\n" +
        "06/09/12 13:55:15~Call #: 9869 - off the road.. its on the roof\n" +
        "06/09/12 13:55:24~Call #: 9869 - people are still inside\n" +
        "06/09/12 13:55:30~Call #: 9869 - dark green expedition\n" +
        "06/09/12 13:55:41~Call #: 9869 - people are conscious\n" +
        "06/09/12 13:55:54~Call #: 9869 - lodged between 2 trees\n" +
        "06/09/12 13:56:11~Call #: 9869 - male subj just climbed out\n" +
        "06/09/12 13:56:46~Call #: 9869 - the males mother is still inside the vehicle\n" +
        "06/09/12 13:58:34~Call #: 9869 - ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:58:34~Call #: 9869 - Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/09/12 13:58:34~Call #: 9869 - Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:58:38~Call #: 9869 - Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/09/12 13:58:38~Call #: 9869 - Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/09/12 13:58:38~Call #: 9869 - ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/09/12 13:58:56~Call #: 9869 - per  1b3, female is able to get out of the vehicle but is loosing cons...veh on side\n" +
        "06/09/12 13:59:50~Call #: 9869 - pt has regaine cons now\n" +
        "06/09/12 14:00:45~7000 ADVISED FEMALE ON TOP OF CAR, WILL NEED A LADDER, KEEP RS619 ENROUTE\n" +
        "06/09/12 14:00:53~14 yo wm...cab...bleeding from hand\n" +
        "06/09/12 14:03:50~PER D186, CANCEL D180\n" +
        "06/09/12 14:05:49~70 COMMAND ADVISED RS619 CAN CLEAR\n" +
        "06/09/12 14:14:23~GMH 88\n" +
        "06/09/12 14:20:49~gmh 88",

        "ADDR:5711 DALLAS CHERRYVILLE HWY",
        "PLACE:METCALFS STORE",
        "X:TRYON SCHOOL RD / BILL FRALEY DR",
        "MAP:70A-6CR1",
        "ID:9868",
        "CALL:29D2P",
        "PRI:1",
        "NAME:AT&T MOBILITY",
        "DATE:06/09/2012",
        "TIME:13:54:33",
        "UNIT:E91Q, E81P, NCSHP, RS619, EN701, EN700, CAR61, D186, D182, D180, E30S, 4A3, 1C3, 1B3, SQ709",
        "INFO:CAR FLIPPED OVER / New ProQA Case Number has been assigned: 4993904 / NEAR METCALF'S STORE / Problem: VEH ACC.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACC.  1.The incident involves a rollover. / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / ONE PERSON IS OUT, THE OTHER POSSIBLY PINNED IN PER MY RP / ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACC.  1.The incident involves a rollover.  2.It's not suspected that chemicals or other hazards are involved.  3.There is someone pinned.  4.No one was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.Their injuries are described as other than to a NOT DANGEROUS area.  7.It's not known if there is SERIOUS bleeding. / Problem: VEH ACC.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Problem: VEH ACC.  Patient Info: 2 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Multiple patients involved: 2.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACC.  1.The incident involves a rollover.  2.It's not suspected that chemicals or other hazards are involved.  3.There is someone pinned.  4.No one was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.Their injuries are described as other than to a NOT DANGEROUS area.  7.It's not known if there is SERIOUS bleeding. / 1b3 confirmed roll over...1 female trapped / female is able to get out of the vehicle but is loosing cons...veh on side / 37 yof regained cons / Call #: 9869 - New ProQA Case Number has been assigned: 4993905 / Call #: 9869 - ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Call #: 9869 - Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover. / Call #: 9869 - Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Call #: 9869 - over turned / Call #: 9869 - off the road.. its on the roof / Call #: 9869 - people are still inside / Call #: 9869 - dark green expedition / Call #: 9869 - people are conscious / Call #: 9869 - lodged between 2 trees / Call #: 9869 - male subj just climbed out / Call #: 9869 - the males mother is still inside the vehicle / Call #: 9869 - ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Call #: 9869 - Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding. / Call #: 9869 - Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Call #: 9869 - Problem: veh overturned .  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Call #: 9869 - Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Unknown number of patients involved.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: veh overturned .  1.The incident involves a rollover.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding. / Call #: 9869 - ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Call #: 9869 - per  1b3, female is able to get out of the vehicle but is loosing cons...veh on side / Call #: 9869 - pt has regaine cons now / 7000 ADVISED FEMALE ON TOP OF CAR, WILL NEED A LADDER, KEEP RS619 ENROUTE / 14 yo wm...cab...bleeding from hand / PER D186, CANCEL D180 / 70 COMMAND ADVISED RS619 CAN CLEAR / GMH 88 / gmh 88");

    doTest("T12",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 09, 2012 2:26:36 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~402~N~MYRTLE SCHOOL~RD~APT7\n" +
        "Venue:~GASTONIA\n" +
        "Cross Streets~\n" +
        "TWIN AVE / OLIVER ST\n" +
        "Phone:~(704) 915-6651\n" +
        "Station:~Station 1\n" +
        "Quadrant:~GF1A\n" +
        "District:~1GR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~9896\n" +
        "Call Type:~ Fire-Apartment\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 12 Police Back Up\n" +
        "Caller:~DAVIS,~SAMANTHAT\n" +
        "Call Date/Time:~06/09/2012 14:22:51\n" +
        "Dispatch Date/Time:~06/09/2012 14:26:28\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000203~~AG Center Fire Dept.\n" +
        "2012-00003894~~Gastonia Fire Dept.\n" +
        "~\n" +
        "Units Sent:~6\n" +
        "RS1, LD61, BC1, EN8, LD3, EN2~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/09/12 14:24:07~HEARD A POPPING NOISE\n" +
        "06/09/12 14:25:24~POSS WIRES BURNING\n" +
        "06/09/12 14:25:34~SMELL OF SMOKE",

        "ADDR:402 N MYRTLE SCHOOL RD",
        "APT:7",
        "CITY:GASTONIA",
        "X:TWIN AVE / OLIVER ST",
        "PHONE:(704) 915-6651",
        "MAP:GF1A-1GR1",
        "ID:9896",
        "CALL:Fire-Apartment",
        "PRI:1",
        "NAME:DAVIS, SAMANTHAT",
        "DATE:06/09/2012",
        "TIME:14:26:28",
        "UNIT:RS1, LD61, BC1, EN8, LD3, EN2",
        "INFO:HEARD A POPPING NOISE / POSS WIRES BURNING / SMELL OF SMOKE");

    doTest("T13",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Sunday, June 10, 2012 5:03:55 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~S ~USHY~321/~S ~EXIT HARDIN\n" +
        "Common Name:~321 S EXIT HARDIN\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Phone:~(910) 315-8582\n" +
        "Station:~Station 21\n" +
        "Quadrant:~21E\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~10601\n" +
        "Call Type:~ Veh Acc-PD\n" +
        "Source:~Phone\n" +
        "Priority:~ 2\n" +
        "Status:~Just Occurred\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~TODD,~JENNIFER\n" +
        "Call Date/Time:~06/10/2012 04:54:37\n" +
        "Dispatch Date/Time:~06/10/2012 04:59:35\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000204~~AG Center Fire Dept.\n" +
        "2012-00001368~~Gaston Co. 9-1-1\n" +
        "2012-00000108~~High Shoals Fire Dept.\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "NCSHP, EN610, EN211~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/10/12 04:56:34~HIT AN ANIMAL/FLUIDS LEAKING FROM THE VEHICLE\n" +
        "06/10/12 04:56:45~CHEV COLBOLT\n" +
        "06/10/12 04:58:42~ALSO SENDING THE FD\n" +
        "06/10/12 04:59:40~PINNING SHP\n" +
        "06/10/12 05:02:25~2105 ENORUTE TO THE STATION\n" +
        "06/10/12 05:03:11~AUTH 2100 ALSO DISPATCH STA 61",

        "ADDR:S  USHY 321 & S  EXIT HARDIN",
        "MADDR:S  US 321 & S  EXIT HARDIN",
        "PLACE:321 S EXIT HARDIN",
        "PHONE:(910) 315-8582",
        "MAP:21E-1DR3",
        "ID:10601",
        "CALL:Veh Acc-PD",
        "PRI:2",
        "NAME:TODD, JENNIFER",
        "DATE:06/10/2012",
        "TIME:04:59:35",
        "UNIT:NCSHP, EN610, EN211",
        "INFO:HIT AN ANIMAL/FLUIDS LEAKING FROM THE VEHICLE / CHEV COLBOLT / ALSO SENDING THE FD / PINNING SHP / 2105 ENORUTE TO THE STATION / AUTH 2100 ALSO DISPATCH STA 61");

    doTest("T14",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Sunday, June 10, 2012 12:28:39 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~BESS TOWN~RD/~RAINBOW END~LN\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Phone:~(704) 691-5713\n" +
        "Station:~Station 70 North\n" +
        "Quadrant:~61D\n" +
        "District:~3CM1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~10847\n" +
        "Call Type:~ Tree In Roadway\n" +
        "Source:~911 Call\n" +
        "Priority:~ 4\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~VERIZON WIRELESS\n" +
        "Call Date/Time:~06/10/2012 12:23:22\n" +
        "Dispatch Date/Time:~06/10/2012 12:28:35\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000205~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/10/12 12:26:32~TREE ACROSS THE ROADWAY\n" +
        "06/10/12 12:27:54~BETWEEN\n" +
        "06/10/12 12:28:13~ON BESS TOWN RD BEFORE YOU GET TO RAINBOW END LN AS YOU ARE COMING FROM ABEL RD",

        "ADDR:BESS TOWN RD & RAINBOW END LN",
        "PHONE:(704) 691-5713",
        "MAP:61D-3CM1",
        "ID:10847",
        "CALL:Tree In Roadway",
        "PRI:4",
        "NAME:VERIZON WIRELESS",
        "DATE:06/10/2012",
        "TIME:12:28:35",
        "UNIT:EN611",
        "INFO:TREE ACROSS THE ROADWAY / BETWEEN / ON BESS TOWN RD BEFORE YOU GET TO RAINBOW END LN AS YOU ARE COMING FROM ABEL RD");

    doTest("T15",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Monday, June 11, 2012 2:33:20 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~GASTONIA DALLAS~HWY/~C GRIER BEAM~BLVD\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61H\n" +
        "District:~1DR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~11948\n" +
        "Call Type:~ 29B4\n" +
        "Source:~Phone\n" +
        "Priority:~ 3\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 15 Call Taking\n" +
        "Caller:~Dallas,~Sarah\n" +
        "Call Date/Time:~06/11/2012 14:31:06\n" +
        "Dispatch Date/Time:~06/11/2012 14:33:15\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000206~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/11/12 14:32:06~SB lane between Dallas Cherry exit and C Grier Beam\n" +
        "06/11/12 14:32:21~Sarah in Dallas is notifing SHP but wishes to send EMS\n" +
        "06/11/12 14:32:23~New ProQA Case Number has been assigned: 4995981\n" +
        "06/11/12 14:32:42~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B04; Response Text: Bravo\n" +
        "06/11/12 14:32:42~Patient Info: 1 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;\n" +
        "06/11/12 14:32:42~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Traffic / Transportation Incidents.  Unknown status/Other codes not applicable.  1.The incident involves multiple vehicles.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/11/12 14:32:47~ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29B04; Response Text: Bravo\n" +
        "06/11/12 14:32:47~Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Traffic / Transportation Incidents.  Unknown status/Other codes not applicable.  1.The incident involves multiple vehicles.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding.\n" +
        "06/11/12 14:32:47~Patient Info: 1 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;",

        "ADDR:GASTONIA DALLAS HWY & C GRIER BEAM BLVD",  // Not mapping
        "X:Station: Station 61",
        "MAP:61H-1DR1",
        "ID:11948",
        "CALL:29B4",
        "PRI:3",
        "NAME:Dallas, Sarah",
        "DATE:06/11/2012",
        "TIME:14:33:15",
        "UNIT:EN611",
        "INFO:SB lane between Dallas Cherry exit and C Grier Beam / Sarah in Dallas is notifing SHP but wishes to send EMS / New ProQA Case Number has been assigned: 4995981 / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B04; Response Text: Bravo / Patient Info: 1 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown; / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Traffic / Transportation Incidents.  Unknown status/Other codes not applicable.  1.The incident involves multiple vehicles.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding. / ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29B04; Response Text: Bravo / Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.  Traffic / Transportation Incidents.  Unknown status/Other codes not applicable.  1.The incident involves multiple vehicles.  2.It's not known if chemicals or other hazards are involved.  3.It's not known if anyone is pinned.  4.It's not known if anyone was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of their injuries are not known.  7.It's not known if there is SERIOUS bleeding. / Patient Info: 1 patient(s); Unknown Range old; Unknown; Conscious: Unknown; Breathing: Unknown;");

    doTest("T16",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Tuesday, June 12, 2012 6:33:30 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~STIWALT FARM~RD/~PUETTS CHAPEL~RD\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61E\n" +
        "District:~3CM2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~13261\n" +
        "Call Type:~ 8C\n" +
        "Source:~Phone\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 6 Fire/EMS Backup\n" +
        "Caller:~JOYCE\n" +
        "Call Date/Time:~06/12/2012 18:27:18\n" +
        "Dispatch Date/Time:~06/12/2012 18:29:36\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/12/2012 18:30:03\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000207~~AG Center Fire Dept.\n" +
        "2012-00011774~~Gaston Emergency Medical Services\n" +
        "2012-00015691~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "EN611, E22P, D144~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/12/12 18:27:53~PT IN RED TOYOTA COROLLA\n" +
        "06/12/12 18:28:13~CALLED IN BY POISON CONTROL CENTER, REF A CALL THEY RECEIVED\n" +
        "06/12/12 18:28:52~SOMEONE SPRAYED RAID ANT AND ROACH KILLER INSIDE CAR, FEMALE DROVE ABOUT 45 MIN, NOW FEELS DIZZY AND SICK\n" +
        "06/12/12 18:29:01~New ProQA Case Number has been assigned: 4997294\n" +
        "06/12/12 18:29:09~ALSO HAVING ABNORMAL VISION\n" +
        "06/12/12 18:30:32~19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISON .  1.This is a Poison Control request for response.  2.She is not violent.  3.It's not known if she is changing color.  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She has taken something unlisted in ProQA: ANT / ROACH SPRAY INGESTED  7.She took it 30 mins. to 2hrs ago.  -Comments: ANT / ROACH SPRAY INGESTED-\n" +
        "06/12/12 18:30:32~Problem: POISON .  Patient Info: 1 patient(s); 19 Years old; Female; Conscious: Yes; Breathing: Yes;\n" +
        "06/12/12 18:30:32~ProQA Dispatch Message Sent; Chief Complaint Number: 23; Dispatch Level: 23C08; Response Text: Charlie\n" +
        "06/12/12 18:30:42~Problem: POISON .  Patient Info: 1 patient(s); 19 Years old; Female; Conscious: Yes; Breathing: Yes;\n" +
        "06/12/12 18:30:42~19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISON .  1.This is a Poison Control request for response.  2.She is not violent.  3.It's not known if she is changing color.  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She has taken something unlisted in ProQA: ANT / ROACH SPRAY INGESTED  7.She took it 30 mins. to 2hrs ago.  -Comments: ANT / ROACH SPRAY INGESTED-\n" +
        "06/12/12 18:30:42~ProQA Questionnaire Completed; Chief Complaint Number: 23; Dispatch Level: 23C08; Response Text: Charlie\n" +
        "06/12/12 18:31:00~PT PHONE NUMBER 520 240 1988\n" +
        "06/12/12 18:31:21~PT PAOLA PARRA\n" +
        "06/12/12 18:32:40~An Error occurred in ProQA; Chief Complaint Number: 23 - CASE ALREADY ON FILE.\n" +
        "06/12/12 18:32:40~19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISO.\n" +
        "06/12/12 18:32:52~ProQA Questionnaire Completed; Chief Complaint Number: 23 - CASE ALREADY ON FILE.\n" +
        "06/12/12 18:32:52~19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISO.",

        "ADDR:STIWALT FARM RD & PUETTS CHAPEL RD",
        "X:Station: Station 61",
        "MAP:61E-3CM2",
        "ID:13261",
        "CALL:8C",
        "PRI:1",
        "NAME:JOYCE",
        "DATE:06/12/2012",
        "TIME:18:29:36",
        "UNIT:EN611, E22P, D144",
        "INFO:PT IN RED TOYOTA COROLLA / CALLED IN BY POISON CONTROL CENTER, REF A CALL THEY RECEIVED / SOMEONE SPRAYED RAID ANT AND ROACH KILLER INSIDE CAR, FEMALE DROVE ABOUT 45 MIN, NOW FEELS DIZZY AND SICK / New ProQA Case Number has been assigned: 4997294 / ALSO HAVING ABNORMAL VISION / 19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISON .  1.This is a Poison Control request for response.  2.She is not violent.  3.It's not known if she is changing color.  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She has taken something unlisted in ProQA: ANT / ROACH SPRAY INGESTED  7.She took it 30 mins. to 2hrs ago.  -Comments: ANT / ROACH SPRAY INGESTED- / Problem: POISON .  Patient Info: 1 patient(s); 19 Years old; Female; Conscious: Yes; Breathing: Yes; / ProQA Dispatch Message Sent; Chief Complaint Number: 23; Dispatch Level: 23C08; Response Text: Charlie / Problem: POISON .  Patient Info: 1 patient(s); 19 Years old; Female; Conscious: Yes; Breathing: Yes; / 19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISON .  1.This is a Poison Control request for response.  2.She is not violent.  3.It's not known if she is changing color.  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She has taken something unlisted in ProQA: ANT / ROACH SPRAY INGESTED  7.She took it 30 mins. to 2hrs ago.  -Comments: ANT / ROACH SPRAY INGESTED- / ProQA Questionnaire Completed; Chief Complaint Number: 23; Dispatch Level: 23C08; Response Text: Charlie / PT PHONE NUMBER 520 240 1988 / PT PAOLA PARRA / An Error occurred in ProQA; Chief Complaint Number: 23 - CASE ALREADY ON FILE. / 19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISO. / ProQA Questionnaire Completed; Chief Complaint Number: 23 - CASE ALREADY ON FILE. / 19 year old, Female, Conscious, Breathing.  Overdose / Poisoning (Ingestion).  Poison Control request for response.  Caller Statement: POISO.");

    doTest("T17",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Tuesday, June 12, 2012 7:42:50 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~N ~USHY~321/~HARDIN~RD\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Station:~Station 21\n" +
        "Quadrant:~61F\n" +
        "District:~1DR2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~13308\n" +
        "Call Type:~ Fire-Vehicle\n" +
        "Source:~Phone\n" +
        "Priority:~ 2\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~cc\n" +
        "Call Date/Time:~06/12/2012 19:39:45\n" +
        "Dispatch Date/Time:~06/12/2012 19:42:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000208~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/12/12 19:41:15~red dodoige truck smoking on side of roadway caller didn't setop will be before hardin rd about 1/2 a mile",

        "ADDR:N  USHY 321 & HARDIN RD",
        "MADDR:N  US 321 & HARDIN RD",
        "X:Station: Station 21",
        "MAP:61F-1DR2",
        "ID:13308",
        "CALL:Fire-Vehicle",
        "PRI:2",
        "NAME:cc",
        "DATE:06/12/2012",
        "TIME:19:42:46",
        "UNIT:EN611",
        "INFO:red dodoige truck smoking on side of roadway caller didn't setop will be before hardin rd about 1/2 a mile");

    doTest("T18",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Thursday, June 14, 2012 1:48:48 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~5005~SHEPHERDS WAY~DR~\n" +
        "Common Name:~ROBIN JOHNSON HOSPICE\n" +
        "Venue:~DALLAS\n" +
        "Cross Streets~\n" +
        "MEADOW WAY DR / DEAD END\n" +
        "Station:~Station 63\n" +
        "Quadrant:~63A\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~15117\n" +
        "Call Type:~ Alarm-Fire (High Risk)\n" +
        "Source:~Phone\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 2 County Police 2\n" +
        "Caller:~CENTRAL,~SEC\n" +
        "Call Date/Time:~06/14/2012 13:47:13\n" +
        "Dispatch Date/Time:~06/14/2012 13:48:10\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000209~~AG Center Fire Dept.\n" +
        "2012-00000125~~Dallas Fire Dept.\n" +
        "2012-00000283~~Ranlo Fire Dept.\n" +
        "2012-00015869~~Rescue Squads Gaston Co\n" +
        "2012-00000135~~Spencer Mt Fire Dept.\n" +
        "~\n" +
        "Units Sent:~6\n" +
        "EN631, EN630, LD61, EN194, EN183, CM121~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/14/12 13:47:33~GENERAL FIRE ALARM\n" +
        "06/14/12 13:47:39~704 922 4211",

        "ADDR:5005 SHEPHERDS WAY DR",  // Not mapping
        "PLACE:ROBIN JOHNSON HOSPICE",
        "CITY:DALLAS",
        "X:MEADOW WAY DR / DEAD END",
        "MAP:63A-1DR3",
        "ID:15117",
        "CALL:Alarm-Fire (High Risk)",
        "PRI:1",
        "NAME:CENTRAL, SEC",
        "DATE:06/14/2012",
        "TIME:13:48:10",
        "UNIT:EN631, EN630, LD61, EN194, EN183, CM121",
        "INFO:GENERAL FIRE ALARM / 704 922 4211");

    doTest("T19",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Monday, June 18, 2012 3:22:51 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~221~N ~LINCOLN~ST~\n" +
        "Venue:~HIGH SHOALS\n" +
        "Cross Streets~\n" +
        "MIDWAY ALY / 4TH ST\n" +
        "Phone:~(704) 964-7503\n" +
        "Station:~Station 21\n" +
        "Quadrant:~21D\n" +
        "District:~1DR2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~18884\n" +
        "Call Type:~ Fire-House\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 2 County Police 2\n" +
        "Caller:~reeves,~mary\n" +
        "Call Date/Time:~06/18/2012 03:21:59\n" +
        "Dispatch Date/Time:~06/18/2012 03:22:43\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000210~~AG Center Fire Dept.\n" +
        "2012-00000115~~High Shoals Fire Dept.\n" +
        "2012-00000138~~Spencer Mt Fire Dept.\n" +
        "~\n" +
        "Units Sent:~4\n" +
        "RS619, EN212, EN183, TA213~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/18/12 03:22:37~rp adv the house is on fire",

        "ADDR:221 N  LINCOLN ST",
        "CITY:HIGH SHOALS",
        "X:MIDWAY ALY / 4TH ST",
        "PHONE:(704) 964-7503",
        "MAP:21D-1DR2",
        "ID:18884",
        "CALL:Fire-House",
        "PRI:1",
        "NAME:reeves, mary",
        "DATE:06/18/2012",
        "TIME:03:22:43",
        "UNIT:RS619, EN212, EN183, TA213",
        "INFO:rp adv the house is on fire");

    doTest("T20",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Tuesday, June 19, 2012 4:28:22 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~9412~S~USHY~321~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "CLONINGER RD / S ONRAMP HARDIN\n" +
        "Phone:~(443) 848-6383\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61F\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~20004\n" +
        "Call Type:~ Fire-Vehicle\n" +
        "Source:~911 Call\n" +
        "Priority:~ 2\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 6 Fire/EMS Backup\n" +
        "Caller:~VERIZON WIRELESS\n" +
        "Call Date/Time:~06/19/2012 04:26:48\n" +
        "Dispatch Date/Time:~06/19/2012 04:28:19\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000211~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "RS619, CAR61, EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/19/12 04:27:01~in the area of hardin rd\n" +
        "06/19/12 04:27:10~saw sparkes from vehilce\n" +
        "06/19/12 04:27:20~smells somthing like burning oil\n" +
        "06/19/12 04:28:17~hyundai  red in color",

        "ADDR:9412 S USHY 321",
        "MADDR:9412 S US 321",
        "X:CLONINGER RD / S ONRAMP HARDIN",
        "PHONE:(443) 848-6383",
        "MAP:61F-1DR3",
        "ID:20004",
        "CALL:Fire-Vehicle",
        "PRI:2",
        "NAME:VERIZON WIRELESS",
        "DATE:06/19/2012",
        "TIME:04:28:19",
        "UNIT:RS619, CAR61, EN611",
        "INFO:in the area of hardin rd / saw sparkes from vehilce / smells somthing like burning oil / hyundai  red in color");

    doTest("T21",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Wednesday, June 20, 2012 5:31:15 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~1437~DALLAS CHERRYVILLE~HWY~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "NONAME 27 RD / DALLAS BESSEMER CITY HWY\n" +
        " EDEN GLEN DR\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61A\n" +
        "District:~1DR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~21810\n" +
        "Call Type:~ Veh Acc-PI\n" +
        "Source:~Field Initiated\n" +
        "Priority:~ 1\n" +
        "Status:~Just Occurred\n" +
        "Assigned To:~Position 7 EMS\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/20/2012 17:30:55\n" +
        "Dispatch Date/Time:~06/20/2012 17:30:55\n" +
        "Arrive Date/Time:~06/20/2012 17:30:55\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000212~~AG Center Fire Dept.\n" +
        "2012-00016497~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~4\n" +
        "RS619, CAR61, EN611, D144~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/20/12 17:31:04~contacting shp\n" +
        "06/20/12 17:31:07~D144 ON SCENE WITH F150\n" +
        "06/20/12 17:31:09~Sending note to SHP",

        "ADDR:1437 DALLAS CHERRYVILLE HWY",
        "X:NONAME 27 RD / DALLAS BESSEMER CITY HWY",
        "MAP:61A-1DR1",
        "ID:21810",
        "CALL:Veh Acc-PI",
        "PRI:1",
        "DATE:06/20/2012",
        "TIME:17:30:55",
        "UNIT:RS619, CAR61, EN611, D144",
        "INFO:contacting shp / D144 ON SCENE WITH F150 / Sending note to SHP");

    doTest("T22",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Wednesday, June 20, 2012 5:36:34 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~1437~E ~MAIN~ST~\n" +
        "Venue:~CHERRYVILLE\n" +
        "Cross Streets~\n" +
        "CRESENT LN / DALLAS CHERRYVILLE HWY\n" +
        " DICK BEAM RD\n" +
        "Station:~Station 73\n" +
        "Quadrant:~73D\n" +
        "District:~6CR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~21810\n" +
        "Call Type:~ 29A1\n" +
        "Source:~Field Initiated\n" +
        "Priority:~ 7\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 7 EMS\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/20/2012 17:30:55\n" +
        "Dispatch Date/Time:~06/20/2012 17:30:55\n" +
        "Arrive Date/Time:~06/20/2012 17:30:55\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/20/2012 17:34:01\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000212~~AG Center Fire Dept.\n" +
        "2012-00000424~~Cherryville Fire Dept.\n" +
        "2012-00000129~~Dallas Fire Dept.\n" +
        "2012-00001446~~Gaston Co. 9-1-1\n" +
        "2012-00016497~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~7\n" +
        "NCSHP, RS619, EN730, EN630, CAR61, EN611, D144~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/20/12 17:31:04~contacting shp\n" +
        "06/20/12 17:31:07~D144 ON SCENE WITH F150\n" +
        "06/20/12 17:31:09~Sending note to SHP\n" +
        "06/20/12 17:32:08~shp direct\n" +
        "06/20/12 17:32:52~New ProQA Case Number has been assigned: 5005820\n" +
        "06/20/12 17:32:59~ProQA Questionnaire Aborted - send\n" +
        "06/20/12 17:33:03~ONE MALE PATIENT CONSCIOUS ALERT OREIENTED CAR IS OFF THE RD PATIENT REFUSING\n" +
        "06/20/12 17:33:15~ALL UNITS DISREGARD\n" +
        "06/20/12 17:34:20~NO LINES DOWN POLES BROKEN IN HALF CHERRYVILLE PD ON SCENE\n" +
        "06/20/12 17:34:46~CHEERYVILE LIGHTS ENROUTE TO FIX POLE\n" +
        "06/20/12 17:34:57~CHERRYVILLE POLICE ONSCENE",

        "ADDR:1437 E  MAIN ST",
        "CITY:CHERRYVILLE",
        "X:CRESENT LN / DALLAS CHERRYVILLE HWY",
        "MAP:73D-6CR1",
        "ID:21810",
        "CALL:29A1",
        "PRI:7",
        "DATE:06/20/2012",
        "TIME:17:30:55",
        "UNIT:NCSHP, RS619, EN730, EN630, CAR61, EN611, D144",
        "INFO:contacting shp / D144 ON SCENE WITH F150 / Sending note to SHP / shp direct / New ProQA Case Number has been assigned: 5005820 / ProQA Questionnaire Aborted - send / ONE MALE PATIENT CONSCIOUS ALERT OREIENTED CAR IS OFF THE RD PATIENT REFUSING / ALL UNITS DISREGARD / NO LINES DOWN POLES BROKEN IN HALF CHERRYVILLE PD ON SCENE / CHEERYVILE LIGHTS ENROUTE TO FIX POLE / CHERRYVILLE POLICE ONSCENE");

    doTest("T23",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Wednesday, June 20, 2012 8:58:05 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~800~N ~OAKLAND~ST~APT D\n" +
        "Venue:~DALLAS\n" +
        "Cross Streets~\n" +
        "WILLIS ST / PHILADELPHIA CHURCH RD\n" +
        " NONAME 101 RD\n" +
        "Phone:~(704) 675-8269\n" +
        "Station:~Station 63\n" +
        "Quadrant:~63A\n" +
        "District:~1DR2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~21993\n" +
        "Call Type:~ Fire-Apartment\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 3 City/Co Backup\n" +
        "Caller:~GUNTER,~sabrina\n" +
        "Call Date/Time:~06/20/2012 20:55:40\n" +
        "Dispatch Date/Time:~06/20/2012 20:57:37\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000213~~AG Center Fire Dept.\n" +
        "2012-00000131~~Dallas Fire Dept.\n" +
        "2012-00012392~~Gaston Emergency Medical Services\n" +
        "2012-00000302~~Ranlo Fire Dept.\n" +
        "2012-00016523~~Rescue Squads Gaston Co\n" +
        "2012-00000142~~Spencer Mt Fire Dept.\n" +
        "~\n" +
        "Units Sent:~10\n" +
        "E81P, SQ639, EN631, EN630, LD61, EN194, EN183, SRU, E20S, D144~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/20/12 20:56:44~rp adv her air conditioner caught on fire\n" +
        "06/20/12 20:56:49~in apt d\n" +
        "06/20/12 20:57:02~rp and he children are out and her husband went back into the apt\n" +
        "06/20/12 20:56:06~Call #: 21992 - NO ANSWER ON CALL BACK\n" +
        "06/20/12 20:56:51~Call #: 21992 - CALLING DALLAS",

        "ADDR:800 N  OAKLAND ST",
        "APT:D",
        "CITY:DALLAS",
        "X:WILLIS ST / PHILADELPHIA CHURCH RD",
        "PHONE:(704) 675-8269",
        "MAP:63A-1DR2",
        "ID:21993",
        "CALL:Fire-Apartment",
        "PRI:1",
        "NAME:GUNTER, sabrina",
        "DATE:06/20/2012",
        "TIME:20:57:37",
        "UNIT:E81P, SQ639, EN631, EN630, LD61, EN194, EN183, SRU, E20S, D144",
        "INFO:rp adv her air conditioner caught on fire / in apt d / rp and he children are out and her husband went back into the apt / Call #: 21992 - NO ANSWER ON CALL BACK / Call #: 21992 - CALLING DALLAS");

    doTest("T24",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Thursday, June 21, 2012 3:48:40 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~2448~DALLAS CHERRYVILLE~HWY~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "APPLEWOOD RD / OLD NC 277 LOOP RD\n" +
        "Phone:~(704) 308-5352\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61A\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~22843\n" +
        "Call Type:~ 29B4\n" +
        "Source:~911 Call\n" +
        "Priority:~ 3\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 3 City/Co Backup\n" +
        "Caller:~SPRINT NEXTEL - CDMA\n" +
        "Call Date/Time:~06/21/2012 15:45:37\n" +
        "Dispatch Date/Time:~06/21/2012 15:46:09\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/21/2012 15:47:14\n" +
        "Latest Unit Cleared Date/Time:~06/21/2012 15:47:28\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000214~~AG Center Fire Dept.\n" +
        "2012-00001453~~Gaston Co. 9-1-1\n" +
        "2012-00012451~~Gaston Emergency Medical Services\n" +
        "2012-00016601~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~5\n" +
        "NCSHP, RS619, EN611, G153, E11P~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/21/12 15:45:52~New ProQA Case Number has been assigned: 5006853\n" +
        "06/21/12 15:46:16~lady on the ground\n" +
        "06/21/12 15:47:21~shp direct\n" +
        "06/21/12 15:47:48~57 year old, Female, Conscious, Breathing.  Traffic / Transportation Incidents.  Unknown status/Other codes not applicable.  Caller Statement: female on the ground .  1.The incident involves multiple vehicles.  2.It's not known if chemicals or other hazards are involved.  3.There is no one pinned.  4.No one was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of her injuries are not known.  7.There is no bleeding now.\n" +
        "06/21/12 15:47:48~Problem: female on the ground .  Patient Info: 1 patient(s); 57 Years old; Female; Conscious: Yes; Breathing: Yes;\n" +
        "06/21/12 15:47:48~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B04; Response Text: Bravo\n" +
        "06/21/12 15:48:02~car on it's side  other car in the woods\n" +
        "06/21/12 15:48:09~medic on scene",

        "ADDR:2448 DALLAS CHERRYVILLE HWY",
        "X:APPLEWOOD RD / OLD NC 277 LOOP RD",
        "PHONE:(704) 308-5352",
        "MAP:61A-1DR3",
        "ID:22843",
        "CALL:29B4",
        "PRI:3",
        "NAME:SPRINT NEXTEL - CDMA",
        "DATE:06/21/2012",
        "TIME:15:46:09",
        "UNIT:NCSHP, RS619, EN611, G153, E11P",
        "INFO:New ProQA Case Number has been assigned: 5006853 / lady on the ground / shp direct / 57 year old, Female, Conscious, Breathing.  Traffic / Transportation Incidents.  Unknown status/Other codes not applicable.  Caller Statement: female on the ground .  1.The incident involves multiple vehicles.  2.It's not known if chemicals or other hazards are involved.  3.There is no one pinned.  4.No one was thrown from the vehicle.  5.It's not known if everyone is completely awake (alert).  6.The type and nature of her injuries are not known.  7.There is no bleeding now. / Problem: female on the ground .  Patient Info: 1 patient(s); 57 Years old; Female; Conscious: Yes; Breathing: Yes; / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B04; Response Text: Bravo / car on it's side  other car in the woods / medic on scene");

    doTest("T25",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 23, 2012 10:59:52 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~283~MILES~RD~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "SPRINGVIEW DR / DALLAS HIGH SHOALS HWY\n" +
        "Phone:~(704) 678-1714\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61B\n" +
        "District:~1DR3\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~25020\n" +
        "Call Type:~ 29D2P\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 11 Supervisor\n" +
        "Caller:~BONE,~JOSH\n" +
        "Call Date/Time:~06/23/2012 10:56:38\n" +
        "Dispatch Date/Time:~06/23/2012 10:57:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/23/2012 10:58:50\n" +
        "Latest Unit Cleared Date/Time:~06/23/2012 10:58:18\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000215~~AG Center Fire Dept.\n" +
        "2012-00001468~~Gaston Co. 9-1-1\n" +
        "2012-00012580~~Gaston Emergency Medical Services\n" +
        "2012-00016775~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~9\n" +
        "E40A, NCSHP, RS619, CAR61, EN611, D188, D182, RSU, E44P~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/23/12 10:56:55~VEH FLIPPED SEV TIMES\n" +
        "06/23/12 10:57:01~DRIVER OUT OF VEH\n" +
        "06/23/12 10:57:07~New ProQA Case Number has been assigned: 5009029\n" +
        "06/23/12 10:57:41~CALLING SHP\n" +
        "06/23/12 10:58:16~SHP DIRECT\n" +
        "06/23/12 10:58:22~Problem: VEH ACCIDENT.  Patient Info: 1 patient(s); 1 Years old; Male; Conscious: Yes; Breathing: Yes;\n" +
        "06/23/12 10:58:22~1 year old, Male, Conscious, Breathing.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACCIDENT.  1.The incident involves a rollover.\n" +
        "06/23/12 10:58:22~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/23/12 10:59:03~Problem: VEH ACCIDENT.  Patient Info: 1 patient(s); 1 Years old; Male; Conscious: Yes; Breathing: Yes;\n" +
        "06/23/12 10:59:03~ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/23/12 10:59:03~1 year old, Male, Conscious, Breathing.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACCIDENT.  1.The incident involves a rollover.  2.Other hazards specified in comments are present: GAS LEAKING FROM VEH  3.There is no one pinned.  4.No one was thrown from the vehicle.  5.Everyone appears to be completely awake (alert).  6.His injuries are described as other than to a NOT DANGEROUS area.  7.There is no bleeding now.  -Comments: GAS LEAKING FROM VEH-\n" +
        "06/23/12 10:59:23~ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta\n" +
        "06/23/12 10:59:23~1 year old, Male, Conscious, Breathing.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACCIDENT.  1.The incident involves a rollover.  2.Other hazards specified in comments are present: GAS LEAKING FROM VEH  3.There is no one pinned.  4.No one was thrown from the vehicle.  5.Everyone appears to be completely awake (alert).  6.His injuries are described as other than to a NOT DANGEROUS area.  7.There is no bleeding now.  -Comments: GAS LEAKING FROM VEH-\n" +
        "06/23/12 10:59:23~Problem: VEH ACCIDENT.  Patient Info: 1 patient(s); 1 Years old; Male; Conscious: Yes; Breathing: Yes;\n" +
        "06/23/12 10:59:30~POSS LEG INJURY",

        "ADDR:283 MILES RD",
        "X:SPRINGVIEW DR / DALLAS HIGH SHOALS HWY",
        "PHONE:(704) 678-1714",
        "MAP:61B-1DR3",
        "ID:25020",
        "CALL:29D2P",
        "PRI:1",
        "NAME:BONE, JOSH",
        "DATE:06/23/2012",
        "TIME:10:57:46",
        "UNIT:E40A, NCSHP, RS619, CAR61, EN611, D188, D182, RSU, E44P",
        "INFO:VEH FLIPPED SEV TIMES / DRIVER OUT OF VEH / New ProQA Case Number has been assigned: 5009029 / CALLING SHP / SHP DIRECT / Problem: VEH ACCIDENT.  Patient Info: 1 patient(s); 1 Years old; Male; Conscious: Yes; Breathing: Yes; / 1 year old, Male, Conscious, Breathing.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACCIDENT.  1.The incident involves a rollover. / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / Problem: VEH ACCIDENT.  Patient Info: 1 patient(s); 1 Years old; Male; Conscious: Yes; Breathing: Yes; / ProQA Key Questions have been completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / 1 year old, Male, Conscious, Breathing.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACCIDENT.  1.The incident involves a rollover.  2.Other hazards specified in comments are present: GAS LEAKING FROM VEH  3.There is no one pinned.  4.No one was thrown from the vehicle.  5.Everyone appears to be completely awake (alert).  6.His injuries are described as other than to a NOT DANGEROUS area.  7.There is no bleeding now.  -Comments: GAS LEAKING FROM VEH- / ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: p; Response Text: Delta / 1 year old, Male, Conscious, Breathing.  Traffic / Transportation Incidents.  HIGH MECHANISM (k through s)  (Rollovers).  Caller Statement: VEH ACCIDENT.  1.The incident involves a rollover.  2.Other hazards specified in comments are present: GAS LEAKING FROM VEH  3.There is no one pinned.  4.No one was thrown from the vehicle.  5.Everyone appears to be completely awake (alert).  6.His injuries are described as other than to a NOT DANGEROUS area.  7.There is no bleeding now.  -Comments: GAS LEAKING FROM VEH- / Problem: VEH ACCIDENT.  Patient Info: 1 patient(s); 1 Years old; Male; Conscious: Yes; Breathing: Yes; / POSS LEG INJURY");

    doTest("T26",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Saturday, June 23, 2012 3:08:49 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~120~PILOTS RIDGE~DR~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "JOE CLONINGER RD / LANDING CT\n" +
        "Phone:~(704) 813-0137\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61A\n" +
        "District:~1DR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~25286\n" +
        "Call Type:~ 30B\n" +
        "Source:~911 Call\n" +
        "Priority:~ 3\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~laura\n" +
        "Call Date/Time:~06/23/2012 15:05:25\n" +
        "Dispatch Date/Time:~06/23/2012 15:08:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000216~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "RS619~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/23/12 15:05:54~New ProQA Case Number has been assigned: 5009295\n" +
        "06/23/12 15:08:08~ProQA Dispatch Message Sent; Chief Complaint Number: 30; Dispatch Level: 30B01; Response Text: Bravo\n" +
        "06/23/12 15:08:08~Problem: neck injury diving in pool .  Patient Info: 1 patient(s); 50 Years old; Male; Conscious: Yes; Breathing: Yes;\n" +
        "06/23/12 15:08:08~50 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body area.  Caller Statement: neck injury diving in pool .  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the neck.  5.He is not having difficulty breathing.\n" +
        "06/23/12 15:08:23~ProQA Questionnaire Completed; Chief Complaint Number: 30; Dispatch Level: 30B01; Response Text: Bravo\n" +
        "06/23/12 15:08:23~50 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body area.  Caller Statement: neck injury diving in pool .  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the neck.  5.He is not having difficulty breathing.\n" +
        "06/23/12 15:08:23~Problem: neck injury diving in pool .  Patient Info: 1 patient(s); 50 Years old; Male; Conscious: Yes; Breathing: Yes;\n" +
        "06/23/12 15:08:29~backyard at the pool",

        "ADDR:120 PILOTS RIDGE DR",
        "X:JOE CLONINGER RD / LANDING CT",
        "PHONE:(704) 813-0137",
        "MAP:61A-1DR1",
        "ID:25286",
        "CALL:30B",
        "PRI:3",
        "NAME:laura",
        "DATE:06/23/2012",
        "TIME:15:08:46",
        "UNIT:RS619",
        "INFO:New ProQA Case Number has been assigned: 5009295 / ProQA Dispatch Message Sent; Chief Complaint Number: 30; Dispatch Level: 30B01; Response Text: Bravo / Problem: neck injury diving in pool .  Patient Info: 1 patient(s); 50 Years old; Male; Conscious: Yes; Breathing: Yes; / 50 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body area.  Caller Statement: neck injury diving in pool .  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the neck.  5.He is not having difficulty breathing. / ProQA Questionnaire Completed; Chief Complaint Number: 30; Dispatch Level: 30B01; Response Text: Bravo / 50 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body area.  Caller Statement: neck injury diving in pool .  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the neck.  5.He is not having difficulty breathing. / Problem: neck injury diving in pool .  Patient Info: 1 patient(s); 50 Years old; Male; Conscious: Yes; Breathing: Yes; / backyard at the pool");

    doTest("T27",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Sunday, June 24, 2012 2:14:46 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~ANDREW~CIR/~TURNER~RD\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "Station:~Station 32\n" +
        "Quadrant:~32A\n" +
        "District:~4SR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~25991\n" +
        "Call Type:~ Fire-House\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~BRASWELL,~SCOTT\n" +
        "Call Date/Time:~06/24/2012 02:12:48\n" +
        "Dispatch Date/Time:~06/24/2012 02:13:59\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000217~~AG Center Fire Dept.\n" +
        "2012-00000161~~Alexis Fire Dept.\n" +
        "2012-00000226~~Belmont Fire Dept.\n" +
        "2012-00000111~~Cramerton Fire Dept.\n" +
        "2012-00012634~~Gaston Emergency Medical Services\n" +
        "2012-00000199~~Lucia Riverbend Fire Dept.\n" +
        "2012-00016857~~Rescue Squads Gaston Co\n" +
        "2012-00000147~~Spencer Mt Fire Dept.\n" +
        "~\n" +
        "Units Sent:~8\n" +
        "RS619, EN431, EN403, SQ319, SP174, E37P, TA184, TA204~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/24/12 02:13:22~TRAILER ON FIRE\n" +
        "06/24/12 02:13:27~ON ANDREW CIR OFF TURNER RD\n" +
        "06/24/12 02:13:54~SOMEONE LIVES THERE, BUT NOT SURE IF ANYONE IS THERE NOW",

        "ADDR:ANDREW CIR & TURNER RD",
        "X:Station: Station 32",
        "MAP:32A-4SR1",
        "ID:25991",
        "CALL:Fire-House",
        "PRI:1",
        "NAME:BRASWELL, SCOTT",
        "DATE:06/24/2012",
        "TIME:02:13:59",
        "UNIT:RS619, EN431, EN403, SQ319, SP174, E37P, TA184, TA204",
        "INFO:TRAILER ON FIRE / ON ANDREW CIR OFF TURNER RD / SOMEONE LIVES THERE, BUT NOT SURE IF ANYONE IS THERE NOW");

    doTest("T28",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Sunday, June 24, 2012 2:28:33 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~436~ANDREW~CIR~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "KEITH LN / KEITH LN\n" +
        "Station:~Station 32\n" +
        "Quadrant:~32A\n" +
        "District:~4SR1\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~25991\n" +
        "Call Type:~ Fire-House\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 8 City Fire\n" +
        "Caller:~BRASWELL,~SCOTT\n" +
        "Call Date/Time:~06/24/2012 02:12:48\n" +
        "Dispatch Date/Time:~06/24/2012 02:13:59\n" +
        "Arrive Date/Time:~06/24/2012 02:15:49\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/24/2012 02:14:44\n" +
        "Latest Unit Cleared Date/Time:~06/24/2012 02:28:27\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000217~~AG Center Fire Dept.\n" +
        "2012-00000161~~Alexis Fire Dept.\n" +
        "2012-00000226~~Belmont Fire Dept.\n" +
        "2012-00000384~~Community Fire Dept.\n" +
        "2012-00000111~~Cramerton Fire Dept.\n" +
        "2012-00000218~~East Gaston Fire Dept.\n" +
        "2012-00037165~~Gaston Co. Police Dept.\n" +
        "2012-00012634~~Gaston Emergency Medical Services\n" +
        "2012-00000199~~Lucia Riverbend Fire Dept.\n" +
        "2012-00000770~~Mt. Holly Fire Dept.\n" +
        "2012-00016857~~Rescue Squads Gaston Co\n" +
        "2012-00000147~~Spencer Mt Fire Dept.\n" +
        "~\n" +
        "Units Sent:~25\n" +
        "E30A, RS619, SQ309, EN431, EN403, EN34, SQ319, EN303, EN183, SP174, E38P, E37P, 2S3, 2E3, 2C3, 2A3, TA184, TA314, LD31, TA204, EN32, SQ32, TA32, K10, K13~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/24/12 02:13:22~TRAILER ON FIRE\n" +
        "06/24/12 02:13:27~ON ANDREW CIR OFF TURNER RD\n" +
        "06/24/12 02:13:54~SOMEONE LIVES THERE, BUT NOT SURE IF ANYONE IS THERE NOW\n" +
        "06/24/12 02:16:04~fully involved\n" +
        "06/24/12 02:17:10~working trailer fire\n" +
        "06/24/12 02:18:13~power pole of fire on fire on andrew\n" +
        "06/24/12 02:18:36~singlewide mobile home fully involved\n" +
        "06/24/12 02:19:01~witness advised someone by a trailer\n" +
        "06/24/12 02:19:07~3200 on scene...fire command 1\n" +
        "06/24/12 02:19:33~h/m saw a subj 20-30 min ago running twd trailer park\n" +
        "06/24/12 02:19:34~command 1\n" +
        "06/24/12 02:19:39~e30a advd e38p to stage a little back and advise other units enroute ref safety issue with fire on power line..\n" +
        "06/24/12 02:19:58~andrew twd brian twd stowe ln per 2e3\n" +
        "06/24/12 02:20:33~MAKE RIGHT FORK WHEN YOU TURN IN ON ANDREW CIRCLE PER COMMAND\n" +
        "06/24/12 02:21:18~CHARGE SECOND LINE\n" +
        "06/24/12 02:22:52~2s3 checking hailey ln\n" +
        "06/24/12 02:23:17~DIVERT STA 18 UNITS TO RIDGECREST, THEY NEED MORE WATER\n" +
        "06/24/12 02:23:53~NEED DUKE ENERGY ASAP\n" +
        "06/24/12 02:26:27~DUKE POWER DIRECT, WILL CALL BACK W/ ETA\n" +
        "06/24/12 02:26:39~need another fire marshall",

        "ADDR:436 ANDREW CIR",
        "X:KEITH LN / KEITH LN",
        "MAP:32A-4SR1",
        "ID:25991",
        "CALL:Fire-House",
        "PRI:1",
        "NAME:BRASWELL, SCOTT",
        "DATE:06/24/2012",
        "TIME:02:13:59",
        "UNIT:E30A, RS619, SQ309, EN431, EN403, EN34, SQ319, EN303, EN183, SP174, E38P, E37P, 2S3, 2E3, 2C3, 2A3, TA184, TA314, LD31, TA204, EN32, SQ32, TA32, K10, K13",
        "INFO:TRAILER ON FIRE / ON ANDREW CIR OFF TURNER RD / SOMEONE LIVES THERE, BUT NOT SURE IF ANYONE IS THERE NOW / fully involved / working trailer fire / power pole of fire on fire on andrew / singlewide mobile home fully involved / witness advised someone by a trailer / 3200 on scene...fire command 1 / h/m saw a subj 20-30 min ago running twd trailer park / command 1 / e30a advd e38p to stage a little back and advise other units enroute ref safety issue with fire on power line.. / andrew twd brian twd stowe ln per 2e3 / MAKE RIGHT FORK WHEN YOU TURN IN ON ANDREW CIRCLE PER COMMAND / CHARGE SECOND LINE / 2s3 checking hailey ln / DIVERT STA 18 UNITS TO RIDGECREST, THEY NEED MORE WATER / NEED DUKE ENERGY ASAP / DUKE POWER DIRECT, WILL CALL BACK W/ ETA / need another fire marshall");

    doTest("T29",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Sunday, June 24, 2012 10:37:24 AM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~1015~PEGGY~DR~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "UNKNOWN / LUCILLE RD\n" +
        "Phone:~(704) 922-1344\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61D\n" +
        "District:~3CM2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~26194\n" +
        "Call Type:~ Medical - EMERGENCY\n" +
        "Source:~911 Call\n" +
        "Priority:~ 1\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 9 Co Fire\n" +
        "Caller:~brianna\n" +
        "Call Date/Time:~06/24/2012 10:34:46\n" +
        "Dispatch Date/Time:~06/24/2012 10:35:21\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~06/24/2012 10:36:03\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000218~~AG Center Fire Dept.\n" +
        "2012-00012659~~Gaston Emergency Medical Services\n" +
        "2012-00016883~~Rescue Squads Gaston Co\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "EN610, D185, E45P~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/24/12 10:35:12~New ProQA Case Number has been assigned: 5010203\n" +
        "06/24/12 10:35:17~burn\n" +
        "06/24/12 10:35:44~D185 DIRECT\n" +
        "06/24/12 10:35:48~E45P DIRECT",

        "ADDR:1015 PEGGY DR",  // Not mapping
        "X:UNKNOWN / LUCILLE RD",
        "PHONE:(704) 922-1344",
        "MAP:61D-3CM2",
        "ID:26194",
        "CALL:Medical - EMERGENCY",
        "PRI:1",
        "NAME:brianna",
        "DATE:06/24/2012",
        "TIME:10:35:21",
        "UNIT:EN610, D185, E45P",
        "INFO:New ProQA Case Number has been assigned: 5010203 / burn / D185 DIRECT / E45P DIRECT");

    doTest("T30",
        "(FW: Rip and Run Report) \n" +
        "-------------------------------------------\n" +
        "From: sqlinfo@cityofgastonia.com[SMTP:SQLINFO@CITYOFGASTONIA.COM]\n" +
        "Sent: Monday, June 25, 2012 10:43:43 PM\n" +
        "To: NWSAdmin\n" +
        "Subject: Rip and Run Report\n" +
        "Auto forwarded by a Rule\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~200~THORNE~RD~\n" +
        "Venue:~COUNTY\n" +
        "Cross Streets~\n" +
        "PUETTS CHAPEL RD / DEAD END\n" +
        "Station:~Station 61\n" +
        "Quadrant:~61E\n" +
        "District:~3CM2\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~27870\n" +
        "Call Type:~ Illegal Burning\n" +
        "Source:~Phone\n" +
        "Priority:~ 3\n" +
        "Status:~In Progress\n" +
        "Assigned To:~Position 4 City Police 2\n" +
        "Caller:~cc\n" +
        "Call Date/Time:~06/25/2012 22:42:28\n" +
        "Dispatch Date/Time:~06/25/2012 22:43:40\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000219~~AG Center Fire Dept.\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "EN610, EN611~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/25/12 22:43:21~large bonfire, thinks they're burning furniture also, has a strange smell, wants fire dept to check",

        "ADDR:200 THORNE RD",
        "X:PUETTS CHAPEL RD / DEAD END",
        "MAP:61E-3CM2",
        "ID:27870",
        "CALL:Illegal Burning",
        "PRI:3",
        "NAME:cc",
        "DATE:06/25/2012",
        "TIME:22:43:40",
        "UNIT:EN610, EN611",
        "INFO:large bonfire, thinks they're burning furniture also, has a strange smell, wants fire dept to check");
  }
  

  public static void main(String[] args) {
    new NCGastonCountyBParserTest().generateTests("T1");
  }
}
