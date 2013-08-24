package net.anei.cadpage.parsers.ZSE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sweden

All Email pages are being redefined, parser should be rewritten when we have more data to work from (again)

Contact: Roger Ehrstedt <ebba.ehrstedt@gmail.com>
Sender: 3315
3491105\nBrand i byggnad\nFlerfamiljshus\nLägenhet\nHändelsebeskrivning : Brand i trapphus vid ingång, brinner i brevlåda\nCarlavägen 45a\n\nPositionWGS84 : La = 59º 22,267'N    Lo = 016º 31,964'E
3490536\nBrand i byggnad\nFlerfamiljshus\nTrapphus\nHändelsebeskrivning : luktar rök i trapphuset, som en lätt dimma\nRademachergatan 21, vån 5\n\nPositionWGS84 : La = 59º 22,308'N    Lo = 016º 30,783'E

SMS text format
Brand i byggnad\nFlerfamiljshus\nLägenhet\nCarlavägen 45a\n\nLa = 59 grader 22,267'N    Lo = 016 grader 31,964'E
Brand i byggnad\nFlerfamiljshus\nTrapphus\nRademachergatan 21, vån 5\n\nLa = 59 grader 22,308'N    Lo = 016 grader 30,783'E


Contact: Active911
Agency name: Rddningstjnsten Eskilstuna
Location: Eskilstuna, Sdermanland, Sweden
Sender: @zenit.sosalarm.se

3491546\nSjukdomsfall\nSvårt sjuk patient eller osäkra upplysningar\n\nHändelsebeskrivning : Patient med oklar smärta, ingen ledig ambulans\nApollovägen 7\n\nPositionWGS84 : La = 59º 16,787'N    Lo = 016º 39,815'E\n
3491105\nBrand i byggnad\nFlerfamiljshus\nLägenhet\nHändelsebeskrivning : Brand i trapphus vid ingång, brinner i brevlåda\nCarlavägen 45a\n\nPositionWGS84 : La = 59º 22,267'N    Lo = 016º 31,964'E\n
3490536\nBrand i byggnad\nFlerfamiljshus\nTrapphus\nHändelsebeskrivning : luktar rök i trapphuset, som en lätt dimma\nRademachergatan 21, vån 5\n\nPositionWGS84 : La = 59º 22,308'N    Lo = 016º 30,783'E\n
3488440\nAutomatlarm\nBrand\n\nHändelsebeskrivning : \nVilsta            Nr 138 Vilsta Raststuga\nEskilstuna\nD10\nPositionWGS84 : La = 59º 21,027'N    Lo = 016º 30,613'E\nStationskod : \nLarmkategori namn : \n
3487792\nAutomatlarm\nBrand\n\nHändelsebeskrivning : \nMälarsjukhuset     Nr 69 Mälarsjukhuset, Eskilstun\nEskilstuna\nD10\nPositionWGS84 : La = 59º 21,738'N    Lo = 016º 31,957'E\nStationskod : \nLarmkategori namn : \n
3487587\nAutomatlarm\nBrand\n\nHändelsebeskrivning : \nBolindervägen 10  Nr 153 Skan Lågg Lagerpartner\nEskilstuna\nD10\nPositionWGS84 : La = 59º 24,222'N    Lo = 016º 26,323'E\nStationskod : \nLarmkategori namn : \n
3485836\nSjukdomsfall\nAllergi\n\nHändelsebeskrivning : \nNoaksgatan 14A\n\nD10\nPositionWGS84 : \n
3485704\nSjukdomsfall\nMedvetslös-barn\n\nHändelsebeskrivning : \nådalsvägen 4c\n\nD10\nPositionWGS84 : La = 59º 21,611'N    Lo = 016º 30,415'E\n
2338824\nÖvrigt räddning\n\n\nHändelsebeskrivning : Happaranta på dörren\nbrandvarnare ljuder\nStavangergatan 4,1\nEskilstuna\nD10\nPositionWGS84 : La = 59º 21,546'N    Lo = 016º 29,297'E\n
3485098\nBrand ute - fordon\nPersonbil\nÖvrigt\nHändelsebeskrivning : Blå volvo, rökutveckling, står utomhus, ingen spridningsrisk.\nRademachergatan\n\nD10\nPositionWGS84 : La = 59º 22,351'N    Lo = 016º 30,673'E\n
3485079\nTrafikolycka - singel\nPersonbil\nÖvrigt\nHändelsebeskrivning : Singelolycka. Sitter kvar i bilen. 1 person drabbad\nMälby korsningen Vesterbergsväg\nv949\nD13\nPositionWGS84 : La = 59º 26,353'N    Lo = 016º 27,533'E\n
3481410\nAutomatlarm\nBrand\n\nHändelsebeskrivning : \nMunktellsvägen Hällby\nEskilstuna\nD10\nPositionWGS84 : \n
3481146\nBrand ute - övrigt\n\n\nHändelsebeskrivning : \nSkogsängsgatan\nSkogsängen\nD10\nPositionWGS84 : La = 59º 21,465'N    Lo = 016º 31,335'E\n
3480832\nAnnat\nLyft-hjälp\n\nHändelsebeskrivning : \nLista Asplund 1\nLista\nD10\nPositionWGS84 : La = 59º 19,453'N    Lo = 016º 14,270'E\n
2041397\nBrand ute - övrigt\n\n\nHändelsebeskrivning : Polis best  är påväg dit  en färgburk som brinner\nMajtunagatan 2 ,Slagstaskolan\nEskilstuna\nD10\nPositionWGS84 : La = 59º 23,724'N    Lo = 016º 29,451'E\n
3480744\nRöklukt - byggnad\nFlerfamiljshus\n\nHändelsebeskrivning : Luktar rök i trapp, brandvarnare tjuter\nStenkvistavägen 21A, 3\n\nD10\nPositionWGS84 : La = 59º 21,577'N    Lo = 016º 31,152'E\n
3479847\nInterna brandlarm\nVia annan larmcentral\n\nHändelsebeskrivning : kök 217\nGustavsborgsvägen 41\n\nD10\nPositionWGS84 : La = 59º 23,413'N    Lo = 016º 25,006'E\n
4077273\nBrand i byggnad\nVilla\n\nHändelsebeskrivning : Brandlarm från Sector. Ev rök\nHarvargatan 7\nEskilstuna\nD10\nLarmkategori namn : \nPositionWGS84 : La = 59º 22,359'N    Lo = 016º 28,629'E\n
3478390\nBrand ute - container\n\n\nHändelsebeskrivning : brinner i en conteiner\nVästergatan 13\n\nD10\nLarmkategori namn : \nPositionWGS84 : La = 59º 22,663'N    Lo = 016º 31,141'E\n
3477652\nSjukdomsfall\n\n\nHändelsebeskrivning : Hjärtstopp\nHLR pågår\nRV 56 Västerdal\n\nD14\nLarmkategori namn : \nPositionWGS84 : La = 59º 19,582'N    Lo = 016º 06,650'E\n
3523002\nTrafikolycka - flera fordon\nLastbil\nÖvrigt\nÅrbyrondellen\n\nPositionWGS84 : \nHändelsebeskrivning : \n
3582989\nTrafikolycka - flera fordon\nLastbil\nÖvrigt\n\n\nPositionWGS84 : La = 59º 23,399'N    Lo = 016º 31,945'E\nHändelsebeskrivning : 2 bilar o hästsläp. 3 drabbade.

*/

public class ZSESwedenParserTest extends BaseParserTest {
  
  public ZSESwedenParserTest() {
    setParser(new ZSESwedenParser(), "", "");
  }
  
  @Test
  public void testRogerEhrstedt() {

    doTest("T1",
        "3491105\n" +
        "Brand i byggnad\n" +
        "Flerfamiljshus\n" +
        "Lägenhet\n" +
        "Händelsebeskrivning : Brand i trapphus vid ingång, brinner i brevlåda\n" +
        "Carlavägen 45a\n\n" +
        "PositionWGS84 : La = 59º 22,267'N    Lo = 016º 31,964'E",

        "ID:3491105",
        "CALL:Brand i byggnad / Flerfamiljshus / Lägenhet",
        "INFO:Brand i trapphus vid ingång, brinner i brevlåda",
        "ADDR:Carlavägen 45a",
        "GPS:+59.371117,+16.532733");

    doTest("T2",
        "3490536\n" +
        "Brand i byggnad\n" +
        "Flerfamiljshus\n" +
        "Trapphus\n" +
        "Händelsebeskrivning : luktar rök i trapphuset, som en lätt dimma\n" +
        "Rademachergatan 21, vån 5\n\n" +
        "PositionWGS84 : La = 59º 22,308'N    Lo = 016º 30,783'E",

        "ID:3490536",
        "CALL:Brand i byggnad / Flerfamiljshus / Trapphus",
        "INFO:luktar rök i trapphuset, som en lätt dimma",
        "ADDR:Rademachergatan 21",
        "PLACE:vån 5",
        "GPS:+59.371800,+16.513050");

  }
  
  @Test
  public void testTextPages() {

    doTest("T1",
        "Brand i byggnad\nFlerfamiljshus\nLägenhet\nCarlavägen 45a\n\nLa = 59 grader 22,267'N    Lo = 016 grader 31,964'E",
        "CALL:Brand i byggnad / Flerfamiljshus / Lägenhet",
        "ADDR:Carlavägen 45a",
        "GPS:+59.371117,+16.532733");

    doTest("T2",
        "Brand i byggnad\nFlerfamiljshus\nTrapphus\nRademachergatan 21, vån 5\n\nLa = 59 grader 22,308'N    Lo = 016 grader 30,783'E",
        "CALL:Brand i byggnad / Flerfamiljshus / Trapphus",
        "ADDR:Rademachergatan 21",
        "PLACE:vån 5",
        "GPS:+59.371800,+16.513050");

  }
  
  @Test
  public void testRddningstjnstenEskilstuna() {

    doTest("T1",
        "3491546\n" +
        "Sjukdomsfall\n" +
        "Svårt sjuk patient eller osäkra upplysningar\n\n" +
        "Händelsebeskrivning : Patient med oklar smärta, ingen ledig ambulans\n" +
        "Apollovägen 7\n\n" +
        "PositionWGS84 : La = 59º 16,787'N    Lo = 016º 39,815'E\n",

        "ID:3491546",
        "CALL:Sjukdomsfall / Svårt sjuk patient eller osäkra upplysningar",
        "INFO:Patient med oklar smärta, ingen ledig ambulans",
        "ADDR:Apollovägen 7",
        "GPS:+59.279783,+16.663583");

    doTest("T2",
        "3491105\n" +
        "Brand i byggnad\n" +
        "Flerfamiljshus\n" +
        "Lägenhet\n" +
        "Händelsebeskrivning : Brand i trapphus vid ingång, brinner i brevlåda\n" +
        "Carlavägen 45a\n\n" +
        "PositionWGS84 : La = 59º 22,267'N    Lo = 016º 31,964'E\n",

        "ID:3491105",
        "CALL:Brand i byggnad / Flerfamiljshus / Lägenhet",
        "INFO:Brand i trapphus vid ingång, brinner i brevlåda",
        "ADDR:Carlavägen 45a",
        "GPS:+59.371117,+16.532733");

    doTest("T3",
        "3490536\n" +
        "Brand i byggnad\n" +
        "Flerfamiljshus\n" +
        "Trapphus\n" +
        "Händelsebeskrivning : luktar rök i trapphuset, som en lätt dimma\n" +
        "Rademachergatan 21, vån 5\n\n" +
        "PositionWGS84 : La = 59º 22,308'N    Lo = 016º 30,783'E\n",

        "ID:3490536",
        "CALL:Brand i byggnad / Flerfamiljshus / Trapphus",
        "INFO:luktar rök i trapphuset, som en lätt dimma",
        "ADDR:Rademachergatan 21",
        "PLACE:vån 5",
        "GPS:+59.371800,+16.513050");

    doTest("T4",
        "3488440\n" +
        "Automatlarm\n" +
        "Brand\n\n" +
        "Händelsebeskrivning : \n" +
        "Vilsta            Nr 138 Vilsta Raststuga\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,027'N    Lo = 016º 30,613'E\n" +
        "Stationskod : \n" +
        "Larmkategori namn : \n",

        "ID:3488440",
        "CALL:Automatlarm / Brand",
        "APT:138",
        "ADDR:Vilsta",
        "PLACE:Vilsta Raststuga",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.350450,+16.510217");

    doTest("T5",
        "3487792\n" +
        "Automatlarm\n" +
        "Brand\n\n" +
        "Händelsebeskrivning : \n" +
        "Mälarsjukhuset     Nr 69 Mälarsjukhuset, Eskilstun\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,738'N    Lo = 016º 31,957'E\n" +
        "Stationskod : \n" +
        "Larmkategori namn : \n",

        "ID:3487792",
        "CALL:Automatlarm / Brand",
        "APT:69",
        "ADDR:Mälarsjukhuset",
        "PLACE:Mälarsjukhuset, Eskilstun",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.362300,+16.532617");

    doTest("T6",
        "3487587\n" +
        "Automatlarm\n" +
        "Brand\n\n" +
        "Händelsebeskrivning : \n" +
        "Bolindervägen 10  Nr 153 Skan Lågg Lagerpartner\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 24,222'N    Lo = 016º 26,323'E\n" +
        "Stationskod : \n" +
        "Larmkategori namn : \n",

        "ID:3487587",
        "CALL:Automatlarm / Brand",
        "APT:153",
        "ADDR:Bolindervägen 10",
        "PLACE:Skan Lågg Lagerpartner",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.403700,+16.438717");

    doTest("T7",
        "3485836\nSjukdomsfall\nAllergi\n\nHändelsebeskrivning : \nNoaksgatan 14A\n\nD10\nPositionWGS84 : \n",
        "ID:3485836",
        "CALL:Sjukdomsfall / Allergi",
        "ADDR:Noaksgatan 14A",
        "SRC:D10");

    doTest("T8",
        "3485704\n" +
        "Sjukdomsfall\n" +
        "Medvetslös-barn\n\n" +
        "Händelsebeskrivning : \n" +
        "ådalsvägen 4c\n\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,611'N    Lo = 016º 30,415'E\n",

        "ID:3485704",
        "CALL:Sjukdomsfall / Medvetslös-barn",
        "ADDR:ådalsvägen 4c",
        "SRC:D10",
        "GPS:+59.360183,+16.506917");

    doTest("T9",
        "2338824\n" +
        "Övrigt räddning\n\n\n" +
        "Händelsebeskrivning : Happaranta på dörren\n" +
        "brandvarnare ljuder\n" +
        "Stavangergatan 4,1\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,546'N    Lo = 016º 29,297'E\n",

        "ID:2338824",
        "CALL:Övrigt räddning",
        "INFO:Happaranta på dörren / brandvarnare ljuder",
        "APT:1",
        "ADDR:Stavangergatan 4",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.359100,+16.488283");

    doTest("T10",
        "3485098\n" +
        "Brand ute - fordon\n" +
        "Personbil\n" +
        "Övrigt\n" +
        "Händelsebeskrivning : Blå volvo, rökutveckling, står utomhus, ingen spridningsrisk.\n" +
        "Rademachergatan\n\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 22,351'N    Lo = 016º 30,673'E\n",

        "ID:3485098",
        "CALL:Brand ute - fordon / Personbil / Övrigt",
        "INFO:Blå volvo, rökutveckling, står utomhus, ingen spridningsrisk.",
        "ADDR:Rademachergatan",
        "SRC:D10",
        "GPS:+59.372517,+16.511217");

    doTest("T11",
        "3485079\n" +
        "Trafikolycka - singel\n" +
        "Personbil\n" +
        "Övrigt\n" +
        "Händelsebeskrivning : Singelolycka. Sitter kvar i bilen. 1 person drabbad\n" +
        "Mälby korsningen Vesterbergsväg\n" +
        "v949\n" +
        "D13\n" +
        "PositionWGS84 : La = 59º 26,353'N    Lo = 016º 27,533'E\n",

        "ID:3485079",
        "CALL:Trafikolycka - singel / Personbil / Övrigt",
        "INFO:Singelolycka. Sitter kvar i bilen. 1 person drabbad",
        "ADDR:Mälby korsningen Vesterbergsväg",
        "CITY:v949",
        "SRC:D13",
        "GPS:+59.439217,+16.458883");

    doTest("T12",
        "3481410\nAutomatlarm\nBrand\n\nHändelsebeskrivning : \nMunktellsvägen Hällby\nEskilstuna\nD10\nPositionWGS84 : \n",
        "ID:3481410",
        "CALL:Automatlarm / Brand",
        "ADDR:Munktellsvägen Hällby",
        "CITY:Eskilstuna",
        "SRC:D10");

    doTest("T13",
        "3481146\n" +
        "Brand ute - övrigt\n\n\n" +
        "Händelsebeskrivning : \n" +
        "Skogsängsgatan\n" +
        "Skogsängen\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,465'N    Lo = 016º 31,335'E\n",

        "ID:3481146",
        "CALL:Brand ute - övrigt",
        "ADDR:Skogsängsgatan",
        "CITY:Skogsängen",
        "SRC:D10",
        "GPS:+59.357750,+16.522250");

    doTest("T14",
        "3480832\n" +
        "Annat\n" +
        "Lyft-hjälp\n\n" +
        "Händelsebeskrivning : \n" +
        "Lista Asplund 1\n" +
        "Lista\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 19,453'N    Lo = 016º 14,270'E\n",

        "ID:3480832",
        "CALL:Annat / Lyft-hjälp",
        "ADDR:Lista Asplund 1",
        "CITY:Lista",
        "SRC:D10",
        "GPS:+59.324217,+16.237833");

    doTest("T15",
        "2041397\n" +
        "Brand ute - övrigt\n\n\n" +
        "Händelsebeskrivning : Polis best  är påväg dit  en färgburk som brinner\n" +
        "Majtunagatan 2 ,Slagstaskolan\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 23,724'N    Lo = 016º 29,451'E\n",

        "ID:2041397",
        "CALL:Brand ute - övrigt",
        "INFO:Polis best  är påväg dit  en färgburk som brinner",
        "ADDR:Majtunagatan 2",
        "PLACE:Slagstaskolan",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.395400,+16.490850");

    doTest("T16",
        "3480744\n" +
        "Röklukt - byggnad\n" +
        "Flerfamiljshus\n\n" +
        "Händelsebeskrivning : Luktar rök i trapp, brandvarnare tjuter\n" +
        "Stenkvistavägen 21A, 3\n\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,577'N    Lo = 016º 31,152'E\n",

        "ID:3480744",
        "CALL:Röklukt - byggnad / Flerfamiljshus",
        "INFO:Luktar rök i trapp, brandvarnare tjuter",
        "APT:3",
        "ADDR:Stenkvistavägen 21A",
        "SRC:D10",
        "GPS:+59.359617,+16.519200");

    doTest("T17",
        "3479847\n" +
        "Interna brandlarm\n" +
        "Via annan larmcentral\n\n" +
        "Händelsebeskrivning : kök 217\n" +
        "Gustavsborgsvägen 41\n\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 23,413'N    Lo = 016º 25,006'E\n",

        "ID:3479847",
        "CALL:Interna brandlarm / Via annan larmcentral",
        "INFO:kök 217",
        "ADDR:Gustavsborgsvägen 41",
        "SRC:D10",
        "GPS:+59.390217,+16.416767");

    doTest("T18",
        "4077273\n" +
        "Brand i byggnad\n" +
        "Villa\n\n" +
        "Händelsebeskrivning : Brandlarm från Sector. Ev rök\n" +
        "Harvargatan 7\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "Larmkategori namn : \n" +
        "PositionWGS84 : La = 59º 22,359'N    Lo = 016º 28,629'E\n",

        "ID:4077273",
        "CALL:Brand i byggnad / Villa",
        "INFO:Brandlarm från Sector. Ev rök",
        "ADDR:Harvargatan 7",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.372650,+16.477150");

    doTest("T19",
        "3478390\n" +
        "Brand ute - container\n\n\n" +
        "Händelsebeskrivning : brinner i en conteiner\n" +
        "Västergatan 13\n\n" +
        "D10\n" +
        "Larmkategori namn : \n" +
        "PositionWGS84 : La = 59º 22,663'N    Lo = 016º 31,141'E\n",

        "ID:3478390",
        "CALL:Brand ute - container",
        "INFO:brinner i en conteiner",
        "ADDR:Västergatan 13",
        "SRC:D10",
        "GPS:+59.377717,+16.519017");

    doTest("T20",
        "3477652\n" +
        "Sjukdomsfall\n\n\n" +
        "Händelsebeskrivning : Hjärtstopp\n" +
        "HLR pågår\n" +
        "RV 56 Västerdal\n\n" +
        "D14\n" +
        "Larmkategori namn : \n" +
        "PositionWGS84 : La = 59º 19,582'N    Lo = 016º 06,650'E\n",

        "ID:3477652",
        "CALL:Sjukdomsfall",
        "INFO:Hjärtstopp / HLR pågår",
        "ADDR:RV 56 Västerdal",
        "SRC:D14",
        "GPS:+59.326367,+16.110833");

    doTest("T21",
        "2338824\n" +
        "Övrigt räddning\n\n\n" +
        "Stavangergatan 4,1\n" +
        "Eskilstuna\n" +
        "D10\n" +
        "PositionWGS84 : La = 59º 21,546'N    Lo = 016º 29,297'E\n" +
        "Händelsebeskrivning : Happaranta på dörren\n" +
        "brandvarnare ljuder\n",

        "ID:2338824",
        "CALL:Övrigt räddning",
        "INFO:Happaranta på dörren / brandvarnare ljuder",
        "APT:1",
        "ADDR:Stavangergatan 4",
        "CITY:Eskilstuna",
        "SRC:D10",
        "GPS:+59.359100,+16.488283");

    doTest("T22",
        "3523002\nTrafikolycka - flera fordon\nLastbil\nÖvrigt\nÅrbyrondellen\n\nPositionWGS84 : \nHändelsebeskrivning : \n",
        "ID:3523002",
        "CALL:Trafikolycka - flera fordon / Lastbil / Övrigt",
        "ADDR:Årbyrondellen");

    doTest("T23",
        "3582989\n" +
        "Trafikolycka - flera fordon\n" +
        "Lastbil\n" +
        "Övrigt\n\n\n" +
        "PositionWGS84 : La = 59º 23,399'N    Lo = 016º 31,945'E\n" +
        "Händelsebeskrivning : 2 bilar o hästsläp. 3 drabbade.",

        "ID:3582989",
        "CALL:Trafikolycka - flera fordon / Lastbil / Övrigt",
        "INFO:2 bilar o hästsläp. 3 drabbade.",
        "GPS:+59.389983,+16.532417",
        "MADDR:+59.389983,+16.532417");

 }
  
  public static void main(String[] args) {
    new ZSESwedenParserTest().generateTests("T1");
  }
}