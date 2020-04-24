package org.aplas.myretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface JsonPlaceHolderApi {

    @GET("Mahasiswi")
    Call<List<Post>> getPost();

    @POST("Mahasiswi")
    Call<Post>createPost(@Body Post post);

//    @GET("Mahasiswi")
//    Call<List<Post>>getPost();

//    @GET("Mahasiswi")
//    Call<List<Post>> getPost(@Query("id_siswa")String id_siswa);
}
