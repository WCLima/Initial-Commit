/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconEventDAO;
import beaconManagement.tcc.domain.BeaconEvent;

@Repository
public class BeaconEventHibernateDAO implements BeaconEventDAO {

	@Autowired
	public SessionFactory sessionFactory;

	private static Logger LOGGER = Logger
			.getLogger(BeaconEventHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#insert(beaconManagement.tcc.domain
	 * .BeaconEvent)
	 */
	@Transactional
	public boolean insert(BeaconEvent beaconEvent) {
		try {
			sessionFactory.getCurrentSession().persist(beaconEvent);
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
	 * beaconManagement.tcc.dao.BeaconEventDAO#save(beaconManagement.tcc.domain
	 * .BeaconEvent)
	 */
	@Transactional
	public boolean delete(BeaconEvent beaconEvent) {
		if (findById(beaconEvent.getId()) != null) {
			try {
				sessionFactory.getCurrentSession().delete(beaconEvent);
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
	 * beaconManagement.tcc.dao.BeaconEventDAO#edit(beaconManagement.tcc.domain
	 * .BeaconEvent)
	 */
	@Transactional
	public boolean edit(BeaconEvent beaconEvent) {
		if (findById(beaconEvent.getId()) != null) {
			try {
				sessionFactory.getCurrentSession().merge(beaconEvent);
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
	 * @see beaconManagement.tcc.dao.BeaconEventDAO#list()
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<BeaconEvent> list() {
		List<BeaconEvent> list = null;
		try {
			list = sessionFactory.getCurrentSession()
					.createQuery("from beaconMgm.BeaconEvent").list();
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
	@Transactional
	public BeaconEvent findById(Long id) {
		BeaconEvent event = null;
		try {
			event = (BeaconEvent) sessionFactory.getCurrentSession()
					.createQuery(
							"from beaconMgm.BeaconEvent be where be.beaconevent_id="
									+ id);
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
	@Transactional
	@SuppressWarnings("unchecked")
	public List<BeaconEvent> findByStartCalendar(Calendar startCalendar) {
		List<BeaconEvent> list = null;
		try {
			list = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from beaconMgm.BeaconEvent be where be.startCalendar="
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
	@Transactional
	@SuppressWarnings("unchecked")
	public List<BeaconEvent> findByEndCalendar(Calendar endCalendar) {
		List<BeaconEvent> list = null;
		try {
			list = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from beaconMgm.BeaconEvent be where be.endCalendar="
									+ endCalendar.getTime()).list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find End Calendar:" + e);
		}
		return list;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
