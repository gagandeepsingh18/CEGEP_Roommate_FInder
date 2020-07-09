package com.example.cegeproommatefinder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    NavController navController;
    private RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<Post> arrayList;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Default Fragment :","OnCreate Called!");

        navController = Navigation.findNavController(getActivity(),R.id.NavigationMainFragment);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("Default Fragment :","OnCreateView Called!");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Default Fragment :","OnViewCreated Called!");


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<PostDetails> call = service.getPost();

        call.enqueue(new Callback<PostDetails>() {
            @Override
            public void onResponse(Call<PostDetails> call, Response<PostDetails> response) {

                System.out.println("Response From URL :" + response.body());

                try {
                    PostDetails post = response.body();

                    arrayList = new ArrayList<>(post.getPost());

                    Log.d("Arraylist size :","Size :"+arrayList.size());

                    generateView(arrayList,view);

                }catch (NullPointerException e)
                {
                    System.out.println("Nullpointer Exception :"+e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<PostDetails> call, Throwable t) {

                System.out.println("In Failure :" + t.getMessage());

            }
        });

    }

    public void generateView(ArrayList<Post> array, View view)
    {

        recyclerAdapter = new RecyclerAdapter(array, getActivity().getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView = view.findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnClickListner(onClickListener);


    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();

            Toast.makeText(getActivity().getApplicationContext(),arrayList.get(position).getPostTitle(),Toast.LENGTH_SHORT).show();

            Bundle b = new Bundle();


            navController.navigate(R.id.post_details_Fragment,b);




        }
    };


}