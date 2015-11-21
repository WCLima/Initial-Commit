package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;

public interface BeaconDetectorService {

	void insertBeaconDetector(BeaconDetector beacon);

	void deleteBeaconDetector(BeaconDetector beacon);

	void editBeaconDetector(BeaconDetector beacon);

	List<BeaconDetector> getAllBeaconDetector();

	BeaconDetector getBeaconDetectorByMac(String mac);

}
