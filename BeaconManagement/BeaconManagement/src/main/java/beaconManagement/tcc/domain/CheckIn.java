package beaconManagement.tcc.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "checkin", schema = "management")
public class CheckIn implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private Calendar checkCalendar;

	@NotBlank
	private Long beaconEvent_id;

	public CheckIn() {
		super();
	}

	public CheckIn(Long id, Calendar checkCalendar, Long beaconEvent_id) {
		super();
		this.id = id;
		this.checkCalendar = checkCalendar;
		this.beaconEvent_id = beaconEvent_id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_checkin_id")
	@SequenceGenerator(name = "sq_checkin_id", sequenceName = "management.SQ_CHECKIN_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCheckCalendar() {
		return checkCalendar;
	}

	public void setCheckCalendar(Calendar checkCalendar) {
		this.checkCalendar = checkCalendar;
	}

	public Long getBeaconEvent_id() {
		return beaconEvent_id;
	}

	public void setBeaconEvent_id(Long beaconEvent_id) {
		this.beaconEvent_id = beaconEvent_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beaconEvent_id == null) ? 0 : beaconEvent_id.hashCode());
		result = prime * result
				+ ((checkCalendar == null) ? 0 : checkCalendar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckIn other = (CheckIn) obj;
		if (beaconEvent_id == null) {
			if (other.beaconEvent_id != null)
				return false;
		} else if (!beaconEvent_id.equals(other.beaconEvent_id))
			return false;
		if (checkCalendar == null) {
			if (other.checkCalendar != null)
				return false;
		} else if (!checkCalendar.equals(other.checkCalendar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckIn [id=" + id + ", checkCalendar=" + checkCalendar
				+ ", beaconEvent_id=" + beaconEvent_id + "]";
	}

}
