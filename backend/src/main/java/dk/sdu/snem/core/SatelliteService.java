package dk.sdu.snem.core;

import dk.sdu.snem.core.model.Log;
import dk.sdu.snem.core.model.Satellite;
import dk.sdu.snem.core.repo.LogRepository;
import dk.sdu.snem.core.repo.SatelliteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SatelliteService {
    private static final Logger logger = LoggerFactory.getLogger(SatelliteService.class);

    private final SatelliteRepository satelliteRepo;
    private final LogRepository logRepo;

    private List<Satellite> satellites;

    public SatelliteService(SatelliteRepository satelliteRepo, LogRepository logRepo) {
        this.satelliteRepo = satelliteRepo;
        this.logRepo = logRepo;
        this.satellites = satelliteRepo.findAll();
    }

    public void checkSatellites() {
        Instant now = Instant.now();

        for (Satellite satellite : satellites) {
            System.out.println("Inside");
            System.out.println(satellite.getNextExpectedHeartbeat());
            if (satellite.getNextExpectedHeartbeat() != null) {System.out.println(satellite.getNextExpectedHeartbeat().isBefore(now));}
            System.out.println(now);
            if (satellite.getNextExpectedHeartbeat() != null && satellite.getNextExpectedHeartbeat().isBefore(now)) {
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
