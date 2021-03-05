# FindCard
An app for getting the details of a debit/credit card.
It helps identify the bank that issued the card to the card holder, the institution that made the card, and the type of card it is - Credit or Debit card.
The application allows the user to provide the number by entering the first 8 digits of a card number using the Soft Input keyboard. 
This application makes use of the [binlist API](https://binlist.net/).

* Tech-stack
    * [Kotlin](https://kotlinlang.org/)
    * [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Retrofit](https://square.github.io/retrofit/) - for network tasks
    * [Dagger Hilt](https://dagger.dev/hilt/) - for dependency injection
    * [Jetpack](https://developer.android.com/jetpack)
        * [View Binding](https://developer.android.com/topic/libraries/view-binding/) - allows for easy interactions between views in layouts and code classes.
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
        * [Room](https://developer.android.com/topic/libraries/architecture/room) persistence library which provides an abstraction layer over SQLite
    * Modern architecture (Clean Architecture and MVVM pattern)
    * Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)

### External dependencies
All the external dependencies (external libraries) are defined in the single place - Gradle `buildSrc` folder. This approach allows to easily manage dependencies and use the same dependency version across all modules.

## Installation
This project requires a minimum API level of 21. Clone the repository, build and run.

## LICENSE
```
MIT License

Copyright (c) 2021 Ikemefuna Nwodo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

