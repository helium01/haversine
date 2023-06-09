package com.opencv.bank_sampah.app

import com.opencv.bank_sampah.model.request.outliteRequest
import com.opencv.bank_sampah.model.request.registerRequest
import com.opencv.bank_sampah.model.request.riwayatRequest
import com.opencv.bank_sampah.model.request.sedekahRequest
import com.opencv.bank_sampah.model.request.userRequest
import com.opencv.bank_sampah.model.response.jemputResponse
import com.opencv.bank_sampah.model.response.outliteResponse
import com.opencv.bank_sampah.model.response.riwayatResponse
import com.opencv.bank_sampah.model.response.sedekahResponse
import com.opencv.bank_sampah.model.response.userResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("login")
    fun login(
        @Body request: userRequest
    ): Call<userResponse>

    @Headers("Content-Type: application/json")
    @POST("register")
    fun register(
        @Body request: registerRequest
    ): Call<userResponse>

    @Headers("Content-Type: application/json")
    @POST("sedekah")
    fun sedekah(
        @Body request: sedekahRequest
    ): Call<sedekahResponse>

    @Headers("Content-Type: application/json")
    @POST("jemput")
    fun jemput(
        @Body request: sedekahRequest
    ): Call<jemputResponse>

    @Headers("Content-Type: application/json")
    @GET("outlite")
    fun outlite(
    ): Call<outliteResponse>

    @Headers("Content-Type: application/json")
    @POST("outlite")
    fun outlite(
        @Body request: outliteRequest
    ): Call<outliteResponse>

    @Headers("Content-Type: application/json")
    @GET("sedekahs/valid/{id}")
    fun sedekahValid(
        @Path("id") id: String
    ): Call<sedekahResponse>

    @Headers("Content-Type: application/json")
    @GET("sedekahs/segera/{id}")
    fun sedekahSegera(
        @Path("id") id: String
    ): Call<sedekahResponse>

    @Headers("Content-Type: application/json")
    @GET("jemputs/valid/{id}")
    fun jemputValid(
        @Path("id") id: String
    ): Call<sedekahResponse>

    @Headers("Content-Type: application/json")
    @GET("jrmput/segera/{id}")
    fun jemputSegera(
        @Path("id") id: String
    ): Call<sedekahResponse>

    @Headers("Content-Type: application/json")
    @POST("riwayats")
    fun riwayat(
        @Body request: riwayatRequest
    ): Call<riwayatResponse>

    @Headers("Content-Type: application/json")
    @GET("pencairan/{id}")
    fun pencairan(
        @Path("id") id: String
    ): Call<riwayatResponse>

    @Headers("Content-Type: application/json")
    @GET("pencairan/valid/{id}")
    fun pencairanValid(
        @Path("id") id: String
    ): Call<riwayatResponse>

    @Headers("Content-Type: application/json")
    @GET("lihat/user")
    fun lihatUser(
    ): Call<userResponse>

    @Headers("Content-Type: application/json")
    @GET("ganti/user/role/{id}")
    fun gantiUser(
        @Path("id") id: String
    ): Call<userResponse>

    @Headers("Content-Type: application/json")
    @GET("index/belum/valid")
    fun indexBelumValid(
    ): Call<userResponse>

    @Headers("Content-Type: application/json")
    @GET("index/sudah/valid/{id}")
    fun indexSudahValid(
        @Path("id") id: String
    ): Call<userResponse>

}