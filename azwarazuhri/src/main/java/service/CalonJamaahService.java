package service;

import entity.CalonJamaah;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CalonJamaahRepository;
import vo.CalonJamaahVO;

@Service
public class CalonJamaahService {

	@Autowired
	CalonJamaahRepository calonJamaahRepository;
//	private List<CalonJamaahVO> calonJamaahVOs;

	public Boolean simpanCalonJamaah(CalonJamaahVO calonJamaahVO) {
		CalonJamaah calonJamaah = new CalonJamaah();
		calonJamaah.setNamaJamaah(calonJamaahVO.getNamaJamaah());
		calonJamaah.setBinti(calonJamaahVO.getBinti());
		calonJamaah.setPengalamanHaji(calonJamaahVO.getPengalamanHaji());
		calonJamaah.setThnTerakhir(calonJamaahVO.getThnTerakhir());
		calonJamaah.setNoPaspor(calonJamaahVO.getNoPaspor());
		calonJamaah.setAlamat(calonJamaahVO.getAlamat());
		calonJamaah.setNoTlp(calonJamaahVO.getNoTlp());
		calonJamaahRepository.save(calonJamaah);
		return true;
	}

	public Boolean updateCaloonJamaah(CalonJamaahVO vo) {
		CalonJamaah calonJamaah = calonJamaahRepository.findById(vo.getId());
		calonJamaah.setNamaJamaah(vo.getNamaJamaah());
		calonJamaah.setBinti(vo.getBinti());
		calonJamaah.setPengalamanHaji(vo.getPengalamanHaji());
		calonJamaah.setThnTerakhir(vo.getThnTerakhir());
		calonJamaah.setNoPaspor(vo.getNoPaspor());
		calonJamaah.setAlamat(vo.getAlamat());
		calonJamaah.setNoTlp(vo.getNoTlp());
		calonJamaahRepository.save(calonJamaah);
		return true;
	}

	public List<CalonJamaahVO> getAll() {
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
		return calonJamaahVOs;
	}

	public CalonJamaahVO getDetail(Long id) {
		CalonJamaah calonJamaah = calonJamaahRepository.findById(id);
		CalonJamaahVO vo = new CalonJamaahVO();
		vo.setId(calonJamaah.getId());
		vo.setNamaJamaah(calonJamaah.getNamaJamaah());
		vo.setBinti(calonJamaah.getBinti());
		vo.setPengalamanHaji(calonJamaah.getPengalamanHaji());
		vo.setThnTerakhir(calonJamaah.getThnTerakhir());
		vo.setNoPaspor(calonJamaah.getNoPaspor());
		vo.setAlamat(calonJamaah.getAlamat());
		vo.setNoTlp(calonJamaah.getNoTlp());
		return vo;
	}

	public CalonJamaahVO listCalonJamaah(Long id) {
		CalonJamaah calonJamaah = calonJamaahRepository.findById(id);
		CalonJamaahVO vo = new CalonJamaahVO();
		vo.setId(calonJamaah.getId());
		return vo;
	}

	public Boolean deleteCalonJmaah(Long id) {
		CalonJamaah calonJamaah = calonJamaahRepository.findById(id);
		calonJamaahRepository.delete(calonJamaah);
		return true;
	}
}
