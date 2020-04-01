package com.example.firebaseconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText ename,eshow;
Button save,show;
Spinner mylist;
List<String> post=new ArrayList<>();
private FirebaseDatabase database;
private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename=findViewById(R.id.ename);
        eshow=findViewById(R.id.eshow);
        save=findViewById(R.id.bsave);
        show=findViewById(R.id.bshow);
        mylist=findViewById(R.id.mylist);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=ename.getText().toString();
               DatabaseReference ref=database.getReference("time");
                ref.setValue(data);

                ref.child("message").setValue("hi hoe are you");
                ref.child("message").setValue("");

                ref.child("message").child("time").setValue("11:00");
                ref.child("message").child("place").setValue("ptk");
                ref.child("message").child("country").setValue("india");
                Toast.makeText(getApplicationContext(),"hlo",Toast.LENGTH_LONG).show();
            }
        });
        databaseReference=database.getReference();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String a="";
                           post.clear();
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                            for( DataSnapshot post1: postSnapshot.getChildren())
                            {

                                /*for( DataSnapshot post2: post1.getChildren())
                                {
                                    Toast.makeText(getApplicationContext(),post2.getValue().toString(),Toast.LENGTH_LONG).show();
                                    a+=post2.getValue().toString();
                                    post.add(post2.getValue().toString());
                                }*/


                                Toast.makeText(getApplicationContext(),post1.getValue().toString(),Toast.LENGTH_LONG).show();
                                a+=post1.getValue().toString();
                                post.add(post1.child("time").getValue().toString());
                            }




                           /* Toast.makeText(getApplicationContext(),postSnapshot.getValue().toString(),Toast.LENGTH_LONG).show();
                             a+=postSnapshot.getValue().toString();
                            post.add(postSnapshot.child("time").getValue(String.class));*/
                        }
                       ename.setText(a);

                        /*
                            Toast.makeText(getApplicationContext(),dataSnapshot.getValue().toString(),Toast.LENGTH_LONG).show();
                           String data=dataSnapshot.child("user").child("message").child("time").getValue().toString();
                          eshow.setText(data);*/
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
       ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, post);


      mylist.setAdapter(arrayAdapter);



    }
}
