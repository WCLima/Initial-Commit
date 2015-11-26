/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconEventDAO;
import beaconManagement.tcc.domain.BeaconEvent;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
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
	public BeaconEvent findById(Long id) {
		BeaconEvent event = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from BeaconEvent be where be.beaconevent_id= :idEvent");
			query.setParameter("idEvent", id);
			event = (BeaconEvent) query.uniqueResult();
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
	public List<BeaconEvent> findByStartCalendar(Long startCalendar) {
		List<BeaconEvent> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from BeaconEvent be where be.startdatemilis= :calendar");
			query.setParameter("calendar", startCalendar);
			list = query.list();
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
	public List<BeaconEvent> findByEndCalendar(Long endCalendar) {
		List<BeaconEvent> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from BeaconEvent be where be.enddatemilis= :calendar");
			query.setParameter("calendar", endCalendar);
			list = query.list();
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
