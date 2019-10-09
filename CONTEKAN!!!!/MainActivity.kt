package com.example.student.intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.recyclerView.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testData = createPhoneData()
        rv_parts.layoutManager = LinearLayoutManager(this)
        rv_parts.setHasFixedSize(true)
        rv_parts.adapter = ContactAdapter(testData, {phoneItem : Phonedata -> phoneItemClicked(phoneItem)})
    }
    private fun phoneItemClicked(phoneItem : PhoneData){
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData() : List<PhoneData> {
        val partList.add(PhoneData(9864934,"Alpha"))
        val partList.add(PhoneData(1341933,"Bravo"))
        val partList.add(PhoneData(1401624,"Charlie"))
        return partList

    }
}
