package ca.concordia.secure.sesession.services;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.concordia.secure.sesession.models.SecureSessionKey;
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
  public SecureSessionKey generateSecureSession(int keySize) throws NoSuchAlgorithmException {
    KeyPair rsaKeypair = RSAUtils.buildRSAeyPair(keySize);
    return secureSessionRepository.save(new SecureSessionKey(rsaKeypair.getPrivate().getEncoded(),
          rsaKeypair.getPublic().getEncoded(), new Timestamp(new Date().getTime())));
  }

}
