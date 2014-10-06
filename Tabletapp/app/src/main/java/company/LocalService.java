package company;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import exceptions.SBSBaseException;
import imports.User;
import scon.RemoteExperiment;
import scon.RemoteProject;
import scon.ServerDatabaseSession;


/**
 * Created by Grit on 04.06.2014.
 */
public class LocalService extends Service {
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
    ServerDatabaseSession SDS ;

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */




    // connection method for Service and Server
    public void connect (String url, User user) throws MalformedURLException {
     SDS = new ServerDatabaseSession(new URL(url), user.getUser_email(), user.getPw_hash());
        Log.d("work","connection established");
    }

    public LinkedList getProjects() throws SBSBaseException {
       LinkedList<RemoteProject> remoteProject_list = SDS.get_projects();
        return remoteProject_list;
    }

    public LinkedList getExperiments() throws SBSBaseException {
        LinkedList<RemoteExperiment> remoteExperiments_list = SDS.get_experiments();
        return remoteExperiments_list;
    }




    public class LocalBinder extends Binder {
        LocalService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** method for clients */





    /** method for clients */




    /*
    private NotificationManager mNM;

    // Unique Identification Number for the Notification.
    // We use it on Notification start, and to cancel it.

    private int NOTIFICATION = R.string.local_service_started;

    /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
  /*  public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }

    @Override
    public void onCreate() {
        mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        // Display a notification about us starting.  We put an icon in the status bar.
        showNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // Cancel the persistent notification.
        mNM.cancel(NOTIFICATION);

        // Tell the user we stopped.
        Toast.makeText(this, R.string.local_service_stopped, Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // This is the object that receives interactions from clients.  See
    // RemoteService for a more complete example.
    private final IBinder mBinder = new LocalBinder();

    /**
     * Show a notification while this service is running.

    private void showNotification() {
        // In this sample, we'll use the same text for the ticker and the expanded notification
      CharSequence text = getText(R.string.local_service_started);

        // Set the icon, scrolling text and timestamp
        Notification notification = new Notification(R.drawable.uni_siegen, text,
             System.currentTimeMillis());

        // The PendingIntent to launch our activity if the user selects this notification


        // Set the info for the views that show in the notification panel.


        // Send the notification.
       mNM.notify(NOTIFICATION, notification);
    }

    */
}