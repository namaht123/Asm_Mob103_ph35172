package congntph34559.fpoly.ph34559_ass_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.ph34559_ass_application.API.APIService;
import congntph34559.fpoly.ph34559_ass_application.DTO.ShoeDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class NewCreateAndAddActivity extends AppCompatActivity {
    TextView tvTitle;
    ImageView ivBack;
    Spinner spSize;
    ArrayAdapter adapterSp;
    List<String> listSize = new ArrayList<String>();
    AppCompatButton btnNewAndEdit;
    EditText edName, edPrice, edBrand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_create_and_add);
        tvTitle = findViewById(R.id.tvTitle);
        ivBack = findViewById(R.id.ivBackCreUp);
        spSize = findViewById(R.id.spSize);
        btnNewAndEdit = findViewById(R.id.btnNewAndEdit);
        edBrand = findViewById(R.id.edBrand);
        edName = findViewById(R.id.edName);
        edPrice = findViewById(R.id.edPrice);

        //Cầu hình UI
        ChangeUI();

        //Cấu hình spinner
        Spinner();

        //Add shoe
        btnNewAndEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateShoe();

            }
        });


    }

    private void CreateShoe() {

        String name = edName.getText().toString();
        String brand = edBrand.getText().toString();
        String price = edPrice.getText().toString();
        String size = (String) spSize.getSelectedItem();


        if (CheckCreateShoe()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIService.DOMAIN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            APIService apiService = retrofit.create(APIService.class);

            Call<ShoeDTO> call = apiService.createShoe(new ShoeDTO(name, brand, Long.parseLong(price), size, "url nè"));


            call.enqueue(new Callback<ShoeDTO>() {
                @Override
                public void onResponse(Call<ShoeDTO> call, Response<ShoeDTO> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(NewCreateAndAddActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NewCreateAndAddActivity.this, MainActivity.class));
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<ShoeDTO> call, Throwable t) {
                    Log.e("zzzzz", "onFailure: " + t.getMessage());
                }
            });


        }


    }

    private boolean CheckCreateShoe() {

        return true;
    }

    private void ChangeUI() {
        //Data intent add
        String titleAdd = getIntent().getStringExtra("titleAdd");
        String titleBtnAdd = getIntent().getStringExtra("titleBtnAdd");
        //Data intent update
        String titleUpdate = getIntent().getStringExtra("titleEdit");
        String titleBtnUp = getIntent().getStringExtra("titleBtnEdit");

        if (titleUpdate == null) {
            tvTitle.setText(titleAdd);
            btnNewAndEdit.setText(titleBtnAdd);
        } else {
            tvTitle.setText(titleUpdate);
            btnNewAndEdit.setText(titleBtnUp);
        }

        //set onClick nut back
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewCreateAndAddActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void Spinner() {

        listSize.add("S");
        listSize.add("M");
        listSize.add("L");
        listSize.add("XL");
        listSize.add("XXL");

        adapterSp =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSize);
        spSize.setAdapter(adapterSp);

    }
}