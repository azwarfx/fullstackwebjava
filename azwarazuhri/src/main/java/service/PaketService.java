package service;

import entity.Paket;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.PaketRepository;
import vo.PaketVO;

@Service
public class PaketService {

	@Autowired
	PaketRepository paketRepository;

	public Boolean simpan(PaketVO vo) {
		Paket paket = new Paket();
		paket.setHarga(vo.getHarga());
		paket.setIsiKamar(vo.getIsiKamar());
		paket.setJenisPaket(vo.getJenisPaket());
		paket.setNamaHotel(vo.getNamaHotel());
		paket.setNamaPaket(vo.getNamaPaket());
		paket.setRute(vo.getRute());
		paket.setDanaBantuan(vo.getDanaBantuan());
		paket.setNamaBantuan(vo.getNamaBantuan());
		paketRepository.save(paket);
		return true;
	}

	public Boolean ubah(PaketVO vo) {
		Paket paket = paketRepository.findById(vo.getId());
		paket.setHarga(vo.getHarga());
		paket.setIsiKamar(vo.getIsiKamar());
		paket.setJenisPaket(vo.getJenisPaket());
		paket.setNamaHotel(vo.getNamaHotel());
		paket.setNamaPaket(vo.getNamaPaket());
		paket.setRute(vo.getRute());
		paket.setDanaBantuan(vo.getDanaBantuan());
		paket.setNamaBantuan(vo.getNamaBantuan());
		this.paketRepository.save(paket);
		return true;
	}

	public List<PaketVO> getAll() {
		List<Paket> pakets = this.paketRepository.findAll();
		List<PaketVO> paketVOs = new ArrayList<>();
		for (Paket paket : pakets) {
			PaketVO vo = new PaketVO();
			vo.setId(paket.getId());
			vo.setHarga(paket.getHarga());
			vo.setIsiKamar(paket.getIsiKamar());
			vo.setJenisPaket(paket.getJenisPaket());
			vo.setNamaHotel(paket.getNamaHotel());
			vo.setNamaPaket(paket.getNamaPaket());
			vo.setRute(paket.getRute());
			vo.setDanaBantuan(paket.getDanaBantuan());
			vo.setNamaBantuan(paket.getNamaBantuan());
			paketVOs.add(vo);
		}
		return paketVOs;
	}

	public PaketVO getDetail(Long id) {
		Paket paket = paketRepository.findById(id);
		PaketVO vo = new PaketVO();
		vo.setHarga(paket.getHarga());
		vo.setIsiKamar(paket.getIsiKamar());
		vo.setJenisPaket(paket.getJenisPaket());
		vo.setNamaHotel(paket.getNamaHotel());
		vo.setNamaPaket(paket.getNamaPaket());
		vo.setRute(paket.getRute());
		vo.setDanaBantuan(paket.getDanaBantuan());
		return vo;
	}

	public Boolean delete(Long id) {
		Paket paket = paketRepository.findById(id);
		paketRepository.delete(paket);
		return true;
	}
}
