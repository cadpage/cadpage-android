package net.anei.cadpage.parsers;

import java.util.ArrayList;
import java.util.List;
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
 */

public class FieldProgramParser extends SmartAddressParser {
  
  // list of cities
  private String[] cities = null;
  
  // table converting city codes to city names
  private Properties cityCodes = null;
  
  // Original program string
  private String programStr;
  
  private StepLink startLink;
  
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
  protected void setProgram(String program) {
    
    if (program == null) return;
    
    this.programStr = program;
    
    // Construct a head link and tail node and compile the tokens between them
    this.startLink = new StepLink(0);
    Step tail = new Step(null, false);
    compile(this.startLink, program, tail, null);
    
    // Now that we no longer need it, reduce the tail node
    tail.removeSkip();
  }
  
  /**
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
      FieldTermInfo info = new FieldTermInfo(fieldTerms[ndx]);
      infoList[ndx] = info;
      Field field = null;
      if (!info.branch){ 
        field = getField(info.name);
        field.setQual(info.qual);
        field.setTrigger(info.trigger);
      }
      fieldSteps[ndx] = new Step(field, info.required);
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
      
      // Check term info for things that would disrupt the natural order of
      // things
      FieldTermInfo info = infoList[ndx];
      
      // Of which the most disruptive by far is an untestable optional field
      // somewhere behind us.
      if (optBreak >= 0) {
        
        // We are looking for a normal testable field that can resolve the condition
        // status of the untestable one.  If we find repeat or optional step
        // before that, all is lost
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
        if (info.optional) {
          
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
      else if (info.optional) {
        
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
        String term = fieldTerms[ndx];
        term = term.substring(1, term.length()-1);
        String[] branchTerms = term.split("\\|");
        
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
  private static String[] tokenize(String programStr) {
    
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
   * Check for any skip nodes that missed our optimization process
   * only called by the test suite
   */
  void checkForSkips() {
    startLink.getStep().checkForSkips();
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
    boolean branch = false;
    char trigger = 0;
    
    FieldTermInfo(String fieldTerm) {
      
      // If this is a conditional branch, just set the branch flag and return
      // The branch will be expanded later
      if (fieldTerm.startsWith("(")) {
        branch = true;
        return;
      }
      
      int len = fieldTerm.length();
      int pt = 0;
      
      // parse field name
      if (! Character.isUpperCase(fieldTerm.charAt(pt++))) {
        throw new RuntimeException("Invalid field term: " + fieldTerm);
      }
      while (pt < len && Character.isJavaIdentifierPart(fieldTerm.charAt(pt))) pt++;
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
      
      else {
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
    return startLink.exec(fields, 0, data);
  }
  
  
  // This class performs one program step
  private class Step {
    
    private boolean required;
    
    private Field field;
    private StepLink succLink = new StepLink(1);
    private StepLink failLink= null;
    
    // List of all links pointing to this step
    private List<StepLink> inLinks = new ArrayList<StepLink>();
    
    private boolean checked = false;
    
    /**
     * Constructor
     * @param field Field processed by this step (can be null)
     * @param required true if this is a required step
     */
    public Step(Field field, boolean required) {
      this.field = field;
      this.required = required;
    }

    /**
     * Create a NOOP step that does absolutely nothing.  This is useful
     * as a temporary link point when we compile conditional branches
     */
    public Step() {
      this.field = null;
      this.required = false;
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
     * @return list of all links pointing to this step
     */
    public List<StepLink> getInLinks() {
      return inLinks;
    }
    
    /**
     * @return true if step can validate its data field (ie can report parse failure)
     */
    public boolean canFail() {
      return field != null && field.doCanFail();
    }
    
    /**
     * @return a clone of the current step
     */
    public Step cloneStep() {
      return new Step(field, required);
    }

    /**
     * Split a branch step into two different steps.  The original stepp will
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
      
      redirect(succLink.getStep(), succLink.getInc());
      
      // Not really necessary, but this will clear the targets incoming links entry to
      // this step, allowing it to be GCed.
      succLink.setLink(null);
      
    }
    
    /**
     * @return true if this is a NOP skip step
     */
    public boolean isSkipStep() {
      return field == null || field.getClass() == SkipField.class;
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
     * Execute the program starting with this step.  The method will
     * recursively call itself for subsequent steps until the entire
     * program has been processed.
     * @param flds Array of fields being processed
     * @param ndx current field index
     * @param data Data object being set up
     * @return true if successful, false otherwise
     */
    public boolean process(String[] flds, int ndx, Data data) {
      
      // Have we passed the end of the data stream
      if (ndx >= flds.length) {

        // Yep, if there is a failre link, execute it
        if (failLink != null){
          return failLink.exec(flds, ndx, data);
        } 
        
        // Otherwise check to make sure there are no required fields in
        // the remaining program steps
        else {
          return checkFailure();
        }
      }
      
      // Next we invoke our field object to process the current data field.
      // If there is a fail step, we will ask the field object to check to
      // see if this is a valid data field before parsing it.  if there is
      // not, it will not be given that option
      boolean success = true;
      if (field != null) {
        if (failLink != null) {
          success = field.doCheckParse(flds[ndx], data);
        }
        else {
          field.parse(flds[ndx], data);
        }
      }
      
      // Jump to the next step
      StepLink link = (success ? succLink : failLink);
      
      // if the next step link is null, the program has completed and we can
      // return a successful result.  Otherwise call ourselves to process
      // the next step on the program.
      if (link == null) return true;
      return link.exec(flds, ndx, data);
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
      if (succLink == null) return true;

      // One special case, if the success step loops back to itself
      // follow the fail step instead of the next step
      StepLink link = succLink;
      if (link.getStep() == this) link = failLink;
      if (link == null || link.getStep() == null) return true;
      
      // Still undetermined, return the failure status of the next step
      return link.getStep().checkFailure();
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
    
    public boolean exec(String[] flds, int ndx, Data data) {
      if (step == null) return true;
      return step.process(flds, ndx+inc, data);
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
