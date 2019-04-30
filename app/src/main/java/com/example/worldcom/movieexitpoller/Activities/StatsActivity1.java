package com.example.worldcom.movieexitpoller.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.worldcom.movieexitpoller.R;
import com.example.worldcom.movieexitpoller.ViewControl.ResponseAdapter;
import com.example.worldcom.movieexitpoller.ViewControl.ResponseViewModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class StatsActivity1 extends AppCompatActivity {

    private ResponseViewModel mResponseViewModel;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    Intent intentMovies = new Intent(StatsActivity1.this, MainActivity.class);
                    intentMovies.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMovies);
                    return true;
                case R.id.navigation_stats:
                    Intent intentStats = new Intent(StatsActivity1.this, StatsActivity1.class);
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
        setContentView(R.layout.activity_stats1);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentStats = new Intent(StatsActivity1.this, StatsActivity2.class);
                intentStats.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentStats);
            }
        });

        String fillerForbug = "";
        String movie_1 = getString(R.string.movie_1_short);
        String movie_2 = getString(R.string.movie_2_short);
        String movie_3 = getString(R.string.movie_3_short);
        String movie_4 = getString(R.string.movie_4_short);
        String movie_5 = getString(R.string.movie_5_short);

        mResponseViewModel = ViewModelProviders.of(this).get(ResponseViewModel.class);
        final ResponseAdapter mAdapter = new ResponseAdapter(this);

        //Bar Graph 1 population.

        final BarGraphSeries<DataPoint> barGraph_Data1 = new BarGraphSeries<>(new DataPoint[]{});
        barGraph_Data1.resetData(new DataPoint[] {});

        GraphView bar_graph1 = findViewById(R.id.bar_graph1);

        bar_graph1.setTitle("Average Recommended Movies");
        final StaticLabelsFormatter staticLabelsForBarGraphs = new StaticLabelsFormatter(bar_graph1);

        bar_graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        bar_graph1.getGridLabelRenderer().setNumVerticalLabels(4);
        bar_graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);

        // This is for a bug since it will only set the bar at the lowest set value.
        barGraph_Data1.appendData(new DataPoint(barGraph_Data1.getHighestValueX() + 1, 0), false, 6);

        mResponseViewModel.getAnswerAverage1_1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer number) {
                mAdapter.setAverageAnswerForQuestion1_1(number);
                barGraph_Data1.appendData(new DataPoint(barGraph_Data1.getHighestValueX() + 1, number), false, 6);
                Log.i("Loaded Averages", number.toString());

                mResponseViewModel.getAnswerAverage1_2().observe(StatsActivity1.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer number) {
                        mAdapter.setAverageAnswerForQuestion1_2(number);
                        barGraph_Data1.appendData(new DataPoint(barGraph_Data1.getHighestValueX() + 1, number), false, 6);
                        Log.i("Loaded Averages", number.toString());
                    }
                });
                mResponseViewModel.getAnswerAverage1_3().observe(StatsActivity1.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer number) {
                        mAdapter.setAverageAnswerForQuestion1_3(number);
                        barGraph_Data1.appendData(new DataPoint(barGraph_Data1.getHighestValueX() + 1, number), false, 6);
                        Log.i("Loaded Averages", number.toString());
                    }
                });
                mResponseViewModel.getAnswerAverage1_4().observe(StatsActivity1.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer number) {
                        mAdapter.setAverageAnswerForQuestion1_4(number);
                        barGraph_Data1.appendData(new DataPoint(barGraph_Data1.getHighestValueX() + 1, number), false, 6);
                        Log.i("Loaded Averages", number.toString());
                    }
                });
                mResponseViewModel.getAnswerAverage1_5().observe(StatsActivity1.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer number) {
                        mAdapter.setAverageAnswerForQuestion1_5(number);
                        barGraph_Data1.appendData(new DataPoint(barGraph_Data1.getHighestValueX() + 1, number), false, 6);
                        Log.i("Loaded Averages", number.toString());
                    }
                });
            }
        });

        barGraph_Data1.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        staticLabelsForBarGraphs.setHorizontalLabels(new String[] { fillerForbug, movie_1, movie_2, movie_3, movie_4, movie_5 });
        bar_graph1.removeAllSeries();
        bar_graph1.addSeries(barGraph_Data1);
        barGraph_Data1.setSpacing(45);
        barGraph_Data1.setDrawValuesOnTop(true);
        barGraph_Data1.setValuesOnTopColor(Color.BLUE);
    }
}



//        Log.i("Loaded Averages", mAnswerAverage2.toString());
//        Log.i("Loaded Averages", mAnswerAverage3.toString());
//        Log.i("Loaded Averages", mAnswerAverage4.toString());
//        Log.i("Loaded Averages", mAnswerAverage5.toString());


//         barGraph_Data1 = new LineGraphSeries<>(new DataPoint[] {});

//        GraphView bar_graph1 = findViewById(R.id.bar_graph1);
//        // For some reason it messes up the first one you try and format and the rest are fine.
//        // This is so that it messes up the one on the bottom.
//        GraphView bar_graph6 = findViewById(R.id.bar_graph6);
//

//
//        bar_graph1.setTitle("Recommended Movies");
//        bar_graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        bar_graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);
//
//        bar_graph1.addSeries(barGraph_Data1);
////        barGraph_Data1.setValueDependentColor(new ValueDependentColor<DataPoint>() {
////            @Override
////            public int get(DataPoint data) {
////                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
////            }
////        });
////        barGraph_Data1.setSpacing(15);
////        barGraph_Data1.setDrawValuesOnTop(true);
//
//        AsyncTask<Void, Void, Integer> movie1responses1 = getResponse(1, 2, db);
//        AsyncTask<Void, Void, Integer> movie2responses1 = getResponse(2, 2, db);
//        AsyncTask<Void, Void, Integer> movie3responses1 = getResponse(3, 2, db);
//        AsyncTask<Void, Void, Integer> movie4responses1 = getResponse(4, 2, db);
//        AsyncTask<Void, Void, Integer> movie5responses1 = getResponse(5, 2, db);
//
//        Integer average11 = 1;
//        Integer average21 = 2;
//        Integer average31 = 3;
//        Integer average41 = 4;
//        Integer average51 = 5;
//        try {
//            average11 = calculateAverage(movie1responses1.get());
//            average21 = calculateAverage(movie2responses1.get());
//            average31 = calculateAverage(movie3responses1.get());
//            average41 = calculateAverage(movie4responses1.get());
//            average51 = calculateAverage(movie5responses1.get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        GraphView bar_graph2 = findViewById(R.id.bar_graph2);
//        bar_graph2.setTitle("Average Purchase Desire");
//        bar_graph2.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        bar_graph2.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);
//
//        BarGraphSeries<DataPoint> barGraph_Data2 = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, average11),
//                new DataPoint(1, average21),
//                new DataPoint(2, average31),
//                new DataPoint(3, average41),
//                new DataPoint(4, average51)
//        });
//        bar_graph2.addSeries(barGraph_Data2);
//
//        barGraph_Data2.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//            }
//        });
//        barGraph_Data2.setSpacing(15);
//        barGraph_Data2.setDrawValuesOnTop(true);
//        barGraph_Data2.setValuesOnTopColor(Color.BLUE);
//
//        GraphView bar_graph3 = findViewById(R.id.bar_graph3);
//        bar_graph3.setTitle("Movies With the Most Likable Male Lead");
//        bar_graph3.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        bar_graph3.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);
//
//        BarGraphSeries<DataPoint> barGraph_Data3 = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 5),
//                new DataPoint(1, 3),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 2)
//        });
//        bar_graph3.addSeries(barGraph_Data3);
//
//        barGraph_Data3.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//            }
//        });
//        barGraph_Data3.setSpacing(15);
//        barGraph_Data3.setDrawValuesOnTop(true);
//        barGraph_Data3.setValuesOnTopColor(Color.GREEN);
//
//        GraphView bar_graph4 = findViewById(R.id.bar_graph4);
//        bar_graph4.setTitle("Movies With the Most Likable Female Lead");
//        bar_graph4.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        bar_graph4.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);
//
//        BarGraphSeries<DataPoint> barGraph_Data4 = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 5),
//                new DataPoint(1, 3),
//                new DataPoint(2, 2),
//                new DataPoint(3, 2),
//                new DataPoint(4, 3)
//        });
//        bar_graph4.addSeries(barGraph_Data4);
//        bar_graph4.refreshDrawableState();
//
//        barGraph_Data4.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//            }
//        });
//        barGraph_Data4.setSpacing(15);
//        barGraph_Data4.setDrawValuesOnTop(true);
//        barGraph_Data4.setValuesOnTopColor(Color.YELLOW);
//
//        GraphView bar_graph5 = findViewById(R.id.bar_graph5);
//        bar_graph5.setTitle("Movies With the Most Likable Female Lead");
//        bar_graph5.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        bar_graph5.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);
//
//        BarGraphSeries<DataPoint> barGraph_Data5 = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 5),
//                new DataPoint(1, 3),
//                new DataPoint(2, 2),
//                new DataPoint(3, 2),
//                new DataPoint(4, 1)
//        });
//        bar_graph5.addSeries(barGraph_Data5);
//
//        barGraph_Data5.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//            }
//        });
//        barGraph_Data5.setSpacing(15);
//        barGraph_Data5.setDrawValuesOnTop(true);
//        barGraph_Data5.setValuesOnTopColor(Color.YELLOW);
//
//        bar_graph6.setTitle("Movies With the Most Likable Female Lead");
//        bar_graph6.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        bar_graph6.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);
//
//        BarGraphSeries<DataPoint> barGraph_Data6 = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 5),
//                new DataPoint(1, 3),
//                new DataPoint(2, 4),
//                new DataPoint(3, 2),
//                new DataPoint(4, 1)
//        });
//        bar_graph6.addSeries(barGraph_Data6);
//
//        barGraph_Data6.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//            }
//        });
//        barGraph_Data6.setSpacing(15);
//        barGraph_Data6.setDrawValuesOnTop(true);
//        barGraph_Data6.setValuesOnTopColor(Color.YELLOW);
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        // we're going to simulate real time with thread that append data to the graph
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // we add 100 new entries
//                for (int i = 0; i < 100; i++) {
//                    runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            addEntry();
//                        }
//                    });
//
//                    // sleep to slow down the add of entries
//                    try {
//                        Thread.sleep(600);
//                    } catch (InterruptedException e) {
//                        // manage error ...
//                    }
//                }
//            }
//        }).start();
//    }

//    // add random data to graph
//    private void addEntry() {
//        ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(StatsActivity.this);
//
//        AsyncTask<Void, Void, Integer> movie1responses = getResponse(1, 1, db);
//        AsyncTask<Void, Void, Integer> movie2responses = getResponse(2, 1, db);
//        AsyncTask<Void, Void, Integer> movie3responses = getResponse(3, 1, db);
//        AsyncTask<Void, Void, Integer> movie4responses = getResponse(4, 1, db);
//        AsyncTask<Void, Void, Integer> movie5responses = getResponse(5, 1, db);
//
//        Integer average1;
//        Integer average2;
//        Integer average3;
//        Integer average4;
//        Integer average5;
//        try {
//            average1 = calculateAverage(movie1responses.get());
//            average2 = calculateAverage(movie2responses.get());
//            average3 = calculateAverage(movie3responses.get());
//            average4 = calculateAverage(movie4responses.get());
//            average5 = calculateAverage(movie5responses.get());
//
//            Log.i("Movie Average", String.valueOf(average1) + movie1responses.getStatus());
//            Log.i("Movie Average", String.valueOf(average2) + movie2responses.getStatus());
//            Log.i("Movies Average", String.valueOf(average3) + movie3responses.getStatus());
//            Log.i("Movies Average", String.valueOf(average4) + movie4responses.getStatus());
//            Log.i("Movies Average", String.valueOf(average5) + movie4responses.getStatus());
//
//            barGraph_Data1.appendData(new DataPoint(lastX++, average1), true, 5);
//            barGraph_Data1.appendData(new DataPoint(lastX++, average2), true, 5);
//            barGraph_Data1.appendData(new DataPoint(lastX++, average3), true, 5);
//            barGraph_Data1.appendData(new DataPoint(lastX++, average4), true, 5);
//            barGraph_Data1.appendData(new DataPoint(lastX++, average5), true, 5);
//
//
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
