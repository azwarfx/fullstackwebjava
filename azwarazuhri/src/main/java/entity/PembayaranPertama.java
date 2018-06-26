package entity;
import java.util.Date;
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
@Table(name="PEMBAYARANPERTAMA")
public class PembayaranPertama
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name="PAKET")
  private Paket paket;

  @ManyToOne
  @JoinColumn(name="CALONJAMAAH")
  private CalonJamaah calonJamaah;

  @ManyToOne
  @JoinColumn(name="JADWALKEBERANGKATAN")
  private JadwalKeberangkatan jadwalKeberangkatan;
  private int uangDp;
  private String namaJamaah;
  private String namaPaket;
  private Date tglBerangkat;

}
