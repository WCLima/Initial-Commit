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

/**
 * @author Wagner
 */
@Entity
@Table(name = "beacondetector", schema = "management")
public class BeaconDetector implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property name="id"
	 */
	private Long id;

	/**
	 * @uml.property name="mac"
	 */
	@NotBlank
	private String mac;

	/**
	 * @uml.property name="location"
	 */
	private String location;

	public BeaconDetector() {
		super();
	}

	public BeaconDetector(Long id, String mac, String location) {
		super();
		this.id = id;
		this.mac = mac;
		this.location = location;
	}

	/**
	 * @return
	 * @uml.property name="id"
	 */
	@Id
	@Column(name = "beacondetector_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beacondetector_id")
	@SequenceGenerator(name = "sq_beacondetector_id", sequenceName = "management.SQ_BEACONDETECTOR_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * @uml.property name="id"
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property name="mac"
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param mac
	 * @uml.property name="mac"
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return
	 * @uml.property name="location"
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 * @uml.property name="location"
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
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
		BeaconDetector other = (BeaconDetector) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconDetector [id=" + id + ", mac=" + mac + ", location="
				+ location + "]";
	}

}
