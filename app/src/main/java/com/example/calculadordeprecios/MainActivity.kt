
package com.example.calculadordeprecios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import com.example.calculadordeprecios.databinding.ActivityMainBinding
import android.widget.Spinner
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val municipios: Spinner = binding.municipio
        val valores = arrayOf("Apodaca", "Monterrey", "San Nicolás", "San Pedro", "Santa Catarina", "Escobedo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, valores)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        municipios.adapter = adapter

        binding.calcular.setOnClickListener { calcularPrecioFinal() }
    }

    private fun calcularPrecioFinal(){
        val pizzaIndSelected: CheckBox = binding.pizzaIndv
        val pizzaFamSelected: CheckBox = binding.pizzaFam
        val bonelessIndSelected: CheckBox = binding.bonelessIndv
        val bonelessCompSelected: CheckBox = binding.bonelessComp
        val burguerSenSelected: CheckBox = binding.burguerSen
        val burguerDoblSelected: CheckBox = binding.burguerDbl
        var acc = 0

        if(pizzaIndSelected.isChecked){
            acc += 75
        }
        if(pizzaFamSelected.isChecked){
            acc += 140
        }
        if(bonelessIndSelected.isChecked){
            acc += 110
        }
        if(bonelessCompSelected.isChecked){
            acc += 200
        }
        if(burguerSenSelected.isChecked){
            acc += 90
        }
        if(burguerDoblSelected.isChecked){
            acc += 150
        }



        val formatoPrecio = NumberFormat.getCurrencyInstance().format(acc)
        binding.total.text = getString(R.string.precio_final, formatoPrecio)


    }
}