package vmd;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.cdi.DelegatingVariableResolver;

import entity.Users;

@VariableResolver(DelegatingVariableResolver.class)
public class UsersVmd {
	 @WireVariable
	  Users users;
	  String username;
	  String password;

	  @Command({"login"})
	  @NotifyChange({"username", "password"})
	  public void login()
	  {
	    if ((this.username != null) && (this.password != null)) {
	      if ((this.username.equals("azwarazuhri@gmail.com")) && (this.password.equals("warrior95"))) {
	        Sessions.getCurrent().setAttribute("user", this.username);
	        Executions.sendRedirect("/index.zul");
	      } else {
	        Messagebox.show("Username atau Password salah");
	      }
	    }
	    else Messagebox.show("Harap diisi terlebih dahulu");
	  }

}
