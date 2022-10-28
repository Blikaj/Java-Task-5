import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class labnew {

    public static void main(String[] args){
        HashMap dict = readfile("dict");
        System.out.println(dict);
        Scanner in=new Scanner(System.in);
        String ch = "-1";
        while (ch != "3") {
            System.out.println("\n");
            System.out.println(
                    """
                            ============Text Main Menu =============
                                                    
                            0- print contents of 'Input.txt'
                            1- find word by key
                            2- find key by word
                            3- exit
                            """);
            ch = in.next();
            switch(ch){
                case "0" -> {
                    dict.forEach((key, value) -> {
                        System.out.println(key+" "+value);
                    });
                    break;
                }
                case "1" -> {
                    findword(in, dict);
                    break;
                }
                case "2" -> {
                    findkey(in, dict);
                    break;
                }
                case "3" -> {
                    ch = "3";
                    break;
                }
                default -> {
                    ch = "-1";
                    System.out.print("Wrong choise, my friend!");
                    break;
                }
            }
        }

    }

    public static void findkey(Scanner in, HashMap dict){
        System.out.println("Input word to find key");
        String keytofind = in.next();
        dict.forEach((key, value) -> {
            if (value.equals(keytofind)) {System.out.println(key+":"+value);};});
    }

    public static void findword(Scanner in, HashMap dict){
        System.out.println("Input key of word to find");
        String key = in.next();
        if (dict.containsKey(key)){
            System.out.println(dict.get(key));
        } else {
            System.out.println("Key not found ");
        }
        /*dict.forEach((key, value) -> {
            if (key.equals(keytofind)) {System.out.println(key+":"+value);};
        });*/
    }

    public static HashMap readfile(String filename){
        HashMap<String, String> dict = new HashMap<>();
        StringBuilder sb = new StringBuilder();;
        System.out.println(String.format("Reading file [%s] using FileReader",filename));
        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] subStr;
                subStr = line.split(":");
                System.out.println(subStr[0]);
                dict.put(subStr[0], subStr[1]);
            }
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        return dict;
    }
}
