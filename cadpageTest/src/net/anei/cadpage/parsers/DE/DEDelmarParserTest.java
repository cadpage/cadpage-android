package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Delmar DE
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

Contact: Active911
Agency name: Lewes Fire Dept Location: Lewes, DE 
Sender: cad@sussexcountyde.gov
  
{CAD Alert} 82C    Call at: 16192 Coastal Hwy        Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-016487    Lat: 38765272    Long: 75211089   DISP: 22:55:31   Cross St: CAVE NECK RD/WILLOW CREEK RD
{CAD Alert} 82C    Call at: 16400 - 16499 HOWARD MILLLoc: 165                      City:19968  Problem:  Carbon Monoxide Detector        Inc#: 2012-016692    Lat: 38763432    Long: 75218628   DISP: 06:29:17   Cross St: MARSHALLS WAY/W ELIZA WILTBANK DR
{CAD Alert} 82B    Call at: 17232 N Village Main BlvdLoc: CHINA GARDEN             City:19958  Problem:  Fire Nature Unknown             Inc#: 2012-016724    Lat: 38751323    Long: 75168144   DISP: 13:28:47   Cross St: Savannah Rd/E Austin St
{CAD Alert} 829    Call at: State Rd & Canal St      Loc: 82 80rit                 City:19971  Problem:  Building Fire                   Inc#: 2012-016763    Lat: 38711863    Long: 75091665   DISP: 23:22:39   Cross St:
{CAD Alert} 82A    Call at: 115 Henlopen Shores Cir  Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-016794    Lat: 38781888    Long: 75109955   DISP: 10:47:41   Cross St: W CAPE SHORES DR/HARBOR PT
{CAD Alert} 82B    Call at: 17046 N Brandt St        Loc: Building 2 /             City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-016855    Lat: 38754065    Long: 75169936   DISP: 21:28:23   Cross St: E CHESAPEAKE ST/E EDGEMOOR ST
{CAD Alert} 829    Call at: 70 - 73 Roberts Rd       Loc: 8                        City:19958  Problem:  Alarm Company                   Inc#: 2012-016971    Lat: 38760024    Long: 75189927   DISP: 04:38:04   Cross St: OLD MILL RD/Dead End
{CAD Alert} 82A    Call at: 1270 Kings Hwy           Loc: Cape Henlopen district ofCity:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-017063    Lat: 38755501    Long: 75148380   DISP: 08:45:46   Cross St: UNNAMED STREET/UNNAMED STREET
{CAD Alert} 829    Call at: Plantations Rd & Postal LLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017132    Lat: 38732931    Long: 75153973   DISP: 01:02:13   Cross St:
{CAD Alert} 82ST   Call at: 26674 Hollyville Rd      Loc: Indian Meadows           City:19966  Problem:  Structure Fire                  Inc#: 2012-017137    Lat: 38613503    Long: 75279391   DISP: 05:18:46   Cross St: INDIAN MEADOWS DR/WASHINGTON ST EXT
{CAD Alert} 82ST   Call at: 301 Ocean View Blvd      Loc: Harbor Health Care 306 / City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-017152    Lat: 38773939    Long: 75154864   DISP: 09:44:45   Cross St: Canary Dr/Unnamed Street
{CAD Alert} 82A    Call at: 18030 1 Hwy              Loc: Troop 7-1.2 mile south ofCity:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017179    Lat: 38746854    Long: 75156901   DISP: 15:35:17   Cross St: Savannah West Sq/Westcoats Rd
{CAD Alert} 82ST   Call at: Pelican Square           Loc: in front of Marshalls    City:       Problem:  Child Locked in Vehicle         Inc#: 2012-017262    Lat: 0           Long: 0          DISP: 16:26:01   Cross St:
{CAD Alert} 82ST   Call at: 130 Bay Ave              Loc: breakwater hse/ apt h    City:19958  Problem:  Alarm Company                   Inc#: 2012-017268    Lat: 38781318    Long: 75133405   DISP: 17:01:58   Cross St: UNNAMED STREET/BAYVIEW AVE
{CAD Alert} 829    Call at: 130 Bay Ave              Loc: breakwater hse/ apt h    City:19958  Problem:  Alarm Company                   Inc#: 2012-017268    Lat: 38781318    Long: 75133405   DISP: 17:01:58   Cross St: UNNAMED STREET/BAYVIEW AVE
{CAD Alert} 829    Call at: 18578 - 18598 Coastal HwyLoc: itao laptop shop         City:19971  Problem:  Structure Fire                  Inc#: 2012-017296    Lat: 38736764    Long: 75141543   DISP: 21:25:51   Cross St: MELSON RD/MIDWAY OUTLET DR
{CAD Alert} 82A    Call at: 0 Bayview Ave            Loc:                          City:19958  Problem:  Water Rescue Priority 2         Inc#: 2012-017369    Lat: 38781479    Long: 75131539   DISP: 15:25:13   Cross St: SAVANNAH RD/VIRGINA AVE
{CAD Alert} 82ST   Call at: 32818 Ocean Reach Dr     Loc:                          City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-017436    Lat: 38741231    Long: 75172143   DISP: 10:43:56   Cross St: CAPE DR S/Dead End
{CAD Alert} 829    Call at: Postal Ln & Plantations RLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017438    Lat: 38732931    Long: 75153973   DISP: 10:57:45   Cross St:
{CAD Alert} 82ST   Call at: 11 - 14 Cape Henlopen Dr Loc:                          City:19958  Problem:  Water Rescue Priority 2         Inc#: 2012-017445    Lat: 38780401    Long: 75130889   DISP: 13:38:14   Cross St: MARYLAND AVE/VIRGINA AVE
{CAD Alert} 82C    Call at: 31169 Learning Ln        Loc: Beach Babies             City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-017524    Lat: 38762001    Long: 75207815   DISP: 11:39:46   Cross St: BEST LN/Coastal Hwy
{CAD Alert} 82A    Call at: 1 - 99 Georgia Ave       Loc: Padle boarder out cant geCity:19958  Problem:  Water Rescue Priority 1         Inc#: 2012-017716    Lat: 38781434    Long: 75127698   DISP: 11:32:44   Cross St: CAPE HENLOPEN DR/Dead End
{CAD Alert} 821    Call at: 6 Prospect St            Loc:                          City:19971  Problem:  Structure Fire                  Inc#: 2012-017788    Lat: 38707672    Long: 75075380   DISP: 08:10:57   Cross St: Dead End/E LAKE DR
{CAD Alert} 82ST   Call at: Old Mill Rd & Coastal HwyLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017791    Lat: 38755225    Long: 75193906   DISP: 08:56:41   Cross St:
{CAD Alert} 829    Call at: 6 Prospect St            Loc:                          City:19971  Problem:  Structure Fire                  Inc#: 2012-017788    Lat: 38707672    Long: 75075380   DISP: 08:10:57   Cross St: Dead End/E LAKE DR
{CAD Alert} 82B    Call at: 9 Bristol Way            Loc: Sussex East T.P.         City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017852    Lat: 38741121    Long: 75200134   DISP: 21:52:59   Cross St: Andover Ln/Sheffield Dr
{CAD Alert} 82ST   Call at: 0 Cape May-lewes Ferry EnLoc: entrance                 City:19958  Problem:  Electrical Hazard               Inc#: 2012-017855    Lat: 38780042    Long: 75120311   DISP: 22:34:49   Cross St: CAPE HENLOPEN DR/CAPE MAY-LEWES
{CAD Alert} 82A    Call at: 17689 Coastal Hwy        Loc: furniture gallery        City:19958  Problem:  Alarm Company                   Inc#: 2012-017929    Lat: 38748450    Long: 75167407   DISP: 14:23:28   Cross St: CONNECTING ROAD/SHADY RD
{CAD Alert} 82ST   Call at: 33106 N Village Loop     Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-017930    Lat: 38754082    Long: 75172653   DISP: 14:27:49   Cross St: W EDGEMOOR ST/W EDGEMOOR ST
{CAD Alert} 82B    Call at: 31104 Sycamore Dr        Loc:                          City:19958  Problem:  Structure Fire                  Inc#: 2012-017935    Lat: 38755469    Long: 75209271   DISP: 14:42:02   Cross St: EDGEWATER DR/EDGEWATER DR
{CAD Alert} 82A    Call at: 17476 Slipper Shell Way  Loc:                          City:19958  Problem:  Elevator/Escalator Rescue       Inc#: 2012-017950    Lat: 38747133    Long: 75181218   DISP: 16:25:39   Cross St: MARSH PERRIWINKLE WAY/COQUINA WAY
{CAD Alert} 82ST   Call at: 34521 Postal Ln          Loc:                          City:19958  Problem:  Unconscious/Fainting(Near)-ALS  Inc#: 2012-017954    Lat: 38737020    Long: 75146269   DISP: 17:07:55   Cross St: OAK LN/MELSON RD
{CAD Alert} 82B    Call at: 16707 Snipe Dr           Loc:                          City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-017999    Lat: 38758982    Long: 75187542   DISP: 10:10:31   Cross St: Dead End/SANDPIPER DR
{CAD Alert} 82C    Call at: 17754 - 17924 Coastal HwyLoc: S/B Lane, Home Depot     City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018003    Lat: 38748461    Long: 75165260   DISP: 10:37:15   Cross St: SHADY RD/CONNECTING ROAD
{CAD Alert} 82C    Call at: 31200 - 31319 Kendale Rd Loc: wgmd radio station       City:19958  Problem:  Alarm Company                   Inc#: 2012-018030    Lat: 38715357    Long: 75206236   DISP: 17:25:47   Cross St: WIL KING RD/BEAVER DAM RD
{CAD Alert} 829    Call at: 31549 DUTTON LN          Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-018030    Lat: 38703561    Long: 75200883   DISP: 17:25:47   Cross St: WIL KING RD/Dead End
{CAD Alert} 82ST   Call at: 1 - 5 Rehoboth Ave       Loc: and the beach 82 for a boCity:19971  Problem:  Water Rescue Priority 1         Inc#: 2012-018046    Lat: 38716698    Long: 75076329   DISP: 19:20:50   Cross St: 1ST ST/1ST ST
{CAD Alert} 82C    Call at: 17436 Slipper Shell Way  Loc:                          City:19958  Problem:  Elevator/Escalator Rescue       Inc#: 2012-018072    Lat: 38748484    Long: 75181128   DISP: 02:56:17   Cross St: JANTHINA WAY/MARSH PERRIWINKLE WAY
{CAD Alert} 82A    Call at: 17832 Coastal Hwy        Loc: Home Depot (82)  s/b     City:       Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018119    Lat: 38748333    Long: 75161667   DISP: 15:07:07   Cross St:
{CAD Alert} 82ST   Call at: 35018 - 35031 Midway OutlLoc: talbots                  City:19971  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-018126    Lat: 38734703    Long: 75139179   DISP: 16:04:13   Cross St: Dead End/COASTAL HWY
{CAD Alert} 829    Call at: 0 Olde Coach Dr          Loc:                          City:19971  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018134    Lat: 38736062    Long: 75135594   DISP: 17:44:17   Cross St: LANTERN LN/SPINNING WHEEL LN
{CAD Alert} 82ST   Call at: 37792 Cape Henlopen Dr   Loc: Cape May Lewes Ferry/entrCity:19958  Problem:  Vehicle Fire                    Inc#: 2012-018194    Lat: 38794534    Long: 75091265   DISP: 10:40:54   Cross St: Unnamed Street/Unnamed Street
{CAD Alert} 82ST   Call at: 17028 Cadbury Cir        Loc: Cadbury at Lewes         City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-018201    Lat: 38754979    Long: 75140089   DISP: 12:35:05   Cross St: Dead End/Dead End
{CAD Alert} 82B    Call at: 17832 Coastal Hwy        Loc: Home Depot (82)          City:       Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018205    Lat: 38748333    Long: 75161667   DISP: 12:52:51   Cross St:
{CAD Alert} 829    Call at: 16727 Coastal Hwy        Loc: Beach Marine             City:19958  Problem:  Alarm Company                   Inc#: 2012-018223    Lat: 38756857    Long: 75196351   DISP: 15:41:36   Cross St: UNNAMED STREET/MINOS CONAWAY RD
{CAD Alert} 829    Call at: Coastal Hwy & Old Postal Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018292    Lat: 38738870    Long: 75144670   DISP: 12:28:59   Cross St:
{CAD Alert} 829    Call at: 18385 Coastal Hwy        Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018340    Lat: 38740321    Long: 75146857   DISP: 20:22:19   Cross St: AMERICAN WAY/OLD POSTAL LN
{CAD Alert} 829    Call at: 802 Pilottown Rd         Loc: USCG Finance Center      City:19958  Problem:  Alarm Company                   Inc#: 2012-018344    Lat: 38790564    Long: 75167505   DISP: 21:05:24   Cross St: UNNAMED STREET/Dead End
{CAD Alert} 829    Call at: 18385 Coastal Hwy        Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018340    Lat: 38740321    Long: 75146857   DISP: 20:22:19   Cross St: AMERICAN WAY/OLD POSTAL LN
{CAD Alert} 82C    Call at: 17054 N Brandt St        Loc: town center east condo buCity:19958  Problem:  Alarm Company                   Inc#: 2012-018453    Lat: 38754474    Long: 75170471   DISP: 10:57:37   Cross St: E CHESAPEAKE ST/E EDGEMOOR ST
{CAD Alert} 82C    Call at: 31168 Learning Ln        Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-018478    Lat: 38761986    Long: 75207828   DISP: 15:00:27   Cross St: BEST LN/Dead End
{CAD Alert} 829    Call at: 1 Sheffield Ct           Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-018488    Lat: 38740214    Long: 75153041   DISP: 17:20:16   Cross St: GAINSBOROUGH DR/Dead End
{CAD Alert} 82B    Call at: 34341 Summerlyn Dr       Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-018521    Lat: 38741146    Long: 75150810   DISP: 01:01:21   Cross St: Dead End/COASTAL HWY
{CAD Alert} 82ST   Call at: Coast Guard Lewes        Loc: CAUTION:  WIRELESS CALL  City:       Problem:  Mutual Aid/Assist               Inc#: 2012-018574    Lat: 0           Long: 0          DISP: 17:35:01   Cross St:
{CAD Alert} 82A    Call at: 18501 Highway One        Loc: MIDWAY SHOPPING CENTER   City:19971  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018591    Lat: 38737917    Long: 75143285   DISP: 22:25:48   Cross St: Midway Shopping Ctr/Melson Rd
{CAD Alert} 82C    Call at: Dartmouth Dr & Coastal HwLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018638    Lat: 38744927    Long: 75153809   DISP: 12:03:11   Cross St:
{CAD Alert} 82B    Call at: 18998 Coastal Hwy        Loc: McDonalds (82)-in front oCity:19971  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018648    Lat: 38731871    Long: 75134182   DISP: 15:34:52   Cross St: John J Williams Hwy/Highway One
{CAD Alert} 82ST   Call at: 38 48'24.83"n & 075 05'53Loc: of the cape point        City:       Problem:  Water Rescue Priority 1         Inc#: 2012-018766    Lat: 38806897    Long: 75098268   DISP: 18:45:56   Cross St:
{CAD Alert} 82ST   Call at: 0 0                      Loc: Exxon 2 (82)             City:       Problem:  Odor Investigation              Inc#: 2012-018874    Lat: 0           Long: 0          DISP: 22:47:22   Cross St:
{CAD Alert} 82ST   Call at: 34445 King Street Row    Loc:                          City:19958  Problem:  Electrical Fire                 Inc#: 2012-018913    Lat: 38744150    Long: 75149973   DISP: 13:08:53   Cross St: KINGS HWY/Dead End
{CAD Alert} 82ST   Call at: Burger King              Loc: n/b lanes                City:       Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018989    Lat: 0           Long: 0          DISP: 12:28:57   Cross St:
{CAD Alert} 82ST   Call at: 33755 Reservoir Dr       Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-019014    Lat: 38710849    Long: 75215148   DISP: 17:46:42   Cross St: PARK PAVILLION WAY/HIGHLANDS WAY
{CAD Alert} 82ST   Call at: 18451 Coastal Hwy        Loc:                          City:19958  Problem:  Outside Fire                    Inc#: 2012-019035    Lat: 38739109    Long: 75145030   DISP: 22:05:04   Cross St: AMERICAN WAY/OLD POSTAL LN
{CAD Alert} 82C    Call at: 20715 Annondell Dr       Loc:                          City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-019041    Lat: 38706598    Long: 75160206   DISP: 23:28:16   Cross St: HIGH KNOLL RD/SPENCER LN
{CAD Alert} 82A    Call at: John J Williams Hwy & HolLoc:                          City:19966  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-019104    Lat: 38668378    Long: 75188499   DISP: 16:23:59   Cross St:
{CAD Alert} 82A    Call at: 27537 Briar Ln           Loc:                          City:19966  Problem:  Structure Fire                  Inc#: 2012-019142    Lat: 38609628    Long: 75199961   DISP: 02:04:44   Cross St: OAK MEADOW DR/OAK MEADOW DR
{CAD Alert} 82A    Call at: 18955 Goldfinch Cv       Loc:                          City:19971  Problem:  Automatic Fire Alarm            Inc#: 2012-019178    Lat: 38726002    Long: 75143120   DISP: 12:39:32   Cross St: DOT SPARROW DR/Dead End
{CAD Alert} 82ST   Call at: 17120 Ockels Ln          Loc:                          City:19968  Problem:  Structure Fire                  Inc#: 2012-019223    Lat: 38753837    Long: 75363309   DISP: 01:01:44   Cross St: Dead End/E REDDEN RD
{CAD Alert} 82ST   Call at: John J Williams & PlantioLoc:                          City:       Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-019262    Lat: 0           Long: 0          DISP: 12:54:58   Cross St:
{CAD Alert} 82ST   Call at: 301 Ocean View Blvd      Loc: Harbor Health Care       City:19958  Problem:  Interfacillity/Palliative-BLS   Inc#: 2012-019340    Lat: 38773939    Long: 75154864   DISP: 10:57:14   Cross St: Canary Dr/Unnamed Street
{CAD Alert} 82B    Call at: 17776 Seashore Dr        Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-019371    Lat: 38743683    Long: 75176991   DISP: 15:27:30   Cross St: E LIGHT DR/INLET WAY
{CAD Alert} 82B    Call at: 28379 Martins Farm Rd    Loc:                          City:19968  Problem:  Structure Fire                  Inc#: 2012-019400    Lat: 38721310    Long: 75251407   DISP: 18:51:24   Cross St: HUNTER DR/NIKAIN LN
{CAD Alert} 82ST   Call at: 1 - 28 Wilmington Ave    Loc: and boards               City:19971  Problem:  Assist                          Inc#: 2012-019405    Lat: 38715709    Long: 75076171   DISP: 19:29:17   Cross St: Dead End/1ST ST
{CAD Alert} 82A    Call at: 1800 Bay Ave             Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-019417    Lat: 38785546    Long: 75149459   DISP: 21:03:34   Cross St: UNNAMED STREET/MICHIGAN AVE
{CAD Alert} 82A    Call at: 41 Inlet View Ct         Loc:                          City:19930  Problem:  Structure Fire                  Inc#: 2012-019445    Lat: 38605377    Long: 75075299   DISP: 00:56:19   Cross St: S SHORE DR/Dead End
{CAD Alert} 82C    Call at: 34155 High Knoll Rd      Loc: x from                   City:19958  Problem:  Structure Fire                  Inc#: 2012-019470    Lat: 38707447    Long: 75162007   DISP: 05:39:55   Cross St: ANNONDELL DR/ANNONDELL DR
{CAD Alert} 82A    Call at: 22256 - 22345 RobinsonvilLoc:                          City:19958  Problem:  Service Call                    Inc#: 2012-019471    Lat: 38679542    Long: 75184534   DISP: 05:47:04   Cross St: CONLEYS CHAPEL RD/JOHN J WILLIAMS HWY
{CAD Alert} 82B    Call at: 34150 High Knoll Rd      Loc:                          City:19958  Problem:  Structure Fire                  Inc#: 2012-019496    Lat: 38707361    Long: 75161870   DISP: 10:48:17   Cross St: ANNONDELL DR/ANNONDELL DR
{CAD Alert} 82C    Call at: 25870 Lingo Ln           Loc:                          City:19966  Problem:  Structure Fire                  Inc#: 2012-019566    Lat: 38631577    Long: 75173867   DISP: 04:52:17   Cross St: LINGO RD/LONG NECK RD
{CAD Alert} 82A    Call at: 114 Ethird St            Loc:                          City:       Problem:  Automatic Fire Alarm            Inc#: 2012-019569    Lat: 0           Long: 0          DISP: 05:40:41   Cross St:
{CAD Alert} 82A    Call at: 34453 King Street Row    Loc: suit 2DELAWARE CARDIOVASCCity:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-019622    Lat: 38744064    Long: 75149850   DISP: 16:49:21   Cross St: KINGS HWY/Dead End
{CAD Alert} 82A    Call at: 5 Bryan Dr               Loc:                          City:19971  Problem:  Child Locked in Vehicle         Inc#: 2012-019675    Lat: 38736188    Long: 75136420   DISP: 02:18:15   Cross St: SABRINA DR/TIFFANY DR
{CAD Alert} 82B    Call at: 28200 - 28361 Elizabeth SLoc:                          City:19966  Problem:  Structure Fire                  Inc#: 2012-019749    Lat: 38600017    Long: 75175399   DISP: 22:23:25   Cross St: BOWDEN ST/BOWDEN ST
{CAD Alert} 82A    Call at: 48 Spinning Wheel Ln     Loc:                          City:19971  Problem:  Carbon Monoxide Detector        Inc#: 2012-020008    Lat: 38735468    Long: 75133564   DISP: 23:18:22   Cross St: CARRIAGE LN/OLDE COACH DR
{CAD Alert} 821    Call at: 22100 - 22107 Holly Oak LLoc: In the area              City:19958  Problem:  Outside Fire                    Inc#: 2012-020046    Lat: 38684481    Long: 75197641   DISP: 11:28:55   Cross St: DORMAN RD/Dead End
{CAD Alert} 82C    Call at: 32002 Conleys Chapel Rd  Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-020079    Lat: 38686127    Long: 75190321   DISP: 17:15:00   Cross St: ANCIENT OAK DR/LAVENDER LN
{CAD Alert} 82ST   Call at: 0 Saint Lawrence St      Loc:                          City:19971  Problem:  Water Rescue Priority 1         Inc#: 2012-020091    Lat: 38708664    Long: 75080891   DISP: 19:03:44   Cross St: BAYARD AVE/BAYARD AVE
{CAD Alert} 82A    Call at: 20025 Wil King Rd        Loc:                          City:19958  Problem:  Smoke Investigation             Inc#: 2012-020094    Lat: 38714995    Long: 75203618   DISP: 19:24:48   Cross St: KENDALE RD/HOLLY AVE
{CAD Alert} 82ST   Call at: 13849 Steamboat Landing RLoc:                          City:19968  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-020216    Lat: 38798252    Long: 75244220   DISP: 01:35:02   Cross St: WHITES NECK WAY/Dead End
{CAD Alert} 82A    Call at: 70 - 73 Roberts Rd       Loc: #3                       City:19958  Problem:  Breathing Problems-ALS          Inc#: 2012-020218    Lat: 38760024    Long: 75189927   DISP: 02:30:34   Cross St: OLD MILL RD/Dead End
{CAD Alert} 82C    Call at: 34682 Villa Cir          Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-020230    Lat: 38742766    Long: 75146585   DISP: 08:53:34   Cross St: BAY CROSSING BLVD/BAY CROSSING BLVD
{CAD Alert} 82ST   Call at: 0 Roosevelt Inlet        Loc: Roosevelt Inlet          City:19968  Problem:  Watercraft in Distress          Inc#: 2012-020234    Lat: 0           Long: 0          DISP: 09:22:43   Cross St:
{CAD Alert} 82B    Call at: 32544 Lewes Georgetown HwLoc: rear entrance to ACE HardCity:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-020662    Lat: 38747388    Long: 75176098   DISP: 23:19:44   Cross St: CONNECTING ROAD/CONNECTING ROAD
{CAD Alert} 82ST   Call at: Savannah Rd & E 4th St   Loc:                          City:       Problem:  Washdown (Fuel Spill)           Inc#: 2012-020708    Lat: 0           Long: 0          DISP: 14:01:03   Cross St:

 */

public class DEDelmarParserTest extends BaseParserTest {
  
  public DEDelmarParserTest() {
    setParser(new DEDelmarParser(), "DELMAR", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Alert) 74AST      Call at 101 Delaware Ave              Delmar Nursing and RehabilitatCity19940      Problem Interfacillity/Palliative-ALS",
        "UNIT:74AST",
        "ADDR:101 Delaware Ave",
        "PLACE:Delmar Nursing and Rehabilitat",
        "CITY:19940",
        "CALL:Interfacillity/Palliative-ALS");

    doTest("T2",
        "(CAD Alert) 74AST      Call at 10411 Hearns Way                                             City19940      Problem Chest Pain-ALS",
        "UNIT:74AST",
        "ADDR:10411 Hearns Way",
        "CITY:19940",
        "CALL:Chest Pain-ALS");

    doTest("T3",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CITY:19940",
        "CALL:Heart Problems/ AICD-BLS");

    doTest("T4",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CITY:19940",
        "CALL:Heart Problems/ AICD-BLS");

    doTest("T5",
        "(CAD Alert) 74AST      Call at Holly Ct & Twelfth St         on foot                        City19940      Problem Abdominal Pain-ALS",
        "UNIT:74AST",
        "ADDR:Holly Ct & Twelfth St",
        "PLACE:on foot",
        "CITY:19940",
        "CALL:Abdominal Pain-ALS");

    doTest("T6",
        "(CAD Alert) 74A        Call at 38650 Sussex Hwy              Food Lion (74) at  appartments City19940      Problem Fire Nature Unknown",
        "UNIT:74A",
        "ADDR:38650 Sussex Hwy",
        "PLACE:Food Lion (74) at  appartments",
        "CITY:19940",
        "CALL:Fire Nature Unknown");

    doTest("T7",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Trussum Pond Rd  intersection by johnny  janosikCity 19956      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Trussum Pond Rd",
        "PLACE:intersection by johnny  janosik",
        "CITY:19956",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T8",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Iron Hill Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T9",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Iron Hill Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T10",
        "(CAD Alert) 74A        Call at Pepperbox Rd & Brittingham Rd                                City19940      Problem Wires Down/Arching         ",
        "UNIT:74A",
        "ADDR:Pepperbox Rd & Brittingham Rd",
        "CITY:19940",
        "CALL:Wires Down/Arching");

    doTest("T11",
        "(CAD Alert) 74ST       Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire ",
        "UNIT:74ST",
        "ADDR:Jackson Rd & Saint George Rd",
        "CITY:19940",
        "CALL:Structure Fire");

    doTest("T12",
        "(CAD Alert) 74AS1      Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire",
        "UNIT:74AS1",
        "ADDR:Jackson Rd & Saint George Rd",
        "CITY:19940",
        "CALL:Structure Fire");

    doTest("T13",
        "(CAD Alert) 74AST      Call at Whitesville Rd & Sussex Hwy                                  City 19956      Problem Traffic/TransportationAcdntBLS       ",
        "UNIT:74AST",
        "ADDR:Whitesville Rd & Sussex Hwy",
        "CITY:19956",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T14",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Whitesville Rd                                  City19940      Problem Fire Nature Unknown",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Whitesville Rd",
        "CITY:19940",
        "CALL:Fire Nature Unknown");

    doTest("T15",
        "(CAD Alert) 74ST       Call at Connelly Mill Rd & Wood Creek                                City21875      Problem Trash Fire",
        "UNIT:74ST",
        "ADDR:Connelly Mill Rd & Wood Creek",
        "CITY:21875",
        "CALL:Trash Fire");

    doTest("T16",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Line Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T17",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Line Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T18",
        "(CAD Alert) 74B        Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74B",
        "ADDR:Line Rd & Rum Ridge Rd",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T19",
        "(CAD Alert) 74AST      Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Line Rd & Rum Ridge Rd",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T20",
        "(CAD Alert) 74AS2      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Stroke-BLS",
        "UNIT:74AS2",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CITY:19940",
        "CALL:Stroke-BLS");

    doTest("T21",
        "(CAD Alert) 74ST       Call at S 2nd St & E Walnut St                                       City21875      Problem Structure Fire",
        "UNIT:74ST",
        "ADDR:S 2nd St & E Walnut St",
        "CITY:21875",
        "CALL:Structure Fire");

    doTest("T22",
        "(CAD Alert) 74ST       Call at Ocean Hwy & Stage Rd                                         City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Ocean Hwy & Stage Rd",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T23",
        "(CAD Alert) 74ST       Call at Rum Ridge & Williams Mill Pond                               City           Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Rum Ridge & Williams Mill Pond",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T24",
        "(CAD Alert) 74ST       Call at Pine St & Ocean Hwy                                          City21875      Problem Fire Nature Unknown",
        "UNIT:74ST",
        "ADDR:Pine St & Ocean Hwy",
        "CITY:21875",
        "CALL:Fire Nature Unknown");

    doTest("T25",
        "(CAD Alert) 74AST      Call at Bi State Blvd & Foskey Ln                                    City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & Foskey Ln",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T26",
        "(CAD Alert) 74AST      Call at Line Rd & Robin Hood Rd       yellow hse                     City21875      Problem Unknown Problem(Man Down)-ALS",
        "UNIT:74AST",
        "ADDR:Line Rd & Robin Hood Rd",
        "PLACE:yellow hse",
        "CITY:21875",
        "CALL:Unknown Problem(Man Down)-ALS");

    doTest("T27",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E State St                                   City           Problem Back Pain (Non Traumatic)-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E State St",
        "CALL:Back Pain (Non Traumatic)-BLS");

    doTest("T28",
        "(CAD Alert) 74AS1      Call at Sussex Hwy & W Snake Rd                                      City19956      Problem Traffic/TransportationAcdntALS",
        "UNIT:74AS1",
        "ADDR:Sussex Hwy & W Snake Rd",
        "CITY:19956",
        "CALL:Traffic/TransportationAcdntALS");

    doTest("T29",
        "(CAD Alert) 74AST      Call at Northwood Dr & Mavel Dr                                                     Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Northwood Dr & Mavel Dr",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T30",
        "(CAD Alert) 74AS1      Call at Bi State Blvd & S Bi State Blv                               City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AS1",
        "ADDR:Bi State Blvd & S Bi State Blv",
        "MADDR:Bi State Blvd & S Bi State Blvd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");
   }
  
  @Test
  public void testMillsboro() {

    doTest("T1",
        "(CAD Alert) 82B        Call at 11 Hartford Way                                             City19958      Problem Gas Leak",
        "UNIT:82B",
        "ADDR:11 Hartford Way",
        "CITY:19958",
        "CALL:Gas Leak");

    doTest("T2",
        "(CAD Alert) 80ST       Call at 26002 John J Williams Hwy     Renaissance Nursing rm 114 / rCity19966      Problem Interfacillity/Palliative-ALS",
        "UNIT:80ST",
        "ADDR:26002 John J Williams Hwy",
        "PLACE:Renaissance Nursing rm 114 / r",
        "CITY:19966",
        "CALL:Interfacillity/Palliative-ALS");

    doTest("T3",
        "(CAD Alert) 82B        Call at Robinsonville Rd & Seashell Bl                              City19958      Problem Traffic/TransportationAcdntBLS",
        "UNIT:82B",
        "ADDR:Robinsonville Rd & Seashell Bl",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T4",
        "(CAD Alert) 821        Call at 20415 Beaver Dam Rd                                         City19951      Problem Unconscious/Fainting(Near)-ALS",
        "UNIT:821",
        "ADDR:20415 Beaver Dam Rd",
        "CITY:19951",
        "CALL:Unconscious/Fainting(Near)-ALS");

    doTest("T5",
        "(CAD Alert) 821        Call at 25877 Prince St                                             City19966      Problem Sick Person(Specific Diag)-ALS",
        "UNIT:821",
        "ADDR:25877 Prince St",
        "CITY:19966",
        "CALL:Sick Person(Specific Diag)-ALS");

    doTest("T6",
        "(CAD Alert) 821        Call at 30971 Buttonwood Dr                                         City19958      Problem Sick Person(Specific Diag)-BLS",
        "UNIT:821",
        "ADDR:30971 Buttonwood Dr",
        "CITY:19958",
        "CALL:Sick Person(Specific Diag)-BLS");
  }
  
  @Test
  public void testLewis() {

    doTest("T1",
        "{CAD Alert} 82C    Call at: 16192 Coastal Hwy        Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-016487    Lat: 38765272    Long: 75211089   DISP: 22:55:31   Cross St: CAVE NECK RD/WILLOW CREEK RD",
        "UNIT:82C",
        "ADDR:16192 Coastal Hwy",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-016487",
        "TIME:22:55:31",
        "X:CAVE NECK RD/WILLOW CREEK RD");

    doTest("T2",
        "{CAD Alert} 82C    Call at: 16400 - 16499 HOWARD MILLLoc: 165                      City:19968  Problem:  Carbon Monoxide Detector        Inc#: 2012-016692    Lat: 38763432    Long: 75218628   DISP: 06:29:17   Cross St: MARSHALLS WAY/W ELIZA WILTBANK DR",
        "UNIT:82C",
        "ADDR:16400 - 16499 HOWARD MILL",
        "MADDR:16400 HOWARD MILL",
        "PLACE:165",
        "CITY:19968",
        "CALL:Carbon Monoxide Detector",
        "ID:2012-016692",
        "TIME:06:29:17",
        "X:MARSHALLS WAY/W ELIZA WILTBANK DR");

    doTest("T3",
        "{CAD Alert} 82B    Call at: 17232 N Village Main BlvdLoc: CHINA GARDEN             City:19958  Problem:  Fire Nature Unknown             Inc#: 2012-016724    Lat: 38751323    Long: 75168144   DISP: 13:28:47   Cross St: Savannah Rd/E Austin St",
        "UNIT:82B",
        "ADDR:17232 N Village Main Blvd",
        "PLACE:CHINA GARDEN",
        "CITY:19958",
        "CALL:Fire Nature Unknown",
        "ID:2012-016724",
        "TIME:13:28:47",
        "X:Savannah Rd/E Austin St");

    doTest("T4",
        "{CAD Alert} 829    Call at: State Rd & Canal St      Loc: 82 80rit                 City:19971  Problem:  Building Fire                   Inc#: 2012-016763    Lat: 38711863    Long: 75091665   DISP: 23:22:39   Cross St:",
        "UNIT:829",
        "ADDR:State Rd & Canal St",
        "PLACE:82 80rit",
        "CITY:19971",
        "CALL:Building Fire",
        "ID:2012-016763",
        "TIME:23:22:39");

    doTest("T5",
        "{CAD Alert} 82A    Call at: 115 Henlopen Shores Cir  Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-016794    Lat: 38781888    Long: 75109955   DISP: 10:47:41   Cross St: W CAPE SHORES DR/HARBOR PT",
        "UNIT:82A",
        "ADDR:115 Henlopen Shores Cir",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-016794",
        "TIME:10:47:41",
        "X:W CAPE SHORES DR/HARBOR PT");

    doTest("T6",
        "{CAD Alert} 82B    Call at: 17046 N Brandt St        Loc: Building 2 /             City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-016855    Lat: 38754065    Long: 75169936   DISP: 21:28:23   Cross St: E CHESAPEAKE ST/E EDGEMOOR ST",
        "UNIT:82B",
        "ADDR:17046 N Brandt St",
        "PLACE:Building 2 /",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-016855",
        "TIME:21:28:23",
        "X:E CHESAPEAKE ST/E EDGEMOOR ST");

    doTest("T7",
        "{CAD Alert} 829    Call at: 70 - 73 Roberts Rd       Loc: 8                        City:19958  Problem:  Alarm Company                   Inc#: 2012-016971    Lat: 38760024    Long: 75189927   DISP: 04:38:04   Cross St: OLD MILL RD/Dead End",
        "UNIT:829",
        "ADDR:70 - 73 Roberts Rd",
        "MADDR:70 Roberts Rd",
        "PLACE:8",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-016971",
        "TIME:04:38:04",
        "X:OLD MILL RD/Dead End");

    doTest("T8",
        "{CAD Alert} 82A    Call at: 1270 Kings Hwy           Loc: Cape Henlopen district ofCity:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-017063    Lat: 38755501    Long: 75148380   DISP: 08:45:46   Cross St: UNNAMED STREET/UNNAMED STREET",
        "UNIT:82A",
        "ADDR:1270 Kings Hwy",
        "PLACE:Cape Henlopen district of",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-017063",
        "TIME:08:45:46",
        "X:UNNAMED STREET/UNNAMED STREET");

    doTest("T9",
        "{CAD Alert} 829    Call at: Plantations Rd & Postal LLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017132    Lat: 38732931    Long: 75153973   DISP: 01:02:13   Cross St:",
        "UNIT:829",
        "ADDR:Plantations Rd & Postal L",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-017132",
        "TIME:01:02:13");

    doTest("T10",
        "{CAD Alert} 82ST   Call at: 26674 Hollyville Rd      Loc: Indian Meadows           City:19966  Problem:  Structure Fire                  Inc#: 2012-017137    Lat: 38613503    Long: 75279391   DISP: 05:18:46   Cross St: INDIAN MEADOWS DR/WASHINGTON ST EXT",
        "UNIT:82ST",
        "ADDR:26674 Hollyville Rd",
        "PLACE:Indian Meadows",
        "CITY:19966",
        "CALL:Structure Fire",
        "ID:2012-017137",
        "TIME:05:18:46",
        "X:INDIAN MEADOWS DR/WASHINGTON ST EXT");

    doTest("T11",
        "{CAD Alert} 82ST   Call at: 301 Ocean View Blvd      Loc: Harbor Health Care 306 / City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-017152    Lat: 38773939    Long: 75154864   DISP: 09:44:45   Cross St: Canary Dr/Unnamed Street",
        "UNIT:82ST",
        "ADDR:301 Ocean View Blvd",
        "PLACE:Harbor Health Care 306 /",
        "CITY:19958",
        "CALL:Cardiac/Resp./Death-ALS",
        "ID:2012-017152",
        "TIME:09:44:45",
        "X:Canary Dr/Unnamed Street");

    doTest("T12",
        "{CAD Alert} 82A    Call at: 18030 1 Hwy              Loc: Troop 7-1.2 mile south ofCity:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017179    Lat: 38746854    Long: 75156901   DISP: 15:35:17   Cross St: Savannah West Sq/Westcoats Rd",
        "UNIT:82A",
        "ADDR:18030 1 Hwy",
        "MADDR:18030 Hwy 1",
        "PLACE:Troop 7-1.2 mile south of",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-017179",
        "TIME:15:35:17",
        "X:Savannah West Sq/Westcoats Rd");

    doTest("T13",
        "{CAD Alert} 82ST   Call at: Pelican Square           Loc: in front of Marshalls    City:       Problem:  Child Locked in Vehicle         Inc#: 2012-017262    Lat: 0           Long: 0          DISP: 16:26:01   Cross St:",
        "UNIT:82ST",
        "ADDR:Pelican Square",
        "MADDR:in front of Marshalls,Pelican Square",
        "PLACE:in front of Marshalls",
        "CALL:Child Locked in Vehicle",
        "ID:2012-017262",
        "TIME:16:26:01");

    doTest("T14",
        "{CAD Alert} 82ST   Call at: 130 Bay Ave              Loc: breakwater hse/ apt h    City:19958  Problem:  Alarm Company                   Inc#: 2012-017268    Lat: 38781318    Long: 75133405   DISP: 17:01:58   Cross St: UNNAMED STREET/BAYVIEW AVE",
        "UNIT:82ST",
        "ADDR:130 Bay Ave",
        "PLACE:breakwater hse/ apt h",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-017268",
        "TIME:17:01:58",
        "X:UNNAMED STREET/BAYVIEW AVE");

    doTest("T15",
        "{CAD Alert} 829    Call at: 130 Bay Ave              Loc: breakwater hse/ apt h    City:19958  Problem:  Alarm Company                   Inc#: 2012-017268    Lat: 38781318    Long: 75133405   DISP: 17:01:58   Cross St: UNNAMED STREET/BAYVIEW AVE",
        "UNIT:829",
        "ADDR:130 Bay Ave",
        "PLACE:breakwater hse/ apt h",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-017268",
        "TIME:17:01:58",
        "X:UNNAMED STREET/BAYVIEW AVE");

    doTest("T16",
        "{CAD Alert} 829    Call at: 18578 - 18598 Coastal HwyLoc: itao laptop shop         City:19971  Problem:  Structure Fire                  Inc#: 2012-017296    Lat: 38736764    Long: 75141543   DISP: 21:25:51   Cross St: MELSON RD/MIDWAY OUTLET DR",
        "UNIT:829",
        "ADDR:18578 - 18598 Coastal Hwy",
        "MADDR:18578 Coastal Hwy",
        "PLACE:itao laptop shop",
        "CITY:19971",
        "CALL:Structure Fire",
        "ID:2012-017296",
        "TIME:21:25:51",
        "X:MELSON RD/MIDWAY OUTLET DR");

    doTest("T17",
        "{CAD Alert} 82A    Call at: 0 Bayview Ave            Loc:                          City:19958  Problem:  Water Rescue Priority 2         Inc#: 2012-017369    Lat: 38781479    Long: 75131539   DISP: 15:25:13   Cross St: SAVANNAH RD/VIRGINA AVE",
        "UNIT:82A",
        "ADDR:0 Bayview Ave",
        "CITY:19958",
        "CALL:Water Rescue Priority 2",
        "ID:2012-017369",
        "TIME:15:25:13",
        "X:SAVANNAH RD/VIRGINA AVE");

    doTest("T18",
        "{CAD Alert} 82ST   Call at: 32818 Ocean Reach Dr     Loc:                          City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-017436    Lat: 38741231    Long: 75172143   DISP: 10:43:56   Cross St: CAPE DR S/Dead End",
        "UNIT:82ST",
        "ADDR:32818 Ocean Reach Dr",
        "CITY:19958",
        "CALL:Cardiac/Resp./Death-ALS",
        "ID:2012-017436",
        "TIME:10:43:56",
        "X:CAPE DR S/Dead End");

    doTest("T19",
        "{CAD Alert} 829    Call at: Postal Ln & Plantations RLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017438    Lat: 38732931    Long: 75153973   DISP: 10:57:45   Cross St:",
        "UNIT:829",
        "ADDR:Postal Ln & Plantations R",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-017438",
        "TIME:10:57:45");

    doTest("T20",
        "{CAD Alert} 82ST   Call at: 11 - 14 Cape Henlopen Dr Loc:                          City:19958  Problem:  Water Rescue Priority 2         Inc#: 2012-017445    Lat: 38780401    Long: 75130889   DISP: 13:38:14   Cross St: MARYLAND AVE/VIRGINA AVE",
        "UNIT:82ST",
        "ADDR:11 - 14 Cape Henlopen Dr",
        "MADDR:11 Cape Henlopen Dr",
        "CITY:19958",
        "CALL:Water Rescue Priority 2",
        "ID:2012-017445",
        "TIME:13:38:14",
        "X:MARYLAND AVE/VIRGINA AVE");

    doTest("T21",
        "{CAD Alert} 82C    Call at: 31169 Learning Ln        Loc: Beach Babies             City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-017524    Lat: 38762001    Long: 75207815   DISP: 11:39:46   Cross St: BEST LN/Coastal Hwy",
        "UNIT:82C",
        "ADDR:31169 Learning Ln",
        "PLACE:Beach Babies",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-017524",
        "TIME:11:39:46",
        "X:BEST LN/Coastal Hwy");

    doTest("T22",
        "{CAD Alert} 82A    Call at: 1 - 99 Georgia Ave       Loc: Padle boarder out cant geCity:19958  Problem:  Water Rescue Priority 1         Inc#: 2012-017716    Lat: 38781434    Long: 75127698   DISP: 11:32:44   Cross St: CAPE HENLOPEN DR/Dead End",
        "UNIT:82A",
        "ADDR:1 - 99 Georgia Ave",
        "MADDR:1 Georgia Ave",
        "PLACE:Padle boarder out cant ge",
        "CITY:19958",
        "CALL:Water Rescue Priority 1",
        "ID:2012-017716",
        "TIME:11:32:44",
        "X:CAPE HENLOPEN DR/Dead End");

    doTest("T23",
        "{CAD Alert} 821    Call at: 6 Prospect St            Loc:                          City:19971  Problem:  Structure Fire                  Inc#: 2012-017788    Lat: 38707672    Long: 75075380   DISP: 08:10:57   Cross St: Dead End/E LAKE DR",
        "UNIT:821",
        "ADDR:6 Prospect St",
        "CITY:19971",
        "CALL:Structure Fire",
        "ID:2012-017788",
        "TIME:08:10:57",
        "X:Dead End/E LAKE DR");

    doTest("T24",
        "{CAD Alert} 82ST   Call at: Old Mill Rd & Coastal HwyLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017791    Lat: 38755225    Long: 75193906   DISP: 08:56:41   Cross St:",
        "UNIT:82ST",
        "ADDR:Old Mill Rd & Coastal Hwy",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-017791",
        "TIME:08:56:41");

    doTest("T25",
        "{CAD Alert} 829    Call at: 6 Prospect St            Loc:                          City:19971  Problem:  Structure Fire                  Inc#: 2012-017788    Lat: 38707672    Long: 75075380   DISP: 08:10:57   Cross St: Dead End/E LAKE DR",
        "UNIT:829",
        "ADDR:6 Prospect St",
        "CITY:19971",
        "CALL:Structure Fire",
        "ID:2012-017788",
        "TIME:08:10:57",
        "X:Dead End/E LAKE DR");

    doTest("T26",
        "{CAD Alert} 82B    Call at: 9 Bristol Way            Loc: Sussex East T.P.         City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-017852    Lat: 38741121    Long: 75200134   DISP: 21:52:59   Cross St: Andover Ln/Sheffield Dr",
        "UNIT:82B",
        "ADDR:9 Bristol Way",
        "PLACE:Sussex East T.P.",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-017852",
        "TIME:21:52:59",
        "X:Andover Ln/Sheffield Dr");

    doTest("T27",
        "{CAD Alert} 82ST   Call at: 0 Cape May-lewes Ferry EnLoc: entrance                 City:19958  Problem:  Electrical Hazard               Inc#: 2012-017855    Lat: 38780042    Long: 75120311   DISP: 22:34:49   Cross St: CAPE HENLOPEN DR/CAPE MAY-LEWES",
        "UNIT:82ST",
        "ADDR:0 Cape May-lewes Ferry En",
        "PLACE:entrance",
        "CITY:19958",
        "CALL:Electrical Hazard",
        "ID:2012-017855",
        "TIME:22:34:49",
        "X:CAPE HENLOPEN DR/CAPE MAY-LEWES");

    doTest("T28",
        "{CAD Alert} 82A    Call at: 17689 Coastal Hwy        Loc: furniture gallery        City:19958  Problem:  Alarm Company                   Inc#: 2012-017929    Lat: 38748450    Long: 75167407   DISP: 14:23:28   Cross St: CONNECTING ROAD/SHADY RD",
        "UNIT:82A",
        "ADDR:17689 Coastal Hwy",
        "PLACE:furniture gallery",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-017929",
        "TIME:14:23:28",
        "X:CONNECTING ROAD/SHADY RD");

    doTest("T29",
        "{CAD Alert} 82ST   Call at: 33106 N Village Loop     Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-017930    Lat: 38754082    Long: 75172653   DISP: 14:27:49   Cross St: W EDGEMOOR ST/W EDGEMOOR ST",
        "UNIT:82ST",
        "ADDR:33106 N Village Loop",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-017930",
        "TIME:14:27:49",
        "X:W EDGEMOOR ST/W EDGEMOOR ST");

    doTest("T30",
        "{CAD Alert} 82B    Call at: 31104 Sycamore Dr        Loc:                          City:19958  Problem:  Structure Fire                  Inc#: 2012-017935    Lat: 38755469    Long: 75209271   DISP: 14:42:02   Cross St: EDGEWATER DR/EDGEWATER DR",
        "UNIT:82B",
        "ADDR:31104 Sycamore Dr",
        "CITY:19958",
        "CALL:Structure Fire",
        "ID:2012-017935",
        "TIME:14:42:02",
        "X:EDGEWATER DR/EDGEWATER DR");

    doTest("T31",
        "{CAD Alert} 82A    Call at: 17476 Slipper Shell Way  Loc:                          City:19958  Problem:  Elevator/Escalator Rescue       Inc#: 2012-017950    Lat: 38747133    Long: 75181218   DISP: 16:25:39   Cross St: MARSH PERRIWINKLE WAY/COQUINA WAY",
        "UNIT:82A",
        "ADDR:17476 Slipper Shell Way",
        "CITY:19958",
        "CALL:Elevator/Escalator Rescue",
        "ID:2012-017950",
        "TIME:16:25:39",
        "X:MARSH PERRIWINKLE WAY/COQUINA WAY");

    doTest("T32",
        "{CAD Alert} 82ST   Call at: 34521 Postal Ln          Loc:                          City:19958  Problem:  Unconscious/Fainting(Near)-ALS  Inc#: 2012-017954    Lat: 38737020    Long: 75146269   DISP: 17:07:55   Cross St: OAK LN/MELSON RD",
        "UNIT:82ST",
        "ADDR:34521 Postal Ln",
        "CITY:19958",
        "CALL:Unconscious/Fainting(Near)-ALS",
        "ID:2012-017954",
        "TIME:17:07:55",
        "X:OAK LN/MELSON RD");

    doTest("T33",
        "{CAD Alert} 82B    Call at: 16707 Snipe Dr           Loc:                          City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-017999    Lat: 38758982    Long: 75187542   DISP: 10:10:31   Cross St: Dead End/SANDPIPER DR",
        "UNIT:82B",
        "ADDR:16707 Snipe Dr",
        "CITY:19958",
        "CALL:Cardiac/Resp./Death-ALS",
        "ID:2012-017999",
        "TIME:10:10:31",
        "X:Dead End/SANDPIPER DR");

    doTest("T34",
        "{CAD Alert} 82C    Call at: 17754 - 17924 Coastal HwyLoc: S/B Lane, Home Depot     City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018003    Lat: 38748461    Long: 75165260   DISP: 10:37:15   Cross St: SHADY RD/CONNECTING ROAD",
        "UNIT:82C",
        "ADDR:17754 - 17924 Coastal Hwy",
        "MADDR:17754 Coastal Hwy",
        "PLACE:S/B Lane, Home Depot",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018003",
        "TIME:10:37:15",
        "X:SHADY RD/CONNECTING ROAD");

    doTest("T35",
        "{CAD Alert} 82C    Call at: 31200 - 31319 Kendale Rd Loc: wgmd radio station       City:19958  Problem:  Alarm Company                   Inc#: 2012-018030    Lat: 38715357    Long: 75206236   DISP: 17:25:47   Cross St: WIL KING RD/BEAVER DAM RD",
        "UNIT:82C",
        "ADDR:31200 - 31319 Kendale Rd",
        "MADDR:31200 Kendale Rd",
        "PLACE:wgmd radio station",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-018030",
        "TIME:17:25:47",
        "X:WIL KING RD/BEAVER DAM RD");

    doTest("T36",
        "{CAD Alert} 829    Call at: 31549 DUTTON LN          Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-018030    Lat: 38703561    Long: 75200883   DISP: 17:25:47   Cross St: WIL KING RD/Dead End",
        "UNIT:829",
        "ADDR:31549 DUTTON LN",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-018030",
        "TIME:17:25:47",
        "X:WIL KING RD/Dead End");

    doTest("T37",
        "{CAD Alert} 82ST   Call at: 1 - 5 Rehoboth Ave       Loc: and the beach 82 for a boCity:19971  Problem:  Water Rescue Priority 1         Inc#: 2012-018046    Lat: 38716698    Long: 75076329   DISP: 19:20:50   Cross St: 1ST ST/1ST ST",
        "UNIT:82ST",
        "ADDR:1 - 5 Rehoboth Ave",
        "MADDR:1 Rehoboth Ave",
        "PLACE:and the beach 82 for a bo",
        "CITY:19971",
        "CALL:Water Rescue Priority 1",
        "ID:2012-018046",
        "TIME:19:20:50",
        "X:1ST ST/1ST ST");

    doTest("T38",
        "{CAD Alert} 82C    Call at: 17436 Slipper Shell Way  Loc:                          City:19958  Problem:  Elevator/Escalator Rescue       Inc#: 2012-018072    Lat: 38748484    Long: 75181128   DISP: 02:56:17   Cross St: JANTHINA WAY/MARSH PERRIWINKLE WAY",
        "UNIT:82C",
        "ADDR:17436 Slipper Shell Way",
        "CITY:19958",
        "CALL:Elevator/Escalator Rescue",
        "ID:2012-018072",
        "TIME:02:56:17",
        "X:JANTHINA WAY/MARSH PERRIWINKLE WAY");

    doTest("T39",
        "{CAD Alert} 82A    Call at: 17832 Coastal Hwy        Loc: Home Depot (82)  s/b     City:       Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018119    Lat: 38748333    Long: 75161667   DISP: 15:07:07   Cross St:",
        "UNIT:82A",
        "ADDR:17832 Coastal Hwy",
        "PLACE:Home Depot (82)  s/b",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018119",
        "TIME:15:07:07");

    doTest("T40",
        "{CAD Alert} 82ST   Call at: 35018 - 35031 Midway OutlLoc: talbots                  City:19971  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-018126    Lat: 38734703    Long: 75139179   DISP: 16:04:13   Cross St: Dead End/COASTAL HWY",
        "UNIT:82ST",
        "ADDR:35018 - 35031 Midway Outl",
        "MADDR:35018 Midway Outl",
        "PLACE:talbots",
        "CITY:19971",
        "CALL:Cardiac/Resp./Death-ALS",
        "ID:2012-018126",
        "TIME:16:04:13",
        "X:Dead End/COASTAL HWY");

    doTest("T41",
        "{CAD Alert} 829    Call at: 0 Olde Coach Dr          Loc:                          City:19971  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018134    Lat: 38736062    Long: 75135594   DISP: 17:44:17   Cross St: LANTERN LN/SPINNING WHEEL LN",
        "UNIT:829",
        "ADDR:0 Olde Coach Dr",
        "CITY:19971",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018134",
        "TIME:17:44:17",
        "X:LANTERN LN/SPINNING WHEEL LN");

    doTest("T42",
        "{CAD Alert} 82ST   Call at: 37792 Cape Henlopen Dr   Loc: Cape May Lewes Ferry/entrCity:19958  Problem:  Vehicle Fire                    Inc#: 2012-018194    Lat: 38794534    Long: 75091265   DISP: 10:40:54   Cross St: Unnamed Street/Unnamed Street",
        "UNIT:82ST",
        "ADDR:37792 Cape Henlopen Dr",
        "PLACE:Cape May Lewes Ferry/entr",
        "CITY:19958",
        "CALL:Vehicle Fire",
        "ID:2012-018194",
        "TIME:10:40:54",
        "X:Unnamed Street/Unnamed Street");

    doTest("T43",
        "{CAD Alert} 82ST   Call at: 17028 Cadbury Cir        Loc: Cadbury at Lewes         City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-018201    Lat: 38754979    Long: 75140089   DISP: 12:35:05   Cross St: Dead End/Dead End",
        "UNIT:82ST",
        "ADDR:17028 Cadbury Cir",
        "PLACE:Cadbury at Lewes",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-018201",
        "TIME:12:35:05",
        "X:Dead End/Dead End");

    doTest("T44",
        "{CAD Alert} 82B    Call at: 17832 Coastal Hwy        Loc: Home Depot (82)          City:       Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018205    Lat: 38748333    Long: 75161667   DISP: 12:52:51   Cross St:",
        "UNIT:82B",
        "ADDR:17832 Coastal Hwy",
        "PLACE:Home Depot (82)",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-018205",
        "TIME:12:52:51");

    doTest("T45",
        "{CAD Alert} 829    Call at: 16727 Coastal Hwy        Loc: Beach Marine             City:19958  Problem:  Alarm Company                   Inc#: 2012-018223    Lat: 38756857    Long: 75196351   DISP: 15:41:36   Cross St: UNNAMED STREET/MINOS CONAWAY RD",
        "UNIT:829",
        "ADDR:16727 Coastal Hwy",
        "PLACE:Beach Marine",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-018223",
        "TIME:15:41:36",
        "X:UNNAMED STREET/MINOS CONAWAY RD");

    doTest("T46",
        "{CAD Alert} 829    Call at: Coastal Hwy & Old Postal Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018292    Lat: 38738870    Long: 75144670   DISP: 12:28:59   Cross St:",
        "UNIT:829",
        "ADDR:Coastal Hwy & Old Postal",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-018292",
        "TIME:12:28:59");

    doTest("T47",
        "{CAD Alert} 829    Call at: 18385 Coastal Hwy        Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018340    Lat: 38740321    Long: 75146857   DISP: 20:22:19   Cross St: AMERICAN WAY/OLD POSTAL LN",
        "UNIT:829",
        "ADDR:18385 Coastal Hwy",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-018340",
        "TIME:20:22:19",
        "X:AMERICAN WAY/OLD POSTAL LN");

    doTest("T48",
        "{CAD Alert} 829    Call at: 802 Pilottown Rd         Loc: USCG Finance Center      City:19958  Problem:  Alarm Company                   Inc#: 2012-018344    Lat: 38790564    Long: 75167505   DISP: 21:05:24   Cross St: UNNAMED STREET/Dead End",
        "UNIT:829",
        "ADDR:802 Pilottown Rd",
        "PLACE:USCG Finance Center",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-018344",
        "TIME:21:05:24",
        "X:UNNAMED STREET/Dead End");

    doTest("T49",
        "{CAD Alert} 829    Call at: 18385 Coastal Hwy        Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-018340    Lat: 38740321    Long: 75146857   DISP: 20:22:19   Cross St: AMERICAN WAY/OLD POSTAL LN",
        "UNIT:829",
        "ADDR:18385 Coastal Hwy",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-018340",
        "TIME:20:22:19",
        "X:AMERICAN WAY/OLD POSTAL LN");

    doTest("T50",
        "{CAD Alert} 82C    Call at: 17054 N Brandt St        Loc: town center east condo buCity:19958  Problem:  Alarm Company                   Inc#: 2012-018453    Lat: 38754474    Long: 75170471   DISP: 10:57:37   Cross St: E CHESAPEAKE ST/E EDGEMOOR ST",
        "UNIT:82C",
        "ADDR:17054 N Brandt St",
        "PLACE:town center east condo bu",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-018453",
        "TIME:10:57:37",
        "X:E CHESAPEAKE ST/E EDGEMOOR ST");

    doTest("T51",
        "{CAD Alert} 82C    Call at: 31168 Learning Ln        Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-018478    Lat: 38761986    Long: 75207828   DISP: 15:00:27   Cross St: BEST LN/Dead End",
        "UNIT:82C",
        "ADDR:31168 Learning Ln",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-018478",
        "TIME:15:00:27",
        "X:BEST LN/Dead End");

    doTest("T52",
        "{CAD Alert} 829    Call at: 1 Sheffield Ct           Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-018488    Lat: 38740214    Long: 75153041   DISP: 17:20:16   Cross St: GAINSBOROUGH DR/Dead End",
        "UNIT:829",
        "ADDR:1 Sheffield Ct",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-018488",
        "TIME:17:20:16",
        "X:GAINSBOROUGH DR/Dead End");

    doTest("T53",
        "{CAD Alert} 82B    Call at: 34341 Summerlyn Dr       Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-018521    Lat: 38741146    Long: 75150810   DISP: 01:01:21   Cross St: Dead End/COASTAL HWY",
        "UNIT:82B",
        "ADDR:34341 Summerlyn Dr",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-018521",
        "TIME:01:01:21",
        "X:Dead End/COASTAL HWY");

    doTest("T54",
        "{CAD Alert} 82ST   Call at: Coast Guard Lewes        Loc: CAUTION:  WIRELESS CALL  City:       Problem:  Mutual Aid/Assist               Inc#: 2012-018574    Lat: 0           Long: 0          DISP: 17:35:01   Cross St:",
        "UNIT:82ST",
        "ADDR:Coast Guard Lewes",
        "MADDR:CAUTION:  WIRELESS CALL,Coast Guard Lewes",
        "PLACE:CAUTION:  WIRELESS CALL",
        "CALL:Mutual Aid/Assist",
        "ID:2012-018574",
        "TIME:17:35:01");

    doTest("T55",
        "{CAD Alert} 82A    Call at: 18501 Highway One        Loc: MIDWAY SHOPPING CENTER   City:19971  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018591    Lat: 38737917    Long: 75143285   DISP: 22:25:48   Cross St: Midway Shopping Ctr/Melson Rd",
        "UNIT:82A",
        "ADDR:18501 Highway One",
        "PLACE:MIDWAY SHOPPING CENTER",
        "CITY:19971",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018591",
        "TIME:22:25:48",
        "X:Midway Shopping Ctr/Melson Rd");

    doTest("T56",
        "{CAD Alert} 82C    Call at: Dartmouth Dr & Coastal HwLoc:                          City:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018638    Lat: 38744927    Long: 75153809   DISP: 12:03:11   Cross St:",
        "UNIT:82C",
        "ADDR:Dartmouth Dr & Coastal Hw",
        "MADDR:Dartmouth Dr & Coastal Hwy",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018638",
        "TIME:12:03:11");

    doTest("T57",
        "{CAD Alert} 82B    Call at: 18998 Coastal Hwy        Loc: McDonalds (82)-in front oCity:19971  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018648    Lat: 38731871    Long: 75134182   DISP: 15:34:52   Cross St: John J Williams Hwy/Highway One",
        "UNIT:82B",
        "ADDR:18998 Coastal Hwy",
        "PLACE:McDonalds (82)-in front o",
        "CITY:19971",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018648",
        "TIME:15:34:52",
        "X:John J Williams Hwy/Highway One");

    doTest("T58",
        "{CAD Alert} 82ST   Call at: 38 48'24.83\"n & 075 05'53Loc: of the cape point        City:       Problem:  Water Rescue Priority 1         Inc#: 2012-018766    Lat: 38806897    Long: 75098268   DISP: 18:45:56   Cross St:",
        "UNIT:82ST",
        "ADDR:38 48'24.83\"n & 075 05'53",
        "MADDR:38 48'24.83\"n",
        "PLACE:of the cape point",
        "CALL:Water Rescue Priority 1",
        "ID:2012-018766",
        "TIME:18:45:56");

    doTest("T59",
        "{CAD Alert} 82ST   Call at: 0 0                      Loc: Exxon 2 (82)             City:       Problem:  Odor Investigation              Inc#: 2012-018874    Lat: 0           Long: 0          DISP: 22:47:22   Cross St:",
        "UNIT:82ST",
        "ADDR:0 0",
        "PLACE:Exxon 2 (82)",
        "CALL:Odor Investigation",
        "ID:2012-018874",
        "TIME:22:47:22");

    doTest("T60",
        "{CAD Alert} 82ST   Call at: 34445 King Street Row    Loc:                          City:19958  Problem:  Electrical Fire                 Inc#: 2012-018913    Lat: 38744150    Long: 75149973   DISP: 13:08:53   Cross St: KINGS HWY/Dead End",
        "UNIT:82ST",
        "ADDR:34445 King Street Row",
        "CITY:19958",
        "CALL:Electrical Fire",
        "ID:2012-018913",
        "TIME:13:08:53",
        "X:KINGS HWY/Dead End");

    doTest("T61",
        "{CAD Alert} 82ST   Call at: Burger King              Loc: n/b lanes                City:       Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-018989    Lat: 0           Long: 0          DISP: 12:28:57   Cross St:",
        "UNIT:82ST",
        "ADDR:Burger King",
        "MADDR:n/b lanes,Burger King",
        "PLACE:n/b lanes",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-018989",
        "TIME:12:28:57");

    doTest("T62",
        "{CAD Alert} 82ST   Call at: 33755 Reservoir Dr       Loc:                          City:19958  Problem:  Alarm Company                   Inc#: 2012-019014    Lat: 38710849    Long: 75215148   DISP: 17:46:42   Cross St: PARK PAVILLION WAY/HIGHLANDS WAY",
        "UNIT:82ST",
        "ADDR:33755 Reservoir Dr",
        "CITY:19958",
        "CALL:Alarm Company",
        "ID:2012-019014",
        "TIME:17:46:42",
        "X:PARK PAVILLION WAY/HIGHLANDS WAY");

    doTest("T63",
        "{CAD Alert} 82ST   Call at: 18451 Coastal Hwy        Loc:                          City:19958  Problem:  Outside Fire                    Inc#: 2012-019035    Lat: 38739109    Long: 75145030   DISP: 22:05:04   Cross St: AMERICAN WAY/OLD POSTAL LN",
        "UNIT:82ST",
        "ADDR:18451 Coastal Hwy",
        "CITY:19958",
        "CALL:Outside Fire",
        "ID:2012-019035",
        "TIME:22:05:04",
        "X:AMERICAN WAY/OLD POSTAL LN");

    doTest("T64",
        "{CAD Alert} 82C    Call at: 20715 Annondell Dr       Loc:                          City:19958  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-019041    Lat: 38706598    Long: 75160206   DISP: 23:28:16   Cross St: HIGH KNOLL RD/SPENCER LN",
        "UNIT:82C",
        "ADDR:20715 Annondell Dr",
        "CITY:19958",
        "CALL:Cardiac/Resp./Death-ALS",
        "ID:2012-019041",
        "TIME:23:28:16",
        "X:HIGH KNOLL RD/SPENCER LN");

    doTest("T65",
        "{CAD Alert} 82A    Call at: John J Williams Hwy & HolLoc:                          City:19966  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-019104    Lat: 38668378    Long: 75188499   DISP: 16:23:59   Cross St:",
        "UNIT:82A",
        "ADDR:John J Williams Hwy & Hol",
        "CITY:19966",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-019104",
        "TIME:16:23:59");

    doTest("T66",
        "{CAD Alert} 82A    Call at: 27537 Briar Ln           Loc:                          City:19966  Problem:  Structure Fire                  Inc#: 2012-019142    Lat: 38609628    Long: 75199961   DISP: 02:04:44   Cross St: OAK MEADOW DR/OAK MEADOW DR",
        "UNIT:82A",
        "ADDR:27537 Briar Ln",
        "CITY:19966",
        "CALL:Structure Fire",
        "ID:2012-019142",
        "TIME:02:04:44",
        "X:OAK MEADOW DR/OAK MEADOW DR");

    doTest("T67",
        "{CAD Alert} 82A    Call at: 18955 Goldfinch Cv       Loc:                          City:19971  Problem:  Automatic Fire Alarm            Inc#: 2012-019178    Lat: 38726002    Long: 75143120   DISP: 12:39:32   Cross St: DOT SPARROW DR/Dead End",
        "UNIT:82A",
        "ADDR:18955 Goldfinch Cv",
        "CITY:19971",
        "CALL:Automatic Fire Alarm",
        "ID:2012-019178",
        "TIME:12:39:32",
        "X:DOT SPARROW DR/Dead End");

    doTest("T68",
        "{CAD Alert} 82ST   Call at: 17120 Ockels Ln          Loc:                          City:19968  Problem:  Structure Fire                  Inc#: 2012-019223    Lat: 38753837    Long: 75363309   DISP: 01:01:44   Cross St: Dead End/E REDDEN RD",
        "UNIT:82ST",
        "ADDR:17120 Ockels Ln",
        "CITY:19968",
        "CALL:Structure Fire",
        "ID:2012-019223",
        "TIME:01:01:44",
        "X:Dead End/E REDDEN RD");

    doTest("T69",
        "{CAD Alert} 82ST   Call at: John J Williams & PlantioLoc:                          City:       Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-019262    Lat: 0           Long: 0          DISP: 12:54:58   Cross St:",
        "UNIT:82ST",
        "ADDR:John J Williams & Plantio",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-019262",
        "TIME:12:54:58");

    doTest("T70",
        "{CAD Alert} 82ST   Call at: 301 Ocean View Blvd      Loc: Harbor Health Care       City:19958  Problem:  Interfacillity/Palliative-BLS   Inc#: 2012-019340    Lat: 38773939    Long: 75154864   DISP: 10:57:14   Cross St: Canary Dr/Unnamed Street",
        "UNIT:82ST",
        "ADDR:301 Ocean View Blvd",
        "PLACE:Harbor Health Care",
        "CITY:19958",
        "CALL:Interfacillity/Palliative-BLS",
        "ID:2012-019340",
        "TIME:10:57:14",
        "X:Canary Dr/Unnamed Street");

    doTest("T71",
        "{CAD Alert} 82B    Call at: 17776 Seashore Dr        Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-019371    Lat: 38743683    Long: 75176991   DISP: 15:27:30   Cross St: E LIGHT DR/INLET WAY",
        "UNIT:82B",
        "ADDR:17776 Seashore Dr",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-019371",
        "TIME:15:27:30",
        "X:E LIGHT DR/INLET WAY");

    doTest("T72",
        "{CAD Alert} 82B    Call at: 28379 Martins Farm Rd    Loc:                          City:19968  Problem:  Structure Fire                  Inc#: 2012-019400    Lat: 38721310    Long: 75251407   DISP: 18:51:24   Cross St: HUNTER DR/NIKAIN LN",
        "UNIT:82B",
        "ADDR:28379 Martins Farm Rd",
        "CITY:19968",
        "CALL:Structure Fire",
        "ID:2012-019400",
        "TIME:18:51:24",
        "X:HUNTER DR/NIKAIN LN");

    doTest("T73",
        "{CAD Alert} 82ST   Call at: 1 - 28 Wilmington Ave    Loc: and boards               City:19971  Problem:  Assist                          Inc#: 2012-019405    Lat: 38715709    Long: 75076171   DISP: 19:29:17   Cross St: Dead End/1ST ST",
        "UNIT:82ST",
        "ADDR:1 - 28 Wilmington Ave",
        "MADDR:1 Wilmington Ave",
        "PLACE:and boards",
        "CITY:19971",
        "CALL:Assist",
        "ID:2012-019405",
        "TIME:19:29:17",
        "X:Dead End/1ST ST");

    doTest("T74",
        "{CAD Alert} 82A    Call at: 1800 Bay Ave             Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-019417    Lat: 38785546    Long: 75149459   DISP: 21:03:34   Cross St: UNNAMED STREET/MICHIGAN AVE",
        "UNIT:82A",
        "ADDR:1800 Bay Ave",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-019417",
        "TIME:21:03:34",
        "X:UNNAMED STREET/MICHIGAN AVE");

    doTest("T75",
        "{CAD Alert} 82A    Call at: 41 Inlet View Ct         Loc:                          City:19930  Problem:  Structure Fire                  Inc#: 2012-019445    Lat: 38605377    Long: 75075299   DISP: 00:56:19   Cross St: S SHORE DR/Dead End",
        "UNIT:82A",
        "ADDR:41 Inlet View Ct",
        "CITY:19930",
        "CALL:Structure Fire",
        "ID:2012-019445",
        "TIME:00:56:19",
        "X:S SHORE DR/Dead End");

    doTest("T76",
        "{CAD Alert} 82C    Call at: 34155 High Knoll Rd      Loc: x from                   City:19958  Problem:  Structure Fire                  Inc#: 2012-019470    Lat: 38707447    Long: 75162007   DISP: 05:39:55   Cross St: ANNONDELL DR/ANNONDELL DR",
        "UNIT:82C",
        "ADDR:34155 High Knoll Rd",
        "PLACE:x from",
        "CITY:19958",
        "CALL:Structure Fire",
        "ID:2012-019470",
        "TIME:05:39:55",
        "X:ANNONDELL DR/ANNONDELL DR");

    doTest("T77",
        "{CAD Alert} 82A    Call at: 22256 - 22345 RobinsonvilLoc:                          City:19958  Problem:  Service Call                    Inc#: 2012-019471    Lat: 38679542    Long: 75184534   DISP: 05:47:04   Cross St: CONLEYS CHAPEL RD/JOHN J WILLIAMS HWY",
        "UNIT:82A",
        "ADDR:22256 - 22345 Robinsonvil",
        "MADDR:22256 Robinsonvil",
        "CITY:19958",
        "CALL:Service Call",
        "ID:2012-019471",
        "TIME:05:47:04",
        "X:CONLEYS CHAPEL RD/JOHN J WILLIAMS HWY");

    doTest("T78",
        "{CAD Alert} 82B    Call at: 34150 High Knoll Rd      Loc:                          City:19958  Problem:  Structure Fire                  Inc#: 2012-019496    Lat: 38707361    Long: 75161870   DISP: 10:48:17   Cross St: ANNONDELL DR/ANNONDELL DR",
        "UNIT:82B",
        "ADDR:34150 High Knoll Rd",
        "CITY:19958",
        "CALL:Structure Fire",
        "ID:2012-019496",
        "TIME:10:48:17",
        "X:ANNONDELL DR/ANNONDELL DR");

    doTest("T79",
        "{CAD Alert} 82C    Call at: 25870 Lingo Ln           Loc:                          City:19966  Problem:  Structure Fire                  Inc#: 2012-019566    Lat: 38631577    Long: 75173867   DISP: 04:52:17   Cross St: LINGO RD/LONG NECK RD",
        "UNIT:82C",
        "ADDR:25870 Lingo Ln",
        "CITY:19966",
        "CALL:Structure Fire",
        "ID:2012-019566",
        "TIME:04:52:17",
        "X:LINGO RD/LONG NECK RD");

    doTest("T80",
        "{CAD Alert} 82A    Call at: 114 Ethird St            Loc:                          City:       Problem:  Automatic Fire Alarm            Inc#: 2012-019569    Lat: 0           Long: 0          DISP: 05:40:41   Cross St:",
        "UNIT:82A",
        "ADDR:114 Ethird St",
        "CALL:Automatic Fire Alarm",
        "ID:2012-019569",
        "TIME:05:40:41");

    doTest("T81",
        "{CAD Alert} 82A    Call at: 34453 King Street Row    Loc: suit 2DELAWARE CARDIOVASCCity:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-019622    Lat: 38744064    Long: 75149850   DISP: 16:49:21   Cross St: KINGS HWY/Dead End",
        "UNIT:82A",
        "ADDR:34453 King Street Row",
        "PLACE:suit 2DELAWARE CARDIOVASC",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-019622",
        "TIME:16:49:21",
        "X:KINGS HWY/Dead End");

    doTest("T82",
        "{CAD Alert} 82A    Call at: 5 Bryan Dr               Loc:                          City:19971  Problem:  Child Locked in Vehicle         Inc#: 2012-019675    Lat: 38736188    Long: 75136420   DISP: 02:18:15   Cross St: SABRINA DR/TIFFANY DR",
        "UNIT:82A",
        "ADDR:5 Bryan Dr",
        "CITY:19971",
        "CALL:Child Locked in Vehicle",
        "ID:2012-019675",
        "TIME:02:18:15",
        "X:SABRINA DR/TIFFANY DR");

    doTest("T83",
        "{CAD Alert} 82B    Call at: 28200 - 28361 Elizabeth SLoc:                          City:19966  Problem:  Structure Fire                  Inc#: 2012-019749    Lat: 38600017    Long: 75175399   DISP: 22:23:25   Cross St: BOWDEN ST/BOWDEN ST",
        "UNIT:82B",
        "ADDR:28200 - 28361 Elizabeth S",
        "MADDR:28200 Elizabeth S",
        "CITY:19966",
        "CALL:Structure Fire",
        "ID:2012-019749",
        "TIME:22:23:25",
        "X:BOWDEN ST/BOWDEN ST");

    doTest("T84",
        "{CAD Alert} 82A    Call at: 48 Spinning Wheel Ln     Loc:                          City:19971  Problem:  Carbon Monoxide Detector        Inc#: 2012-020008    Lat: 38735468    Long: 75133564   DISP: 23:18:22   Cross St: CARRIAGE LN/OLDE COACH DR",
        "UNIT:82A",
        "ADDR:48 Spinning Wheel Ln",
        "CITY:19971",
        "CALL:Carbon Monoxide Detector",
        "ID:2012-020008",
        "TIME:23:18:22",
        "X:CARRIAGE LN/OLDE COACH DR");

    doTest("T85",
        "{CAD Alert} 821    Call at: 22100 - 22107 Holly Oak LLoc: In the area              City:19958  Problem:  Outside Fire                    Inc#: 2012-020046    Lat: 38684481    Long: 75197641   DISP: 11:28:55   Cross St: DORMAN RD/Dead End",
        "UNIT:821",
        "ADDR:22100 - 22107 Holly Oak L",
        "MADDR:22100 Holly Oak L",
        "PLACE:In the area",
        "CITY:19958",
        "CALL:Outside Fire",
        "ID:2012-020046",
        "TIME:11:28:55",
        "X:DORMAN RD/Dead End");

    doTest("T86",
        "{CAD Alert} 82C    Call at: 32002 Conleys Chapel Rd  Loc:                          City:19958  Problem:  Traffic/TransportationAcdntALS  Inc#: 2012-020079    Lat: 38686127    Long: 75190321   DISP: 17:15:00   Cross St: ANCIENT OAK DR/LAVENDER LN",
        "UNIT:82C",
        "ADDR:32002 Conleys Chapel Rd",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntALS",
        "ID:2012-020079",
        "TIME:17:15:00",
        "X:ANCIENT OAK DR/LAVENDER LN");

    doTest("T87",
        "{CAD Alert} 82ST   Call at: 0 Saint Lawrence St      Loc:                          City:19971  Problem:  Water Rescue Priority 1         Inc#: 2012-020091    Lat: 38708664    Long: 75080891   DISP: 19:03:44   Cross St: BAYARD AVE/BAYARD AVE",
        "UNIT:82ST",
        "ADDR:0 Saint Lawrence St",
        "CITY:19971",
        "CALL:Water Rescue Priority 1",
        "ID:2012-020091",
        "TIME:19:03:44",
        "X:BAYARD AVE/BAYARD AVE");

    doTest("T88",
        "{CAD Alert} 82A    Call at: 20025 Wil King Rd        Loc:                          City:19958  Problem:  Smoke Investigation             Inc#: 2012-020094    Lat: 38714995    Long: 75203618   DISP: 19:24:48   Cross St: KENDALE RD/HOLLY AVE",
        "UNIT:82A",
        "ADDR:20025 Wil King Rd",
        "CITY:19958",
        "CALL:Smoke Investigation",
        "ID:2012-020094",
        "TIME:19:24:48",
        "X:KENDALE RD/HOLLY AVE");

    doTest("T89",
        "{CAD Alert} 82ST   Call at: 13849 Steamboat Landing RLoc:                          City:19968  Problem:  Cardiac/Resp./Death-ALS         Inc#: 2012-020216    Lat: 38798252    Long: 75244220   DISP: 01:35:02   Cross St: WHITES NECK WAY/Dead End",
        "UNIT:82ST",
        "ADDR:13849 Steamboat Landing R",
        "CITY:19968",
        "CALL:Cardiac/Resp./Death-ALS",
        "ID:2012-020216",
        "TIME:01:35:02",
        "X:WHITES NECK WAY/Dead End");

    doTest("T90",
        "{CAD Alert} 82A    Call at: 70 - 73 Roberts Rd       Loc: #3                       City:19958  Problem:  Breathing Problems-ALS          Inc#: 2012-020218    Lat: 38760024    Long: 75189927   DISP: 02:30:34   Cross St: OLD MILL RD/Dead End",
        "UNIT:82A",
        "ADDR:70 - 73 Roberts Rd",
        "MADDR:70 Roberts Rd",
        "PLACE:#3",
        "CITY:19958",
        "CALL:Breathing Problems-ALS",
        "ID:2012-020218",
        "TIME:02:30:34",
        "X:OLD MILL RD/Dead End");

    doTest("T91",
        "{CAD Alert} 82C    Call at: 34682 Villa Cir          Loc:                          City:19958  Problem:  Automatic Fire Alarm            Inc#: 2012-020230    Lat: 38742766    Long: 75146585   DISP: 08:53:34   Cross St: BAY CROSSING BLVD/BAY CROSSING BLVD",
        "UNIT:82C",
        "ADDR:34682 Villa Cir",
        "CITY:19958",
        "CALL:Automatic Fire Alarm",
        "ID:2012-020230",
        "TIME:08:53:34",
        "X:BAY CROSSING BLVD/BAY CROSSING BLVD");

    doTest("T92",
        "{CAD Alert} 82ST   Call at: 0 Roosevelt Inlet        Loc: Roosevelt Inlet          City:19968  Problem:  Watercraft in Distress          Inc#: 2012-020234    Lat: 0           Long: 0          DISP: 09:22:43   Cross St:",
        "UNIT:82ST",
        "ADDR:0 Roosevelt Inlet",
        "PLACE:Roosevelt Inlet",
        "CITY:19968",
        "CALL:Watercraft in Distress",
        "ID:2012-020234",
        "TIME:09:22:43");

    doTest("T93",
        "{CAD Alert} 82B    Call at: 32544 Lewes Georgetown HwLoc: rear entrance to ACE HardCity:19958  Problem:  Traffic/TransportationAcdntBLS  Inc#: 2012-020662    Lat: 38747388    Long: 75176098   DISP: 23:19:44   Cross St: CONNECTING ROAD/CONNECTING ROAD",
        "UNIT:82B",
        "ADDR:32544 Lewes Georgetown Hw",
        "MADDR:32544 Lewes Georgetown Hwy",
        "PLACE:rear entrance to ACE Hard",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS",
        "ID:2012-020662",
        "TIME:23:19:44",
        "X:CONNECTING ROAD/CONNECTING ROAD");

    doTest("T94",
        "{CAD Alert} 82ST   Call at: Savannah Rd & E 4th St   Loc:                          City:       Problem:  Washdown (Fuel Spill)           Inc#: 2012-020708    Lat: 0           Long: 0          DISP: 14:01:03   Cross St:",
        "UNIT:82ST",
        "ADDR:Savannah Rd & E 4th St",
        "CALL:Washdown (Fuel Spill)",
        "ID:2012-020708",
        "TIME:14:01:03");
    
  }
  
  public static void main(String[] args) {
    new DEDelmarParserTest().generateTests("T1");
  }
}
    		