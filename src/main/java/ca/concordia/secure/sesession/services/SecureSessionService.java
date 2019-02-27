package ca.concordia.secure.sesession.services;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.concordia.secure.sesession.models.SecureSession;
import ca.concordia.secure.sesession.repositories.SecureSessionRepository;
import ca.concordia.secure.sesession.utils.RSAUtils;

@Service
public class SecureSessionService {

  private final SecureSessionRepository secureSessionRepository;

  @Autowired
  public SecureSessionService(final SecureSessionRepository secureSessionRepository) {
    this.secureSessionRepository = secureSessionRepository;
  }

  /**
   * Generates and saves a secure session
   * @param keySize
   * @return
   * @throws NoSuchAlgorithmException
   */
  public SecureSession generateSecureSession(final int keySize) throws NoSuchAlgorithmException {
    final KeyPair rsaKeypair = RSAUtils.buildRSAeyPair(keySize);
    return secureSessionRepository.save(new SecureSession(rsaKeypair.getPrivate().getEncoded(),
          rsaKeypair.getPublic().getEncoded(), new Timestamp(new Date().getTime())));
  }

}
