package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Prince Georges County, MD
for Prince Georges, Anne Arundel, and Charles counties. and Howard County
Contact: charles woodland <lollipopjuggs@gmail.com>
Contact: Russ <rcfireblitz@gmail.com>
System: Fireblitz
From: @fireblitz.com

55: BUILDING FIRE\nE809 TK809 BO804\n4637 37TH ST (ALLISON ST & DEAD END)\n12/07 04:51\nhttp://fireblitz.com/09/9.html
0-2 H12: PI\nS11 R11\nPG INDIAN HEAD HWY/FARMINGTON RD WEST\nNotes: WANTS ENGINE AND AMBULANCE FROM STATION 11\n12/07 06:14\nhttp://fireblitz.com/11/0.html
26: INVESTIGATION\nE817\n6036 PARKLAND CT (OLD SILVER HILL RD & OLD SILVER HILL RD)\n12/06 22:40\nhttp://fireblitz.com/17/9.html
48: FD ACCIDENT\nSQ818 B802\nANNAPOLIS RD/PRINCESS GARDEN PY (9006 ANNAPOLIS RD/5900 PRINCESS GARD\n12/07 07:02\nhttp://fireblitz.com/18/6.html
24: OVERDOSE - ALS\nA824 MD847, CHARLIE OD/NOT ALRT\n1605 AIRPORT LN (SCHALL RD & BERRY RD)\n12/07 07:14\nhttp://fireblitz.com/24/8.html
27: INJURED/SICK\nA827\n6304 MAXWELL DR #4 (CARSWELL AV & MORRIS AV)\n12/07 05:14\nhttp://fireblitz.com/27/2.html
46: BUILDING FIRE\nE833 TK833 BO802\n1200 CAPITAL CENTER BL (BLVD AT THE CAP CTR)\n12/07 00:51\nhttp://fireblitz.com/33/9.html
46: BUILDING FIRE\nE837 TK837 BO802\n1200 CAPITAL CENTER BL (BLVD AT THE CAP CTR)\n12/07 00:51\nhttp://fireblitz.com/37/5.html
49: MEDIC LOCAL\nA849\n13218 DEERFIELD RD (DEAD END & MATTHEWS CT)\n12/06 23:00\nhttp://fireblitz.com/49/1.html
 */


public class MDPrinceGeorgesCountyParser extends SmsMsgParser {
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "PG", "PRINCE GEORGES COUNTY",
      "CH", "CHARLES COUNTY",
      "AA", "ANNE ARUNDEL COUNTY",
      "HO", "HOWARD COUNTY",
      "DC", "WASHINGTON"
  });
  
  public MDPrinceGeorgesCountyParser() {
    super("PRINCE GEORGES COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "@fireblitz.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String[] lines = body.split("\n");
    if (lines.length != 5 && lines.length != 6) return false;
    if (! lines[lines.length-1].startsWith("http://fireblitz.com/")) return false;
    
    int ndx = 1;
    for (String line : lines) {
      line = line.trim();
      
      switch (ndx) {
        
        // First line contains a station ID & map page followed by a colon and call description
      case 1:
        Parser p = new Parser(line);
        String station = p.get(':');
        data.strCall = p.get();
        
        // If the station contains a dash, there is a map page
        p = new Parser(station);
        data.strMap = p.getLastOptional('-');
        station = p.get();
        
        // First two characters *MIGHT* be a county code
        if (station.length() >= 2) {
          String code = station.substring(0,2);
          String county = COUNTY_CODES.getProperty(code);
          if (county != null) {
            data.defCity = county;
            if (code.equals("DC")) data.defState = "DC";
            station = station.substring(2);
          }
        }
        
        // Anything left is the response station
        data.strSource = station;
        ndx++;
        break;
        
        // Second line is units
      case 2:
        p = new Parser(line);
        data.strUnit = p.get(',');
        ndx++;
        break;
        
        // Third line is address, possibly with cross streets in parens
      case 3:
        if (line.startsWith("PG ")) line = line.substring(3).trim();
        p = new Parser(line);
        String sAddress = p.get('(');
        parseAddress(sAddress, data);
        data.strCross = p.get(')');
        ndx++;
        break;
        
        // Fourth line may have notes
      case 4:
        if (line.startsWith("Notes:")) {
          data.strSupp = line.substring(6).trim();
          break;
        }
        
        // But should eventually have the firebiz URL
        if (line.startsWith("http://")) {
          if (data.strSupp.length() > 0) data.strSupp += '\n';
          data.strSupp += line;
          ndx++;
          break;
        }
      }
    }
    
    return true;
  }
}
