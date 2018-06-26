package vmd;


import entity.PembayaranPertama;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import service.PembayaranKeduaService;
import service.PembayaranPertamaService;
import vo.PembayaranKeduaVO;
import vo.PembayaranPertamaVO;

@Data
@VariableResolver({ DelegatingVariableResolver.class })
public class PembayaranKeduaVmd {

	@WireVariable
	PembayaranKeduaService pembayaranKeduaService;
	List<PembayaranKeduaVO> vos = new ArrayList<>();
	PembayaranKeduaVO vo = new PembayaranKeduaVO();

	@WireVariable
	PembayaranPertamaService pembayaranPertamaService;
	PembayaranPertamaVO pertmaVO = new PembayaranPertamaVO();
	List<PembayaranPertamaVO> pertmaVOS = new ArrayList<>();
	Long idDp;
	int jumlahDp;

	@Init
	public void load() {
		setVos(this.pembayaranKeduaService.getAll());
		setPertmaVOS(this.pembayaranPertamaService.getAll());
	}

	@Command({ "dp" })
	@NotifyChange
	public void tampil() {
		this.idDp = this.pertmaVO.getId();
		this.jumlahDp = this.pertmaVO.getUangDp();
	}

	@Command({ "simpan" })
	@NotifyChange({ "vos" })
	public void simpan() {
		Messagebox.show(""+vo.getTglPelunasan());
		PembayaranPertama pembayaranPertama = new PembayaranPertama();
		pembayaranPertama.setId(this.idDp);
		this.vo.setPembayaranPertama(pembayaranPertama);
		this.vo.setPelunasan(this.vo.getPelunasan() - this.jumlahDp);
		this.pembayaranKeduaService.simpan(this.vo);
		load();
	}

	@Command({ "ubah" })
	@NotifyChange({ "vos" })
	public void ubah() {
		PembayaranPertama pembayaranPertama = new PembayaranPertama();
		pembayaranPertama.setId(this.idDp);
		this.vo.setPembayaranPertama(pembayaranPertama);
		this.vo.setPelunasan(this.vo.getPelunasan() - this.jumlahDp);
		this.pembayaranKeduaService.ubah(this.vo);
		load();
	}

	@Command({ "hapus" })
	@NotifyChange({ "vos" })
	public void hapus() {
		this.pembayaranKeduaService.hapus(this.vo.getId());
		load();
	}
}
