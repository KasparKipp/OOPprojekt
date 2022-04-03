package com.projekt.Ridebuddy.rides.service;

import com.projekt.Ridebuddy.rides.dao.RideDao;
import com.projekt.Ridebuddy.rides.dao.SampleRideDataAccessService;
import com.projekt.Ridebuddy.rides.model.Ride;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadFiles {

    /**
     * The example .csv input file each row is split into an array and each
     * index is the following value:
     * ride date [0]; address [1]; price [2]; booking fee [3]; distance rate [4];
     * cancel fee [5]; tip [6]; currency [7]; payment method [8];
     * time of payment [9]; distance [10]; ride status [11];
     *
     * @param fileName name of the file
     * @return List of all rides in the current file
     */
    public static RideDao readFile(String fileName) {
        Path path = Path.of(fileName);
        RideDao rideDao = new SampleRideDataAccessService();

        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(",");

                //ToDo use the RideDateFormatter.java class
                LocalDateTime parsedRideDate = LocalDateTime.parse(info[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);

                int paymentMethod;
                /*
                index is used in case the address contains a comma. In which case the
                index is increased by 1 so that the Ride class can have the correct values
                for each value.
                 */
                int index = 1;
                String parsedAddress = info[index++];
                /*
                 info[2] should be the price of the ride in case the address doesn't include a comma in it.
                 Otherwise, the index is increased by one so that the Ride object will get the correct values in each field.
                 For example "Uus Tänav 61, Тарту"
                 */
                if (info[2].contains("\"")) {
                    parsedAddress += ", " + info[index++];
                }
                int parsedPrice = Integer.parseInt(info[index++]);
                /*
                bookingFee and roadFee is not applicable in Estonia.
                 */
                double parsedBookingFee = Double.parseDouble(info[index++]);
                double parsedRoadFee = Double.parseDouble(info[index++]);
                double parsedCancellationFee = Double.parseDouble(info[index++]);
                double parsedTip = Double.parseDouble(info[index++]);
                char parsedCurrency = info[index++].charAt(0);
                switch (info[index++]) {
                    case "cash":
                        paymentMethod = 69;
                    case "app_payment":
                        paymentMethod = 70;
                    case "card_payment":
                        paymentMethod = 71;
                    default:
                        paymentMethod = 0;
                }

                //ToDo use the RideDateFormatter.java class
                LocalDateTime parsedTimeOfPayment = LocalDateTime.parse(info[index++]);

                int parsedRideDistance = Integer.parseInt(info[index++]);
                // rideStatus is not necessasry for end-user. Since by default it is marked as "Finished"
                String parsedRideStatus = info[index];
                Ride ride = new Ride(parsedRideDate, parsedAddress, parsedPrice, parsedCancellationFee,
                        parsedTip, parsedCurrency, paymentMethod, parsedRideDistance, parsedTimeOfPayment);

                rideDao.insertRide("BOLT", ride);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rideDao;
    }
}