/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconDetectorDAO;
import beaconManagement.tcc.domain.BeaconDetector;

@Repository
public class BeaconDetectorHibernateDAO extends CommonDAOImpl implements
BeaconDetectorDAO {

	private static final Logger LOGGER = Logger
			.getLogger(BeaconDetectorHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDetectorDAO#list()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BeaconDetector> list() {
		List<BeaconDetector> list = null;
		try {
			list = getCurrentSession().createQuery("from BeaconDetector")
					.list();
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
	@Transactional(readOnly = true)
	public BeaconDetector findById(Long id) {
		BeaconDetector item = null;
		try {
			item = (BeaconDetector) getCurrentSession().createQuery(
					"from BeaconDetector b where b.beacondetector_id=" + id)
					.uniqueResult();
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
	@Transactional(readOnly = true)
	public BeaconDetector findByMac(String mac) {
		BeaconDetector item = null;
		try {
			item = (BeaconDetector) getCurrentSession().createQuery(
					"from BeaconDetector b where b.mac=" + mac).uniqueResult();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find the MAC: " + e);
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#insert(beaconManagement.tcc
	 * .domain.BeaconDetector)
	 */
	@Transactional(readOnly = true)
	public boolean insert(BeaconDetector item) {
		try {
			getCurrentSession().persist(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot insert:" + e);
			return false;
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
	@Transactional(readOnly = true)
	public boolean edit(BeaconDetector item) {
		try {
			getCurrentSession().merge(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot edit:" + e);
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
	@Transactional(readOnly = true)
	public boolean delete(BeaconDetector item) {
		try {
			getCurrentSession().delete(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot delete:" + e);
			return false;
		}
		return true;
	}
}
