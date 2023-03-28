package com.meow.hungergames.Service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;
import com.meow.hungergames.Entity.Post;
import com.meow.hungergames.Entity.Saved;

@Service
public class SavedService {
    
    public String submitSavedToDb(Saved saved) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("saved").document(saved.getSavedBy()).collection(saved.getSavedBy()).document(saved.getPost().getPostId()).set(saved);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public ArrayList<Saved> retrieveSavedFromDb(String userId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("saved").document(userId).collection(userId).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Saved> saveds = new ArrayList<>();
        Saved saved = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            saved = documentSnapshot.toObject(Saved.class);
            saveds.add(saved);
        }
        return saveds;
    }

    public Saved checkSavedFromDb(String postId, String userId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("saved").document(userId).collection(userId).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        Saved saved = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            saved = documentSnapshot.toObject(Saved.class);
            if (saved.getPost().getPostId().equals(postId)) return saved;
        }
        List<String> t = new ArrayList<>();
        t.add("hehe");
        List<String> t2 = new ArrayList<>();
        t2.add("hehe");
        return new Saved(new Post("hehe", "hehe", "hehe", "hehe", "hehe", "hehe", 0, 0, t, t2, "hehe", false), "hehe", "hehe");
    }

    public String deleteSavedFromDb(String userId, String postId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("saved").document(userId).collection(userId).document(postId).delete();
        return "Recipe with postId " + postId + " is deleted";
    }
}