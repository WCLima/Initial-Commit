/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.BeaconDetectorDAO;
import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.service.BeaconDetectorService;

/**
 * @author  Wagner
 */
@Service
public class BeaconDetectorServiceImpl implements BeaconDetectorService {

	/**
	 * @uml.property  name="beaconDetectorDao"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Autowired
	private BeaconDetectorDAO beaconDetectorDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconDetectorService#insertBeaconDetector
	 * (beaconManagement.tcc.domain.BeaconDetector)
	 */
	public boolean insertBeaconDetector(BeaconDetector detector) {
		return beaconDetectorDao.insert(detector);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconDetectorService#deleteBeaconDetector
	 * (beaconManagement.tcc.domain.BeaconDetector)
	 */
	public boolean deleteBeaconDetector(BeaconDetector detector) {
		return beaconDetectorDao.delete(detector);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconDetectorService#editBeaconDetector
	 * (beaconManagement.tcc.domain.BeaconDetector)
	 */
	public boolean editBeaconDetector(BeaconDetector detector) {
		return beaconDetectorDao.edit(detector);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconDetectorService#getAllBeaconDetector()
	 */
	public List<BeaconDetector> getAllBeaconDetector() {
		return beaconDetectorDao.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconDetectorService#getBeaconDetectorByMac
	 * (java.lang.String)
	 */
	public BeaconDetector getBeaconDetectorByMac(String mac) {
		return beaconDetectorDao.findByMac(mac);
	}

}
