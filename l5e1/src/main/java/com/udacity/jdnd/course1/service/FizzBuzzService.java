package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) {

        if(number < 1)
            throw new IllegalArgumentException("IllegalArgumentException number < 1");

        Boolean isDivisibleBy3 = isDivisibleByN(number, 3);
        Boolean isDivisibleBy5 = isDivisibleByN(number, 5);

        if( isDivisibleBy3 && isDivisibleBy5 ){
            return "FizzBuzz";
        }else if( isDivisibleBy3 ){
            return "Fizz";
        }else if( isDivisibleBy5 ){
            return "Buzz";
        }

        return String.valueOf(number);
    }

    Boolean isDivisibleByN(int number, int base){
        return number % base == 0;
    }
}
