package tesdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.CalonJamaah;
import repo.CalonJamaahRepository;
import vo.CalonJamaahVO;

public class Latihan {
	@Autowired
	CalonJamaahRepository calonJamaahRepository;
	private ApplicationContext ctx;

	public static void main(String[] args) {
//		DataNasabahDao kardao = (DataNasabahDao)ctx.getBean(DataNasabahDao.class);
		Latihan latihan = new Latihan();
		latihan.getAll();
		List<CalonJamaah>calonJamaahs= latihan.getAll();
		for(CalonJamaah calonJamaah:calonJamaahs) {
			System.out.println(calonJamaah.getNamaJamaah());
			
		}
	}

	public List<CalonJamaah> getAll() {
		ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		CalonJamaahRepository calonJamaahRepository = (CalonJamaahRepository)ctx.getBean(CalonJamaahRepository.class);
		List<CalonJamaah> calonJamaahs = calonJamaahRepository.findAll();
		List<CalonJamaahVO> calonJamaahVOs = new ArrayList<>();
		for (CalonJamaah calonJamaah : calonJamaahs) {
			CalonJamaahVO vo = new CalonJamaahVO();
			vo.setId(calonJamaah.getId());
			vo.setNamaJamaah(calonJamaah.getNamaJamaah());
			vo.setBinti(calonJamaah.getBinti());
			vo.setPengalamanHaji(calonJamaah.getPengalamanHaji());
			vo.setThnTerakhir(calonJamaah.getThnTerakhir());
			vo.setNoPaspor(calonJamaah.getNoPaspor());
			vo.setAlamat(calonJamaah.getAlamat());
			vo.setNoTlp(calonJamaah.getNoTlp());
			calonJamaahVOs.add(vo);
		}
		return calonJamaahs;
	};
}
