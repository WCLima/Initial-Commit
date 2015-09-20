package beaconManagement.tcc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "beacon", schema = "management")
public class Beacon implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	@Pattern(regexp = "^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$")
	private String mac;

	public Beacon() {
		super();
	}

	public Beacon(long id, String name, String mac) {
		super();
		this.id = id;
		this.name = name;
		this.mac = mac;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beacon_id")
	@SequenceGenerator(name = "sq_beacon_id", sequenceName = "management.SQ_BEACON_ID", initialValue = 1, allocationSize = 1)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "Beacon [id=" + id + ", name=" + name + ", mac=" + mac + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Beacon other = (Beacon) obj;
		if (id != other.id)
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
