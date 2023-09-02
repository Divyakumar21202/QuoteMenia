package com.example.firebasedatafetching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class QuotesListView extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<QuotesViewHolder> arrayList=new ArrayList<>();
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    QuoteRecyclerAdapter quoteRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list_view);
        recyclerView=findViewById(R.id.rv_quotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseReference myref=firebaseDatabase.getReference("Quotes");
        quoteRecyclerAdapter=new QuoteRecyclerAdapter(getApplicationContext(),arrayList);

        recyclerView.setAdapter(quoteRecyclerAdapter);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Code to Read All user From the DataBase ..
                for(DataSnapshot dataSnapshot :snapshot.getChildren())
                {
                    QuotesViewHolder newvh=dataSnapshot.getValue(QuotesViewHolder.class);
                    arrayList.add(newvh);
                }
                quoteRecyclerAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Array List is Updated",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Error to Fetch Data",Toast.LENGTH_SHORT).show();

            }
        });





    }
}