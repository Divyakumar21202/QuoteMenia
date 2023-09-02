package com.example.firebasedatafetching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    ArrayList<QuotesViewHolder> arrayList=new ArrayList<>();
    EditText textViewName,textViewQuotes;
    Button btnUpload,btnGoToRecyclerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewName=findViewById(R.id.edt_txt_name);
        textViewQuotes=findViewById(R.id.edt_txt_quote);
        btnUpload=findViewById(R.id.btn_upload);
        btnGoToRecyclerList=findViewById(R.id.btn_go_to_recycler_list);



        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name=textViewName.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Name",Toast.LENGTH_SHORT).show();
                    return;
                }
                String quote=textViewQuotes.getText().toString();
                if(quote.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Some Quote",Toast.LENGTH_SHORT).show();
                    return;
                }

                DatabaseReference myref=firebaseDatabase.getReference("Quotes");
                HashMap<String,Object> hashMap=new HashMap<>();
                hashMap.put("Name",textViewName.getText().toString());
                hashMap.put("Quote",textViewQuotes.getText().toString());
                myref.child(name).setValue(hashMap)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getApplicationContext(),"Data Uploaded",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Failed to Upload",Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });

    }
}