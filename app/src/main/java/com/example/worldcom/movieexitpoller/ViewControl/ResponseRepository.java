package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.worldcom.movieexitpoller.Room.Response;
import com.example.worldcom.movieexitpoller.Room.ResponseDao;
import com.example.worldcom.movieexitpoller.Room.ResponseRoomDatabase;

import java.util.List;

public class ResponseRepository {
    private ResponseDao mResponseDao;
    private LiveData<List<Response>> mAllResponse;
    private LiveData<List<Integer>> mAnswerAverageForQuestion;
    Integer movieId;
    Integer questionId;

    public ResponseRepository(Application application) {
        ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(application);
        mResponseDao = db.responseDao();
        mAllResponse = mResponseDao.getAllResponses();
        mAnswerAverageForQuestion = mResponseDao.getAnswers(movieId, questionId);
    }

    public LiveData<List<Response>> getAllResponses() {
        return mAllResponse;
    }

    public int getAnswerAverage() {
        return calculateAverage(mAnswerAverageForQuestion);
    }

    private int calculateAverage(LiveData<List<Integer>> liveMark) {
        int sum = 0;
        List<Integer> marks = liveMark.getValue();

        if(!marks.isEmpty()) {
            for (int mark : marks) {
                sum += mark;
            }
            return sum / marks.size();
        }
        return sum;
    }
}
