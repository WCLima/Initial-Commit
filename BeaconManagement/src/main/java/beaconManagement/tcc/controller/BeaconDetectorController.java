package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.service.BeaconDetectorService;

/**
 * @author  Wagner
 */
@Controller
@RequestMapping(value = "/detector")
public class BeaconDetectorController {

	/**
	 * @uml.property  name="beaconDetectorService"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Autowired
	private BeaconDetectorService beaconDetectorService;

	@RequestMapping(value = "/list_detectors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BeaconDetector> getBeaconsDetectors() {
		return beaconDetectorService.getAllBeaconDetector();
	}

	@RequestMapping(value = "/find_detector_by_mac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeaconDetector getBeaconDetectorByMAC(@RequestBody String mac) {
		return beaconDetectorService.getBeaconDetectorByMac(mac);
	}

	@RequestMapping(value = "/insert_detector", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertBeaconEvent(@RequestBody BeaconDetector detector) {
		return beaconDetectorService.insertBeaconDetector(detector);
	}

	@RequestMapping(value = "/delete_detector", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteBeaconEvent(@RequestBody BeaconDetector detector) {
		return beaconDetectorService.deleteBeaconDetector(detector);
	}

	@RequestMapping(value = "/edit_detector", method = RequestMethod.POST)
	@ResponseBody
	public boolean editBeaconEvent(@RequestBody BeaconDetector detector) {
		return beaconDetectorService.editBeaconDetector(detector);
	}
}
