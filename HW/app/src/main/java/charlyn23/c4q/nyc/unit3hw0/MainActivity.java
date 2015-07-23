package charlyn23.c4q.nyc.unit3hw0;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataGetter dataGetter =  new DataGetter();

        TextView hint = (TextView)findViewById(R.id.hint);
        hint.bringToFront();


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

}

