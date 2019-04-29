package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.worldcom.movieexitpoller.Room.Response;

import java.util.List;

public class ResponseViewModel extends AndroidViewModel {

    private ResponseRepository mRepository;

    private LiveData<List<Response>> mAllResponses;
    private int mAnswerAverage;

    public ResponseViewModel(Application application) {
        super(application);
        mRepository = new ResponseRepository(application);
        mAllResponses = mRepository.getAllResponses();
        mAnswerAverage = mRepository.getAnswerAverage();
    }

    public LiveData<List<Response>> getAllResponses() { return mAllResponses; }

    public int getAnswerAverage() {
        return mAnswerAverage;
    }



}
