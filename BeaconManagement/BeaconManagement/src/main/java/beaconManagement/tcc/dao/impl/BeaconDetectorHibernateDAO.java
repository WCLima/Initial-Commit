/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconDetectorDAO;
import beaconManagement.tcc.domain.BeaconDetector;

@Repository
@Transactional
public class BeaconDetectorHibernateDAO implements BeaconDetectorDAO {

	@Autowired
	public SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#insert(beaconManagement.tcc
	 * .domain.BeaconDetector)
	 */
	public void insert(BeaconDetector detector) {
		sessionFactory.getCurrentSession().persist(detector);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#delete(beaconManagement.tcc
	 * .domain.BeaconDetector)
	 */
	public void delete(BeaconDetector detector) {
		if (findById(detector.getId()) != null) {
			sessionFactory.getCurrentSession().delete(detector);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#edit(beaconManagement.tcc.
	 * domain.BeaconDetector)
	 */
	public void edit(BeaconDetector detector) {
		if (findById(detector.getId()) != null) {
			sessionFactory.getCurrentSession().merge(detector);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDetectorDAO#list()
	 */
	@SuppressWarnings("unchecked")
	public List<BeaconDetector> list() {
		List<BeaconDetector> list = sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.BeaconDetector").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.BeaconDetectorDAO#findById(java.lang.Long)
	 */
	public BeaconDetector findById(Long id) {
		BeaconDetector item = (BeaconDetector) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.BeaconDetector b where b.beacondetector_id="
								+ id).uniqueResult();
		return item;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDetectorDAO#findByMac(java.lang.String)
	 */
	public BeaconDetector findByMac(String mac) {
		BeaconDetector item = (BeaconDetector) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.BeaconDetector b where b.mac=" + mac)
				.uniqueResult();
		return item;
	}

}
