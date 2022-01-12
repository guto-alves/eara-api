package com.gutotech.eara.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DarkColorValidator implements ConstraintValidator<DarkColor, String> {

	@Override
	public boolean isValid(String c, ConstraintValidatorContext context) {
		if (!c.matches("#\\w{6}")) {
			return false;
		}
		
		c = c.substring(1); // strip #
		int rgb = Integer.valueOf(c, 16); // convert rrggbb to decimal
		int r = (rgb >> 16) & 0xff; // extract red
		int g = (rgb >> 8) & 0xff; // extract green
		int b = (rgb >> 0) & 0xff; // extract blue

		double luma = 0.2126 * r + 0.7152 * g + 0.0722 * b; // per ITU-R BT.709

		return luma < 200;
	}

}
