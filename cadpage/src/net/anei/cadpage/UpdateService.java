package net.anei.cadpage;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class UpdateService extends Service {
    public static final String UPDATE= "update";
    public static final String CADPAGE_REFRESH = "update";
    
    @Override
    public void onStart(Intent intent, int startId){
      
    }
    @Override
    public IBinder onBind(Intent arg0) {
            return null;
    }
}
