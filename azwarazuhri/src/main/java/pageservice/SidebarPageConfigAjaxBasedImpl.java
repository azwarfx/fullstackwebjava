package pageservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SidebarPageConfigAjaxBasedImpl implements SidebarPageConfig {
	HashMap<String, SidebarPage> pageMap = new LinkedHashMap<>();

	public SidebarPageConfigAjaxBasedImpl() {
		this.pageMap.put("fn1", new SidebarPage("Calon Jamaah", "/imgs/fn.png", "/fitur/calonjamaah.zul"));
		this.pageMap.put("fn2", new SidebarPage("Pembayaran Pertama", "/imgs/fn.png", "/fitur/pembayaranpertama.zul"));
		this.pageMap.put("fn3", new SidebarPage("Pelunasan", "/imgs/fn.png", "/fitur/pembayarankedua.zul"));
		this.pageMap.put("fn4", new SidebarPage("Dokumen", "/imgs/fn.png", "/fitur/dokumen.zul"));
		this.pageMap.put("fn5", new SidebarPage("Dana Bantuan", "/imgs/fn.png", "/fitur/danabantuan.zul"));
		this.pageMap.put("fn6", new SidebarPage("Keberangkatan", "/imgs/fn.png", "/fitur/keberangkatan.zul"));
		this.pageMap.put("fn7", new SidebarPage("Paket", "/imgs/fn.png", "/fitur/paket.zul"));
	}

	public List<SidebarPage> getPages() {
		return new ArrayList<>(this.pageMap.values());
	}
}