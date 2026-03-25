package com.example.ejercicio_2

class Calculadora(
    val marca: String,
    val anosDeVida: Int
) {

    var precio: Double

    init {
        precio = 0.0
    }

    constructor(marca: String, anosDeVida: Int, precio: Double) : this(marca, anosDeVida) {
        this.precio = precio
    }

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double): Double {
        if (b == 0.0) {
            println("Error: no es posible dividir entre cero")
            return 0.0
        }
        return a / b
    }
}