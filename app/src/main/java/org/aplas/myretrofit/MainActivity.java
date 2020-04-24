package org.aplas.myretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView result = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://harrisjson.000webhostapp.com/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if(!response.isSuccessful()){
//                    textViewResult.setText("Code " + response.code());
//                    return;
//                }
                List<Post> posts = response.body();
                String content="";
                for(Post post:posts){
                    content+="id_siswa : "+post.getId_siswa()+"\n";
                    content+="nama : "+post.getNama()+"\n";
                    content+="alamat : "+post.getAlamat()+"\n";
                    content+="jenis_kelamin : "+post.getJenis_kelamin()+"\n";
                    content+="no_telp : "+post.getNo_telp()+"\n";
                }
                MahasiswiAdapter adapter = new MahasiswiAdapter(posts);
                    result.setAdapter(adapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                result.setLayoutManager(layoutManager);
//                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void tambah(View view) {
        Intent i = new Intent(MainActivity.this,Formadd.class);
        startActivity(i);
    }
}

