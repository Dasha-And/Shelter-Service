package shelter.service.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import shelter.service.model.User;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    private static final String COLLECTION_NAME ="user";


    public String insertUser(User user) throws ExecutionException, InterruptedException, FirebaseAuthException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document().set(user);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public User getUserDetailsByEmail(String email) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        Query query = dbFirestore.collection(COLLECTION_NAME).whereEqualTo("email", email);

        ApiFuture<QuerySnapshot> future = query.get();

        if (!future.get().getDocuments().isEmpty()) {
            DocumentSnapshot document = future.get().getDocuments().get(0);

            User user = null;
            if(document.exists()) {
                user = document.toObject(User.class);
                return user;
            }else{
                return null;
            }
        } else {
            return null;
        }
    }
}
