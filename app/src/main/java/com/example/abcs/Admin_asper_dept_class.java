package com.example.abcs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_asper_dept_class extends AppCompatActivity
{
    RecyclerView recview;
    ArrayList<model> datalist;
    FirebaseFirestore db;
    myadapter adapter;
    TextView _1;
    String txt_yr,txt_dept;
    TextView comp, it,entc,cvil,mech;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_asper_dept_class);
        _1=findViewById(R.id._1);
        comp  =findViewById(R.id.textView105);
        it=findViewById(R.id.textView106);
        entc =findViewById(R.id.textView107);
        cvil =findViewById(R.id.textView108);
        mech=findViewById(R.id.textView109);
        recview=(RecyclerView)findViewById(R.id.rv999);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<model>();
        adapter=new myadapter(datalist);
        recview.setAdapter(adapter);
        db=FirebaseFirestore.getInstance();
        comp.setText(getIntent().getStringExtra("deco1"));
        it.setText(getIntent().getStringExtra("deco2"));
        entc.setText(getIntent().getStringExtra("deco3"));
        cvil.setText(getIntent().getStringExtra("deco4"));
        mech.setText(getIntent().getStringExtra("deco5"));
        _1.setText(getIntent().getStringExtra("class1"));

        //comp
        if(_1.getText().toString().equals("BE") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="BE";
        }
          if (_1.getText().toString().equals("SY") && comp.getText().toString().equals("Comp")){
              txt_dept="Comp";
              txt_yr="SY";
          }
        if (_1.getText().toString().equals("TY") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="TY";
        }
        if (_1.getText().toString().equals("FY") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="FY";
        }
//mech
        if(_1.getText().toString().equals("BE") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SY") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="SY";
        }
        if (_1.getText().toString().equals("TY") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="TY";
        }
        if (_1.getText().toString().equals("FY") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="FY";
        }

//civil
        if(_1.getText().toString().equals("BE") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SY") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="SY";
        }
        if (_1.getText().toString().equals("TY") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="TY";
        }
        if (_1.getText().toString().equals("FY") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="FY";
        }
        //entc
        if(_1.getText().toString().equals("BE") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SY") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="SY";
        }
        if (_1.getText().toString().equals("TY") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="TY";
        }
        if (_1.getText().toString().equals("FY") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="FY";
        }
//it
        if(_1.getText().toString().equals("BE") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SY") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="SY";
        }
        if (_1.getText().toString().equals("TY") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="TY";
        }
        if (_1.getText().toString().equals("FY") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="FY";
        }
        db.collection("student_req_permision_data").whereEqualTo("class",txt_yr).whereEqualTo("brnach",txt_dept).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj=d.toObject(model.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}