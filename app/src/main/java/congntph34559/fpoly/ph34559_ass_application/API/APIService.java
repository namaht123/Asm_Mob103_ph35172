package congntph34559.fpoly.ph34559_ass_application.API;

import java.util.List;

import congntph34559.fpoly.ph34559_ass_application.DTO.ShoeDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {


    String DOMAIN = "http://192.168.1.161:3000";

    @GET("/api/get-list-shoe")
    Call<List<ShoeDTO>> getShoe();

    @POST("/api/post-shoe")
    Call<ShoeDTO> createShoe(@Body ShoeDTO shoe);


}
