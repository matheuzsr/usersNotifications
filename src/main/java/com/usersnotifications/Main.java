/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.usersnotifications;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author logcomex
 */
public class Main {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();

        System.out.println(dotenv.get("VERSION"));
    }
}
