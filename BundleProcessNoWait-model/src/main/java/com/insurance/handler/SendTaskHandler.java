package com.insurance.handler;

//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import org.springframework.stereotype.Component;

/************ begin RabbitMQ import ****************
import org.springframework.amqp.rabbit.core.RabbitTemplate;
/************ end RabbitMQ import ****************/

@Component
public class SendTaskHandler implements WorkItemHandler {

    // private static final Logger logger = LoggerFactory.getLogger(SendTaskHandler.class);

    /********** begin RabbitMQ code *
    private final RabbitTemplate rabbitTemplate = new RabbitTemplate();
    /********** end RabbitMQ code */

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

        String message = (String) workItem.getParameter("Message");
        // logger.debug("Sending message: {}", message);
        System.out.println("===============> Sending Message ================");
        /************** being RabbitMQ code *
        //rabbitTemplate.convertAndSend("spring-boot-exchange","foo.bar.baz",message);
        /************** end RabbitMQ code */

        manager.completeWorkItem(workItem.getId(), null);

    }

    @Override
    public  void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        // Do nothing, cannot be aborted
    }

}
