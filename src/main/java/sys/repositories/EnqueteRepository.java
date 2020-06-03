package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sys.domain.Enquete;

@Repository
public interface EnqueteRepository extends JpaRepository<Enquete, String> {
}
