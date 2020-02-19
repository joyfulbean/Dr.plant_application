package com.kminamy.dr_plant4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<CustomDto> listCustom = new ArrayList<>();
    //ListView에 보여질 Item 수
    @Override
    public int getCount() {
        return listCustom.size();
    }
    //하나의 item(ImageView1, TextView 2)
    @Override
    public Object getItem(int position) {
        return listCustom.get(position);
    }
    //Item의 id: Item을 구별하기 위한 것으로 position 사용
    @Override
    public long getItemId(int position) {
        return position;
    }

    //실제로 Item이 보여지는 부분
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CustomViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom, null, false);

            holder = new CustomViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
            holder.textTitle = (TextView)convertView.findViewById(R.id.text_title);
            holder.textContent = (TextView)convertView.findViewById(R.id.text_content);

            convertView.setTag(holder);
        }else{
            holder = (CustomViewHolder)convertView.getTag();
        }

        CustomDto dto = listCustom.get(position);

        holder.imageView.setImageResource(dto.getResId());
        holder.textTitle.setText(dto.getTitle());
        holder.textContent.setText(dto.getContent());

        return convertView;
    }

    class CustomViewHolder{
        ImageView imageView;
        TextView textTitle;
        TextView textContent;
    }
    // MainActivity에서 Adapter에 있는 ArrayList에 data를 추가시켜주는 함수
    public void addItem(CustomDto dto){
        listCustom.add(dto);
    }
}
