package net.anei.cadpage.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Saint Marys County, MD
Contact: "Jason Adams" <jadams@bdvfd.org> or jadams@bdvfd.org or 2405384664@vzwpix.com
Contact: Brian Brown <brian.brown86@gmail.com>
Contact: patrick woodburn <patlvfd@gmail.com>
Sender: mplus@co.saint-marys.md.us
System: Pro QA Medical & Pro QA Fire

21:10:05*Personal Injury Accident*22607 THREE NOTCH RD INTERSECTN*MACARTHUR BL*LEXINGTON PARK*CO9 CO3 SQ3 CO39 CO79 A796*N/B LANES TWO VEHICLES AT LEAST ONE INJURY*
14:41:22*Personal Injury Accident*21050 WILLOWS RD INTERSECTN*ABBERLY CREST LN*LEXINGTON PARK*CO3 CO39 CO6R*
15:24:31*Working House Fire*20242 POINT LOOKOUT RD*OLD GREAT MILLS RD*INDIAN BRIDGE RD*GREAT MILLS*CO3 CO9 CO6 CO1 CO5 CO39 CO6R*
21:11:30*Commercial Building Fire*46528 VALLEY CT APT3019*SPRING VALLEY DR*DEAD END*LEXINGTON PARK*CO3 CO13 CO9 TK3 CO7 TK7 CO39*Using ProQA Fire*
23:14:28*Heart Problems*22521 IVERSON DR UNIT3*AMBER DR*CUL DE SAC*CALIFORNIA*CO9*55YOF C/A/B; RAPID HEART RATE AND WEAK; HX DIABETES;*
((37593) CAD ) 22:12:45*CO Detector With Symptons*21353 FOXGLOVE CT*DEAD END*BAYWOODS RD*HERMANVILLE*CO3 CO39*Using ProQA Fire*
((44333) CAD ) 00:35:39*CHIMNEY FIRE*25120 DOVE POINT LN*PARSONS MILL RD*DEAD END*LOVEVILLE*CO1 TK1 CO7*Using ProQA Fire*

((46589) CAD) 14:02:26*Stroke**APT A2**22027 OXFORD CT APTA2*GLOUCESTER CT*DEAD END*LEXINGTON PARK*CO39*Using ProQA Medical*
((46677) CAD) 13:59:56*Chest Pain*40452 MEDLEYS LN*LAUREL GROVE RD*LOVEVILLE RD*OAKVILLE*CO79 ALS*subject has pacemaker*
((46589) CAD) 13:29:15*Breathing Difficulties**ST MARYS NURSING CENTER**21585 PEABODY ST RM441A*HOLLYWOOD RD*DEAD END*LEONARDTOWN*CO19 CO79 ALS*hx copd*
((46589) CAD) 12:47:33*Chest Pain*17498 GRAYSON RD*BEACHVILLE RD*VILLA RD*ST INIGOES*CO49R ALS*Using ProQA Medical*
((46589) CAD) 12:14:40*Sick Person**NEWTOWNE VILLAGE APTS**22810 DORSEY ST APT309*CONNELY CT*DEAD END*LEONARDTOWN*CO19 CO79 A799*Using ProQA Medical*
((46589) CAD) 12:08:40*Sick Person*46104 SALTMARSH CT*WEST WESTBURY BL*DEAD END*LEXINGTON PARK*CO39 A397*Using ProQA Medical*
((47017) CAD ) 21:24:45*Seizures/Convulsions*THREE OAK CENTER*46905 LEI DR*THREE NOTCH RD*SOUTH CORAL DR*LEXINGTON PARK*ALS CO39*Using ProQA

 */


public class MDSaintMarysCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("\\b\\d\\d:\\d\\d:\\d\\d\\*");
  private static final Pattern PLACE = Pattern.compile("\\*\\*([^*]+)\\*\\*");
  
  public MDSaintMarysCountyParser() {
    super("SAINT MARYS COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "mplus@co.saint-marys.md.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.start());
    
    // Special case, field delimited by double starts is a place name
    // that should be removed from the message string
    match = PLACE.matcher(body);
    if (match.find()) {
      data.strPlace = body.substring(match.start(1), match.end(1));
      body = body.substring(0, match.start()+1) + body.substring(match.end());
    }
    
    String[] flds = body.split("\\*");
    if (flds.length < 6) return false;
    
    int ndx = 0;
    for (String fld : flds) {
      fld = fld.trim();
      switch (ndx++) {
      
      case 0:
        // Time - skip
        break;
      
      case 1:
        // Call description
        data.strCall = fld;
        break;
        
      case 2:
        // Address line
        if (fld.endsWith(" INTERSECTN")) {
          fld = fld.substring(0, fld.length()-11).trim();
        } else {
          ndx++;
        }
        
        // Parse the address
        parseAddress(StartType.START_ADDR, fld, data);
        
        // If it didn't look like an address, switch it to the
        // place name and try again with the next field
        if (getStatus() == 0 && data.strPlace.length() == 0) {
          data.strPlace = data.strAddress;
          data.strAddress = "";
          ndx -= 2;
          break;
        }
        
        // Otherwise, anything remaining is considered an apt
        data.strApt = getLeft();
        break;
        
      case 3:
        // intersecting street
        data.strAddress = data.strAddress + " & " + fld;
        ndx += 2;
        break;
        
      case 4:
        // Cross street 1
        data.strCross = fld;
        break;
        
      case 5:
        // Cross street 2
        data.strCross = data.strCross + " / " + fld;
        break;
        
      case 6:
        // town
        data.strCity = fld;
        break;
        
      case 7:
        // Units
        data.strUnit = fld;
        break;
        
      case 8:
        // Description
        data.strSupp = fld;
        break;
        
      case 9:
        // Additional description
        data.strSupp = data.strSupp + " / " + fld;
        ndx--;
        break;
      }
    }
    
    return true;
  }
}
