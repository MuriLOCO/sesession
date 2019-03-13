package ca.concordia.secure.sesession.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.concordia.secure.sesession.models.SecureSessionKey;

public interface SecureSessionRepository extends JpaRepository<SecureSessionKey, Long>{

}
