package CodeSnippetManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> Snippets = new ArrayList<>();

        System.out.println("Welcome to the CodeVault..");

        String codeSnippet = addSnippet();

        while (!codeSnippet.equalsIgnoreCase("done")) {
            Snippets.add(codeSnippet); // Add the code snippet itself, not the list
            codeSnippet = addSnippet();
        }

        // File check should be before saving the snippets
        File file = new File("CodeSnippets.txt");
        try {
            // opens the file - it will create a file if it doesn't exist
            PrintWriter fileOutput =
                    new PrintWriter(new BufferedWriter(new FileWriter(file)));

            // write to the file
            for (String itemName : Snippets) {
                fileOutput.println(itemName);
            }

            // close the file
            fileOutput.close();
            System.out.println("Code snippets saved to CodeSnippets.txt.");
        } catch (IOException ex) {
            System.out.println("An error occurred while saving the file: " + ex);
        }
    }

    private static String addSnippet() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your code snippet (type 'done' to finish):");
        String codeSnippet = keyboard.nextLine();
        return codeSnippet;
    }
}
