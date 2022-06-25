package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int passwordLength;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Password Generator!");
        System.out.println("Enter the password length");

        try {
            passwordLength = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Try again! Use only digits");
            passwordLength = Integer.parseInt(reader.readLine());
        }

        while (passwordLength <8 || passwordLength > 100) {
            System.out.println("Try again!\nThe password length: 8-100");
            passwordLength = Integer.parseInt(reader.readLine());
        }

        String password = PasswordGenerator.makePassword(passwordLength);
        System.out.println("Your password is: ");
        System.out.println(password);

    }
}