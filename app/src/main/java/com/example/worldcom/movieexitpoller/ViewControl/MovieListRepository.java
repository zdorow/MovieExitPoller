package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.worldcom.movieexitpoller.Room.ResponseDao;
import com.example.worldcom.movieexitpoller.Room.ResponseRoomDatabase;

import java.util.List;

public class MovieListRepository {

    private ResponseDao mResDao;
    private LiveData<List<String>> mAllMovies;

    MovieListRepository(Application application){
        ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(application);
        mResDao = db.responseDao();
        mAllMovies = mResDao.getMovieNames();
    }

    LiveData<List<String>> getAllMovies() {return mAllMovies;}
}
