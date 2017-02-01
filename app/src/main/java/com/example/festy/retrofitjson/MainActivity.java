package com.example.festy.retrofitjson;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.festy.retrofitjson.ApiClient;
import com.example.festy.retrofitjson.ApiService;
import com.example.festy.retrofitjson.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button getData;
    private TextView npsn;
    private TextView institution_name;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData = (Button) findViewById(R.id.getprofile);
        npsn = (TextView) findViewById(R.id.npsn);
        institution_name = (TextView) findViewById(R.id.institution_name);


        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Get The Data");
                progressDialog.setMessage("Loading ...");
                progressDialog.show();

                getProfile();
            }
        });
    }

    private void getProfile(){
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Profile> call = apiService.getMyProfile("73006");
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                progressDialog.dismiss();
                Profile p = response.body();

                npsn.setText(p.getNpsn());
                institution_name.setText(p.getInstitutionName());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Failed to load", Toast.LENGTH_LONG).show();
            }
        });
    }
}
