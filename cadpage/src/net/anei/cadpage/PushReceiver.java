/*
 * Copyright (C) 2007-2008 Esmertec AG.
 * Copyright (C) 2007-2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.anei.cadpage;



import net.anei.cadpage.mms.GenericPdu;
import net.anei.cadpage.mms.PduParser;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.PowerManager;

/**
 * Receives Intent.WAP_PUSH_RECEIVED_ACTION intents and starts the
 * TransactionService by passing the push-data to it.
 */
public class PushReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("SMSReceiver: onReceive()");
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) return;

    // Hold a wake lock for 5 seconds, enough to give any
    // services we start time to take their own wake locks.
    PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
    PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MMS PushReceiver");
    wl.acquire(5000);
    new ReceivePushTask(context).execute(intent);
  }

  private class ReceivePushTask extends AsyncTask<Intent,Void,Void> {
    
    private Context context;
    
    public ReceivePushTask(Context context) {
      this.context = context;
    }

    @Override
    protected Void doInBackground(Intent... intents) {
      Intent intent = intents[0];

      // Get raw PDU push-data from the message and parse it
      byte[] pushData = intent.getByteArrayExtra("data");

      GenericPdu pdu = new PduParser(pushData).parse();
      if (null == pdu) {
        Log.e("Invalid PUSH data");
        return null;
      }
      
      SmsMmsMessage message = pdu.getMessage();
      if (message == null) return null;

      // See if message passes override from filter
      boolean overrideFilter = ManagePreferences.overrideFilter();
      String sFilter = (overrideFilter ? ManagePreferences.filter() : "");
      if (overrideFilter) {
        String sAddress = message.getAddress();
        if (! SmsPopupUtils.matchFilter(sAddress, sFilter)) return null;
      }
      
      // Save message for future test or error reporting use
      // If message is rejected as duplicate, and we aren't supposed to display
      // these in the standard messaging app, remove it from the messaging app content
      if (SmsMsgLogBuffer.getInstance().checkDuplicateNotice(message)) return null;
      SmsMsgLogBuffer.getInstance().add(message);
    
      return null;
    }
  }
}
