package com.core.order.ordersaga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.core.order.core.events.OrderCreatedEvent;



@Saga

public class OrderSaga {

	
	@Autowired
	 private transient CommandGateway commandGateway;
	
	@SagaEventHandler(associationProperty = "orderId")
	@StartSaga
	public void hanlde(OrderCreatedEvent event)
	{
		
	}
	    	
}
