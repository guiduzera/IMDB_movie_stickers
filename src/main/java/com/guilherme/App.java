package com.guilherme;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        JsonParser jsonParser = new JsonParser();
        ApiConsumer apiConsumer = new ApiConsumer(url, jsonParser);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(
                    "Olá, seja bem vindo ao sistema de listagem de filmes. Digite o número da opção desejada:");
            System.out.println("1 - Listar filmes");
            System.out.println("2 - Criar Figurinha");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();
            while (opcao != 3) {
                switch (opcao) {
                    case 1:
                        System.out.println("\nListando filmes...\n");
                        List<Map<String, String>> response = apiConsumer.getResponseAsList();
                        MovieListGenerate movieListGenerate = new MovieListGenerate(response);
                        movieListGenerate.generate();
                        System.out.println("Digite o número da opção desejada:");
                        System.out.println("1 - Listar filmes");
                        System.out.println("2 - Criar Figurinha");
                        System.out.println("3 - Sair");
                        opcao = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("\n------------------------\n");
                        System.out.println("Ops, essa opção ainda não está disponível.");
                        System.out.println("\n-------------------------\n");
                        System.out.println("Digite o número da opção desejada:");
                        System.out.println("1 - Listar filmes");
                        System.out.println("2 - Criar Figurinha");
                        System.out.println("3 - Sair");
                        opcao = scanner.nextInt();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        System.out.println("Digite o número da opção desejada:");
                        System.out.println("1 - Listar filmes");
                        System.out.println("2 - Criar Figurinha");
                        System.out.println("3 - Sair");
                        opcao = scanner.nextInt();
                        break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
