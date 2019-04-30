package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieListRepository mRepository;

    private LiveData<List<String>> mAllMovies;

    public MovieListViewModel(Application application) {
        super(application);
        mRepository = new MovieListRepository(application);
        mAllMovies = mRepository.getAllMovies();
    }

    public LiveData<List<String>> getAllMovies() { return mAllMovies; }
}
