package ngcb.app.ngcb.service;
import java.util.List;


import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.employeNotFoundException;
import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.repo.employeRepo;



@Service
@Transactional
public class employeService {

private final employeRepo EmployeRepo;

public employeService(employeRepo EmployeRepo) {
	this.EmployeRepo=EmployeRepo;
}
public employe addEmploye (employe employe) {
	
		return EmployeRepo.save(employe);} 

public  List<employe> findAllEmployes(){
	return EmployeRepo.findAll();}

public employe updateEmploye(employe employe) {
	return EmployeRepo.save(employe);
}

public employe findEmployeByMatricule(String matricule ) {
	return EmployeRepo.findEmployeByMatricule(matricule)
			.orElseThrow(()-> new employeNotFoundException("employe by id "+matricule+"was not found "));
}

public void deleteEmploye (String matricule) {
	EmployeRepo.deleteEmployeByMatricule(matricule);
}
 



}