package dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

public class UserDao {

protected Session session;
	
	public UserDao() {
		session = SectionFactory.getSession();
	}
	
	public User findById(long identifier) {
		return getByCriteria(eq("id", identifier));
	}
	
	@SuppressWarnings("unchecked")
	public User getByCriteria(Criterion... criterions) {
		Criteria criteria = createCriteria(criterions);
		criteria.setMaxResults(1);
		List<User> list = criteria.list();
		return (!list.isEmpty()) ? list.iterator().next() : null;
	}
	
	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = session.createCriteria(User.class);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return criteria;
	}
	
	public void save(User user) {
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	
	public void update(User user) {
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}
	
	public void delete(User user) {
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}
	
}
