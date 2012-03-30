package net.anei.cadpage.parsers.DE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Kent County, DE
Contact: Dewey Thomas <dewey@codemessaging.net>
From: kentcenter@state.de.us

(Incident Alert)Unit:A64 Status:Dispatched 26A10 Sick Person - Unwell/Ill 125 CENTURY DR Venue: Smyrna Dev/Sub: BRENFORD WOODS Xst's: NEEDHAM DR / NEEDHAM DR Caller: MASS LEXIS
(Incident Alert)Unit:A41 Status:Dispatched 10C1 Chest Pains 73 WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: SPRING RIDGE WAY / SADDLEBROOK DR, S WYNN WOOD CIR Caller: TOMPKINS WAYNE
(Incident Alert)Unit:B64 Status:Dispatched 33C5T Transfer/Interfacility 1181 PADDOCK RD JAMES T VAUGHN CORRECTIONAL CENTER Venue: Smyrna Dev/Sub: Xst's: DELAWARE DEPT OF CORRECTION CT / MC QUAIL RD Caller: PHYLIS
(Incident Alert)Unit:A42 Status:Dispatched 4B3A Assault - Unknown 5 N  WASHINGTON ST PARK PLACE LOUNGE Venue: Milford Dev/Sub: Xst's: PARK AVE / S WASHINGTON ST Caller:
(Incident Alert)Unit:A41 Status:Dispatched 17B1G Falls - Possibly Dangerous 561 N  DUPONT HWY HOLIDAY INN DOVER Venue: Dover Dev/Sub: Xst's: JEFFERIC BLVD / TOWNSEND BLVD Caller: DEBB LESEX
(Incident Alert)Unit:46F1 Status:Dispatched Outside Fire-Small 1788 N  DUPONT HWY MCDONALDS SCARBOROUGH RD Venue: Dover Dev/Sub: Xst's: HOLIDAY BLVD / CEDAR CHASE DR Caller:
(Incident Alert)Unit:A42 Status:Dispatched 21D3 Hemorrhage - Dangerous 204 ASHLEY WAY  Venue: Milford Dev/Sub: THE VILLAS AT MILFORD CROSSING Xst's: UNKNOWN / MOYER CIR E Caller: FULLER SHIRLEY
(Incident Alert)Unit:46F1 Status:Dispatched Vehicle Fire 201 STOVER BLVD MAIN STAY SUITES Venue: Dover Dev/Sub: STOVER Xst's: BAY RD / KRISKO CIR Caller: EAGLE HOSPITALITY ( MAINSTAY S
(Incident Alert)Unit:A51 Status:Dispatched Electrical Hazard-Wire Down ARTHURSVILLE RD  Venue: Clayton Dev/Sub: Xst's: Caller: DIMEO FRED
(Incident Alert)Unit:P51F Status:Dispatched Electrical Hazard-Wire Down ARTHURSVILLE RD  Venue: Clayton Dev/Sub: Xst's: Caller: DIMEO FRED
(Incident Alert)Unit:A41 Status:Dispatched 6D2 Breathing Problems 425 MANNERING DR  Venue: Dover Dev/Sub: GRAND OAKS Xst's: DEAD END / LADY CT Caller: DAMATO
(Incident Alert)Unit:B64 Status:Dispatched 31A3 Fainting Episode 436 GREENS BRANCH LN  Venue: Smyrna Dev/Sub: EAGLE CHASE Xst's: EAGLE WAY / N HIGH ST Caller: WINGFIELD
(Incident Alert)Unit:A42 Status:Dispatched 26A11 Sick Person - Vomiting 47 LADY SLIPPER LN  Venue: Milford Dev/Sub: SARAGLEN ACRES Xst's: DEAD END / JONQUIL CT Caller: MALANIO JOSIE
(Incident Alert)Unit:A64 Status:Dispatched 6D1 Breathing Problems  197 SPENCER DR  Venue: Clayton Dev/Sub: Xst's: BLACKISTON RD / BLACKISTON RD Caller: LEAGER MONICA
(Incident Alert)Unit:B64 Status:Dispatched 31A1 Fainting Episode 169 PADDOCK RD  Venue: Townsend Dev/Sub: Xst's: THOROUGHFARE NECK RD / FLEMINGS LANDING RD Caller: WICKS DEBBIE
(Incident Alert)Unit:C50 Status:Dispatched 9B1A - Obvious Death 2628 VERNON RD  Venue: Harrington Dev/Sub: Xst's: CATTAIL BRANCH RD / WELCH RD Caller: CARTER PAUL
(Incident Alert)Unit:46F3 Status:Dispatched Alarms-Commercial 1294 FORREST AVE BETSY ROSS PIZZA FORREST AVE Venue: Dover Dev/Sub: Xst's: S INDEPENDENCE BLVD, INDEPENDENCE BLVD / KENTON RD Caller:
(Incident Alert)Unit:A41 Status:Dispatched 23O1A Overdose/Poisoning WILLOW GROVE RD  Venue: Camden Wyoming Dev/Sub: Xst's: Caller: STACEY CRYSTAL
(Incident Alert)Unit:B53 Status:Dispatched 17B3 Falls - Unknown 6394 W DENNEYS RD  Venue: Dover Dev/Sub: Xst's: JPS DR / JOSIE AVE Caller: M BLANCHARD
(Incident Alert)Unit:P53E Status:Dispatched 17B3 Falls - Unknown 6394 W DENNEYS RD  Venue: Dover Dev/Sub: Xst's: JPS DR / JOSIE AVE Caller: M BLANCHARD
(Incident Alert)Unit:B50 Status:Dispatched 17A1G Falls - Not Dangerous  42 CHAMBERS CIR HARRINGTON CASINO Venue: Harrington Dev/Sub: STATE FAIR GROUNDS Xst's: WILLIAM M CHAMBERS JR RD / WILLIAM M CHAMBERS JR RD Caller: HAYES PAUL
(Incident Alert)Unit:A64 Status:Dispatched 26A10 Sick Person - Unwell/Ill 910 APPLEBERRY DR  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: DYLAN ST / DAIRY DR, SAKS ST Caller: KRASAVAGE MARTIN
(Incident Alert)Unit:478 Status:Dispatched 17B1G Falls - Possibly Dangerous 618 PROSPECT CHURCH RD  Venue: Harrington Dev/Sub: Xst's: TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD Caller: CANNON JIM
(Incident Alert)Unit:C50 Status:Dispatched 17B1G Falls - Possibly Dangerous 618 PROSPECT CHURCH RD  Venue: Harrington Dev/Sub: Xst's: TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD Caller: CANNON JIM
(Incident Alert)Unit:P50F Status:Dispatched Citizen Assist/Service Call  7250 MILFORD HARRINGTON HWY ROYAL FARMS- HARRINGTON Venue: Harrington Dev/Sub: Xst's: CLARK ST, S DUPONT HWY / S DUPONT HWY Caller:
(Incident Alert)Unit:A50 Status:Dispatched 17A2G Falls - Non Recent 502 MASON AVE  Venue: Harrington Dev/Sub: Xst's: MADISON AVE / DEAD END Caller: S STIERS
(Incident Alert)Unit:A41 Status:Dispatched 26A8 Sick Person - Other Pain 1750 S  TAYLOR DR  Venue: Dover Dev/Sub: TAYLOR ESTATES Xst's: N TAYLOR DR, LAKEVIEW AVE / S DUPONT HWY Caller: WINCHELL
(Incident Alert)Unit:A41 Status:Dispatched 24B1 Pregnancy 3036 UPPER KING RD TROOP 3 Venue: Dover Dev/Sub: Xst's: DERBY WOOD CIR / BISON RD Caller:
(Incident Alert)Unit:46F4 Status:Dispatched Structure-Chimney  1401 S FARMVIEW DR  Venue: Dover Dev/Sub: Xst's: WOODMILL DR / S INDEPENDENCE BLVD Caller:
(Incident Alert)Unit:A64 Status:Dispatched 32B2 - Medic Alert 612 SAKS ST  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: STELLA ST / RADNOR LN Caller:
(Incident Alert)Unit:A42 Status:Dispatched 30A1 Traumatic Injury SE FRONT ST  Venue: Milford Dev/Sub: Xst's: Caller: JOHN
(Incident Alert)Unit:A41 Status:Dispatched 6D1 Breathing Problems  688 S  WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: WILDMEADOW LN / DEAD END Caller: G WITT
(Incident Alert)Unit:A64 Status:Dispatched 1C4 Abdominal Pains 306 BIG OAK RD  Venue: Smyrna Dev/Sub: Xst's: STATE HWY 1 / PIER HEAD BLVD Caller: CONLON TIM
(Incident Alert)Unit:A64 Status:Dispatched 17A1G Falls - Not Dangerous  6 REHOBOTH CIR  Venue: Clayton Dev/Sub: CLAYTON COURTS MHP Xst's: DEAD END / CLAYTON DR Caller: HUTTON
(Incident Alert)Unit:A42 Status:Dispatched 13C1 Diabetic - Not Alert 7190 WILKINS RD  Venue: Milford Dev/Sub: Xst's: CEDAR CREEK RD / GREGORY BLVD Caller: DILLON MARY
(Incident Alert)Unit:P41F Status:Dispatched Alarms-Commercial 140 SOUTHERN BLVD WYOMING CONCRETE Venue: Camden Wyoming Dev/Sub: WYOMING Xst's: PINE ST / S LAYTON AVE Caller: 73
(Incident Alert)Unit:A42 Status:Dispatched 13C1 Diabetic - Not Alert 111 LOVERS LN  Venue: Milford Dev/Sub: Xst's: BERRY LN / SE 2ND ST Caller: PD MILFORD
(Incident Alert)Unit:A64 Status:Dispatched 33C5T Transfer/Interfacility 3034 S  DUPONT BLVD PINNACLE HEALTH AND REHAB CTR  Venue: Smyrna Dev/Sub: Xst's: UNKNOWN / VILLAGE DR Caller: KARNAO JASON
(Incident Alert)Unit:46F2 Status:Dispatched Alarms-Commercial 644 S  QUEEN ST  Venue: Dover Dev/Sub: Xst's: S WEST ST / W WATER ST Caller: FIRE DOVER
(Incident Alert)Unit:A42 Status:Dispatched 33C1T Transfer/Interfacility 100 DELAWARE VETERANS BLVD DELAWARE VETERANS HOME Venue: Milford Dev/Sub: Xst's: DEAD END / PATRIOTS WAY Caller: NIXON
(Incident Alert)Unit:A64 Status:Dispatched 26D1 Sick Person - Not Alert 175 ASHFIELD CT CHIMES GROUP HOME Venue: Smyrna Dev/Sub: TWIN WILLOWS Xst's: W BRAEBURN DR / W CAYHILL LN Caller: SIRRELL
(Incident Alert)Unit:P41F Status:Dispatched Alarms-Residential (single) 605 QUAIL RUN  Venue: Camden Wyoming Dev/Sub: WILD QUAIL GOLF AND COUNTRY CLUB Xst's: GREEN WINGED TRL / PINTAIL PL Caller: 28
(Incident Alert)Unit:B64 Status:Dispatched 23B1I Overdose/Poisoning 101 N  CARTER RD  Venue: Smyrna Dev/Sub: Xst's: W MOUNT VERNON ST / DEAK DR Caller: TRACY
(Incident Alert)Unit:A42 Status:Dispatched Service Call -Locked in Vehicle 202 ALLEN WAY  Venue: Milford Dev/Sub: Xst's: AURORA PL / N CHURCH ST Caller: MURRY SHENAY
(Incident Alert)Unit:A41 Status:Dispatched 26C1 Sick Person  1822 THICKET RD  Venue: Camden Wyoming Dev/Sub: Xst's: No Cross Streets Found Caller: SIPPLE VICTORIA
(Incident Alert)Unit:B64 Status:Dispatched 32B2 - Medic Alert 612 SAKS ST  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: STELLA ST / RADNOR LN Caller: 12170
(Incident Alert)Unit:P41F Status:Dispatched Electrical Hazard-Wire Down 8429 WESTVILLE RD  Venue: Camden Wyoming Dev/Sub: Xst's: UNKNOWN / MALLARD DR Caller: DEAN
(Incident Alert)Unit:B64 Status:Dispatched 23C7I Overdose/Poisoning 214 S  CARTER RD  Venue: Smyrna Dev/Sub: Xst's: JULIA WAY / DETTINGER RD Caller:
(Incident Alert)Unit:A42 Status:Dispatched 31D2 Unconscious/Fainting 1042 N  WALNUT ST MILFORD DINER Venue: Milford Dev/Sub: Xst's: N DUPONT BLVD / BUCCANEER BLVD Caller: IRENE
(Incident Alert)Unit:A41 Status:Dispatched 10C4 Chest Pains 642 S  WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: WILDMEADOW LN / RIDINGWOOD LN Caller: JACKSON JOAN
(Incident Alert)Unit:B64 Status:Dispatched 26C2 Sick Person  263 HOLLY HILL DR  Venue: Smyrna Dev/Sub: HOLLY HILL ESTATES Xst's: BERRY DR / CEDAR CT Caller: EPPLER
(Incident Alert)Unit:A41 Status:Dispatched 10C2 Chest Pains  3664 PEACHTREE RUN  Venue: Dover Dev/Sub: Xst's: LOCHMEATH WAY / VANNESSA DR Caller: KNOTS REGINA
(Incident Alert)Unit:A42 Status:Dispatched 33C6T Transfer/Interfacility 219 S  WALNUT ST  Venue: Milford Dev/Sub: Xst's: SE 2ND ST / BARKER ST Caller: SHERRY
(Incident Alert)Unit:46F9 Status:Dispatched Alarms-High Life Hazard 1121 FORREST AVE MODERN MATURITY CTR Venue: Dover Dev/Sub: Xst's: BENNINGTON ST, GEORGE WASHINGTON DR / SAULSBURY RD, FOREST ST Caller: DFD
(Incident Alert)Unit:A42 Status:Dispatched 10D2 Chest Pains  711 EVERGREEN LN  Venue: Milford Dev/Sub: Xst's: MEADOW BROOK LN / WISSEMAN AVE Caller: WARD MARIAN
(Incident Alert)Unit:P51F Status:Dispatched Structure-Mobile Home/Trailer 79 ELAINE DR  Venue: Clayton Dev/Sub: Xst's: MAPLE OAKS LN / SHAWS CORNER RD Caller: DORIAN GODDARD
(Incident Alert)Unit:C50 Status:Dispatched 6D1 Breathing Problems  10 MECHANIC ST HARRINGTON PD Venue: Harrington Dev/Sub: Xst's: FLEMING ST / COMMERCE ST, HANLEY ST, RAILROAD AVE Caller: 

 */


public class DEKentCountyCParser extends FieldProgramParser {
  
  public DEKentCountyCParser() {
    super("KENT COUNTY", "DE",
           "Unit:UNIT! Status:ADDR/SCP! Venue:CITY! Dev/Sub:PLACE! Xst's:X Caller:NAME");
  }
  
  @Override
  public String getFilter() {
    return "kentcenter@state.de.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Incident Alert") && !subject.equals("!")) return false;
    return super.parseMsg(body, data);
  }
  
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}[A-Z]\\d{1,2}[A-Z]?) (?:- )?");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      if (!field.startsWith("Dispatched ")) abort();
      field = field.substring(11).trim();
      
      Matcher match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL ADDR APT PLACE";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      data.strPlace = append(data.strPlace, " - ", field);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
}


