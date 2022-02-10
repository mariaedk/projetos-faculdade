# Proteus Projects
## _About..._
* This repository contains university group projects made on the software [Proteus 8 professional](https://www.labcenter.com/).
* The code has some parts written in C, and some others are pure Assembly code. That is possible thanks to the Digital Mars C compiler.
* In order to write a line of code or even, a block of code in assembly inside a C function, we must use
    `_asm + code` (for a single line) or `_asm {block of code}` (for a block of code)
___
### The first project!
* The task of the first project was implementing a code on which you could open a terminal and type numbers only between 0 and 255, inclusive. It should not be able to let you type any another digit if the first two digits typed were above 26, and if they were 25, it should check if the third digit was between 0 and 5. Also, if the first 2 digits were numbers equals or lower than 24, it should let the user type any other number of his preference, as the third digit.
* To do so, first, we must allow the user to type the first 2 numbers freely, since 00 to 99 is between 255.
If he wants to type only two numbers or even one, he should be allowed. But, if there's a third digit, we must verify the other 2 digits. As explained above, we must limit it accordingly.
* The terminal will return to us the ascii code of the digit typed in. That way, we can compare all the digits through their ascii code, and make the proper conditions.
* Also, we have implemented a function which prints into the terminal one number at a time. Thats why we must divide our number given by the user by 100, so we could know the value of the hundred, then divide what's left of that number by 10, so we could know the value of the ten, and finally, the rest of it is the unit.

#### How do I test? Click on the anchor tag!
___
### The Second Project!
* The task of the second project was implementing a code on which using a graphical display we could set up an alarm clock. The button used as multiplication (x) on the keypad allows us to set up hours, minutes and seconds for an alarm. Once we press that button again, it will return to the normal timing, and once both the alarm clock and the normal clock hours are the exact same, it will make some (perhaps irritating :joy:) noise, which means it is "time to wake up".
* Some animations were added and made by the team who developed.

#### How do I test? Click on the anchor tag!
___

### And... The Final Project!!!
* Our task was to implement a version of the old "Genius" toy - Estrela - on Proteus, using Assembly language.
    * [IMAGE OF THE TOY](https://estrela.vteximg.com.br/arquivos/ids/163355-1000-1000/Jogo-Genius-Produto-Estrela.jpg?v=636661399595430000)
* The toy is very similar to a normal memory game; there are 4 different colors and 6 different sounds. One sound for each color and one sound for when you lose or win the game.
* The toy will generate a random 8 color sequence that you must remind. On the easy mode, if you forget a color and miss it, the game will restart but it will continue the sequence from where it stopped.
* On the difficult mode, it will keep generating random sequences of colors until you reach a full 8 color sequence.
* We have used the GLCD display and a keypad to have inputs from the user.
* To start the game, you must select (-) for an easy version of the game, and (+) for a difficult version of the game.
* The main function "RodarJogo()" has been implemented in C, since it is meant to only call other functions that have been implemented(mostly) in the Assembly language.

#### How do I test? Click on the anchor tag!

___

#### How do I test?
* First of all, you must have Proteus installed. This program was made on Proteus 8 professional. 

    * NOTE: You should also have a LICENSE in order to use Proteus.
* Once installed, you must download the compiler to execute the program. On the "System" tab, you should be able to download the compiler mentioned above.
* With that set, download our project and load it into your Proteus software.
* Hit run and... Enjoy!

___
