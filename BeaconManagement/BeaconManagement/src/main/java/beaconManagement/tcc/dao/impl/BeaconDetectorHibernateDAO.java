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

import beaconManagement.tcc.dao.BeaconDetectorDAO;
import beaconManagement.tcc.domain.BeaconDetector;

@Repository
public class BeaconDetectorHibernateDAO implements BeaconDetectorDAO {

	@Autowired
	public SessionFactory sessionFactory;

	private static final Logger LOGGER = Logger
			.getLogger(BeaconDetectorHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#insert(beaconManagement.tcc
	 * .domain.BeaconDetector)
	 */
	@Transactional
	public boolean insert(BeaconDetector detector) {
		try {
			sessionFactory.getCurrentSession().persist(detector);
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
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#delete(beaconManagement.tcc
	 * .domain.BeaconDetector)
	 */
	@Transactional
	public boolean delete(BeaconDetector detector) {
		if (findById(detector.getId()) != null) {
			try {
				sessionFactory.getCurrentSession().delete(detector);
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
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#edit(beaconManagement.tcc.
	 * domain.BeaconDetector)
	 */
	@Transactional
	public boolean edit(BeaconDetector detector) {
		if (findById(detector.getId()) != null) {
			try {
				sessionFactory.getCurrentSession().merge(detector);
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
	 * @see beaconManagement.tcc.dao.BeaconDetectorDAO#list()
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<BeaconDetector> list() {
		List<BeaconDetector> list = null;
		try {
			list = sessionFactory.getCurrentSession()
					.createQuery("from beaconMgm.BeaconDetector").list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot list: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconDetectorDAO#findById(java.lang.Long)
	 */
	@Transactional
	public BeaconDetector findById(Long id) {
		BeaconDetector item = null;
		try {
			item = (BeaconDetector) sessionFactory
					.getCurrentSession()
					.createQuery(
							"from beaconMgm.BeaconDetector b where b.beacondetector_id="
									+ id).uniqueResult();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find the id: " + e);
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#findByMac(java.lang.String)
	 */
	@Transactional
	public BeaconDetector findByMac(String mac) {
		BeaconDetector item = null;
		try {
			item = (BeaconDetector) sessionFactory
					.getCurrentSession()
					.createQuery(
							"from beaconMgm.BeaconDetector b where b.mac="
									+ mac).uniqueResult();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find the MAC: " + e);
		}
		return item;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
