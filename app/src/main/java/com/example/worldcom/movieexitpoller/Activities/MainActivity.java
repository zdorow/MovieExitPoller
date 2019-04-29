package com.example.worldcom.movieexitpoller.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.worldcom.movieexitpoller.Helpers.CurrentMovies;
import com.example.worldcom.movieexitpoller.ViewControl.MovieListAdapter;
import com.example.worldcom.movieexitpoller.R;
import com.idescout.sql.SqlScoutServer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<String> moviesList = CurrentMovies.getAll();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    Intent intentMovies = new Intent(MainActivity.this, MainActivity.class);
                    intentMovies.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMovies);
                    return true;
                case R.id.navigation_stats:
                    Intent intentStats = new Intent(MainActivity.this, StatsActivity.class);
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
        setContentView(R.layout.activity_main);
        SqlScoutServer.create(this, getPackageName());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        MovieListAdapter mAdapter = new MovieListAdapter(this, moviesList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}

