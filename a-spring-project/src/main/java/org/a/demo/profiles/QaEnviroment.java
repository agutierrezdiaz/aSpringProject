package org.a.demo.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "qa")
public class QaEnviroment implements EnviromentService {

	@Override
	public String getEnviroment() {
		return "qa";
	}
	
}
