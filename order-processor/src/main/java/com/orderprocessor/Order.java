package com.orderprocessor;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	private UUID orderNumber;
	private BigDecimal amount;
	private Integer quantity;
	private UUID customerNumber;
	private double total;
	
}
