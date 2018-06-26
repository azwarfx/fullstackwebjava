package vmd;

import entity.CalonJamaah;
import entity.Dokumen;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import service.CalonJamaahService;
import service.DokumenService;
import vo.CalonJamaahVO;
import vo.DokumenVO;
@Data
@VariableResolver({ DelegatingVariableResolver.class })
public class DokumenVmd {

	@WireVariable
	DokumenService dokumenService;

	@WireVariable
	CalonJamaahService calonJamaahService;
	public Dokumen dokumen = new Dokumen();
	public DokumenVO dokumenVO = new DokumenVO();
	public List<DokumenVO> dokumenVOs = new ArrayList<>();

	public CalonJamaahVO calonJamaahVO = new CalonJamaahVO();
	public List<CalonJamaahVO> calonJamaahVOs = new ArrayList<>();
	Long idCalonJamaah = null;
	String namaJamaah = null;

	@Init
	public void load() {
		setDokumenVOs(dokumenService.getAll());

		setCalonJamaahVOs(calonJamaahService.getAll());
		setDokumenVO(dokumenVO);
	}

	@Command({ "jamaah" })
	@NotifyChange({ "idCalonJamaah" })
	public void tampilJamaah() {
		idCalonJamaah = calonJamaahVO.getId();
		namaJamaah = calonJamaahVO.getNamaJamaah();
		System.out.println("Ini datanya Bro " + calonJamaahVO.getNamaJamaah());
	}

	@Command({"simpan"})
	@NotifyChange({"dokumenVOs"})
	public void simpan() {
		CalonJamaah calonJamaah = new CalonJamaah();
		calonJamaah.setId(idCalonJamaah);
		calonJamaah.setNamaJamaah(namaJamaah);
		dokumenVO.setCalonJamaah(calonJamaah);
		dokumenVO.setNamaJamaah(namaJamaah);

		dokumenService.simpanDokumen(dokumenVO);
		load();
	}

	@Command({ "ubah" })
	@NotifyChange({ "dokumenVOs" })
	public void ubah() {
		CalonJamaah calonJamaah = new CalonJamaah();
		calonJamaah.setId(idCalonJamaah);
		calonJamaah.setNamaJamaah(namaJamaah);
		dokumenVO.setCalonJamaah(calonJamaah);
		dokumenVO.setNamaJamaah(namaJamaah);
		dokumenService.updateDokumen(dokumenVO);
		load();
	}

	@Command({ "hapus" })
	@NotifyChange({ "dokumenVOs" })
	public void hapus() {
		dokumenService.deleteDokumen(dokumenVO.getId());
		load();
	}

}
