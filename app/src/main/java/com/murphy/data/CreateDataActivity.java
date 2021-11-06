package com.murphy.data;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateDataActivity extends AppCompatActivity {
    SqlHelper dbHelper;
    Button ton1, ton2;
    EditText no, nrp, nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_data);

        dbHelper = new SqlHelper(this);
        no = (EditText) findViewById(R.id.no);
        nama = (EditText) findViewById(R.id.nrp);
        nrp = (EditText) findViewById(R.id.nama);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        ton1.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("insert into biodata(no, nrp, nama) values('" +
                    no.getText().toString() + "','" +
                    nama.getText().toString() + "','" +
                    nrp.getText().toString() + "')");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            MainActivity.ma.RefreshList();
            finish();
        });
        ton2.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            finish();
        });
    }
}