package shelter.service.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import shelter.service.model.User;

import java.util.*;
import java.util.concurrent.ExecutionException;

import static com.google.cloud.firestore.FieldPath.documentId;

@Service
public class UserService {

    private static final String COLLECTION_NAME ="user";


    public String insertUser(User user) throws ExecutionException, InterruptedException, FirebaseAuthException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(user.getEmail()).set(user);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public User getUserDetailsByEmail(String email) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        DocumentReference documentReference=dbFirestore.collection(COLLECTION_NAME).document(email);

        ApiFuture<DocumentSnapshot> future=documentReference.get();

        DocumentSnapshot document=future.get();

        User user=null;
        if(document.exists()) {
            user = document.toObject(User.class);
            return user;
        }else{
            return null;
        }
    }
    public User getUserDetailsById(String id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        Map<String, User> userList = new HashMap<>();
        User user = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future= documentReference1.get();
            DocumentSnapshot document=future.get();
            String userId = document.getId();
            user = document.toObject(User.class);
            userList.put(userId, user);

        }
        return userList.getOrDefault(id, null);
    }

    public String updateUserShelterId(User user) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(user.getEmail()).update("shelterId", user.getShelterId());

        return collectionApiFuture.get().getUpdateTime().toString();

    }
}
