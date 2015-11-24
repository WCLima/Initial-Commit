/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconDAO;
import beaconManagement.tcc.domain.Beacon;

@Repository
public class BeaconHibernateDAO extends CommonDAOImpl implements BeaconDAO {

	private static final Logger LOGGER = Logger
			.getLogger(BeaconHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDAO#list()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Beacon> list() {
		List<Beacon> list = null;
		try {
			list = getCurrentSession().createQuery("from Beacon b").list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDAO#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	public Beacon findById(Long id) {
		Beacon item = null;
		try {
			item = (Beacon) getCurrentSession().createQuery(
					"from Beacon b where b.beacon_id=" + id).uniqueResult();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find id: " + e);
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDAO#findByMac(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public Beacon findByMac(String mac) {
		Beacon item = null;
		try {
			item = (Beacon) getCurrentSession().createQuery(
					"from Beacon b where b.mac=" + mac).uniqueResult();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find MAC: " + e);
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.CommonDAO#insert(java.lang.Object)
	 */
	@Transactional(readOnly = true)
	public boolean insert(Beacon item) {
		try {
			getCurrentSession().persist(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot insert: " + e);
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.CommonDAO#edit(java.lang.Object)
	 */
	@Transactional(readOnly = true)
	public boolean edit(Beacon item) {
		try {
			getCurrentSession().merge(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot edit: " + e);
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.CommonDAO#delete(java.lang.Object)
	 */
	@Transactional(readOnly = true)
	public boolean delete(Beacon item) {
		try {
			getCurrentSession().delete(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot delete: " + e);
			return false;
		}
		return true;
	}
}
