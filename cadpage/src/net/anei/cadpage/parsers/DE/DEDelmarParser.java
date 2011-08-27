package net.anei.cadpage.parsers.DE;


import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

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

 */


public class DEDelmarParser extends SmsMsgParser {
  
  public DEDelmarParser() {
    super("DELMAR", "DE");
  }
  
  @Override
  public String getFilter() {
    return "epage-owner@delmar74fire.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (body.length() < 95) return false;
    if (!subject.equals("CAD Alert")) return false;
    if (!body.substring(11,19).equals("Call at ")) return false;
    
    data.strUnit = body.substring(0,11).trim();
    parseAddress(body.substring(19,49).trim(), data);
    data.strPlace = body.substring(49,80).trim();
    int pt = body.indexOf("Problem ", 80);
    if (pt < 0) return false;
    data.strCall = body.substring(pt+8).trim();
    
    return true;
  }
}


