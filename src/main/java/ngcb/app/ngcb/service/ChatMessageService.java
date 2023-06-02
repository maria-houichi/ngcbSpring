package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.ChatMessage;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.repo.ChatMessageRepo;
@Service
@Transactional
public class ChatMessageService {
	private ChatMessageRepo chatMessageRepo ;

	public ChatMessageService(ChatMessageRepo chatMessageRepo) {
		this.chatMessageRepo = chatMessageRepo;
	}
	
	
public  List<ChatMessage> findAllMessages(){
		
		return chatMessageRepo.findAllByVuTrue();
		 }

public ChatMessage addMessage (ChatMessage chatMessage ) {
	return chatMessageRepo.save(chatMessage );} 

}
