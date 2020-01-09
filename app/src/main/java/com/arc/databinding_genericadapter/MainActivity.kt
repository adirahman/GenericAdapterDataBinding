package com.arc.databinding_genericadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val genericAdapter = GenericAdapter<Contact>(R.layout.item_contacts_list)

        genericAdapter.setOnListItemViewClickListener(object : GenericAdapter.OnListItemViewClickListener{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(view.context,"Click ar row $position",Toast.LENGTH_SHORT).show()
            }
        })

        val listContact = ArrayList<Contact>()
        listContact.add(Contact("ucok","1234"))
        listContact.add(Contact("ucok","1234"))
        listContact.add(Contact("ucok","1234"))

        rv.adapter = genericAdapter
        genericAdapter.addItems(listContact)
    }
}
