package com.kedu.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.FilesDAO;
import com.kedu.dto.FilesDTO;

@Controller
@RequestMapping("/file")
public class FileController {


	@Autowired
	private FilesDAO dao;

	@RequestMapping("/upload")
	public String upload(String text, MultipartFile[] files, HttpSession session) throws Exception { //알아서해준데 쓰래
		String realPath = session.getServletContext().getRealPath("upload");
		System.out.println(realPath);

		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {realPathFile.mkdir();}
		for(MultipartFile file : files) {
			if(!file.isEmpty()) {
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID() + "_" + oriName;

				file.transferTo(new File(realPath+"/"+sysName));
				dao.insertFile(new FilesDTO(0,"test", oriName, sysName,0));
			}
		}
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/list")
	public List<FilesDTO> list() {
		return dao.selectAll();
	}

	@RequestMapping("/download")
	public void download(HttpServletResponse resp, HttpSession session, String sysname, String oriname) throws Exception {
		String realPath = session.getServletContext().getRealPath("upload");
		File target = new File(realPath+"/"+sysname);

		oriname = new String(oriname.getBytes("utf8"), "ISO-8859-1");
		resp.setHeader("content-disposition", "attachment;filename=\""+oriname+"\"");

		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
				DataOutputStream dos = new DataOutputStream(resp.getOutputStream());){
					byte[] fileContents = dis.readAllBytes();
					dos.write(fileContents);
					dos.flush();
				}
	}


	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) { // 에러처리
		e.printStackTrace();
		return "redirect:/error";
	}
}
