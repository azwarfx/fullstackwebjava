package service;

import entity.PembayaranPertama;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.PembayaranPertamaRepository;
import vo.PembayaranPertamaVO;

@Service
public class PembayaranPertamaService {

	@Autowired
	PembayaranPertamaRepository pembayaranPertamaRepository;

	public List<PembayaranPertamaVO> getAll() {
		List<PembayaranPertama> pembayaranPertamas = pembayaranPertamaRepository.findAll();
		List<PembayaranPertamaVO> pembayaranPertamaVOs = new ArrayList<>();
		for (PembayaranPertama pembayaranPertama : pembayaranPertamas) {
			PembayaranPertamaVO pembayaranPertamaVO = new PembayaranPertamaVO();
			pembayaranPertamaVO.setId(pembayaranPertama.getId());
			pembayaranPertamaVO.setUangDp(pembayaranPertama.getUangDp());
			pembayaranPertamaVO.setCalonJamaah(pembayaranPertama.getCalonJamaah());
			pembayaranPertamaVO.setJadwalKeberangkatan(pembayaranPertama.getJadwalKeberangkatan());
			pembayaranPertamaVO.setPaket(pembayaranPertama.getPaket());
			pembayaranPertamaVO.setNamaJamaah(pembayaranPertama.getNamaJamaah());
			pembayaranPertamaVO.setTglBerangkat(pembayaranPertama.getTglBerangkat());
			pembayaranPertamaVOs.add(pembayaranPertamaVO);
		}

		return pembayaranPertamaVOs;
	}

	public Boolean simapn(PembayaranPertamaVO vo) {
		PembayaranPertama pembayaranPertama = new PembayaranPertama();
		pembayaranPertama.setUangDp(vo.getUangDp());
		pembayaranPertama.setCalonJamaah(vo.getCalonJamaah());
		pembayaranPertama.setJadwalKeberangkatan(vo.getJadwalKeberangkatan());
		pembayaranPertama.setPaket(vo.getPaket());
		pembayaranPertama.setNamaJamaah(vo.getNamaJamaah());
		pembayaranPertama.setTglBerangkat(vo.getTglBerangkat());
		pembayaranPertamaRepository.save(pembayaranPertama);
		return Boolean.valueOf(true);
	}

	public Boolean ubah(PembayaranPertamaVO vo) {
		PembayaranPertama pembayaranPertama = pembayaranPertamaRepository.findById(vo.getId());
		pembayaranPertama.setUangDp(vo.getUangDp());
		pembayaranPertama.setCalonJamaah(vo.getCalonJamaah());
		pembayaranPertama.setJadwalKeberangkatan(vo.getJadwalKeberangkatan());
		pembayaranPertama.setPaket(vo.getPaket());
		pembayaranPertama.setNamaJamaah(vo.getNamaJamaah());
		pembayaranPertama.setTglBerangkat(vo.getTglBerangkat());
		pembayaranPertamaRepository.save(pembayaranPertama);
		return true;
	}

	public PembayaranPertamaVO getDetail(Long id) {
		PembayaranPertama pembayaranPertama = pembayaranPertamaRepository.findById(id);
		PembayaranPertamaVO vo = new PembayaranPertamaVO();
		vo.setUangDp(pembayaranPertama.getUangDp());
		vo.setCalonJamaah(pembayaranPertama.getCalonJamaah());
		vo.setJadwalKeberangkatan(pembayaranPertama.getJadwalKeberangkatan());
		vo.setPaket(pembayaranPertama.getPaket());
		vo.setNamaJamaah(pembayaranPertama.getNamaJamaah());
		vo.setTglBerangkat(pembayaranPertama.getTglBerangkat());
		return vo;
	}

	public Boolean deletePembayaranPertama(Long id) {
		PembayaranPertama pembayaranPertama = pembayaranPertamaRepository.findById(id);
		pembayaranPertamaRepository.delete(pembayaranPertama);
		return Boolean.valueOf(true);
	}
}
