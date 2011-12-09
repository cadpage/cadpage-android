package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALStClairCountyParserTest;

import org.junit.Test;


public class ALStClairCountyParserTest extends BaseParserTest {
  
  public ALStClairCountyParserTest() {
    setParser(new ALStClairCountyParser(), "ST CLAIR COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "9-1-1CENTRAL:MED >MEDICAL CALL 3213 EVERGREEN RD XS: R INT @ 3992 AL HWY 23 SPRINGVILLE ALTON DOLLAR 2056297007 Map: Grids:0,0 Cad: 2011-0000088977",
        "CALL:MEDICAL CALL",
        "ADDR:3213 EVERGREEN RD",
        "X:R INT @ 3992 AL HWY 23",
        "CITY:SPRINGVILLE",
        "NAME:ALTON DOLLAR",
        "PHONE:2056297007",
        "ID:2011-0000088977");

    doTest("T2",
        "9-1-1CENTRAL:MED >MEDICAL CALL 25 GRAY RD XS: L INT @ 2949 AL HWY 23 SPRINGVILLE WOODS, KATIE 2054676649 Map: Grids:0,0 Cad: 2011-0000089146",
        "CALL:MEDICAL CALL",
        "ADDR:25 GRAY RD",
        "X:L INT @ 2949 AL HWY 23",
        "CITY:SPRINGVILLE",
        "NAME:WOODS, KATIE",
        "PHONE:2054676649",
        "ID:2011-0000089146");

    doTest("T3",
        "9-1-1CENTRAL:MED >MEDICAL CALL 3213 EVERGREEN RD XS: R INT @ 3992 AL HWY 23 SPRINGVILLE ALTON DOLLAR 2056297007 Map: Grids:0,0 Cad: 2011-0000088977",
        "CALL:MEDICAL CALL",
        "ADDR:3213 EVERGREEN RD",
        "X:R INT @ 3992 AL HWY 23",
        "CITY:SPRINGVILLE",
        "NAME:ALTON DOLLAR",
        "PHONE:2056297007",
        "ID:2011-0000088977");

    doTest("T4",
        "9-1-1CENTRAL:MED >MEDICAL CALL 25 GRAY RD XS: L INT @ 2949 AL HWY 23 SPRINGVILLE WOODS, KATHY 2054670992 Map: Grids:0,0 Cad: 2011-0000084537",
        "CALL:MEDICAL CALL",
        "ADDR:25 GRAY RD",
        "X:L INT @ 2949 AL HWY 23",
        "CITY:SPRINGVILLE",
        "NAME:WOODS, KATHY",
        "PHONE:2054670992",
        "ID:2011-0000084537");

    doTest("T5",
        "9-1-1CENTRAL:MED >MEDICAL CALL 70 HOYT HILL RD COOL SPRINGS KURT 2054923800 Map: Grids:0,0 Cad: 2011-0000079042",
        "CALL:MEDICAL CALL",
        "ADDR:70 HOYT HILL RD",
        "CITY:COOL SPRINGS",
        "NAME:KURT",
        "PHONE:2054923800",
        "ID:2011-0000079042");

    doTest("T6",
        "9-1-1CENTRAL:MED >MEDICAL CALL 70 HOYT HILL RD XS: L INT @ 1641 RAY WYATT RD ASHVILLE KURT 2054923800 Map: Grids:0,0 Cad: 2011-0000079041",
        "CALL:MEDICAL CALL",
        "ADDR:70 HOYT HILL RD",
        "X:L INT @ 1641 RAY WYATT RD",
        "CITY:ASHVILLE",
        "NAME:KURT",
        "PHONE:2054923800",
        "ID:2011-0000079041");

    doTest("T7",
        "9-1-1CENTRAL:MED >MEDICAL CALL 1276 BEULAH CIR XS: L INT @ 5063 AL HWY 23 SPRINGVILLE MARGARET FRANKLIN 2053621848 Map: Grids:0,0 Cad: 2011-0000076650",
        "CALL:MEDICAL CALL",
        "ADDR:1276 BEULAH CIR",
        "X:L INT @ 5063 AL HWY 23",
        "CITY:SPRINGVILLE",
        "NAME:MARGARET FRANKLIN",
        "PHONE:2053621848",
        "ID:2011-0000076650");

    doTest("T8",
        "9-1-1CENTRAL:MED >MEDICAL CALL 437 BUCKS VALLEY RD XS: R INT @ 10824 CO RD 31 ASHVILLE ELIZABETH WHEELER 2055291043 Map: Grids:0,0 Cad: 2011-0000074532",
        "CALL:MEDICAL CALL",
        "ADDR:437 BUCKS VALLEY RD",
        "X:R INT @ 10824 CO RD 31",
        "CITY:ASHVILLE",
        "NAME:ELIZABETH WHEELER",
        "PHONE:2055291043",
        "ID:2011-0000074532");

    doTest("T9",
        "9-1-1CENTRAL:MED >MEDICAL CALL 115 HONEYSUCKLE WAY RIVERSIDE JOYCE RAMSEY 2054716335 Map: Grids:0,0 Cad: 2011-0000073897",
        "CALL:MEDICAL CALL",
        "ADDR:115 HONEYSUCKLE WAY",
        "CITY:RIVERSIDE",
        "NAME:JOYCE RAMSEY",
        "PHONE:2054716335",
        "ID:2011-0000073897");

    doTest("T10",
        "9-1-1CENTRAL:50 >WRECK CO RD 23 @ BEULAH LN ASHVILLE DORIS LAWLER 2054731205 Cad: 2011-0000073324",
        "CALL:WRECK CO RD 23",
        "ADDR:BEULAH LN",
        "CITY:ASHVILLE",
        "NAME:DORIS LAWLER",
        "PHONE:2054731205",
        "ID:2011-0000073324");

    doTest("T11",
        "9-1-1CENTRAL:MED >MEDICAL CALL 104 LAKE DR XS: L INT @ 375 EVERGREEN DR SPRINGVILLE BAILEY,NOAH 2059658047 Map: Grids:0,0 Cad: 2011-0000073129",
        "CALL:MEDICAL CALL",
        "ADDR:104 LAKE DR",
        "X:L INT @ 375 EVERGREEN DR",
        "CITY:SPRINGVILLE",
        "NAME:BAILEY,NOAH",
        "PHONE:2059658047",
        "ID:2011-0000073129");

    doTest("T12",
        "9-1-1CENTRAL:50 >WRECK 8599 CO RD 31 XS: R INT @ 13064 US HWY 11 ASHVILLE ENSEY,KAREN 2055945299 Map: Grids:0,0 Cad: 2011-0000073086",
        "CALL:WRECK",
        "ADDR:8599 CO RD 31",
        "MADDR:8599 CO 31",
        "X:R INT @ 13064 US HWY 11",
        "CITY:ASHVILLE",
        "NAME:ENSEY,KAREN",
        "PHONE:2055945299",
        "ID:2011-0000073086");

    doTest("T13",
        "9-1-1CENTRAL:FIRES >STRUCTURE FIRE 65 SALEM CT XS: R INT @ 7430 CO RD 31 ASHVILLE ISAAC PILA 2055777932 Map: Grids:0,0 Cad: 2011-0000073040",
        "CALL:STRUCTURE FIRE",
        "ADDR:65 SALEM CT",
        "X:R INT @ 7430 CO RD 31",
        "CITY:ASHVILLE",
        "NAME:ISAAC PILA",
        "PHONE:2055777932",
        "ID:2011-0000073040");

    doTest("T14",
        "9-1-1CENTRAL:MED >MEDICAL CALL 25139 US HWY 411 XS: BEGINS @ END OF MOODY PRKWY ASHVILLE FARMER, RANDY 2055945861 Map: Grids:0,0 Cad: 2011-0000072997",
        "CALL:MEDICAL CALL",
        "ADDR:25139 US HWY 411",
        "X:BEGINS @ END OF",
        "CITY:MOODY",
        "NAME:PRKWY ASHVILLE FARMER, RANDY",
        "PHONE:2055945861",
        "ID:2011-0000072997");

    doTest("T15",
        "9-1-1CENTRAL:FIRES >STRUCTURE FIRE 60 SALEM CT XS: R INT @ 7430 CO RD 31 ASHVILLE PAULA 9112755039 Map: Grids:0,0 Cad: 2011-0000072597",
        "CALL:STRUCTURE FIRE",
        "ADDR:60 SALEM CT",
        "X:R INT @ 7430 CO RD 31",
        "CITY:ASHVILLE",
        "NAME:PAULA",
        "PHONE:9112755039",
        "ID:2011-0000072597");

    doTest("T16",
        "9-1-1CENTRAL:MED >MEDICAL CALL 2607 AL HWY 23 SPRINGVILLE CHUCK BACHUSS 2053695680 Map: Grids:0,0 Cad: 2011-0000071871",
        "CALL:MEDICAL CALL",
        "ADDR:2607 AL HWY 23",
        "CITY:SPRINGVILLE",
        "NAME:CHUCK BACHUSS",
        "PHONE:2053695680",
        "ID:2011-0000071871");

  }
  
  public static void main(String[] args) {
    new ALStClairCountyParserTest().generateTests("T1", "CALL ADDR X CITY NAME PHONE MAP ID");
  }
}