package vo;

import entity.DanaBantuan;
import entity.PembayaranPertama;
import java.util.Date;
import lombok.Data;
@Data
public class PembayaranKeduaVO extends BaseVO
{
  private PembayaranPertama pembayaranPertama;
  private int pelunasan;
  private Date tglPelunasan;
  private Date tglBatasPelunasan;

}
