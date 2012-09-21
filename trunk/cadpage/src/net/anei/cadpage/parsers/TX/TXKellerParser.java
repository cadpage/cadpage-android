package net.anei.cadpage.parsers.TX;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Keller, TX (in Tarrent County)
Contact: Active911
Agency name: Colleyville Fire Department Location: Colleyville, TX
Sender: crimes@cityofkeller.com 

(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7401 WINDSWEPT TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Walgreens Glade Rd- 3830 Glade Rd,Box308 Colleyville\nHERITAGE AVE//COPPERGLEN CIR\n Fire Box = 2241
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  HALL JOHNSON RD, Colleyville\nSYCAMORE DR//\n Fire Box = 2129
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5101 BLUEBONNET DR, Colleyville\nRIVERWALK DR//\n Fire Box = 2137
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  PLEASANT RUN, Colleyville\n//\n Fire Box = 2136
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 921 SHADY LAKE DR - BEDFORD, Colleyville\n//\n Fire Box =
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3708 BRIARHAVEN LN, Colleyville\nGREENBRIAR LN//NULL\n Fire Box = 2153
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4008 WINDVIEW DR, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2156
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4904 JIM MITCHELL TRL E, Colleyville\nGLADE RD//NULL\n Fire Box = 2249
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 4002 ELMWOOD CT, Colleyville\nPLANTATION DR S//NULL\n Fire Box = 2154
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 213 WHITE DR, Colleyville\nWESTCOAT DR//\n Fire Box = 2319
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4608 JIM MITCHELL TRL W, Colleyville\nGLADE RD//NULL\n Fire Box = 2249
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 219 CHEEK SPARGER RD, Colleyville\nFELPS DR//STEEPLECHASE DR\n Fire Box = 2153
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7212 STILTON CT, Colleyville\nCOLLINS PATH//NULL\n Fire Box = 2114
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4801 SHADYCREEK LN, Colleyville\nMEADOWVIEW DR//\n Fire Box = 2249
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 1912 Shenandoah Dr Gpv, Colleyville\n//\n Fire Box =
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n--  Merlot Grapevine, Colleyville\n//\n Fire Box =
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n--  PLEASANT RUN RD, Colleyville\nMAIN ST//NULL\n Fire Box = 2128
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5500 VALLEY VIEW DR W, Colleyville\nVALLEY VIEW DR S//NULL\n Fire Box = 2134
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 5500 VALLEY VIEW DR W, Colleyville\nVALLEY VIEW DR S//NULL\n Fire Box = 2134
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1221 CHURCH ST, Colleyville\nCOLLEYVILLE BLVD.//\n Fire Box = 2137
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 200 CHEEK SPARGER RD, Colleyville\nFELPS DR//STEEPLECHASE DR\n Fire Box = 2153
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6216 CIMMARON TRL, Colleyville\nMCDONWELL SCH RD W//\n Fire Box = 2317
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 4309 MARTIN PKWY, Colleyville\nEATON CIR//\n Fire Box = 2250
(GAS - ODOR INSIDE) \nGAS - ODOR INSIDE\n-- 5303 ROBERTS DR, Colleyville\n//\n Fire Box = 2241
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4309 MARTIN PKWY, Colleyville\nEATON CIR//\n Fire Box = 2250
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 907 RODEO DR, Colleyville\nMOCKINGBIRD LN//\n Fire Box = 2154
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7990 PRECINCT LINE RD, Colleyville\nL D LOCKETT RD W//NULL\n Fire Box = 2324
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 4500 STAFFORD DR, Colleyville\nGLADE RD//NULL\n Fire Box = 2147
(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 4419 MEANDERING WAY, Colleyville\nLAKESIDE DR//\n Fire Box = 2249
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1701 OAK KNOLL DR, Colleyville\nSTAFFORD DR//\n Fire Box = 2147
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7007 SHEPHERDS GLEN, Colleyville\n//\n Fire Box = 2312
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Gloria's Restaurant- 5611 Colleyville Blvd, Colleyville\nHALL JOHNSON RD//\n Fire Box = 2129
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4601 MILL WOOD DR, Colleyville\nMILL VIEW DR//\n Fire Box = 2145
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6413 LORRAINE PARK, Colleyville\n//\n Fire Box = 2317
(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-Heritage High School- 5401 Heritage Ave, Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241
(FIRE - GRASS) \nFIRE - GRASS\n-- 805 COLLEYVILLE TER, Colleyville\nBRANSFORD RD//PLEASANT RUN RD\n Fire Box = 2128
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Colleyville Cinema Grill- 5655 Colleyville Blvd, Colleyville\nHALL JOHNSON RD//\n Fire Box = 2129
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5700 OAK TOP DR, Colleyville\nOAK VALLEY DR W//\n Fire Box = 2327
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 300  Westover Dr-euless, Colleyville\n//\n Fire Box =
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4200 SHADOW RIDGE DR, Colleyville\nSADDLEBROOK DR//NULL\n Fire Box = 2154
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 405 GLADE RD, Colleyville\nBRANSFORD DR//MILL CREEK DR\n Fire Box = 2145
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 304 VAN OAKS DR, Colleyville\nBETTINGER DR//NULL\n Fire Box = 2318
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 405 GLADE RD, Colleyville\nBRANSFORD DR//MILL CREEK DR\n Fire Box = 2145
(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 4508 CRESTHAVEN DR, Colleyville\nMEANDERING WAY//\n Fire Box = 2249
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 6106 LANSFORD LN, Colleyville\nBALLANTRAE DR//\n Fire Box = 2230
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3604 BRIARBROOK CT, Colleyville\nWOODBRIAR LN//\n Fire Box = 2161
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 500 FIELD ST, Colleyville\nBRANSFORD RD//\n Fire Box = 2135
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 3900 Jackson Rd, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2257
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 3900 Jackson Rd, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2257
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 2404 ARBOR GATE LN, Colleyville\nAMADOR TRL//\n Fire Box = 2231
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 5700 COLLEYVILLE BLVD, Colleyville\nHALL JOHNSON RD//\n Fire Box = 2129
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 5700 COLLEYVILLE BLVD, Colleyville\nHALL JOHNSON RD//\n Fire Box = 2129
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Lifetime Fitness- 1221 Church St, Colleyville\nCOLLEYVILLE BLVD.//\n Fire Box = 2137
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1603 ROYAL LN, Colleyville\nBLUEBONNET DR//\n Fire Box = 2137
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4700 MILL VIEW DR, Colleyville\nGLADE RD W//\n Fire Box = 2144
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-EXXON STATION- 4405 Colleyville Blvd,Box406 Colleyville\nBRANSFORD RD//MILL VALLEY DR E\n Fire Box = 2145
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 6701 MEADE DR, Colleyville\nFRANCES LN//\n Fire Box = 2122
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1812 MAPLEWOOD TRL, Colleyville\nSHADOWOOD TRL//\n Fire Box = 2135
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Colleyville Middle School- 1100 Bogart Dr, Colleyville\nPLEASANT RUN RD//\n Fire Box = 2128
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Goody Goody Liquor- 4701 COLLEYVILLE BLVD,300 Colleyville\nGLADE RD//CENTERPARK DR\n Fire Box = 2146
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6110 HUNTER LN, Colleyville\nSHELTON DR//\n Fire Box = 2120
(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 5800 COLLEYVILLE BLVD, Colleyville\n BOGART//TUSCANY DR\n Fire Box = 2129
(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 1909  FOUNTAIN PASS DR, Colleyville\nOAK POINTE DR//NULL\n Fire Box = 2121
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5314 BRANSFORD RD,208 Colleyville\nWHITE DR//\n Fire Box = 2135
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 1300 HALL JOHNSON RD, Colleyville\n//\n Fire Box = 2129
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 483 N MAIN ST, Keller\nKELLER HICKS RD//JOHNSON RD\n Fire Box = 52430701
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4601 MILL WOOD DR, Colleyville\nMILL VIEW DR//\n Fire Box = 2145
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1100 LAVACA TRL, Colleyville\nMUSTANG TRL//PRECINCT LINE RD\n Fire Box = 2317
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-Keller Welding Mfg Inc- 604 Katy Rd, Keller\nKELLER HICKS RD//KATY RD\n Fire Box = 52430601
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5207 HERITAGE AVE, Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 483 N MAIN ST, Keller\nKELLER HICKS RD//JOHNSON RD\n Fire Box = 52430701
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6413 LORRAINE PARK, Colleyville\n//\n Fire Box = 2317
(FD INVESTIGATION) \nFD INVESTIGATION\n-- 1190 CHEEK SPARGER RD, Colleyville\nBEDFORD RD//TARA DR\n Fire Box = 2155
(GAS - ODOR OUTSIDE) \nGAS - ODOR OUTSIDE\n-- 5008 COPPERGLEN CIR, Colleyville\nGLADE RD//\n Fire Box = 2241
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1509 TINKER RD, Colleyville\nCOLLEYVILLE BLVD//NULL\n Fire Box = 2121
(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 7801 LEESBURG DR, Colleyville\nCHARLOTTESVILLE AVE//\n Fire Box = 2302
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 407 Marseille - Hurst, Colleyville\n//\n Fire Box =
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 5114 MONTCLAIR DR, Colleyville\nGLADE RD//NULL\n Fire Box = 2238
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7026 PRIMROSE LN, Colleyville\nJOHN MCCAIN RD//NULL\n Fire Box = 2313
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1329 SNOW MOUNTAIN CIR, Keller\nSNOW MOUNTAIN CIR//SNOW MOUNTAIN CIR\n Fire Box = 53420304
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5207 HERITAGE AVE, Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6521 COLLEYVILLE BLVD, Colleyville\nTARRANT LN//\n Fire Box = 2121
(GAS - ODOR OUTSIDE) \nGAS - ODOR OUTSIDE\n--  REMINGTON PKWY, Colleyville\nMCDONWELL SCH RD W//NULL\n Fire Box = 2326
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7204 OVERLAND TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 1312 Hardisty, Colleyville\n//\n Fire Box =
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7300 CHANEL CT, Colleyville\nBANDIT TRL//NULL\n Fire Box = 2310
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 110 MAIN ST, Colleyville\nCOLLEYVILLE BLVD//VILLAGE LN\n Fire Box = 2136
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3838 SAN BAR LN, Colleyville\nWOODBINE DR//NULL\n Fire Box = 2152
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5232 COLLEYVILLE BLVD,100 Colleyville\nMAIN ST//PROFESSIONAL CT\n Fire Box = 2136
(FIRE - GRASS) \nFIRE - GRASS\n-- 4712 BILL SIMMONS RD, Colleyville\nGLADE RD//NULL\n Fire Box = 2248
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1033 PALO DURO TR, Keller\nKING TR//EOP\n Fire Box = 53420401
(POWER LINE ARCING/POLE ON FIRE) \nPOWER LINE ARCING/POLE ON FIRE\n-- 4200 JACKSON RD, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2249
(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 919 CHEEK SPARGER RD, Colleyville\nWAYNE DR//CHEECK SPARGER RD\n Fire Box = 2154
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7201 WINDSWEPT TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Lifetime Fitness- 1221 Church St, Colleyville\nCOLLEYVILLE BLVD.//\n Fire Box = 2137
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4809 JIM MITCHELL TRL E, Colleyville\nGLADE RD//NULL\n Fire Box = 2249
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 6709 MEADE DR, Colleyville\nFRANCES LN//\n Fire Box = 2122
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5314 BRANSFORD RD,105 Colleyville\nWHITE DR//\n Fire Box = 2135
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Heritage Middle School- 5300 Heritage Ave,Box308 Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241
(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 4604 MEANDERING WAY, Colleyville\nLAKESIDE DR//\n Fire Box = 2249
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 4105 LEXINGTON PKWY, Colleyville\nPEMBROOKE PKWY S//\n Fire Box = 2259
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5056 HERITAGE OAKS DR, Colleyville\nHERITAGE AVE//NULL\n Fire Box = 2241
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Lakes Of Somerset- 1100 Somerset Blvd,Box401A Colleyville\nBEDFORD RD//\n Fire Box = 2146
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Heritage High School- 5401 Heritage Ave, Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7215 BROOKE DR, Colleyville\nPRINCE MEADOW DR//\n Fire Box = 2114
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 3609 COTSWOLD CT, Colleyville\nPRESTWICK DR//GLADE RD\n Fire Box = 2251
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 5005 SAN GABRIEL AVE, Colleyville\nRIVERWALK CT//NULL\n Fire Box = 2136
(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 6512 HORSESHOE BND, Colleyville\n//\n Fire Box = 2317
(FIRE - GRASS) \nFIRE - GRASS\n-- 6512 KINGSTON DR, Colleyville\nTINKER RD//\n Fire Box = 2121
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3136 WOODLAND HEIGHTS CIR, Colleyville\nMARTIN PKWY//NULL\n Fire Box = 2258
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5508 REAGAN RD, Colleyville\nL D LOCKETT RD W//\n Fire Box = 2326
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6020 STERLING DR, Colleyville\nCRYSTAL WAY//L D LOCKETT RD W\n Fire Box = 2325

*/

public class TXKellerParser extends FieldProgramParser {
  
  public TXKellerParser() {
    super("TARRANT COUNTY","TX",
          "CALL ADDR X BOX!");
  }
  
  @Override
  public String getFilter() {
    return "crimes@cityofkeller.com";
  }
  
  @Override
  protected boolean parseMsg(String field, Data data) {
    return parseFields(field.split("\n"), 4, data);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    int pt = sAddress.indexOf(", Box");
    if (pt >= 0) sAddress = sAddress.substring(0,pt).trim();
    return sAddress;
  }
  
  private static final Pattern BOX_PTN = Pattern.compile("BOX *(\\d+)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-- ")) {
        field = field.substring(3).trim();
      } else if (field.startsWith("-")) {
        int pt = field.indexOf('-',1);
        if (pt < 0) abort();
        data.strPlace = field.substring(1,pt).trim();
        field = field.substring(pt+1).trim();
      } else abort();
      
      int pt = field.lastIndexOf(',');
      if (pt < 0) abort();
      String city = field.substring(pt+1).trim();
      field = field.substring(0,pt).trim();
      
      String box = "";
      Matcher match = BOX_PTN.matcher(city);
      if (match.find()) {
        box = ", Box " + match.group(1);
        city = city.substring(match.end()).trim();
      }
      
      pt = field.lastIndexOf('-');
      if (pt >= 0) {
        city = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      
      parseAddress(field, data);
      data.strAddress = data.strAddress + box;
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR APT CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      if (field.endsWith("/NULL")) field = field.substring(0,field.length()-5).trim();
      super.parse(field, data);
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("Fire Box =")) abort();
      field = field.substring(10).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }
  
}
