
package com.example.firebaseconnect.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.firebaseconnect.R;
import com.example.firebaseconnect.fragment.pending;
import com.example.firebaseconnect.fragment.room;
import com.example.firebaseconnect.fragment.student;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class tab_activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    Spinner option;
    ImageView delete,reload,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity);
        bottomNavigationView = findViewById(R.id.bottomn);
        delete = findViewById(R.id.delete);
        back = findViewById(R.id.back);
        reload = findViewById(R.id.reload);

        option = findViewById(R.id.option);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;


                switch (menuItem.getItemId()) {
                    case R.id.student:
                        fragment = new student();
                        Toast.makeText(getApplicationContext(), "toast ", Toast.LENGTH_LONG).show();
                        viewfragment(fragment);
                        return true;
                    case R.id.pending:
                        fragment = new pending();
                        Toast.makeText(getApplicationContext(), "toast1 ", Toast.LENGTH_LONG).show();
                        viewfragment(fragment);
                        return true;
                    case R.id.room:
                        fragment = new room();
                        Toast.makeText(getApplicationContext(), "toasthh ", Toast.LENGTH_LONG).show();
                        viewfragment(fragment);
                        return true;

                }
                Toast.makeText(getApplicationContext(), "work ", Toast.LENGTH_LONG).show();



                return false;
            }
        });

    }
    public void viewfragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentcontainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
