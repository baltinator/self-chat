package com.example.self_chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_VIEW_KEY = "message_view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText messageInput = findViewById(R.id.message_input);
        final TextView messageOutput = findViewById(R.id.message_output);
        Button sendButton = findViewById(R.id.send_button);

        if (savedInstanceState != null)
        {
            messageOutput.setText(savedInstanceState.getString(MESSAGE_VIEW_KEY));
        }

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable message = messageInput.getText();
                messageOutput.setText(message.toString());
                message.clear();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView messageOutput = findViewById(R.id.message_output);
        outState.putString(MESSAGE_VIEW_KEY, messageOutput.getText().toString());
    }
}
