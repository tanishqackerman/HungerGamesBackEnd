package com.meow.hungergames.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import com.meow.hungergames.Entity.Comment;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;

@Service
public class CommentService {
    
    public String submitCommentToDb(Comment comment) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("comment").document(comment.getPostId()).collection(comment.getPostId()).document(comment.getCommentId()).set(comment);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public ArrayList<Comment> retrievePostCommentFromDb(String postId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("comment").document(postId).collection(postId).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<Comment> comments = new ArrayList<>();
        Comment comment = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();
            comment = documentSnapshot.toObject(Comment.class);
            comments.add(comment);
        }
        Collections.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
        Collections.reverse(comments);
        return comments;
    }

    public String deleteCommentFromDb(String postId, String commentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("comment").document(postId).collection(postId).document(commentId).delete();
        return "Comment with commentId " + commentId + " is deleted";
    }
}