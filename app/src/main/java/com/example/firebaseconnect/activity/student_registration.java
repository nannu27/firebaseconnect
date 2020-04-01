package com.example.firebaseconnect.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.firebaseconnect.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class student_registration extends AppCompatActivity {

    EditText euserid,fname,lname,father_name,mobile,parents_mobile,occupation,permanent_address,working_address,pg_name,room_name,bed_number,whatsapp_number1;
    Button save_button,clear_button,id_button;
    RadioButton male,female;
    RadioGroup gender;
    ImageView image_id_proof,back,mypic;
    String suserid,sfname,slname,sgender,sfathername,smobile,swhatsno,sparentno,soccupation,sworkingadd,spermanentadd,spgname,sroomno,sbedno;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    FirebaseStorage storage;
    StorageReference storageReference;
    Uri filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        euserid= findViewById(R.id.euserid);
        fname = findViewById(R.id.renti_fname);
        lname = findViewById(R.id.renti_lastname);
        father_name = findViewById(R.id.renti_father_name);
        mobile = findViewById(R.id.renti_mobile_number);
        whatsapp_number1 = findViewById(R.id.renti_whatsapp_number);
        parents_mobile = findViewById(R.id.renti_parents_mobile);
        occupation = findViewById(R.id.renti_occupation);
        working_address = findViewById(R.id.renti_office_address);
        permanent_address = findViewById(R.id.renti_permanet_address);
        pg_name = findViewById(R.id.renti_pg_name);
        room_name = findViewById(R.id.renti_room_number);
        bed_number = findViewById(R.id.renti_bed_number);

        //buttons
        save_button = findViewById(R.id.renti_submit);
        clear_button = findViewById(R.id.renti_clear);
        // for image
        id_button = findViewById(R.id.renti_id_button);

        //checkBoxes
        male = findViewById(R.id.renti_male_gender);
        female = findViewById(R.id.renti_fmale_gender);
        gender = findViewById(R.id.renti_gender);

        //image_view
        mypic=findViewById(R.id.mypic);
        image_id_proof = findViewById(R.id.renti_profile);
        back = findViewById(R.id.back);


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
//listener
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suserid=euserid.getText().toString();
                sfname=fname.getText().toString();
                slname=lname.getText().toString();
                if(male.isChecked())
                {
                    sgender="male";
                }
                else if( female.isChecked())
                {
                    sgender="female";
                }

                sfathername=father_name.getText().toString();
                smobile=mobile.getText().toString();
                swhatsno=whatsapp_number1.getText().toString();
                sparentno=parents_mobile.getText().toString();
                soccupation=occupation.getText().toString();
                sworkingadd=working_address.getText().toString();
                spermanentadd=permanent_address.getText().toString();
                spgname=pg_name.getText().toString();
                sroomno=room_name.getText().toString();
                sbedno=bed_number.getText().toString();

               // sfathername,smobile,swhatsno,sparentno,soccupation,sworkingadd,spermanentadd,spgname,sroomno,sbedno
                if(!(sfname.matches(""))  && !(slname.matches("")) &&!(sgender.matches("")) &&!(sfathername.matches(""))  &&!(smobile.matches(""))  &&!(swhatsno.matches(""))  &&!(sparentno.matches(""))&&!(soccupation.matches(""))&&!(sworkingadd.matches(""))&&!(spermanentadd.matches(""))&&!(spgname.matches(""))&&!(sroomno.matches(""))&&!(sbedno.matches(""))){
                    database= FirebaseDatabase.getInstance();
                    databaseReference=database.getReference("user").child(suserid);
                    databaseReference.child("fname").setValue(sfname);
                    databaseReference.child("lname").setValue(slname);
                    databaseReference.child("gender").setValue(sgender);
                    databaseReference.child("fathername").setValue(sfname);
                    databaseReference.child("mobileno").setValue(smobile);
                    databaseReference.child("whatsupno").setValue(swhatsno);
                    databaseReference.child("parentno").setValue(sparentno);
                    databaseReference.child("occupation").setValue(soccupation);
                    databaseReference.child("workingaddress").setValue(sworkingadd);
                    databaseReference.child("permenentaddress").setValue(sparentno);
                    databaseReference.child("pgname").setValue(spgname);
                    databaseReference.child("roomno").setValue(sroomno);
                    databaseReference.child("bedno").setValue(sbedno);





                    Toast.makeText(getApplicationContext(), sfathername, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "fill all boxes", Toast.LENGTH_LONG).show();
                }




            }
        });




id_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(),"ggi".toString(), Toast.LENGTH_LONG).show();
        database= FirebaseDatabase.getInstance();
        databaseReference=database.getReference("user").child("user1");
        databaseReference.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                Toast.makeText(getApplicationContext(),"gg"+ snapshot.getValue().toString(), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });




    }
});



    }
}
