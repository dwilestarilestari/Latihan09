package id.ac.tari.latihan09;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etFirstNumber;
    private EditText etSNumber;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("close confirmation")
                .setTitle("close app")
                .setIcon(android.R.drawable.star_big_on)
                .setCancelable(true)
                .setPositiveButton("YES", (dialog, which) -> super.onBackPressed())
                .setNegativeButton("NO", null)
            .show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        etFirstNumber.setText("");
        etSNumber.setText("");
        etFirstNumber.requestFocus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSNumber = findViewById(R.id.etSNumber);
        Button btCalculate = findViewById(R.id.btCalculate);

        btCalculate.setOnClickListener(v -> {
            int fno = Integer.parseInt(etFirstNumber.getText().toString());
            int sno = Integer.parseInt(etSNumber.getText().toString());
            Intent intent = new Intent(this, Calculate.class);
            intent.putExtra("fno", fno);
            intent.putExtra("sno", sno);
            startActivity(intent);


        });


    }
}
