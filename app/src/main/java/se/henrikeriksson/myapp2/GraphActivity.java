package se.henrikeriksson.myapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cz.msebera.android.httpclient.Header;


public class GraphActivity extends AppCompatActivity {
    GraphView graph;
    Context c = getApplicationContext();
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_graph, menu);
        return true;
    }


    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_graph);

        graph = (GraphView) findViewById(R.id.graph);
        graph.setTitle("Temperaturstatistik kl 12");
        graph.setTitleTextSize(40);
        graph.getGridLabelRenderer().setVerticalAxisTitle("°C");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Datum");

        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));



         HttpUtils.get("subdomain/weather/graphtemp.json", new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("JsonLoader", "---------------- this is response:" + response);
                try {
                    JSONObject serverResp = new JSONObject(response.toString());
                    JSONArray arr = serverResp.getJSONArray("graph");
                    DataPoint[] dataPoints = new DataPoint[arr.length()];
                    for (int i = 0; i < arr.length(); i++) {
                        String date = arr.getJSONArray(i).getString(0);
                        String temp1 = arr.getJSONArray(i).getString(1);

                        try {
<<<<<<< HEAD
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
=======
                            SimpleDateFormat sdf = (SimpleDateFormat)SimpleDateFormat.getDateInstance(SimpleDateFormat.DAY_OF_WEEK_IN_MONTH_FIELD);
>>>>>>> 2b718e83e242e042b78b1731a8f05c6b60a92bb6
                            Date parse = sdf.parse(date);
                            Calendar c = Calendar.getInstance();
                            c.setTime(parse);
                            dataPoints[i] = new DataPoint(c.getTimeInMillis(), Double.parseDouble(temp1));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(c));
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
                    graph.addSeries(series);
                } catch (JSONException json) {
                    json.printStackTrace();
                }
            }
        });
    }
}
