package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;

public interface BeaconDetectorDAO {

	void insert(BeaconDetector detector);

	void edit(BeaconDetector detector);

	void delete(BeaconDetector detector);

	List<BeaconDetector> list();

	BeaconDetector findById(Long id);

	BeaconDetector findByMac(String mac);
}
