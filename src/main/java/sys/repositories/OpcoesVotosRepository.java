package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sys.domain.OpcoesVotos;

@Repository
public interface OpcoesVotosRepository extends JpaRepository<OpcoesVotos, Integer> {
}
