package ca.concordia.secure.sesession.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "secure_session_key")
@Data
public class SecureSessionKey {

  public SecureSessionKey(final byte[] privateKey, final byte[] publicKey, final Timestamp sessionTime) {
    this.privateKey = privateKey;
    this.publicKey = publicKey;
    this.sessionTime = sessionTime;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "private_key", nullable = false)
  private byte[] privateKey;
  @Column(name = "public_key", nullable = false)
  private byte[] publicKey;
  @Column(name = "session_time", nullable = false)
  private Timestamp sessionTime;

}
