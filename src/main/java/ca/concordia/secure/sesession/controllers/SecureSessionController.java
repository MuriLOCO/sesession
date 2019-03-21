package ca.concordia.secure.sesession.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.concordia.secure.sesession.models.SecureSessionKey;
import ca.concordia.secure.sesession.services.SecureSessionService;

@RestController
public class SecureSessionController {

  private final SecureSessionService secureSessionService;
  
  @Autowired
  public SecureSessionController(SecureSessionService secureSessionService) {
   this.secureSessionService = secureSessionService;
  }
  
  @RequestMapping("/generate")  
  public SecureSessionKey generate(@RequestParam(required = true) int keySize) throws NoSuchAlgorithmException{    
    return secureSessionService.generateSecureSession(keySize);
  }  
}
