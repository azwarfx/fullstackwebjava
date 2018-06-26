package vo;

import entity.CalonJamaah;
import entity.JadwalKeberangkatan;
import entity.Paket;
import entity.PembayaranPertama;

import java.util.Date;
import lombok.Data;
@Data
public class PembayaranPertamaVO extends BaseVO
{
  private Paket paket;
  private CalonJamaah calonJamaah;
  private JadwalKeberangkatan jadwalKeberangkatan;
  private int uangDp;
  private String namaJamaah;
  private String namaPaket;
  private Date tglBerangkat;

}
