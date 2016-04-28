package org.suhas.restful.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.suhas.restful.model.Comment;
import org.suhas.restful.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService cServ = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long msgId) {
		return cServ.getAllComments(msgId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComById(@PathParam("messageId") long msgId, @PathParam("commentId") long cId){
		return cServ.getCommentById(msgId, cId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long msgId, Comment comment){
		System.out.println("my man");
		return cServ.addComment(msgId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long msgId, @PathParam("commentId") long cId, Comment comment){
		comment.setId(cId);
		return cServ.updateComment(msgId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long msgId, @PathParam("commentId") long cId){
		cServ.removeComment(msgId, cId);
	}
	
	

}
