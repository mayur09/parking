package com.pg.coupon.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "parking_coupon")
public class ParkingCoupon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "name", length = 50, nullable = true)
	private String name;

	@Column(name = "coupon_type", length = 50, nullable = true)
	private Integer couponType;

	@Column(name = "expiry_date")
	private Calendar expiryDate;

	@ManyToMany
	@JoinTable(name = "coupon_location", joinColumns = { @JoinColumn(name = "coupon_id", nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "location_id", nullable = true) })
	protected Set<ParkingLocation> parkingLocations = new HashSet<ParkingLocation>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Calendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Set<ParkingLocation> getParkingLocations() {
		return parkingLocations;
	}

	public void setParkingLocations(Set<ParkingLocation> parkingLocations) {
		this.parkingLocations = parkingLocations;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && this.getClass() == org.hibernate.Hibernate.getClass(obj)) {
			ParkingCoupon parkingCoupon = (ParkingCoupon) obj;
			return parkingCoupon.getId() != null && parkingCoupon.getId().equals(this.getId());
		} else {
			return false;
		}
	}

}
