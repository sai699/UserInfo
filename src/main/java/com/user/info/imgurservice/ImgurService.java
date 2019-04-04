package com.user.info.imgurservice;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;

@Component
public class ImgurService implements IImgurService {

	private RestTemplate restTemplate;

	@Value("${imgur.url}")
	private String imgUrl;
	
	@Value("${imgur.upload.url}")
	private String imgUploadUrl;

	private String token = "f09a9c5bdb6b4c1d8b902a77707353e696fd38a3";

	@Override
	public ImgurResponseVO uploadImage(MultipartFile file) {
		ImgurResponseVO imgurResponseVO = null;
		try {
		
			restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			headers.add("Authorization", "Bearer " + token);
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			Base64.Encoder encoder = Base64.getEncoder(); 
			body.add("image", encoder.encode(file.getBytes()));
			HttpEntity<MultiValueMap<String, Object>> requestEntity
			 = new HttpEntity<>(body, headers);
			imgurResponseVO = restTemplate.postForObject(imgUploadUrl, requestEntity, ImgurResponseVO.class);
		}
		catch (Exception e) {
		}
		
		return imgurResponseVO;

	}

	@Override
	public ImgurResponseVO viewImage(String id) {
		
		ImgurResponseVO imgurViewResponseVO = null;
		ResponseEntity<ImgurResponseVO> response = null;
		try {
			restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + token);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			response= restTemplate.exchange(imgUrl + id, HttpMethod.GET,
					entity, ImgurResponseVO.class);
			imgurViewResponseVO =response.getBody();
			
		}
		catch (Exception e) {
		}
		
		return imgurViewResponseVO;

	}

	@Override
	public ImgurDeleteResponseVO deleteImage(String id) {
		ImgurDeleteResponseVO imgurDeleteResponseVO = null;
		
		try {
			restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + token);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<ImgurDeleteResponseVO> response = restTemplate.exchange(imgUrl + id, HttpMethod.DELETE,
					entity, ImgurDeleteResponseVO.class);
			imgurDeleteResponseVO =response.getBody();
		} catch (Exception e) {

		}
		return imgurDeleteResponseVO;

	}

}
