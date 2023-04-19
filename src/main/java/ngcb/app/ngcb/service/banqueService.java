package ngcb.app.ngcb.service;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.banque;
import ngcb.app.ngcb.repo.banqueRepo;


@Service
@Transactional
public class banqueService {
	
private final banqueRepo BanqueRepo;
	
	public banqueService(banqueRepo BanqueRepo) {
		this.BanqueRepo=BanqueRepo;
	}
	
	public  List<banque> findAllBanques(){
		return BanqueRepo.findAll();}
	
	public banque addBanque (banque banque) {
		
		return BanqueRepo.save(banque);} 

}
