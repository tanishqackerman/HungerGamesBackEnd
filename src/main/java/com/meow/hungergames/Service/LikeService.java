package com.meow.hungergames.Service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import com.meow.hungergames.Entity.Like;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;

@Service
public class LikeService {
    
    public String submitLikeToDb(Like like) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("like").document(like.getPostId()).collection(like.getPostId()).document(like.getUserId()).set(like);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public ArrayList<Like> retrieveLikeFromDb(String postId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("like").document(postId).collection(postId).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Like> likes = new ArrayList<>();
        Like like = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            like = documentSnapshot.toObject(Like.class);
            likes.add(like);
        }
        Collections.sort(likes, new Comparator<Like>() {
            @Override
            public int compare(Like o1, Like o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
        Collections.reverse(likes);
        return likes;
    }

    public Like checkLikeFromDb(String postId, String userId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("like").document(postId).collection(postId).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        // ArrayList<Like> likes = new ArrayList<>();
        Like like = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            like = documentSnapshot.toObject(Like.class);
            if (like.getUserId().equals(userId)) return like;
        }
        return new Like("hehe", "hehe", "hehe", "hehe", "hehe");
    }

    public String deleteLikeFromDb(String postId, String userId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("like").document(postId).collection(postId).document(userId).delete();
        return "Like with userId " + userId + " is deleted";
    }
}