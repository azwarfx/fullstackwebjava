package service;

import entity.DanaBantuan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.DanaBantuanRepository;
import vo.DanaBantuanVO;

@Service
public class DanaBantuanService {

	@Autowired
	DanaBantuanRepository danaBantuanRepository;

	public List<DanaBantuanVO> getAll() {
		List<DanaBantuan> bantuanList = danaBantuanRepository.findAll();
		List<DanaBantuanVO> danaBantuanVOs = new ArrayList<>();
		for (DanaBantuan bantuan : bantuanList) {
			DanaBantuanVO bantuanVO = new DanaBantuanVO();
			bantuanVO.setId(bantuan.getId());
			bantuanVO.setHargaPotongan(bantuan.getHargaPotongan());
			bantuanVO.setNominal(bantuan.getNominal());
			danaBantuanVOs.add(bantuanVO);
		}
		return danaBantuanVOs;
	}

	public Boolean simpan(DanaBantuanVO vo) {
		DanaBantuan danaBantuan = new DanaBantuan();
		danaBantuan.setHargaPotongan(vo.getHargaPotongan());
		danaBantuan.setNominal(vo.getNominal());
		danaBantuanRepository.save(danaBantuan);
		return true;
	}

	public Boolean ubah(DanaBantuanVO vo) {
		DanaBantuan danaBantuan = this.danaBantuanRepository.findById(vo.getId());
		danaBantuan.setHargaPotongan(vo.getHargaPotongan());
		danaBantuan.setNominal(vo.getNominal());
		danaBantuanRepository.save(danaBantuan);
		return true;
	}

	public DanaBantuanVO getDetail(Long id) {
		DanaBantuan danaBantuan = danaBantuanRepository.findById(id);
		DanaBantuanVO vo = new DanaBantuanVO();
		vo.setHargaPotongan(danaBantuan.getHargaPotongan());
		vo.setNominal(danaBantuan.getNominal());
		return vo;
	}

	public Boolean hapus(Long id) {
		DanaBantuan danaBantuan = danaBantuanRepository.findById(id);
		this.danaBantuanRepository.delete(danaBantuan);
		return true;
	}
}
