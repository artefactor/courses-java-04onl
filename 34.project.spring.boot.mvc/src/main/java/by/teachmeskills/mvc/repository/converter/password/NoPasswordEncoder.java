package by.teachmeskills.mvc.repository.converter.password;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class NoPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence charSequence) {
		if (charSequence ==null){
			return null;
		}
		return charSequence.toString();
	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
		return true;
	}
}
