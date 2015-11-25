package beaconManagement.tcc.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.CheckIn;
import beaconManagement.tcc.service.CheckInService;

@Controller
@RequestMapping(value = "/checkin")
public class CheckInController {

	@Autowired
	private CheckInService checkInService;

	@RequestMapping(value = "/list_checkins", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckIn() {
		return checkInService.getCheckIn();
	}

	@RequestMapping(value = "/list_checkins_by_detector", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInByBeaconDetector(
			@RequestBody BeaconDetector detector) {
		return checkInService.getCheckInByBeaconDetector(detector);
	}

	@RequestMapping(value = "/list_checkins_by_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInByCalendar(@RequestBody Calendar calendar) {
		return checkInService.getCheckInByCalendar(calendar);
	}

	@RequestMapping(value = "/list_checkins_from_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInFromCalendar(@RequestBody Calendar calendar) {
		return checkInService.getCheckInFromCalendar(calendar);
	}

	@RequestMapping(value = "/list_checkins_before_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckIn> getCheckInBeforeCalendar(@RequestBody Calendar calendar) {
		return checkInService.getCheckInBeforeCalendar(calendar);
	}

	@RequestMapping(value = "/insert_checkin", method = RequestMethod.PUT)
	public boolean insertCheckIn(@RequestBody CheckIn checkIn) {
		return checkInService.insertCheckIn(checkIn);
	}
}
