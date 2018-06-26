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
@Table(name="PAKET")
public class Paket
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long id;

  @ManyToOne
  @JoinColumn(name="DANABANTUAN")
  private DanaBantuan danaBantuan;
  private String jenisPaket;
  private String namaPaket;
  private String rute;
  private String namaHotel;
  private String isiKamar;
  private String harga;
  private String namaBantuan;

}
