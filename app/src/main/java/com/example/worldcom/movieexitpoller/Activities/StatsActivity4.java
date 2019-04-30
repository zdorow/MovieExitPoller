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

public class StatsActivity4 extends AppCompatActivity {

    private ResponseViewModel mResponseViewModel;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    Intent intentMovies = new Intent(StatsActivity4.this, MainActivity.class);
                    intentMovies.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMovies);
                    return true;
                case R.id.navigation_stats:
                    Intent intentStats = new Intent(StatsActivity4.this, StatsActivity1.class);
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
        setContentView(R.layout.activity_stats4);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentStats = new Intent(StatsActivity4.this, StatsActivity5.class);
                intentStats.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentStats);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentStats = new Intent(StatsActivity4.this, StatsActivity3.class);
                intentStats.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentStats);
            }
        });

        String fillerForBug = "";
        String movie_1 = getString(R.string.movie_1_short);
        String movie_2 = getString(R.string.movie_2_short);
        String movie_3 = getString(R.string.movie_3_short);
        String movie_4 = getString(R.string.movie_4_short);
        String movie_5 = getString(R.string.movie_5_short);

        mResponseViewModel = ViewModelProviders.of(this).get(ResponseViewModel.class);
        final ResponseAdapter mAdapter = new ResponseAdapter(this);

        //Bar Graph 4 population.

        final BarGraphSeries<DataPoint> barGraph_Data4 = new BarGraphSeries<>(new DataPoint[]{});
        barGraph_Data4.resetData(new DataPoint[] {});

        GraphView bar_graph4 = findViewById(R.id.bar_graph4);

        bar_graph4.setTitle("Average Recommended Female Lead");
        final StaticLabelsFormatter staticLabelsForBarGraphs = new StaticLabelsFormatter(bar_graph4);

        bar_graph4.getGridLabelRenderer().setVerticalLabelsVisible(false);
        bar_graph4.getGridLabelRenderer().setNumVerticalLabels(4);
        bar_graph4.getGridLabelRenderer().setLabelFormatter(staticLabelsForBarGraphs);

        // This is for a bug since it will only set the bar at the lowest set value.
        barGraph_Data4.appendData(new DataPoint(0, 0), false, 6);

        mResponseViewModel.getAnswerAverage4_1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer number) {
                mAdapter.setAverageAnswerForQuestion4_1(number);
                barGraph_Data4.appendData(new DataPoint(1, number), false, 6);
                Log.i("Loaded Averages", number.toString());

                mResponseViewModel.getAnswerAverage4_2().observe(StatsActivity4.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer number) {
                        mAdapter.setAverageAnswerForQuestion4_2(number);
                        barGraph_Data4.appendData(new DataPoint(2, number), false, 6);
                        Log.i("Loaded Averages", number.toString());

                        mResponseViewModel.getAnswerAverage4_3().observe(StatsActivity4.this, new Observer<Integer>() {
                            @Override
                            public void onChanged(@Nullable Integer number) {
                                mAdapter.setAverageAnswerForQuestion4_3(number);
                                barGraph_Data4.appendData(new DataPoint(3, number), false, 6);
                                Log.i("Loaded Averages", number.toString());

                                mResponseViewModel.getAnswerAverage4_4().observe(StatsActivity4.this, new Observer<Integer>() {
                                    @Override
                                    public void onChanged(@Nullable Integer number) {
                                        mAdapter.setAverageAnswerForQuestion4_4(number);
                                        barGraph_Data4.appendData(new DataPoint(4, number), false, 6);
                                        Log.i("Loaded Averages", number.toString());

                                        mResponseViewModel.getAnswerAverage4_5().observe(StatsActivity4.this, new Observer<Integer>() {
                                            @Override
                                            public void onChanged(@Nullable Integer number) {
                                                mAdapter.setAverageAnswerForQuestion4_5(number);
                                                barGraph_Data4.appendData(new DataPoint(5, number), false, 6);
                                                Log.i("Loaded Averages", number.toString());
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        barGraph_Data4.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        staticLabelsForBarGraphs.setHorizontalLabels(new String[] { fillerForBug, movie_1, movie_2, movie_3, movie_4, movie_5 });
        bar_graph4.removeAllSeries();
        bar_graph4.addSeries(barGraph_Data4);
        barGraph_Data4.setSpacing(45);
        barGraph_Data4.setDrawValuesOnTop(true);
        barGraph_Data4.setValuesOnTopColor(Color.BLUE);
    }
}