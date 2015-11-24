package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.service.BeaconDetectorService;

@Controller
@RequestMapping(value = "/detectors")
public class BeaconDetectorController {

	@Autowired
	private BeaconDetectorService beaconDetectorService;

	@RequestMapping(value = "/list_detectors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BeaconDetector> getBeaconsDetectors() {
		return beaconDetectorService.getAllBeaconDetector();
	}

	@RequestMapping(value = "/detector_by_mac", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeaconDetector getBeaconDetectorByMAC(@RequestBody String mac) {
		return beaconDetectorService.getBeaconDetectorByMac(mac);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public boolean insertBeaconEvent(@RequestBody BeaconDetector detector) {
		return beaconDetectorService.insertBeaconDetector(detector);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean deleteBeaconEvent(@RequestBody BeaconDetector detector) {
		return beaconDetectorService.deleteBeaconDetector(detector);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public boolean editBeaconEvent(@RequestBody BeaconDetector detector) {
		return beaconDetectorService.editBeaconDetector(detector);
	}
}
