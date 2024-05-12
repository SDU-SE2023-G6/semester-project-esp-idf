package dk.sdu.snem.core;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SatelliteChecker {

    @Autowired
    private SatelliteService satelliteService;

    @Scheduled(fixedRate = 15000) // 15sec
    public void checkSatelliteStatus() {
        System.out.println("Checking satellite status");
        satelliteService.checkSatellites();
    }
}
