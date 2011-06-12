package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.FieldProgramParser;

/*
Kent County, MD
Contact: Travis Nelson <tnelson5135@gmail.com>
Sender: 911@kentgov.org
System: PSSI

CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1
CT:MVC/PT NOT ALERT W CAMPUS AVE / WASHINGTON AVE  BOX:6001 DUE:E6 R6 A8 PM1-1
CT:CARDIAC ARREST 25129 WYMONT PARK RD  BOX:5005 DUE:A8
CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1
CT:UNCON/SYNCOPAL 818 HIGH ST  BOX:6001 DUE:A8 PM1-1
CT:EMOTIONAL DISORDER 104 VICKERS DR @KENT CO DETENTION CE  BOX:6001 DUE:A81
CT:ALLERGIC REACTION TACO BELL/KFC @709 WASHINGTON AVE  BOX:6001 DUE:A8 PM1-1
CT:MVC RT 213 / RT 291  BOX:6001 DUE:RA8E
CT:MVC MORGNEC RD / TALBOT BLVD  BOX:6001 DUE:E6 A8 PM1-1
CT:STRUCTURE FIRE 408 MORGNEC RD APT 103  BOX:6001 DUE:E6 E4 QAE71 QAE52 TWR6 QATWL5 R6 RP4 A8 A81 PM1-1
CT:CHEST PAIN 11673 KENNEDYVILLE RD  BOX:4002 DUE:E4 A8 PM1-1

*/


public class MDKentCountyParser extends FieldProgramParser {

  public MDKentCountyParser() {
    super("WILLIAMSON COUNTY", "TX",
           "CT:ADDR! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "911@kentgov.org";
  }
}
