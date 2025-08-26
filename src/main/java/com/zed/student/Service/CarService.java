package com.zed.student.Service;

import com.zed.student.Class.Car;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    List<Car> cars;
    final String FILE_NAME = "database.csv";
    int currentMaxId = 0;

    public CarService() {
        cars = new ArrayList<Car>();
        readFromDisk();
    }

    public List<Car> getCars() {
        return cars;
    }
    public void deleteCar(int id){
        cars.removeIf(car -> car.getId() == id);
        writeToDisk();
    }

    public List<Car> searchCar(String keyword){
        if(keyword.trim().isEmpty()){
            return new ArrayList<>(cars);
        }

        String searchKeyword = keyword.toLowerCase();

        return cars.stream().filter(s ->{
            return (s.getMake() != null && s.getMake().toLowerCase().contains(searchKeyword)) ||
                    (s.getColor() != null && s.getColor().toLowerCase().contains(searchKeyword)) ||
                    (s.getBodyType() != null && s.getBodyType().toLowerCase().contains(searchKeyword)) ||
                    (s.getEngineType() != null && s.getEngineType().toLowerCase().contains(searchKeyword)) ||
                    (s.getTransmission() != null && s.getTransmission().toLowerCase().contains(searchKeyword));
        }).collect(Collectors.toList());
    }

    public Car getCarById(int id){
        for (Car car : cars) {
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }

    public void updateCar(int id, Car car){
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getId()== id){
                cars.set(i, car);
                writeToDisk();
                break;
            }
        }
    }

    public void addCar(Car car){
        car.setId(++currentMaxId);
        cars.add(car);
        writeToDisk();
    }

    public int getId(){
        if(cars.isEmpty()){
            return 1;
        }
        return cars.get(cars.size() - 1).getId() + 1;
    }

    public void writeToDisk(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            //write the content of the arraylist into csv
            System.out.println("Writing to file");
            for(Car s : cars){
                bw.write(s.getId() + ","
                        + s.getMake() + ","
                        + s.getYear() + ","
                        + s.getLicensePlateNumber() + ","
                        + s.getColor() + ","
                        + s.getBodyType() + ","
                        + s.getEngineType() + ","
                        + s.getTransmission()
                );
                bw.newLine();
            }
            System.out.println("Done writing to file");
        }catch(IOException e){
            System.out.println("Woah! Error: " + e.getMessage());
        }
    }

    /**
     * This read the CSV file and loads it to the students ArrayList
     */
    public void readFromDisk(){
        File file = new File(FILE_NAME);
        if(!file.exists()){
            System.out.println("file not found");
            return;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length >= 8) {
                    Car c = new Car();
                    c.setId(Integer.parseInt(data[0]));
                    c.setMake(data[1]);
                    c.setYear(Integer.parseInt(data[2]));
                    c.setLicensePlateNumber(data[3]);
                    c.setColor(data[4]);
                    c.setBodyType(data[5]);
                    c.setEngineType(data[6]);
                    c.setTransmission(data[7]);


                    //add coffee to the list
                    cars.add(c);

                    if (c.getId() > currentMaxId) {
                        currentMaxId = c.getId();
                    }
                }
            }
            System.out.println("Done reading from file");
        }catch(IOException e){
            System.out.println("Wow! Error: " + e.getMessage());
        }
    }
}
