import java.util.*

enum class Country(val country: String, val currency: String) {
    Germany("Germany", "Euro"),
    Mali("Mali", "CFA franc"),
    Dominica("Dominica", "Eastern Caribbean dollar"),
    Canada("Canada", "Canadian dollar"),
    Spain("Spain", "Euro"),
    Australia("Australia", "Australian dollar"),
    Brazil("Brazil", "Brazilian real"),
    Senegal("Senegal", "CFA franc"),
    France("France", "Euro"),
    Grenada("Grenada", "Eastern Caribbean dollar"),
    Kiribati("Kiribati", "Australian dollar"),
    Null("", "")
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val country1 = try {
        Country.valueOf(input.next())
    } catch (e: IllegalArgumentException) {
        Country.Null
    }
    val country2 = try {
        Country.valueOf(input.next())
    } catch (e: IllegalArgumentException) {
        Country.Null
    }

    val currency1 = country1.currency
    val currency2 = country2.currency

    if (currency1 == currency2)
        print("true")
    else
        print("false")

}