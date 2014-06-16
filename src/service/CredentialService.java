package service;

import javax.inject.Inject;

import model.Credential;
import br.com.caelum.vraptor.ioc.Component;
import dao.CredentialDao;

@Component
public class CredentialService {
	
	@Inject
	private CredentialDao dao;

	public Credential findById(long id) {
		return dao.findById(id);
	}
	
	public void save(Credential credential) {
		dao.save(credential);
	}
	
	public void update(Credential credential) {
		dao.update(credential);
	}
	
	public void saveOrUpdate(Credential credential) {
		dao.saveOrUpdate(credential);
	}
	
	public void delete(long id) {
		Credential credential = findById(id);
		dao.delete(credential);
	}

	public void delete(Credential credential) {
		dao.delete(credential);
	}
	
}
