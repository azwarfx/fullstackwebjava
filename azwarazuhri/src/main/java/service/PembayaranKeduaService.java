package service;

import entity.PembayaranKedua;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.PembayaranKeduaRepository;
import vo.PembayaranKeduaVO;

@Service
public class PembayaranKeduaService {

	@Autowired
	PembayaranKeduaRepository pembayaranKeduaRepository;

	public List<PembayaranKeduaVO> getAll() {
		List<PembayaranKedua> pembayaranKeduas = this.pembayaranKeduaRepository.findAll();
		List<PembayaranKeduaVO> pembayaranKeduaVOs = new ArrayList<>();
		for (PembayaranKedua pembayaranKedua : pembayaranKeduas) {
			PembayaranKeduaVO pembayaranKeduaVO = new PembayaranKeduaVO();
			pembayaranKeduaVO.setId(pembayaranKedua.getId());
			pembayaranKeduaVO.setPelunasan(pembayaranKedua.getPelunasan());
			pembayaranKeduaVO.setTglBatasPelunasan(pembayaranKedua.getTglBatasPelunasan());
			pembayaranKeduaVO.setTglPelunasan(pembayaranKedua.getTglPelunasan());
			pembayaranKeduaVO.setPembayaranPertama(pembayaranKedua.getPembayaranPertama());
			pembayaranKeduaVOs.add(pembayaranKeduaVO);
		}
		return pembayaranKeduaVOs;
	}

	public Boolean simpan(PembayaranKeduaVO vo) {
		PembayaranKedua pembayaranKedua = new PembayaranKedua();
		pembayaranKedua.setPelunasan(vo.getPelunasan());
		pembayaranKedua.setTglBatasPelunasan(vo.getTglBatasPelunasan());
		pembayaranKedua.setTglPelunasan(vo.getTglPelunasan());
		pembayaranKedua.setPembayaranPertama(vo.getPembayaranPertama());
		pembayaranKeduaRepository.save(pembayaranKedua);
		return Boolean.valueOf(true);
	}

	public Boolean ubah(PembayaranKeduaVO vo) {
		PembayaranKedua pembayaranKedua = pembayaranKeduaRepository.findById(vo.getId());
		pembayaranKedua.setPelunasan(vo.getPelunasan());
		pembayaranKedua.setTglBatasPelunasan(vo.getTglBatasPelunasan());
		pembayaranKedua.setTglPelunasan(vo.getTglPelunasan());
		pembayaranKedua.setPembayaranPertama(vo.getPembayaranPertama());
		pembayaranKeduaRepository.save(pembayaranKedua);
		return true;
	}

	public PembayaranKeduaVO getDetail(Long id) {
		PembayaranKedua pembayaranKedua = pembayaranKeduaRepository.findById(id);
		PembayaranKeduaVO vo = new PembayaranKeduaVO();
		vo.setPelunasan(pembayaranKedua.getPelunasan());
		vo.setTglPelunasan(pembayaranKedua.getTglPelunasan());
		vo.setTglBatasPelunasan(pembayaranKedua.getTglBatasPelunasan());
		vo.setPembayaranPertama(vo.getPembayaranPertama());
		return vo;
	}

	public Boolean hapus(Long id) {
		PembayaranKedua pembayaranKedua = pembayaranKeduaRepository.findById(id);
		pembayaranKeduaRepository.delete(pembayaranKedua);
		return true;
	}
}
