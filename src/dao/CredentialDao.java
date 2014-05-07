package dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import model.Credential;
import model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;


public class CredentialDao {
	
	protected Session session;
	
	public CredentialDao() {
		session = SectionFactory.getSession();
	}
	
	public Credential findById(long identifier) {
		return getByCriteria(eq("id", identifier));
	}
	
	@SuppressWarnings("unchecked")
	public Credential getByCriteria(Criterion... criterions) {
		Criteria criteria = createCriteria(criterions);
		criteria.setMaxResults(1);
		List<Credential> list = criteria.list();
		return (!list.isEmpty()) ? list.iterator().next() : null;
	}
	
	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = session.createCriteria(Credential.class);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return criteria;
	}
	
	public void save(Credential credential) {
		Transaction tx = session.beginTransaction();
		session.save(credential);
		tx.commit();
	}
	
	public void update(Credential credential) {
		Transaction tx = session.beginTransaction();
		session.update(credential);
		tx.commit();
	}
	
	public void saveOrUpdate(Credential credential) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(credential);
		tx.commit();
	}
	
	public void delete(Credential credential) {
		Transaction tx = session.beginTransaction();
		session.delete(credential);
		tx.commit();
	}

	
	
}
