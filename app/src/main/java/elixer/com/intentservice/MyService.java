package elixer.com.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String message = intent.getStringExtra("message");
        intent.setAction(MainActivity.FILTER_ACTION_KEY);
        //This wait can be for downloading, sending a request, decoding a file etc.
        SystemClock.sleep(5000);

        String resultMessage = "The Result String  after 6 seconds of processing.." + message;
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent.putExtra("broadcastMessage", resultMessage));
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(getApplicationContext(), "Intent SERVICE CREATED", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Intent SERVICE DESTROYED", Toast.LENGTH_SHORT).show();
    }


}