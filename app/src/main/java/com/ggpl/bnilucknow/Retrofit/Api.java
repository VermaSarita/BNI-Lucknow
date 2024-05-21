package com.ggpl.bnilucknow.Retrofit;
import com.ggpl.bnilucknow.AllChapterModel;
import com.ggpl.bnilucknow.Model.Chapter.categoeryModel;
import com.ggpl.bnilucknow.Model.Login.RequestLogin;
import com.ggpl.bnilucknow.Model.Login.ResponseLogin;
import com.ggpl.bnilucknow.Model.MasterModel.ApexMember;
import com.ggpl.bnilucknow.Model.MasterModel.EmeraldModel;
import com.ggpl.bnilucknow.Model.MasterModel.MaestrosModel;
import com.ggpl.bnilucknow.Model.MasterModel.MavericksModel;
import com.ggpl.bnilucknow.Model.MasterModel.PrimePrime;
import com.ggpl.bnilucknow.Model.MasterModel.ProsperityModel;
import com.ggpl.bnilucknow.Model.MasterModel.masterMember;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface Api {

    @GET("api/Chapter")
    Call<List<AllChapterModel>> getData();

    @POST("api/Login/UserLogin")
    Call<List<categoeryModel>> getCategoery();


    @POST("api/Login/UserList")
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);

    @GET("api/MAster")
    Call<List<masterMember>> getMasters();

    @GET("api/Apex")
    Call<List<ApexMember>> getAppData();

    @GET("api/Mavericks")
    Call<List<MavericksModel>> getMeveriksdata();

    @GET("api/Prime")
    Call<List<PrimePrime>> getPrimeData();

    @GET("api/Emerald")
    Call<List<EmeraldModel>> getEmeraldData();

    @GET("api/Prosperity")
    Call<List<ProsperityModel>> getProsperityData();

    @GET("api/Maestros")
    Call<List<MaestrosModel>> getMaestrosData();









}
