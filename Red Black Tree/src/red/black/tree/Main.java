package red.black.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        RBT_Methods methods = new RBT_Methods();
        RBT_Methods.Node node;
        String x;
        int loadFile = 0;
        boolean flag = true;
        ArrayList<String> dictionaryWords = new ArrayList();

        while (flag) {

            System.out.println("1.Load  2.Print Size  3.Insert  4.Search  5.Remove 6.Exit");
            System.out.print("Enter your choice : ");
            x = scan.next();

            switch (x) {
                case "1":
                    try {
                        File f = new File("words.txt");
                        BufferedReader b = new BufferedReader(new FileReader(f));
                        String readLine = "";
                        System.out.println("Loaded");
                        loadFile = 1;
                        while ((readLine = b.readLine()) != null) {
                            node = methods.new Node(readLine.toLowerCase());
                            methods.insert(node);
                            dictionaryWords.add(readLine.toLowerCase());
                        }
                    } catch (IOException e) {
                        System.out.println("File not found");
                    }
                    break;
                case "2":
                    if (loadFile == 1) {
                        int height = methods.treeHeight(methods.root);
                        System.out.println("Tree's height is : " + height);
                    } else {
                        System.out.println("No File Loaded");
                    }
                    break;
                case "3":
                    if (loadFile == 1) {
                        methods.flag = 0;
                        System.out.print("Enter the new word : ");
                        String newWord = scan.next().toLowerCase();
                        node = methods.new Node(newWord);
                        methods.search(node, methods.root);
                        if (methods.flag == 0) {
                            methods.insert(node);
                            methods.fixTree(node);
                            dictionaryWords.add(newWord);
                            int height = methods.treeHeight(methods.root);
                            System.out.println("Tree's height is " + height);
                            int size = methods.size(methods.root);
                            System.out.println("Tree's size is " + size);
                            PrintWriter writer = new PrintWriter("words.txt");
                            int i;
                            for (i = 0; i < dictionaryWords.size()-1; i++) {
                                writer.println(dictionaryWords.get(i));
                            }
                            writer.print(dictionaryWords.get(i));
                            writer.close();
                        } else {
                            System.out.println("Error word already exists ");
                        }
                    } else {
                        System.out.println("No File Loaded");
                    }
                    break;
                case "4":
                    if (loadFile == 1) {
                        methods.flag = 0;
                        System.out.print("Enter the word : ");
                        String searchWord = scan.next().toLowerCase();
                        node = methods.new Node(searchWord);
                        methods.search(node, methods.root);
                        if (methods.flag == 0) {
                            System.out.println("NotFound");
                        } else {
                            System.out.println("Found");
                        }
                    } else {
                        System.out.println("No File Loaded");
                    }
                    break;
                case "5":
                    if (loadFile == 1) {
                        System.out.print("Enter the word : ");
                        String deleteWord = scan.next().toLowerCase();
                        node = methods.new Node(deleteWord);
                        if (methods.delete(node)) {
                            System.out.println("Deletion Done!");
                            int height = methods.treeHeight(methods.root);
                            System.out.println("Tree's height is " + height);
                            int size = methods.size(methods.root);
                            System.out.println("Tree's size is " + size);
                            
                            PrintWriter writer = new PrintWriter("words.txt");
                            
                            for (int i = 0; i < dictionaryWords.size(); i++) {
                                if (deleteWord.equals(dictionaryWords.get(i))) {
                                    dictionaryWords.remove(i);
                                }
                            }
                            int j;
                            for (j = 0; j < dictionaryWords.size()-1; j++) {
                                    writer.println(dictionaryWords.get(j));
                                }
                            writer.print(dictionaryWords.get(j));
                            writer.close();
                        } else {
                            System.out.println("Word not found!");
                        }
                    } else {
                        System.out.println("No File Loaded");
                    }
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }
    }
}
