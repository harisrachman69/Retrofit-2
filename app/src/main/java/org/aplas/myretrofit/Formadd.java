package org.aplas.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Formadd extends AppCompatActivity {
    private EditText ktnamasiswa, ktalamatsiswa, ktjksiswa, kttelpsiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formadd);

        ktnamasiswa = (EditText) findViewById(R.id.kt_namasiswa);
        ktalamatsiswa = (EditText) findViewById(R.id.kt_alamatsiswa);
        ktjksiswa = (EditText) findViewById(R.id.kt_jeniskelaminsiswa);
        kttelpsiswa=(EditText) findViewById(R.id.kt_no_telpsiswa);

    }

    public void submit(View view) {
        String nama = ktnamasiswa.getText().toString().trim();
        String alamat = ktalamatsiswa.getText().toString().trim();
        String jenis_kelamin = ktjksiswa.getText().toString().trim();
        String no_telp = kttelpsiswa.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://harrisjson.000webhostapp.com/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Post post = new Post(nama, alamat, jenis_kelamin, no_telp);

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Formadd.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Formadd.this, MainActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(Formadd.this, "Gagal ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}