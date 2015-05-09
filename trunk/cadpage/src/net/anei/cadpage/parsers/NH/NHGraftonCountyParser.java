package net.anei.cadpage.parsers.NH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchArchonixParser;

public class NHGraftonCountyParser extends DispatchArchonixParser {

  public NHGraftonCountyParser() {
    super(CITY_CODES, "GRAFTON COUNTY", "NH");
    setupGpsLookupTable(MILE_MARKERS);
    setupMultiWordStreets("TE LO CA");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_TE | MAP_FLG_SUPPR_LA;
  }
  
  private static Pattern I93 = Pattern.compile("(.*?)I 93 ([SN]) (MM \\d{1,2}(?:\\.\\d)?|EXIT \\d{2}) *(.*)", Pattern.DOTALL);
  private static Pattern CITY = Pattern.compile("(.*?) *, *([^ ]{2}) *([^ ]{2})? *(\n.*)", Pattern.DOTALL);
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {    
    if (subject.startsWith("Fwd: ")) subject = subject.substring(5);
    if (! super.parseMsg(subject, body, data)) return false;
    if (data.strCall.length() == 0) return false;
    
    //convert I 93 format places
    Matcher mat = I93.matcher(data.strPlace);
    if (mat.matches()) data.strPlace = append(mat.group(1) + "INTERSTATE 93 " + mat.group(2) + "B " + mat.group(3), " ", mat.group(4));
    
    // convert city
    mat = CITY.matcher(data.strPlace);
    if (mat.matches()) data.strPlace = mat.group(1) + ", " + convertCodes(mat.group(2), CITY_CODES) + mat.group(4);

    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
    
  private class MyAddressCityField extends BaseAddressCityField {

    @Override
    public void parse(String field, Data data) {
      String addr = null;
      Matcher mat = I93.matcher(field);
      if (mat.matches()) {
        addr = "INTERSTATE 93 " + mat.group(2) + "B " + mat.group(3);
        field = append(append(mat.group(1), " ", "123 Dummy Rd"), " ", mat.group(4));
      }
      
      // the false makes the following city construct optional
      super.parse(field, data, false);
      
      // replace dummy address with real one
      if (addr != null) data.strAddress = addr;
    }
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "01", "Alton", 
      "01 01", "Alton",
      "02", "Ashland", 
      "02 02", "Ashland",
      "03", "Belmont", 
      "03 03", "Belmont",
      "04", "Bristol", 
      "04 04", "Bristol",
      "05", "Center Harbor", 
      "05 05", "Center Harbor",
      "06", "Barnstead", 
      "06 06", "Barnstead",
      "07", "Franklin", 
      "07 07", "Franklin",
      "08", "Gilford", 
      "08 08", "Gilford",
      "09", "Gilmanton", 
      "09 09", "Gilmanton",
      "10", "Groton", 
      "10 10", "Groton",
      "11", "Hill", 
      "11 11", "Hill",
      "12", "Holderness", 
      "12 12", "Holderness",
      "13", "Laconia", 
      "13 13", "Laconia",
      "14", "Meredith", 
      "14 14", "Meredith",
      "15", "Moultonborough", 
      "15 15", "Moultonborough",
      "17", "New Hampton", 
      "17 17", "New Hampton",
      "18", "Plymouth", 
      "18 18", "Plymouth",
      "19", "Sanbornton", 
      "19 19", "Sanbornton",
      "20", "Sandwich", 
      "20 20", "Sandwich",
      "21", "Tilton", 
      "21 21", "Tilton",
      "23", "Waterville Valley", 
      "23 23", "Waterville Valley",
      "25", "Strafford", 
      "25 25", "Strafford",
      "30", "Alexandria", 
      "30 30", "Alexandria",
      "31", "Andover", 
      "31 31", "Andover",
      "34", "Bridgewater", 
      "34 34", "Bridgewater",
      "35", "Campton", 
      "35 35", "Campton",
      "36", "Danbury", 
      "36 36", "Danbury",
      "37", "Hebron", 
      "37 37", "Hebron",
      "38", "Rumney", 
      "38 38", "Rumney",
      "40", "Warren", 
      "40 40", "Warren",
      "41", "Dorchester", 
      "41 41", "Dorchester",
      "42", "Wentworth", 
      "42 42", "Wentworth",
      "89", "Northfield", 
      "89 89", "Northfield",
      "96", "Ellsworth", 
      "96 96", "Ellsworth",
      "97", "Thornton", 
      "97 97", "Thornton",
      "WO", "Woodstock", 
      "WO WO", "Woodstock"
  });
  
  private static Properties MILE_MARKERS = buildCodeTable(new String[]{
      "INTERSTATE 93 NB MM 81.8", "43.784906, -71.675496",
      "INTERSTATE 93 SB MM 81.8", "43.784991, -71.675911",
      "INTERSTATE 93 NB MM 82.0", "43.787568, -71.674110",
      "INTERSTATE 93 SB MM 82.0", "43.787678, -71.674550",
      "INTERSTATE 93 NB MM 82.2", "43.790574, -71.673933",
      "INTERSTATE 93 SB MM 82.2", "43.790512, -71.674407",
      "INTERSTATE 93 NB MM 82.4", "43.793255, -71.674862",
      "INTERSTATE 93 SB MM 82.4", "43.793095, -71.675451",
      "INTERSTATE 93 NB MM 82.6", "43.795941, -71.675798",
      "INTERSTATE 93 SB MM 82.6", "43.795777, -71.676614",
      "INTERSTATE 93 NB MM 82.8", "43.798879, -71.676630",
      "INTERSTATE 93 SB MM 82.8", "43.798863, -71.677693",
      "INTERSTATE 93 NB MM 83.0", "43.801782, -71.676336",
      "INTERSTATE 93 SB MM 83.0", "43.801937, -71.677227",
      "INTERSTATE 93 NB MM 83.2", "43.804511, -71.674989",
      "INTERSTATE 93 SB MM 83.2", "43.804707, -71.675554",
      "INTERSTATE 93 NB MM 83.4", "43.807115, -71.673263",
      "INTERSTATE 93 SB MM 83.4", "43.807342, -71.673810",
      "INTERSTATE 93 NB EXIT 27", "43.808268, -71.672453",
      "INTERSTATE 93 NB MM 83.6", "43.809687, -71.671456",
      "INTERSTATE 93 SB MM 83.6", "43.809941, -71.672117",
      "INTERSTATE 93 NB MM 83.8", "43.812135, -71.669318",
      "INTERSTATE 93 SB MM 83.8", "43.812288, -71.670004",
      "INTERSTATE 93 SB EXIT 27", "43.813330, -71.668568",
      "INTERSTATE 93 NB MM 84.0", "43.814242, -71.666568",
      "INTERSTATE 93 SB MM 84.0", "43.814530, -71.666847",
      "INTERSTATE 93 NB MM 84.2", "43.816409, -71.663674",
      "INTERSTATE 93 SB MM 84.2", "43.816706, -71.664090",
      "INTERSTATE 93 NB MM 84.4", "43.818597, -71.661340",
      "INTERSTATE 93 SB MM 84.4", "43.819022, -71.661819",
      "INTERSTATE 93 NB MM 84.6", "43.821217, -71.659582",
      "INTERSTATE 93 SB MM 84.6", "43.821354, -71.660122",
      "INTERSTATE 93 NB MM 84.8", "43.823933, -71.658282",
      "INTERSTATE 93 SB MM 84.8", "43.824025, -71.658698",
      "INTERSTATE 93 NB MM 85.0", "43.826591, -71.657019",
      "INTERSTATE 93 SB MM 85.0", "43.826677, -71.657421",
      "INTERSTATE 93 NB MM 85.2", "43.829422, -71.655668",
      "INTERSTATE 93 SB MM 85.2", "43.829525, -71.656071",
      "INTERSTATE 93 NB MM 85.4", "43.832163, -71.654355",
      "INTERSTATE 93 SB MM 85.4", "43.832266, -71.654765",
      "INTERSTATE 93 NB MM 85.6", "43.834904, -71.653030",
      "INTERSTATE 93 SB MM 85.6", "43.835002, -71.653454",
      "INTERSTATE 93 NB MM 85.8", "43.837596, -71.651537",
      "INTERSTATE 93 SB MM 85.8", "43.837712, -71.651966",
      "INTERSTATE 93 NB MM 86.0", "43.840014, -71.649726",
      "INTERSTATE 93 SB MM 86.0", "43.840168, -71.650136",
      "INTERSTATE 93 NB MM 86.2", "43.842663, -71.647682",
      "INTERSTATE 93 SB MM 86.2", "43.842823, -71.648085",
      "INTERSTATE 93 NB MM 86.4", "43.845206, -71.645802",
      "INTERSTATE 93 SB MM 86.4", "43.845313, -71.646313",
      "INTERSTATE 93 NB EXIT 28", "43.847913, -71.645117",
      "INTERSTATE 93 NB MM 86.6", "43.848188, -71.645135",
      "INTERSTATE 93 SB MM 86.6", "43.848172, -71.645656",
      "INTERSTATE 93 NB MM 86.8", "43.851061, -71.645940",
      "INTERSTATE 93 SB MM 86.8", "43.850619, -71.646253",
      "INTERSTATE 93 NB MM 87.0", "43.853534, -71.647668",
      "INTERSTATE 93 SB MM 87.0", "43.853364, -71.648079",
      "INTERSTATE 93 SB EXIT 28", "43.853627, -71.648258",
      "INTERSTATE 93 NB MM 87.2", "43.856155, -71.649537",
      "INTERSTATE 93 SB MM 87.2", "43.856041, -71.649982",
      "INTERSTATE 93 NB MM 87.4", "43.858659, -71.651308",
      "INTERSTATE 93 SB MM 87.4", "43.858482, -71.651727",
      "INTERSTATE 93 NB MM 87.6", "43.861020, -71.653540",
      "INTERSTATE 93 SB MM 87.6", "43.860776, -71.653869",
      "INTERSTATE 93 NB MM 87.8", "43.862976, -71.656517",
      "INTERSTATE 93 SB MM 87.8", "43.862704, -71.656796",
      "INTERSTATE 93 NB MM 88.0", "43.864733, -71.659429",
      "INTERSTATE 93 SB MM 88.0", "43.864476, -71.659716",
      "INTERSTATE 93 NB MM 88.2", "43.866764, -71.662768",
      "INTERSTATE 93 SB MM 88.2", "43.866517, -71.663068",
      "INTERSTATE 93 NB MM 88.4", "43.868426, -71.665541",
      "INTERSTATE 93 SB MM 88.4", "43.868167, -71.665823",
      "INTERSTATE 93 NB Exit 29", "43.870262, -71.668538",
      "INTERSTATE 93 NB MM 88.6", "43.870401, -71.668775",
      "INTERSTATE 93 SB MM 88.6", "43.870136, -71.669096",
      "INTERSTATE 93 SB Exit 29", "43.871168, -71.670826",
      "INTERSTATE 93 NB MM 88.8", "43.871165, -71.670832",
      "INTERSTATE 93 SB MM 88.8", "43.872005, -71.672230",
      "INTERSTATE 93 NB MM 89.0", "43.874899, -71.673745",
      "INTERSTATE 93 SB MM 89.0", "43.874560, -71.674848",
      "INTERSTATE 93 NB MM 89.2", "43.877629, -71.674791",
      "INTERSTATE 93 SB MM 89.2", "43.877463, -71.675855",
      "INTERSTATE 93 NB MM 89.4", "43.880519, -71.676095",
      "INTERSTATE 93 SB MM 89.4", "43.880094, -71.677035",
      "INTERSTATE 93 NB MM 89.6", "43.882912, -71.677665",
      "INTERSTATE 93 SB MM 89.6", "43.882713, -71.678576",
      "INTERSTATE 93 NB MM 89.8", "43.885638, -71.679452",
      "INTERSTATE 93 SB MM 89.8", "43.885519, -71.680239",
      "INTERSTATE 93 NB MM 90.0", "43.888285, -71.681030",
      "INTERSTATE 93 SB MM 90.0", "43.888135, -71.681612",
      "INTERSTATE 93 NB MM 90.2", "43.891025, -71.682311",
      "INTERSTATE 93 SB MM 90.2", "43.890891, -71.682856",
      "INTERSTATE 93 NB MM 90.4", "43.893815, -71.683761",
      "INTERSTATE 93 SB MM 90.4", "43.893661, -71.684224",
      "INTERSTATE 93 NB MM 90.6", "43.896244, -71.685663",
      "INTERSTATE 93 SB MM 90.6", "43.896004, -71.686211",
      "INTERSTATE 93 NB MM 90.8", "43.898802, -71.687614",
      "INTERSTATE 93 SB MM 90.8", "43.898598, -71.688417",
      "INTERSTATE 93 NB MM 91.0", "43.901601, -71.688355",
      "INTERSTATE 93 SB MM 91.0", "43.901461, -71.689839",
      "INTERSTATE 93 NB MM 91.2", "43.904458, -71.689165",
      "INTERSTATE 93 SB MM 91.2", "43.904123, -71.690851",
      "INTERSTATE 93 NB MM 91.4", "43.907224, -71.690368",
      "INTERSTATE 93 SB MM 91.4", "43.907035, -71.691472",
      "INTERSTATE 93 NB MM 91.6", "43.910063, -71.691080",
      "INTERSTATE 93 SB MM 91.6", "43.910028, -71.692024",
      "INTERSTATE 93 NB MM 91.8", "43.912954, -71.691548",
      "INTERSTATE 93 SB MM 91.8", "43.912889, -71.692375",
      "INTERSTATE 93 NB MM 92.0", "43.915825, -71.691412",
      "INTERSTATE 93 SB MM 92.0", "43.915962, -71.692372",
      "INTERSTATE 93 NB MM 92.2", "43.918666, -71.690712",
      "INTERSTATE 93 SB MM 92.2", "43.918831, -71.691893",
      "INTERSTATE 93 NB MM 92.4", "43.921537, -71.690028",
      "INTERSTATE 93 SB MM 92.4", "43.921685, -71.691293",
      "INTERSTATE 93 NB MM 92.6", "43.924355, -71.689191",
      "INTERSTATE 93 SB MM 92.6", "43.924578, -71.690035",
      "INTERSTATE 93 NB MM 92.8", "43.927087, -71.687808",
      "INTERSTATE 93 SB MM 92.8", "43.927272, -71.688459",
      "INTERSTATE 93 NB MM 93.0", "43.929825, -71.686452",
      "INTERSTATE 93 SB MM 93.0", "43.929901, -71.687092",
      "INTERSTATE 93 NB MM 93.2", "43.932675, -71.686592",
      "INTERSTATE 93 SB MM 93.2", "43.932560, -71.687180"
  });
 }
