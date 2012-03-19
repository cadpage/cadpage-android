package net.anei.cadpage.parsers.DE;


import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Delmar DE, looking to implement second parser for MD
Contact: Kenny Love <kennylove989@gmail.com>
Contact: Steve Litchford <stevelitchford@gmail.com>
Sender: epage-owner@delmar74fire.com

(CAD Alert) 74AST      Call at 101 Delaware Ave              Delmar Nursing and RehabilitatCity19940      Problem Interfacillity/Palliative-ALS
(CAD Alert) 74AST      Call at 10411 Hearns Way                                             City19940      Problem Chest Pain-ALS
(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS
(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS
(CAD Alert) 74AST      Call at Holly Ct & Twelfth St         on foot                        City19940      Problem Abdominal Pain-ALS
(CAD Alert) 74A        Call at 38650 Sussex Hwy              Food Lion (74) at  appartments City19940      Problem Fire Nature Unknown
(CAD Alert) 74AST      Call at Sussex Hwy & Trussum Pond Rd  intersection by johnny  janosikCity 19956      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74ST       Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74AST      Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74A        Call at Pepperbox Rd & Brittingham Rd                                City19940      Problem Wires Down/Arching         
(CAD Alert) 74ST       Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire 
(CAD Alert) 74AS1      Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire
(CAD Alert) 74AST      Call at Whitesville Rd & Sussex Hwy                                  City 19956      Problem Traffic/TransportationAcdntBLS       
(CAD Alert) 74ST       Call at Sussex Hwy & Whitesville Rd                                  City19940      Problem Fire Nature Unknown
(CAD Alert) 74ST       Call at Connelly Mill Rd & Wood Creek                                City21875      Problem Trash Fire
(CAD Alert) 74ST       Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74AST      Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74B        Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74AST      Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74AS2      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Stroke-BLS
(CAD Alert) 74ST       Call at S 2nd St & E Walnut St                                       City21875      Problem Structure Fire
(CAD Alert) 74ST       Call at Ocean Hwy & Stage Rd                                         City21875      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74ST       Call at Rum Ridge & Williams Mill Pond                               City           Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74ST       Call at Pine St & Ocean Hwy                                          City21875      Problem Fire Nature Unknown
(CAD Alert) 74AST      Call at Bi State Blvd & Foskey Ln                                    City21875      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74AST      Call at Line Rd & Robin Hood Rd       yellow hse                     City21875      Problem Unknown Problem(Man Down)-ALS
(CAD Alert) 74AST      Call at Bi State Blvd & E State St                                   City           Problem Back Pain (Non Traumatic)-BLS
(CAD Alert) 74AS1      Call at Sussex Hwy & W Snake Rd                                      City19956      Problem Traffic/TransportationAcdntALS
(CAD Alert) 74AST      Call at Northwood Dr & Mavel Dr                                                     Problem Traffic/TransportationAcdntBLS
(CAD Alert) 74AS1      Call at Bi State Blvd & S Bi State Blv                               City19940      Problem Traffic/TransportationAcdntBLS

Agency name: Lewes Vol Fire CO Station 82 
Location: Millsboro, DE
Constact: support@active911.com
Sender: cad@sussexcountyde.gov
(CAD Alert) 82B        Call at 11 Hartford Way                                             City19958      Problem Gas Leak
(CAD Alert) 80ST       Call at 26002 John J Williams Hwy     Renaissance Nursing rm 114 / rCity19966      Problem Interfacillity/Palliative-ALS
(CAD Alert) 82B        Call at Robinsonville Rd & Seashell Bl                              City19958      Problem Traffic/TransportationAcdntBLS
(CAD Alert) 821        Call at 20415 Beaver Dam Rd                                         City19951      Problem Unconscious/Fainting(Near)-ALS
(CAD Alert) 821        Call at 25877 Prince St                                             City19966      Problem Sick Person(Specific Diag)-ALS
(CAD Alert) 821        Call at 30971 Buttonwood Dr                                         City19958      Problem Sick Person(Specific Diag)-BLS

*** Different format ***
(CAD Alert) 821    Call at: 403 Ingramtown Rd                       Loc:                               City: 19947      Problem: Traumatic Injuries-BLS           Lat:38691260    Long:75379283  Inc#:2012-005426         Disp:09:21:33Cross St:S KING ST/PARSONS LN       

 */


public class DEDelmarParser extends MsgParser {
  
  public DEDelmarParser() {
    super("DELMAR", "DE");
  }
  
  @Override
  public String getFilter() {
    return "epage-owner@delmar74fire.com,cad@sussexcountyde.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (body.length() < 95) return false;
    if (!subject.equals("CAD Alert")) return false;
    if (!body.substring(11,19).equals("Call at ")) return false;
    
    data.strUnit = body.substring(0,11).trim();
    parseAddress(body.substring(19,49).trim(), data);
    
    int pt = 49;
    int cityPt = body.indexOf("City", pt);
    if (cityPt >= 0) pt = cityPt+4;
    pt = body.indexOf("Problem ", pt);
    if (pt < 0) return false;
    data.strCall = body.substring(pt+8).trim();
    if (cityPt >= 0) {
      data.strCity = body.substring(cityPt+4, pt).trim();
      pt = cityPt;
    }
    data.strPlace = body.substring(49, pt).trim();
    
    return true;
  }
}


