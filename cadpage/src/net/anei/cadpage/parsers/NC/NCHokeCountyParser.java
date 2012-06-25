package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchVisionAirParser;

/* 
Hoke County, NC
Contact:Dean Barefoot <muddybrute@gmail.com>
Sender: Hoke@hokecounty.org

Hoke Co 911:795 TC JONES RD* * * * * **EMD* * * * * * * * 09/15/2011 14:36:26 : pos4 : mblack3325 ** EMD Case Entry Finished ** Chief Complaint Number: 19 Key Q
Hoke Co 911:385 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 09/19/2011 06:20:35 : pos2 : SCOOPER9403 Cross streets: 7100 ARABIA RD//DEAD END Cross streets: 205
Hoke Co 911:6020 PHILLIPI CHURCH RD* * * * * **26 SICK PERS* * * * * * * * 09/18/2011 00:57:12 : pos1 : LGRADY7274 ** EMD Case Complete ** Key Questions: 46 yea
Hoke Co 911:6020 PHILLIPI CHURCH RD* * * * * **EMD* * * * * * * * 09/18/2011 00:56:49 : pos1 : LGRADY7274 ** EMD Recommended Dispatch ** Response Text: Alpha Di
Hoke Co 911:216 ROLLING PINES CT* * * * * **01 ABD PAIN* * * * * * * * 09/17/2011 19:54:51 : pos2 : SCOOPER9403 205 10-8 09/17/2011 19:54:38 : pos2 : SCOOPER940
Hoke Co 911:216 ROLLING PINES CT* * * * * **EMD* * * * * * * * 09/17/2011 19:37:54 : pos1 : LGRADY7274 ** EMD Recommended Dispatch ** Response Text: Alpha Dispa
Hoke Co 911:265 BETTY`S TRL* * * * * **EMD* * * * * * * * 09/16/2011 19:14:15 : pos2 : SCOOPER9403 Cross streets: 580 EVERITT RD//DEAD END WILL BE IN THE VERY E
Hoke Co 911:730 GALATIA CHURCH RD* * * * * **EMD* * * * * * * * 09/15/2011 13:51:27 : pos4 : mblack3325 Cross streets: 5365 ROCKFISH RD//CUMBERLAND CO LINE*

Contact: craig branan <craig.branan@gmail.com>
Sender: Hoke@hokecounty.org
Hoke Co 911:100 WAYSIDE RD* * * * * **AC/PI* * * * * * * * 04/25/2012 18:18:57 : pos2 : RCRUMPLER3351 Cross streets: FAYETTEVILLE RD//OLD OAK RD*

*/

public class NCHokeCountyParser extends DispatchVisionAirParser {
  
  public NCHokeCountyParser() {
    super("Hoke Co 911:", "HOKE COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "Hoke@hokecounty.org";
  }
}
