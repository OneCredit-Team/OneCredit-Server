package com.onecredict.onecredictserver.repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvRepository{

    public static String ConvertCsvtoJson() throws Exception{

        List<String> csvRows = null;
        try(var reader = Files.lines(Paths.get("/Users/jin-yulim/Desktop/OneCredict-Server/src/main/java/com/onecredict/onecredictserver/repository/dumi1.csv"))){
            csvRows = reader.collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
        }

        if(csvRows != null){

            String json = csvToJson(csvRows);
            System.out.println(json);
            return json;
        }

        return null;
    }

    public static String csvToJson(List<String> csv){

        //remove empty lines
        //this will affect permanently the list.
        //be careful if you want to use this list after executing this method
        csv.removeIf(e -> e.trim().isEmpty());

        //csv is empty or have declared only columns
        if(csv.size() <= 1){
            return "[]";
        }

        //get first line = columns names
        String[] columns = csv.get(0).split(",");

        //get all rows
        StringBuilder json = new StringBuilder("[\n");
        csv.subList(1, csv.size()) //substring without first row(columns)
                .stream()
                .map(e -> e.split(","))
                .filter(e -> e.length == columns.length) //values size should match with columns size
                .forEach(row -> {

                    json.append("\t[\n");

                    for(int i = 1; i < columns.length; i++){
                        json.append("\t\t\"")
                                .append(row[i])
                                .append("\",\n"); //comma-1
                    }

                    //replace comma-1 with \n
                    json.replace(json.lastIndexOf(","), json.length(), "\n");

                    json.append("\t],"); //comma-2

                });

        //remove comma-2
        json.replace(json.lastIndexOf(","), json.length(), "");

        json.append("\n]");

        return json.toString();

    }

}