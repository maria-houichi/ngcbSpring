package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.ChatMessage;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.service.ChatMessageService;

@RestController
@RequestMapping("message")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatMessageResource {
	private final ChatMessageService chatMessageService;

	public ChatMessageResource(ChatMessageService chatMessageService) {
		this.chatMessageService = chatMessageService;
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/all")
	public ResponseEntity<List<ChatMessage>> getAllMessages(){
		List<ChatMessage> messages =chatMessageService.findAllMessages();
		return new ResponseEntity<>(messages, HttpStatus.OK);
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/add")
	public ResponseEntity<ChatMessage> addMessage(@RequestBody ChatMessage chatMessage){
		ChatMessage newMessage= chatMessageService.addMessage(chatMessage);
		return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
		
	} 

}
