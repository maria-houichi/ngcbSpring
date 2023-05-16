package ngcb.app.ngcb.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.delegation;
import ngcb.app.ngcb.model.pk_deleg;

public interface delegRepo   extends JpaRepository<delegation,pk_deleg > {

}
