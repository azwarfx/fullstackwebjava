package entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DOKUMEN")
public class Dokumen
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name="CALONJAMAAH")
  private CalonJamaah calonJamaah;
  private String paspor;
  private String ktp;
  private String kartuKeluarga;
  private String suratNikah;
  private String akte;
  private String kartuManingitis;
  private String namaJamaah;
  private String keterangan;


}
