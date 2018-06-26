package vmd;

import entity.JadwalKeberangkatan;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import service.JadwalKeberangkatanService;
import vo.JadwalKeberangkatanVO;
@Data
@VariableResolver({ DelegatingVariableResolver.class })
public class JadwalKeberangkatanVmd {

	@WireVariable
	JadwalKeberangkatanService jadwalKeberangkatanService;
	public JadwalKeberangkatan jadwalKeberangkatan = new JadwalKeberangkatan();
	public JadwalKeberangkatanVO jadwalKeberangkatanVO = new JadwalKeberangkatanVO();
	public List<JadwalKeberangkatanVO> jadwalKeberangkatanVOs = new ArrayList<>();

	@Init
	public void load() {
		setJadwalKeberangkatanVOs(jadwalKeberangkatanService.getAll());
	}

	@Command({ "simpan" })
	@NotifyChange({ "jadwalKeberangkatanVOs" })
	public void simpan() {
		jadwalKeberangkatanService.simpan(jadwalKeberangkatanVO);
		load();
	}

	@Command({ "ubah" })
	@NotifyChange({ "jadwalKeberangkatanVOs" })
	public void ubah() {
		jadwalKeberangkatanService.update(jadwalKeberangkatanVO);
		load();
	}

	@Command({ "hapus" })
	@NotifyChange({ "jadwalKeberangkatanVOs" })
	public void hapus() {
		jadwalKeberangkatanService.delete(jadwalKeberangkatanVO.getId());
		load();
	}

}
