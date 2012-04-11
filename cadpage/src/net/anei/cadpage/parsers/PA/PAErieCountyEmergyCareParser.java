package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
EnergyCare (Erie County, PA)
Contact: "Thomas, George" <gthomas@emergycare.org>
System: Zoll RescueNet

Run# 17973/ 0087-A/ 08:55/ ALS/ Priority 1/ E 20TH ST & MCCLELLAND AVE/ 16510/ GREY PICKUP TRUCK/ ON 20TH/ W OF MCCLELLAND/ <PROQA_DET>/ MALE IN PICKUP PARKED ON SIDE OF ROAD SLUMPED OVER OFF TO THE SIDE UNK. EMD: 31D0/ ECDOPS: 2012-35555/ <Unknown>/ X=Buffalo Rd&E 20th St
Run# 17958/ 0081-A/ 08:17/ BLS/ Priority 1/ 2416 STATE ST/ 16503/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ BLS P1; 52 year old/ Female/ Unconscious/ Breathing. Convulsions /Seizures. Not seizing now and breathing effectively (verified) (Epileptic or Previous history of seizures). EMD: 12A1E/ ECDOPS: 2012-35545/ <Unknown>/ X=E 26th St&W 24th St
Run# 17945/ 0030-A/ 07:30/ Medical Taxi/ Priority 4 / VA Out of Town/ TANGLEWOOD APTS/ 16504/ 101 - BUILDING 819/ <PROQA_DET>/ VA MEDICAL CTR UNIVERSITY CAMPUS/ NU/ OWN CH/BILL VA/MCGUIRE WILL DO/ COCCARELLI/ ALBERT/ X=UNNAMED|WAYNE&WAYNE
Run# 17968/ 0045-A/ 09:30/ BLS/ Priority 3 / Local/ TWINBROOK MEDICAL CENTER/ 16511/ east 212/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ wound clinic for md meritz/ med nec for crew/ ms pt sacreal wounds nsa/ LAST NAME/ FIRST NAME/ X=PRIESTLEY&NAPIER
Run# 19857/ 0095-A/ 10:51/ BLS/ Priority 1/ 531 E 12TH ST/ 16503/ DOWNSTAIRS/ <PROQA_DET>/ SAINT VINCENT HEALTH CENTER/ BLS P1; 21 year old/ Male/ Conscious/ Breathing. Hemorrhage/ Lacerations. SERIOUS hemorrhage. EMD: 21B2/ ECDOPS: 2012-39719/ <Unknown>/ X=Wallace St&Ash St
Run# 19859/ 0096-A/ 10:58/ Paramedic Intercept/ Priority 1/ 10906 LAKE RD/ 16428/ <PROQA_DET>/ DISORIENTED PERSON/ ASSIST CRESCENT/ <Unknown>/ X=N Mill St
Run# 19866/ 0100-A/ 11:20/ BLS/ Priority 2/ 2912 COCHRAN ST/ 16508/ STAGE AWAY/ <PROQA_DET>/ BLS P1 / LAW; 40 year old/ Female/ Conscious/ Breathing. Psychiatric / AbnormalBehavior / Suicide Attempt. Non-SERIOUS or MINOR hemorrhage (Violent). EMD: 25B2V/ ECDOPS: 2012-39726/ <Unknown>/ X=W 31st St&W 29th St
Run# 19872/ 0104-A/ 11:44/ BLS W/ALS ASSIST/ Priority 1/ 1042 E 11TH ST/ 16503/ WITH ENGINE 8/ <PROQA_DET>/ BLS P1 / ALS P1; 38 year old/ Male/ Conscious/ Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1/ ECDOPS: 2012-39737/ <Unknown>/ X=Pennsylvania Ave&Brewster St
Run# 19860/ 0098-A/ 11:01/ ALS/ Priority 1/ DIALYSIS CENTER OF ERIE/ 16502/ LOBBY/ <PROQA_DET>/ BLS P1 / ALS P1; 71 year old/ Female/ Conscious/ Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1/ ECDOPS: 2012-39721/ <Unknown>/ X=17TH&16TH
Run# 19861/ 0099-A/ 11:07/ BLS/ Priority 1/ GRANDVIEW MANOR/ 16504/ 122/ <PROQA_DET>/ BLS PRIORITY 1; 92 year old/ Female/ Consciousness unknown/ Breathing status unknown. Unknown Problem (Man Down). EMD: 32B2/ ECDOPS: 2012-39722/ <Unknown>/ X=UNNAMED|UNNAMED&UNNAMED
Run# 19839/ 0044-B/ 09:41/ BLS/ Priority 3 / Local/ UPMC HAMOT MEDICAL CENTER/ 16550/ WOUND CLINIC/ <PROQA_DET>/ TWINBROOK MEDICAL CENTER/ NO SPEC ATTN/CREW TO GET MED NEC/HUTCHINSON/ CHARLES/ X=2ND&DOBBINS LANDING

 */


public class PAErieCountyEmergyCareParser extends DispatchProQAParser {
  
  public PAErieCountyEmergyCareParser() {
    super("ERIE COUNTY", "PA",
           "SKIP TIME CALL CALL? PRI ADDR PLACE? ZIP! INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.equals("Local") && data.strPlace.length() > 0) {
      data.strAddress = data.strPlace;
      data.strPlace = "";
    }
    return true;
  }

  private class MyPriorityField extends PriorityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Parser p = new Parser(field);
      if (!p.get(' ').equals("Priority")) return false;
      super.parse(p.get(), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyCityField extends CityField {
    public MyCityField() {
      setPattern(Pattern.compile("\\d{5}"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
