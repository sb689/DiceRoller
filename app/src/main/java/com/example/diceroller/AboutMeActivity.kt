package com.example.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.diceroller.databinding.ActivityAboutMeBinding


class AboutMeActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAboutMeBinding
    private val myName: MyName = MyName(name = "ABCDEFG")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAboutMeBinding.inflate(layoutInflater);
        setContentView(mBinding.root);
        mBinding.myName = myName
        mBinding.buttonDone.setOnClickListener {
            doneButtonClicked(it);
        }

    }


    private fun doneButtonClicked(view: View){

        mBinding.apply {

            myName?.nickName = etNickName.text.toString()
            invalidateAll()
            etNickName.visibility = View.GONE
            buttonDone.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}