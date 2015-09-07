package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.service.BeaconService;

@Controller
@RequestMapping(value = "/beacons")
public class BeaconController {

	@Autowired
	private BeaconService beaconService;

	@RequestMapping(value = "/list_beacons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Beacon> getBeacons() {
		return beaconService.getBeacons();
	}

}
