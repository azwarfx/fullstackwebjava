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
import service.PaketService;
import vo.DanaBantuanVO;
import vo.PaketVO;

@Data
@VariableResolver({ DelegatingVariableResolver.class })
public class PaketVmd {

	@WireVariable
	PaketService paketService;
	PaketVO paketVO = new PaketVO();
	List<PaketVO> paketVOs = new ArrayList<>();

	@WireVariable
	DanaBantuanService danaBantuanService;
	DanaBantuanVO danaBantuanVO = new DanaBantuanVO();
	List<DanaBantuanVO> bantuanVOs = new ArrayList<>();
	Long idBantuan = null;
	String namaBantuan = null;

	@Init
	public void load() {
		setPaketVOs(paketService.getAll());
		setBantuanVOs(danaBantuanService.getAll());
	}

	@Command({ "bantuan" })
	@NotifyChange({ "namaBantuan" })
	public void tampilBantuan() {
		idBantuan = danaBantuanVO.getId();
		namaBantuan = danaBantuanVO.getHargaPotongan();
	}

	@Command({ "simpan" })
	@NotifyChange({ "bantuanVOs", " paketVOs" })
	public void simpan() {
		DanaBantuan danaBantuan = new DanaBantuan();
		danaBantuan.setId(idBantuan);
		danaBantuan.setHargaPotongan(namaBantuan);

		paketVO.setDanaBantuan(danaBantuan);
		paketVO.setNamaBantuan(namaBantuan);
		paketService.simpan(paketVO);
		load();
	}

	@Command({ "ubah" })
	@NotifyChange({ "bantuanVOs", "paketVOs" })
	public void ubah() {
		DanaBantuan danaBantuan = new DanaBantuan();
		danaBantuan.setId(idBantuan);
		danaBantuan.setHargaPotongan(namaBantuan);
		paketVO.setDanaBantuan(danaBantuan);
		paketVO.setNamaBantuan(namaBantuan);
		paketService.ubah(paketVO);
		load();
	}

	@Command({ "hapus" })
	@NotifyChange({ "dokumenVOs", "paketVOs" })
	public void hapus() {
		paketService.delete(paketVO.getId());
		load();
	}

}
