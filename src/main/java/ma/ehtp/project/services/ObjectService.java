package ma.ehtp.project.services;
import ma.ehtp.project.entities.ObjectData;
import ma.ehtp.project.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    public List<ObjectData> getAllObjects() {
        return objectRepository.findAll();
    }

    public void addObject(ObjectData object) {
        objectRepository.save(object);
    }

    public void addRandomObject() {
        ObjectData object = new ObjectData();
        Random random = new Random();
        object.setName(UUID.randomUUID().toString());
        object.setQuantity(random.nextInt(100));
        objectRepository.save(object);
    }
}
