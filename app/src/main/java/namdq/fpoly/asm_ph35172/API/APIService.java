package namdq.fpoly.asm_ph35172.API;

import java.util.List;

import namdq.fpoly.asm_ph35172.DTO.ShoeDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {


    String DOMAIN = "http://192.168.1.15:3000";

    @GET("/api/get-list-shoe")
    Call<List<ShoeDTO>> getShoe();


    @POST("/api/post-shoe")
    Call<ShoeDTO> createShoe(@Body ShoeDTO shoe);

    @PUT("/api/update-shoe-by-id/{id}")
    Call<ShoeDTO> updateShoe(@Path("id") String id, @Body ShoeDTO shoe);

    @DELETE("/api/delete-shoe-by-id/{id}")
    Call<ShoeDTO> deleteShoe(@Path("id") String id);

}
