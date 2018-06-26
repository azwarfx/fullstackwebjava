package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="DANABANTUAN")
@Data
public class DanaBantuan
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String hargaPotongan;
  private int nominal;

}
