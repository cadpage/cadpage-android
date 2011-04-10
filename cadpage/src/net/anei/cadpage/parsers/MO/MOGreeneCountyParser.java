package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/*
Greene County, MO
Contact: Daniel Brant <rdnck41@gmail.com>
Sender: grnpage@springfieldmo.gov <From%3Agrnpage@springfieldmo.gov>

TYP: RESIDENTIAL FIRE AD: 500 S VENTURA AVE CTY: REPUBLIC MAP: U-8 CN: JOE SNYDER CMT1: * * * CLONE STRUCTURE FIRES TO GF/FHOUSE-FBLDG/BF10/ CMT:AUTO_AID * * * TIME: 22:21 UNTS: RF/BRUSH1 XST: 598 S FOREST LN XST2: 600 W ONEAL RD
TYP: MEDICAL AD: 1013 E US60 EAST CTY: REPUBLIC MAP: T-9 LOC: PRICE CUTTER CMT1: * * * CLONE STRUCTURE FIRES TO GF/ FHOUSE-FBLDG/BF10/CMT:AUTO_AID * * * CMT2: PERSON FELL OFF BICYCLE -ELDERLY TIME: 19:12 UNTS: RF/ST1

 */


public class MOGreeneCountyParser extends DispatchPrintrakParser {
  
  public MOGreeneCountyParser() {
    super("GREENE COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "grnpage@springfieldmo.gov";
  }
}
