package com.example.worldcom.movieexitpoller.ViewControl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldcom.movieexitpoller.R;

import com.jjoe64.graphview.GraphView;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>{

    class ResponseViewHolder extends RecyclerView.ViewHolder {
        private final GraphView bar_graph;

        private ResponseViewHolder(View itemView) {
            super(itemView);
            bar_graph = itemView.findViewById(R.id.bar_graph1);
        }
    }
    private final LayoutInflater mInflater;
    private int mAverageResponse;

    ResponseAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ResponseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ResponseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ResponseViewHolder holder, int position) {
//        Word current = mWords.get(position);
//        String next = "<font color='#EE0000'><i>" + current.getPart() + "</i></font>";
//        holder.wordItemView.setText(Html.fromHtml(current.getWord() + " - " + next));
    }

    void setResponses(int response){
        mAverageResponse = response;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
