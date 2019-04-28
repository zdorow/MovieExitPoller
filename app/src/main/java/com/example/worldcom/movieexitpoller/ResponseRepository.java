package com.example.worldcom.movieexitpoller;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ResponseRepository {
    private ResponseDao mResponseDao;
    private LiveData<List<Response>> mAllResponse;
    private LiveData<List<Integer>> mAnswersForQuestion;
    Integer movieId;
    Integer questionId;

    ResponseRepository(Application application) {
        ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(application);
        mResponseDao = db.responseDao();
        mAllResponse = mResponseDao.getAllResponses();
        mAnswersForQuestion = mResponseDao.getAnswers(movieId, questionId);
    }

    LiveData<List<Response>> getAllResponses() {
        return mAllResponse;
    }

    LiveData<List<Integer>> getAnswers() {
        return mAnswersForQuestion;
    }

    public void insert (Response response) {
        new insertAsyncTask(mResponseDao).execute(response);
    }

    private static class insertAsyncTask extends AsyncTask<Response, Void, Void> {

        private ResponseDao mAsyncTaskDao;

        insertAsyncTask(ResponseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Response... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
