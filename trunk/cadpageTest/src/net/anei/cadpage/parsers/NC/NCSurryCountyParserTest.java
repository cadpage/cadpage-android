package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCSurryCountyParserTest extends BaseParserTest {
  
  public NCSurryCountyParserTest() {
    setParser(new NCSurryCountyParser(), "SURRY COUNTY", "NC");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] SC911::Call #120627-0079 [Address] 112 SOLO LN [X St] PEACE HAVEN CIR TO DEADEND [Type] ASST PATIENT\n",
        "ID:120627-0079",
        "ADDR:112 SOLO LN",
        "X:PEACE HAVEN CIR & DEADEND",
        "CALL:ASST PATIENT");

    doTest("T2",
        "[] SC911::Call #120627-0206 [Address] 587 N FRANKLIN RD [X St] TO [Type] CARDIAC\n",
        "ID:120627-0206",
        "ADDR:587 N FRANKLIN RD",
        "CALL:CARDIAC");

    doTest("T3",
        "[] SC911::Call #120627-0221 [Address] 297 MAPLE HOLLOW RD [X St] MARK ST TO LYNN ST [Type] DIABETIC D\n",
        "ID:120627-0221",
        "ADDR:297 MAPLE HOLLOW RD",
        "X:MARK ST & LYNN ST",
        "CALL:DIABETIC D");

    doTest("T4",
        "[] SC911::Call #120627-0235 [Address] 1872 W PINE ST [X St] TRANQUIL LN TO CEDAR KNOLL DR [Type] ASST PATIENT\n",
        "ID:120627-0235",
        "ADDR:1872 W PINE ST",
        "X:TRANQUIL LN & CEDAR KNOLL DR",
        "CALL:ASST PATIENT");

    doTest("T5",
        "[] SC911::Call #120627-0263 [Address] MAPLE DR // OLD TOAST RD [X St] OLD TOAST RD TO DEADEND [Type] UNKNOWN PROB\n",
        "ID:120627-0263",
        "ADDR:MAPLE DR & OLD TOAST RD",
        "X:OLD TOAST RD & DEADEND",
        "CALL:UNKNOWN PROB");

    doTest("T6",
        "[] SC911::Call #120628-0145 [Address] 1766 S ANDY GRIFFITH PKWY [X St] CITY LIMITS TO OLD BUCK SHOALS RD [Type] FIRE ALARM\n",
        "ID:120628-0145",
        "ADDR:1766 S ANDY GRIFFITH PKWY",
        "X:CITY LIMITS & OLD BUCK SHOALS RD",
        "CALL:FIRE ALARM");

    doTest("T7",
        "[] SC911::Call #120628-0294 [Address] 1161 W LEBANON ST [X St] PAIGE ST TO HADLEY RD [Type] COMM SERVICE\n",
        "ID:120628-0294",
        "ADDR:1161 W LEBANON ST",
        "X:PAIGE ST & HADLEY RD",
        "CALL:COMM SERVICE");
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "SC911::Call #120707-0414 [Address] 367 CEDAR RIDGE RD [X St] PIPERS GAP RD TO DEADEND [Type] ASSAULT D",
        "ID:120707-0414",
        "ADDR:367 CEDAR RIDGE RD",
        "X:PIPERS GAP RD & DEADEND",
        "CALL:ASSAULT D");

    doTest("T2",
        "SC911::Call #120709-0218 [Address] 192 LOWER PARK LN [X St] MID LN TO DEADEND [Type] CVA D",
        "ID:120709-0218",
        "ADDR:192 LOWER PARK LN",
        "X:MID LN & DEADEND",
        "CALL:CVA D");

    doTest("T3",
        "SC911::Call #120710-0221 [Address] 426 N FRANKLIN RD [X St] TO [Type] RESP DIS D",
        "ID:120710-0221",
        "ADDR:426 N FRANKLIN RD",
        "CALL:RESP DIS D");

    doTest("T4",
        "SC911::Call #120712-0107 [Address] 1872 PIPERS GAP RD [X St] MILLER RD TO PHANTOM LN [Type] ACCIDENT PI",
        "ID:120712-0107",
        "ADDR:1872 PIPERS GAP RD",
        "X:MILLER RD & PHANTOM LN",
        "CALL:ACCIDENT PI");

    doTest("T5",
        "SC911::Call #120712-0347 [Address] 223 BLUEMONT RD [X St] HIGHLAND DR TO S FRANKLIN RD [Type] FALL",
        "ID:120712-0347",
        "ADDR:223 BLUEMONT RD",
        "X:HIGHLAND DR & S FRANKLIN RD",
        "CALL:FALL");

    doTest("T6",
        "SC911::Call #120713-0124 [Address] 201 HUNTINGTON CREEK LN [X St] IMOGENE CH RD TO DEADEND [Type] UNRESPONSIVE",
        "ID:120713-0124",
        "ADDR:201 HUNTINGTON CREEK LN",
        "X:IMOGENE CH RD & DEADEND",
        "CALL:UNRESPONSIVE");

    doTest("T7",
        "SC911::Call #120713-0140 [Address] 227 AIRVIEW DR [X St] SUMMIT DR TO DEADEND [Type] ASSIST AGNCY",
        "ID:120713-0140",
        "ADDR:227 AIRVIEW DR",
        "X:SUMMIT DR & DEADEND",
        "CALL:ASSIST AGNCY");

    doTest("T8",
        "SC911::Call #120713-0165 [Address] 227 AIRVIEW DR [X St] SUMMIT DR TO DEADEND [Type] ASSIST AGNCY",
        "ID:120713-0165",
        "ADDR:227 AIRVIEW DR",
        "X:SUMMIT DR & DEADEND",
        "CALL:ASSIST AGNCY");

    doTest("T9",
        "SC911::Call #120713-0208 [Address] 142 BOURBON TR [X St] CAROLINA RD/DUKE RD TO DEADEND [Type] CHOKE",
        "ID:120713-0208",
        "ADDR:142 BOURBON TR",
        "X:CAROLINA RD/DUKE RD & DEADEND",
        "CALL:CHOKE");

    doTest("T10",
        "SC911::Call #120713-0222 [Address] 242 DUDLEY AVE [X St] DUDLEY AVE TO DEADEND [Type] FALL D",
        "ID:120713-0222",
        "ADDR:242 DUDLEY AVE",
        "X:DUDLEY AVE & DEADEND",
        "CALL:FALL D");

    doTest("T11",
        "SC911::Call #120713-0222 [Address] 242 DUDLEY AVE [X St] DUDLEY AVE TO DEADEND [Type] FALL D",
        "ID:120713-0222",
        "ADDR:242 DUDLEY AVE",
        "X:DUDLEY AVE & DEADEND",
        "CALL:FALL D");

    doTest("T12",
        "SC911::Call #120714-0040 [Address] 149 LINWOOD DR [X St] S FRANKLIN RD TO GREENWAY DR [Type] SUICIDE",
        "ID:120714-0040",
        "ADDR:149 LINWOOD DR",
        "X:S FRANKLIN RD & GREENWAY DR",
        "CALL:SUICIDE");

    doTest("T13",
        "SC911::Call #120714-0113 [Address] 150 ELK COURT DR [X St] N BRIDGE ST TO HWY 268 BY PASS [Type] LIFELINE",
        "ID:120714-0113",
        "ADDR:150 ELK COURT DR",
        "X:N BRIDGE ST & HWY 268 BY PASS",
        "CALL:LIFELINE");

    doTest("T14",
        "SC911::Call #120714-0116 [Address] 108 DOGWOOD DR [X St] ROSEWOOD DR TO LONG ST [Type] SICK D",
        "ID:120714-0116",
        "ADDR:108 DOGWOOD DR",
        "X:ROSEWOOD DR & LONG ST",
        "CALL:SICK D");

    doTest("T15",
        "SC911::Call #120715-0211 [Address] 194 OAK RIDGE DR [X St] MAPLE HOLLOW RD TO DEADEND [Type] CARDIAC D",
        "ID:120715-0211",
        "ADDR:194 OAK RIDGE DR",
        "X:MAPLE HOLLOW RD & DEADEND",
        "CALL:CARDIAC D");

    doTest("T16",
        "SC911::Call #120715-0237 [Address] 481 WHITE PINES COUNTRY CLUB RD [X St] N ANDY GRIFFITH PKWY TO VA STATE LINE [Type] ASST PATIENT",
        "ID:120715-0237",
        "ADDR:481 WHITE PINES COUNTRY CLUB RD",
        "X:N ANDY GRIFFITH PKWY & VA STATE LINE",
        "CALL:ASST PATIENT");

    doTest("T17",
        "SC911::Call #120715-0325 [Address] 338 S FRANKLIN RD [X St] CALVARY DR TO LONG ST [Type] HEMRGE D",
        "ID:120715-0325",
        "ADDR:338 S FRANKLIN RD",
        "X:CALVARY DR & LONG ST",
        "CALL:HEMRGE D");

    doTest("T18",
        "SC911::Call #120716-0179 [Address] 227 AIRVIEW DR [X St] SUMMIT DR TO DEADEND [Type] TRANSPORT",
        "ID:120716-0179",
        "ADDR:227 AIRVIEW DR",
        "X:SUMMIT DR & DEADEND",
        "CALL:TRANSPORT");

    doTest("T19",
        "SC911::Call #120716-0280 [Address] 110 DUTCHMANS CT [X St] JOHNSON RIDGE RD TO DEADEND [Type] TRANSPORT",
        "ID:120716-0280",
        "ADDR:110 DUTCHMANS CT",
        "X:JOHNSON RIDGE RD & DEADEND",
        "CALL:TRANSPORT");

    doTest("T20",
        "SC911::Call #120716-0299 [Address] 481 WHITE PINES COUNTRY CLUB RD [X St] N ANDY GRIFFITH PKWY TO VA STATE LINE [Type] UNRSPVE D",
        "ID:120716-0299",
        "ADDR:481 WHITE PINES COUNTRY CLUB RD",
        "X:N ANDY GRIFFITH PKWY & VA STATE LINE",
        "CALL:UNRSPVE D");

    doTest("T21",
        "SC911::Call #120716-0529 [Address] 2013 SPARGER RD [X St] BEAMER RD TO GOINS RD [Type] ACCIDENT PI",
        "ID:120716-0529",
        "ADDR:2013 SPARGER RD",
        "X:BEAMER RD & GOINS RD",
        "CALL:ACCIDENT PI");

    doTest("T22",
        "SC911::Call #120718-0172 [Address] 112 SOLO LN [X St] PEACE HAVEN CIR TO DEADEND [Type] CARDIAC D",
        "ID:120718-0172",
        "ADDR:112 SOLO LN",
        "X:PEACE HAVEN CIR & DEADEND",
        "CALL:CARDIAC D");

    doTest("T23",
        "SC911::Call #120718-0206 [Address] 1872 W PINE ST [X St] TRANQUIL LN TO CEDAR KNOLL DR [Type] ASST PATIENT",
        "ID:120718-0206",
        "ADDR:1872 W PINE ST",
        "X:TRANQUIL LN & CEDAR KNOLL DR",
        "CALL:ASST PATIENT");
  }

  public static void main(String[] args) {
    new NCSurryCountyParserTest().generateTests("T1", "ID ADDR APT X CALL");
  }
}
