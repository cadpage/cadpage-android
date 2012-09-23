package net.anei.cadpage.ant;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * Ant support task that performs a rot13 substitution on all files in source directory tree
 * and places the results in a target directory tree
 */
public class Rot13 extends Task {

  private String src = null;
  private String target = null;
  
  private int convertedFileCount = 0;
  
  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }
  

  @Override
  public void init() throws BuildException {
    super.init();
  }

  @Override
  public void execute() throws BuildException {
    if (src == null || src.length() == 0) {
      throw new BuildException("src attribute required for rot13 task");
    }
    if (target == null || target.length() == 0) {
      throw new BuildException("target attribute required for rot13 task");
    }
    log("Converting " + src + " to " + target , Project.MSG_INFO);
    
    try {
      // get a list of all of the files in the src directory
      File[] srcList = getFileList(src);
      
      // Loop through all of them
      convertedFileCount = 0;
      for (File srcFile : srcList) {
        
        // For each one compute the corresponding target file
        String name = srcFile.getName();
        if (!name.startsWith(src)) {
          throw new RuntimeException("Source filename " + name + " does not start with " + src);
        }
        File tgtFile = new File(target + name.substring(src.length()));
        
        // And do the Rot14 conversion on it
        convert(srcFile, tgtFile);
      }
      log(convertedFileCount + " files converted", Project.MSG_INFO);
    } 
    
    catch (IOException ex) {
      throw new BuildException(ex);
    }
  }

  /**
   * Get a list of all regular files located in a particular src file designation
   * @param src source file
   * @return list of the normal files in this directory tree
   */
  private File[] getFileList(String src) throws BuildException, IOException {
    List<File> fileList = new ArrayList<File>();
    File file = new File(src);
    getFileList(file, fileList);
    return fileList.toArray(new File[fileList.size()]);
  }

  private void getFileList(File file, List<File> fileList) throws BuildException, IOException {
    if (!file.exists()) throw new BuildException(file.getAbsolutePath() + " not found");
    if (file.isHidden()) return;
    if (file.isFile()) {
      fileList.add(file);
    } else if (file.isDirectory()) {
      File[] files = file.listFiles();
      Arrays.sort(files);
      for (File file2 : files) getFileList(file2, fileList);
    }
  }

  /**
   * Perform the rot13 conversion from a source file to a target file
   * @param srcFile source file
   * @param tgtFile target file
   */
  private void convert(File srcFile, File tgtFile) throws IOException {
    
    // Source file had better be a normal file
    if (!srcFile.exists() || !srcFile.isFile()) {
      throw new RuntimeException(srcFile.getName() + " does not exist or is not a file");
    }
    long srcTime = srcFile.lastModified();
    
    // If target file exists and is as recent as the source file, we don't have to do anything
    if (tgtFile.exists() && tgtFile.lastModified() >= srcTime) return;
    
    // Otherwise, report what we are doing
    log("Converting " + srcFile.getName() + " to " + tgtFile.getName(), Project.MSG_VERBOSE);
    convertedFileCount++;
    
    // Make sure we have a directory to build the target file in
    tgtFile.getParentFile().mkdirs();
    
    // Open both files and copy the rot13 encrypted contents from source to target file
    BufferedInputStream is = null;
    BufferedOutputStream os = null;
    try {
      is = new BufferedInputStream(new FileInputStream(srcFile));
      os = new BufferedOutputStream(new FileOutputStream(tgtFile));
      while (true) {
        int chr = is.read();
        if (chr < 0) break;
        chr = convertChar(chr, 'A', 'Z');
        chr = convertChar(chr, 'a', 'z');
        os.write(chr);
      }
    }
    finally {
      try {is.close();} catch (IOException ex) {}
      try {os.close();} catch (IOException ex) {}
    }
    
    // Finally, force the target last modified time to the source last modified time
    // so we can invoke this operation in the other direction as needed
    tgtFile.setLastModified(srcTime);
  }
  
  private int convertChar(int chr, int lowLimit, int highLimit) {
    if (chr >= lowLimit && chr <= highLimit) {
      int range = highLimit-lowLimit+1;
      chr += range/2;
      if (chr > highLimit) chr -= range;
    }
    return chr;
  }
}
