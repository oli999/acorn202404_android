package com.example.step08fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/*
    하나의 액티비티는 여러개의 프레그먼트로 구성할수가 있다
    액티비티 제어하에 동작하는 미니 액티비티라고 생각하면 된다.
 */
public class MyFragment extends Fragment {
    //액티비티가 선택적으로 구현할 인터페이스 정의하기
    public interface Listener{
        public void setMessage(String msg);
    }

    /*
        onCreateView() 메소드 재정의하기
        - 액티비티의 onCreate() 메소드와 역활이 비슷하다
        - 무언가 초기화 작업을 하면되는데 보통 View(UI) 를 만들어서 리턴해 준다.
        - 여기서 리턴한 View 를 이 Fragment 에서 제어 하고 관리한다고 생각하면 된다.
     */
    //필드
    int count=0;
    Button countBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //MyFragment 를 제어하고 있는 액티비티의 참조값이 필요 하다면 ... ?
        FragmentActivity fa = getActivity();

        // fragment_my.xml 문서를 전개해서 View 객체 만들기
        View view=inflater.inflate(R.layout.fragment_my, container, false);
        //만들어진 View 에서 Button 의 참조값 얻어내기
        countBtn=view.findViewById(R.id.countBtn);
        countBtn.setOnClickListener(v->{
            count++;
            countBtn.setText(Integer.toString(count));
            //MyFragment 를 제어하고 있는 액티비티의 메소드를 호출하면서 어떤 값을 전달하려면?
            if (fa instanceof Listener && count%10 == 0){
                Listener listener = (Listener) fa;
                listener.setMessage("count 가 10의 배수 입니다");
            }
        });

        //만든 View 객체의 참조값을 리턴해준다.
        return view;
    }

    //리셋하는 메소드
    public void reset(){
        //카운트 초기화
        count=0;
        countBtn.setText(Integer.toString(count));
    }
}
