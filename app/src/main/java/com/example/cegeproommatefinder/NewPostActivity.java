package com.example.cegeproommatefinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.security.Permission;
import java.util.HashMap;

public class NewPostActivity extends AppCompatActivity {

    private static final int CameraRequest = 1;
    private static final int StorageRequest = 2;

    private static final int ImagePickCamera = 3;
    private static final int ImagePickStorage = 4;

    String[] CameraPermission, StoragePermission;

    ActionBar actionBar;
    EditText Title, Description;
    ImageView imageView;
    Button NewPost;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    String name, email, uid;
    Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);


        actionBar= getSupportActionBar();
        actionBar.setTitle("Post a new Add");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        firebaseAuth= FirebaseAuth.getInstance();
        CheckUserStatus();


        CameraPermission = new String[] {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE };
        StoragePermission = new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE };

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        Query query= databaseReference.orderByChild("email").equalTo(email);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    name = ""+ dataSnapshot.child("name").getValue();
                    email = ""+ dataSnapshot.child("email").getValue();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(NewPostActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });

        Title = findViewById(R.id.NewPostTitleInput);
        Description = findViewById(R.id.NewPostDescriptionInput);
        imageView = findViewById(R.id.NewPostImage);
        NewPost = findViewById(R.id.NewPostButton);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickImage();
            }
        });



        NewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PostTitle = Title.getText().toString().trim();
                String PostDescription =Description.getText().toString().trim();
                if(TextUtils.isEmpty(PostTitle)){
                    Toast.makeText(NewPostActivity.this, "PLease enter the title for the Post", Toast.LENGTH_SHORT).show();
                    return;
                }
               else if(TextUtils.isEmpty(PostDescription)){
                    Toast.makeText(NewPostActivity.this, "PLease enter the title for the Post", Toast.LENGTH_SHORT).show();
                    return;
                }
               else {
                PostAdFun(PostTitle, PostDescription, String.valueOf(imageUri));
               }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        CheckUserStatus();

    }

    @Override
    protected void onResume() {
        super.onResume();
        CheckUserStatus();
    }



    private void CheckUserStatus() {
        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
         email = firebaseUser.getEmail();
         uid = firebaseUser.getUid();
        }
        else {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }



    private void PostAdFun(final String postTitle, final String postDescription, final String uri) {


        final String timestamp = String.valueOf(System.currentTimeMillis());
        Log.d("gagan", timestamp);
        String databasePath = "Posts/" + "post_" + timestamp;
        Log.d("gagan", databasePath);
        StorageReference  storageRef  = FirebaseStorage.getInstance().getReference().child(databasePath);
        storageRef.putFile(Uri.parse(uri))
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Log.d("gagan", uri);
                       // Toast.makeText(NewPostActivity.this, String.valueOf(uri), Toast.LENGTH_SHORT).show();
                        Task<Uri> uriTask= taskSnapshot.getStorage().getDownloadUrl();
                        while(!uriTask.isSuccessful());
                      //  Log.d("gagan", uri);
                        String downloadUri = uriTask.getResult().toString();

                        if (uriTask.isSuccessful()){
                  //          Log.d("gagan", uri);
                            HashMap<Object, String> hashMap = new HashMap<>();

                            hashMap.put("uid", uid);
                            hashMap.put("name", name);
                            hashMap.put("email", email);
                            hashMap.put("pid", timestamp);
                            hashMap.put("postTitle", postTitle);
                            hashMap.put("postDescription", postDescription);
                            hashMap.put("postImage", downloadUri);
                            hashMap.put("postTime", timestamp);

                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Posts");

                            databaseReference.child(timestamp).setValue(hashMap)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                           Toast.makeText(NewPostActivity.this, "Advertisment is Posted", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(NewPostActivity.this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    });
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("gagan", ""+e);
                    }
                });
    }


    private void PickImage() {
        String[] options= {"Take a Picture", "Gallery"};

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Options");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    if (!checkCameraPermission()){
                        requestCameraPermission();
                    }
                    else{
                        pickFromCamera();
                    }
                }
                if (which==1){
                    if (!checkGalleryPermission()){
                        requestGalleryPermission();
                    }
                    else{
                        pickFromGallery();
                    }
                }
            }
        });

        builder.create().show();
    }

    private void pickFromCamera() {
        ContentValues contentValues= new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE, "Temp Pick");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION, "Temp Desc");

        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, ImagePickCamera);

    }

    private void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, ImagePickStorage);
    }

    private boolean checkGalleryPermission(){
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return  result;
    }

    private void requestGalleryPermission(){
        ActivityCompat.requestPermissions(this, StoragePermission, StorageRequest);
    }

    private boolean checkCameraPermission(){
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        boolean result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        return  result && result2;
    }

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(this, CameraPermission, CameraRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return super.onSupportNavigateUp();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case CameraRequest:{
                if (grantResults.length>0){
                   boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                   boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                   if (cameraAccepted && storageAccepted) {

                       pickFromCamera();
                   }
                   else {
                       Toast.makeText(this, "Please provide access to both Camera and External Storage", Toast.LENGTH_SHORT).show();
                   }
                }
                else {

                }
            }
            break;
            case StorageRequest:{
                if (grantResults.length>0){
                    boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if (storageAccepted) {

                        pickFromGallery();
                    }
                    else {
                        Toast.makeText(this, "Please provide access to External Storage", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                }
            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (resultCode == RESULT_OK){
        if (requestCode == ImagePickStorage ){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
        else if (requestCode == ImagePickCamera){
            imageView.setImageURI(imageUri);
        }

    }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

