/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

@Repository
public class CheckInHibernateDAO implements CheckInDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = Logger
			.getLogger(CheckInHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#insert(beaconManagement.tcc.domain
	 * .CheckIn)
	 */
	@Transactional
	public boolean insert(CheckIn check) {
		try {
			sessionFactory.getCurrentSession().persist(check);
		} catch (Exception e) {
			LOGGER.error("Cannot insert: " + e);
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#list()
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CheckIn> list() {
		List<CheckIn> list = sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.checkin c").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#findById(java.lang.Long)
	 */
	@Transactional
	public CheckIn findById(Long id) {
		CheckIn checkIn = (CheckIn) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.checkin c where c.id=" + id);
		return checkIn;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findByCalendar(java.util.Calendar)
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByCalendar(Calendar calendar) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.checkCalendar="
								+ calendar).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#findByStatus(boolean)
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByBeaconEvent(BeaconEvent event) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.beaconevent_id = "
								+ event.getId()).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findByBeaconDetector(beaconManagement
	 * .tcc.domain.BeaconDetector)
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByBeaconDetector(BeaconDetector detector) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.beacondetector_id = "
								+ detector.getId()).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findFromCalendar(java.util.Calendar)
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CheckIn> findFromCalendar(Calendar calendar) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.checkCalendar > "
								+ calendar).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findBeforeCalendar(java.util.Calendar
	 * )
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CheckIn> findBeforeCalendar(Calendar calendar) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.checkCalendar < "
								+ calendar).list();
		return list;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
