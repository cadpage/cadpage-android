package net.anei.cadpage.parsers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

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
 * 2) An optional slash followed by one or more alphanumeric characters that
 *    can be used to designate special handling by this field processor.
 *    
 * 3) An optional exclamation point [!] which indicates that this field is
 *    required and the parse operation should fail if it runs out of data before
 *    this field is processed, or
 *    An optional percent sign [%] which indicates that this field is expected.
 *    A missing expected field will not cause the parse operation to fail, but
 *    it will cause Cadpage to wait for a second text message containing the
 *    rest of the CAD page
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
 *   Address fields
 *     y - parse -xx city convention
 *     i - implied intersection convention
 *     s - accept sloppy addresses
 *     a - no implied address (only with smart parser logic)
 *     S - Invoke smart parser logic, this is followed by some optional flag
 *         characters, followed by up two 3 field designation characters
 *         Flag characters
 *         0 - @ or AT can mark begining of address or place
 *         1 - @ or AT marks beginning of place
 *         2 - Only @ will be treated as start maker.  Ignore "AT"
 *         First field character determines what can come ahead of the address
 *         X - nothing
 *         C - call description (req)
 *         c - call description (opt)
 *         P - Place name (opt)
 *         p - place name (req)
 *         S - something we can skip (opt)
 *         s - something we can skip (req)
 *         Second field character determines what data comes after the address
 *         X - nothing
 *         C - call description
 *         P - place name
 *         S - something we can skip
 *         a - apartment
 *         U - unit
 *         N - name
 *         I - supplemental info
 *         x - cross streets
 *         Third field character determines what to do with a special field between 
 *         the regular address and the city field
 *         X - nothing
 *         P - place name
 *         S - something we can skip
 *         
 * SPECIAL FIELD NAMES
 * 
 * INTLS - operator initials, always skipped but will validated as 1-3 upper case letters
 * 
 * EMPTY - Empty field.  Must always be empty
 * 
 * ADDRCITY - Address and City field separated by a comma.  Can take all ofthe
 * special field qualifiers that an address field can.
 * 
 * END - Does no processing, fails if not beyond the end of the data fields
 * 
 * SELECT - Does not process a field, only makes yes/no selection decision after calling the
 *          getSelectValue() method.  If the result matches the qualifer string, the test
 *          succeeds, otherwise it fails.
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
 * 
 * Conditional branches
 * 
 * Conditional branches are an advanced feature that can be incredibly
 * useful in certain cases.  If there is a point in your program where
 * different field patterns may be possible, they can be enclosed in
 * parenthesis and separated by pipe characters.  For example
 * 
 * CALL ADDR ( CITY STATE | MAP ) INFO+
 * 
 * All of the conditional branches in a group, except the last one, must have
 * contain a validatable field that will be used to determine if this is the
 * correct branch to process
 * 
 * Keyword tags
 * 
 * tagged field can be defined by prefixing the field term with a tag name and
 * a colon.  A tagged field term will only match a data field that starts with
 * that tag name and a colon.  Tagged and positional (untagged) fields can 
 * be intermixed.
 * 
 * A keyword tagged field can be declared optional, which determines what happens
 * when no matching data field is found.  Normal behavior is to assume that
 * the tagged data field exists somewhere beyond the end of the field and pretty
 * much terminates field processing.  The the tagged field is declared optional
 * with a ? qualifier and no matching data field is found, the tagged field is
 * simply ignored and processing picks up with the next field.
 */

public class FieldProgramParser extends SmartAddressParser {
  
  // Flag indicating fields can occur in any order
  // Field keywords are required to keep things straight
  public static final int FLDPROG_ANY_ORDER = 1;
  
  // Flag indicating that keyword matches do not have to match case
  public static final int FLDPROG_IGNORE_CASE = 2;
  
  // list of cities
  private Set<String> cities = null;
  
  // table converting city codes to city names
  private Properties cityCodes = null;
  
  // Original program string
  private String programStr;
  
  // Start of program steps
  private StepLink startLink;
  
  // True if any of our program steps contain a tag
  private boolean parseTags = false;
  
  // List of tags on the main path
  private String[] tagList = null;
  
  // Character used to terminate keywords
  private char breakChar = ':';
  
  // Fields can occur in any order
  private boolean anyOrder;
  
  // Case should be ignored when comparing keywords
  private boolean ignoreCase;
  
  private Map<String, Step> keywordMap = null;
  
  public static String setExpectFlag(String program, String fldTerm) {
    if (fldTerm == null) return program;
    int pt = program.indexOf(fldTerm);
    if (pt < 0) throw new RuntimeException("Field term not found");
    pt += fldTerm.length();
    return program.substring(0,pt) + '%' + program.substring(pt);
  }
  
  public FieldProgramParser(String[] cities, String defCity, String defState, String programStr) {
    this(cities, defCity, defState, CountryCode.US, programStr, 0);
  }
  
  public FieldProgramParser(String[] cities, String defCity, String defState, String programStr, int flags) {
    this(cities, defCity, defState, CountryCode.US, programStr, flags);
  }
  
  public FieldProgramParser(Properties cityCodes, String defCity, String defState, String programStr) {
    this(cityCodes, defCity, defState, programStr, 0);
  }
  
  public FieldProgramParser(Properties cityCodes, String defCity, String defState, String programStr, int flags) {
    super(cityCodes, defCity, defState);
    this.cityCodes = cityCodes;
    setProgram(programStr, flags);
  }
  
  public FieldProgramParser(String defCity, String defState, String programStr) {
    super(defCity, defState);
    setProgram(programStr, 0);
  }
  
  public FieldProgramParser(String defCity, String defState, String programStr, int flags) {
    super(defCity, defState);
    setProgram(programStr, flags);
  }
  
  public FieldProgramParser(String[] cities, String defCity, String defState, CountryCode country, String programStr) {
    this(cities, defCity, defState, country, programStr, 0);
  }
  
  public FieldProgramParser(String[] cities, String defCity, String defState, CountryCode country, 
                             String programStr, int flags) {
    super(cities, defCity, defState, country);
    if (cities != null) this.cities = new HashSet<String>(Arrays.asList(cities));;
    setProgram(programStr, flags);
  }
  
  /**
   * Set the character used to mark the end of  keyword
   * @param breakChar new break character
   */
  protected void setBreakChar(char breakChar) {
    this.breakChar = breakChar;
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
  private static final Pattern TAG_PTN = Pattern.compile("([^ :]+):");
  protected void setProgram(String program, int flags) {
    
    anyOrder = (flags & FLDPROG_ANY_ORDER) != 0;
    ignoreCase = (flags & FLDPROG_IGNORE_CASE) != 0;

    if (program == null) return;
    
    parseTags = false;
    this.programStr = program;
    
    // Construct a head link and tail node and compile the tokens between them
    this.startLink = new StepLink(0);
    Step tail = new Step(null, null, null, false);
    compile(this.startLink, program, tail, null);
    
    // Now that we no longer need it, reduce the tail node
    tail.removeSkip();
    
    // And finally build a list of tags we can use to parse undelimited messages
    // We used to do this by scanning through the compiled steps, but that misses
    // tags on conditional branches.  Now we just parse tags from the program string
    tagList = null;
    if (parseTags) {
      List<String> tags = new ArrayList<String>();
      Matcher match = TAG_PTN.matcher(program);
      while (match.find()) {
        String key = match.group(1).replace('_', ' ');
        if (ignoreCase) key = key.toUpperCase();
        tags.add(key);
      }
      tagList = tags.toArray(new String[tags.size()]);
    }
    
    // If we are processing fields in any order, build a keyword > Field
    if (anyOrder) {
      keywordMap = new LinkedHashMap<String, Step>();
      for (Step step = startLink.getStep(); step != null; step = step.nextStep) {
        if (step.tag != null && step.field != null) {
          keywordMap.put(step.tag, step);
        }
      }
    }
  }
  
  /**
   * 
   * Compile program string into a chain of program steps
   * @param headLink The step link that should end up pointing to the start
   * of the program chain
   * @param program Program string to be compiled
   * @param tail Program step were all execution chains should terminate
   * @param failStep If not null, the step that should be jumped to if
   * a data stream cannot be matched to the program.  If null, no attempt 
   * will be made to validate the data stream.
   */
  private void compile(StepLink headLink, String program, Step tail, Step failStep) {
    
    // Empty string is a special, easily handled, case
    if (program.length() == 0) {
      headLink.setLink(tail, 0);
      return;
    }
    
    // Split program string into field terms
    String[] fieldTerms = tokenize(program);;
    
    // Build arrays of term info and of field steps for each field term
    FieldTermInfo[] infoList = new FieldTermInfo[fieldTerms.length];
    Step[] fieldSteps = new Step[fieldTerms.length];

    // First pass through the field terms, constructing the appropriate field
    // and program step that will be used.
    for (int ndx = 0; ndx < fieldTerms.length; ndx++) {
      FieldTermInfo info = new FieldTermInfo(fieldTerms[ndx], breakChar);
      if (anyOrder) {
        if (info.tag == null) throw new RuntimeException("Any order fields must have a keyword: " + fieldTerms[ndx]);
        if (info.optional) {
          throw new RuntimeException("Any order parsers do not support optional fields:" + fieldTerms[ndx]);
        }
      }
      if (ignoreCase & info.tag != null) info.tag = info.tag.toUpperCase(); 
      infoList[ndx] = info;
      Field field = null;
      if (!info.branch){ 
        field = getField(info.name);
        field.setQual(info.qual);
        field.setTrigger(info.trigger);
      }
      fieldSteps[ndx] = new Step(info.tag, field, info.required, info.optional);
    }

    // Initialize stuff, and link the heading link to the first step
    // If there is a failure step (meaning we are compiling a conditional branch)
    // There is an implicit decision required about the first node
    int optBreak = (failStep != null ? 0 : -1);
    boolean optRepeat = false;
    headLink.setLink(fieldSteps[0]);
    
    // Now to start a second pass, this will will figure out just how the
    // steps need to be linked together
    for (int ndx = 0; ndx < fieldTerms.length; ndx++) {
      
      // Get the previous link, and current, and next steps in normal sequence
      Step step = fieldSteps[ndx];
      Step next = ndx+1 < fieldTerms.length ? fieldSteps[ndx+1] : tail;
      step.setNextStep(next);
      
      // Check term info for things that would disrupt the natural order of
      // things
      FieldTermInfo info = infoList[ndx];
      
      // Of which the most disruptive by far is an untestable optional field
      // somewhere behind us.
      if (optBreak >= 0) {
        
        // We are looking for a normal testable field that can resolve the condition
        // status of the untestable one.  If we find repeat or optional step
        // or tagged step before that, all is lost
        if (info.repeat || info.optional || info.branch) {
          throw new RuntimeException("Deferred optional status of " + fieldTerms[optBreak] + 
                                      " not resolved before " + fieldTerms[ndx]);
        }
        
        // OK, is this our testable determination step?
        if (step.canFail()) {
          
          // There are three reasons why a condition check is deferred
          // First we could be processing a conditional branch subprogram
          int delta = ndx - optBreak;
          Step optStep = fieldSteps[optBreak];
          if (failStep != null) {
            
            // Start link should point to this node
            // with the appropriate index adjustment
            headLink.setLink(step, delta);
            
            // Failure link jumps to failure step, reversing the index adjustment
            step.getFailLink().setLink(failStep, -delta);
            
            // Success link can go two different ways
            // if the decision step is the first step, success links to the next step
            if (delta == 0) {
              step.getSuccLink().setLink(next);
            }
            
            // Otherwise, success link jumps back to first step, and the step
            // before the decision step bypasses the decision step
            else {
              step.getSuccLink().setLink(fieldSteps[optBreak], -(delta+1));
              fieldSteps[ndx-1].getSuccLink().setLink(next, 1);
            }
            
            // The conditional branch decision has been made, 
            // Null out the fail step so we don't try to do it again
            failStep = null;
            
          }
          // First it could be terminating an earlier repeat block
          else if (optRepeat) {
            
            // Redirect all links to the conditional repeat node to this, decision, node
            // Assuming that the optional node field does not exist.
            // Note, this include the link originally set up from the repeat node to itself
            fieldSteps[optBreak].redirect(step, delta-1);
            
            // Failure link jumps back to the optional repeat node, which we now assume
            // does exist
            step.getFailLink().setLink(optStep, -(delta-1));
            
            // Success link is trickier
            // If optional node and decision node are next to each other,
            // Success link just moves on the the next node normally
            if (delta == 1) {
              step.getSuccLink().setLink(next);
            }
            
            // If there is a sequence of steps between the option and decision
            // steps success link jumps back to the first one, the success
            // link of the last one jumps over the decision step to point to
            // the following step
            else {
              step.getSuccLink().setLink(fieldSteps[optBreak+1], -delta);
              fieldSteps[ndx-1].getSuccLink().setLink(next, 1);
            }
          }
          
          // Otherwise this is a normal deferred conditional test
          else {
            
            // The decision step needs to 
            // be cloned because it will have to appear twice in the step program.
            // The original step will not be a decision step and will flow
            // normally to the next step
            Step newStep = step.cloneStep();
            step.getSuccLink().setLink(next);

            // redirect all links to the optional step to the decision step
            // assuming that the optional field does not exist
            optStep.redirect(newStep, delta-1);
            
            // A step failure here implies that the optional field does exist
            // Failure branch will jump back to the optional branch, and proceed
            // normally from there, which includes processing the original step
            // for this field without a failure option
            newStep.getFailLink().setLink(optStep,-(delta-1));
            
            // If the optional and decision steps are next to each other
            // the success branch can just move on the the next step normally
            if (delta == 1) {
              newStep.getSuccLink().setLink(next);
            }
            
            // Otherwise, the success branch will execute a chain of steps cloned from all
            // of the steps between the optional step and this decision step
            // (which may be empty if the two are next to each other) then
            // skip this step and take up normal processing with the next step
            else {
              int incAdj = -delta;
              Step prevStep = newStep;
              for (int jj = optBreak+1; jj<ndx; jj++) {
                newStep = fieldSteps[jj].cloneStep();
                prevStep.getSuccLink().setLink(newStep, incAdj);
                prevStep.removeSkip();
                prevStep = newStep;
                incAdj = 0;
              }
              prevStep.getSuccLink().setLink(next, 1);
              prevStep.removeSkip();
            }
          }
          
          // And finally, reset the optional break so we can resume
          // normal processing
          optBreak = -1;
        }
        
        // Otherwise, we are still searching for a decision mode, follow
        // normal logic flow
        else {
          step.getSuccLink().setLink(next);
        }
      }
      
      // So we aren't in deferred decision mode
      // See if this node is flagged to repeat
      else if (info.repeat) {
        
        // It does, normal chain links back to the same step, processing
        // Consecutive fields until something happens
        step.getSuccLink().setLink(step);
        
        // If optional flag is set as well as repeat flag, we have some other
        // weirdness
        if (info.tag == null && info.optional) {
          
          // If the step can detect failures, we can set the failure branch
          // to the next step, processing the same field there
          if (step.canFail()) {
            step.getFailLink().setLink(next);
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
      else if (info.tag == null && info.optional) {
        
        // In any case, logic from from this step goes to the next step
        step.getSuccLink().setLink(next);
        
        // If this step can do its own validity testing, life is wonderful
        // We just set the fail condition to process the next step with the
        // same data field
        if (step.canFail()) {
          step.getFailLink().setLink(next);
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
      
      // Otherwise, there is nothing unusual or extraordinary about this step
      // It will just link to the next step and field.
      else {
        step.getSuccLink().setLink(next);
      }
    }
    
    // End of second pass
    // If we are still trying to resolve an optional break, complain
    if (optBreak >= 0) {
      throw new RuntimeException("Deferred optional status of " + fieldTerms[optBreak] + 
                                  " was never resolved");
    }
    
    // And now for a final third pass to expand any conditional branch terms
    for (int ndx = 0; ndx < fieldTerms.length; ndx++) {
      if (infoList[ndx].branch) {
        
        // Split the branch step into a branch head and tail steps
        Step branchHead = fieldSteps[ndx];
        Step branchTail = branchHead.split();
        
        //  Next break the field term up into the different conditional branches
        String[] branchTerms = splitBranches(fieldTerms[ndx]);
        
        // Loop through each of the optional branches
        int cnt = 0;
        for (String branchTerm : branchTerms) {
          branchTerm = branchTerm.trim();
          
          // We need a temporary skip step with no data increment to link 
          // each conditional branch chains to the next.  Except for the
          // last one where we have no failure step
          Step linkStep = (++cnt == branchTerms.length ? null : new Step());
          
          // Each branch will be compiled using the branch head step as the
          // start step, the branch tail step as the tail step, and the new
          // link step as the branch failure step
          compile(branchHead.getSuccLink(), branchTerm, branchTail, linkStep);
          branchHead.setNextStep(branchHead.getSuccLink().getStep());
          branchHead.removeSkip();
          branchHead = linkStep;
        }
        branchTail.removeSkip();
      }
    }
    
    // Fourth pass to remove any remaining SKIP steps
    // We can't do this in the 2nd pass because a subsequent node might have
    // tried to link back to it
    for (Step step : fieldSteps) {
      step.removeSkip();
    }
  }
  
  /**
   * Break program string up into an array of tokens.  Tokens are generally
   * separated by blanks, but a list of items in parenthesis will be combined
   * into a single token
   * @param programStr program string to be compiled
   * @return list of program terms from program string
   */
  private String[] tokenize(String programStr) {
    
    // Initialize stuff
    List<String> tokenList = new ArrayList<String>();
    StringBuilder sb = null;
    int level = 0;
    
    // Break string down into blank delimited tokens and run through them
    for (String token : programStr.split(" +")) {
      
      // If we are working at the bottom level (which most of the time we will)
      if (level == 0) {
        
        if (token.equals(")")) {
          throw new RuntimeException("Mismatched parens in " + programStr);
        }
        
        // Check for open paren.  If we find one, crate a StringBuilder and 
        // save it there
        if (token.equals("(")) {
          if (anyOrder) throw new RuntimeException("Conditional branches not allowed in any order parsers");
          sb = new StringBuilder(token);
          level++;
        }
        
        // Otherwise add this token to the token list
        else tokenList.add(token);
      } 
      
      // If we aren't at level zero, we are working with something in parenthesis
      else {
        
        // Append this token to the saved string builder
        sb.append(' ');
        sb.append(token);
        
        // Adjust the parenthesis nesting level
        if (token.equals("(")) level++;
        if (token.equals(")")) {
          if (--level == 0) {
            
            // If we have closed the last paren create a token from the 
            // StringBuilder and save it in the token list
            tokenList.add(sb.toString());
            sb = null;
          }
        }
      }
    }
    
    // All done, but make sure we don't have any unmatched open parens
    if (level > 0) {
      throw new RuntimeException("Missing closing paren in" + programStr);
    }
    
    return tokenList.toArray(new String[tokenList.size()]);
  }
  
  /**
   * Split a conditional branch program into component branches
   * @param program conditional branch probram
   * @return array of conditional branch components
   */
  private static String[] splitBranches(String program) {
    
    List<String> branches = new ArrayList<String>();
    int st = 1;
    int lev = 0;
    for (int pt = 1; pt<program.length(); pt++) {
      char chr = program.charAt(pt);
      if ((chr == '|' && lev == 0) || pt == program.length()-1) {
        branches.add(program.substring(st, pt).trim());
        st = pt+1;
      } else if (chr == '(') lev++;
      else if (chr == ')') lev--;
    }
    if (lev != 0) throw new RuntimeException("Mismatched () in branch token: " + program);
    return branches.toArray(new String[branches.size()]);
  }
  
  /**
   * Check for any skip nodes that missed our optimization process
   * only called by the test suite
   */
  void checkForSkips() {
    startLink.getStep().checkForSkips();
  }
  
  // Enum report required status of a program step
  // NORMAL - nothing special
  // REQUIRED - If not present, message will be rejected
  // EXPECTED - If not present, message will be accepted, but will be flagged
  // as expecting more input
  private enum EReqStatus {NORMAL, REQUIRED, EXPECTED};
  
  /**
   * This class holds all of the basic information parsed from a program string
   * field term
   */
  private static class FieldTermInfo {
    String tag = null;
    String name = null;
    String qual = null;
    EReqStatus required = EReqStatus.NORMAL;
    boolean repeat = false;
    boolean optional = false;
    boolean branch = false;
    char trigger = 0;
    
    FieldTermInfo(String fieldTerm, char breakChar) {
      
      // If this is a conditional branch, just set the branch flag and return
      // The branch will be expanded later
      if (fieldTerm.startsWith("(")) {
        branch = true;
        return;
      }
      
      int len = fieldTerm.length();
      int st = fieldTerm.indexOf(breakChar);
      if (st > 0) {
        tag = fieldTerm.substring(0,st).replace('_', ' ');
      }
      st++;
      
      // parse field or tag name
      int pt = st;
      while (pt < len && 
             (Character.isJavaIdentifierPart(fieldTerm.charAt(pt)) || fieldTerm.charAt(pt)=='-')) pt++;
      
      name = fieldTerm.substring(st, pt);  
      
      // parse field qualifier, if it exists
      if (pt >= len) return;
      char chr = fieldTerm.charAt(pt++);
      if (chr == '/') {
        
        st = pt;
        if (pt >= len) return;
        while (pt < len && Character.isJavaIdentifierPart(fieldTerm.charAt(pt))) pt++;
        qual = fieldTerm.substring(st, pt);
        if (pt >= len) return;
        chr = fieldTerm.charAt(pt++);
      }
      
      // Check for Required [!] indicator
      if (chr == '!' || chr == '%') {
        required = (chr == '!' ? EReqStatus.REQUIRED : EReqStatus.EXPECTED);
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
      
      else {
        throw new RuntimeException("Invalid field term: " + fieldTerm);
      }
    }
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // We cannot break an undelimited message into fields without tag definitions
    if (!parseTags) {
      throw new RuntimeException("FieldProgramParser cannot parse message without tag definitions");
    }
    
    String[] fields = parseMessageFields(body, tagList, breakChar, anyOrder, ignoreCase);
    return parseFields(fields, data);
  }
  

  /**
   * This method is invoked to process an array of parsed fields as determined
   * by the field program passed to the constructor
   * @param fields Array of fields to be processed
   * @param minFields minimum required number of fields
   * @param data Data object to be filled
   * @return true if parsing was successful
   */
  protected boolean parseFields(String[] fields, int minFields, Data data) {
    if (fields.length < minFields) return false;
    return parseFields(fields, data);
  }

  /**
   * This method is invoked to process an array of parsed fields as determined
   * by the field program passed to the constructor
   * @param fields Array of fields to be processed
   * @param data Data object to be filled
   * @return true if parsing was successful
   */
  protected boolean parseFields(String[] fields, Data data) {
    
    // If we are running in any field order mode, things get a lot easier
    if (anyOrder) {
      
      // Clear the checked flags for all steps
      for (Step step : keywordMap.values()) step.checked = false;
      
      // Loop through all of the fields
      for (String field : fields) {
        
        // Break field into keyword and value
        int pt = field.indexOf(breakChar);
        if (pt < 0) return false;
        
        // Get the field associated with this keyword
        String tag = field.substring(0, pt).trim();
        if (ignoreCase) tag = tag.toUpperCase();
        String value = field.substring(pt+1).trim();
        Step step = keywordMap.get(tag);
        if (step == null) return false;
        
        // Flag step as processed
        step.checked = true;
        
        // and use it to process this value
        if (step.field != null) {
          try {
            step.field.parse(value, data);
          } catch (FieldProgramException ex) {
            return false;
          }
        }
      }
      
      // Make another pass checking that all required fields have been entered
      for (Step step : keywordMap.values()) {
        if (!step.checked && step.required != EReqStatus.NORMAL) {
          if (step.required == EReqStatus.REQUIRED) return false; 
          data.expectMore = true;
        }
      }
      return true;
    }
    
    State state = new State();
    if (state.link(startLink)) return false;
    do {} while (!state.exec(fields, data));
    return state.getResult();
  }
  
  // When executing, the parser acts as a state engine.  This class preserves the parser
  // state as that engine executes
  private class State {
    private int index = 0;
    private Step step = null ;
    private Step lastStep = null;
    private boolean result = true;
    
    public int getIndex() {
      return index;
    }
    
    public void setIndex(int index) {
      this.index = index;
    }
    
    public Step getLastStep() {
      return lastStep;
    }
    
    public boolean getResult() {
      return result;
    }
    
    public void setResult(boolean result) {
      this.result = result;
    }

    public void setStep(Step step) {
      this.step = step;
    }

    public boolean link(StepLink link) {
      if (link == null) return true;
      index += link.getInc();
      lastStep = step;
      step =  link.getStep();
      return step == null;
    }
    
    public boolean exec(String[] fields, Data data) {
      if (!step.process(this, fields, data)) return false;
      
      // Parse state engine has completed
      // But we still need to check for any unprocessed required fields
      while (result && step != null) {
        if (! step.checkFailure(data)) result = false;
        step = step.getNextStep();
      }
      return true;
    }
  }
  
  
  // This class performs one program step
  private class Step {
    
    private String tag;
    private EReqStatus required;
    private boolean optional;
    
    private Field field;
    private StepLink succLink = new StepLink(1);
    private StepLink failLink= null;
    private Step nextStep = null;
    
    // List of all links pointing to this step
    private List<StepLink> inLinks = new ArrayList<StepLink>();
    
    private boolean checked = false;
    
    /**
     * Constructor
     * @param tag field tag
     * @param field Field processed by this step (can be null)
     * @param required required status
     * @param optional optional flag setting
     */
    public Step(String tag, Field field, EReqStatus required, boolean optional) {
      this.tag = tag;
      this.field = field;
      this.required = required;
      this.optional = (tag != null) && optional;
      
      if (tag != null) parseTags = true;
      
      // Select field is a special case.  It doesn't actually process a field, so the
      // success link increment needs to be backed down to zero
      if (field instanceof SelectField) succLink.setLink(null, -1);
    }

    /**
     * Create a NOOP step that does absolutely nothing.  This is useful
     * as a temporary link point when we compile conditional branches
     */
    public Step() {
      this.field = null;
      this.required = null;
      succLink = new StepLink(0);
    }

    /**
     * @return Link to be taken on step parse succeeds
     */
    public StepLink getSuccLink() {
      return succLink;
    }
    
    /**
     * @return link to be taken when step parse fails
     */
    public StepLink getFailLink() {
      if (failLink == null) failLink = new StepLink(0);
      return failLink;
    }
    
    /**
     * Set the next step
     * @param nextStep new next step value
     */
    public void setNextStep(Step nextStep) {
      this.nextStep = nextStep;
    }
    
    /**
     * @return next step
     */
    public Step getNextStep() {
      return nextStep;
    }
    
    /**
     * @return list of all links pointing to this step
     */
    public List<StepLink> getInLinks() {
      return inLinks;
    }
    
    /**
     * @return true if step can validate its data field (ie can report parse failure)
     */
    public boolean canFail() {
      // tagged steps can always identify themselves
      // untagged steps can identify themselves if their field can
      return tag != null || field != null && field.doCanFail();
    }
    
    /**
     * @return a clone of the current step
     */
    public Step cloneStep() {
      Step newStep = new Step(tag, field, required, optional);
      newStep.nextStep = nextStep;
      return newStep;
    }

    /**
     * Split a branch step into two different steps.  The original step will
     * retain all of the incoming links, the returned step will retain the
     * original outgoing link with the data index increment reduced by one
     * @return
     */
    public Step split() {
      Step step = cloneStep();
      step.succLink.setLink(succLink.getStep(), -1);
      succLink = new StepLink(0);
      return step;
    }

    /**
     * If this is a skip step, remove it from the program tree, redirecting all
     * incoming links to the next link in the chain.  Care should be taken not
     * to remove a skip link that is still in the fieldSteps array and may be
     * processed by something else
     */
    public void removeSkip() {
      
      // Only remove links that do nothing and make no decisions
      if (! isSkipStep() || failLink != null) return;
      if (succLink.getStep() == this) return;
      
      redirect(succLink.getStep(), succLink.getInc());
      
      // Not really necessary, but this will clear the targets incoming links entry to
      // this step, allowing it to be GCed.
      succLink.setLink(null);
      
    }
    
    /**
     * @return true if this is a NOP skip step
     */
    public boolean isSkipStep() {
      if (tag != null) return false;
      if (field == null) return true;
      if (field.pattern != null) return false;
      return field.getClass() == SkipField.class;
    }
    
    /**
     * Redirect all links pointing to this step to some other step
     * possibly adjusting the data field increment
     * @param newStep New step that links should be redirected to
     * @param incAdj Data field increment adjustment
     */
    public void redirect(Step newStep, int incAdj) {
      while (! inLinks.isEmpty()) inLinks.remove(0).setLink(newStep, incAdj);
    }

    /**
     * Execute the program starting with this step.
     * @param flds Array of fields being processed
     * @param ndx current field index
     * @param data Data object being set up
     * @param lastStep most recently executed step
     * @return the next link to be processed, or 
     * SUCCESS to indicate a successful parse, or 
     * FAILURE to indicate a parse failure
     */
    public boolean process(State state, String[] flds, Data data) {

      int ndx = state.getIndex();
      Step lastStep = state.getLastStep();

      // Have we passed the end of the data stream
      if (ndx >= flds.length) {
        
        // Yep, if this is an END step, take the success link
        if (field instanceof EndField) {
          return state.link(succLink);
        }

        // Otherwise, if there is a failure link, execute it
        // Unless it points back to ourselves, which can happen if there was
        // a repeating condition SKIP step
        if (failLink != null && failLink.step != this){
          return state.link(failLink);
        } 
        
        // Otherwise we are finished
        return true;
      }
      
      // Now we have to deal with any tag complications
      // Default is to process this step with this data field
      // Tag processing is suppressed for Select field steps since they really
      // do no field processing
      Step procStep = this;
      String curFld = flds[ndx].trim();
      if (parseTags && !(field instanceof SelectField)) {
        Step startStep = this;
        int startNdx = ndx;
        while (true) {
          
          // See if data field is tagged
          // if it is extract the tag and adjust the current field value
          procStep = startStep;
          String curTag = null;
          String curVal = null;
          int pt = curFld.indexOf(breakChar);
          if (pt >= 0) {
            curTag = curFld.substring(0, pt).trim();
            if (ignoreCase) curTag = curTag.toUpperCase();
            curVal = curFld.substring(pt+1).trim();
          }
          
          // If this is an option tagged step, take failure branch
          // if tags do not match, otherwise process this step
          if (tag != null && failLink != null) {
            if (! tag.equals(curTag)) return state.link(failLink);
            curFld = curVal;
            break;
          }
          
          // Note.  If this is an untagged step with a failure branch, we
          // also want to take the failure branch it a field tag goes somewhere.
          // But we can't do that now because we don't know if this is a real
          // field tag or a spurious colon.
          
          // If data field is tagged, search the program steps for one with
          // a matching tag
          if (curTag != null) {
            boolean skipReq = false;
            procStep = startStep;
            while (procStep != null && !curTag.equals(procStep.tag)) {
              if (procStep.required == EReqStatus.REQUIRED) skipReq = true;;
              procStep = procStep.nextStep;
            }
            
            // Did we find one
            if (procStep != null) {
              
              // If the original step was untagged and had a failure
              // branch, we should take that failure branch now.  We
              // couldn't do this earlier because the field might have
              // had a spurious colon
              if (this.failLink != null) return state.link(this.failLink);
              
              // If we had to skip over a required field, return failure
              if (skipReq) {
                state.setResult(false);
                return true;
              }
              
              // Otherwise we are ready to process this step
              curFld = curVal;
              break;
            }
            
            // If we didn't find one, and this step isn't tagged, assume that
            // this is an incidental colon and process the step normally
            procStep = startStep;
          }
          
          // Data field is not tagged
          // If it is the last field, check to see if it might be a truncated
          // tag for a future step.  If it is, we are finished
          if (ndx == flds.length-1 && curFld.length() > 0) {
            Step tStep = procStep;
            while (tStep != null) {
              if (tStep.tag != null && tStep.tag.startsWith(curFld)) return true;
              tStep = tStep.nextStep;
            }
          }
          
          // if the current start step is also untagged, process it normally
          if (startStep.tag == null) break;
          
          // If the current step is tagged, untagged data fields will usually be 
          // ignored until we come to the tagged step.  An exception is made if
          // the current step tag matches the previous step tag, in which case it
          // is assumed that the untagged data field inherits the tag from a
          // previous data field.
          if (lastStep != null && startStep.tag.equals(lastStep.tag)) break;
          if (++ndx >= flds.length) {
            
            // There is no data field matching this steps tag
            // If the tagged field is not flagged as optional then the assumption
            // is that there is a matching tagged field beyond the end of this
            // this text.  Which means we have reached the end of text processing
            // and need only check if there are any required fields we haven't
            // encountered
            if (!startStep.optional) return true;
            
            // Otherwise, the assumption is that there is no matching
            // tagged field.  So we start the whole process all over again
            // with the next step in the chain
            ndx = startNdx;
            lastStep = startStep;
            startStep = null;
            if (succLink != null) startStep = succLink.getStep();
            
            // If this hits the end of the chain, make sure we didn't skip
            // any required fields
            if (startStep == null) return true;
          }
          curFld = flds[ndx].trim();
          continue;
        }
      }
      state.setIndex(ndx);
      state.setStep(procStep);
      return procStep.process2(state, curFld, flds, data);
    }

    public boolean process2(State state, String curFld, String[] flds, Data data) {
      
      // Get current field and state information
      int ndx = state.getIndex();
      
      // Next we invoke our field object to process the current data field.
      // If there is a fail step, we will ask the field object to check to
      // see if this is a valid data field before parsing it.  if there is
      // not, it will not be given that option
      boolean success = true;
      try {
        if (field != null) {
          field.setFieldList(flds, ndx);
          if (failLink != null) {
            success = field.doCheckParse(curFld, data);
          }
          else {
            field.doParse(curFld, data);
          }
        }
      } catch (FieldProgramException ex) {
        state.setResult(false);
        return true;
      }
      
      // Jump to the next step
      return state.link(success ? succLink : failLink);
    }
    
    /**
     * This is called for a process step beyond the end of the data fields
     * it returns a false status if it is a require process step
     * @return true if this is not a required field step
     */
    public boolean checkFailure(Data data) {

      // If this is a required step, return failure
      if (required == EReqStatus.REQUIRED) {
        return false;
      }
      if (required == EReqStatus.EXPECTED) data.expectMore = true; 
      return true;
    }

    public void checkForSkips() {
      
      // Use the checked flag to ensure we check the same node twice
      
      if (checked) return;
      checked = true;
      
      // If this is a skip node,optimization has failed
      if (isSkipStep()) {
        throw new RuntimeException("Skip node still present in program tree");
      }
      
      // Check both branches
      if (succLink != null && succLink.getStep() != null) succLink.getStep().checkForSkips();
      if (failLink != null && failLink.getStep() != null) failLink.getStep().checkForSkips();
      
    }
    
    @Override
    public String toString() {
      return "" + hashCode() + "  " + getFieldName() + getLinkName("Succ", succLink) + getLinkName("Fail", failLink); 
    }
    
    private String getFieldName() {
      if (field == null) return "-----";
      String name = field.getClass().getName();
      int pt = name.lastIndexOf('$');
      if (pt < 0) pt = name.lastIndexOf('.');
      if (pt >= 0) name = name.substring(pt+1);
      if (name.endsWith("Field")) name = name.substring(0,name.length()-5);
      return name;
    }
    
    private String getLinkName(String title, StepLink link) {
      if (link == null) return "";
      return "  " + title + ": " + link.toString();
    }
  }
  
  /**
   * This class contains the information needed to link a Step to another Step
   */
  private static class StepLink {
    private Step step;
    private int inc;
    
    public StepLink(int inc) {
      this.step = null;
      this.inc = inc;
    }

    public Step getStep() {
      return step;
    }
    
    public int getInc() {
      return inc;
    }
    
    public void setLink(Step step) {
      setLink(step, 0);
    }
    
    public void setLink(Step step, int incAdj) {
      if (this.step != null) this.step.getInLinks().remove(this);
      this.step = step;
      if (step != null) step.getInLinks().add(this);
      this.inc += incAdj;
    }
    
    @Override
    public String toString() {
      return (step == null ? "-----" : step.hashCode()) + "/" + inc;
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
    private boolean hardPattern = false;
    
    private String[] fieldList;
    private int index;
    
    // default constructor
    public Field() {}
    
    public Field(String pattern) {
      setPattern(pattern);
    }
    
    public Field(String pattern, boolean hardPattern) {
      setPattern(pattern, hardPattern);
    }
    
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
    
    public void setPattern(String pattern) {
      setPattern(Pattern.compile(pattern));
    }

    public void setPattern(Pattern pattern) {
      setPattern(pattern, false);
    }
    
    public void setPattern(String pattern, boolean hardPattern) {
      setPattern(Pattern.compile(pattern), hardPattern);
    }
    
    public void setPattern(Pattern pattern, boolean hardPattern) {
      this.pattern = pattern;
      this.hardPattern = hardPattern;
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
      if (pattern != null) return true;
      if (trigger != 0) return true;
      return canFail();
    }
    
    /**
     * @return true if field parser has the ability to confirm whether passed
     * field is valid
     */
    public boolean canFail() {
      return false;
    }
    
    public void setFieldList(String[] fieldList, int index) {
      this.fieldList = fieldList;
      this.index = index;
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
      if (pattern != null) {
        Matcher match = pattern.matcher(field);
        if (!match.matches()) return false;
        if (match.groupCount() == 1) field = match.group(1);
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
      parse(field, data);
      return true;
    }
    
    /**
     * Perform field parsing
     * @param field field to checked and parsed
     * @param data data object to be filled in
     */
    public void doParse(String field, Data data) {
      
      // If a hard pattern is specified, and this doesn't pass it
      // reject this message
      if (pattern != null) {
        Matcher match = pattern.matcher(field);
        if (match.matches()) {
          if (match.groupCount() == 1) field = match.group(1);
        } else if (hardPattern) abort();
      }
      parse(field, data);
    }
    
    /*
     * parse data field
     */
    abstract public void parse(String field, Data data);

    /**
     * Retrieve a data field before or after the current field
     * @param ndx Relative index of desired field.  0 retrieves this field,
     * positive values retrieve following fields, negative values retrieve
     * preceding fields
     * @return value of requested field if it exists, empty string if it does not
     */
    protected String getRelativeField(int ndx) {
      ndx += index;
      if (ndx < 0 || ndx >= fieldList.length) return "";
      return fieldList[ndx];
    }
    
    /**
     * @return true if we are processing the last field
     */
    protected boolean isLastField() {
      return index == fieldList.length - 1;
    }
    
    /**
     * Abort field program processing and return parse failure
     */
    protected void abort() {
      throw new FieldProgramException();
    }
    
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
    
    public CallField() {};
    public CallField(String pattern) {
      super(pattern);
    }
    public CallField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " / ", field);
    }
  }

  /**
   * Place field processor
   */
  public class PlaceField extends Field {
    
    public PlaceField() {};
    public PlaceField(String pattern) {
      super(pattern);
    }
    public PlaceField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strPlace = field;
    }
  }

  /**
   * Address field processor
   */
  private static final Pattern SLOPPY_ADDR_PTN = Pattern.compile("\\d.*|.*[/&].*");
  public class AddressField extends Field {
    
    private boolean incCity = false;
    private boolean sloppy = false;
    
    // Smart address parser info
    private StartType startType = null;
    private String startField = null;
    private int parseFlags = 0;
    private String tailField = null;
    private Field tailData = null;
    private String padField = null;
    private Field padData = null;
    
    public AddressField() {}
    
    public AddressField(String ptn) {
      super(ptn, true);
    }
    
    public AddressField(String ptn, boolean hard) {
      super(ptn, hard);
    }
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public void setQual(String qual) {
      super.setQual(qual);
      if (qual == null) return;
      
      int pt = qual.indexOf('S');
      if (pt >= 0) {
        startType = StartType.START_ADDR;
        parseFlags = FLAG_ANCHOR_END;
        boolean addPlace = false;
        do {
          if (++pt >= qual.length()) break;
          char chr = qual.charAt(pt);
          if (chr == '0') {
            parseFlags |= FLAG_AT_BOTH;
            addPlace = true;
            if (++pt >= qual.length()) break;
          }
          if (chr == '1') {
            parseFlags |= FLAG_AT_PLACE;
            addPlace = true;
            if (++pt >= qual.length()) break;
          }
          if (chr == '2') {
            parseFlags |= FLAG_AT_SIGN_ONLY;
            if (++pt >= qual.length()) break;
          }
          chr = qual.charAt(pt);
          int pt2 = "cPsCpS".indexOf(chr);
          if (pt2 >= 0) {
            if (pt2 >= 3) {
              pt2 -= 3;
              parseFlags |= FLAG_START_FLD_REQ;
            }
            startField = new String[]{"CALL","PLACE",null}[pt2];
            startType = new StartType[]{StartType.START_CALL,StartType.START_PLACE,StartType.START_SKIP}[pt2];
          }
          
          if (++pt >= qual.length()) break;
          chr = qual.charAt(pt);
          pt2 = "CPSaUNIx".indexOf(chr);
          if (pt2 >= 0) {
            parseFlags &= ~FLAG_ANCHOR_END;
            tailField = new String[]{"CALL","PLACE","SKIP","APT","UNIT","NAME","INFO", "X"}[pt2];
            tailData = getField(tailField);
            if (chr == 'I') parseFlags |= FLAG_IGNORE_AT;
          }
          
          if (++pt >= qual.length()) break;
          chr = qual.charAt(pt);
          pt2 = "PS".indexOf(chr);
          if (pt2 >= 0) {
            parseFlags |= FLAG_PAD_FIELD;
            padField = new String[]{"PLACE","SKIP"}[pt2];
            padData = getField(padField);
          }
          
        } while (false);
        if (addPlace) {
          if (tailField == null) tailField = "PLACE";
          else tailField = "PLACE " + tailField;
        }
        qual = qual.substring(0,pt);
      }
      incCity = qual.contains("y");
      sloppy  = qual.contains("s");
      if (qual.contains("i")) {
        if (startType == null) {
          startType = StartType.START_ADDR;
          parseFlags = FLAG_ANCHOR_END;
        }
        parseFlags |= FLAG_IMPLIED_INTERSECT;
      }
      if (qual.contains("a") && startType != null) parseFlags |= FLAG_NO_IMPLIED_APT;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      
      // If we accept sloppy address, then anything staring with a numeric field
      // or that contains a / or an & counts
      if (sloppy && SLOPPY_ADDR_PTN.matcher(field).matches()) {
        parse(field, data);
      }
      
      // If we aren't using the smart parser, just call check address and parse the field
      else if (startType == null) {
        if (checkAddress(field) <= 0) return false;
        parse(field, data);
      }
      
      // If smart parser is being used, invoke it to parse the field, but do not
      // pass the FLAG_ANCHOR_END flag which would invalidate the results.
      // If the address should be anchored at the end, and there is any text left
      // following the address, return false
      else {
        Result res = parseAddress(startType, field);
        if (res.getStatus() <= 0) return false;
        if ((parseFlags & FLAG_ANCHOR_END) != 0 && getLeft().length() > 0) return false;
        
        // Looks good, lets parse out the data
        res.getData(data);
        if (padData != null) padData.parse(res.getPadField(), data);
        if (tailData != null) tailData.parse(res.getLeft(), data);
      }
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (startType == null) {
        if (incCity) {
          parseAddressCity(field, data);
          if (cityCodes != null) data.strCity = convertCodes(data.strCity, cityCodes);
        } else {
          parseAddress(field, data);
        }
      } else {
        parseAddress(startType, parseFlags, field, data);
        if (tailData != null) tailData.parse(getLeft(), data);
      }
    }

    @Override
    public String getFieldNames() {
      StringBuilder sb = new StringBuilder();
      if (startType == null) {
        sb.append("ADDR APT");
        if (incCity) sb.append(" CITY");
      }
      
      else {
        if (startField != null) {
          sb.append(startField);
        }
        sb.append(" ADDR APT ");
        if (padField != null) {
          sb.append(padField);
          sb.append(' ');
        }
        sb.append("CITY ");
        if (tailField != null) sb.append(tailField); 
      }
      return sb.toString().trim();
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
      if (!cities.contains(field.toUpperCase())) return false;
      data.strCity = field;
      return true;
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
  
  private static final Pattern ZIP_PATTERN = Pattern.compile("\\d{5}");
  public class ZipField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (! ZIP_PATTERN.matcher(field).matches()) return false;
      data.strCity = field;
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "CITY";
    }
  }
  
  /**
   * Field containing address and city separated by a comma
   */
  public class AddressCityField extends AddressField {
    
    private Field cityField = new CityField(); 
    
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt < 0) return false;
      parse(field.substring(0,pt).trim(), data);
      cityField.parse(field.substring(pt+1).trim(), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      cityField.parse(p.getLastOptional(','), data);
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  /**
   * Apartment field processor
   */
  public class AptField extends Field {
    
    public AptField() {};
    public AptField(String pattern) {
      super(pattern);
    }
    public AptField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strApt = append(data.strApt, "-", field);
    }
  }

  /**
   * Cross street field processor
   */
  public class CrossField extends Field {
    
    private boolean incCity = false;
    
    public CrossField() {}
    
    public CrossField(String pattern) {
      super(pattern);
    }
    
    public CrossField(String pattern, boolean hard) {
      super(pattern, hard);
    }
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public void setQual(String qual) {
      incCity = qual != null && qual.contains("c");
      super.setQual(qual);
    }
 
    @Override
    public boolean checkParse(String field, Data data) {
      if (checkAddress(field) == 0) return false;
      parse(field, data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (incCity) {
        int pt = field.indexOf('-');
        if (pt >= 0) field = field.substring(0,pt).trim();
      }
      data.strCross = append(data.strCross, " & ", field);
    }
  }

  /**
   * Box field processor
   */
  public class BoxField extends Field {
    
    public BoxField() {};
    public BoxField(String pattern) {
      super(pattern);
    }
    public BoxField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
   
    @Override
    public void parse(String field, Data data) {
      data.strBox = field;
    }
  }

  /**
   * Unit field processor
   */
  public class UnitField extends Field {
    
    public UnitField() {};
    public UnitField(String pattern) {
      super(pattern);
    }
    public UnitField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strUnit = field;
    }
  }

  /**
   * State field processor
   */
  public class StateField extends Field {
    
    public StateField() {
      super("[A-Z]{2}", true);
    };

    @Override
    public void parse(String field, Data data) {
      data.strState = field;
    }
  }

  /**
   * Map field processor
   */
  public class MapField extends Field {
    
    public MapField() {};
    public MapField(String pattern) {
      super(pattern);
    }
    public MapField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strMap = field;
    }
  }

  /**
   * ID field processor
   */
  public class IdField extends Field {
    
    public IdField() {}
    
    public IdField(String pattern) {
      super(pattern);
    }
    
    public IdField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
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
    
    public PhoneField() {
      setPattern(Pattern.compile("\\d{10}|\\d{3}-\\d{3}-\\d{4}"));
    }
    
    public PhoneField(String pattern) {
      super(pattern);
    }
    
    public PhoneField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
    
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
    
    public InfoField() {}
    
    public InfoField(String pattern) {
      super(pattern);
    }
    
    public InfoField(String pattern, boolean hard) {
      super(pattern, hard);
    }
    
    
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
    
    public SourceField() {};
    public SourceField(String pattern) {
      super(pattern);
    }
    public SourceField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strSource = field;
    }
  }

  /**
   * Code field processor
   */
  public class CodeField extends Field {
    
    public CodeField() {};
    public CodeField(String pattern) {
      super(pattern);
    }
    public CodeField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strCode = field;
    }
  }

  /**
   * Name field processor
   */
  public class NameField extends Field {
    
    public NameField() {};
    public NameField(String pattern) {
      super(pattern);
    }
    public NameField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strName = field;
    }
  }

  /**
   * Place/Name field processor
   * Handles a field that could be either a pesonal or public place name
   */
  public class PlaceNameField extends Field {
    
    public PlaceNameField() {};
    public PlaceNameField(String pattern) {
      super(pattern);
    }
    public PlaceNameField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      if (checkPlace(field)) data.strPlace = field;
      else data.strName = field;
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PLACE";
    }
  }

  /**
   * Priority field processor
   */
  public class PriorityField extends Field {
    
    public PriorityField() {};
    public PriorityField(String pattern) {
      super(pattern);
    }
    public PriorityField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strPriority = field;
    }
  }

  /**
   * Channel field processor
   */
  public class ChannelField extends Field {
    
    public ChannelField() {};
    public ChannelField(String pattern) {
      super(pattern);
    }
    public ChannelField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strChannel = field;
    }
  }

  /**
   * GPS field processor
   */
  public class GPSField extends Field {
    
    public GPSField() {};
    public GPSField(String pattern) {
      super(pattern);
    }
    public GPSField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      data.strGPSLoc = field;
    }
  }

  /**
   * Date field processor
   */
  public class DateField extends Field {
    
    private DateFormat fmt = null;
    boolean hardPattern = false;
    
    public DateField() {};
    public DateField(String pattern) {
      super(pattern);
    }
    public DateField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
    public DateField(DateFormat fmt) {
      this.fmt = fmt;
    }
    public DateField(DateFormat fmt, boolean hardPattern) {
      this.fmt = fmt;
      this.hardPattern = hardPattern;
    }
    
    @Override
    public boolean canFail() {
      return hardPattern || super.canFail();
    }

    @Override
    public void parse(String field, Data data) {
      if (fmt != null) {
        if (!checkParse(field, data) && hardPattern) abort();
      } else {
        data.strDate = field;
      }
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (fmt != null) {
        return setDate(fmt, field, data);
      } else {
        parse(field, data);
        return true;
      }
    }
  }

  /**
   * Time field processor
   */
  public class TimeField extends Field {
    
    private DateFormat fmt = null;
    boolean hardPattern = false;
    
    public TimeField() {};
    public TimeField(String pattern) {
      super(pattern);
    }
    public TimeField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
    public TimeField(DateFormat fmt) {
      this.fmt = fmt;
    }
    public TimeField(DateFormat fmt, boolean hardPattern) {
      this.fmt = fmt;
      this.hardPattern = hardPattern;
    }
    
    @Override
    public boolean canFail() {
      return hardPattern || fmt != null || super.canFail();
    }

    @Override
    public void parse(String field, Data data) {
      if (fmt != null) {
        if (!checkParse(field, data) && hardPattern) abort();
      } else {
        data.strTime = field;
      }
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (fmt != null) {
        return setTime(fmt, field, data);
      } else {
        parse(field, data);
        return true;
      }
    }
  }

  /**
   * Date/Time field processor
   */
  public class DateTimeField extends Field {
    
    DateFormat fmt = null;
    boolean hardPattern = false;
    
    public DateTimeField () {};
    public DateTimeField (String pattern) {
      super(pattern);
    }
    public DateTimeField (String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
    
    public DateTimeField(DateFormat fmt) {
      this.fmt = fmt;
    }
    
    public DateTimeField(DateFormat fmt, boolean hardPattern) {
      this.fmt = fmt;
      this.hardPattern = hardPattern;
    }
    
    @Override
    public boolean canFail() {
      return hardPattern || super.canFail();
    }

    @Override
    public void parse(String field, Data data) {
      if (fmt != null) {
        if  (!checkParse(field, data) && hardPattern) abort();
      } else {
        int pt = field.indexOf(' ');
        if (pt >= 0) {
          data.strDate = field.substring(0,pt).trim();
          data.strTime = field.substring(pt+1).trim();
        }
      }
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (fmt != null) {
        return setDateTime(fmt, field, data);
      } else {
        int pt = field.indexOf(' ');
        if (pt < 0) return false;
        data.strDate = field.substring(0,pt).trim();
        data.strTime = field.substring(pt+1).trim();
        return true;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME";
    }
  }

  /**
   * Time/Date field processor
   */
  public class TimeDateField extends Field {
    
    public TimeDateField() {};
    public TimeDateField(String pattern) {
      super(pattern);
    }
    public TimeDateField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strTime = field.substring(0,pt).trim();
      data.strDate = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "TIME DATE";
    }
  }
  
  /**
   * Info URL field
   */
  public class InfoUrlField extends Field {
    public InfoUrlField(){}
    public InfoUrlField(String pattern) {
      super(pattern);
    }
    public InfoUrlField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("http://") && !field.startsWith("https://")) return false;
      parse(field, data);
      return true;
    }
    @Override
    public void parse(String field, Data data) {
      data.strInfoURL = field;
    }
  }
  
  /**
   * Skip field processor
   */
  public class SkipField extends Field {
    
    public SkipField() {};
    public SkipField(String pattern) {
      super(pattern);
    }
    public SkipField(String pattern, boolean hardPattern) {
      super(pattern, hardPattern);
    }

    @Override
    public void parse(String field, Data data) {
    }
  }
  
  /**
   * Initials field processor
   * Field containing dispatcher initials, which is skipped
   * but has ability to verify initials contents
   */
  private static final Pattern INITLS_PAT = Pattern.compile("[A-Za-z]{2,3}");
  public class InitialsField extends Field {
    
    public InitialsField() {
      setPattern(INITLS_PAT);
    }

    @Override
    public void parse(String field, Data data) {
    }
  }
  
  /**
   * Empty field processor
   * Field which must be empty
   */
  public class EmptyField extends SkipField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return field.length() == 0;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  /**
   * End field processor
   * Does no field processing but can be tested.  Succeeds only if it working
   * on a data a field beyond the limits of the field array
   */
  public class EndField extends SkipField {

    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // If called normally, we always fail.  The success condition is
      // detected by Step.process()
      return false;
    }
  }
  
  public class SelectField extends SkipField {
    
    private String code;

    @Override
    public void setQual(String qual) {
      this.code = qual;
    }
    
    @Override
    public String getQual() {
      return code;
    }

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      return code.equals(getSelectValue());
    }
  }
  
  protected String getSelectValue() {
    return "";
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
    if (name.equals("ZIP")) return new ZipField();
    if (name.equals("ADDRCITY")) return new AddressCityField();
    if (name.equals("APT")) return new AptField();
    if (name.equals("X")) return new CrossField();
    if (name.equals("BOX")) return new BoxField();
    if (name.equals("UNIT")) return new UnitField();
    if (name.equals("ST")) return new StateField();
    if (name.equals("MAP")) return new MapField();
    if (name.equals("ID")) return new IdField();
    if (name.equals("PHONE")) return new PhoneField();
    if (name.equals("INFO")) return new InfoField();
    if (name.equals("UNK")) return new InfoField();    // For unknown fields never known to be non-empty
    if (name.equals("SRC")) return new SourceField();
    if (name.equals("CODE")) return new CodeField();
    if (name.equals("NAME")) return new NameField();
    if (name.equals("PLACENAME")) return new PlaceNameField();
    if (name.equals("PRI")) return new PriorityField();
    if (name.equals("CH")) return new ChannelField();
    if (name.equals("GPS")) return new GPSField();
    if (name.equals("DATE")) return new DateField();
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("DATETIME")) return new DateTimeField();
    if (name.equals("TIMEDATE")) return new TimeDateField();
    if (name.equals("URL")) return new InfoUrlField();
    if (name.equals("SKIP")) return new SkipField();
    if (name.equals("INTLS")) return new InitialsField();
    if (name.equals("EMPTY")) return new EmptyField();
    if (name.equals("END")) return new EndField();
    if (name.equals("SELECT")) return new SelectField();
    
    // TODO Add and END field processor that does nothing but can test for
    // the end of the data sequence
    
    throw new RuntimeException("Invalid field name: " + name);
  }
  
  @SuppressWarnings("serial")
  private static class FieldProgramException extends RuntimeException {};
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Start:" + startLink.toString());
    for (Step step = startLink.getStep(); step != null; step = step.nextStep) {
      sb.append('\n');
      sb.append(step.toString());
    }
    return sb.toString();
  }
}
