package com.example.firebasedatafetching;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.xml.namespace.QName;


public class QuoteRecyclerAdapter extends RecyclerView.Adapter<QuoteRecyclerAdapter.viewHolder> {


    Context context;
    ArrayList<QuotesViewHolder> arrayList;

    public QuoteRecyclerAdapter(Context context, ArrayList<QuotesViewHolder> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(context).inflate(R.layout.quoteview,parent,false);
       viewHolder viewHolder =new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.Quote.setText(arrayList.get(position).Quote);
        holder.name.setText(arrayList.get(position).name);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name,Quote;
        public viewHolder(View view){
            super(view);
            name=view.findViewById(R.id.txtview_layout_name);
            Quote=view.findViewById(R.id.txtview_layout_Quote);
        }
    }
}
