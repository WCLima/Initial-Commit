package beaconManagement.tcc.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/list_checkInsByDate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInByCalendar(@RequestBody Calendar calendar) {
		return checkInService.getCheckInByCalendar(calendar);
	}

	@RequestMapping(value = "/list_checkInsFromDate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInFromCalendar(@RequestBody Calendar calendar) {
		return checkInService.getCheckInFromCalendar(calendar);
	}

	@RequestMapping(value = "/list_checkInsBeforeDate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInBeforeCalendar(@RequestBody Calendar calendar) {
		return checkInService.getCheckInBeforeCalendar(calendar);
	}
}
