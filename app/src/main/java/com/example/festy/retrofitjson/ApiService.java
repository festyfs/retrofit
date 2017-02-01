/**
 * Created by Festy on 2/1/2017.
 */
package com.example.festy.retrofitjson;
//implementasi method GET retrofit

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/institusi/nearby.php?latitude=-7.2731103&longitude=112.7416039&distance=0.2/")
    Call<Profile> getMyProfile(@Query("npsn") String npsn);
}
