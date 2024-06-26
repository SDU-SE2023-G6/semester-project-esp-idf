package dk.sdu.snem.core;

import dk.sdu.snem.core.model.Log;
import dk.sdu.snem.core.model.Satellite;
import dk.sdu.snem.core.repo.LogRepository;
import dk.sdu.snem.core.repo.SatelliteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class SatelliteService {
    private static final Logger logger = LoggerFactory.getLogger(SatelliteService.class);

    private final SatelliteRepository satelliteRepo;
    private final LogRepository logRepo;


    public SatelliteService(SatelliteRepository satelliteRepo, LogRepository logRepo) {
        this.satelliteRepo = satelliteRepo;
        this.logRepo = logRepo;
    }

    public void checkSatellites() {
        Instant now = Instant.now();

        for (Satellite satellite : satelliteRepo.findAll()) {
            if (satellite.getNextExpectedHeartbeat() != null) {
                logger.info("Inside at %s".formatted(satellite.getNextExpectedHeartbeat().toString()));
                logger.info("Is before %s".formatted(satellite.getNextExpectedHeartbeat().isBefore(now)));
                logger.info("Now is %s".formatted(now.toString()));
            }
            if (satellite.getNextExpectedHeartbeat() != null && satellite.getNextExpectedHeartbeat().isBefore(now.minus(Duration.ofMinutes(2)))) {
                satellite.setStatus(Satellite.SatelliteStatus.OFFLINE);
                satelliteRepo.save(satellite);

                Log errorLog = new Log();
                errorLog.setTimestamp(now);
                errorLog.setMessage("Satellite did not report back in expected time, assuming it is offline");
                errorLog.setSatellite(satellite);
                errorLog.setType(Log.LogType.ERROR);
                logRepo.save(errorLog);
            }
        }
    }
}
