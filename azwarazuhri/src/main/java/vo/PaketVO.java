package vo;

import java.util.Date;

import entity.DanaBantuan;
import lombok.Data;
@Data
public class PaketVO extends BaseVO
{
  private DanaBantuan danaBantuan;
  private String jenisPaket;
  private String namaPaket;
  private String rute;
  private String namaHotel;
  private String isiKamar;
  private String harga;
  private String namaBantuan;

}
