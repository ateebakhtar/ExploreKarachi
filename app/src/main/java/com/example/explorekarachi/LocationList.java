package com.example.explorekarachi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocationList extends AppCompatActivity {



    private RecyclerView mRecyclerView;
    //private ExampleAdapter mAdapter;
    listAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        //final FloatingActionButton addtolist = findViewById(R.id.addToList);
//        addtolist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });

//
//        final FloatingActionButton viewmap = findViewById(R.id.viewOnnmap);
//        viewmap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////
////                Data.latitude = example_items.get(position).getLatitude();
////                Data.longituide = example_items.get(position).getLongitude();
////                Intent i = new Intent(LocationList.this,ViewMap.class);
////                startActivity(i);
//
//            }
//        });






        setContentView(R.layout.activity_location_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        final ArrayList<example_item> example_items= new ArrayList<>();

        if(Data.status == 0)
        {

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom);
            dialog.setTitle("Help");
            // set the custom dialog components - text, image and button

            ImageView image = (ImageView) dialog.findViewById(R.id.imageView);
            ImageView image1 = (ImageView) dialog.findViewById(R.id.imageView2);
            ImageView image2 = (ImageView) dialog.findViewById(R.id.imageView3);
            ImageView image3 = (ImageView) dialog.findViewById(R.id.imageView4);

            image.setImageResource(R.drawable.beech);
            image1.setImageResource(R.drawable.movie);
            image2.setImageResource(R.drawable.food);
            image3.setImageResource(R.drawable.shopping);

            Button dialogButton = (Button) dialog.findViewById(R.id.button);
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox m = dialog.findViewById(R.id.checkBox);
                    if(m.isChecked())
                    {
                        Data.status = 1;
                    }
                    dialog.dismiss();
                }
            });
//            dialog.show();

        }
//
        if(Data.pos == 0 && Data.people.equals("1 person"))
        {


            example_items.add(new example_item(R.drawable.beech,"The Royal rodale","Entertainment","Defence","24.791994","67.046843","With a view to provide light food, The Royal Rodale features informal eating outlet that offers a large variety of cafe delights."));

            example_items.add(new example_item(R.drawable.food,"Hardees","Food","Defence","24.794692","67.048431","Fast-food chain serving fried chicken & big burgers."));

            example_items.add(new example_item(R.drawable.food,"Auntie Munaver's Dessert And Savory","Food","Defence","24.787416","67.058473","Decadently Delicious Desserts and Savories for a dinner, party or just to indulge yourself at home, Auntie Munaver brings the most delectable experience, tantalizing your taste buds and reawakening a deep desire for the most exotic of tastes which will leave you hungry for more."));

            example_items.add(new example_item(R.drawable.food,"ChaiWala Chota Bukhari","Food","Defence","24.786452","67.057640","Chai Wala is your one-stop chai and chilling destination. We serve a range of traditional and artisanal beverages and snacks."));

            example_items.add(new example_item(R.drawable.food,"Bundoo Khan","Food","Defence","24.797965","67.045205","Bundu Khan has to be one of the best old fashioned restaurants still going strong. Mr Bundo Khan opened his restaurant before the partition of India and Pakistan."));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.shopping,"Gul Plaza","Shopping","Saddar","24.865042","67.023672","Crokery,Electronics, House Hold and Gift Items, Whole seller, Retailer under one roof in Karachi"));

            example_items.add(new example_item(R.drawable.movie,"Frere Hall","Entertainment","Saddar","24.847778","67.033031","Frere Hall is a building in Karachi, Pakistan that dates from the early British colonial-era in Sindh."));

            example_items.add(new example_item(R.drawable.movie,"Pearl Continental Hotel","Entertainment","Saddar","24.847595","24.847595","Pearl-Continental Hotels & Resorts is the largest chain of five-star hotels in Pakistan with properties in Lahore, Faisalabad, Karachi, Rawalpindi, Peshawar, Gwadar, Bhurban, and Muzaffarabad."));

            example_items.add(new example_item(R.drawable.food,"Meeruth Famous Kabab Paratha","Food","Nazimabad","24.929324","67.034700", "The best kabab Paratha Hotel providing best food on best price"));

            example_items.add(new example_item(R.drawable.movie,"Eidgah Ground","Entertainment","Nazimabad","24.911723","67.029957", "Eidgah ground for eid prayer and in other days many people play cricket and outdoor games here! Clean and nice area Like"));

            example_items.add(new example_item(R.drawable.food,"Dilpasand Sweets","Food","Nazimabad","24.926420","67.032151", "One of the biggest confectionery shop in the town, providing quality items at affordable prices. All the bakery items are available. Arabic sweets, Bengali sweets, local sweets and different types of Halwa are there to delight your taste buds. They have maintained their standard , in terms of service and hygiene"));

            example_items.add(new example_item(R.drawable.shopping,"Serena Mobile Mall","Shopping","Nazimabad","24.953685","67.058323", "Serena mobile market is the busiest place to sell or purchase new or used phone or repairing or buying accessories your phone needs .its provide great support to near by areas because you.dont have to travel long distances"));

            example_items.add(new example_item(R.drawable.shopping,"Dolmen Mall","Shopping","Nazimabad","24.935743","67.040293", "The Dolmen Magazine was launched during Dolmen Mall’s biggest event of the year, the Dolmen Shopping Festival, in December 2015. Bringing the latest in fashion, food and entertainment, the magazine covers all of the recent happenings at Dolmen Mall Clifton along with exclusive discounts offered to its customers through the magazine."));

            example_items.add(new example_item(R.drawable.food,"Chilli Fry Day","Food","Nazimabad","24.934657","67.032004", "Amazing taste and variety of fries including pizza fries, ranch fries and flavored fries. New menu includes burgers, sandwich and chicken bites"));

            example_items.add(new example_item(R.drawable.shopping,"Al-Madni Mall","Shopping","Nazimabad","24.936234","67.042782", "Exorbitant rate even belts are more then double priced. Everyone is selling cheap quality products at high price no quality comparison."));

            example_items.add(new example_item(R.drawable.movie,"Asghar Ali Shah Cricket Stadium","Entertainment","Nazimabad","24.937986","67.030989", "One of the best grounds in karachi for local players. Major tournaments like Ramzan Cup and Women Domestic Cup helds here every year. And the best point about this ground is that it is available for the local matches too. Pitch is average but the outfield is smooth and fast."));

            example_items.add(new example_item(R.drawable.food,"Vintage","Food","Defence","24.795486","67.050300", "Amazing food with tasty sauce. Quantity is very less as compare to the price. The seating arrangement isnt very comforting. But the quality of the food makes up for everything."));

            example_items.add(new example_item(R.drawable.movie,"Nueplex Cinemas","Entertainment","Defence","24.779701","67.089716", "Nueplex Cinemas is a movie theatre and the largest Cinema Complex located in Karachi, Pakistan. Housed on the second floor of The Place, built from the ground up and designed by cinema Architects Mesbur & Smith of Canada. Comprising 5 theatres, totalling 1200 seats and home to the 3 largest silver screens in Pakistan."));

            example_items.add(new example_item(R.drawable.shopping,"Lulusar Concept Store","Shopping","Defence","24.795344","67.065564", "Lulusar dha Karachi has a very nice store with super friendly and helpful staff. Store is well spaced and decor is simple yet graceful. You can try the clothes that's the comfort which came in handy after the opening of lulusar."));

            example_items.add(new example_item(R.drawable.beech,"Seaview Beach","Beach","Defence","24.789949","67.043860", "commonly known as Sea View it is actually Clifton Beach, in Karachi,Pakistan is located on the Arabian Sea. It stretches from Karachi to Ormara (Balochistan). The beach is very popular in All over Pakistan.It is open 24/7 for the general public. Karachi is the most prominent coastal city of Pakistan and beach lovers here have many opportunities to visit different beaches bordering the Arabian Sea. Clifton Beach is purported to give the best value in leisure and recreational opportunities for fun seekers and beach lovers. The beach is located in the neighborhoods of the Saddar Town which is the city center."));

            example_items.add(new example_item(R.drawable.movie,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.movie,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.movie,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.movie,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.movie,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.food,"Chullu Kabab Sistani","Food","Saddar","24.857850","67.031099", "One of the oldest Irani restaurant in city still serving hygienic n good quality tasty Irani n Pakistani dishes. Ambience, atmosphere, crockery, sitting arrangements are up to mark. Challu Kabab is dish of the restaurant. But I think the prices are much high."));

            example_items.add(new example_item(R.drawable.food,"Cafe Durakhshan","Food","Saddar","24.865760","67.026366", "It is one of the place where you always pass by, never think to go in. So two days ago, my friend took me there after telling me for over an year that I will feed you the most amazing Plaau. And we went there for lunch. And Oh my word! It was worth the wait. Amazing taste and very retro ambiance. Loved every bit of it. From Presentation to taste, Service to seating"));

            example_items.add(new example_item(R.drawable.food,"Evergreen Cafe","Food","Defence","24.797407","67.051017", "Who says healthy food has to taste bad!!! This is a great place if you are health conscious and yet wants a hearty tasty meal. Excellent choices, reasonable price and the food quality is as good as it gets in Karachi."));

            example_items.add(new example_item(R.drawable.food,"Loco","Food","Defence","24.793056","67.065670", "Great mexican, Italian cuisine served tapas style in a  space only slightly bigger than a hole in the wall. Good service and food. No walk-in customers accepted so make sure that you book your table in advance. 1.50hours per customer per table"));

            example_items.add(new example_item(R.drawable.shopping,"N'eco's Natural Store & Cafe","Food","Defence","24.796674","67.066217", "The Cafe menu focuses on appealing to different palates and to families. N’eco’s created a space where everyone can enjoy what they love, indulgent or healthy, but guaranteed fresh and natural. The Organic Store stocks products ranging from super-foods to all natural beauty and personal care, Eco friendly products to pure and natural edibles. We strongly believe in supporting local brands and encourage female entrepreneurs and small business. We are constantly garnering feedback from customers and improving the selection of products available."));

            example_items.add(new example_item(R.drawable.food,"Kababjees","Food","North Nazimabad","24.933455","67.034851"," With warmth of service rarely experienced, it is a perfect place to rejoice with family, to soak in the relaxing decor and with deep desire to revisit for once, is never enough."));

            example_items.add(new example_item(R.drawable.food,"TAO","Food","Clifton","24.829955","67.024015","TAO offers you a contemporary Pan-Asian cuisine with the spin of various cooking techniques like grilling, steaming, pan frying all to be enjoyed with our light starters, freshly made salads and comforting soups."));

            example_items.add(new example_item(R.drawable.food,"Karachi Parsi Institute","Entertainment","Saddar","24.865795","67.038385","Karachi Parsi Institute sports grounds (Parsi Gymkhana was built in 1893)"));


        }
        else if(Data.pos == 0 && Data.people.equals("3 or less"))
        {

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.food,"Chullu Kabab Sistani","Food","Saddar","24.857850","67.031099", "One of the oldest Irani restaurant in city still serving hygienic n good quality tasty Irani n Pakistani dishes. Ambience, atmosphere, crockery, sitting arrangements are up to mark. Challu Kabab is dish of the restaurant. But I think the prices are much high."));


            example_items.add(new example_item(R.drawable.beech,"The Royal rodale","Entertainment","Defence","24.791994","67.046843","With a view to provide light food, The Royal Rodale features informal eating outlet that offers a large variety of cafe delights."));

            example_items.add(new example_item(R.drawable.food,"Hardees","Food","Defence","24.794692","67.048431","Fast-food chain serving fried chicken & big burgers."));

            example_items.add(new example_item(R.drawable.food,"Auntie Munaver's Dessert And Savory","Food","Defence","24.787416","67.058473","Decadently Delicious Desserts and Savories for a dinner, party or just to indulge yourself at home, Auntie Munaver brings the most delectable experience, tantalizing your taste buds and reawakening a deep desire for the most exotic of tastes which will leave you hungry for more."));

            example_items.add(new example_item(R.drawable.food,"ChaiWala Chota Bukhari","Food","Defence","24.786452","67.057640","Chai Wala is your one-stop chai and chilling destination. We serve a range of traditional and artisanal beverages and snacks."));

            example_items.add(new example_item(R.drawable.food,"Bundoo Khan","Food","Defence","24.797965","67.045205","Bundu Khan has to be one of the best old fashioned restaurants still going strong. Mr Bundo Khan opened his restaurant before the partition of India and Pakistan."));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.shopping,"Gul Plaza","Shopping","Saddar","24.865042","67.023672","Crokery,Electronics, House Hold and Gift Items, Whole seller, Retailer under one roof in Karachi"));

            example_items.add(new example_item(R.drawable.movie,"Frere Hall","Entertainment","Saddar","24.847778","67.033031","Frere Hall is a building in Karachi, Pakistan that dates from the early British colonial-era in Sindh."));

            example_items.add(new example_item(R.drawable.movie,"Pearl Continental Hotel","Entertainment","Saddar","24.847595","24.847595","Pearl-Continental Hotels & Resorts is the largest chain of five-star hotels in Pakistan with properties in Lahore, Faisalabad, Karachi, Rawalpindi, Peshawar, Gwadar, Bhurban, and Muzaffarabad."));

            example_items.add(new example_item(R.drawable.food,"Meeruth Famous Kabab Paratha","Food","Nazimabad","24.929324","67.034700", "The best kabab Paratha Hotel providing best food on best price"));


            example_items.add(new example_item(R.drawable.food,"Cafe Durakhshan","Food","Saddar","24.865760","67.026366", "It is one of the place where you always pass by, never think to go in. So two days ago, my friend took me there after telling me for over an year that I will feed you the most amazing Plaau. And we went there for lunch. And Oh my word! It was worth the wait. Amazing taste and very retro ambiance. Loved every bit of it. From Presentation to taste, Service to seating"));

            example_items.add(new example_item(R.drawable.food,"Evergreen Cafe","Food","Defence","24.797407","67.051017", "Who says healthy food has to taste bad!!! This is a great place if you are health conscious and yet wants a hearty tasty meal. Excellent choices, reasonable price and the food quality is as good as it gets in Karachi."));

            example_items.add(new example_item(R.drawable.food,"Loco","Food","Defence","24.793056","67.065670", "Great mexican, Italian cuisine served tapas style in a  space only slightly bigger than a hole in the wall. Good service and food. No walk-in customers accepted so make sure that you book your table in advance. 1.50hours per customer per table"));

            example_items.add(new example_item(R.drawable.food,"N'eco's Natural Store & Cafe","Food","Defence","24.796674","67.066217", "The Cafe menu focuses on appealing to different palates and to families. N’eco’s created a space where everyone can enjoy what they love, indulgent or healthy, but guaranteed fresh and natural. The Organic Store stocks products ranging from super-foods to all natural beauty and personal care, Eco friendly products to pure and natural edibles. We strongly believe in supporting local brands and encourage female entrepreneurs and small business. We are constantly garnering feedback from customers and improving the selection of products available."));

            example_items.add(new example_item(R.drawable.food,"Kababjees","Food","North Nazimabad","24.933455","67.034851"," With warmth of service rarely experienced, it is a perfect place to rejoice with family, to soak in the relaxing decor and with deep desire to revisit for once, is never enough."));

            example_items.add(new example_item(R.drawable.food,"TAO","Food","Clifton","24.829955","67.024015","TAO offers you a contemporary Pan-Asian cuisine with the spin of various cooking techniques like grilling, steaming, pan frying all to be enjoyed with our light starters, freshly made salads and comforting soups."));

            example_items.add(new example_item(R.drawable.food,"Karachi Parsi Institute","Entertainment","Saddar","24.865795","67.038385","Karachi Parsi Institute sports grounds (Parsi Gymkhana was built in 1893)"));


        }
        else if(Data.pos == 0 && Data.people.equals("5 or less"))
        {

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.food,"Chullu Kabab Sistani","Food","Saddar","24.857850","67.031099", "One of the oldest Irani restaurant in city still serving hygienic n good quality tasty Irani n Pakistani dishes. Ambience, atmosphere, crockery, sitting arrangements are up to mark. Challu Kabab is dish of the restaurant. But I think the prices are much high."));


            example_items.add(new example_item(R.drawable.beech,"The Royal rodale","Entertainment","Defence","24.791994","67.046843","With a view to provide light food, The Royal Rodale features informal eating outlet that offers a large variety of cafe delights."));

            example_items.add(new example_item(R.drawable.food,"Hardees","Food","Defence","24.794692","67.048431","Fast-food chain serving fried chicken & big burgers."));

            example_items.add(new example_item(R.drawable.food,"Auntie Munaver's Dessert And Savory","Food","Defence","24.787416","67.058473","Decadently Delicious Desserts and Savories for a dinner, party or just to indulge yourself at home, Auntie Munaver brings the most delectable experience, tantalizing your taste buds and reawakening a deep desire for the most exotic of tastes which will leave you hungry for more."));

            example_items.add(new example_item(R.drawable.food,"ChaiWala Chota Bukhari","Food","Defence","24.786452","67.057640","Chai Wala is your one-stop chai and chilling destination. We serve a range of traditional and artisanal beverages and snacks."));

            example_items.add(new example_item(R.drawable.food,"Bundoo Khan","Food","Defence","24.797965","67.045205","Bundu Khan has to be one of the best old fashioned restaurants still going strong. Mr Bundo Khan opened his restaurant before the partition of India and Pakistan."));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.shopping,"Gul Plaza","Shopping","Saddar","24.865042","67.023672","Crokery,Electronics, House Hold and Gift Items, Whole seller, Retailer under one roof in Karachi"));

            example_items.add(new example_item(R.drawable.movie,"Frere Hall","Entertainment","Saddar","24.847778","67.033031","Frere Hall is a building in Karachi, Pakistan that dates from the early British colonial-era in Sindh."));

            example_items.add(new example_item(R.drawable.movie,"Pearl Continental Hotel","Entertainment","Saddar","24.847595","24.847595","Pearl-Continental Hotels & Resorts is the largest chain of five-star hotels in Pakistan with properties in Lahore, Faisalabad, Karachi, Rawalpindi, Peshawar, Gwadar, Bhurban, and Muzaffarabad."));

            example_items.add(new example_item(R.drawable.food,"Meeruth Famous Kabab Paratha","Food","Nazimabad","24.929324","67.034700", "The best kabab Paratha Hotel providing best food on best price"));


            example_items.add(new example_item(R.drawable.food,"Cafe Durakhshan","Food","Saddar","24.865760","67.026366", "It is one of the place where you always pass by, never think to go in. So two days ago, my friend took me there after telling me for over an year that I will feed you the most amazing Plaau. And we went there for lunch. And Oh my word! It was worth the wait. Amazing taste and very retro ambiance. Loved every bit of it. From Presentation to taste, Service to seating"));

            example_items.add(new example_item(R.drawable.food,"Evergreen Cafe","Food","Defence","24.797407","67.051017", "Who says healthy food has to taste bad!!! This is a great place if you are health conscious and yet wants a hearty tasty meal. Excellent choices, reasonable price and the food quality is as good as it gets in Karachi."));

            example_items.add(new example_item(R.drawable.food,"Loco","Food","Defence","24.793056","67.065670", "Great mexican, Italian cuisine served tapas style in a  space only slightly bigger than a hole in the wall. Good service and food. No walk-in customers accepted so make sure that you book your table in advance. 1.50hours per customer per table"));

            example_items.add(new example_item(R.drawable.food,"N'eco's Natural Store & Cafe","Food","Defence","24.796674","67.066217", "The Cafe menu focuses on appealing to different palates and to families. N’eco’s created a space where everyone can enjoy what they love, indulgent or healthy, but guaranteed fresh and natural. The Organic Store stocks products ranging from super-foods to all natural beauty and personal care, Eco friendly products to pure and natural edibles. We strongly believe in supporting local brands and encourage female entrepreneurs and small business. We are constantly garnering feedback from customers and improving the selection of products available."));

            example_items.add(new example_item(R.drawable.food,"Kababjees","Food","North Nazimabad","24.933455","67.034851"," With warmth of service rarely experienced, it is a perfect place to rejoice with family, to soak in the relaxing decor and with deep desire to revisit for once, is never enough."));

            example_items.add(new example_item(R.drawable.food,"TAO","Food","Clifton","24.829955","67.024015","TAO offers you a contemporary Pan-Asian cuisine with the spin of various cooking techniques like grilling, steaming, pan frying all to be enjoyed with our light starters, freshly made salads and comforting soups."));

            example_items.add(new example_item(R.drawable.food,"Karachi Parsi Institute","Entertainment","Saddar","24.865795","67.038385","Karachi Parsi Institute sports grounds (Parsi Gymkhana was built in 1893)"));


        }
        else if(Data.pos == 0 && Data.people.equals("more than 5"))
        {

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.food,"Chullu Kabab Sistani","Food","Saddar","24.857850","67.031099", "One of the oldest Irani restaurant in city still serving hygienic n good quality tasty Irani n Pakistani dishes. Ambience, atmosphere, crockery, sitting arrangements are up to mark. Challu Kabab is dish of the restaurant. But I think the prices are much high."));

            example_items.add(new example_item(R.drawable.food,"Cafe Durakhshan","Food","Saddar","24.865760","67.026366", "It is one of the place where you always pass by, never think to go in. So two days ago, my friend took me there after telling me for over an year that I will feed you the most amazing Plaau. And we went there for lunch. And Oh my word! It was worth the wait. Amazing taste and very retro ambiance. Loved every bit of it. From Presentation to taste, Service to seating"));

            example_items.add(new example_item(R.drawable.food,"Evergreen Cafe","Food","Defence","24.797407","67.051017", "Who says healthy food has to taste bad!!! This is a great place if you are health conscious and yet wants a hearty tasty meal. Excellent choices, reasonable price and the food quality is as good as it gets in Karachi."));

            example_items.add(new example_item(R.drawable.food,"Loco","Food","Defence","24.793056","67.065670", "Great mexican, Italian cuisine served tapas style in a  space only slightly bigger than a hole in the wall. Good service and food. No walk-in customers accepted so make sure that you book your table in advance. 1.50hours per customer per table"));

            example_items.add(new example_item(R.drawable.food,"N'eco's Natural Store & Cafe","Food","Defence","24.796674","67.066217", "The Cafe menu focuses on appealing to different palates and to families. N’eco’s created a space where everyone can enjoy what they love, indulgent or healthy, but guaranteed fresh and natural. The Organic Store stocks products ranging from super-foods to all natural beauty and personal care, Eco friendly products to pure and natural edibles. We strongly believe in supporting local brands and encourage female entrepreneurs and small business. We are constantly garnering feedback from customers and improving the selection of products available."));

            example_items.add(new example_item(R.drawable.food,"Kababjees","Food","North Nazimabad","24.933455","67.034851"," With warmth of service rarely experienced, it is a perfect place to rejoice with family, to soak in the relaxing decor and with deep desire to revisit for once, is never enough."));

            example_items.add(new example_item(R.drawable.food,"TAO","Food","Clifton","24.829955","67.024015","TAO offers you a contemporary Pan-Asian cuisine with the spin of various cooking techniques like grilling, steaming, pan frying all to be enjoyed with our light starters, freshly made salads and comforting soups."));

            example_items.add(new example_item(R.drawable.food,"Karachi Parsi Institute","Entertainment","Saddar","24.865795","67.038385","Karachi Parsi Institute sports grounds (Parsi Gymkhana was built in 1893)"));


            example_items.add(new example_item(R.drawable.beech,"The Royal rodale","Entertainment","Defence","24.791994","67.046843","With a view to provide light food, The Royal Rodale features informal eating outlet that offers a large variety of cafe delights."));

            example_items.add(new example_item(R.drawable.food,"Hardees","Food","Defence","24.794692","67.048431","Fast-food chain serving fried chicken & big burgers."));

            example_items.add(new example_item(R.drawable.food,"Auntie Munaver's Dessert And Savory","Food","Defence","24.787416","67.058473","Decadently Delicious Desserts and Savories for a dinner, party or just to indulge yourself at home, Auntie Munaver brings the most delectable experience, tantalizing your taste buds and reawakening a deep desire for the most exotic of tastes which will leave you hungry for more."));

            example_items.add(new example_item(R.drawable.food,"ChaiWala Chota Bukhari","Food","Defence","24.786452","67.057640","Chai Wala is your one-stop chai and chilling destination. We serve a range of traditional and artisanal beverages and snacks."));

            example_items.add(new example_item(R.drawable.food,"Bundoo Khan","Food","Defence","24.797965","67.045205","Bundu Khan has to be one of the best old fashioned restaurants still going strong. Mr Bundo Khan opened his restaurant before the partition of India and Pakistan."));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.shopping,"Gul Plaza","Shopping","Saddar","24.865042","67.023672","Crokery,Electronics, House Hold and Gift Items, Whole seller, Retailer under one roof in Karachi"));

            example_items.add(new example_item(R.drawable.movie,"Frere Hall","Entertainment","Saddar","24.847778","67.033031","Frere Hall is a building in Karachi, Pakistan that dates from the early British colonial-era in Sindh."));

            example_items.add(new example_item(R.drawable.movie,"Pearl Continental Hotel","Entertainment","Saddar","24.847595","24.847595","Pearl-Continental Hotels & Resorts is the largest chain of five-star hotels in Pakistan with properties in Lahore, Faisalabad, Karachi, Rawalpindi, Peshawar, Gwadar, Bhurban, and Muzaffarabad."));

            example_items.add(new example_item(R.drawable.food,"Meeruth Famous Kabab Paratha","Food","Nazimabad","24.929324","67.034700", "The best kabab Paratha Hotel providing best food on best price"));

        }
        else if(Data.pos == 1 && Data.people.equals("1 person"))
        {

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.movie,"Eidgah Ground","Entertainment","Nazimabad","24.911723","67.029957", "Eidgah ground for eid prayer and in other days many people play cricket and outdoor games here! Clean and nice area Like"));

            example_items.add(new example_item(R.drawable.food,"Dilpasand Sweets","Food","Nazimabad","24.926420","67.032151", "One of the biggest confectionery shop in the town, providing quality items at affordable prices. All the bakery items are available. Arabic sweets, Bengali sweets, local sweets and different types of Halwa are there to delight your taste buds. They have maintained their standard , in terms of service and hygiene"));

            example_items.add(new example_item(R.drawable.shopping,"Serena Mobile Mall","Shopping","Nazimabad","24.953685","67.058323", "Serena mobile market is the busiest place to sell or purchase new or used phone or repairing or buying accessories your phone needs .its provide great support to near by areas because you.dont have to travel long distances"));

            example_items.add(new example_item(R.drawable.shopping,"Dolmen Mall","Shopping","Nazimabad","24.935743","67.040293", "The Dolmen Magazine was launched during Dolmen Mall’s biggest event of the year, the Dolmen Shopping Festival, in December 2015. Bringing the latest in fashion, food and entertainment, the magazine covers all of the recent happenings at Dolmen Mall Clifton along with exclusive discounts offered to its customers through the magazine."));

            example_items.add(new example_item(R.drawable.food,"Chilli Fry Day","Food","Nazimabad","24.934657","67.032004", "Amazing taste and variety of fries including pizza fries, ranch fries and flavored fries. New menu includes burgers, sandwich and chicken bites"));

            example_items.add(new example_item(R.drawable.shopping,"Al-Madni Mall","Shopping","Nazimabad","24.936234","67.042782", "Exorbitant rate even belts are more then double priced. Everyone is selling cheap quality products at high price no quality comparison."));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

        }
        else if(Data.pos == 1 && Data.people.equals("more than 5"))
        {

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));


            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.movie,"Eidgah Ground","Entertainment","Nazimabad","24.911723","67.029957", "Eidgah ground for eid prayer and in other days many people play cricket and outdoor games here! Clean and nice area Like"));

            example_items.add(new example_item(R.drawable.food,"Dilpasand Sweets","Food","Nazimabad","24.926420","67.032151", "One of the biggest confectionery shop in the town, providing quality items at affordable prices. All the bakery items are available. Arabic sweets, Bengali sweets, local sweets and different types of Halwa are there to delight your taste buds. They have maintained their standard , in terms of service and hygiene"));

            example_items.add(new example_item(R.drawable.shopping,"Serena Mobile Mall","Shopping","Nazimabad","24.953685","67.058323", "Serena mobile market is the busiest place to sell or purchase new or used phone or repairing or buying accessories your phone needs .its provide great support to near by areas because you.dont have to travel long distances"));


            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.movie,"Eidgah Ground","Entertainment","Nazimabad","24.911723","67.029957", "Eidgah ground for eid prayer and in other days many people play cricket and outdoor games here! Clean and nice area Like"));

            example_items.add(new example_item(R.drawable.food,"Dilpasand Sweets","Food","Nazimabad","24.926420","67.032151", "One of the biggest confectionery shop in the town, providing quality items at affordable prices. All the bakery items are available. Arabic sweets, Bengali sweets, local sweets and different types of Halwa are there to delight your taste buds. They have maintained their standard , in terms of service and hygiene"));

            example_items.add(new example_item(R.drawable.shopping,"Serena Mobile Mall","Shopping","Nazimabad","24.953685","67.058323", "Serena mobile market is the busiest place to sell or purchase new or used phone or repairing or buying accessories your phone needs .its provide great support to near by areas because you.dont have to travel long distances"));

            example_items.add(new example_item(R.drawable.shopping,"Dolmen Mall","Shopping","Nazimabad","24.935743","67.040293", "The Dolmen Magazine was launched during Dolmen Mall’s biggest event of the year, the Dolmen Shopping Festival, in December 2015. Bringing the latest in fashion, food and entertainment, the magazine covers all of the recent happenings at Dolmen Mall Clifton along with exclusive discounts offered to its customers through the magazine."));

        }
        else if(Data.pos == 1 && Data.people.equals("5 or less"))
        {
            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.movie,"Eidgah Ground","Entertainment","Nazimabad","24.911723","67.029957", "Eidgah ground for eid prayer and in other days many people play cricket and outdoor games here! Clean and nice area Like"));

            example_items.add(new example_item(R.drawable.food,"Dilpasand Sweets","Food","Nazimabad","24.926420","67.032151", "One of the biggest confectionery shop in the town, providing quality items at affordable prices. All the bakery items are available. Arabic sweets, Bengali sweets, local sweets and different types of Halwa are there to delight your taste buds. They have maintained their standard , in terms of service and hygiene"));

            example_items.add(new example_item(R.drawable.shopping,"Serena Mobile Mall","Shopping","Nazimabad","24.953685","67.058323", "Serena mobile market is the busiest place to sell or purchase new or used phone or repairing or buying accessories your phone needs .its provide great support to near by areas because you.dont have to travel long distances"));

            example_items.add(new example_item(R.drawable.shopping,"Dolmen Mall","Shopping","Nazimabad","24.935743","67.040293", "The Dolmen Magazine was launched during Dolmen Mall’s biggest event of the year, the Dolmen Shopping Festival, in December 2015. Bringing the latest in fashion, food and entertainment, the magazine covers all of the recent happenings at Dolmen Mall Clifton along with exclusive discounts offered to its customers through the magazine."));

        }
        else if(Data.pos == 1 && Data.people.equals("3 or less"))
        {
            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.movie,"Eidgah Ground","Entertainment","Nazimabad","24.911723","67.029957", "Eidgah ground for eid prayer and in other days many people play cricket and outdoor games here! Clean and nice area Like"));

            example_items.add(new example_item(R.drawable.food,"Dilpasand Sweets","Food","Nazimabad","24.926420","67.032151", "One of the biggest confectionery shop in the town, providing quality items at affordable prices. All the bakery items are available. Arabic sweets, Bengali sweets, local sweets and different types of Halwa are there to delight your taste buds. They have maintained their standard , in terms of service and hygiene"));

            example_items.add(new example_item(R.drawable.shopping,"Serena Mobile Mall","Shopping","Nazimabad","24.953685","67.058323", "Serena mobile market is the busiest place to sell or purchase new or used phone or repairing or buying accessories your phone needs .its provide great support to near by areas because you.dont have to travel long distances"));

            example_items.add(new example_item(R.drawable.shopping,"Dolmen Mall","Shopping","Nazimabad","24.935743","67.040293", "The Dolmen Magazine was launched during Dolmen Mall’s biggest event of the year, the Dolmen Shopping Festival, in December 2015. Bringing the latest in fashion, food and entertainment, the magazine covers all of the recent happenings at Dolmen Mall Clifton along with exclusive discounts offered to its customers through the magazine."));

        }
        else if(Data.pos == 2 && Data.people.equals("1 person"))
        {
            example_items.add(new example_item(R.drawable.food,"Loco","Food","Defence","24.793056","67.065670", "Great mexican, Italian cuisine served tapas style in a  space only slightly bigger than a hole in the wall. Good service and food. No walk-in customers accepted so make sure that you book your table in advance. 1.50hours per customer per table"));

            example_items.add(new example_item(R.drawable.beech,"The Royal rodale","Entertainment","Defence","24.791994","67.046843","With a view to provide light food, The Royal Rodale features informal eating outlet that offers a large variety of cafe delights."));

            example_items.add(new example_item(R.drawable.food,"Hardees","Food","Defence","24.794692","67.048431","Fast-food chain serving fried chicken & big burgers."));

            example_items.add(new example_item(R.drawable.food,"Auntie Munaver's Dessert And Savory","Food","Defence","24.787416","67.058473","Decadently Delicious Desserts and Savories for a dinner, party or just to indulge yourself at home, Auntie Munaver brings the most delectable experience, tantalizing your taste buds and reawakening a deep desire for the most exotic of tastes which will leave you hungry for more."));

            example_items.add(new example_item(R.drawable.food,"ChaiWala Chota Bukhari","Food","Defence","24.786452","67.057640","Chai Wala is your one-stop chai and chilling destination. We serve a range of traditional and artisanal beverages and snacks."));

            example_items.add(new example_item(R.drawable.food,"Bundoo Khan","Food","Defence","24.797965","67.045205","Bundu Khan has to be one of the best old fashioned restaurants still going strong. Mr Bundo Khan opened his restaurant before the partition of India and Pakistan."));

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

        }
        else if(Data.pos == 3 && Data.people.equals("1 person"))
        {

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

        }
        else if(Data.pos == 3 && Data.people.equals("3 or less"))
        {

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));


            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

        }
        else if(Data.pos == 3 && Data.people.equals("5 or less"))
        {

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

        }
        else
        {
            example_items.add(new example_item(R.drawable.shopping,"Zainab Market","Shopping","Saddar","24.855757","67.028472","Zainab Market, located in the heart of the city, is the ultimate shopping destination for many. It was set up in the mid ‘70s, and even with its modest outward appearance, it has garnered a reputation that few bazaars, if any, can match in the country."));

            example_items.add(new example_item(R.drawable.movie,"Atrium Mall","Entertainment","Saddar","24.856281","67.030279","Atrium Cinemas is a movie theater and first Digital 3D Multi-Screen Cinema Complex in Pakistan inside Atrium Mall Karachi. Cinema was opened on December 31, 2010."));

            example_items.add(new example_item(R.drawable.food,"Iceberg Ice Cream","Food","Saddar","24.857944","67.031117","Located at Dr Daud Pota Road Saddar, Karachi, Ice Berg, the House of Quality Ice Cream and Kulfi is one of the oldest ice-cream makers in town."));

            example_items.add(new example_item(R.drawable.shopping,"Gul Plaza","Shopping","Saddar","24.865042","67.023672","Crokery,Electronics, House Hold and Gift Items, Whole seller, Retailer under one roof in Karachi"));

            example_items.add(new example_item(R.drawable.movie,"Frere Hall","Entertainment","Saddar","24.847778","67.033031","Frere Hall is a building in Karachi, Pakistan that dates from the early British colonial-era in Sindh."));

            example_items.add(new example_item(R.drawable.food,"PAF Museum","Entertainment","PAF base Faisal","24.870867","67.096196","PAF Museum, Karachi is an Air Force museum and park situated near Karsaz Flyover on Shahrah-e-Faisal in Karachi, Sindh, Pakistan. A majority of the aircraft, weapons and radar are displayed outside in the park but the main museum features all major fighter aircraft that have been used by the Pakistan Air Force"));

            example_items.add(new example_item(R.drawable.food,"Pakistan Maritime Museum","Karsaz Faisal Cantonment","Saddar","24.886564","67.091829","Pakistan Maritime Museum is a naval museum and park situated near PNS Karsaz on Habib Ibrahim Rehmatullah Road in Karachi, Pakistan. The main museum building is located inside the park of 28 acres. It comprises six galleries and an auditorium"));

            example_items.add(new example_item(R.drawable.food,"National Museum of Pakistan","Entertainment","Saddar","24.852989","67.018469","This museum holds the most diverse range of art, from paintings to relics, sculptures and models that depict all the facets of Pakistani culture. This museum consists of 11 galleries that showcase artifacts from the Indus Valley Civilization up to modern times. It also boasts a large collection of coins and many rare manuscripts of the Quran"));

            example_items.add(new example_item(R.drawable.food,"Quaid-e-Azam House","Entertainment","Fatima Jinnah Rd","24.852396","67.033480","The Quaid-e-Azam House, also known as Flagstaff House, is a museum dedicated to the personal life of Muhammad Ali Jinnah, the founder of Pakistan. Located in Karachi, Sindh, Pakistan, it was designed by British architect Moses Somake. The former home of Jinnah, who lived there from 1944 until his death in 1948."));

            example_items.add(new example_item(R.drawable.food,"State Bank Museum & Art Gallery","Entertainment"," I.I Chundrigar Rd","24.849486","66.999168","State Bank of Pakistan Museum & Art Gallery is a museum which was established 2004 to introduce first Monetary Museum of Pakistan"));

        }
//
//
//


















        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new listAdapter(example_items,this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

//        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(final int position) {
//                Toast.makeText(LocationList.this, example_items.get(position).getText1(), Toast.LENGTH_SHORT).show();
//                new AlertDialog.Builder(LocationList.this)
//                        .setTitle("Location")
//                        .setMessage("Do you wish to add to list or View on Map")
//                        .setPositiveButton("View on Map", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                //Toast.makeText(LocationList.this, , Toast.LENGTH_SHORT).show();
//                                Data.latitude = example_items.get(position).getLatitude();
//                                Data.longituide = example_items.get(position).getLongitude();
//                                Intent i = new Intent(LocationList.this,ViewMap.class);
//                                startActivity(i);
//                            }
//                        })
//
//                        // A null listener allows the button to dismiss the dialog and take no further action.
//                        .setNegativeButton("Add to List", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(LocationList.this, "Added to List", Toast.LENGTH_SHORT).show();
//                                Data.mylist.add(example_items.get(position));
//                            }
//                        })
//                        ///.setIcon(android.R.drawable.ic_dialog_alert)
//                        .show();
//            }
//        });
    }
    public void openi(View view)
    {
        Intent i = new Intent(this,ImageSearch.class);
        startActivity(i);
    }
    public void openlist(View view)
    {
        Intent i = new Intent(this,MyList.class);
        startActivity(i);
    }
    public void openv(View view)
    {
        Intent i = new Intent(this,VoiceSearch.class);
        startActivity(i);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {

            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        //Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(this,pickLocation.class);
        startActivity(setIntent);
    }
}
