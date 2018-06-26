package vo;

import entity.CalonJamaah;
import lombok.Data;
@Data
public class DokumenVO extends BaseVO
{
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
