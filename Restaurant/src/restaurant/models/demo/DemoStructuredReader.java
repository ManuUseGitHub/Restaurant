/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import restaurant.models.parsers.DishParser;

/**
 *
 * @author MAZE2
 */
public class DemoStructuredReader {
    
    public static void main(String[] args) {
        Path cheminFichierEntree = Paths.get("generated\\2026687372\\Soupe aux cressons");

        DishParser pars = new DishParser();
        try (BufferedReader entree = Files.newBufferedReader(cheminFichierEntree, StandardCharsets.UTF_8)) {
            String lignelue = entree.readLine();
            while (lignelue != null) {
                String[] lignesAvecColonnes = lignelue.split(":");
                if (lignesAvecColonnes.length > 1) {
                    pars.completeEtudiant(lignelue, lignesAvecColonnes[1]);
                } else if(lignesAvecColonnes.length == 1) {
                    pars.completeEtudiant(lignelue.trim(), lignesAvecColonnes[0]);
                }
                lignelue = entree.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Le chemin spécifié est inaccessible");
            ex.printStackTrace(System.err);
        }
        pars.getPlats().stream().forEach((etu) -> {
            System.out.println(etu.toString());
        });
    }
}
