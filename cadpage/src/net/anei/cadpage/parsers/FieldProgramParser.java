package net.anei.cadpage.parsers;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * This is a general purpose programmable field parser.  It can be used as a
 * base class for parser that have to process an array of fields that lack
 * keyword identifiers but which should appear in a particular order.  There
 * is a provision to allow the order to be adjusted to handle optional fields
 * that may or may not be present.
 * 
 * The field sequence program consists of one string with a number of field
 * terms separated by blanks.  Each field term consists of the following
 * 
 * 1) A field name, these will match the names used in parser testing classes
 *    Subclasses can override the default field processors, or add their own
 *    by overriding the getField() method
 *    
 * 2) An optional colon followed by one or more alphanumeric characters that
 *    can be used to designate special handling by this field processor.
 *    
 * 3) An optional exclamation point [!] which indicates that this field is
 *    required and the parse operation should fail if it runs out of data before
 *    this field is processed
 *    
 * 4) An optional plus sign [+] which indicates that this field should repeat
 *    Indefinitely.  Typically this only be used for INFO fields
 *    
 * 5) An option question mark [?] which indicates that this field may not be
 *    present.  The question mark may or may not be followed by a trigger 
 *    character.  If there is a trigger character, the presence of this character
 *    in position one of the data field indicates that the field is present, otherwise
 *    this field term will be skipped and the next field term used to process
 *    the current data field.  If there is no trigger character the program
 *    will attempt to deduce whether the field exists or not by querying the
 *    field processor for this and possibly subsequent field terms 
 *    
 * Field Qualifiers
 *   All conditional fields
 *     Z - suppress condition checks.  This is useful is this fields condition
 *     check is less reliable than another field behind it  
 *    
 * The ugly details on optional fields
 * 
 * Some data fields (like ADDR, ID, and X) have internal logic
 * to make a decision as to whether a particular data field is valid or not.
 * For these, the ? qualifier just calls that fields validation logic and uses
 * that to determine whether or not the field is present.
 * 
 * Others, like PLACE and INFO, have no such logic.  Yet we can and often do
 * use the ? qualifier when the field may or may not be present.  In such cases
 * the program looks for the next field after the optional field that does have
 * validation logic and tries to process that field on the assumption that the
 * optional field is missing.  If the validation fails, it proceeds assuming
 * the optional field is present.  The exact logic on which fields to check and
 * in what order is made when the parser class is instantiated, the program
 * string you pass is compiled into a set of parse and validation steps which
 * can then be executed when a string needs to be parsed.
 */

public class FieldProgramParser extends SmartAddressParser {
  
  // list of cities
  private String[] cities = null;
  
  // table converting city codes to city names
  private Properties cityCodes = null;
  
  // Original program string
  private String programStr;
  
  private Step program;
  
  public FieldProgramParser(String[] cities, String defCity, String defState, String programStr) {
    super(cities, defCity, defState);
    this.cities = cities;
    setProgram(programStr);
  }
  
  public FieldProgramParser(Properties cityCodes, String defCity, String defState, String programStr) {
    super(cityCodes, defCity, defState);
    this.cityCodes = cityCodes;
    setProgram(programStr);
  }
  
  public FieldProgramParser(String defCity, String defState, String programStr) {
    super(defCity, defState);
    setProgram(programStr);
  }
  
  /**
   * @return uncompiled program string
   */
  public String getProgram() {
    return programStr;
  }
  
  /**
   * Compile program string into a Step tree that will execute the requested
   * field assignments
   * @param programStr program string to be compiled
   */
  protected void setProgram(String programStr) {
    
    this.programStr = programStr;
    
    // Split program string into field terms
    String[] fieldTerms = programStr.split(" ");
    
    // Build arrays of term info and of field steps for each field term
    // The steps array has an extra entry at the beginning that is only used
    // to track the program start point
    FieldTermInfo[] infoList = new FieldTermInfo[fieldTerms.length];
    Step[] fieldSteps = new Step[fieldTerms.length+1];
    fieldSteps[0] = new Step(null, false);

    // First pass through the field terms, constructing the appropriate field
    // and program step that will be used.
    for (int ndx = 0; ndx < fieldTerms.length; ndx++) {
      FieldTermInfo info = new FieldTermInfo(fieldTerms[ndx]);
      infoList[ndx] = info; 
      Field field = getField(info.name);
      field.setQual(info.qual);
      field.setTrigger(info.trigger);
      fieldSteps[ndx+1] = new Step(field, info.required);
    }

    // The first (dummy) step just links to the first real step.  We have to
    // keep the 1 field increment so things work out if the first field
    // is a deferred optional field, but we will invoke it with an initial
    // index of -1 so things will work out
    int optBreak = -1;
    boolean optRepeat = false;
    fieldSteps[0].setNextStep(fieldSteps[1]);
    
    // And we need a tail step so fail branches at the end of the program
    // will have something to branch to
    Step tail = new Step(null, false);
    
    
    // Now to start a second pass, this will will figure out just how the
    // steps need to be linked together
    for (int ndx = 0; ndx < fieldTerms.length; ndx++) {
      
      // Get the current, and next steps in normal sequence
      Step step = fieldSteps[ndx+1];
      Step next = ndx+1 < fieldTerms.length ? fieldSteps[ndx+2] : tail;
      
      // we will start by assuming things progress in a normal flow, until
      // we determine otherwise.  Next data increment defaults to one which
      // is what we want
      step.setNextStep(next);
      
      // Check term info for things that would disrupt the natural order of
      // things
      FieldTermInfo info = infoList[ndx];
      
      // Of which the most disruptive by far is an untestable optional field
      // somewhere behind us.
      if (optBreak >= 0) {
        
        // We are looking for a normal testable field that can resolve the
        // status of the untestable one.  If we find repeat or optional step
        // before that, all is lost
        if (info.repeat || info.optional) {
          throw new RuntimeException("Deferred optional status of " + fieldTerms[optBreak] + " not resolved before " + fieldTerms[ndx]);
        }
        
        // OK, is this our testable determination step?
        if (step.canFail()) {
          
          // It is, now things get tricky
          // If this is a normal deferred condition, The decision step needs to 
          // be cloned because it will have to appear twice in the step program.
          // This isn't a problem when a repeat condtional is deferrred
          Step newStep = optRepeat ? step : step.cloneStep();
          
          // The step before the optional break has to jump to our new cloned
          // decision step, adjusting the field increment under the assumption 
          // that there the optional data field is not, in fact, present.
          int delta = ndx - optBreak;
          fieldSteps[optBreak].setNextStep(newStep);
          fieldSteps[optBreak].setNextInc(delta);
          
          // A step failure here implies that the optional field does exist
          // Failure branch will jump back to the optional branch, and proceed
          // normally from there, which includes processing the original step
          // for this field without a failure option
          Step optStep = fieldSteps[optBreak+1];
          newStep.setFailStep(optStep);
          newStep.setFailInc(-(delta-1));
          
          // If this is a deferred conditional repeat, the optional repeat
          // step has to jump back to this decision step to see if it should
          // continue looping.  If this isn't a repeat, we do nothing, and
          // the logic will flow normally along the steps between the option
          // step and the decision step, executing the original step for
          // this field that still does not have a failure branch
          if (optRepeat) {
            optStep.setNextStep(step);
            optStep.setNextInc(delta);
          }
          
          // The success branch will execute a chain of steps cloned from all
          // of the steps between the optional step and this decision step
          // (which may be empty if the two are next to each other) then
          // skip this step and take up normal processing with the next step
          // For repeat conditional process, it is not necessary to clone the
          // intervening steps because they repeating step never tries to
          // execute them
          newStep.setNextInc(-(delta-1));
          Step prev = newStep;
          int nextInc = 1;
          for (int jj = optBreak+1; jj<ndx; jj++) {
            nextInc = 2;
            newStep = fieldSteps[jj+1];
            if (!optRepeat) newStep = newStep.cloneStep();
            prev.setNextStep(newStep);
            prev = newStep;
          }
          prev.setNextStep(next);
          prev.setNextInc(nextInc);
          
          // And finally, reset the optional break so we can resume
          // normal processing
          optBreak = -1;
        }
      }
      
      // OK, that wasn't a problem, see if this step has a repeat flag
      else if (info.repeat) {
        
        // It does, normal chain links back to the same step, processing
        // Consecutive fields until something happens
        step.setNextStep(step);
        
        // If optional flag is set as well as repeat flag, we have some other
        // wierdness
        if (info.optional) {
          
          // If the step can detect failures, we can set the failure branch
          // to the next step, processing the same field there
          if (step.canFail()) {
            step.setFailStep(next);
          } 
          
          // If it can't detect failures, we have to defer the decision
          // which is going to pretty much work the way the regular deferred
          // optional field words
          else {
            optRepeat = true;
            optBreak = ndx;
          }
        }
      }
      
      // Next thing to check is a optional flag without the repeat flag
      else if (info.optional) {
        
        // If this step can do its own validity testing, life is wonderful
        // We just set the fail condition to process the next step with the
        // same data field
        if (step.canFail()) {
          step.setFailStep(next);
        }
        
        // Otherwise, life gets complicated.
        // We will have to defer the decision as to whether this field exists
        // or not based on a subsequent field that can be validated.  For now
        // just remember where the option break is
        else {
          optRepeat = false;
          optBreak = ndx;
        }
      }
    }
    
    // End of second pass
    // If we are still trying to resolve an optional break, complain
    if (optBreak >= 0) {
      throw new RuntimeException("Deferred optional status of " + fieldTerms[optBreak] + " was never resolved");
    }
    
    // Save first node as the start of the step program
    program = fieldSteps[0];
  }
  
  /**
   * This class holds all of the basic information parsed from a program string
   * field term
   */
  private static class FieldTermInfo {
    String name = null;
    String qual = null;
    boolean required = false;
    boolean repeat = false;
    boolean optional = false;
    char trigger = 0;
    
    FieldTermInfo(String fieldTerm) {
      
      int len = fieldTerm.length();
      int pt = 0;
      
      // parse field name
      while (pt < len && Character.isUpperCase(fieldTerm.charAt(pt))) pt++;
      name = fieldTerm.substring(0, pt);
      
      // parse field qualifier, if it exists
      if (pt >= len) return;
      char chr = fieldTerm.charAt(pt++);
      if (chr == ':') {
        
        int st = pt;
        if (pt >= len) return;
        while (pt < len && Character.isUpperCase(fieldTerm.charAt(pt))) pt++;
        qual = fieldTerm.substring(st, pt);
        if (pt >= len) return;
        chr = fieldTerm.charAt(pt++);
      }
      
      // Check for Required [!] indicator
      if (chr == '!') {
        required = true;
        if (pt >= len) return;
        chr = fieldTerm.charAt(pt++);
      }
      
      // Check for repeat [+] indicator
      if (chr == '+') {
        repeat = true;
        if (pt >= len) return;
        chr = fieldTerm.charAt(pt++);
      }
      
      // Check for optional [?] indicator
      if (chr == '?') {
        optional = true;
        if (pt >= len) return;
        trigger = fieldTerm.charAt(pt++);
      }
      
      if (pt < len) {
        throw new RuntimeException("Invalid field term: " + fieldTerm);
      }
    }
  }
  
  
  /**
   * This method is invoked to process an array of parsed fields as determined
   * by the field program passed to the constructor
   * @param fields Array of fields to be processed
   * @param data Data object to be filled
   * @return true if parsing was successful
   */
  public boolean parseFields(String[] fields, Data data) {
    return program.process(fields, -1, data);
  }
  
  
  // This class performs one program step
  private class Step {
    
    private boolean required;
    
    private Field field;
    private Step nextStep = null;
    private int nextInc = 1;
    private Step failStep = null;;
    private int failInc = 0;
    
    public Step(Field field, boolean required) {
      this.field = field;
      this.required = required;
    }

    public void setNextStep(Step nextStep) {
      this.nextStep = nextStep;
    }

    public void setNextInc(int nextInc) {
      this.nextInc = nextInc;
    }

    public void setFailStep(Step failStep) {
      this.failStep = failStep;
    }

    public void setFailInc(int failInc) {
      this.failInc = failInc;
    }
    
    public boolean canFail() {
      return field.doCanFail();
    }
    
    public Step cloneStep() {
      return new Step(field, required);
    }

    /**
     * Execute the program starting with this step.  The method will
     * recursively call itself for subsequent steps until the entire
     * program has been processed.
     * @param flds Array of fields being processed
     * @param ndx current field index
     * @param data Data object being set up
     * @return true if successful, false otherwise
     */
    public boolean process(String[] flds, int ndx, Data data) {
      
      // If we have passed the end of the data fields, all we have to
      // do is check that there are no remaining required fields that have
      // not been processed
      if (ndx >= flds.length) {
        return checkFailure();
      }
      
      // Next we invoke our field object to process the current data field.
      // If there is a fail step, we will ask the field object to check to
      // see if this is a valid data field before parsing it.  if there is
      // not, it will not be given that option
      boolean success = true;
      if (field != null) {
        if (failStep != null) {
          success = field.doCheckParse(flds[ndx], data);
        }
        else {
          field.parse(flds[ndx], data);
        }
      }
      
      // Now determine which step and data field increment should be used
      Step step = (success ? nextStep : failStep);
      int inc = (success ? nextInc : failInc);
      
      // if the next step is null, the program has completed and we can
      // return a successful result.  Otherwise call ourselves to process
      // the next step on the program.
      if (step == null) return true;
      return step.process(flds, ndx + inc, data);
    }
    
    /**
     * This is called when we have reached the end of the data fields and
     * need to ensure that there are no required fields remaining to be
     * processed.
     * 
     * @return true if there are no required fields remaining in the normal
     * program sequence
     */
    private boolean checkFailure() {

      // If this is a required step, return failure
      if (required) return false;
      
      // If there are no more program steps, return success
      if (nextStep == null) return true;

      // One special case, if the success step loops back to itself
      // follow the fail step instead of the next step
      Step step = (nextStep == this ? failStep : nextStep);
      if (step == null) return true;
      
      // Still undetermined, return the failure status of the next step
      return step.checkFailure();
    }
  }

  /*
   * This is the base class for all single field processors
   */
  abstract public class Field {
    
    private String qual = null;
    
    private boolean noVerify;

    private char trigger = 0;
    
    private Pattern pattern = null;
    
    public void setTrigger(char trigger) {
      this.trigger = trigger;
    }

    public void setQual(String qual) {
      this.qual = qual;
      if (qual != null) this.noVerify = qual.contains("Z");
    }
    
    public String getQual() {
      return qual;
    }

    public void setPattern(Pattern pattern) {
      this.pattern = pattern;
    }
    
    protected boolean isNoVerify() {
      return noVerify;
    }
    
    /**
     * @return true if field parser has the ability to confirm whether passed
     * field is valid
     */
    public final boolean doCanFail() {
      if (noVerify) return false;
      if (trigger != 0) return true;
      return canFail();
    }
    
    /**
     * @return true if field parser has the ability to confirm whether passed
     * field is valid
     */
    public boolean canFail() {
      return pattern != null;
    }

    /**
     * Check if field is valid for this position, and if it is parse it.  This
     * should never be called unless canFail() returns true
     * @param field field to be checked and parsed
     * @return if this is a valid field
     */
    public final boolean doCheckParse(String field, Data data) {
      
      // If there is a trigger character, see if this starts with it
      if (trigger != 0) {
        if (field.length() == 0) return false;
        if (field.charAt(0) != trigger) return false;
        parse(field.substring(1).trim(), data);
        return true;
      }
      
      return checkParse(field, data);
    }

    /**
     * Check if field is valid for this position, and if it is parse it.  This
     * should never be called unless canFail() returns true
     * @param field field to be checked and parsed
     * @return if this is a valid field
     */
    public boolean checkParse(String field, Data data) {
      
      if (!pattern.matcher(field).matches()) return false;
      parse(field, data);
      return true;
    }
    
    /**
     * Convenience method to append two strings with a connector
     * @param str1 first string
     * @param connector connector string
     * @param str2 second string
     * @return appended string
     */
    protected String append(String str1, String connector, String str2) {
      if (str1.length() == 0) return str2;
      if (str2.length() == 0) return str1;
      return str1 + connector + str2;
    }
    
    /*
     * parse data field
     */
    abstract public void parse(String field, Data data);
    
    /**
     * Return blank separated names of the base info fields that might be set by this field
     * If this returns null, the name of of the field term used to look up
     * this field will be used.  It should be overridden by any field processor
     * that sets an info field other than the one described by its name
     * @return
     */
    public String getFieldNames() {
      return null;
    }
  }

  /**
   * Call field processor
   */
  public class CallField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " / ", field);
    }
  }

  /**
   * Place field processor
   */
  public class PlaceField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      data.strPlace = field;
    }
  }

  /**
   * Address field processor
   */
  public class AddressField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (checkAddress(field) <= 0) return false;
      parse(field, data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      parseAddress(field, data);
    }
  }

  /**
   * City field processor
   */
  public class CityField extends Field {
    
    @Override
    public boolean canFail() {
      return cities != null || cityCodes != null;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (cityCodes != null) {
        String city = cityCodes.getProperty(field);
        if (city == null) return false;
        data.strCity = city;
        return true;
      }
      
      // Otherwise we must have a cities list
      for (String city : cities) {
        if (field.equals(city)) {
          data.strCity = field;
          return true;
        }
      }
      return false;
    }

    @Override
    public void parse(String field, Data data) {
      if (cityCodes != null) {
        data.strCity = convertCodes(field, cityCodes); 
      } else {
        data.strCity = field;
      }
    }
  }
  
  /**
   * Apartment field processor
   */
  public class AptField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strApt = field;
    }
  }

  /**
   * Cross street field processor
   */
  public class CrossField extends Field {
    
    
    @Override
    public boolean canFail() {
      return true;
    }
  
    @Override
    public boolean checkParse(String field, Data data) {
      if (checkAddress(field) == 0) return false;
      parse(field, data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      data.strCross = append(data.strCross, " & ", field);
    }
  }

  /**
   * Box field processor
   */
  public class BoxField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      data.strBox = field;
    }
  }

  /**
   * Unit field processor
   */
  public class UnitField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strUnit = field;
    }
  }

  /**
   * State field processor
   */
  public class StateField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strState = field;
    }
  }

  /**
   * Map field processor
   */
  public class MapField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strMap = field;
    }
  }

  /**
   * ID field processor
   */
  private static final Pattern NORMAL_ID_PAT = Pattern.compile("[0-9]{3,}");
  public class IdField extends Field {
    
    public IdField() {
      setPattern(NORMAL_ID_PAT);
    }

    @Override
    public void parse(String field, Data data) {
      data.strCallId = field;
    }
  }

  /**
   * Phone field processor
   */
  public class PhoneField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      data.strPhone = field;
    }
  }

  /**
   * Supplemental info field processor
   */
  static final Pattern APT_PAT = Pattern.compile("^APT( |:|#) *", Pattern.CASE_INSENSITIVE);
  public class InfoField extends Field {
    
    
    @Override
    public void parse(String field, Data data) {
      
      // Some special keywords will divert info to other fields
      if (field.length() <= 10 && data.strApt.length() == 0) {
        Matcher match = APT_PAT.matcher(field);
        if (match.find()) {
          data.strApt = field.substring(match.end());
          return;
        }
      }
      data.strSupp = append(data.strSupp, " / ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO APT";
    }
  }

  /**
   * Source field processor
   */
  public class SourceField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strSource = field;
    }
  }

  /**
   * Code field processor
   */
  public class CodeField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strCode = field;
    }
  }

  /**
   * Name field processor
   */
  public class NameField extends Field {

    @Override
    public void parse(String field, Data data) {
      data.strName = field;
    }
  }
  
  /**
   * Skip field processor
   */
  public class SkipField extends Field {

    @Override
    public void parse(String field, Data data) {
    }
  }
  
  /**
   * Initials field processor
   * Field containing dispatcher initials, which is skipped
   * but has ability to verify initials contents
   */
  private static final Pattern INITLS_PAT = Pattern.compile("[A-Z]{2,3}");
  public class InitialsField extends Field {
    
    public InitialsField() {
      setPattern(INITLS_PAT);
    }

    @Override
    public void parse(String field, Data data) {
    }
  }
  
  /**
   * Look up the field processor associated with name
   * This should be overridden by classes that need some special field
   * processing
   * @param name requested field name
   * @return field processor
   */
  protected Field getField(String name) {

    if (name.equals("CALL")) return new CallField();
    if (name.equals("PLACE")) return new PlaceField();
    if (name.equals("ADDR")) return new AddressField();
    if (name.equals("CITY")) return new CityField();
    if (name.equals("APT")) return new AptField();
    if (name.equals("X")) return new CrossField();
    if (name.equals("BOX")) return new BoxField();
    if (name.equals("UNIT")) return new UnitField();
    if (name.equals("ST")) return new StateField();
    if (name.equals("MAP")) return new MapField();
    if (name.equals("ID")) return new IdField();
    if (name.equals("PHONE")) return new PhoneField();
    if (name.equals("INFO")) return new InfoField();
    if (name.equals("SRC")) return new SourceField();
    if (name.equals("CODE")) return new CodeField();
    if (name.equals("NAME")) return new NameField();
    if (name.equals("SKIP")) return new SkipField();
    if (name.equals("INTLS")) return new InitialsField();
    
    // TODO Add and END field processor that does nothing but can test for
    // the end of the data sequence
    
    throw new RuntimeException("Invalid field name: " + name);
  }
}
