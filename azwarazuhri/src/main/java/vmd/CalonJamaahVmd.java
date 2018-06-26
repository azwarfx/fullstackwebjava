package vmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import lombok.Data;
import service.CalonJamaahService;
import vo.CalonJamaahVO;

@Data
@VariableResolver({DelegatingVariableResolver.class})
public class CalonJamaahVmd
{

  @WireVariable
  CalonJamaahService calonJamaahService;
  CalonJamaahVO vo = new CalonJamaahVO();
  public List<CalonJamaahVO> voList = new ArrayList<>();

  @Init
  public void load() {
    setVoList(calonJamaahService.getAll());
  }
  @Command({"simpan"})
  @NotifyChange({"voList"})
  public void save() {
    calonJamaahService.simpanCalonJamaah(vo);
    load();
  }
  @Command({"hapus"})
  @NotifyChange({"voList"})
  public void hapus() {
    System.out.println("Ini Datanya" +vo.getId());
    calonJamaahService.deleteCalonJmaah(vo.getId());
    load();
  }
  @Command({"edit"})
  @NotifyChange({"voList"})
  public void ubah() {
    calonJamaahService.updateCaloonJamaah(vo);
    load();
  }

  @Command({"cetak"})
  public void cetakCalonJamaah() throws JRException {
    Locale locale = new Locale("id", "ID");
    Locale.setDefault(locale);

    String reportFile = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reports");

    reportFile = reportFile + "/tes2.jasper";

    JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile, null, 
      new JRBeanCollectionDataSource(voList));

    JasperViewer.viewReport(jasperPrint, false);
  }

}
