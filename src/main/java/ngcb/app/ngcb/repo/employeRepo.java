/**
 * 
 */
package ngcb.app.ngcb.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ngcb.app.ngcb.model.employe;



/**
 * @author Sos
 *
 */
public interface employeRepo extends JpaRepository<employe,String> {
void deleteEmployeByMatricule(String matricule);
Optional <employe> findEmployeByMatricule(String matricule);

}
