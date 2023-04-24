package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.agence;
import ngcb.app.ngcb.repo.agenceRepo;


@Service
@Transactional
public class agenceService {
	private final agenceRepo AgenceRepo;
	public agenceService(agenceRepo AgencenRepo) {
		this.AgenceRepo=AgencenRepo;
	}
	
	public  List<agence> findAllAgences(){
		return AgenceRepo.findAll();}
	
	public agence addAgence (agence agence) {
		
		return AgenceRepo.save(agence);} 

}
