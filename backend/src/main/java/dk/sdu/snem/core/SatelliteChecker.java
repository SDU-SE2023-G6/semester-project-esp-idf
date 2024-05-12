package dk.sdu.snem.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SatelliteChecker {
    private static final Logger logger = LoggerFactory.getLogger(SatelliteChecker.class);

    @Autowired
    private SatelliteService satelliteService;

    @Scheduled(fixedRate = 15000) // 15sec
    public void checkSatelliteStatus() {
        logger.info("Checking satellite status");
        satelliteService.checkSatellites();
    }
}
