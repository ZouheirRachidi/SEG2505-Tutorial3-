package com.example.firebasedemo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FirebaseTest";
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Database reference
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Call write and read functions
        writeTestValue();
        setupDatabaseListener();
    }

    /**
     * Writes a test value to the Firebase database
     */
    private void writeTestValue() {
        mDatabase.child("test").setValue("Hello Firebase!")
                .addOnSuccessListener(aVoid -> Log.d(TAG, "Value written successfully."))
                .addOnFailureListener(e -> Log.e(TAG, "Failed to write value.", e));
    }

    /**
     * Sets up a listener to read values from the Firebase database
     */
    private void setupDatabaseListener() {
        mDatabase.child("test").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Read and log the value
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Log database error
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }
}
