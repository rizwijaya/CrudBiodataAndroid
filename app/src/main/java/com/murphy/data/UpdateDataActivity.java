package com.murphy.data;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDataActivity extends AppCompatActivity {
    protected Cursor cursor;
    SqlHelper dbHelper;
    Button ton1, ton2;
    EditText no, nrp, nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        dbHelper = new SqlHelper(this);
        no = (EditText) findViewById(R.id.no);
        nrp = (EditText) findViewById(R.id.nrp);
        nama = (EditText) findViewById(R.id.nama);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            no.setText(cursor.getString(0));
            nama.setText(cursor.getString(1));
            nrp.setText(cursor.getString(2));
        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            SQLiteDatabase db1 = dbHelper.getWritableDatabase();
            db1.execSQL("update biodata set nama='" +
                    nama.getText().toString() + "', nrp='" +
                    nrp.getText().toString() + "' where no='" +
                    no.getText().toString() + "'");
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