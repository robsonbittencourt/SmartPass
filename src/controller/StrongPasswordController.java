package controller;

import com.google.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class StrongPasswordController {
	
	@Inject
	private Result result;
	
	@Get("/strongPassword")
	public void strongPassword() {
		
	}
	
	@Post("/strongPassword")
	public void verify(String password) {
		result.include("passwordStatus", "");
		result.include("passwordMessage", "");
		result.forwardTo(this).strongPassword();
	}
}
