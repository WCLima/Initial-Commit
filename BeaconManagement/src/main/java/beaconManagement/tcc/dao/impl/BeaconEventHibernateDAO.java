/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconEventDAO;
import beaconManagement.tcc.domain.BeaconEvent;

@Repository
public class BeaconEventHibernateDAO extends CommonDAOImpl implements
BeaconEventDAO {

	private static Logger LOGGER = Logger
			.getLogger(BeaconEventHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconEventDAO#list()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BeaconEvent> list() {
		List<BeaconEvent> list = null;
		try {
			list = getCurrentSession().createQuery("from BeaconEvent").list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot list: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconEventDAO#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	public BeaconEvent findById(Long id) {
		BeaconEvent event = null;
		try {
			event = (BeaconEvent) getCurrentSession().createQuery(
					"from BeaconEvent be where be.beaconevent_id=" + id);
		} catch (HibernateException e) {
			LOGGER.error("Cannot find id: " + e);
		}
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#findByStartCalendar(java.util
	 * .Calendar)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BeaconEvent> findByStartCalendar(Calendar startCalendar) {
		List<BeaconEvent> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from BeaconEvent be where be.startCalendar="
							+ startCalendar.getTime()).list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find Start Calendar: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#findByEndCalendar(java.util.Calendar
	 * )
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BeaconEvent> findByEndCalendar(Calendar endCalendar) {
		List<BeaconEvent> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from BeaconEvent be where be.endCalendar="
							+ endCalendar.getTime()).list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find End Calendar:" + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.CommonDAO#insert(java.lang.Object)
	 */
	@Transactional(readOnly = true)
	public boolean insert(BeaconEvent item) {
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
	public boolean edit(BeaconEvent item) {
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
	public boolean delete(BeaconEvent item) {
		try {
			getCurrentSession().delete(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot delete: " + e);
			return false;
		}
		return true;
	}
}
