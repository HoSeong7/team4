package com.keduit.helloworld.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResultDTO {
	
	private String fileName;
	private String folderPath;
	
	public String getImageURL() {
		try {
			return URLEncoder.encode(folderPath+"/"+fileName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ""; 
	}
	
	public String getThumbnailURL() {
		
		try {
			return URLEncoder.encode(folderPath
					+ "/s_"+fileName, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
		
		
	}

}
