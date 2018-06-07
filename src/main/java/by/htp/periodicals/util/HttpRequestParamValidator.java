package by.htp.periodicals.util;

import by.htp.periodicals.domain.User;
import by.htp.periodicals.util.ValidateNullParamException;

public final class HttpRequestParamValidator {
	
	private HttpRequestParamValidator() {}
	
	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				throw new ValidateNullParamException("Empty parameter recieved");
			}
		}
	}

	public static void validateUserParams(User user) {
		if (stringParamIsEmpty(user.getLogin())){
			throw new ValidateNullParamException("The field login must be filled in");
		}
		if (stringParamIsEmpty(user.getPassword())){
			throw new ValidateNullParamException("The field password must be filled in");
		}
		if (stringParamIsEmpty(user.getLastName())){
			throw new ValidateNullParamException("The field Last Name must be filled in");
		}
		if (stringParamIsEmpty(user.getFirstName())){
			throw new ValidateNullParamException("The field First Name must be filled in");
		}
		if (stringParamIsEmpty(user.getEmail())){
			throw new ValidateNullParamException("The field Email must be filled in");
		}
	}
	
	private static boolean stringParamIsEmpty(String param) {
		return "".equals(param);
	}
}
