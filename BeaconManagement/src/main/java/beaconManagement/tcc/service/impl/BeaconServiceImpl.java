/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.BeaconDAO;
import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.service.BeaconService;

/**
 * @author  Wagner
 */
@Service
public class BeaconServiceImpl implements BeaconService {

	/**
	 * @uml.property  name="beaconDao"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Autowired
	private BeaconDAO beaconDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconService#insertBeacon(beaconManagement
	 * .tcc.domain.Beacon)
	 */
	public boolean insertBeacon(Beacon beacon) {
		return beaconDao.insert(beacon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.BeaconService#saveBeacon(beaconManagement
	 * .tcc.domain.Beacon)
	 */
	public boolean deleteBeacon(Beacon beacon) {
		return beaconDao.delete(beacon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.BeaconService#editBeacon(beaconManagement
	 * .tcc.domain.Beacon)
	 */
	public boolean editBeacon(Beacon beacon) {
		return beaconDao.edit(beacon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.service.BeaconService#getBeacons()
	 */
	public List<Beacon> getBeacons() {
		return beaconDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.BeaconService#getBeaconByMac(java.lang.String
	 * )
	 */
	public Beacon getBeaconByMac(String mac) {
		return beaconDao.findByMac(mac);
	}

}
