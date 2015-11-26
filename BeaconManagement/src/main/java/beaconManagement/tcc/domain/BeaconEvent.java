package beaconManagement.tcc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "beaconevent", schema = "management")
public class BeaconEvent implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private Long startDateMillis;

	@NotBlank
	private Long endDateMillis;

	public BeaconEvent(Long id, Long startDateMillis, Long endDateMillis) {
		super();
		this.id = id;
		this.startDateMillis = startDateMillis;
		this.endDateMillis = endDateMillis;
	}

	@Id
	@Column(name = "beaconevent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beaconevent_id")
	@SequenceGenerator(name = "sq_beaconevent_id", sequenceName = "management.SQ_BEACONEVENT_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStartDateMillis() {
		return startDateMillis;
	}

	public void setStartDateMilis(Long startDateMillis) {
		this.startDateMillis = startDateMillis;
	}

	public Long getEndDateMillis() {
		return endDateMillis;
	}

	public void setEndDateMilis(Long endDateMillis) {
		this.endDateMillis = endDateMillis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endDateMillis == null) ? 0 : endDateMillis.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((startDateMillis == null) ? 0 : startDateMillis.hashCode());
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
		if (endDateMillis == null) {
			if (other.endDateMillis != null)
				return false;
		} else if (!endDateMillis.equals(other.endDateMillis))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startDateMillis == null) {
			if (other.startDateMillis != null)
				return false;
		} else if (!startDateMillis.equals(other.startDateMillis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconEvent [id=" + id + ", startDateMillis=" + startDateMillis
				+ ", endDateMillis=" + endDateMillis + "]";
	}

}
