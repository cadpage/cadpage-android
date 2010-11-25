package net.anei.cadpage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

/* Instantiate an AM and store a list files under /assets/bin
in an array. */

public class utils extends SmsPopupActivity {
	
public  void copyFiles() throws IOException {
//AssetManager assetManager = getAssets();

//String[] sourceFiles = assetManager.list("res/raw");
	

String DATAPATH = "/media/audio/notifications";
String src = "/alert.wav";
File sourceFile = new File("res/raw/alert.wav");
File sdDir = new File(Environment.getExternalStorageDirectory().getPath());
File targetFile = new File(sdDir.getAbsolutePath() + DATAPATH + src );
/* If the target file does not exist, create a copy from the
bundled asset. */
	if (!targetFile.exists()) {
		targetFile.createNewFile();
BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile));
BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
int len;
byte[] buf = new byte[1024];
while((len = in.read(buf)) != -1) {
out.write(buf, 0, len);
	}
	if (Log.DEBUG) {Log.v( "Wrote file "+targetFile.toString());}
in.close();
out.close();
	} else {
	if (Log.DEBUG) {Log.v( src+": File already exists. Nothing to be done.");}
	}
}

//catch (IOException io) {
//Log.e( "Error! Install failed.");
//Log.e( io.getMessage());
//} catch (Exception ex) {
//Log.e( "Error! Install failed.");
//Log.e( ex.getMessage());
//}
//}
//})


public boolean saveas(Context ctx,int ressound){
	 byte[] buffer=null;
	 //InputStream fIn = openRawResource(R.raw.alert);
	 InputStream fIn = ctx.getResources().openRawResource(ressound);
	 int size=0;
	 try {
	  size = fIn.available();
	  buffer = new byte[size];
	  fIn.read(buffer);
	  fIn.close();
	 } catch (IOException e) {
	  // TODO Auto-generated catch block
	  return false;
	 }

	 String path="/sdcard/media/audio/notifications/";
	 String filename="generalquarter"+".wav";

	 boolean exists = (new File(path)).exists();
	 if (!exists){new File(path).mkdirs();}

	 FileOutputStream save;
	 try {
	  save = new FileOutputStream(path+filename);
	  save.write(buffer);
	  save.flush();
	  save.close();
	 } catch (FileNotFoundException e) {
	  // TODO Auto-generated catch block
	  return false;
	 } catch (IOException e) {
	  // TODO Auto-generated catch block
	  return false;
	 }    

	 ctx.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file:/"+path+filename)));
	 
	 File k = new File(path, filename);

	 ContentValues values = new ContentValues();
	 values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
	 values.put(MediaStore.MediaColumns.TITLE, "General Quarters");
	 values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/wav");
	 values.put(MediaStore.Audio.Media.ARTIST, "");
	 values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
	 values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
	 values.put(MediaStore.Audio.Media.IS_ALARM, true);
	 values.put(MediaStore.Audio.Media.IS_MUSIC, false);

	 //Insert it into the database
	 ctx.getContentResolver().insert(MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath()), values);

	 return true;
	}
}
