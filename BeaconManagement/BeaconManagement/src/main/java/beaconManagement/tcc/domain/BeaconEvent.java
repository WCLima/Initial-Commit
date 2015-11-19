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
@Table(name = "beaconEvent", schema = "management")
public class BeaconEvent implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private Calendar startCalendar;

	@NotBlank
	private Calendar endCalendar;

	public BeaconEvent() {
		super();
	}

	public BeaconEvent(Long id, Calendar startCalendar, Calendar endCalendar) {
		super();
		this.id = id;
		this.startCalendar = startCalendar;
		this.endCalendar = endCalendar;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beaconevent_id")
	@SequenceGenerator(name = "sq_beaconevent_id", sequenceName = "management.SQ_BEACONEVENT_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getStartCalendar() {
		return startCalendar;
	}

	public void setStartCalendar(Calendar startCalendar) {
		this.startCalendar = startCalendar;
	}

	public Calendar getEndCalendar() {
		return endCalendar;
	}

	public void setEndCalendar(Calendar endCalendar) {
		this.endCalendar = endCalendar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endCalendar == null) ? 0 : endCalendar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((startCalendar == null) ? 0 : startCalendar.hashCode());
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
		BeaconEvent other = (BeaconEvent) obj;
		if (endCalendar == null) {
			if (other.endCalendar != null)
				return false;
		} else if (!endCalendar.equals(other.endCalendar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startCalendar == null) {
			if (other.startCalendar != null)
				return false;
		} else if (!startCalendar.equals(other.startCalendar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconEvent [id=" + id + ", startCalendar=" + startCalendar
				+ ", endCalendar=" + endCalendar + "]";
	}

}
