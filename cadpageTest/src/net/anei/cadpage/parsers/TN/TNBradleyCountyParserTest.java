package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Bradley County, TN (Cleveland)

Contact: Matt Mundall <ltmatt0014@gmail.com>
Sender: 7774
CLEVELANDTN911 Bradley CO 911:* 5989 Georgetown Rd NW* * * * * * * * Acc Inj* * * * * * * * 08/15/2013 14:41:23 : pos2 : jelawson older lady holding her head now req ems 08/15/2013 14:41:10 : pos2 : jelawson dodge 3500 truck vs nissan car 08/15/2013 14:40:48 : pos2 : jelawson subs exiting veh 08/15/2013 14:40:43 : pos2 : jelawson still in the rd 08/15/2013 14:40:37 : pos2 : jelawson Cross streets: Eureka Rd NW//Stiles Ave NW rear end collison*
CLEVELANDTN911 Bradley CO 911:* 2736 Chatata Valley Rd NE* * * * * * * * Acc Inj* * * * * * * * 08/15/2013 10:35:03 : pos8 : djohnson PAGED EMA 08/15/2013 10:33:03 : pos2 : jelawson Cross streets: Old Bacon Rd NE//Council Rd NE co maintenance tractor vs propane truck they say they are ok but caller isnt sure road is blocked now says minor injs*
CLEVELANDTN911 Bradley CO 911:* 1030 Ellis Dr SE* * * * * * * * Fire Brush* * * * * * * * 08/15/2013 05:38:57 : pos3 : swilliams Looks like the address will be 1031 Ellis 08/15/2013 05:38:34 : pos3 : swilliams Fire is getting bigger and is behind the residence 08/15/2013 05:37:59 : pos3 : swilliams Caller can smell rubber and says the smoke is really drk 08/15/2013 05:37:41 : pos3 : swilliams Cross streets: Blackburn Rd SE//Buchanan Rd SE There is a fire across from 1020 Ellis*
CLEVELANDTN911 Bradley CO 911:* 2667 Old Alabama Rd SW* * * * * * * * Alarm Fire* * * * * * * * 08/14/2013 16:05:03 : pos2 : rdayhuff Cross streets: Tallent Rd SW//Hamilton County showing key pad fire security and communications op/peter 800 852 2902 no ctc with an rp*
CLEVELANDTN911 Bradley CO 911:* 5940 MOUSE CREEK RD NW* * * * * * * Place Comment: Code for gate- 1220 Landmark Comment: code for gate 1220* Acc Inj* * * * * * * * 08/14/2013 11:59:09 : pos8 : jelawson air bag deployed 08/14/2013 11:59:02 : pos8 : jelawson not sure on exact location 08/14/2013 11:58:53 : pos8 : jelawson Cross streets: Shenandoah Ln NW//Singletree Dr NW Landmark: Soccer Field Place Comment: Code for gate- 1220 Landmark Comment: code for gate 1220 08/14/2013 11:57:39 : pos8 : jelawson Lauderdale Memorial Hwy NW//North Mouse Creek Rd older model p/u trailer came off hit b1 and kept going south*
CLEVELANDTN911 Bradley CO 911:* 1800 Spring Place Rd SE* * * * * * * * Acc Inj* * * * * * * * 8/13/2013 18:12:15 : pos1 : bflynn MY CALLER IS CORY 423-790-2233 08/13/2013 18:12:13 : pos2 : wdavis ONSTAR SAYING 4 VEHICLES INVOLVED 8/13/2013 18:12:03 : pos1 : bflynn ONE VEHICLE ON ITS SIDE ... EVERYONE CLEAR FROM THAT VEHICLE 08/13/2013 18:12:01 : pos5 : hallen another caller just a passerby didn¡t stop 4588135 8/13/2013 18:11:33 : pos1 : bflynn EVERYONE ELSE IS CLEAR THE VEHICLE 8/13/2013 18:11:27 : pos1 : bflynn FEMALE IN THE BACK OF THE VEHICLE HAVING WHAT LOOKS TO BE A SEIZURE 8/13/2013 18:11:05 : pos1 : bflynn MY CALLER SAYS HE THINKS SOMEONE IS HAVING A SEIZURE 08/13/2013 18:11:04 : pos5 : hallen go out towards walmart from the spring palce exit 08/13/2013 18:10:50 : pos8 : rdayhuff another caller adv that one veh flipped...802 5909 8/13/2013 18:10:49 : pos1 : bflynn OB SIDE 08/13/2013 18:10:48 : pos5 : hallen one car on its side 08/13/2013 18:10:44 : pos5 : hallen 3-4 cars 08/13/2013 18:10:39 :
CLEVELANDTN911 Bradley CO 911:* 100 20th St SE* * * * * * * * Water Rescue* * * * * * * * 08/13/2013 09:15:38 : pos3 : jelawson veh also died 08/13/2013 09:15:34 : pos3 : jelawson water over her gas pedal 08/13/2013 09:15:25 : pos3 : jelawson 20th St SE//Blue Springs Rd SE car is flooding up midway to door she is still inside*
CLEVELANDTN911 Bradley CO 911:* 1213 10th St NE* * * * * * * * Fire Struct* * * * * * * * 08/15/2013 17:51:48 : pos6 : swestfield they are out of the house now 08/15/2013 17:51:38 : pos6 : swestfield says she doesn¡t know how it started, she was cooking and started smelling something and then found one of the outlets behind the stove on fire but it is out now. 08/15/2013 17:50:56 : pos6 : swestfield Cross streets: HIGH ST NE//LOWERY ST Cross streets: 4th St NE//8th St NE says that she had an electrical fire. is out now. caught the sink on fire. neighbor put it out*

 */

public class TNBradleyCountyParserTest extends BaseParserTest {
  
  public TNBradleyCountyParserTest() {
    setParser(new TNBradleyCountyParser(), "BRADLEY COUNTY", "TN");
  }
  
  @Test
  public void testMattMundall() {

    doTest("T1",
        "CLEVELANDTN911 Bradley CO 911:* 5989 Georgetown Rd NW* * * * * * * * Acc Inj* * * * * * * * 08/15/2013 14:41:23 : pos2 : jelawson older lady holding her head now req ems 08/15/2013 14:41:10 : pos2 : jelawson dodge 3500 truck vs nissan car 08/15/2013 14:40:48 : pos2 : jelawson subs exiting veh 08/15/2013 14:40:43 : pos2 : jelawson still in the rd 08/15/2013 14:40:37 : pos2 : jelawson Cross streets: Eureka Rd NW//Stiles Ave NW rear end collison*",
        "ADDR:5989 Georgetown Rd NW",
        "CALL:Acc Inj",
        "DATE:08/15/2013",
        "TIME:14:41:23",
        "X:Eureka Rd NW / Stiles Ave NW",
        "INFO:older lady holding her head now req ems\ndodge 3500 truck vs nissan car\nsubs exiting veh\nstill in the rd\nrear end collison");

    doTest("T2",
        "CLEVELANDTN911 Bradley CO 911:* 2736 Chatata Valley Rd NE* * * * * * * * Acc Inj* * * * * * * * 08/15/2013 10:35:03 : pos8 : djohnson PAGED EMA 08/15/2013 10:33:03 : pos2 : jelawson Cross streets: Old Bacon Rd NE//Council Rd NE co maintenance tractor vs propane truck they say they are ok but caller isnt sure road is blocked now says minor injs*",
        "ADDR:2736 Chatata Valley Rd NE",
        "CALL:Acc Inj",
        "DATE:08/15/2013",
        "TIME:10:35:03",
        "X:Old Bacon Rd NE / Council Rd NE",
        "INFO:PAGED EMA\nco maintenance tractor vs propane truck they say they are ok but caller isnt sure road is blocked now says minor injs");

    doTest("T3",
        "CLEVELANDTN911 Bradley CO 911:* 1030 Ellis Dr SE* * * * * * * * Fire Brush* * * * * * * * 08/15/2013 05:38:57 : pos3 : swilliams Looks like the address will be 1031 Ellis 08/15/2013 05:38:34 : pos3 : swilliams Fire is getting bigger and is behind the residence 08/15/2013 05:37:59 : pos3 : swilliams Caller can smell rubber and says the smoke is really drk 08/15/2013 05:37:41 : pos3 : swilliams Cross streets: Blackburn Rd SE//Buchanan Rd SE There is a fire across from 1020 Ellis*",
        "ADDR:1030 Ellis Dr SE",
        "CALL:Fire Brush",
        "DATE:08/15/2013",
        "TIME:05:38:57",
        "X:Blackburn Rd SE / Buchanan Rd SE",
        "INFO:Looks like the address will be 1031 Ellis\nFire is getting bigger and is behind the residence\nCaller can smell rubber and says the smoke is really drk\nThere is a fire across from 1020 Ellis");

    doTest("T4",
        "CLEVELANDTN911 Bradley CO 911:* 2667 Old Alabama Rd SW* * * * * * * * Alarm Fire* * * * * * * * 08/14/2013 16:05:03 : pos2 : rdayhuff Cross streets: Tallent Rd SW//Hamilton County showing key pad fire security and communications op/peter 800 852 2902 no ctc with an rp*",
        "ADDR:2667 Old Alabama Rd SW",
        "CALL:Alarm Fire",
        "DATE:08/14/2013",
        "TIME:16:05:03",
        "X:Tallent Rd SW / Hamilton County showing key pad fire security and communications op/peter 800 852 2902 no ctc with an rp");

    doTest("T5",
        "CLEVELANDTN911 Bradley CO 911:* 5940 MOUSE CREEK RD NW* * * * * * * Place Comment: Code for gate- 1220 Landmark Comment: code for gate 1220* Acc Inj* * * * * * * * 08/14/2013 11:59:09 : pos8 : jelawson air bag deployed 08/14/2013 11:59:02 : pos8 : jelawson not sure on exact location 08/14/2013 11:58:53 : pos8 : jelawson Cross streets: Shenandoah Ln NW//Singletree Dr NW Landmark: Soccer Field Place Comment: Code for gate- 1220 Landmark Comment: code for gate 1220 08/14/2013 11:57:39 : pos8 : jelawson Lauderdale Memorial Hwy NW//North Mouse Creek Rd older model p/u trailer came off hit b1 and kept going south*",
        "ADDR:5940 MOUSE CREEK RD NW",
        "INFO:Code for gate- 1220\nair bag deployed\nnot sure on exact location\ncode for gate 1220\nLauderdale Memorial Hwy NW//North Mouse Creek Rd older model p/u trailer came off hit b1 and kept going south",
        "PLACE:Soccer Field",
        "CALL:Acc Inj",
        "DATE:08/14/2013",
        "TIME:11:59:09",
        "X:Shenandoah Ln NW / Singletree Dr NW");

    doTest("T6",
        "CLEVELANDTN911 Bradley CO 911:* 1800 Spring Place Rd SE* * * * * * * * Acc Inj* * * * * * * * 8/13/2013 18:12:15 : pos1 : bflynn MY CALLER IS CORY 423-790-2233 08/13/2013 18:12:13 : pos2 : wdavis ONSTAR SAYING 4 VEHICLES INVOLVED 8/13/2013 18:12:03 : pos1 : bflynn ONE VEHICLE ON ITS SIDE ... EVERYONE CLEAR FROM THAT VEHICLE 08/13/2013 18:12:01 : pos5 : hallen another caller just a passerby didn¡t stop 4588135 8/13/2013 18:11:33 : pos1 : bflynn EVERYONE ELSE IS CLEAR THE VEHICLE 8/13/2013 18:11:27 : pos1 : bflynn FEMALE IN THE BACK OF THE VEHICLE HAVING WHAT LOOKS TO BE A SEIZURE 8/13/2013 18:11:05 : pos1 : bflynn MY CALLER SAYS HE THINKS SOMEONE IS HAVING A SEIZURE 08/13/2013 18:11:04 : pos5 : hallen go out towards walmart from the spring palce exit 08/13/2013 18:10:50 : pos8 : rdayhuff another caller adv that one veh flipped...802 5909 8/13/2013 18:10:49 : pos1 : bflynn OB SIDE 08/13/2013 18:10:48 : pos5 : hallen one car on its side 08/13/2013 18:10:44 : pos5 : hallen 3-4 cars 08/13/2013 18:10:39 :",
        "ADDR:1800 Spring Place Rd SE",
        "CALL:Acc Inj",
        "DATE:8/13/2013",
        "TIME:18:12:15",
        "INFO:MY CALLER IS CORY 423-790-2233\nONSTAR SAYING 4 VEHICLES INVOLVED\nONE VEHICLE ON ITS SIDE ... EVERYONE CLEAR FROM THAT VEHICLE\nanother caller just a passerby didn@t stop 4588135\nEVERYONE ELSE IS CLEAR THE VEHICLE\nFEMALE IN THE BACK OF THE VEHICLE HAVING WHAT LOOKS TO BE A SEIZURE\nMY CALLER SAYS HE THINKS SOMEONE IS HAVING A SEIZURE\ngo out towards walmart from the spring palce exit\nanother caller adv that one veh flipped...802 5909\nOB SIDE\none car on its side\n3-4 cars 08/13/2013 18:10:39 :");

    doTest("T7",
        "CLEVELANDTN911 Bradley CO 911:* 100 20th St SE* * * * * * * * Water Rescue* * * * * * * * 08/13/2013 09:15:38 : pos3 : jelawson veh also died 08/13/2013 09:15:34 : pos3 : jelawson water over her gas pedal 08/13/2013 09:15:25 : pos3 : jelawson 20th St SE//Blue Springs Rd SE car is flooding up midway to door she is still inside*",
        "ADDR:100 20th St SE",
        "CALL:Water Rescue",
        "DATE:08/13/2013",
        "TIME:09:15:38",
        "INFO:veh also died\nwater over her gas pedal\n20th St SE//Blue Springs Rd SE car is flooding up midway to door she is still inside");

    doTest("T8",
        "CLEVELANDTN911 Bradley CO 911:* 1213 10th St NE* * * * * * * * Fire Struct* * * * * * * * 08/15/2013 17:51:48 : pos6 : swestfield they are out of the house now 08/15/2013 17:51:38 : pos6 : swestfield says she doesn¡t know how it started, she was cooking and started smelling something and then found one of the outlets behind the stove on fire but it is out now. 08/15/2013 17:50:56 : pos6 : swestfield Cross streets: HIGH ST NE//LOWERY ST Cross streets: 4th St NE//8th St NE says that she had an electrical fire. is out now. caught the sink on fire. neighbor put it out*",
        "ADDR:1213 10th St NE",
        "CALL:Fire Struct",
        "DATE:08/15/2013",
        "TIME:17:51:48",
        "X:HIGH ST NE / LOWERY ST",
        "INFO:they are out of the house now\nsays she doesn@t know how it started, she was cooking and started smelling something and then found one of the outlets behind the stove on fire but it is out now.\nsays that she had an electrical fire. is out now. caught the sink on fire. neighbor put it out");

  }
  

  public static void main(String[] args) {
    new TNBradleyCountyParserTest().generateTests("T1");
  }
}
