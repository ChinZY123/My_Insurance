package my.edu.tarc.myinsurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.myinsurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //inflate = load UI to memory
        binding = ActivityMainBinding.inflate(layoutInflater)
        // show the UI
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinner.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            var premium = 0
            if(age == 0){ //Less Than 17
                premium += 60
            } else if(age == 1) { //
                premium += 70
            } else if(age == 2) {
                premium += 90
            } else if(age == 3) {
                premium += 120
            } else if(age == 4) {
                premium += 150
            } else  {
                premium += 150
            }
            if(gender == binding.radioButtonMale.id){
                if(age == 1){ //Less Than 17
                    premium += 50
                } else if(age == 2) { //
                    premium += 100
                } else if(age == 3) {
                    premium += 150
                } else if(age == 4) {
                    premium += 200
                } else if(age == 5) {
                    premium += 200
                } else  {
                    premium += 0
                }
            }
            if(smoker){
                if(age == 1){ //Less Than 17
                    premium += 100
                } else if(age == 2) { //
                    premium += 150
                } else if(age == 3) {
                    premium += 200
                } else if(age == 4) {
                    premium += 250
                } else if(age == 5) {
                    premium += 300
                } else  {
                    premium += 0
                }
            }
            //Display output
            binding.textViewPremium.text = String.format(" Rm %s", premium)
        //binding.textViewPremium.text = premium.toString()
        }
        binding.buttonReset.setOnClickListener{
            binding.textViewPremium.text = getString(R.string.premium)
        }
    }
}