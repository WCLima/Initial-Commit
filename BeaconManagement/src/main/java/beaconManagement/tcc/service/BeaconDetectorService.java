package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;

public interface BeaconDetectorService {

	boolean insertBeaconDetector(BeaconDetector beacon);

	boolean deleteBeaconDetector(BeaconDetector beacon);

	boolean editBeaconDetector(BeaconDetector beacon);

	List<BeaconDetector> getAllBeaconDetector();

	BeaconDetector getBeaconDetectorByMac(String mac);

}
