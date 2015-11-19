package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beaconManagement.tcc.domain.CheckIn;
import beaconManagement.tcc.service.CheckInService;

@Controller
@RequestMapping(value = "/checkIns")
public class CheckInController {

	@Autowired
	private CheckInService checkInService;

	@RequestMapping(value = "/list_checkIns", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckIn() {
		return checkInService.getCheckIn();
	}

}
