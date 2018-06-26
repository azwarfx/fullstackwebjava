package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="JADWALKEBERANGKATAN")
public class JadwalKeberangkatan
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long id;
  private String namaKloter;
  private String kbih;
  private String pembimbing;
  private Date keberangkatan;
  private Date kepulangan;

}
