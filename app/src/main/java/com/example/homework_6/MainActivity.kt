package com.example.homework_6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)


        data class User(var name:String, var lastname: String, var email: String, var age: Int)

        var list = mutableListOf<Any>()

        var num1 = 0
        var num2 = 0

        var firstName = binding.firstName.text.toString()
        var lastName = binding.lastName.text.toString()
        var email = binding.email.text.toString()
        var age = binding.age.text.toString().toInt()

        binding.btnAddUser.setOnClickListener{
            var newUser = User(firstName, lastName, email, age)

            if (list.contains(newUser)){
                Toast.makeText(this, "User already exist", Toast.LENGTH_SHORT).show()}

            else if (firstName.isNotEmpty() && lastName.isNotEmpty()
                && email.isNotEmpty() && age > 0){
                list.add(newUser);
                Toast.makeText(this, "User already exist", Toast.LENGTH_SHORT).show();
                binding.success.setTextColor(Color.parseColor("#B60C0C"))}

            else{binding.error.setTextColor(Color.parseColor("#FFB60C0C"))}

            num1++

            binding.activeUsersNumber.text = num1.toString()

        }


        binding.btnRemoveUser.setOnClickListener{
            var newUser = User(firstName, lastName, email, age)
            if (list.contains(newUser)){list.remove(newUser);
                Toast.makeText(this, "User deleted successfully", Toast.LENGTH_SHORT).show();
                binding.success.setTextColor(Color.parseColor("#B60C0C"))}
            else {Toast.makeText(this, "User does not exits", Toast.LENGTH_SHORT).show();
                binding.error.setTextColor(Color.parseColor("#FFB60C0C"))}

            num2--

            binding.deletedUsersNumber.text = num1.toString()
            binding.success.setTextColor(Color.parseColor("#B60C0C"))

        }

        binding.btnUpdateUser.setOnClickListener {
            var newUser = User(firstName, lastName, email, age)
            if (list.contains(newUser))
            {list.remove(newUser);
                list.add(newUser);
                binding.success.setTextColor(Color.parseColor("#B60C0C"))
            }else{
                binding.error.setTextColor(Color.parseColor("#FFB60C0C"))
            }

        }
    }
}




