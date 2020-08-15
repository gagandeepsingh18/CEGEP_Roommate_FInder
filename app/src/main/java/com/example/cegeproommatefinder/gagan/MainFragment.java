package com.example.cegeproommatefinder.gagan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cegeproommatefinder.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainFragment extends Fragment  {

    RecyclerView recyclerView;
    ArrayList<ModelPost> postList;
    AdapterPost adapterPost;
    NavController navController;


    public MainFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.NavigationMainFragment);

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_main, container, false);


        recyclerView = view.findViewById(R.id.PostRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewPostActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        recyclerView.setLayoutManager(linearLayoutManager);

        postList = new ArrayList<>();



        loadPosts(view);




        return view;
    }



    private void loadPosts(View view) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ModelPost modelPost= dataSnapshot.getValue(ModelPost.class);

                    postList.add(modelPost);

                    adapterPost = new AdapterPost(getActivity().getApplicationContext(), postList);

                    recyclerView.setAdapter(adapterPost);

                    adapterPost.setOnClickListner(onClickListener);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();

            Toast.makeText(getActivity().getApplicationContext(),postList.get(position).getPostTitle(),Toast.LENGTH_SHORT).show();

            Bundle b = new Bundle();
            b.putParcelable("Post selected", (Parcelable) postList.get(position));
            navController.navigate(R.id.display_Fragment,b);





        }
    };
}