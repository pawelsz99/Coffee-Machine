package machine

import java.util.*

fun main() {
    val coffeeMachine = CoffeeMachine(400, 540, 120, 550, 9)
}


class CoffeeMachine(water: Int, milk: Int,
                    coffeeBeans: Int, money: Int,
                    disposableCups: Int) {

    private var currentWater = water
    private var currentMilk = milk
    private var currentCoffeeBeans = coffeeBeans
    private var currentMoney = money
    private var currentDisposableCups = disposableCups

    private val recipeEspresso = mapOf(
            "water" to 250,
            "milk" to 0,
            "coffeeBeans" to 16,
            "money" to 4)
    private val recipeLatte = mapOf(
            "water" to 350,
            "milk" to 75,
            "coffeeBeans" to 20,
            "money" to 7)
    private val recipeCappuccino = mapOf(
            "water" to 200,
            "milk" to 100,
            "coffeeBeans" to 12,
            "money" to 6)

    private val recipes = mapOf(
            "espresso" to recipeEspresso,
            "latte" to recipeLatte,
            "cappuccino" to recipeCappuccino)

    private val scanner = Scanner(System.`in`)

    init {
        println()
        menu()
    }

    private fun menu() {
        var action = ""
        while (action != "exit") {
            println()
            println("Write action (buy, fill, take, remaining, exit): ")
            action = scanner.next()
            println()
            when (action) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> remaining()
            }
        }
    }

    private fun remaining() {
        printState()
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (scanner.next()) { // it goes back to main menu when input something else than 1, 2 or 3
            "1" -> coffeeResourcesChecklist("espresso")
            "2" -> coffeeResourcesChecklist("latte")
            "3" -> coffeeResourcesChecklist("cappuccino")
        }
    }


    private fun coffeeResourcesChecklist(type: String) {
        // check water, milk, coffeeBeans, disposable cups, if all yes make coffee,
        // else print info and break
        if (currentWater >= recipes[type]?.get("water") ?: error("recipe")) {
            if (currentMilk >= recipes[type]?.get("milk") ?: error("recipe")) {
                if (currentCoffeeBeans >= recipes[type]?.get("coffeeBeans") ?: error("recipe")) {
                    if (currentDisposableCups >= 1) {
                        iHaveEnough()
                        makeCoffee(type)
                    } else sorryNotEnough("disposable cups")
                } else sorryNotEnough("coffee beans")
            } else sorryNotEnough("milk")
        } else sorryNotEnough("water")
    }

    private fun makeCoffee(type: String) {  // call only if you have before checked the resources
        currentWater -= recipes[type]?.get("water") ?: error("")
        currentMilk -= recipes[type]?.get("milk") ?: error("")
        currentCoffeeBeans -= recipes[type]?.get("coffeeBeans") ?: error("")
        currentDisposableCups -= 1
        currentMoney += recipes[type]?.get("money") ?: error("")

    }


    private fun fill() {
        println("Write how many ml of water do you want to add:")
        currentWater += scanner.nextInt()

        println("Write how many ml of milk do you want to add:")
        currentMilk += scanner.nextInt()

        println("Write how many grams of coffee beans do you want to add:")
        currentCoffeeBeans += scanner.nextInt()

        println("Write how many disposable cups of coffee do you want to add:")
        currentDisposableCups += scanner.nextInt()
    }

    private fun take() {
        println("I gave you $currentMoney")
        currentMoney = 0
    }

    private fun iHaveEnough() {
        println("I have enough resources, making you a coffee!")
    }


    private fun sorryNotEnough(resource: String) {
        println("Sorry, not enough $resource!")
    }   // what if more than one resource is missing?


    private fun printState() {
        println("The coffee machine has:")
        println("$currentWater of water")
        println("$currentMilk of milk")
        println("$currentCoffeeBeans of coffee beans")
        println("$currentDisposableCups of disposable cups")
        println("$currentMoney of money")
    }

    // on this stage this function is a bit overkill because it return
    // the maximum cups possible from the resources,
    // better is to write a function that checks only
    // if we have resources for one cup
//    private fun maxCupsOfCoffee(type: String): Int {
//        val cupsFormMilk = maxCupsFromResource(currentMilk, recipes[type]?.get("milk"))
//        val cupsFormWater = maxCupsFromResource(currentWater, recipes[type]?.get("water"))
//        val cupsFormCoffeeBeans = maxCupsFromResource(currentCoffeeBeans, recipes[type]?.get("coffeeBeans"))
//        val cupsFromDisposableCups = currentDisposableCups
//        return min(cupsFormCoffeeBeans, min(cupsFormMilk, min(cupsFormWater, cupsFromDisposableCups)))
//    }
//
//    private fun maxCupsFromResource(material: Int, materialNeeded: Int?) = material / materialNeeded!!

}



