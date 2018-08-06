package com.sadikul.fileobserver;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.FileObserver;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class FileObserverService extends Service
{


    FileObserver mFileObserver = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("obService","started");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("obService","onCreate");
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("obService",path);
        mFileObserver = new FileObserver(path) {
            @Override
            public void onEvent(int event, @Nullable String path) {
                Log.d("obService","event code for observer :"+event);
            }
        };

        mFileObserver.startWatching();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
