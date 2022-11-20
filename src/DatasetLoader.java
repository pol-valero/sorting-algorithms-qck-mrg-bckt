package src;

import java.nio.file.Files;
import java.nio.file.Path;


import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

public class DatasetLoader {

    private String separator = ";";
    private Path path = Path.of("datasets/fleetXS.txt");

    private Vessel csvLineToVessel (String csvLine) {
        String[] field = csvLine.split(separator);
        Vessel vessel = new Vessel(Integer.parseInt(field[0]), field[1], field[2], Float.parseFloat(field[3]), Float.parseFloat(field[4]),
                                    Integer.parseInt(field[5]), Integer.parseInt(field[6]), field[7], Integer.parseInt(field[8]), field[9]);

        return vessel;
    }

    public LinkedList<Vessel> loadVessels() {

        boolean firstLine = true;

        LinkedList<Vessel> vesselsList = new LinkedList<>();

        try {
            List<String> csvLines = Files.readAllLines(path);

            for (String csvLine : csvLines) {
                if(!firstLine) {
                    vesselsList.add(csvLineToVessel(csvLine));
                } else {
                    firstLine = false;
                }
            }

            return vesselsList;
        } catch (IOException e) {
            return vesselsList;
        }
    }

}
