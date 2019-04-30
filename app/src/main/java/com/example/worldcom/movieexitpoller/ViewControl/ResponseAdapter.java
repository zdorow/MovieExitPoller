package com.example.worldcom.movieexitpoller.ViewControl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldcom.movieexitpoller.R;

import com.jjoe64.graphview.GraphView;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>{

    private Integer mAverageAnswerForQuestion1_1;
    private Integer mAverageAnswerForQuestion1_2;
    private Integer mAverageAnswerForQuestion1_3;
    private Integer mAverageAnswerForQuestion1_4;
    private Integer mAverageAnswerForQuestion1_5;

    private Integer mAverageAnswerForQuestion2_1;
    private Integer mAverageAnswerForQuestion2_2;
    private Integer mAverageAnswerForQuestion2_3;
    private Integer mAverageAnswerForQuestion2_4;
    private Integer mAverageAnswerForQuestion2_5;

    private Integer mAverageAnswerForQuestion3_1;
    private Integer mAverageAnswerForQuestion3_2;
    private Integer mAverageAnswerForQuestion3_3;
    private Integer mAverageAnswerForQuestion3_4;
    private Integer mAverageAnswerForQuestion3_5;

    private Integer mAverageAnswerForQuestion4_1;
    private Integer mAverageAnswerForQuestion4_2;
    private Integer mAverageAnswerForQuestion4_3;
    private Integer mAverageAnswerForQuestion4_4;
    private Integer mAverageAnswerForQuestion4_5;

    private Integer mAverageAnswerForQuestion5_1;
    private Integer mAverageAnswerForQuestion5_2;
    private Integer mAverageAnswerForQuestion5_3;
    private Integer mAverageAnswerForQuestion5_4;
    private Integer mAverageAnswerForQuestion5_5;

    private Integer mAverageAnswerForQuestion6_1;
    private Integer mAverageAnswerForQuestion6_2;
    private Integer mAverageAnswerForQuestion6_3;
    private Integer mAverageAnswerForQuestion6_4;
    private Integer mAverageAnswerForQuestion6_5;

    class ResponseViewHolder extends RecyclerView.ViewHolder {
        private final GraphView bar_graph;

        private ResponseViewHolder(View itemView) {
            super(itemView);
            bar_graph = itemView.findViewById(R.id.bar_graph1);
        }
    }
    private final LayoutInflater mInflater;

    public ResponseAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ResponseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_graphs, parent, false);
        return new ResponseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ResponseViewHolder holder, int position) {
    }

    public void setAverageAnswerForQuestion1_1(Integer average){
        mAverageAnswerForQuestion1_1 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion1_2(Integer average){
        mAverageAnswerForQuestion1_2 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion1_3(Integer average){
        mAverageAnswerForQuestion1_3 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion1_4(Integer average){
        mAverageAnswerForQuestion1_4 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion1_5(Integer average){
        mAverageAnswerForQuestion1_5 = average;
        notifyDataSetChanged();
    }

    public void setAverageAnswerForQuestion2_1(Integer average){
        mAverageAnswerForQuestion2_1 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion2_2(Integer average){
        mAverageAnswerForQuestion2_2 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion2_3(Integer average){
        mAverageAnswerForQuestion2_3 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion2_4(Integer average){
        mAverageAnswerForQuestion2_4 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion2_5(Integer average){
        mAverageAnswerForQuestion2_5 = average;
        notifyDataSetChanged();
    }

    public void setAverageAnswerForQuestion3_1(Integer average){
        mAverageAnswerForQuestion3_1 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion3_2(Integer average){
        mAverageAnswerForQuestion3_2 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion3_3(Integer average){
        mAverageAnswerForQuestion3_3 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion3_4(Integer average){
        mAverageAnswerForQuestion3_4 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion3_5(Integer average){
        mAverageAnswerForQuestion3_5 = average;
        notifyDataSetChanged();
    }

    public void setAverageAnswerForQuestion4_1(Integer average){
        mAverageAnswerForQuestion4_1 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion4_2(Integer average){
        mAverageAnswerForQuestion4_2 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion4_3(Integer average){
        mAverageAnswerForQuestion4_3 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion4_4(Integer average){
        mAverageAnswerForQuestion4_4 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion4_5(Integer average){
        mAverageAnswerForQuestion4_5 = average;
        notifyDataSetChanged();
    }

    public void setAverageAnswerForQuestion5_1(Integer average){
        mAverageAnswerForQuestion5_1 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion5_2(Integer average){
        mAverageAnswerForQuestion5_2 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion5_3(Integer average){
        mAverageAnswerForQuestion5_3 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion5_4(Integer average){
        mAverageAnswerForQuestion5_4 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion5_5(Integer average){
        mAverageAnswerForQuestion5_5 = average;
        notifyDataSetChanged();
    }

    public void setAverageAnswerForQuestion6_1(Integer average){
        mAverageAnswerForQuestion6_1 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion6_2(Integer average){
        mAverageAnswerForQuestion6_2 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion6_3(Integer average){
        mAverageAnswerForQuestion6_3 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion6_4(Integer average){
        mAverageAnswerForQuestion6_4 = average;
        notifyDataSetChanged();
    }
    public void setAverageAnswerForQuestion6_5(Integer average){
        mAverageAnswerForQuestion6_5 = average;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return 6;
    }
}
