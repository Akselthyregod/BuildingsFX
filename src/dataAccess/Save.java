package dataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Save {



    public static void save(UUID uuid, String input) throws FileNotFoundException {
        try {
        File file = new File("DATA.txt");

        if (!file.exists()){
            file.createNewFile();
        }

            ArrayList<String> content = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                content.add(scanner.nextLine());
            }

            if(content.size() == 0){
                content.add("DATA FOR PROJECT");
            }

            ArrayList<String> temp = new ArrayList<>();

            for ( String string :
                    content ) {

                temp.add(string);

                if(string.equals(uuid.toString())){
                    temp.add(input);
                }
            }

            int count = 0;
            for ( String string : content){
                if (string.equals(uuid.toString())){
                    count++;
                }
            }
            if(count == 0){
                temp.add("");
                temp.add(uuid.toString());
                temp.add(input);
            }

            content = temp;

            PrintWriter pw = new PrintWriter(file);


            for ( String fileString :
                    content ) {
                pw.println(fileString);
            }

            pw.close();


        } catch(FileNotFoundException e){
                System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws FileNotFoundException {

       save(UUID.randomUUID(), "Test");

    }
}
