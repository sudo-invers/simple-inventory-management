package com.invers.management;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	
    @Id @GeneratedValue @Column (name="product_id", updatable = false)
	private UUID productId;
	
    @Column (name="product_date", nullable=false, insertable=false, 
    		 updatable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") 
	private LocalDateTime productDate;
	
    @Column (name="product_name", nullable=false)
	private String productName;

	public LocalDateTime getProductDate() {
		return productDate;
	}

	public void setProductDate(LocalDateTime productDate) {
		this.productDate = productDate;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId +
				", productDate=" + productDate +
				", productName=" + productName
				+ "]";
	}
	

}