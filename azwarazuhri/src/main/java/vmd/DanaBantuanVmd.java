package vmd;

import entity.DanaBantuan;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import service.DanaBantuanService;
import vo.DanaBantuanVO;

@Data
@VariableResolver({ DelegatingVariableResolver.class })
public class DanaBantuanVmd {

	@WireVariable
	DanaBantuanService danaBantuanService;
	DanaBantuan bantuan = new DanaBantuan();
	DanaBantuanVO danaBantuanVO = new DanaBantuanVO();
	List<DanaBantuanVO> bantuanVOs = new ArrayList<>();

	@Init
	public void load() {
		setBantuanVOs(danaBantuanService.getAll());
	}

	@Command({ "simpan" })
	@NotifyChange({ "bantuanVOs" })
	public void simpan() {
		danaBantuanService.simpan(danaBantuanVO);
		load();
	}

	@Command({ "hapus" })
	@NotifyChange({ "bantuanVOs" })
	public void hapus() {
		danaBantuanService.hapus(danaBantuanVO.getId());
		load();
	}

	@Command({ "ubah" })
	@NotifyChange({ "bantuanVOs" })
	public void ubah() {
		danaBantuanService.ubah(danaBantuanVO);
		load();
	}

}
