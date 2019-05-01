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
	
	
	private static final String FILE_ADDRESS = "download";
	
	/**
	 * 文件上传保存模块
	 * 保存目录：Base目录/文件名/，文件名：上传文件名
	 * 暂时存在两种文件格式：图片、音乐mp3
	 * @param file
	 */
	public static Path saveFile(MultipartFile file) {
		
		// 读取文件名+后缀，并进行切割处理读取文件名
		String fileName = file.getOriginalFilename();		
		String name = fileName.split("\\.")[0];
		String tag = fileName.split("\\.")[1];
		
		// 目录地址
		String directory = FILE_ADDRESS;
		if ("mp3".equals(tag)) {
			directory += "/music/" + name;
		} else {
			directory += "/images/" + name;
		}
		Path filePath = null;
		try {
			byte[] bytes = file.getBytes();
			// 创建针对性的文件夹
			Path dirPath = Paths.get(directory);
			System.out.println("success3");
			Files.createDirectory(dirPath);
			// 写入文件
			filePath = Paths.get(directory, fileName);
			System.out.println("success");
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
		
		return filePath;
	}
	
	public static String saveMp3(long artistId, long albumId, MultipartFile file) {
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
		
		return filePath.toString();
	}

}
