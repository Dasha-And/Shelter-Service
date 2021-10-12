package shelter.service.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shelter.service.model.Shelter;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ShelterService {

    private static final String COLLECTION_NAME ="shelter" ;

    public String saveShelter(Shelter shelter) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document().set(shelter);

        return collectionApiFuture.get().getUpdateTime().toString();

    }
}
