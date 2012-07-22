package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Montgomery County, MD
Contact: Alain Pankopf <hockeylaxboy11@gmail.com>
Sender: rc.355@c-msg.net,@mcen.montgomerycountymd.gov 

MCo / [mCAD] * D * 2301 * BUILDING FIRE * 1620 E JEFFERSON ST ,RO * E723 E703 E721 E726 E705B AT723 AT703 RS703 A723 BC703 BC704 D3 D5 DFRS INV CEALRM CODE BCNOT
MCo / [mCAD] * D * 0302 * BUILDING FIRE * 733 MONROE ST ,RO * E723 E733 E726 E725 E721 AT703 AT723 RS741B M723 BC703 BC704 D3 D5 DFRS INV CEALRM CODE BCNOT
MCo / [mCAD] * D * 0301 * HOUSE FIRE * 1006 DE BECK DR ,RO * E703 E723 E721 E725 E733 AT703 T731 RS703 A703 BC703 BC704 D3 D5 DFRS INV CEALRM CODE BCNOT
MCo / [mCAD] * D * 2312 * UNCONFIRMED POWDER * 5700 BOU AVE ,MCG (TARGET STORE) * E723 AT723 A723 M703 HM707 E720 D3 BC703 DFRS BCNOT HIRT ECC
MCo / [mCAD] * D * 0801 * BOX ALARM * 17211 KING JAMES WAY ,MCG * E728 E731 E703 T731 RS703 A708C BC705 BC703 D8 D3 DFRS INV CEALRM CODE BCNOT
MCo / [mCAD] * D * 0503 * HOUSE FIRE * 4805 FLANDERS AVE ,MCG * E705B E723 E720 E750 E726 AT723 AT751 RS742 A705B BC704 BC703 D5 D3 DFRS INV CEALRM CODE BCNOT
MCo / [mCAD] * D * 0318 * STABBING - ALS1 * 9300 KEY WEST AVE / 15200 SHADY GROVE RD ,RO * M703 BCNOT EMSNOT E703 D3 ECC25 DFRS
MCo / [mCAD] * D * 0301 * PIC w/ ENTRAPMENT -ALS1 * 1180 EDMONSTON DR / 1100 WADE AVE ,RO * M703 RS703 E703 D3 EMS EMSNOT BCNOT DFRS

Contact: Keith Stakes <kstakes2@aol.com>
Sender: MC Emergency Network
CAD MSG: * D * 3132 * BOX ALARM * 209 FOUNTAIN GREEN LA ,GA  * E708 E722 E729 E734 E728 T731 AT708 RS703 M73M
CAD MSG: * D * 2424 * PIC w/ ENTRAPMENT -ALS1 * 13400 NEW HAMPSHIRE AVE / 2 RANDOLPH RD ,MCG  * A724 E724

Contact: "Ebow Holdbrook-Smith" <ebowhold4u@gmail.com>
CAD MSG: * D * 3525 * PIC w/VEH OVERTURNED-ALS1 * S270C 121-27 @ 17000 S270 X18 TO X16 HWY ,MCG  * M735 T7

Contact: Morgan Kee <morgan.kee@gmail.com>
(MCo) [mCAD] * D * 4009 * PIC w/ ENTRAPMENT -ALS1 * 4700 BROOM DR / 18400 WICKHAM RD ,MCG * A740 E740 M704 RS704 D4 EMS EMSNOT BCNOT DFRS

Contact: Robert Murphy <robertmurphy30@gmail.com>
FRM:General Alerts\nMSG:CAD MSG: * D *  * MAF FULL * 14615 PHILIP DR * AT715 BCNOT DFRS=

Contact: Christopher Finelli <chris.finelli@gmail.com>
CAD MSG: * D * 0609 * RSC - RESET ALARM * 4908 AUBURN AVE ,MCG  * RS741B ECC1

Contact: Tim Whirley <t.whirley76@gmail.com>
Sender: alrt_7H8G@mcen.montgomerycountymd.gov
CAD MSG: * D * 1704 * ABDOMINAL PAIN * 7500 MATTINGLY LA ,MCG  * A717 ECC30

Contact support@active911.com
[Important message from MCEN] CAD MSG: * D * 2112 * PIC w/ ENTRAPMENT -ALS1 * 12000 CONNECTICUT AVE / 11900 VEIRS MILL RD ,MCG  * A721 PE721 RS742B D5 DFRS\nSent by MCCAD MCCAD to PE721, FS21, A721, DFRS, D5, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2403 * HOUSE FIRE * 5 APPLEBY CT ,MCG  * PE715 PE718 PE712 PE841 PE716 T715 AT718 RS742B M715 BC701 BC704 D12 D15 DFRS INV CEALRM CODE BCNOT\nSent by MCCAD MCCAD to INV, BCNOT, D15, FS24, PE718, PE715, D12, AT718, PE716, CEALRM, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2403 * HOUSE FIRE * 8 APPLEBY CT ,MCG  * RID T716 RS814 REDX INV CODE DFRS WIG A724\nSent by MCCAD MCCAD to INV, WIG, T716, FS24, A724, DFRS, REDX, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 3008 * POTOMAC RIVER RESCUE M * BILLY GOAT TRAIL A @ 13250 POTOMAC RIVER RIVR ,MCG  * RRTF ST710 SWTL A710 M401 PE730 D10 EAGLE DFRS BCNOT WRT\nSent by MCCAD MCCAD to FS30, PE730, BCNOT, DFRS, RRAT, D10, ST710, A710, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1102 * PIC * 6598 MASSACHUSETTS AVE / 6400 GOLDSBORO RD ,MCG  * RS741 M741 DFRS\nSent by MCCAD MCCAD to RS741, DFRS, FS11, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * PE717 PE728 PE740 PE708 PE734 PAT708 AT734 RS717 EW717 W704 W722 A717 BC703 BC704 D17 D8 DFRS INV CODE BCNOT\nSent by MCCAD MCCAD to INV, PE717, D8, RS717, W704, PE728, A717, EW717, BCNOT, PE740, pat708, BC703, pe708, D17, DFRS, AT734, FS17, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * RID T725 RS729 M708 REDX INV CODE WIG DFRS\nSent by MCCAD MCCAD to INV, WIG, DFRS, M708, RS729, FS17, REDX, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * WSTF W731 HCEW44 W709 PE704 D17 DFRS A708\nSent by MCCAD MCCAD to A708, DFRS, D17, pe704, FS17, W731, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * TF E753 PE729 AT718 D17 CT740 DFRS WITF AR733\nSent by MCCAD MCCAD to AT718, PE729, DFRS, D17, E753, FS17, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * PG00 * MAF FULL * 6017 EASTERN AVE ,PG  * E702 T716 DFRS\nSent by MCCAD MCCAD to T716, DFRS, E702, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 0807 * PEDESTRIAN STRUCK- ALS2 * 460 GIRARD ST ,GA  * M708 DFRS PE708 ECC25\nSent by MCCAD MCCAD to pe708, FS08, DFRS, M708, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1527 * BOX ALARM * 13631 COLGATE WAY ,MCG  * PE715 PE841 PE724 PE712 T715 TK831 RS849 BC701 BC704 D15 D12 DFRS INV CEALRM CODE BCNOT A724 E810C\nSent by MCCAD MCCAD to INV, PE724, D15, BCNOT, FS15, PE715, D12, A724, CEALRM, DFRS, pe712, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 0846 * PIC w/ ENTRAPMENT -ALS1 * S270H 370-SHD GRV @ 8500 S270 X9 TO X8 HWY ,GA  * M708B RS703 PE708 D8 DFRS A753 M731 PAT708\nSent by MCCAD MCCAD to pe708, A753, RS703, FS08, D8, M708B, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1527 * PIC - UNK STATUS * 3403 HAMPTON HOLLOW DR ,MCG  * DFRS\nSent by MCCAD MCCAD to DFRS, FS15, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 0208 * PEDESTRIAN STRUCK- ALS2 * 300 DOMER AVE / 8600 FLOWER AVE ,MCG  * A702 M701 DFRS ECC28 PE701\nSent by MCCAD MCCAD to pe701, A702, DFRS, M701, FS02, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2101 * HOUSE FIRE * 11828 ROCKING HORSE RD ,MCG  * PE721 PE723 E705B PE718 PE725 AT723 AT718 RS742B A721 BC704 BC702 D5 D3 DFRS INV CEALRM CODE BCNOT\nSent by MCCAD MCCAD to INV, BCNOT, D3, PE721, FS21, PE723, AT723, E705B, AT718, CEALRM, DFRS, D5, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2606 * BELLS * 5550 TUCKERMAN LA ,MCG (BRIGHTON GARDENS (SNF)) * E726 AT723 CEALRM ECC30\nSent by MCCAD MCCAD to E726, AT723, CEALRM, FS26, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1106 * CHEM / HAZMAT * 5400 WESTBARD AVE ,MCG (GIANT FOOD) * E711 PE706 E710 T706 RS741 A711 M741D M726 HM707 E720 D11 BC702 BCNOT EMSNOT DFRS ECC24 HIRT\nSent by MCCAD MCCAD to BCNOT, T706, D11, HIRT, A711, EMSNOT, E711, RS741, HM707, pe706, FS11, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2606 * STATUS SEIZURES- ALS1 * 11025 ROSEMONT DR ,MCG  * E726 M723 ECC25\nSent by MCCAD MCCAD to E726, FS26, M723, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2606 * STATUS SEIZURES- ALS1 * TILDEN MS @ 11211 OLD GEORGETOWN RD ,MCG  * E726\nSent by MCCAD MCCAD to E726, FS26, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 0406 * PIC - UNK STATUS * 17200 NORWOOD RD / 17200 DR BIRD RD ,MCG  * DFRS EMSNOT\nSent by MCCAD MCCAD to DFRS, FS04, EMSNOT, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * DC00 * TRANSFER * 5760 GEORGIA AVE NW ,DC  * ECC1 DFRS E702\nSent by MCCAD MCCAD to E702, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * DC00 * TRANSFER * 4300 WISCONSIN AVE NW ,DC  * ECC10 E711 DFRS\nSent by MCCAD MCCAD to DFRS, E711, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2610 * AFA * 10400 SEVEN LOCKS RD ,MCG (HEIGHTS SCHOOL) * E726 AT751 CEALRM ECC30\nSent by MCCAD MCCAD to E726, AT751, CEALRM, FS26, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 2302 * PEDESTRIAN STRUCK- ALS2 * 5300 RANDOLPH RD / 12100 LAUDERDALE DR ,MCG  * PE723 DFRS A705 M726 ECC10\nSent by MCCAD MCCAD to A705, FS23, PE723, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1031 * LRG VEHICLE FIRE * IL495B MACARTHUR BLVD-RIVER RD @ 39500 IL495 X41 TO X39 HWY ,MCG  * E752 E401 A710 BC702 D10 DFRS E726 A741B ECC25 AT401\nSent by MCCAD MCCAD to DFRS, D10, FS10, A741B, A710, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 0610 * METRO OTHER EVENT * METRO BETHESDA STA @ 7450 WISCONSIN AVE ,MCG  * PE706 PE707 T706 AT751 A741B D6 BC702 RAIL DFRS\nSent by MCCAD MCCAD to AT751, T706, A741B, D6, FS06, DFRS, pe706, pe707, RAIL, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1620 * PEDESTRIAN STRUCK- ALS2 * 9302 PINEY BRANCH RD ,MCG (FOREST PARK APTS) * T716 M712 DFRS A702 ECC30 PE712\nSent by MCCAD MCCAD to T716, DFRS, M712, FS16, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * PG00 * MA FULL * 1807 FOX ST ,PG  * ECC DFRS BCNOT PE712 T716\nSent by MCCAD MCCAD to BCNOT, T716, DFRS, pe712, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * PG00 * MA FULL * 1807 FOX ST ,PG  * DFRS M712\nSent by MCCAD MCCAD to DFRS, M712, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n
[Important message from MCEN] CAD MSG: * D * 1614 * BOX ALARM * WARWICK TOWERS @ 1131 UNIVERSITY BLV W ,MCG  * PE716 PE718 E705B PE719 PE701 T716 AT718 AT719 RS742B A742D BC701 BC704 RD2 D1 DFRS INV CODE BCNOT\nSent by MCCAD MCCAD to pe701, D1, INV, BCNOT, PE719, T716, PE718, RD2, AT718, PE716, DFRS, FS16, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n...Powered by the Roam Secure Alert Network\n----\n- Update your MCEN account at https://mcen.montgomerycountymd.gov\n

*/

public class MDMontgomeryCountyParser extends FieldProgramParser {
  
  public MDMontgomeryCountyParser() {
    super(CITY_CODES, "MONTGOMERY COUNTY", "MD",
          "BOX CALL ADDR UNIT!");
  }
  
	public String getFilter() {
		return "rc.355@c-msg.net,MC Emergency Network,@mcen.montgomerycountymd.gov,411911";
	}
	
	@Override
	protected boolean parseMsg(String body, Data data) {
  
	  int pt = body.indexOf("* D * ");
	  if (pt < 0) return false;
	  body = body.substring(pt+6).trim();
	  pt = body.indexOf('\n');
	  if (pt >= 0) body = body.substring(0,pt).trim();
	  return parseFields(body.split("\\*"), 4, data);
	}
	
	private final Field CITY_FIELD = new CityField();
	private class MyAddressField extends AddressField {
	  @Override
	  public void parse(String field, Data data) {
	    Parser p = new Parser(field);
	    field = p.get('(');
	    data.strPlace = p.get(')');
	    p = new Parser(field);
	    data.strPlace = append(p.getOptional('@'), " - ", data.strPlace);
	    super.parse(p.get(','), data);
      CITY_FIELD.parse(p.get(), data);
      if (data.strCity.equals("DC")) {
        data.strCity = "WASHINGTON";
        data.strState = "DC";
      }
    }
	  
	  @Override
	  public String getFieldNames() {
	    return super.getFieldNames() + " CITY PLACE";
	  }
	}
	
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+\\d{3}[A-Z]?");
	private class MyUnitField extends UnitField {
	  @Override
	  public void parse(String field, Data data) {
      for (String unit : field.split(" +")) {
        if (UNIT_PTN.matcher(unit).matches()) {
          data.strUnit = append(data.strUnit, " ", unit);
        }
      }
	  }
  }
	
	@Override
	public Field getField(String name) {
	  if (name.equals("ADDR")) return new MyAddressField();
	  if (name.equals("UNIT")) return new MyUnitField();
	  return super.getField(name);
	}
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "DC",  "DC",
      "GA", "GAITHERSBURG",
      "MCG", "",
      "PG",  "PRINCE GEORGES COUNTY",
      "RO",  "ROCKVILLE",
      "SS",  "SILVER SPRING",
      "TP",  "TACOMA PARK"
  });
}
/***
valid units consist of specific prefix followed by 3 digits.

A – Ambulance (BLS EMS Transport Unit)
AB – Air Boat
ALS – ALS Chase Car
AR – Air Unit
AT – Tower (Aerial Tower)
BC – Battalion Chief
DC – Duty Chief
E – Engine
ECC CAD – Emergency Communication Center CAD dispatch console
EMS – EMS Supervisor
EW – Engine Tanker
HM – Haz Mat
HSU – Haz Mat Support Unit
M – Medic (ALS EMS Transport Unit)
MAB – Medical Ambulance Bus (20 patient EMS transport unit)
MSU – Medical Support Unit (Mass casualty EMS supplies)
NCR – National Capital Region Communications Unit
RAT – Reserve Aerial Tower
RE – Reserve Engine
RECON – Urban Search & Rescue Recon Unit
RS – Rescue Squad (Heavy Rescue)
SOP – Special Operations Chief
T – Truck
U – Unit
W – Tanker (Water Tender)
XTP – Urban Search & Rescue Roll-off Transport Unit
***/  
