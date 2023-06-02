package ngcb.app.ngcb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ngcb.app.ngcb.model.ChatMessage;
import ngcb.app.ngcb.model.signataire;


public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long> {
	List<ChatMessage> findAllByVuTrue();
}
