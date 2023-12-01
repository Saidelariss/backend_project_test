package ma.ehtp.project.services;

import ma.ehtp.project.entities.ObjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CsvDataLoader {

    @Autowired
    private ObjectService objectService;

    @PostConstruct
    public void loadCsvData() {
        try {
            // Charger le fichier CSV depuis les ressources
            InputStream resource = getClass().getClassLoader().getResourceAsStream("data.csv");
            System.out.println(getClass().getResource("/data.csv"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));

         //  lire la première ligne et la sauter parce qu'elle concerne juste les noms des colonnes
            String line = reader.readLine();
            if(line!=null){
                // Lire chaque ligne et ajouter un objet à la base de données
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    ObjectData object = new ObjectData();
                    object.setName(data[0]);
                    object.setQuantity(Integer.parseInt(data[1]));
                    objectService.addObject(object);
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
