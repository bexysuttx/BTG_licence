package bexysuttx.lic.BTG_Licence.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import bexysuttx.lic.BTG_Licence.model.User;

@Repository
public class ControllUserDAO {

	private static Map<String, List<User>> usersMap = new LinkedHashMap<>();
	private static List<String> active;

	static {
		initUsrs();
	}

	private static void initUsrs() {
		active = new ArrayList<>();
		File file = new File("input_lic.txt");
		try (Stream<String> linesStream = Files.lines(file.toPath())){
			linesStream.forEach(line-> {
				active.add(line);		
		});
		} catch (IOException e) {
			System.out.println("Files lic not found!");
			e.printStackTrace();
		}
	}

	public List<User> getKey(String key) {
		return usersMap.get(key);
	}

	public boolean checkKey(User user) {
		if (active.contains(user.getUid())) {
			List<User> list = usersMap.get(user.getUid());
			if (list == null) {
				list = new ArrayList<>();
			}
			for (User u : list) {
				if (u.getMacAddress().equals(user.getMacAddress())) {
					return true;
				}
			}
			list.add(user);
			usersMap.put(user.getUid(), list);
			return true;
		}
		return false;
	}

	public Map<String, List<User>> getTotalKey() {
		return usersMap;
	}

	public String addGenerateKey() {
		String uid = UUID.randomUUID().toString();
		active.add(uid);
		return uid;
	}

	public List<String> getGenerateKey() {
		return active;
	}

	public void deleteKey(String key) {
		usersMap.remove(key);
	}

}
