import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeSet;

import static java.util.Collections.replaceAll;

public class treeset {

    public static void main(String[] args){
        TreeSet<String> set = readfile("oldfile");
        System.out.println(set);
        writefile(set, "newfile");
    }

    public static TreeSet readfile(String filename){
        TreeSet set = new TreeSet<String>();
        System.out.println(String.format("Reading file [%s] using FileReader",filename));
        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] subStr;
                line = line.replaceAll("\\p{Punct}", "");
                subStr = line.split(" ");
                System.out.println(subStr);
                for (String i : subStr) {
                    if (!(set.contains(i))) {
                        set.add(i);
                    }
                };
            }
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        set.remove("");
        return set;
    }

    public static void writefile(TreeSet<String> set, String filename){
        System.out.println(String.format("Writing to file [%s]",filename));
        try {
            FileWriter myWriter = new FileWriter(filename);
            for (String i : set){
                myWriter.write(i + " ");
            }
            myWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
    }
}
