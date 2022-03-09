package bexysuttx.lic.BTG_Licence.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import bexysuttx.lic.BTG_Licence.dao.ControllUserDAO;

@Service
public class BackupLic {
	
	@Autowired
	private  ControllUserDAO controllUserDAO;

	@Scheduled(cron= "0 0 0/3 * * ?")
	public  void backupInFile() throws IOException {
		File  file = new File("keyLicence_"+LocalDateTime.now().toString()+".txt");
		System.out.println("Scheduled!");
		Path path = Paths.get(file.getPath());
		Files.write(path, controllUserDAO.getGenerateKey(), StandardCharsets.UTF_8);
		
	}

}
