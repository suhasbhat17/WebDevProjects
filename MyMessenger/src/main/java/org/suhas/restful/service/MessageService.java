package org.suhas.restful.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.suhas.restful.database.Database;
import org.suhas.restful.model.Message;

public class MessageService {

	
	private Map<Long, Message> messages = Database.getMessage();
	
	public MessageService(){
		/*messages.put(1L, new Message(1,"hello janeman","sos") );
		messages.put(2L, new Message(2,"hello janu","chumz") );*/
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> list = new ArrayList<>(messages.values());
		if(start+size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}

	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}

	public Message updateMessage(Message msg) {
		if (msg.getId() <= 0) {
			return null;

		} else {
			messages.put(msg.getId(), msg);
		}
		return msg;
	}

	public Message removeMessage(Long id) {
		return messages.remove(id);

	}
}
