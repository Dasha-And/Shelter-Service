package shelter.service.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shelter.service.model.Shelter;
import shelter.service.model.Shelter;
import shelter.service.model.Shelter;
import shelter.service.model.User;


import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class ShelterService {

    private static final String COLLECTION_NAME ="shelter" ;

    public String saveShelter(Shelter shelter) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document().set(shelter);

        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public Shelter getShelterDetailsById(String id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        Map<String, Shelter> shelterList = new HashMap<>();
        Shelter shelter = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future= documentReference1.get();
            DocumentSnapshot document=future.get();
            String shelterId = document.getId();
            shelter = document.toObject(Shelter.class);
            shelterList.put(shelterId, shelter);

        }
        return shelterList.getOrDefault(id, null);
    }

    public List<Shelter> getShelterDetails() throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        List<Shelter> shelterList=new ArrayList<>();
        Shelter shelter=null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future= documentReference1.get();
            DocumentSnapshot document=future.get();

            shelter=document.toObject(Shelter.class);
            shelterList.add(shelter);

        }
        return shelterList;
    }
    public String getShelterIdByName(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        Query query = dbFirestore.collection(COLLECTION_NAME).whereEqualTo("name", name);
        ApiFuture<QuerySnapshot> future = query.get();

        if (!future.get().getDocuments().isEmpty()) {
            DocumentSnapshot document = future.get().getDocuments().get(0);

            String shelterId = null;
            if(document.exists()) {
                shelterId = document.getId();
                return shelterId;
            }else{
                return null;
            }
        } else {
            return null;
        }
    }
    public void updateShelter(Shelter shelter, String shelterId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore
                .collection(COLLECTION_NAME)
                .document(shelterId)
                .update("name", shelter.getName(), "longitude", shelter.getLongitude(), "latitude", shelter.getLatitude(), "phone", shelter.getPhone(), "email", shelter.getEmail(), "siteUrl", shelter.getSiteUrl());
    }
}
