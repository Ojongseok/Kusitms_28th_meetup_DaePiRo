package com.daepiro.numberoneproject.data.network

import com.daepiro.numberoneproject.data.model.CommunityTownListModel
import com.daepiro.numberoneproject.data.model.DisasterRequestBody
import com.daepiro.numberoneproject.data.model.DisasterResponse
import com.daepiro.numberoneproject.data.model.FundingDetailResponse
import com.daepiro.numberoneproject.data.model.FundingListResponse
import com.daepiro.numberoneproject.data.model.LoginTestResponse
import com.daepiro.numberoneproject.data.model.LoginTokenResponse
import com.daepiro.numberoneproject.data.model.ShelterData
import com.daepiro.numberoneproject.data.model.ShelterListResponse
import com.daepiro.numberoneproject.data.model.ShelterRequestBody
import com.daepiro.numberoneproject.data.model.TokenRequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // 만료된 AccessToken 갱신
    @POST("/token/refresh")
    suspend fun refreshAccessToken(
        @Body body: TokenRequestBody
    ): ApiResult<LoginTokenResponse>

    // 네이버 로그인
    @POST("/token/naver")
    suspend fun userNaverLogin(
        @Body body: TokenRequestBody
    ): ApiResult<LoginTokenResponse>

    //카카오 로그인
    @POST("/token/kakao")
    suspend fun userKakaoLogin(
        @Body body: TokenRequestBody
    ): ApiResult<LoginTokenResponse>

    // 로그인 테스트
    @GET("/api/logintest")
    suspend fun apiLoginTest(
        @Header("Authorization") token: String
    ): ApiResult<LoginTestResponse>

    // 가까운 대피소 목록 조회
    @POST("/api/shelters/list")
    suspend fun getAroundSheltersList(
        @Header("Authorization") token: String,
        @Body body: ShelterRequestBody
    ): ApiResult<ShelterListResponse>

    // 최근 재난문자 조회
    @POST("/api/disaster/latest")
    suspend fun getDisasterMessage(
        @Header("Authorization") token: String,
        @Body body: DisasterRequestBody
    ): ApiResult<DisasterResponse>

    //대피소 전체 데이터 가진 링크 가져오기
    @GET("/api/admin/address-info")
    suspend fun getShelters(
        @Header("Authorization") token:String
    ): ApiResult<List<ShelterData>>

//    //대피소 url로부터 파싱
//    @GET
//    suspend fun getDataFromUrl(
//        @Url url:String
//    ):ApiResult<List<ShelterData>>

    // 후원 목록 최신순 조회
    @GET("/api/sponsor/latest")
    suspend fun getFundingListByLatest(
        @Header("Authorization") token:String
    ): ApiResult<FundingListResponse>

    // 후원 목록 인기순 조회
    @GET("/api/sponsor/popular")
    suspend fun getFundingListByPopular(
        @Header("Authorization") token:String
    ): ApiResult<FundingListResponse>

    // 후원 상세정보 조회
    @GET("/api/sponsor/{sponsorId}")
    suspend fun getFundingDetail(
        @Header("Authorization") token:String,
        @Path("sponsorId") sponsorId: Int
    ): ApiResult<FundingDetailResponse>

    //커뮤니티 동네생활 게시글 리스트 조회
    @GET("/api/articles")
    suspend fun getTownCommentList(
        @Header("Authorization") token:String,
        @Query("size") size:Int,
        @Query("tag") tag:String?,
        @Query("lastArticleId") lastArticleId:Int?
    ):ApiResult<CommunityTownListModel>
}