package com.example.worldcom.movieexitpoller.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.worldcom.movieexitpoller.Room.Response;

import java.util.List;

@Dao
public interface ResponseDao {

    @Query("SELECT * from responseTable")
    List<Response> getAllResponses();

    @Query("SELECT questionAnswer from responseTable where movieId = :mId AND questionId = :questionId")
    List<Integer> getAnswers(Integer mId, Integer questionId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Response response);

    @Query("DELETE FROM responseTable")
    void deleteAll();
}
