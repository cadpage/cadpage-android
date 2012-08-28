package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Jefferson County, PA
Contact: "Rhed, Tony" <trhed@crossettinc.com>  (historical)
Sender: Dispatch@jeffersoncountypa.com
prvs=0482c7782c=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment N 4TH ST HILL ST Reynoldsville Narrative:  10 YEAR OLD BOY HIT BY A CAR.
prvs=0483bf5710=dispatch@jeffersoncountypa.com (Incident) Structure Fire CRICKET RD & VO TECH RD Winslow Narrative:  612 TO STATION  634 TO STATION UNKNOWN INJURIES  POSSIBLE  ENTRAPMENT. BOX 6-F
prvs=0484c9755a=dispatch@jeffersoncountypa.com (Incident) Fire - Alarm. 3823 ROUTE 310 HIMES HILL RD / CHIPS RD Winslow.    Narrative:  basement smoke detector-  6-C Fire Tower

Contact: Chris Smith <ffsmith20@gmail.com>
Sender: dispatch@jeffersoncountypa.com
prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Fire - Alarm 251 S PENN STREET EXT Punxsutawney DEAD END / CLIFF ST 20-A Snyder Hill
prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire 251 S PENN ST Punxsutawney
prvs=0516eca2ae=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) MVA ROUTE 119 / ROUTE 436 Young Narrative:
prvs=0514f9c90b=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) MVA 3637 ROUTE 36 SPRING RD / HOLLIS LN Oliver SMITH HAULINGNarrative: 5-A Coolspring
prvs=0512e03127=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire 106 FOUNDRY ST CRISSMAN ALY / W MAHONING ST Punxsutawney Narrative: 40-A Snyder Hill
prvs=05312311d9=dispatch@jeffersoncountypa.com (Incident) Tree Down GASKILL AVE ALTMAN AVE Punxsutawney 20-A Snyder Hill
prvs=054676518f=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Misc. Fire S20 MED50  313 WOODLAND AVE Punxsutawney BLAIR ST / CAMBRIA ST 20-A Snyder Hill
prvs=054477bfa6=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 SQ30 R20 R40 T20 T40 MED50  143 WOODDALE DR Bell ALBION RD / ACORN LN 30-B Snyder Hill
prvs=054676518f=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 T20 T40 MED50  118 CLARK ST Punxsutawney HAMPTON AVE, RIDGE AVE / N PENN ST 30-A Snyder Hi
prvs=0555093757=dispatch@jeffersoncountypa.com (Incident) Tree Down S20  558 ROBINSON ST Bell HALL ST / DEAD END 20-B Snyder Hill
prvs=05703e571d=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire E20 R20 T20 E30 SQ30 E40 TK40 R40 MED50  105 WOODLAND AVE Punxsutawney SPRING ST / E MAHONING ST, CLEARFIEL

prvs=0585990ef8=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment S40 S20 S30 MED50  754 S MAIN STREET EXT Young FEMCO MACHINE COMPANYUNIVERSAL DR, CALVARY LN / ALLIAN

*/

public class PAJeffersonCountyParser extends SmartAddressParser {
  
  private static final Pattern BOX_CH_PTN = Pattern.compile("(?: +BOX|-)? +(\\d{1,2}-[A-Z])(?: +([A-Za-z]+(?: +[A-Za-z]+)?))?$");
  
  public PAJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@jeffersoncountypa.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Incident")) return false;
    
    Matcher match = BOX_CH_PTN.matcher(body);
    if (match.find()) {
      data.strBox = match.group(1);
      data.strChannel = getOptGroup(match.group(2));
      body = body.substring(0,match.start()).trim();
    }
    
    int pt = body.indexOf("Narrative:");
    if (pt >= 0) {
      data.strSupp = body.substring(pt+10).trim();
      body = body.substring(0,pt).trim();
    }

    // SNYDER HILL in info section confuses the smart address parer
    body = body.replace("Snyder Hill", "Snyder-Hill");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, body, data);
    data.strCross = getPadField();
    String extra = getLeft();
    
    if (data.strCross.length() == 0 && extra.contains(" / ")) {
      boolean cross = true;
      boolean foundSlash = false;
      for (String part : extra.split(",")) {
        part = part.trim();
        boolean slash = part.contains("/");
        if (!slash && !foundSlash) {
          data.strCross = append(data.strCross, ", ", part);
        }
        else if (cross) {
          Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, part);
          if (res.getStatus() > 0) {
            String saveCross = data.strCross;
            data.strCross = "";
            res.getData(data);
            data.strCross = append(saveCross, ", ", data.strCross);
            part = res.getLeft();
            if (part.length() > 0) {
              data.strPlace = part;
              cross = false;
            }
          } else if (slash) {
            data.strCross = append(data.strCross, ", ", part);
            cross = false;
          } else {
            data.strPlace = part;
            cross = false;
          }
        } else {
          data.strPlace = append(data.strPlace, ", ", part);
        }
        if (slash) foundSlash = true;
      }
    } else {
      data.strPlace = extra;
    }
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Boroughs
    "BIG RUN",
    "BROCKWAY",
    "BROOKVILLE",
    "CORSICA",
    "FALLS CREEK",
    "PUNXSUTAWNEY",
    "REYNOLDSVILLE",
    "SUMMERVILLE",
    "SYKESVILLE",
    "TIMBLIN",
    "WORTHVILLE",

    // Townships
    "BARNETT",
    "BEAVER",
    "BELL",
    "CLOVER",
    "ELDRED",
    "GASKILL",
    "HEATH",
    "HENDERSON",
    "KNOX",
    "MCCALMONT",
    "OLIVER",
    "PERRY",
    "PINE CREEK",
    "POLK",
    "PORTER",
    "RINGGOLD",
    "ROSE",
    "SNYDER",
    "UNION",
    "WARSAW",
    "WASHINGTON",
    "WINSLOW",
    "YOUNG",
    
    // Unincoroporated community
    "SPRANKLE MILLS"

  };
}
