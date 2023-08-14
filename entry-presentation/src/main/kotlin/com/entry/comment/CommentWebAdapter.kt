package com.entry.comment

import com.entry.comment.dto.request.CommentRequest
import com.entry.comment.dto.request.CommentWebRequest
import com.entry.comment.port.`in`.SaveCommentUseCase
import com.entry.common.WebAdapter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/comment")
@RestController
@WebAdapter
class CommentWebAdapter(
    private val saveCommentUseCase: SaveCommentUseCase
) {

    @PostMapping("/{feedId}")
    fun saveComment(
        @RequestBody commentWebRequest: CommentWebRequest,
        @PathVariable feedId: UUID
    ){

        saveCommentUseCase.saveComment(
            CommentRequest(
                commentWebRequest.content
            ), feedId
        )
    }

}