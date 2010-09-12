package net.anei.cadpage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import android.content.Context;

public class SmsMessageQueue implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private static String QUEUE_FILENAME = "message.queue";
  
  private LinkedList<SmsMmsMessage> queue = new LinkedList<SmsMmsMessage>();
  private Context context;
  
  public SmsMessageQueue(Context context) {
    this.context = context;
    ObjectInputStream is = null;
    try {
      is = new ObjectInputStream(
        context.openFileInput(QUEUE_FILENAME));
      int count = is.readInt();
      for (int j = 0; j<count; j++) {
        SmsMmsMessage message = SmsMmsMessage.readObject(context, is);
        queue.add(message);
      }
    } catch (FileNotFoundException ex) {
    } catch (Exception ex) {
      Log.e(ex);
    } finally {
      if (is != null) try {is.close();} catch (IOException ex) {}
    }
  }

  /**
   * Save queue to persistent file
   */
  public synchronized void save() {
    ObjectOutputStream os = null;
    try {
      os = new ObjectOutputStream(
        context.openFileOutput(QUEUE_FILENAME, Context.MODE_PRIVATE));
      os.write(queue.size());
      for (SmsMmsMessage msg : queue) {
        os.writeObject(msg);
      }
      os.writeObject(this);
    } catch (IOException ex) {
      Log.e(ex);
    } finally {
      if (os != null) try {os.close();} catch (IOException ex) {}
    }
  }
  
  /**
   * Add new message to queue and delete any old messages down to the
   * requested history queue count
   * @param msg message to be added
   */
  public synchronized void addNewMsg(SmsMmsMessage msg) {
    
    // Add message to beginning of queue
    queue.addFirst(msg);
    
    // Get history limit
    int limit = ManagePreferences.historyCount();
    
    // Do we have to delete anything
    int deleteCnt = queue.size() - limit;
    if (deleteCnt > 0) {
      
      // Count the number of messages that can be deleted
      // (read and not locked)
      int availCnt = 0;
      for (SmsMmsMessage m : queue) {
        if (m.isRead() && !m.isLocked()) availCnt++;
      }
      
      // How many of these need to be kept to get us to the right limit
      int keepCnt = Math.max(0, availCnt - deleteCnt);
      
      // Make another pass through the list deleting anything over the keep limit
      for (Iterator<SmsMmsMessage> itr = queue.iterator(); ; itr.hasNext()) {
        SmsMmsMessage m = itr.next();
        if (m.isRead() && !m.isLocked()) {
          if (keepCnt <= 0) itr.remove();
          else keepCnt--;
        }
      }
    }
  }
  
  /**
   * Remove all expendable (read and not locked) messages
   */
  public void clearAll() {
    
    // Make another pass through the list deleting anything over the keep limit
    for (Iterator<SmsMmsMessage> itr = queue.iterator(); ; itr.hasNext()) {
      SmsMmsMessage m = itr.next();
      if (m.isRead() && !m.isLocked()) itr.remove();
    }
  }

  /**
   * @return the single unread message if there is one and only one.  
   * Null otherwise
   */
  public SmsMmsMessage getDisplayMsg() {
    SmsMmsMessage result = null;
    for (SmsMmsMessage msg : queue) {
      if (! msg.isRead()) {
        if (result != null) return null;
        result = msg;
      }
    }
    return result;
  }
  
  /**
   * @return an unmodifiable collection of the current queue contents
   */
  public Collection<SmsMmsMessage> getMessages() {
    return Collections.unmodifiableCollection(queue);
  }
  
}
