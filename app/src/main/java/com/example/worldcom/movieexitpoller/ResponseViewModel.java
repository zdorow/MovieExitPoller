package com.example.worldcom.movieexitpoller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

public class ResponseViewModel extends AndroidViewModel {

    private ResponseRepository mRepository;

    private LiveData<List<Response>> mAllResponses;

    public ResponseViewModel(Application application) {
        super(application);
        mRepository = new ResponseRepository(application);
        mAllResponses = mRepository.getAllResponses();
    }

    public LiveData<List<Response>> getAllResponses() { return mAllResponses; }

    public void insert(Response response) { mRepository.insert(response); }
}
