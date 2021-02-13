package com.htc.service.entity;

import java.io.Serializable;

public class Service implements Serializable
{
	private String serviceId;
	private String serviceDesc;
	private String price;
	private String status;
	
	public Service() {
		super();
	}
	
	public Service(String serviceId, String serviceDesc, String price, String status) {
		super();
		this.serviceId = serviceId;
		this.serviceDesc = serviceDesc;
		this.price = price;
		this.status = status;
	}

	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceDesc=" + serviceDesc + ", price=" + price + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((serviceDesc == null) ? 0 : serviceDesc.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Service other = (Service) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (serviceDesc == null) {
			if (other.serviceDesc != null)
				return false;
		} else if (!serviceDesc.equals(other.serviceDesc))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}	
