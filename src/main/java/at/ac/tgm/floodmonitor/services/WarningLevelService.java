package at.ac.tgm.floodmonitor.services;

import at.ac.tgm.floodmonitor.model.WarningLevel;
import org.springframework.stereotype.Service;

@Service
public class WarningLevelService {

    public WarningLevel calculateWarningLevel(double waterLevel) {

        if (waterLevel < 0) {
            return WarningLevel.UNKNOWN;
        }

        if (waterLevel < 2.0) {
            return WarningLevel.NORMAL;
        }

        if (waterLevel < 3.0) {
            return WarningLevel.WARNING;
        }

        return WarningLevel.CRITICAL;
    }
}