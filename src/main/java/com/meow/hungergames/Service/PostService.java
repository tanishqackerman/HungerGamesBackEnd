package com.meow.hungergames.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import com.meow.hungergames.Entity.Post;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;

@Service
public class PostService {
    
    public String submitPostToDb(Post post) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("post").document(post.getPostId()).set(post);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    
    public String updatePostInDb(Post post) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("post").document(post.getPostId()).set(post);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public ArrayList<Post> retrievePostFromDb() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            posts.add(post);
        }
        return posts;
    }
    
    
    public Post retrieveSinglePostFromDb(String postId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            if (post.getPostId().equals(postId)) return post;
        }
        return null;
    }

    public ArrayList<Post> retrieveUserPostFromDb(String userId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            if (post.getUserId().equals(userId)) posts.add(post);
        }
        return posts;
    }

    public ArrayList<Post> retrieveHottestPostFromDb() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            posts.add(post);
        }
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                return p1.getLikes() < p2.getLikes() ? -1 : p1.getLikes() == p2.getLikes() ? 0 : 1;
            }
        });
        Collections.reverse(posts);
        return posts;
    }

    public ArrayList<Post> retrieveLatestPostFromDb() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            posts.add(post);
        }
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        Collections.reverse(posts);
        return posts;
    }

    public ArrayList<Post> retrieveVegPostFromDb() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            if (post.getIsVeg()) posts.add(post);
        }
        return posts;
    }

    public ArrayList<Post> retrieveNonVegPostFromDb() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            if (!post.getIsVeg()) posts.add(post);
        }
        return posts;
    }

    public ArrayList<Post> retrieveQueryPostFromDb(String query) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("post").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            post = documentSnapshot.toObject(Post.class);
            if (post.getRecipeName().toLowerCase().contains(query)) posts.add(post);
        }
        return posts;
    }

    public String deletePostFromDb(String postId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("post").document(postId).delete();
        return "Recipe with postId " + postId + " is deleted";
    }
}