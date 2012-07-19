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
        "X:No Cross Streets Found",
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
  
  public static void main(String[] args) {
    new NJOceanCountyParserTest().generateTests("T1");
  }
}
