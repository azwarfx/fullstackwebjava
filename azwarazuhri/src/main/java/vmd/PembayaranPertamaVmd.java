package vmd;

import entity.CalonJamaah;
import entity.JadwalKeberangkatan;
import entity.Paket;
import lombok.Data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import service.CalonJamaahService;
import service.JadwalKeberangkatanService;
import service.PaketService;
import service.PembayaranPertamaService;
import vo.CalonJamaahVO;
import vo.JadwalKeberangkatanVO;
import vo.PaketVO;
import vo.PembayaranPertamaVO;

@Data
@VariableResolver({ DelegatingVariableResolver.class })
public class PembayaranPertamaVmd {

	@WireVariable
	PembayaranPertamaService pembayaranPertamaService;
	PembayaranPertamaVO pembayaranPertamaVO = new PembayaranPertamaVO();
	List<PembayaranPertamaVO> pembayaranPertamaVOs = new ArrayList<>();

	@WireVariable
	CalonJamaahService calonJamaahService;
	public CalonJamaahVO calonJamaahVO = new CalonJamaahVO();
	public List<CalonJamaahVO> calonJamaahVOs = new ArrayList<>();
	Long idCalonJamaah = null;
	String namaJamaah = null;

	@WireVariable
	JadwalKeberangkatanService jadwalKeberangkatanService;
	public JadwalKeberangkatanVO keberangkatan = new JadwalKeberangkatanVO();
	public List<JadwalKeberangkatanVO> keberangkatanVos = new ArrayList<>();
	Long idJadwal;
	Date tglKeberangakatan;

	@WireVariable
	PaketService paketService;
	PaketVO paketVo = new PaketVO();
	List<PaketVO> paketVos = new ArrayList<>();
	Long idPaket;
	String namaPaket;

	@Init
	public void load() {
		setPembayaranPertamaVOs(pembayaranPertamaService.getAll());

		setCalonJamaahVOs(calonJamaahService.getAll());

		setKeberangkatanVos(jadwalKeberangkatanService.getAll());

		setPaketVos(paketService.getAll());
	}

	@Command({ "paket" })
	@NotifyChange({ "idPaket" })
	public void tampilPaket() {
		idPaket = paketVo.getId();
		namaPaket = paketVo.getNamaPaket();
	}

	@Command({ "simpan" })
	@NotifyChange({ "pembayaranPertamaVOs" })
	public void simpan() {
		Messagebox.show(namaPaket);
		Messagebox.show("Ini" + tglKeberangakatan);
		CalonJamaah calonJamaah = new CalonJamaah();
		calonJamaah.setId(idCalonJamaah);
		calonJamaah.setNamaJamaah(namaJamaah);
		Paket paket = new Paket();
		paket.setId(idPaket);
		paket.setNamaPaket(namaPaket);
		JadwalKeberangkatan berangkat = new JadwalKeberangkatan();
		berangkat.setId(idJadwal);
		berangkat.setKeberangkatan(tglKeberangakatan);
		pembayaranPertamaVO.setTglBerangkat(tglKeberangakatan);
		pembayaranPertamaVO.setCalonJamaah(calonJamaah);
		pembayaranPertamaVO.setNamaJamaah(namaJamaah);
		pembayaranPertamaVO.setPaket(paket);
		pembayaranPertamaVO.setNamaPaket(namaPaket);
		pembayaranPertamaVO.setJadwalKeberangkatan(berangkat);
		pembayaranPertamaService.simapn(pembayaranPertamaVO);
		load();
	}

	@Command({ "jamaah" })
	@NotifyChange({ "idCalonJamaah", "namaJamaah" })
	public void tampilJamaah() {
		idCalonJamaah = calonJamaahVO.getId();
		namaJamaah = calonJamaahVO.getNamaJamaah();
		System.out.println("Ini datanya Bro " + calonJamaahVO.getNamaJamaah());
	}

	@Command({ "jadwal" })
	@NotifyChange({ "idJadwal", "tglKeberangakatan" })
	public void tampilJadwal() {
		idJadwal = keberangkatan.getId();
		tglKeberangakatan = keberangkatan.getKeberangkatan();
	}

	@Command({ "ubah" })
	@NotifyChange({ " pembayaranPertamaVOs" })
	public void ubah() {
		CalonJamaah calonJamaah = new CalonJamaah();
		calonJamaah.setId(idCalonJamaah);
		calonJamaah.setNamaJamaah(namaJamaah);
		pembayaranPertamaVO.setCalonJamaah(calonJamaah);
		pembayaranPertamaVO.setNamaJamaah(namaJamaah);
		pembayaranPertamaService.ubah(pembayaranPertamaVO);
		load();
	}

	@Command({ "hapus" })
	@NotifyChange({ " pembayaranPertamaVOs" })
	public void hapus() {
		pembayaranPertamaService.deletePembayaranPertama(pembayaranPertamaVO.getId());
		load();
	}
}
