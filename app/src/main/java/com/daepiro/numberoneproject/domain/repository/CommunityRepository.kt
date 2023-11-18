package com.daepiro.numberoneproject.domain.repository

import com.daepiro.numberoneproject.data.model.CommentWritingRequestBody
import com.daepiro.numberoneproject.data.model.CommentWritingResponse
import com.daepiro.numberoneproject.data.model.CommunityRereplyRequestBody
import com.daepiro.numberoneproject.data.model.CommunityTownDeleteCommentResponse
import com.daepiro.numberoneproject.data.model.CommunityTownDetailData
import com.daepiro.numberoneproject.data.model.CommunityTownListModel
import com.daepiro.numberoneproject.data.model.CommunityTownReplyRequestBody
import com.daepiro.numberoneproject.data.model.CommunityTownReplyResponse
import com.daepiro.numberoneproject.data.model.CommunityTownReplyResponseModel
import com.daepiro.numberoneproject.data.network.ApiResult
import okhttp3.MultipartBody

interface CommunityRepository {
    suspend fun getTownCommentList(token:String,size:Int,tag:String?,lastArticleId:Int?):ApiResult<CommunityTownListModel>
    suspend fun getTownCommentDetail(token:String,articleId:Int):ApiResult<CommunityTownDetailData>
    suspend fun setTownDetail(
        token:String,
        title:String,
        content:String,
        articleTag:String,
        longtitude:Double,
        latitude:Double,
        imageList: List<MultipartBody.Part>
        ):ApiResult<CommentWritingResponse>

    suspend fun getTownReply(token:String, articleId:Int) : ApiResult<CommunityTownReplyResponse>

    suspend fun setTownReply(token:String,articleId: Int, body: CommunityTownReplyRequestBody):ApiResult<CommunityTownReplyResponseModel>
    suspend fun setTownRereply(token:String, articleId: Int, commentid:Long, body: CommunityRereplyRequestBody):ApiResult<CommunityTownReplyResponseModel>
    suspend fun deleteComment(token:String,articleId: Int):ApiResult<CommunityTownDeleteCommentResponse>
}