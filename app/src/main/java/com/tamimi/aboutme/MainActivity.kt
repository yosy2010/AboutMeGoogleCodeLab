package com.tamimi.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create an onClickListener on the done button to take the text from the edit text and display it in the text view and make the button invisible

        // get the nick name from the edit text
        val nickName = nick_namr_edit_text.text

        // update nickname with entered name
        done_btn.setOnClickListener { view ->
            // check if there was text entered
            if (nickName.isNotEmpty()) {

                // update the nick name
                updateNickName(nickName, view)
            } else {

                // if there was no text entered then show a toast
                Toast.makeText(this, "Please enter your nickname", Toast.LENGTH_SHORT).show()
            }
        }

        // if the user click on his nickname again we want to put the edit text and the done btn back again so he can edit his name
        nick_name_text_view.setOnClickListener {

            // show the btn and text edit and hide the nickname text view and request focus for text edit and show the keyboard
            makeEditable()

        }
    }

    private fun makeEditable() {
        nick_namr_edit_text.visibility = View.VISIBLE
        done_btn.visibility = View.VISIBLE
        nick_name_text_view.visibility = View.GONE

        // request focus for the edit text
        nick_namr_edit_text.requestFocus()
        showKeyboard()
    }

    private fun updateNickName(nickName: Editable?, view: View) {
        // if there is then show it in the nickname text edit
        nick_name_text_view.text = nickName

        // show the text field of the nickname
        nick_name_text_view.visibility = View.VISIBLE

        // make the button disappear
        done_btn.visibility = View.GONE

        // and make the text edit also disappear
        nick_namr_edit_text.visibility = View.GONE

        // and hide the keyboard
        hideKeyboard(view)
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun showKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nick_namr_edit_text, 0)
    }


}
