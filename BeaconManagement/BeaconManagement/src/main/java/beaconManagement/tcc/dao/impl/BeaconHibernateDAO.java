/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconDAO;
import beaconManagement.tcc.domain.Beacon;

@Repository
public class BeaconHibernateDAO implements BeaconDAO {

	@Autowired
	public SessionFactory sessionFactory;

	private static final Logger LOGGER = Logger
			.getLogger(BeaconHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconDAO#insert(beaconManagement.tcc.domain
	 * .Beacon)
	 */
	@Transactional
	public boolean insert(Beacon beacon) {
		try {
			sessionFactory.getCurrentSession().persist(beacon);
		} catch (HibernateException e) {
			LOGGER.error("Cannot insert: " + e);
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDAO#delete(beaconManagement.tcc.domain
	 * .Beacon)
	 */
	@Transactional
	public boolean delete(Beacon beacon) {
		if (findById(beacon.getId()) != null) {
			try {
				sessionFactory.getCurrentSession().delete(beacon);
			} catch (HibernateException e) {
				LOGGER.error("Cannot delete: " + e);
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDAO#edit(beaconManagement.tcc.domain.Beacon
	 * )
	 */
	@Transactional
	public boolean edit(Beacon beacon) {
		if (findById(beacon.getId()) != null) {
			try {
				sessionFactory.getCurrentSession().merge(beacon);
			} catch (HibernateException e) {
				LOGGER.error("Cannot edit: " + e);
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDAO#list()
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Beacon> list() {
		List<Beacon> list = sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDAO#findById(java.lang.Long)
	 */
	@Transactional
	public Beacon findById(Long id) {
		Beacon item = (Beacon) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon b where b.beacon_id=" + id)
				.uniqueResult();
		return item;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDAO#findByMac(java.lang.String)
	 */
	@Transactional
	public Beacon findByMac(String mac) {
		Beacon item = (Beacon) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon b where b.mac=" + mac)
				.uniqueResult();
		return item;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
