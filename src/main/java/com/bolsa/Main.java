package com.bolsa;

import java.io.IOException;

public class Main {

    public static Empresa empresa;

    public static void main(String[] args) throws IOException {
        Setup.run();
        Menu.runConsole();
    }
}
