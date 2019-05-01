package cn.ltysyn.inmusic;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
public class MusicCenterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MusicCenterApp.class, args);
	}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		DataSize size = DataSize.ofMegabytes(10);
		factory.setMaxFileSize(size);
		factory.setMaxRequestSize(size);
		return factory.createMultipartConfig();
	}

}
