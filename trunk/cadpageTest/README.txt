The java source code for this text project normally resides in the src directory.  But it is not 
archived from there.  Instead it is archived in the rot13-src directory after being run through a 
rot13 substitution.  The Ant build file has two targets
import - copies the encrypted source in rot13-src to regular source in src
export - copies the regular source in src to encrypted source in rot13-src

The intent behind this is provide a modicum of privacy protection for thousands of ordinary people
who initiated 911 calls that just happened to end up in our test suite.  


