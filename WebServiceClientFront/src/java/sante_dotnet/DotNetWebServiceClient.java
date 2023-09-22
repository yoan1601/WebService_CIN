package sante_dotnet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DotNetWebServiceClient {
    
    public static Personne[] getLp () {
        try {
            String result = "";
            // URL de l'endpoint du service web .NET
            String serviceUrl = "http://localhost:5204/api/Personne/getSomePersonnes";
            
            // Créez une URL à partir de l'URL du service web
            URL url = new URL(serviceUrl);

            // Ouvrez une connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurez la méthode HTTP GET (ou POST si nécessaire)
            connection.setRequestMethod("GET");

            // Obtenez la réponse du service web
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lisez la réponse du service web
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

               // La réponse devrait contenir la somme
                result = response.toString();
                final Gson gson = new GsonBuilder().create();
                final Personne[] lp = gson.fromJson(result, Personne[].class);
                return lp;
                
            } else {
                System.out.println("Erreur lors de la communication avec le service web. Code de réponse : " + responseCode);
            }

            // Fermez la connexion
            connection.disconnect();
            return new Personne[0];

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static int add() {
        try {
            int result = 0;
            // URL de l'endpoint du service web .NET
            String serviceUrl = "http://localhost:5204/api/Calculator/add?num1=68&num2=100";
            
            // Créez une URL à partir de l'URL du service web
            URL url = new URL(serviceUrl);

            // Ouvrez une connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurez la méthode HTTP GET (ou POST si nécessaire)
            connection.setRequestMethod("GET");

            // Obtenez la réponse du service web
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lisez la réponse du service web
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // La réponse devrait contenir la somme
                result = Integer.parseInt(response.toString());
                System.out.println("Résultat de l'addition : " + result);
                
            } else {
                System.out.println("Erreur lors de la communication avec le service web. Code de réponse : " + responseCode);
            }

            // Fermez la connexion
            connection.disconnect();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return -1;
    }
    
    public static String getPersonneJson() {
        try {
            String result = "";
            // URL de l'endpoint du service web .NET
            String serviceUrl = "http://localhost:5204/api/Personne/getOnePersonne";
            
            // Créez une URL à partir de l'URL du service web
            URL url = new URL(serviceUrl);

            // Ouvrez une connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurez la méthode HTTP GET (ou POST si nécessaire)
            connection.setRequestMethod("GET");

            // Obtenez la réponse du service web
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lisez la réponse du service web
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // La réponse devrait contenir la somme
                result = response.toString();
                System.out.println("personne obtenue : " + result);
                
            } else {
                System.out.println("Erreur lors de la communication avec le service web. Code de réponse : " + responseCode);
            }

            // Fermez la connexion
            connection.disconnect();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static Personne getPersonne() {
        String json = DotNetWebServiceClient.getPersonneJson();
        final Gson gson = new GsonBuilder().create();
        final Personne personne = gson.fromJson(json, Personne.class);
        return personne;
    }
}

