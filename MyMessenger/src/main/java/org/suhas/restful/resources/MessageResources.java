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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.suhas.restful.model.Message;
import org.suhas.restful.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService msgServ = new MessageService();

	@GET
	public List<Message> getMessage(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {

		if (year > 0) {
			return msgServ.getAllMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return msgServ.getAllMessagesPaginated(start, size);
		} else {
			System.out.println("suhas");
			return msgServ.getAllMessages();
		}
	}

	@GET
	@Path("/{messageId}")
	public Message getMessageById(@PathParam("messageId") long messageId) {
		return msgServ.getMessage(messageId);
	}

	@POST
	public Message addMessage(Message msg) {
		return msgServ.addMessage(msg);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message msg) {
		msg.setId(messageId);
		return msgServ.updateMessage(msg);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		msgServ.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getComments() {
		return new CommentResource();
	}
}
