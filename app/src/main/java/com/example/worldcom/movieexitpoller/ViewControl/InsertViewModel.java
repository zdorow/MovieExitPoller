package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.worldcom.movieexitpoller.Room.Response;

public class InsertViewModel extends AndroidViewModel {

    private InsertRepository mRepository;

    public InsertViewModel(Application application) {
        super(application);
        mRepository = new InsertRepository(application);
    }

    public void insert(Response response) { mRepository.insert(response); }
}
