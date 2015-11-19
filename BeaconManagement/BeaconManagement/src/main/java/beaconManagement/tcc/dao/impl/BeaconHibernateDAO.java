/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconDAO;
import beaconManagement.tcc.domain.Beacon;

@Repository
@Transactional
public class BeaconHibernateDAO implements BeaconDAO {

	@Autowired
	public SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.BeaconDAO#insert(beaconManagement.tcc.domain
	 * .Beacon)
	 */
	public void insert(Beacon beacon) {
		sessionFactory.getCurrentSession().persist(beacon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconDAO#delete(beaconManagement.tcc.domain
	 * .Beacon)
	 */
	public void delete(Beacon beacon) {
		sessionFactory.getCurrentSession().delete(beacon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconDAO#edit(beaconManagement.tcc.domain.Beacon
	 * )
	 */
	public void edit(Beacon beacon) {
		sessionFactory.getCurrentSession().merge(beacon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconDAO#list()
	 */
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
	public Beacon findById(Long id) {
		Beacon item = (Beacon) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon b where b.id=" + id)
				.uniqueResult();
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconDAO#findByMac(java.lang.String)
	 */
	public Beacon findByMac(String mac) {
		Beacon item = (Beacon) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon b where b.mac=" + mac)
				.uniqueResult();
		return item;
	}

}
