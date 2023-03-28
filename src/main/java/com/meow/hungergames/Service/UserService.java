package com.meow.hungergames.Service;

import org.springframework.stereotype.Service;
import com.meow.hungergames.Entity.User;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    
    public String submitUserToDb(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user").document(user.getUserId().toString()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public ArrayList<User> retrieveUserDetailsFromDb() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("user").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<User> users = new ArrayList<>();
        User user = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            user = documentSnapshot.toObject(User.class);
            users.add(user);
        }
        return users;
    }
    
    public User retrieveUserFromDb(String userId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("user").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            User user = documentSnapshot.toObject(User.class);
            if (user.getUserId().equals(userId)) return user;
        }
        return null;
    }

    public String deleteUserFromDb(String userId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("user").document(userId).delete();
        return "Recipe with postId " + userId + " is deleted";
    }
}