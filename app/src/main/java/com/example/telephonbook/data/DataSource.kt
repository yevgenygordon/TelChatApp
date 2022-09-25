package com.example.telephonbook.data

import com.example.telephonbook.R
import com.example.telephonbook.data.model.Chat
import com.example.telephonbook.data.model.Person

class DataSource {

    fun loadPerson ():MutableList<Person>{
        val listOfPerson = mutableListOf<Person>(

            Person(R.drawable.image0,"Fredy Krüger","+2123 231 14660",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image1,"Doctor Strange","+787 66767 665",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image2,"Mister Nobody","+567 223 3424242",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image3,"Sherlock Holmes","+123 334 34424224",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image4,"Cinderella","+098 455 3535353",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image5,"Frodo Beutlin","+888 6564 45353",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image6,"DR. JULIUS","+432 3234 532523424",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image7,"LEELOO MINAI","+232100 3423423 2342",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image8,"ALPA CHINO","+12 2332 2424121",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image0,"Sgt. MAC McDONALD","+5645564 4646",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image1,"TINKY-WINKY","+985 54545 343433",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image2,"POPPY PUFF","+234 422232 2222",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image3,"BOBA FETT","+4353 345435 755",mutableListOf<Chat>(Chat())),
            Person(R.drawable.image4,"CHARLIE NASEWEIS","+676 5656 3 2222",mutableListOf<Chat>(Chat())),


            )

        return listOfPerson
    }
}