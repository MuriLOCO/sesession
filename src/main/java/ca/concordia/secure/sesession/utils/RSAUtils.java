package ca.concordia.secure.sesession.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSAUtils {

  /**
   * Generates the key pair of RSA
   * @param keySize
   * @return
   * @throws NoSuchAlgorithmException
   */
  public static KeyPair buildRSAeyPair(final int keySize) throws NoSuchAlgorithmException {        
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(keySize);      
    return keyPairGenerator.genKeyPair();
}
  
}
