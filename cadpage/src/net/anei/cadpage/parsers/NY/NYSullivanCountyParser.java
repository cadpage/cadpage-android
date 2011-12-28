package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Sullivan County, NY
Contact: Daniel Buschmann <wr63hiway@gmail.com>, la41hiway@yahoo.com, 631-484-5655
Sender: 911@co.sullivan.ny.us <From%3A911@co.sullivan.ny.us>

(911 Page) 09:33 Type: E-26A Sick Person Loc: 25 CARRIER X: No Cross Streets Found V: V/Liberty CN:
(911 Page) 06:53 Type: E-13A Diabetic Problem Loc: 159 N MAIN X: No Cross Streets Found V: V/Liberty CN:
(911 Page) 09;17 Type: E-29B MVA Loc:STHY 52 X: HYSANA RD V: LIBERTY CN:
(911 Page) 13:25 Type: E-6D Breathing Problem Loc: 124 Hunter Lake Dr X: Dead End/ Lily Pond Rd, Hunter Lake Rd V: Rockland CN:
(911 Page) 10:20 Type: E-17A Fall Victim Loc: 27 ACADEMY ST X: CHESTNUT ST / ST PAULS PL V: V/Liberty CN:
(911 Page) 10:03 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 09:31 Type: E-33A Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 09:18 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 13:49 Type: E-10D Chest Pain Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 13:38 Type: E-21B Hemorrhage/Laceration Loc: 36 S MAIN ST X: JOHN ST / DARBEE LN, N MAIN ST, CHESTNUT ST V: V/Liberty CN:
(911 Page) 12:35 Type: E- 6D Breathing Problem Loc: 256 SUNSET LAKE RD X: COMMUNITY LN / AIRPORT RD V: Liberty CN:
(911 Page) 10:20 Type: E-17A Fall Victim Loc: 27 ACADEMY ST X: CHESTNUT ST / ST PAULS PL V: V/Liberty CN:
(911 Page) 03:34 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 22:55 Type: E-33C Transfer/Interfacility Loc: 256 SUNSET LAKE RD X: COMMUNITY LN / AIRPORT RD V: Liberty CN:
(911 Page) 20:27 Type: E- 1C Abdominal Pain Loc: 358 E BROADWAY X: RICHARDSON AV / SPRING ST V: V/Monticello CN:

Contact: Crystal Bianucci <darktree84@gmail.com> 
(911 Page) 19:24 Type: F-Activated Alarm Loc: 22 SAINT JOHN ST X: No Cross Streets Found V: V/Monticello CN:

*/


public class NYSullivanCountyParser extends FieldProgramParser {
  
    public NYSullivanCountyParser() {
      super("SULLIVAN COUNTY", "NY",
             "SKIP Type:CALL! Loc:ADDR! X:X V:CITY CN:NAME");
    }
    
    @Override
    public String getFilter() {
      return "911@co.sullivan.ny.us";
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    
	    if (!subject.equalsIgnoreCase("911 Page")) return false;
	    return super.parseMsg(body, data);
	  }
	  
	  class MyCityField extends CityField {
	    
	    @Override
	    public void parse(String fld, Data data) {
	      if (fld.startsWith("V/")) fld = fld.substring(2).trim();
	      super.parse(fld, data);
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("CITY")) return new MyCityField();
      return super.getField(name);
    }
	  
	}
	