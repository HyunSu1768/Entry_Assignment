package com.entry.comment.dto.response

import com.entry.comment.model.Comment


data class CommentResponse(

    val userName: String,

    val content: String
){

    companion object {

        fun of(comment: Comment): CommentResponse{

            return CommentResponse(
                comment.user.nickname,
                comment.content
            )
        }
    }
}