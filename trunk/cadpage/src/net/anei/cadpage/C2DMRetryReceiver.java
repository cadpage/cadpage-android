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

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Receives C2DM Retry request
 * Had to make our own receiver because the main C2DM recever 
 * requires permissions that we don't have access to
 */
public class C2DMRetryReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    Log.v("C2DMRetryReceiver: onReceive()");
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) return;

    // Everything else gets handed off to the service intent
    C2DMService.runIntentInService(context, intent);
    
    setResultCode(Activity.RESULT_OK);
  }
}

