package org.suhas.restful.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.suhas.restful.database.Database;
import org.suhas.restful.model.Comment;
import org.suhas.restful.model.Message;

public class CommentService {

	private Map<Long, Message> messages = Database.getMessage();

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		System.out.println("grand");
		return new ArrayList<>(comments.values());
	}

	public Comment getCommentById(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;

	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;

	}

	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
