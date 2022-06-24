package edu.poly.shop.service.imp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.shop.config.StorageProperties;
import edu.poly.shop.exception.StorageException;
import edu.poly.shop.exception.StorageFileNotFoundException;
import edu.poly.shop.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
	private final Path rootLocation;
	
	@Override
	public String getStoredFilenmae( MultipartFile file , String id) {
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		return "p" + id + "." + ext;
	}
	public StorageServiceImpl(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}
	@Override
	public void store(MultipartFile file, String storeFilename) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("Filed to store empty file");
			}
			Path destinationFilePath = this.rootLocation.resolve(Paths.get(storeFilename))
					.normalize().toAbsolutePath();
			if(!destinationFilePath.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new StorageException("Cannot store file outside current dirctory");
			}
			try(InputStream inputStrem = file.getInputStream()){
				Files.copy(inputStrem, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new StorageException("Filed to store file");
		}
	}
	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}
			throw new StorageFileNotFoundException("could not read file:" + filename);
		} catch ( Exception e) {
			throw new StorageFileNotFoundException("could nit read file:" + filename);
		}
	}
	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}
	@Override
	public void delete(String storedFilename) throws IOException {
		Path destina = rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
			
		Files.delete(destina);
	}
	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
			System.out.println(rootLocation.toString());
		} catch (Exception e) {
			throw new StorageException("Could not initialize storage", e);
			
		}
	}
}
