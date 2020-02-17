package com.kminamy.dr_plant4;

import android.content.Intent;
import android.content.res.TypedArray;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter();
        listView = (ListView)findViewById(R.id.list_view);

        setData();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            /*
             * Listview의 item을 click할 때 수렴할 동작
             * @param parent : 클릭이 발생한 AdapterView
             * @param view : 클릭 한 adapterview내의 view(adapter에 의해 제공되는 view)
             * @param position : 클릭한 item의 position
             * @param id ; 클릭한 item의 id
             * */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //adapter.getItem(position)의 return 값은 Object 형
                //실제 Item의 자료형은 CustomDTO형이기 떄문에 형변환을 시켜야
                //getResId() 메소드를 호출할 수 있음.
                int imgRes = ((CustomDto)adapter.getItem(position)).getResId();

                //new Intent(현재 Activity의 Context, 시작할 Activity class)
                Intent intent = new Intent(MainActivity.this,DiagnosisActivity.class);

                intent.putExtra("ImgRes", imgRes);
                startActivity(intent);
            }
        });

    }
    //보통 listview는 통신을 통해 가져온 데이터를 보여준다.
    //arrResId, titles, contents를 서버에서 가져온 데이터라고 생각
    private void setData(){
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] contents= getResources().getStringArray(R.array.content);

        for(int i =0;i<arrResId.length();i++){
            CustomDto dto = new CustomDto();
            dto.setResId(arrResId.getResourceId(i,0));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);

            adapter.addItem(dto);
        }


    }
}
