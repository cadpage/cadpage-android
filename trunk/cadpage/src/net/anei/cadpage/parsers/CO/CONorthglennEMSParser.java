package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
Northglenn and Comerce City (Adams County), CO
contact: Brad Jones <brad@jones.name>
Contact: Carl Nelson <firstdue@gmail.com>
Contact: Alan Mikes <alanmark64@gmail.com>
sender: dispatch@northglennambulance.com

- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/
- part 1 of 1 / RC:Run# 9913/5541 E 67TH AVE//med alarm/Not Available/
- part 1 of 1 / RC:Run# 9911/7373 BIRCH ST///Unconscious / Fainting/
- part 1 of 1 / RC:Run# 10172/8810 E 88TH AVE///Assault/
- part 1 of 1 / RC:Run# 10119/E 60TH AVE & DAHLIA ST//./Unconscious / Fainting/
Subject:- part 1 of 1\nRC:Run# 3769/3015 CALIFORNIA ST//out of control child hit head/Not Known//\n
Subject:- part 1 of 1\nRun# 5678/ 1301 PONTIAC ST/ Fall Victim\n
(- part 1 of 1) RC:Run# 575/5486 RIVERDALE WAY/287//Injured Party//
 - part 1 of 1 / RC:Job# 0028-A/ Run# 7024/ was Canceled: Fire Department Standby/20:11/20:11/20:11/20:15/20:25\n\n

*/

public class CONorthglennEMSParser extends DispatchProQAParser {
  
  public CONorthglennEMSParser() {
    super("ADAMS COUNTY", "CO",
           "ADDR CALL! CALL+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@northglennambulance.com";
  }
}
