package com.example.worldcom.movieexitpoller.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "responseTable")
public class Response {

    @PrimaryKey (autoGenerate = true)
    public int keyId;

    public Response( @NonNull Integer movieId, @NonNull Integer questionId,
                     @NonNull Integer questionAnswer) {
        this.movieId = movieId;
        this.questionId = questionId;
        this.questionAnswer = questionAnswer;
    }

    @NonNull
    @ColumnInfo(name = "movieName")
    private String movieName;
    public String getMovieName(){return this.movieName;
    }
    
    public String setMovieName(String movieId){
        this.movieName = movieName;
        return movieName;
    }

    @NonNull
    @ColumnInfo(name = "movieId")
    private Integer movieId;
    public Integer getMovieId(){return this.movieId;
    }

    public Integer setMovieId(Integer movieId){
        this.movieId = movieId;
        return movieId;
    }

    @NonNull
    @ColumnInfo(name = "questionId")
    private Integer questionId;
    public Integer getQuestionId() { return questionId;
    }

    public Integer setQuestionId(Integer questionId){
        this.questionId = questionId;
        return questionId;
    }

    @NonNull
    @ColumnInfo(name = "questionAnswer")
    private Integer questionAnswer;
    
    public Integer getQuestionAnswer() {
        return questionAnswer;
    }

    public Integer setQuestionAnswer(Integer questionAnswer){
        this.questionAnswer = questionAnswer;
        return questionAnswer;
    }

}
