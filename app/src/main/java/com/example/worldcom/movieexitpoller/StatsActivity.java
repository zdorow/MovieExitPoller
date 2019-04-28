package com.example.worldcom.movieexitpoller;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class StatsActivity extends AppCompatActivity {
    //protected ResponseViewModel response;
    ResponseRepository db;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    Intent intentMovies = new Intent(StatsActivity.this, MainActivity.class);
                    intentMovies.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMovies);
                    return true;
                case R.id.navigation_stats:
                    Intent intentStats = new Intent(StatsActivity.this, StatsActivity.class);
                    intentStats.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentStats);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GraphView line_graph1 = findViewById(R.id.line_graph1);
        line_graph1.setTitle("Number of Surveys Submitted Per Month");
        StaticLabelsFormatter staticLabelsForLineGraphs = new StaticLabelsFormatter(line_graph1);
        staticLabelsForLineGraphs.setHorizontalLabels(new String[] {"January", "February", "March", "April", "May"});
        line_graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsForLineGraphs);

        //response = ViewModelProviders.of(this).get(ResponseViewModel.class);
        //List<Integer> question1 = getResponse(0, 0, context).getValue();
        //try {
            //List<Integer> ALLLLLL = (List<Integer>) response.getAllResponses();
            //MutableLiveData<List<Response>> ALLLLLL = response.getAllResponses();
            //MutableLiveData<List<Integer>> question1 = getResponse(1, 3, StatsActivity.this).get();

            //Integer movie1Value = calculateAverage(question1);
            //Log.i("Movie", ALLLLLL.toString());

//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }
        //List<Integer> question1 = getResponse(2, 0, context).getValue();

         //Create the observer which updates the UI.
        final Observer<List<Response>> responseObserver = new Observer<List<Response>>() {
            @Override
            public void onChanged(@Nullable List<Response> responses) {
                // Update the UI, in this case
                Log.i("Movies", responses.toString());
            }

        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        db.getAllResponses().observe(this, responseObserver);


        LineGraphSeries<DataPoint> lineSeries1 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 3),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        line_graph1.addSeries(lineSeries1);

        GraphView line_graph2 = findViewById(R.id.line_graph2);
        line_graph2.setTitle("Average Top Score by Month");
        line_graph2.getGridLabelRenderer().setLabelFormatter(staticLabelsForLineGraphs);

        LineGraphSeries<DataPoint> lineSeries2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 4),
                new DataPoint(1, 2),
                new DataPoint(2, 9),
                new DataPoint(3, 6),
                new DataPoint(4, 2)
        });
        line_graph2.addSeries(lineSeries2);

        String movie_1 = getString(R.string.movie_1_short);
        String movie_2 = getString(R.string.movie_2_short);
        String movie_3 = getString(R.string.movie_3_short);
        String movie_4 = getString(R.string.movie_4_short);
        String movie_5 = getString(R.string.movie_5_short);

        GraphView bar_graph1 = findViewById(R.id.bar_graph1);
        bar_graph1.setTitle("Recommended Movies");
        StaticLabelsFormatter staticLabelsForBarGraphs = new StaticLabelsFormatter(bar_graph1);
        staticLabelsForBarGraphs.setHorizontalLabels(new String[] { movie_1, movie_2, movie_3, movie_4, movie_5 });

        bar_graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);

        BarGraphSeries<DataPoint> barGraph_Data1 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        bar_graph1.addSeries(barGraph_Data1);

        barGraph_Data1.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        barGraph_Data1.setSpacing(15);
        barGraph_Data1.setDrawValuesOnTop(true);
        barGraph_Data1.setValuesOnTopColor(Color.RED);

        GraphView bar_graph2 = findViewById(R.id.bar_graph2);
        bar_graph2.setTitle("Average Purchase Desire");
        bar_graph2.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);

        BarGraphSeries<DataPoint> barGraph_Data2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(1, 3),
                new DataPoint(2, 9),
                new DataPoint(3, 2),
                new DataPoint(4, 7)
        });
        bar_graph2.addSeries(barGraph_Data2);

        barGraph_Data2.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        barGraph_Data2.setSpacing(15);
        barGraph_Data2.setDrawValuesOnTop(true);
        barGraph_Data2.setValuesOnTopColor(Color.BLUE);

        GraphView bar_graph3 = findViewById(R.id.bar_graph3);
        bar_graph3.setTitle("Movies With the Most Likable Male Lead");
        bar_graph3.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);

        BarGraphSeries<DataPoint> barGraph_Data3 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(1, 3),
                new DataPoint(2, 9),
                new DataPoint(3, 2),
                new DataPoint(4, 7)
        });
        bar_graph3.addSeries(barGraph_Data2);

        barGraph_Data3.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        barGraph_Data3.setSpacing(15);
        barGraph_Data3.setDrawValuesOnTop(true);
        barGraph_Data3.setValuesOnTopColor(Color.GREEN);

        GraphView bar_graph4 = findViewById(R.id.bar_graph4);
        bar_graph4.setTitle("Movies With the Most Likable Female Lead");
        bar_graph4.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);

        BarGraphSeries<DataPoint> barGraph_Data4 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(1, 3),
                new DataPoint(2, 9),
                new DataPoint(3, 2),
                new DataPoint(4, 7)
        });
        bar_graph4.addSeries(barGraph_Data2);

        barGraph_Data4.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        barGraph_Data4.setSpacing(15);
        barGraph_Data4.setDrawValuesOnTop(true);
        barGraph_Data4.setValuesOnTopColor(Color.YELLOW);
    }

    public static AsyncTask<Void, Void, LiveData<List<Integer>>> getResponse(final Integer movieId,
                                                                   final Integer questionId,
                                                                   final Context context) {
        return new AsyncTask<Void, Void, LiveData<List<Integer>>>() {
    @Override
    protected LiveData<List<Integer>> doInBackground(Void... voids) {
        final ResponseDao responseDao = ResponseRoomDatabase.getDatabase(context).responseDao();
        return responseDao.getAnswers(movieId, questionId);
    }
}.execute();
    }

    private Integer calculateAverage(List<Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum / marks.size();
        }
        return sum;
    }
}
