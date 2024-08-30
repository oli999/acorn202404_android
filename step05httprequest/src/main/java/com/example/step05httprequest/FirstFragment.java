package com.example.step05httprequest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.step05httprequest.databinding.FragmentFirstBinding;
/*
    [ Fragment ]

    - 액티비티 안에서 동작하는 미니 액티비티라고 생각하면 된다.
    - 재활용을 염두에 두고 만들수도 있다.
    - 자주쓰이는 UI 와 기능을 Fragment 로 만들어 놓고 여러개의 액티비티에서 가져다가 쓸수 있다.
    - 고유의 layout 과 동작을 가지고 있다.
 */
public class FirstFragment extends Fragment {
    // Fragment 에서도 view binding 을 사용할수 있다.
    private FragmentFirstBinding binding;

    // onCreateView() 메소드가 리턴해주는 View 객체가 이 Fragment 의 UI 이다
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // UI (View) 객체를 만들어서 리턴해 주어야한다.
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    // Fragment 이 UI 구성이 끝나면 호출되는 메소드 (준비 완료된 상태)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Fragment 의 동작을 여기서 정의 하면 된다.
        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }
    // Fragment 가 비활성화 될때 호출되는 메소드
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //주로 마무리 작업을 여기서 한다.
        binding = null;
    }

}