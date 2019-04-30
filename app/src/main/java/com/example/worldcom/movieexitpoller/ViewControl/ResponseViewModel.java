package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.worldcom.movieexitpoller.Room.Response;

import java.util.List;

public class ResponseViewModel extends AndroidViewModel {

    private ResponseRepository mRepository;

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

    public ResponseViewModel(Application application) {
        super(application);
        mRepository = new ResponseRepository(application);
        mAllResponses = mRepository.getAllResponses();
        mAverageAnswerForQuestion1_1 = mRepository.getAnswerAverage1_1();
        mAverageAnswerForQuestion1_2 = mRepository.getAnswerAverage1_2();
        mAverageAnswerForQuestion1_3 = mRepository.getAnswerAverage1_3();
        mAverageAnswerForQuestion1_4 = mRepository.getAnswerAverage1_4();
        mAverageAnswerForQuestion1_5 = mRepository.getAnswerAverage1_5();

        mAverageAnswerForQuestion2_1 = mRepository.getAnswerAverage2_1();
        mAverageAnswerForQuestion2_2 = mRepository.getAnswerAverage2_2();
        mAverageAnswerForQuestion2_3 = mRepository.getAnswerAverage2_3();
        mAverageAnswerForQuestion2_4 = mRepository.getAnswerAverage2_4();
        mAverageAnswerForQuestion2_5 = mRepository.getAnswerAverage2_5();

        mAverageAnswerForQuestion3_1 = mRepository.getAnswerAverage3_1();
        mAverageAnswerForQuestion3_2 = mRepository.getAnswerAverage3_2();
        mAverageAnswerForQuestion3_3 = mRepository.getAnswerAverage3_3();
        mAverageAnswerForQuestion3_4 = mRepository.getAnswerAverage3_4();
        mAverageAnswerForQuestion3_5 = mRepository.getAnswerAverage3_5();

        mAverageAnswerForQuestion4_1 = mRepository.getAnswerAverage4_1();
        mAverageAnswerForQuestion4_2 = mRepository.getAnswerAverage4_2();
        mAverageAnswerForQuestion4_3 = mRepository.getAnswerAverage4_3();
        mAverageAnswerForQuestion4_4 = mRepository.getAnswerAverage4_4();
        mAverageAnswerForQuestion4_5 = mRepository.getAnswerAverage4_5();

        mAverageAnswerForQuestion5_1 = mRepository.getAnswerAverage5_1();
        mAverageAnswerForQuestion5_2 = mRepository.getAnswerAverage5_2();
        mAverageAnswerForQuestion5_3 = mRepository.getAnswerAverage5_3();
        mAverageAnswerForQuestion5_4 = mRepository.getAnswerAverage5_4();
        mAverageAnswerForQuestion5_5 = mRepository.getAnswerAverage5_5();

        mAverageAnswerForQuestion6_1 = mRepository.getAnswerAverage6_1();
        mAverageAnswerForQuestion6_2 = mRepository.getAnswerAverage6_2();
        mAverageAnswerForQuestion6_3 = mRepository.getAnswerAverage6_3();
        mAverageAnswerForQuestion6_4 = mRepository.getAnswerAverage6_4();
        mAverageAnswerForQuestion6_5 = mRepository.getAnswerAverage6_5();
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
