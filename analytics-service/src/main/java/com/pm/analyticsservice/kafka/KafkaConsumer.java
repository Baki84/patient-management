package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

import java.nio.charset.StandardCharsets;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient", groupId = "analytic-service")
    public void consumeEvent(
            byte[] event,

            @Header(value = "source-service", required = false) byte[] sourceHeader,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset
    ) {

        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);

            String sourceService = sourceHeader != null
                    ? new String(sourceHeader, StandardCharsets.UTF_8)
                    : "unknown";

            log.info(
                    "Received Event -> Source={}, EventType={}, PatientId={}, Name={}, Email={}, Topic={}, Partition={}, Offset={}",
                    sourceService,
                    patientEvent.getEventType(),
                    patientEvent.getPatientId(),
                    patientEvent.getName(),
                    patientEvent.getEmail(),
                    topic,
                    partition,
                    offset
            );

            // TODO: call analytic logic here

        } catch (InvalidProtocolBufferException e) {
            log.error("Failed to deserialize PatientEvent. Topic={}, Partition={}, Offset={}",
                    topic, partition, offset, e);
        } catch (Exception e) {
            log.error("Unexpected error while processing event. Topic={}, Partition={}, Offset={}",
                    topic, partition, offset, e);
        }
    }
}