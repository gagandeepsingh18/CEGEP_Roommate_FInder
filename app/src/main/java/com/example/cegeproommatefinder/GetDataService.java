package com.example.cegeproommatefinder;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("Ek0MDl1yK")
    Call<PostDetails> getPost();

}
