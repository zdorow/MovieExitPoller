package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.worldcom.movieexitpoller.Room.Response;

import java.util.List;

public class ResponseViewModel extends AndroidViewModel {

    private ResponseRepository mRepository;

    private List<Response> mAllResponses;

    public ResponseViewModel(Application application) {
        super(application);
        mRepository = new ResponseRepository(application);
        mAllResponses = mRepository.getAllResponses();
    }

    public List<Response> getAllResponses() { return mAllResponses; }

    public void insert(Response response) { mRepository.insert(response); }
}
