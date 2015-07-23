package charlyn23.c4q.nyc.unit3hw0;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataGetter dataGetter =  new DataGetter();

        Button notificationButton = (Button)findViewById(R.id.notificationButton);
        TextView hint = (TextView)findViewById(R.id.hint);
        hint.bringToFront();

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify("Notification Alert", "You've received new message");
            }
        });




        final int bx2000 = dataGetter.getBX2000Pop();
        int bx2010 = dataGetter.getBX2010Pop();
        int bk2000 = dataGetter.getBK2000Pop();
        int bk2010 = dataGetter.getBK2010Pop();
        int man2000 = dataGetter.getManhattan2000Pop();
        int man2010 = dataGetter.getManhattan2010Pop();
        int qns2000 = dataGetter.getQueens2000Pop();
        int qns2010 = dataGetter.getQueens2010Pop();
        int si2000 = dataGetter.getSI2000Pop();
        int si2010 = dataGetter.getSI2010Pop();

        final int total2000 = bx2000 + bk2000 + man2000 + qns2000 + si2000;





        final PieChart pieChart2000 = (PieChart) findViewById(R.id.piechart2000);
        pieChart2000.addPieSlice(new PieModel("Bronx", 1332650, Color.parseColor("#FE6DA8")));
        pieChart2000.addPieSlice(new PieModel("Brooklyn", 2465326, Color.parseColor("#56B7F1")));
        pieChart2000.addPieSlice(new PieModel("Manhattan", 1537195, Color.parseColor("#FED70E")));
        pieChart2000.addPieSlice(new PieModel("Queens", 2229379, Color.parseColor("#996ADE")));
        pieChart2000.addPieSlice(new PieModel("Staten Island", 443728, Color.parseColor("#CDA67F")));


        final PieChart pieChart2010 = (PieChart) findViewById(R.id.piechart2010);
        pieChart2010.addPieSlice((new PieModel("Bronx", 1385108, Color.parseColor("#FE6DA8"))));
        pieChart2010.addPieSlice(new PieModel("Brooklyn", 2504700, Color.parseColor("#56B7F1")));
        pieChart2010.addPieSlice(new PieModel("Manhattan", 1585873, Color.parseColor("#FED70E")));
        pieChart2010.addPieSlice(new PieModel("Queens", 2230722, Color.parseColor("#996ADE")));
        pieChart2010.addPieSlice(new PieModel("Staten Island", 468730, Color.parseColor("#CDA67F")));


        pieChart2000.startAnimation();
        pieChart2010.startAnimation();

        //Notification
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.android_icon);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");

        Intent resultIntent = new Intent(this, NotificationView.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationView.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void Notify(String notificationTitle, String notificationMessage){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        @SuppressWarnings("deprecation")

        Notification notification = new Notification(R.drawable.android_icon,"New Message", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this,NotificationView.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        notification.setLatestEventInfo(MainActivity.this, notificationTitle,notificationMessage, pendingIntent);
        notificationManager.notify(9999, notification);
    }

}

