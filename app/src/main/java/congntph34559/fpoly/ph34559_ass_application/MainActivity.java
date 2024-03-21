package congntph34559.fpoly.ph34559_ass_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.ph34559_ass_application.API.APIService;
import congntph34559.fpoly.ph34559_ass_application.Adapter.AdapterShoe;
import congntph34559.fpoly.ph34559_ass_application.DTO.ShoeDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<ShoeDTO> list = new ArrayList<>();
    AdapterShoe adapterShoe;
    RecyclerView recyclerView;
    FloatingActionButton floaAdd;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcvList);
        floaAdd = findViewById(R.id.floatAdd);

        //Connect
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Call Api Retrofit
        CallAPI(retrofit);


        //setOnclick add
        floaAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewCreateAndAddActivity.class);
                intent.putExtra("titleAdd", "Create shoe");
                intent.putExtra("titleBtnAdd", "Create");
                startActivity(intent);
                finish();
            }
        });


    }

    private void CallAPI(Retrofit retrofit) {

        //Khai báo API Service
        APIService apiService = retrofit.create(APIService.class);

        Call<List<ShoeDTO>> call = apiService.getShoe();

        call.enqueue(new Callback<List<ShoeDTO>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<ShoeDTO>> call, @NonNull Response<List<ShoeDTO>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    adapterShoe = new AdapterShoe(getApplicationContext(), list);
                    LinearLayoutManager linearLayoutManager =
                            new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapterShoe);
                    adapterShoe.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ShoeDTO>> call, @NonNull Throwable t) {
                Log.e("zzzz", "onFailure: " + t.getMessage());
            }
        });


    }
}