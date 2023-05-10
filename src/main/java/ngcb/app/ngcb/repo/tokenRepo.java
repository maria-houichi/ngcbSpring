package ngcb.app.ngcb.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ngcb.app.ngcb.model.token;

public interface tokenRepo extends JpaRepository<token, Integer> {
	@Query(value = """
		      select t from token t inner join user u\s
		      on t.user.matricule = u.matricule\s
		      where u.matricule = :id and (t.expired = false or t.revoked = false)\s
		      """)
	  List<token> findAllValidTokenByUser(Integer id);
		 Optional<token> findByToken(String token);
}
	