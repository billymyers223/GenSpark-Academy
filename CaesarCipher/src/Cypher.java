import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class Cypher {
    public static void main(String[] args) throws IOException {
        Path pathToDe = Paths.get("./Raw.txt");
        Path pathToEn = Paths.get("./En.txt");

        Scanner scan = new Scanner(System.in);
        System.out.println("Please input text you'd like to encrypt");
        String encrypt = scan.nextLine();
        System.out.println("Please input a key for the text when it needs to be decrypted");
        int key = scan.nextInt();
        String retEn = "";
        String retDe = encrypt;
        char[] chars = encrypt.toCharArray();
        for (char c: chars){
            c+=4;
            retEn = retEn + c;
        }
        System.out.println(retEn);

        System.out.println("\nPlease enter your key:");
        int e = scan.nextInt();

        Files.write(pathToDe, Collections.singleton(retDe), StandardCharsets.UTF_8);
        Files.write(pathToEn, Collections.singleton(retEn), StandardCharsets.UTF_8);

        if(e == key){
            System.out.println(retDe);
        }else{
            System.out.println(retEn);
        }

    }
}
