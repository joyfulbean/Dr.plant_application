package com.kminamy.dr_plant4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setIcon(R.drawable.logo3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        TextView resultText = (TextView)findViewById(R.id.ill);
        TextView link = (TextView)findViewById(R.id.link1);
        TextView treatText = (TextView)findViewById(R.id.treatment);
        // TextView에 설명 url 또는 아마존에서 추천 상품 가져오기
        Intent intent = getIntent();
       // String disease = intent.getStringExtra("diseaseName");
        //resultText.setText(disease);
        String  disease="Brown leaf spot";
        String temp, treatment;
        resultText.setText(disease);
        if (disease=="Bacterial leaf spot") {
            temp="<a href=\"https://www.planetnatural.com/pest-problem-solver/plant-disease/bacterial-leaf-spot/\">Treatment for bacterial leaf spot</a>";
            link.setText(Html.fromHtml(temp));

            treatment = "1. When selecting fruit trees, choose resistant varieties if possible.\n" +
                    "2. Keep the soil under the tree clean and rake up fallen fruit.\n" +
                    "3. Spray with a baking soda solution \n(a tablespoon of baking soda,2 1/2 tablespoons of vegetable oil, a teaspoon of liquid soap, not detergent, to one gallon of water), or neem oil (do not use when pollinating insects including bees or other beneficial insects are present).\n";
            treatText.setText(treatment);
        } else if(disease == "Black leaf rot"){
            //url 고치기
            temp="<a href=\"https://homeguides.sfgate.com/cure-brown-leaf-disease-shrubs-87974.html\">Treatment for brown leaf spot</a>";
            link.setText(Html.fromHtml(temp));

            treatment = "1. Prune infected leaves immediately. Ensure the overall health of your plant by removing diseased leaves entirely. \n" +
                    "2. Mix together a solution of 1 tbsp. baking soda, 2.5 tbsp. vegetable oil, 1 tsp. liquid soap, and 1 gallon water. \n"+"" +
                    "Be sure to use liquid soap, not detergent. Since this may potentially burn your leaves, spray a small test area with the solution before spraying the entire plant. If burning is absent or minimal, spray the leaves once every two weeks.\n";
            treatText.setText(treatment);
        }
        else if(disease=="Brown leaf spot") {
            temp="<a href=\"https://homeguides.sfgate.com/cure-brown-leaf-disease-shrubs-87974.html\">Treatment for brown leaf spot</a>";
            link.setText(Html.fromHtml(temp));

            treatment = "1. Prune infected leaves immediately.\nEnsure the overall health of your plant by removing diseased leaves entirely. \n" +
                    "2. Mix together a solution of 1 tbsp. baking soda,\n2.5 tbsp. vegetable oil, 1 tsp. liquid soap, and 1 gallon water. \n"+"" +
                    "Be sure to use liquid soap, not detergent.\nSince this may potentially burn your leaves, spray a\nsmall test area with the solution before spraying the entire plant.\nIf burning is absent or minimal, spray the leaves once every two weeks.\n";
            treatText.setText(treatment);
        } else if (disease=="Mosaic virus") {
            temp="<a href=\"https://www.planetnatural.com/pest-problem-solver/plant-disease/mosaic-virus/\">Treatment for mosaic virus</a>";
            link.setText(Html.fromHtml(temp));
            treatment = "";
            treatText.setText(treatment);
        } else if (disease=="Powdery mildew") {
            temp="<a href=\"http://www.saferbrand.com/articles/treat-powdery-mildew-plants\">Treatment for powdery mildew</a>";
            link.setText(Html.fromHtml(temp));
            treatment = "";
            treatText.setText(treatment);
        } else if (disease=="Rust") {
            temp="<a href=\"https://www.planetnatural.com/pest-problem-solver/plant-disease/common-rust/\">Treatment for rust</a>";
            link.setText(Html.fromHtml(temp));
        } else if (disease=="Black leaf rot") {
            temp="<a href=\"https://www.thespruce.com/black-spot-on-roses-4125530\">Treatment for black leaf rot</a>";
            link.setText(Html.fromHtml(temp));
            treatment = "";
            treatText.setText(treatment);
        } else if(disease == "Sunburn"){
            temp="<a href=\"https://homeguides.sfgate.com/save-sunburned-house-plants-92003.html\">Treatment for sunburn</a>";
            link.setText(Html.fromHtml(temp));

            treatment="1.Take frequent cool baths or showers to help relieve the pain.\n2.Use a moisturizer that contains aloe vera or soy to help soothe sunburned skin.\n3.Consider taking aspirin or ibuprofen to help reduce any swelling, redness and discomfort.";
            treatText.setText(treatment);
        } else{
            link.setText("It's healthy. No more information");
            treatment = "\n";
            treatText.setText(treatment);
        }
        link.setMovementMethod(LinkMovementMethod.getInstance());

        ImageView imageView = (ImageView)findViewById(R.id.imgSelectFromUser);
        Uri imageuri = Uri.parse(intent.getStringExtra("imageUri"));
        imageView.setImageURI(imageuri);

    }
}
