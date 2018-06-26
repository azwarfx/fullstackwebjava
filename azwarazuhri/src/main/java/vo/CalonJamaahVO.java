package vo;

import java.util.Date;

import lombok.Data;

@Data
public class CalonJamaahVO {
	private Long id;
	private String namaJamaah;
	private String binti;
	private String pengalamanHaji;
	private Date thnTerakhir;
	private String noPaspor;
	private String alamat;
	private String noTlp;
}
