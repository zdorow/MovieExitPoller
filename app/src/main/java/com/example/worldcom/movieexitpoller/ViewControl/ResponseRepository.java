package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.worldcom.movieexitpoller.Room.Response;
import com.example.worldcom.movieexitpoller.Room.ResponseDao;
import com.example.worldcom.movieexitpoller.Room.ResponseRoomDatabase;

import java.util.List;

public class ResponseRepository {
    private ResponseDao mResponseDao;
    private LiveData<List<Response>> mAllResponses;
    private LiveData<Integer> mAverageAnswerForQuestion1_1;
    private LiveData<Integer> mAverageAnswerForQuestion1_2;
    private LiveData<Integer> mAverageAnswerForQuestion1_3;
    private LiveData<Integer> mAverageAnswerForQuestion1_4;
    private LiveData<Integer> mAverageAnswerForQuestion1_5;

    private LiveData<Integer> mAverageAnswerForQuestion2_1;
    private LiveData<Integer> mAverageAnswerForQuestion2_2;
    private LiveData<Integer> mAverageAnswerForQuestion2_3;
    private LiveData<Integer> mAverageAnswerForQuestion2_4;
    private LiveData<Integer> mAverageAnswerForQuestion2_5;

    private LiveData<Integer> mAverageAnswerForQuestion3_1;
    private LiveData<Integer> mAverageAnswerForQuestion3_2;
    private LiveData<Integer> mAverageAnswerForQuestion3_3;
    private LiveData<Integer> mAverageAnswerForQuestion3_4;
    private LiveData<Integer> mAverageAnswerForQuestion3_5;

    private LiveData<Integer> mAverageAnswerForQuestion4_1;
    private LiveData<Integer> mAverageAnswerForQuestion4_2;
    private LiveData<Integer> mAverageAnswerForQuestion4_3;
    private LiveData<Integer> mAverageAnswerForQuestion4_4;
    private LiveData<Integer> mAverageAnswerForQuestion4_5;

    private LiveData<Integer> mAverageAnswerForQuestion5_1;
    private LiveData<Integer> mAverageAnswerForQuestion5_2;
    private LiveData<Integer> mAverageAnswerForQuestion5_3;
    private LiveData<Integer> mAverageAnswerForQuestion5_4;
    private LiveData<Integer> mAverageAnswerForQuestion5_5;

    private LiveData<Integer> mAverageAnswerForQuestion6_1;
    private LiveData<Integer> mAverageAnswerForQuestion6_2;
    private LiveData<Integer> mAverageAnswerForQuestion6_3;
    private LiveData<Integer> mAverageAnswerForQuestion6_4;
    private LiveData<Integer> mAverageAnswerForQuestion6_5;

    public ResponseRepository(Application application) {
        ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(application);
        mResponseDao = db.responseDao();
        mAllResponses = mResponseDao.getAllResponses();
        mAverageAnswerForQuestion1_1 = mResponseDao.getAnswerAverage(1, 1);
        mAverageAnswerForQuestion1_2 = mResponseDao.getAnswerAverage(2, 1);
        mAverageAnswerForQuestion1_3 = mResponseDao.getAnswerAverage(3, 1);
        mAverageAnswerForQuestion1_4 = mResponseDao.getAnswerAverage(4, 1);
        mAverageAnswerForQuestion1_5 = mResponseDao.getAnswerAverage(5, 1);

        mAverageAnswerForQuestion2_1 = mResponseDao.getAnswerAverage(1, 2);
        mAverageAnswerForQuestion2_2 = mResponseDao.getAnswerAverage(2, 2);
        mAverageAnswerForQuestion2_3 = mResponseDao.getAnswerAverage(3, 2);
        mAverageAnswerForQuestion2_4 = mResponseDao.getAnswerAverage(4, 2);
        mAverageAnswerForQuestion2_5 = mResponseDao.getAnswerAverage(5, 2);

        mAverageAnswerForQuestion3_1 = mResponseDao.getAnswerAverage(1, 3);
        mAverageAnswerForQuestion3_2 = mResponseDao.getAnswerAverage(2, 3);
        mAverageAnswerForQuestion3_3 = mResponseDao.getAnswerAverage(3, 3);
        mAverageAnswerForQuestion3_4 = mResponseDao.getAnswerAverage(4, 3);
        mAverageAnswerForQuestion3_5 = mResponseDao.getAnswerAverage(5, 3);

        mAverageAnswerForQuestion4_1 = mResponseDao.getAnswerAverage(1, 4);
        mAverageAnswerForQuestion4_2 = mResponseDao.getAnswerAverage(2, 4);
        mAverageAnswerForQuestion4_3 = mResponseDao.getAnswerAverage(3, 4);
        mAverageAnswerForQuestion4_4 = mResponseDao.getAnswerAverage(4, 4);
        mAverageAnswerForQuestion4_5 = mResponseDao.getAnswerAverage(5, 4);

        mAverageAnswerForQuestion5_1 = mResponseDao.getAnswerAverage(1, 5);
        mAverageAnswerForQuestion5_2 = mResponseDao.getAnswerAverage(2, 5);
        mAverageAnswerForQuestion5_3 = mResponseDao.getAnswerAverage(3, 5);
        mAverageAnswerForQuestion5_4 = mResponseDao.getAnswerAverage(4, 5);
        mAverageAnswerForQuestion5_5 = mResponseDao.getAnswerAverage(5, 5);

        mAverageAnswerForQuestion6_1 = mResponseDao.getAnswerAverage(1, 6);
        mAverageAnswerForQuestion6_2 = mResponseDao.getAnswerAverage(2, 6);
        mAverageAnswerForQuestion6_3 = mResponseDao.getAnswerAverage(3, 6);
        mAverageAnswerForQuestion6_4 = mResponseDao.getAnswerAverage(4, 6);
        mAverageAnswerForQuestion6_5 = mResponseDao.getAnswerAverage(5, 6);
    }

    public LiveData<List<Response>> getAllResponses() {
        return mAllResponses;
    }

    public LiveData<Integer> getAnswerAverage1_1() {
        return mAverageAnswerForQuestion1_1;
    }    
    public LiveData<Integer> getAnswerAverage1_2() {
        return mAverageAnswerForQuestion1_2;
    }   
    public LiveData<Integer> getAnswerAverage1_3() {
        return mAverageAnswerForQuestion1_3;
    }
    public LiveData<Integer> getAnswerAverage1_4() {
        return mAverageAnswerForQuestion1_4;
    }
    public LiveData<Integer> getAnswerAverage1_5() {
        return mAverageAnswerForQuestion1_5;
    }

    public LiveData<Integer> getAnswerAverage2_1() {
        return mAverageAnswerForQuestion2_1;
    }
    public LiveData<Integer> getAnswerAverage2_2() {
        return mAverageAnswerForQuestion2_2;
    }
    public LiveData<Integer> getAnswerAverage2_3() {
        return mAverageAnswerForQuestion2_3;
    }
    public LiveData<Integer> getAnswerAverage2_4() {
        return mAverageAnswerForQuestion2_4;
    }
    public LiveData<Integer> getAnswerAverage2_5() {
        return mAverageAnswerForQuestion2_5;
    }

    public LiveData<Integer> getAnswerAverage3_1() {
        return mAverageAnswerForQuestion3_1;
    }
    public LiveData<Integer> getAnswerAverage3_2() {
        return mAverageAnswerForQuestion3_2;
    }
    public LiveData<Integer> getAnswerAverage3_3() {
        return mAverageAnswerForQuestion3_3;
    }
    public LiveData<Integer> getAnswerAverage3_4() {
        return mAverageAnswerForQuestion3_4;
    }
    public LiveData<Integer> getAnswerAverage3_5() {
        return mAverageAnswerForQuestion3_5;
    }

    public LiveData<Integer> getAnswerAverage4_1() {
        return mAverageAnswerForQuestion4_1;
    }
    public LiveData<Integer> getAnswerAverage4_2() {
        return mAverageAnswerForQuestion4_2;
    }
    public LiveData<Integer> getAnswerAverage4_3() {
        return mAverageAnswerForQuestion4_3;
    }
    public LiveData<Integer> getAnswerAverage4_4() {
        return mAverageAnswerForQuestion4_4;
    }
    public LiveData<Integer> getAnswerAverage4_5() {
        return mAverageAnswerForQuestion4_5;
    }

    public LiveData<Integer> getAnswerAverage5_1() {
        return mAverageAnswerForQuestion5_1;
    }
    public LiveData<Integer> getAnswerAverage5_2() {
        return mAverageAnswerForQuestion5_2;
    }
    public LiveData<Integer> getAnswerAverage5_3() {
        return mAverageAnswerForQuestion5_3;
    }
    public LiveData<Integer> getAnswerAverage5_4() {
        return mAverageAnswerForQuestion5_4;
    }
    public LiveData<Integer> getAnswerAverage5_5() {
        return mAverageAnswerForQuestion5_5;
    }

    public LiveData<Integer> getAnswerAverage6_1() {
        return mAverageAnswerForQuestion6_1;
    }
    public LiveData<Integer> getAnswerAverage6_2() {
        return mAverageAnswerForQuestion6_2;
    }
    public LiveData<Integer> getAnswerAverage6_3() {
        return mAverageAnswerForQuestion6_3;
    }
    public LiveData<Integer> getAnswerAverage6_4() {
        return mAverageAnswerForQuestion6_4;
    }
    public LiveData<Integer> getAnswerAverage6_5() {
        return mAverageAnswerForQuestion6_5;
    }
    
}
