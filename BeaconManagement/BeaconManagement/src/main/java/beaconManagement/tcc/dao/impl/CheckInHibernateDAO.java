/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

@Repository
@Transactional
public class CheckInHibernateDAO implements CheckInDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(CheckIn check) {
		sessionFactory.getCurrentSession().persist(check);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.CheckInDAO#list()
	 */
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
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByBeaconEvent(BeaconEvent event) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.beaconevent_id = "
								+ event.getId()).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CheckIn> findFromCalendar(Calendar calendar) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.checkCalendar > "
								+ calendar).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CheckIn> findBeforeCalendar(Calendar calendar) {
		List<CheckIn> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.checkin c where c.checkCalendar < "
								+ calendar).list();
		return list;
	}

}
