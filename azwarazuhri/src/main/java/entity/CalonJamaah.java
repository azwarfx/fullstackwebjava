package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CALONJAMAAH")
@Data
public class CalonJamaah {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String namaJamaah;
	private String binti;
	private String pengalamanHaji;
	private Date thnTerakhir;
	private String noPaspor;
	private String alamat;
	private String noTlp;

}
