package ca.concordia.secure.sesession.models;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class SecureSession {

  public SecureSession(final byte[] privateKey, final byte[] publicKey, final Timestamp timeStamp) {
    this.privateKey = privateKey;
    this.publicKey = publicKey;
    this.timeStamp = timeStamp;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private byte[] privateKey;
  private byte[] publicKey;
  private Timestamp timeStamp;

}
