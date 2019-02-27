package ca.concordia.secure.sesession.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.concordia.secure.sesession.models.SecureSession;

public interface SecureSessionRepository extends JpaRepository<SecureSession, Long>{

}
