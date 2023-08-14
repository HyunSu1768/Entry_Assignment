package com.entry.comment.port.out

import com.entry.comment.model.Comment

interface SaveCommentPort {

    fun saveComment(comment: Comment)
}