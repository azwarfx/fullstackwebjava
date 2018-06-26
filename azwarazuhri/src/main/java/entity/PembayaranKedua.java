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
@Table(name="PEMBAYANKEDUA")
public class PembayaranKedua
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long id;

  @ManyToOne
  @JoinColumn(name="PEMBAYARANPERTAMA")
  private PembayaranPertama pembayaranPertama;
  private int pelunasan;
  private Date tglPelunasan;
  private Date tglBatasPelunasan;

}
