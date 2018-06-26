package service;

import entity.Dokumen;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CalonJamaahRepository;
import repo.DokumenRepository;
import vo.DokumenVO;

@Service
public class DokumenService {

	@Autowired
	DokumenRepository dokumenRepository;

	@Autowired
	CalonJamaahRepository calonJamaahRepository;

	public Boolean simpanDokumen(DokumenVO vo) {
		Dokumen dokumen = new Dokumen();
		dokumen.setAkte(vo.getAkte());
		dokumen.setKartuKeluarga(vo.getKartuKeluarga());
		dokumen.setKartuManingitis(vo.getKartuManingitis());
		dokumen.setKeterangan(vo.getKeterangan());
		dokumen.setKtp(vo.getKtp());

		dokumen.setNamaJamaah(vo.getNamaJamaah());
		dokumen.setPaspor(vo.getPaspor());
		dokumen.setSuratNikah(vo.getSuratNikah());
		dokumen.setCalonJamaah(vo.getCalonJamaah());
		dokumenRepository.save(dokumen);
		return Boolean.valueOf(true);
	}

	public Boolean updateDokumen(DokumenVO vo) {
		Dokumen dokumen = dokumenRepository.findById(vo.getId());
		dokumen.setAkte(vo.getAkte());
		dokumen.setKartuKeluarga(vo.getKartuKeluarga());
		dokumen.setKartuManingitis(vo.getKartuManingitis());
		dokumen.setKeterangan(vo.getKeterangan());
		dokumen.setKtp(vo.getKtp());

		dokumen.setNamaJamaah(vo.getNamaJamaah());
		dokumen.setPaspor(vo.getPaspor());
		dokumen.setSuratNikah(vo.getSuratNikah());
		dokumen.setCalonJamaah(vo.getCalonJamaah());
		dokumenRepository.save(dokumen);
		return true;
	}

	public List<DokumenVO> getAll() {
		List<Dokumen> dokumens = dokumenRepository.findAll();
		List<DokumenVO> dokumenVOs = new ArrayList<>();
		for (Dokumen dokumen : dokumens) {
			DokumenVO vo = new DokumenVO();
			vo.setId(dokumen.getId());
			vo.setAkte(dokumen.getAkte());
			vo.setKartuKeluarga(dokumen.getKartuKeluarga());
			vo.setKartuManingitis(dokumen.getKartuManingitis());
			vo.setKeterangan(dokumen.getKeterangan());
			vo.setKtp(dokumen.getKtp());

			vo.setNamaJamaah(dokumen.getNamaJamaah());
			vo.setPaspor(dokumen.getPaspor());
			vo.setSuratNikah(dokumen.getSuratNikah());
			vo.setCalonJamaah(vo.getCalonJamaah());
			dokumenVOs.add(vo);
		}
		return dokumenVOs;
	}

	public DokumenVO getDetail(Long id) {
		Dokumen dokumen = dokumenRepository.findById(id);
		DokumenVO vo = new DokumenVO();
		vo.setId(dokumen.getId());
		vo.setAkte(dokumen.getAkte());
		vo.setKartuManingitis(dokumen.getKartuManingitis());
		vo.setKartuKeluarga(dokumen.getKartuKeluarga());
		vo.setKeterangan(dokumen.getKeterangan());
		vo.setKtp(dokumen.getKtp());

		vo.setNamaJamaah(dokumen.getNamaJamaah());
		vo.setPaspor(dokumen.getPaspor());
		vo.setSuratNikah(dokumen.getSuratNikah());
		vo.setCalonJamaah(vo.getCalonJamaah());
		return vo;
	}

	public Boolean deleteDokumen(Long id) {
		Dokumen dokumen = dokumenRepository.findById(id);
		dokumenRepository.delete(dokumen);
		return true;
	}
}
