package net.anei.cadpage.parsers;

/*
Northglenn and Comerce City (Adams County), CO
contact: Brad Jones <brad@jones.name>
sender: dispatch@northglennambulance.com
- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/
- part 1 of 1 / RC:Run# 9913/5541 E 67TH AVE//med alarm/Not Available/
- part 1 of 1 / RC:Run# 9911/7373 BIRCH ST///Unconscious / Fainting/
- part 1 of 1 / RC:Run# 10172/8810 E 88TH AVE///Assault/
- part 1 of 1 / RC:Run# 10119/E 60TH AVE & DAHLIA ST//./Unconscious / Fainting/
*/

public class CONorthglennEMSParser extends DispatchProQAParser {
  
  public CONorthglennEMSParser() {
    super("CO", "ADAMS COUNTY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@northglennambulance.com";
  }
}
