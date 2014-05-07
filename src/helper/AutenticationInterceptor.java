package helper;

import javax.inject.Inject;

import controller.LoginController;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class AutenticationInterceptor implements Interceptor {
	
	@Inject
	UserSession session;
	@Inject
	Result result;
	
	@Override
	public boolean accepts(ResourceMethod method) {
		return !this.session.isLogged() && !method.containsAnnotation(Inrestrict.class);
	}

	@Override
	public void intercept(InterceptorStack arg0, ResourceMethod arg1, Object arg2) throws InterceptionException {
		result.redirectTo(LoginController.class).login();
	}
	
}
