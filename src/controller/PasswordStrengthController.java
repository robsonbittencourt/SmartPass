package controller;

import java.util.ArrayList;
import java.util.List;

import model.Password;
import service.PasswordStrengthService;
import type.PasswordStrengthType;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import check.PasswordCheck;
import check.PasswordCheckCharacterTypes;
import check.PasswordCheckDate;
import check.PasswordCheckDictionary;
import check.PasswordCheckSequence;
import check.PasswordCheckSize;

import com.google.inject.Inject;

@Resource
public class PasswordStrengthController {

	@Inject
	private Result result;
	@Inject
	private PasswordStrengthService service;

	@Get("/passwordStrength")
	public void passwordStrength() {
		Password password = new Password();
		result.include(password);
	}

	@Post("/passwordStrength")
	public void passwordStrength(Password password) {
		PasswordStrengthType passwordStreght = service.verifyPasswordStrenght(password, getAllPasswordCheckers());
		password.setMessageStatus(passwordStreght.getMessageStatus());
		result.include("password", password);
	}

	private List<PasswordCheck> getAllPasswordCheckers() {
		List<PasswordCheck> checkers = new ArrayList<PasswordCheck>();
		checkers.add(new PasswordCheckCharacterTypes(30));
		checkers.add(new PasswordCheckSize(30));
		checkers.add(new PasswordCheckDictionary(20));
		checkers.add(new PasswordCheckDate(10));
		checkers.add(new PasswordCheckSequence(10));
		return checkers;
	}
}
