package cn.ltysyn.inmusic.music.utils;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	
	private static final String FILE_ADDRESS = "/home/ansel/nginx/music/download";
	
	private static final String FILE_TEMP_ADDRESS = "download";
	
	public static String saveMp3(long artistId, long albumId, MultipartFile file) {
		// 利用 UUID 生成唯一字符串作为音乐的路径名
		String hashName = UUID.randomUUID().toString().replace("-", "");
		Path filePath = null;
		try {
			byte[] bytes = file.getBytes();
			// 写入文件
			filePath = Paths.get(FILE_ADDRESS, String.valueOf(artistId), String.valueOf(albumId), hashName + ".mp3");
			Files.write(filePath, bytes);
		} catch (FileAlreadyExistsException e) {
			// TODO: handle exception
			System.err.println("目录已存在");
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("文件写入失败");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return Paths.get(FILE_TEMP_ADDRESS, String.valueOf(artistId), String.valueOf(albumId), hashName + ".mp3").toString();
	}
	
	public static String savePic(long artistId, long albumId, MultipartFile file) {
		String hashName = UUID.randomUUID().toString().replace("-", "");
		Path filePath = null;
		try {
			byte[] bytes = file.getBytes();
			// 创建目录
			Path dirPath = Paths.get(FILE_ADDRESS, String.valueOf(artistId), String.valueOf(albumId));
			if (!Files.exists(dirPath)) {
				Files.createDirectory(dirPath);
			}
			// 写入文件
			filePath = Paths.get(FILE_ADDRESS, String.valueOf(artistId), String.valueOf(albumId), hashName + ".jpg");
			Files.write(filePath, bytes);
		} catch (FileAlreadyExistsException e) {
			// TODO: handle exception
			System.err.println("目录已存在");
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("文件写入失败");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return Paths.get(FILE_TEMP_ADDRESS, String.valueOf(artistId), String.valueOf(albumId), hashName + ".jpg").toString();
	}
	
	public static String savePic(long artistId, MultipartFile file) {
		String hashName = UUID.randomUUID().toString().replace("-", "");
		Path filePath = null;
		try {
			byte[] bytes = file.getBytes();
			// 创建目录
			Path dirPath = Paths.get(FILE_ADDRESS, String.valueOf(artistId));
			if (!Files.exists(dirPath)) {
				Files.createDirectory(dirPath);
			}
			// 写入文件
			filePath = Paths.get(FILE_ADDRESS, String.valueOf(artistId), hashName + ".jpg");
			Files.write(filePath, bytes);
		} catch (FileAlreadyExistsException e) {
			// TODO: handle exception
			System.err.println("目录已存在");
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("文件写入失败");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return Paths.get(FILE_TEMP_ADDRESS, String.valueOf(artistId), hashName + ".jpg").toString();
	}

}
