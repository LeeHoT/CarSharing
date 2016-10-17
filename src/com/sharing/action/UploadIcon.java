package com.sharing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharing.entities.Icon;
import com.sharing.service.UpdateIconService;

@Controller("uploadIcon")
public class UploadIcon extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UpdateIconService updateIconService;
	private Icon icon;
	private File file;
	public String execute() throws IOException, SQLException {
		String name = ServletActionContext.getRequest().getSession()
				.getAttribute("name").toString();
		FileInputStream fis = new FileInputStream(getFile());
		FileOutputStream fos = new FileOutputStream(ServletActionContext
				.getServletContext().getRealPath("images/icon/" + name + ".png"));		
		byte[] buffer = new byte[1024];
		int len = 0 ;
		
		while((len=fis.read(buffer))>0){
			fos.write(buffer,0,len);
		}
		//关闭输入、输出流
		fos.close();
		fis.close();
		//
		updateIconService.updateIcon(icon);	
		ServletActionContext.getRequest().getSession().setAttribute("icon", name);
		return SUCCESS;
	}
	
	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


}
