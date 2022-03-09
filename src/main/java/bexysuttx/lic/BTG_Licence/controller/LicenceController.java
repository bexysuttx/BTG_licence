package bexysuttx.lic.BTG_Licence.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bexysuttx.lic.BTG_Licence.dao.ControllUserDAO;
import bexysuttx.lic.BTG_Licence.model.User;

@RestController
public class LicenceController {

	@Autowired
	private ControllUserDAO controllUserDAO;

	@RequestMapping(value = "/check", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
		if (controllUserDAO.checkKey(user)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(Map.of("lic", user.getUid(), "mac", user.getMacAddress(), "active", true));
		} else
			return ResponseEntity.status(HttpStatus.OK).body(Map.of("message",
					"You do not have a license. Send a message in telegram: @bexysutt ", "active", false));
	}

	@RequestMapping(value = "/addKeyWesty4313", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> addGenerateKey() {
		String uid = controllUserDAO.addGenerateKey();
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("uid", uid, "message", "Added"));
	}
	
	@RequestMapping(value = "/getKeyWesty4313", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, List<String>>> getGenerateKey() {
		List<String> list = controllUserDAO.getGenerateKey();
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("licence",list));
	}

	@RequestMapping(value = "/getWesty4313", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getUser(@RequestBody String key) {
		List<User> list = controllUserDAO.getKey(key);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("key", key, "users", list));
	}

	@RequestMapping(value = "/getTotalWesty4313", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, List<User>>> getTotalUsers() {
		Map<String, List<User>> map = controllUserDAO.getTotalKey();
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
}
