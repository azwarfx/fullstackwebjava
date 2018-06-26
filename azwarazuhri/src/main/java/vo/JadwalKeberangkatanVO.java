package vo;

import java.util.Date;
import lombok.Data;
@Data
public class JadwalKeberangkatanVO extends BaseVO
{
  private String namaKloter;
  private String kbih;
  private String pembimbing;
  private Date keberangkatan;
  private Date kepulangan;

}
