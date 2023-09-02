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

       viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

       QuotesViewHolder quotesViewHolder=arrayList.get(position);
       holder.Quote.setText(quotesViewHolder.getQuote());
       holder.Name.setText(quotesViewHolder.getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView Name,Quote;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.txtview_layout_name);
            Quote=itemView.findViewById(R.id.txtview_layout_Quote);
        }
    }
}
