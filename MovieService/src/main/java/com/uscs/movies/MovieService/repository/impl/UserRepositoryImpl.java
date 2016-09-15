package com.uscs.movies.MovieService.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.UserRepository;


@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public long addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		long id = (Long) session.save(user);
		logger.info("User added Successfully" + user);
		return id;
	}

	@Override
	public User getUser(long userId) {
		return (User) this.sessionFactory.getCurrentSession().get(UserImpl.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> search(String firstName, String lastName) {
//		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(User.class);
//		if (!StringUtils.isEmpty(firstName)) {
//			crit.add(Restrictions.like("firstName", "%" + firstName + "%"));
//		}
//		if (!StringUtils.isEmpty(lastName)) {
//			crit.add(Restrictions.like("lastName", "%" + lastName + "%"));
//		}
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("findUserByFn")
				.setString("firstName", "sharvil");
		List<User> searchResult = query.list();
//		List<User> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public void update(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);

	}

	@Override
	public void delete(long userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = getUser(userId);
		if (user != null) {
			session.delete(user);
			logger.info("User deleted successfully,User details=" + user);
		}

	}

	@Override
	public List<User> searchByFn(String firstName) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("findUserByFn").setString("firstName", firstName);
		List<User> searchResult = query.list();
		return searchResult;

	}

}
