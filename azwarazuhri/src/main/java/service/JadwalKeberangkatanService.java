package service;

import entity.JadwalKeberangkatan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.JadwalKeberangkatanRepository;
import vo.JadwalKeberangkatanVO;

@Service
public class JadwalKeberangkatanService {

	@Autowired
	JadwalKeberangkatanRepository jadwalKeberangkatanRepository;

	public Boolean simpan(JadwalKeberangkatanVO vo) {
		JadwalKeberangkatan jadwalKeberangkatan = new JadwalKeberangkatan();
		jadwalKeberangkatan.setKbih(vo.getKbih());
		jadwalKeberangkatan.setKeberangkatan(vo.getKeberangkatan());
		jadwalKeberangkatan.setKepulangan(vo.getKepulangan());
		jadwalKeberangkatan.setNamaKloter(vo.getNamaKloter());
		jadwalKeberangkatan.setPembimbing(vo.getPembimbing());
		jadwalKeberangkatanRepository.save(jadwalKeberangkatan);
		return true;
	}

	public Boolean update(JadwalKeberangkatanVO vo) {
		JadwalKeberangkatan jadwalKeberangkatan = jadwalKeberangkatanRepository.findById(vo.getId());
		jadwalKeberangkatan.setKbih(vo.getKbih());
		jadwalKeberangkatan.setKeberangkatan(vo.getKeberangkatan());
		jadwalKeberangkatan.setKepulangan(vo.getKepulangan());
		jadwalKeberangkatan.setNamaKloter(vo.getNamaKloter());
		jadwalKeberangkatan.setPembimbing(vo.getPembimbing());
		jadwalKeberangkatanRepository.save(jadwalKeberangkatan);
		return true;
	}

	public List<JadwalKeberangkatanVO> getAll() {
		List<JadwalKeberangkatan> jadwalKeberangkatans = this.jadwalKeberangkatanRepository.findAll();
		List<JadwalKeberangkatanVO> vos = new ArrayList<>();
		for (JadwalKeberangkatan jadwalKeberangkatan : jadwalKeberangkatans) {
			JadwalKeberangkatanVO vo = new JadwalKeberangkatanVO();
			vo.setId(jadwalKeberangkatan.getId());
			vo.setKbih(jadwalKeberangkatan.getKbih());
			vo.setKeberangkatan(jadwalKeberangkatan.getKeberangkatan());
			vo.setKepulangan(jadwalKeberangkatan.getKepulangan());
			vo.setNamaKloter(jadwalKeberangkatan.getNamaKloter());
			vo.setPembimbing(jadwalKeberangkatan.getPembimbing());
			vos.add(vo);
		}
		return vos;
	}

	public JadwalKeberangkatanVO getDetail(Long id) {
		JadwalKeberangkatan jadwalKeberangkatan = jadwalKeberangkatanRepository.findById(id);
		JadwalKeberangkatanVO vo = new JadwalKeberangkatanVO();
		vo.setKbih(jadwalKeberangkatan.getKbih());
		vo.setKeberangkatan(jadwalKeberangkatan.getKeberangkatan());
		vo.setKepulangan(jadwalKeberangkatan.getKepulangan());
		vo.setNamaKloter(jadwalKeberangkatan.getNamaKloter());
		vo.setPembimbing(jadwalKeberangkatan.getPembimbing());
		return vo;
	}

	public Boolean delete(Long id) {
		JadwalKeberangkatan jadwalKeberangkatan = jadwalKeberangkatanRepository.findById(id);
		jadwalKeberangkatanRepository.delete(jadwalKeberangkatan);
		return true;
	}
}
