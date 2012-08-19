package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJOceanCountyParserTest extends BaseParserTest {
  
  public NJOceanCountyParserTest() {
    setParser(new NJOceanCountyParser(), "OCEAN COUNTY", "NJ");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~33~WOODLAND~RD~\n" +
        "Common Name:~ST BARNABAS CHURCH - BERKELEY @ WOODLAND/CHAIN\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "SYLVAN LAKE BLVD / CHAIN BLVD\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~91096\n" +
        "Call Type:~ Fire Information\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/12/2012 12:56:40\n" +
        "Dispatch Date/Time:~07/12/2012 12:59:49\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17D~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:33 WOODLAND RD",
        "PLACE:ST BARNABAS CHURCH - BERKELEY @ WOODLAND/CHAIN",
        "CITY:Berkeley Township",
        "X:SYLVAN LAKE BLVD / CHAIN BLVD",
        "ID:91096",
        "CALL:Fire Information",
        "PRI:Administrative",
        "DATE:07/12/2012",
        "TIME:12:59:49",
        "UNIT:ST17D");

    doTest("T2",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~445~RT~9~\n" +
        "Common Name:~SHOPRITE - BERKELEY\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "FREDERICK DR / KORMAN RD\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~91184\n" +
        "Call Type:~ Landing Zone\n" +
        "Source:~Telephone\n" +
        "Priority:~ Low\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/12/2012 14:24:12\n" +
        "Dispatch Date/Time:~07/12/2012 14:24:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~07/12/2012 14:34:16\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000186~~Bayville Fire Department\n" +
        "2012-00008054~~Paid ALS\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "MONOC1, F1700~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:445 RT 9",
        "PLACE:SHOPRITE - BERKELEY",
        "CITY:Berkeley Township",
        "X:FREDERICK DR / KORMAN RD",
        "ID:91184",
        "CALL:Landing Zone",
        "PRI:Low",
        "DATE:07/12/2012",
        "TIME:14:24:46",
        "UNIT:MONOC1, F1700");

    doTest("T3",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~33~KORMAN~RD~APT A12\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "ESPLANADE WAY / RT 9\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~91504\n" +
        "Call Type:~ CO Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/12/2012 18:56:54\n" +
        "Dispatch Date/Time:~07/12/2012 18:58:36\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000187~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/12/12 18:58:15~Nature Of Call: NO ONE FEELING ILL WAITING OUTSIDE",

        "SRC:ST17-SQ13",
        "ADDR:33 KORMAN RD",
        "APT:A12",
        "CITY:Berkeley Township",
        "X:ESPLANADE WAY / RT 9",
        "ID:91504",
        "CALL:CO Alarm",
        "PRI:High",
        "DATE:07/12/2012",
        "TIME:18:58:36",
        "UNIT:ST17",
        "INFO:Nature Of Call: NO ONE FEELING ILL WAITING OUTSIDE");

    doTest("T4",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~445~RT~9~\n" +
        "Common Name:~SHOPRITE - BERKELEY\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "FREDERICK DR / KORMAN RD\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92248\n" +
        "Call Type:~ Vehicle Fire\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 14:20:45\n" +
        "Dispatch Date/Time:~07/13/2012 14:21:47\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00001602~~Bayville EMS\n" +
        "2012-00000188~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "ST17, SQ13~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:445 RT 9",
        "PLACE:SHOPRITE - BERKELEY",
        "CITY:Berkeley Township",
        "X:FREDERICK DR / KORMAN RD",
        "ID:92248",
        "CALL:Vehicle Fire",
        "PRI:High",
        "DATE:07/13/2012",
        "TIME:14:21:47",
        "UNIT:ST17, SQ13");

    doTest("T5",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~343~ARLINGTON~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "MARYLAND AVE / DEAD END\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92497\n" +
        "Call Type:~ Gas Leak\n" +
        "Source:~Telephone\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 17:16:32\n" +
        "Dispatch Date/Time:~07/13/2012 17:17:43\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000189~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:343 ARLINGTON AVE",
        "CITY:Berkeley Township",
        "X:MARYLAND AVE / DEAD END",
        "ID:92497",
        "CALL:Gas Leak",
        "PRI:Medium",
        "DATE:07/13/2012",
        "TIME:17:17:43",
        "UNIT:ST17");

    doTest("T6",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~445~RT~9~\n" +
        "Common Name:~SHOPRITE - BERKELEY\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "FREDERICK DR / KORMAN RD\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92561\n" +
        "Call Type:~ Landing Zone\n" +
        "Source:~Telephone\n" +
        "Priority:~ Low\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 18:14:03\n" +
        "Dispatch Date/Time:~07/13/2012 18:14:36\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000190~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:445 RT 9",
        "PLACE:SHOPRITE - BERKELEY",
        "CITY:Berkeley Township",
        "X:FREDERICK DR / KORMAN RD",
        "ID:92561",
        "CALL:Landing Zone",
        "PRI:Low",
        "DATE:07/13/2012",
        "TIME:18:14:36",
        "UNIT:ST17");

    doTest("T7",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~316~BAY~BLVD~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "CROW AVE / ROBIN AVE\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92833\n" +
        "Call Type:~ General Weakness\n" +
        "Source:~911\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 23:16:54\n" +
        "Dispatch Date/Time:~07/13/2012 23:18:20\n" +
        "Arrive Date/Time:~07/13/2012 23:30:08\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~07/13/2012 23:26:31\n" +
        "Latest Unit Cleared Date/Time:~07/13/2012 23:26:34\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00001605~~Bayville EMS\n" +
        "2012-00000191~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "ST17, SQ13, E136~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/13/12 23:17:53~Nature Of Call: 42YOF\n" +
        "07/13/12 23:18:02~CELULITIS IN BOTH LEGS\n" +
        "07/13/12 23:24:15~conf crew",

        "SRC:ST17-SQ13",
        "ADDR:316 BAY BLVD",
        "CITY:Berkeley Township",
        "X:CROW AVE / ROBIN AVE",
        "ID:92833",
        "CALL:General Weakness",
        "PRI:Medium",
        "DATE:07/13/2012",
        "TIME:23:18:20",
        "UNIT:ST17, SQ13, E136",
        "INFO:Nature Of Call: 42YOF / CELULITIS IN BOTH LEGS / conf crew");

    doTest("T8",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~255~CHELSEA~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "CEDARCREST DR / BERKELEY PL\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~93543\n" +
        "Call Type:~ CO Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/14/2012 16:55:39\n" +
        "Dispatch Date/Time:~07/14/2012 16:56:19\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000192~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/14/12 16:56:05~Nature Of Call: CO ALM, EVERYONE GETTING OUT",

        "SRC:ST17-SQ13",
        "ADDR:255 CHELSEA AVE",
        "CITY:Berkeley Township",
        "X:CEDARCREST DR / BERKELEY PL",
        "ID:93543",
        "CALL:CO Alarm",
        "PRI:High",
        "DATE:07/14/2012",
        "TIME:16:56:19",
        "UNIT:ST17",
        "INFO:Nature Of Call: CO ALM, EVERYONE GETTING OUT");

    doTest("T9",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~492~EASTERN~BLVD~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "LATIMER AVE / NOLAN AVE\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94287\n" +
        "Call Type:~ Animal Call\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 11:04:44\n" +
        "Dispatch Date/Time:~07/15/2012 11:09:44\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 11:08:59~Nature Of Call: KITTEN IN TREE / PD REQ FD RESPONE.\n" +
        "07/15/12 11:09:13~CALLED IN BY BERK PD",

        "SRC:ST17-SQ13",
        "ADDR:492 EASTERN BLVD",
        "CITY:Berkeley Township",
        "X:LATIMER AVE / NOLAN AVE",
        "ID:94287",
        "CALL:Animal Call",
        "PRI:Administrative",
        "DATE:07/15/2012",
        "TIME:11:09:44",
        "UNIT:ST17",
        "INFO:Nature Of Call: KITTEN IN TREE / PD REQ FD RESPONE. / CALLED IN BY BERK PD");

    doTest("T10",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~136~CEDAR RUN~RD~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "DEAD END / SAND RD\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94427\n" +
        "Call Type:~ Fire Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 13:34:22\n" +
        "Dispatch Date/Time:~07/15/2012 13:35:37\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000193~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 13:35:22~Nature Of Call: vacant house  third party nothing showing",

        "SRC:ST17-SQ13",
        "ADDR:136 CEDAR RUN RD",
        "CITY:Berkeley Township",
        "X:DEAD END / SAND RD",
        "ID:94427",
        "CALL:Fire Alarm",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:13:35:37",
        "UNIT:ST17",
        "INFO:Nature Of Call: vacant house  third party nothing showing");

    doTest("T11",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~570~EGENOLF~PL~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "No Cross Streets Found\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94774\n" +
        "Call Type:~ Brush Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 19:46:28\n" +
        "Dispatch Date/Time:~07/15/2012 19:47:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000194~~Bayville Fire Department\n" +
        "2012-00001156~~NJ Forest Fire Service\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "ST17, B7~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:570 EGENOLF PL",
        "CITY:Berkeley Township",
        "ID:94774",
        "CALL:Brush Fire",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:19:47:46",
        "UNIT:ST17, B7");

    doTest("T12",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~50~GOOD LUCK~DR~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "BEACH AVE / DORRANCE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94807\n" +
        "Call Type:~ Structure Fire\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 20:26:59\n" +
        "Dispatch Date/Time:~07/15/2012 20:27:43\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00001618~~Bayville EMS\n" +
        "2012-00000195~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "ST17, SQ13~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 20:27:28~Nature Of Call: SMOKE COMING OUT OF HOUSE UNK IF ANYONE IS HOME",

        "SRC:ST17-SQ13",
        "ADDR:50 GOOD LUCK DR",
        "CITY:Berkeley Township",
        "X:BEACH AVE / DORRANCE DR",
        "ID:94807",
        "CALL:Structure Fire",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:20:27:43",
        "UNIT:ST17, SQ13",
        "INFO:Nature Of Call: SMOKE COMING OUT OF HOUSE UNK IF ANYONE IS HOME");

    doTest("T13",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~395~LAKESIDE~BLVD~\n" +
        "Common Name:~Crystal Lake Convalescent Center - Berkeley\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "HAYDEN ST / MONTGOMERY ST\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94871\n" +
        "Call Type:~ Fire Alarm\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 21:23:09\n" +
        "Dispatch Date/Time:~07/15/2012 21:24:10\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000196~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 21:23:59~Nature Of Call: OPER 3684\n" +
        "07/15/12 21:24:05~Nature Of Call: OPER 3684",

        "SRC:ST17-SQ13",
        "ADDR:395 LAKESIDE BLVD",
        "PLACE:Crystal Lake Convalescent Center - Berkeley",
        "CITY:Berkeley Township",
        "X:HAYDEN ST / MONTGOMERY ST",
        "ID:94871",
        "CALL:Fire Alarm",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:21:24:10",
        "UNIT:ST17",
        "INFO:Nature Of Call: OPER 3684 / Nature Of Call: OPER 3684");

    doTest("T14",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~386~VIRGINIA~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "HOOVER AVE / WESTERN BLVD\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94963\n" +
        "Call Type:~ Pole Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 22:57:26\n" +
        "Dispatch Date/Time:~07/15/2012 22:58:35\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000197~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:386 VIRGINIA AVE",
        "CITY:Berkeley Township",
        "X:HOOVER AVE / WESTERN BLVD",
        "ID:94963",
        "CALL:Pole Fire",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:22:58:35",
        "UNIT:ST17");

    doTest("T15",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~18~BUTLER~BLVD~\n" +
        "Common Name:~Tallwoods Care Center - Berkeley @ Butler Blvd\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "LAUREL LN / RT 9\n" +
        " CENTRAL PKWY\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~96448\n" +
        "Call Type:~ Fire Information\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/17/2012 12:22:04\n" +
        "Dispatch Date/Time:~07/17/2012 12:23:19\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17C~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/17/12 12:22:32~Nature Of Call: WORKING ON FIRE SYSTEM\n" +
        "07/17/12 12:23:05~WILL CALL BACK WHEN DONE",

        "SRC:ST17-SQ13",
        "ADDR:18 BUTLER BLVD",
        "PLACE:Tallwoods Care Center - Berkeley @ Butler Blvd",
        "CITY:Berkeley Township",
        "X:LAUREL LN / RT 9",
        "ID:96448",
        "CALL:Fire Information",
        "PRI:Administrative",
        "DATE:07/17/2012",
        "TIME:12:23:19",
        "UNIT:ST17C",
        "INFO:Nature Of Call: WORKING ON FIRE SYSTEM / WILL CALL BACK WHEN DONE");

    doTest("T16",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~120~PATTON~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "MIDLAND AVE / DEAD END\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~96592\n" +
        "Call Type:~ CO Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/17/2012 14:34:14\n" +
        "Dispatch Date/Time:~07/17/2012 14:35:01\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000198~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:120 PATTON AVE",
        "CITY:Berkeley Township",
        "X:MIDLAND AVE / DEAD END",
        "ID:96592",
        "CALL:CO Alarm",
        "PRI:High",
        "DATE:07/17/2012",
        "TIME:14:35:01",
        "UNIT:ST17");

    doTest("T17",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~11~VINE~ST~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "MARICIEL AVE / CENTRAL PKWY\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~97427\n" +
        "Call Type:~ Odor Investigation\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/18/2012 11:00:14\n" +
        "Dispatch Date/Time:~07/18/2012 11:00:57\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000199~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/18/12 11:00:43~Nature Of Call: strong smell of smoke",

        "SRC:ST17-SQ13",
        "ADDR:11 VINE ST",
        "CITY:Berkeley Township",
        "X:MARICIEL AVE / CENTRAL PKWY",
        "ID:97427",
        "CALL:Odor Investigation",
        "PRI:Administrative",
        "DATE:07/18/2012",
        "TIME:11:00:57",
        "UNIT:ST17",
        "INFO:Nature Of Call: strong smell of smoke");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~401~DOVER~RD~\n\n" +
        "Common Name:~SQ37\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "TILTON AVE / YANNETTE RD\n\n" +
        " AMHERST RD\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129474\n\n" +
        "Call Type:~ EMS Information\n\n" +
        "Source:~Telephone\n\n" +
        "Priority:~ Administrative\n\n" +
        "Status:~Not In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 09:10:09\n\n" +
        "Dispatch Date/Time:~08/17/2012 09:11:03\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "~\n\n" +
        "Units Sent:~1\n\n" +
        "SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 09:10:39~Nature Of Call: pager test for both tones\n\n" +
        "08/17/12 09:10:44~asst capt of squad\n\n" +
        "08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:401 DOVER RD",
        "PLACE:SQ37",
        "CITY:South Toms River Boro",
        "X:TILTON AVE / YANNETTE RD",
        "ID:129474",
        "CALL:EMS Information",
        "PRI:Administrative",
        "DATE:08/17/2012",
        "TIME:09:11:03",
        "UNIT:SQ37",
        "INFO:Nature Of Call: pager test for both tones / asst capt of squad / just got 2 pagers back, want to make sure they are working");

    doTest("T2",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~401~DOVER~RD~\n\n" +
        "Common Name:~SQ37\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "TILTON AVE / YANNETTE RD\n\n" +
        " AMHERST RD\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129474\n\n" +
        "Call Type:~ EMS Information\n\n" +
        "Source:~Telephone\n\n" +
        "Priority:~ Administrative\n\n" +
        "Status:~Not In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 09:10:09\n\n" +
        "Dispatch Date/Time:~08/17/2012 09:11:03\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~08/17/2012 09:12:35\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~08/17/2012 09:12:35\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "~\n\n" +
        "Units Sent:~1\n\n" +
        "SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 09:10:39~Nature Of Call: pager test for both tones\n\n" +
        "08/17/12 09:10:44~asst capt of squad\n\n" +
        "08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:401 DOVER RD",
        "PLACE:SQ37",
        "CITY:South Toms River Boro",
        "X:TILTON AVE / YANNETTE RD",
        "ID:129474",
        "CALL:EMS Information",
        "PRI:Administrative",
        "DATE:08/17/2012",
        "TIME:09:11:03",
        "UNIT:SQ37",
        "INFO:Nature Of Call: pager test for both tones / asst capt of squad / just got 2 pagers back, want to make sure they are working");

    doTest("T3",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129743\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 13:26:56\n\n" +
        "Dispatch Date/Time:~08/17/2012 13:30:11\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010722~~Paid ALS\n\n" +
        "2012-00001281~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~2\n\n" +
        "SQ75, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n\n" +
        "08/17/12 13:30:25~sarah",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:130 2ND AVE",
        "CITY:Berkeley Township",
        "ID:129743",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/17/2012",
        "TIME:13:30:11",
        "UNIT:SQ75, SQ37",
        "INFO:Nature Of Call: 19 MONTHS / sarah");

    doTest("T4",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129743\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 13:26:56\n\n" +
        "Dispatch Date/Time:~08/17/2012 13:30:11\n\n" +
        "Arrive Date/Time:~08/17/2012 13:50:57\n\n" +
        "Clear Date/Time:~08/17/2012 14:21:51\n\n" +
        "Enroute Date/Time:~08/17/2012 13:33:35\n\n" +
        "Latest Unit Cleared Date/Time:~08/17/2012 14:21:50\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010722~~Paid ALS\n\n" +
        "2012-00001281~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "E712, SQ75, E378, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n\n" +
        "08/17/12 13:30:25~sarah",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:130 2ND AVE",
        "CITY:Berkeley Township",
        "ID:129743",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/17/2012",
        "TIME:13:30:11",
        "UNIT:E712, SQ75, E378, SQ37",
        "INFO:Nature Of Call: 19 MONTHS / sarah");

    doTest("T5",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130085\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 18:32:23\n\n" +
        "Dispatch Date/Time:~08/17/2012 18:33:14\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010739~~Paid ALS\n\n" +
        "2012-00001282~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~2\n\n" +
        "SQ75, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 18:32:38~Nature Of Call: 19 MOS YOM",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:130 2ND AVE",
        "CITY:Berkeley Township",
        "ID:130085",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/17/2012",
        "TIME:18:33:14",
        "UNIT:SQ75, SQ37",
        "INFO:Nature Of Call: 19 MOS YOM");

    doTest("T6",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130085\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 18:32:23\n\n" +
        "Dispatch Date/Time:~08/17/2012 18:33:14\n\n" +
        "Arrive Date/Time:~08/17/2012 18:44:04\n\n" +
        "Clear Date/Time:~08/17/2012 19:24:43\n\n" +
        "Enroute Date/Time:~08/17/2012 18:42:02\n\n" +
        "Latest Unit Cleared Date/Time:~08/17/2012 19:24:37\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010739~~Paid ALS\n\n" +
        "2012-00001282~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "E712, SQ75, E378, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 18:32:38~Nature Of Call: 19 MOS YOM\n\n" +
        "08/17/12 18:34:09~natalie\n\n" +
        "08/17/12 18:34:57~crosses 5th &amp; 8th st\n\n" +
        "08/17/12 18:36:34~370 conf crew resp to bldg\n\n" +
        "08/17/12 18:36:44~CHILD OUT OF THE SEIZURE JUST CAME HOME FROM THE HOSPITAL FOR THE SAME THING\n\n" +
        "08/17/12 18:36:47~HAS A FEVER\n\n" +
        "08/17/12 18:48:00~712 on loc per mon control",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:130 2ND AVE",
        "CITY:Berkeley Township",
        "ID:130085",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/17/2012",
        "TIME:18:33:14",
        "UNIT:E712, SQ75, E378, SQ37",
        "INFO:Nature Of Call: 19 MOS YOM / natalie / crosses 5th & 8th st / 370 conf crew resp to bldg / CHILD OUT OF THE SEIZURE JUST CAME HOME FROM THE HOSPITAL FOR THE SAME THING / HAS A FEVER / 712 on loc per mon control");

    doTest("T7",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~1~DREW~LN~\n\n" +
        "Common Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "ATTISON AVE / DEAD END\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130645\n\n" +
        "Call Type:~ Special Response\n\n" +
        "Source:~Air\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 09:47:53\n\n" +
        "Dispatch Date/Time:~08/18/2012 09:49:23\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001283~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~1\n\n" +
        "E370~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 09:49:12~Nature Of Call: special assignment",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:1 DREW LN",
        "PLACE:PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN",
        "CITY:South Toms River Boro",
        "X:ATTISON AVE / DEAD END",
        "ID:130645",
        "CALL:Special Response",
        "PRI:Medium",
        "DATE:08/18/2012",
        "TIME:09:49:23",
        "UNIT:E370",
        "INFO:Nature Of Call: special assignment");

    doTest("T8",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~~FAIRWAY~DR/~DOVER~RD\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130769\n\n" +
        "Call Type:~ Suicide Attempt\n\n" +
        "Source:~911\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 12:25:30\n\n" +
        "Dispatch Date/Time:~08/18/2012 12:28:09\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00002735~~South Toms River Police Department\n\n" +
        "~\n\n" +
        "Units Sent:~2\n\n" +
        "SQ37, 29-06~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n\n" +
        "08/18/12 12:26:21~34 yom called cp and said he was ending his life\n\n" +
        "08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n\n" +
        "08/18/12 12:27:45~slurring his words\n\n" +
        "08/18/12 12:28:11~unk how long ago he took them or what they are\n\n" +
        "08/18/12 12:28:14~third party",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:FAIRWAY DR & DOVER RD",
        "CITY:South Toms River Boro",
        "ID:130769",
        "CALL:Suicide Attempt",
        "PRI:Medium",
        "DATE:08/18/2012",
        "TIME:12:28:09",
        "UNIT:SQ37, 29-06",
        "INFO:Nature Of Call: took 20 pills - unkown type / 34 yom called cp and said he was ending his life / natoli - beige house bilevel next to 7-11 / slurring his words / unk how long ago he took them or what they are / third party");

    doTest("T9",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~100~FAIRWAY~DR~\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "DOVER RD / DOUBLE TROUBLE RD\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130769\n\n" +
        "Call Type:~ Suicide Attempt\n\n" +
        "Source:~911\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 12:25:30\n\n" +
        "Dispatch Date/Time:~08/18/2012 12:28:09\n\n" +
        "Arrive Date/Time:~08/18/2012 12:28:49\n\n" +
        "Clear Date/Time:~08/18/2012 13:38:50\n\n" +
        "Enroute Date/Time:~08/18/2012 12:30:21\n\n" +
        "Latest Unit Cleared Date/Time:~08/18/2012 13:38:50\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010795~~Paid ALS\n\n" +
        "2012-00001284~~South Toms River EMS\n\n" +
        "2012-00002735~~South Toms River Police Department\n\n" +
        "~\n\n" +
        "Units Sent:~7\n\n" +
        "E712, SQ75, E378, E370, SQ37, 29-17, 29-06~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n\n" +
        "08/18/12 12:26:21~34 yom called cp and said he was ending his life\n\n" +
        "08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n\n" +
        "08/18/12 12:27:45~slurring his words\n\n" +
        "08/18/12 12:28:11~unk how long ago he took them or what they are\n\n" +
        "08/18/12 12:28:14~third party\n\n" +
        "08/18/12 12:29:01~she stated he was at his residence\n\n" +
        "08/18/12 12:29:33~POSS 101\n\n" +
        "08/18/12 12:30:00~VIC MONOC\n\n" +
        "08/18/12 12:30:51~DOGS IN RESD UNK IF FRIENDLY OR NOT\n\n" +
        "08/18/12 12:32:00~subj concious and alert\n\n" +
        "08/18/12 12:32:21~BRIAN IS A FRIEND WHO LIVES UP THE STREET AND CINDY CALLED HIM AND IS ON HIS WAY TO RESD",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:100 FAIRWAY DR",
        "CITY:South Toms River Boro",
        "X:DOVER RD / DOUBLE TROUBLE RD",
        "ID:130769",
        "CALL:Suicide Attempt",
        "PRI:Medium",
        "DATE:08/18/2012",
        "TIME:12:28:09",
        "UNIT:E712, SQ75, E378, E370, SQ37, 29-17, 29-06",
        "INFO:Nature Of Call: took 20 pills - unkown type / 34 yom called cp and said he was ending his life / natoli - beige house bilevel next to 7-11 / slurring his words / unk how long ago he took them or what they are / third party / she stated he was at his residence / POSS 101 / VIC MONOC / DOGS IN RESD UNK IF FRIENDLY OR NOT / subj concious and alert / BRIAN IS A FRIEND WHO LIVES UP THE STREET AND CINDY CALLED HIM AND IS ON HIS WAY TO RESD");

    doTest("T10",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~1~DREW~LN~\n\n" +
        "Common Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "ATTISON AVE / DEAD END\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130645\n\n" +
        "Call Type:~ Special Response\n\n" +
        "Source:~Air\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 09:47:53\n\n" +
        "Dispatch Date/Time:~08/18/2012 09:49:23\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~08/18/2012 16:08:32\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~08/18/2012 16:08:32\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001283~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "E379, E378, E377, E370~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 09:49:12~Nature Of Call: special assignment",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:1 DREW LN",
        "PLACE:PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN",
        "CITY:South Toms River Boro",
        "X:ATTISON AVE / DEAD END",
        "ID:130645",
        "CALL:Special Response",
        "PRI:Medium",
        "DATE:08/18/2012",
        "TIME:09:49:23",
        "UNIT:E379, E378, E377, E370",
        "INFO:Nature Of Call: special assignment");

    doTest("T11",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~721~MIDLAND~AVE~\n\n" +
        "Common Name:~AMIB Group Home - Pine Beach @ Midland Ave\n\n" +
        "Venue:~Pine Beach Boro\n\n" +
        "Cross Streets~\n\n" +
        "LINDEN AVE / PENNSYLVANIA AVE\n\n" +
        "Quadrant:~ST38\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131775\n\n" +
        "Call Type:~ EMS Call\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:28:48\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:30:14\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001562~~Beachwood EMS\n\n" +
        "2012-00002188~~Pine Beach Police Department\n\n" +
        "2012-00001285~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~3\n\n" +
        "SQ37, SQ15, PNBCPD~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n\n" +
        "08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n\n" +
        "08/19/12 10:30:46~22-08 NOTFD\n\n" +
        "08/19/12 10:35:42~2ND REQUEST SQ37 STARTED",

        "SRC:ST38-SQ15",
        "ADDR:721 MIDLAND AVE",
        "PLACE:AMIB Group Home - Pine Beach @ Midland Ave",
        "CITY:Pine Beach Boro",
        "X:LINDEN AVE / PENNSYLVANIA AVE",
        "ID:131775",
        "CALL:EMS Call",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:10:30:14",
        "UNIT:SQ37, SQ15, PNBCPD",
        "INFO:Nature Of Call: 50 yom swollen hand / Nature Of Call: 50 yom swollen hand unknonw how / 22-08 NOTFD / 2ND REQUEST SQ37 STARTED");

    doTest("T12",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~95~ATLANTIC CITY~BLVD~\n\n" +
        "Common Name:~RITE AID - BEACHWOOD\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "ENSIGN AVE / STARBOARD ST\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131816\n\n" +
        "Call Type:~ Pedestrian Struck\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:55:20\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:56:58\n\n" +
        "Arrive Date/Time:~08/19/2012 10:59:41\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~08/19/2012 10:57:36\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001563~~Beachwood EMS\n\n" +
        "2012-00004629~~Beachwood Police Department\n\n" +
        "2012-00001286~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "4-54, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n\n" +
        "08/19/12 10:57:38~PKING LOT OF RITE AID NOW",

        "SRC:ST16-SQ15",
        "ADDR:95 ATLANTIC CITY BLVD",
        "PLACE:RITE AID - BEACHWOOD",
        "CITY:Beachwood Boro",
        "X:ENSIGN AVE / STARBOARD ST",
        "ID:131816",
        "CALL:Pedestrian Struck",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:10:56:58",
        "UNIT:4-54, SQ37, SQ15, 4-56",
        "INFO:Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND / PKING LOT OF RITE AID NOW");

    doTest("T13",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~95~ATLANTIC CITY~BLVD~\n\n" +
        "Common Name:~RITE AID - BEACHWOOD\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "ENSIGN AVE / STARBOARD ST\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131816\n\n" +
        "Call Type:~ Pedestrian Struck\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:55:20\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:56:58\n\n" +
        "Arrive Date/Time:~08/19/2012 10:59:41\n\n" +
        "Clear Date/Time:~08/19/2012 11:08:08\n\n" +
        "Enroute Date/Time:~08/19/2012 10:57:36\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 11:08:08\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001563~~Beachwood EMS\n\n" +
        "2012-00004629~~Beachwood Police Department\n\n" +
        "2012-00001286~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "4-54, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n\n" +
        "08/19/12 10:57:38~PKING LOT OF RITE AID NOW\n\n" +
        "08/19/12 11:03:18~15 2ND REQUESTING FOR DRIVER AND START MUTUAL AID\n\n" +
        "08/19/12 11:07:17~NO INJ PER PD CANCLE THE RIG",

        "SRC:ST16-SQ15",
        "ADDR:95 ATLANTIC CITY BLVD",
        "PLACE:RITE AID - BEACHWOOD",
        "CITY:Beachwood Boro",
        "X:ENSIGN AVE / STARBOARD ST",
        "ID:131816",
        "CALL:Pedestrian Struck",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:10:56:58",
        "UNIT:4-54, SQ37, SQ15, 4-56",
        "INFO:Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND / PKING LOT OF RITE AID NOW / 15 2ND REQUESTING FOR DRIVER AND START MUTUAL AID / NO INJ PER PD CANCLE THE RIG");

    doTest("T14",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~214~BEACHWOOD~BLVD~\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131830\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 11:08:07\n\n" +
        "Dispatch Date/Time:~08/19/2012 11:09:39\n\n" +
        "Arrive Date/Time:~08/19/2012 11:10:56\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~08/19/2012 11:09:51\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 11:10:27\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001564~~Beachwood EMS\n\n" +
        "2012-00004631~~Beachwood Police Department\n\n" +
        "2012-00010861~~Paid ALS\n\n" +
        "2012-00001287~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~5\n\n" +
        "E712, SQ75, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 11:08:51~Nature Of Call: 38 YOF\n\n" +
        "08/19/12 11:09:54~MONOC-JOHN",

        "SRC:ST16-SQ15",
        "ADDR:214 BEACHWOOD BLVD",
        "CITY:Beachwood Boro",
        "ID:131830",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:11:09:39",
        "UNIT:E712, SQ75, SQ37, SQ15, 4-56",
        "INFO:Nature Of Call: 38 YOF / MONOC-JOHN");

    doTest("T15",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~721~MIDLAND~AVE~\n\n" +
        "Common Name:~AMIB Group Home - Pine Beach @ Midland Ave\n\n" +
        "Venue:~Pine Beach Boro\n\n" +
        "Cross Streets~\n\n" +
        "LINDEN AVE / PENNSYLVANIA AVE\n\n" +
        "Quadrant:~ST38\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131775\n\n" +
        "Call Type:~ EMS Call\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:28:48\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:30:14\n\n" +
        "Arrive Date/Time:~08/19/2012 10:42:55\n\n" +
        "Clear Date/Time:~08/19/2012 12:00:55\n\n" +
        "Enroute Date/Time:~08/19/2012 10:38:13\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 12:00:55\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001562~~Beachwood EMS\n\n" +
        "2012-00001227~~Ocean Gate EMS\n\n" +
        "2012-00002188~~Pine Beach Police Department\n\n" +
        "2012-00001285~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~6\n\n" +
        "22-08, SQ37, SQ31, SQ15, E158, PNBCPD~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n\n" +
        "08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n\n" +
        "08/19/12 10:30:46~22-08 NOTFD\n\n" +
        "08/19/12 10:35:42~2ND REQUEST SQ37 STARTED\n\n" +
        "08/19/12 10:41:24~NO ANSWER FROM 15 OR 37 .37 2ND STARTED 31\n\n" +
        "08/19/12 10:42:48~SQ15 NEEDS A DRIVER OR EMT NEED\n\n" +
        "08/19/12 10:44:59~SQ37 DRIVER HEADING TO BUILDING PER 370\n\n" +
        "08/19/12 10:45:08~SQ31 TOLD TO STAND DOWN",

        "SRC:ST38-SQ15",
        "ADDR:721 MIDLAND AVE",
        "PLACE:AMIB Group Home - Pine Beach @ Midland Ave",
        "CITY:Pine Beach Boro",
        "X:LINDEN AVE / PENNSYLVANIA AVE",
        "ID:131775",
        "CALL:EMS Call",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:10:30:14",
        "UNIT:22-08, SQ37, SQ31, SQ15, E158, PNBCPD",
        "INFO:Nature Of Call: 50 yom swollen hand / Nature Of Call: 50 yom swollen hand unknonw how / 22-08 NOTFD / 2ND REQUEST SQ37 STARTED / NO ANSWER FROM 15 OR 37 .37 2ND STARTED 31 / SQ15 NEEDS A DRIVER OR EMT NEED / SQ37 DRIVER HEADING TO BUILDING PER 370 / SQ31 TOLD TO STAND DOWN");

    doTest("T16",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~214~BEACHWOOD~BLVD~\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131830\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 11:08:07\n\n" +
        "Dispatch Date/Time:~08/19/2012 11:09:39\n\n" +
        "Arrive Date/Time:~08/19/2012 11:10:56\n\n" +
        "Clear Date/Time:~08/19/2012 12:21:50\n\n" +
        "Enroute Date/Time:~08/19/2012 11:09:51\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 12:21:49\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001564~~Beachwood EMS\n\n" +
        "2012-00004631~~Beachwood Police Department\n\n" +
        "2012-00010861~~Paid ALS\n\n" +
        "2012-00001287~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~7\n\n" +
        "4-54, E712, SQ75, E378, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 11:08:51~Nature Of Call: 38 YOF\n\n" +
        "08/19/12 11:09:54~MONOC-JOHN\n\n" +
        "08/19/12 11:12:00~2nd req\n\n" +
        "08/19/12 11:13:14~USE SIDE ENTRANCE",

        "SRC:ST16-SQ15",
        "ADDR:214 BEACHWOOD BLVD",
        "CITY:Beachwood Boro",
        "ID:131830",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:11:09:39",
        "UNIT:4-54, E712, SQ75, E378, SQ37, SQ15, 4-56",
        "INFO:Nature Of Call: 38 YOF / MONOC-JOHN / 2nd req / USE SIDE ENTRANCE");

  }
  
  public static void main(String[] args) {
    new NJOceanCountyParserTest().generateTests("T1");
  }
}
