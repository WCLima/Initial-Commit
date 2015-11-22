package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;

public interface BeaconDetectorDAO {

	boolean insert(BeaconDetector detector);

	boolean edit(BeaconDetector detector);

	boolean delete(BeaconDetector detector);

	List<BeaconDetector> list();

	BeaconDetector findById(Long id);

	BeaconDetector findByMac(String mac);
}
